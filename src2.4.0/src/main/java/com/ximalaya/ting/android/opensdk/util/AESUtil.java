package com.ximalaya.ting.android.opensdk.util;

import java.nio.charset.Charset;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AESUtil {
    private static final Charset CHARSET_UTF_8 = Charset.forName("utf-8");
    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";
    private static final String KEY_ALGORITHM = "AES";

    public static byte[] decrypt(String str, String str2) {
        return decrypt(str.getBytes(CHARSET_UTF_8), str2.getBytes(CHARSET_UTF_8));
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2) {
        try {
            Cipher instance = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            instance.init(2, getSecretKey(bArr2));
            return instance.doFinal(bArr);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String decryptAsString(String str, String str2) {
        return decryptAsString(str.getBytes(CHARSET_UTF_8), str2.getBytes(CHARSET_UTF_8));
    }

    public static String decryptAsString(byte[] bArr, byte[] bArr2) {
        return new String(decrypt(bArr, bArr2));
    }

    public static byte[] encrypt(String str, String str2) {
        try {
            return encrypt(str.getBytes(CHARSET_UTF_8), str2.getBytes(CHARSET_UTF_8));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2) {
        try {
            Cipher instance = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            instance.init(1, getSecretKey(bArr2));
            return instance.doFinal(bArr);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String encryptAsString(String str, String str2) {
        return encryptAsString(str.getBytes(CHARSET_UTF_8), str2.getBytes(CHARSET_UTF_8));
    }

    public static String encryptAsString(byte[] bArr, byte[] bArr2) {
        return new String(encrypt(bArr, bArr2));
    }

    private static SecretKey getSecretKey(byte[] bArr) throws Exception {
        return new SecretKeySpec(bArr, KEY_ALGORITHM);
    }
}
