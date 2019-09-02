package com.zjwh.android_wh_physicalfitness.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public class DueRun implements Parcelable {
    public static final Creator<DueRun> CREATOR = new Creator<DueRun>() {
        public DueRun createFromParcel(Parcel parcel) {
            return new DueRun(parcel);
        }

        public DueRun[] newArray(int i) {
            return new DueRun[i];
        }
    };
    private long beginTime;
    private int currNum;
    private boolean currUserEnter;
    private float distance;
    private long endTime;
    private String icon;
    private long leftTime;
    private String locDesc;
    private double locLat;
    private double locLon;
    private int locPid;
    private String name;
    private List<ParticipantBean> participants;
    private int roomId;
    private String roomName;
    private String roomNum;
    private int sex;
    private int status;
    private int totalNum;
    private int uid;
    private int unid;

    protected DueRun(Parcel parcel) {
        this.uid = parcel.readInt();
        this.unid = parcel.readInt();
        this.name = parcel.readString();
        this.icon = parcel.readString();
        this.sex = parcel.readInt();
        this.locPid = parcel.readInt();
        this.locDesc = parcel.readString();
        this.roomId = parcel.readInt();
        this.beginTime = parcel.readLong();
        this.endTime = parcel.readLong();
        this.totalNum = parcel.readInt();
        this.currNum = parcel.readInt();
        this.distance = parcel.readFloat();
        this.currUserEnter = parcel.readByte() != (byte) 0;
        this.locLon = parcel.readDouble();
        this.locLat = parcel.readDouble();
        this.roomName = parcel.readString();
        this.roomNum = parcel.readString();
        this.leftTime = parcel.readLong();
        this.status = parcel.readInt();
        this.participants = parcel.createTypedArrayList(ParticipantBean.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public long getBeginTime() {
        return this.beginTime;
    }

    public int getCurrNum() {
        return this.currNum;
    }

    public boolean getCurrUserEnter() {
        return this.currUserEnter;
    }

    public float getDistance() {
        return this.distance;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public String getIcon() {
        return this.icon;
    }

    public long getLeftTime() {
        return this.leftTime;
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

    public int getLocPid() {
        return this.locPid;
    }

    public String getName() {
        return this.name;
    }

    public List<ParticipantBean> getParticipants() {
        return this.participants;
    }

    public int getRoomId() {
        return this.roomId;
    }

    public String getRoomName() {
        return this.roomName;
    }

    public String getRoomNum() {
        return this.roomNum;
    }

    public int getSex() {
        return this.sex;
    }

    public int getStatus() {
        return this.status;
    }

    public int getTotalNum() {
        return this.totalNum;
    }

    public int getUid() {
        return this.uid;
    }

    public int getUnid() {
        return this.unid;
    }

    public boolean isCurrUserEnter() {
        return this.currUserEnter;
    }

    public void setBeginTime(long j) {
        this.beginTime = j;
    }

    public void setCurrNum(int i) {
        this.currNum = i;
    }

    public void setCurrUserEnter(boolean z) {
        this.currUserEnter = z;
    }

    public void setDistance(float f) {
        this.distance = f;
    }

    public void setEndTime(long j) {
        this.endTime = j;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setLeftTime(long j) {
        this.leftTime = j;
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

    public void setLocPid(int i) {
        this.locPid = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setParticipants(List<ParticipantBean> list) {
        this.participants = list;
    }

    public void setRoomId(int i) {
        this.roomId = i;
    }

    public void setRoomName(String str) {
        this.roomName = str;
    }

    public void setRoomNum(String str) {
        this.roomNum = str;
    }

    public void setSex(int i) {
        this.sex = i;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setTotalNum(int i) {
        this.totalNum = i;
    }

    public void setUid(int i) {
        this.uid = i;
    }

    public void setUnid(int i) {
        this.unid = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DueRun{uid=");
        stringBuilder.append(this.uid);
        stringBuilder.append(", unid=");
        stringBuilder.append(this.unid);
        stringBuilder.append(", name='");
        stringBuilder.append(this.name);
        stringBuilder.append('\'');
        stringBuilder.append(", icon='");
        stringBuilder.append(this.icon);
        stringBuilder.append('\'');
        stringBuilder.append(", sex=");
        stringBuilder.append(this.sex);
        stringBuilder.append(", locPid=");
        stringBuilder.append(this.locPid);
        stringBuilder.append(", locDesc='");
        stringBuilder.append(this.locDesc);
        stringBuilder.append('\'');
        stringBuilder.append(", roomId=");
        stringBuilder.append(this.roomId);
        stringBuilder.append(", beginTime=");
        stringBuilder.append(this.beginTime);
        stringBuilder.append(", endTime=");
        stringBuilder.append(this.endTime);
        stringBuilder.append(", totalNum=");
        stringBuilder.append(this.totalNum);
        stringBuilder.append(", currNum=");
        stringBuilder.append(this.currNum);
        stringBuilder.append(", distance=");
        stringBuilder.append(this.distance);
        stringBuilder.append(", currUserEnter=");
        stringBuilder.append(this.currUserEnter);
        stringBuilder.append(", locLon=");
        stringBuilder.append(this.locLon);
        stringBuilder.append(", locLat=");
        stringBuilder.append(this.locLat);
        stringBuilder.append(", roomName='");
        stringBuilder.append(this.roomName);
        stringBuilder.append('\'');
        stringBuilder.append(", roomNum='");
        stringBuilder.append(this.roomNum);
        stringBuilder.append('\'');
        stringBuilder.append(", leftTime=");
        stringBuilder.append(this.leftTime);
        stringBuilder.append(", status=");
        stringBuilder.append(this.status);
        stringBuilder.append(", participants=");
        stringBuilder.append(this.participants);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.uid);
        parcel.writeInt(this.unid);
        parcel.writeString(this.name);
        parcel.writeString(this.icon);
        parcel.writeInt(this.sex);
        parcel.writeInt(this.locPid);
        parcel.writeString(this.locDesc);
        parcel.writeInt(this.roomId);
        parcel.writeLong(this.beginTime);
        parcel.writeLong(this.endTime);
        parcel.writeInt(this.totalNum);
        parcel.writeInt(this.currNum);
        parcel.writeFloat(this.distance);
        parcel.writeByte(this.currUserEnter);
        parcel.writeDouble(this.locLon);
        parcel.writeDouble(this.locLat);
        parcel.writeString(this.roomName);
        parcel.writeString(this.roomNum);
        parcel.writeLong(this.leftTime);
        parcel.writeInt(this.status);
        parcel.writeTypedList(this.participants);
    }
}
