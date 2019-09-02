package org.apache.commons.codec.language;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

public class RefinedSoundex implements StringEncoder {
    public static final RefinedSoundex US_ENGLISH = new RefinedSoundex();
    private static final char[] US_ENGLISH_MAPPING = US_ENGLISH_MAPPING_STRING.toCharArray();
    public static final String US_ENGLISH_MAPPING_STRING = "01360240043788015936020505";
    private final char[] soundexMapping;

    public RefinedSoundex() {
        this.soundexMapping = US_ENGLISH_MAPPING;
    }

    public RefinedSoundex(String str) {
        this.soundexMapping = str.toCharArray();
    }

    public RefinedSoundex(char[] cArr) {
        this.soundexMapping = new char[cArr.length];
        System.arraycopy(cArr, 0, this.soundexMapping, 0, cArr.length);
    }

    public int difference(String str, String str2) throws EncoderException {
        return SoundexUtils.difference(this, str, str2);
    }

    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof String) {
            return soundex((String) obj);
        }
        throw new EncoderException("Parameter supplied to RefinedSoundex encode is not of type java.lang.String");
    }

    public String encode(String str) {
        return soundex(str);
    }

    /* Access modifiers changed, original: 0000 */
    public char getMappingCode(char c) {
        return !Character.isLetter(c) ? 0 : this.soundexMapping[Character.toUpperCase(c) - 65];
    }

    public String soundex(String str) {
        if (str == null) {
            return null;
        }
        str = SoundexUtils.clean(str);
        if (str.length() == 0) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        stringBuilder.append(str.charAt(0));
        char c = '*';
        while (i < str.length()) {
            char mappingCode = getMappingCode(str.charAt(i));
            if (mappingCode != c) {
                if (mappingCode != 0) {
                    stringBuilder.append(mappingCode);
                }
                c = mappingCode;
            }
            i++;
        }
        return stringBuilder.toString();
    }
}
