package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.album.SubscribeAlbumList;

class CommonRequest$88 implements CommonRequest$IRequestCallBack<SubscribeAlbumList> {
    CommonRequest$88() {
    }

    public SubscribeAlbumList success(String str) throws Exception {
        return (SubscribeAlbumList) BaseResponse.getResponseBodyStringToObject(new TypeToken<SubscribeAlbumList>() {
        }.getType(), str);
    }
}
