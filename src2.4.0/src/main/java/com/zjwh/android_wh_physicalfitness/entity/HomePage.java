package com.zjwh.android_wh_physicalfitness.entity;

public class HomePage {
    private String bicon;
    private String icon;
    private float[] score;

    public String getBicon() {
        return this.bicon;
    }

    public String getIcon() {
        return this.icon;
    }

    public float[] getScore() {
        return this.score;
    }

    public void setBicon(String str) {
        this.bicon = str;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setScore(float[] fArr) {
        this.score = fArr;
    }
}
