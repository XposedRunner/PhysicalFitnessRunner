package com.zjwh.android_wh_physicalfitness.entity;

public class AllSemesterRunInfo {
    private int totalDays;
    private int totalDis;

    public int getTotalDays() {
        return this.totalDays;
    }

    public int getTotalDis() {
        return this.totalDis;
    }

    public void setTotalDays(int i) {
        this.totalDays = i;
    }

    public void setTotalDis(int i) {
        this.totalDis = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AllSemesterRunInfo{totalDays=");
        stringBuilder.append(this.totalDays);
        stringBuilder.append(", totalDis=");
        stringBuilder.append(this.totalDis);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
