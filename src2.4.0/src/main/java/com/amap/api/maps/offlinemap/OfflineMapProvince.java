package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Iterator;

public class OfflineMapProvince extends Province {
    public static final Creator<OfflineMapProvince> CREATOR = new Creator<OfflineMapProvince>() {
        /* renamed from: a */
        public OfflineMapProvince createFromParcel(Parcel parcel) {
            return new OfflineMapProvince(parcel);
        }

        /* renamed from: a */
        public OfflineMapProvince[] newArray(int i) {
            return new OfflineMapProvince[i];
        }
    };
    private String a;
    private int b = 6;
    private long c;
    private String d;
    private int e = 0;
    private ArrayList<OfflineMapCity> f;

    public OfflineMapProvince(Parcel parcel) {
        super(parcel);
        this.a = parcel.readString();
        this.b = parcel.readInt();
        this.c = parcel.readLong();
        this.d = parcel.readString();
        this.e = parcel.readInt();
        this.f = parcel.createTypedArrayList(OfflineMapCity.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public ArrayList<OfflineMapCity> getCityList() {
        return this.f == null ? new ArrayList() : this.f;
    }

    public ArrayList<OfflineMapCity> getDownloadedCityList() {
        ArrayList arrayList = new ArrayList();
        if (this.f == null) {
            return arrayList;
        }
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            OfflineMapCity offlineMapCity = (OfflineMapCity) it.next();
            if (offlineMapCity.getState() != 6) {
                arrayList.add(offlineMapCity);
            }
        }
        return arrayList;
    }

    public long getSize() {
        return this.c;
    }

    public int getState() {
        return this.b;
    }

    public String getUrl() {
        return this.a;
    }

    public String getVersion() {
        return this.d;
    }

    public int getcompleteCode() {
        return this.e;
    }

    public void setCityList(ArrayList<OfflineMapCity> arrayList) {
        this.f = arrayList;
    }

    public void setCompleteCode(int i) {
        this.e = i;
    }

    public void setSize(long j) {
        this.c = j;
    }

    public void setState(int i) {
        this.b = i;
    }

    public void setUrl(String str) {
        this.a = str;
    }

    public void setVersion(String str) {
        this.d = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.a);
        parcel.writeInt(this.b);
        parcel.writeLong(this.c);
        parcel.writeString(this.d);
        parcel.writeInt(this.e);
        parcel.writeTypedList(this.f);
    }
}
