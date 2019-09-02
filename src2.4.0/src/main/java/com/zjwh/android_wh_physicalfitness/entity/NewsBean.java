package com.zjwh.android_wh_physicalfitness.entity;

import com.google.gson.annotations.SerializedName;

public class NewsBean implements Comparable<NewsBean> {
    private int contentType;
    private int isTop;
    private int likeCount;
    private String listImage;
    private boolean newAdd;
    @SerializedName(alternate = {"id"}, value = "newsId")
    private int newsId;
    private long publishTime;
    private int readCount;
    private String summary;
    private String thumbUrl;
    private String title;

    public int compareTo(NewsBean newsBean) {
        return (!isTop() || newsBean.isTop()) ? (isTop() || !newsBean.isTop()) ? 0 : 1 : -1;
    }

    public int getContentType() {
        return this.contentType;
    }

    public int getIsTop() {
        return this.isTop;
    }

    public int getLikeCount() {
        return this.likeCount;
    }

    public String getListImage() {
        return this.listImage;
    }

    public int getNewsId() {
        return this.newsId;
    }

    public long getPublishTime() {
        return this.publishTime;
    }

    public int getReadCount() {
        return this.readCount;
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

    public boolean isNewAdd() {
        return this.newAdd;
    }

    public boolean isTop() {
        return getIsTop() == 1;
    }

    public void setContentType(int i) {
        this.contentType = i;
    }

    public void setIsTop(int i) {
        this.isTop = i;
    }

    public void setLikeCount(int i) {
        this.likeCount = i;
    }

    public void setListImage(String str) {
        this.listImage = str;
    }

    public void setNewAdd(boolean z) {
        this.newAdd = z;
    }

    public void setNewsId(int i) {
        this.newsId = i;
    }

    public void setPublishTime(long j) {
        this.publishTime = j;
    }

    public void setReadCount(int i) {
        this.readCount = i;
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
        stringBuilder.append("NewsBean{newsId=");
        stringBuilder.append(this.newsId);
        stringBuilder.append(", isTop=");
        stringBuilder.append(this.isTop);
        stringBuilder.append(", title='");
        stringBuilder.append(this.title);
        stringBuilder.append('\'');
        stringBuilder.append(", publishTime=");
        stringBuilder.append(this.publishTime);
        stringBuilder.append(", readCount=");
        stringBuilder.append(this.readCount);
        stringBuilder.append(", likeCount=");
        stringBuilder.append(this.likeCount);
        stringBuilder.append(", thumbUrl='");
        stringBuilder.append(this.thumbUrl);
        stringBuilder.append('\'');
        stringBuilder.append(", contentType=");
        stringBuilder.append(this.contentType);
        stringBuilder.append(", summary='");
        stringBuilder.append(this.summary);
        stringBuilder.append('\'');
        stringBuilder.append(", listImage='");
        stringBuilder.append(this.listImage);
        stringBuilder.append('\'');
        stringBuilder.append(", newAdd=");
        stringBuilder.append(this.newAdd);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
