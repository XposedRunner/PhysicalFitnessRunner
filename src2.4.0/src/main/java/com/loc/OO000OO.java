package com.loc;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.location.Location;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.SystemClock;
import android.support.v4.view.MotionEventCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.SparseArray;
import cn.jiguang.net.HttpUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.DPoint;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Random;
import org.json.JSONObject;

/* compiled from: Utils */
public final class OO000OO {
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

    public static float O000000o(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        return O000000o(new double[]{aMapLocation.getLatitude(), aMapLocation.getLongitude(), aMapLocation2.getLatitude(), aMapLocation2.getLongitude()});
    }

    public static float O000000o(DPoint dPoint, DPoint dPoint2) {
        return O000000o(new double[]{dPoint.getLatitude(), dPoint.getLongitude(), dPoint2.getLatitude(), dPoint2.getLongitude()});
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

    public static Object O000000o(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            return context.getApplicationContext().getSystemService(str);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "Utils", "getServ");
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002b  */
    public static java.lang.String O000000o(long r4, java.lang.String r6) {
        /*
        r0 = android.text.TextUtils.isEmpty(r6);
        if (r0 == 0) goto L_0x0008;
    L_0x0006:
        r6 = "yyyy-MM-dd HH:mm:ss";
    L_0x0008:
        r0 = 0;
        r1 = new java.text.SimpleDateFormat;	 Catch:{ Throwable -> 0x0016 }
        r2 = java.util.Locale.CHINA;	 Catch:{ Throwable -> 0x0016 }
        r1.<init>(r6, r2);	 Catch:{ Throwable -> 0x0016 }
        r1.applyPattern(r6);	 Catch:{ Throwable -> 0x0014 }
        goto L_0x001f;
    L_0x0014:
        r6 = move-exception;
        goto L_0x0018;
    L_0x0016:
        r6 = move-exception;
        r1 = r0;
    L_0x0018:
        r0 = "Utils";
        r2 = "formatUTC";
        com.loc.O0o0000.O000000o(r6, r0, r2);
    L_0x001f:
        r2 = 0;
        r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));
        if (r6 > 0) goto L_0x0029;
    L_0x0025:
        r4 = java.lang.System.currentTimeMillis();
    L_0x0029:
        if (r1 != 0) goto L_0x002e;
    L_0x002b:
        r4 = "NULL";
        return r4;
    L_0x002e:
        r4 = java.lang.Long.valueOf(r4);
        r4 = r1.format(r4);
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.OO000OO.O000000o(long, java.lang.String):java.lang.String");
    }

    public static void O000000o() {
    }

    public static boolean O000000o(long j, long j2) {
        String str = "yyyyMMddHH";
        String O000000o = O000000o(j, str);
        String O000000o2 = O000000o(j2, str);
        return ("NULL".equals(O000000o) || "NULL".equals(O000000o2)) ? false : O000000o.equals(O000000o2);
    }

    public static boolean O000000o(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return O00000o() < 17 ? O00000o(context, "android.provider.Settings$System") : O00000o(context, "android.provider.Settings$Global");
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0062  */
    public static boolean O000000o(android.database.sqlite.SQLiteDatabase r6, java.lang.String r7) {
        /*
        r0 = android.text.TextUtils.isEmpty(r7);
        r1 = 0;
        if (r0 == 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r0 = "2.0.201501131131";
        r2 = ".";
        r3 = "";
        r0 = r0.replace(r2, r3);
        if (r6 == 0) goto L_0x006e;
    L_0x0014:
        r2 = 1;
        r3 = 0;
        r4 = r6.isOpen();	 Catch:{ Throwable -> 0x0066, all -> 0x005f }
        if (r4 != 0) goto L_0x001d;
    L_0x001c:
        return r1;
    L_0x001d:
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0066, all -> 0x005f }
        r4.<init>();	 Catch:{ Throwable -> 0x0066, all -> 0x005f }
        r5 = "SELECT count(*) as c FROM sqlite_master WHERE type = 'table' AND name = '";
        r4.append(r5);	 Catch:{ Throwable -> 0x0066, all -> 0x005f }
        r7 = r7.trim();	 Catch:{ Throwable -> 0x0066, all -> 0x005f }
        r4.append(r7);	 Catch:{ Throwable -> 0x0066, all -> 0x005f }
        r4.append(r0);	 Catch:{ Throwable -> 0x0066, all -> 0x005f }
        r7 = "' ";
        r4.append(r7);	 Catch:{ Throwable -> 0x0066, all -> 0x005f }
        r7 = r4.toString();	 Catch:{ Throwable -> 0x0066, all -> 0x005f }
        r6 = r6.rawQuery(r7, r3);	 Catch:{ Throwable -> 0x0066, all -> 0x005f }
        if (r6 == 0) goto L_0x0051;
    L_0x0040:
        r7 = r6.moveToFirst();	 Catch:{ Throwable -> 0x0067, all -> 0x004e }
        if (r7 == 0) goto L_0x0051;
    L_0x0046:
        r7 = r6.getInt(r1);	 Catch:{ Throwable -> 0x0067, all -> 0x004e }
        if (r7 <= 0) goto L_0x0051;
    L_0x004c:
        r7 = r2;
        goto L_0x0052;
    L_0x004e:
        r7 = move-exception;
        r3 = r6;
        goto L_0x0060;
    L_0x0051:
        r7 = r1;
    L_0x0052:
        r0 = r4.length();	 Catch:{ Throwable -> 0x0067, all -> 0x004e }
        r4.delete(r1, r0);	 Catch:{ Throwable -> 0x0067, all -> 0x004e }
        if (r6 == 0) goto L_0x006d;
    L_0x005b:
        r6.close();
        return r7;
    L_0x005f:
        r7 = move-exception;
    L_0x0060:
        if (r3 == 0) goto L_0x0065;
    L_0x0062:
        r3.close();
    L_0x0065:
        throw r7;
    L_0x0066:
        r6 = r3;
    L_0x0067:
        if (r6 == 0) goto L_0x006c;
    L_0x0069:
        r6.close();
    L_0x006c:
        r7 = r2;
    L_0x006d:
        return r7;
    L_0x006e:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.OO000OO.O000000o(android.database.sqlite.SQLiteDatabase, java.lang.String):boolean");
    }

    public static boolean O000000o(Location location, int i) {
        Boolean valueOf = Boolean.valueOf(false);
        if (VERSION.SDK_INT >= 18) {
            try {
                valueOf = (Boolean) O0o.O000000o((Object) location, "isFromMockProvider", new Object[0]);
            } catch (Throwable unused) {
            }
        }
        if (valueOf.booleanValue()) {
            return true;
        }
        Bundle extras = location.getExtras();
        return (extras != null ? extras.getInt("satellites") : 0) <= 0 ? true : i == 0 && location.getAltitude() == 0.0d && location.getBearing() == 0.0f && location.getSpeed() == 0.0f;
    }

    public static boolean O000000o(AMapLocation aMapLocation) {
        return (aMapLocation != null && aMapLocation.getErrorCode() == 0) ? O00000Oo(aMapLocation) : false;
    }

    public static boolean O000000o(AMapLocationServer aMapLocationServer) {
        return (aMapLocationServer == null || Constants.VIA_SHARE_TYPE_PUBLISHVIDEO.equals(aMapLocationServer.d()) || "5".equals(aMapLocationServer.d()) || Constants.VIA_SHARE_TYPE_INFO.equals(aMapLocationServer.d())) ? false : O00000Oo((AMapLocation) aMapLocationServer);
    }

    public static boolean O000000o(String str) {
        return (TextUtils.isEmpty(str) || "00:00:00:00:00:00".equals(str) || str.contains(" :")) ? false : true;
    }

    public static boolean O000000o(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        ArrayList O00000o = O00000o(str);
        String[] split = str2.toString().split("#");
        int i = 0;
        int i2 = i;
        int i3 = i2;
        while (i < split.length) {
            if (split[i].contains(",nb") || split[i].contains(",access")) {
                i2++;
                if (O00000o.contains(split[i])) {
                    i3++;
                }
            }
            i++;
        }
        if (((double) (i3 * 2)) >= ((double) (O00000o.size() + i2)) * 0.618d) {
            return true;
        }
        return false;
    }

    public static boolean O000000o(JSONObject jSONObject, String str) {
        return OO0o000.O000000o(jSONObject, str);
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
            return OO0o000.O00000Oo(bArr);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "Utils", "gz");
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
            O0o0000.O000000o(th, "Utils", "getMccMnc");
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
        return System.currentTimeMillis();
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
        if (!TextUtils.isEmpty(O0o0000.O0000O0o)) {
            return O0o0000.O0000O0o;
        }
        CharSequence charSequence = null;
        if (context == null) {
            return null;
        }
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(OO00o00.O00000o0(context), 64);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "Utils", "getAppName part");
            packageInfo = null;
        }
        try {
            if (TextUtils.isEmpty(O0o0000.O0000OOo)) {
                O0o0000.O0000OOo = null;
            }
        } catch (Throwable th2) {
            O0o0000.O000000o(th2, "Utils", "getAppName");
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
        String O00000o0 = OO00o00.O00000o0(context);
        if (!TextUtils.isEmpty(O00000o0)) {
            stringBuilder.append(",");
            stringBuilder.append(O00000o0);
        }
        if (!TextUtils.isEmpty(O0o0000.O0000OOo)) {
            stringBuilder.append(",");
            stringBuilder.append(O0o0000.O0000OOo);
        }
        O00000o0 = stringBuilder.toString();
        O0o0000.O0000O0o = O00000o0;
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

    /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00a1 */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00ad A:{Splitter:B:34:0x0094, ExcHandler: all (r8_7 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0036 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x009e A:{SYNTHETIC, Splitter:B:41:0x009e} */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00cb A:{SYNTHETIC, Splitter:B:68:0x00cb} */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0036 A:{LOOP_START, SYNTHETIC, LOOP:0: B:11:0x0036->B:72:0x0036} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0036 */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00ad A:{Splitter:B:34:0x0094, ExcHandler: all (r8_7 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00ad A:{Splitter:B:34:0x0094, ExcHandler: all (r8_7 'th' java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Can't wrap try/catch for region: R(10:24|(1:26)|27|(4:28|29|30|(1:32)(1:78))|33|34|35|36|76|72) */
    /* JADX WARNING: Missing block: B:53:0x00ad, code skipped:
            r8 = move-exception;
     */
    /* JADX WARNING: Missing block: B:54:0x00ae, code skipped:
            r0 = r7;
            r7 = r8;
     */
    /* JADX WARNING: Missing block: B:69:?, code skipped:
            r0.closeEntry();
            r0.close();
     */
    public static void O00000Oo(java.lang.String r7, java.lang.String r8) {
        /*
        r0 = 0;
        r1 = new java.io.File;	 Catch:{ Throwable -> 0x00b8 }
        r1.<init>(r7);	 Catch:{ Throwable -> 0x00b8 }
        r7 = r1.exists();	 Catch:{ Throwable -> 0x00b8 }
        if (r7 == 0) goto L_0x00b5;
    L_0x000c:
        r7 = r1.isDirectory();	 Catch:{ Throwable -> 0x00b8 }
        if (r7 == 0) goto L_0x0013;
    L_0x0012:
        return;
    L_0x0013:
        r7 = java.io.File.separator;	 Catch:{ Throwable -> 0x00b8 }
        r7 = r8.endsWith(r7);	 Catch:{ Throwable -> 0x00b8 }
        if (r7 != 0) goto L_0x002c;
    L_0x001b:
        r7 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00b8 }
        r7.<init>();	 Catch:{ Throwable -> 0x00b8 }
        r7.append(r8);	 Catch:{ Throwable -> 0x00b8 }
        r8 = java.io.File.separator;	 Catch:{ Throwable -> 0x00b8 }
        r7.append(r8);	 Catch:{ Throwable -> 0x00b8 }
        r8 = r7.toString();	 Catch:{ Throwable -> 0x00b8 }
    L_0x002c:
        r7 = new java.util.zip.ZipInputStream;	 Catch:{ Throwable -> 0x00b8 }
        r2 = new java.io.FileInputStream;	 Catch:{ Throwable -> 0x00b8 }
        r2.<init>(r1);	 Catch:{ Throwable -> 0x00b8 }
        r7.<init>(r2);	 Catch:{ Throwable -> 0x00b8 }
    L_0x0036:
        r1 = r7.getNextEntry();	 Catch:{ Throwable -> 0x00b1, all -> 0x00ad }
        if (r1 == 0) goto L_0x00a6;
    L_0x003c:
        r2 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r3 = new byte[r2];	 Catch:{ Exception -> 0x00a2, all -> 0x009b }
        r4 = r1.getName();	 Catch:{ Exception -> 0x00a2, all -> 0x009b }
        r5 = android.text.TextUtils.isEmpty(r4);	 Catch:{ Exception -> 0x00a2, all -> 0x009b }
        if (r5 != 0) goto L_0x00a6;
    L_0x004a:
        r5 = "../";
        r5 = r4.contains(r5);	 Catch:{ Exception -> 0x00a2, all -> 0x009b }
        if (r5 == 0) goto L_0x0053;
    L_0x0052:
        goto L_0x00a6;
    L_0x0053:
        r1 = r1.isDirectory();	 Catch:{ Exception -> 0x00a2, all -> 0x009b }
        if (r1 == 0) goto L_0x005a;
    L_0x0059:
        goto L_0x0036;
    L_0x005a:
        r1 = new java.io.File;	 Catch:{ Exception -> 0x00a2, all -> 0x009b }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00a2, all -> 0x009b }
        r5.<init>();	 Catch:{ Exception -> 0x00a2, all -> 0x009b }
        r5.append(r8);	 Catch:{ Exception -> 0x00a2, all -> 0x009b }
        r5.append(r4);	 Catch:{ Exception -> 0x00a2, all -> 0x009b }
        r4 = r5.toString();	 Catch:{ Exception -> 0x00a2, all -> 0x009b }
        r1.<init>(r4);	 Catch:{ Exception -> 0x00a2, all -> 0x009b }
        r4 = new java.io.File;	 Catch:{ Exception -> 0x00a2, all -> 0x009b }
        r5 = r1.getParent();	 Catch:{ Exception -> 0x00a2, all -> 0x009b }
        r4.<init>(r5);	 Catch:{ Exception -> 0x00a2, all -> 0x009b }
        r5 = r4.exists();	 Catch:{ Exception -> 0x00a2, all -> 0x009b }
        if (r5 != 0) goto L_0x0080;
    L_0x007d:
        r4.mkdirs();	 Catch:{ Exception -> 0x00a2, all -> 0x009b }
    L_0x0080:
        r4 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x00a2, all -> 0x009b }
        r4.<init>(r1);	 Catch:{ Exception -> 0x00a2, all -> 0x009b }
    L_0x0085:
        r1 = 0;
        r5 = r7.read(r3, r1, r2);	 Catch:{ Exception -> 0x00a3, all -> 0x0098 }
        r6 = -1;
        if (r5 == r6) goto L_0x0091;
    L_0x008d:
        r4.write(r3, r1, r5);	 Catch:{ Exception -> 0x00a3, all -> 0x0098 }
        goto L_0x0085;
    L_0x0091:
        r4.flush();	 Catch:{ Exception -> 0x00a3, all -> 0x0098 }
    L_0x0094:
        r4.close();	 Catch:{ Throwable -> 0x0036, all -> 0x00ad }
        goto L_0x0036;
    L_0x0098:
        r8 = move-exception;
        r0 = r4;
        goto L_0x009c;
    L_0x009b:
        r8 = move-exception;
    L_0x009c:
        if (r0 == 0) goto L_0x00a1;
    L_0x009e:
        r0.close();	 Catch:{ Throwable -> 0x00a1, all -> 0x00ad }
    L_0x00a1:
        throw r8;	 Catch:{ Throwable -> 0x00b1, all -> 0x00ad }
    L_0x00a2:
        r4 = r0;
    L_0x00a3:
        if (r4 == 0) goto L_0x0036;
    L_0x00a5:
        goto L_0x0094;
    L_0x00a6:
        r7.closeEntry();	 Catch:{ Throwable -> 0x00ac }
        r7.close();	 Catch:{ Throwable -> 0x00ac }
    L_0x00ac:
        return;
    L_0x00ad:
        r8 = move-exception;
        r0 = r7;
        r7 = r8;
        goto L_0x00c9;
    L_0x00b1:
        r8 = move-exception;
        r0 = r7;
        r7 = r8;
        goto L_0x00b9;
    L_0x00b5:
        return;
    L_0x00b6:
        r7 = move-exception;
        goto L_0x00c9;
    L_0x00b8:
        r7 = move-exception;
    L_0x00b9:
        r8 = "Utils";
        r1 = "unZip";
        com.loc.O0o0000.O000000o(r7, r8, r1);	 Catch:{ all -> 0x00b6 }
        if (r0 == 0) goto L_0x00c8;
    L_0x00c2:
        r0.closeEntry();	 Catch:{ Throwable -> 0x00c8 }
        r0.close();	 Catch:{ Throwable -> 0x00c8 }
    L_0x00c8:
        return;
    L_0x00c9:
        if (r0 == 0) goto L_0x00d1;
    L_0x00cb:
        r0.closeEntry();	 Catch:{ Throwable -> 0x00d1 }
        r0.close();	 Catch:{ Throwable -> 0x00d1 }
    L_0x00d1:
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.OO000OO.O00000Oo(java.lang.String, java.lang.String):void");
    }

    public static boolean O00000Oo(long j, long j2) {
        String str = "yyyyMMdd";
        String O000000o = O000000o(j, str);
        String O000000o2 = O000000o(j2, str);
        return ("NULL".equals(O000000o) || "NULL".equals(O000000o2)) ? false : O000000o.equals(O000000o2);
    }

    public static boolean O00000Oo(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0) != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean O00000Oo(AMapLocation aMapLocation) {
        double longitude = aMapLocation.getLongitude();
        double latitude = aMapLocation.getLatitude();
        boolean z = false;
        if (!(longitude == 0.0d && latitude == 0.0d) && longitude <= 180.0d) {
            if (latitude > 90.0d) {
                return false;
            }
            if (longitude >= -180.0d) {
                if (latitude < -90.0d) {
                    return false;
                }
                z = true;
            }
        }
        return z;
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
        return O000000o(Integer.parseInt(str), null);
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:9|10|11|12) */
    /* JADX WARNING: Missing block: B:11:0x0020, code skipped:
            r0 = java.lang.Integer.parseInt(com.loc.O0o.O000000o(r1, "SDK").toString());
     */
    /* JADX WARNING: Missing block: B:12:0x0021, code skipped:
            return r0;
     */
    public static int O00000o() {
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
        r2 = com.loc.O0o.O00000Oo(r1, r2);	 Catch:{ Throwable -> 0x0012 }
        r0 = r2;
        return r0;
    L_0x0012:
        r2 = "SDK";
        r1 = com.loc.O0o.O000000o(r1, r2);	 Catch:{ Throwable -> 0x0021 }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x0021 }
        r1 = java.lang.Integer.parseInt(r1);	 Catch:{ Throwable -> 0x0021 }
        r0 = r1;
    L_0x0021:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.OO000OO.O00000o():int");
    }

    public static ArrayList<String> O00000o(String str) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split("#");
            int i = 0;
            while (i < split.length) {
                if (split[i].contains(",nb") || split[i].contains(",access")) {
                    arrayList.add(split[i]);
                }
                i++;
            }
        }
        return arrayList;
    }

    public static boolean O00000o(Context context) {
        try {
            NetworkInfo O00000o0 = O00000o0(context);
            if (O00000o0 != null && O00000o0.isConnectedOrConnecting()) {
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static boolean O00000o(Context context, String str) throws Throwable {
        ContentResolver contentResolver = context.getContentResolver();
        String str2 = ((String) O0o.O000000o(str, "AIRPLANE_MODE_ON")).toString();
        return ((Integer) O0o.O000000o(str, "getInt", new Object[]{contentResolver, str2}, new Class[]{ContentResolver.class, String.class})).intValue() == 1;
    }

    public static double O00000o0(double d) {
        return ((double) ((long) (d * 1000000.0d))) / 1000000.0d;
    }

    public static long O00000o0() {
        return SystemClock.elapsedRealtime();
    }

    public static NetworkInfo O00000o0(Context context) {
        try {
            return OO0O0o0.O0000oO(context);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "Utils", "getNetWorkInfo");
            return null;
        }
    }

    public static boolean O00000o0(long j, long j2) {
        if (!O00000Oo(j, j2)) {
            return false;
        }
        Calendar instance = Calendar.getInstance(Locale.CHINA);
        instance.setTimeInMillis(j);
        int i = instance.get(11);
        instance.setTimeInMillis(j2);
        int i2 = instance.get(11);
        if (i > 12) {
            if (i2 > 12) {
                return true;
            }
        } else if (i2 <= 12) {
            return true;
        }
        return false;
    }

    public static boolean O00000o0(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getApplicationContext().getPackageManager().getPackageInfo(str, 256);
        } catch (Throwable unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public static boolean O00000o0(String str, String str2) {
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            return false;
        }
        for (File file2 : file.listFiles()) {
            if (file2.isDirectory() && file2.getName().equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public static byte[] O00000o0(String str) {
        return O00000Oo(Integer.parseInt(str), null);
    }

    public static String O00000oO() {
        return Build.MODEL;
    }

    public static void O00000oO(String str) {
        try {
            if (!str.endsWith(File.separator)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(File.separator);
                str = stringBuilder.toString();
            }
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    if (file2.isDirectory()) {
                        O00000oO(file2.getAbsolutePath());
                    } else {
                        file2.delete();
                    }
                }
                file.delete();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static boolean O00000oO(Context context) {
        try {
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName.equals(OO00o00.O00000o0(context))) {
                    return runningAppProcessInfo.importance != 100;
                }
            }
        } catch (Throwable th) {
            O0o0000.O000000o(th, "Utils", "isApplicationBroughtToBackground");
            return true;
        }
    }

    public static double O00000oo(String str) throws NumberFormatException {
        return Double.parseDouble(str);
    }

    public static String O00000oo() {
        return VERSION.RELEASE;
    }

    public static boolean O00000oo(Context context) {
        if (VERSION.SDK_INT < 23 || context.getApplicationInfo().targetSdkVersion < 23) {
            for (String checkCallingOrSelfPermission : O00000oo) {
                if (context.checkCallingOrSelfPermission(checkCallingOrSelfPermission) != 0) {
                    return false;
                }
            }
        } else {
            Application application = (Application) context;
            for (Object obj : O00000oo) {
                int O00000Oo;
                try {
                    O00000Oo = O0o.O00000Oo(application.getBaseContext(), "checkSelfPermission", obj);
                } catch (Throwable unused) {
                    O00000Oo = 0;
                }
                if (O00000Oo != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static float O0000O0o(String str) throws NumberFormatException {
        return Float.parseFloat(str);
    }

    public static int O0000O0o() {
        return new Random().nextInt(65536) - 32768;
    }

    @SuppressLint({"NewApi"})
    public static boolean O0000O0o(Context context) {
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
        if (!isWifiEnabled && O00000o() > 17) {
            try {
                return "true".equals(String.valueOf(O0o.O000000o(O000000o, "isScanAlwaysAvailable", new Object[0])));
            } catch (Throwable unused2) {
            }
        }
        return isWifiEnabled;
    }

    public static int O0000OOo(String str) throws NumberFormatException {
        return Integer.parseInt(str);
    }

    /* JADX WARNING: Missing block: B:16:0x0034, code skipped:
            return "3G";
     */
    /* JADX WARNING: Missing block: B:18:0x0037, code skipped:
            return "2G";
     */
    /* JADX WARNING: Missing block: B:24:0x004e, code skipped:
            if ("CDMA2000".equalsIgnoreCase(r0) == false) goto L_0x0051;
     */
    public static java.lang.String O0000OOo(android.content.Context r3) {
        /*
        r3 = O00000o0(r3);
        if (r3 == 0) goto L_0x0052;
    L_0x0006:
        r0 = r3.isConnectedOrConnecting();
        if (r0 != 0) goto L_0x000d;
    L_0x000c:
        goto L_0x0052;
    L_0x000d:
        r0 = "UNKNOWN";
        r1 = r3.getType();
        r2 = 1;
        if (r1 != r2) goto L_0x0019;
    L_0x0016:
        r0 = "WIFI";
        return r0;
    L_0x0019:
        if (r1 != 0) goto L_0x0051;
    L_0x001b:
        r0 = r3.getSubtypeName();
        r3 = r3.getSubtype();
        switch(r3) {
            case 1: goto L_0x0035;
            case 2: goto L_0x0035;
            case 3: goto L_0x0032;
            case 4: goto L_0x0035;
            case 5: goto L_0x0032;
            case 6: goto L_0x0032;
            case 7: goto L_0x0035;
            case 8: goto L_0x0032;
            case 9: goto L_0x0032;
            case 10: goto L_0x0032;
            case 11: goto L_0x0035;
            case 12: goto L_0x0032;
            case 13: goto L_0x002f;
            case 14: goto L_0x0032;
            case 15: goto L_0x0032;
            case 16: goto L_0x0035;
            case 17: goto L_0x0032;
            default: goto L_0x0026;
        };
    L_0x0026:
        r3 = "GSM";
        r3 = r3.equalsIgnoreCase(r0);
        if (r3 == 0) goto L_0x0038;
    L_0x002e:
        goto L_0x0035;
    L_0x002f:
        r0 = "4G";
        return r0;
    L_0x0032:
        r0 = "3G";
        return r0;
    L_0x0035:
        r0 = "2G";
        return r0;
    L_0x0038:
        r3 = "TD-SCDMA";
        r3 = r3.equalsIgnoreCase(r0);
        if (r3 != 0) goto L_0x0032;
    L_0x0040:
        r3 = "WCDMA";
        r3 = r3.equalsIgnoreCase(r0);
        if (r3 != 0) goto L_0x0032;
    L_0x0048:
        r3 = "CDMA2000";
        r3 = r3.equalsIgnoreCase(r0);
        if (r3 == 0) goto L_0x0051;
    L_0x0050:
        goto L_0x0032;
    L_0x0051:
        return r0;
    L_0x0052:
        r3 = "DISCONNECTED";
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.OO000OO.O0000OOo(android.content.Context):java.lang.String");
    }

    public static void O0000OOo() {
        O00000o.clear();
    }

    public static byte O0000Oo(String str) throws NumberFormatException {
        return Byte.parseByte(str);
    }

    public static String O0000Oo() {
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Environment.getExternalStorageDirectory().getAbsolutePath());
        stringBuilder.append(File.separator);
        stringBuilder.append("amap");
        stringBuilder.append(File.separator);
        stringBuilder.append("openamaplocationsdk");
        stringBuilder.append(File.separator);
        return stringBuilder.toString();
    }

    public static boolean O0000Oo(Context context) {
        return VERSION.SDK_INT >= 28 && context.getApplicationInfo().targetSdkVersion >= 28;
    }

    public static int O0000Oo0(String str) throws NumberFormatException {
        return Integer.parseInt(str, 16);
    }

    public static String O0000Oo0() {
        try {
            return oOo00.O00000Oo("S128DF1572465B890OE3F7A13167KLEI".getBytes(HttpUtils.ENCODING_UTF_8)).substring(20);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String O0000Oo0(Context context) {
        String O0000o00 = OO0O0o0.O0000o00(context);
        if (TextUtils.isEmpty(O0000o00) || O0000o00.equals("00:00:00:00:00:00")) {
            O0000o00 = "00:00:00:00:00:00";
            if (context != null) {
                O0000o00 = OO0000o.O00000Oo(context, "pref", "smac", O0000o00);
            }
        }
        if (TextUtils.isEmpty(O0000o00)) {
            O0000o00 = "00:00:00:00:00:00";
        }
        if (!O0000O0o) {
            if (!(context == null || TextUtils.isEmpty(O0000o00))) {
                OO0000o.O000000o(context, "pref", "smac", O0000o00);
            }
            O0000O0o = true;
        }
        return O0000o00;
    }

    public static boolean O0000OoO(Context context) {
        ServiceInfo serviceInfo;
        try {
            serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, "com.amap.api.location.APSService"), 128);
        } catch (Throwable unused) {
            serviceInfo = null;
        }
        return serviceInfo != null;
    }
}
