package com.amap.api.mapcore.util;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.location.Location;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.support.v4.view.MotionEventCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.SparseArray;
import java.util.Hashtable;
import java.util.Random;
import org.json.JSONObject;

/* compiled from: Utils */
public final class bt {
    static WifiManager O000000o;
    private static int O00000Oo;
    private static Hashtable<String, Long> O00000o = new Hashtable();
    private static String[] O00000o0;
    private static SparseArray<String> O00000oO;
    private static String[] O00000oo = new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};
    private static boolean O0000O0o;

    public static double O000000o(double d) {
        return ((double) ((long) (d * 1000000.0d))) / 1000000.0d;
    }

    public static float O000000o(float f) {
        return (float) (((double) ((long) (((double) f) * 100.0d))) / 100.0d);
    }

    public static float O000000o(double[] dArr) {
        if (dArr.length != 4) {
            return 0.0f;
        }
        float[] fArr = new float[1];
        Location.distanceBetween(dArr[0], dArr[1], dArr[2], dArr[3], fArr);
        return fArr[0];
    }

    public static int O000000o(int i) {
        return -113 + (2 * i);
    }

    public static int O000000o(NetworkInfo networkInfo) {
        return (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected()) ? networkInfo.getType() : -1;
    }

    public static long O000000o() {
        return System.currentTimeMillis();
    }

    public static Object O000000o(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            return context.getApplicationContext().getSystemService(str);
        } catch (Throwable th) {
            bp.O000000o(th, "Utils", "getServ");
            return null;
        }
    }

    public static boolean O000000o(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return O00000o0() < 17 ? O00000Oo(context, "android.provider.Settings$System") : O00000Oo(context, "android.provider.Settings$Global");
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean O000000o(String str) {
        return (TextUtils.isEmpty(str) || "00:00:00:00:00:00".equals(str) || str.contains(" :")) ? false : true;
    }

    public static boolean O000000o(JSONObject jSONObject, String str) {
        return o0OOOO00.O000000o(jSONObject, str);
    }

    public static byte[] O000000o(int i, byte[] bArr) {
        if (bArr == null || bArr.length < 2) {
            bArr = new byte[2];
        }
        bArr[0] = (byte) (255 & i);
        bArr[1] = (byte) ((i & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8);
        return bArr;
    }

    public static byte[] O000000o(long j) {
        byte[] bArr = new byte[8];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) ((int) ((j >> (i * 8)) & 255));
        }
        return bArr;
    }

    public static byte[] O000000o(byte[] bArr) {
        try {
            return o0OOOO00.O00000Oo(bArr);
        } catch (Throwable th) {
            bp.O000000o(th, "Utils", "gz");
            return null;
        }
    }

    public static String[] O000000o(TelephonyManager telephonyManager) {
        int parseInt;
        CharSequence networkOperator = telephonyManager != null ? telephonyManager.getNetworkOperator() : null;
        String[] strArr = new String[]{"0", "0"};
        int i = (!TextUtils.isEmpty(networkOperator) && TextUtils.isDigitsOnly(networkOperator) && networkOperator.length() > 4) ? 1 : 0;
        if (i != 0) {
            strArr[0] = networkOperator.substring(0, 3);
            char[] toCharArray = networkOperator.substring(3).toCharArray();
            int i2 = 0;
            while (i2 < toCharArray.length && Character.isDigit(toCharArray[i2])) {
                i2++;
            }
            strArr[1] = networkOperator.substring(3, i2 + 3);
        }
        try {
            parseInt = Integer.parseInt(strArr[0]);
        } catch (Throwable th) {
            bp.O000000o(th, "Utils", "getMccMnc");
            parseInt = 0;
        }
        if (parseInt == 0) {
            strArr[0] = "0";
        }
        if ("0".equals(strArr[0]) || "0".equals(strArr[1])) {
            if ("0".equals(strArr[0]) && "0".equals(strArr[1]) && O00000o0 != null) {
                strArr = O00000o0;
            }
            return strArr;
        }
        O00000o0 = strArr;
        return strArr;
    }

    public static double O00000Oo(double d) {
        return ((double) ((long) (d * 100.0d))) / 100.0d;
    }

    public static long O00000Oo() {
        return SystemClock.elapsedRealtime();
    }

    public static String O00000Oo(int i) {
        String str = "其他错误";
        switch (i) {
            case 0:
                return "success";
            case 1:
                return "重要参数为空";
            case 2:
                return "WIFI信息不足";
            case 3:
                return "请求参数获取出现异常";
            case 4:
                return "网络连接异常";
            case 5:
                return "解析数据异常";
            case 6:
                return "定位结果错误";
            case 7:
                return "KEY错误";
            case 8:
                return "其他错误";
            case 9:
                return "初始化异常";
            case 10:
                return "定位服务启动失败";
            case 11:
                return "错误的基站信息，请检查是否插入SIM卡";
            case 12:
                return "缺少定位权限";
            case 13:
                return "网络定位失败，请检查设备是否插入sim卡，是否开启移动网络或开启了wifi模块";
            case 14:
                return "GPS 定位失败，由于设备当前 GPS 状态差,建议持设备到相对开阔的露天场所再次尝试";
            case 15:
                return "当前返回位置为模拟软件返回，请关闭模拟软件，或者在option中设置允许模拟";
            case 18:
                return "定位失败，飞行模式下关闭了WIFI开关，请关闭飞行模式或者打开WIFI开关";
            case 19:
                return "定位失败，没有检查到SIM卡，并且关闭了WIFI开关，请打开WIFI开关或者插入SIM卡";
            default:
                return str;
        }
    }

    public static String O00000Oo(Context context) {
        if (!TextUtils.isEmpty(bp.O0000O0o)) {
            return bp.O0000O0o;
        }
        CharSequence charSequence = null;
        if (context == null) {
            return null;
        }
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(o0O0O0Oo.O00000o0(context), 64);
        } catch (Throwable th) {
            bp.O000000o(th, "Utils", "getAppName part");
            packageInfo = null;
        }
        try {
            if (TextUtils.isEmpty(bp.O0000OOo)) {
                bp.O0000OOo = null;
            }
        } catch (Throwable th2) {
            bp.O000000o(th2, "Utils", "getAppName");
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (packageInfo != null) {
            if (packageInfo.applicationInfo != null) {
                charSequence = packageInfo.applicationInfo.loadLabel(context.getPackageManager());
            }
            if (charSequence != null) {
                stringBuilder.append(charSequence.toString());
            }
            if (!TextUtils.isEmpty(packageInfo.versionName)) {
                stringBuilder.append(packageInfo.versionName);
            }
        }
        String O00000o0 = o0O0O0Oo.O00000o0(context);
        if (!TextUtils.isEmpty(O00000o0)) {
            stringBuilder.append(",");
            stringBuilder.append(O00000o0);
        }
        if (!TextUtils.isEmpty(bp.O0000OOo)) {
            stringBuilder.append(",");
            stringBuilder.append(bp.O0000OOo);
        }
        O00000o0 = stringBuilder.toString();
        bp.O0000O0o = O00000o0;
        return O00000o0;
    }

    public static String O00000Oo(TelephonyManager telephonyManager) {
        int i = 0;
        if (O00000oO == null) {
            SparseArray sparseArray = new SparseArray();
            O00000oO = sparseArray;
            sparseArray.append(0, "UNKWN");
            O00000oO.append(1, "GPRS");
            O00000oO.append(2, "EDGE");
            O00000oO.append(3, "UMTS");
            O00000oO.append(4, "CDMA");
            O00000oO.append(5, "EVDO_0");
            O00000oO.append(6, "EVDO_A");
            O00000oO.append(7, "1xRTT");
            O00000oO.append(8, "HSDPA");
            O00000oO.append(9, "HSUPA");
            O00000oO.append(10, "HSPA");
            O00000oO.append(11, "IDEN");
            O00000oO.append(12, "EVDO_B");
            O00000oO.append(13, "LTE");
            O00000oO.append(14, "EHRPD");
            O00000oO.append(15, "HSPAP");
        }
        if (telephonyManager != null) {
            i = telephonyManager.getNetworkType();
        }
        return (String) O00000oO.get(i, "UNKWN");
    }

    private static boolean O00000Oo(Context context, String str) throws Throwable {
        ContentResolver contentResolver = context.getContentResolver();
        String str2 = ((String) br.O000000o(str, "AIRPLANE_MODE_ON")).toString();
        return ((Integer) br.O000000o(str, "getInt", new Object[]{contentResolver, str2}, new Class[]{ContentResolver.class, String.class})).intValue() == 1;
    }

    public static byte[] O00000Oo(int i, byte[] bArr) {
        if (bArr == null || bArr.length < 4) {
            bArr = new byte[4];
        }
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = (byte) ((i >> (i2 * 8)) & 255);
        }
        return bArr;
    }

    public static byte[] O00000Oo(String str) {
        return O000000o(O00000o(str), null);
    }

    public static int O00000o(String str) throws NumberFormatException {
        return Integer.parseInt(str);
    }

    public static String O00000o() {
        return Build.MODEL;
    }

    public static String O00000o(Context context) {
        String O0000o00 = o0O0o000.O0000o00(context);
        if (TextUtils.isEmpty(O0000o00) || O0000o00.equals("00:00:00:00:00:00")) {
            O0000o00 = bs.O000000o(context);
        }
        if (TextUtils.isEmpty(O0000o00)) {
            O0000o00 = "00:00:00:00:00:00";
        }
        if (!O0000O0o) {
            bs.O000000o(context, O0000o00);
            O0000O0o = true;
        }
        return O0000o00;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:9|10|11|12) */
    /* JADX WARNING: Missing block: B:11:0x0020, code skipped:
            r0 = java.lang.Integer.parseInt(com.amap.api.mapcore.util.br.O000000o(r1, "SDK").toString());
     */
    /* JADX WARNING: Missing block: B:12:0x0021, code skipped:
            return r0;
     */
    public static int O00000o0() {
        /*
        r0 = O00000Oo;
        if (r0 <= 0) goto L_0x0007;
    L_0x0004:
        r0 = O00000Oo;
        return r0;
    L_0x0007:
        r0 = 0;
        r1 = "android.os.Build$VERSION";
        r2 = "SDK_INT";
        r2 = com.amap.api.mapcore.util.br.O00000Oo(r1, r2);	 Catch:{ Throwable -> 0x0012 }
        r0 = r2;
        return r0;
    L_0x0012:
        r2 = "SDK";
        r1 = com.amap.api.mapcore.util.br.O000000o(r1, r2);	 Catch:{ Throwable -> 0x0021 }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x0021 }
        r1 = java.lang.Integer.parseInt(r1);	 Catch:{ Throwable -> 0x0021 }
        r0 = r1;
    L_0x0021:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.bt.O00000o0():int");
    }

    @SuppressLint({"NewApi"})
    public static boolean O00000o0(Context context) {
        if (context == null) {
            return true;
        }
        boolean isWifiEnabled;
        if (O000000o == null) {
            O000000o = (WifiManager) O000000o(context, "wifi");
        }
        try {
            isWifiEnabled = O000000o.isWifiEnabled();
        } catch (Throwable unused) {
            isWifiEnabled = false;
        }
        if (!isWifiEnabled && O00000o0() > 17) {
            try {
                return "true".equals(String.valueOf(br.O000000o(O000000o, "isScanAlwaysAvailable", new Object[0])));
            } catch (Throwable unused2) {
            }
        }
        return isWifiEnabled;
    }

    public static byte[] O00000o0(String str) {
        return O00000Oo(O00000o(str), null);
    }

    public static byte O00000oO(String str) throws NumberFormatException {
        return Byte.parseByte(str);
    }

    public static String O00000oO() {
        return VERSION.RELEASE;
    }

    public static boolean O00000oO(Context context) {
        return VERSION.SDK_INT >= 28 && context.getApplicationInfo().targetSdkVersion >= 28;
    }

    public static int O00000oo() {
        return new Random().nextInt(65536) - 32768;
    }
}
