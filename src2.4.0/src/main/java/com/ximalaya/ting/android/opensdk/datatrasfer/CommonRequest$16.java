package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.album.Album;
import com.ximalaya.ting.android.opensdk.model.album.BatchAlbumList;
import java.util.List;

class CommonRequest$16 implements CommonRequest$IRequestCallBack<BatchAlbumList> {
    CommonRequest$16() {
    }

    public BatchAlbumList success(String str) throws Exception {
        List list = (List) BaseResponse.getResponseBodyStringToObject(new TypeToken<List<Album>>() {
        }.getType(), str);
        BatchAlbumList batchAlbumList = new BatchAlbumList();
        batchAlbumList.setAlbums(list);
        return batchAlbumList;
    }
}
