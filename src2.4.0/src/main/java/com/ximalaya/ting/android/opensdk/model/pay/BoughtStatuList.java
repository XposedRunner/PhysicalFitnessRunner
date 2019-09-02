package com.ximalaya.ting.android.opensdk.model.pay;

import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;
import java.util.List;

public class BoughtStatuList extends XimalayaResponse {
    private List<BoughtStatu> mBoughtStatus;

    public List<BoughtStatu> getBoughtStatus() {
        return this.mBoughtStatus;
    }

    public void setBoughtStatus(List<BoughtStatu> list) {
        this.mBoughtStatus = list;
    }
}
