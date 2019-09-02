package com.google.zxing.maxicode.decoder;

import com.google.zxing.common.DecoderResult;
import java.text.DecimalFormat;
import java.text.NumberFormat;

final class DecodedBitStreamParser {
    private static final char ECI = '￺';
    private static final char FS = '\u001c';
    private static final char GS = '\u001d';
    private static final char LATCHA = '￷';
    private static final char LATCHB = '￸';
    private static final char LOCK = '￹';
    private static final NumberFormat NINE_DIGITS = new DecimalFormat("000000000");
    private static final char NS = '￻';
    private static final char PAD = '￼';
    private static final char RS = '\u001e';
    private static final String[] SETS = new String[]{"\nABCDEFGHIJKLMNOPQRSTUVWXYZ￺\u001c\u001d\u001e￻ ￼\"#$%&'()*+,-./0123456789:￱￲￳￴￸", "`abcdefghijklmnopqrstuvwxyz￺\u001c\u001d\u001e￻{￼}~;<=>?[\\]^_ ,./:@!|￼￵￶￼￰￲￳￴￷", "ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚ￺\u001c\u001d\u001eÛÜÝÞßª¬±²³µ¹º¼½¾￷ ￹￳￴￸", "àáâãäåæçèéêëìíîïðñòóôõö÷øùú￺\u001c\u001d\u001e￻ûüýþÿ¡¨«¯°´·¸»¿￷ ￲￹￴￸", "\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a￺￼￼\u001b￻\u001c\u001d\u001e\u001f ¢£¤¥¦§©­®¶￷ ￲￳￹￸", "\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./0123456789:;<=>?"};
    private static final char SHIFTA = '￰';
    private static final char SHIFTB = '￱';
    private static final char SHIFTC = '￲';
    private static final char SHIFTD = '￳';
    private static final char SHIFTE = '￴';
    private static final char THREESHIFTA = '￶';
    private static final NumberFormat THREE_DIGITS = new DecimalFormat("000");
    private static final char TWOSHIFTA = '￵';

    private DecodedBitStreamParser() {
    }

    static DecoderResult decode(byte[] bArr, int i) {
        StringBuilder stringBuilder = new StringBuilder(144);
        switch (i) {
            case 2:
            case 3:
                String format;
                if (i == 2) {
                    format = new DecimalFormat("0000000000".substring(0, getPostCode2Length(bArr))).format((long) getPostCode2(bArr));
                } else {
                    format = getPostCode3(bArr);
                }
                String format2 = THREE_DIGITS.format((long) getCountry(bArr));
                String format3 = THREE_DIGITS.format((long) getServiceClass(bArr));
                stringBuilder.append(getMessage(bArr, 10, 84));
                StringBuilder stringBuilder2;
                if (!stringBuilder.toString().startsWith("[)>\u001e01\u001d")) {
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(format);
                    stringBuilder2.append(GS);
                    stringBuilder2.append(format2);
                    stringBuilder2.append(GS);
                    stringBuilder2.append(format3);
                    stringBuilder2.append(GS);
                    stringBuilder.insert(0, stringBuilder2.toString());
                    break;
                }
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(format);
                stringBuilder2.append(GS);
                stringBuilder2.append(format2);
                stringBuilder2.append(GS);
                stringBuilder2.append(format3);
                stringBuilder2.append(GS);
                stringBuilder.insert(9, stringBuilder2.toString());
                break;
            case 4:
                stringBuilder.append(getMessage(bArr, 1, 93));
                break;
            case 5:
                stringBuilder.append(getMessage(bArr, 1, 77));
                break;
        }
        return new DecoderResult(bArr, stringBuilder.toString(), null, String.valueOf(i));
    }

    private static int getBit(int i, byte[] bArr) {
        i--;
        return ((1 << (5 - (i % 6))) & bArr[i / 6]) == 0 ? 0 : 1;
    }

    private static int getCountry(byte[] bArr) {
        return getInt(bArr, new byte[]{(byte) 53, (byte) 54, (byte) 43, (byte) 44, (byte) 45, (byte) 46, (byte) 47, (byte) 48, (byte) 37, (byte) 38});
    }

    private static int getInt(byte[] bArr, byte[] bArr2) {
        if (bArr2.length == 0) {
            throw new IllegalArgumentException();
        }
        int i = 0;
        int i2 = 0;
        while (i < bArr2.length) {
            i2 += getBit(bArr2[i], bArr) << ((bArr2.length - i) - 1);
            i++;
        }
        return i2;
    }

    /* JADX WARNING: Missing block: B:9:0x004c, code skipped:
            r5 = -1;
     */
    /* JADX WARNING: Missing block: B:12:0x0051, code skipped:
            r6 = r4;
            r4 = 0;
     */
    /* JADX WARNING: Missing block: B:14:0x005c, code skipped:
            r7 = r5 - 1;
     */
    /* JADX WARNING: Missing block: B:15:0x005e, code skipped:
            if (r5 != 0) goto L_0x0061;
     */
    /* JADX WARNING: Missing block: B:16:0x0060, code skipped:
            r4 = r6;
     */
    /* JADX WARNING: Missing block: B:17:0x0061, code skipped:
            r3 = r3 + 1;
            r5 = r7;
     */
    private static java.lang.String getMessage(byte[] r12, int r13, int r14) {
        /*
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = 0;
        r2 = -1;
        r3 = r13;
        r4 = r1;
        r6 = r4;
        r5 = r2;
    L_0x000b:
        r7 = r13 + r14;
        r8 = 1;
        if (r3 >= r7) goto L_0x0064;
    L_0x0010:
        r7 = SETS;
        r7 = r7[r4];
        r9 = r12[r3];
        r7 = r7.charAt(r9);
        switch(r7) {
            case 65520: goto L_0x0054;
            case 65521: goto L_0x0054;
            case 65522: goto L_0x0054;
            case 65523: goto L_0x0054;
            case 65524: goto L_0x0054;
            case 65525: goto L_0x0050;
            case 65526: goto L_0x004e;
            case 65527: goto L_0x004b;
            case 65528: goto L_0x0048;
            case 65529: goto L_0x004c;
            case 65530: goto L_0x001d;
            case 65531: goto L_0x0021;
            default: goto L_0x001d;
        };
    L_0x001d:
        r0.append(r7);
        goto L_0x005c;
    L_0x0021:
        r3 = r3 + 1;
        r7 = r12[r3];
        r7 = r7 << 24;
        r3 = r3 + r8;
        r9 = r12[r3];
        r9 = r9 << 18;
        r7 = r7 + r9;
        r3 = r3 + r8;
        r9 = r12[r3];
        r9 = r9 << 12;
        r7 = r7 + r9;
        r3 = r3 + r8;
        r9 = r12[r3];
        r9 = r9 << 6;
        r7 = r7 + r9;
        r3 = r3 + r8;
        r9 = r12[r3];
        r7 = r7 + r9;
        r9 = NINE_DIGITS;
        r10 = (long) r7;
        r7 = r9.format(r10);
        r0.append(r7);
        goto L_0x005c;
    L_0x0048:
        r5 = r2;
        r4 = r8;
        goto L_0x005c;
    L_0x004b:
        r4 = r1;
    L_0x004c:
        r5 = r2;
        goto L_0x005c;
    L_0x004e:
        r5 = 3;
        goto L_0x0051;
    L_0x0050:
        r5 = 2;
    L_0x0051:
        r6 = r4;
        r4 = r1;
        goto L_0x005c;
    L_0x0054:
        r5 = 65520; // 0xfff0 float:9.1813E-41 double:3.2371E-319;
        r5 = r7 - r5;
        r6 = r4;
        r4 = r5;
        r5 = r8;
    L_0x005c:
        r7 = r5 + -1;
        if (r5 != 0) goto L_0x0061;
    L_0x0060:
        r4 = r6;
    L_0x0061:
        r3 = r3 + r8;
        r5 = r7;
        goto L_0x000b;
    L_0x0064:
        r12 = r0.length();
        if (r12 <= 0) goto L_0x0081;
    L_0x006a:
        r12 = r0.length();
        r12 = r12 - r8;
        r12 = r0.charAt(r12);
        r13 = 65532; // 0xfffc float:9.183E-41 double:3.2377E-319;
        if (r12 != r13) goto L_0x0081;
    L_0x0078:
        r12 = r0.length();
        r12 = r12 - r8;
        r0.setLength(r12);
        goto L_0x0064;
    L_0x0081:
        r12 = r0.toString();
        return r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.maxicode.decoder.DecodedBitStreamParser.getMessage(byte[], int, int):java.lang.String");
    }

    private static int getPostCode2(byte[] bArr) {
        return getInt(bArr, new byte[]{(byte) 33, (byte) 34, (byte) 35, (byte) 36, (byte) 25, (byte) 26, (byte) 27, (byte) 28, (byte) 29, (byte) 30, (byte) 19, (byte) 20, (byte) 21, (byte) 22, (byte) 23, (byte) 24, (byte) 13, (byte) 14, (byte) 15, (byte) 16, (byte) 17, (byte) 18, (byte) 7, (byte) 8, (byte) 9, (byte) 10, (byte) 11, (byte) 12, (byte) 1, (byte) 2});
    }

    private static int getPostCode2Length(byte[] bArr) {
        return getInt(bArr, new byte[]{(byte) 39, (byte) 40, (byte) 41, (byte) 42, (byte) 31, (byte) 32});
    }

    private static String getPostCode3(byte[] bArr) {
        return String.valueOf(new char[]{SETS[0].charAt(getInt(bArr, new byte[]{(byte) 39, (byte) 40, (byte) 41, (byte) 42, (byte) 31, (byte) 32})), SETS[0].charAt(getInt(bArr, new byte[]{(byte) 33, (byte) 34, (byte) 35, (byte) 36, (byte) 25, (byte) 26})), SETS[0].charAt(getInt(bArr, new byte[]{(byte) 27, (byte) 28, (byte) 29, (byte) 30, (byte) 19, (byte) 20})), SETS[0].charAt(getInt(bArr, new byte[]{(byte) 21, (byte) 22, (byte) 23, (byte) 24, (byte) 13, (byte) 14})), SETS[0].charAt(getInt(bArr, new byte[]{(byte) 15, (byte) 16, (byte) 17, (byte) 18, (byte) 7, (byte) 8})), SETS[0].charAt(getInt(bArr, new byte[]{(byte) 9, (byte) 10, (byte) 11, (byte) 12, (byte) 1, (byte) 2}))});
    }

    private static int getServiceClass(byte[] bArr) {
        return getInt(bArr, new byte[]{(byte) 55, (byte) 56, (byte) 57, (byte) 58, (byte) 59, (byte) 60, (byte) 49, (byte) 50, (byte) 51, (byte) 52});
    }
}
