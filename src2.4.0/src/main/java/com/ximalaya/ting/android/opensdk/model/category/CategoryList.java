package com.ximalaya.ting.android.opensdk.model.category;

import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;
import java.util.List;

public class CategoryList extends XimalayaResponse {
    private List<Category> categories;

    public List<Category> getCategories() {
        return this.categories;
    }

    public void setCategories(List<Category> list) {
        this.categories = list;
    }
}
