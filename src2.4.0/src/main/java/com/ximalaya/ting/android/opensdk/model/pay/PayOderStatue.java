package com.ximalaya.ting.android.opensdk.model.pay;

import com.google.gson.annotations.SerializedName;
import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;

public class PayOderStatue extends XimalayaResponse {
    @SerializedName("xima_order_created_at")
    private long orderCreatedAt;
    @SerializedName("xima_order_no")
    private String orderNo;
    @SerializedName("xima_order_status")
    private int orderStatus;
    @SerializedName("xima_order_updated_at")
    private long orderUpdatedAt;

    public long getOrderCreatedAt() {
        return this.orderCreatedAt;
    }

    public String getOrderNo() {
        return this.orderNo;
    }

    public int getOrderStatus() {
        return this.orderStatus;
    }

    public long getOrderUpdatedAt() {
        return this.orderUpdatedAt;
    }

    public void setOrderCreatedAt(long j) {
        this.orderCreatedAt = j;
    }

    public void setOrderNo(String str) {
        this.orderNo = str;
    }

    public void setOrderStatus(int i) {
        this.orderStatus = i;
    }

    public void setOrderUpdatedAt(long j) {
        this.orderUpdatedAt = j;
    }
}
