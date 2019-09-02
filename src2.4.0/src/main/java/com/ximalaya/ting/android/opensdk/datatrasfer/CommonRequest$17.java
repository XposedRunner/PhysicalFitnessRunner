package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.track.BatchTrackList;

class CommonRequest$17 implements CommonRequest$IRequestCallBack<BatchTrackList> {
    CommonRequest$17() {
    }

    public BatchTrackList success(String str) throws Exception {
        return (BatchTrackList) BaseResponse.getResponseBodyStringToObject(new TypeToken<BatchTrackList>() {
        }.getType(), str);
    }
}
