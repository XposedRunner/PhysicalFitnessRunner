package org.apache.commons.codec.language;

import java.util.Locale;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

public class Metaphone implements StringEncoder {
    private static final String FRONTV = "EIY";
    private static final String VARSON = "CSPTG";
    private static final String VOWELS = "AEIOU";
    private int maxCodeLen = 4;

    private boolean isLastChar(int i, int i2) {
        return i2 + 1 == i;
    }

    private boolean isNextChar(StringBuilder stringBuilder, int i, char c) {
        return i >= 0 && i < stringBuilder.length() - 1 && stringBuilder.charAt(i + 1) == c;
    }

    private boolean isPreviousChar(StringBuilder stringBuilder, int i, char c) {
        return i > 0 && i < stringBuilder.length() && stringBuilder.charAt(i - 1) == c;
    }

    private boolean isVowel(StringBuilder stringBuilder, int i) {
        return VOWELS.indexOf(stringBuilder.charAt(i)) >= 0;
    }

    private boolean regionMatch(StringBuilder stringBuilder, int i, String str) {
        return (i < 0 || (str.length() + i) - 1 >= stringBuilder.length()) ? false : stringBuilder.substring(i, str.length() + i).equals(str);
    }

    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof String) {
            return metaphone((String) obj);
        }
        throw new EncoderException("Parameter supplied to Metaphone encode is not of type java.lang.String");
    }

    public String encode(String str) {
        return metaphone(str);
    }

    public int getMaxCodeLen() {
        return this.maxCodeLen;
    }

    public boolean isMetaphoneEqual(String str, String str2) {
        return metaphone(str).equals(metaphone(str2));
    }

    public String metaphone(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        if (str.length() == 1) {
            return str.toUpperCase(Locale.ENGLISH);
        }
        char[] toCharArray = str.toUpperCase(Locale.ENGLISH).toCharArray();
        StringBuilder stringBuilder = new StringBuilder(40);
        StringBuilder stringBuilder2 = new StringBuilder(10);
        int i = 0;
        char c = toCharArray[0];
        if (c != 'A') {
            if (c != 'G' && c != 'K' && c != 'P') {
                switch (c) {
                    case 'W':
                        if (toCharArray[1] != 'R') {
                            if (toCharArray[1] != 'H') {
                                stringBuilder.append(toCharArray);
                                break;
                            }
                            stringBuilder.append(toCharArray, 1, toCharArray.length - 1);
                            stringBuilder.setCharAt(0, 'W');
                            break;
                        }
                        stringBuilder.append(toCharArray, 1, toCharArray.length - 1);
                        break;
                    case 'X':
                        toCharArray[0] = 'S';
                        stringBuilder.append(toCharArray);
                        break;
                    default:
                        stringBuilder.append(toCharArray);
                        break;
                }
            } else if (toCharArray[1] == 'N') {
                stringBuilder.append(toCharArray, 1, toCharArray.length - 1);
            } else {
                stringBuilder.append(toCharArray);
            }
        } else if (toCharArray[1] == 'E') {
            stringBuilder.append(toCharArray, 1, toCharArray.length - 1);
        } else {
            stringBuilder.append(toCharArray);
        }
        int length = stringBuilder.length();
        while (stringBuilder2.length() < getMaxCodeLen() && i < length) {
            c = stringBuilder.charAt(i);
            if (c == 'C' || !isPreviousChar(stringBuilder, i, c)) {
                switch (c) {
                    case 'A':
                    case 'E':
                    case 'I':
                    case 'O':
                    case 'U':
                        if (i == 0) {
                            stringBuilder2.append(c);
                            break;
                        }
                        break;
                    case 'B':
                        if (!(isPreviousChar(stringBuilder, i, 'M') && isLastChar(length, i))) {
                            stringBuilder2.append(c);
                            break;
                        }
                    case 'C':
                        if (!isPreviousChar(stringBuilder, i, 'S') || isLastChar(length, i) || FRONTV.indexOf(stringBuilder.charAt(i + 1)) < 0) {
                            if (!regionMatch(stringBuilder, i, "CIA")) {
                                if (isLastChar(length, i) || FRONTV.indexOf(stringBuilder.charAt(i + 1)) < 0) {
                                    if (!isPreviousChar(stringBuilder, i, 'S') || !isNextChar(stringBuilder, i, 'H')) {
                                        if (isNextChar(stringBuilder, i, 'H')) {
                                            if (i != 0 || length < 3 || !isVowel(stringBuilder, 2)) {
                                                stringBuilder2.append('X');
                                                break;
                                            }
                                            stringBuilder2.append('K');
                                            break;
                                        }
                                        stringBuilder2.append('K');
                                        break;
                                    }
                                    stringBuilder2.append('K');
                                    break;
                                }
                                stringBuilder2.append('S');
                                break;
                            }
                            stringBuilder2.append('X');
                            break;
                        }
                        break;
                    case 'D':
                        if (!isLastChar(length, i + 1) && isNextChar(stringBuilder, i, 'G')) {
                            int i2 = i + 2;
                            if (FRONTV.indexOf(stringBuilder.charAt(i2)) >= 0) {
                                stringBuilder2.append('J');
                                i = i2;
                                break;
                            }
                        }
                        stringBuilder2.append('T');
                        break;
                    case 'F':
                    case 'J':
                    case 'L':
                    case 'M':
                    case 'N':
                    case 'R':
                        stringBuilder2.append(c);
                        break;
                    case 'G':
                        int i3 = i + 1;
                        if (!(isLastChar(length, i3) && isNextChar(stringBuilder, i, 'H')) && ((isLastChar(length, i3) || !isNextChar(stringBuilder, i, 'H') || isVowel(stringBuilder, i + 2)) && (i <= 0 || !(regionMatch(stringBuilder, i, "GN") || regionMatch(stringBuilder, i, "GNED"))))) {
                            boolean isPreviousChar = isPreviousChar(stringBuilder, i, 'G');
                            if (!isLastChar(length, i) && FRONTV.indexOf(stringBuilder.charAt(i3)) >= 0 && !isPreviousChar) {
                                stringBuilder2.append('J');
                                break;
                            }
                            stringBuilder2.append('K');
                            break;
                        }
                        break;
                    case 'H':
                        if (!isLastChar(length, i) && ((i <= 0 || VARSON.indexOf(stringBuilder.charAt(i - 1)) < 0) && isVowel(stringBuilder, i + 1))) {
                            stringBuilder2.append('H');
                            break;
                        }
                    case 'K':
                        if (i > 0) {
                            if (!isPreviousChar(stringBuilder, i, 'C')) {
                                stringBuilder2.append(c);
                                break;
                            }
                        }
                        stringBuilder2.append(c);
                        break;
                        break;
                    case 'P':
                        if (!isNextChar(stringBuilder, i, 'H')) {
                            stringBuilder2.append(c);
                            break;
                        }
                        stringBuilder2.append('F');
                        break;
                    case 'Q':
                        stringBuilder2.append('K');
                        break;
                    case 'S':
                        if (!regionMatch(stringBuilder, i, "SH") && !regionMatch(stringBuilder, i, "SIO") && !regionMatch(stringBuilder, i, "SIA")) {
                            stringBuilder2.append('S');
                            break;
                        }
                        stringBuilder2.append('X');
                        break;
                        break;
                    case 'T':
                        if (!regionMatch(stringBuilder, i, "TIA") && !regionMatch(stringBuilder, i, "TIO")) {
                            if (!regionMatch(stringBuilder, i, "TCH")) {
                                if (!regionMatch(stringBuilder, i, "TH")) {
                                    stringBuilder2.append('T');
                                    break;
                                }
                                stringBuilder2.append('0');
                                break;
                            }
                        }
                        stringBuilder2.append('X');
                        break;
                        break;
                    case 'V':
                        stringBuilder2.append('F');
                        break;
                    case 'W':
                    case 'Y':
                        if (!isLastChar(length, i) && isVowel(stringBuilder, i + 1)) {
                            stringBuilder2.append(c);
                            break;
                        }
                    case 'X':
                        stringBuilder2.append('K');
                        stringBuilder2.append('S');
                        break;
                    case 'Z':
                        stringBuilder2.append('S');
                        break;
                }
                i++;
            } else {
                i++;
            }
            if (stringBuilder2.length() > getMaxCodeLen()) {
                stringBuilder2.setLength(getMaxCodeLen());
            }
        }
        return stringBuilder2.toString();
    }

    public void setMaxCodeLen(int i) {
        this.maxCodeLen = i;
    }
}
