package com.zjwh.android_wh_physicalfitness.entity.request;

public class QDueRunWatch {
    private double lat;
    private double lon;
    private int uid;
    private int unid;

    public QDueRunWatch(int i, int i2, double d, double d2) {
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
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
