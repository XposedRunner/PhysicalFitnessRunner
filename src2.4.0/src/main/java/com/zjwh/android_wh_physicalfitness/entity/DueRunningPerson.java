package com.zjwh.android_wh_physicalfitness.entity;

public class DueRunningPerson {
    private String icon;
    private double lat;
    private double lon;
    private String name;
    private int roomId;
    private int sex;
    private int status;
    private int uid;

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

    public int getRoomId() {
        return this.roomId;
    }

    public int getSex() {
        return this.sex;
    }

    public int getStatus() {
        return this.status;
    }

    public int getUid() {
        return this.uid;
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

    public void setRoomId(int i) {
        this.roomId = i;
    }

    public void setSex(int i) {
        this.sex = i;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setUid(int i) {
        this.uid = i;
    }
}
