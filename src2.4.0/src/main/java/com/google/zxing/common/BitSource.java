package com.google.zxing.common;

public final class BitSource {
    private int bitOffset;
    private int byteOffset;
    private final byte[] bytes;

    public BitSource(byte[] bArr) {
        this.bytes = bArr;
    }

    public int available() {
        return (8 * (this.bytes.length - this.byteOffset)) - this.bitOffset;
    }

    public int getBitOffset() {
        return this.bitOffset;
    }

    public int getByteOffset() {
        return this.byteOffset;
    }

    public int readBits(int i) {
        if (i < 1 || i > 32 || i > available()) {
            throw new IllegalArgumentException(String.valueOf(i));
        }
        int i2;
        if (this.bitOffset > 0) {
            i2 = 8 - this.bitOffset;
            int i3 = i < i2 ? i : i2;
            i2 -= i3;
            i2 = (((255 >> (8 - i3)) << i2) & this.bytes[this.byteOffset]) >> i2;
            i -= i3;
            this.bitOffset += i3;
            if (this.bitOffset == 8) {
                this.bitOffset = 0;
                this.byteOffset++;
            }
        } else {
            i2 = 0;
        }
        if (i <= 0) {
            return i2;
        }
        while (i >= 8) {
            i2 = (i2 << 8) | (this.bytes[this.byteOffset] & 255);
            this.byteOffset++;
            i -= 8;
        }
        if (i <= 0) {
            return i2;
        }
        int i4 = 8 - i;
        i2 = (i2 << i) | ((((255 >> i4) << i4) & this.bytes[this.byteOffset]) >> i4);
        this.bitOffset += i;
        return i2;
    }
}
