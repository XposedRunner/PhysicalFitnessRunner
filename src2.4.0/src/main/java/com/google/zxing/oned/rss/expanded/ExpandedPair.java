package com.google.zxing.oned.rss.expanded;

import com.google.zxing.oned.rss.DataCharacter;
import com.google.zxing.oned.rss.FinderPattern;

final class ExpandedPair {
    private final FinderPattern finderPattern;
    private final DataCharacter leftChar;
    private final boolean mayBeLast;
    private final DataCharacter rightChar;

    ExpandedPair(DataCharacter dataCharacter, DataCharacter dataCharacter2, FinderPattern finderPattern, boolean z) {
        this.leftChar = dataCharacter;
        this.rightChar = dataCharacter2;
        this.finderPattern = finderPattern;
        this.mayBeLast = z;
    }

    private static boolean equalsOrNull(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    private static int hashNotNull(Object obj) {
        return obj == null ? 0 : obj.hashCode();
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof ExpandedPair)) {
            return false;
        }
        ExpandedPair expandedPair = (ExpandedPair) obj;
        if (equalsOrNull(this.leftChar, expandedPair.leftChar) && equalsOrNull(this.rightChar, expandedPair.rightChar) && equalsOrNull(this.finderPattern, expandedPair.finderPattern)) {
            z = true;
        }
        return z;
    }

    /* Access modifiers changed, original: 0000 */
    public FinderPattern getFinderPattern() {
        return this.finderPattern;
    }

    /* Access modifiers changed, original: 0000 */
    public DataCharacter getLeftChar() {
        return this.leftChar;
    }

    /* Access modifiers changed, original: 0000 */
    public DataCharacter getRightChar() {
        return this.rightChar;
    }

    public int hashCode() {
        return (hashNotNull(this.leftChar) ^ hashNotNull(this.rightChar)) ^ hashNotNull(this.finderPattern);
    }

    /* Access modifiers changed, original: 0000 */
    public boolean mayBeLast() {
        return this.mayBeLast;
    }

    public boolean mustBeLast() {
        return this.rightChar == null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ ");
        stringBuilder.append(this.leftChar);
        stringBuilder.append(" , ");
        stringBuilder.append(this.rightChar);
        stringBuilder.append(" : ");
        stringBuilder.append(this.finderPattern == null ? "null" : Integer.valueOf(this.finderPattern.getValue()));
        stringBuilder.append(" ]");
        return stringBuilder.toString();
    }
}
