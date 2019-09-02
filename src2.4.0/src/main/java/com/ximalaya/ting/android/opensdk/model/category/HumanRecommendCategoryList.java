package com.ximalaya.ting.android.opensdk.model.category;

import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;
import java.util.List;

public class HumanRecommendCategoryList extends XimalayaResponse {
    private List<HumanRecommendCategory> categories;

    public List<HumanRecommendCategory> getCategories() {
        return this.categories;
    }

    public void setCategories(List<HumanRecommendCategory> list) {
        this.categories = list;
    }
}
