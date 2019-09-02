package com.google.zxing.pdf417.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.pdf417.PDF417Common;
import com.google.zxing.pdf417.decoder.ec.ErrorCorrection;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Formatter;

public final class PDF417ScanningDecoder {
    private static final int CODEWORD_SKEW_SIZE = 2;
    private static final int MAX_EC_CODEWORDS = 512;
    private static final int MAX_ERRORS = 3;
    private static final ErrorCorrection errorCorrection = new ErrorCorrection();

    private PDF417ScanningDecoder() {
    }

    private static BoundingBox adjustBoundingBox(DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn) throws NotFoundException, FormatException {
        if (detectionResultRowIndicatorColumn == null) {
            return null;
        }
        int[] rowHeights = detectionResultRowIndicatorColumn.getRowHeights();
        if (rowHeights == null) {
            return null;
        }
        int max = getMax(rowHeights);
        int i = 0;
        int length = rowHeights.length;
        int i2 = 0;
        int i3 = i2;
        while (i2 < length) {
            int i4 = rowHeights[i2];
            i3 += max - i4;
            if (i4 > 0) {
                break;
            }
            i2++;
        }
        Codeword[] codewords = detectionResultRowIndicatorColumn.getCodewords();
        i2 = 0;
        while (i3 > 0 && codewords[i2] == null) {
            i3--;
            i2++;
        }
        for (i2 = rowHeights.length - 1; i2 >= 0; i2--) {
            i += max - rowHeights[i2];
            if (rowHeights[i2] > 0) {
                break;
            }
        }
        max = codewords.length - 1;
        while (i > 0 && codewords[max] == null) {
            i--;
            max--;
        }
        return detectionResultRowIndicatorColumn.getBoundingBox().addMissingRows(i3, i, detectionResultRowIndicatorColumn.isLeft());
    }

    private static void adjustCodewordCount(DetectionResult detectionResult, BarcodeValue[][] barcodeValueArr) throws NotFoundException {
        int[] value = barcodeValueArr[0][1].getValue();
        int barcodeColumnCount = (detectionResult.getBarcodeColumnCount() * detectionResult.getBarcodeRowCount()) - getNumberOfECCodeWords(detectionResult.getBarcodeECLevel());
        if (value.length == 0) {
            if (barcodeColumnCount < 1 || barcodeColumnCount > PDF417Common.MAX_CODEWORDS_IN_BARCODE) {
                throw NotFoundException.getNotFoundInstance();
            }
            barcodeValueArr[0][1].setValue(barcodeColumnCount);
        } else if (value[0] != barcodeColumnCount) {
            barcodeValueArr[0][1].setValue(barcodeColumnCount);
        }
    }

    private static int adjustCodewordStartColumn(BitMatrix bitMatrix, int i, int i2, boolean z, int i3, int i4) {
        boolean z2 = z;
        int i5 = z ? -1 : 1;
        int i6 = i3;
        for (int i7 = 0; i7 < 2; i7++) {
            while (true) {
                if (((!z2 || i6 < i) && (z2 || i6 >= i2)) || z2 != bitMatrix.get(i6, i4)) {
                    i5 = -i5;
                } else if (Math.abs(i3 - i6) > 2) {
                    return i3;
                } else {
                    i6 += i5;
                }
            }
            i5 = -i5;
            z2 = !z2;
        }
        return i6;
    }

    private static boolean checkCodewordSkew(int i, int i2, int i3) {
        return i2 + -2 <= i && i <= i3 + 2;
    }

    private static int correctErrors(int[] iArr, int[] iArr2, int i) throws ChecksumException {
        if ((iArr2 == null || iArr2.length <= (i / 2) + 3) && i >= 0 && i <= 512) {
            return errorCorrection.decode(iArr, i, iArr2);
        }
        throw ChecksumException.getChecksumInstance();
    }

    private static BarcodeValue[][] createBarcodeMatrix(DetectionResult detectionResult) throws FormatException {
        int i;
        int i2;
        BarcodeValue[][] barcodeValueArr = (BarcodeValue[][]) Array.newInstance(BarcodeValue.class, new int[]{detectionResult.getBarcodeRowCount(), detectionResult.getBarcodeColumnCount() + 2});
        for (i = 0; i < barcodeValueArr.length; i++) {
            for (i2 = 0; i2 < barcodeValueArr[i].length; i2++) {
                barcodeValueArr[i][i2] = new BarcodeValue();
            }
        }
        DetectionResultColumn[] detectionResultColumns = detectionResult.getDetectionResultColumns();
        i = detectionResultColumns.length;
        i2 = 0;
        int i3 = i2;
        while (i2 < i) {
            DetectionResultColumn detectionResultColumn = detectionResultColumns[i2];
            if (detectionResultColumn != null) {
                for (Codeword codeword : detectionResultColumn.getCodewords()) {
                    if (codeword != null) {
                        int rowNumber = codeword.getRowNumber();
                        if (rowNumber < 0) {
                            continue;
                        } else if (rowNumber >= barcodeValueArr.length) {
                            throw FormatException.getFormatInstance();
                        } else {
                            barcodeValueArr[rowNumber][i3].setValue(codeword.getValue());
                        }
                    }
                }
                continue;
            }
            i3++;
            i2++;
        }
        return barcodeValueArr;
    }

    private static DecoderResult createDecoderResult(DetectionResult detectionResult) throws FormatException, ChecksumException, NotFoundException {
        BarcodeValue[][] createBarcodeMatrix = createBarcodeMatrix(detectionResult);
        adjustCodewordCount(detectionResult, createBarcodeMatrix);
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[(detectionResult.getBarcodeRowCount() * detectionResult.getBarcodeColumnCount())];
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int i = 0;
        for (int i2 = 0; i2 < detectionResult.getBarcodeRowCount(); i2++) {
            int i3 = 0;
            while (i3 < detectionResult.getBarcodeColumnCount()) {
                int i4 = i3 + 1;
                int[] value = createBarcodeMatrix[i2][i4].getValue();
                int barcodeColumnCount = (detectionResult.getBarcodeColumnCount() * i2) + i3;
                if (value.length == 0) {
                    arrayList.add(Integer.valueOf(barcodeColumnCount));
                } else if (value.length == 1) {
                    iArr[barcodeColumnCount] = value[0];
                } else {
                    arrayList3.add(Integer.valueOf(barcodeColumnCount));
                    arrayList2.add(value);
                }
                i3 = i4;
            }
        }
        int[][] iArr2 = new int[arrayList2.size()][];
        while (i < iArr2.length) {
            iArr2[i] = (int[]) arrayList2.get(i);
            i++;
        }
        return createDecoderResultFromAmbiguousValues(detectionResult.getBarcodeECLevel(), iArr, PDF417Common.toIntArray(arrayList), PDF417Common.toIntArray(arrayList3), iArr2);
    }

    private static DecoderResult createDecoderResultFromAmbiguousValues(int i, int[] iArr, int[] iArr2, int[] iArr3, int[][] iArr4) throws FormatException, ChecksumException {
        int i2 = 100;
        int[] iArr5 = new int[iArr3.length];
        while (true) {
            int i3 = i2 - 1;
            if (i2 > 0) {
                int i4;
                for (i4 = 0; i4 < iArr5.length; i4++) {
                    iArr[iArr3[i4]] = iArr4[i4][iArr5[i4]];
                }
                try {
                    return decodeCodewords(iArr, i, iArr2);
                } catch (ChecksumException unused) {
                    if (iArr5.length == 0) {
                        throw ChecksumException.getChecksumInstance();
                    }
                    for (i4 = 0; i4 < iArr5.length; i4++) {
                        if (iArr5[i4] < iArr4[i4].length - 1) {
                            iArr5[i4] = iArr5[i4] + 1;
                            break;
                        }
                        iArr5[i4] = 0;
                        if (i4 == iArr5.length - 1) {
                            throw ChecksumException.getChecksumInstance();
                        }
                    }
                    i2 = i3;
                }
            } else {
                throw ChecksumException.getChecksumInstance();
            }
        }
    }

    public static DecoderResult decode(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i, int i2) throws NotFoundException, FormatException, ChecksumException {
        DetectionResultColumn detectionResultColumn;
        BoundingBox boundingBox = new BoundingBox(bitMatrix, resultPoint, resultPoint2, resultPoint3, resultPoint4);
        DetectionResultColumn detectionResultColumn2 = null;
        DetectionResult detectionResult = detectionResultColumn2;
        DetectionResultColumn detectionResultColumn3 = detectionResult;
        int i3 = 0;
        BoundingBox boundingBox2 = boundingBox;
        while (i3 < 2) {
            if (resultPoint != null) {
                detectionResultColumn2 = getRowIndicatorColumn(bitMatrix, boundingBox2, resultPoint, true, i, i2);
            }
            detectionResultColumn = detectionResultColumn2;
            if (resultPoint3 != null) {
                detectionResultColumn3 = getRowIndicatorColumn(bitMatrix, boundingBox2, resultPoint3, false, i, i2);
            }
            detectionResult = merge(detectionResultColumn, detectionResultColumn3);
            if (detectionResult == null) {
                throw NotFoundException.getNotFoundInstance();
            } else if (i3 != 0 || detectionResult.getBoundingBox() == null || (detectionResult.getBoundingBox().getMinY() >= boundingBox2.getMinY() && detectionResult.getBoundingBox().getMaxY() <= boundingBox2.getMaxY())) {
                detectionResult.setBoundingBox(boundingBox2);
                break;
            } else {
                boundingBox2 = detectionResult.getBoundingBox();
                i3++;
                detectionResultColumn2 = detectionResultColumn;
            }
        }
        detectionResultColumn = detectionResultColumn2;
        i3 = detectionResult.getBarcodeColumnCount() + 1;
        detectionResult.setDetectionResultColumn(0, detectionResultColumn);
        detectionResult.setDetectionResultColumn(i3, detectionResultColumn3);
        boolean z = detectionResultColumn != null;
        int i4 = i;
        int i5 = i2;
        int i6 = 1;
        while (i6 <= i3) {
            int i7 = z ? i6 : i3 - i6;
            if (detectionResult.getDetectionResultColumn(i7) == null) {
                DetectionResultColumn detectionResultRowIndicatorColumn;
                if (i7 == 0 || i7 == i3) {
                    detectionResultRowIndicatorColumn = new DetectionResultRowIndicatorColumn(boundingBox2, i7 == 0);
                } else {
                    detectionResultRowIndicatorColumn = new DetectionResultColumn(boundingBox2);
                }
                detectionResult.setDetectionResultColumn(i7, detectionResultRowIndicatorColumn);
                int minY = boundingBox2.getMinY();
                int i8 = i5;
                i5 = i4;
                i4 = -1;
                while (minY <= boundingBox2.getMaxY()) {
                    int i9;
                    int startColumn = getStartColumn(detectionResult, i7, minY, z);
                    if (startColumn >= 0 && startColumn <= boundingBox2.getMaxX()) {
                        i9 = startColumn;
                    } else if (i4 == -1) {
                        startColumn = i8;
                        i8 = startColumn;
                        minY++;
                    } else {
                        i9 = i4;
                    }
                    int i10 = i8;
                    Codeword detectCodeword = detectCodeword(bitMatrix, boundingBox2.getMinX(), boundingBox2.getMaxX(), z, i9, minY, i5, i10);
                    if (detectCodeword != null) {
                        detectionResultRowIndicatorColumn.setCodeword(minY, detectCodeword);
                        i5 = Math.min(i5, detectCodeword.getWidth());
                        i8 = Math.max(i10, detectCodeword.getWidth());
                        i4 = i9;
                        minY++;
                    } else {
                        startColumn = i10;
                        i8 = startColumn;
                        minY++;
                    }
                }
                i4 = i5;
                i5 = i8;
            }
            i6++;
        }
        return createDecoderResult(detectionResult);
    }

    private static DecoderResult decodeCodewords(int[] iArr, int i, int[] iArr2) throws FormatException, ChecksumException {
        if (iArr.length == 0) {
            throw FormatException.getFormatInstance();
        }
        int i2 = 1 << (i + 1);
        int correctErrors = correctErrors(iArr, iArr2, i2);
        verifyCodewordCount(iArr, i2);
        DecoderResult decode = DecodedBitStreamParser.decode(iArr, String.valueOf(i));
        decode.setErrorsCorrected(Integer.valueOf(correctErrors));
        decode.setErasures(Integer.valueOf(iArr2.length));
        return decode;
    }

    private static Codeword detectCodeword(BitMatrix bitMatrix, int i, int i2, boolean z, int i3, int i4, int i5, int i6) {
        i3 = adjustCodewordStartColumn(bitMatrix, i, i2, z, i3, i4);
        int[] moduleBitCount = getModuleBitCount(bitMatrix, i, i2, z, i3, i4);
        if (moduleBitCount == null) {
            return null;
        }
        int i7;
        i2 = PDF417Common.getBitCountSum(moduleBitCount);
        if (z) {
            int i8 = i3;
            i3 += i2;
            i7 = i8;
        } else {
            for (i7 = 0; i7 < moduleBitCount.length / 2; i7++) {
                i4 = moduleBitCount[i7];
                moduleBitCount[i7] = moduleBitCount[(moduleBitCount.length - 1) - i7];
                moduleBitCount[(moduleBitCount.length - 1) - i7] = i4;
            }
            i7 = i3 - i2;
        }
        if (!checkCodewordSkew(i2, i5, i6)) {
            return null;
        }
        int decodedValue = PDF417CodewordDecoder.getDecodedValue(moduleBitCount);
        i2 = PDF417Common.getCodeword(decodedValue);
        return i2 == -1 ? null : new Codeword(i7, i3, getCodewordBucketNumber(decodedValue), i2);
    }

    private static BarcodeMetadata getBarcodeMetadata(DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn, DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn2) {
        BarcodeMetadata barcodeMetadata = null;
        if (detectionResultRowIndicatorColumn != null) {
            BarcodeMetadata barcodeMetadata2 = detectionResultRowIndicatorColumn.getBarcodeMetadata();
            if (barcodeMetadata2 != null) {
                if (detectionResultRowIndicatorColumn2 != null) {
                    BarcodeMetadata barcodeMetadata3 = detectionResultRowIndicatorColumn2.getBarcodeMetadata();
                    return (barcodeMetadata3 == null || barcodeMetadata2.getColumnCount() == barcodeMetadata3.getColumnCount() || barcodeMetadata2.getErrorCorrectionLevel() == barcodeMetadata3.getErrorCorrectionLevel() || barcodeMetadata2.getRowCount() == barcodeMetadata3.getRowCount()) ? barcodeMetadata2 : null;
                }
                return barcodeMetadata2;
            }
        }
        if (detectionResultRowIndicatorColumn2 != null) {
            barcodeMetadata = detectionResultRowIndicatorColumn2.getBarcodeMetadata();
        }
        return barcodeMetadata;
    }

    private static int[] getBitCountForCodeword(int i) {
        int[] iArr = new int[8];
        int i2 = 0;
        int length = iArr.length - 1;
        while (true) {
            int i3 = i & 1;
            if (i3 != i2) {
                length--;
                if (length < 0) {
                    return iArr;
                }
                i2 = i3;
            }
            iArr[length] = iArr[length] + 1;
            i >>= 1;
        }
    }

    private static int getCodewordBucketNumber(int i) {
        return getCodewordBucketNumber(getBitCountForCodeword(i));
    }

    private static int getCodewordBucketNumber(int[] iArr) {
        return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
    }

    private static int getMax(int[] iArr) {
        int i = -1;
        for (int max : iArr) {
            i = Math.max(i, max);
        }
        return i;
    }

    private static int[] getModuleBitCount(BitMatrix bitMatrix, int i, int i2, boolean z, int i3, int i4) {
        int[] iArr = new int[8];
        int i5 = z ? 1 : -1;
        boolean z2 = z;
        int i6 = 0;
        while (true) {
            if (((z && i3 < i2) || (!z && i3 >= i)) && i6 < iArr.length) {
                if (bitMatrix.get(i3, i4) == z2) {
                    iArr[i6] = iArr[i6] + 1;
                    i3 += i5;
                } else {
                    i6++;
                    z2 = !z2;
                }
            }
        }
        return (i6 == iArr.length || (((z && i3 == i2) || (!z && i3 == i)) && i6 == iArr.length - 1)) ? iArr : null;
    }

    private static int getNumberOfECCodeWords(int i) {
        return 2 << i;
    }

    private static DetectionResultRowIndicatorColumn getRowIndicatorColumn(BitMatrix bitMatrix, BoundingBox boundingBox, ResultPoint resultPoint, boolean z, int i, int i2) {
        boolean z2 = z;
        DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn = new DetectionResultRowIndicatorColumn(boundingBox, z2);
        int i3 = 0;
        while (i3 < 2) {
            int i4 = i3 == 0 ? 1 : -1;
            int x = (int) resultPoint.getX();
            int y = (int) resultPoint.getY();
            while (y <= boundingBox.getMaxY() && y >= boundingBox.getMinY()) {
                Codeword detectCodeword = detectCodeword(bitMatrix, 0, bitMatrix.getWidth(), z2, x, y, i, i2);
                if (detectCodeword != null) {
                    detectionResultRowIndicatorColumn.setCodeword(y, detectCodeword);
                    x = z2 ? detectCodeword.getStartX() : detectCodeword.getEndX();
                }
                y += i4;
            }
            i3++;
        }
        return detectionResultRowIndicatorColumn;
    }

    private static int getStartColumn(DetectionResult detectionResult, int i, int i2, boolean z) {
        int i3 = z ? 1 : -1;
        Codeword codeword = null;
        int i4 = i - i3;
        if (isValidBarcodeColumn(detectionResult, i4)) {
            codeword = detectionResult.getDetectionResultColumn(i4).getCodeword(i2);
        }
        if (codeword != null) {
            return z ? codeword.getEndX() : codeword.getStartX();
        }
        codeword = detectionResult.getDetectionResultColumn(i).getCodewordNearby(i2);
        if (codeword != null) {
            return z ? codeword.getStartX() : codeword.getEndX();
        }
        if (isValidBarcodeColumn(detectionResult, i4)) {
            codeword = detectionResult.getDetectionResultColumn(i4).getCodewordNearby(i2);
        }
        if (codeword != null) {
            return z ? codeword.getEndX() : codeword.getStartX();
        }
        int i5 = 0;
        while (true) {
            i -= i3;
            if (isValidBarcodeColumn(detectionResult, i)) {
                for (Codeword codeword2 : detectionResult.getDetectionResultColumn(i).getCodewords()) {
                    if (codeword2 != null) {
                        return (z ? codeword2.getEndX() : codeword2.getStartX()) + ((i3 * i5) * (codeword2.getEndX() - codeword2.getStartX()));
                    }
                }
                i5++;
            } else {
                return z ? detectionResult.getBoundingBox().getMinX() : detectionResult.getBoundingBox().getMaxX();
            }
        }
    }

    private static boolean isValidBarcodeColumn(DetectionResult detectionResult, int i) {
        return i >= 0 && i <= detectionResult.getBarcodeColumnCount() + 1;
    }

    private static DetectionResult merge(DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn, DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn2) throws NotFoundException, FormatException {
        if (detectionResultRowIndicatorColumn == null && detectionResultRowIndicatorColumn2 == null) {
            return null;
        }
        BarcodeMetadata barcodeMetadata = getBarcodeMetadata(detectionResultRowIndicatorColumn, detectionResultRowIndicatorColumn2);
        return barcodeMetadata == null ? null : new DetectionResult(barcodeMetadata, BoundingBox.merge(adjustBoundingBox(detectionResultRowIndicatorColumn), adjustBoundingBox(detectionResultRowIndicatorColumn2)));
    }

    public static String toString(BarcodeValue[][] barcodeValueArr) {
        Formatter formatter = new Formatter();
        for (int i = 0; i < barcodeValueArr.length; i++) {
            formatter.format("Row %2d: ", new Object[]{Integer.valueOf(i)});
            for (BarcodeValue value : barcodeValueArr[i]) {
                if (value.getValue().length == 0) {
                    formatter.format("        ", (Object[]) null);
                } else {
                    formatter.format("%4d(%2d)", new Object[]{Integer.valueOf(barcodeValueArr[i][r3].getValue()[0]), barcodeValueArr[i][r3].getConfidence(barcodeValueArr[i][r3].getValue()[0])});
                }
            }
            formatter.format("%n", new Object[0]);
        }
        String formatter2 = formatter.toString();
        formatter.close();
        return formatter2;
    }

    private static void verifyCodewordCount(int[] iArr, int i) throws FormatException {
        if (iArr.length < 4) {
            throw FormatException.getFormatInstance();
        }
        int i2 = iArr[0];
        if (i2 > iArr.length) {
            throw FormatException.getFormatInstance();
        } else if (i2 != 0) {
        } else {
            if (i < iArr.length) {
                iArr[0] = iArr.length - i;
                return;
            }
            throw FormatException.getFormatInstance();
        }
    }
}
