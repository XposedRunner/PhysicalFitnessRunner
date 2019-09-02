package com.zjwh.android_wh_physicalfitness.entity.Eventbus;

public class DynamicScrollEvt {
    private int state;

    public DynamicScrollEvt(int i) {
        this.state = i;
    }

    public int getState() {
        return this.state;
    }

    public void setState(int i) {
        this.state = i;
    }
}
