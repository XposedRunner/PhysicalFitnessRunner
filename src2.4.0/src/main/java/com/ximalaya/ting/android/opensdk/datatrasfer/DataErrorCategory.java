package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.annotations.SerializedName;

public class DataErrorCategory {
    @SerializedName("error_code")
    private String mErrorCode;
    @SerializedName("error_desc")
    private String mErrorDesc;
    @SerializedName("error_no")
    private int mErrorNo;

    public String getErrorCode() {
        return this.mErrorCode;
    }

    public String getErrorDesc() {
        return this.mErrorDesc;
    }

    public int getErrorNo() {
        return this.mErrorNo;
    }

    public void setErrorCode(String str) {
        this.mErrorCode = str;
    }

    public void setErrorDesc(String str) {
        this.mErrorDesc = str;
    }

    public void setErrorNo(int i) {
        this.mErrorNo = i;
    }
}
