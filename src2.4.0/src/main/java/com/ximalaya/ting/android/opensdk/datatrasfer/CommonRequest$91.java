package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.Gson;
import com.ximalaya.ting.android.opensdk.model.album.AlbumList;

class CommonRequest$91 implements CommonRequest$IRequestCallBack<AlbumList> {
    CommonRequest$91() {
    }

    public AlbumList success(String str) throws Exception {
        return (AlbumList) new Gson().fromJson(str, AlbumList.class);
    }
}
