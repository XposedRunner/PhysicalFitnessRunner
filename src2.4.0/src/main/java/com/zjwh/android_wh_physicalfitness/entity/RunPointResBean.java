package com.zjwh.android_wh_physicalfitness.entity;

public class RunPointResBean {
    private String adExposingCodes;
    private String downloadUrl;

    public String getAdExposingCodes() {
        return this.adExposingCodes;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public void setAdExposingCodes(String str) {
        this.adExposingCodes = str;
    }

    public void setDownloadUrl(String str) {
        this.downloadUrl = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RunPointResBean{adExposingCodes='");
        stringBuilder.append(this.adExposingCodes);
        stringBuilder.append('\'');
        stringBuilder.append(", downloadUrl='");
        stringBuilder.append(this.downloadUrl);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
