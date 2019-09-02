package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.Map;

public final class Code128Writer extends OneDimensionalCodeWriter {
    private static final int CODE_CODE_B = 100;
    private static final int CODE_CODE_C = 99;
    private static final int CODE_FNC_1 = 102;
    private static final int CODE_FNC_2 = 97;
    private static final int CODE_FNC_3 = 96;
    private static final int CODE_FNC_4_B = 100;
    private static final int CODE_START_B = 104;
    private static final int CODE_START_C = 105;
    private static final int CODE_STOP = 106;
    private static final char ESCAPE_FNC_1 = 'ñ';
    private static final char ESCAPE_FNC_2 = 'ò';
    private static final char ESCAPE_FNC_3 = 'ó';
    private static final char ESCAPE_FNC_4 = 'ô';

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0022  */
    private static boolean isDigits(java.lang.CharSequence r4, int r5, int r6) {
        /*
        r6 = r6 + r5;
        r0 = r4.length();
    L_0x0005:
        r1 = 0;
        if (r5 >= r6) goto L_0x0020;
    L_0x0008:
        if (r5 >= r0) goto L_0x0020;
    L_0x000a:
        r2 = r4.charAt(r5);
        r3 = 48;
        if (r2 < r3) goto L_0x0016;
    L_0x0012:
        r3 = 57;
        if (r2 <= r3) goto L_0x001d;
    L_0x0016:
        r3 = 241; // 0xf1 float:3.38E-43 double:1.19E-321;
        if (r2 == r3) goto L_0x001b;
    L_0x001a:
        return r1;
    L_0x001b:
        r6 = r6 + 1;
    L_0x001d:
        r5 = r5 + 1;
        goto L_0x0005;
    L_0x0020:
        if (r6 > r0) goto L_0x0023;
    L_0x0022:
        r1 = 1;
    L_0x0023:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.Code128Writer.isDigits(java.lang.CharSequence, int, int):boolean");
    }

    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.CODE_128) {
            return super.encode(str, barcodeFormat, i, i2, map);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Can only encode CODE_128, but got ");
        stringBuilder.append(barcodeFormat);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public boolean[] encode(String str) {
        int length = str.length();
        if (length < 1 || length > 80) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Contents length should be between 1 and 80 characters, but got ");
            stringBuilder.append(length);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt < ' ' || charAt > '~') {
                switch (charAt) {
                    case 241:
                    case 242:
                    case 243:
                    case 244:
                        break;
                    default:
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("Bad character in input: ");
                        stringBuilder2.append(charAt);
                        throw new IllegalArgumentException(stringBuilder2.toString());
                }
            }
        }
        ArrayList<int[]> arrayList = new ArrayList();
        int i3 = 1;
        int i4 = 0;
        int i5 = i4;
        int i6 = i5;
        while (i4 < length) {
            int i7 = 99;
            int i8 = 100;
            if (!isDigits(str, i4, i5 == 99 ? 2 : 4)) {
                i7 = 100;
            }
            if (i7 == i5) {
                switch (str.charAt(i4)) {
                    case 241:
                        i8 = 102;
                        break;
                    case 242:
                        i8 = 97;
                        break;
                    case 243:
                        i8 = 96;
                        break;
                    case 244:
                        break;
                    default:
                        if (i5 != 100) {
                            i8 = Integer.parseInt(str.substring(i4, i4 + 2));
                            i4++;
                            break;
                        }
                        i8 = str.charAt(i4) - 32;
                        break;
                }
                i4++;
            } else {
                if (i5 == 0) {
                    i8 = i7 == 100 ? 104 : 105;
                } else {
                    i8 = i7;
                }
                i5 = i7;
            }
            arrayList.add(Code128Reader.CODE_PATTERNS[i8]);
            i6 += i8 * i3;
            if (i4 != 0) {
                i3++;
            }
        }
        arrayList.add(Code128Reader.CODE_PATTERNS[i6 % 103]);
        arrayList.add(Code128Reader.CODE_PATTERNS[106]);
        length = 0;
        for (int[] iArr : arrayList) {
            i5 = length;
            for (int i62 : (int[]) r13.next()) {
                i5 += i62;
            }
            length = i5;
        }
        boolean[] zArr = new boolean[length];
        for (int[] appendPattern : arrayList) {
            i += OneDimensionalCodeWriter.appendPattern(zArr, i, appendPattern, true);
        }
        return zArr;
    }
}
