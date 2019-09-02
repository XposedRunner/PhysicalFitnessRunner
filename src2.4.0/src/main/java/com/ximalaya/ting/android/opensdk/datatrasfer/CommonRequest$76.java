package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.live.radio.RadioListByCategory;

class CommonRequest$76 implements CommonRequest$IRequestCallBack<RadioListByCategory> {
    CommonRequest$76() {
    }

    public RadioListByCategory success(String str) throws Exception {
        return (RadioListByCategory) BaseResponse.getResponseBodyStringToObject(new TypeToken<RadioListByCategory>() {
        }.getType(), str);
    }
}
