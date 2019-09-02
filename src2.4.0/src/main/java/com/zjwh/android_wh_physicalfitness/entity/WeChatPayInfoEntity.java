package com.zjwh.android_wh_physicalfitness.entity;

public class WeChatPayInfoEntity {
    private String appid;
    private String noncestr;
    private String partnerid;
    private String prepayid;
    private String prepayidpackage;
    private String sign;
    private String timestamp;

    public WeChatPayInfoEntity(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.appid = str;
        this.partnerid = str2;
        this.prepayid = str3;
        this.noncestr = str4;
        this.timestamp = str5;
        this.prepayidpackage = str6;
        this.sign = str7;
    }

    public String getAppid() {
        return this.appid;
    }

    public String getNoncestr() {
        return this.noncestr;
    }

    public String getPartnerid() {
        return this.partnerid;
    }

    public String getPrepayid() {
        return this.prepayid;
    }

    public String getPrepayidpackage() {
        return this.prepayidpackage;
    }

    public String getSign() {
        return this.sign;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public void setAppid(String str) {
        this.appid = str;
    }

    public void setNoncestr(String str) {
        this.noncestr = str;
    }

    public void setPartnerid(String str) {
        this.partnerid = str;
    }

    public void setPrepayid(String str) {
        this.prepayid = str;
    }

    public void setPrepayidpackage(String str) {
        this.prepayidpackage = str;
    }

    public void setSign(String str) {
        this.sign = str;
    }

    public void setTimestamp(String str) {
        this.timestamp = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("WeChatPayInfoEntity{appid='");
        stringBuilder.append(this.appid);
        stringBuilder.append('\'');
        stringBuilder.append(", partnerid='");
        stringBuilder.append(this.partnerid);
        stringBuilder.append('\'');
        stringBuilder.append(", prepayid='");
        stringBuilder.append(this.prepayid);
        stringBuilder.append('\'');
        stringBuilder.append(", noncestr='");
        stringBuilder.append(this.noncestr);
        stringBuilder.append('\'');
        stringBuilder.append(", timestamp='");
        stringBuilder.append(this.timestamp);
        stringBuilder.append('\'');
        stringBuilder.append(", prepayidpackage='");
        stringBuilder.append(this.prepayidpackage);
        stringBuilder.append('\'');
        stringBuilder.append(", sign='");
        stringBuilder.append(this.sign);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
