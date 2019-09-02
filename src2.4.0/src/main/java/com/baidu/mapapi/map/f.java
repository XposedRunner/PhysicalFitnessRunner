package com.baidu.mapapi.map;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class f implements Creator<BaiduMapOptions> {
    f() {
    }

    /* renamed from: a */
    public BaiduMapOptions createFromParcel(Parcel parcel) {
        return new BaiduMapOptions(parcel);
    }

    /* renamed from: a */
    public BaiduMapOptions[] newArray(int i) {
        return new BaiduMapOptions[i];
    }
}
