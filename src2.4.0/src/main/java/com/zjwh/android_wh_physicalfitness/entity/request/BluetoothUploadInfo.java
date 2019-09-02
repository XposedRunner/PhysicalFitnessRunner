package com.zjwh.android_wh_physicalfitness.entity.request;

import java.util.List;

public class BluetoothUploadInfo {
    private List<BluetoothUploadInfoItem> data;

    public BluetoothUploadInfo(List<BluetoothUploadInfoItem> list) {
        this.data = list;
    }

    public List<BluetoothUploadInfoItem> getData() {
        return this.data;
    }

    public void setData(List<BluetoothUploadInfoItem> list) {
        this.data = list;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BluetoothUploadInfo{data=");
        stringBuilder.append(this.data);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
