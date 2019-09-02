package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.banner.Banner;
import com.ximalaya.ting.android.opensdk.model.banner.DiscoveryBannerList;
import java.util.List;

class CommonRequest$26 implements CommonRequest$IRequestCallBack<DiscoveryBannerList> {
    CommonRequest$26() {
    }

    public DiscoveryBannerList success(String str) throws Exception {
        List list = (List) BaseResponse.getResponseBodyStringToObject(new TypeToken<List<Banner>>() {
        }.getType(), str);
        DiscoveryBannerList discoveryBannerList = new DiscoveryBannerList();
        discoveryBannerList.setBannerList(list);
        return discoveryBannerList;
    }
}
