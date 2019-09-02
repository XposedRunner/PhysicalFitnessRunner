package com.zjwh.android_wh_physicalfitness.entity;

public class AboutRunInfo {
    private int isMissed;
    private int isStarted;

    public int getIsMissed() {
        return this.isMissed;
    }

    public int getIsStarted() {
        return this.isStarted;
    }

    public void setIsMissed(int i) {
        this.isMissed = i;
    }

    public void setIsStarted(int i) {
        this.isStarted = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AboutRunInfo{isMissed=");
        stringBuilder.append(this.isMissed);
        stringBuilder.append(", isStarted=");
        stringBuilder.append(this.isStarted);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
