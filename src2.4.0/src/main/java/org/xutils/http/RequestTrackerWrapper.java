package org.xutils.http;

import org.xutils.common.util.LogUtil;
import org.xutils.http.app.RequestTracker;
import org.xutils.http.request.UriRequest;

final class RequestTrackerWrapper implements RequestTracker {
    private final RequestTracker base;

    public RequestTrackerWrapper(RequestTracker requestTracker) {
        this.base = requestTracker;
    }

    public void onCache(UriRequest uriRequest, Object obj) {
        try {
            this.base.onCache(uriRequest, obj);
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
        }
    }

    public void onCancelled(UriRequest uriRequest) {
        try {
            this.base.onCancelled(uriRequest);
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
        }
    }

    public void onError(UriRequest uriRequest, Throwable th, boolean z) {
        try {
            this.base.onError(uriRequest, th, z);
        } catch (Throwable th2) {
            LogUtil.e(th2.getMessage(), th2);
        }
    }

    public void onFinished(UriRequest uriRequest) {
        try {
            this.base.onFinished(uriRequest);
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
        }
    }

    public void onRequestCreated(UriRequest uriRequest) {
        try {
            this.base.onRequestCreated(uriRequest);
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
        }
    }

    public void onStart(RequestParams requestParams) {
        try {
            this.base.onStart(requestParams);
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
        }
    }

    public void onSuccess(UriRequest uriRequest, Object obj) {
        try {
            this.base.onSuccess(uriRequest, obj);
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
        }
    }

    public void onWaiting(RequestParams requestParams) {
        try {
            this.base.onWaiting(requestParams);
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
        }
    }
}
