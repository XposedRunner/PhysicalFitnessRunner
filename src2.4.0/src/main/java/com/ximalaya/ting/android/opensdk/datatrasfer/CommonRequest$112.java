package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.pay.PayOderStatue;

class CommonRequest$112 implements CommonRequest$IRequestCallBack<PayOderStatue> {
    CommonRequest$112() {
    }

    public PayOderStatue success(String str) throws Exception {
        return (PayOderStatue) BaseResponse.getResponseBodyStringToObject(new TypeToken<PayOderStatue>() {
        }.getType(), str);
    }
}
