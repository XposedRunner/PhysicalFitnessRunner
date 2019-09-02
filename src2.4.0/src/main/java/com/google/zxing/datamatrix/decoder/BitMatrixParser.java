package com.google.zxing.datamatrix.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;

final class BitMatrixParser {
    private final BitMatrix mappingBitMatrix;
    private final BitMatrix readMappingMatrix;
    private final Version version;

    BitMatrixParser(BitMatrix bitMatrix) throws FormatException {
        int height = bitMatrix.getHeight();
        if (height < 8 || height > 144 || (height & 1) != 0) {
            throw FormatException.getFormatInstance();
        }
        this.version = readVersion(bitMatrix);
        this.mappingBitMatrix = extractDataRegion(bitMatrix);
        this.readMappingMatrix = new BitMatrix(this.mappingBitMatrix.getWidth(), this.mappingBitMatrix.getHeight());
    }

    private static Version readVersion(BitMatrix bitMatrix) throws FormatException {
        return Version.getVersionForDimensions(bitMatrix.getHeight(), bitMatrix.getWidth());
    }

    /* Access modifiers changed, original: 0000 */
    public BitMatrix extractDataRegion(BitMatrix bitMatrix) {
        int symbolSizeRows = this.version.getSymbolSizeRows();
        int symbolSizeColumns = this.version.getSymbolSizeColumns();
        if (bitMatrix.getHeight() != symbolSizeRows) {
            throw new IllegalArgumentException("Dimension of bitMarix must match the version size");
        }
        int dataRegionSizeRows = this.version.getDataRegionSizeRows();
        int dataRegionSizeColumns = this.version.getDataRegionSizeColumns();
        symbolSizeRows /= dataRegionSizeRows;
        symbolSizeColumns /= dataRegionSizeColumns;
        BitMatrix bitMatrix2 = new BitMatrix(symbolSizeColumns * dataRegionSizeColumns, symbolSizeRows * dataRegionSizeRows);
        for (int i = 0; i < symbolSizeRows; i++) {
            BitMatrix bitMatrix3;
            int i2 = i * dataRegionSizeRows;
            for (int i3 = 0; i3 < symbolSizeColumns; i3++) {
                int i4 = i3 * dataRegionSizeColumns;
                for (int i5 = 0; i5 < dataRegionSizeRows; i5++) {
                    int i6 = (((dataRegionSizeRows + 2) * i) + 1) + i5;
                    int i7 = i2 + i5;
                    for (int i8 = 0; i8 < dataRegionSizeColumns; i8++) {
                        if (bitMatrix.get((((dataRegionSizeColumns + 2) * i3) + 1) + i8, i6)) {
                            bitMatrix2.set(i4 + i8, i7);
                        }
                    }
                    bitMatrix3 = bitMatrix;
                }
                bitMatrix3 = bitMatrix;
            }
            bitMatrix3 = bitMatrix;
        }
        return bitMatrix2;
    }

    /* Access modifiers changed, original: 0000 */
    public Version getVersion() {
        return this.version;
    }

    /* Access modifiers changed, original: 0000 */
    public byte[] readCodewords() throws FormatException {
        byte[] bArr = new byte[this.version.getTotalCodewords()];
        int height = this.mappingBitMatrix.getHeight();
        int width = this.mappingBitMatrix.getWidth();
        int i = 0;
        int i2 = i;
        int i3 = i2;
        int i4 = i3;
        int i5 = i4;
        int i6 = i5;
        int i7 = 4;
        while (true) {
            if (i7 == height && i == 0 && i2 == 0) {
                i2 = i3 + 1;
                bArr[i3] = (byte) readCorner1(height, width);
                i7 -= 2;
                i += 2;
                i3 = i2;
                i2 = 1;
            } else {
                int i8 = height - 2;
                if (i7 == i8 && i == 0 && (width & 3) != 0 && i4 == 0) {
                    i4 = i3 + 1;
                    bArr[i3] = (byte) readCorner2(height, width);
                    i7 -= 2;
                    i += 2;
                    i3 = i4;
                    i4 = 1;
                } else if (i7 == height + 4 && i == 2 && (width & 7) == 0 && i5 == 0) {
                    i5 = i3 + 1;
                    bArr[i3] = (byte) readCorner3(height, width);
                    i7 -= 2;
                    i += 2;
                    i3 = i5;
                    i5 = 1;
                } else if (i7 == i8 && i == 0 && (width & 7) == 4 && i6 == 0) {
                    i6 = i3 + 1;
                    bArr[i3] = (byte) readCorner4(height, width);
                    i7 -= 2;
                    i += 2;
                    i3 = i6;
                    i6 = 1;
                } else {
                    int i9;
                    do {
                        if (i7 < height && i >= 0 && !this.readMappingMatrix.get(i, i7)) {
                            i9 = i3 + 1;
                            bArr[i3] = (byte) readUtah(i7, i, height, width);
                            i3 = i9;
                        }
                        i7 -= 2;
                        i += 2;
                        if (i7 < 0) {
                            break;
                        }
                    } while (i < width);
                    i7++;
                    i += 3;
                    do {
                        if (i7 >= 0 && i < width && !this.readMappingMatrix.get(i, i7)) {
                            i9 = i3 + 1;
                            bArr[i3] = (byte) readUtah(i7, i, height, width);
                            i3 = i9;
                        }
                        i7 += 2;
                        i -= 2;
                        if (i7 >= height) {
                            break;
                        }
                    } while (i >= 0);
                    i7 += 3;
                    i++;
                }
            }
            if (i7 >= height && i >= width) {
                break;
            }
        }
        if (i3 == this.version.getTotalCodewords()) {
            return bArr;
        }
        throw FormatException.getFormatInstance();
    }

    /* Access modifiers changed, original: 0000 */
    public int readCorner1(int i, int i2) {
        int i3 = i - 1;
        int i4 = (readModule(i3, 0, i, i2) ? 1 : 0) << 1;
        if (readModule(i3, 1, i, i2)) {
            i4 |= 1;
        }
        i4 <<= 1;
        if (readModule(i3, 2, i, i2)) {
            i4 |= 1;
        }
        i3 = i4 << 1;
        if (readModule(0, i2 - 2, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        i4 = i2 - 1;
        if (readModule(0, i4, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(1, i4, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(2, i4, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        return readModule(3, i4, i, i2) ? i3 | 1 : i3;
    }

    /* Access modifiers changed, original: 0000 */
    public int readCorner2(int i, int i2) {
        int i3 = (readModule(i + -3, 0, i, i2) ? 1 : 0) << 1;
        if (readModule(i - 2, 0, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(i - 1, 0, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(0, i2 - 4, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(0, i2 - 3, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(0, i2 - 2, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        int i4 = i2 - 1;
        if (readModule(0, i4, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        return readModule(1, i4, i, i2) ? i3 | 1 : i3;
    }

    /* Access modifiers changed, original: 0000 */
    public int readCorner3(int i, int i2) {
        int i3 = i - 1;
        int i4 = (readModule(i3, 0, i, i2) ? 1 : 0) << 1;
        int i5 = i2 - 1;
        if (readModule(i3, i5, i, i2)) {
            i4 |= 1;
        }
        i3 = i4 << 1;
        i4 = i2 - 3;
        if (readModule(0, i4, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        int i6 = i2 - 2;
        if (readModule(0, i6, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(0, i5, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(1, i4, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(1, i6, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        return readModule(1, i5, i, i2) ? i3 | 1 : i3;
    }

    /* Access modifiers changed, original: 0000 */
    public int readCorner4(int i, int i2) {
        int i3 = (readModule(i + -3, 0, i, i2) ? 1 : 0) << 1;
        if (readModule(i - 2, 0, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(i - 1, 0, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(0, i2 - 2, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        int i4 = i2 - 1;
        if (readModule(0, i4, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(1, i4, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(2, i4, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        return readModule(3, i4, i, i2) ? i3 | 1 : i3;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean readModule(int i, int i2, int i3, int i4) {
        if (i < 0) {
            i += i3;
            i2 += 4 - ((i3 + 4) & 7);
        }
        if (i2 < 0) {
            i2 += i4;
            i += 4 - ((i4 + 4) & 7);
        }
        this.readMappingMatrix.set(i2, i);
        return this.mappingBitMatrix.get(i2, i);
    }

    /* Access modifiers changed, original: 0000 */
    public int readUtah(int i, int i2, int i3, int i4) {
        int i5 = i - 2;
        int i6 = i2 - 2;
        int i7 = (readModule(i5, i6, i3, i4) ? 1 : 0) << 1;
        int i8 = i2 - 1;
        if (readModule(i5, i8, i3, i4)) {
            i7 |= 1;
        }
        i5 = i7 << 1;
        i7 = i - 1;
        if (readModule(i7, i6, i3, i4)) {
            i5 |= 1;
        }
        i5 <<= 1;
        if (readModule(i7, i8, i3, i4)) {
            i5 |= 1;
        }
        i5 <<= 1;
        if (readModule(i7, i2, i3, i4)) {
            i5 |= 1;
        }
        i5 <<= 1;
        if (readModule(i, i6, i3, i4)) {
            i5 |= 1;
        }
        i5 <<= 1;
        if (readModule(i, i8, i3, i4)) {
            i5 |= 1;
        }
        i5 <<= 1;
        return readModule(i, i2, i3, i4) ? i5 | 1 : i5;
    }
}
