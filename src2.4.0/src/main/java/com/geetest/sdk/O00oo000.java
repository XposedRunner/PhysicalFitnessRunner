package com.geetest.sdk;

import android.util.Base64;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* compiled from: GT3RSAUtils */
public final class O00oo000 {
    public static String O000000o = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDB45NNFhRGWzMFPn9I7k7IexS5\nXviJR3E9Je7L/350x5d9AtwdlFH3ndXRwQwprLaptNb7fQoCebZxnhdyVl8Jr2J3\nFZGSIa75GJnK4IwNaG10iyCjYDviMYymvCtZcGWSqSGdC/Bcn2UCOiHSMwgHJSrg\nBm1Zzu+l8nSOqAurgQIDAQAB";
    private static String O00000Oo = "RSA/ECB/PKCS1Padding";
    private static final char[] O00000o0 = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String O000000o(String str, RSAPublicKey rSAPublicKey) {
        byte[] O000000o = O000000o(rSAPublicKey, str.getBytes());
        if (O000000o == null || O000000o.length == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < O000000o.length; i++) {
            stringBuilder.append(O00000o0[(O000000o[i] >> 4) & 15]);
            stringBuilder.append(O00000o0[O000000o[i] & 15]);
        }
        return stringBuilder.toString();
    }

    public static PublicKey O000000o(String str) {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 4)));
    }

    private static byte[] O000000o(RSAPublicKey rSAPublicKey, byte[] bArr) {
        if (rSAPublicKey == null) {
            throw new Exception("加密公钥为空, 请设置");
        }
        try {
            Cipher instance = Cipher.getInstance(O00000Oo);
            instance.init(1, rSAPublicKey);
            return instance.doFinal(bArr);
        } catch (NoSuchAlgorithmException unused) {
            throw new Exception("无此加密算法");
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
            return null;
        } catch (InvalidKeyException unused2) {
            throw new Exception("加密公钥非法,请检查");
        } catch (IllegalBlockSizeException unused3) {
            throw new Exception("明文长度非法");
        } catch (BadPaddingException unused4) {
            throw new Exception("明文数据已损坏");
        }
    }
}
