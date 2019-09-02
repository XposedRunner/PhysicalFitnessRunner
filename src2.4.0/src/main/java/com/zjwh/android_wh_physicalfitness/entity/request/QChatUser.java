package com.zjwh.android_wh_physicalfitness.entity.request;

public class QChatUser {
    private int uid;
    private long updateTimestamp;

    public QChatUser(int i, long j) {
        this.uid = i;
        this.updateTimestamp = j;
    }

    public int getUid() {
        return this.uid;
    }

    public long getUpdateTimestamp() {
        return this.updateTimestamp;
    }

    public void setUid(int i) {
        this.uid = i;
    }

    public void setUpdateTimestamp(long j) {
        this.updateTimestamp = j;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("QChatUser{uid=");
        stringBuilder.append(this.uid);
        stringBuilder.append(", updateTimestamp=");
        stringBuilder.append(this.updateTimestamp);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
