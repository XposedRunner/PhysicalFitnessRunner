package org.apache.commons.codec.net;

import org.apache.commons.codec.DecoderException;

class Utils {
    Utils() {
    }

    static int digit16(byte b) throws DecoderException {
        int digit = Character.digit((char) b, 16);
        if (digit != -1) {
            return digit;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid URL encoding: not a valid digit (radix 16): ");
        stringBuilder.append(b);
        throw new DecoderException(stringBuilder.toString());
    }
}
