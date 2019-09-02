package com.ximalaya.ting.android.opensdk.model.pay;

import com.google.gson.annotations.SerializedName;

public class OrderDetail {
    @SerializedName("client_os_type")
    private int clientOsType;
    @SerializedName("order_amount")
    private double orderAmount;
    @SerializedName("pay_channel")
    private int payChannel;
    @SerializedName("pay_content")
    private String payContent;
    @SerializedName("third_uid")
    private String thirdUid;
    private int uid;
    @SerializedName("xima_order_created_at")
    private long ximaOrderCreatedAt;
    @SerializedName("xima_order_no")
    private String ximaOrderNo;
    @SerializedName("xima_order_status")
    private int ximaOrderStatus;
    @SerializedName("xima_order_updated_at")
    private long ximaOrderUpdatedAt;

    public int getClientOsType() {
        return this.clientOsType;
    }

    public double getOrderAmount() {
        return this.orderAmount;
    }

    public int getPayChannel() {
        return this.payChannel;
    }

    public String getPayContent() {
        return this.payContent;
    }

    public String getThirdUid() {
        return this.thirdUid;
    }

    public int getUid() {
        return this.uid;
    }

    public long getXimaOrderCreatedAt() {
        return this.ximaOrderCreatedAt;
    }

    public String getXimaOrderNo() {
        return this.ximaOrderNo;
    }

    public int getXimaOrderStatus() {
        return this.ximaOrderStatus;
    }

    public long getXimaOrderUpdatedAt() {
        return this.ximaOrderUpdatedAt;
    }

    public void setClientOsType(int i) {
        this.clientOsType = i;
    }

    public void setOrderAmount(double d) {
        this.orderAmount = d;
    }

    public void setPayChannel(int i) {
        this.payChannel = i;
    }

    public void setPayContent(String str) {
        this.payContent = str;
    }

    public void setThirdUid(String str) {
        this.thirdUid = str;
    }

    public void setUid(int i) {
        this.uid = i;
    }

    public void setXimaOrderCreatedAt(long j) {
        this.ximaOrderCreatedAt = j;
    }

    public void setXimaOrderNo(String str) {
        this.ximaOrderNo = str;
    }

    public void setXimaOrderStatus(int i) {
        this.ximaOrderStatus = i;
    }

    public void setXimaOrderUpdatedAt(long j) {
        this.ximaOrderUpdatedAt = j;
    }
}
