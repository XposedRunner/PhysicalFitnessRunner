package org.xutils.http;

import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import org.xutils.common.Callback.CacheCallback;
import org.xutils.common.Callback.Cancelable;
import org.xutils.common.Callback.CancelledException;
import org.xutils.common.Callback.CommonCallback;
import org.xutils.common.Callback.PrepareCallback;
import org.xutils.common.Callback.ProgressCallback;
import org.xutils.common.Callback.TypedCallback;
import org.xutils.common.task.AbsTask;
import org.xutils.common.task.Priority;
import org.xutils.common.task.PriorityExecutor;
import org.xutils.common.util.IOUtil;
import org.xutils.common.util.ParameterizedTypeUtil;
import org.xutils.http.app.RequestInterceptListener;
import org.xutils.http.app.RequestTracker;
import org.xutils.http.request.UriRequest;
import org.xutils.http.request.UriRequestFactory;
import org.xutils.x;

public class HttpTask<ResultType> extends AbsTask<ResultType> implements ProgressHandler {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final PriorityExecutor CACHE_EXECUTOR = new PriorityExecutor(5, true);
    private static final HashMap<String, WeakReference<HttpTask<?>>> DOWNLOAD_TASK = new HashMap(1);
    private static final int FLAG_CACHE = 2;
    private static final int FLAG_PROGRESS = 3;
    private static final int FLAG_REQUEST_CREATED = 1;
    private static final PriorityExecutor HTTP_EXECUTOR = new PriorityExecutor(5, true);
    private static final int MAX_FILE_LOAD_WORKER = 3;
    private static final AtomicInteger sCurrFileLoadCount = new AtomicInteger(0);
    private CacheCallback<ResultType> cacheCallback;
    private final Object cacheLock = new Object();
    private final CommonCallback<ResultType> callback;
    private final Executor executor;
    private volatile boolean hasException = false;
    private long lastUpdateTime;
    private Type loadType;
    private long loadingUpdateMaxTimeSpan = 300;
    private RequestParams params;
    private PrepareCallback prepareCallback;
    private ProgressCallback progressCallback;
    private Object rawResult = null;
    private UriRequest request;
    private RequestInterceptListener requestInterceptListener;
    private RequestWorker requestWorker;
    private RequestTracker tracker;
    private volatile Boolean trustCache = null;

    private final class RequestWorker {
        Throwable ex;
        Object result;

        private RequestWorker() {
        }

        /* synthetic */ RequestWorker(HttpTask httpTask, AnonymousClass1 anonymousClass1) {
            this();
        }

        /* JADX WARNING: Missing exception handler attribute for start block: B:72:0x0113 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x002f */
        /* JADX WARNING: Can't wrap try/catch for region: R(2:72|73) */
        /* JADX WARNING: Missing block: B:73:?, code skipped:
            r5.ex = r0;
     */
        public void request() {
            /*
            r5 = this;
            r0 = 0;
            r1 = java.io.File.class;
            r2 = org.xutils.http.HttpTask.this;	 Catch:{ Throwable -> 0x00b2 }
            r2 = r2.loadType;	 Catch:{ Throwable -> 0x00b2 }
            if (r1 != r2) goto L_0x003d;
        L_0x000b:
            r1 = org.xutils.http.HttpTask.sCurrFileLoadCount;	 Catch:{ Throwable -> 0x00b2 }
            r1 = r1.get();	 Catch:{ Throwable -> 0x00b2 }
            r2 = 3;
            if (r1 < r2) goto L_0x0036;
        L_0x0016:
            r1 = org.xutils.http.HttpTask.this;	 Catch:{ Throwable -> 0x00b2 }
            r1 = r1.isCancelled();	 Catch:{ Throwable -> 0x00b2 }
            if (r1 != 0) goto L_0x0036;
        L_0x001e:
            r1 = org.xutils.http.HttpTask.sCurrFileLoadCount;	 Catch:{ Throwable -> 0x00b2 }
            monitor-enter(r1);	 Catch:{ Throwable -> 0x00b2 }
            r2 = org.xutils.http.HttpTask.sCurrFileLoadCount;	 Catch:{ InterruptedException -> 0x0031, Throwable -> 0x002f }
            r3 = 10;
            r2.wait(r3);	 Catch:{ InterruptedException -> 0x0031, Throwable -> 0x002f }
            goto L_0x002f;
        L_0x002d:
            r0 = move-exception;
            goto L_0x0034;
        L_0x002f:
            monitor-exit(r1);	 Catch:{ all -> 0x002d }
            goto L_0x000b;
        L_0x0031:
            r0 = 1;
            monitor-exit(r1);	 Catch:{ all -> 0x002d }
            goto L_0x0036;
        L_0x0034:
            monitor-exit(r1);	 Catch:{ all -> 0x002d }
            throw r0;	 Catch:{ Throwable -> 0x00b2 }
        L_0x0036:
            r1 = org.xutils.http.HttpTask.sCurrFileLoadCount;	 Catch:{ Throwable -> 0x00b2 }
            r1.incrementAndGet();	 Catch:{ Throwable -> 0x00b2 }
        L_0x003d:
            if (r0 != 0) goto L_0x0091;
        L_0x003f:
            r1 = org.xutils.http.HttpTask.this;	 Catch:{ Throwable -> 0x00b2 }
            r1 = r1.isCancelled();	 Catch:{ Throwable -> 0x00b2 }
            if (r1 == 0) goto L_0x0048;
        L_0x0047:
            goto L_0x0091;
        L_0x0048:
            r0 = org.xutils.http.HttpTask.this;	 Catch:{ Throwable -> 0x0064 }
            r0 = r0.request;	 Catch:{ Throwable -> 0x0064 }
            r1 = org.xutils.http.HttpTask.this;	 Catch:{ Throwable -> 0x0064 }
            r1 = r1.requestInterceptListener;	 Catch:{ Throwable -> 0x0064 }
            r0.setRequestInterceptListener(r1);	 Catch:{ Throwable -> 0x0064 }
            r0 = org.xutils.http.HttpTask.this;	 Catch:{ Throwable -> 0x0064 }
            r0 = r0.request;	 Catch:{ Throwable -> 0x0064 }
            r0 = r0.loadResult();	 Catch:{ Throwable -> 0x0064 }
            r5.result = r0;	 Catch:{ Throwable -> 0x0064 }
            goto L_0x0067;
        L_0x0064:
            r0 = move-exception;
            r5.ex = r0;	 Catch:{ Throwable -> 0x00b2 }
        L_0x0067:
            r0 = r5.ex;	 Catch:{ Throwable -> 0x00b2 }
            if (r0 == 0) goto L_0x006e;
        L_0x006b:
            r0 = r5.ex;	 Catch:{ Throwable -> 0x00b2 }
            throw r0;	 Catch:{ Throwable -> 0x00b2 }
        L_0x006e:
            r0 = java.io.File.class;
            r1 = org.xutils.http.HttpTask.this;
            r1 = r1.loadType;
            if (r0 != r1) goto L_0x0137;
        L_0x0078:
            r0 = org.xutils.http.HttpTask.sCurrFileLoadCount;
            monitor-enter(r0);
            r1 = org.xutils.http.HttpTask.sCurrFileLoadCount;	 Catch:{ all -> 0x008e }
            r1.decrementAndGet();	 Catch:{ all -> 0x008e }
            r1 = org.xutils.http.HttpTask.sCurrFileLoadCount;	 Catch:{ all -> 0x008e }
            r1.notifyAll();	 Catch:{ all -> 0x008e }
            monitor-exit(r0);	 Catch:{ all -> 0x008e }
            goto L_0x0137;
        L_0x008e:
            r1 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x008e }
            throw r1;
        L_0x0091:
            r1 = new org.xutils.common.Callback$CancelledException;	 Catch:{ Throwable -> 0x00b2 }
            r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00b2 }
            r2.<init>();	 Catch:{ Throwable -> 0x00b2 }
            r3 = "cancelled before request";
            r2.append(r3);	 Catch:{ Throwable -> 0x00b2 }
            if (r0 == 0) goto L_0x00a2;
        L_0x009f:
            r0 = "(interrupted)";
            goto L_0x00a4;
        L_0x00a2:
            r0 = "";
        L_0x00a4:
            r2.append(r0);	 Catch:{ Throwable -> 0x00b2 }
            r0 = r2.toString();	 Catch:{ Throwable -> 0x00b2 }
            r1.<init>(r0);	 Catch:{ Throwable -> 0x00b2 }
            throw r1;	 Catch:{ Throwable -> 0x00b2 }
        L_0x00af:
            r0 = move-exception;
            goto L_0x0138;
        L_0x00b2:
            r0 = move-exception;
            r5.ex = r0;	 Catch:{ all -> 0x00af }
            r1 = r0 instanceof org.xutils.ex.HttpException;	 Catch:{ all -> 0x00af }
            if (r1 == 0) goto L_0x0115;
        L_0x00b9:
            r1 = r0;
            r1 = (org.xutils.ex.HttpException) r1;	 Catch:{ all -> 0x00af }
            r2 = r1.getCode();	 Catch:{ all -> 0x00af }
            r3 = 301; // 0x12d float:4.22E-43 double:1.487E-321;
            if (r2 == r3) goto L_0x00c8;
        L_0x00c4:
            r3 = 302; // 0x12e float:4.23E-43 double:1.49E-321;
            if (r2 != r3) goto L_0x0115;
        L_0x00c8:
            r3 = org.xutils.http.HttpTask.this;	 Catch:{ all -> 0x00af }
            r3 = r3.params;	 Catch:{ all -> 0x00af }
            r3 = r3.getRedirectHandler();	 Catch:{ all -> 0x00af }
            if (r3 == 0) goto L_0x0115;
        L_0x00d4:
            r4 = org.xutils.http.HttpTask.this;	 Catch:{ Throwable -> 0x0113 }
            r4 = r4.request;	 Catch:{ Throwable -> 0x0113 }
            r3 = r3.getRedirectParams(r4);	 Catch:{ Throwable -> 0x0113 }
            if (r3 == 0) goto L_0x0115;
        L_0x00e0:
            r4 = r3.getMethod();	 Catch:{ Throwable -> 0x0113 }
            if (r4 != 0) goto L_0x00f3;
        L_0x00e6:
            r4 = org.xutils.http.HttpTask.this;	 Catch:{ Throwable -> 0x0113 }
            r4 = r4.params;	 Catch:{ Throwable -> 0x0113 }
            r4 = r4.getMethod();	 Catch:{ Throwable -> 0x0113 }
            r3.setMethod(r4);	 Catch:{ Throwable -> 0x0113 }
        L_0x00f3:
            r4 = org.xutils.http.HttpTask.this;	 Catch:{ Throwable -> 0x0113 }
            r4.params = r3;	 Catch:{ Throwable -> 0x0113 }
            r3 = org.xutils.http.HttpTask.this;	 Catch:{ Throwable -> 0x0113 }
            r4 = org.xutils.http.HttpTask.this;	 Catch:{ Throwable -> 0x0113 }
            r4 = r4.createNewRequest();	 Catch:{ Throwable -> 0x0113 }
            r3.request = r4;	 Catch:{ Throwable -> 0x0113 }
            r3 = new org.xutils.ex.HttpRedirectException;	 Catch:{ Throwable -> 0x0113 }
            r4 = r1.getMessage();	 Catch:{ Throwable -> 0x0113 }
            r1 = r1.getResult();	 Catch:{ Throwable -> 0x0113 }
            r3.<init>(r2, r4, r1);	 Catch:{ Throwable -> 0x0113 }
            r5.ex = r3;	 Catch:{ Throwable -> 0x0113 }
            goto L_0x0115;
        L_0x0113:
            r5.ex = r0;	 Catch:{ all -> 0x00af }
        L_0x0115:
            r0 = java.io.File.class;
            r1 = org.xutils.http.HttpTask.this;
            r1 = r1.loadType;
            if (r0 != r1) goto L_0x0137;
        L_0x011f:
            r0 = org.xutils.http.HttpTask.sCurrFileLoadCount;
            monitor-enter(r0);
            r1 = org.xutils.http.HttpTask.sCurrFileLoadCount;	 Catch:{ all -> 0x0134 }
            r1.decrementAndGet();	 Catch:{ all -> 0x0134 }
            r1 = org.xutils.http.HttpTask.sCurrFileLoadCount;	 Catch:{ all -> 0x0134 }
            r1.notifyAll();	 Catch:{ all -> 0x0134 }
            monitor-exit(r0);	 Catch:{ all -> 0x0134 }
            goto L_0x0137;
        L_0x0134:
            r1 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x0134 }
            throw r1;
        L_0x0137:
            return;
        L_0x0138:
            r1 = java.io.File.class;
            r2 = org.xutils.http.HttpTask.this;
            r2 = r2.loadType;
            if (r1 != r2) goto L_0x015a;
        L_0x0142:
            r1 = org.xutils.http.HttpTask.sCurrFileLoadCount;
            monitor-enter(r1);
            r2 = org.xutils.http.HttpTask.sCurrFileLoadCount;	 Catch:{ all -> 0x0157 }
            r2.decrementAndGet();	 Catch:{ all -> 0x0157 }
            r2 = org.xutils.http.HttpTask.sCurrFileLoadCount;	 Catch:{ all -> 0x0157 }
            r2.notifyAll();	 Catch:{ all -> 0x0157 }
            monitor-exit(r1);	 Catch:{ all -> 0x0157 }
            goto L_0x015a;
        L_0x0157:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0157 }
            throw r0;
        L_0x015a:
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.xutils.http.HttpTask$RequestWorker.request():void");
        }
    }

    public HttpTask(RequestParams requestParams, Cancelable cancelable, CommonCallback<ResultType> commonCallback) {
        super(cancelable);
        this.params = requestParams;
        this.callback = commonCallback;
        if (commonCallback instanceof CacheCallback) {
            this.cacheCallback = (CacheCallback) commonCallback;
        }
        if (commonCallback instanceof PrepareCallback) {
            this.prepareCallback = (PrepareCallback) commonCallback;
        }
        if (commonCallback instanceof ProgressCallback) {
            this.progressCallback = (ProgressCallback) commonCallback;
        }
        if (commonCallback instanceof RequestInterceptListener) {
            this.requestInterceptListener = (RequestInterceptListener) commonCallback;
        }
        RequestTracker requestTracker = requestParams.getRequestTracker();
        if (requestTracker == null) {
            requestTracker = commonCallback instanceof RequestTracker ? (RequestTracker) commonCallback : UriRequestFactory.getDefaultTracker();
        }
        if (requestTracker != null) {
            this.tracker = new RequestTrackerWrapper(requestTracker);
        }
        if (requestParams.getExecutor() != null) {
            this.executor = requestParams.getExecutor();
        } else if (this.cacheCallback != null) {
            this.executor = CACHE_EXECUTOR;
        } else {
            this.executor = HTTP_EXECUTOR;
        }
    }

    private void checkDownloadTask() {
        if (File.class == this.loadType) {
            synchronized (DOWNLOAD_TASK) {
                WeakReference weakReference;
                String saveFilePath = this.params.getSaveFilePath();
                if (!TextUtils.isEmpty(saveFilePath)) {
                    weakReference = (WeakReference) DOWNLOAD_TASK.get(saveFilePath);
                    if (weakReference != null) {
                        HttpTask httpTask = (HttpTask) weakReference.get();
                        if (httpTask != null) {
                            httpTask.cancel();
                            httpTask.closeRequestSync();
                        }
                        DOWNLOAD_TASK.remove(saveFilePath);
                    }
                    DOWNLOAD_TASK.put(saveFilePath, new WeakReference(this));
                }
                if (DOWNLOAD_TASK.size() > 3) {
                    Iterator it = DOWNLOAD_TASK.entrySet().iterator();
                    while (it.hasNext()) {
                        weakReference = (WeakReference) ((Entry) it.next()).getValue();
                        if (weakReference == null || weakReference.get() == null) {
                            it.remove();
                        }
                    }
                }
            }
        }
    }

    private void clearRawResult() {
        if (this.rawResult instanceof Closeable) {
            IOUtil.closeQuietly((Closeable) this.rawResult);
        }
        this.rawResult = null;
    }

    private void closeRequestSync() {
        clearRawResult();
        IOUtil.closeQuietly(this.request);
    }

    private UriRequest createNewRequest() throws Throwable {
        this.params.init();
        UriRequest uriRequest = UriRequestFactory.getUriRequest(this.params, this.loadType);
        uriRequest.setCallingClassLoader(this.callback.getClass().getClassLoader());
        uriRequest.setProgressHandler(this);
        this.loadingUpdateMaxTimeSpan = (long) this.params.getLoadingUpdateMaxTimeSpan();
        update(1, uriRequest);
        return uriRequest;
    }

    private void resolveLoadType() {
        Class cls = this.callback.getClass();
        if (this.callback instanceof TypedCallback) {
            this.loadType = ((TypedCallback) this.callback).getLoadType();
        } else if (this.callback instanceof PrepareCallback) {
            this.loadType = ParameterizedTypeUtil.getParameterizedType(cls, PrepareCallback.class, 0);
        } else {
            this.loadType = ParameterizedTypeUtil.getParameterizedType(cls, CommonCallback.class, 0);
        }
    }

    /* Access modifiers changed, original: protected */
    public void cancelWorks() {
        x.task().run(new Runnable() {
            public void run() {
                HttpTask.this.closeRequestSync();
            }
        });
    }

    /* Access modifiers changed, original: protected */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x011a A:{SYNTHETIC, Splitter:B:72:0x011a} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00bb  */
    /* JADX WARNING: Missing exception handler attribute for start block: B:48:0x00dc */
    /* JADX WARNING: Removed duplicated region for block: B:132:? A:{SYNTHETIC, Splitter:B:72:0x011a, ExcHandler: HttpRedirectException (unused org.xutils.ex.HttpRedirectException)} */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x01f6 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x01d7  */
    public ResultType doBackground() throws java.lang.Throwable {
        /*
        r9 = this;
        r0 = r9.isCancelled();
        if (r0 == 0) goto L_0x000e;
    L_0x0006:
        r0 = new org.xutils.common.Callback$CancelledException;
        r1 = "cancelled before request";
        r0.<init>(r1);
        throw r0;
    L_0x000e:
        r9.resolveLoadType();
        r0 = r9.createNewRequest();
        r9.request = r0;
        r9.checkDownloadTask();
        r0 = r9.params;
        r0 = r0.getHttpRetryHandler();
        if (r0 != 0) goto L_0x0027;
    L_0x0022:
        r0 = new org.xutils.http.app.HttpRetryHandler;
        r0.<init>();
    L_0x0027:
        r1 = r9.params;
        r1 = r1.getMaxRetryCount();
        r0.setMaxRetryCount(r1);
        r1 = r9.isCancelled();
        if (r1 == 0) goto L_0x003e;
    L_0x0036:
        r0 = new org.xutils.common.Callback$CancelledException;
        r1 = "cancelled before request";
        r0.<init>(r1);
        throw r0;
    L_0x003e:
        r1 = r9.cacheCallback;
        r2 = 0;
        r3 = 1;
        r4 = 0;
        if (r1 == 0) goto L_0x00f1;
    L_0x0045:
        r1 = r9.params;
        r1 = r1.getMethod();
        r1 = org.xutils.http.HttpMethod.permitsCache(r1);
        if (r1 == 0) goto L_0x00f1;
    L_0x0051:
        r9.clearRawResult();	 Catch:{ Throwable -> 0x0077 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0077 }
        r1.<init>();	 Catch:{ Throwable -> 0x0077 }
        r5 = "load cache: ";
        r1.append(r5);	 Catch:{ Throwable -> 0x0077 }
        r5 = r9.request;	 Catch:{ Throwable -> 0x0077 }
        r5 = r5.getRequestUri();	 Catch:{ Throwable -> 0x0077 }
        r1.append(r5);	 Catch:{ Throwable -> 0x0077 }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x0077 }
        org.xutils.common.util.LogUtil.d(r1);	 Catch:{ Throwable -> 0x0077 }
        r1 = r9.request;	 Catch:{ Throwable -> 0x0077 }
        r1 = r1.loadResultFromCache();	 Catch:{ Throwable -> 0x0077 }
        r9.rawResult = r1;	 Catch:{ Throwable -> 0x0077 }
        goto L_0x007d;
    L_0x0077:
        r1 = move-exception;
        r5 = "load disk cache error";
        org.xutils.common.util.LogUtil.w(r5, r1);
    L_0x007d:
        r1 = r9.isCancelled();
        if (r1 == 0) goto L_0x008e;
    L_0x0083:
        r9.clearRawResult();
        r0 = new org.xutils.common.Callback$CancelledException;
        r1 = "cancelled before request";
        r0.<init>(r1);
        throw r0;
    L_0x008e:
        r1 = r9.rawResult;
        if (r1 == 0) goto L_0x00f1;
    L_0x0092:
        r1 = r9.prepareCallback;
        if (r1 == 0) goto L_0x00b3;
    L_0x0096:
        r1 = r9.prepareCallback;	 Catch:{ Throwable -> 0x00a4 }
        r5 = r9.rawResult;	 Catch:{ Throwable -> 0x00a4 }
        r1 = r1.prepare(r5);	 Catch:{ Throwable -> 0x00a4 }
        r9.clearRawResult();
        goto L_0x00b5;
    L_0x00a2:
        r0 = move-exception;
        goto L_0x00af;
    L_0x00a4:
        r1 = move-exception;
        r5 = "prepare disk cache error";
        org.xutils.common.util.LogUtil.w(r5, r1);	 Catch:{ all -> 0x00a2 }
        r9.clearRawResult();
        r1 = r4;
        goto L_0x00b5;
    L_0x00af:
        r9.clearRawResult();
        throw r0;
    L_0x00b3:
        r1 = r9.rawResult;
    L_0x00b5:
        r5 = r9.isCancelled();
        if (r5 == 0) goto L_0x00c3;
    L_0x00bb:
        r0 = new org.xutils.common.Callback$CancelledException;
        r1 = "cancelled before request";
        r0.<init>(r1);
        throw r0;
    L_0x00c3:
        if (r1 == 0) goto L_0x00f2;
    L_0x00c5:
        r5 = 2;
        r6 = new java.lang.Object[r3];
        r6[r2] = r1;
        r9.update(r5, r6);
    L_0x00cd:
        r5 = r9.trustCache;
        if (r5 != 0) goto L_0x00e8;
    L_0x00d1:
        r5 = r9.cacheLock;
        monitor-enter(r5);
        r6 = r9.cacheLock;	 Catch:{ InterruptedException -> 0x00de, Throwable -> 0x00dc }
        r6.wait();	 Catch:{ InterruptedException -> 0x00de, Throwable -> 0x00dc }
        goto L_0x00dc;
    L_0x00da:
        r0 = move-exception;
        goto L_0x00e6;
    L_0x00dc:
        monitor-exit(r5);	 Catch:{ all -> 0x00da }
        goto L_0x00cd;
    L_0x00de:
        r0 = new org.xutils.common.Callback$CancelledException;	 Catch:{ all -> 0x00da }
        r1 = "cancelled before request";
        r0.<init>(r1);	 Catch:{ all -> 0x00da }
        throw r0;	 Catch:{ all -> 0x00da }
    L_0x00e6:
        monitor-exit(r5);	 Catch:{ all -> 0x00da }
        throw r0;
    L_0x00e8:
        r5 = r9.trustCache;
        r5 = r5.booleanValue();
        if (r5 == 0) goto L_0x00f2;
    L_0x00f0:
        return r4;
    L_0x00f1:
        r1 = r4;
    L_0x00f2:
        r5 = r9.trustCache;
        if (r5 != 0) goto L_0x00fc;
    L_0x00f6:
        r5 = java.lang.Boolean.valueOf(r2);
        r9.trustCache = r5;
    L_0x00fc:
        if (r1 != 0) goto L_0x0103;
    L_0x00fe:
        r1 = r9.request;
        r1.clearCacheHeader();
    L_0x0103:
        r1 = r9.callback;
        r1 = r1 instanceof org.xutils.common.Callback.ProxyCacheCallback;
        if (r1 == 0) goto L_0x0114;
    L_0x0109:
        r1 = r9.callback;
        r1 = (org.xutils.common.Callback.ProxyCacheCallback) r1;
        r1 = r1.onlyCache();
        if (r1 == 0) goto L_0x0114;
    L_0x0113:
        return r4;
    L_0x0114:
        r7 = r2;
        r1 = r3;
        r5 = r4;
        r6 = r5;
    L_0x0118:
        if (r1 == 0) goto L_0x0214;
    L_0x011a:
        r1 = r9.isCancelled();	 Catch:{ HttpRedirectException -> 0x01f7, Throwable -> 0x01cc }
        if (r1 == 0) goto L_0x0128;
    L_0x0120:
        r1 = new org.xutils.common.Callback$CancelledException;	 Catch:{ HttpRedirectException -> 0x01f7, Throwable -> 0x01cc }
        r8 = "cancelled before request";
        r1.<init>(r8);	 Catch:{ HttpRedirectException -> 0x01f7, Throwable -> 0x01cc }
        throw r1;	 Catch:{ HttpRedirectException -> 0x01f7, Throwable -> 0x01cc }
    L_0x0128:
        r1 = r9.request;	 Catch:{ HttpRedirectException -> 0x01f7, Throwable -> 0x01cc }
        r1.close();	 Catch:{ HttpRedirectException -> 0x01f7, Throwable -> 0x01cc }
        r9.clearRawResult();	 Catch:{ Throwable -> 0x01b9, HttpRedirectException -> 0x01f7 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x01b9, HttpRedirectException -> 0x01f7 }
        r1.<init>();	 Catch:{ Throwable -> 0x01b9, HttpRedirectException -> 0x01f7 }
        r8 = "load: ";
        r1.append(r8);	 Catch:{ Throwable -> 0x01b9, HttpRedirectException -> 0x01f7 }
        r8 = r9.request;	 Catch:{ Throwable -> 0x01b9, HttpRedirectException -> 0x01f7 }
        r8 = r8.getRequestUri();	 Catch:{ Throwable -> 0x01b9, HttpRedirectException -> 0x01f7 }
        r1.append(r8);	 Catch:{ Throwable -> 0x01b9, HttpRedirectException -> 0x01f7 }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x01b9, HttpRedirectException -> 0x01f7 }
        org.xutils.common.util.LogUtil.d(r1);	 Catch:{ Throwable -> 0x01b9, HttpRedirectException -> 0x01f7 }
        r1 = new org.xutils.http.HttpTask$RequestWorker;	 Catch:{ Throwable -> 0x01b9, HttpRedirectException -> 0x01f7 }
        r1.<init>(r9, r4);	 Catch:{ Throwable -> 0x01b9, HttpRedirectException -> 0x01f7 }
        r9.requestWorker = r1;	 Catch:{ Throwable -> 0x01b9, HttpRedirectException -> 0x01f7 }
        r1 = r9.requestWorker;	 Catch:{ Throwable -> 0x01b9, HttpRedirectException -> 0x01f7 }
        r1.request();	 Catch:{ Throwable -> 0x01b9, HttpRedirectException -> 0x01f7 }
        r1 = r9.requestWorker;	 Catch:{ Throwable -> 0x01b9, HttpRedirectException -> 0x01f7 }
        r1 = r1.ex;	 Catch:{ Throwable -> 0x01b9, HttpRedirectException -> 0x01f7 }
        if (r1 == 0) goto L_0x0161;
    L_0x015c:
        r1 = r9.requestWorker;	 Catch:{ Throwable -> 0x01b9, HttpRedirectException -> 0x01f7 }
        r1 = r1.ex;	 Catch:{ Throwable -> 0x01b9, HttpRedirectException -> 0x01f7 }
        throw r1;	 Catch:{ Throwable -> 0x01b9, HttpRedirectException -> 0x01f7 }
    L_0x0161:
        r1 = r9.requestWorker;	 Catch:{ Throwable -> 0x01b9, HttpRedirectException -> 0x01f7 }
        r1 = r1.result;	 Catch:{ Throwable -> 0x01b9, HttpRedirectException -> 0x01f7 }
        r9.rawResult = r1;	 Catch:{ Throwable -> 0x01b9, HttpRedirectException -> 0x01f7 }
        r1 = r9.prepareCallback;	 Catch:{ HttpRedirectException -> 0x01f7, Throwable -> 0x01cc }
        if (r1 == 0) goto L_0x0190;
    L_0x016b:
        r1 = r9.isCancelled();	 Catch:{ HttpRedirectException -> 0x01f7, Throwable -> 0x01cc }
        if (r1 == 0) goto L_0x0179;
    L_0x0171:
        r1 = new org.xutils.common.Callback$CancelledException;	 Catch:{ HttpRedirectException -> 0x01f7, Throwable -> 0x01cc }
        r8 = "cancelled before request";
        r1.<init>(r8);	 Catch:{ HttpRedirectException -> 0x01f7, Throwable -> 0x01cc }
        throw r1;	 Catch:{ HttpRedirectException -> 0x01f7, Throwable -> 0x01cc }
    L_0x0179:
        r1 = r9.prepareCallback;	 Catch:{ all -> 0x018b }
        r8 = r9.rawResult;	 Catch:{ all -> 0x018b }
        r1 = r1.prepare(r8);	 Catch:{ all -> 0x018b }
        r9.clearRawResult();	 Catch:{ HttpRedirectException -> 0x0189, Throwable -> 0x0185 }
        goto L_0x0192;
    L_0x0185:
        r5 = move-exception;
        r6 = r1;
        r1 = r5;
        goto L_0x01cd;
    L_0x0189:
        r6 = r1;
        goto L_0x01f7;
    L_0x018b:
        r1 = move-exception;
        r9.clearRawResult();	 Catch:{ HttpRedirectException -> 0x01f7, Throwable -> 0x01cc }
        throw r1;	 Catch:{ HttpRedirectException -> 0x01f7, Throwable -> 0x01cc }
    L_0x0190:
        r1 = r9.rawResult;	 Catch:{ HttpRedirectException -> 0x01f7, Throwable -> 0x01cc }
    L_0x0192:
        r6 = r1;
        r1 = r9.cacheCallback;	 Catch:{ HttpRedirectException -> 0x01f7, Throwable -> 0x01cc }
        if (r1 == 0) goto L_0x01a8;
    L_0x0197:
        r1 = r9.params;	 Catch:{ HttpRedirectException -> 0x01f7, Throwable -> 0x01cc }
        r1 = r1.getMethod();	 Catch:{ HttpRedirectException -> 0x01f7, Throwable -> 0x01cc }
        r1 = org.xutils.http.HttpMethod.permitsCache(r1);	 Catch:{ HttpRedirectException -> 0x01f7, Throwable -> 0x01cc }
        if (r1 == 0) goto L_0x01a8;
    L_0x01a3:
        r1 = r9.request;	 Catch:{ HttpRedirectException -> 0x01f7, Throwable -> 0x01cc }
        r1.save2Cache();	 Catch:{ HttpRedirectException -> 0x01f7, Throwable -> 0x01cc }
    L_0x01a8:
        r1 = r9.isCancelled();	 Catch:{ HttpRedirectException -> 0x01f7, Throwable -> 0x01cc }
        if (r1 == 0) goto L_0x01b6;
    L_0x01ae:
        r1 = new org.xutils.common.Callback$CancelledException;	 Catch:{ HttpRedirectException -> 0x01f7, Throwable -> 0x01cc }
        r8 = "cancelled after request";
        r1.<init>(r8);	 Catch:{ HttpRedirectException -> 0x01f7, Throwable -> 0x01cc }
        throw r1;	 Catch:{ HttpRedirectException -> 0x01f7, Throwable -> 0x01cc }
    L_0x01b6:
        r1 = r2;
        goto L_0x0118;
    L_0x01b9:
        r1 = move-exception;
        r9.clearRawResult();	 Catch:{ HttpRedirectException -> 0x01f7, Throwable -> 0x01cc }
        r8 = r9.isCancelled();	 Catch:{ HttpRedirectException -> 0x01f7, Throwable -> 0x01cc }
        if (r8 == 0) goto L_0x01cb;
    L_0x01c3:
        r1 = new org.xutils.common.Callback$CancelledException;	 Catch:{ HttpRedirectException -> 0x01f7, Throwable -> 0x01cc }
        r8 = "cancelled during request";
        r1.<init>(r8);	 Catch:{ HttpRedirectException -> 0x01f7, Throwable -> 0x01cc }
        throw r1;	 Catch:{ HttpRedirectException -> 0x01f7, Throwable -> 0x01cc }
    L_0x01cb:
        throw r1;	 Catch:{ HttpRedirectException -> 0x01f7, Throwable -> 0x01cc }
    L_0x01cc:
        r1 = move-exception;
    L_0x01cd:
        r5 = r9.request;
        r5 = r5.getResponseCode();
        r8 = 304; // 0x130 float:4.26E-43 double:1.5E-321;
        if (r5 == r8) goto L_0x01f6;
    L_0x01d7:
        switch(r5) {
            case 204: goto L_0x01f6;
            case 205: goto L_0x01f6;
            default: goto L_0x01da;
        };
    L_0x01da:
        r5 = r9.isCancelled();
        if (r5 == 0) goto L_0x01eb;
    L_0x01e0:
        r5 = r1 instanceof org.xutils.common.Callback.CancelledException;
        if (r5 != 0) goto L_0x01eb;
    L_0x01e4:
        r1 = new org.xutils.common.Callback$CancelledException;
        r5 = "canceled by user";
        r1.<init>(r5);
    L_0x01eb:
        r5 = r1;
        r1 = r9.request;
        r7 = r7 + 1;
        r1 = r0.canRetry(r1, r5, r7);
        goto L_0x0118;
    L_0x01f6:
        return r4;
    L_0x01f7:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r8 = "Http Redirect:";
        r1.append(r8);
        r8 = r9.params;
        r8 = r8.getUri();
        r1.append(r8);
        r1 = r1.toString();
        org.xutils.common.util.LogUtil.w(r1);
        r1 = r3;
        goto L_0x0118;
    L_0x0214:
        if (r5 == 0) goto L_0x0223;
    L_0x0216:
        if (r6 != 0) goto L_0x0223;
    L_0x0218:
        r0 = r9.trustCache;
        r0 = r0.booleanValue();
        if (r0 != 0) goto L_0x0223;
    L_0x0220:
        r9.hasException = r3;
        throw r5;
    L_0x0223:
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xutils.http.HttpTask.doBackground():java.lang.Object");
    }

    public Executor getExecutor() {
        return this.executor;
    }

    public Priority getPriority() {
        return this.params.getPriority();
    }

    /* Access modifiers changed, original: protected */
    public boolean isCancelFast() {
        return this.params.isCancelFast();
    }

    /* Access modifiers changed, original: protected */
    public void onCancelled(CancelledException cancelledException) {
        if (this.tracker != null) {
            this.tracker.onCancelled(this.request);
        }
        this.callback.onCancelled(cancelledException);
    }

    /* Access modifiers changed, original: protected */
    public void onError(Throwable th, boolean z) {
        if (this.tracker != null) {
            this.tracker.onError(this.request, th, z);
        }
        this.callback.onError(th, z);
    }

    /* Access modifiers changed, original: protected */
    public void onFinished() {
        if (this.tracker != null) {
            this.tracker.onFinished(this.request);
        }
        x.task().run(new Runnable() {
            public void run() {
                HttpTask.this.closeRequestSync();
            }
        });
        this.callback.onFinished();
    }

    /* Access modifiers changed, original: protected */
    public void onStarted() {
        if (this.tracker != null) {
            this.tracker.onStart(this.params);
        }
        if (this.progressCallback != null) {
            this.progressCallback.onStarted();
        }
    }

    /* Access modifiers changed, original: protected */
    public void onSuccess(ResultType resultType) {
        if (!this.hasException) {
            if (this.tracker != null) {
                this.tracker.onSuccess(this.request, resultType);
            }
            this.callback.onSuccess(resultType);
        }
    }

    /* Access modifiers changed, original: protected|varargs */
    public void onUpdate(int i, Object... objArr) {
        switch (i) {
            case 1:
                if (this.tracker != null) {
                    this.tracker.onRequestCreated((UriRequest) objArr[0]);
                    return;
                }
                return;
            case 2:
                synchronized (this.cacheLock) {
                    Object obj;
                    try {
                        obj = objArr[0];
                        if (this.tracker != null) {
                            this.tracker.onCache(this.request, obj);
                        }
                        this.trustCache = Boolean.valueOf(this.cacheCallback.onCache(obj));
                        obj = this.cacheLock;
                    } catch (Throwable th) {
                        try {
                            this.trustCache = Boolean.valueOf(false);
                            this.callback.onError(th, true);
                            obj = this.cacheLock;
                        } catch (Throwable th2) {
                            this.cacheLock.notifyAll();
                        }
                    }
                    obj.notifyAll();
                }
                return;
            case 3:
                if (this.progressCallback != null && objArr.length == 3) {
                    try {
                        this.progressCallback.onLoading(((Number) objArr[0]).longValue(), ((Number) objArr[1]).longValue(), ((Boolean) objArr[2]).booleanValue());
                        return;
                    } catch (Throwable th3) {
                        this.callback.onError(th3, true);
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }

    /* Access modifiers changed, original: protected */
    public void onWaiting() {
        if (this.tracker != null) {
            this.tracker.onWaiting(this.params);
        }
        if (this.progressCallback != null) {
            this.progressCallback.onWaiting();
        }
    }

    public String toString() {
        return this.params.toString();
    }

    public boolean updateProgress(long j, long j2, boolean z) {
        boolean z2 = false;
        if (isCancelled() || isFinished()) {
            return false;
        }
        if (!(this.progressCallback == null || this.request == null || j <= 0)) {
            if (j < j2) {
                j = j2;
            }
            if (z) {
                this.lastUpdateTime = System.currentTimeMillis();
                update(3, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(this.request.isLoading()));
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.lastUpdateTime >= this.loadingUpdateMaxTimeSpan) {
                    this.lastUpdateTime = currentTimeMillis;
                    update(3, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(this.request.isLoading()));
                }
            }
        }
        if (!(isCancelled() || isFinished())) {
            z2 = true;
        }
        return z2;
    }
}
