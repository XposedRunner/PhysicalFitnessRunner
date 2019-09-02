package com.ximalaya.ting.android.opensdk.model.pay;

import com.google.gson.annotations.SerializedName;

public class AlbumPriceTypeDetail {
    @SerializedName("discounted_price")
    private double discountedPrice;
    @SerializedName("price")
    private double price;
    @SerializedName("price_type")
    private int priceType;
    @SerializedName("price_unit")
    private String priceUnit;

    public double getDiscountedPrice() {
        return this.discountedPrice;
    }

    public double getPrice() {
        return this.price;
    }

    public int getPriceType() {
        return this.priceType;
    }

    public String getPriceUnit() {
        return this.priceUnit;
    }

    public void setDiscountedPrice(double d) {
        this.discountedPrice = d;
    }

    public void setPrice(double d) {
        this.price = d;
    }

    public void setPriceType(int i) {
        this.priceType = i;
    }

    public void setPriceUnit(String str) {
        this.priceUnit = str;
    }
}
