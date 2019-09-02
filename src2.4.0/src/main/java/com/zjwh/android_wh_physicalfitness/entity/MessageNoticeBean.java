package com.zjwh.android_wh_physicalfitness.entity;

public class MessageNoticeBean extends MultiAdapterBean {
    private int id;
    private String notificationImage;
    private String summary;
    private long time;
    private String title;
    private int type;
    private String url;

    public MessageNoticeBean() {
        setViewType(2);
    }

    public int getId() {
        return this.id;
    }

    public String getNotificationImage() {
        return this.notificationImage;
    }

    public String getSummary() {
        return this.summary;
    }

    public long getTime() {
        return this.time;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setNotificationImage(String str) {
        this.notificationImage = str;
    }

    public void setSummary(String str) {
        this.summary = str;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MessageNoticeBean{id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", title='");
        stringBuilder.append(this.title);
        stringBuilder.append('\'');
        stringBuilder.append(", summary='");
        stringBuilder.append(this.summary);
        stringBuilder.append('\'');
        stringBuilder.append(", time=");
        stringBuilder.append(this.time);
        stringBuilder.append(", type=");
        stringBuilder.append(this.type);
        stringBuilder.append(", url='");
        stringBuilder.append(this.url);
        stringBuilder.append('\'');
        stringBuilder.append(", notificationImage='");
        stringBuilder.append(this.notificationImage);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
