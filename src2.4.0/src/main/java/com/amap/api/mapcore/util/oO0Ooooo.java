package com.amap.api.mapcore.util;

/* compiled from: HashCodeBuilder */
public class oO0Ooooo {
    private final int O000000o;
    private int O00000Oo;

    public oO0Ooooo() {
        this.O00000Oo = 0;
        this.O000000o = 37;
        this.O00000Oo = 17;
    }

    public int O000000o() {
        return this.O00000Oo;
    }

    public oO0Ooooo O000000o(byte b) {
        this.O00000Oo = (this.O00000Oo * this.O000000o) + b;
        return this;
    }

    public oO0Ooooo O000000o(char c) {
        this.O00000Oo = (this.O00000Oo * this.O000000o) + c;
        return this;
    }

    public oO0Ooooo O000000o(double d) {
        return O000000o(Double.doubleToLongBits(d));
    }

    public oO0Ooooo O000000o(float f) {
        this.O00000Oo = (this.O00000Oo * this.O000000o) + Float.floatToIntBits(f);
        return this;
    }

    public oO0Ooooo O000000o(int i) {
        this.O00000Oo = (this.O00000Oo * this.O000000o) + i;
        return this;
    }

    public oO0Ooooo O000000o(long j) {
        this.O00000Oo = (this.O00000Oo * this.O000000o) + ((int) (j ^ (j >> 32)));
        return this;
    }

    public oO0Ooooo O000000o(Object obj) {
        if (obj == null) {
            this.O00000Oo *= this.O000000o;
        } else if (!obj.getClass().isArray()) {
            this.O00000Oo = (this.O00000Oo * this.O000000o) + obj.hashCode();
        } else if (obj instanceof long[]) {
            O000000o((long[]) obj);
        } else if (obj instanceof int[]) {
            O000000o((int[]) obj);
        } else if (obj instanceof short[]) {
            O000000o((short[]) obj);
        } else if (obj instanceof char[]) {
            O000000o((char[]) obj);
        } else if (obj instanceof byte[]) {
            O000000o((byte[]) obj);
        } else if (obj instanceof double[]) {
            O000000o((double[]) obj);
        } else if (obj instanceof float[]) {
            O000000o((float[]) obj);
        } else if (obj instanceof boolean[]) {
            O000000o((boolean[]) obj);
        } else {
            O000000o((Object[]) obj);
        }
        return this;
    }

    public oO0Ooooo O000000o(short s) {
        this.O00000Oo = (this.O00000Oo * this.O000000o) + s;
        return this;
    }

    public oO0Ooooo O000000o(boolean z) {
        this.O00000Oo = (this.O00000Oo * this.O000000o) + (z ^ 1);
        return this;
    }

    public oO0Ooooo O000000o(byte[] bArr) {
        if (bArr == null) {
            this.O00000Oo *= this.O000000o;
        } else {
            for (byte O000000o : bArr) {
                O000000o(O000000o);
            }
        }
        return this;
    }

    public oO0Ooooo O000000o(char[] cArr) {
        if (cArr == null) {
            this.O00000Oo *= this.O000000o;
        } else {
            for (char O000000o : cArr) {
                O000000o(O000000o);
            }
        }
        return this;
    }

    public oO0Ooooo O000000o(double[] dArr) {
        if (dArr == null) {
            this.O00000Oo *= this.O000000o;
        } else {
            for (double O000000o : dArr) {
                O000000o(O000000o);
            }
        }
        return this;
    }

    public oO0Ooooo O000000o(float[] fArr) {
        if (fArr == null) {
            this.O00000Oo *= this.O000000o;
        } else {
            for (float O000000o : fArr) {
                O000000o(O000000o);
            }
        }
        return this;
    }

    public oO0Ooooo O000000o(int[] iArr) {
        if (iArr == null) {
            this.O00000Oo *= this.O000000o;
        } else {
            for (int O000000o : iArr) {
                O000000o(O000000o);
            }
        }
        return this;
    }

    public oO0Ooooo O000000o(long[] jArr) {
        if (jArr == null) {
            this.O00000Oo *= this.O000000o;
        } else {
            for (long O000000o : jArr) {
                O000000o(O000000o);
            }
        }
        return this;
    }

    public oO0Ooooo O000000o(Object[] objArr) {
        if (objArr == null) {
            this.O00000Oo *= this.O000000o;
        } else {
            for (Object O000000o : objArr) {
                O000000o(O000000o);
            }
        }
        return this;
    }

    public oO0Ooooo O000000o(short[] sArr) {
        if (sArr == null) {
            this.O00000Oo *= this.O000000o;
        } else {
            for (short O000000o : sArr) {
                O000000o(O000000o);
            }
        }
        return this;
    }

    public oO0Ooooo O000000o(boolean[] zArr) {
        if (zArr == null) {
            this.O00000Oo *= this.O000000o;
        } else {
            for (boolean O000000o : zArr) {
                O000000o(O000000o);
            }
        }
        return this;
    }

    public int hashCode() {
        return O000000o();
    }
}
