package com.google.zxing.datamatrix.decoder;

final class DataBlock {
    private final byte[] codewords;
    private final int numDataCodewords;

    private DataBlock(int i, byte[] bArr) {
        this.numDataCodewords = i;
        this.codewords = bArr;
    }

    static DataBlock[] getDataBlocks(byte[] bArr, Version version) {
        int i;
        int dataCodewords;
        int i2;
        ECBlocks eCBlocks = version.getECBlocks();
        ECB[] eCBlocks2 = eCBlocks.getECBlocks();
        int i3 = 0;
        int i4 = i3;
        while (i3 < eCBlocks2.length) {
            i4 += eCBlocks2[i3].getCount();
            i3++;
        }
        DataBlock[] dataBlockArr = new DataBlock[i4];
        i3 = eCBlocks2.length;
        i4 = 0;
        int i5 = i4;
        while (i4 < i3) {
            ECB ecb = eCBlocks2[i4];
            i = i5;
            i5 = 0;
            while (i5 < ecb.getCount()) {
                dataCodewords = ecb.getDataCodewords();
                int i6 = i + 1;
                dataBlockArr[i] = new DataBlock(dataCodewords, new byte[(eCBlocks.getECCodewords() + dataCodewords)]);
                i5++;
                i = i6;
            }
            i4++;
            i5 = i;
        }
        int length = dataBlockArr[0].codewords.length - eCBlocks.getECCodewords();
        int i7 = length - 1;
        i3 = 0;
        i4 = i3;
        while (i3 < i7) {
            i2 = i4;
            i4 = 0;
            while (i4 < i5) {
                dataCodewords = i2 + 1;
                dataBlockArr[i4].codewords[i3] = bArr[i2];
                i4++;
                i2 = dataCodewords;
            }
            i3++;
            i4 = i2;
        }
        int i8 = version.getVersionNumber() == 24 ? 1 : 0;
        i3 = i8 != 0 ? 8 : i5;
        i2 = i4;
        i4 = 0;
        while (i4 < i3) {
            dataCodewords = i2 + 1;
            dataBlockArr[i4].codewords[i7] = bArr[i2];
            i4++;
            i2 = dataCodewords;
        }
        i7 = dataBlockArr[0].codewords.length;
        while (length < i7) {
            i3 = 0;
            while (i3 < i5) {
                i4 = i8 != 0 ? (i3 + 8) % i5 : i3;
                i = (i8 == 0 || i4 <= 7) ? length : length - 1;
                dataCodewords = i2 + 1;
                dataBlockArr[i4].codewords[i] = bArr[i2];
                i3++;
                i2 = dataCodewords;
            }
            length++;
        }
        if (i2 == bArr.length) {
            return dataBlockArr;
        }
        throw new IllegalArgumentException();
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
