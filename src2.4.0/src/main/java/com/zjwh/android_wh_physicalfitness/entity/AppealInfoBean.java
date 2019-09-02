package com.zjwh.android_wh_physicalfitness.entity;

public class AppealInfoBean {
    private int appealStatus;
    private String verifier;
    private String verifyInfo;
    private long verifyTime;

    public int getAppealStatus() {
        return this.appealStatus;
    }

    public String getVerifier() {
        return this.verifier;
    }

    public String getVerifyInfo() {
        return this.verifyInfo;
    }

    public long getVerifyTime() {
        return this.verifyTime;
    }

    public void setAppealStatus(int i) {
        this.appealStatus = i;
    }

    public void setVerifier(String str) {
        this.verifier = str;
    }

    public void setVerifyInfo(String str) {
        this.verifyInfo = str;
    }

    public void setVerifyTime(long j) {
        this.verifyTime = j;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AppealInfoBean{appealStatus=");
        stringBuilder.append(this.appealStatus);
        stringBuilder.append(", verifier='");
        stringBuilder.append(this.verifier);
        stringBuilder.append('\'');
        stringBuilder.append(", verifyInfo='");
        stringBuilder.append(this.verifyInfo);
        stringBuilder.append('\'');
        stringBuilder.append(", verifyTime=");
        stringBuilder.append(this.verifyTime);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
