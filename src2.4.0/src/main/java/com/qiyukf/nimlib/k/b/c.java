package com.qiyukf.nimlib.k.b;

import android.opengl.GLES10;

public final class c {
    private static int a;

    public static final int a() {
        if (a > 0) {
            return a;
        }
        int[] iArr = new int[1];
        GLES10.glGetIntegerv(3379, iArr, 0);
        int i = iArr[0];
        a = i;
        return i;
    }

    public static final int a(int i, int i2, int i3) {
        int a = a();
        if (a <= 0 || (i2 <= i && i3 <= i)) {
            return i;
        }
        while (true) {
            float f = (float) i;
            float f2 = (float) a;
            if (((float) i2) / f <= f2 && ((float) i3) / f <= f2) {
                break;
            }
            i++;
        }
        if (((i - 1) & i) == 0) {
            return i;
        }
        i2 = 0;
        while (i > 0) {
            i >>= 1;
            i2++;
        }
        return 1 << i2;
    }

    public static int a(int i, int i2, int i3, int i4) {
        int i5 = 1;
        if (i > 0) {
            if (i2 <= 0) {
                return 1;
            }
            if (i3 <= 0 && i4 <= 0) {
                return 1;
            }
            if (i3 <= 0) {
                i3 = (int) ((((float) (i * i4)) / ((float) i2)) + 0.5f);
            } else if (i4 <= 0) {
                i4 = (int) ((((float) (i2 * i3)) / ((float) i)) + 0.5f);
            }
            if (i2 > i4 || i > i3) {
                int round = Math.round(((float) i2) / ((float) i4));
                int round2 = Math.round(((float) i) / ((float) i3));
                if (round >= round2) {
                    round = round2;
                }
                if (round == 0) {
                    round = 1;
                }
                float f = (float) (i * i2);
                i5 = round;
                while (f / ((float) (i5 * i5)) > ((float) ((i3 * i4) << 1))) {
                    i5++;
                }
            }
        }
        return i5;
    }

    public static int a(String str) {
        int[] a = a.a(str);
        int i = a[0];
        int i2 = 1;
        int i3 = a[1];
        if (i > 0 && i3 > 0) {
            i3 = (int) Math.sqrt((double) (((float) (i * i3)) / 1166400.0f));
            if (i3 <= 0) {
                return 1;
            }
            i2 = i3;
        }
        return i2;
    }
}
