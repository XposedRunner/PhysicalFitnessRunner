package com.zjwh.android_wh_physicalfitness.entity;

public class SemesterInfo {
    private long endDate;
    private int sid;
    private String sname;
    private long startDate;
    private int viewType = 2;

    public long getEndDate() {
        return this.endDate;
    }

    public int getSid() {
        return this.sid;
    }

    public String getSname() {
        return this.sname;
    }

    public long getStartDate() {
        return this.startDate;
    }

    public int getViewType() {
        return this.viewType;
    }

    public void setEndDate(long j) {
        this.endDate = j;
    }

    public void setSid(int i) {
        this.sid = i;
    }

    public void setSname(String str) {
        this.sname = str;
    }

    public void setStartDate(long j) {
        this.startDate = j;
    }

    public void setViewType(int i) {
        this.viewType = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SemesterInfo{sid=");
        stringBuilder.append(this.sid);
        stringBuilder.append(", sname='");
        stringBuilder.append(this.sname);
        stringBuilder.append('\'');
        stringBuilder.append(", startDate=");
        stringBuilder.append(this.startDate);
        stringBuilder.append(", endDate=");
        stringBuilder.append(this.endDate);
        stringBuilder.append(", viewType=");
        stringBuilder.append(this.viewType);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
