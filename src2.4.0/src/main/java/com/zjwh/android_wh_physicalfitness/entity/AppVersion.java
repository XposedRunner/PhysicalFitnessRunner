package com.zjwh.android_wh_physicalfitness.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AppVersion implements Parcelable {
    public static final Creator<AppVersion> CREATOR = new Creator<AppVersion>() {
        public AppVersion createFromParcel(Parcel parcel) {
            return new AppVersion(parcel);
        }

        public AppVersion[] newArray(int i) {
            return new AppVersion[i];
        }
    };
    private String appVersion;
    private int delayWaitTime;
    private String downloadUrl;
    private int isForse;
    private double pkgSize;
    private String updateMsg;
    private String updateType;

    protected AppVersion(Parcel parcel) {
        this.appVersion = parcel.readString();
        this.downloadUrl = parcel.readString();
        this.isForse = parcel.readInt();
        this.updateMsg = parcel.readString();
        this.updateType = parcel.readString();
        this.pkgSize = parcel.readDouble();
        this.delayWaitTime = parcel.readInt();
    }

    public AppVersion(String str, String str2, int i, String str3, double d) {
        this.appVersion = str;
        this.downloadUrl = str2;
        this.isForse = i;
        this.updateMsg = str3;
        this.pkgSize = d;
    }

    public int describeContents() {
        return 0;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public int getDelayWaitTime() {
        return this.delayWaitTime;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public int getIsForse() {
        return this.isForse;
    }

    public double getPkgSize() {
        return this.pkgSize;
    }

    public String getUpdateMsg() {
        return this.updateMsg;
    }

    public String getUpdateType() {
        return this.updateType;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public void setDelayWaitTime(int i) {
        this.delayWaitTime = i;
    }

    public void setDownloadUrl(String str) {
        this.downloadUrl = str;
    }

    public void setIsForse(int i) {
        this.isForse = i;
    }

    public void setPkgSize(double d) {
        this.pkgSize = d;
    }

    public void setUpdateMsg(String str) {
        this.updateMsg = str;
    }

    public void setUpdateType(String str) {
        this.updateType = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appVersion);
        parcel.writeString(this.downloadUrl);
        parcel.writeInt(this.isForse);
        parcel.writeString(this.updateMsg);
        parcel.writeString(this.updateType);
        parcel.writeDouble(this.pkgSize);
        parcel.writeInt(this.delayWaitTime);
    }
}
