package com.zjwh.android_wh_physicalfitness.entity;

import android.graphics.Rect;

public class BarChartPoint {
    private boolean mIsSelected;
    private Rect mLocation;
    private float mScore;

    public Rect getLocation() {
        return this.mLocation;
    }

    public float getScore() {
        return this.mScore;
    }

    public boolean isSelected() {
        return this.mIsSelected;
    }

    public void setLocation(Rect rect) {
        this.mLocation = rect;
    }

    public void setScore(float f) {
        this.mScore = f;
    }

    public void setSelected(boolean z) {
        this.mIsSelected = z;
    }
}
