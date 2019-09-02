package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class PolygonHoleOptions extends BaseHoleOptions implements Parcelable {
    public static final Creator<PolygonHoleOptions> CREATOR = new Creator<PolygonHoleOptions>() {
        /* renamed from: a */
        public PolygonHoleOptions createFromParcel(Parcel parcel) {
            return new PolygonHoleOptions(parcel);
        }

        /* renamed from: a */
        public PolygonHoleOptions[] newArray(int i) {
            return new PolygonHoleOptions[i];
        }
    };
    private final List<LatLng> points;

    public PolygonHoleOptions() {
        this.points = new ArrayList();
        this.isPolygonHoleOptions = true;
    }

    protected PolygonHoleOptions(Parcel parcel) {
        this.points = parcel.createTypedArrayList(LatLng.CREATOR);
        this.isPolygonHoleOptions = true;
    }

    public PolygonHoleOptions addAll(Iterable<LatLng> iterable) {
        try {
            for (LatLng add : iterable) {
                this.points.add(add);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public List<LatLng> getPoints() {
        return this.points;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.points);
    }
}
