package com.umeng.commonsdk.statistics.common;

import com.umeng.commonsdk.proguard.ap;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.security.MessageDigest;
import java.util.Locale;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

public class DataHelper {
    public static long ENVELOPE_ENTITY_RAW_LENGTH_MAX = 2097152;
    public static long ENVELOPE_EXTRA_LENGTH = 1024;
    public static long ENVELOPE_LENGTH_MAX = 204800;
    private static final byte[] iv = new byte[]{(byte) 10, (byte) 1, (byte) 11, (byte) 5, (byte) 4, ap.m, (byte) 7, (byte) 9, (byte) 23, (byte) 3, (byte) 1, (byte) 6, (byte) 8, (byte) 12, ap.k, (byte) 91};

    public static String assembleStatelessURL(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("https://");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public static String assembleURL(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("https://");
        stringBuilder.append(str);
        stringBuilder.append("/unify_logs");
        return stringBuilder.toString();
    }

    static String bytes2Hex(byte[] bArr) {
        String str = "";
        for (byte b : bArr) {
            StringBuilder stringBuilder;
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() == 1) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append("0");
                str = stringBuilder.toString();
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(toHexString);
            str = stringBuilder.toString();
        }
        return str;
    }

    public static String convertExceptionToString(Throwable th) {
        if (th == null) {
            return null;
        }
        String obj;
        try {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            for (th = th.getCause(); th != null; th = th.getCause()) {
                th.printStackTrace(printWriter);
            }
            obj = stringWriter.toString();
            try {
                printWriter.close();
                stringWriter.close();
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            obj = null;
        }
        return obj;
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2) throws Exception {
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
        instance.init(2, new SecretKeySpec(bArr2, "AES"), new IvParameterSpec(iv));
        return instance.doFinal(bArr);
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2) throws Exception {
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
        instance.init(1, new SecretKeySpec(bArr2, "AES"), new IvParameterSpec(iv));
        return instance.doFinal(bArr);
    }

    public static String encryptBySHA1(String str) {
        byte[] bytes = str.getBytes();
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA1");
            instance.update(bytes);
            return bytes2Hex(instance.digest());
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] hash(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.reset();
            instance.update(bArr);
            return instance.digest();
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean largeThanMaxSize(long j, long j2) {
        return j > j2;
    }

    public static int random(int i, String str) {
        if (((double) new Random().nextFloat()) < 0.001d) {
            i = 0;
            if (str == null) {
                MLog.e("--->", "null signature..");
            }
            try {
                i = Integer.parseInt(str.substring(9, 11), 16);
            } catch (Exception unused) {
            }
            return (i | 128) * 1000;
        }
        i = new Random().nextInt(i);
        return (i > 255000 || i < 128000) ? i : 127000;
    }

    public static byte[] reverseHexString(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length % 2 != 0) {
            return null;
        }
        byte[] bArr = new byte[(length / 2)];
        int i = 0;
        while (i < length) {
            int i2 = i + 2;
            bArr[i / 2] = (byte) Integer.valueOf(str.substring(i, i2), 16).intValue();
            i = i2;
        }
        return bArr;
    }

    public static String toHexString(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bArr.length; i++) {
            stringBuffer.append(String.format("%02X", new Object[]{Byte.valueOf(bArr[i])}));
        }
        return stringBuffer.toString().toLowerCase(Locale.US);
    }
}
