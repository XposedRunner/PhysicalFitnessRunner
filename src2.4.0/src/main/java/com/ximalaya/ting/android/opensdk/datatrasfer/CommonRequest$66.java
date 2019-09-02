package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.Gson;
import com.ximalaya.ting.android.opensdk.model.PostResponse;

class CommonRequest$66 implements CommonRequest$IRequestCallBack<PostResponse> {
    CommonRequest$66() {
    }

    public PostResponse success(String str) throws Exception {
        return (PostResponse) new Gson().fromJson(str, PostResponse.class);
    }
}
