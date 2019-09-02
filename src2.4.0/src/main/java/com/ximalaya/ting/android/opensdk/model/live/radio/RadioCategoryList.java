package com.ximalaya.ting.android.opensdk.model.live.radio;

import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;
import java.util.List;

public class RadioCategoryList extends XimalayaResponse {
    private List<RadioCategory> radioCategories;

    public List<RadioCategory> getRadioCategories() {
        return this.radioCategories;
    }

    public void setRadioCategories(List<RadioCategory> list) {
        this.radioCategories = list;
    }
}
