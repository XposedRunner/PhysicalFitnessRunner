package com.google.zxing.oned.rss.expanded;

import com.google.zxing.common.BitArray;
import java.util.List;

final class BitArrayBuilder {
    private BitArrayBuilder() {
    }

    static BitArray buildBitArray(List<ExpandedPair> list) {
        int i;
        int size = (list.size() * 2) - 1;
        if (((ExpandedPair) list.get(list.size() - 1)).getRightChar() == null) {
            size--;
        }
        BitArray bitArray = new BitArray(12 * size);
        int value = ((ExpandedPair) list.get(0)).getRightChar().getValue();
        int i2 = 0;
        for (i = 11; i >= 0; i--) {
            if (((1 << i) & value) != 0) {
                bitArray.set(i2);
            }
            i2++;
        }
        for (i = 1; i < list.size(); i++) {
            ExpandedPair expandedPair = (ExpandedPair) list.get(i);
            int value2 = expandedPair.getLeftChar().getValue();
            int i3 = i2;
            for (i2 = 11; i2 >= 0; i2--) {
                if (((1 << i2) & value2) != 0) {
                    bitArray.set(i3);
                }
                i3++;
            }
            if (expandedPair.getRightChar() != null) {
                value = expandedPair.getRightChar().getValue();
                for (i2 = 11; i2 >= 0; i2--) {
                    if (((1 << i2) & value) != 0) {
                        bitArray.set(i3);
                    }
                    i3++;
                }
            }
            i2 = i3;
        }
        return bitArray;
    }
}
