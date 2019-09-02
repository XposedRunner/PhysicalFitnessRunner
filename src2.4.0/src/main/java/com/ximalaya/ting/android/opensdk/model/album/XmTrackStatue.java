package com.ximalaya.ting.android.opensdk.model.album;

import com.google.gson.annotations.SerializedName;

public class XmTrackStatue {
    @SerializedName("has_bought")
    private boolean hasBought;
    private int id;
    @SerializedName("is_paid")
    private boolean isPaid;

    public int getId() {
        return this.id;
    }

    public boolean isHasBought() {
        return this.hasBought;
    }

    public boolean isPaid() {
        return this.isPaid;
    }

    public void setHasBought(boolean z) {
        this.hasBought = z;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setPaid(boolean z) {
        this.isPaid = z;
    }
}
