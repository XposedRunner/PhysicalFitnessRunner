package com.zjwh.android_wh_physicalfitness.entity;

public class AttendanceValidBean {
    private long endTime;
    private long startTime;

    public long getEndTime() {
        return this.endTime;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public void setEndTime(long j) {
        this.endTime = j;
    }

    public void setStartTime(long j) {
        this.startTime = j;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AttendanceValidBean{startTime=");
        stringBuilder.append(this.startTime);
        stringBuilder.append(", endTime=");
        stringBuilder.append(this.endTime);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
