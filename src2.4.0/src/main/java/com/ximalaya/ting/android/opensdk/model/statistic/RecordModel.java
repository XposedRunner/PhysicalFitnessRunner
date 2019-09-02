package com.ximalaya.ting.android.opensdk.model.statistic;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class RecordModel implements Parcelable {
    public static final Creator<RecordModel> CREATOR = new Creator<RecordModel>() {
        public RecordModel createFromParcel(Parcel parcel) {
            RecordModel recordModel = new RecordModel();
            recordModel.readFromParcel(parcel);
            return recordModel;
        }

        public RecordModel[] newArray(int i) {
            return new RecordModel[i];
        }
    };
    public static final int DEVICE_ABQ = 9;
    public static final int DEVICE_CC = 5;
    public static final int DEVICE_FORD = 4;
    public static final int DEVICE_MY_SPIN = 10;
    public static final int TYPE_BLUETOOTH = 1;
    public static final int TYPE_MY_SPIN = 3;
    public static final int TYPE_USB = 4;
    public static final int TYPE_WIFI = 2;
    int device;
    String deviceName;
    int type;

    public RecordModel(int i, int i2, String str) {
        this.type = i;
        this.device = i2;
        this.deviceName = str;
    }

    public int describeContents() {
        return 0;
    }

    public int getDevice() {
        return this.device;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public int getType() {
        return this.type;
    }

    public void readFromParcel(Parcel parcel) {
        setType(parcel.readInt());
        setDevice(parcel.readInt());
        setDeviceName(parcel.readString());
    }

    public void setDevice(int i) {
        this.device = i;
    }

    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.type);
        parcel.writeInt(this.device);
        parcel.writeString(this.deviceName);
    }
}
