package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.coldboot.ColdBootDetail;

class CommonRequest$65 implements CommonRequest$IRequestCallBack<ColdBootDetail> {
    CommonRequest$65() {
    }

    public ColdBootDetail success(String str) throws Exception {
        return (ColdBootDetail) BaseResponse.getResponseBodyStringToObject(new TypeToken<ColdBootDetail>() {
        }.getType(), str);
    }
}
