package com.ximalaya.ting.android.opensdk.model.live.provinces;

import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;
import java.util.List;

public class ProvinceList extends XimalayaResponse {
    private List<Province> provinceList;

    public List<Province> getProvinceList() {
        return this.provinceList;
    }

    public void setProvinceList(List<Province> list) {
        this.provinceList = list;
    }
}
