package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.word.SuggestWords;

class CommonRequest$25 implements CommonRequest$IRequestCallBack<SuggestWords> {
    CommonRequest$25() {
    }

    public SuggestWords success(String str) throws Exception {
        return (SuggestWords) BaseResponse.getResponseBodyStringToObject(new TypeToken<SuggestWords>() {
        }.getType(), str);
    }
}
