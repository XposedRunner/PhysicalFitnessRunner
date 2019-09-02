package com.ximalaya.ting.android.opensdk.model.token;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AccessToken implements Parcelable {
    public static final Creator<AccessToken> CREATOR = new Creator<AccessToken>() {
        public AccessToken createFromParcel(Parcel parcel) {
            AccessToken accessToken = new AccessToken();
            accessToken.readFromParcel(parcel);
            return accessToken;
        }

        public AccessToken[] newArray(int i) {
            return new AccessToken[i];
        }
    };
    private String mAccessToken;
    private long mExpire;
    private long mLastGetTime;
    private String mRefreshToken;
    private String mThirdToken;
    private String mThirdUid;
    private String mUid;

    public int describeContents() {
        return 0;
    }

    public String getAccessToken() {
        return this.mAccessToken;
    }

    public long getExpire() {
        return this.mExpire;
    }

    public long getLastGetTime() {
        return this.mLastGetTime;
    }

    public String getRefreshToken() {
        return this.mRefreshToken;
    }

    public String getThirdToken() {
        return this.mThirdToken;
    }

    public String getThirdUid() {
        return this.mThirdUid;
    }

    public String getUid() {
        return this.mUid;
    }

    public void readFromParcel(Parcel parcel) {
        this.mAccessToken = parcel.readString();
        this.mExpire = parcel.readLong();
        this.mUid = parcel.readString();
        this.mLastGetTime = parcel.readLong();
        this.mRefreshToken = parcel.readString();
        this.mThirdUid = parcel.readString();
        this.mThirdToken = parcel.readString();
    }

    public void setAccessToken(String str) {
        this.mAccessToken = str;
    }

    public void setExpire(long j) {
        this.mExpire = j;
    }

    public void setLastGetTime(long j) {
        this.mLastGetTime = j;
    }

    public void setRefreshToken(String str) {
        this.mRefreshToken = str;
    }

    public void setThirdToken(String str) {
        this.mThirdToken = str;
    }

    public void setThirdUid(String str) {
        this.mThirdUid = str;
    }

    public void setUid(String str) {
        this.mUid = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mAccessToken);
        parcel.writeLong(this.mExpire);
        parcel.writeString(this.mUid);
        parcel.writeLong(this.mLastGetTime);
        parcel.writeString(this.mRefreshToken);
        parcel.writeString(this.mThirdUid);
        parcel.writeString(this.mThirdToken);
    }
}
