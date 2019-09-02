package com.ximalaya.ting.android.opensdk.auth.utils;

import java.security.MessageDigest;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: MD5 */
public final class b {
    private static final char[] a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String a(String str) {
        try {
            return a(str.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String a(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.update(bArr);
            bArr = instance.digest();
            char[] cArr = new char[32];
            int i = 0;
            int i2 = 0;
            while (i < 16) {
                byte b = bArr[i];
                int i3 = i2 + 1;
                cArr[i2] = a[(b >>> 4) & 15];
                i2 = i3 + 1;
                cArr[i3] = a[b & 15];
                i++;
            }
            return new String(cArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void a() {
        System.out.println(a("c"));
    }
}
