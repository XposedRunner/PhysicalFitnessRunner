package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class n implements Creator<TrafficInfo> {
    n() {
    }

    /* renamed from: a */
    public TrafficInfo createFromParcel(Parcel parcel) {
        return new TrafficInfo(parcel);
    }

    /* renamed from: a */
    public TrafficInfo[] newArray(int i) {
        return new TrafficInfo[i];
    }
}
