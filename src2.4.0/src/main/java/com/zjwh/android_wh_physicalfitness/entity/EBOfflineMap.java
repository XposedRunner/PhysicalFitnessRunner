package com.zjwh.android_wh_physicalfitness.entity;

public class EBOfflineMap {
    private int downloadStatus;

    public EBOfflineMap(int i) {
        this.downloadStatus = i;
    }

    public int getDownloadStatus() {
        return this.downloadStatus;
    }

    public void setDownloadStatus(int i) {
        this.downloadStatus = i;
    }
}
