package com.baidu.mapsdkplatform.comapi.synchronization.render;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class a implements Creator<LinkPointPolyLineInfo> {
    a() {
    }

    /* renamed from: a */
    public LinkPointPolyLineInfo createFromParcel(Parcel parcel) {
        return new LinkPointPolyLineInfo(parcel);
    }

    /* renamed from: a */
    public LinkPointPolyLineInfo[] newArray(int i) {
        return new LinkPointPolyLineInfo[i];
    }
}
