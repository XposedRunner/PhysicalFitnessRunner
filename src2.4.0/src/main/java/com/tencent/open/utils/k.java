package com.tencent.open.utils;

/* compiled from: ProGuard */
public final class k implements Cloneable {
    private long a;

    public k(long j) {
        this.a = j;
    }

    public byte[] a() {
        return new byte[]{(byte) ((int) (this.a & 255)), (byte) ((int) ((this.a & 65280) >> 8)), (byte) ((int) ((this.a & 16711680) >> 16)), (byte) ((int) ((this.a & 4278190080L) >> 24))};
    }

    public long b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null || !(obj instanceof k)) {
            return false;
        }
        if (this.a == ((k) obj).b()) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return (int) this.a;
    }
}
