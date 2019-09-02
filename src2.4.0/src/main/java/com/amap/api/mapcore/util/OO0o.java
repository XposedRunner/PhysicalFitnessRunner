package com.amap.api.mapcore.util;

/* compiled from: EarClippingTriangulator */
public class OO0o {
    private final OOOOO00 O000000o = new OOOOO00();
    private short[] O00000Oo;
    private int O00000o;
    private double[] O00000o0;
    private final OOO0OO0 O00000oO = new OOO0OO0();
    private final OOOOO00 O00000oo = new OOOOO00();

    private static int O000000o(double d, double d2, double d3, double d4, double d5, double d6) {
        return (int) Math.signum(((d * (d6 - d4)) + (d3 * (d2 - d6))) + (d5 * (d4 - d2)));
    }

    private int O000000o(int i) {
        short[] sArr = this.O00000Oo;
        int i2 = sArr[O00000o(i)] * 2;
        int i3 = sArr[i] * 2;
        int i4 = sArr[O00000oO(i)] * 2;
        double[] dArr = this.O00000o0;
        return O000000o(dArr[i2], dArr[i2 + 1], dArr[i3], dArr[i3 + 1], dArr[i4], dArr[i4 + 1]);
    }

    private void O000000o() {
        int[] iArr = this.O00000oO.O000000o;
        while (this.O00000o > 3) {
            int O00000Oo = O00000Oo();
            O00000o0(O00000Oo);
            int O00000o = O00000o(O00000Oo);
            if (O00000Oo == this.O00000o) {
                O00000Oo = 0;
            }
            iArr[O00000o] = O000000o(O00000o);
            iArr[O00000Oo] = O000000o(O00000Oo);
        }
        if (this.O00000o == 3) {
            OOOOO00 ooooo00 = this.O00000oo;
            short[] sArr = this.O00000Oo;
            ooooo00.O000000o(sArr[0]);
            ooooo00.O000000o(sArr[1]);
            ooooo00.O000000o(sArr[2]);
        }
    }

    private int O00000Oo() {
        int i = this.O00000o;
        for (int i2 = 0; i2 < i; i2++) {
            if (O00000Oo(i2)) {
                return i2;
            }
        }
        int[] iArr = this.O00000oO.O000000o;
        for (int i3 = 0; i3 < i; i3++) {
            if (iArr[i3] != -1) {
                return i3;
            }
        }
        return 0;
    }

    private boolean O00000Oo(int i) {
        int[] iArr = this.O00000oO.O000000o;
        if (iArr[i] == -1) {
            return false;
        }
        int O00000o = O00000o(i);
        int O00000oO = O00000oO(i);
        short[] sArr = this.O00000Oo;
        int i2 = sArr[O00000o] * 2;
        int i3 = sArr[i] * 2;
        int i4 = sArr[O00000oO] * 2;
        double[] dArr = this.O00000o0;
        double d = dArr[i2];
        boolean z = true;
        double d2 = dArr[i2 + 1];
        double d3 = dArr[i3];
        double d4 = dArr[i3 + 1];
        double d5 = dArr[i4];
        double d6 = dArr[i4 + 1];
        i3 = O00000oO(O00000oO);
        while (i3 != O00000o) {
            boolean z2;
            if (iArr[i3] != z) {
                O00000oO = sArr[i3] * 2;
                double d7 = dArr[O00000oO];
                double d8 = dArr[O00000oO + z];
                z2 = z;
                if (O000000o(d5, d6, d, d2, d7, d8) >= 0 && O000000o(d, d2, d3, d4, d7, d8) >= 0 && O000000o(d3, d4, d5, d6, d7, d8) >= 0) {
                    return false;
                }
            }
            z2 = z;
            i3 = O00000oO(i3);
            z = z2;
        }
        return z;
    }

    private int O00000o(int i) {
        if (i == 0) {
            i = this.O00000o;
        }
        return i - 1;
    }

    private void O00000o0(int i) {
        short[] sArr = this.O00000Oo;
        OOOOO00 ooooo00 = this.O00000oo;
        ooooo00.O000000o(sArr[O00000o(i)]);
        ooooo00.O000000o(sArr[i]);
        ooooo00.O000000o(sArr[O00000oO(i)]);
        this.O000000o.O00000Oo(i);
        this.O00000oO.O00000Oo(i);
        this.O00000o--;
    }

    private int O00000oO(int i) {
        return (i + 1) % this.O00000o;
    }

    public OOOOO00 O000000o(double[] dArr) {
        return O000000o(dArr, 0, dArr.length);
    }

    public OOOOO00 O000000o(double[] dArr, int i, int i2) {
        this.O00000o0 = dArr;
        i2 /= 2;
        this.O00000o = i2;
        i /= 2;
        OOOOO00 ooooo00 = this.O000000o;
        ooooo00.O000000o();
        ooooo00.O00000o0(i2);
        ooooo00.O00000Oo = i2;
        short[] sArr = ooooo00.O000000o;
        this.O00000Oo = sArr;
        int i3 = i2 - 1;
        for (int i4 = 0; i4 < i2; i4++) {
            sArr[i4] = (short) ((i + i3) - i4);
        }
        OOO0OO0 ooo0oo0 = this.O00000oO;
        ooo0oo0.O000000o();
        ooo0oo0.O00000o0(i2);
        for (i = 0; i < i2; i++) {
            ooo0oo0.O000000o(O000000o(i));
        }
        ooooo00 = this.O00000oo;
        ooooo00.O000000o();
        ooooo00.O00000o0(Math.max(0, i2 - 2) * 3);
        O000000o();
        return ooooo00;
    }
}
