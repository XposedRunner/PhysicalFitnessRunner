package com.zjwh.android_wh_physicalfitness.entity.mine;

public class SportConcernFansBean {
    private String avatarUrl;
    private int gender;
    private int interestStatus;
    private long interestTime;
    private String name;
    private String personalSign;
    private int rank;
    private int uid;
    private int viewType = 2;

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

    public int getRank() {
        return this.rank;
    }

    public int getUid() {
        return this.uid;
    }

    public int getViewType() {
        return this.viewType;
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

    public void setRank(int i) {
        this.rank = i;
    }

    public void setUid(int i) {
        this.uid = i;
    }

    public void setViewType(int i) {
        this.viewType = i;
    }
}
