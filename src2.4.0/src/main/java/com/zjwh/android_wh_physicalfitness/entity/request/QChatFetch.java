package com.zjwh.android_wh_physicalfitness.entity.request;

import java.util.List;

public class QChatFetch {
    private long timestamp;
    private List<Integer> uids;

    public QChatFetch(long j, List<Integer> list) {
        this.timestamp = j;
        this.uids = list;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public List<Integer> getUids() {
        return this.uids;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public void setUids(List<Integer> list) {
        this.uids = list;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("QChatFetch{timestamp=");
        stringBuilder.append(this.timestamp);
        stringBuilder.append(", uids=");
        stringBuilder.append(this.uids);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
