package com.ximalaya.ting.android.opensdk.model.coldboot;

import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;
import java.util.List;

public class SubGenreList extends XimalayaResponse {
    private List<String> subgenreList;

    public List<String> getSubgenreList() {
        return this.subgenreList;
    }

    public void setSubgenreList(List<String> list) {
        this.subgenreList = list;
    }
}
