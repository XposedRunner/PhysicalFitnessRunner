package com.geetest.sdk;

import android.text.TextUtils;
import android.util.Log;

/* compiled from: GT3HMAC_SHA1 */
public final class O00o0 {
    private final int[] O000000o = new int[]{1732584193, -271733879, -1732584194, 271733878, -1009589776};
    private final int[] O00000Oo = new int[5];
    private final int[] O00000o0 = new int[80];

    private static int O000000o(int i, int i2) {
        return (i >>> (32 - i2)) | (i << i2);
    }

    public static byte[] O000000o(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            Log.d("HMAC_SHA1", "when getHmacSHA1,the key is null");
            return null;
        }
        byte[] bArr = new byte[64];
        byte[] bArr2 = new byte[64];
        byte[] bArr3 = new byte[64];
        int length = str2.length();
        O00o0 o00o0 = new O00o0();
        int i = 0;
        byte[] O000000o;
        if (str2.length() > 64) {
            O000000o = o00o0.O000000o(O00o.O000000o(str2));
            for (length = 0; length < 20; length++) {
                bArr3[length] = O000000o[length];
            }
            length = 20;
        } else {
            O000000o = O00o.O000000o(str2);
            for (int i2 = 0; i2 < O000000o.length; i2++) {
                bArr3[i2] = O000000o[i2];
            }
        }
        while (length < 64) {
            bArr3[length] = (byte) 0;
            length++;
        }
        while (i < 64) {
            bArr[i] = (byte) (bArr3[i] ^ 54);
            bArr2[i] = (byte) (bArr3[i] ^ 92);
            i++;
        }
        return o00o0.O000000o(O000000o(bArr2, o00o0.O000000o(O000000o(bArr, O00o.O000000o(str)))));
    }

    private byte[] O000000o(byte[] bArr) {
        int i;
        Object obj = bArr;
        int i2 = 63;
        int i3 = 0;
        System.arraycopy(this.O000000o, 0, this.O00000Oo, 0, this.O000000o.length);
        int length = obj.length;
        int i4 = length % 64;
        if (i4 < 56) {
            i2 = 55 - i4;
            i4 = (length - i4) + 64;
        } else if (i4 == 56) {
            i4 = (length + 8) + 64;
        } else {
            i2 = (63 - i4) + 56;
            i4 = ((length + 64) - i4) + 64;
        }
        byte[] bArr2 = new byte[i4];
        System.arraycopy(obj, 0, bArr2, 0, length);
        int i5 = length + 1;
        bArr2[length] = Byte.MIN_VALUE;
        int i6 = i5;
        i5 = 0;
        while (i5 < i2) {
            i = i6 + 1;
            bArr2[i6] = (byte) 0;
            i5++;
            i6 = i;
        }
        long j = ((long) length) << 3;
        byte b = (byte) ((int) ((j >> 8) & 255));
        byte b2 = (byte) ((int) ((j >> 24) & 255));
        byte b3 = (byte) ((int) ((j >> 32) & 255));
        byte b4 = (byte) ((int) (j & 255));
        byte b5 = (byte) ((int) ((j >> 16) & 255));
        byte b6 = (byte) ((int) ((j >> 40) & 255));
        byte b7 = (byte) ((int) ((j >> 48) & 255));
        length = i6 + 1;
        bArr2[i6] = (byte) ((int) (j >> 56));
        i5 = length + 1;
        bArr2[length] = b7;
        length = i5 + 1;
        bArr2[i5] = b6;
        i5 = length + 1;
        bArr2[length] = b3;
        length = i5 + 1;
        bArr2[i5] = b2;
        i5 = length + 1;
        bArr2[length] = b5;
        length = i5 + 1;
        bArr2[i5] = b;
        bArr2[length] = b4;
        i5 = bArr2.length / 64;
        for (length = 0; length < i5; length++) {
            int i7;
            int[] iArr;
            int O000000o;
            int i8;
            int O000000o2;
            i6 = 0;
            i2 = 16;
            while (i6 < i2) {
                i7 = (length << 6) + (i6 << 2);
                this.O00000o0[i6] = (bArr2[i7 + 3] & 255) | ((((bArr2[i7] & 255) << 24) | ((bArr2[i7 + 1] & 255) << 16)) | ((bArr2[i7 + 2] & 255) << 8));
                i6++;
                i2 = 16;
            }
            for (i6 = i2; i6 <= 79; i6++) {
                iArr = this.O00000o0;
                iArr[i6] = O000000o(((iArr[i6 - 3] ^ this.O00000o0[i6 - 8]) ^ this.O00000o0[i6 - 14]) ^ this.O00000o0[i6 - 16], 1);
            }
            iArr = new int[5];
            for (i = 0; i < 5; i++) {
                iArr[i] = this.O00000Oo[i];
            }
            for (i = 0; i <= 19; i++) {
                O000000o = O000000o(iArr[0], 5);
                i8 = iArr[1];
                O000000o = (((O000000o + ((i8 & iArr[2]) | ((i8 ^ -1) & iArr[3]))) + iArr[4]) + this.O00000o0[i]) + 1518500249;
                iArr[4] = iArr[3];
                iArr[3] = iArr[2];
                iArr[2] = O000000o(iArr[1], 30);
                iArr[1] = iArr[0];
                iArr[0] = O000000o;
            }
            for (i = 20; i <= 39; i++) {
                O000000o2 = (((O000000o(iArr[0], 5) + ((iArr[1] ^ iArr[2]) ^ iArr[3])) + iArr[4]) + this.O00000o0[i]) + 1859775393;
                iArr[4] = iArr[3];
                iArr[3] = iArr[2];
                iArr[2] = O000000o(iArr[1], 30);
                iArr[1] = iArr[0];
                iArr[0] = O000000o2;
            }
            for (i = 40; i <= 59; i++) {
                O000000o2 = O000000o(iArr[0], 5);
                O000000o = iArr[1];
                i8 = iArr[2];
                int i9 = iArr[3];
                O000000o2 = (((O000000o2 + (((O000000o & i8) | (O000000o & i9)) | (i8 & i9))) + iArr[4]) + this.O00000o0[i]) - 1894007588;
                iArr[4] = iArr[3];
                iArr[3] = iArr[2];
                iArr[2] = O000000o(iArr[1], 30);
                iArr[1] = iArr[0];
                iArr[0] = O000000o2;
            }
            for (i = 60; i <= 79; i++) {
                O000000o2 = (((O000000o(iArr[0], 5) + ((iArr[1] ^ iArr[2]) ^ iArr[3])) + iArr[4]) + this.O00000o0[i]) - 899497514;
                iArr[4] = iArr[3];
                iArr[3] = iArr[2];
                iArr[2] = O000000o(iArr[1], 30);
                iArr[1] = iArr[0];
                iArr[0] = O000000o2;
            }
            for (i7 = 0; i7 < 5; i7++) {
                int[] iArr2 = this.O00000Oo;
                iArr2[i7] = iArr2[i7] + iArr[i7];
            }
            for (i6 = 0; i6 < this.O00000o0.length; i6++) {
                this.O00000o0[i6] = 0;
            }
        }
        byte[] bArr3 = new byte[20];
        while (i3 < this.O00000Oo.length) {
            length = this.O00000Oo[i3];
            i4 = i3 << 2;
            bArr3[i4] = (byte) (length >>> 24);
            bArr3[i4 + 1] = (byte) (length >>> 16);
            bArr3[i4 + 2] = (byte) (length >>> 8);
            bArr3[i4 + 3] = (byte) length;
            i3++;
        }
        return bArr3;
    }

    private static byte[] O000000o(byte[] bArr, byte[] bArr2) {
        int i = 0;
        byte[] bArr3 = new byte[(bArr2.length + 64)];
        for (int i2 = 0; i2 < 64; i2++) {
            bArr3[i2] = bArr[i2];
        }
        while (i < bArr2.length) {
            bArr3[i + 64] = bArr2[i];
            i++;
        }
        return bArr3;
    }
}
