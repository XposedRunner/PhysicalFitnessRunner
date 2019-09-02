package com.sina.weibo.sdk.net;

import android.content.Context;
import android.os.AsyncTask;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.utils.LogUtil;
import com.tencent.open.SocialConstants;

public class AsyncWeiboRunner {
    private Context mContext;

    private static class AsyncTaskResult<T> {
        private WeiboException error;
        private T result;

        public AsyncTaskResult(WeiboException weiboException) {
            this.error = weiboException;
        }

        public AsyncTaskResult(T t) {
            this.result = t;
        }

        public WeiboException getError() {
            return this.error;
        }

        public T getResult() {
            return this.result;
        }
    }

    public static class RequestRunner extends AsyncTask<Void, Void, AsyncTaskResult<String>> {
        private final Context mContext;
        private final String mHttpMethod;
        private final RequestListener mListener;
        private final WeiboParameters mParams;
        private final String mUrl;

        public RequestRunner(Context context, String str, WeiboParameters weiboParameters, String str2, RequestListener requestListener) {
            this.mContext = context;
            this.mUrl = str;
            this.mParams = weiboParameters;
            this.mHttpMethod = str2;
            this.mListener = requestListener;
        }

        /* Access modifiers changed, original: protected|varargs */
        public AsyncTaskResult<String> doInBackground(Void... voidArr) {
            try {
                return new AsyncTaskResult(HttpManager.openUrl(this.mContext, this.mUrl, this.mHttpMethod, this.mParams));
            } catch (WeiboException e) {
                LogUtil.e("ContentValues", e.getMessage());
                return new AsyncTaskResult(e);
            }
        }

        /* Access modifiers changed, original: protected */
        public void onPostExecute(AsyncTaskResult<String> asyncTaskResult) {
            WeiboException error = asyncTaskResult.getError();
            if (error != null) {
                this.mListener.onWeiboException(error);
            } else {
                this.mListener.onComplete((String) asyncTaskResult.getResult());
            }
        }

        /* Access modifiers changed, original: protected */
        public void onPreExecute() {
        }
    }

    public AsyncWeiboRunner(Context context) {
        this.mContext = context;
    }

    private void addAction(Context context, String str) {
        try {
            Class.forName("com.sina.weibo.sdk.cmd.WbAppActivator").getMethod("getInstance", new Class[]{Context.class, String.class}).invoke(null, new Object[]{context, str}).getClass().getMethod("activateApp", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
        }
    }

    public String request(String str, WeiboParameters weiboParameters, String str2) throws WeiboException {
        addAction(this.mContext, weiboParameters.getAppKey());
        return HttpManager.openUrl(this.mContext, str, str2, weiboParameters);
    }

    public String request(String str, boolean z, String str2, String str3, WeiboParameters weiboParameters, String str4) throws WeiboException {
        if (!z) {
            return request(str3, weiboParameters, str4);
        }
        weiboParameters.put(SocialConstants.PARAM_SOURCE, str);
        weiboParameters.setAnonymousCookie(str2);
        return request(str3, weiboParameters, str4);
    }

    public void request4RdirectURL(String str, WeiboParameters weiboParameters, String str2, RequestListener requestListener) {
        final String str3 = str;
        final String str4 = str2;
        final WeiboParameters weiboParameters2 = weiboParameters;
        final RequestListener requestListener2 = requestListener;
        new Thread() {
            public void run() {
                try {
                    String openRedirectUrl4LocationUri = HttpManager.openRedirectUrl4LocationUri(AsyncWeiboRunner.this.mContext, str3, str4, weiboParameters2);
                    if (requestListener2 != null) {
                        requestListener2.onComplete(openRedirectUrl4LocationUri);
                    }
                } catch (WeiboException e) {
                    if (requestListener2 != null) {
                        requestListener2.onWeiboException(e);
                    }
                }
            }
        }.start();
    }

    public void requestAsync(String str, WeiboParameters weiboParameters, String str2, RequestListener requestListener) {
        addAction(this.mContext, weiboParameters.getAppKey());
        new RequestRunner(this.mContext, str, weiboParameters, str2, requestListener).execute(new Void[]{null});
    }

    public void requestAsync(String str, boolean z, String str2, String str3, WeiboParameters weiboParameters, String str4, RequestListener requestListener) {
        if (z) {
            weiboParameters.put(SocialConstants.PARAM_SOURCE, str);
            weiboParameters.setAnonymousCookie(str2);
            requestAsync(str3, weiboParameters, str4, requestListener);
            return;
        }
        requestAsync(str3, weiboParameters, str4, requestListener);
    }

    @Deprecated
    public void requestByThread(String str, WeiboParameters weiboParameters, String str2, RequestListener requestListener) {
        final String str3 = str;
        final String str4 = str2;
        final WeiboParameters weiboParameters2 = weiboParameters;
        final RequestListener requestListener2 = requestListener;
        new Thread() {
            public void run() {
                try {
                    String openUrl = HttpManager.openUrl(AsyncWeiboRunner.this.mContext, str3, str4, weiboParameters2);
                    if (requestListener2 != null) {
                        requestListener2.onComplete(openUrl);
                    }
                } catch (WeiboException e) {
                    if (requestListener2 != null) {
                        requestListener2.onWeiboException(e);
                    }
                }
            }
        }.start();
    }
}
