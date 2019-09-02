package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.ae.gmap.maploader.Pools.SynchronizedPool;

public final class Tile implements Parcelable {
    public static final b CREATOR = new b();
    private static final SynchronizedPool<Tile> M_POOL = new SynchronizedPool(18);
    public final byte[] data;
    public final int height;
    private final int mVersionCode;
    public final int width;

    Tile(int i, int i2, int i3, byte[] bArr) {
        this.mVersionCode = i;
        this.width = i2;
        this.height = i3;
        this.data = bArr;
    }

    public Tile(int i, int i2, byte[] bArr) {
        this(1, i, i2, bArr);
    }

    public static Tile obtain(int i, int i2, byte[] bArr) {
        Tile tile = (Tile) M_POOL.acquire();
        return tile != null ? tile : new Tile(i, i2, bArr);
    }

    public int describeContents() {
        return 0;
    }

    public void recycle() {
        M_POOL.release(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mVersionCode);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeByteArray(this.data);
    }
}
