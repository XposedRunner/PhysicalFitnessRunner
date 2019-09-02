package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import okhttp3.Address;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Route;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.framed.ErrorCode;
import okhttp3.internal.framed.StreamResetException;
import okhttp3.internal.http.Http1xStream;
import okhttp3.internal.http.Http2xStream;
import okhttp3.internal.http.HttpStream;

public final class StreamAllocation {
    public final Address address;
    private boolean canceled;
    private RealConnection connection;
    private final ConnectionPool connectionPool;
    private int refusedStreamCount;
    private boolean released;
    private Route route;
    private final RouteSelector routeSelector;
    private HttpStream stream;

    public StreamAllocation(ConnectionPool connectionPool, Address address) {
        this.connectionPool = connectionPool;
        this.address = address;
        this.routeSelector = new RouteSelector(address, routeDatabase());
    }

    private void deallocate(boolean z, boolean z2, boolean z3) {
        RealConnection realConnection;
        synchronized (this.connectionPool) {
            if (z3) {
                try {
                    this.stream = null;
                } catch (Throwable th) {
                    while (true) {
                    }
                }
            }
            if (z2) {
                this.released = true;
            }
            if (this.connection != null) {
                if (z) {
                    this.connection.noNewStreams = true;
                }
                if (this.stream == null && (this.released || this.connection.noNewStreams)) {
                    release(this.connection);
                    if (this.connection.allocations.isEmpty()) {
                        this.connection.idleAtNanos = System.nanoTime();
                        if (Internal.instance.connectionBecameIdle(this.connectionPool, this.connection)) {
                            realConnection = this.connection;
                            this.connection = null;
                        }
                    }
                    realConnection = null;
                    this.connection = null;
                }
            }
            realConnection = null;
        }
        if (realConnection != null) {
            Util.closeQuietly(realConnection.socket());
        }
    }

    /* JADX WARNING: Missing block: B:28:0x0044, code skipped:
            if (r1 != null) goto L_0x0059;
     */
    /* JADX WARNING: Missing block: B:29:0x0046, code skipped:
            r1 = r8.routeSelector.next();
            r0 = r8.connectionPool;
     */
    /* JADX WARNING: Missing block: B:30:0x004e, code skipped:
            monitor-enter(r0);
     */
    /* JADX WARNING: Missing block: B:32:?, code skipped:
            r8.route = r1;
            r8.refusedStreamCount = 0;
     */
    /* JADX WARNING: Missing block: B:33:0x0054, code skipped:
            monitor-exit(r0);
     */
    /* JADX WARNING: Missing block: B:38:0x0059, code skipped:
            r0 = new okhttp3.internal.connection.RealConnection(r1);
            acquire(r0);
            r1 = r8.connectionPool;
     */
    /* JADX WARNING: Missing block: B:39:0x0063, code skipped:
            monitor-enter(r1);
     */
    /* JADX WARNING: Missing block: B:41:?, code skipped:
            okhttp3.internal.Internal.instance.put(r8.connectionPool, r0);
            r8.connection = r0;
     */
    /* JADX WARNING: Missing block: B:42:0x006f, code skipped:
            if (r8.canceled == false) goto L_0x0079;
     */
    /* JADX WARNING: Missing block: B:44:0x0078, code skipped:
            throw new java.io.IOException("Canceled");
     */
    /* JADX WARNING: Missing block: B:45:0x0079, code skipped:
            monitor-exit(r1);
     */
    /* JADX WARNING: Missing block: B:46:0x007a, code skipped:
            r0.connect(r9, r10, r11, r8.address.connectionSpecs(), r12);
            routeDatabase().connected(r0.route());
     */
    /* JADX WARNING: Missing block: B:47:0x0093, code skipped:
            return r0;
     */
    private okhttp3.internal.connection.RealConnection findConnection(int r9, int r10, int r11, boolean r12) throws java.io.IOException {
        /*
        r8 = this;
        r0 = r8.connectionPool;
        monitor-enter(r0);
        r1 = r8.released;	 Catch:{ all -> 0x0097 }
        if (r1 == 0) goto L_0x000f;
    L_0x0007:
        r9 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x0097 }
        r10 = "released";
        r9.<init>(r10);	 Catch:{ all -> 0x0097 }
        throw r9;	 Catch:{ all -> 0x0097 }
    L_0x000f:
        r1 = r8.stream;	 Catch:{ all -> 0x0097 }
        if (r1 == 0) goto L_0x001b;
    L_0x0013:
        r9 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x0097 }
        r10 = "stream != null";
        r9.<init>(r10);	 Catch:{ all -> 0x0097 }
        throw r9;	 Catch:{ all -> 0x0097 }
    L_0x001b:
        r1 = r8.canceled;	 Catch:{ all -> 0x0097 }
        if (r1 == 0) goto L_0x0027;
    L_0x001f:
        r9 = new java.io.IOException;	 Catch:{ all -> 0x0097 }
        r10 = "Canceled";
        r9.<init>(r10);	 Catch:{ all -> 0x0097 }
        throw r9;	 Catch:{ all -> 0x0097 }
    L_0x0027:
        r1 = r8.connection;	 Catch:{ all -> 0x0097 }
        if (r1 == 0) goto L_0x0031;
    L_0x002b:
        r2 = r1.noNewStreams;	 Catch:{ all -> 0x0097 }
        if (r2 != 0) goto L_0x0031;
    L_0x002f:
        monitor-exit(r0);	 Catch:{ all -> 0x0097 }
        return r1;
    L_0x0031:
        r1 = okhttp3.internal.Internal.instance;	 Catch:{ all -> 0x0097 }
        r2 = r8.connectionPool;	 Catch:{ all -> 0x0097 }
        r3 = r8.address;	 Catch:{ all -> 0x0097 }
        r1 = r1.get(r2, r3, r8);	 Catch:{ all -> 0x0097 }
        if (r1 == 0) goto L_0x0041;
    L_0x003d:
        r8.connection = r1;	 Catch:{ all -> 0x0097 }
        monitor-exit(r0);	 Catch:{ all -> 0x0097 }
        return r1;
    L_0x0041:
        r1 = r8.route;	 Catch:{ all -> 0x0097 }
        monitor-exit(r0);	 Catch:{ all -> 0x0097 }
        if (r1 != 0) goto L_0x0059;
    L_0x0046:
        r0 = r8.routeSelector;
        r1 = r0.next();
        r0 = r8.connectionPool;
        monitor-enter(r0);
        r8.route = r1;	 Catch:{ all -> 0x0056 }
        r2 = 0;
        r8.refusedStreamCount = r2;	 Catch:{ all -> 0x0056 }
        monitor-exit(r0);	 Catch:{ all -> 0x0056 }
        goto L_0x0059;
    L_0x0056:
        r9 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0056 }
        throw r9;
    L_0x0059:
        r0 = new okhttp3.internal.connection.RealConnection;
        r0.<init>(r1);
        r8.acquire(r0);
        r1 = r8.connectionPool;
        monitor-enter(r1);
        r2 = okhttp3.internal.Internal.instance;	 Catch:{ all -> 0x0094 }
        r3 = r8.connectionPool;	 Catch:{ all -> 0x0094 }
        r2.put(r3, r0);	 Catch:{ all -> 0x0094 }
        r8.connection = r0;	 Catch:{ all -> 0x0094 }
        r2 = r8.canceled;	 Catch:{ all -> 0x0094 }
        if (r2 == 0) goto L_0x0079;
    L_0x0071:
        r9 = new java.io.IOException;	 Catch:{ all -> 0x0094 }
        r10 = "Canceled";
        r9.<init>(r10);	 Catch:{ all -> 0x0094 }
        throw r9;	 Catch:{ all -> 0x0094 }
    L_0x0079:
        monitor-exit(r1);	 Catch:{ all -> 0x0094 }
        r1 = r8.address;
        r6 = r1.connectionSpecs();
        r2 = r0;
        r3 = r9;
        r4 = r10;
        r5 = r11;
        r7 = r12;
        r2.connect(r3, r4, r5, r6, r7);
        r9 = r8.routeDatabase();
        r10 = r0.route();
        r9.connected(r10);
        return r0;
    L_0x0094:
        r9 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0094 }
        throw r9;
    L_0x0097:
        r9 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0097 }
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.StreamAllocation.findConnection(int, int, int, boolean):okhttp3.internal.connection.RealConnection");
    }

    /* JADX WARNING: Missing block: B:9:0x0012, code skipped:
            if (r0.isHealthy(r8) != false) goto L_0x0018;
     */
    /* JADX WARNING: Missing block: B:11:0x0018, code skipped:
            return r0;
     */
    private okhttp3.internal.connection.RealConnection findHealthyConnection(int r4, int r5, int r6, boolean r7, boolean r8) throws java.io.IOException {
        /*
        r3 = this;
    L_0x0000:
        r0 = r3.findConnection(r4, r5, r6, r7);
        r1 = r3.connectionPool;
        monitor-enter(r1);
        r2 = r0.successCount;	 Catch:{ all -> 0x0019 }
        if (r2 != 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r1);	 Catch:{ all -> 0x0019 }
        return r0;
    L_0x000d:
        monitor-exit(r1);	 Catch:{ all -> 0x0019 }
        r1 = r0.isHealthy(r8);
        if (r1 != 0) goto L_0x0018;
    L_0x0014:
        r3.noNewStreams();
        goto L_0x0000;
    L_0x0018:
        return r0;
    L_0x0019:
        r4 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0019 }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.StreamAllocation.findHealthyConnection(int, int, int, boolean, boolean):okhttp3.internal.connection.RealConnection");
    }

    private void release(RealConnection realConnection) {
        int size = realConnection.allocations.size();
        for (int i = 0; i < size; i++) {
            if (((Reference) realConnection.allocations.get(i)).get() == this) {
                realConnection.allocations.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    private RouteDatabase routeDatabase() {
        return Internal.instance.routeDatabase(this.connectionPool);
    }

    public void acquire(RealConnection realConnection) {
        realConnection.allocations.add(new WeakReference(this));
    }

    public void cancel() {
        HttpStream httpStream;
        RealConnection realConnection;
        synchronized (this.connectionPool) {
            this.canceled = true;
            httpStream = this.stream;
            realConnection = this.connection;
        }
        if (httpStream != null) {
            httpStream.cancel();
        } else if (realConnection != null) {
            realConnection.cancel();
        }
    }

    public synchronized RealConnection connection() {
        return this.connection;
    }

    public boolean hasMoreRoutes() {
        return this.route != null || this.routeSelector.hasNext();
    }

    public HttpStream newStream(OkHttpClient okHttpClient, boolean z) {
        int connectTimeoutMillis = okHttpClient.connectTimeoutMillis();
        int readTimeoutMillis = okHttpClient.readTimeoutMillis();
        int writeTimeoutMillis = okHttpClient.writeTimeoutMillis();
        try {
            HttpStream http2xStream;
            RealConnection findHealthyConnection = findHealthyConnection(connectTimeoutMillis, readTimeoutMillis, writeTimeoutMillis, okHttpClient.retryOnConnectionFailure(), z);
            if (findHealthyConnection.framedConnection != null) {
                http2xStream = new Http2xStream(okHttpClient, this, findHealthyConnection.framedConnection);
            } else {
                findHealthyConnection.socket().setSoTimeout(readTimeoutMillis);
                findHealthyConnection.source.timeout().timeout((long) readTimeoutMillis, TimeUnit.MILLISECONDS);
                findHealthyConnection.sink.timeout().timeout((long) writeTimeoutMillis, TimeUnit.MILLISECONDS);
                http2xStream = new Http1xStream(okHttpClient, this, findHealthyConnection.source, findHealthyConnection.sink);
            }
            synchronized (this.connectionPool) {
                this.stream = http2xStream;
            }
            return http2xStream;
        } catch (IOException e) {
            throw new RouteException(e);
        }
    }

    public void noNewStreams() {
        deallocate(true, false, false);
    }

    public void release() {
        deallocate(false, true, false);
    }

    public HttpStream stream() {
        HttpStream httpStream;
        synchronized (this.connectionPool) {
            httpStream = this.stream;
        }
        return httpStream;
    }

    public void streamFailed(IOException iOException) {
        boolean z;
        synchronized (this.connectionPool) {
            if (iOException instanceof StreamResetException) {
                StreamResetException streamResetException = (StreamResetException) iOException;
                if (streamResetException.errorCode == ErrorCode.REFUSED_STREAM) {
                    this.refusedStreamCount++;
                }
                if (streamResetException.errorCode != ErrorCode.REFUSED_STREAM || this.refusedStreamCount > 1) {
                    this.route = null;
                }
                z = false;
            } else {
                if (!(this.connection == null || this.connection.isMultiplexed())) {
                    if (this.connection.successCount == 0) {
                        if (!(this.route == null || iOException == null)) {
                            this.routeSelector.connectFailed(this.route, iOException);
                        }
                        this.route = null;
                    }
                }
                z = false;
            }
            z = true;
        }
        deallocate(z, false, true);
    }

    public void streamFinished(boolean z, HttpStream httpStream) {
        synchronized (this.connectionPool) {
            if (httpStream != null) {
                if (httpStream == this.stream) {
                    if (!z) {
                        RealConnection realConnection = this.connection;
                        realConnection.successCount++;
                    }
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("expected ");
            stringBuilder.append(this.stream);
            stringBuilder.append(" but was ");
            stringBuilder.append(httpStream);
            throw new IllegalStateException(stringBuilder.toString());
        }
        deallocate(z, false, true);
    }

    public String toString() {
        return this.address.toString();
    }
}
