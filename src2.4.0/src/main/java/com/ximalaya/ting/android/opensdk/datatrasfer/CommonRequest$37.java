package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.album.Album;
import com.ximalaya.ting.android.opensdk.model.album.RelativeAlbums;
import java.util.List;

class CommonRequest$37 implements CommonRequest$IRequestCallBack<RelativeAlbums> {
    CommonRequest$37() {
    }

    public RelativeAlbums success(String str) throws Exception {
        List list = (List) BaseResponse.getResponseBodyStringToObject(new TypeToken<List<Album>>() {
        }.getType(), str);
        RelativeAlbums relativeAlbums = new RelativeAlbums();
        relativeAlbums.setRelativeAlbumList(list);
        if (list != null) {
            relativeAlbums.setCurrentPage(1);
            relativeAlbums.setTotalPage(1);
            relativeAlbums.setTotalCount(list.size());
        }
        return relativeAlbums;
    }
}
