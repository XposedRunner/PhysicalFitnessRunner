package com.zjwh.android_wh_physicalfitness.entity;

public class DueRunCreateInfo {
    private int beginInterval;
    private String createDate;
    private int createNum;
    private double distance;
    private int id;
    private double lat;
    private double lon;
    private int numLimit;
    private int pid;
    private String roomName;
    private int uid;
    private int unid;

    public int getBeginInterval() {
        return this.beginInterval;
    }

    public String getCreateDate() {
        return this.createDate;
    }

    public int getCreateNum() {
        return this.createNum;
    }

    public double getDistance() {
        return this.distance;
    }

    public int getId() {
        return this.id;
    }

    public double getLat() {
        return this.lat;
    }

    public double getLon() {
        return this.lon;
    }

    public int getNumLimit() {
        return this.numLimit;
    }

    public int getPid() {
        return this.pid;
    }

    public String getRoomName() {
        return this.roomName;
    }

    public int getUid() {
        return this.uid;
    }

    public int getUnid() {
        return this.unid;
    }

    public void setBeginInterval(int i) {
        this.beginInterval = i;
    }

    public void setCreateDate(String str) {
        this.createDate = str;
    }

    public void setCreateNum(int i) {
        this.createNum = i;
    }

    public void setDistance(double d) {
        this.distance = d;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setLat(double d) {
        this.lat = d;
    }

    public void setLon(double d) {
        this.lon = d;
    }

    public void setNumLimit(int i) {
        this.numLimit = i;
    }

    public void setPid(int i) {
        this.pid = i;
    }

    public void setRoomName(String str) {
        this.roomName = str;
    }

    public void setUid(int i) {
        this.uid = i;
    }

    public void setUnid(int i) {
        this.unid = i;
    }
}
