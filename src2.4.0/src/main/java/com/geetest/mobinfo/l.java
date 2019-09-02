package com.geetest.mobinfo;

import android.support.v4.media.TransportMediator;
import com.bangcle.andJni.JniLib1557756502;

/* compiled from: Base64Coder */
public class l {
    private static final char[] a = new char[64];
    private static final byte[] b = new byte[128];

    static {
        int i;
        int i2 = 0;
        char c = 'A';
        int i3 = 0;
        while (c <= 'Z') {
            i = i3 + 1;
            a[i3] = c;
            c = (char) (c + 1);
            i3 = i;
        }
        c = 'a';
        while (c <= 'z') {
            i = i3 + 1;
            a[i3] = c;
            c = (char) (c + 1);
            i3 = i;
        }
        c = '0';
        while (c <= '9') {
            i = i3 + 1;
            a[i3] = c;
            c = (char) (c + 1);
            i3 = i;
        }
        int i4 = i3 + 1;
        a[i3] = '+';
        a[i4] = '/';
        for (int i5 = 0; i5 < b.length; i5++) {
            b[i5] = (byte) -1;
        }
        while (i2 < 64) {
            b[a[i2]] = (byte) i2;
            i2++;
        }
    }

    public static String a(String str) {
        return (String) JniLib1557756502.cL(str, Integer.valueOf(132));
    }

    private static byte[] a(char[] cArr) {
        int length = cArr.length;
        if (length % 4 != 0) {
            throw new IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
        }
        while (length > 0 && cArr[length - 1] == '=') {
            length--;
        }
        int i = (length * 3) / 4;
        byte[] bArr = new byte[i];
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4;
            int i5 = i2 + 1;
            char c = cArr[i2];
            int i6 = i5 + 1;
            char c2 = cArr[i5];
            int i7 = 65;
            if (i6 < length) {
                i4 = i6 + 1;
                i6 = cArr[i6];
            } else {
                i4 = i6;
                i6 = 65;
            }
            if (i4 < length) {
                i7 = i4 + 1;
                char c3 = cArr[i4];
                i4 = i7;
                i7 = c3;
            }
            if (c > 127 || c2 > 127 || i6 > TransportMediator.KEYCODE_MEDIA_PAUSE || i7 > TransportMediator.KEYCODE_MEDIA_PAUSE) {
                throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
            }
            byte b = b[c];
            byte b2 = b[c2];
            byte b3 = b[i6];
            byte b4 = b[i7];
            if (b < (byte) 0 || b2 < (byte) 0 || b3 < (byte) 0 || b4 < (byte) 0) {
                throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
            }
            i2 = (b << 2) | (b2 >>> 4);
            i5 = ((b2 & 15) << 4) | (b3 >>> 2);
            i6 = ((b3 & 3) << 6) | b4;
            i7 = i3 + 1;
            bArr[i3] = (byte) i2;
            if (i7 < i) {
                i2 = i7 + 1;
                bArr[i7] = (byte) i5;
            } else {
                i2 = i7;
            }
            if (i2 < i) {
                i3 = i2 + 1;
                bArr[i2] = (byte) i6;
            } else {
                i3 = i2;
            }
            i2 = i4;
        }
        return bArr;
    }

    private static char[] a(byte[] bArr) {
        return (char[]) JniLib1557756502.cL(bArr, Integer.valueOf(133));
    }

    private static char[] a(byte[] bArr, int i) {
        int i2 = ((i * 4) + 2) / 3;
        char[] cArr = new char[(((i + 2) / 3) * 4)];
        int i3 = 0;
        int i4 = i3;
        while (i3 < i) {
            int i5;
            int i6;
            int i7 = i3 + 1;
            i3 = bArr[i3] & 255;
            if (i7 < i) {
                i5 = i7 + 1;
                i7 = bArr[i7] & 255;
            } else {
                i5 = i7;
                i7 = 0;
            }
            if (i5 < i) {
                i6 = i5 + 1;
                i5 = bArr[i5] & 255;
            } else {
                i6 = i5;
                i5 = 0;
            }
            int i8 = i3 >>> 2;
            i3 = ((i3 & 3) << 4) | (i7 >>> 4);
            i7 = ((i7 & 15) << 2) | (i5 >>> 6);
            i5 &= 63;
            int i9 = i4 + 1;
            cArr[i4] = a[i8];
            i4 = i9 + 1;
            cArr[i9] = a[i3];
            char c = '=';
            cArr[i4] = i4 < i2 ? a[i7] : '=';
            i4++;
            if (i4 < i2) {
                c = a[i5];
            }
            cArr[i4] = c;
            i4++;
            i3 = i6;
        }
        return cArr;
    }

    public static String b(String str) {
        return (String) JniLib1557756502.cL(str, Integer.valueOf(134));
    }

    private static byte[] c(String str) {
        return (byte[]) JniLib1557756502.cL(str, Integer.valueOf(135));
    }
}
