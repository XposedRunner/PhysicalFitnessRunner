package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.column.ColumnList;

class CommonRequest$30 implements CommonRequest$IRequestCallBack<ColumnList> {
    CommonRequest$30() {
    }

    public ColumnList success(String str) throws Exception {
        return (ColumnList) BaseResponse.getResponseBodyStringToObject(new TypeToken<ColumnList>() {
        }.getType(), str);
    }
}
