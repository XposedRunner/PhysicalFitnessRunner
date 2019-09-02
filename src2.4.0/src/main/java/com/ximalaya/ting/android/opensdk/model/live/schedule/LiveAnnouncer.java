package com.ximalaya.ting.android.opensdk.model.live.schedule;

import com.google.gson.annotations.SerializedName;

public class LiveAnnouncer {
    @SerializedName("avatar_url")
    private String avatarUrl;
    @SerializedName("id")
    private long liveAnnouncerId;
    @SerializedName("nickname")
    private String nickName;

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public long getLiveAnnouncerId() {
        return this.liveAnnouncerId;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setAvatarUrl(String str) {
        this.avatarUrl = str;
    }

    public void setLiveAnnouncerId(long j) {
        this.liveAnnouncerId = j;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }
}
