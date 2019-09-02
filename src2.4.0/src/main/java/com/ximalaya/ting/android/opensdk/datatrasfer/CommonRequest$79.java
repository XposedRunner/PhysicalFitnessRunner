package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.customized.CustomizedTrackList;

class CommonRequest$79 implements CommonRequest$IRequestCallBack<CustomizedTrackList> {
    CommonRequest$79() {
    }

    public CustomizedTrackList success(String str) throws Exception {
        return (CustomizedTrackList) BaseResponse.getResponseBodyStringToObject(new TypeToken<CustomizedTrackList>() {
        }.getType(), str);
    }
}
