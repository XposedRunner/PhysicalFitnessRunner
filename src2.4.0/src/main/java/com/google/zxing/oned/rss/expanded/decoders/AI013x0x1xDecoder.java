package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

final class AI013x0x1xDecoder extends AI01weightDecoder {
    private static final int DATE_SIZE = 16;
    private static final int HEADER_SIZE = 8;
    private static final int WEIGHT_SIZE = 20;
    private final String dateCode;
    private final String firstAIdigits;

    AI013x0x1xDecoder(BitArray bitArray, String str, String str2) {
        super(bitArray);
        this.dateCode = str2;
        this.firstAIdigits = str;
    }

    private void encodeCompressedDate(StringBuilder stringBuilder, int i) {
        i = getGeneralDecoder().extractNumericValueFromBitArray(i, 16);
        if (i != 38400) {
            stringBuilder.append('(');
            stringBuilder.append(this.dateCode);
            stringBuilder.append(')');
            int i2 = i % 32;
            i /= 32;
            int i3 = (i % 12) + 1;
            i /= 12;
            if (i / 10 == 0) {
                stringBuilder.append('0');
            }
            stringBuilder.append(i);
            if (i3 / 10 == 0) {
                stringBuilder.append('0');
            }
            stringBuilder.append(i3);
            if (i2 / 10 == 0) {
                stringBuilder.append('0');
            }
            stringBuilder.append(i2);
        }
    }

    /* Access modifiers changed, original: protected */
    public void addWeightCode(StringBuilder stringBuilder, int i) {
        i /= 100000;
        stringBuilder.append('(');
        stringBuilder.append(this.firstAIdigits);
        stringBuilder.append(i);
        stringBuilder.append(')');
    }

    /* Access modifiers changed, original: protected */
    public int checkWeight(int i) {
        return i % 100000;
    }

    public String parseInformation() throws NotFoundException {
        if (getInformation().getSize() != 84) {
            throw NotFoundException.getNotFoundInstance();
        }
        StringBuilder stringBuilder = new StringBuilder();
        encodeCompressedGtin(stringBuilder, 8);
        encodeCompressedWeight(stringBuilder, 48, 20);
        encodeCompressedDate(stringBuilder, 68);
        return stringBuilder.toString();
    }
}
