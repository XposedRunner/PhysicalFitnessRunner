package com.google.zxing.aztec.encoder;

import android.support.v4.media.TransportMediator;
import com.alibaba.wireless.security.SecExceptionCode;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public final class HighLevelEncoder {
    private static final int[][] CHAR_MAP = ((int[][]) Array.newInstance(int.class, new int[]{5, 256}));
    static final int[][] LATCH_TABLE = new int[][]{new int[]{0, 327708, 327710, 327709, 656318}, new int[]{590318, 0, 327710, 327709, 656318}, new int[]{262158, 590300, 0, 590301, 932798}, new int[]{327709, 327708, 656318, 0, 327710}, new int[]{327711, 656380, 656382, 656381, 0}};
    static final int MODE_DIGIT = 2;
    static final int MODE_LOWER = 1;
    static final int MODE_MIXED = 3;
    static final String[] MODE_NAMES = new String[]{"UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT"};
    static final int MODE_PUNCT = 4;
    static final int MODE_UPPER = 0;
    static final int[][] SHIFT_TABLE = ((int[][]) Array.newInstance(int.class, new int[]{6, 6}));
    private final byte[] text;

    static {
        int i;
        int i2;
        CHAR_MAP[0][32] = 1;
        for (i = 65; i <= 90; i++) {
            CHAR_MAP[0][i] = (i - 65) + 2;
        }
        CHAR_MAP[1][32] = 1;
        for (i = 97; i <= SecExceptionCode.SEC_ERROR_INIT_NO_DATA_FILE; i++) {
            CHAR_MAP[1][i] = (i - 97) + 2;
        }
        CHAR_MAP[2][32] = 1;
        for (i = 48; i <= 57; i++) {
            CHAR_MAP[2][i] = (i - 48) + 2;
        }
        CHAR_MAP[2][44] = 12;
        CHAR_MAP[2][46] = 13;
        int[] iArr = new int[]{0, 32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, SecExceptionCode.SEC_ERROR_INIT_LOW_VERSION_DATA, TransportMediator.KEYCODE_MEDIA_PLAY, TransportMediator.KEYCODE_MEDIA_PAUSE};
        for (i2 = 0; i2 < iArr.length; i2++) {
            CHAR_MAP[3][iArr[i2]] = i2;
        }
        iArr = new int[]{0, 13, 0, 0, 0, 0, 33, 39, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 91, 93, SecExceptionCode.SEC_ERROR_INIT_INCORRECT_DATA_FILE, SecExceptionCode.SEC_ERROR_INIT_PARSE_USER_CONFIG_ERROR};
        for (i2 = 0; i2 < iArr.length; i2++) {
            if (iArr[i2] > 0) {
                CHAR_MAP[4][iArr[i2]] = i2;
            }
        }
        for (int[] fill : SHIFT_TABLE) {
            Arrays.fill(fill, -1);
        }
        SHIFT_TABLE[0][4] = 0;
        SHIFT_TABLE[1][4] = 0;
        SHIFT_TABLE[1][0] = 28;
        SHIFT_TABLE[3][4] = 0;
        SHIFT_TABLE[2][4] = 0;
        SHIFT_TABLE[2][0] = 15;
    }

    public HighLevelEncoder(byte[] bArr) {
        this.text = bArr;
    }

    private static Collection<State> simplifyStates(Iterable<State> iterable) {
        LinkedList linkedList = new LinkedList();
        for (State state : iterable) {
            Object obj = 1;
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                State state2 = (State) it.next();
                if (state2.isBetterThanOrEqualTo(state)) {
                    obj = null;
                    break;
                } else if (state.isBetterThanOrEqualTo(state2)) {
                    it.remove();
                }
            }
            if (obj != null) {
                linkedList.add(state);
            }
        }
        return linkedList;
    }

    private void updateStateForChar(State state, int i, Collection<State> collection) {
        char c = (char) (this.text[i] & 255);
        int i2 = 0;
        int i3 = CHAR_MAP[state.getMode()][c] > 0 ? 1 : 0;
        State state2 = null;
        while (i2 <= 4) {
            int i4 = CHAR_MAP[i2][c];
            if (i4 > 0) {
                if (state2 == null) {
                    state2 = state.endBinaryShift(i);
                }
                if (i3 == 0 || i2 == state.getMode() || i2 == 2) {
                    collection.add(state2.latchAndAppend(i2, i4));
                }
                if (i3 == 0 && SHIFT_TABLE[state.getMode()][i2] >= 0) {
                    collection.add(state2.shiftAndAppend(i2, i4));
                }
            }
            i2++;
        }
        if (state.getBinaryShiftByteCount() > 0 || CHAR_MAP[state.getMode()][c] == 0) {
            collection.add(state.addBinaryShiftChar(i));
        }
    }

    private static void updateStateForPair(State state, int i, int i2, Collection<State> collection) {
        State endBinaryShift = state.endBinaryShift(i);
        collection.add(endBinaryShift.latchAndAppend(4, i2));
        if (state.getMode() != 4) {
            collection.add(endBinaryShift.shiftAndAppend(4, i2));
        }
        if (i2 == 3 || i2 == 4) {
            collection.add(endBinaryShift.latchAndAppend(2, 16 - i2).latchAndAppend(2, 1));
        }
        if (state.getBinaryShiftByteCount() > 0) {
            collection.add(state.addBinaryShiftChar(i).addBinaryShiftChar(i + 1));
        }
    }

    private Collection<State> updateStateListForChar(Iterable<State> iterable, int i) {
        LinkedList linkedList = new LinkedList();
        for (State updateStateForChar : iterable) {
            updateStateForChar(updateStateForChar, i, linkedList);
        }
        return simplifyStates(linkedList);
    }

    private static Collection<State> updateStateListForPair(Iterable<State> iterable, int i, int i2) {
        LinkedList linkedList = new LinkedList();
        for (State updateStateForPair : iterable) {
            updateStateForPair(updateStateForPair, i, i2, linkedList);
        }
        return simplifyStates(linkedList);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004d  */
    public com.google.zxing.common.BitArray encode() {
        /*
        r8 = this;
        r0 = com.google.zxing.aztec.encoder.State.INITIAL_STATE;
        r0 = java.util.Collections.singletonList(r0);
        r1 = 0;
        r2 = r0;
        r0 = r1;
    L_0x0009:
        r3 = r8.text;
        r3 = r3.length;
        if (r0 >= r3) goto L_0x0054;
    L_0x000e:
        r3 = r0 + 1;
        r4 = r8.text;
        r4 = r4.length;
        if (r3 >= r4) goto L_0x001a;
    L_0x0015:
        r4 = r8.text;
        r4 = r4[r3];
        goto L_0x001b;
    L_0x001a:
        r4 = r1;
    L_0x001b:
        r5 = r8.text;
        r5 = r5[r0];
        r6 = 13;
        if (r5 == r6) goto L_0x003f;
    L_0x0023:
        r6 = 44;
        r7 = 32;
        if (r5 == r6) goto L_0x003b;
    L_0x0029:
        r6 = 46;
        if (r5 == r6) goto L_0x0037;
    L_0x002d:
        r6 = 58;
        if (r5 == r6) goto L_0x0033;
    L_0x0031:
        r4 = r1;
        goto L_0x0044;
    L_0x0033:
        if (r4 != r7) goto L_0x0031;
    L_0x0035:
        r4 = 5;
        goto L_0x0044;
    L_0x0037:
        if (r4 != r7) goto L_0x0031;
    L_0x0039:
        r4 = 3;
        goto L_0x0044;
    L_0x003b:
        if (r4 != r7) goto L_0x0031;
    L_0x003d:
        r4 = 4;
        goto L_0x0044;
    L_0x003f:
        r5 = 10;
        if (r4 != r5) goto L_0x0031;
    L_0x0043:
        r4 = 2;
    L_0x0044:
        if (r4 <= 0) goto L_0x004d;
    L_0x0046:
        r0 = updateStateListForPair(r2, r0, r4);
        r2 = r0;
        r0 = r3;
        goto L_0x0051;
    L_0x004d:
        r2 = r8.updateStateListForChar(r2, r0);
    L_0x0051:
        r0 = r0 + 1;
        goto L_0x0009;
    L_0x0054:
        r0 = new com.google.zxing.aztec.encoder.HighLevelEncoder$1;
        r0.<init>();
        r0 = java.util.Collections.min(r2, r0);
        r0 = (com.google.zxing.aztec.encoder.State) r0;
        r1 = r8.text;
        r0 = r0.toBitArray(r1);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.aztec.encoder.HighLevelEncoder.encode():com.google.zxing.common.BitArray");
    }
}
