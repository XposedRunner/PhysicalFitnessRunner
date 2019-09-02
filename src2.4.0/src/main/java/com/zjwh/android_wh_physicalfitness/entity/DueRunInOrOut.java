package com.zjwh.android_wh_physicalfitness.entity;

public class DueRunInOrOut {
    public static final int ROOM_STATUS_IN = 1;
    public static final int ROOM_STATUS_OUT = 2;
    private int gender;
    private String headImgUrl;
    private int inOrOutRoom;
    private long inOrOutTime;
    private String name;

    public int getGender() {
        return this.gender;
    }

    public String getHeadImgUrl() {
        return this.headImgUrl;
    }

    public int getInOrOutRoom() {
        return this.inOrOutRoom;
    }

    public long getInOrOutTime() {
        return this.inOrOutTime;
    }

    public String getName() {
        return this.name;
    }

    public void setGender(int i) {
        this.gender = i;
    }

    public void setHeadImgUrl(String str) {
        this.headImgUrl = str;
    }

    public void setInOrOutRoom(int i) {
        this.inOrOutRoom = i;
    }

    public void setInOrOutTime(long j) {
        this.inOrOutTime = j;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DueRunInOrOut{name='");
        stringBuilder.append(this.name);
        stringBuilder.append('\'');
        stringBuilder.append(", inOrOutRoom=");
        stringBuilder.append(this.inOrOutRoom);
        stringBuilder.append(", inOrOutTime=");
        stringBuilder.append(this.inOrOutTime);
        stringBuilder.append(", headImgUrl='");
        stringBuilder.append(this.headImgUrl);
        stringBuilder.append('\'');
        stringBuilder.append(", gender=");
        stringBuilder.append(this.gender);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
