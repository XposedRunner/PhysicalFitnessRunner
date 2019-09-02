package com.geetest.sdk;

public class GT3ErrorBean {
    public String challenge;
    public long duration;
    public String errorCode;
    public String errorDesc;
    private boolean isChangeDesc = false;
    public String sdkVersion;
    public String type;

    public GT3ErrorBean(String str, String str2, long j, String str3, String str4, String str5) {
        this.errorCode = str;
        this.errorDesc = str2;
        this.duration = j;
        this.challenge = str3;
        this.type = str4;
        this.sdkVersion = str5;
    }

    public boolean isChangeDesc() {
        return this.isChangeDesc;
    }

    public void setChangeDesc(boolean z) {
        this.isChangeDesc = z;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("GT3ErrorBean{errorCode='");
        stringBuilder.append(this.errorCode);
        stringBuilder.append('\'');
        stringBuilder.append(", errorDesc='");
        stringBuilder.append(this.errorDesc);
        stringBuilder.append('\'');
        stringBuilder.append(", duration=");
        stringBuilder.append(this.duration);
        stringBuilder.append(", challenge='");
        stringBuilder.append(this.challenge);
        stringBuilder.append('\'');
        stringBuilder.append(", type='");
        stringBuilder.append(this.type);
        stringBuilder.append('\'');
        stringBuilder.append(", sdkVersion='");
        stringBuilder.append(this.sdkVersion);
        stringBuilder.append('\'');
        stringBuilder.append(", isChangeDesc=");
        stringBuilder.append(this.isChangeDesc);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
