package com.zjwh.android_wh_physicalfitness.entity.response;

public class RunCount {
    private int countInCurrSeme;
    private float currSemeValidDistance;
    private float distanceInCurrSeme;

    public int getCountInCurrSeme() {
        return this.countInCurrSeme;
    }

    public float getCurrSemeValidDistance() {
        return this.currSemeValidDistance;
    }

    public float getDistanceInCurrSeme() {
        return this.distanceInCurrSeme;
    }

    public void setCountInCurrSeme(int i) {
        this.countInCurrSeme = i;
    }

    public void setCurrSemeValidDistance(float f) {
        this.currSemeValidDistance = f;
    }

    public void setDistanceInCurrSeme(float f) {
        this.distanceInCurrSeme = f;
    }
}
