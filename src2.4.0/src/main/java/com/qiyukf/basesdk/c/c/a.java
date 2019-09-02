package com.qiyukf.basesdk.c.c;

public final class a {
    private static final char[] a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final int[] b = new int[]{60, 56, 52, 48, 44, 40, 36, 32, 28, 24, 20, 16, 12, 8, 4, 0};

    private static int a(char c) {
        if (c >= '0' && c <= '9') {
            return c - 48;
        }
        int i = 97;
        if (c < 'a' || c > 'f') {
            i = 65;
            if (c < 'A' || c > 'F') {
                return -1;
            }
        }
        return (c - i) + 10;
    }

    private static String a(byte b) {
        long j = (long) b;
        StringBuilder stringBuilder = new StringBuilder(2);
        for (int i = 0; i < 2; i++) {
            stringBuilder.append(a[(int) ((j >> b[i + 14]) & 15)]);
        }
        return stringBuilder.toString();
    }

    public static String a(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte a : bArr) {
            stringBuilder.append(a(a));
        }
        return stringBuilder.toString();
    }

    public static byte[] a(String str) {
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = 2 * i;
            int a = a(str.charAt(i2));
            i2 = a(str.charAt(i2 + 1));
            if (a == -1 || i2 == -1) {
                return null;
            }
            bArr[i] = (byte) ((a << 4) + i2);
        }
        return bArr;
    }
}
