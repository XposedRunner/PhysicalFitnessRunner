package com.google.zxing.aztec.encoder;

import android.support.v4.internal.view.SupportMenu;
import com.google.zxing.common.BitArray;
import java.util.LinkedList;

final class State {
    static final State INITIAL_STATE = new State(Token.EMPTY, 0, 0, 0);
    private final int binaryShiftByteCount;
    private final int bitCount;
    private final int mode;
    private final Token token;

    private State(Token token, int i, int i2, int i3) {
        this.token = token;
        this.mode = i;
        this.binaryShiftByteCount = i2;
        this.bitCount = i3;
    }

    /* Access modifiers changed, original: 0000 */
    public State addBinaryShiftChar(int i) {
        int i2;
        Token token = this.token;
        int i3 = this.mode;
        int i4 = this.bitCount;
        if (this.mode == 4 || this.mode == 2) {
            i3 = HighLevelEncoder.LATCH_TABLE[i3][0];
            i2 = SupportMenu.USER_MASK & i3;
            i3 >>= 16;
            token = token.add(i2, i3);
            i4 += i3;
            i3 = 0;
        }
        i2 = (this.binaryShiftByteCount == 0 || this.binaryShiftByteCount == 31) ? 18 : this.binaryShiftByteCount == 62 ? 9 : 8;
        State state = new State(token, i3, this.binaryShiftByteCount + 1, i4 + i2);
        return state.binaryShiftByteCount == 2078 ? state.endBinaryShift(i + 1) : state;
    }

    /* Access modifiers changed, original: 0000 */
    public State endBinaryShift(int i) {
        return this.binaryShiftByteCount == 0 ? this : new State(this.token.addBinaryShift(i - this.binaryShiftByteCount, this.binaryShiftByteCount), this.mode, 0, this.bitCount);
    }

    /* Access modifiers changed, original: 0000 */
    public int getBinaryShiftByteCount() {
        return this.binaryShiftByteCount;
    }

    /* Access modifiers changed, original: 0000 */
    public int getBitCount() {
        return this.bitCount;
    }

    /* Access modifiers changed, original: 0000 */
    public int getMode() {
        return this.mode;
    }

    /* Access modifiers changed, original: 0000 */
    public Token getToken() {
        return this.token;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean isBetterThanOrEqualTo(State state) {
        int i = this.bitCount + (HighLevelEncoder.LATCH_TABLE[this.mode][state.mode] >> 16);
        if (state.binaryShiftByteCount > 0 && (this.binaryShiftByteCount == 0 || this.binaryShiftByteCount > state.binaryShiftByteCount)) {
            i += 10;
        }
        return i <= state.bitCount;
    }

    /* Access modifiers changed, original: 0000 */
    public State latchAndAppend(int i, int i2) {
        int i3;
        int i4 = this.bitCount;
        Token token = this.token;
        if (i != this.mode) {
            i3 = HighLevelEncoder.LATCH_TABLE[this.mode][i];
            int i5 = SupportMenu.USER_MASK & i3;
            i3 >>= 16;
            token = token.add(i5, i3);
            i4 += i3;
        }
        i3 = i == 2 ? 4 : 5;
        return new State(token.add(i2, i3), i, 0, i4 + i3);
    }

    /* Access modifiers changed, original: 0000 */
    public State shiftAndAppend(int i, int i2) {
        Token token = this.token;
        int i3 = this.mode == 2 ? 4 : 5;
        return new State(token.add(HighLevelEncoder.SHIFT_TABLE[this.mode][i], i3).add(i2, 5), this.mode, 0, (this.bitCount + i3) + 5);
    }

    /* Access modifiers changed, original: 0000 */
    public BitArray toBitArray(byte[] bArr) {
        LinkedList<Token> linkedList = new LinkedList();
        for (Object obj = endBinaryShift(bArr.length).token; obj != null; obj = obj.getPrevious()) {
            linkedList.addFirst(obj);
        }
        BitArray bitArray = new BitArray();
        for (Token appendTo : linkedList) {
            appendTo.appendTo(bitArray, bArr);
        }
        return bitArray;
    }

    public String toString() {
        return String.format("%s bits=%d bytes=%d", new Object[]{HighLevelEncoder.MODE_NAMES[this.mode], Integer.valueOf(this.bitCount), Integer.valueOf(this.binaryShiftByteCount)});
    }
}
