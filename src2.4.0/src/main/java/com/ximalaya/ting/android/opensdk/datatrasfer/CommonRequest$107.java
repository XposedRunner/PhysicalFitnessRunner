package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.customized.CustomizedSearchList;

class CommonRequest$107 implements CommonRequest$IRequestCallBack<CustomizedSearchList> {
    CommonRequest$107() {
    }

    public CustomizedSearchList success(String str) throws Exception {
        return (CustomizedSearchList) BaseResponse.getResponseBodyStringToObject(new TypeToken<CustomizedSearchList>() {
        }.getType(), str);
    }
}
