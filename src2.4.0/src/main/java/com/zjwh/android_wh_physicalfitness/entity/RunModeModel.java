package com.zjwh.android_wh_physicalfitness.entity;

public class RunModeModel {
    private boolean destinationRun;
    private boolean freedomRun;
    private boolean freedomRunCalculate;
    private boolean randomRun;

    public boolean isDestinationRun() {
        return this.destinationRun;
    }

    public boolean isFreedomRun() {
        return this.freedomRun;
    }

    public boolean isFreedomRunCalculate() {
        return this.freedomRunCalculate;
    }

    public boolean isRandomRun() {
        return this.randomRun;
    }

    public void setDestinationRun(boolean z) {
        this.destinationRun = z;
    }

    public void setFreedomRun(boolean z) {
        this.freedomRun = z;
    }

    public void setFreedomRunCalculate(boolean z) {
        this.freedomRunCalculate = z;
    }

    public void setRandomRun(boolean z) {
        this.randomRun = z;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RunModeModel{randomRun=");
        stringBuilder.append(this.randomRun);
        stringBuilder.append(", destinationRun=");
        stringBuilder.append(this.destinationRun);
        stringBuilder.append(", freedomRun=");
        stringBuilder.append(this.freedomRun);
        stringBuilder.append(", freedomRunCalculate=");
        stringBuilder.append(this.freedomRunCalculate);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
