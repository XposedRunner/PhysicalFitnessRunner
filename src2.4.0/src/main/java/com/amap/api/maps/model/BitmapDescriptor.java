package com.amap.api.maps.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Parcel;
import android.os.Parcelable;

public final class BitmapDescriptor implements Parcelable, Cloneable {
    public static final BitmapDescriptorCreator CREATOR = new BitmapDescriptorCreator();
    int a;
    int b;
    Bitmap c;
    private String mId;

    BitmapDescriptor(Bitmap bitmap) {
        this(bitmap, null);
    }

    private BitmapDescriptor(Bitmap bitmap, int i, int i2, String str) {
        this.a = 0;
        this.b = 0;
        this.a = i;
        this.b = i2;
        this.c = bitmap;
        this.mId = str;
    }

    BitmapDescriptor(Bitmap bitmap, String str) {
        this.a = 0;
        this.b = 0;
        if (bitmap != null) {
            this.a = bitmap.getWidth();
            this.b = bitmap.getHeight();
            if (bitmap.getConfig() == null) {
                this.c = bitmap.copy(Config.ARGB_8888, true);
            } else {
                this.c = bitmap.copy(bitmap.getConfig(), true);
            }
            this.mId = str;
        }
    }

    public BitmapDescriptor clone() {
        try {
            return new BitmapDescriptor(this.c.copy(this.c.getConfig(), true), this.a, this.b, this.mId);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public int describeContents() {
        return 0;
    }

    /* JADX WARNING: Missing block: B:26:0x004b, code skipped:
            return false;
     */
    /* JADX WARNING: Missing block: B:27:0x004c, code skipped:
            return false;
     */
    public boolean equals(java.lang.Object r4) {
        /*
        r3 = this;
        r0 = r3.c;
        r1 = 0;
        if (r0 == 0) goto L_0x004c;
    L_0x0005:
        r0 = r3.c;
        r0 = r0.isRecycled();
        if (r0 == 0) goto L_0x000e;
    L_0x000d:
        goto L_0x004c;
    L_0x000e:
        if (r4 != 0) goto L_0x0011;
    L_0x0010:
        return r1;
    L_0x0011:
        if (r3 != r4) goto L_0x0015;
    L_0x0013:
        r4 = 1;
        return r4;
    L_0x0015:
        r0 = r3.getClass();
        r2 = r4.getClass();
        if (r0 == r2) goto L_0x0020;
    L_0x001f:
        return r1;
    L_0x0020:
        r4 = (com.amap.api.maps.model.BitmapDescriptor) r4;
        r0 = r4.c;
        if (r0 == 0) goto L_0x004b;
    L_0x0026:
        r0 = r4.c;
        r0 = r0.isRecycled();
        if (r0 == 0) goto L_0x002f;
    L_0x002e:
        goto L_0x004b;
    L_0x002f:
        r0 = r3.a;
        r2 = r4.getWidth();
        if (r0 != r2) goto L_0x004a;
    L_0x0037:
        r0 = r3.b;
        r2 = r4.getHeight();
        if (r0 == r2) goto L_0x0040;
    L_0x003f:
        goto L_0x004a;
    L_0x0040:
        r0 = r3.c;	 Catch:{ Throwable -> 0x0049 }
        r4 = r4.c;	 Catch:{ Throwable -> 0x0049 }
        r4 = r0.sameAs(r4);	 Catch:{ Throwable -> 0x0049 }
        return r4;
    L_0x0049:
        return r1;
    L_0x004a:
        return r1;
    L_0x004b:
        return r1;
    L_0x004c:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.maps.model.BitmapDescriptor.equals(java.lang.Object):boolean");
    }

    public Bitmap getBitmap() {
        return this.c;
    }

    public int getHeight() {
        return this.b;
    }

    public String getId() {
        return this.mId;
    }

    public int getWidth() {
        return this.a;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public void recycle() {
        if (this.c != null && !this.c.isRecycled()) {
            this.c.recycle();
            this.c = null;
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mId);
        parcel.writeParcelable(this.c, i);
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
    }
}
