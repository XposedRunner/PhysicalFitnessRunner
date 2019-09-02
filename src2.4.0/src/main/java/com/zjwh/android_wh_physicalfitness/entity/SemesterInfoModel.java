package com.zjwh.android_wh_physicalfitness.entity;

public class SemesterInfoModel {
    private long endDate;
    private double semesterGoal;
    private int sid;
    private String sname;
    private long startDate;

    public long getEndDate() {
        return this.endDate;
    }

    public double getSemesterGoal() {
        return this.semesterGoal;
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

    public void setEndDate(long j) {
        this.endDate = j;
    }

    public void setSemesterGoal(double d) {
        this.semesterGoal = d;
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

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SemesterInfoModel{semesterGoal=");
        stringBuilder.append(this.semesterGoal);
        stringBuilder.append(", sid=");
        stringBuilder.append(this.sid);
        stringBuilder.append(", sname='");
        stringBuilder.append(this.sname);
        stringBuilder.append('\'');
        stringBuilder.append(", startDate=");
        stringBuilder.append(this.startDate);
        stringBuilder.append(", endDate=");
        stringBuilder.append(this.endDate);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
