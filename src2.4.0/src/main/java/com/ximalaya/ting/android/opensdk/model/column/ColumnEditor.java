package com.ximalaya.ting.android.opensdk.model.column;

import com.google.gson.annotations.SerializedName;

public class ColumnEditor {
    @SerializedName("avatar_url")
    private String avatarUrl;
    @SerializedName("nickname")
    private String nickName;
    @SerializedName("personal_signature")
    private String personalsignature;
    private long uid;

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String getPersonalsignature() {
        return this.personalsignature;
    }

    public long getUid() {
        return this.uid;
    }

    public void setAvatarUrl(String str) {
        this.avatarUrl = str;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setPersonalsignature(String str) {
        this.personalsignature = str;
    }

    public void setUid(long j) {
        this.uid = j;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ColumnEditor [uid=");
        stringBuilder.append(this.uid);
        stringBuilder.append(", nickName=");
        stringBuilder.append(this.nickName);
        stringBuilder.append(", avatarUrl=");
        stringBuilder.append(this.avatarUrl);
        stringBuilder.append(", personalsignature=");
        stringBuilder.append(this.personalsignature);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
