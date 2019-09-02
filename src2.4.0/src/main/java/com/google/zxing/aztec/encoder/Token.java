package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;

abstract class Token {
    static final Token EMPTY = new SimpleToken(null, 0, 0);
    private final Token previous;

    Token(Token token) {
        this.previous = token;
    }

    /* Access modifiers changed, original: final */
    public final Token add(int i, int i2) {
        return new SimpleToken(this, i, i2);
    }

    /* Access modifiers changed, original: final */
    public final Token addBinaryShift(int i, int i2) {
        return new BinaryShiftToken(this, i, i2);
    }

    public abstract void appendTo(BitArray bitArray, byte[] bArr);

    /* Access modifiers changed, original: final */
    public final Token getPrevious() {
        return this.previous;
    }
}
