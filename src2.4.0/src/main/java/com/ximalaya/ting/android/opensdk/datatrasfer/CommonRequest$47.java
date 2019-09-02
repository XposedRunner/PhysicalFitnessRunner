package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.album.Album;
import com.ximalaya.ting.android.opensdk.model.album.RecommendCollectAlbumList;
import java.util.List;

class CommonRequest$47 implements CommonRequest$IRequestCallBack<RecommendCollectAlbumList> {
    CommonRequest$47() {
    }

    public RecommendCollectAlbumList success(String str) throws Exception {
        List list = (List) BaseResponse.getResponseBodyStringToObject(new TypeToken<List<Album>>() {
        }.getType(), str);
        RecommendCollectAlbumList recommendCollectAlbumList = new RecommendCollectAlbumList();
        recommendCollectAlbumList.setAlbumList(list);
        return recommendCollectAlbumList;
    }
}
