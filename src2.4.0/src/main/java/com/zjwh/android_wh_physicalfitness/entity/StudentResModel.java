package com.zjwh.android_wh_physicalfitness.entity;

public class StudentResModel {
    public String campusId;
    public String name;
    public double semesterGoal;
    public int uid;
    public double validTotalDis;

    public StudentResModel(int i, String str, String str2, double d, double d2) {
        this.uid = i;
        this.name = str;
        this.campusId = str2;
        this.validTotalDis = d;
        this.semesterGoal = d2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("StudentResModel{uid=");
        stringBuilder.append(this.uid);
        stringBuilder.append(", name='");
        stringBuilder.append(this.name);
        stringBuilder.append('\'');
        stringBuilder.append(", campusId='");
        stringBuilder.append(this.campusId);
        stringBuilder.append('\'');
        stringBuilder.append(", validTotalDis=");
        stringBuilder.append(this.validTotalDis);
        stringBuilder.append(", semesterGoal=");
        stringBuilder.append(this.semesterGoal);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
