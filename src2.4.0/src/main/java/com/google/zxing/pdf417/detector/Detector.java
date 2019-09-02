package com.google.zxing.pdf417.detector;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class Detector {
    private static final int BARCODE_MIN_HEIGHT = 10;
    private static final int[] INDEXES_START_PATTERN = new int[]{0, 4, 1, 5};
    private static final int[] INDEXES_STOP_PATTERN = new int[]{6, 2, 7, 3};
    private static final float MAX_AVG_VARIANCE = 0.42f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.8f;
    private static final int MAX_PATTERN_DRIFT = 5;
    private static final int MAX_PIXEL_DRIFT = 3;
    private static final int ROW_STEP = 5;
    private static final int SKIPPED_ROW_COUNT_MAX = 25;
    private static final int[] START_PATTERN = new int[]{8, 1, 1, 1, 1, 1, 1, 3};
    private static final int[] STOP_PATTERN = new int[]{7, 1, 1, 3, 1, 1, 1, 2, 1};

    private Detector() {
    }

    private static void copyToResult(ResultPoint[] resultPointArr, ResultPoint[] resultPointArr2, int[] iArr) {
        for (int i = 0; i < iArr.length; i++) {
            resultPointArr[iArr[i]] = resultPointArr2[i];
        }
    }

    public static PDF417DetectorResult detect(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map, boolean z) throws NotFoundException {
        BitMatrix blackMatrix = binaryBitmap.getBlackMatrix();
        List detect = detect(z, blackMatrix);
        if (detect.isEmpty()) {
            blackMatrix = blackMatrix.clone();
            blackMatrix.rotate180();
            detect = detect(z, blackMatrix);
        }
        return new PDF417DetectorResult(blackMatrix, detect);
    }

    private static List<ResultPoint[]> detect(boolean z, BitMatrix bitMatrix) {
        ArrayList<ResultPoint[]> arrayList = new ArrayList();
        int i = 0;
        int i2 = i;
        loop0:
        while (true) {
            int i3 = i2;
            while (i < bitMatrix.getHeight()) {
                ResultPoint[] findVertices = findVertices(bitMatrix, i, i2);
                if (findVertices[0] != null || findVertices[3] != null) {
                    arrayList.add(findVertices);
                    if (!z) {
                        break loop0;
                    }
                    if (findVertices[2] != null) {
                        i3 = (int) findVertices[2].getX();
                        i = (int) findVertices[2].getY();
                    } else {
                        i3 = (int) findVertices[4].getX();
                        i = (int) findVertices[4].getY();
                    }
                    i2 = i3;
                    i3 = 1;
                } else if (i3 == 0) {
                    break;
                } else {
                    for (ResultPoint[] resultPointArr : arrayList) {
                        if (resultPointArr[1] != null) {
                            i = (int) Math.max((float) i, resultPointArr[1].getY());
                        }
                        if (resultPointArr[3] != null) {
                            i = Math.max(i, (int) resultPointArr[3].getY());
                        }
                    }
                    i += 5;
                    i2 = 0;
                }
            }
            break loop0;
        }
        return arrayList;
    }

    private static int[] findGuardPattern(BitMatrix bitMatrix, int i, int i2, int i3, boolean z, int[] iArr, int[] iArr2) {
        int i4;
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int length = iArr.length;
        int i5 = 0;
        while (bitMatrix.get(i, i2) && i > 0) {
            i4 = i5 + 1;
            if (i5 >= 3) {
                break;
            }
            i--;
            i5 = i4;
        }
        i4 = i;
        i5 = 0;
        while (true) {
            int i6 = 1;
            if (i < i3) {
                int z2;
                if ((bitMatrix.get(i, i2) ^ z2) != 0) {
                    iArr2[i5] = iArr2[i5] + 1;
                } else {
                    int i7 = length - 1;
                    if (i5 != i7) {
                        i5++;
                    } else if (patternMatchVariance(iArr2, iArr, MAX_INDIVIDUAL_VARIANCE) < MAX_AVG_VARIANCE) {
                        return new int[]{i4, i};
                    } else {
                        i4 += iArr2[0] + iArr2[1];
                        int i8 = length - 2;
                        System.arraycopy(iArr2, 2, iArr2, 0, i8);
                        iArr2[i8] = 0;
                        iArr2[i7] = 0;
                        i5--;
                    }
                    iArr2[i5] = 1;
                    if (z2 != 0) {
                        i6 = 0;
                    }
                    z2 = i6;
                }
                i++;
            } else if (i5 != length - 1 || patternMatchVariance(iArr2, iArr, MAX_INDIVIDUAL_VARIANCE) >= MAX_AVG_VARIANCE) {
                return null;
            } else {
                return new int[]{i4, i - 1};
            }
        }
    }

    private static ResultPoint[] findRowsWithPattern(BitMatrix bitMatrix, int i, int i2, int i3, int i4, int[] iArr) {
        int i5;
        int i6;
        int[] findGuardPattern;
        float f;
        int i7 = i;
        ResultPoint[] resultPointArr = new ResultPoint[4];
        int[] iArr2 = iArr;
        int[] iArr3 = new int[iArr2.length];
        int i8 = i3;
        while (true) {
            i5 = 0;
            if (i8 >= i7) {
                i6 = 0;
                break;
            }
            findGuardPattern = findGuardPattern(bitMatrix, i4, i8, i2, false, iArr2, iArr3);
            if (findGuardPattern != null) {
                int[] iArr4;
                while (true) {
                    iArr4 = findGuardPattern;
                    if (i8 <= 0) {
                        break;
                    }
                    i8--;
                    findGuardPattern = findGuardPattern(bitMatrix, i4, i8, i2, false, iArr2, iArr3);
                    if (findGuardPattern == null) {
                        i8++;
                        break;
                    }
                }
                f = (float) i8;
                resultPointArr[0] = new ResultPoint((float) iArr4[0], f);
                resultPointArr[1] = new ResultPoint((float) iArr4[1], f);
                i6 = 1;
            } else {
                i8 += 5;
            }
        }
        int i9 = i8 + 1;
        if (i6 != 0) {
            int i10;
            int[] iArr5 = new int[]{(int) resultPointArr[0].getX(), (int) resultPointArr[1].getX()};
            int i11 = i9;
            int i12 = 0;
            while (i11 < i7) {
                i10 = i12;
                findGuardPattern = findGuardPattern(bitMatrix, iArr5[0], i11, i2, false, iArr2, iArr3);
                if (findGuardPattern != null && Math.abs(iArr5[0] - findGuardPattern[0]) < 5 && Math.abs(iArr5[1] - findGuardPattern[1]) < 5) {
                    iArr5 = findGuardPattern;
                    i12 = 0;
                } else if (i10 > 25) {
                    break;
                } else {
                    i12 = i10 + 1;
                }
                i11++;
            }
            i10 = i12;
            i9 = i11 - (i10 + 1);
            f = (float) i9;
            resultPointArr[2] = new ResultPoint((float) iArr5[0], f);
            resultPointArr[3] = new ResultPoint((float) iArr5[1], f);
        }
        if (i9 - i8 < 10) {
            while (i5 < resultPointArr.length) {
                resultPointArr[i5] = null;
                i5++;
            }
        }
        return resultPointArr;
    }

    private static ResultPoint[] findVertices(BitMatrix bitMatrix, int i, int i2) {
        int height = bitMatrix.getHeight();
        int width = bitMatrix.getWidth();
        ResultPoint[] resultPointArr = new ResultPoint[8];
        copyToResult(resultPointArr, findRowsWithPattern(bitMatrix, height, width, i, i2, START_PATTERN), INDEXES_START_PATTERN);
        if (resultPointArr[4] != null) {
            i2 = (int) resultPointArr[4].getX();
            i = (int) resultPointArr[4].getY();
        }
        copyToResult(resultPointArr, findRowsWithPattern(bitMatrix, height, width, i, i2, STOP_PATTERN), INDEXES_STOP_PATTERN);
        return resultPointArr;
    }

    private static float patternMatchVariance(int[] iArr, int[] iArr2, float f) {
        int i = 0;
        int length = iArr.length;
        int i2 = 0;
        int i3 = i2;
        int i4 = i3;
        while (i2 < length) {
            i3 += iArr[i2];
            i4 += iArr2[i2];
            i2++;
        }
        if (i3 < i4) {
            return Float.POSITIVE_INFINITY;
        }
        float f2 = (float) i3;
        float f3 = f2 / ((float) i4);
        f *= f3;
        float f4 = 0.0f;
        while (i < length) {
            float f5 = ((float) iArr2[i]) * f3;
            float f6 = (float) iArr[i];
            f6 = f6 > f5 ? f6 - f5 : f5 - f6;
            if (f6 > f) {
                return Float.POSITIVE_INFINITY;
            }
            f4 += f6;
            i++;
        }
        return f4 / f2;
    }
}
