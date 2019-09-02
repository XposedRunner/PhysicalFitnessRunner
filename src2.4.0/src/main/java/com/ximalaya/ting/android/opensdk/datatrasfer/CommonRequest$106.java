package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.customized.ColumnItems;

class CommonRequest$106 implements CommonRequest$IRequestCallBack<ColumnItems> {
    CommonRequest$106() {
    }

    public ColumnItems success(String str) throws Exception {
        return (ColumnItems) BaseResponse.getResponseBodyStringToObject(new TypeToken<ColumnItems>() {
        }.getType(), str);
    }
}
