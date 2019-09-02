package com.zjwh.android_wh_physicalfitness.entity;

public class ConcernResultBean {
    private int interestStatus;

    public int getInterestStatus() {
        return this.interestStatus;
    }

    public void setInterestStatus(int i) {
        this.interestStatus = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ConcernResultBean{interestStatus=");
        stringBuilder.append(this.interestStatus);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
