package com.zjwh.android_wh_physicalfitness.entity.statistics;

public class PvDataInfo {
    public String itemId = "";
    public int module;
    public int stayTime;

    public PvDataInfo(int i, String str) {
        this.module = i;
        this.itemId = str;
    }

    public PvDataInfo(int i, String str, int i2) {
        this.module = i;
        this.itemId = str;
        this.stayTime = i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PvDataInfo{module=");
        stringBuilder.append(this.module);
        stringBuilder.append(", item_id='");
        stringBuilder.append(this.itemId);
        stringBuilder.append('\'');
        stringBuilder.append(",stay_time=");
        stringBuilder.append(this.stayTime);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
