package org.apache.commons.codec.language;

import java.util.Locale;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

public class MatchRatingApproachEncoder implements StringEncoder {
    private static final String[] DOUBLE_CONSONANT = new String[]{"BB", "CC", "DD", "FF", "GG", "HH", "JJ", "KK", "LL", "MM", "NN", "PP", "QQ", "RR", "SS", "TT", "VV", "WW", "XX", "YY", "ZZ"};
    private static final int EIGHT = 8;
    private static final int ELEVEN = 11;
    private static final String EMPTY = "";
    private static final int FIVE = 5;
    private static final int FOUR = 4;
    private static final int ONE = 1;
    private static final String PLAIN_ASCII = "AaEeIiOoUuAaEeIiOoUuYyAaEeIiOoUuYyAaOoNnAaEeIiOoUuYyAaCcOoUu";
    private static final int SEVEN = 7;
    private static final int SIX = 6;
    private static final String SPACE = " ";
    private static final int THREE = 3;
    private static final int TWELVE = 12;
    private static final int TWO = 2;
    private static final String UNICODE = "ÀàÈèÌìÒòÙùÁáÉéÍíÓóÚúÝýÂâÊêÎîÔôÛûŶŷÃãÕõÑñÄäËëÏïÖöÜüŸÿÅåÇçŐőŰű";

    /* Access modifiers changed, original: 0000 */
    public String cleanName(String str) {
        str = str.toUpperCase(Locale.ENGLISH);
        r0 = new String[5];
        int i = 0;
        r0[0] = "\\-";
        r0[1] = "[&]";
        r0[2] = "\\'";
        r0[3] = "\\.";
        r0[4] = "[\\,]";
        int length = r0.length;
        while (i < length) {
            str = str.replaceAll(r0[i], "");
            i++;
        }
        return removeAccents(str).replaceAll("\\s+", "");
    }

    public final Object encode(Object obj) throws EncoderException {
        if (obj instanceof String) {
            return encode((String) obj);
        }
        throw new EncoderException("Parameter supplied to Match Rating Approach encoder is not of type java.lang.String");
    }

    public final String encode(String str) {
        return (str == null || "".equalsIgnoreCase(str) || SPACE.equalsIgnoreCase(str) || str.length() == 1) ? "" : getFirst3Last3(removeDoubleConsonants(removeVowels(cleanName(str))));
    }

    /* Access modifiers changed, original: 0000 */
    public String getFirst3Last3(String str) {
        int length = str.length();
        if (length <= 6) {
            return str;
        }
        String substring = str.substring(0, 3);
        str = str.substring(length - 3, length);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(substring);
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    /* Access modifiers changed, original: 0000 */
    public int getMinRating(int i) {
        return i <= 4 ? 5 : (i < 5 || i > 7) ? (i < 8 || i > 11) ? i == 12 ? 2 : 1 : 3 : 4;
    }

    /* JADX WARNING: Missing block: B:26:0x0088, code skipped:
            return false;
     */
    /* JADX WARNING: Missing block: B:27:0x0089, code skipped:
            return false;
     */
    public boolean isEncodeEquals(java.lang.String r5, java.lang.String r6) {
        /*
        r4 = this;
        r0 = 0;
        if (r5 == 0) goto L_0x0089;
    L_0x0003:
        r1 = "";
        r1 = r1.equalsIgnoreCase(r5);
        if (r1 != 0) goto L_0x0089;
    L_0x000b:
        r1 = " ";
        r1 = r1.equalsIgnoreCase(r5);
        if (r1 == 0) goto L_0x0015;
    L_0x0013:
        goto L_0x0089;
    L_0x0015:
        if (r6 == 0) goto L_0x0088;
    L_0x0017:
        r1 = "";
        r1 = r1.equalsIgnoreCase(r6);
        if (r1 != 0) goto L_0x0088;
    L_0x001f:
        r1 = " ";
        r1 = r1.equalsIgnoreCase(r6);
        if (r1 == 0) goto L_0x0028;
    L_0x0027:
        goto L_0x0088;
    L_0x0028:
        r1 = r5.length();
        r2 = 1;
        if (r1 == r2) goto L_0x0087;
    L_0x002f:
        r1 = r6.length();
        if (r1 != r2) goto L_0x0036;
    L_0x0035:
        goto L_0x0087;
    L_0x0036:
        r1 = r5.equalsIgnoreCase(r6);
        if (r1 == 0) goto L_0x003d;
    L_0x003c:
        return r2;
    L_0x003d:
        r5 = r4.cleanName(r5);
        r6 = r4.cleanName(r6);
        r5 = r4.removeVowels(r5);
        r6 = r4.removeVowels(r6);
        r5 = r4.removeDoubleConsonants(r5);
        r6 = r4.removeDoubleConsonants(r6);
        r5 = r4.getFirst3Last3(r5);
        r6 = r4.getFirst3Last3(r6);
        r1 = r5.length();
        r3 = r6.length();
        r1 = r1 - r3;
        r1 = java.lang.Math.abs(r1);
        r3 = 3;
        if (r1 < r3) goto L_0x006e;
    L_0x006d:
        return r0;
    L_0x006e:
        r1 = r5.length();
        r3 = r6.length();
        r1 = r1 + r3;
        r1 = java.lang.Math.abs(r1);
        r1 = r4.getMinRating(r1);
        r5 = r4.leftToRightThenRightToLeftProcessing(r5, r6);
        if (r5 < r1) goto L_0x0086;
    L_0x0085:
        r0 = r2;
    L_0x0086:
        return r0;
    L_0x0087:
        return r0;
    L_0x0088:
        return r0;
    L_0x0089:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.language.MatchRatingApproachEncoder.isEncodeEquals(java.lang.String, java.lang.String):boolean");
    }

    /* Access modifiers changed, original: 0000 */
    public boolean isVowel(String str) {
        return str.equalsIgnoreCase("E") || str.equalsIgnoreCase("A") || str.equalsIgnoreCase("O") || str.equalsIgnoreCase("I") || str.equalsIgnoreCase("U");
    }

    /* Access modifiers changed, original: 0000 */
    public int leftToRightThenRightToLeftProcessing(String str, String str2) {
        char[] toCharArray = str.toCharArray();
        char[] toCharArray2 = str2.toCharArray();
        int length = str.length() - 1;
        int length2 = str2.length() - 1;
        int i = 0;
        while (i < toCharArray.length && i <= length2) {
            int i2 = i + 1;
            String substring = str.substring(i, i2);
            int i3 = length - i;
            String substring2 = str.substring(i3, i3 + 1);
            String substring3 = str2.substring(i, i2);
            int i4 = length2 - i;
            String substring4 = str2.substring(i4, i4 + 1);
            if (substring.equals(substring3)) {
                toCharArray[i] = ' ';
                toCharArray2[i] = ' ';
            }
            if (substring2.equals(substring4)) {
                toCharArray[i3] = ' ';
                toCharArray2[i4] = ' ';
            }
            i = i2;
        }
        str = new String(toCharArray).replaceAll("\\s+", "");
        str2 = new String(toCharArray2).replaceAll("\\s+", "");
        return str.length() > str2.length() ? Math.abs(6 - str.length()) : Math.abs(6 - str2.length());
    }

    /* Access modifiers changed, original: 0000 */
    public String removeAccents(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            int indexOf = UNICODE.indexOf(charAt);
            if (indexOf > -1) {
                stringBuilder.append(PLAIN_ASCII.charAt(indexOf));
            } else {
                stringBuilder.append(charAt);
            }
        }
        return stringBuilder.toString();
    }

    /* Access modifiers changed, original: 0000 */
    public String removeDoubleConsonants(String str) {
        str = str.toUpperCase();
        String str2 = str;
        for (CharSequence charSequence : DOUBLE_CONSONANT) {
            if (str2.contains(charSequence)) {
                str2 = str2.replace(charSequence, charSequence.substring(0, 1));
            }
        }
        return str2;
    }

    /* Access modifiers changed, original: 0000 */
    public String removeVowels(String str) {
        String substring = str.substring(0, 1);
        str = str.replaceAll("A", "").replaceAll("E", "").replaceAll("I", "").replaceAll("O", "").replaceAll("U", "").replaceAll("\\s{2,}\\b", SPACE);
        if (!isVowel(substring)) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(substring);
        stringBuilder.append(str);
        return stringBuilder.toString();
    }
}
