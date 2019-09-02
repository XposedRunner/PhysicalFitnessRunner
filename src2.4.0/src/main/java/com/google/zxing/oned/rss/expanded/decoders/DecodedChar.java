package com.google.zxing.oned.rss.expanded.decoders;

final class DecodedChar extends DecodedObject {
    static final char FNC1 = '$';
    private final char value;

    DecodedChar(int i, char c) {
        super(i);
        this.value = c;
    }

    /* Access modifiers changed, original: 0000 */
    public char getValue() {
        return this.value;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean isFNC1() {
        return this.value == FNC1;
    }
}
