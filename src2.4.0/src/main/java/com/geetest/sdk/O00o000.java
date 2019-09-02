package com.geetest.sdk;

/* compiled from: GT3Base64Util */
public final class O00o000 {
    private static char[] O000000o = new char[64];
    private static byte[] O00000Oo = new byte[128];

    static {
        int i;
        int i2 = 0;
        char c = 'A';
        int i3 = 0;
        while (c <= 'Z') {
            i = i3 + 1;
            O000000o[i3] = c;
            c = (char) (c + 1);
            i3 = i;
        }
        c = 'a';
        while (c <= 'z') {
            i = i3 + 1;
            O000000o[i3] = c;
            c = (char) (c + 1);
            i3 = i;
        }
        c = '0';
        while (c <= '9') {
            i = i3 + 1;
            O000000o[i3] = c;
            c = (char) (c + 1);
            i3 = i;
        }
        int i4 = i3 + 1;
        O000000o[i3] = '(';
        O000000o[i4] = ')';
        for (int i5 = 0; i5 < O00000Oo.length; i5++) {
            O00000Oo[i5] = (byte) -1;
        }
        while (i2 < 64) {
            O00000Oo[O000000o[i2]] = (byte) i2;
            i2++;
        }
    }

    public static char[] O000000o(byte[] bArr) {
        int length = bArr.length;
        int i = ((length << 2) + 2) / 3;
        char[] cArr = new char[(((length + 2) / 3) << 2)];
        int i2 = 0;
        int i3 = i2;
        while (i2 < length) {
            int i4;
            int i5;
            int i6 = i2 + 1;
            i2 = bArr[i2] & 255;
            if (i6 < length) {
                i4 = i6 + 1;
                i6 = bArr[i6] & 255;
            } else {
                i4 = i6;
                i6 = 0;
            }
            if (i4 < length) {
                i5 = i4 + 1;
                i4 = bArr[i4] & 255;
            } else {
                i5 = i4;
                i4 = 0;
            }
            int i7 = ((i2 & 96) >>> 1) | (i2 & 15);
            i2 = ((((i2 & 16) | ((i2 & 128) >>> 2)) | ((i6 & 128) >>> 4)) | ((i6 & 48) >>> 3)) | ((i6 & 4) >>> 2);
            i6 = ((((i6 & 3) << 2) | (((i6 & 64) >>> 1) | ((i6 & 8) << 1))) | ((i4 & 16) >>> 3)) | ((i4 & 4) >>> 2);
            i4 = (i4 & 3) | (((i4 & 224) >>> 2) | ((i4 & 8) >> 1));
            int i8 = i3 + 1;
            cArr[i3] = O000000o[i7];
            i3 = i8 + 1;
            cArr[i8] = O000000o[i2];
            char c = '.';
            cArr[i3] = i3 < i ? O000000o[i6] : '.';
            i3++;
            if (i3 < i) {
                c = O000000o[i4];
            }
            cArr[i3] = c;
            i3++;
            i2 = i5;
        }
        return cArr;
    }
}
