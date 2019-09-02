package com.ximalaya.ting.android.opensdk.model.announcer;

import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;
import java.util.ArrayList;
import java.util.List;

public class AnnouncerCategoryList extends XimalayaResponse {
    List<AnnouncerCategory> list = new ArrayList();

    public List<AnnouncerCategory> getList() {
        return this.list;
    }

    public void setList(List<AnnouncerCategory> list) {
        this.list = list;
    }
}
