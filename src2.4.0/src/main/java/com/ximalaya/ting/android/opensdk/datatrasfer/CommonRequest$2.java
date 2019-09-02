package com.ximalaya.ting.android.opensdk.datatrasfer;

import android.text.TextUtils;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.httputil.IHttpCallBack;
import com.ximalaya.ting.android.opensdk.httputil.XimalayaException;
import okhttp3.Response;

class CommonRequest$2 implements IHttpCallBack {
    final /* synthetic */ IDataCallBack val$callback;
    final /* synthetic */ CommonRequest$IRequestCallBack val$successCallBack;

    CommonRequest$2(CommonRequest$IRequestCallBack commonRequest$IRequestCallBack, IDataCallBack iDataCallBack) {
        this.val$successCallBack = commonRequest$IRequestCallBack;
        this.val$callback = iDataCallBack;
    }

    public void onFailure(int i, String str) {
        CommonRequest.delivery.postError(i, str, this.val$callback);
    }

    public void onResponse(Response response) {
        try {
            String responseBodyToString = new BaseResponse(response).getResponseBodyToString();
            if (this.val$successCallBack != null) {
                CommonRequest.delivery.postSuccess(this.val$callback, this.val$successCallBack.success(responseBodyToString));
            } else {
                CommonRequest.delivery.postSuccess(this.val$callback, null);
            }
        } catch (Exception e) {
            if (e == null || TextUtils.isEmpty(e.getMessage())) {
                CommonRequest.delivery.postError(XimalayaException.PARSE_JSON_ERROR, "parse response json data error", this.val$callback);
            } else {
                CommonRequest.delivery.postError(XimalayaException.PARSE_JSON_ERROR, e.getMessage(), this.val$callback);
            }
        }
    }
}
