package com.loc;

/* compiled from: HashCodeBuilder */
public final class O0000Oo0 {
    private final int O000000o;
    private int O00000Oo;

    public O0000Oo0() {
        this.O00000Oo = 0;
        this.O000000o = 37;
        this.O00000Oo = 17;
    }

    private O0000Oo0 O000000o(long j) {
        this.O00000Oo = (this.O00000Oo * this.O000000o) + ((int) (j ^ (j >> 32)));
        return this;
    }

    public final int O000000o() {
        return this.O00000Oo;
    }

    public final O0000Oo0 O000000o(Object obj) {
        if (obj != null) {
            if (obj.getClass().isArray()) {
                int i = 0;
                if (obj instanceof long[]) {
                    long[] jArr = (long[]) obj;
                    if (jArr != null) {
                        while (i < jArr.length) {
                            O000000o(jArr[i]);
                            i++;
                        }
                    }
                } else if (obj instanceof int[]) {
                    int[] iArr = (int[]) obj;
                    if (iArr != null) {
                        while (i < iArr.length) {
                            this.O00000Oo = (this.O00000Oo * this.O000000o) + iArr[i];
                            i++;
                        }
                    }
                } else if (obj instanceof short[]) {
                    short[] sArr = (short[]) obj;
                    if (sArr != null) {
                        while (i < sArr.length) {
                            this.O00000Oo = (this.O00000Oo * this.O000000o) + sArr[i];
                            i++;
                        }
                    }
                } else if (obj instanceof char[]) {
                    char[] cArr = (char[]) obj;
                    if (cArr != null) {
                        while (i < cArr.length) {
                            this.O00000Oo = (this.O00000Oo * this.O000000o) + cArr[i];
                            i++;
                        }
                    }
                } else if (obj instanceof byte[]) {
                    byte[] bArr = (byte[]) obj;
                    if (bArr != null) {
                        while (i < bArr.length) {
                            this.O00000Oo = (this.O00000Oo * this.O000000o) + bArr[i];
                            i++;
                        }
                    }
                } else if (obj instanceof double[]) {
                    double[] dArr = (double[]) obj;
                    if (dArr != null) {
                        while (i < dArr.length) {
                            O000000o(Double.doubleToLongBits(dArr[i]));
                            i++;
                        }
                    }
                } else if (obj instanceof float[]) {
                    float[] fArr = (float[]) obj;
                    if (fArr != null) {
                        while (i < fArr.length) {
                            this.O00000Oo = (this.O00000Oo * this.O000000o) + Float.floatToIntBits(fArr[i]);
                            i++;
                        }
                    }
                } else if (obj instanceof boolean[]) {
                    boolean[] zArr = (boolean[]) obj;
                    if (zArr != null) {
                        while (i < zArr.length) {
                            this.O00000Oo = (this.O00000Oo * this.O000000o) + (zArr[i] ^ 1);
                            i++;
                        }
                    }
                } else {
                    O000000o((Object[]) obj);
                    return this;
                }
            }
            this.O00000Oo = (this.O00000Oo * this.O000000o) + obj.hashCode();
            return this;
        }
        this.O00000Oo *= this.O000000o;
        return this;
    }

    public final O0000Oo0 O000000o(Object[] objArr) {
        if (objArr == null) {
            this.O00000Oo *= this.O000000o;
            return this;
        }
        for (Object O000000o : objArr) {
            O000000o(O000000o);
        }
        return this;
    }

    public final int hashCode() {
        return this.O00000Oo;
    }
}
