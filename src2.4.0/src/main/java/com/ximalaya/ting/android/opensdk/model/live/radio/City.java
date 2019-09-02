package com.ximalaya.ting.android.opensdk.model.live.radio;

import com.google.gson.annotations.SerializedName;
import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;

public class City extends XimalayaResponse {
    @SerializedName("city_code")
    private int cityCode;
    @SerializedName("city_name")
    private String cityName;
    private long id;
    private String kind;

    public int getCityCode() {
        return this.cityCode;
    }

    public String getCityName() {
        return this.cityName;
    }

    public long getId() {
        return this.id;
    }

    public String getKind() {
        return this.kind;
    }

    public void setCityCode(int i) {
        this.cityCode = i;
    }

    public void setCityName(String str) {
        this.cityName = str;
    }

    public void setId(long j) {
        this.id = j;
    }

    public void setKind(String str) {
        this.kind = str;
    }
}
