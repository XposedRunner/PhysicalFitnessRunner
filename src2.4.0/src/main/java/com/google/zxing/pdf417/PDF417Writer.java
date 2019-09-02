package com.google.zxing.pdf417;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.pdf417.encoder.Compaction;
import com.google.zxing.pdf417.encoder.Dimensions;
import com.google.zxing.pdf417.encoder.PDF417;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Map;

public final class PDF417Writer implements Writer {
    static final int DEFAULT_ERROR_CORRECTION_LEVEL = 2;
    static final int WHITE_SPACE = 30;

    private static BitMatrix bitMatrixFromEncoder(PDF417 pdf417, String str, int i, int i2, int i3, int i4) throws WriterException {
        int i5;
        pdf417.generateBarcodeLogic(str, i);
        byte[][] scaledMatrix = pdf417.getBarcodeMatrix().getScaledMatrix(1, 4);
        if (((i3 > i2 ? 1 : 0) ^ (scaledMatrix[0].length < scaledMatrix.length ? 1 : 0)) != 0) {
            scaledMatrix = rotateArray(scaledMatrix);
            i5 = 1;
        } else {
            i5 = 0;
        }
        i2 /= scaledMatrix[0].length;
        i3 /= scaledMatrix.length;
        if (i2 >= i3) {
            i2 = i3;
        }
        if (i2 <= 1) {
            return bitMatrixFrombitArray(scaledMatrix, i4);
        }
        byte[][] scaledMatrix2 = pdf417.getBarcodeMatrix().getScaledMatrix(i2, i2 * 4);
        if (i5 != 0) {
            scaledMatrix2 = rotateArray(scaledMatrix2);
        }
        return bitMatrixFrombitArray(scaledMatrix2, i4);
    }

    private static BitMatrix bitMatrixFrombitArray(byte[][] bArr, int i) {
        int i2 = 2 * i;
        BitMatrix bitMatrix = new BitMatrix(bArr[0].length + i2, bArr.length + i2);
        bitMatrix.clear();
        i2 = (bitMatrix.getHeight() - i) - 1;
        int i3 = 0;
        while (i3 < bArr.length) {
            for (int i4 = 0; i4 < bArr[0].length; i4++) {
                if (bArr[i3][i4] == (byte) 1) {
                    bitMatrix.set(i4 + i, i2);
                }
            }
            i3++;
            i2--;
        }
        return bitMatrix;
    }

    private static byte[][] rotateArray(byte[][] bArr) {
        byte[][] bArr2 = (byte[][]) Array.newInstance(byte.class, new int[]{bArr[0].length, bArr.length});
        for (int i = 0; i < bArr.length; i++) {
            int length = (bArr.length - i) - 1;
            for (int i2 = 0; i2 < bArr[0].length; i2++) {
                bArr2[i2][length] = bArr[i][i2];
            }
        }
        return bArr2;
    }

    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2) throws WriterException {
        return encode(str, barcodeFormat, i, i2, null);
    }

    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat != BarcodeFormat.PDF_417) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Can only encode PDF_417, but got ");
            stringBuilder.append(barcodeFormat);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        PDF417 pdf417 = new PDF417();
        int i3 = 30;
        int i4 = 2;
        if (map != null) {
            if (map.containsKey(EncodeHintType.PDF417_COMPACT)) {
                pdf417.setCompact(((Boolean) map.get(EncodeHintType.PDF417_COMPACT)).booleanValue());
            }
            if (map.containsKey(EncodeHintType.PDF417_COMPACTION)) {
                pdf417.setCompaction((Compaction) map.get(EncodeHintType.PDF417_COMPACTION));
            }
            if (map.containsKey(EncodeHintType.PDF417_DIMENSIONS)) {
                Dimensions dimensions = (Dimensions) map.get(EncodeHintType.PDF417_DIMENSIONS);
                pdf417.setDimensions(dimensions.getMaxCols(), dimensions.getMinCols(), dimensions.getMaxRows(), dimensions.getMinRows());
            }
            if (map.containsKey(EncodeHintType.MARGIN)) {
                i3 = ((Number) map.get(EncodeHintType.MARGIN)).intValue();
            }
            if (map.containsKey(EncodeHintType.ERROR_CORRECTION)) {
                i4 = ((Number) map.get(EncodeHintType.ERROR_CORRECTION)).intValue();
            }
            if (map.containsKey(EncodeHintType.CHARACTER_SET)) {
                pdf417.setEncoding(Charset.forName((String) map.get(EncodeHintType.CHARACTER_SET)));
            }
        }
        int i5 = i4;
        return bitMatrixFromEncoder(pdf417, str, i5, i, i2, i3);
    }
}
