package com.baidu.mapapi.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class a implements Creator<LatLng> {
    a() {
    }

    /* renamed from: a */
    public LatLng createFromParcel(Parcel parcel) {
        return new LatLng(parcel);
    }

    /* renamed from: a */
    public LatLng[] newArray(int i) {
        return new LatLng[i];
    }
}
