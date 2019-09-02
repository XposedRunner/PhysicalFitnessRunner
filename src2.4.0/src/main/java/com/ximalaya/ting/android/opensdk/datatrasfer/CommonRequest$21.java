package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.constants.DTransferConstants;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.track.TrackList;
import java.util.Map;

class CommonRequest$21 implements CommonRequest$IRequestCallBack<TrackList> {
    final /* synthetic */ Map val$params;

    CommonRequest$21(Map map) {
        this.val$params = map;
    }

    public TrackList success(String str) throws Exception {
        TrackList trackList = (TrackList) BaseResponse.getResponseBodyStringToObject(new TypeToken<TrackList>() {
        }.getType(), str);
        this.val$params.put(DTransferConstants.TOTAL_PAGE, String.valueOf(trackList.getTotalPage()));
        trackList.setParams(this.val$params);
        return trackList;
    }
}
