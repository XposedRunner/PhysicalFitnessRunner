package com.amap.api.maps.model;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public class VisibleRegionCreator implements Creator<VisibleRegion> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void a(VisibleRegion visibleRegion, Parcel parcel, int i) {
        parcel.writeInt(visibleRegion.a());
        parcel.writeParcelable(visibleRegion.nearLeft, i);
        parcel.writeParcelable(visibleRegion.nearRight, i);
        parcel.writeParcelable(visibleRegion.farLeft, i);
        parcel.writeParcelable(visibleRegion.farRight, i);
        parcel.writeParcelable(visibleRegion.latLngBounds, i);
    }

    public VisibleRegion createFromParcel(Parcel parcel) {
        LatLng latLng;
        LatLng latLng2;
        LatLng latLng3;
        BadParcelableException e;
        LatLng latLng4;
        LatLngBounds latLngBounds;
        int readInt = parcel.readInt();
        try {
            latLng = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            try {
                latLng2 = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
                try {
                    latLng3 = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
                } catch (BadParcelableException e2) {
                    e = e2;
                    latLng3 = null;
                    latLng4 = latLng3;
                    e.printStackTrace();
                    latLngBounds = null;
                    return new VisibleRegion(readInt, latLng, latLng2, latLng3, latLng4, latLngBounds);
                }
            } catch (BadParcelableException e3) {
                e = e3;
                latLng2 = null;
                latLng3 = latLng2;
                latLng4 = latLng3;
                e.printStackTrace();
                latLngBounds = null;
                return new VisibleRegion(readInt, latLng, latLng2, latLng3, latLng4, latLngBounds);
            }
            try {
                latLng4 = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
                try {
                    latLngBounds = (LatLngBounds) parcel.readParcelable(LatLngBounds.class.getClassLoader());
                } catch (BadParcelableException e4) {
                    e = e4;
                    e.printStackTrace();
                    latLngBounds = null;
                    return new VisibleRegion(readInt, latLng, latLng2, latLng3, latLng4, latLngBounds);
                }
            } catch (BadParcelableException e5) {
                e = e5;
                latLng4 = null;
                e.printStackTrace();
                latLngBounds = null;
                return new VisibleRegion(readInt, latLng, latLng2, latLng3, latLng4, latLngBounds);
            }
        } catch (BadParcelableException e6) {
            e = e6;
            latLng = null;
            latLng2 = latLng;
            latLng3 = latLng2;
            latLng4 = latLng3;
            e.printStackTrace();
            latLngBounds = null;
            return new VisibleRegion(readInt, latLng, latLng2, latLng3, latLng4, latLngBounds);
        }
        return new VisibleRegion(readInt, latLng, latLng2, latLng3, latLng4, latLngBounds);
    }

    public VisibleRegion[] newArray(int i) {
        return new VisibleRegion[i];
    }
}
