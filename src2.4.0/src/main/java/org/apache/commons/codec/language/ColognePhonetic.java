package org.apache.commons.codec.language;

import java.util.Locale;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

public class ColognePhonetic implements StringEncoder {
    private static final char[] AEIJOUY = new char[]{'A', 'E', 'I', 'J', 'O', 'U', 'Y'};
    private static final char[] AHKLOQRUX = new char[]{'A', 'H', 'K', 'L', 'O', 'Q', 'R', 'U', 'X'};
    private static final char[] AHOUKQX = new char[]{'A', 'H', 'O', 'U', 'K', 'Q', 'X'};
    private static final char[] CKQ = new char[]{'C', 'K', 'Q'};
    private static final char[] GKQ = new char[]{'G', 'K', 'Q'};
    private static final char[][] PREPROCESS_MAP = new char[][]{new char[]{196, 'A'}, new char[]{220, 'U'}, new char[]{214, 'O'}, new char[]{223, 'S'}};
    private static final char[] SCZ = new char[]{'S', 'C', 'Z'};
    private static final char[] SZ = new char[]{'S', 'Z'};
    private static final char[] TDX = new char[]{'T', 'D', 'X'};
    private static final char[] WFPV = new char[]{'W', 'F', 'P', 'V'};

    private abstract class CologneBuffer {
        protected final char[] data;
        protected int length = 0;

        public CologneBuffer(int i) {
            this.data = new char[i];
            this.length = 0;
        }

        public CologneBuffer(char[] cArr) {
            this.data = cArr;
            this.length = cArr.length;
        }

        public abstract char[] copyData(int i, int i2);

        public int length() {
            return this.length;
        }

        public String toString() {
            return new String(copyData(0, this.length));
        }
    }

    private class CologneInputBuffer extends CologneBuffer {
        public CologneInputBuffer(char[] cArr) {
            super(cArr);
        }

        public void addLeft(char c) {
            this.length++;
            this.data[getNextPos()] = c;
        }

        /* Access modifiers changed, original: protected */
        public char[] copyData(int i, int i2) {
            char[] cArr = new char[i2];
            System.arraycopy(this.data, (this.data.length - this.length) + i, cArr, 0, i2);
            return cArr;
        }

        public char getNextChar() {
            return this.data[getNextPos()];
        }

        /* Access modifiers changed, original: protected */
        public int getNextPos() {
            return this.data.length - this.length;
        }

        public char removeNext() {
            char nextChar = getNextChar();
            this.length--;
            return nextChar;
        }
    }

    private class CologneOutputBuffer extends CologneBuffer {
        public CologneOutputBuffer(int i) {
            super(i);
        }

        public void addRight(char c) {
            this.data[this.length] = c;
            this.length++;
        }

        /* Access modifiers changed, original: protected */
        public char[] copyData(int i, int i2) {
            char[] cArr = new char[i2];
            System.arraycopy(this.data, i, cArr, 0, i2);
            return cArr;
        }
    }

    private static boolean arrayContains(char[] cArr, char c) {
        for (char c2 : cArr) {
            if (c2 == c) {
                return true;
            }
        }
        return false;
    }

    private String preprocess(String str) {
        char[] toCharArray = str.toUpperCase(Locale.GERMAN).toCharArray();
        for (int i = 0; i < toCharArray.length; i++) {
            if (toCharArray[i] > 'Z') {
                for (char[] cArr : PREPROCESS_MAP) {
                    if (toCharArray[i] == cArr[0]) {
                        toCharArray[i] = cArr[1];
                        break;
                    }
                }
            }
        }
        return new String(toCharArray);
    }

    public String colognePhonetic(String str) {
        if (str == null) {
            return null;
        }
        str = preprocess(str);
        CologneOutputBuffer cologneOutputBuffer = new CologneOutputBuffer(str.length() * 2);
        CologneInputBuffer cologneInputBuffer = new CologneInputBuffer(str.toCharArray());
        int length = cologneInputBuffer.length();
        char c = '/';
        char c2 = '-';
        while (length > 0) {
            char removeNext = cologneInputBuffer.removeNext();
            int length2 = cologneInputBuffer.length();
            char nextChar = length2 > 0 ? cologneInputBuffer.getNextChar() : '-';
            if (arrayContains(AEIJOUY, removeNext)) {
                c2 = '0';
            } else if (removeNext == 'H' || removeNext < 'A' || removeNext > 'Z') {
                if (c == '/') {
                    length = length2;
                } else {
                    c2 = '-';
                }
            } else if (removeNext == 'B' || (removeNext == 'P' && nextChar != 'H')) {
                c2 = '1';
            } else if ((removeNext == 'D' || removeNext == 'T') && !arrayContains(SCZ, nextChar)) {
                c2 = '2';
            } else if (arrayContains(WFPV, removeNext)) {
                c2 = '3';
            } else {
                if (!arrayContains(GKQ, removeNext)) {
                    if (removeNext != 'X' || arrayContains(CKQ, c2)) {
                        if (!(removeNext == 'S' || removeNext == 'Z')) {
                            if (removeNext == 'C') {
                                if (c != '/') {
                                }
                            } else if (!arrayContains(TDX, removeNext)) {
                                c2 = removeNext == 'R' ? '7' : removeNext == 'L' ? '5' : (removeNext == 'M' || removeNext == 'N') ? '6' : removeNext;
                            }
                        }
                        c2 = '8';
                    } else {
                        cologneInputBuffer.addLeft('S');
                        length2++;
                    }
                }
                c2 = '4';
            }
            if (c2 != '-' && ((c != c2 && (c2 != '0' || c == '/')) || c2 < '0' || c2 > '8')) {
                cologneOutputBuffer.addRight(c2);
            }
            c = c2;
            c2 = removeNext;
            length = length2;
        }
        return cologneOutputBuffer.toString();
    }

    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof String) {
            return encode((String) obj);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("This method's parameter was expected to be of the type ");
        stringBuilder.append(String.class.getName());
        stringBuilder.append(". But actually it was of the type ");
        stringBuilder.append(obj.getClass().getName());
        stringBuilder.append(".");
        throw new EncoderException(stringBuilder.toString());
    }

    public String encode(String str) {
        return colognePhonetic(str);
    }

    public boolean isEncodeEqual(String str, String str2) {
        return colognePhonetic(str).equals(colognePhonetic(str2));
    }
}
