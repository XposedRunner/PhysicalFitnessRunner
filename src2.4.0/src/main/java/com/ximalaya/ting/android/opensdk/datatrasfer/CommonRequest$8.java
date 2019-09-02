package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.constants.DTransferConstants;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.track.SearchTrackList;
import java.util.Map;

class CommonRequest$8 implements CommonRequest$IRequestCallBack<SearchTrackList> {
    final /* synthetic */ Map val$params;

    CommonRequest$8(Map map) {
        this.val$params = map;
    }

    public SearchTrackList success(String str) throws Exception {
        SearchTrackList searchTrackList = (SearchTrackList) BaseResponse.getResponseBodyStringToObject(new TypeToken<SearchTrackList>() {
        }.getType(), str);
        this.val$params.put(DTransferConstants.TOTAL_PAGE, String.valueOf(searchTrackList.getTotalPage()));
        searchTrackList.setParams(this.val$params);
        return searchTrackList;
    }
}
