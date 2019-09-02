package com.zjwh.android_wh_physicalfitness.entity;

public class BluetoothTabBean {
    private String finishedTab;
    private int invalidTab;
    private int totalTab;

    public String getFinishedTab() {
        return this.finishedTab;
    }

    public int getInvalidTab() {
        return this.invalidTab;
    }

    public int getTotalTab() {
        return this.totalTab;
    }

    public void setFinishedTab(String str) {
        this.finishedTab = str;
    }

    public void setInvalidTab(int i) {
        this.invalidTab = i;
    }

    public void setTotalTab(int i) {
        this.totalTab = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BluetoothTabBean{invalidTab=");
        stringBuilder.append(this.invalidTab);
        stringBuilder.append(", totalTab=");
        stringBuilder.append(this.totalTab);
        stringBuilder.append(", finishedTab='");
        stringBuilder.append(this.finishedTab);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
