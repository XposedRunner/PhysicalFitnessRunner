package com.zjwh.android_wh_physicalfitness.entity;

public class BSignBean {
    private long recordId;

    public long getRecordId() {
        return this.recordId;
    }

    public void setRecordId(long j) {
        this.recordId = j;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BSignBean{recordId=");
        stringBuilder.append(this.recordId);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
