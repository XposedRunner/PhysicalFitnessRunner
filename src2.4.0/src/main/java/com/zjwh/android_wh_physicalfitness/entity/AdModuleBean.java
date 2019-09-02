package com.zjwh.android_wh_physicalfitness.entity;

public class AdModuleBean {
    private String adExposingCodes;
    private int id;
    private String imageUrl;
    private String jumpUrl;
    private String logoUrl;
    private String subTitle;
    private String title;

    public String getAdExposingCodes() {
        return this.adExposingCodes;
    }

    public int getId() {
        return this.id;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public String getLogoUrl() {
        return this.logoUrl;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public String getTitle() {
        return this.title;
    }

    public void setAdExposingCodes(String str) {
        this.adExposingCodes = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public void setJumpUrl(String str) {
        this.jumpUrl = str;
    }

    public void setLogoUrl(String str) {
        this.logoUrl = str;
    }

    public void setSubTitle(String str) {
        this.subTitle = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AdModuleBean{id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", imageUrl='");
        stringBuilder.append(this.imageUrl);
        stringBuilder.append('\'');
        stringBuilder.append(", jumpUrl='");
        stringBuilder.append(this.jumpUrl);
        stringBuilder.append('\'');
        stringBuilder.append(", logoUrl='");
        stringBuilder.append(this.logoUrl);
        stringBuilder.append('\'');
        stringBuilder.append(", subTitle='");
        stringBuilder.append(this.subTitle);
        stringBuilder.append('\'');
        stringBuilder.append(", title='");
        stringBuilder.append(this.title);
        stringBuilder.append('\'');
        stringBuilder.append(", adExposingCodes='");
        stringBuilder.append(this.adExposingCodes);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
