package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

public abstract class OneDimensionalCodeWriter implements Writer {
    protected static int appendPattern(boolean[] zArr, int i, int[] iArr, boolean z) {
        int length = iArr.length;
        int i2 = i;
        boolean z2 = z;
        i = 0;
        int i3 = i;
        while (i < length) {
            int i4 = iArr[i];
            int i5 = i2;
            i2 = 0;
            while (i2 < i4) {
                int i6 = i5 + 1;
                zArr[i5] = z2;
                i2++;
                i5 = i6;
            }
            i3 += i4;
            z2 = !z2;
            i++;
            i2 = i5;
        }
        return i3;
    }

    private static BitMatrix renderResult(boolean[] zArr, int i, int i2, int i3) {
        int length = zArr.length;
        i3 += length;
        i = Math.max(i, i3);
        i2 = Math.max(1, i2);
        i3 = i / i3;
        int i4 = (i - (length * i3)) / 2;
        BitMatrix bitMatrix = new BitMatrix(i, i2);
        i = 0;
        while (i < length) {
            if (zArr[i]) {
                bitMatrix.setRegion(i4, 0, i3, i2);
            }
            i++;
            i4 += i3;
        }
        return bitMatrix;
    }

    public final BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2) throws WriterException {
        return encode(str, barcodeFormat, i, i2, null);
    }

    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (i < 0 || i2 < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Negative size is not allowed. Input: ");
            stringBuilder.append(i);
            stringBuilder.append('x');
            stringBuilder.append(i2);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else {
            int defaultMargin = getDefaultMargin();
            if (map != null) {
                Integer num = (Integer) map.get(EncodeHintType.MARGIN);
                if (num != null) {
                    defaultMargin = num.intValue();
                }
            }
            return renderResult(encode(str), i, i2, defaultMargin);
        }
    }

    public abstract boolean[] encode(String str);

    public int getDefaultMargin() {
        return 10;
    }
}
