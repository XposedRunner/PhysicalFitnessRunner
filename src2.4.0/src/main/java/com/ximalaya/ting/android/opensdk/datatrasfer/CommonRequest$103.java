package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.album.AlbumList;

class CommonRequest$103 implements CommonRequest$IRequestCallBack<AlbumList> {
    CommonRequest$103() {
    }

    public AlbumList success(String str) throws Exception {
        return (AlbumList) BaseResponse.getResponseBodyStringToObject(new TypeToken<AlbumList>() {
        }.getType(), str);
    }
}
