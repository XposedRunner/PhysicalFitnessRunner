package okhttp3.internal.http;

import com.ximalaya.ting.android.xmpayordersdk.O000000o;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.net.Proxy.Type;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Address;
import okhttp3.CertificatePinner;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.connection.StreamAllocation;

public final class RetryAndFollowUpInterceptor implements Interceptor {
    private static final int MAX_FOLLOW_UPS = 20;
    private volatile boolean canceled;
    private final OkHttpClient client;
    private boolean forWebSocket;
    private StreamAllocation streamAllocation;

    public RetryAndFollowUpInterceptor(OkHttpClient okHttpClient) {
        this.client = okHttpClient;
    }

    private Address createAddress(HttpUrl httpUrl) {
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory;
        CertificatePinner certificatePinner;
        if (httpUrl.isHttps()) {
            SSLSocketFactory sslSocketFactory = this.client.sslSocketFactory();
            hostnameVerifier = this.client.hostnameVerifier();
            sSLSocketFactory = sslSocketFactory;
            certificatePinner = this.client.certificatePinner();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = sSLSocketFactory;
            certificatePinner = hostnameVerifier;
        }
        return new Address(httpUrl.host(), httpUrl.port(), this.client.dns(), this.client.socketFactory(), sSLSocketFactory, hostnameVerifier, certificatePinner, this.client.proxyAuthenticator(), this.client.proxy(), this.client.protocols(), this.client.connectionSpecs(), this.client.proxySelector());
    }

    private Request followUpRequest(Response response) throws IOException {
        if (response == null) {
            throw new IllegalStateException();
        }
        RealConnection connection = this.streamAllocation.connection();
        Route route = connection != null ? connection.route() : null;
        int code = response.code();
        String method = response.request().method();
        switch (code) {
            case 300:
            case 301:
            case 302:
            case 303:
                break;
            case StatusLine.HTTP_TEMP_REDIRECT /*307*/:
            case StatusLine.HTTP_PERM_REDIRECT /*308*/:
                if (!(method.equals("GET") || method.equals("HEAD"))) {
                    return null;
                }
            case O000000o.O0000ooO /*401*/:
                return this.client.authenticator().authenticate(route, response);
            case 407:
                if ((route != null ? route.proxy() : this.client.proxy()).type() == Type.HTTP) {
                    return this.client.proxyAuthenticator().authenticate(route, response);
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            case 408:
                return response.request().body() instanceof UnrepeatableRequestBody ? null : response.request();
            default:
                return null;
        }
        if (!this.client.followRedirects()) {
            return null;
        }
        String header = response.header("Location");
        if (header == null) {
            return null;
        }
        HttpUrl resolve = response.request().url().resolve(header);
        if (resolve == null) {
            return null;
        }
        if (!resolve.scheme().equals(response.request().url().scheme()) && !this.client.followSslRedirects()) {
            return null;
        }
        Builder newBuilder = response.request().newBuilder();
        if (HttpMethod.permitsRequestBody(method)) {
            if (HttpMethod.redirectsToGet(method)) {
                newBuilder.method("GET", null);
            } else {
                newBuilder.method(method, null);
            }
            newBuilder.removeHeader("Transfer-Encoding");
            newBuilder.removeHeader("Content-Length");
            newBuilder.removeHeader("Content-Type");
        }
        if (!sameConnection(response, resolve)) {
            newBuilder.removeHeader("Authorization");
        }
        return newBuilder.url(resolve).build();
    }

    private boolean isRecoverable(IOException iOException, boolean z) {
        boolean z2 = false;
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (!(iOException instanceof InterruptedIOException)) {
            return (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
        } else {
            if ((iOException instanceof SocketTimeoutException) && z) {
                z2 = true;
            }
            return z2;
        }
    }

    private boolean recover(IOException iOException, boolean z, Request request) {
        this.streamAllocation.streamFailed(iOException);
        return !this.client.retryOnConnectionFailure() ? false : (z || !(request.body() instanceof UnrepeatableRequestBody)) && isRecoverable(iOException, z) && this.streamAllocation.hasMoreRoutes();
    }

    private boolean sameConnection(Response response, HttpUrl httpUrl) {
        HttpUrl url = response.request().url();
        return url.host().equals(httpUrl.host()) && url.port() == httpUrl.port() && url.scheme().equals(httpUrl.scheme());
    }

    public void cancel() {
        this.canceled = true;
        StreamAllocation streamAllocation = this.streamAllocation;
        if (streamAllocation != null) {
            streamAllocation.cancel();
        }
    }

    public OkHttpClient client() {
        return this.client;
    }

    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        this.streamAllocation = new StreamAllocation(this.client.connectionPool(), createAddress(request.url()));
        int i = 0;
        Response response = null;
        while (!this.canceled) {
            try {
                Response proceed = ((RealInterceptorChain) chain).proceed(request, this.streamAllocation, null, null);
                response = response != null ? proceed.newBuilder().priorResponse(response.newBuilder().body(null).build()).build() : proceed;
                request = followUpRequest(response);
                if (request == null) {
                    if (!this.forWebSocket) {
                        this.streamAllocation.release();
                    }
                    return response;
                }
                Util.closeQuietly(response.body());
                i++;
                StringBuilder stringBuilder;
                if (i > 20) {
                    this.streamAllocation.release();
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Too many follow-up requests: ");
                    stringBuilder.append(i);
                    throw new ProtocolException(stringBuilder.toString());
                } else if (request.body() instanceof UnrepeatableRequestBody) {
                    throw new HttpRetryException("Cannot retry streamed HTTP body", response.code());
                } else if (!sameConnection(response, request.url())) {
                    this.streamAllocation.release();
                    this.streamAllocation = new StreamAllocation(this.client.connectionPool(), createAddress(request.url()));
                } else if (this.streamAllocation.stream() != null) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Closing the body of ");
                    stringBuilder.append(response);
                    stringBuilder.append(" didn't close its backing stream. Bad interceptor?");
                    throw new IllegalStateException(stringBuilder.toString());
                }
            } catch (RouteException e) {
                if (!recover(e.getLastConnectException(), true, request)) {
                    throw e.getLastConnectException();
                }
            } catch (IOException e2) {
                if (!recover(e2, false, request)) {
                    throw e2;
                }
            } catch (Throwable th) {
                this.streamAllocation.streamFailed(null);
                this.streamAllocation.release();
            }
        }
        this.streamAllocation.release();
        throw new IOException("Canceled");
    }

    public boolean isCanceled() {
        return this.canceled;
    }

    public boolean isForWebSocket() {
        return this.forWebSocket;
    }

    public void setForWebSocket(boolean z) {
        this.forWebSocket = z;
    }

    public StreamAllocation streamAllocation() {
        return this.streamAllocation;
    }
}
