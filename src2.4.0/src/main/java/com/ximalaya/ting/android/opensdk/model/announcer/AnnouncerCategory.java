package com.ximalaya.ting.android.opensdk.model.announcer;

import com.google.gson.annotations.SerializedName;

public class AnnouncerCategory {
    private long id;
    private String kind;
    @SerializedName("order_num")
    private String orderNum;
    @SerializedName("vcategory_name")
    private String vcategoryName;

    public long getId() {
        return this.id;
    }

    public String getKind() {
        return this.kind;
    }

    public String getOrderNum() {
        return this.orderNum;
    }

    public String getVcategoryName() {
        return this.vcategoryName;
    }

    public void setId(long j) {
        this.id = j;
    }

    public void setKind(String str) {
        this.kind = str;
    }

    public void setOrderNum(String str) {
        this.orderNum = str;
    }

    public void setVcategoryName(String str) {
        this.vcategoryName = str;
    }
}
