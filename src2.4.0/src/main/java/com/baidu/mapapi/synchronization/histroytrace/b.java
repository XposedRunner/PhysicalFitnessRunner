package com.baidu.mapapi.synchronization.histroytrace;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceData.HistoryTracePoint;

final class b implements Creator<HistoryTracePoint> {
    b() {
    }

    /* renamed from: a */
    public HistoryTracePoint createFromParcel(Parcel parcel) {
        return new HistoryTracePoint(parcel);
    }

    /* renamed from: a */
    public HistoryTracePoint[] newArray(int i) {
        return new HistoryTracePoint[i];
    }
}
