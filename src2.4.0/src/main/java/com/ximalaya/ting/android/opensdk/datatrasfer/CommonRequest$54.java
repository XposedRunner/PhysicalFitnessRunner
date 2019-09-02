package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.announcer.AnnouncerCategory;
import com.ximalaya.ting.android.opensdk.model.announcer.AnnouncerCategoryList;
import java.util.List;

class CommonRequest$54 implements CommonRequest$IRequestCallBack<AnnouncerCategoryList> {
    CommonRequest$54() {
    }

    public AnnouncerCategoryList success(String str) throws Exception {
        List list = (List) BaseResponse.getResponseBodyStringToObject(new TypeToken<List<AnnouncerCategory>>() {
        }.getType(), str);
        AnnouncerCategoryList announcerCategoryList = new AnnouncerCategoryList();
        announcerCategoryList.setList(list);
        return announcerCategoryList;
    }
}
