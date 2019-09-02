package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.album.DiscoveryRecommendAlbums;
import com.ximalaya.ting.android.opensdk.model.album.DiscoveryRecommendAlbumsList;
import java.util.List;

class CommonRequest$71 implements CommonRequest$IRequestCallBack<DiscoveryRecommendAlbumsList> {
    CommonRequest$71() {
    }

    public DiscoveryRecommendAlbumsList success(String str) throws Exception {
        List list = (List) BaseResponse.getResponseBodyStringToObject(new TypeToken<List<DiscoveryRecommendAlbums>>() {
        }.getType(), str);
        DiscoveryRecommendAlbumsList discoveryRecommendAlbumsList = new DiscoveryRecommendAlbumsList();
        discoveryRecommendAlbumsList.setDiscoveryRecommendAlbumses(list);
        return discoveryRecommendAlbumsList;
    }
}
