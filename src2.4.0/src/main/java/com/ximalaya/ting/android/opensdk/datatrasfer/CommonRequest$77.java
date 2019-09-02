package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.constants.DTransferConstants;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.track.AnnouncerTrackList;
import java.util.Map;

class CommonRequest$77 implements CommonRequest$IRequestCallBack<AnnouncerTrackList> {
    final /* synthetic */ Map val$params;

    CommonRequest$77(Map map) {
        this.val$params = map;
    }

    public AnnouncerTrackList success(String str) throws Exception {
        AnnouncerTrackList announcerTrackList = (AnnouncerTrackList) BaseResponse.getResponseBodyStringToObject(new TypeToken<AnnouncerTrackList>() {
        }.getType(), str);
        try {
            this.val$params.put(DTransferConstants.PAGE, String.valueOf(announcerTrackList.getCurrentPage()));
            this.val$params.put(DTransferConstants.PRE_PAGE, String.valueOf(announcerTrackList.getCurrentPage() - 1));
            this.val$params.put(DTransferConstants.TOTAL_PAGE, String.valueOf(announcerTrackList.getTotalPage()));
            announcerTrackList.setParams(this.val$params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return announcerTrackList;
    }
}
