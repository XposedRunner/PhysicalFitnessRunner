package com.zjwh.android_wh_physicalfitness.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class DueRunCreateResult implements Parcelable {
    public static final Creator<DueRunCreateResult> CREATOR = new Creator<DueRunCreateResult>() {
        public DueRunCreateResult createFromParcel(Parcel parcel) {
            return new DueRunCreateResult(parcel);
        }

        public DueRunCreateResult[] newArray(int i) {
            return new DueRunCreateResult[i];
        }
    };
    private long beginTime;
    private int roomId;
    private String roomNum;

    protected DueRunCreateResult(Parcel parcel) {
        this.roomId = parcel.readInt();
        this.roomNum = parcel.readString();
        this.beginTime = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public long getBeginTime() {
        return this.beginTime;
    }

    public int getRoomId() {
        return this.roomId;
    }

    public String getRoomNum() {
        return this.roomNum;
    }

    public void setBeginTime(long j) {
        this.beginTime = j;
    }

    public void setRoomId(int i) {
        this.roomId = i;
    }

    public void setRoomNum(String str) {
        this.roomNum = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DueRunCreateResult{roomId=");
        stringBuilder.append(this.roomId);
        stringBuilder.append(", roomNum='");
        stringBuilder.append(this.roomNum);
        stringBuilder.append('\'');
        stringBuilder.append(", beginTime=");
        stringBuilder.append(this.beginTime);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.roomId);
        parcel.writeString(this.roomNum);
        parcel.writeLong(this.beginTime);
    }
}
