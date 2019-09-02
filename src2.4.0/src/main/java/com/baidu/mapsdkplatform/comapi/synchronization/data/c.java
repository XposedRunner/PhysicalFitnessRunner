package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.baidu.mapsdkplatform.comapi.synchronization.data.RouteLineInfo.RouteSectionInfo;

final class c implements Creator<RouteSectionInfo> {
    c() {
    }

    /* renamed from: a */
    public RouteSectionInfo createFromParcel(Parcel parcel) {
        return new RouteSectionInfo(parcel);
    }

    /* renamed from: a */
    public RouteSectionInfo[] newArray(int i) {
        return new RouteSectionInfo[i];
    }
}
