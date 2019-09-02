package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.track.TrackIdList;

class CommonRequest$23 implements CommonRequest$IRequestCallBack<TrackIdList> {
    CommonRequest$23() {
    }

    public TrackIdList success(String str) throws Exception {
        return (TrackIdList) BaseResponse.getResponseBodyStringToObject(new TypeToken<TrackIdList>() {
        }.getType(), str);
    }
}
