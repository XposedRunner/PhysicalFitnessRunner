package com.zjwh.android_wh_physicalfitness.entity;

public class SportMoodMatchBean {
    private String avatarUrl;
    private int dynamicId;
    private int dynamicUid;
    private int gender;
    private String imgUrl;
    private String nickName;
    private String university;

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public int getDynamicId() {
        return this.dynamicId;
    }

    public int getDynamicUid() {
        return this.dynamicUid;
    }

    public int getGender() {
        return this.gender;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String getUniversity() {
        return this.university;
    }

    public void setAvatarUrl(String str) {
        this.avatarUrl = str;
    }

    public void setDynamicId(int i) {
        this.dynamicId = i;
    }

    public void setDynamicUid(int i) {
        this.dynamicUid = i;
    }

    public void setGender(int i) {
        this.gender = i;
    }

    public void setImgUrl(String str) {
        this.imgUrl = str;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setUniversity(String str) {
        this.university = str;
    }
}
