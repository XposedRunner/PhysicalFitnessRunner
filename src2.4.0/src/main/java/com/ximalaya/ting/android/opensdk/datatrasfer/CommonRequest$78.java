package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.customized.CustomizedAlbumList;

class CommonRequest$78 implements CommonRequest$IRequestCallBack<CustomizedAlbumList> {
    CommonRequest$78() {
    }

    public CustomizedAlbumList success(String str) throws Exception {
        return (CustomizedAlbumList) BaseResponse.getResponseBodyStringToObject(new TypeToken<CustomizedAlbumList>() {
        }.getType(), str);
    }
}
