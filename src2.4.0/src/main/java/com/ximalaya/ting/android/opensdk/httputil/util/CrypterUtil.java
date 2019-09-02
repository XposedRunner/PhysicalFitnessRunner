package com.ximalaya.ting.android.opensdk.httputil.util;

import com.ximalaya.ting.android.opensdk.util.DigestUtils;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class CrypterUtil {
    private static final String HMAC_SHA1 = "HmacSHA1";

    public static byte[] hmacSHA1(byte[] bArr, byte[] bArr2) throws NoSuchAlgorithmException, InvalidKeyException {
        if (bArr == null || bArr2 == null) {
            return null;
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, HMAC_SHA1);
        Mac instance = Mac.getInstance(HMAC_SHA1);
        instance.init(secretKeySpec);
        return instance.doFinal(bArr);
    }

    public static String hmacSHA1ToStr(String str, String str2) throws InvalidKeyException, NoSuchAlgorithmException {
        return (str == null || str2 == null) ? null : hmacSHA1ToStr(str.getBytes(), str2.getBytes());
    }

    public static String hmacSHA1ToStr(byte[] bArr, byte[] bArr2) throws NoSuchAlgorithmException, InvalidKeyException {
        return DigestUtils.md5Hex(hmacSHA1(bArr, bArr2));
    }
}
