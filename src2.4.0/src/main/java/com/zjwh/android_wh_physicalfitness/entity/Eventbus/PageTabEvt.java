package com.zjwh.android_wh_physicalfitness.entity.Eventbus;

public class PageTabEvt {
    private int position;

    public PageTabEvt(int i) {
        this.position = i;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int i) {
        this.position = i;
    }
}
