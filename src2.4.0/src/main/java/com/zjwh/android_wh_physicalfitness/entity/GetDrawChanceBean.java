package com.zjwh.android_wh_physicalfitness.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class GetDrawChanceBean implements Parcelable {
    public static final Creator<GetDrawChanceBean> CREATOR = new Creator<GetDrawChanceBean>() {
        public GetDrawChanceBean createFromParcel(Parcel parcel) {
            return new GetDrawChanceBean(parcel);
        }

        public GetDrawChanceBean[] newArray(int i) {
            return new GetDrawChanceBean[i];
        }
    };
    private int luckyDrawCondition;
    private int rrid;
    private String uuid;

    protected GetDrawChanceBean(Parcel parcel) {
        this.uuid = parcel.readString();
        this.rrid = parcel.readInt();
        this.luckyDrawCondition = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public int getLuckyDrawCondition() {
        return this.luckyDrawCondition;
    }

    public int getRrid() {
        return this.rrid;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setLuckyDrawCondition(int i) {
        this.luckyDrawCondition = i;
    }

    public void setRrid(int i) {
        this.rrid = i;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GetDrawChanceBean{uuid='");
        stringBuilder.append(this.uuid);
        stringBuilder.append('\'');
        stringBuilder.append(", rrid=");
        stringBuilder.append(this.rrid);
        stringBuilder.append(", luckyDrawCondition=");
        stringBuilder.append(this.luckyDrawCondition);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.uuid);
        parcel.writeInt(this.rrid);
        parcel.writeInt(this.luckyDrawCondition);
    }
}
