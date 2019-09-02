package com.zjwh.android_wh_physicalfitness.entity;

public class DueRunReqParam {
    private double lat;
    private double lon;
    private int type;
    private int uid;
    private int unid;

    public DueRunReqParam(int i, double d, double d2, int i2) {
        this.uid = i;
        this.lon = d;
        this.lat = d2;
        this.type = i2;
    }

    public DueRunReqParam(int i, int i2, double d, double d2) {
        this.uid = i;
        this.unid = i2;
        this.lon = d;
        this.lat = d2;
    }

    public double getLat() {
        return this.lat;
    }

    public double getLon() {
        return this.lon;
    }

    public int getType() {
        return this.type;
    }

    public int getUid() {
        return this.uid;
    }

    public int getUnid() {
        return this.unid;
    }

    public void setLat(double d) {
        this.lat = d;
    }

    public void setLon(double d) {
        this.lon = d;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setUid(int i) {
        this.uid = i;
    }

    public void setUnid(int i) {
        this.unid = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DueRunReqParam{lat=");
        stringBuilder.append(this.lat);
        stringBuilder.append(", unid=");
        stringBuilder.append(this.unid);
        stringBuilder.append(", uid=");
        stringBuilder.append(this.uid);
        stringBuilder.append(", lon=");
        stringBuilder.append(this.lon);
        stringBuilder.append(", type=");
        stringBuilder.append(this.type);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
