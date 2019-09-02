package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

public final class ITFWriter extends OneDimensionalCodeWriter {
    private static final int[] END_PATTERN = new int[]{3, 1, 1};
    private static final int[] START_PATTERN = new int[]{1, 1, 1, 1};

    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.ITF) {
            return super.encode(str, barcodeFormat, i, i2, map);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Can only encode ITF, but got ");
        stringBuilder.append(barcodeFormat);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public boolean[] encode(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("The lenght of the input should be even");
        } else if (length > 80) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Requested contents should be less than 80 digits long, but got ");
            stringBuilder.append(length);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else {
            boolean[] zArr = new boolean[(9 + (9 * length))];
            int appendPattern = OneDimensionalCodeWriter.appendPattern(zArr, 0, START_PATTERN, true);
            for (int i = 0; i < length; i += 2) {
                int digit = Character.digit(str.charAt(i), 10);
                int digit2 = Character.digit(str.charAt(i + 1), 10);
                int[] iArr = new int[18];
                for (int i2 = 0; i2 < 5; i2++) {
                    int i3 = 2 * i2;
                    iArr[i3] = ITFReader.PATTERNS[digit][i2];
                    iArr[i3 + 1] = ITFReader.PATTERNS[digit2][i2];
                }
                appendPattern += OneDimensionalCodeWriter.appendPattern(zArr, appendPattern, iArr, true);
            }
            OneDimensionalCodeWriter.appendPattern(zArr, appendPattern, END_PATTERN, true);
            return zArr;
        }
    }
}
