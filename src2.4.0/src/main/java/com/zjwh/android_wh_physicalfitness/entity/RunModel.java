package com.zjwh.android_wh_physicalfitness.entity;

public class RunModel {
    private double totalDis;
    private double validTotalDis;

    public double getTotalDis() {
        return this.totalDis;
    }

    public double getValidTotalDis() {
        return this.validTotalDis;
    }

    public void setTotalDis(double d) {
        this.totalDis = d;
    }

    public void setValidTotalDis(double d) {
        this.validTotalDis = d;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RunModel{totalDis=");
        stringBuilder.append(this.totalDis);
        stringBuilder.append(", validTotalDis=");
        stringBuilder.append(this.validTotalDis);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
