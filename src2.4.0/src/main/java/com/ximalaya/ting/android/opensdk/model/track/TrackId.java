package com.ximalaya.ting.android.opensdk.model.track;

import com.google.gson.annotations.SerializedName;

public class TrackId {
    @SerializedName("has_bought")
    private boolean mHasBought;
    @SerializedName("id")
    private long mId;
    @SerializedName("is_paid")
    private boolean mIsPaid;

    public long getId() {
        return this.mId;
    }

    public boolean hasBought() {
        return this.mHasBought;
    }

    public boolean isPaid() {
        return this.mIsPaid;
    }
}
