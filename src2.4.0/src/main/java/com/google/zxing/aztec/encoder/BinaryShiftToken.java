package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;

final class BinaryShiftToken extends Token {
    private final short binaryShiftByteCount;
    private final short binaryShiftStart;

    BinaryShiftToken(Token token, int i, int i2) {
        super(token);
        this.binaryShiftStart = (short) i;
        this.binaryShiftByteCount = (short) i2;
    }

    public void appendTo(BitArray bitArray, byte[] bArr) {
        short s = (short) 0;
        while (s < this.binaryShiftByteCount) {
            if (s == (short) 0 || (s == (short) 31 && this.binaryShiftByteCount <= (short) 62)) {
                bitArray.appendBits(31, 5);
                if (this.binaryShiftByteCount > (short) 62) {
                    bitArray.appendBits(this.binaryShiftByteCount - 31, 16);
                } else if (s == (short) 0) {
                    bitArray.appendBits(Math.min(this.binaryShiftByteCount, 31), 5);
                } else {
                    bitArray.appendBits(this.binaryShiftByteCount - 31, 5);
                }
            }
            bitArray.appendBits(bArr[this.binaryShiftStart + s], 8);
            s++;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<");
        stringBuilder.append(this.binaryShiftStart);
        stringBuilder.append("::");
        stringBuilder.append((this.binaryShiftStart + this.binaryShiftByteCount) - 1);
        stringBuilder.append('>');
        return stringBuilder.toString();
    }
}
