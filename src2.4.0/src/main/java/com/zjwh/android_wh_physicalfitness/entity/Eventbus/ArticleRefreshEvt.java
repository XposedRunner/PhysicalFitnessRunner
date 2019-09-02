package com.zjwh.android_wh_physicalfitness.entity.Eventbus;

public class ArticleRefreshEvt {
    private boolean dataChanged;

    public ArticleRefreshEvt(boolean z) {
        this.dataChanged = z;
    }

    public boolean isDataChanged() {
        return this.dataChanged;
    }

    public void setDataChanged(boolean z) {
        this.dataChanged = z;
    }
}
