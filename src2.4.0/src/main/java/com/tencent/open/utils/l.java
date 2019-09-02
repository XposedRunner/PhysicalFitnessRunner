package com.tencent.open.utils;

import android.support.v4.view.MotionEventCompat;

/* compiled from: ProGuard */
public final class l implements Cloneable {
    private int a;

    public l(int i) {
        this.a = i;
    }

    public l(byte[] bArr) {
        this(bArr, 0);
    }

    public l(byte[] bArr, int i) {
        this.a = (bArr[i + 1] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK;
        this.a += bArr[i] & 255;
    }

    public byte[] a() {
        return new byte[]{(byte) (this.a & 255), (byte) ((this.a & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8)};
    }

    public int b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null || !(obj instanceof l)) {
            return false;
        }
        if (this.a == ((l) obj).b()) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return this.a;
    }
}
