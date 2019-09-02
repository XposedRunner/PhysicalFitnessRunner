package com.google.zxing.aztec;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.aztec.encoder.AztecCode;
import com.google.zxing.aztec.encoder.Encoder;
import com.google.zxing.common.BitMatrix;
import java.nio.charset.Charset;
import java.util.Map;

public final class AztecWriter implements Writer {
    private static final Charset DEFAULT_CHARSET = Charset.forName("ISO-8859-1");

    private static BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Charset charset, int i3, int i4) {
        if (barcodeFormat == BarcodeFormat.AZTEC) {
            return renderResult(Encoder.encode(str.getBytes(charset), i3, i4), i, i2);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Can only encode AZTEC, but got ");
        stringBuilder.append(barcodeFormat);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    private static BitMatrix renderResult(AztecCode aztecCode, int i, int i2) {
        BitMatrix matrix = aztecCode.getMatrix();
        if (matrix == null) {
            throw new IllegalStateException();
        }
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        i = Math.max(i, width);
        i2 = Math.max(i2, height);
        int min = Math.min(i / width, i2 / height);
        int i3 = (i - (width * min)) / 2;
        int i4 = (i2 - (height * min)) / 2;
        BitMatrix bitMatrix = new BitMatrix(i, i2);
        i2 = 0;
        while (i2 < height) {
            int i5 = 0;
            int i6 = i3;
            while (i5 < width) {
                if (matrix.get(i5, i2)) {
                    bitMatrix.setRegion(i6, i4, min, min);
                }
                i5++;
                i6 += min;
            }
            i2++;
            i4 += min;
        }
        return bitMatrix;
    }

    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2) {
        return encode(str, barcodeFormat, i, i2, null);
    }

    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) {
        Number number = null;
        String str2 = map == null ? null : (String) map.get(EncodeHintType.CHARACTER_SET);
        Number number2 = map == null ? null : (Number) map.get(EncodeHintType.ERROR_CORRECTION);
        if (map != null) {
            number = (Number) map.get(EncodeHintType.AZTEC_LAYERS);
        }
        return encode(str, barcodeFormat, i, i2, str2 == null ? DEFAULT_CHARSET : Charset.forName(str2), number2 == null ? 33 : number2.intValue(), number == null ? 0 : number.intValue());
    }
}
