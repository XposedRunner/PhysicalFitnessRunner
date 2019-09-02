package okhttp3.internal.http;

import com.zjwh.android_wh_physicalfitness.utils.O00Oo00o.O00000o0;
import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.connection.StreamAllocation;
import okio.BufferedSink;
import okio.Okio;

public final class CallServerInterceptor implements Interceptor {
    private final boolean forWebSocket;

    public CallServerInterceptor(boolean z) {
        this.forWebSocket = z;
    }

    public Response intercept(Chain chain) throws IOException {
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        HttpStream httpStream = realInterceptorChain.httpStream();
        StreamAllocation streamAllocation = realInterceptorChain.streamAllocation();
        Request request = chain.request();
        long currentTimeMillis = System.currentTimeMillis();
        httpStream.writeRequestHeaders(request);
        if (HttpMethod.permitsRequestBody(request.method()) && request.body() != null) {
            BufferedSink buffer = Okio.buffer(httpStream.createRequestBody(request, request.body().contentLength()));
            request.body().writeTo(buffer);
            buffer.close();
        }
        httpStream.finishRequest();
        Response build = httpStream.readResponseHeaders().request(request).handshake(streamAllocation.connection().handshake()).sentRequestAtMillis(currentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
        if (!(this.forWebSocket && build.code() == 101)) {
            build = build.newBuilder().body(httpStream.openResponseBody(build)).build();
        }
        if (O00000o0.O00000o0.equalsIgnoreCase(build.request().header("Connection")) || O00000o0.O00000o0.equalsIgnoreCase(build.header("Connection"))) {
            streamAllocation.noNewStreams();
        }
        int code = build.code();
        if ((code != 204 && code != 205) || build.body().contentLength() <= 0) {
            return build;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("HTTP ");
        stringBuilder.append(code);
        stringBuilder.append(" had non-zero Content-Length: ");
        stringBuilder.append(build.body().contentLength());
        throw new ProtocolException(stringBuilder.toString());
    }
}
