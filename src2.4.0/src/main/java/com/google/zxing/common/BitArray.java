package com.google.zxing.common;

import java.util.Arrays;

public final class BitArray implements Cloneable {
    private int[] bits;
    private int size;

    public BitArray() {
        this.size = 0;
        this.bits = new int[1];
    }

    public BitArray(int i) {
        this.size = i;
        this.bits = makeArray(i);
    }

    BitArray(int[] iArr, int i) {
        this.bits = iArr;
        this.size = i;
    }

    private void ensureCapacity(int i) {
        if (i > this.bits.length * 32) {
            int[] makeArray = makeArray(i);
            System.arraycopy(this.bits, 0, makeArray, 0, this.bits.length);
            this.bits = makeArray;
        }
    }

    private static int[] makeArray(int i) {
        return new int[((i + 31) / 32)];
    }

    public void appendBit(boolean z) {
        ensureCapacity(this.size + 1);
        if (z) {
            int[] iArr = this.bits;
            int i = this.size / 32;
            iArr[i] = iArr[i] | (1 << (this.size & 31));
        }
        this.size++;
    }

    public void appendBitArray(BitArray bitArray) {
        int i = bitArray.size;
        ensureCapacity(this.size + i);
        for (int i2 = 0; i2 < i; i2++) {
            appendBit(bitArray.get(i2));
        }
    }

    public void appendBits(int i, int i2) {
        if (i2 < 0 || i2 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        ensureCapacity(this.size + i2);
        while (i2 > 0) {
            boolean z = true;
            if (((i >> (i2 - 1)) & 1) != 1) {
                z = false;
            }
            appendBit(z);
            i2--;
        }
    }

    public void clear() {
        int length = this.bits.length;
        for (int i = 0; i < length; i++) {
            this.bits[i] = 0;
        }
    }

    public BitArray clone() {
        return new BitArray((int[]) this.bits.clone(), this.size);
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof BitArray)) {
            return false;
        }
        BitArray bitArray = (BitArray) obj;
        if (this.size == bitArray.size && Arrays.equals(this.bits, bitArray.bits)) {
            z = true;
        }
        return z;
    }

    public void flip(int i) {
        int[] iArr = this.bits;
        int i2 = i / 32;
        iArr[i2] = (1 << (i & 31)) ^ iArr[i2];
    }

    public boolean get(int i) {
        return ((1 << (i & 31)) & this.bits[i / 32]) != 0;
    }

    public int[] getBitArray() {
        return this.bits;
    }

    public int getNextSet(int i) {
        if (i >= this.size) {
            return this.size;
        }
        int i2 = i / 32;
        i = (((1 << (i & 31)) - 1) ^ -1) & this.bits[i2];
        while (i == 0) {
            i2++;
            if (i2 == this.bits.length) {
                return this.size;
            }
            i = this.bits[i2];
        }
        i2 = (i2 * 32) + Integer.numberOfTrailingZeros(i);
        if (i2 > this.size) {
            i2 = this.size;
        }
        return i2;
    }

    public int getNextUnset(int i) {
        if (i >= this.size) {
            return this.size;
        }
        int i2 = i / 32;
        i = (((1 << (i & 31)) - 1) ^ -1) & (this.bits[i2] ^ -1);
        while (i == 0) {
            i2++;
            if (i2 == this.bits.length) {
                return this.size;
            }
            i = this.bits[i2] ^ -1;
        }
        i2 = (i2 * 32) + Integer.numberOfTrailingZeros(i);
        if (i2 > this.size) {
            i2 = this.size;
        }
        return i2;
    }

    public int getSize() {
        return this.size;
    }

    public int getSizeInBytes() {
        return (this.size + 7) / 8;
    }

    public int hashCode() {
        return (31 * this.size) + Arrays.hashCode(this.bits);
    }

    public boolean isRange(int i, int i2, boolean z) {
        if (i2 < i) {
            throw new IllegalArgumentException();
        } else if (i2 == i) {
            return true;
        } else {
            i2--;
            int i3 = i / 32;
            int i4 = i2 / 32;
            int i5 = i3;
            while (i5 <= i4) {
                int i6;
                int i7 = i5 > i3 ? 0 : i & 31;
                int i8 = i5 < i4 ? 31 : i2 & 31;
                if (i7 == 0 && i8 == 31) {
                    i6 = -1;
                } else {
                    i6 = 0;
                    while (i7 <= i8) {
                        i6 |= 1 << i7;
                        i7++;
                    }
                }
                i7 = this.bits[i5] & i6;
                if (!z) {
                    i6 = 0;
                }
                if (i7 != i6) {
                    return false;
                }
                i5++;
            }
            return true;
        }
    }

    public void reverse() {
        int i;
        int[] iArr = new int[this.bits.length];
        int i2 = (this.size - 1) / 32;
        int i3 = i2 + 1;
        for (i = 0; i < i3; i++) {
            long j = (long) this.bits[i];
            long j2 = ((j >> 1) & 1431655765) | ((j & 1431655765) << 1);
            j2 = ((j2 >> 2) & 858993459) | ((j2 & 858993459) << 2);
            j2 = ((j2 >> 4) & 252645135) | ((j2 & 252645135) << 4);
            j2 = ((j2 >> 8) & 16711935) | ((j2 & 16711935) << 8);
            iArr[i2 - i] = (int) (((j2 >> 16) & 65535) | ((j2 & 65535) << 16));
        }
        i = i3 * 32;
        if (this.size != i) {
            i -= this.size;
            int i4 = 1;
            for (i2 = 0; i2 < 31 - i; i2++) {
                i4 = (i4 << 1) | 1;
            }
            i2 = (iArr[0] >> i) & i4;
            for (int i5 = 1; i5 < i3; i5++) {
                int i6 = iArr[i5];
                iArr[i5 - 1] = i2 | (i6 << (32 - i));
                i2 = (i6 >> i) & i4;
            }
            iArr[i3 - 1] = i2;
        }
        this.bits = iArr;
    }

    public void set(int i) {
        int[] iArr = this.bits;
        int i2 = i / 32;
        iArr[i2] = (1 << (i & 31)) | iArr[i2];
    }

    public void setBulk(int i, int i2) {
        this.bits[i / 32] = i2;
    }

    public void setRange(int i, int i2) {
        if (i2 < i) {
            throw new IllegalArgumentException();
        } else if (i2 != i) {
            i2--;
            int i3 = i / 32;
            int i4 = i2 / 32;
            int i5 = i3;
            while (i5 <= i4) {
                int i6 = 0;
                int i7 = i5 > i3 ? 0 : i & 31;
                int i8 = i5 < i4 ? 31 : i2 & 31;
                if (i7 == 0 && i8 == 31) {
                    i6 = -1;
                } else {
                    while (i7 <= i8) {
                        i6 |= 1 << i7;
                        i7++;
                    }
                }
                int[] iArr = this.bits;
                iArr[i5] = i6 | iArr[i5];
                i5++;
            }
        }
    }

    public void toBytes(int i, byte[] bArr, int i2, int i3) {
        int i4 = i;
        i = 0;
        while (i < i3) {
            int i5 = 0;
            int i6 = i4;
            for (i4 = i5; i4 < 8; i4++) {
                if (get(i6)) {
                    i5 |= 1 << (7 - i4);
                }
                i6++;
            }
            bArr[i2 + i] = (byte) i5;
            i++;
            i4 = i6;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(this.size);
        for (int i = 0; i < this.size; i++) {
            if ((i & 7) == 0) {
                stringBuilder.append(' ');
            }
            stringBuilder.append(get(i) ? 'X' : '.');
        }
        return stringBuilder.toString();
    }

    public void xor(BitArray bitArray) {
        if (this.bits.length != bitArray.bits.length) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        for (int i = 0; i < this.bits.length; i++) {
            int[] iArr = this.bits;
            iArr[i] = iArr[i] ^ bitArray.bits[i];
        }
    }
}
