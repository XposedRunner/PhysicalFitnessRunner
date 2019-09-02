package com.google.zxing.pdf417.decoder;

import java.util.Formatter;

class DetectionResultColumn {
    private static final int MAX_NEARBY_DISTANCE = 5;
    private final BoundingBox boundingBox;
    private final Codeword[] codewords;

    DetectionResultColumn(BoundingBox boundingBox) {
        this.boundingBox = new BoundingBox(boundingBox);
        this.codewords = new Codeword[((boundingBox.getMaxY() - boundingBox.getMinY()) + 1)];
    }

    /* Access modifiers changed, original: final */
    public final BoundingBox getBoundingBox() {
        return this.boundingBox;
    }

    /* Access modifiers changed, original: final */
    public final Codeword getCodeword(int i) {
        return this.codewords[imageRowToCodewordIndex(i)];
    }

    /* Access modifiers changed, original: final */
    public final Codeword getCodewordNearby(int i) {
        Codeword codeword = getCodeword(i);
        if (codeword != null) {
            return codeword;
        }
        for (int i2 = 1; i2 < 5; i2++) {
            Codeword codeword2;
            int imageRowToCodewordIndex = imageRowToCodewordIndex(i) - i2;
            if (imageRowToCodewordIndex >= 0) {
                codeword2 = this.codewords[imageRowToCodewordIndex];
                if (codeword2 != null) {
                    return codeword2;
                }
            }
            imageRowToCodewordIndex = imageRowToCodewordIndex(i) + i2;
            if (imageRowToCodewordIndex < this.codewords.length) {
                codeword2 = this.codewords[imageRowToCodewordIndex];
                if (codeword2 != null) {
                    return codeword2;
                }
            }
        }
        return null;
    }

    /* Access modifiers changed, original: final */
    public final Codeword[] getCodewords() {
        return this.codewords;
    }

    /* Access modifiers changed, original: final */
    public final int imageRowToCodewordIndex(int i) {
        return i - this.boundingBox.getMinY();
    }

    /* Access modifiers changed, original: final */
    public final void setCodeword(int i, Codeword codeword) {
        this.codewords[imageRowToCodewordIndex(i)] = codeword;
    }

    public String toString() {
        Formatter formatter = new Formatter();
        Codeword[] codewordArr = this.codewords;
        int length = codewordArr.length;
        int i = 0;
        int i2 = i;
        while (i < length) {
            Codeword codeword = codewordArr[i];
            if (codeword == null) {
                Object[] objArr = new Object[1];
                int i3 = i2 + 1;
                objArr[0] = Integer.valueOf(i2);
                formatter.format("%3d:    |   %n", objArr);
                i2 = i3;
            } else {
                r9 = new Object[3];
                int i4 = i2 + 1;
                r9[0] = Integer.valueOf(i2);
                r9[1] = Integer.valueOf(codeword.getRowNumber());
                r9[2] = Integer.valueOf(codeword.getValue());
                formatter.format("%3d: %3d|%3d%n", r9);
                i2 = i4;
            }
            i++;
        }
        String formatter2 = formatter.toString();
        formatter.close();
        return formatter2;
    }
}
