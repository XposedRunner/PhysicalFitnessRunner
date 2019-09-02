package com.zjwh.android_wh_physicalfitness.entity;

public class EBRankBcgr {
    private String bgUrl;
    private int uid;

    public EBRankBcgr(int i, String str) {
        this.uid = i;
        this.bgUrl = str;
    }

    public String getBgUrl() {
        return this.bgUrl;
    }

    public int getUid() {
        return this.uid;
    }

    public void setBgUrl(String str) {
        this.bgUrl = str;
    }

    public void setUid(int i) {
        this.uid = i;
    }
}
