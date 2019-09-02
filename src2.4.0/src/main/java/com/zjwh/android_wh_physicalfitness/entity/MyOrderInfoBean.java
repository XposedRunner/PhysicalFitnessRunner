package com.zjwh.android_wh_physicalfitness.entity;

public class MyOrderInfoBean {
    private String fieldName;
    private String orderCode;
    private String orderNumber;
    private int orderStatus;
    private String paymentTime;
    private String receivableFee;
    private String tradeNo;
    private int userId;
    private String venueName;

    public String getFieldName() {
        return this.fieldName;
    }

    public String getOrderCode() {
        return this.orderCode;
    }

    public String getOrderNumber() {
        return this.orderNumber;
    }

    public int getOrderStatus() {
        return this.orderStatus;
    }

    public String getPaymentTime() {
        return this.paymentTime;
    }

    public String getReceivableFee() {
        return this.receivableFee;
    }

    public String getTradeNo() {
        return this.tradeNo;
    }

    public int getUserId() {
        return this.userId;
    }

    public String getVenueName() {
        return this.venueName;
    }

    public void setFieldName(String str) {
        this.fieldName = str;
    }

    public void setOrderCode(String str) {
        this.orderCode = str;
    }

    public void setOrderNumber(String str) {
        this.orderNumber = str;
    }

    public void setOrderStatus(int i) {
        this.orderStatus = i;
    }

    public void setPaymentTime(String str) {
        this.paymentTime = str;
    }

    public void setReceivableFee(String str) {
        this.receivableFee = str;
    }

    public void setTradeNo(String str) {
        this.tradeNo = str;
    }

    public void setUserId(int i) {
        this.userId = i;
    }

    public void setVenueName(String str) {
        this.venueName = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MyOrderInfoBean{fieldName='");
        stringBuilder.append(this.fieldName);
        stringBuilder.append('\'');
        stringBuilder.append(", orderCode='");
        stringBuilder.append(this.orderCode);
        stringBuilder.append('\'');
        stringBuilder.append(", orderNumber='");
        stringBuilder.append(this.orderNumber);
        stringBuilder.append('\'');
        stringBuilder.append(", orderStatus=");
        stringBuilder.append(this.orderStatus);
        stringBuilder.append(", paymentTime='");
        stringBuilder.append(this.paymentTime);
        stringBuilder.append('\'');
        stringBuilder.append(", receivableFee='");
        stringBuilder.append(this.receivableFee);
        stringBuilder.append('\'');
        stringBuilder.append(", tradeNo='");
        stringBuilder.append(this.tradeNo);
        stringBuilder.append('\'');
        stringBuilder.append(", userId=");
        stringBuilder.append(this.userId);
        stringBuilder.append(", venueName='");
        stringBuilder.append(this.venueName);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
