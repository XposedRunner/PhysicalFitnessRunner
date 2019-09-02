package com.zjwh.android_wh_physicalfitness.entity.Eventbus;

public class MainDataEvt {
    private boolean isDataChange;
    private int selectedIndex;

    public MainDataEvt(int i) {
        this.selectedIndex = i;
    }

    public MainDataEvt(boolean z) {
        this.isDataChange = z;
    }

    public int getSelectedModuleId() {
        return this.selectedIndex;
    }

    public boolean isDataChange() {
        return this.isDataChange;
    }

    public void setDataChange(boolean z) {
        this.isDataChange = z;
    }

    public void setSelectedIndex(int i) {
        this.selectedIndex = i;
    }
}
