package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

public final class UPCAWriter implements Writer {
    private final EAN13Writer subWriter = new EAN13Writer();

    private static String preencode(String str) {
        StringBuilder stringBuilder;
        int length = str.length();
        if (length == 11) {
            length = 0;
            int i = 0;
            while (length < 11) {
                i += (str.charAt(length) - 48) * (length % 2 == 0 ? 3 : 1);
                length++;
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append((1000 - i) % 10);
            str = stringBuilder.toString();
        } else if (length != 12) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Requested contents should be 11 or 12 digits long, but got ");
            stringBuilder2.append(str.length());
            throw new IllegalArgumentException(stringBuilder2.toString());
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append('0');
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2) throws WriterException {
        return encode(str, barcodeFormat, i, i2, null);
    }

    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.UPC_A) {
            return this.subWriter.encode(preencode(str), BarcodeFormat.EAN_13, i, i2, map);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Can only encode UPC-A, but got ");
        stringBuilder.append(barcodeFormat);
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}
