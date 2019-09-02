package com.google.zxing.multi;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class GenericMultipleBarcodeReader implements MultipleBarcodeReader {
    private static final int MAX_DEPTH = 4;
    private static final int MIN_DIMENSION_TO_RECUR = 100;
    private final Reader delegate;

    public GenericMultipleBarcodeReader(Reader reader) {
        this.delegate = reader;
    }

    private void doDecodeMultiple(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map, List<Result> list, int i, int i2, int i3) {
        BinaryBitmap binaryBitmap2 = binaryBitmap;
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        if (i6 <= 4) {
            try {
                Object obj;
                List list2;
                Map<DecodeHintType, ?> map2 = map;
                Result decode = this.delegate.decode(binaryBitmap2, map2);
                for (Result text : list) {
                    if (text.getText().equals(decode.getText())) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    list2 = list;
                    list2.add(translateResultPoints(decode, i4, i5));
                } else {
                    list2 = list;
                }
                ResultPoint[] resultPoints = decode.getResultPoints();
                if (resultPoints != null && resultPoints.length != 0) {
                    float f;
                    int i7;
                    float f2;
                    int i8;
                    int i9;
                    int i10;
                    int width = binaryBitmap.getWidth();
                    int height = binaryBitmap.getHeight();
                    float f3 = (float) width;
                    float f4 = (float) height;
                    int length = resultPoints.length;
                    float f5 = 0.0f;
                    float f6 = f5;
                    float f7 = f4;
                    f4 = f3;
                    int i11 = 0;
                    while (i11 < length) {
                        int i12 = length;
                        ResultPoint resultPoint = resultPoints[i11];
                        if (resultPoint != null) {
                            float x = resultPoint.getX();
                            float y = resultPoint.getY();
                            if (x < f4) {
                                f4 = x;
                            }
                            if (y < f7) {
                                f7 = y;
                            }
                            if (x > f5) {
                                f5 = x;
                            }
                            if (y > f6) {
                                f6 = y;
                            }
                        }
                        i11++;
                        length = i12;
                    }
                    if (f4 > 100.0f) {
                        f = f6;
                        f6 = f7;
                        i7 = height;
                        f2 = f5;
                        i8 = width;
                        doDecodeMultiple(binaryBitmap2.crop(0, 0, (int) f4, height), map2, list2, i4, i5, i6 + 1);
                    } else {
                        i7 = height;
                        f2 = f5;
                        f = f6;
                        f6 = f7;
                        i8 = width;
                    }
                    if (f6 > 100.0f) {
                        doDecodeMultiple(binaryBitmap2.crop(0, 0, i8, (int) f6), map2, list2, i4, i5, i6 + 1);
                    }
                    if (f2 < ((float) (i8 - 100))) {
                        i9 = (int) f2;
                        i10 = i7;
                        BinaryBitmap crop = binaryBitmap2.crop(i9, 0, i8 - i9, i10);
                        doDecodeMultiple(crop, map2, list2, i4 + i9, i5, i6 + 1);
                    } else {
                        i10 = i7;
                    }
                    if (f < ((float) (i10 - 100))) {
                        i9 = (int) f;
                        BinaryBitmap crop2 = binaryBitmap2.crop(0, i9, i8, i10 - i9);
                        doDecodeMultiple(crop2, map2, list2, i4, i5 + i9, i6 + 1);
                    }
                }
            } catch (ReaderException unused) {
            }
        }
    }

    private static Result translateResultPoints(Result result, int i, int i2) {
        ResultPoint[] resultPoints = result.getResultPoints();
        if (resultPoints == null) {
            return result;
        }
        ResultPoint[] resultPointArr = new ResultPoint[resultPoints.length];
        for (int i3 = 0; i3 < resultPoints.length; i3++) {
            ResultPoint resultPoint = resultPoints[i3];
            if (resultPoint != null) {
                resultPointArr[i3] = new ResultPoint(resultPoint.getX() + ((float) i), resultPoint.getY() + ((float) i2));
            }
        }
        Result result2 = new Result(result.getText(), result.getRawBytes(), resultPointArr, result.getBarcodeFormat());
        result2.putAllMetadata(result.getResultMetadata());
        return result2;
    }

    public Result[] decodeMultiple(BinaryBitmap binaryBitmap) throws NotFoundException {
        return decodeMultiple(binaryBitmap, null);
    }

    public Result[] decodeMultiple(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException {
        ArrayList arrayList = new ArrayList();
        doDecodeMultiple(binaryBitmap, map, arrayList, 0, 0, 0);
        if (!arrayList.isEmpty()) {
            return (Result[]) arrayList.toArray(new Result[arrayList.size()]);
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
