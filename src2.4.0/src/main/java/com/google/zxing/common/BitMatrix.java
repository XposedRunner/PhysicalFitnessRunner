package com.google.zxing.common;

import java.util.Arrays;

public final class BitMatrix implements Cloneable {
    private final int[] bits;
    private final int height;
    private final int rowSize;
    private final int width;

    public BitMatrix(int i) {
        this(i, i);
    }

    public BitMatrix(int i, int i2) {
        if (i < 1 || i2 < 1) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.width = i;
        this.height = i2;
        this.rowSize = (i + 31) / 32;
        this.bits = new int[(this.rowSize * i2)];
    }

    private BitMatrix(int i, int i2, int i3, int[] iArr) {
        this.width = i;
        this.height = i2;
        this.rowSize = i3;
        this.bits = iArr;
    }

    public static BitMatrix parse(String str, String str2, String str3) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        boolean[] zArr = new boolean[str.length()];
        int i = 0;
        int i2 = -1;
        int i3 = 0;
        int i4 = i3;
        int i5 = i4;
        int i6 = i5;
        while (i3 < str.length()) {
            if (str.charAt(i3) == 10 || str.charAt(i3) == 13) {
                if (i4 > i5) {
                    if (i2 == -1) {
                        i2 = i4 - i5;
                    } else if (i4 - i5 != i2) {
                        throw new IllegalArgumentException("row lengths do not match");
                    }
                    i6++;
                    i5 = i4;
                }
                i3++;
            } else if (str.substring(i3, str2.length() + i3).equals(str2)) {
                i3 += str2.length();
                zArr[i4] = true;
                i4++;
            } else if (str.substring(i3, str3.length() + i3).equals(str3)) {
                i3 += str3.length();
                zArr[i4] = false;
                i4++;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("illegal character encountered: ");
                stringBuilder.append(str.substring(i3));
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        if (i4 > i5) {
            if (i2 == -1) {
                i2 = i4 - i5;
            } else if (i4 - i5 != i2) {
                throw new IllegalArgumentException("row lengths do not match");
            }
            i6++;
        }
        BitMatrix bitMatrix = new BitMatrix(i2, i6);
        while (i < i4) {
            if (zArr[i]) {
                bitMatrix.set(i % i2, i / i2);
            }
            i++;
        }
        return bitMatrix;
    }

    public void clear() {
        int length = this.bits.length;
        for (int i = 0; i < length; i++) {
            this.bits[i] = 0;
        }
    }

    public BitMatrix clone() {
        return new BitMatrix(this.width, this.height, this.rowSize, (int[]) this.bits.clone());
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof BitMatrix)) {
            return false;
        }
        BitMatrix bitMatrix = (BitMatrix) obj;
        if (this.width == bitMatrix.width && this.height == bitMatrix.height && this.rowSize == bitMatrix.rowSize && Arrays.equals(this.bits, bitMatrix.bits)) {
            z = true;
        }
        return z;
    }

    public void flip(int i, int i2) {
        i2 = (i2 * this.rowSize) + (i / 32);
        int[] iArr = this.bits;
        iArr[i2] = (1 << (i & 31)) ^ iArr[i2];
    }

    public boolean get(int i, int i2) {
        return ((this.bits[(i2 * this.rowSize) + (i / 32)] >>> (i & 31)) & 1) != 0;
    }

    public int[] getBottomRightOnBit() {
        int length = this.bits.length - 1;
        while (length >= 0 && this.bits[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i;
        int i2 = length / this.rowSize;
        int i3 = (length % this.rowSize) * 32;
        for (i = 31; (this.bits[length] >>> i) == 0; i--) {
        }
        return new int[]{i3 + i, i2};
    }

    public int[] getEnclosingRectangle() {
        int i = this.width;
        int i2 = -1;
        int i3 = this.height;
        int i4 = -1;
        int i5 = i;
        i = 0;
        while (i < this.height) {
            int i6 = i4;
            i4 = i2;
            i2 = i5;
            for (i5 = 0; i5 < this.rowSize; i5++) {
                int i7 = this.bits[(this.rowSize * i) + i5];
                if (i7 != 0) {
                    if (i < i3) {
                        i3 = i;
                    }
                    if (i > i6) {
                        i6 = i;
                    }
                    int i8 = i5 * 32;
                    int i9 = 31;
                    if (i8 < i2) {
                        int i10 = 0;
                        while ((i7 << (31 - i10)) == 0) {
                            i10++;
                        }
                        i10 += i8;
                        if (i10 < i2) {
                            i2 = i10;
                        }
                    }
                    if (i8 + 31 > i4) {
                        while ((i7 >>> i9) == 0) {
                            i9--;
                        }
                        i7 = i8 + i9;
                        if (i7 > i4) {
                            i4 = i7;
                        }
                    }
                }
            }
            i++;
            i5 = i2;
            i2 = i4;
            i4 = i6;
        }
        i4 -= i3;
        if (i2 - i5 < 0 || i4 < 0) {
            return null;
        }
        return new int[]{i5, i3, i2, i4};
    }

    public int getHeight() {
        return this.height;
    }

    public BitArray getRow(int i, BitArray bitArray) {
        if (bitArray == null || bitArray.getSize() < this.width) {
            bitArray = new BitArray(this.width);
        } else {
            bitArray.clear();
        }
        i *= this.rowSize;
        for (int i2 = 0; i2 < this.rowSize; i2++) {
            bitArray.setBulk(i2 * 32, this.bits[i + i2]);
        }
        return bitArray;
    }

    public int getRowSize() {
        return this.rowSize;
    }

    public int[] getTopLeftOnBit() {
        int i = 0;
        while (i < this.bits.length && this.bits[i] == 0) {
            i++;
        }
        if (i == this.bits.length) {
            return null;
        }
        int i2;
        int i3 = i / this.rowSize;
        int i4 = (i % this.rowSize) * 32;
        for (i2 = 0; (this.bits[i] << (31 - i2)) == 0; i2++) {
        }
        return new int[]{i4 + i2, i3};
    }

    public int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (31 * ((((((this.width * 31) + this.width) * 31) + this.height) * 31) + this.rowSize)) + Arrays.hashCode(this.bits);
    }

    public void rotate180() {
        int width = getWidth();
        int height = getHeight();
        BitArray bitArray = new BitArray(width);
        BitArray bitArray2 = new BitArray(width);
        for (width = 0; width < (height + 1) / 2; width++) {
            bitArray = getRow(width, bitArray);
            int i = (height - 1) - width;
            bitArray2 = getRow(i, bitArray2);
            bitArray.reverse();
            bitArray2.reverse();
            setRow(width, bitArray2);
            setRow(i, bitArray);
        }
    }

    public void set(int i, int i2) {
        i2 = (i2 * this.rowSize) + (i / 32);
        int[] iArr = this.bits;
        iArr[i2] = (1 << (i & 31)) | iArr[i2];
    }

    public void setRegion(int i, int i2, int i3, int i4) {
        if (i2 < 0 || i < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        } else if (i4 < 1 || i3 < 1) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        } else {
            i3 += i;
            i4 += i2;
            if (i4 > this.height || i3 > this.width) {
                throw new IllegalArgumentException("The region must fit inside the matrix");
            }
            while (i2 < i4) {
                int i5 = this.rowSize * i2;
                for (int i6 = i; i6 < i3; i6++) {
                    int[] iArr = this.bits;
                    int i7 = (i6 / 32) + i5;
                    iArr[i7] = iArr[i7] | (1 << (i6 & 31));
                }
                i2++;
            }
        }
    }

    public void setRow(int i, BitArray bitArray) {
        System.arraycopy(bitArray.getBitArray(), 0, this.bits, i * this.rowSize, this.rowSize);
    }

    public String toString() {
        return toString("X ", "  ");
    }

    public String toString(String str, String str2) {
        return toString(str, str2, "\n");
    }

    @Deprecated
    public String toString(String str, String str2, String str3) {
        StringBuilder stringBuilder = new StringBuilder(this.height * (this.width + 1));
        for (int i = 0; i < this.height; i++) {
            for (int i2 = 0; i2 < this.width; i2++) {
                stringBuilder.append(get(i2, i) ? str : str2);
            }
            stringBuilder.append(str3);
        }
        return stringBuilder.toString();
    }

    public void unset(int i, int i2) {
        i2 = (i2 * this.rowSize) + (i / 32);
        int[] iArr = this.bits;
        iArr[i2] = ((1 << (i & 31)) ^ -1) & iArr[i2];
    }

    public void xor(BitMatrix bitMatrix) {
        if (this.width == bitMatrix.getWidth() && this.height == bitMatrix.getHeight() && this.rowSize == bitMatrix.getRowSize()) {
            BitArray bitArray = new BitArray((this.width / 32) + 1);
            for (int i = 0; i < this.height; i++) {
                int i2 = this.rowSize * i;
                int[] bitArray2 = bitMatrix.getRow(i, bitArray).getBitArray();
                for (int i3 = 0; i3 < this.rowSize; i3++) {
                    int[] iArr = this.bits;
                    int i4 = i2 + i3;
                    iArr[i4] = iArr[i4] ^ bitArray2[i3];
                }
            }
            return;
        }
        throw new IllegalArgumentException("input matrix dimensions do not match");
    }
}
