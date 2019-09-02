package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.user.XmBaseUserInfo;

class CommonRequest$109 implements CommonRequest$IRequestCallBack<XmBaseUserInfo> {
    CommonRequest$109() {
    }

    public XmBaseUserInfo success(String str) throws Exception {
        return (XmBaseUserInfo) BaseResponse.getResponseBodyStringToObject(new TypeToken<XmBaseUserInfo>() {
        }.getType(), str);
    }
}
