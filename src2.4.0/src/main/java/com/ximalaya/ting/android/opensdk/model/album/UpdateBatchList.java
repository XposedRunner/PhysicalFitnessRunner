package com.ximalaya.ting.android.opensdk.model.album;

import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;
import java.util.List;

public class UpdateBatchList extends XimalayaResponse {
    private List<UpdateBatch> list;

    public List<UpdateBatch> getList() {
        return this.list;
    }

    public void setList(List<UpdateBatch> list) {
        this.list = list;
    }
}
