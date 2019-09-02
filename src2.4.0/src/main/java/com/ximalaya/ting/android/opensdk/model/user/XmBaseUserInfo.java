package com.ximalaya.ting.android.opensdk.model.user;

import com.google.gson.annotations.SerializedName;
import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;

public class XmBaseUserInfo extends XimalayaResponse {
    @SerializedName("avatar_url")
    private String avatarUrl;
    private int id;
    @SerializedName("is_verified")
    private String isVerified;
    private String kind;
    @SerializedName("nickname")
    private String nickName;

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public int getId() {
        return this.id;
    }

    public String getIsVerified() {
        return this.isVerified;
    }

    public String getKind() {
        return this.kind;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setAvatarUrl(String str) {
        this.avatarUrl = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setIsVerified(String str) {
        this.isVerified = str;
    }

    public void setKind(String str) {
        this.kind = str;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }
}
