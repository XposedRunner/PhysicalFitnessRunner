package com.zjwh.android_wh_physicalfitness.entity;

public class AppealResultBean {
    private String statusInfo;

    public String getStatusInfo() {
        return this.statusInfo;
    }

    public void setStatusInfo(String str) {
        this.statusInfo = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AppealResultBean{statusInfo='");
        stringBuilder.append(this.statusInfo);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
