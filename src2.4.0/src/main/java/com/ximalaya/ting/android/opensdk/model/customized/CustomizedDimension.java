package com.ximalaya.ting.android.opensdk.model.customized;

import com.google.gson.annotations.SerializedName;

public class CustomizedDimension {
    @SerializedName("dim_id")
    private int dimId;
    @SerializedName("dim_name")
    private String dimName;
    @SerializedName("dim_value")
    private String dimValue;

    public int getDimId() {
        return this.dimId;
    }

    public String getDimName() {
        return this.dimName;
    }

    public String getDimValue() {
        return this.dimValue;
    }

    public void setDimId(int i) {
        this.dimId = i;
    }

    public void setDimName(String str) {
        this.dimName = str;
    }

    public void setDimValue(String str) {
        this.dimValue = str;
    }
}
