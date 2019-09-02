package com.ximalaya.ting.android.opensdk.model.live.radio;

import com.google.gson.annotations.SerializedName;

public class RadioCategory {
    private long id;
    private String kind;
    @SerializedName("order_num")
    private int orderNum;
    @SerializedName("radio_category_name")
    private String radioCategoryName;

    public long getId() {
        return this.id;
    }

    public String getKind() {
        return this.kind;
    }

    public int getOrderNum() {
        return this.orderNum;
    }

    public String getRadioCategoryName() {
        return this.radioCategoryName;
    }

    public void setId(long j) {
        this.id = j;
    }

    public void setKind(String str) {
        this.kind = str;
    }

    public void setOrderNum(int i) {
        this.orderNum = i;
    }

    public void setRadioCategoryName(String str) {
        this.radioCategoryName = str;
    }
}
