package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class City implements Parcelable {
    public static final Creator<City> CREATOR = new Creator<City>() {
        /* renamed from: a */
        public City createFromParcel(Parcel parcel) {
            return new City(parcel);
        }

        /* renamed from: a */
        public City[] newArray(int i) {
            return new City[i];
        }
    };
    private String a = "";
    private String b = "";
    private String c;
    private String d;
    private String e = "";

    public City(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public String getAdcode() {
        return this.e;
    }

    public String getCity() {
        return this.a;
    }

    public String getCode() {
        return this.b;
    }

    public String getJianpin() {
        return this.c;
    }

    public String getPinyin() {
        return this.d;
    }

    public void setAdcode(String str) {
        this.e = str;
    }

    public void setCity(String str) {
        this.a = str;
    }

    public void setCode(String str) {
        String str2 = "[]";
        if (str != null && !str2.equals(str)) {
            this.b = str;
        }
    }

    public void setJianpin(String str) {
        this.c = str;
    }

    public void setPinyin(String str) {
        this.d = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
    }
}
