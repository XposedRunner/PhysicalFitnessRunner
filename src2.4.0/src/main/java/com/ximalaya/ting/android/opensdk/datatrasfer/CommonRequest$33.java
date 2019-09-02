package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.ranks.RankAlbumList;

class CommonRequest$33 implements CommonRequest$IRequestCallBack<RankAlbumList> {
    CommonRequest$33() {
    }

    public RankAlbumList success(String str) throws Exception {
        return (RankAlbumList) BaseResponse.getResponseBodyStringToObject(new TypeToken<RankAlbumList>() {
        }.getType(), str);
    }
}
