package com.google.zxing.qrcode.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;

final class BitMatrixParser {
    private final BitMatrix bitMatrix;
    private boolean mirror;
    private FormatInformation parsedFormatInfo;
    private Version parsedVersion;

    BitMatrixParser(BitMatrix bitMatrix) throws FormatException {
        int height = bitMatrix.getHeight();
        if (height < 21 || (height & 3) != 1) {
            throw FormatException.getFormatInstance();
        }
        this.bitMatrix = bitMatrix;
    }

    private int copyBit(int i, int i2, int i3) {
        return this.mirror ? this.bitMatrix.get(i2, i) : this.bitMatrix.get(i, i2) ? (i3 << 1) | 1 : i3 << 1;
    }

    /* Access modifiers changed, original: 0000 */
    public void mirror() {
        int i = 0;
        while (i < this.bitMatrix.getWidth()) {
            int i2 = i + 1;
            for (int i3 = i2; i3 < this.bitMatrix.getHeight(); i3++) {
                if (this.bitMatrix.get(i, i3) != this.bitMatrix.get(i3, i)) {
                    this.bitMatrix.flip(i3, i);
                    this.bitMatrix.flip(i, i3);
                }
            }
            i = i2;
        }
    }

    /* Access modifiers changed, original: 0000 */
    public byte[] readCodewords() throws FormatException {
        FormatInformation readFormatInformation = readFormatInformation();
        Version readVersion = readVersion();
        DataMask forReference = DataMask.forReference(readFormatInformation.getDataMask());
        int height = this.bitMatrix.getHeight();
        forReference.unmaskBitMatrix(this.bitMatrix, height);
        BitMatrix buildFunctionPattern = readVersion.buildFunctionPattern();
        byte[] bArr = new byte[readVersion.getTotalCodewords()];
        int i = height - 1;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = i;
        while (i6 > 0) {
            if (i6 == 6) {
                i6--;
            }
            int i7 = i5;
            i5 = i4;
            i4 = i3;
            i3 = 0;
            while (i3 < height) {
                int i8 = i2 != 0 ? i - i3 : i3;
                int i9 = i5;
                i5 = i4;
                for (i4 = 0; i4 < 2; i4++) {
                    int i10 = i6 - i4;
                    if (!buildFunctionPattern.get(i10, i8)) {
                        i7++;
                        i9 <<= 1;
                        int i11 = this.bitMatrix.get(i10, i8) ? i9 | 1 : i9;
                        if (i7 == 8) {
                            i7 = i5 + 1;
                            bArr[i5] = (byte) i11;
                            i5 = i7;
                            i7 = 0;
                            i9 = 0;
                        } else {
                            i9 = i11;
                        }
                    }
                }
                i3++;
                i4 = i5;
                i5 = i9;
            }
            i2 ^= 1;
            i6 -= 2;
            i3 = i4;
            i4 = i5;
            i5 = i7;
        }
        if (i3 == readVersion.getTotalCodewords()) {
            return bArr;
        }
        throw FormatException.getFormatInstance();
    }

    /* Access modifiers changed, original: 0000 */
    public FormatInformation readFormatInformation() throws FormatException {
        if (this.parsedFormatInfo != null) {
            return this.parsedFormatInfo;
        }
        int i = 0;
        int i2 = 0;
        int i3 = i2;
        while (i2 < 6) {
            i3 = copyBit(i2, 8, i3);
            i2++;
        }
        i2 = copyBit(8, 7, copyBit(8, 8, copyBit(7, 8, i3)));
        for (i3 = 5; i3 >= 0; i3--) {
            i2 = copyBit(8, i3, i2);
        }
        i3 = this.bitMatrix.getHeight();
        int i4 = i3 - 7;
        for (int i5 = i3 - 1; i5 >= i4; i5--) {
            i = copyBit(8, i5, i);
        }
        for (i4 = i3 - 8; i4 < i3; i4++) {
            i = copyBit(i4, 8, i);
        }
        this.parsedFormatInfo = FormatInformation.decodeFormatInformation(i2, i);
        if (this.parsedFormatInfo != null) {
            return this.parsedFormatInfo;
        }
        throw FormatException.getFormatInstance();
    }

    /* Access modifiers changed, original: 0000 */
    public Version readVersion() throws FormatException {
        if (this.parsedVersion != null) {
            return this.parsedVersion;
        }
        int height = this.bitMatrix.getHeight();
        int i = (height - 17) / 4;
        if (i <= 6) {
            return Version.getVersionForNumber(i);
        }
        int i2;
        i = height - 11;
        int i3 = 5;
        int i4 = 0;
        int i5 = 0;
        for (i2 = 5; i2 >= 0; i2--) {
            for (int i6 = height - 9; i6 >= i; i6--) {
                i5 = copyBit(i6, i2, i5);
            }
        }
        Version decodeVersionInformation = Version.decodeVersionInformation(i5);
        if (decodeVersionInformation == null || decodeVersionInformation.getDimensionForVersion() != height) {
            while (i3 >= 0) {
                for (i2 = height - 9; i2 >= i; i2--) {
                    i4 = copyBit(i3, i2, i4);
                }
                i3--;
            }
            Version decodeVersionInformation2 = Version.decodeVersionInformation(i4);
            if (decodeVersionInformation2 == null || decodeVersionInformation2.getDimensionForVersion() != height) {
                throw FormatException.getFormatInstance();
            }
            this.parsedVersion = decodeVersionInformation2;
            return decodeVersionInformation2;
        }
        this.parsedVersion = decodeVersionInformation;
        return decodeVersionInformation;
    }

    /* Access modifiers changed, original: 0000 */
    public void remask() {
        if (this.parsedFormatInfo != null) {
            DataMask.forReference(this.parsedFormatInfo.getDataMask()).unmaskBitMatrix(this.bitMatrix, this.bitMatrix.getHeight());
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void setMirror(boolean z) {
        this.parsedVersion = null;
        this.parsedFormatInfo = null;
        this.mirror = z;
    }
}
