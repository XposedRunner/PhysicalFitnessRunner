package com.zjwh.android_wh_physicalfitness.entity;

public class LocJsonEntity {
    private String allLocJson;
    private boolean useZip;

    public LocJsonEntity(boolean z, String str) {
        this.useZip = z;
        this.allLocJson = str;
    }

    public String getAllLocJson() {
        return this.allLocJson;
    }

    public boolean getUseZip() {
        return this.useZip;
    }

    public void setAllLocJson(String str) {
        this.allLocJson = str;
    }

    public void setUseZip(boolean z) {
        this.useZip = z;
    }
}
