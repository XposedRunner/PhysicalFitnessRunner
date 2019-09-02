package com.zjwh.android_wh_physicalfitness.entity.Eventbus;

public class MusicProgressEvt {
    private int currPo;
    private int duration;

    public MusicProgressEvt(int i, int i2) {
        this.currPo = i;
        this.duration = i2;
    }

    public int getCurrPo() {
        return this.currPo;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setCurrPo(int i) {
        this.currPo = i;
    }

    public void setDuration(int i) {
        this.duration = i;
    }
}
