package com.ximalaya.ting.android.opensdk.httputil.util;

import java.io.UnsupportedEncodingException;

public class BASE64Encoder {
    private static final String DEFAULT_ENCODING = "UTF-8";
    private static final char[] ENCODE_TABLE = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static final char LAST2BYTE = ((char) Integer.parseInt("00000011", 2));
    private static final char LAST4BYTE = ((char) Integer.parseInt("00001111", 2));
    private static final char LAST6BYTE = ((char) Integer.parseInt("00111111", 2));
    private static final char LEAD2BYTE = ((char) Integer.parseInt("11000000", 2));
    private static final char LEAD4BYTE = ((char) Integer.parseInt("11110000", 2));
    private static final char LEAD6BYTE = ((char) Integer.parseInt("11111100", 2));

    public static String encode(String str) throws UnsupportedEncodingException {
        return encode(str.getBytes("UTF-8"));
    }

    public static String encode(byte[] bArr) {
        int i = 0;
        StringBuffer stringBuffer = new StringBuffer(((int) (((double) bArr.length) * 1.34d)) + 3);
        int i2 = 0;
        int i3 = i2;
        while (i < bArr.length) {
            i2 %= 8;
            while (i2 < 8) {
                int i4;
                if (i2 == 0) {
                    i3 = (char) (((char) (bArr[i] & LEAD6BYTE)) >>> 2);
                } else if (i2 == 2) {
                    i3 = (char) (bArr[i] & LAST6BYTE);
                } else if (i2 == 4) {
                    i3 = (char) (((char) (bArr[i] & LAST4BYTE)) << 2);
                    i4 = i + 1;
                    if (i4 < bArr.length) {
                        i3 = (char) (i3 | ((bArr[i4] & LEAD2BYTE) >>> 6));
                    }
                } else if (i2 == 6) {
                    i3 = (char) (((char) (bArr[i] & LAST2BYTE)) << 4);
                    i4 = i + 1;
                    if (i4 < bArr.length) {
                        i3 = (char) (i3 | ((bArr[i4] & LEAD4BYTE) >>> 4));
                    }
                }
                stringBuffer.append(ENCODE_TABLE[i3]);
                i2 += 6;
            }
            i++;
        }
        if (stringBuffer.length() % 4 != 0) {
            for (int length = 4 - (stringBuffer.length() % 4); length > 0; length--) {
                stringBuffer.append("=");
            }
        }
        return stringBuffer.toString();
    }
}
