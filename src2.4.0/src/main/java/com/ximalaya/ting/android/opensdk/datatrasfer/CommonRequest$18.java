package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.constants.DTransferConstants;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.track.TrackHotList;
import java.util.Map;

class CommonRequest$18 implements CommonRequest$IRequestCallBack<TrackHotList> {
    final /* synthetic */ Map val$params;

    CommonRequest$18(Map map) {
        this.val$params = map;
    }

    public TrackHotList success(String str) throws Exception {
        TrackHotList trackHotList = (TrackHotList) BaseResponse.getResponseBodyStringToObject(new TypeToken<TrackHotList>() {
        }.getType(), str);
        this.val$params.put(DTransferConstants.TOTAL_PAGE, String.valueOf(trackHotList.getTotalPage()));
        trackHotList.setParams(this.val$params);
        return trackHotList;
    }
}
