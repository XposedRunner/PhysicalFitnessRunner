package com.zjwh.android_wh_physicalfitness.entity;

public class DynamicTagBean {
    private String tagContent;
    private int tagType;
    private String tagUrl;

    public DynamicTagBean(int i, String str) {
        this.tagType = i;
        this.tagContent = str;
    }

    public String getTagContent() {
        return this.tagContent;
    }

    public int getTagType() {
        return this.tagType;
    }

    public String getTagUrl() {
        return this.tagUrl;
    }

    public void setTagContent(String str) {
        this.tagContent = str;
    }

    public void setTagType(int i) {
        this.tagType = i;
    }

    public void setTagUrl(String str) {
        this.tagUrl = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DynamicTagBean{tagType=");
        stringBuilder.append(this.tagType);
        stringBuilder.append(", tagUrl='");
        stringBuilder.append(this.tagUrl);
        stringBuilder.append('\'');
        stringBuilder.append(", tagContent='");
        stringBuilder.append(this.tagContent);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
