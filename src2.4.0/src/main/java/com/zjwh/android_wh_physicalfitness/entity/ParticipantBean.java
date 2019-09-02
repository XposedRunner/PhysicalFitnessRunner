package com.zjwh.android_wh_physicalfitness.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ParticipantBean implements Parcelable {
    public static final Creator<ParticipantBean> CREATOR = new Creator<ParticipantBean>() {
        public ParticipantBean createFromParcel(Parcel parcel) {
            return new ParticipantBean(parcel);
        }

        public ParticipantBean[] newArray(int i) {
            return new ParticipantBean[i];
        }
    };
    private String iconUrl;
    private int sex;
    private int uid;

    protected ParticipantBean(Parcel parcel) {
        this.uid = parcel.readInt();
        this.iconUrl = parcel.readString();
        this.sex = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public int getSex() {
        return this.sex;
    }

    public int getUid() {
        return this.uid;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public void setSex(int i) {
        this.sex = i;
    }

    public void setUid(int i) {
        this.uid = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ParticipantBean{uid=");
        stringBuilder.append(this.uid);
        stringBuilder.append(", iconUrl='");
        stringBuilder.append(this.iconUrl);
        stringBuilder.append('\'');
        stringBuilder.append(", sex=");
        stringBuilder.append(this.sex);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.uid);
        parcel.writeString(this.iconUrl);
        parcel.writeInt(this.sex);
    }
}
