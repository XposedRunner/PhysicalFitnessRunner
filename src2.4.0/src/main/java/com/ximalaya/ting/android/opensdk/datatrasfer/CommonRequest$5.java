package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.category.Category;
import com.ximalaya.ting.android.opensdk.model.category.CategoryList;
import java.util.List;

class CommonRequest$5 implements CommonRequest$IRequestCallBack<CategoryList> {
    CommonRequest$5() {
    }

    public CategoryList success(String str) throws Exception {
        List list = (List) BaseResponse.getResponseBodyStringToObject(new TypeToken<List<Category>>() {
        }.getType(), str);
        CategoryList categoryList = new CategoryList();
        categoryList.setCategories(list);
        return categoryList;
    }
}
