package com.google.zxing.oned;

public final class CodaBarWriter extends OneDimensionalCodeWriter {
    private static final char[] ALT_START_END_CHARS = new char[]{'T', 'N', '*', 'E'};
    private static final char[] CHARS_WHICH_ARE_TEN_LENGTH_EACH_AFTER_DECODED = new char[]{'/', ':', '+', '.'};
    private static final char DEFAULT_GUARD = START_END_CHARS[0];
    private static final char[] START_END_CHARS = new char[]{'A', 'B', 'C', 'D'};

    public boolean[] encode(String str) {
        StringBuilder stringBuilder;
        if (str.length() < 2) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(DEFAULT_GUARD);
            stringBuilder.append(str);
            stringBuilder.append(DEFAULT_GUARD);
            str = stringBuilder.toString();
        } else {
            char toUpperCase = Character.toUpperCase(str.charAt(0));
            char toUpperCase2 = Character.toUpperCase(str.charAt(str.length() - 1));
            boolean arrayContains = CodaBarReader.arrayContains(START_END_CHARS, toUpperCase);
            boolean arrayContains2 = CodaBarReader.arrayContains(START_END_CHARS, toUpperCase2);
            boolean arrayContains3 = CodaBarReader.arrayContains(ALT_START_END_CHARS, toUpperCase);
            boolean arrayContains4 = CodaBarReader.arrayContains(ALT_START_END_CHARS, toUpperCase2);
            StringBuilder stringBuilder2;
            if (arrayContains) {
                if (!arrayContains2) {
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("Invalid start/end guards: ");
                    stringBuilder2.append(str);
                    throw new IllegalArgumentException(stringBuilder2.toString());
                }
            } else if (arrayContains3) {
                if (!arrayContains4) {
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("Invalid start/end guards: ");
                    stringBuilder2.append(str);
                    throw new IllegalArgumentException(stringBuilder2.toString());
                }
            } else if (arrayContains2 || arrayContains4) {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Invalid start/end guards: ");
                stringBuilder2.append(str);
                throw new IllegalArgumentException(stringBuilder2.toString());
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(DEFAULT_GUARD);
                stringBuilder.append(str);
                stringBuilder.append(DEFAULT_GUARD);
                str = stringBuilder.toString();
            }
        }
        int i = 20;
        int i2 = 1;
        while (i2 < str.length() - 1) {
            if (Character.isDigit(str.charAt(i2)) || str.charAt(i2) == '-' || str.charAt(i2) == '$') {
                i += 9;
            } else if (CodaBarReader.arrayContains(CHARS_WHICH_ARE_TEN_LENGTH_EACH_AFTER_DECODED, str.charAt(i2))) {
                i += 10;
            } else {
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append("Cannot encode : '");
                stringBuilder3.append(str.charAt(i2));
                stringBuilder3.append('\'');
                throw new IllegalArgumentException(stringBuilder3.toString());
            }
            i2++;
        }
        boolean[] zArr = new boolean[(i + (str.length() - 1))];
        i = 0;
        int i3 = i;
        while (i < str.length()) {
            int i4;
            int i5;
            char toUpperCase3 = Character.toUpperCase(str.charAt(i));
            if (i == 0 || i == str.length() - 1) {
                if (toUpperCase3 == '*') {
                    toUpperCase3 = 'C';
                } else if (toUpperCase3 == 'E') {
                    toUpperCase3 = 'D';
                } else if (toUpperCase3 == 'N') {
                    toUpperCase3 = 'B';
                } else if (toUpperCase3 == 'T') {
                    toUpperCase3 = 'A';
                }
            }
            for (i4 = 0; i4 < CodaBarReader.ALPHABET.length; i4++) {
                if (toUpperCase3 == CodaBarReader.ALPHABET[i4]) {
                    i5 = CodaBarReader.CHARACTER_ENCODINGS[i4];
                    break;
                }
            }
            i5 = 0;
            int i6 = 0;
            boolean z = true;
            i4 = i3;
            i3 = i6;
            while (i3 < 7) {
                zArr[i4] = z;
                i4++;
                if (((i5 >> (6 - i3)) & 1) == 0 || i6 == 1) {
                    z ^= 1;
                    i3++;
                    i6 = 0;
                } else {
                    i6++;
                }
            }
            if (i < str.length() - 1) {
                zArr[i4] = false;
                i4++;
            }
            i3 = i4;
            i++;
        }
        return zArr;
    }
}
