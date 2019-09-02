package com.google.zxing.qrcode.decoder;

import com.google.zxing.qrcode.decoder.Version.ECB;
import com.google.zxing.qrcode.decoder.Version.ECBlocks;

final class DataBlock {
    private final byte[] codewords;
    private final int numDataCodewords;

    private DataBlock(int i, byte[] bArr) {
        this.numDataCodewords = i;
        this.codewords = bArr;
    }

    static DataBlock[] getDataBlocks(byte[] bArr, Version version, ErrorCorrectionLevel errorCorrectionLevel) {
        if (bArr.length != version.getTotalCodewords()) {
            throw new IllegalArgumentException();
        }
        int i;
        int dataCodewords;
        int i2;
        ECBlocks eCBlocksForLevel = version.getECBlocksForLevel(errorCorrectionLevel);
        ECB[] eCBlocks = eCBlocksForLevel.getECBlocks();
        int i3 = 0;
        int i4 = i3;
        while (i3 < eCBlocks.length) {
            i4 += eCBlocks[i3].getCount();
            i3++;
        }
        DataBlock[] dataBlockArr = new DataBlock[i4];
        i3 = eCBlocks.length;
        i4 = 0;
        int i5 = i4;
        while (i4 < i3) {
            ECB ecb = eCBlocks[i4];
            i = i5;
            i5 = 0;
            while (i5 < ecb.getCount()) {
                dataCodewords = ecb.getDataCodewords();
                int i6 = i + 1;
                dataBlockArr[i] = new DataBlock(dataCodewords, new byte[(eCBlocksForLevel.getECCodewordsPerBlock() + dataCodewords)]);
                i5++;
                i = i6;
            }
            i4++;
            i5 = i;
        }
        int length = dataBlockArr[0].codewords.length;
        i3 = dataBlockArr.length - 1;
        while (i3 >= 0 && dataBlockArr[i3].codewords.length != length) {
            i3--;
        }
        i3++;
        length -= eCBlocksForLevel.getECCodewordsPerBlock();
        int i7 = 0;
        i4 = i7;
        while (i7 < length) {
            i2 = i4;
            i4 = 0;
            while (i4 < i5) {
                dataCodewords = i2 + 1;
                dataBlockArr[i4].codewords[i7] = bArr[i2];
                i4++;
                i2 = dataCodewords;
            }
            i7++;
            i4 = i2;
        }
        i7 = i3;
        while (i7 < i5) {
            i = i4 + 1;
            dataBlockArr[i7].codewords[length] = bArr[i4];
            i7++;
            i4 = i;
        }
        i7 = dataBlockArr[0].codewords.length;
        while (length < i7) {
            i2 = i4;
            i4 = 0;
            while (i4 < i5) {
                int i8 = i2 + 1;
                dataBlockArr[i4].codewords[i4 < i3 ? length : length + 1] = bArr[i2];
                i4++;
                i2 = i8;
            }
            length++;
            i4 = i2;
        }
        return dataBlockArr;
    }

    /* Access modifiers changed, original: 0000 */
    public byte[] getCodewords() {
        return this.codewords;
    }

    /* Access modifiers changed, original: 0000 */
    public int getNumDataCodewords() {
        return this.numDataCodewords;
    }
}
