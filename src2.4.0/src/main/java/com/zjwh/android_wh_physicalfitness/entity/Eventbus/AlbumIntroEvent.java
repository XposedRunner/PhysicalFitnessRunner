package com.zjwh.android_wh_physicalfitness.entity.Eventbus;

public class AlbumIntroEvent {
    private String albumIntro;
    private String nickName;

    public AlbumIntroEvent(String str, String str2) {
        this.nickName = str;
        this.albumIntro = str2;
    }

    public String getAlbumIntro() {
        return this.albumIntro;
    }

    public String getNickName() {
        return this.nickName;
    }
}
