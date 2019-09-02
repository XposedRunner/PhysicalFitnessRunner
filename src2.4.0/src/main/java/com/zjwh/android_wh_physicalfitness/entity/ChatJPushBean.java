package com.zjwh.android_wh_physicalfitness.entity;

public class ChatJPushBean {
    private int fromUid;
    private String message;

    public int getFromUid() {
        return this.fromUid;
    }

    public String getMessage() {
        return this.message;
    }

    public void setFromUid(int i) {
        this.fromUid = i;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ChatJPushBean{message='");
        stringBuilder.append(this.message);
        stringBuilder.append('\'');
        stringBuilder.append(", fromUid=");
        stringBuilder.append(this.fromUid);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
