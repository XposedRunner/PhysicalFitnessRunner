package com.google.zxing.common;

import com.google.zxing.Binarizer;
import com.google.zxing.LuminanceSource;
import com.google.zxing.NotFoundException;
import java.lang.reflect.Array;

public final class HybridBinarizer extends GlobalHistogramBinarizer {
    private static final int BLOCK_SIZE = 8;
    private static final int BLOCK_SIZE_MASK = 7;
    private static final int BLOCK_SIZE_POWER = 3;
    private static final int MINIMUM_DIMENSION = 40;
    private static final int MIN_DYNAMIC_RANGE = 24;
    private BitMatrix matrix;

    public HybridBinarizer(LuminanceSource luminanceSource) {
        super(luminanceSource);
    }

    private static int[][] calculateBlackPoints(byte[] bArr, int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int[][] iArr = (int[][]) Array.newInstance(int.class, new int[]{i6, i5});
        for (int i7 = 0; i7 < i6; i7++) {
            int i8 = i7 << 3;
            int i9 = 8;
            int i10 = i4 - 8;
            if (i8 <= i10) {
                i10 = i8;
            }
            i8 = 0;
            while (i8 < i5) {
                int i11;
                int i12 = i8 << 3;
                int i13 = i3 - 8;
                if (i12 > i13) {
                    i12 = i13;
                }
                int i14 = 255;
                int i15 = (i10 * i3) + i12;
                i13 = 0;
                int i16 = 0;
                int i17 = 0;
                while (i13 < i9) {
                    i11 = i17;
                    i17 = i16;
                    i16 = 0;
                    while (i16 < i9) {
                        i9 = bArr[i15 + i16] & 255;
                        i17 += i9;
                        if (i9 < i14) {
                            i14 = i9;
                        }
                        if (i9 > i11) {
                            i11 = i9;
                        }
                        i16++;
                        i9 = 8;
                    }
                    if (i11 - i14 <= 24) {
                        i16 = i17;
                        i13++;
                        i15 += i3;
                        i17 = i11;
                        i9 = 8;
                    }
                    while (true) {
                        i13++;
                        i15 += i3;
                        i9 = 8;
                        if (i13 >= 8) {
                            break;
                        }
                        i16 = 0;
                        while (i16 < i9) {
                            i17 += bArr[i15 + i16] & 255;
                            i16++;
                            i9 = 8;
                        }
                    }
                    i16 = i17;
                    i13++;
                    i15 += i3;
                    i17 = i11;
                    i9 = 8;
                }
                i11 = i16 >> 6;
                if (i17 - i14 <= 24) {
                    i11 = i14 / 2;
                    if (i7 > 0 && i8 > 0) {
                        i9 = i7 - 1;
                        i16 = i8 - 1;
                        i9 = ((iArr[i9][i8] + (2 * iArr[i7][i16])) + iArr[i9][i16]) / 4;
                        if (i14 < i9) {
                            i11 = i9;
                        }
                    }
                }
                iArr[i7][i8] = i11;
                i8++;
                i9 = 8;
            }
        }
        return iArr;
    }

    private static void calculateThresholdForBlock(byte[] bArr, int i, int i2, int i3, int i4, int[][] iArr, BitMatrix bitMatrix) {
        int i5 = i;
        int i6 = i2;
        for (int i7 = 0; i7 < i6; i7++) {
            int i8 = i7 << 3;
            int i9 = i4 - 8;
            if (i8 > i9) {
                i8 = i9;
            }
            for (i9 = 0; i9 < i5; i9++) {
                int i10 = i9 << 3;
                int i11 = i3 - 8;
                if (i10 <= i11) {
                    i11 = i10;
                }
                i10 = cap(i9, 2, i5 - 3);
                int cap = cap(i7, 2, i6 - 3);
                int i12 = 0;
                for (int i13 = -2; i13 <= 2; i13++) {
                    int[] iArr2 = iArr[cap + i13];
                    i12 += (((iArr2[i10 - 2] + iArr2[i10 - 1]) + iArr2[i10]) + iArr2[i10 + 1]) + iArr2[i10 + 2];
                }
                thresholdBlock(bArr, i11, i8, i12 / 25, i3, bitMatrix);
            }
        }
    }

    private static int cap(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    private static void thresholdBlock(byte[] bArr, int i, int i2, int i3, int i4, BitMatrix bitMatrix) {
        int i5 = (i2 * i4) + i;
        int i6 = 0;
        while (i6 < 8) {
            for (int i7 = 0; i7 < 8; i7++) {
                if ((bArr[i5 + i7] & 255) <= i3) {
                    bitMatrix.set(i + i7, i2 + i6);
                }
            }
            i6++;
            i5 += i4;
        }
    }

    public Binarizer createBinarizer(LuminanceSource luminanceSource) {
        return new HybridBinarizer(luminanceSource);
    }

    public BitMatrix getBlackMatrix() throws NotFoundException {
        if (this.matrix != null) {
            return this.matrix;
        }
        LuminanceSource luminanceSource = getLuminanceSource();
        int width = luminanceSource.getWidth();
        int height = luminanceSource.getHeight();
        if (width < 40 || height < 40) {
            this.matrix = super.getBlackMatrix();
        } else {
            byte[] matrix = luminanceSource.getMatrix();
            int i = width >> 3;
            if ((width & 7) != 0) {
                i++;
            }
            int i2 = i;
            i = height >> 3;
            if ((height & 7) != 0) {
                i++;
            }
            int i3 = i;
            int[][] calculateBlackPoints = calculateBlackPoints(matrix, i2, i3, width, height);
            BitMatrix bitMatrix = new BitMatrix(width, height);
            calculateThresholdForBlock(matrix, i2, i3, width, height, calculateBlackPoints, bitMatrix);
            this.matrix = bitMatrix;
        }
        return this.matrix;
    }
}
