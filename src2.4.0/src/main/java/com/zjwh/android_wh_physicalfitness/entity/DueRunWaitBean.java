package com.zjwh.android_wh_physicalfitness.entity;

import java.util.List;

public class DueRunWaitBean {
    public static final int ROOM_STATUS_DISBAND = 3;
    public static final int ROOM_STATUS_ENTER = 1;
    public static final int ROOM_STATUS_FULL = 4;
    public static final int ROOM_STATUS_RUNNING = 2;
    private boolean currUserEnter;
    private List<DueRunInOrOut> inOrOutMember;
    private long leftTime;
    private String locDesc;
    private long locLat;
    private long locLon;
    private List<DueRunWait> roomMember;
    private String roomName;
    private String roomNum;
    private int roomStatus;

    public List<DueRunInOrOut> getInOrOutMember() {
        return this.inOrOutMember;
    }

    public long getLeftTime() {
        return this.leftTime;
    }

    public String getLocDesc() {
        return this.locDesc;
    }

    public long getLocLat() {
        return this.locLat;
    }

    public long getLocLon() {
        return this.locLon;
    }

    public List<DueRunWait> getRoomMember() {
        return this.roomMember;
    }

    public String getRoomName() {
        return this.roomName;
    }

    public String getRoomNum() {
        return this.roomNum;
    }

    public int getRoomStatus() {
        return this.roomStatus;
    }

    public boolean isCurrUserEnter() {
        return this.currUserEnter;
    }

    public void setCurrUserEnter(boolean z) {
        this.currUserEnter = z;
    }

    public void setInOrOutMember(List<DueRunInOrOut> list) {
        this.inOrOutMember = list;
    }

    public void setLeftTime(long j) {
        this.leftTime = j;
    }

    public void setLocDesc(String str) {
        this.locDesc = str;
    }

    public void setLocLat(long j) {
        this.locLat = j;
    }

    public void setLocLon(long j) {
        this.locLon = j;
    }

    public void setRoomMember(List<DueRunWait> list) {
        this.roomMember = list;
    }

    public void setRoomName(String str) {
        this.roomName = str;
    }

    public void setRoomNum(String str) {
        this.roomNum = str;
    }

    public void setRoomStatus(int i) {
        this.roomStatus = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DueRunWaitBean{roomMember=");
        stringBuilder.append(this.roomMember);
        stringBuilder.append(", inOrOutMember=");
        stringBuilder.append(this.inOrOutMember);
        stringBuilder.append(", roomStatus=");
        stringBuilder.append(this.roomStatus);
        stringBuilder.append(", roomName='");
        stringBuilder.append(this.roomName);
        stringBuilder.append('\'');
        stringBuilder.append(", roomNum='");
        stringBuilder.append(this.roomNum);
        stringBuilder.append('\'');
        stringBuilder.append(", locDesc='");
        stringBuilder.append(this.locDesc);
        stringBuilder.append('\'');
        stringBuilder.append(", locLon=");
        stringBuilder.append(this.locLon);
        stringBuilder.append(", locLat=");
        stringBuilder.append(this.locLat);
        stringBuilder.append(", leftTime=");
        stringBuilder.append(this.leftTime);
        stringBuilder.append(", currUserEnter=");
        stringBuilder.append(this.currUserEnter);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
