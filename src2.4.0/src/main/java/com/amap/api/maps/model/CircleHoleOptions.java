package com.amap.api.maps.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CircleHoleOptions extends BaseHoleOptions implements Parcelable {
    public static final Creator<CircleHoleOptions> CREATOR = new Creator<CircleHoleOptions>() {
        /* renamed from: a */
        public CircleHoleOptions createFromParcel(Parcel parcel) {
            return new CircleHoleOptions(parcel);
        }

        /* renamed from: a */
        public CircleHoleOptions[] newArray(int i) {
            return new CircleHoleOptions[i];
        }
    };
    private LatLng point;
    private double radius;

    public CircleHoleOptions() {
        this.point = null;
        this.radius = 0.0d;
        this.isPolygonHoleOptions = false;
    }

    protected CircleHoleOptions(Parcel parcel) {
        this.point = null;
        this.radius = 0.0d;
        Bundle readBundle = parcel.readBundle();
        this.point = new LatLng(readBundle.getDouble("lat"), readBundle.getDouble("lng"));
        this.radius = parcel.readDouble();
    }

    public CircleHoleOptions center(LatLng latLng) {
        this.point = latLng;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public LatLng getCenter() {
        return this.point;
    }

    public double getRadius() {
        return this.radius;
    }

    public CircleHoleOptions radius(double d) {
        this.radius = d;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();
        if (this.point != null) {
            bundle.putDouble("lat", this.point.latitude);
            bundle.putDouble("lng", this.point.longitude);
        }
        parcel.writeBundle(bundle);
        parcel.writeDouble(this.radius);
    }
}
