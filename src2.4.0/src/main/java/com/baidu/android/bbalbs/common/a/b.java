package com.baidu.android.bbalbs.common.a;

import android.support.v4.view.MotionEventCompat;
import java.io.UnsupportedEncodingException;

public final class b {
    private static final byte[] a = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 43, (byte) 47};

    public static String a(byte[] bArr, String str) throws UnsupportedEncodingException {
        int length = (bArr.length * 4) / 3;
        byte[] bArr2 = new byte[(length + ((length / 76) + 3))];
        int length2 = bArr.length - (bArr.length % 3);
        int i = 0;
        int i2 = i;
        int i3 = i2;
        while (i < length2) {
            int i4 = i2 + 1;
            bArr2[i2] = a[(bArr[i] & 255) >> 2];
            i2 = i4 + 1;
            int i5 = i + 1;
            bArr2[i4] = a[((bArr[i] & 3) << 4) | ((bArr[i5] & 255) >> 4)];
            i4 = i2 + 1;
            i5 = i + 2;
            bArr2[i2] = a[((bArr[i5] & 15) << 2) | ((bArr[i5] & 255) >> 6)];
            i2 = i4 + 1;
            bArr2[i4] = a[bArr[i5] & 63];
            if ((i2 - i3) % 76 == 0 && i2 != 0) {
                i4 = i2 + 1;
                bArr2[i2] = (byte) 10;
                i3++;
                i2 = i4;
            }
            i += 3;
        }
        switch (bArr.length % 3) {
            case 1:
                i3 = i2 + 1;
                bArr2[i2] = a[(bArr[length2] & 255) >> 2];
                i2 = i3 + 1;
                bArr2[i3] = a[(bArr[length2] & 3) << 4];
                int i6 = i2 + 1;
                bArr2[i2] = (byte) 61;
                i2 = i6 + 1;
                bArr2[i6] = (byte) 61;
                break;
            case 2:
                i3 = i2 + 1;
                bArr2[i2] = a[(bArr[length2] & 255) >> 2];
                i2 = i3 + 1;
                length2++;
                bArr2[i3] = a[((bArr[length2] & 3) << 4) | ((bArr[length2] & 255) >> 4)];
                i3 = i2 + 1;
                bArr2[i2] = a[(bArr[length2] & 15) << 2];
                i2 = i3 + 1;
                bArr2[i3] = (byte) 61;
                break;
        }
        return new String(bArr2, 0, i2, str);
    }

    public static byte[] a(byte[] bArr) {
        return a(bArr, bArr.length);
    }

    public static byte[] a(byte[] bArr, int i) {
        int i2 = (i / 4) * 3;
        if (i2 == 0) {
            return new byte[0];
        }
        byte b;
        byte[] bArr2 = new byte[i2];
        int i3 = i;
        int i4 = 0;
        while (true) {
            byte b2 = bArr[i3 - 1];
            b = (byte) 10;
            if (!(b2 == (byte) 10 || b2 == (byte) 13 || b2 == (byte) 32 || b2 == (byte) 9)) {
                if (b2 != (byte) 61) {
                    break;
                }
                i4++;
            }
            i3--;
        }
        int i5 = 0;
        int i6 = i5;
        int i7 = i6;
        int i8 = i7;
        while (i5 < i3) {
            byte b3 = bArr[i5];
            if (!(b3 == b || b3 == (byte) 13 || b3 == (byte) 32 || b3 == (byte) 9)) {
                int i9;
                if (b3 >= (byte) 65 && b3 <= (byte) 90) {
                    i9 = b3 - 65;
                } else if (b3 >= (byte) 97 && b3 <= (byte) 122) {
                    i9 = b3 - 71;
                } else if (b3 >= (byte) 48 && b3 <= (byte) 57) {
                    i9 = b3 + 4;
                } else if (b3 == (byte) 43) {
                    i9 = 62;
                } else if (b3 != (byte) 47) {
                    return null;
                } else {
                    i9 = 63;
                }
                i9 = ((byte) i9) | (i6 << 6);
                if (i8 % 4 == 3) {
                    int i10 = i7 + 1;
                    bArr2[i7] = (byte) ((i9 & 16711680) >> 16);
                    i6 = i10 + 1;
                    bArr2[i10] = (byte) ((i9 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8);
                    i7 = i6 + 1;
                    bArr2[i6] = (byte) (i9 & 255);
                }
                i8++;
                i6 = i9;
            }
            i5++;
            b = (byte) 10;
        }
        if (i4 > 0) {
            int i11 = i6 << (6 * i4);
            i3 = i7 + 1;
            bArr2[i7] = (byte) ((i11 & 16711680) >> 16);
            if (i4 == 1) {
                i7 = i3 + 1;
                bArr2[i3] = (byte) ((i11 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8);
            } else {
                i7 = i3;
            }
        }
        byte[] bArr3 = new byte[i7];
        System.arraycopy(bArr2, 0, bArr3, 0, i7);
        return bArr3;
    }
}
