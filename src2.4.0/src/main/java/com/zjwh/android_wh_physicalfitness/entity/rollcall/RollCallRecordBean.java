package com.zjwh.android_wh_physicalfitness.entity.rollcall;

public class RollCallRecordBean {
    private long recordDate;
    private int status;

    public long getRecordDate() {
        return this.recordDate;
    }

    public int getStatus() {
        return this.status;
    }

    public void setRecordDate(long j) {
        this.recordDate = j;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RollCallRecordBean{recordDate=");
        stringBuilder.append(this.recordDate);
        stringBuilder.append(", status=");
        stringBuilder.append(this.status);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
