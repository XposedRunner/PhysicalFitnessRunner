package com.ximalaya.ting.android.opensdk.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

public class DigestUtils {
    private static final char[] HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    protected static String encodeHex(byte[] bArr) {
        int i = 0;
        int length = bArr.length;
        char[] cArr = new char[(length << 1)];
        int i2 = 0;
        while (i < length) {
            int i3 = i2 + 1;
            cArr[i2] = HEX_DIGITS[(240 & bArr[i]) >>> 4];
            i2 = i3 + 1;
            cArr[i3] = HEX_DIGITS[15 & bArr[i]];
            i++;
        }
        return new String(cArr);
    }

    static MessageDigest getDigest(String str) {
        try {
            return MessageDigest.getInstance(str);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static byte[] md5(byte[] bArr) {
        return getDigest(MessageDigestAlgorithms.MD5).digest(bArr);
    }

    public static String md5Hex(String str) {
        return encodeHex(md5(utf8Bytes(str)));
    }

    public static String md5Hex(byte[] bArr) {
        return encodeHex(md5(bArr));
    }

    public static byte[] sha1(String str) {
        return sha1(utf8Bytes(str));
    }

    public static byte[] sha1(byte[] bArr) {
        return getDigest(MessageDigestAlgorithms.SHA_1).digest(bArr);
    }

    public static String sha1Hex(String str) {
        return new String(encodeHex(sha1(str)));
    }

    private static byte[] utf8Bytes(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
