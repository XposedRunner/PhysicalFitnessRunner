package com.google.zxing.oned.rss;

final class Pair extends DataCharacter {
    private int count;
    private final FinderPattern finderPattern;

    Pair(int i, int i2, FinderPattern finderPattern) {
        super(i, i2);
        this.finderPattern = finderPattern;
    }

    /* Access modifiers changed, original: 0000 */
    public int getCount() {
        return this.count;
    }

    /* Access modifiers changed, original: 0000 */
    public FinderPattern getFinderPattern() {
        return this.finderPattern;
    }

    /* Access modifiers changed, original: 0000 */
    public void incrementCount() {
        this.count++;
    }
}
