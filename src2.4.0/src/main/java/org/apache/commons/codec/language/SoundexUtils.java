package org.apache.commons.codec.language;

import java.util.Locale;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

final class SoundexUtils {
    SoundexUtils() {
    }

    static String clean(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        int length = str.length();
        char[] cArr = new char[length];
        int i = 0;
        int i2 = i;
        while (i < length) {
            if (Character.isLetter(str.charAt(i))) {
                int i3 = i2 + 1;
                cArr[i2] = str.charAt(i);
                i2 = i3;
            }
            i++;
        }
        return i2 == length ? str.toUpperCase(Locale.ENGLISH) : new String(cArr, 0, i2).toUpperCase(Locale.ENGLISH);
    }

    static int difference(StringEncoder stringEncoder, String str, String str2) throws EncoderException {
        return differenceEncoded(stringEncoder.encode(str), stringEncoder.encode(str2));
    }

    static int differenceEncoded(String str, String str2) {
        int i = 0;
        if (str == null || str2 == null) {
            return 0;
        }
        int min = Math.min(str.length(), str2.length());
        int i2 = 0;
        while (i < min) {
            if (str.charAt(i) == str2.charAt(i)) {
                i2++;
            }
            i++;
        }
        return i2;
    }
}
