package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.banner.Banner;
import com.ximalaya.ting.android.opensdk.model.banner.CategoryBannerList;
import java.util.List;

class CommonRequest$27 implements CommonRequest$IRequestCallBack<CategoryBannerList> {
    CommonRequest$27() {
    }

    public CategoryBannerList success(String str) throws Exception {
        List list = (List) BaseResponse.getResponseBodyStringToObject(new TypeToken<List<Banner>>() {
        }.getType(), str);
        CategoryBannerList categoryBannerList = new CategoryBannerList();
        categoryBannerList.setBannerList(list);
        return categoryBannerList;
    }
}
