package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class b implements Creator<RouteLineInfo> {
    b() {
    }

    /* renamed from: a */
    public RouteLineInfo createFromParcel(Parcel parcel) {
        return new RouteLineInfo(parcel);
    }

    /* renamed from: a */
    public RouteLineInfo[] newArray(int i) {
        return new RouteLineInfo[i];
    }
}
