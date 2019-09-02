package com.zjwh.android_wh_physicalfitness.entity.Eventbus;

public class MusicStatusEvt {
    private boolean isPlaying;

    public MusicStatusEvt(boolean z) {
        this.isPlaying = z;
    }

    public boolean isPlaying() {
        return this.isPlaying;
    }

    public void setPlaying(boolean z) {
        this.isPlaying = z;
    }
}
