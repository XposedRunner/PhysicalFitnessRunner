package com.ximalaya.ting.android.opensdk.model.pay;

import com.google.gson.annotations.SerializedName;
import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;

public class ClientOrderResult extends XimalayaResponse {
    @SerializedName("order_settlement_url")
    private String orderSettlementUrl;

    public String getOrderSettlementUrl() {
        return this.orderSettlementUrl;
    }

    public void setOrderSettlementUrl(String str) {
        this.orderSettlementUrl = str;
    }
}
