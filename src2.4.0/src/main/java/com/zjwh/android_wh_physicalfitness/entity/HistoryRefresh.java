package com.zjwh.android_wh_physicalfitness.entity;

public class HistoryRefresh {
    private boolean dataChanged;

    public HistoryRefresh(boolean z) {
        this.dataChanged = z;
    }

    public boolean isDataChanged() {
        return this.dataChanged;
    }

    public void setDataChanged(boolean z) {
        this.dataChanged = z;
    }
}
