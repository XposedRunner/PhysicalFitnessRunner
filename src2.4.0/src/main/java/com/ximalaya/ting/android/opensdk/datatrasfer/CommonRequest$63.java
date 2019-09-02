package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.coldboot.ColdBootTag;

class CommonRequest$63 implements CommonRequest$IRequestCallBack<ColdBootTag> {
    CommonRequest$63() {
    }

    public ColdBootTag success(String str) throws Exception {
        return (ColdBootTag) BaseResponse.getResponseBodyStringToObject(new TypeToken<ColdBootTag>() {
        }.getType(), str);
    }
}
