package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.album.XmAlbumTracksStatue;

class CommonRequest$111 implements CommonRequest$IRequestCallBack<XmAlbumTracksStatue> {
    CommonRequest$111() {
    }

    public XmAlbumTracksStatue success(String str) throws Exception {
        return (XmAlbumTracksStatue) BaseResponse.getResponseBodyStringToObject(new TypeToken<XmAlbumTracksStatue>() {
        }.getType(), str);
    }
}
