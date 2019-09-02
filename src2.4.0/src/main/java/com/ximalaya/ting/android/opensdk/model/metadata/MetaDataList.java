package com.ximalaya.ting.android.opensdk.model.metadata;

import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;
import java.util.List;

public class MetaDataList extends XimalayaResponse {
    private List<MetaData> metaDatas;

    public List<MetaData> getMetaDatas() {
        return this.metaDatas;
    }

    public void setMetaDatas(List<MetaData> list) {
        this.metaDatas = list;
    }
}
