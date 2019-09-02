package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.live.radio.RadioList;

class CommonRequest$44 implements CommonRequest$IRequestCallBack<RadioList> {
    CommonRequest$44() {
    }

    public RadioList success(String str) throws Exception {
        return (RadioList) BaseResponse.getResponseBodyStringToObject(new TypeToken<RadioList>() {
        }.getType(), str);
    }
}
