package com.zjwh.android_wh_physicalfitness.entity;

public class PersonalSportData {
    private int semesterCount;
    private float semesterDis;
    private float semesterValidDis;
    private int totalDays;
    private float totalDis;

    public int getSemesterCount() {
        return this.semesterCount;
    }

    public float getSemesterDis() {
        return this.semesterDis;
    }

    public float getSemesterValidDis() {
        return this.semesterValidDis;
    }

    public int getTotalDays() {
        return this.totalDays;
    }

    public float getTotalDis() {
        return this.totalDis;
    }

    public void setSemesterCount(int i) {
        this.semesterCount = i;
    }

    public void setSemesterDis(float f) {
        this.semesterDis = f;
    }

    public void setSemesterValidDis(float f) {
        this.semesterValidDis = f;
    }

    public void setTotalDays(int i) {
        this.totalDays = i;
    }

    public void setTotalDis(float f) {
        this.totalDis = f;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PersonalSportData{semesterCount=");
        stringBuilder.append(this.semesterCount);
        stringBuilder.append(", semesterDis=");
        stringBuilder.append(this.semesterDis);
        stringBuilder.append(", semesterValidDis=");
        stringBuilder.append(this.semesterValidDis);
        stringBuilder.append(", totalDays=");
        stringBuilder.append(this.totalDays);
        stringBuilder.append(", totalDis=");
        stringBuilder.append(this.totalDis);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
