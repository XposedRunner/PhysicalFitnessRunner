package com.google.zxing.oned.rss;

public final class RSSUtils {
    private RSSUtils() {
    }

    private static int combins(int i, int i2) {
        int i3 = i - i2;
        if (i3 > i2) {
            int i4 = i3;
            i3 = i2;
            i2 = i4;
        }
        int i5 = 1;
        int i6 = 1;
        while (i > i2) {
            i5 *= i;
            if (i6 <= i3) {
                i5 /= i6;
                i6++;
            }
            i--;
        }
        while (i6 <= i3) {
            i5 /= i6;
            i6++;
        }
        return i5;
    }

    public static int getRSSvalue(int[] iArr, int i, boolean z) {
        int[] iArr2 = iArr;
        int i2 = i;
        int length = iArr2.length;
        int i3 = 0;
        for (int i4 : iArr2) {
            i3 += i4;
        }
        int i42 = i3;
        int i5 = 0;
        int i6 = 0;
        i3 = 0;
        while (true) {
            int i7 = length - 1;
            if (i5 >= i7) {
                return i3;
            }
            int i8 = 1 << i5;
            int i9 = i6 | i8;
            i6 = 1;
            while (i6 < iArr2[i5]) {
                int i10;
                int i11 = i42 - i6;
                int i12 = length - i5;
                int i13 = i12 - 2;
                int combins = combins(i11 - 1, i13);
                if (z && i9 == 0) {
                    i10 = i12 - 1;
                    if (i11 - i10 >= i10) {
                        combins -= combins(i11 - i12, i13);
                    }
                }
                if (i12 - 1 > 1) {
                    i10 = i11 - i13;
                    i13 = 0;
                    while (i10 > i2) {
                        i13 += combins((i11 - i10) - 1, i12 - 3);
                        i10--;
                        iArr2 = iArr;
                    }
                    combins -= i13 * (i7 - i5);
                } else if (i11 > i2) {
                    combins--;
                }
                i3 += combins;
                i6++;
                i9 &= i8 ^ -1;
                iArr2 = iArr;
            }
            i42 -= i6;
            i5++;
            i6 = i9;
            iArr2 = iArr;
        }
    }
}
