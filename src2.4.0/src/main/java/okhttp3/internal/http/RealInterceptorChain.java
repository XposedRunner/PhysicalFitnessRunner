package okhttp3.internal.http;

import java.io.IOException;
import java.util.List;
import okhttp3.Connection;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.connection.StreamAllocation;

public final class RealInterceptorChain implements Chain {
    private int calls;
    private final Connection connection;
    private final HttpStream httpStream;
    private final int index;
    private final List<Interceptor> interceptors;
    private final Request request;
    private final StreamAllocation streamAllocation;

    public RealInterceptorChain(List<Interceptor> list, StreamAllocation streamAllocation, HttpStream httpStream, Connection connection, int i, Request request) {
        this.interceptors = list;
        this.connection = connection;
        this.streamAllocation = streamAllocation;
        this.httpStream = httpStream;
        this.index = i;
        this.request = request;
    }

    private boolean sameConnection(HttpUrl httpUrl) {
        return httpUrl.host().equals(this.connection.route().address().url().host()) && httpUrl.port() == this.connection.route().address().url().port();
    }

    public Connection connection() {
        return this.connection;
    }

    public HttpStream httpStream() {
        return this.httpStream;
    }

    public Response proceed(Request request) throws IOException {
        return proceed(request, this.streamAllocation, this.httpStream, this.connection);
    }

    public Response proceed(Request request, StreamAllocation streamAllocation, HttpStream httpStream, Connection connection) throws IOException {
        if (this.index >= this.interceptors.size()) {
            throw new AssertionError();
        }
        this.calls++;
        StringBuilder stringBuilder;
        if (this.httpStream != null && !sameConnection(request.url())) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("network interceptor ");
            stringBuilder.append(this.interceptors.get(this.index - 1));
            stringBuilder.append(" must retain the same host and port");
            throw new IllegalStateException(stringBuilder.toString());
        } else if (this.httpStream == null || this.calls <= 1) {
            RealInterceptorChain realInterceptorChain = new RealInterceptorChain(this.interceptors, streamAllocation, httpStream, connection, this.index + 1, request);
            Interceptor interceptor = (Interceptor) this.interceptors.get(this.index);
            Response intercept = interceptor.intercept(realInterceptorChain);
            StringBuilder stringBuilder2;
            if (httpStream != null && this.index + 1 < this.interceptors.size() && realInterceptorChain.calls != 1) {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append("network interceptor ");
                stringBuilder2.append(interceptor);
                stringBuilder2.append(" must call proceed() exactly once");
                throw new IllegalStateException(stringBuilder2.toString());
            } else if (intercept != null) {
                return intercept;
            } else {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append("interceptor ");
                stringBuilder2.append(interceptor);
                stringBuilder2.append(" returned null");
                throw new NullPointerException(stringBuilder2.toString());
            }
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("network interceptor ");
            stringBuilder.append(this.interceptors.get(this.index - 1));
            stringBuilder.append(" must call proceed() exactly once");
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    public Request request() {
        return this.request;
    }

    public StreamAllocation streamAllocation() {
        return this.streamAllocation;
    }
}
