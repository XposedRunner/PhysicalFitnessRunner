package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.track.BatchTrackList;
import com.ximalaya.ting.android.opensdk.model.track.Track;
import java.util.List;

class CommonRequest$96 implements CommonRequest$IRequestCallBack<BatchTrackList> {
    CommonRequest$96() {
    }

    public BatchTrackList success(String str) throws Exception {
        List list = (List) BaseResponse.getResponseBodyStringToObject(new TypeToken<List<Track>>() {
        }.getType(), str);
        BatchTrackList batchTrackList = new BatchTrackList();
        batchTrackList.setTracks(list);
        return batchTrackList;
    }
}
