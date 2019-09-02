package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.banner.BannerV2;
import com.ximalaya.ting.android.opensdk.model.banner.BannerV2List;
import java.util.List;

class CommonRequest$114 implements CommonRequest$IRequestCallBack<BannerV2List> {
    CommonRequest$114() {
    }

    public BannerV2List success(String str) throws Exception {
        List list = (List) BaseResponse.getResponseBodyStringToObject(new TypeToken<List<BannerV2>>() {
        }.getType(), str);
        BannerV2List bannerV2List = new BannerV2List();
        bannerV2List.setBannerV2s(list);
        return bannerV2List;
    }
}
