package com.autonavi.amap.mapcore;

import cn.jiguang.net.HttpUtils;
import java.io.ByteArrayOutputStream;

public class Convert {
    public static final String bytesToHexString(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer(bArr.length);
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(255 & b);
            if (toHexString.length() < 2) {
                stringBuffer.append(0);
            }
            stringBuffer.append(toHexString.toUpperCase());
        }
        return stringBuffer.toString();
    }

    public static void convert1bString(byte[] bArr, int i, ConvertString convertString) {
        try {
            convertString.byteLength = bArr[i];
            convertString.value = new String(bArr, i + 1, convertString.byteLength, HttpUtils.ENCODING_UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            convertString.byteLength = 0;
            convertString.value = "";
        }
    }

    public static void convert2bString(byte[] bArr, int i, ConvertString convertString) {
        try {
            convertString.byteLength = getShort(bArr, i);
            convertString.value = new String(bArr, i + 2, convertString.byteLength, HttpUtils.ENCODING_UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            convertString.byteLength = 0;
            convertString.value = "";
        }
    }

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

    public static byte[] copyString(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    public static byte[] covertBytes(byte b) {
        return new byte[]{b};
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

    public static byte[] get2BString(String str) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bytes = str.getBytes(HttpUtils.ENCODING_UTF_8);
            byteArrayOutputStream.write(convertShort(bytes.length));
            byteArrayOutputStream.write(bytes);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return new byte[1];
        }
    }

    public static boolean getBit(byte b, int i) {
        int i2 = 32 - i;
        return (((b << i2) >>> i2) >>> (i - 1)) > 0;
    }

    public static byte[] getDouble(double d) {
        byte[] bArr = new byte[8];
        String toHexString = Long.toHexString(Double.doubleToLongBits(d));
        for (int i = 0; i < 8; i++) {
            int i2 = 2 * i;
            bArr[7 - i] = (byte) Integer.parseInt(toHexString.substring(i2, i2 + 2), 16);
        }
        return bArr;
    }

    public static int getInt(byte[] bArr, int i) {
        return ((((bArr[3 + i] & 255) << 24) + ((bArr[2 + i] & 255) << 16)) + ((bArr[1 + i] & 255) << 8)) + ((bArr[i + 0] & 255) << 0);
    }

    public static int getNum(byte b, int i, int i2) {
        i2 = (32 - i2) - 1;
        return ((b << i2) >>> i2) >>> i;
    }

    public static int getNum(short s, int i, int i2) {
        i2 = 32 - i2;
        return ((s << i2) >>> i2) >>> (i - 1);
    }

    public static short getShort(byte[] bArr, int i) {
        return (short) (((bArr[i + 1] & 255) << 8) + ((bArr[i + 0] & 255) << 0));
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
