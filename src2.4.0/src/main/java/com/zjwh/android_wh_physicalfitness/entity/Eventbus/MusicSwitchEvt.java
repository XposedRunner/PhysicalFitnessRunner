package com.zjwh.android_wh_physicalfitness.entity.Eventbus;

public class MusicSwitchEvt {
    private long albumId;
    private long soundId;

    public MusicSwitchEvt(long j, long j2) {
        this.albumId = j;
        this.soundId = j2;
    }

    public long getAlbumId() {
        return this.albumId;
    }

    public long getSoundId() {
        return this.soundId;
    }

    public void setAlbumId(long j) {
        this.albumId = j;
    }

    public void setSoundId(long j) {
        this.soundId = j;
    }
}
