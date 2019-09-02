package com.google.zxing.qrcode.decoder;

final class FormatInformation {
    private static final int[] BITS_SET_IN_HALF_BYTE = new int[]{0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4};
    private static final int[][] FORMAT_INFO_DECODE_LOOKUP = new int[][]{new int[]{FORMAT_INFO_MASK_QR, 0}, new int[]{20773, 1}, new int[]{24188, 2}, new int[]{23371, 3}, new int[]{17913, 4}, new int[]{16590, 5}, new int[]{20375, 6}, new int[]{19104, 7}, new int[]{30660, 8}, new int[]{29427, 9}, new int[]{32170, 10}, new int[]{30877, 11}, new int[]{26159, 12}, new int[]{25368, 13}, new int[]{27713, 14}, new int[]{26998, 15}, new int[]{5769, 16}, new int[]{5054, 17}, new int[]{7399, 18}, new int[]{6608, 19}, new int[]{1890, 20}, new int[]{597, 21}, new int[]{3340, 22}, new int[]{2107, 23}, new int[]{13663, 24}, new int[]{12392, 25}, new int[]{16177, 26}, new int[]{14854, 27}, new int[]{9396, 28}, new int[]{8579, 29}, new int[]{11994, 30}, new int[]{11245, 31}};
    private static final int FORMAT_INFO_MASK_QR = 21522;
    private final byte dataMask;
    private final ErrorCorrectionLevel errorCorrectionLevel;

    private FormatInformation(int i) {
        this.errorCorrectionLevel = ErrorCorrectionLevel.forBits((i >> 3) & 3);
        this.dataMask = (byte) (i & 7);
    }

    static FormatInformation decodeFormatInformation(int i, int i2) {
        FormatInformation doDecodeFormatInformation = doDecodeFormatInformation(i, i2);
        return doDecodeFormatInformation != null ? doDecodeFormatInformation : doDecodeFormatInformation(i ^ FORMAT_INFO_MASK_QR, i2 ^ FORMAT_INFO_MASK_QR);
    }

    private static FormatInformation doDecodeFormatInformation(int i, int i2) {
        int[][] iArr = FORMAT_INFO_DECODE_LOOKUP;
        int length = iArr.length;
        int i3 = 0;
        int i4 = Integer.MAX_VALUE;
        for (int i5 = i3; i5 < length; i5++) {
            int[] iArr2 = iArr[i5];
            int i6 = iArr2[0];
            if (i6 == i || i6 == i2) {
                return new FormatInformation(iArr2[1]);
            }
            int numBitsDiffering = numBitsDiffering(i, i6);
            if (numBitsDiffering < i4) {
                i3 = iArr2[1];
                i4 = numBitsDiffering;
            }
            if (i != i2) {
                i6 = numBitsDiffering(i2, i6);
                if (i6 < i4) {
                    i3 = iArr2[1];
                    i4 = i6;
                }
            }
        }
        return i4 <= 3 ? new FormatInformation(i3) : null;
    }

    static int numBitsDiffering(int i, int i2) {
        i ^= i2;
        return ((((((BITS_SET_IN_HALF_BYTE[i & 15] + BITS_SET_IN_HALF_BYTE[(i >>> 4) & 15]) + BITS_SET_IN_HALF_BYTE[(i >>> 8) & 15]) + BITS_SET_IN_HALF_BYTE[(i >>> 12) & 15]) + BITS_SET_IN_HALF_BYTE[(i >>> 16) & 15]) + BITS_SET_IN_HALF_BYTE[(i >>> 20) & 15]) + BITS_SET_IN_HALF_BYTE[(i >>> 24) & 15]) + BITS_SET_IN_HALF_BYTE[(i >>> 28) & 15];
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof FormatInformation)) {
            return false;
        }
        FormatInformation formatInformation = (FormatInformation) obj;
        if (this.errorCorrectionLevel == formatInformation.errorCorrectionLevel && this.dataMask == formatInformation.dataMask) {
            z = true;
        }
        return z;
    }

    /* Access modifiers changed, original: 0000 */
    public byte getDataMask() {
        return this.dataMask;
    }

    /* Access modifiers changed, original: 0000 */
    public ErrorCorrectionLevel getErrorCorrectionLevel() {
        return this.errorCorrectionLevel;
    }

    public int hashCode() {
        return (this.errorCorrectionLevel.ordinal() << 3) | this.dataMask;
    }
}
