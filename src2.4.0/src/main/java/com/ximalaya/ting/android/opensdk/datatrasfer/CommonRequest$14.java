package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.announcer.AnnouncerList;

class CommonRequest$14 implements CommonRequest$IRequestCallBack<AnnouncerList> {
    CommonRequest$14() {
    }

    public AnnouncerList success(String str) throws Exception {
        return (AnnouncerList) BaseResponse.getResponseBodyStringToObject(new TypeToken<AnnouncerList>() {
        }.getType(), str);
    }
}
