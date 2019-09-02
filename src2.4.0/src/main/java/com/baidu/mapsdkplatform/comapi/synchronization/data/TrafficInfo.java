package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public final class TrafficInfo implements Parcelable {
    public static final Creator<TrafficInfo> CREATOR = new n();
    private boolean a;
    private String b;
    private ArrayList<Integer> c;

    public TrafficInfo() {
        this.a = false;
        this.b = null;
        this.a = false;
        this.b = null;
        this.c = new ArrayList();
    }

    protected TrafficInfo(Parcel parcel) {
        boolean z = false;
        this.a = false;
        this.b = null;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        }
        this.a = z;
        this.b = parcel.readString();
    }

    public String a() {
        return this.b;
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(ArrayList<Integer> arrayList) {
        this.c = arrayList;
    }

    public void a(boolean z) {
        this.a = z;
    }

    public ArrayList<Integer> b() {
        return this.c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) this.a);
        parcel.writeString(this.b);
    }
}
