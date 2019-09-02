package com.zjwh.android_wh_physicalfitness.entity;

public class RoomInfoModel {
    private long beginTime;
    private int distance;
    private long endTime;
    private int finishNum;
    private String locDesc;
    private double locLat;
    private double locLon;
    private String roomName;

    public long getBeginTime() {
        return this.beginTime;
    }

    public int getDistance() {
        return this.distance;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public int getFinishNum() {
        return this.finishNum;
    }

    public String getLocDesc() {
        return this.locDesc;
    }

    public double getLocLat() {
        return this.locLat;
    }

    public double getLocLon() {
        return this.locLon;
    }

    public String getRoomName() {
        return this.roomName;
    }

    public void setBeginTime(long j) {
        this.beginTime = j;
    }

    public void setDistance(int i) {
        this.distance = i;
    }

    public void setEndTime(long j) {
        this.endTime = j;
    }

    public void setFinishNum(int i) {
        this.finishNum = i;
    }

    public void setLocDesc(String str) {
        this.locDesc = str;
    }

    public void setLocLat(double d) {
        this.locLat = d;
    }

    public void setLocLon(double d) {
        this.locLon = d;
    }

    public void setRoomName(String str) {
        this.roomName = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RoomInfoModel{beginTime='");
        stringBuilder.append(this.beginTime);
        stringBuilder.append('\'');
        stringBuilder.append(", endTime='");
        stringBuilder.append(this.endTime);
        stringBuilder.append('\'');
        stringBuilder.append(", distance=");
        stringBuilder.append(this.distance);
        stringBuilder.append(", locDesc='");
        stringBuilder.append(this.locDesc);
        stringBuilder.append('\'');
        stringBuilder.append(", finishNum=");
        stringBuilder.append(this.finishNum);
        stringBuilder.append(", roomName='");
        stringBuilder.append(this.roomName);
        stringBuilder.append('\'');
        stringBuilder.append(", locLon=");
        stringBuilder.append(this.locLon);
        stringBuilder.append(", locLat=");
        stringBuilder.append(this.locLat);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
