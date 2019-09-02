package com.zjwh.android_wh_physicalfitness.entity;

public class DynamicLikeBean {
    private String avatarUrl;
    private int gender;
    private String nickName;
    private int operationId;
    private int uid;
    private String university;
    private String whatsUp;

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public int getGender() {
        return this.gender;
    }

    public String getNickName() {
        return this.nickName;
    }

    public int getOperationId() {
        return this.operationId;
    }

    public int getUid() {
        return this.uid;
    }

    public String getUniversity() {
        return this.university;
    }

    public String getWhatsUp() {
        return this.whatsUp;
    }

    public void setAvatarUrl(String str) {
        this.avatarUrl = str;
    }

    public void setGender(int i) {
        this.gender = i;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setOperationId(int i) {
        this.operationId = i;
    }

    public void setUid(int i) {
        this.uid = i;
    }

    public void setUniversity(String str) {
        this.university = str;
    }

    public void setWhatsUp(String str) {
        this.whatsUp = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DynamicLikeBean{operationId=");
        stringBuilder.append(this.operationId);
        stringBuilder.append(", uid=");
        stringBuilder.append(this.uid);
        stringBuilder.append(", nickName='");
        stringBuilder.append(this.nickName);
        stringBuilder.append('\'');
        stringBuilder.append(", gender=");
        stringBuilder.append(this.gender);
        stringBuilder.append(", university='");
        stringBuilder.append(this.university);
        stringBuilder.append('\'');
        stringBuilder.append(", avatarUrl='");
        stringBuilder.append(this.avatarUrl);
        stringBuilder.append('\'');
        stringBuilder.append(", whatsUp='");
        stringBuilder.append(this.whatsUp);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
