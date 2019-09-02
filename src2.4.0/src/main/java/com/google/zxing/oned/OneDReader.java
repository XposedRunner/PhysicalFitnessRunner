package com.google.zxing.oned;

import com.amap.api.maps.utils.SpatialRelationUtil;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public abstract class OneDReader implements Reader {
    private Result doDecode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException {
        int i;
        int i2;
        BinaryBitmap binaryBitmap2;
        Map<DecodeHintType, ?> map2 = map;
        int width = binaryBitmap.getWidth();
        int height = binaryBitmap.getHeight();
        BitArray bitArray = new BitArray(width);
        int i3 = height >> 1;
        int i4 = 1;
        int i5 = (map2 == null || !map2.containsKey(DecodeHintType.TRY_HARDER)) ? 0 : 1;
        int max = Math.max(1, height >> (i5 != 0 ? 8 : 5));
        i5 = i5 != 0 ? height : 15;
        Map map3 = map2;
        int i6 = 0;
        while (i6 < i5) {
            int i7 = i6 + 1;
            int i8 = i7 / 2;
            if (((i6 & 1) == 0 ? i4 : 0) == 0) {
                i8 = -i8;
            }
            i8 = (i8 * max) + i3;
            if (i8 < 0 || i8 >= height) {
                break;
            }
            try {
                BitArray blackRow = binaryBitmap.getBlackRow(i8, bitArray);
                int i9 = 0;
                while (i9 < 2) {
                    if (i9 == i4) {
                        blackRow.reverse();
                        if (map3 != null && map3.containsKey(DecodeHintType.NEED_RESULT_POINT_CALLBACK)) {
                            EnumMap enumMap = new EnumMap(DecodeHintType.class);
                            enumMap.putAll(map3);
                            enumMap.remove(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
                            map3 = enumMap;
                        }
                    }
                    try {
                        Result decodeRow = decodeRow(i8, blackRow, map3);
                        if (i9 == i4) {
                            try {
                                decodeRow.putMetadata(ResultMetadataType.ORIENTATION, Integer.valueOf(180));
                                ResultPoint[] resultPoints = decodeRow.getResultPoints();
                                if (resultPoints != null) {
                                    float f = (float) width;
                                    i = width;
                                    try {
                                        i2 = height;
                                    } catch (ReaderException unused) {
                                        i2 = height;
                                        height = 1;
                                        i9++;
                                        i4 = height;
                                        width = i;
                                        height = i2;
                                        binaryBitmap2 = binaryBitmap;
                                    }
                                    try {
                                        resultPoints[0] = new ResultPoint((f - resultPoints[0].getX()) - 1.0f, resultPoints[0].getY());
                                        height = 1;
                                        try {
                                            resultPoints[1] = new ResultPoint((f - resultPoints[1].getX()) - 1.0f, resultPoints[1].getY());
                                        } catch (ReaderException unused2) {
                                            continue;
                                        }
                                    } catch (ReaderException unused3) {
                                        height = 1;
                                        i9++;
                                        i4 = height;
                                        width = i;
                                        height = i2;
                                        binaryBitmap2 = binaryBitmap;
                                    }
                                }
                            } catch (ReaderException unused4) {
                                i = width;
                                i2 = height;
                                height = 1;
                                i9++;
                                i4 = height;
                                width = i;
                                height = i2;
                                binaryBitmap2 = binaryBitmap;
                            }
                        }
                        return decodeRow;
                    } catch (ReaderException unused5) {
                        i = width;
                        i2 = height;
                        height = i4;
                        i9++;
                        i4 = height;
                        width = i;
                        height = i2;
                        binaryBitmap2 = binaryBitmap;
                    }
                }
                i = width;
                i2 = height;
                height = i4;
                bitArray = blackRow;
            } catch (NotFoundException unused6) {
                i = width;
                i2 = height;
                height = i4;
            }
            i4 = height;
            i6 = i7;
            width = i;
            height = i2;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    protected static float patternMatchVariance(int[] iArr, int[] iArr2, float f) {
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

    protected static void recordPattern(BitArray bitArray, int i, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        Arrays.fill(iArr, 0, length, 0);
        int size = bitArray.getSize();
        if (i >= size) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i2 = bitArray.get(i) ^ 1;
        int i3 = 0;
        while (i < size) {
            if ((bitArray.get(i) ^ i2) != 0) {
                iArr[i3] = iArr[i3] + 1;
            } else {
                i3++;
                if (i3 == length) {
                    break;
                }
                iArr[i3] = 1;
                i2 = i2 == 0 ? 1 : 0;
            }
            i++;
        }
        if (i3 == length) {
            return;
        }
        if (i3 != length - 1 || i != size) {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    protected static void recordPatternInReverse(BitArray bitArray, int i, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        boolean z = bitArray.get(i);
        while (i > 0 && length >= 0) {
            i--;
            if (bitArray.get(i) != z) {
                length--;
                z = !z;
            }
        }
        if (length >= 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        recordPattern(bitArray, i + 1, iArr);
    }

    public Result decode(BinaryBitmap binaryBitmap) throws NotFoundException, FormatException {
        return decode(binaryBitmap, null);
    }

    public Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        try {
            return doDecode(binaryBitmap, map);
        } catch (NotFoundException e) {
            int i = 0;
            int i2 = (map == null || !map.containsKey(DecodeHintType.TRY_HARDER)) ? 0 : 1;
            if (i2 == 0 || !binaryBitmap.isRotateSupported()) {
                throw e;
            }
            binaryBitmap = binaryBitmap.rotateCounterClockwise();
            Result doDecode = doDecode(binaryBitmap, map);
            Map resultMetadata = doDecode.getResultMetadata();
            i2 = 270;
            if (resultMetadata != null && resultMetadata.containsKey(ResultMetadataType.ORIENTATION)) {
                i2 = (270 + ((Integer) resultMetadata.get(ResultMetadataType.ORIENTATION)).intValue()) % SpatialRelationUtil.A_CIRCLE_DEGREE;
            }
            doDecode.putMetadata(ResultMetadataType.ORIENTATION, Integer.valueOf(i2));
            ResultPoint[] resultPoints = doDecode.getResultPoints();
            if (resultPoints != null) {
                int height = binaryBitmap.getHeight();
                while (i < resultPoints.length) {
                    resultPoints[i] = new ResultPoint((((float) height) - resultPoints[i].getY()) - 1.0f, resultPoints[i].getX());
                    i++;
                }
            }
            return doDecode;
        }
    }

    public abstract Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException;

    public void reset() {
    }
}
