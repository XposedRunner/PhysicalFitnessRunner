package com.zjwh.android_wh_physicalfitness.entity.rank;

public class CheatReportImageBean {
    public static final int VIEW_TYPE_ADD = 1;
    public static final int VIEW_TYPE_PHOTO = 2;
    private String imageUrl;
    private int viewType;

    public CheatReportImageBean(int i) {
        this.viewType = i;
    }

    public CheatReportImageBean(int i, String str) {
        this.viewType = i;
        this.imageUrl = str;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public int getViewType() {
        return this.viewType;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public void setViewType(int i) {
        this.viewType = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CheatReportImageBean{viewType=");
        stringBuilder.append(this.viewType);
        stringBuilder.append(", imageUrl='");
        stringBuilder.append(this.imageUrl);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
