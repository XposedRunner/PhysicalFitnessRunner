package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.track.CommonTrackList;
import com.ximalaya.ting.android.opensdk.model.track.Track;

class CommonRequest$70 implements CommonRequest$IRequestCallBack<CommonTrackList> {
    CommonRequest$70() {
    }

    public CommonTrackList success(String str) throws Exception {
        return (CommonTrackList) BaseResponse.getResponseBodyStringToObject(new TypeToken<CommonTrackList<Track>>() {
        }.getType(), str);
    }
}
