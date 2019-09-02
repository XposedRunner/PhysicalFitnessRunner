package com.ximalaya.ting.android.opensdk.model.album;

import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;
import java.util.List;

public class HotAggregationList extends XimalayaResponse {
    private List<HotAggregation> list;

    public List<HotAggregation> getList() {
        return this.list;
    }

    public void setList(List<HotAggregation> list) {
        this.list = list;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("HotAggregationList [list=");
        stringBuilder.append(this.list);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
