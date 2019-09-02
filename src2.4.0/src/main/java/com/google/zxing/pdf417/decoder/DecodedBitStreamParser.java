package com.google.zxing.pdf417.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.pdf417.PDF417ResultMetadata;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Arrays;

final class DecodedBitStreamParser {
    private static final int AL = 28;
    private static final int AS = 27;
    private static final int BEGIN_MACRO_PDF417_CONTROL_BLOCK = 928;
    private static final int BEGIN_MACRO_PDF417_OPTIONAL_FIELD = 923;
    private static final int BYTE_COMPACTION_MODE_LATCH = 901;
    private static final int BYTE_COMPACTION_MODE_LATCH_6 = 924;
    private static final Charset DEFAULT_ENCODING = Charset.forName("ISO-8859-1");
    private static final int ECI_CHARSET = 927;
    private static final int ECI_GENERAL_PURPOSE = 926;
    private static final int ECI_USER_DEFINED = 925;
    private static final BigInteger[] EXP900 = new BigInteger[16];
    private static final int LL = 27;
    private static final int MACRO_PDF417_TERMINATOR = 922;
    private static final int MAX_NUMERIC_CODEWORDS = 15;
    private static final char[] MIXED_CHARS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '&', 13, 9, ',', ':', '#', '-', '.', '$', '/', '+', '%', '*', '=', '^'};
    private static final int ML = 28;
    private static final int MODE_SHIFT_TO_BYTE_COMPACTION_MODE = 913;
    private static final int NUMBER_OF_SEQUENCE_CODEWORDS = 2;
    private static final int NUMERIC_COMPACTION_MODE_LATCH = 902;
    private static final int PAL = 29;
    private static final int PL = 25;
    private static final int PS = 29;
    private static final char[] PUNCT_CHARS = new char[]{';', '<', '>', '@', '[', '\\', ']', '_', '`', '~', '!', 13, 9, ',', ':', 10, '-', '.', '$', '/', '\"', '|', '*', '(', ')', '?', '{', '}', '\''};
    private static final int TEXT_COMPACTION_MODE_LATCH = 900;

    private enum Mode {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static {
        EXP900[0] = BigInteger.ONE;
        BigInteger valueOf = BigInteger.valueOf(900);
        EXP900[1] = valueOf;
        for (int i = 2; i < EXP900.length; i++) {
            EXP900[i] = EXP900[i - 1].multiply(valueOf);
        }
    }

    private DecodedBitStreamParser() {
    }

    private static int byteCompaction(int i, int[] iArr, Charset charset, int i2, StringBuilder stringBuilder) {
        int i3;
        int i4 = i;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i5 = MACRO_PDF417_TERMINATOR;
        int i6 = BEGIN_MACRO_PDF417_OPTIONAL_FIELD;
        int i7 = 928;
        int i8 = 902;
        long j = 900;
        int i9;
        int i10;
        if (i4 == 901) {
            int i11;
            int[] iArr2 = new int[6];
            int i12 = i2 + 1;
            int i13 = iArr[i2];
            int i14 = 0;
            i3 = i12;
            long j2 = 0;
            i12 = i14;
            while (i3 < iArr[0] && r19 == 0) {
                i9 = i14 + 1;
                iArr2[i14] = i13;
                long j3 = (j2 * j) + ((long) i13);
                i10 = i3 + 1;
                i3 = iArr[i3];
                if (i3 == 900 || i3 == 901 || i3 == 902 || i3 == BYTE_COMPACTION_MODE_LATCH_6 || i3 == 928 || i3 == r6 || i3 == r5) {
                    i5 = i10 - 1;
                    i14 = i9;
                    j2 = j3;
                    i12 = 1;
                    i6 = BEGIN_MACRO_PDF417_OPTIONAL_FIELD;
                    j = 900;
                    i13 = i3;
                    i3 = i5;
                    i5 = MACRO_PDF417_TERMINATOR;
                } else if (i9 % 5 != 0 || i9 <= 0) {
                    i14 = i9;
                    j2 = j3;
                    i5 = MACRO_PDF417_TERMINATOR;
                    i6 = BEGIN_MACRO_PDF417_OPTIONAL_FIELD;
                    i13 = i3;
                    i3 = i10;
                    j = 900;
                } else {
                    i9 = 0;
                    while (i9 < 6) {
                        byteArrayOutputStream.write((byte) ((int) (j3 >> ((5 - i9) * 8))));
                        i9++;
                        i5 = MACRO_PDF417_TERMINATOR;
                        i6 = BEGIN_MACRO_PDF417_OPTIONAL_FIELD;
                    }
                    i13 = i3;
                    i3 = i10;
                    i14 = 0;
                    j = 900;
                    j2 = 0;
                }
            }
            if (i3 != iArr[0] || i13 >= 900) {
                i11 = i14;
            } else {
                i11 = i14 + 1;
                iArr2[i14] = i13;
            }
            for (i9 = 0; i9 < i11; i9++) {
                byteArrayOutputStream.write((byte) iArr2[i9]);
            }
        } else if (i4 == BYTE_COMPACTION_MODE_LATCH_6) {
            i3 = i2;
            i4 = 0;
            i9 = i4;
            long j4 = 0;
            while (i3 < iArr[0] && r0 == 0) {
                Object obj;
                Object obj2;
                i10 = i3 + 1;
                i3 = iArr[i3];
                if (i3 < 900) {
                    i9++;
                    i3 = i10;
                    j4 = (j4 * 900) + ((long) i3);
                    obj = BYTE_COMPACTION_MODE_LATCH_6;
                } else {
                    if (i3 == 900 || i3 == 901 || i3 == i8) {
                        obj = BYTE_COMPACTION_MODE_LATCH_6;
                    } else {
                        obj = BYTE_COMPACTION_MODE_LATCH_6;
                        if (!(i3 == BYTE_COMPACTION_MODE_LATCH_6 || i3 == i7)) {
                            if (i3 != BEGIN_MACRO_PDF417_OPTIONAL_FIELD) {
                                if (i3 != MACRO_PDF417_TERMINATOR) {
                                    i3 = i10;
                                }
                                i3 = i10 - 1;
                                i4 = 1;
                            }
                            i3 = i10 - 1;
                            i4 = 1;
                        }
                    }
                    i3 = i10 - 1;
                    i4 = 1;
                }
                if (i9 % 5 != 0 || i9 <= 0) {
                    obj2 = 6;
                } else {
                    obj2 = 6;
                    for (i9 = 0; i9 < 6; i9++) {
                        byteArrayOutputStream.write((byte) ((int) (j4 >> ((5 - i9) * 8))));
                    }
                    i9 = 0;
                    j4 = 0;
                }
                Object obj3 = obj2;
                Object obj4 = obj;
                i7 = 928;
                i8 = 902;
            }
        } else {
            i3 = i2;
        }
        stringBuilder.append(new String(byteArrayOutputStream.toByteArray(), charset));
        return i3;
    }

    /* JADX WARNING: Missing block: B:15:0x004f, code skipped:
            r1 = byteCompaction(r2, r7, r3, r1, r0);
     */
    static com.google.zxing.common.DecoderResult decode(int[] r7, java.lang.String r8) throws com.google.zxing.FormatException {
        /*
        r0 = new java.lang.StringBuilder;
        r1 = 2;
        r2 = 1;
        r3 = r7.length;
        r3 = r3 * r1;
        r0.<init>(r3);
        r3 = DEFAULT_ENCODING;
        r2 = r7[r2];
        r4 = new com.google.zxing.pdf417.PDF417ResultMetadata;
        r4.<init>();
    L_0x0012:
        r5 = 0;
        r5 = r7[r5];
        if (r1 >= r5) goto L_0x0072;
    L_0x0017:
        r5 = 913; // 0x391 float:1.28E-42 double:4.51E-321;
        if (r2 == r5) goto L_0x0059;
    L_0x001b:
        switch(r2) {
            case 900: goto L_0x0054;
            case 901: goto L_0x004f;
            case 902: goto L_0x004a;
            default: goto L_0x001e;
        };
    L_0x001e:
        switch(r2) {
            case 922: goto L_0x0045;
            case 923: goto L_0x0045;
            case 924: goto L_0x004f;
            case 925: goto L_0x0042;
            case 926: goto L_0x003f;
            case 927: goto L_0x002d;
            case 928: goto L_0x0028;
            default: goto L_0x0021;
        };
    L_0x0021:
        r1 = r1 + -1;
        r1 = textCompaction(r7, r1, r0);
        goto L_0x0062;
    L_0x0028:
        r1 = decodeMacroBlock(r7, r1, r4);
        goto L_0x0062;
    L_0x002d:
        r2 = r1 + 1;
        r1 = r7[r1];
        r1 = com.google.zxing.common.CharacterSetECI.getCharacterSetECIByValue(r1);
        r1 = r1.name();
        r1 = java.nio.charset.Charset.forName(r1);
        r3 = r1;
        goto L_0x0061;
    L_0x003f:
        r1 = r1 + 2;
        goto L_0x0062;
    L_0x0042:
        r1 = r1 + 1;
        goto L_0x0062;
    L_0x0045:
        r7 = com.google.zxing.FormatException.getFormatInstance();
        throw r7;
    L_0x004a:
        r1 = numericCompaction(r7, r1, r0);
        goto L_0x0062;
    L_0x004f:
        r1 = byteCompaction(r2, r7, r3, r1, r0);
        goto L_0x0062;
    L_0x0054:
        r1 = textCompaction(r7, r1, r0);
        goto L_0x0062;
    L_0x0059:
        r2 = r1 + 1;
        r1 = r7[r1];
        r1 = (char) r1;
        r0.append(r1);
    L_0x0061:
        r1 = r2;
    L_0x0062:
        r2 = r7.length;
        if (r1 >= r2) goto L_0x006d;
    L_0x0065:
        r2 = r1 + 1;
        r1 = r7[r1];
        r6 = r2;
        r2 = r1;
        r1 = r6;
        goto L_0x0012;
    L_0x006d:
        r7 = com.google.zxing.FormatException.getFormatInstance();
        throw r7;
    L_0x0072:
        r7 = r0.length();
        if (r7 != 0) goto L_0x007d;
    L_0x0078:
        r7 = com.google.zxing.FormatException.getFormatInstance();
        throw r7;
    L_0x007d:
        r7 = new com.google.zxing.common.DecoderResult;
        r0 = r0.toString();
        r1 = 0;
        r7.<init>(r1, r0, r1, r8);
        r7.setOther(r4);
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DecodedBitStreamParser.decode(int[], java.lang.String):com.google.zxing.common.DecoderResult");
    }

    private static String decodeBase900toBase10(int[] iArr, int i) throws FormatException {
        BigInteger bigInteger = BigInteger.ZERO;
        for (int i2 = 0; i2 < i; i2++) {
            bigInteger = bigInteger.add(EXP900[(i - i2) - 1].multiply(BigInteger.valueOf((long) iArr[i2])));
        }
        String bigInteger2 = bigInteger.toString();
        if (bigInteger2.charAt(0) == '1') {
            return bigInteger2.substring(1);
        }
        throw FormatException.getFormatInstance();
    }

    private static int decodeMacroBlock(int[] iArr, int i, PDF417ResultMetadata pDF417ResultMetadata) throws FormatException {
        if (i + 2 > iArr[0]) {
            throw FormatException.getFormatInstance();
        }
        int[] iArr2 = new int[2];
        int i2 = i;
        i = 0;
        while (i < 2) {
            iArr2[i] = iArr[i2];
            i++;
            i2++;
        }
        pDF417ResultMetadata.setSegmentIndex(Integer.parseInt(decodeBase900toBase10(iArr2, 2)));
        StringBuilder stringBuilder = new StringBuilder();
        int textCompaction = textCompaction(iArr, i2, stringBuilder);
        pDF417ResultMetadata.setFileId(stringBuilder.toString());
        if (iArr[textCompaction] == BEGIN_MACRO_PDF417_OPTIONAL_FIELD) {
            textCompaction++;
            int[] iArr3 = new int[(iArr[0] - textCompaction)];
            int i3 = 0;
            int i4 = i3;
            while (textCompaction < iArr[0] && i3 == 0) {
                int i5 = textCompaction + 1;
                textCompaction = iArr[textCompaction];
                if (textCompaction < 900) {
                    int i6 = i4 + 1;
                    iArr3[i4] = textCompaction;
                    textCompaction = i5;
                    i4 = i6;
                } else if (textCompaction != MACRO_PDF417_TERMINATOR) {
                    throw FormatException.getFormatInstance();
                } else {
                    pDF417ResultMetadata.setLastSegment(true);
                    i3 = true;
                    textCompaction = i5 + 1;
                }
            }
            pDF417ResultMetadata.setOptionalData(Arrays.copyOf(iArr3, i4));
            return textCompaction;
        } else if (iArr[textCompaction] != MACRO_PDF417_TERMINATOR) {
            return textCompaction;
        } else {
            pDF417ResultMetadata.setLastSegment(true);
            return textCompaction + 1;
        }
    }

    /* JADX WARNING: Missing block: B:14:0x0048, code skipped:
            r4 = r5;
     */
    /* JADX WARNING: Missing block: B:19:0x0055, code skipped:
            r4 = r5;
     */
    /* JADX WARNING: Missing block: B:33:0x0082, code skipped:
            r4 = r3;
     */
    /* JADX WARNING: Missing block: B:50:0x00b4, code skipped:
            r5 = r4;
     */
    /* JADX WARNING: Missing block: B:62:0x00d5, code skipped:
            r3 = ' ';
     */
    /* JADX WARNING: Missing block: B:73:0x00f5, code skipped:
            r3 = 0;
     */
    /* JADX WARNING: Missing block: B:74:0x00f6, code skipped:
            if (r3 == 0) goto L_0x00fb;
     */
    /* JADX WARNING: Missing block: B:75:0x00f8, code skipped:
            r0.append(r3);
     */
    /* JADX WARNING: Missing block: B:76:0x00fb, code skipped:
            r2 = r2 + 1;
     */
    private static void decodeTextCompaction(int[] r15, int[] r16, int r17, java.lang.StringBuilder r18) {
        /*
        r0 = r18;
        r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA;
        r2 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA;
        r4 = r1;
        r5 = r2;
        r2 = 0;
        r1 = r17;
    L_0x000b:
        if (r2 >= r1) goto L_0x00ff;
    L_0x000d:
        r6 = r15[r2];
        r7 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.AnonymousClass1.$SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode;
        r8 = r4.ordinal();
        r7 = r7[r8];
        r8 = 65;
        r9 = 28;
        r10 = 27;
        r12 = 913; // 0x391 float:1.28E-42 double:4.51E-321;
        r13 = 900; // 0x384 float:1.261E-42 double:4.447E-321;
        r3 = 26;
        r11 = 29;
        switch(r7) {
            case 1: goto L_0x00ce;
            case 2: goto L_0x00a6;
            case 3: goto L_0x0074;
            case 4: goto L_0x0058;
            case 5: goto L_0x0044;
            case 6: goto L_0x002a;
            default: goto L_0x0028;
        };
    L_0x0028:
        goto L_0x00f5;
    L_0x002a:
        if (r6 >= r11) goto L_0x0031;
    L_0x002c:
        r3 = PUNCT_CHARS;
        r3 = r3[r6];
        goto L_0x0048;
    L_0x0031:
        if (r6 != r11) goto L_0x0036;
    L_0x0033:
        r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA;
        goto L_0x0082;
    L_0x0036:
        if (r6 != r12) goto L_0x003f;
    L_0x0038:
        r3 = r16[r2];
        r3 = (char) r3;
        r0.append(r3);
        goto L_0x0055;
    L_0x003f:
        if (r6 != r13) goto L_0x0055;
    L_0x0041:
        r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA;
        goto L_0x0082;
    L_0x0044:
        if (r6 >= r3) goto L_0x004b;
    L_0x0046:
        r8 = r8 + r6;
        r3 = (char) r8;
    L_0x0048:
        r4 = r5;
        goto L_0x00f6;
    L_0x004b:
        if (r6 != r3) goto L_0x0050;
    L_0x004d:
        r4 = r5;
        goto L_0x00d5;
    L_0x0050:
        if (r6 != r13) goto L_0x0055;
    L_0x0052:
        r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA;
        goto L_0x0082;
    L_0x0055:
        r4 = r5;
        goto L_0x00f5;
    L_0x0058:
        if (r6 >= r11) goto L_0x0060;
    L_0x005a:
        r3 = PUNCT_CHARS;
        r3 = r3[r6];
        goto L_0x00f6;
    L_0x0060:
        if (r6 != r11) goto L_0x0065;
    L_0x0062:
        r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA;
        goto L_0x0082;
    L_0x0065:
        if (r6 != r12) goto L_0x006f;
    L_0x0067:
        r3 = r16[r2];
        r3 = (char) r3;
        r0.append(r3);
        goto L_0x00f5;
    L_0x006f:
        if (r6 != r13) goto L_0x00f5;
    L_0x0071:
        r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA;
        goto L_0x0082;
    L_0x0074:
        r7 = 25;
        if (r6 >= r7) goto L_0x007e;
    L_0x0078:
        r3 = MIXED_CHARS;
        r3 = r3[r6];
        goto L_0x00f6;
    L_0x007e:
        if (r6 != r7) goto L_0x0085;
    L_0x0080:
        r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT;
    L_0x0082:
        r4 = r3;
        goto L_0x00f5;
    L_0x0085:
        if (r6 != r3) goto L_0x0088;
    L_0x0087:
        goto L_0x00d5;
    L_0x0088:
        if (r6 != r10) goto L_0x008d;
    L_0x008a:
        r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.LOWER;
        goto L_0x0082;
    L_0x008d:
        if (r6 != r9) goto L_0x0092;
    L_0x008f:
        r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA;
        goto L_0x0082;
    L_0x0092:
        if (r6 != r11) goto L_0x0097;
    L_0x0094:
        r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT_SHIFT;
        goto L_0x00b4;
    L_0x0097:
        if (r6 != r12) goto L_0x00a1;
    L_0x0099:
        r3 = r16[r2];
        r3 = (char) r3;
        r0.append(r3);
        goto L_0x00f5;
    L_0x00a1:
        if (r6 != r13) goto L_0x00f5;
    L_0x00a3:
        r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA;
        goto L_0x0082;
    L_0x00a6:
        if (r6 >= r3) goto L_0x00ad;
    L_0x00a8:
        r3 = 97;
        r3 = r3 + r6;
        r3 = (char) r3;
        goto L_0x00f6;
    L_0x00ad:
        if (r6 != r3) goto L_0x00b0;
    L_0x00af:
        goto L_0x00d5;
    L_0x00b0:
        if (r6 != r10) goto L_0x00b6;
    L_0x00b2:
        r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA_SHIFT;
    L_0x00b4:
        r5 = r4;
        goto L_0x0082;
    L_0x00b6:
        if (r6 != r9) goto L_0x00bb;
    L_0x00b8:
        r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.MIXED;
        goto L_0x0082;
    L_0x00bb:
        if (r6 != r11) goto L_0x00c0;
    L_0x00bd:
        r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT_SHIFT;
        goto L_0x00b4;
    L_0x00c0:
        if (r6 != r12) goto L_0x00c9;
    L_0x00c2:
        r3 = r16[r2];
        r3 = (char) r3;
        r0.append(r3);
        goto L_0x00f5;
    L_0x00c9:
        if (r6 != r13) goto L_0x00f5;
    L_0x00cb:
        r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA;
        goto L_0x0082;
    L_0x00ce:
        if (r6 >= r3) goto L_0x00d3;
    L_0x00d0:
        r8 = r8 + r6;
        r3 = (char) r8;
        goto L_0x00f6;
    L_0x00d3:
        if (r6 != r3) goto L_0x00d8;
    L_0x00d5:
        r3 = 32;
        goto L_0x00f6;
    L_0x00d8:
        if (r6 != r10) goto L_0x00dd;
    L_0x00da:
        r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.LOWER;
        goto L_0x0082;
    L_0x00dd:
        if (r6 != r9) goto L_0x00e2;
    L_0x00df:
        r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.MIXED;
        goto L_0x0082;
    L_0x00e2:
        if (r6 != r11) goto L_0x00e7;
    L_0x00e4:
        r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT_SHIFT;
        goto L_0x00b4;
    L_0x00e7:
        if (r6 != r12) goto L_0x00f0;
    L_0x00e9:
        r3 = r16[r2];
        r3 = (char) r3;
        r0.append(r3);
        goto L_0x00f5;
    L_0x00f0:
        if (r6 != r13) goto L_0x00f5;
    L_0x00f2:
        r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA;
        goto L_0x0082;
    L_0x00f5:
        r3 = 0;
    L_0x00f6:
        if (r3 == 0) goto L_0x00fb;
    L_0x00f8:
        r0.append(r3);
    L_0x00fb:
        r2 = r2 + 1;
        goto L_0x000b;
    L_0x00ff:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DecodedBitStreamParser.decodeTextCompaction(int[], int[], int, java.lang.StringBuilder):void");
    }

    private static int numericCompaction(int[] iArr, int i, StringBuilder stringBuilder) throws FormatException {
        int[] iArr2 = new int[15];
        int i2 = 0;
        int i3 = i2;
        while (i < iArr[0] && r2 == 0) {
            int i4 = i + 1;
            i = iArr[i];
            if (i4 == iArr[0]) {
                i2 = 1;
            }
            if (i < 900) {
                iArr2[i3] = i;
                i3++;
            } else if (i == 900 || i == 901 || i == BYTE_COMPACTION_MODE_LATCH_6 || i == 928 || i == BEGIN_MACRO_PDF417_OPTIONAL_FIELD || i == MACRO_PDF417_TERMINATOR) {
                i4--;
                i2 = 1;
            }
            if ((i3 % 15 == 0 || i == 902 || i2 != 0) && i3 > 0) {
                stringBuilder.append(decodeBase900toBase10(iArr2, i3));
                i3 = 0;
            }
            i = i4;
        }
        return i;
    }

    private static int textCompaction(int[] iArr, int i, StringBuilder stringBuilder) {
        int[] iArr2 = new int[((iArr[0] - i) * 2)];
        int[] iArr3 = new int[((iArr[0] - i) * 2)];
        int i2 = 0;
        int i3 = i2;
        while (i < iArr[0] && i2 == 0) {
            int i4 = i + 1;
            i = iArr[i];
            if (i < 900) {
                iArr2[i3] = i / 30;
                iArr2[i3 + 1] = i % 30;
                i3 += 2;
            } else if (i != MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                if (i != 928) {
                    switch (i) {
                        case 900:
                            i = i3 + 1;
                            iArr2[i3] = 900;
                            i3 = i;
                            break;
                        case 901:
                        case 902:
                            break;
                        default:
                            switch (i) {
                                case MACRO_PDF417_TERMINATOR /*922*/:
                                case BEGIN_MACRO_PDF417_OPTIONAL_FIELD /*923*/:
                                case BYTE_COMPACTION_MODE_LATCH_6 /*924*/:
                                    break;
                            }
                            break;
                    }
                }
                i4--;
                i2 = 1;
            } else {
                iArr2[i3] = MODE_SHIFT_TO_BYTE_COMPACTION_MODE;
                i = i4 + 1;
                iArr3[i3] = iArr[i4];
                i3++;
            }
            i = i4;
            continue;
        }
        decodeTextCompaction(iArr2, iArr3, i3, stringBuilder);
        return i;
    }
}
