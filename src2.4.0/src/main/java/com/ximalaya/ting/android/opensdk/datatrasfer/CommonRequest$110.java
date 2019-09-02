package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.user.XmUserInfo;

class CommonRequest$110 implements CommonRequest$IRequestCallBack<XmUserInfo> {
    CommonRequest$110() {
    }

    public XmUserInfo success(String str) throws Exception {
        return (XmUserInfo) BaseResponse.getResponseBodyStringToObject(new TypeToken<XmUserInfo>() {
        }.getType(), str);
    }
}
