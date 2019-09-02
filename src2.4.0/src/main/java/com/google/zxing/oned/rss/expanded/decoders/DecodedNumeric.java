package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;

final class DecodedNumeric extends DecodedObject {
    static final int FNC1 = 10;
    private final int firstDigit;
    private final int secondDigit;

    DecodedNumeric(int i, int i2, int i3) throws FormatException {
        super(i);
        if (i2 < 0 || i2 > 10 || i3 < 0 || i3 > 10) {
            throw FormatException.getFormatInstance();
        }
        this.firstDigit = i2;
        this.secondDigit = i3;
    }

    /* Access modifiers changed, original: 0000 */
    public int getFirstDigit() {
        return this.firstDigit;
    }

    /* Access modifiers changed, original: 0000 */
    public int getSecondDigit() {
        return this.secondDigit;
    }

    /* Access modifiers changed, original: 0000 */
    public int getValue() {
        return (this.firstDigit * 10) + this.secondDigit;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean isAnyFNC1() {
        return this.firstDigit == 10 || this.secondDigit == 10;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean isFirstDigitFNC1() {
        return this.firstDigit == 10;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean isSecondDigitFNC1() {
        return this.secondDigit == 10;
    }
}
