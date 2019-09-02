package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class a implements Creator<DriverPosition> {
    a() {
    }

    /* renamed from: a */
    public DriverPosition createFromParcel(Parcel parcel) {
        return new DriverPosition(parcel);
    }

    /* renamed from: a */
    public DriverPosition[] newArray(int i) {
        return new DriverPosition[i];
    }
}
