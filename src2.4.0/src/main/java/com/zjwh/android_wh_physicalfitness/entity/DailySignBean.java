package com.zjwh.android_wh_physicalfitness.entity;

public class DailySignBean {
    private int day;
    private boolean isSelected;
    private int score;

    public int getDay() {
        return this.day;
    }

    public int getScore() {
        return this.score;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setDay(int i) {
        this.day = i;
    }

    public void setScore(int i) {
        this.score = i;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }
}
