package com.zjwh.android_wh_physicalfitness.entity.rollcall;

public class RollCallRankBean {
    private String campusId;
    private String icon;
    private int order;
    private int sex;
    private long signTime;
    private String studentName;

    public String getCampusId() {
        return this.campusId;
    }

    public String getIcon() {
        return this.icon;
    }

    public int getOrder() {
        return this.order;
    }

    public int getSex() {
        return this.sex;
    }

    public long getSignTime() {
        return this.signTime;
    }

    public String getStudentName() {
        return this.studentName;
    }

    public void setCampusId(String str) {
        this.campusId = str;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setOrder(int i) {
        this.order = i;
    }

    public void setSex(int i) {
        this.sex = i;
    }

    public void setSignTime(long j) {
        this.signTime = j;
    }

    public void setStudentName(String str) {
        this.studentName = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RollCallRankBean{order=");
        stringBuilder.append(this.order);
        stringBuilder.append(", studentName='");
        stringBuilder.append(this.studentName);
        stringBuilder.append('\'');
        stringBuilder.append(", campusId='");
        stringBuilder.append(this.campusId);
        stringBuilder.append('\'');
        stringBuilder.append(", signTime=");
        stringBuilder.append(this.signTime);
        stringBuilder.append(", icon='");
        stringBuilder.append(this.icon);
        stringBuilder.append('\'');
        stringBuilder.append(", sex=");
        stringBuilder.append(this.sex);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
