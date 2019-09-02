package com.zjwh.android_wh_physicalfitness.entity.database;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

@Table(name = "runPoint")
public class RunPoint {
    @Column(name = "desc")
    private String desc;
    @Column(name = "endTime")
    private String endTime;
    @Column(name = "fromTime")
    private String fromTime;
    @Column(name = "isFixed")
    private boolean isFixed;
    @Column(name = "lat")
    private double lat;
    @Column(name = "lon")
    private double lon;
    @Column(autoGen = false, isId = true, name = "pid")
    private int pid;
    @Column(name = "runMode")
    private int runMode;
    @Column(name = "serialNum")
    private int serialNum;
    @Column(name = "unid")
    private int unid;

    public String getDesc() {
        return this.desc;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public String getFromTime() {
        return this.fromTime;
    }

    public boolean getIsFixed() {
        return this.isFixed;
    }

    public double getLat() {
        return this.lat;
    }

    public double getLon() {
        return this.lon;
    }

    public int getPid() {
        return this.pid;
    }

    public int getRunMode() {
        return this.runMode;
    }

    public int getSerialNum() {
        return this.serialNum;
    }

    public int getUnid() {
        return this.unid;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setEndTime(String str) {
        this.endTime = str;
    }

    public void setFromTime(String str) {
        this.fromTime = str;
    }

    public void setIsFixed(boolean z) {
        this.isFixed = z;
    }

    public void setLat(double d) {
        this.lat = d;
    }

    public void setLon(double d) {
        this.lon = d;
    }

    public void setPid(int i) {
        this.pid = i;
    }

    public void setRunMode(int i) {
        this.runMode = i;
    }

    public void setSerialNum(int i) {
        this.serialNum = i;
    }

    public void setUnid(int i) {
        this.unid = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RunPoint{desc='");
        stringBuilder.append(this.desc);
        stringBuilder.append('\'');
        stringBuilder.append(", pid=");
        stringBuilder.append(this.pid);
        stringBuilder.append(", unid=");
        stringBuilder.append(this.unid);
        stringBuilder.append(", lon=");
        stringBuilder.append(this.lon);
        stringBuilder.append(", lat=");
        stringBuilder.append(this.lat);
        stringBuilder.append(", isFixed=");
        stringBuilder.append(this.isFixed);
        stringBuilder.append(", fromTime='");
        stringBuilder.append(this.fromTime);
        stringBuilder.append('\'');
        stringBuilder.append(", endTime='");
        stringBuilder.append(this.endTime);
        stringBuilder.append('\'');
        stringBuilder.append(", runMode=");
        stringBuilder.append(this.runMode);
        stringBuilder.append(", serialNum=");
        stringBuilder.append(this.serialNum);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
