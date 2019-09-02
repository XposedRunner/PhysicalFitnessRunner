package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

public final class EAN8Reader extends UPCEANReader {
    private final int[] decodeMiddleCounters = new int[4];

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
        while (i3 < 4 && i2 < size) {
            stringBuilder.append((char) (48 + UPCEANReader.decodeDigit(bitArray, iArr2, i2, L_PATTERNS)));
            int i4 = i2;
            for (int i5 : iArr2) {
                i4 += i5;
            }
            i3++;
            i2 = i4;
        }
        int i6 = UPCEANReader.findGuardPattern(bitArray, i2, true, MIDDLE_PATTERN)[1];
        i3 = 0;
        while (i3 < 4 && i6 < size) {
            stringBuilder.append((char) (UPCEANReader.decodeDigit(bitArray, iArr2, i6, L_PATTERNS) + 48));
            i5 = i6;
            for (int i7 : iArr2) {
                i5 += i7;
            }
            i3++;
            i6 = i5;
        }
        return i6;
    }

    /* Access modifiers changed, original: 0000 */
    public BarcodeFormat getBarcodeFormat() {
        return BarcodeFormat.EAN_8;
    }
}
