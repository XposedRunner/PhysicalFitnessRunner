package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.album.Album;
import com.ximalaya.ting.android.opensdk.model.album.AlbumList;
import java.util.List;

class CommonRequest$100 implements CommonRequest$IRequestCallBack<AlbumList> {
    CommonRequest$100() {
    }

    public AlbumList success(String str) throws Exception {
        List list = (List) BaseResponse.getResponseBodyStringToObject(new TypeToken<List<Album>>() {
        }.getType(), str);
        AlbumList albumList = new AlbumList();
        albumList.setAlbums(list);
        return albumList;
    }
}
