package com.zjwh.android_wh_physicalfitness.entity.database;

import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import java.util.ArrayList;
import java.util.List;
import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;
import org.xutils.db.sqlite.WhereBuilder;
import org.xutils.ex.DbException;

@Table(name = "bluetoothDevice")
public class BluetoothDeviceBean {
    @Column(name = "deviceId")
    private int deviceId;
    @Column(isId = true, name = "id")
    private int id;
    @Column(name = "recordId")
    private long recordId;
    @Column(name = "timestamp")
    private long timestamp;

    public BluetoothDeviceBean(int i, long j, long j2) {
        this.deviceId = i;
        this.timestamp = j;
        this.recordId = j2;
    }

    public static void cleanOldData(long j, long j2) throws DbException {
        O00Oo0.O0000O0o().delete(BluetoothDeviceBean.class, WhereBuilder.b("recordId", "=", Long.valueOf(j2)).and("timestamp", "<", Long.valueOf(j)));
    }

    public static List<BluetoothDeviceBean> getList(long j, long j2, long j3) throws DbException {
        List findAll = O00Oo0.O0000O0o().selector(BluetoothDeviceBean.class).where("timestamp", ">", Long.valueOf(j)).and("timestamp", "<", Long.valueOf(j2)).and("recordId", "=", Long.valueOf(j3)).findAll();
        return findAll == null ? new ArrayList() : findAll;
    }

    public int getDeviceId() {
        return this.deviceId;
    }

    public int getId() {
        return this.id;
    }

    public long getRecordId() {
        return this.recordId;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setDeviceId(int i) {
        this.deviceId = i;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setRecordId(long j) {
        this.recordId = j;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BluetoothDeviceBean{id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", deviceId=");
        stringBuilder.append(this.deviceId);
        stringBuilder.append(", timestamp=");
        stringBuilder.append(this.timestamp);
        stringBuilder.append(", recordId=");
        stringBuilder.append(this.recordId);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
