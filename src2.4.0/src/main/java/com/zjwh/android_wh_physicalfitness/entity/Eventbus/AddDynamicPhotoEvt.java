package com.zjwh.android_wh_physicalfitness.entity.Eventbus;

public class AddDynamicPhotoEvt {
    private int num;

    public AddDynamicPhotoEvt(int i) {
        this.num = i;
    }

    public int getPhotoNum() {
        return this.num;
    }
}
