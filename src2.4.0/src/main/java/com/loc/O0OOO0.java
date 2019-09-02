package com.loc;

import cn.jiguang.net.HttpUtils;
import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: Encrypt */
public final class O0OOO0 {
    private static final char[] O000000o = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final byte[] O00000Oo = new byte[]{(byte) 0, (byte) 1, (byte) 1, (byte) 2, (byte) 3, (byte) 5, (byte) 8, (byte) 13, (byte) 8, (byte) 7, (byte) 6, (byte) 5, (byte) 4, (byte) 3, (byte) 2, (byte) 1};
    private static final IvParameterSpec O00000o0 = new IvParameterSpec(O00000Oo);

    public static String O000000o(String str) {
        if (str != null) {
            try {
                if (str.length() == 0) {
                    return null;
                }
                String O000000o = O000000o("SHA1", str);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(O000000o);
                stringBuilder.append(str);
                return O000000o("MD5", stringBuilder.toString());
            } catch (Throwable th) {
                O0o0000.O000000o(th, "Encrypt", "generatorKey");
            }
        }
        return null;
    }

    public static String O000000o(String str, String str2) {
        if (str2 == null) {
            return null;
        }
        try {
            byte[] O000000o = OO0OOOO.O000000o(str2.getBytes(HttpUtils.ENCODING_UTF_8), str);
            int length = O000000o.length;
            StringBuilder stringBuilder = new StringBuilder(length * 2);
            for (int i = 0; i < length; i++) {
                stringBuilder.append(O000000o[(O000000o[i] >> 4) & 15]);
                stringBuilder.append(O000000o[O000000o[i] & 15]);
            }
            return stringBuilder.toString();
        } catch (Throwable th) {
            O0o0000.O000000o(th, "Encrypt", "encode");
            return null;
        }
    }

    public static byte[] O000000o(byte[] bArr) {
        int i = 0;
        try {
            byte[] bArr2 = new byte[16];
            byte[] bArr3 = new byte[(bArr.length - 16)];
            System.arraycopy(bArr, 0, bArr2, 0, 16);
            System.arraycopy(bArr, 16, bArr3, 0, bArr.length - 16);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, secretKeySpec, new IvParameterSpec(OO0o000.O00000o0()));
            return instance.doFinal(bArr3);
        } catch (Throwable th) {
            if (bArr != null) {
                i = bArr.length;
            }
            StringBuilder stringBuilder = new StringBuilder("decryptRsponse length = ");
            stringBuilder.append(i);
            O0o0000.O000000o(th, "Encrypt", stringBuilder.toString());
            return null;
        }
    }

    public static synchronized byte[] O000000o(byte[] bArr, String str) throws Exception {
        synchronized (O0OOO0.class) {
            PrivateKey generatePrivate = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(oOo00.O00000Oo(str)));
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(1, generatePrivate);
            int length = bArr.length;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i = 0;
            int i2 = i;
            while (true) {
                int i3 = length - i;
                if (i3 > 0) {
                    byte[] doFinal = i3 > 245 ? instance.doFinal(bArr, i, 245) : instance.doFinal(bArr, i, i3);
                    byteArrayOutputStream.write(doFinal, 0, doFinal.length);
                    i2++;
                    i = i2 * 245;
                } else {
                    bArr = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                }
            }
        }
        return bArr;
    }

    public static byte[] O000000o(byte[] bArr, byte[] bArr2) throws Exception {
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(2, new SecretKeySpec(bArr, "AES"), O00000o0);
        return instance.doFinal(bArr2);
    }

    private static SecretKeySpec O00000Oo(String str) {
        byte[] bytes;
        if (str == null) {
            str = "";
        }
        StringBuffer stringBuffer = new StringBuffer(16);
        while (true) {
            stringBuffer.append(str);
            if (stringBuffer.length() >= 16) {
                break;
            }
            str = "0";
        }
        if (stringBuffer.length() > 16) {
            stringBuffer.setLength(16);
        }
        try {
            bytes = stringBuffer.toString().getBytes(HttpUtils.ENCODING_UTF_8);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "Encrypt", "createKey");
            bytes = null;
        }
        return new SecretKeySpec(bytes, "AES");
    }

    public static synchronized byte[] O00000Oo(byte[] bArr, String str) throws Exception {
        synchronized (O0OOO0.class) {
            PrivateKey generatePrivate = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(oOo00.O00000Oo(str)));
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(2, generatePrivate);
            int length = bArr.length;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i = 0;
            int i2 = i;
            while (true) {
                int i3 = length - i;
                if (i3 > 0) {
                    byte[] doFinal = i3 > 256 ? instance.doFinal(bArr, i, 256) : instance.doFinal(bArr, i, i3);
                    byteArrayOutputStream.write(doFinal, 0, doFinal.length);
                    i2++;
                    i = i2 * 256;
                } else {
                    bArr = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                }
            }
        }
        return bArr;
    }

    public static byte[] O00000o(byte[] bArr, String str) {
        try {
            SecretKeySpec O00000Oo = O00000Oo(str);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(OO0o000.O00000o0());
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, O00000Oo, ivParameterSpec);
            return instance.doFinal(bArr);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "Encrypt", "aesDecrypt");
            return null;
        }
    }

    public static byte[] O00000o0(byte[] bArr, String str) {
        try {
            SecretKeySpec O00000Oo = O00000Oo(str);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(OO0o000.O00000o0());
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(1, O00000Oo, ivParameterSpec);
            return instance.doFinal(bArr);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "Encrypt", "aesEncrypt");
            return null;
        }
    }
}
