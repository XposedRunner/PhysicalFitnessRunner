package com.zjwh.android_wh_physicalfitness.entity.Eventbus;

public class NoticeHasNewEvt {
    private boolean hasNew;

    public NoticeHasNewEvt(boolean z) {
        this.hasNew = z;
    }

    public boolean isHasNew() {
        return this.hasNew;
    }

    public void setHasNew(boolean z) {
        this.hasNew = z;
    }
}
