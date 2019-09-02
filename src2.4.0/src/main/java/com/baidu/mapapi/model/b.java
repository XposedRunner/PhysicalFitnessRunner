package com.baidu.mapapi.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class b implements Creator<LatLngBounds> {
    b() {
    }

    /* renamed from: a */
    public LatLngBounds createFromParcel(Parcel parcel) {
        return new LatLngBounds(parcel);
    }

    /* renamed from: a */
    public LatLngBounds[] newArray(int i) {
        return new LatLngBounds[i];
    }
}
