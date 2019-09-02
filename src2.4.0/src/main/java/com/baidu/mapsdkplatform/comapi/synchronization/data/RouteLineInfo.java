package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.model.LatLng;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class RouteLineInfo implements Parcelable {
    public static final Creator<RouteLineInfo> CREATOR = new b();
    private boolean a;
    private String b;
    private CopyOnWriteArrayList<RouteSectionInfo> c;

    public static final class RouteSectionInfo implements Parcelable {
        public static final Creator<RouteSectionInfo> CREATOR = new c();
        private LatLng a;
        private LatLng b;

        public RouteSectionInfo() {
            this.a = null;
            this.b = null;
            this.a = null;
            this.b = null;
        }

        protected RouteSectionInfo(Parcel parcel) {
            this.a = null;
            this.b = null;
            this.a = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            this.b = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        }

        public LatLng a() {
            return this.a;
        }

        public void a(LatLng latLng) {
            this.a = latLng;
        }

        public LatLng b() {
            return this.b;
        }

        public void b(LatLng latLng) {
            this.b = latLng;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.a, i);
            parcel.writeParcelable(this.b, i);
        }
    }

    public RouteLineInfo() {
        this.a = false;
        this.b = null;
        this.c = new CopyOnWriteArrayList();
    }

    protected RouteLineInfo(Parcel parcel) {
        this.a = parcel.readByte() != (byte) 0;
        this.b = parcel.readString();
    }

    public String a() {
        return this.b;
    }

    public void a(RouteSectionInfo routeSectionInfo) {
        if (this.c != null) {
            this.c.add(routeSectionInfo);
        }
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(boolean z) {
        this.a = z;
    }

    public List<RouteSectionInfo> b() {
        return this.c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) this.a);
        parcel.writeString(this.b);
        parcel.writeTypedList(this.c);
    }
}
