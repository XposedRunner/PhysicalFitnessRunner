package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;

final class AI013103decoder extends AI013x0xDecoder {
    AI013103decoder(BitArray bitArray) {
        super(bitArray);
    }

    /* Access modifiers changed, original: protected */
    public void addWeightCode(StringBuilder stringBuilder, int i) {
        stringBuilder.append("(3103)");
    }

    /* Access modifiers changed, original: protected */
    public int checkWeight(int i) {
        return i;
    }
}
