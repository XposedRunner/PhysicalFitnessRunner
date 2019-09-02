package com.zjwh.android_wh_physicalfitness.entity;

public class ShareInfoBean {
    private String imageUrl;
    private int isShare;
    private String shareUrl;
    private String summary;
    private String title;

    public ShareInfoBean(int i, String str, String str2, String str3, String str4) {
        this.isShare = i;
        this.title = str;
        this.summary = str2;
        this.imageUrl = str3;
        this.shareUrl = str4;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getShareUrl() {
        return this.shareUrl;
    }

    public String getSummary() {
        return this.summary;
    }

    public String getTitle() {
        return this.title;
    }

    public int isHasShare() {
        return this.isShare;
    }

    public void setHasShare(int i) {
        this.isShare = i;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public void setShareUrl(String str) {
        this.shareUrl = str;
    }

    public void setSummary(String str) {
        this.summary = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ShareInfoBean{isShare=");
        stringBuilder.append(this.isShare);
        stringBuilder.append(", title='");
        stringBuilder.append(this.title);
        stringBuilder.append('\'');
        stringBuilder.append(", summary='");
        stringBuilder.append(this.summary);
        stringBuilder.append('\'');
        stringBuilder.append(", imageUrl='");
        stringBuilder.append(this.imageUrl);
        stringBuilder.append('\'');
        stringBuilder.append(", shareUrl='");
        stringBuilder.append(this.shareUrl);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
