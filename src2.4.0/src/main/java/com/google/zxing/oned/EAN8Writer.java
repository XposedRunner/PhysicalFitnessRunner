package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

public final class EAN8Writer extends UPCEANWriter {
    private static final int CODE_WIDTH = 67;

    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.EAN_8) {
            return super.encode(str, barcodeFormat, i, i2, map);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Can only encode EAN_8, but got ");
        stringBuilder.append(barcodeFormat);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public boolean[] encode(String str) {
        if (str.length() != 8) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Requested contents should be 8 digits long, but got ");
            stringBuilder.append(str.length());
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        boolean[] zArr = new boolean[67];
        int appendPattern = OneDimensionalCodeWriter.appendPattern(zArr, 0, UPCEANReader.START_END_PATTERN, true) + 0;
        int i = 0;
        while (i <= 3) {
            int i2 = i + 1;
            appendPattern += OneDimensionalCodeWriter.appendPattern(zArr, appendPattern, UPCEANReader.L_PATTERNS[Integer.parseInt(str.substring(i, i2))], false);
            i = i2;
        }
        appendPattern += OneDimensionalCodeWriter.appendPattern(zArr, appendPattern, UPCEANReader.MIDDLE_PATTERN, false);
        i = 4;
        while (i <= 7) {
            int i3 = i + 1;
            appendPattern += OneDimensionalCodeWriter.appendPattern(zArr, appendPattern, UPCEANReader.L_PATTERNS[Integer.parseInt(str.substring(i, i3))], true);
            i = i3;
        }
        OneDimensionalCodeWriter.appendPattern(zArr, appendPattern, UPCEANReader.START_END_PATTERN, true);
        return zArr;
    }
}
