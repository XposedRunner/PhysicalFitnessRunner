package com.zjwh.android_wh_physicalfitness.entity;

import java.util.List;

public class SportMoodShareBean extends DynamicPublishBean {
    private int rrid;

    public SportMoodShareBean(int i, String str, List<Integer> list, float f) {
        super(i, str, list, f);
    }

    public SportMoodShareBean(int i, String str, List<Integer> list, float f, int i2) {
        super(i, str, list, f);
        this.rrid = i2;
    }

    public int getRrid() {
        return this.rrid;
    }

    public void setRrid(int i) {
        this.rrid = i;
    }
}
