package com.zjwh.android_wh_physicalfitness.entity;

public class PointJsonEntity {
    private String fivePointJson;
    private boolean useZip;

    public PointJsonEntity(boolean z, String str) {
        this.useZip = z;
        this.fivePointJson = str;
    }

    public String getFivePointJson() {
        return this.fivePointJson;
    }

    public boolean getUseZip() {
        return this.useZip;
    }

    public void setFivePointJson(String str) {
        this.fivePointJson = str;
    }

    public void setUseZip(boolean z) {
        this.useZip = z;
    }
}
