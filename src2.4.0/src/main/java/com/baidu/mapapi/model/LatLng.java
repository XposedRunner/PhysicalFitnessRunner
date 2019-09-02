package com.baidu.mapapi.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class LatLng implements Parcelable {
    public static final Creator<LatLng> CREATOR = new a();
    private static final String a = "LatLng";
    public final double latitude;
    public final double latitudeE6;
    public final double longitude;
    public final double longitudeE6;

    public LatLng(double d, double d2) {
        if (Double.isNaN(d) || Double.isNaN(d2) || Double.isInfinite(d) || Double.isInfinite(d2)) {
            this.latitudeE6 = 0.0d;
            this.longitudeE6 = 0.0d;
            this.latitude = 0.0d;
            this.longitude = 0.0d;
            return;
        }
        d *= 1000000.0d;
        d2 *= 1000000.0d;
        this.latitudeE6 = d;
        this.longitudeE6 = d2;
        this.latitude = d / 1000000.0d;
        this.longitude = d2 / 1000000.0d;
    }

    protected LatLng(Parcel parcel) {
        this.latitude = parcel.readDouble();
        this.longitude = parcel.readDouble();
        this.latitudeE6 = parcel.readDouble();
        this.longitudeE6 = parcel.readDouble();
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        String str = new String("latitude: ");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.latitude);
        str = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(", longitude: ");
        str = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.longitude);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.latitude);
        parcel.writeDouble(this.longitude);
        parcel.writeDouble(this.latitudeE6);
        parcel.writeDouble(this.longitudeE6);
    }
}
