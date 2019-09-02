package com.google.zxing.pdf417.decoder;

import com.google.zxing.pdf417.PDF417Common;
import java.lang.reflect.Array;

final class PDF417CodewordDecoder {
    private static final float[][] RATIOS_TABLE = ((float[][]) Array.newInstance(float.class, new int[]{PDF417Common.SYMBOL_TABLE.length, 8}));

    static {
        for (int i = 0; i < PDF417Common.SYMBOL_TABLE.length; i++) {
            int i2 = PDF417Common.SYMBOL_TABLE[i];
            int i3 = i2 & 1;
            int i4 = i2;
            i2 = 0;
            while (i2 < 8) {
                int i5;
                float f = 0.0f;
                while (true) {
                    i5 = i4 & 1;
                    if (i5 != i3) {
                        break;
                    }
                    f += 1.0f;
                    i4 >>= 1;
                }
                RATIOS_TABLE[i][(8 - i2) - 1] = f / 17.0f;
                i2++;
                i3 = i5;
            }
        }
    }

    private PDF417CodewordDecoder() {
    }

    private static int getBitValue(int[] iArr) {
        long j = 0;
        int i = 0;
        while (i < iArr.length) {
            long j2 = j;
            int i2 = 0;
            while (i2 < iArr[i]) {
                int i3 = 1;
                j2 <<= 1;
                if (i % 2 != 0) {
                    i3 = 0;
                }
                i2++;
                j2 |= (long) i3;
            }
            i++;
            j = j2;
        }
        return (int) j;
    }

    private static int getClosestDecodedValue(int[] iArr) {
        int bitCountSum = PDF417Common.getBitCountSum(iArr);
        float[] fArr = new float[8];
        for (int i = 0; i < fArr.length; i++) {
            fArr[i] = ((float) iArr[i]) / ((float) bitCountSum);
        }
        bitCountSum = -1;
        float f = Float.MAX_VALUE;
        for (int i2 = 0; i2 < RATIOS_TABLE.length; i2++) {
            float[] fArr2 = RATIOS_TABLE[i2];
            float f2 = 0.0f;
            for (int i3 = 0; i3 < 8; i3++) {
                float f3 = fArr2[i3] - fArr[i3];
                f2 += f3 * f3;
                if (f2 >= f) {
                    break;
                }
            }
            if (f2 < f) {
                bitCountSum = PDF417Common.SYMBOL_TABLE[i2];
                f = f2;
            }
        }
        return bitCountSum;
    }

    private static int getDecodedCodewordValue(int[] iArr) {
        int bitValue = getBitValue(iArr);
        return PDF417Common.getCodeword(bitValue) == -1 ? -1 : bitValue;
    }

    static int getDecodedValue(int[] iArr) {
        int decodedCodewordValue = getDecodedCodewordValue(sampleBitCounts(iArr));
        return decodedCodewordValue != -1 ? decodedCodewordValue : getClosestDecodedValue(iArr);
    }

    private static int[] sampleBitCounts(int[] iArr) {
        float bitCountSum = (float) PDF417Common.getBitCountSum(iArr);
        int[] iArr2 = new int[8];
        int i = 0;
        int i2 = 0;
        int i3 = i2;
        while (i < 17) {
            if (((float) (iArr[i3] + i2)) <= (bitCountSum / 34.0f) + ((((float) i) * bitCountSum) / 17.0f)) {
                i2 += iArr[i3];
                i3++;
            }
            iArr2[i3] = iArr2[i3] + 1;
            i++;
        }
        return iArr2;
    }
}
