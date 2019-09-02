package com.zjwh.android_wh_physicalfitness.entity;

public class EndPointModel {
    private String beginTime;
    private String endTime;
    private boolean open;

    public String getBeginTime() {
        return this.beginTime;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public boolean getOpen() {
        return this.open;
    }

    public void setBeginTime(String str) {
        this.beginTime = str;
    }

    public void setEndTime(String str) {
        this.endTime = str;
    }

    public void setOpen(boolean z) {
        this.open = z;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("EndPointModel{beginTime='");
        stringBuilder.append(this.beginTime);
        stringBuilder.append('\'');
        stringBuilder.append(", endTime='");
        stringBuilder.append(this.endTime);
        stringBuilder.append('\'');
        stringBuilder.append(", open=");
        stringBuilder.append(this.open);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
