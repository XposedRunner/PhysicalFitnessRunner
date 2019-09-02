package com.zjwh.android_wh_physicalfitness.entity;

public class RunSendBean {
    private long flag;
    private double lat;
    private double lon;
    private String runec;
    private int sex;
    private int uid;
    private String uuid;

    public RunSendBean(long j, double d, double d2, String str, int i, int i2, String str2) {
        this.flag = j;
        this.lat = d;
        this.lon = d2;
        this.uuid = str;
        this.uid = i;
        this.sex = i2;
        this.runec = str2;
    }

    public long getFlag() {
        return this.flag;
    }

    public double getLat() {
        return this.lat;
    }

    public double getLon() {
        return this.lon;
    }

    public int getSex() {
        return this.sex;
    }

    public int getUid() {
        return this.uid;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setFlag(long j) {
        this.flag = j;
    }

    public void setLat(double d) {
        this.lat = d;
    }

    public void setLon(double d) {
        this.lon = d;
    }

    public void setSex(int i) {
        this.sex = i;
    }

    public void setUid(int i) {
        this.uid = i;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RunSendBean{flag=");
        stringBuilder.append(this.flag);
        stringBuilder.append(", lat=");
        stringBuilder.append(this.lat);
        stringBuilder.append(", lon=");
        stringBuilder.append(this.lon);
        stringBuilder.append(", uuid='");
        stringBuilder.append(this.uuid);
        stringBuilder.append('\'');
        stringBuilder.append(", uid=");
        stringBuilder.append(this.uid);
        stringBuilder.append(", sex=");
        stringBuilder.append(this.sex);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
