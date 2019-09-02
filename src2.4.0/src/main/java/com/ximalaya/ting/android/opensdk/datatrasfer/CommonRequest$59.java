package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.ximalaya.ting.android.opensdk.httputil.IHttpCallBack;
import okhttp3.Response;

class CommonRequest$59 implements IHttpCallBack {
    final /* synthetic */ IDataCallBack val$dataCallBack;

    CommonRequest$59(IDataCallBack iDataCallBack) {
        this.val$dataCallBack = iDataCallBack;
    }

    public void onFailure(int i, String str) {
        if (this.val$dataCallBack != null) {
            this.val$dataCallBack.onError(i, str);
        }
    }

    public void onResponse(Response response) {
        if (this.val$dataCallBack != null) {
            this.val$dataCallBack.onSuccess(null);
        }
    }
}
