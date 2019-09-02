package com.zjwh.android_wh_physicalfitness.entity;

public class MessageBodyBean {
    private int id = -1;
    private String url = "";

    public int getId() {
        return this.id;
    }

    public String getUrl() {
        return this.url;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MessageBodyBean{id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", url='");
        stringBuilder.append(this.url);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
