package okhttp3.internal.connection;

import com.zjwh.android_wh_physicalfitness.utils.O00Oo00o.O00000o0;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Connection;
import okhttp3.ConnectionSpec;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.Version;
import okhttp3.internal.framed.ErrorCode;
import okhttp3.internal.framed.FramedConnection;
import okhttp3.internal.framed.FramedConnection.Listener;
import okhttp3.internal.framed.FramedStream;
import okhttp3.internal.http.Http1xStream;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.platform.Platform;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;

public final class RealConnection extends Listener implements Connection {
    public int allocationLimit;
    public final List<Reference<StreamAllocation>> allocations = new ArrayList();
    public volatile FramedConnection framedConnection;
    private Handshake handshake;
    public long idleAtNanos = Long.MAX_VALUE;
    public boolean noNewStreams;
    private Protocol protocol;
    private Socket rawSocket;
    private final Route route;
    public BufferedSink sink;
    public Socket socket;
    public BufferedSource source;
    public int successCount;

    public RealConnection(Route route) {
        this.route = route;
    }

    private void buildConnection(int i, int i2, int i3, ConnectionSpecSelector connectionSpecSelector) throws IOException {
        connectSocket(i, i2);
        establishProtocol(i2, i3, connectionSpecSelector);
    }

    private void buildTunneledConnection(int i, int i2, int i3, ConnectionSpecSelector connectionSpecSelector) throws IOException {
        Request createTunnelRequest = createTunnelRequest();
        HttpUrl url = createTunnelRequest.url();
        int i4 = 0;
        while (true) {
            i4++;
            if (i4 > 21) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Too many tunnel connections attempted: ");
                stringBuilder.append(21);
                throw new ProtocolException(stringBuilder.toString());
            }
            connectSocket(i, i2);
            createTunnelRequest = createTunnel(i2, i3, createTunnelRequest, url);
            if (createTunnelRequest == null) {
                establishProtocol(i2, i3, connectionSpecSelector);
                return;
            }
            Util.closeQuietly(this.rawSocket);
            this.rawSocket = null;
            this.sink = null;
            this.source = null;
        }
    }

    private void connectSocket(int i, int i2) throws IOException {
        Proxy proxy = this.route.proxy();
        Socket createSocket = (proxy.type() == Type.DIRECT || proxy.type() == Type.HTTP) ? this.route.address().socketFactory().createSocket() : new Socket(proxy);
        this.rawSocket = createSocket;
        this.rawSocket.setSoTimeout(i2);
        try {
            Platform.get().connectSocket(this.rawSocket, this.route.socketAddress(), i);
            this.source = Okio.buffer(Okio.source(this.rawSocket));
            this.sink = Okio.buffer(Okio.sink(this.rawSocket));
        } catch (ConnectException unused) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to connect to ");
            stringBuilder.append(this.route.socketAddress());
            throw new ConnectException(stringBuilder.toString());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x011b A:{Catch:{ all -> 0x010b }} */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0115 A:{Catch:{ all -> 0x010b }} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x011e  */
    private void connectTls(int r6, int r7, okhttp3.internal.connection.ConnectionSpecSelector r8) throws java.io.IOException {
        /*
        r5 = this;
        r6 = r5.route;
        r6 = r6.address();
        r7 = r6.sslSocketFactory();
        r0 = 0;
        r1 = r5.rawSocket;	 Catch:{ AssertionError -> 0x010e }
        r2 = r6.url();	 Catch:{ AssertionError -> 0x010e }
        r2 = r2.host();	 Catch:{ AssertionError -> 0x010e }
        r3 = r6.url();	 Catch:{ AssertionError -> 0x010e }
        r3 = r3.port();	 Catch:{ AssertionError -> 0x010e }
        r4 = 1;
        r7 = r7.createSocket(r1, r2, r3, r4);	 Catch:{ AssertionError -> 0x010e }
        r7 = (javax.net.ssl.SSLSocket) r7;	 Catch:{ AssertionError -> 0x010e }
        r8 = r8.configureSecureSocket(r7);	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r1 = r8.supportsTlsExtensions();	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        if (r1 == 0) goto L_0x0041;
    L_0x002e:
        r1 = okhttp3.internal.platform.Platform.get();	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r2 = r6.url();	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r2 = r2.host();	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r3 = r6.protocols();	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r1.configureTlsExtensions(r7, r2, r3);	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
    L_0x0041:
        r7.startHandshake();	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r1 = r7.getSession();	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r1 = okhttp3.Handshake.get(r1);	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r2 = r6.hostnameVerifier();	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r3 = r6.url();	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r3 = r3.host();	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r4 = r7.getSession();	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r2 = r2.verify(r3, r4);	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        if (r2 != 0) goto L_0x00b4;
    L_0x0062:
        r8 = r1.peerCertificates();	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r0 = 0;
        r8 = r8.get(r0);	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r8 = (java.security.cert.X509Certificate) r8;	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r0 = new javax.net.ssl.SSLPeerUnverifiedException;	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r1 = new java.lang.StringBuilder;	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r1.<init>();	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r2 = "Hostname ";
        r1.append(r2);	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r6 = r6.url();	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r6 = r6.host();	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r1.append(r6);	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r6 = " not verified:\n    certificate: ";
        r1.append(r6);	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r6 = okhttp3.CertificatePinner.pin(r8);	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r1.append(r6);	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r6 = "\n    DN: ";
        r1.append(r6);	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r6 = r8.getSubjectDN();	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r6 = r6.getName();	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r1.append(r6);	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r6 = "\n    subjectAltNames: ";
        r1.append(r6);	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r6 = okhttp3.internal.tls.OkHostnameVerifier.allSubjectAltNames(r8);	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r1.append(r6);	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r6 = r1.toString();	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r0.<init>(r6);	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        throw r0;	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
    L_0x00b4:
        r2 = r6.certificatePinner();	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r6 = r6.url();	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r6 = r6.host();	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r3 = r1.peerCertificates();	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r2.check(r6, r3);	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r6 = r8.supportsTlsExtensions();	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        if (r6 == 0) goto L_0x00d5;
    L_0x00cd:
        r6 = okhttp3.internal.platform.Platform.get();	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r0 = r6.getSelectedProtocol(r7);	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
    L_0x00d5:
        r5.socket = r7;	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r6 = r5.socket;	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r6 = okio.Okio.source(r6);	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r6 = okio.Okio.buffer(r6);	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r5.source = r6;	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r6 = r5.socket;	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r6 = okio.Okio.sink(r6);	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r6 = okio.Okio.buffer(r6);	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r5.sink = r6;	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        r5.handshake = r1;	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        if (r0 == 0) goto L_0x00f8;
    L_0x00f3:
        r6 = okhttp3.Protocol.get(r0);	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        goto L_0x00fa;
    L_0x00f8:
        r6 = okhttp3.Protocol.HTTP_1_1;	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
    L_0x00fa:
        r5.protocol = r6;	 Catch:{ AssertionError -> 0x0108, all -> 0x0106 }
        if (r7 == 0) goto L_0x0105;
    L_0x00fe:
        r6 = okhttp3.internal.platform.Platform.get();
        r6.afterHandshake(r7);
    L_0x0105:
        return;
    L_0x0106:
        r6 = move-exception;
        goto L_0x011c;
    L_0x0108:
        r6 = move-exception;
        r0 = r7;
        goto L_0x010f;
    L_0x010b:
        r6 = move-exception;
        r7 = r0;
        goto L_0x011c;
    L_0x010e:
        r6 = move-exception;
    L_0x010f:
        r7 = okhttp3.internal.Util.isAndroidGetsocknameError(r6);	 Catch:{ all -> 0x010b }
        if (r7 == 0) goto L_0x011b;
    L_0x0115:
        r7 = new java.io.IOException;	 Catch:{ all -> 0x010b }
        r7.<init>(r6);	 Catch:{ all -> 0x010b }
        throw r7;	 Catch:{ all -> 0x010b }
    L_0x011b:
        throw r6;	 Catch:{ all -> 0x010b }
    L_0x011c:
        if (r7 == 0) goto L_0x0125;
    L_0x011e:
        r8 = okhttp3.internal.platform.Platform.get();
        r8.afterHandshake(r7);
    L_0x0125:
        okhttp3.internal.Util.closeQuietly(r7);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealConnection.connectTls(int, int, okhttp3.internal.connection.ConnectionSpecSelector):void");
    }

    private Request createTunnel(int i, int i2, Request request, HttpUrl httpUrl) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CONNECT ");
        stringBuilder.append(Util.hostHeader(httpUrl, true));
        stringBuilder.append(" HTTP/1.1");
        String stringBuilder2 = stringBuilder.toString();
        while (true) {
            Http1xStream http1xStream = new Http1xStream(null, null, this.source, this.sink);
            this.source.timeout().timeout((long) i, TimeUnit.MILLISECONDS);
            this.sink.timeout().timeout((long) i2, TimeUnit.MILLISECONDS);
            http1xStream.writeRequest(request.headers(), stringBuilder2);
            http1xStream.finishRequest();
            Response build = http1xStream.readResponse().request(request).build();
            long contentLength = HttpHeaders.contentLength(build);
            if (contentLength == -1) {
                contentLength = 0;
            }
            Source newFixedLengthSource = http1xStream.newFixedLengthSource(contentLength);
            Util.skipAll(newFixedLengthSource, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            newFixedLengthSource.close();
            int code = build.code();
            if (code != 200) {
                if (code != 407) {
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("Unexpected response code for CONNECT: ");
                    stringBuilder3.append(build.code());
                    throw new IOException(stringBuilder3.toString());
                }
                Request authenticate = this.route.address().proxyAuthenticator().authenticate(this.route, build);
                if (authenticate == null) {
                    throw new IOException("Failed to authenticate with proxy");
                } else if (O00000o0.O00000o0.equalsIgnoreCase(build.header("Connection"))) {
                    return authenticate;
                } else {
                    request = authenticate;
                }
            } else if (this.source.buffer().exhausted() && this.sink.buffer().exhausted()) {
                return null;
            } else {
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
        }
    }

    private Request createTunnelRequest() {
        return new Builder().url(this.route.address().url()).header("Host", Util.hostHeader(this.route.address().url(), true)).header("Proxy-Connection", "Keep-Alive").header("User-Agent", Version.userAgent()).build();
    }

    private void establishProtocol(int i, int i2, ConnectionSpecSelector connectionSpecSelector) throws IOException {
        if (this.route.address().sslSocketFactory() != null) {
            connectTls(i, i2, connectionSpecSelector);
        } else {
            this.protocol = Protocol.HTTP_1_1;
            this.socket = this.rawSocket;
        }
        if (this.protocol == Protocol.SPDY_3 || this.protocol == Protocol.HTTP_2) {
            this.socket.setSoTimeout(0);
            FramedConnection build = new FramedConnection.Builder(true).socket(this.socket, this.route.address().url().host(), this.source, this.sink).protocol(this.protocol).listener(this).build();
            build.start();
            this.allocationLimit = build.maxConcurrentStreams();
            this.framedConnection = build;
            return;
        }
        this.allocationLimit = 1;
    }

    public void cancel() {
        Util.closeQuietly(this.rawSocket);
    }

    public void connect(int i, int i2, int i3, List<ConnectionSpec> list, boolean z) {
        if (this.protocol != null) {
            throw new IllegalStateException("already connected");
        }
        ConnectionSpecSelector connectionSpecSelector = new ConnectionSpecSelector(list);
        if (this.route.address().sslSocketFactory() == null) {
            if (list.contains(ConnectionSpec.CLEARTEXT)) {
                String host = this.route.address().url().host();
                if (!Platform.get().isCleartextTrafficPermitted(host)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("CLEARTEXT communication to ");
                    stringBuilder.append(host);
                    stringBuilder.append(" not permitted by network security policy");
                    throw new RouteException(new UnknownServiceException(stringBuilder.toString()));
                }
            }
            throw new RouteException(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
        }
        RouteException routeException = null;
        while (this.protocol == null) {
            try {
                if (this.route.requiresTunnel()) {
                    buildTunneledConnection(i, i2, i3, connectionSpecSelector);
                } else {
                    buildConnection(i, i2, i3, connectionSpecSelector);
                }
            } catch (IOException e) {
                Util.closeQuietly(this.socket);
                Util.closeQuietly(this.rawSocket);
                this.socket = null;
                this.rawSocket = null;
                this.source = null;
                this.sink = null;
                this.handshake = null;
                this.protocol = null;
                if (routeException == null) {
                    routeException = new RouteException(e);
                } else {
                    routeException.addConnectException(e);
                }
                if (!z || !connectionSpecSelector.connectionFailed(e)) {
                    throw routeException;
                }
            }
        }
    }

    public Handshake handshake() {
        return this.handshake;
    }

    public boolean isHealthy(boolean z) {
        if (this.socket.isClosed() || this.socket.isInputShutdown() || this.socket.isOutputShutdown()) {
            return false;
        }
        if (this.framedConnection == null && z) {
            int soTimeout;
            try {
                soTimeout = this.socket.getSoTimeout();
                this.socket.setSoTimeout(1);
                if (this.source.exhausted()) {
                    this.socket.setSoTimeout(soTimeout);
                    return false;
                }
                this.socket.setSoTimeout(soTimeout);
                return true;
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            } catch (Throwable th) {
                this.socket.setSoTimeout(soTimeout);
            }
        }
        return true;
    }

    public boolean isMultiplexed() {
        return this.framedConnection != null;
    }

    public void onSettings(FramedConnection framedConnection) {
        this.allocationLimit = framedConnection.maxConcurrentStreams();
    }

    public void onStream(FramedStream framedStream) throws IOException {
        framedStream.close(ErrorCode.REFUSED_STREAM);
    }

    public Protocol protocol() {
        if (this.framedConnection != null) {
            return this.framedConnection.getProtocol();
        }
        return this.protocol != null ? this.protocol : Protocol.HTTP_1_1;
    }

    public Route route() {
        return this.route;
    }

    public Socket socket() {
        return this.socket;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Connection{");
        stringBuilder.append(this.route.address().url().host());
        stringBuilder.append(":");
        stringBuilder.append(this.route.address().url().port());
        stringBuilder.append(", proxy=");
        stringBuilder.append(this.route.proxy());
        stringBuilder.append(" hostAddress=");
        stringBuilder.append(this.route.socketAddress());
        stringBuilder.append(" cipherSuite=");
        stringBuilder.append(this.handshake != null ? this.handshake.cipherSuite() : "none");
        stringBuilder.append(" protocol=");
        stringBuilder.append(this.protocol);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
