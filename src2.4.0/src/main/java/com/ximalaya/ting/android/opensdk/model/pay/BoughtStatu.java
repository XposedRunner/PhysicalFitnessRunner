package com.ximalaya.ting.android.opensdk.model.pay;

import com.google.gson.annotations.SerializedName;
import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;

public class BoughtStatu extends XimalayaResponse {
    @SerializedName("has_bought")
    private boolean hasBought;
    private int id;

    public int getId() {
        return this.id;
    }

    public boolean isHasBought() {
        return this.hasBought;
    }

    public void setHasBought(boolean z) {
        this.hasBought = z;
    }

    public void setId(int i) {
        this.id = i;
    }
}
