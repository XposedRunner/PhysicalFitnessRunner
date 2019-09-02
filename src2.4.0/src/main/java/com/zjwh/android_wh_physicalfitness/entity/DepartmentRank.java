package com.zjwh.android_wh_physicalfitness.entity;

public class DepartmentRank {
    private String departmentName;
    private double dis;
    private int order;
    private int participateCount;

    public String getDepartmentName() {
        return this.departmentName;
    }

    public double getDis() {
        return this.dis;
    }

    public int getOrder() {
        return this.order;
    }

    public int getParticipateCount() {
        return this.participateCount;
    }

    public void setDepartmentName(String str) {
        this.departmentName = str;
    }

    public void setDis(double d) {
        this.dis = d;
    }

    public void setOrder(int i) {
        this.order = i;
    }

    public void setParticipateCount(int i) {
        this.participateCount = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DepartmentRank{departmentName='");
        stringBuilder.append(this.departmentName);
        stringBuilder.append('\'');
        stringBuilder.append(", dis=");
        stringBuilder.append(this.dis);
        stringBuilder.append(", order=");
        stringBuilder.append(this.order);
        stringBuilder.append(", participateCount=");
        stringBuilder.append(this.participateCount);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
