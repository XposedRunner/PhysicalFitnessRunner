package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.search.SearchAll;

class CommonRequest$9 implements CommonRequest$IRequestCallBack<SearchAll> {
    CommonRequest$9() {
    }

    public SearchAll success(String str) throws Exception {
        return (SearchAll) BaseResponse.getResponseBodyStringToObject(new TypeToken<SearchAll>() {
        }.getType(), str);
    }
}
