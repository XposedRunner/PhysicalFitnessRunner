package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.ranks.RankTrackList;

class CommonRequest$34 implements CommonRequest$IRequestCallBack<RankTrackList> {
    CommonRequest$34() {
    }

    public RankTrackList success(String str) throws Exception {
        return (RankTrackList) BaseResponse.getResponseBodyStringToObject(new TypeToken<RankTrackList>() {
        }.getType(), str);
    }
}
