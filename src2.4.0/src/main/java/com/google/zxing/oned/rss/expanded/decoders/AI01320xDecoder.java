package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;

final class AI01320xDecoder extends AI013x0xDecoder {
    AI01320xDecoder(BitArray bitArray) {
        super(bitArray);
    }

    /* Access modifiers changed, original: protected */
    public void addWeightCode(StringBuilder stringBuilder, int i) {
        if (i < 10000) {
            stringBuilder.append("(3202)");
        } else {
            stringBuilder.append("(3203)");
        }
    }

    /* Access modifiers changed, original: protected */
    public int checkWeight(int i) {
        return i < 10000 ? i : i - 10000;
    }
}
