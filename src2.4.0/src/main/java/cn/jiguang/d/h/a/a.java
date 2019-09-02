package cn.jiguang.d.h.a;

import android.support.v4.view.ViewCompat;
import android.util.Base64;
import cn.jiguang.d.a.d;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class a {
    private static String a = "";
    private static int b;

    public static String a() {
        return a((long) c());
    }

    public static String a(long j) {
        long j2;
        long j3;
        switch (((int) j) % 10) {
            case 1:
                j2 = 5 * j;
                j3 = 88;
                break;
            case 2:
                j2 = 23 * j;
                j3 = 15;
                break;
            case 3:
                j2 = 3 * j;
                j3 = 73;
                break;
            case 4:
                j2 = 13 * j;
                j3 = 96;
                break;
            case 5:
                j2 = 17 * j;
                j3 = 49;
                break;
            case 6:
                j2 = 7 * j;
                j3 = 68;
                break;
            case 7:
                j2 = 31 * j;
                j3 = 39;
                break;
            case 8:
                j2 = 29 * j;
                j3 = 41;
                break;
            case 9:
                j2 = 37 * j;
                j3 = 91;
                break;
            default:
                j2 = 8 * j;
                j3 = 74;
                break;
        }
        j3 = j2 + (j % j3);
        StringBuilder stringBuilder = new StringBuilder("JCKP");
        stringBuilder.append(String.valueOf(j3));
        return cn.jiguang.g.a.a(stringBuilder.toString());
    }

    public static String a(String str) {
        try {
            String str2 = "DFA84B10B7ACDD25";
            if (str2.length() != 16) {
                str = null;
            } else {
                byte[] c = c(str2, "ASCII");
                Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
                instance.init(1, new SecretKeySpec(c, "AES"), a(c));
                str = Base64.encodeToString(instance.doFinal(str.getBytes()), 2);
            }
            return str;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String a(String str, String str2) {
        if (str2 == null) {
            return null;
        }
        try {
            if (str2.length() != 16) {
                return null;
            }
            byte[] c = c(str2, "ASCII");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, new SecretKeySpec(c, "AES"), a(c));
            return new String(instance.doFinal(Base64.decode(str, 2)));
        } catch (Exception unused) {
            return null;
        }
    }

    private static IvParameterSpec a(byte[] bArr) {
        try {
            return (IvParameterSpec) cn.jiguang.f.a.a(IvParameterSpec.class, new Object[]{bArr}, new Class[]{byte[].class});
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void a(int i) {
        b = i;
    }

    public static byte[] a(String str, byte[] bArr) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(c(str, "utf-8"), "AES");
        Cipher instance = Cipher.getInstance("AES/ECB/PKCS7Padding");
        instance.init(1, secretKeySpec);
        return instance.doFinal(bArr);
    }

    public static byte[] a(byte[] bArr, int i) {
        long c;
        byte[] bArr2;
        Exception e;
        int length = bArr.length - 24;
        byte[] bArr3 = new byte[24];
        byte[] bArr4 = new byte[length];
        System.arraycopy(bArr, 0, bArr3, 0, 24);
        System.arraycopy(bArr, 24, bArr4, 0, length);
        String str = "";
        if (i == 1) {
            c = d.c(null);
        } else {
            if (i == 0) {
                c = (long) b;
            }
            bArr = a(str, bArr4);
            i = bArr.length + 24;
            bArr2 = new byte[i];
            try {
                System.arraycopy(bArr3, 0, bArr2, 0, 24);
                System.arraycopy(bArr, 0, bArr2, 24, bArr.length);
                bArr2[0] = (byte) ((i >>> 8) & 255);
                bArr2[1] = (byte) (i & 255);
                bArr2[0] = (byte) (bArr2[0] | 128);
                return bArr2;
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return bArr2;
            }
        }
        str = b(c);
        try {
            bArr = a(str, bArr4);
            i = bArr.length + 24;
            bArr2 = new byte[i];
            System.arraycopy(bArr3, 0, bArr2, 0, 24);
            System.arraycopy(bArr, 0, bArr2, 24, bArr.length);
            bArr2[0] = (byte) ((i >>> 8) & 255);
            bArr2[1] = (byte) (i & 255);
            bArr2[0] = (byte) (bArr2[0] | 128);
            return bArr2;
        } catch (Exception e3) {
            e = e3;
            bArr2 = null;
            e.printStackTrace();
            return bArr2;
        }
    }

    public static byte[] a(byte[] bArr, String str, String str2) {
        if (str == null) {
            return null;
        }
        byte[] c = c(str, "utf-8");
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(1, new SecretKeySpec(c, "AES"), a(str2.getBytes("utf-8")));
        return instance.doFinal(bArr);
    }

    public static String b() {
        return a;
    }

    private static String b(long j) {
        long j2;
        long j3;
        String valueOf = String.valueOf(j);
        int length = valueOf.length();
        if (length >= 2) {
            valueOf = valueOf.substring(length - 2, length);
        }
        switch (Integer.parseInt(valueOf) % 10) {
            case 1:
                j2 = 5 * j;
                j3 = 88;
                break;
            case 2:
                j2 = 23 * j;
                j3 = 15;
                break;
            case 3:
                j2 = 3 * j;
                j3 = 73;
                break;
            case 4:
                j2 = 13 * j;
                j3 = 96;
                break;
            case 5:
                j2 = 17 * j;
                j3 = 49;
                break;
            case 6:
                j2 = 7 * j;
                j3 = 68;
                break;
            case 7:
                j2 = 31 * j;
                j3 = 39;
                break;
            case 8:
                j2 = 29 * j;
                j3 = 41;
                break;
            case 9:
                j2 = 37 * j;
                j3 = 91;
                break;
            default:
                j2 = 8 * j;
                j3 = 74;
                break;
        }
        j3 = j2 + (j % j3);
        StringBuilder stringBuilder = new StringBuilder("JCKP");
        stringBuilder.append(String.valueOf(j3));
        String a = cn.jiguang.g.a.a(stringBuilder.toString());
        a = a;
        return a;
    }

    public static String b(String str, String str2) {
        try {
            return a(str, "DFA84B10B7ACDD25");
        } catch (Exception unused) {
            return str2;
        }
    }

    public static byte[] b(String str, byte[] bArr) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(c(str, "utf-8"), "AES");
        Cipher instance = Cipher.getInstance("AES/ECB/NoPadding");
        instance.init(2, secretKeySpec);
        return instance.doFinal(bArr);
    }

    public static int c() {
        return Math.abs(new SecureRandom().nextInt()) & ViewCompat.MEASURED_SIZE_MASK;
    }

    private static byte[] c(String str, String str2) {
        byte[] bArr = new byte[str.length()];
        byte[] bytes = str.substring(0, str.length() / 2).getBytes(str2);
        byte[] bytes2 = str.substring(str.length() / 2).getBytes(str2);
        System.arraycopy(bytes, 0, bArr, 0, bytes.length);
        System.arraycopy(bytes2, 0, bArr, bytes.length, bytes2.length);
        return bArr;
    }
}
