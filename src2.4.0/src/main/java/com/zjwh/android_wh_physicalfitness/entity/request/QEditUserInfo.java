package com.zjwh.android_wh_physicalfitness.entity.request;

public class QEditUserInfo {
    private float height;
    private String personalSign;
    private boolean updateHeight;
    private boolean updateSign;
    private boolean updateWeight;
    private float weight;

    public float getHeight() {
        return this.height;
    }

    public String getPersonalSign() {
        return this.personalSign;
    }

    public float getWeight() {
        return this.weight;
    }

    public boolean isUpdateHeight() {
        return this.updateHeight;
    }

    public boolean isUpdateSign() {
        return this.updateSign;
    }

    public boolean isUpdateWeight() {
        return this.updateWeight;
    }

    public void setHeight(float f) {
        this.height = f;
    }

    public void setPersonalSign(String str) {
        this.personalSign = str;
    }

    public void setUpdateHeight(boolean z) {
        this.updateHeight = z;
    }

    public void setUpdateSign(boolean z) {
        this.updateSign = z;
    }

    public void setUpdateWeight(boolean z) {
        this.updateWeight = z;
    }

    public void setWeight(float f) {
        this.weight = f;
    }
}
