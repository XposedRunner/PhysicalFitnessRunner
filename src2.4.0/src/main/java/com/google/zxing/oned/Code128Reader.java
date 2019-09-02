package com.google.zxing.oned;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

public final class Code128Reader extends OneDReader {
    private static final int CODE_CODE_A = 101;
    private static final int CODE_CODE_B = 100;
    private static final int CODE_CODE_C = 99;
    private static final int CODE_FNC_1 = 102;
    private static final int CODE_FNC_2 = 97;
    private static final int CODE_FNC_3 = 96;
    private static final int CODE_FNC_4_A = 101;
    private static final int CODE_FNC_4_B = 100;
    static final int[][] CODE_PATTERNS = new int[][]{new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, new int[]{1, 2, 2, 2, 3, 1}, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};
    private static final int CODE_SHIFT = 98;
    private static final int CODE_START_A = 103;
    private static final int CODE_START_B = 104;
    private static final int CODE_START_C = 105;
    private static final int CODE_STOP = 106;
    private static final float MAX_AVG_VARIANCE = 0.25f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.7f;

    private static int decodeCode(BitArray bitArray, int[] iArr, int i) throws NotFoundException {
        OneDReader.recordPattern(bitArray, i, iArr);
        float f = 0.25f;
        i = -1;
        for (int i2 = 0; i2 < CODE_PATTERNS.length; i2++) {
            float patternMatchVariance = OneDReader.patternMatchVariance(iArr, CODE_PATTERNS[i2], 0.7f);
            if (patternMatchVariance < f) {
                i = i2;
                f = patternMatchVariance;
            }
        }
        if (i >= 0) {
            return i;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int[] findStartPattern(BitArray bitArray) throws NotFoundException {
        int size = bitArray.getSize();
        int nextSet = bitArray.getNextSet(0);
        int[] iArr = new int[6];
        int length = iArr.length;
        int i = 0;
        int i2 = i;
        int i3 = nextSet;
        while (nextSet < size) {
            if ((bitArray.get(nextSet) ^ i) != 0) {
                iArr[i2] = iArr[i2] + 1;
            } else {
                int i4 = length - 1;
                if (i2 == i4) {
                    int i5;
                    float f = 0.25f;
                    int i6 = -1;
                    for (i5 = 103; i5 <= 105; i5++) {
                        float patternMatchVariance = OneDReader.patternMatchVariance(iArr, CODE_PATTERNS[i5], 0.7f);
                        if (patternMatchVariance < f) {
                            i6 = i5;
                            f = patternMatchVariance;
                        }
                    }
                    if (i6 < 0 || !bitArray.isRange(Math.max(0, i3 - ((nextSet - i3) / 2)), i3, false)) {
                        i3 += iArr[0] + iArr[1];
                        i5 = length - 2;
                        System.arraycopy(iArr, 2, iArr, 0, i5);
                        iArr[i5] = 0;
                        iArr[i4] = 0;
                        i2--;
                    } else {
                        return new int[]{i3, nextSet, i6};
                    }
                }
                i2++;
                iArr[i2] = 1;
                i ^= 1;
            }
            nextSet++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX WARNING: Missing block: B:57:0x00f9, code skipped:
            r10 = 100;
     */
    /* JADX WARNING: Missing block: B:58:0x00fd, code skipped:
            r9 = r5;
            r5 = r10;
     */
    /* JADX WARNING: Missing block: B:64:0x0119, code skipped:
            r5 = 0;
            r9 = 0;
            r11 = 100;
     */
    /* JADX WARNING: Missing block: B:79:0x014a, code skipped:
            r9 = 0;
     */
    /* JADX WARNING: Missing block: B:84:0x0157, code skipped:
            r9 = r5;
            r5 = r10;
            r3 = 0;
            r10 = 99;
     */
    /* JADX WARNING: Missing block: B:86:0x0160, code skipped:
            r10 = 101;
     */
    /* JADX WARNING: Missing block: B:87:0x0163, code skipped:
            r9 = r5;
            r5 = r10;
     */
    /* JADX WARNING: Missing block: B:88:0x0165, code skipped:
            r10 = r3;
            r3 = 0;
     */
    /* JADX WARNING: Missing block: B:90:0x016c, code skipped:
            r11 = 100;
            r21 = r5;
            r5 = r3;
            r3 = r10;
            r10 = r21;
     */
    /* JADX WARNING: Missing block: B:110:0x01b1, code skipped:
            r9 = r5;
     */
    /* JADX WARNING: Missing block: B:111:0x01b2, code skipped:
            r5 = 0;
     */
    /* JADX WARNING: Missing block: B:112:0x01b3, code skipped:
            if (r8 == 0) goto L_0x01bd;
     */
    /* JADX WARNING: Missing block: B:114:0x01b7, code skipped:
            if (r3 != 101) goto L_0x01bb;
     */
    /* JADX WARNING: Missing block: B:115:0x01b9, code skipped:
            r3 = r11;
     */
    /* JADX WARNING: Missing block: B:116:0x01bb, code skipped:
            r3 = 101;
     */
    /* JADX WARNING: Missing block: B:118:0x01bf, code skipped:
            r8 = r5;
            r5 = r9;
            r9 = r12;
            r12 = r2;
            r2 = r14;
            r14 = r19;
     */
    public com.google.zxing.Result decodeRow(int r23, com.google.zxing.common.BitArray r24, java.util.Map<com.google.zxing.DecodeHintType, ?> r25) throws com.google.zxing.NotFoundException, com.google.zxing.FormatException, com.google.zxing.ChecksumException {
        /*
        r22 = this;
        r0 = r24;
        r1 = r25;
        r2 = 1;
        r3 = 0;
        if (r1 == 0) goto L_0x0012;
    L_0x0008:
        r4 = com.google.zxing.DecodeHintType.ASSUME_GS1;
        r1 = r1.containsKey(r4);
        if (r1 == 0) goto L_0x0012;
    L_0x0010:
        r1 = r2;
        goto L_0x0013;
    L_0x0012:
        r1 = r3;
    L_0x0013:
        r4 = findStartPattern(r24);
        r5 = 2;
        r6 = r4[r5];
        r7 = new java.util.ArrayList;
        r8 = 20;
        r7.<init>(r8);
        r9 = (byte) r6;
        r9 = java.lang.Byte.valueOf(r9);
        r7.add(r9);
        switch(r6) {
            case 103: goto L_0x0037;
            case 104: goto L_0x0034;
            case 105: goto L_0x0031;
            default: goto L_0x002c;
        };
    L_0x002c:
        r0 = com.google.zxing.FormatException.getFormatInstance();
        throw r0;
    L_0x0031:
        r12 = 99;
        goto L_0x0039;
    L_0x0034:
        r12 = 100;
        goto L_0x0039;
    L_0x0037:
        r12 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
    L_0x0039:
        r13 = new java.lang.StringBuilder;
        r13.<init>(r8);
        r8 = r4[r3];
        r14 = r4[r2];
        r15 = 6;
        r15 = new int[r15];
        r18 = r2;
        r5 = r3;
        r9 = r5;
        r10 = r9;
        r17 = r10;
        r16 = r6;
        r2 = r8;
        r6 = r17;
        r8 = r6;
        r3 = r12;
        r12 = r8;
    L_0x0054:
        if (r6 != 0) goto L_0x01c8;
    L_0x0056:
        r2 = decodeCode(r0, r15, r14);
        r9 = (byte) r2;
        r9 = java.lang.Byte.valueOf(r9);
        r7.add(r9);
        r9 = 106; // 0x6a float:1.49E-43 double:5.24E-322;
        if (r2 == r9) goto L_0x0068;
    L_0x0066:
        r18 = 1;
    L_0x0068:
        if (r2 == r9) goto L_0x0070;
    L_0x006a:
        r17 = r17 + 1;
        r19 = r17 * r2;
        r16 = r16 + r19;
    L_0x0070:
        r11 = r15.length;
        r19 = r14;
        r9 = 0;
    L_0x0074:
        if (r9 >= r11) goto L_0x007d;
    L_0x0076:
        r20 = r15[r9];
        r19 = r19 + r20;
        r9 = r9 + 1;
        goto L_0x0074;
    L_0x007d:
        switch(r2) {
            case 103: goto L_0x008b;
            case 104: goto L_0x008b;
            case 105: goto L_0x008b;
            default: goto L_0x0080;
        };
    L_0x0080:
        r9 = 96;
        r20 = 32;
        switch(r3) {
            case 99: goto L_0x0175;
            case 100: goto L_0x0106;
            case 101: goto L_0x0090;
            default: goto L_0x0087;
        };
    L_0x0087:
        r11 = 100;
        goto L_0x01b1;
    L_0x008b:
        r0 = com.google.zxing.FormatException.getFormatInstance();
        throw r0;
    L_0x0090:
        r11 = 64;
        if (r2 >= r11) goto L_0x00a8;
    L_0x0094:
        if (r5 != r10) goto L_0x009e;
    L_0x0096:
        r5 = r20 + r2;
        r5 = (char) r5;
        r13.append(r5);
        goto L_0x0119;
    L_0x009e:
        r5 = r20 + r2;
        r5 = r5 + 128;
        r5 = (char) r5;
        r13.append(r5);
        goto L_0x0119;
    L_0x00a8:
        if (r2 >= r9) goto L_0x00bc;
    L_0x00aa:
        if (r5 != r10) goto L_0x00b4;
    L_0x00ac:
        r5 = r2 + -64;
        r5 = (char) r5;
        r13.append(r5);
        goto L_0x0119;
    L_0x00b4:
        r5 = r2 + 64;
        r5 = (char) r5;
        r13.append(r5);
        goto L_0x0119;
    L_0x00bc:
        r9 = 106; // 0x6a float:1.49E-43 double:5.24E-322;
        if (r2 == r9) goto L_0x00c2;
    L_0x00c0:
        r18 = 0;
    L_0x00c2:
        if (r2 == r9) goto L_0x0101;
    L_0x00c4:
        switch(r2) {
            case 96: goto L_0x00fd;
            case 97: goto L_0x00fd;
            case 98: goto L_0x00f6;
            case 99: goto L_0x0157;
            case 100: goto L_0x00f2;
            case 101: goto L_0x00dc;
            case 102: goto L_0x00c8;
            default: goto L_0x00c7;
        };
    L_0x00c7:
        goto L_0x00fd;
    L_0x00c8:
        if (r1 == 0) goto L_0x00fd;
    L_0x00ca:
        r9 = r13.length();
        if (r9 != 0) goto L_0x00d6;
    L_0x00d0:
        r9 = "]C1";
        r13.append(r9);
        goto L_0x00fd;
    L_0x00d6:
        r9 = 29;
        r13.append(r9);
        goto L_0x00fd;
    L_0x00dc:
        if (r10 != 0) goto L_0x00e5;
    L_0x00de:
        if (r5 == 0) goto L_0x00e5;
    L_0x00e0:
        r10 = r3;
        r3 = 0;
        r5 = 1;
        goto L_0x014a;
    L_0x00e5:
        if (r10 == 0) goto L_0x00ee;
    L_0x00e7:
        if (r5 == 0) goto L_0x00ee;
    L_0x00e9:
        r10 = r3;
        r3 = 0;
        r5 = 0;
        goto L_0x014a;
    L_0x00ee:
        r5 = r10;
        r9 = 1;
        goto L_0x0165;
    L_0x00f2:
        r9 = r5;
        r5 = r10;
        r3 = 0;
        goto L_0x00f9;
    L_0x00f6:
        r9 = r5;
        r5 = r10;
        r3 = 1;
    L_0x00f9:
        r10 = 100;
        goto L_0x016c;
    L_0x00fd:
        r9 = r5;
        r5 = r10;
        goto L_0x0165;
    L_0x0101:
        r9 = r5;
        r5 = r10;
        r6 = 1;
        goto L_0x0165;
    L_0x0106:
        if (r2 >= r9) goto L_0x011f;
    L_0x0108:
        if (r5 != r10) goto L_0x0111;
    L_0x010a:
        r5 = r20 + r2;
        r5 = (char) r5;
        r13.append(r5);
        goto L_0x0119;
    L_0x0111:
        r5 = r20 + r2;
        r5 = r5 + 128;
        r5 = (char) r5;
        r13.append(r5);
    L_0x0119:
        r5 = 0;
        r9 = 0;
        r11 = 100;
        goto L_0x01b3;
    L_0x011f:
        r9 = 106; // 0x6a float:1.49E-43 double:5.24E-322;
        if (r2 == r9) goto L_0x0125;
    L_0x0123:
        r18 = 0;
    L_0x0125:
        if (r2 == r9) goto L_0x0168;
    L_0x0127:
        switch(r2) {
            case 96: goto L_0x0163;
            case 97: goto L_0x0163;
            case 98: goto L_0x015d;
            case 99: goto L_0x0157;
            case 100: goto L_0x0143;
            case 101: goto L_0x013f;
            case 102: goto L_0x012b;
            default: goto L_0x012a;
        };
    L_0x012a:
        goto L_0x0163;
    L_0x012b:
        if (r1 == 0) goto L_0x0163;
    L_0x012d:
        r9 = r13.length();
        if (r9 != 0) goto L_0x0139;
    L_0x0133:
        r9 = "]C1";
        r13.append(r9);
        goto L_0x0163;
    L_0x0139:
        r9 = 29;
        r13.append(r9);
        goto L_0x0163;
    L_0x013f:
        r9 = r5;
        r5 = r10;
        r3 = 0;
        goto L_0x0160;
    L_0x0143:
        if (r10 != 0) goto L_0x014c;
    L_0x0145:
        if (r5 == 0) goto L_0x014c;
    L_0x0147:
        r10 = r3;
        r3 = 0;
        r5 = 1;
    L_0x014a:
        r9 = 0;
        goto L_0x016c;
    L_0x014c:
        if (r10 == 0) goto L_0x0154;
    L_0x014e:
        if (r5 == 0) goto L_0x0154;
    L_0x0150:
        r10 = r3;
        r3 = 0;
        r5 = 0;
        goto L_0x014a;
    L_0x0154:
        r5 = r10;
        r9 = 1;
        goto L_0x0165;
    L_0x0157:
        r9 = r5;
        r5 = r10;
        r3 = 0;
        r10 = 99;
        goto L_0x016c;
    L_0x015d:
        r9 = r5;
        r5 = r10;
        r3 = 1;
    L_0x0160:
        r10 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        goto L_0x016c;
    L_0x0163:
        r9 = r5;
        r5 = r10;
    L_0x0165:
        r10 = r3;
        r3 = 0;
        goto L_0x016c;
    L_0x0168:
        r9 = r5;
        r5 = r10;
        r6 = 1;
        goto L_0x0165;
    L_0x016c:
        r11 = 100;
        r21 = r5;
        r5 = r3;
        r3 = r10;
        r10 = r21;
        goto L_0x01b3;
    L_0x0175:
        r11 = 100;
        if (r2 >= r11) goto L_0x0186;
    L_0x0179:
        r9 = 10;
        if (r2 >= r9) goto L_0x0182;
    L_0x017d:
        r9 = 48;
        r13.append(r9);
    L_0x0182:
        r13.append(r2);
        goto L_0x01b1;
    L_0x0186:
        r9 = 106; // 0x6a float:1.49E-43 double:5.24E-322;
        if (r2 == r9) goto L_0x018c;
    L_0x018a:
        r18 = 0;
    L_0x018c:
        if (r2 == r9) goto L_0x01ad;
    L_0x018e:
        switch(r2) {
            case 100: goto L_0x01aa;
            case 101: goto L_0x01a6;
            case 102: goto L_0x0192;
            default: goto L_0x0191;
        };
    L_0x0191:
        goto L_0x01b1;
    L_0x0192:
        if (r1 == 0) goto L_0x01b1;
    L_0x0194:
        r9 = r13.length();
        if (r9 != 0) goto L_0x01a0;
    L_0x019a:
        r9 = "]C1";
        r13.append(r9);
        goto L_0x01b1;
    L_0x01a0:
        r9 = 29;
        r13.append(r9);
        goto L_0x01b1;
    L_0x01a6:
        r9 = r5;
        r3 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        goto L_0x01b2;
    L_0x01aa:
        r9 = r5;
        r3 = r11;
        goto L_0x01b2;
    L_0x01ad:
        r9 = r5;
        r5 = 0;
        r6 = 1;
        goto L_0x01b3;
    L_0x01b1:
        r9 = r5;
    L_0x01b2:
        r5 = 0;
    L_0x01b3:
        if (r8 == 0) goto L_0x01bd;
    L_0x01b5:
        r8 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        if (r3 != r8) goto L_0x01bb;
    L_0x01b9:
        r3 = r11;
        goto L_0x01bf;
    L_0x01bb:
        r3 = r8;
        goto L_0x01bf;
    L_0x01bd:
        r8 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
    L_0x01bf:
        r8 = r5;
        r5 = r9;
        r9 = r12;
        r12 = r2;
        r2 = r14;
        r14 = r19;
        goto L_0x0054;
    L_0x01c8:
        r1 = r14 - r2;
        r5 = r0.getNextUnset(r14);
        r6 = r24.getSize();
        r8 = r5 - r2;
        r10 = 2;
        r8 = r8 / r10;
        r8 = r8 + r5;
        r6 = java.lang.Math.min(r6, r8);
        r8 = 0;
        r0 = r0.isRange(r5, r6, r8);
        if (r0 != 0) goto L_0x01e7;
    L_0x01e2:
        r0 = com.google.zxing.NotFoundException.getNotFoundInstance();
        throw r0;
    L_0x01e7:
        r17 = r17 * r9;
        r16 = r16 - r17;
        r0 = r16 % 103;
        if (r0 == r9) goto L_0x01f4;
    L_0x01ef:
        r0 = com.google.zxing.ChecksumException.getChecksumInstance();
        throw r0;
    L_0x01f4:
        r0 = r13.length();
        if (r0 != 0) goto L_0x01ff;
    L_0x01fa:
        r0 = com.google.zxing.NotFoundException.getNotFoundInstance();
        throw r0;
    L_0x01ff:
        if (r0 <= 0) goto L_0x0212;
    L_0x0201:
        if (r18 == 0) goto L_0x0212;
    L_0x0203:
        r5 = 99;
        if (r3 != r5) goto L_0x020d;
    L_0x0207:
        r3 = r0 + -2;
        r13.delete(r3, r0);
        goto L_0x0212;
    L_0x020d:
        r3 = r0 + -1;
        r13.delete(r3, r0);
    L_0x0212:
        r0 = 1;
        r3 = r4[r0];
        r0 = 0;
        r4 = r4[r0];
        r3 = r3 + r4;
        r0 = (float) r3;
        r3 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r0 = r0 / r3;
        r2 = (float) r2;
        r1 = (float) r1;
        r1 = r1 / r3;
        r2 = r2 + r1;
        r1 = r7.size();
        r3 = new byte[r1];
        r4 = 0;
    L_0x0228:
        if (r4 >= r1) goto L_0x0239;
    L_0x022a:
        r5 = r7.get(r4);
        r5 = (java.lang.Byte) r5;
        r5 = r5.byteValue();
        r3[r4] = r5;
        r4 = r4 + 1;
        goto L_0x0228;
    L_0x0239:
        r1 = new com.google.zxing.Result;
        r4 = r13.toString();
        r5 = 2;
        r5 = new com.google.zxing.ResultPoint[r5];
        r6 = new com.google.zxing.ResultPoint;
        r7 = r23;
        r7 = (float) r7;
        r6.<init>(r0, r7);
        r0 = 0;
        r5[r0] = r6;
        r0 = new com.google.zxing.ResultPoint;
        r0.<init>(r2, r7);
        r2 = 1;
        r5[r2] = r0;
        r0 = com.google.zxing.BarcodeFormat.CODE_128;
        r1.<init>(r4, r3, r5, r0);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.Code128Reader.decodeRow(int, com.google.zxing.common.BitArray, java.util.Map):com.google.zxing.Result");
    }
}
