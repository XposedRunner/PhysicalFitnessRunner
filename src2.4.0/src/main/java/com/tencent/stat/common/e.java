package com.tencent.stat.common;

public class e {
    static final byte[] a = "03a976511e2cbe3a7f26808fb7af3c05".getBytes();

    public static byte[] a(byte[] bArr) {
        return a(bArr, a);
    }

    static byte[] a(byte[] bArr, byte[] bArr2) {
        int[] iArr = new int[256];
        int[] iArr2 = new int[256];
        int length = bArr2.length;
        if (length < 1 || length > 256) {
            throw new IllegalArgumentException("key must be between 1 and 256 bytes");
        }
        int i;
        int i2 = 0;
        for (i = 0; i < 256; i++) {
            iArr[i] = i;
            iArr2[i] = bArr2[i % length];
        }
        int i3 = 0;
        length = i3;
        while (i3 < 256) {
            length = ((length + iArr[i3]) + iArr2[i3]) & 255;
            i = iArr[i3];
            iArr[i3] = iArr[length];
            iArr[length] = i;
            i3++;
        }
        bArr2 = new byte[bArr.length];
        int i4 = 0;
        int i5 = i4;
        while (i2 < bArr.length) {
            i4 = (i4 + 1) & 255;
            i5 = (i5 + iArr[i4]) & 255;
            length = iArr[i4];
            iArr[i4] = iArr[i5];
            iArr[i5] = length;
            bArr2[i2] = (byte) (iArr[(iArr[i4] + iArr[i5]) & 255] ^ bArr[i2]);
            i2++;
        }
        return bArr2;
    }

    public static byte[] b(byte[] bArr) {
        return b(bArr, a);
    }

    static byte[] b(byte[] bArr, byte[] bArr2) {
        return a(bArr, bArr2);
    }
}
