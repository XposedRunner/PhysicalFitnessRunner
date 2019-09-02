package com.baidu.mapapi.synchronization.histroytrace;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class a implements Creator<HistoryTraceData> {
    a() {
    }

    /* renamed from: a */
    public HistoryTraceData createFromParcel(Parcel parcel) {
        return new HistoryTraceData(parcel);
    }

    /* renamed from: a */
    public HistoryTraceData[] newArray(int i) {
        return new HistoryTraceData[i];
    }
}
