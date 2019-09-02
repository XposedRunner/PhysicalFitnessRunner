package com.zjwh.android_wh_physicalfitness.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MessageNewBean implements Parcelable {
    public static final Creator<MessageNewBean> CREATOR = new Creator<MessageNewBean>() {
        public MessageNewBean createFromParcel(Parcel parcel) {
            return new MessageNewBean(parcel);
        }

        public MessageNewBean[] newArray(int i) {
            return new MessageNewBean[i];
        }
    };
    private int count;
    private int messageType;

    protected MessageNewBean(Parcel parcel) {
        this.messageType = parcel.readInt();
        this.count = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public int getCount() {
        return this.count;
    }

    public int getMessageType() {
        return this.messageType;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public void setMessageType(int i) {
        this.messageType = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MessageNewBean{messageType=");
        stringBuilder.append(this.messageType);
        stringBuilder.append(", count=");
        stringBuilder.append(this.count);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.messageType);
        parcel.writeInt(this.count);
    }
}
