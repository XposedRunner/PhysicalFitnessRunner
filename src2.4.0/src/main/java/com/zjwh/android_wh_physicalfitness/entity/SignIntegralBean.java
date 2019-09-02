package com.zjwh.android_wh_physicalfitness.entity;

public class SignIntegralBean {
    private int continueDays;
    private int point;
    private int rank;
    private String rankName;
    private int signinState;

    public int getContinueDays() {
        return this.continueDays;
    }

    public int getPoint() {
        return this.point;
    }

    public int getRank() {
        return this.rank;
    }

    public String getRankName() {
        return this.rankName;
    }

    public int getSigninState() {
        return this.signinState;
    }

    public void setContinueDays(int i) {
        this.continueDays = i;
    }

    public void setPoint(int i) {
        this.point = i;
    }

    public void setRank(int i) {
        this.rank = i;
    }

    public void setRankName(String str) {
        this.rankName = str;
    }

    public void setSigninState(int i) {
        this.signinState = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SignIntegralBean{continueDays=");
        stringBuilder.append(this.continueDays);
        stringBuilder.append(", point=");
        stringBuilder.append(this.point);
        stringBuilder.append(", rank=");
        stringBuilder.append(this.rank);
        stringBuilder.append(", rankName='");
        stringBuilder.append(this.rankName);
        stringBuilder.append('\'');
        stringBuilder.append(", signinState=");
        stringBuilder.append(this.signinState);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
