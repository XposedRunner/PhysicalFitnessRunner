package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.customized.CustomizedTrackColumnDetail;

class CommonRequest$81 implements CommonRequest$IRequestCallBack<CustomizedTrackColumnDetail> {
    CommonRequest$81() {
    }

    public CustomizedTrackColumnDetail success(String str) throws Exception {
        return (CustomizedTrackColumnDetail) BaseResponse.getResponseBodyStringToObject(new TypeToken<CustomizedTrackColumnDetail>() {
        }.getType(), str);
    }
}
