package com.ximalaya.ting.android.opensdk.model;

import com.google.gson.annotations.SerializedName;
import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;

public class SercretPubKey extends XimalayaResponse {
    @SerializedName("expired_time")
    private int expiredTime;
    @SerializedName("is_fallback")
    private boolean isFallBack;
    @SerializedName("s_pub_key")
    private String pubKey;

    public int getExpiredTime() {
        return this.expiredTime;
    }

    public String getPubKey() {
        return this.pubKey;
    }

    public boolean isFallBack() {
        return this.isFallBack;
    }

    public void setExpiredTime(int i) {
        this.expiredTime = i;
    }

    public void setFallBack(boolean z) {
        this.isFallBack = z;
    }

    public void setPubKey(String str) {
        this.pubKey = str;
    }
}
