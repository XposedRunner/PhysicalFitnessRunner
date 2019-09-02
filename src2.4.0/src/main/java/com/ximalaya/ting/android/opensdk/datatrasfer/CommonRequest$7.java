package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.album.SearchAlbumList;

class CommonRequest$7 implements CommonRequest$IRequestCallBack<SearchAlbumList> {
    CommonRequest$7() {
    }

    public SearchAlbumList success(String str) throws Exception {
        return (SearchAlbumList) BaseResponse.getResponseBodyStringToObject(new TypeToken<SearchAlbumList>() {
        }.getType(), str);
    }
}
