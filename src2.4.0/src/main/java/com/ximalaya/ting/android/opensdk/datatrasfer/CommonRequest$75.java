package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.live.radio.RadioCategory;
import com.ximalaya.ting.android.opensdk.model.live.radio.RadioCategoryList;
import java.util.List;

class CommonRequest$75 implements CommonRequest$IRequestCallBack<RadioCategoryList> {
    CommonRequest$75() {
    }

    public RadioCategoryList success(String str) throws Exception {
        List list = (List) BaseResponse.getResponseBodyStringToObject(new TypeToken<List<RadioCategory>>() {
        }.getType(), str);
        RadioCategoryList radioCategoryList = new RadioCategoryList();
        radioCategoryList.setRadioCategories(list);
        return radioCategoryList;
    }
}
