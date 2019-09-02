package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;

abstract class AI01weightDecoder extends AI01decoder {
    AI01weightDecoder(BitArray bitArray) {
        super(bitArray);
    }

    public abstract void addWeightCode(StringBuilder stringBuilder, int i);

    public abstract int checkWeight(int i);

    /* Access modifiers changed, original: protected|final */
    public final void encodeCompressedWeight(StringBuilder stringBuilder, int i, int i2) {
        i = getGeneralDecoder().extractNumericValueFromBitArray(i, i2);
        addWeightCode(stringBuilder, i);
        i = checkWeight(i);
        i2 = 100000;
        for (int i3 = 0; i3 < 5; i3++) {
            if (i / i2 == 0) {
                stringBuilder.append('0');
            }
            i2 /= 10;
        }
        stringBuilder.append(i);
    }
}
