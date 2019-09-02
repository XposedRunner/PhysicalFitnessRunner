package com.zjwh.android_wh_physicalfitness.entity.request;

import com.zjwh.android_wh_physicalfitness.entity.database.BluetoothDeviceBean;
import java.util.List;

public class BluetoothUploadInfoItem {
    private long end;
    private List<BluetoothDeviceBean> json;
    private long recordId;
    private long start;
    private String uuid;

    public BluetoothUploadInfoItem(long j, long j2, long j3, String str, List<BluetoothDeviceBean> list) {
        this.end = j;
        this.start = j2;
        this.recordId = j3;
        this.uuid = str;
        this.json = list;
    }

    public long getEnd() {
        return this.end;
    }

    public List<BluetoothDeviceBean> getJson() {
        return this.json;
    }

    public long getRecordId() {
        return this.recordId;
    }

    public long getStart() {
        return this.start;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setEnd(long j) {
        this.end = j;
    }

    public void setJson(List<BluetoothDeviceBean> list) {
        this.json = list;
    }

    public void setRecordId(long j) {
        this.recordId = j;
    }

    public void setStart(long j) {
        this.start = j;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BluetoothUploadInfoItem{end=");
        stringBuilder.append(this.end);
        stringBuilder.append(", start=");
        stringBuilder.append(this.start);
        stringBuilder.append(", recordId=");
        stringBuilder.append(this.recordId);
        stringBuilder.append(", uuid='");
        stringBuilder.append(this.uuid);
        stringBuilder.append('\'');
        stringBuilder.append(", json=");
        stringBuilder.append(this.json);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
