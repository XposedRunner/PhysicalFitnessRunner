package com.ximalaya.ting.android.opensdk.model.pay;

import com.google.gson.annotations.SerializedName;
import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;
import java.util.List;

public class PayInfo extends XimalayaResponse {
    @SerializedName("composed_price_type")
    private int composedPriceType;
    @SerializedName("price_type_detail")
    private List<PriceTypeDetailBean> priceTypeDetail;

    public static class PriceTypeDetailBean {
        @SerializedName("discounted_price")
        private float discountedPrice;
        private float price;
        @SerializedName("price_type")
        private int priceType;
        @SerializedName("price_unit")
        private String priceUnit;

        public float getDiscountedPrice() {
            return this.discountedPrice;
        }

        public float getPrice() {
            return this.price;
        }

        public int getPriceType() {
            return this.priceType;
        }

        public String getPriceUnit() {
            return this.priceUnit;
        }

        public void setDiscountedPrice(float f) {
            this.discountedPrice = f;
        }

        public void setPrice(float f) {
            this.price = f;
        }

        public void setPriceType(int i) {
            this.priceType = i;
        }

        public void setPriceUnit(String str) {
            this.priceUnit = str;
        }
    }

    public int getComposedPriceType() {
        return this.composedPriceType;
    }

    public List<PriceTypeDetailBean> getPriceTypeDetail() {
        return this.priceTypeDetail;
    }

    public void setComposedPriceType(int i) {
        this.composedPriceType = i;
    }

    public void setPriceTypeDetail(List<PriceTypeDetailBean> list) {
        this.priceTypeDetail = list;
    }
}
