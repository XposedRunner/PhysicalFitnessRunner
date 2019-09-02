package com.baidu.location;

import cn.jiguang.net.HttpUtils;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;

public class Jni {
    private static int a = 0;
    private static int b = 1;
    private static int c = 2;
    private static int d = 11;
    private static int e = 12;
    private static int f = 13;
    private static int g = 14;
    private static int h = 15;
    private static int i = 1024;
    private static boolean j = true;

    static {
        try {
            System.loadLibrary("locSDK7b");
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        }
    }

    private static native String a(byte[] bArr, int i);

    private static native String b(double d, double d2, int i, int i2);

    private static native String c(byte[] bArr, int i);

    public static double[] coorEncrypt(double d, double d2, String str) {
        double[] dArr = new double[]{0.0d, 0.0d};
        if (j) {
            return dArr;
        }
        int i = -1;
        if (str.equals(BDLocation.BDLOCATION_GCJ02_TO_BD09)) {
            i = a;
        } else if (str.equals("bd09ll")) {
            i = b;
        } else if (str.equals(CoordinateType.GCJ02)) {
            i = c;
        } else if (str.equals(BDLocation.BDLOCATION_WGS84_TO_GCJ02)) {
            i = d;
        } else if (str.equals(BDLocation.BDLOCATION_BD09_TO_GCJ02)) {
            i = e;
        } else if (str.equals(BDLocation.BDLOCATION_BD09LL_TO_GCJ02)) {
            i = f;
        } else if (str.equals("wgs842mc")) {
            i = h;
        }
        if (str.equals("gcj2wgs")) {
            i = 16;
        }
        try {
            String[] split = b(d, d2, i, 132456).split(":");
            dArr[0] = Double.parseDouble(split[0]);
            dArr[1] = Double.parseDouble(split[1]);
        } catch (UnsatisfiedLinkError unused) {
        }
        return dArr;
    }

    private static native String ee(String str, int i);

    public static String en1(String str) {
        if (j) {
            return "err!";
        }
        if (str == null) {
            return "null";
        }
        byte[] bytes = str.getBytes();
        byte[] bArr = new byte[i];
        int i = 740;
        int length = bytes.length;
        if (length <= 740) {
            i = length;
        }
        length = 0;
        int i2 = 0;
        while (length < i) {
            if (bytes[length] != (byte) 0) {
                bArr[i2] = bytes[length];
                i2++;
            }
            length++;
        }
        try {
            return a(bArr, 132456);
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            return "err!";
        }
    }

    public static String encode(String str) {
        if (j) {
            return "err!";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(en1(str));
        stringBuilder.append("|tp=3");
        return stringBuilder.toString();
    }

    public static String encode2(String str) {
        if (j) {
            return "err!";
        }
        if (str == null) {
            return "null";
        }
        try {
            return c(str.getBytes(), 132456);
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            return "err!";
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0014 */
    /* JADX WARNING: Failed to process nested try/catch */
    public static java.lang.Long encode3(java.lang.String r4) {
        /*
        r0 = j;
        r1 = 0;
        if (r0 == 0) goto L_0x0006;
    L_0x0005:
        return r1;
    L_0x0006:
        r0 = "";
        r2 = new java.lang.String;	 Catch:{ Exception -> 0x0014 }
        r4 = r4.getBytes();	 Catch:{ Exception -> 0x0014 }
        r3 = "UTF-8";
        r2.<init>(r4, r3);	 Catch:{ Exception -> 0x0014 }
        r0 = r2;
    L_0x0014:
        r2 = murmur(r0);	 Catch:{ UnsatisfiedLinkError -> 0x001d }
        r4 = java.lang.Long.valueOf(r2);	 Catch:{ UnsatisfiedLinkError -> 0x001d }
        return r4;
    L_0x001d:
        r4 = move-exception;
        r4.printStackTrace();
        r4 = r1;
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.Jni.encode3(java.lang.String):java.lang.Long");
    }

    private static native String encodeNotLimit(String str, int i);

    public static String encodeOfflineLocationUpdateRequest(String str) {
        if (j) {
            return "err!";
        }
        String str2 = "";
        try {
            str2 = new String(str.getBytes(), HttpUtils.ENCODING_UTF_8);
        } catch (Exception unused) {
        }
        try {
            str = encodeNotLimit(str2, 132456);
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            str = "err!";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("|tp=3");
        return stringBuilder.toString();
    }

    public static String encodeTp4(String str) {
        if (j) {
            return "err!";
        }
        String str2 = "";
        try {
            str2 = new String(str.getBytes(), HttpUtils.ENCODING_UTF_8);
        } catch (Exception unused) {
        }
        try {
            str = ee(str2, 132456);
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            str = "err!";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("|tp=4");
        return stringBuilder.toString();
    }

    public static double getGpsSwiftRadius(float f, double d, double d2) {
        if (j) {
            return 0.0d;
        }
        try {
            return gsr(f, d, d2);
        } catch (UnsatisfiedLinkError unused) {
            return 0.0d;
        }
    }

    private static native double gsr(float f, double d, double d2);

    private static native long murmur(String str);
}
