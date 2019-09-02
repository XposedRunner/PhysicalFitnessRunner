package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.customized.CustomizedAlbumColumnDetail;

class CommonRequest$80 implements CommonRequest$IRequestCallBack<CustomizedAlbumColumnDetail> {
    CommonRequest$80() {
    }

    public CustomizedAlbumColumnDetail success(String str) throws Exception {
        return (CustomizedAlbumColumnDetail) BaseResponse.getResponseBodyStringToObject(new TypeToken<CustomizedAlbumColumnDetail>() {
        }.getType(), str);
    }
}
