package com.ximalaya.ting.android.opensdk.model.metadata;

import com.google.gson.annotations.SerializedName;

public class ChildAttributes {
    @SerializedName("attr_key")
    private String attrKey;
    @SerializedName("attr_value")
    private String attrValue;
    @SerializedName("display_name")
    private String displayName;

    public String getAttrKey() {
        return this.attrKey;
    }

    public String getAttrValue() {
        return this.attrValue;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setAttrKey(String str) {
        this.attrKey = str;
    }

    public void setAttrValue(String str) {
        this.attrValue = str;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }
}
