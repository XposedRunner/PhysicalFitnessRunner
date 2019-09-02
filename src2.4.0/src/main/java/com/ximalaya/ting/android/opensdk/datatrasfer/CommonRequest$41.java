package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.download.RecommendDownload;

class CommonRequest$41 implements CommonRequest$IRequestCallBack<RecommendDownload> {
    CommonRequest$41() {
    }

    public RecommendDownload success(String str) throws Exception {
        return (RecommendDownload) BaseResponse.getResponseBodyStringToObject(new TypeToken<RecommendDownload>() {
        }.getType(), str);
    }
}
