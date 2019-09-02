package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class j implements Creator<SyncResponseResult> {
    j() {
    }

    /* renamed from: a */
    public SyncResponseResult createFromParcel(Parcel parcel) {
        return new SyncResponseResult(parcel);
    }

    /* renamed from: a */
    public SyncResponseResult[] newArray(int i) {
        return new SyncResponseResult[i];
    }
}
