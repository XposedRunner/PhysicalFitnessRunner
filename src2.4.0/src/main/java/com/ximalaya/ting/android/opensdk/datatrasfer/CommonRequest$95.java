package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.model.album.Album;
import com.ximalaya.ting.android.opensdk.model.album.BatchAlbumList;
import java.lang.reflect.Type;
import java.util.List;

class CommonRequest$95 implements CommonRequest$IRequestCallBack<BatchAlbumList> {
    CommonRequest$95() {
    }

    public BatchAlbumList success(String str) throws Exception {
        Type type = new TypeToken<List<Album>>() {
        }.getType();
        Gson gson = new Gson();
        BatchAlbumList batchAlbumList = new BatchAlbumList();
        batchAlbumList.setAlbums((List) gson.fromJson(str, type));
        return batchAlbumList;
    }
}
