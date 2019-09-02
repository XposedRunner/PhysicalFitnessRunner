package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.live.radio.RadioListById;

class CommonRequest$48 implements CommonRequest$IRequestCallBack<RadioListById> {
    CommonRequest$48() {
    }

    public RadioListById success(String str) throws Exception {
        return (RadioListById) BaseResponse.getResponseBodyStringToObject(new TypeToken<RadioListById>() {
        }.getType(), str);
    }
}
