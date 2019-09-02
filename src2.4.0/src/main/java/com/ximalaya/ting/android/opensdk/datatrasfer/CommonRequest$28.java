package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.banner.Banner;
import com.ximalaya.ting.android.opensdk.model.banner.RankBannerList;
import java.util.List;

class CommonRequest$28 implements CommonRequest$IRequestCallBack<RankBannerList> {
    CommonRequest$28() {
    }

    public RankBannerList success(String str) throws Exception {
        List list = (List) BaseResponse.getResponseBodyStringToObject(new TypeToken<List<Banner>>() {
        }.getType(), str);
        RankBannerList rankBannerList = new RankBannerList();
        rankBannerList.setBannerList(list);
        return rankBannerList;
    }
}
