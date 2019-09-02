package com.amap.api.mapcore.util;

/* compiled from: IntArray */
public class OOO0OO0 {
    public int[] O000000o;
    public int O00000Oo;
    public boolean O00000o0;

    public OOO0OO0() {
        this(true, 16);
    }

    public OOO0OO0(boolean z, int i) {
        this.O00000o0 = z;
        this.O000000o = new int[i];
    }

    public void O000000o() {
        this.O00000Oo = 0;
    }

    public void O000000o(int i) {
        int[] iArr = this.O000000o;
        if (this.O00000Oo == iArr.length) {
            iArr = O00000o(Math.max(8, (int) (((float) this.O00000Oo) * 1.75f)));
        }
        int i2 = this.O00000Oo;
        this.O00000Oo = i2 + 1;
        iArr[i2] = i;
    }

    public int O00000Oo(int i) {
        if (i >= this.O00000Oo) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("index can't be >= size: ");
            stringBuilder.append(i);
            stringBuilder.append(" >= ");
            stringBuilder.append(this.O00000Oo);
            throw new IndexOutOfBoundsException(stringBuilder.toString());
        }
        int[] iArr = this.O000000o;
        int i2 = iArr[i];
        this.O00000Oo--;
        if (this.O00000o0) {
            System.arraycopy(iArr, i + 1, iArr, i, this.O00000Oo - i);
        } else {
            iArr[i] = iArr[this.O00000Oo];
        }
        return i2;
    }

    /* Access modifiers changed, original: protected */
    public int[] O00000o(int i) {
        int[] iArr = new int[i];
        System.arraycopy(this.O000000o, 0, iArr, 0, Math.min(this.O00000Oo, iArr.length));
        this.O000000o = iArr;
        return iArr;
    }

    public int[] O00000o0(int i) {
        int i2 = this.O00000Oo + i;
        if (i2 > this.O000000o.length) {
            O00000o(Math.max(8, i2));
        }
        return this.O000000o;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OOO0OO0)) {
            return false;
        }
        OOO0OO0 ooo0oo0 = (OOO0OO0) obj;
        int i = this.O00000Oo;
        if (i != ooo0oo0.O00000Oo) {
            return false;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (this.O000000o[i2] != ooo0oo0.O000000o[i2]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return 42;
    }

    public String toString() {
        if (this.O00000Oo == 0) {
            return "[]";
        }
        int[] iArr = this.O000000o;
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append('[');
        stringBuilder.append(iArr[0]);
        for (int i = 1; i < this.O00000Oo; i++) {
            stringBuilder.append(", ");
            stringBuilder.append(iArr[i]);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
