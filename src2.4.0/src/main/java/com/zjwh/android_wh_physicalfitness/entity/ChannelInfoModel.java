package com.zjwh.android_wh_physicalfitness.entity;

public class ChannelInfoModel {
    private boolean placeHolderShow;

    public boolean isPlaceHolderShow() {
        return this.placeHolderShow;
    }

    public void setPlaceHolderShow(boolean z) {
        this.placeHolderShow = z;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ChannelInfoModel{, placeHolderShow=");
        stringBuilder.append(this.placeHolderShow);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
