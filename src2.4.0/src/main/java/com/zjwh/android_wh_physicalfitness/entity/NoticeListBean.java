package com.zjwh.android_wh_physicalfitness.entity;

public class NoticeListBean {
    private int id;
    private boolean newAdd;
    private long publishDate;
    private String publisher;
    private String publisherRole;
    private String title;

    public int getId() {
        return this.id;
    }

    public long getPublishDate() {
        return this.publishDate;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public String getPublisherRole() {
        return this.publisherRole;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isNewAdd() {
        return this.newAdd;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setNewAdd(boolean z) {
        this.newAdd = z;
    }

    public void setPublishDate(long j) {
        this.publishDate = j;
    }

    public void setPublisher(String str) {
        this.publisher = str;
    }

    public void setPublisherRole(String str) {
        this.publisherRole = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("NoticeListBean{id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", publishDate=");
        stringBuilder.append(this.publishDate);
        stringBuilder.append(", publisher='");
        stringBuilder.append(this.publisher);
        stringBuilder.append('\'');
        stringBuilder.append(", publisherRole='");
        stringBuilder.append(this.publisherRole);
        stringBuilder.append('\'');
        stringBuilder.append(", title='");
        stringBuilder.append(this.title);
        stringBuilder.append('\'');
        stringBuilder.append(", newAdd=");
        stringBuilder.append(this.newAdd);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
