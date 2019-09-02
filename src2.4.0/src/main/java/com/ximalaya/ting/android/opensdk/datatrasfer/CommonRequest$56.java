package com.ximalaya.ting.android.opensdk.datatrasfer;

import android.text.TextUtils;
import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.httputil.IHttpCallBack;
import com.ximalaya.ting.android.opensdk.httputil.XimalayaException;
import com.ximalaya.ting.android.opensdk.model.advertis.AdvertisList;
import com.ximalaya.ting.android.opensdk.util.Logger;
import java.lang.reflect.Type;
import okhttp3.Response;

class CommonRequest$56 implements IHttpCallBack {
    final /* synthetic */ IDataCallBack val$callback;

    CommonRequest$56(IDataCallBack iDataCallBack) {
        this.val$callback = iDataCallBack;
    }

    public void onFailure(int i, String str) {
        CommonRequest.delivery.postError(i, str, this.val$callback);
    }

    public void onResponse(Response response) {
        Exception e;
        BaseResponse baseResponse = new BaseResponse(response);
        String str = "";
        Type type = new TypeToken<AdvertisList>() {
        }.getType();
        if (baseResponse.getStatusCode() == 200) {
            String responseBodyToString;
            try {
                responseBodyToString = baseResponse.getResponseBodyToString();
                try {
                    CommonRequest.delivery.postSuccess(this.val$callback, (AdvertisList) BaseResponse.getResponseBodyStringToObject(type, responseBodyToString));
                    return;
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Exception e3) {
                Exception exception = e3;
                responseBodyToString = str;
                e = exception;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("response json str:");
                stringBuilder.append(responseBodyToString);
                Logger.d("XIMALAYASDK", stringBuilder.toString());
                if (e == null || TextUtils.isEmpty(e.getMessage())) {
                    CommonRequest.delivery.postError(XimalayaException.PARSE_JSON_ERROR, "parse response json data error", this.val$callback);
                    return;
                } else {
                    CommonRequest.delivery.postError(XimalayaException.PARSE_JSON_ERROR, e.getMessage(), this.val$callback);
                    return;
                }
            }
        }
        CommonRequest.delivery.postError(baseResponse.getStatusCode(), baseResponse.getStatusMessage(), this.val$callback);
    }
}
