package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

public final class EAN13Reader extends UPCEANReader {
    static final int[] FIRST_DIGIT_ENCODINGS = new int[]{0, 11, 13, 14, 19, 25, 28, 21, 22, 26};
    private final int[] decodeMiddleCounters = new int[4];

    private static void determineFirstDigit(StringBuilder stringBuilder, int i) throws NotFoundException {
        for (int i2 = 0; i2 < 10; i2++) {
            if (i == FIRST_DIGIT_ENCODINGS[i2]) {
                stringBuilder.insert(0, (char) (48 + i2));
                return;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* Access modifiers changed, original: protected */
    public int decodeMiddle(BitArray bitArray, int[] iArr, StringBuilder stringBuilder) throws NotFoundException {
        int i;
        int[] iArr2 = this.decodeMiddleCounters;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int size = bitArray.getSize();
        int i2 = iArr[1];
        int i3 = 0;
        int i4 = i3;
        while (i3 < 6 && i2 < size) {
            int decodeDigit = UPCEANReader.decodeDigit(bitArray, iArr2, i2, L_AND_G_PATTERNS);
            stringBuilder.append((char) (48 + (decodeDigit % 10)));
            i = i2;
            for (int i5 : iArr2) {
                i += i5;
            }
            if (decodeDigit >= 10) {
                i4 = (1 << (5 - i3)) | i4;
            }
            i3++;
            i2 = i;
        }
        determineFirstDigit(stringBuilder, i4);
        int i6 = UPCEANReader.findGuardPattern(bitArray, i2, true, MIDDLE_PATTERN)[1];
        i3 = 0;
        while (i3 < 6 && i6 < size) {
            stringBuilder.append((char) (UPCEANReader.decodeDigit(bitArray, iArr2, i6, L_PATTERNS) + 48));
            i4 = i6;
            for (int i7 : iArr2) {
                i4 += i7;
            }
            i3++;
            i6 = i4;
        }
        return i6;
    }

    /* Access modifiers changed, original: 0000 */
    public BarcodeFormat getBarcodeFormat() {
        return BarcodeFormat.EAN_13;
    }
}
