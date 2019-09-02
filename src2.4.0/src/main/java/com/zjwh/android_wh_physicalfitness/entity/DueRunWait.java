package com.zjwh.android_wh_physicalfitness.entity;

public class DueRunWait {
    private long enterTime;
    private String icon;
    private double lat;
    private double lon;
    private String name;
    private int sex;
    private int uid;

    public long getEnterTime() {
        return this.enterTime;
    }

    public String getIcon() {
        return this.icon;
    }

    public double getLat() {
        return this.lat;
    }

    public double getLon() {
        return this.lon;
    }

    public String getName() {
        return this.name;
    }

    public int getSex() {
        return this.sex;
    }

    public int getUid() {
        return this.uid;
    }

    public void setEnterTime(long j) {
        this.enterTime = j;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setLat(double d) {
        this.lat = d;
    }

    public void setLon(double d) {
        this.lon = d;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSex(int i) {
        this.sex = i;
    }

    public void setUid(int i) {
        this.uid = i;
    }
}
