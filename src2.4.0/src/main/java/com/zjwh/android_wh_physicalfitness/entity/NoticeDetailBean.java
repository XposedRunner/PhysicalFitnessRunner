package com.zjwh.android_wh_physicalfitness.entity;

public class NoticeDetailBean {
    private String buttonText;
    private String buttonUrl;
    private String content;
    private int id;
    private String imageUrl;
    private long publishDate;
    private String publisher;
    private String publisherRole;
    private String title;

    public String getButtonText() {
        return this.buttonText;
    }

    public String getButtonUrl() {
        return this.buttonUrl;
    }

    public String getContent() {
        return this.content;
    }

    public int getId() {
        return this.id;
    }

    public String getImageUrl() {
        return this.imageUrl;
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

    public void setButtonText(String str) {
        this.buttonText = str;
    }

    public void setButtonUrl(String str) {
        this.buttonUrl = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
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
        stringBuilder.append("NoticeDetailBean{buttonText='");
        stringBuilder.append(this.buttonText);
        stringBuilder.append('\'');
        stringBuilder.append(", buttonUrl='");
        stringBuilder.append(this.buttonUrl);
        stringBuilder.append('\'');
        stringBuilder.append(", content='");
        stringBuilder.append(this.content);
        stringBuilder.append('\'');
        stringBuilder.append(", id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", imageUrl='");
        stringBuilder.append(this.imageUrl);
        stringBuilder.append('\'');
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
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
