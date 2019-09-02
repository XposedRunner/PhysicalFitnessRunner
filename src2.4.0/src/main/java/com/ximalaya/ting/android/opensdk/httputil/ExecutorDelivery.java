package com.ximalaya.ting.android.opensdk.httputil;

import android.os.Handler;
import android.os.Looper;
import com.ximalaya.ting.android.opensdk.datatrasfer.IDataCallBack;
import java.util.concurrent.Executor;

public class ExecutorDelivery {
    private final Executor mResponsePoster = new Executor() {
        public void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    };

    private class ResponseDeliveryRunnable<T> implements Runnable {
        private IDataCallBack<T> callback;
        private int code;
        private String message;
        private int postCode;
        private T t;

        public ResponseDeliveryRunnable(int i, int i2, String str, T t, IDataCallBack<T> iDataCallBack) {
            this.postCode = i;
            this.code = i2;
            this.message = str;
            this.callback = iDataCallBack;
            this.t = t;
        }

        public ResponseDeliveryRunnable(int i, T t, IDataCallBack<T> iDataCallBack) {
            this.postCode = i;
            this.callback = iDataCallBack;
            this.t = t;
        }

        public void run() {
            if (this.postCode == 0) {
                this.callback.onSuccess(this.t);
            } else if (this.postCode == 1) {
                this.callback.onError(this.code, this.message);
            }
        }
    }

    public ExecutorDelivery(Handler handler) {
    }

    public <T> void postError(int i, String str, IDataCallBack<T> iDataCallBack) {
        this.mResponsePoster.execute(new ResponseDeliveryRunnable(1, i, str, null, iDataCallBack));
    }

    public <T> void postSuccess(IDataCallBack<T> iDataCallBack, T t) {
        this.mResponsePoster.execute(new ResponseDeliveryRunnable(0, t, iDataCallBack));
    }
}
