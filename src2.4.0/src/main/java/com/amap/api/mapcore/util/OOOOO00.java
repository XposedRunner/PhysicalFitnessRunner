package com.amap.api.mapcore.util;

/* compiled from: ShortArray */
public class OOOOO00 {
    public short[] O000000o;
    public int O00000Oo;
    public boolean O00000o0;

    public OOOOO00() {
        this(true, 16);
    }

    public OOOOO00(boolean z, int i) {
        this.O00000o0 = z;
        this.O000000o = new short[i];
    }

    public short O000000o(int i) {
        if (i < this.O00000Oo) {
            return this.O000000o[i];
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("index can't be >= size: ");
        stringBuilder.append(i);
        stringBuilder.append(" >= ");
        stringBuilder.append(this.O00000Oo);
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    public void O000000o() {
        this.O00000Oo = 0;
    }

    public void O000000o(short s) {
        short[] sArr = this.O000000o;
        if (this.O00000Oo == sArr.length) {
            sArr = O00000o(Math.max(8, (int) (((float) this.O00000Oo) * 1.75f)));
        }
        int i = this.O00000Oo;
        this.O00000Oo = i + 1;
        sArr[i] = s;
    }

    public short O00000Oo(int i) {
        if (i >= this.O00000Oo) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("index can't be >= size: ");
            stringBuilder.append(i);
            stringBuilder.append(" >= ");
            stringBuilder.append(this.O00000Oo);
            throw new IndexOutOfBoundsException(stringBuilder.toString());
        }
        short[] sArr = this.O000000o;
        short s = sArr[i];
        this.O00000Oo--;
        if (this.O00000o0) {
            System.arraycopy(sArr, i + 1, sArr, i, this.O00000Oo - i);
        } else {
            sArr[i] = sArr[this.O00000Oo];
        }
        return s;
    }

    /* Access modifiers changed, original: protected */
    public short[] O00000o(int i) {
        short[] sArr = new short[i];
        System.arraycopy(this.O000000o, 0, sArr, 0, Math.min(this.O00000Oo, sArr.length));
        this.O000000o = sArr;
        return sArr;
    }

    public short[] O00000o0(int i) {
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
        if (!(obj instanceof OOOOO00)) {
            return false;
        }
        OOOOO00 ooooo00 = (OOOOO00) obj;
        int i = this.O00000Oo;
        if (i != ooooo00.O00000Oo) {
            return false;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (this.O000000o[i2] != ooooo00.O000000o[i2]) {
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
        short[] sArr = this.O000000o;
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append('[');
        stringBuilder.append(sArr[0]);
        for (int i = 1; i < this.O00000Oo; i++) {
            stringBuilder.append(", ");
            stringBuilder.append(sArr[i]);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
