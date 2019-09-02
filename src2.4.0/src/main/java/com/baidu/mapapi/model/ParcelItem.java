package com.baidu.mapapi.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ParcelItem implements Parcelable {
    public static final Creator<ParcelItem> CREATOR = new c();
    private Bundle a;

    public int describeContents() {
        return 0;
    }

    public Bundle getBundle() {
        return this.a;
    }

    public void setBundle(Bundle bundle) {
        this.a = bundle;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.a);
    }
}
