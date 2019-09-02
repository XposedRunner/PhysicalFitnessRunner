package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.album.Album;
import com.ximalaya.ting.android.opensdk.model.album.GussLikeAlbumList;
import java.util.List;

class CommonRequest$29 implements CommonRequest$IRequestCallBack<GussLikeAlbumList> {
    CommonRequest$29() {
    }

    public GussLikeAlbumList success(String str) throws Exception {
        List list = (List) BaseResponse.getResponseBodyStringToObject(new TypeToken<List<Album>>() {
        }.getType(), str);
        GussLikeAlbumList gussLikeAlbumList = new GussLikeAlbumList();
        gussLikeAlbumList.setAlbumList(list);
        return gussLikeAlbumList;
    }
}
