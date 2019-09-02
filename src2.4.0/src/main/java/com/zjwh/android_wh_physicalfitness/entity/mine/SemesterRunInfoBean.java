package com.zjwh.android_wh_physicalfitness.entity.mine;

public class SemesterRunInfoBean {
    private float runCount;
    private float semesterException;
    private float semesterRunLength;
    private float todayRunLength;

    public float getRunCount() {
        return this.runCount;
    }

    public float getSemesterException() {
        return this.semesterException;
    }

    public float getSemesterRunLength() {
        return this.semesterRunLength;
    }

    public float getTodayRunLength() {
        return this.todayRunLength;
    }

    public void setRunCount(float f) {
        this.runCount = f;
    }

    public void setSemesterException(float f) {
        this.semesterException = f;
    }

    public void setSemesterRunLength(float f) {
        this.semesterRunLength = f;
    }

    public void setTodayRunLength(float f) {
        this.todayRunLength = f;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SemesterRunInfoBean{runCount=");
        stringBuilder.append(this.runCount);
        stringBuilder.append(", semesterException=");
        stringBuilder.append(this.semesterException);
        stringBuilder.append(", semesterRunLength=");
        stringBuilder.append(this.semesterRunLength);
        stringBuilder.append(", todayRunLength=");
        stringBuilder.append(this.todayRunLength);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
