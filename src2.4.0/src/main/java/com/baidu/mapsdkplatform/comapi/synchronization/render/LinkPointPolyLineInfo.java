package com.baidu.mapsdkplatform.comapi.synchronization.render;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.model.LatLng;

public final class LinkPointPolyLineInfo implements Parcelable {
    public static final Creator<LinkPointPolyLineInfo> CREATOR = new a();
    private long a;
    private LatLng b;
    private LatLng c;
    private int d;

    public LinkPointPolyLineInfo() {
        this.a = 0;
        this.d = 0;
        this.a = 0;
        this.b = null;
        this.c = null;
        this.d = 0;
    }

    protected LinkPointPolyLineInfo(Parcel parcel) {
        this.a = 0;
        this.d = 0;
        this.a = parcel.readLong();
        this.b = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.c = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.d = parcel.readInt();
    }

    public LatLng a() {
        return this.b;
    }

    public void a(int i) {
        this.d = i;
    }

    public void a(LatLng latLng) {
        this.b = latLng;
    }

    public LatLng b() {
        return this.c;
    }

    public void b(LatLng latLng) {
        this.c = latLng;
    }

    public int c() {
        return this.d;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.a);
        parcel.writeParcelable(this.b, i);
        parcel.writeParcelable(this.c, i);
        parcel.writeInt(this.d);
    }
}
