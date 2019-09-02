package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.pay.PayInfo;

class CommonRequest$105 implements CommonRequest$IRequestCallBack<PayInfo> {
    CommonRequest$105() {
    }

    public PayInfo success(String str) throws Exception {
        return (PayInfo) BaseResponse.getResponseBodyStringToObject(new TypeToken<PayInfo>() {
        }.getType(), str);
    }
}
