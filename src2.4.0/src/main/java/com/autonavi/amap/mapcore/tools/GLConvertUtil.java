package com.autonavi.amap.mapcore.tools;

import cn.jiguang.net.HttpUtils;
import java.io.ByteArrayOutputStream;

public class GLConvertUtil {
    public static double convertDouble(byte[] bArr, int i) {
        long j = 0;
        int i2 = 0;
        while (i2 < 8) {
            i2++;
            j += ((long) (bArr[i2 + i] & 255)) << (8 * i2);
        }
        return Double.longBitsToDouble(j);
    }

    public static byte[] convertInt(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 24) & 255)};
    }

    public static byte[] convertShort(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255)};
    }

    public static byte[] get1BString(String str) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(new byte[]{(byte) str.getBytes(HttpUtils.ENCODING_UTF_8).length});
            byteArrayOutputStream.write(r5);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return new byte[1];
        }
    }

    public static int getInt(byte[] bArr, int i) {
        return ((((bArr[3 + i] & 255) << 24) + ((bArr[2 + i] & 255) << 16)) + ((bArr[1 + i] & 255) << 8)) + ((bArr[i + 0] & 255) << 0);
    }

    public static int getInt2(byte[] bArr, int i) {
        return ((((bArr[0 + i] & 255) << 24) + ((bArr[1 + i] & 255) << 16)) + ((bArr[2 + i] & 255) << 8)) + ((bArr[3 + i] & 255) << 0);
    }

    public static long getLong(byte[] bArr, int i) {
        return (((((((((long) (bArr[7 + i] & 255)) << 56) + (((long) (bArr[6 + i] & 255)) << 48)) + (((long) (bArr[5 + i] & 255)) << 40)) + (((long) (bArr[4 + i] & 255)) << 32)) + (((long) (bArr[3 + i] & 255)) << 24)) + (((long) (bArr[2 + i] & 255)) << 16)) + (((long) (bArr[1 + i] & 255)) << 8)) + (((long) (bArr[0 + i] & 255)) << 0);
    }

    public static short getShort(byte[] bArr, int i) {
        return (short) (((bArr[i + 1] & 255) << 8) + ((bArr[i + 0] & 255) << 0));
    }

    public static short getShort2(byte[] bArr, int i) {
        return (short) (((bArr[i + 0] & 255) << 8) + ((bArr[i + 1] & 255) << 0));
    }

    public static String getString(byte[] bArr, int i, int i2) {
        try {
            return new String(bArr, i, i2, HttpUtils.ENCODING_UTF_8);
        } catch (Exception unused) {
            return "";
        }
    }

    public static byte[] getSubBytes(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    public static int getUShort(byte[] bArr, int i) {
        return ((bArr[i + 1] & 255) << 8) + ((bArr[i + 0] & 255) << 0);
    }

    public static void moveArray(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        byte[] bArr3 = new byte[i3];
        System.arraycopy(bArr, i, bArr3, 0, i3);
        System.arraycopy(bArr3, 0, bArr2, i2, i3);
    }

    public static void writeInt(byte[] bArr, int i, int i2) {
        System.arraycopy(convertInt(i2), 0, bArr, i, 4);
    }

    public static void writeShort(byte[] bArr, int i, short s) {
        System.arraycopy(convertShort(s), 0, bArr, i, 2);
    }
}
