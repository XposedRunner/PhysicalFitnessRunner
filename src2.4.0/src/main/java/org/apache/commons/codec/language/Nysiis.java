package org.apache.commons.codec.language;

import java.util.regex.Pattern;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

public class Nysiis implements StringEncoder {
    private static final char[] CHARS_A = new char[]{'A'};
    private static final char[] CHARS_AF = new char[]{'A', 'F'};
    private static final char[] CHARS_C = new char[]{'C'};
    private static final char[] CHARS_FF = new char[]{'F', 'F'};
    private static final char[] CHARS_G = new char[]{'G'};
    private static final char[] CHARS_N = new char[]{'N'};
    private static final char[] CHARS_NN = new char[]{'N', 'N'};
    private static final char[] CHARS_S = new char[]{'S'};
    private static final char[] CHARS_SSS = new char[]{'S', 'S', 'S'};
    private static final Pattern PAT_DT_ETC = Pattern.compile("(DT|RT|RD|NT|ND)$");
    private static final Pattern PAT_EE_IE = Pattern.compile("(EE|IE)$");
    private static final Pattern PAT_K = Pattern.compile("^K");
    private static final Pattern PAT_KN = Pattern.compile("^KN");
    private static final Pattern PAT_MAC = Pattern.compile("^MAC");
    private static final Pattern PAT_PH_PF = Pattern.compile("^(PH|PF)");
    private static final Pattern PAT_SCH = Pattern.compile("^SCH");
    private static final char SPACE = ' ';
    private static final int TRUE_LENGTH = 6;
    private final boolean strict;

    public Nysiis() {
        this(true);
    }

    public Nysiis(boolean z) {
        this.strict = z;
    }

    private static boolean isVowel(char c) {
        return c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    private static char[] transcodeRemaining(char c, char c2, char c3, char c4) {
        if (c2 == 'E' && c3 == 'V') {
            return CHARS_AF;
        }
        if (isVowel(c2)) {
            return CHARS_A;
        }
        if (c2 == 'Q') {
            return CHARS_G;
        }
        if (c2 == 'Z') {
            return CHARS_S;
        }
        if (c2 == 'M') {
            return CHARS_N;
        }
        if (c2 == 'K') {
            return c3 == 'N' ? CHARS_NN : CHARS_C;
        } else {
            if (c2 == 'S' && c3 == 'C' && c4 == 'H') {
                return CHARS_SSS;
            }
            if (c2 == 'P' && c3 == 'H') {
                return CHARS_FF;
            }
            if (c2 == 'H' && (!isVowel(c) || !isVowel(c3))) {
                return new char[]{c};
            } else if (c2 == 'W' && isVowel(c)) {
                return new char[]{c};
            } else {
                return new char[]{c2};
            }
        }
    }

    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof String) {
            return nysiis((String) obj);
        }
        throw new EncoderException("Parameter supplied to Nysiis encode is not of type java.lang.String");
    }

    public String encode(String str) {
        return nysiis(str);
    }

    public boolean isStrict() {
        return this.strict;
    }

    public String nysiis(String str) {
        if (str == null) {
            return null;
        }
        str = SoundexUtils.clean(str);
        if (str.length() == 0) {
            return str;
        }
        str = PAT_DT_ETC.matcher(PAT_EE_IE.matcher(PAT_SCH.matcher(PAT_PH_PF.matcher(PAT_K.matcher(PAT_KN.matcher(PAT_MAC.matcher(str).replaceFirst("MCC")).replaceFirst("NN")).replaceFirst("C")).replaceFirst("FF")).replaceFirst("SSS")).replaceFirst("Y")).replaceFirst("D");
        StringBuilder stringBuilder = new StringBuilder(str.length());
        stringBuilder.append(str.charAt(0));
        char[] toCharArray = str.toCharArray();
        int length = toCharArray.length;
        int i = 1;
        while (i < length) {
            int i2 = length - 1;
            char c = SPACE;
            char c2 = i < i2 ? toCharArray[i + 1] : SPACE;
            if (i < length - 2) {
                c = toCharArray[i + 2];
            }
            int i3 = i - 1;
            char[] transcodeRemaining = transcodeRemaining(toCharArray[i3], toCharArray[i], c2, c);
            System.arraycopy(transcodeRemaining, 0, toCharArray, i, transcodeRemaining.length);
            if (toCharArray[i] != toCharArray[i3]) {
                stringBuilder.append(toCharArray[i]);
            }
            i++;
        }
        if (stringBuilder.length() > 1) {
            char charAt = stringBuilder.charAt(stringBuilder.length() - 1);
            if (charAt == 'S') {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                charAt = stringBuilder.charAt(stringBuilder.length() - 1);
            }
            if (stringBuilder.length() > 2 && stringBuilder.charAt(stringBuilder.length() - 2) == 'A' && charAt == 'Y') {
                stringBuilder.deleteCharAt(stringBuilder.length() - 2);
            }
            if (charAt == 'A') {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        }
        str = stringBuilder.toString();
        if (isStrict()) {
            str = str.substring(0, Math.min(6, str.length()));
        }
        return str;
    }
}
