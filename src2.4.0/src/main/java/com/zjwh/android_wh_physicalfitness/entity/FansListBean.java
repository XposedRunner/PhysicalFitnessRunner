package com.zjwh.android_wh_physicalfitness.entity;

public class FansListBean {
    private String avatarUrl;
    private int gender;
    private int interestStatus;
    private long interestTime;
    private boolean isServiceDoing;
    private String name;
    private String personalSign;
    private int uid;

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public int getGender() {
        return this.gender;
    }

    public int getInterestStatus() {
        return this.interestStatus;
    }

    public long getInterestTime() {
        return this.interestTime;
    }

    public String getName() {
        return this.name;
    }

    public String getPersonalSign() {
        return this.personalSign;
    }

    public int getUid() {
        return this.uid;
    }

    public boolean isServiceDoing() {
        return this.isServiceDoing;
    }

    public void setAvatarUrl(String str) {
        this.avatarUrl = str;
    }

    public void setGender(int i) {
        this.gender = i;
    }

    public void setInterestStatus(int i) {
        this.interestStatus = i;
    }

    public void setInterestTime(long j) {
        this.interestTime = j;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPersonalSign(String str) {
        this.personalSign = str;
    }

    public void setServiceDoing(boolean z) {
        this.isServiceDoing = z;
    }

    public void setUid(int i) {
        this.uid = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FansListBean{uid=");
        stringBuilder.append(this.uid);
        stringBuilder.append(", name='");
        stringBuilder.append(this.name);
        stringBuilder.append('\'');
        stringBuilder.append(", gender=");
        stringBuilder.append(this.gender);
        stringBuilder.append(", personalSign='");
        stringBuilder.append(this.personalSign);
        stringBuilder.append('\'');
        stringBuilder.append(", avatarUrl='");
        stringBuilder.append(this.avatarUrl);
        stringBuilder.append('\'');
        stringBuilder.append(", interestStatus=");
        stringBuilder.append(this.interestStatus);
        stringBuilder.append(", interestTime=");
        stringBuilder.append(this.interestTime);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
