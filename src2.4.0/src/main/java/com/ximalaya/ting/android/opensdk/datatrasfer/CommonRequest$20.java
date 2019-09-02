package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.constants.DTransferConstants;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.track.LastPlayTrackList;
import java.util.Map;

class CommonRequest$20 implements CommonRequest$IRequestCallBack<LastPlayTrackList> {
    final /* synthetic */ Map val$params;

    CommonRequest$20(Map map) {
        this.val$params = map;
    }

    public LastPlayTrackList success(String str) throws Exception {
        LastPlayTrackList lastPlayTrackList = (LastPlayTrackList) BaseResponse.getResponseBodyStringToObject(new TypeToken<LastPlayTrackList>() {
        }.getType(), str);
        this.val$params.put(DTransferConstants.PAGE, String.valueOf(lastPlayTrackList.getPageid()));
        this.val$params.put(DTransferConstants.PRE_PAGE, String.valueOf(lastPlayTrackList.getPageid() - 1));
        this.val$params.put(DTransferConstants.TOTAL_PAGE, String.valueOf(lastPlayTrackList.getTotalPage()));
        lastPlayTrackList.setParams(this.val$params);
        return lastPlayTrackList;
    }
}
