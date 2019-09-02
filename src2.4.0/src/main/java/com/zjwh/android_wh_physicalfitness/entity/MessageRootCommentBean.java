package com.zjwh.android_wh_physicalfitness.entity;

public class MessageRootCommentBean {
    private int isDeleted;
    private int rootId;
    private int rootType;
    private String summary;
    private String thumbUrl;
    private String title;

    public int getIsDeleted() {
        return this.isDeleted;
    }

    public int getRootId() {
        return this.rootId;
    }

    public int getRootType() {
        return this.rootType;
    }

    public String getSummary() {
        return this.summary;
    }

    public String getThumbUrl() {
        return this.thumbUrl;
    }

    public String getTitle() {
        return this.title;
    }

    public void setIsDeleted(int i) {
        this.isDeleted = i;
    }

    public void setRootId(int i) {
        this.rootId = i;
    }

    public void setRootType(int i) {
        this.rootType = i;
    }

    public void setSummary(String str) {
        this.summary = str;
    }

    public void setThumbUrl(String str) {
        this.thumbUrl = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RootCommentBean{rootId=");
        stringBuilder.append(this.rootId);
        stringBuilder.append(", rootType=");
        stringBuilder.append(this.rootType);
        stringBuilder.append(", title='");
        stringBuilder.append(this.title);
        stringBuilder.append('\'');
        stringBuilder.append(", summary='");
        stringBuilder.append(this.summary);
        stringBuilder.append('\'');
        stringBuilder.append(", thumbUrl='");
        stringBuilder.append(this.thumbUrl);
        stringBuilder.append('\'');
        stringBuilder.append(", isDeleted=");
        stringBuilder.append(this.isDeleted);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
