package okhttp3;

import java.io.IOException;
import java.util.ArrayList;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.connection.ConnectInterceptor;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.BridgeInterceptor;
import okhttp3.internal.http.CallServerInterceptor;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;

final class RealCall implements Call {
    private final OkHttpClient client;
    private boolean executed;
    Request originalRequest;
    private final RetryAndFollowUpInterceptor retryAndFollowUpInterceptor;

    final class AsyncCall extends NamedRunnable {
        private final Callback responseCallback;

        private AsyncCall(Callback callback) {
            super("OkHttp %s", r4.redactedUrl().toString());
            this.responseCallback = callback;
        }

        /* Access modifiers changed, original: protected */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0055 A:{Catch:{ all -> 0x002d }} */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x0035 A:{SYNTHETIC, Splitter:B:13:0x0035} */
        public void execute() {
            /*
            r6 = this;
            r0 = 1;
            r1 = 0;
            r2 = okhttp3.RealCall.this;	 Catch:{ IOException -> 0x002f }
            r2 = r2.getResponseWithInterceptorChain();	 Catch:{ IOException -> 0x002f }
            r3 = okhttp3.RealCall.this;	 Catch:{ IOException -> 0x002f }
            r3 = r3.retryAndFollowUpInterceptor;	 Catch:{ IOException -> 0x002f }
            r3 = r3.isCanceled();	 Catch:{ IOException -> 0x002f }
            if (r3 == 0) goto L_0x0025;
        L_0x0014:
            r1 = r6.responseCallback;	 Catch:{ IOException -> 0x0023 }
            r2 = okhttp3.RealCall.this;	 Catch:{ IOException -> 0x0023 }
            r3 = new java.io.IOException;	 Catch:{ IOException -> 0x0023 }
            r4 = "Canceled";
            r3.<init>(r4);	 Catch:{ IOException -> 0x0023 }
            r1.onFailure(r2, r3);	 Catch:{ IOException -> 0x0023 }
            goto L_0x005c;
        L_0x0023:
            r1 = move-exception;
            goto L_0x0033;
        L_0x0025:
            r1 = r6.responseCallback;	 Catch:{ IOException -> 0x0023 }
            r3 = okhttp3.RealCall.this;	 Catch:{ IOException -> 0x0023 }
            r1.onResponse(r3, r2);	 Catch:{ IOException -> 0x0023 }
            goto L_0x005c;
        L_0x002d:
            r0 = move-exception;
            goto L_0x006a;
        L_0x002f:
            r0 = move-exception;
            r5 = r1;
            r1 = r0;
            r0 = r5;
        L_0x0033:
            if (r0 == 0) goto L_0x0055;
        L_0x0035:
            r0 = okhttp3.internal.platform.Platform.get();	 Catch:{ all -> 0x002d }
            r2 = 4;
            r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x002d }
            r3.<init>();	 Catch:{ all -> 0x002d }
            r4 = "Callback failure for ";
            r3.append(r4);	 Catch:{ all -> 0x002d }
            r4 = okhttp3.RealCall.this;	 Catch:{ all -> 0x002d }
            r4 = r4.toLoggableString();	 Catch:{ all -> 0x002d }
            r3.append(r4);	 Catch:{ all -> 0x002d }
            r3 = r3.toString();	 Catch:{ all -> 0x002d }
            r0.log(r2, r3, r1);	 Catch:{ all -> 0x002d }
            goto L_0x005c;
        L_0x0055:
            r0 = r6.responseCallback;	 Catch:{ all -> 0x002d }
            r2 = okhttp3.RealCall.this;	 Catch:{ all -> 0x002d }
            r0.onFailure(r2, r1);	 Catch:{ all -> 0x002d }
        L_0x005c:
            r0 = okhttp3.RealCall.this;
            r0 = r0.client;
            r0 = r0.dispatcher();
            r0.finished(r6);
            return;
        L_0x006a:
            r1 = okhttp3.RealCall.this;
            r1 = r1.client;
            r1 = r1.dispatcher();
            r1.finished(r6);
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.RealCall$AsyncCall.execute():void");
        }

        /* Access modifiers changed, original: 0000 */
        public RealCall get() {
            return RealCall.this;
        }

        /* Access modifiers changed, original: 0000 */
        public String host() {
            return RealCall.this.originalRequest.url().host();
        }

        /* Access modifiers changed, original: 0000 */
        public Request request() {
            return RealCall.this.originalRequest;
        }
    }

    protected RealCall(OkHttpClient okHttpClient, Request request) {
        this.client = okHttpClient;
        this.originalRequest = request;
        this.retryAndFollowUpInterceptor = new RetryAndFollowUpInterceptor(okHttpClient);
    }

    private Response getResponseWithInterceptorChain() throws IOException {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.client.interceptors());
        arrayList.add(this.retryAndFollowUpInterceptor);
        arrayList.add(new BridgeInterceptor(this.client.cookieJar()));
        arrayList.add(new CacheInterceptor(this.client.internalCache()));
        arrayList.add(new ConnectInterceptor(this.client));
        if (!this.retryAndFollowUpInterceptor.isForWebSocket()) {
            arrayList.addAll(this.client.networkInterceptors());
        }
        arrayList.add(new CallServerInterceptor(this.retryAndFollowUpInterceptor.isForWebSocket()));
        return new RealInterceptorChain(arrayList, null, null, null, 0, this.originalRequest).proceed(this.originalRequest);
    }

    private String toLoggableString() {
        String str = this.retryAndFollowUpInterceptor.isCanceled() ? "canceled call" : "call";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(" to ");
        stringBuilder.append(redactedUrl());
        return stringBuilder.toString();
    }

    public void cancel() {
        this.retryAndFollowUpInterceptor.cancel();
    }

    public void enqueue(Callback callback) {
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already Executed");
            }
            this.executed = true;
        }
        this.client.dispatcher().enqueue(new AsyncCall(callback));
    }

    public Response execute() throws IOException {
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already Executed");
            }
            this.executed = true;
        }
        try {
            this.client.dispatcher().executed(this);
            Response responseWithInterceptorChain = getResponseWithInterceptorChain();
            if (responseWithInterceptorChain != null) {
                return responseWithInterceptorChain;
            }
            throw new IOException("Canceled");
        } finally {
            this.client.dispatcher().finished(this);
        }
    }

    public boolean isCanceled() {
        return this.retryAndFollowUpInterceptor.isCanceled();
    }

    public synchronized boolean isExecuted() {
        return this.executed;
    }

    /* Access modifiers changed, original: 0000 */
    public HttpUrl redactedUrl() {
        return this.originalRequest.url().resolve("/...");
    }

    public Request request() {
        return this.originalRequest;
    }

    /* Access modifiers changed, original: declared_synchronized */
    public synchronized void setForWebSocket() {
        if (this.executed) {
            throw new IllegalStateException("Already Executed");
        }
        this.retryAndFollowUpInterceptor.setForWebSocket(true);
    }

    /* Access modifiers changed, original: 0000 */
    public StreamAllocation streamAllocation() {
        return this.retryAndFollowUpInterceptor.streamAllocation();
    }
}
