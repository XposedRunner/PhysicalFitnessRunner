package com.zjwh.android_wh_physicalfitness.entity.database;

import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;
import org.xutils.ex.DbException;

@Table(name = "bluetoothSign")
public class BluetoothSignBean {
    @Column(name = "lastUploadTime")
    private long lastUploadTime;
    @Column(autoGen = false, isId = true, name = "recordId")
    private long recordId;
    @Column(name = "validTime")
    private long validTime;

    public static BluetoothSignBean getBean(long j) throws DbException {
        return (BluetoothSignBean) O00Oo0.O0000O0o().selector(BluetoothSignBean.class).where("recordId", "=", Long.valueOf(j)).findFirst();
    }

    public long getLastUploadTime() {
        return this.lastUploadTime;
    }

    public long getRecordId() {
        return this.recordId;
    }

    public long getValidTime() {
        return this.validTime;
    }

    public void setLastUploadTime(long j) {
        this.lastUploadTime = j;
    }

    public void setRecordId(long j) {
        this.recordId = j;
    }

    public void setValidTime(long j) {
        this.validTime = j;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BluetoothSignBean{recordId=");
        stringBuilder.append(this.recordId);
        stringBuilder.append(", validTime=");
        stringBuilder.append(this.validTime);
        stringBuilder.append(", lastUploadTime=");
        stringBuilder.append(this.lastUploadTime);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
