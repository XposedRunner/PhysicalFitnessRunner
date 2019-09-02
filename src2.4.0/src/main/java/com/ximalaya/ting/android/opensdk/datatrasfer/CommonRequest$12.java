package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.pay.ObfuscatePlayInfo;

class CommonRequest$12 implements CommonRequest$IRequestCallBack<ObfuscatePlayInfo> {
    CommonRequest$12() {
    }

    public ObfuscatePlayInfo success(String str) throws Exception {
        return (ObfuscatePlayInfo) BaseResponse.getResponseBodyStringToObject(new TypeToken<ObfuscatePlayInfo>() {
        }.getType(), str);
    }
}
