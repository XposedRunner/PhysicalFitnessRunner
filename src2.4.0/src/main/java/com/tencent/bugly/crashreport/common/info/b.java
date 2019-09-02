package com.tencent.bugly.crashreport.common.info;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.support.v4.os.EnvironmentCompat;
import android.telephony.TelephonyManager;
import cn.jiguang.net.HttpUtils;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: BUGLY */
public final class b {
    private static String a;
    private static String b;

    public static String a() {
        try {
            return Build.MODEL;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return "fail";
        }
    }

    public static String a(Context context) {
        String str = null;
        if (context == null) {
            return null;
        }
        if (AppInfo.a(context, "android.permission.READ_PHONE_STATE")) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    String deviceId = telephonyManager.getDeviceId();
                    if (deviceId != null) {
                        try {
                            str = deviceId.toLowerCase();
                        } catch (Throwable unused) {
                            str = deviceId;
                        }
                    } else {
                        str = deviceId;
                    }
                }
            } catch (Throwable unused2) {
                x.a("Failed to get IMEI.", new Object[0]);
                return str;
            }
            return str;
        }
        x.d("no READ_PHONE_STATE permission to get IMEI", new Object[0]);
        return null;
    }

    public static String a(boolean z) {
        String str = null;
        if (z) {
            try {
                str = q();
            } catch (Throwable th) {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
                return "fail";
            }
        }
        if (str == null) {
            str = System.getProperty("os.arch");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public static String b() {
        try {
            return VERSION.RELEASE;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return "fail";
        }
    }

    public static String b(Context context) {
        String str = null;
        if (context == null) {
            return null;
        }
        if (AppInfo.a(context, "android.permission.READ_PHONE_STATE")) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    String subscriberId = telephonyManager.getSubscriberId();
                    if (subscriberId != null) {
                        try {
                            str = subscriberId.toLowerCase();
                        } catch (Throwable unused) {
                            str = subscriberId;
                        }
                    } else {
                        str = subscriberId;
                    }
                }
            } catch (Throwable unused2) {
                x.a("Failed to get IMSI.", new Object[0]);
                return str;
            }
            return str;
        }
        x.d("no READ_PHONE_STATE permission to get IMSI", new Object[0]);
        return null;
    }

    public static int c() {
        try {
            return VERSION.SDK_INT;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return -1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0025  */
    public static java.lang.String c(android.content.Context r3) {
        /*
        r0 = "fail";
        if (r3 != 0) goto L_0x0005;
    L_0x0004:
        return r0;
    L_0x0005:
        r3 = r3.getContentResolver();	 Catch:{ Throwable -> 0x001e }
        r1 = "android_id";
        r3 = android.provider.Settings.Secure.getString(r3, r1);	 Catch:{ Throwable -> 0x001e }
        if (r3 != 0) goto L_0x0019;
    L_0x0011:
        r0 = "null";
        goto L_0x002d;
    L_0x0014:
        r0 = move-exception;
        r2 = r0;
        r0 = r3;
        r3 = r2;
        goto L_0x001f;
    L_0x0019:
        r0 = r3.toLowerCase();	 Catch:{ Throwable -> 0x0014 }
        goto L_0x002d;
    L_0x001e:
        r3 = move-exception;
    L_0x001f:
        r3 = com.tencent.bugly.proguard.x.a(r3);
        if (r3 != 0) goto L_0x002d;
    L_0x0025:
        r3 = "Failed to get Android ID.";
        r1 = 0;
        r1 = new java.lang.Object[r1];
        com.tencent.bugly.proguard.x.a(r3, r1);
    L_0x002d:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.common.info.b.c(android.content.Context):java.lang.String");
    }

    public static String d() {
        try {
            return Build.SERIAL;
        } catch (Throwable unused) {
            x.a("Failed to get hardware serial number.", new Object[0]);
            return "fail";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0065  */
    public static java.lang.String d(android.content.Context r5) {
        /*
        r0 = "fail";
        if (r5 != 0) goto L_0x0005;
    L_0x0004:
        return r0;
    L_0x0005:
        r1 = 0;
        r2 = 1;
        r3 = "wifi";
        r3 = r5.getSystemService(r3);	 Catch:{ Throwable -> 0x0059 }
        r3 = (android.net.wifi.WifiManager) r3;	 Catch:{ Throwable -> 0x0059 }
        if (r3 == 0) goto L_0x0063;
    L_0x0011:
        r3 = r3.getConnectionInfo();	 Catch:{ Throwable -> 0x0059 }
        if (r3 == 0) goto L_0x0063;
    L_0x0017:
        r3 = r3.getMacAddress();	 Catch:{ Throwable -> 0x0059 }
        if (r3 == 0) goto L_0x0029;
    L_0x001d:
        r0 = "02:00:00:00:00:00";
        r0 = r3.equals(r0);	 Catch:{ Throwable -> 0x0026 }
        if (r0 == 0) goto L_0x0057;
    L_0x0025:
        goto L_0x0029;
    L_0x0026:
        r5 = move-exception;
        r0 = r3;
        goto L_0x005a;
    L_0x0029:
        r0 = "wifi.interface";
        r5 = com.tencent.bugly.proguard.z.a(r5, r0);	 Catch:{ Throwable -> 0x0026 }
        r0 = "MAC interface: %s";
        r4 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x0026 }
        r4[r1] = r5;	 Catch:{ Throwable -> 0x0026 }
        com.tencent.bugly.proguard.x.c(r0, r4);	 Catch:{ Throwable -> 0x0026 }
        r5 = java.net.NetworkInterface.getByName(r5);	 Catch:{ Throwable -> 0x0026 }
        if (r5 != 0) goto L_0x0044;
    L_0x003e:
        r5 = "wlan0";
        r5 = java.net.NetworkInterface.getByName(r5);	 Catch:{ Throwable -> 0x0026 }
    L_0x0044:
        if (r5 != 0) goto L_0x004c;
    L_0x0046:
        r5 = "eth0";
        r5 = java.net.NetworkInterface.getByName(r5);	 Catch:{ Throwable -> 0x0026 }
    L_0x004c:
        if (r5 == 0) goto L_0x0057;
    L_0x004e:
        r5 = r5.getHardwareAddress();	 Catch:{ Throwable -> 0x0026 }
        r0 = com.tencent.bugly.proguard.z.d(r5);	 Catch:{ Throwable -> 0x0026 }
        goto L_0x0063;
    L_0x0057:
        r0 = r3;
        goto L_0x0063;
    L_0x0059:
        r5 = move-exception;
    L_0x005a:
        r3 = com.tencent.bugly.proguard.x.a(r5);
        if (r3 != 0) goto L_0x0063;
    L_0x0060:
        r5.printStackTrace();
    L_0x0063:
        if (r0 != 0) goto L_0x0067;
    L_0x0065:
        r0 = "null";
    L_0x0067:
        r5 = "MAC address: %s";
        r2 = new java.lang.Object[r2];
        r2[r1] = r0;
        com.tencent.bugly.proguard.x.c(r5, r2);
        r5 = r0.toLowerCase();
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.common.info.b.d(android.content.Context):java.lang.String");
    }

    public static long e() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return -1;
        }
    }

    public static String e(Context context) {
        String str = "fail";
        if (context == null) {
            return str;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                String simSerialNumber = telephonyManager.getSimSerialNumber();
                if (simSerialNumber == null) {
                    try {
                        str = "null";
                    } catch (Throwable unused) {
                        str = simSerialNumber;
                    }
                } else {
                    str = simSerialNumber;
                }
            }
        } catch (Throwable unused2) {
            x.a("Failed to get SIM serial number.", new Object[0]);
            return str;
        }
        return str;
    }

    public static long f() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return -1;
        }
    }

    public static String f(Context context) {
        String str = EnvironmentCompat.MEDIA_UNKNOWN;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return null;
            }
            String str2;
            if (activeNetworkInfo.getType() == 1) {
                str2 = "WIFI";
            } else {
                if (activeNetworkInfo.getType() == 0) {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        int networkType = telephonyManager.getNetworkType();
                        switch (networkType) {
                            case 1:
                                str2 = "GPRS";
                                break;
                            case 2:
                                str2 = "EDGE";
                                break;
                            case 3:
                                str2 = "UMTS";
                                break;
                            case 4:
                                str2 = "CDMA";
                                break;
                            case 5:
                                str2 = "EVDO_0";
                                break;
                            case 6:
                                str2 = "EVDO_A";
                                break;
                            case 7:
                                str2 = "1xRTT";
                                break;
                            case 8:
                                str2 = "HSDPA";
                                break;
                            case 9:
                                str2 = "HSUPA";
                                break;
                            case 10:
                                str2 = "HSPA";
                                break;
                            case 11:
                                str2 = "iDen";
                                break;
                            case 12:
                                str2 = "EVDO_B";
                                break;
                            case 13:
                                str2 = "LTE";
                                break;
                            case 14:
                                str2 = "eHRPD";
                                break;
                            case 15:
                                str2 = "HSPA+";
                                break;
                            default:
                                StringBuilder stringBuilder = new StringBuilder("MOBILE(");
                                stringBuilder.append(networkType);
                                stringBuilder.append(")");
                                str = stringBuilder.toString();
                                break;
                        }
                    }
                }
                str2 = str;
            }
            return str2;
        } catch (Exception e) {
            if (!x.a(e)) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x008d A:{Catch:{ all -> 0x00b3 }} */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0092 A:{SYNTHETIC, Splitter:B:52:0x0092} */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00a2 A:{SYNTHETIC, Splitter:B:59:0x00a2} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00b6 A:{SYNTHETIC, Splitter:B:69:0x00b6} */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00c6 A:{SYNTHETIC, Splitter:B:76:0x00c6} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00b6 A:{SYNTHETIC, Splitter:B:69:0x00b6} */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00c6 A:{SYNTHETIC, Splitter:B:76:0x00c6} */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x008d A:{Catch:{ all -> 0x00b3 }} */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0092 A:{SYNTHETIC, Splitter:B:52:0x0092} */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00a2 A:{SYNTHETIC, Splitter:B:59:0x00a2} */
    public static long g() {
        /*
        r0 = "/proc/meminfo";
        r1 = 0;
        r2 = new java.io.FileReader;	 Catch:{ Throwable -> 0x0083, all -> 0x007e }
        r2.<init>(r0);	 Catch:{ Throwable -> 0x0083, all -> 0x007e }
        r0 = new java.io.BufferedReader;	 Catch:{ Throwable -> 0x0079, all -> 0x0074 }
        r3 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;
        r0.<init>(r2, r3);	 Catch:{ Throwable -> 0x0079, all -> 0x0074 }
        r1 = r0.readLine();	 Catch:{ Throwable -> 0x0072 }
        if (r1 != 0) goto L_0x0034;
    L_0x0015:
        r0.close();	 Catch:{ IOException -> 0x0019 }
        goto L_0x0023;
    L_0x0019:
        r0 = move-exception;
        r1 = com.tencent.bugly.proguard.x.a(r0);
        if (r1 != 0) goto L_0x0023;
    L_0x0020:
        r0.printStackTrace();
    L_0x0023:
        r2.close();	 Catch:{ IOException -> 0x0027 }
        goto L_0x0031;
    L_0x0027:
        r0 = move-exception;
        r1 = com.tencent.bugly.proguard.x.a(r0);
        if (r1 != 0) goto L_0x0031;
    L_0x002e:
        r0.printStackTrace();
    L_0x0031:
        r0 = -1;
        return r0;
    L_0x0034:
        r3 = ":\\s+";
        r4 = 2;
        r1 = r1.split(r3, r4);	 Catch:{ Throwable -> 0x0072 }
        r3 = 1;
        r1 = r1[r3];	 Catch:{ Throwable -> 0x0072 }
        r1 = r1.toLowerCase();	 Catch:{ Throwable -> 0x0072 }
        r3 = "kb";
        r4 = "";
        r1 = r1.replace(r3, r4);	 Catch:{ Throwable -> 0x0072 }
        r1 = r1.trim();	 Catch:{ Throwable -> 0x0072 }
        r3 = java.lang.Long.parseLong(r1);	 Catch:{ Throwable -> 0x0072 }
        r1 = 10;
        r3 = r3 << r1;
        r0.close();	 Catch:{ IOException -> 0x0059 }
        goto L_0x0063;
    L_0x0059:
        r0 = move-exception;
        r1 = com.tencent.bugly.proguard.x.a(r0);
        if (r1 != 0) goto L_0x0063;
    L_0x0060:
        r0.printStackTrace();
    L_0x0063:
        r2.close();	 Catch:{ IOException -> 0x0067 }
        goto L_0x0071;
    L_0x0067:
        r0 = move-exception;
        r1 = com.tencent.bugly.proguard.x.a(r0);
        if (r1 != 0) goto L_0x0071;
    L_0x006e:
        r0.printStackTrace();
    L_0x0071:
        return r3;
    L_0x0072:
        r1 = move-exception;
        goto L_0x0087;
    L_0x0074:
        r0 = move-exception;
        r5 = r1;
        r1 = r0;
        r0 = r5;
        goto L_0x00b4;
    L_0x0079:
        r0 = move-exception;
        r5 = r1;
        r1 = r0;
        r0 = r5;
        goto L_0x0087;
    L_0x007e:
        r0 = move-exception;
        r2 = r1;
        r1 = r0;
        r0 = r2;
        goto L_0x00b4;
    L_0x0083:
        r0 = move-exception;
        r2 = r1;
        r1 = r0;
        r0 = r2;
    L_0x0087:
        r3 = com.tencent.bugly.proguard.x.a(r1);	 Catch:{ all -> 0x00b3 }
        if (r3 != 0) goto L_0x0090;
    L_0x008d:
        r1.printStackTrace();	 Catch:{ all -> 0x00b3 }
    L_0x0090:
        if (r0 == 0) goto L_0x00a0;
    L_0x0092:
        r0.close();	 Catch:{ IOException -> 0x0096 }
        goto L_0x00a0;
    L_0x0096:
        r0 = move-exception;
        r1 = com.tencent.bugly.proguard.x.a(r0);
        if (r1 != 0) goto L_0x00a0;
    L_0x009d:
        r0.printStackTrace();
    L_0x00a0:
        if (r2 == 0) goto L_0x00b0;
    L_0x00a2:
        r2.close();	 Catch:{ IOException -> 0x00a6 }
        goto L_0x00b0;
    L_0x00a6:
        r0 = move-exception;
        r1 = com.tencent.bugly.proguard.x.a(r0);
        if (r1 != 0) goto L_0x00b0;
    L_0x00ad:
        r0.printStackTrace();
    L_0x00b0:
        r0 = -2;
        return r0;
    L_0x00b3:
        r1 = move-exception;
    L_0x00b4:
        if (r0 == 0) goto L_0x00c4;
    L_0x00b6:
        r0.close();	 Catch:{ IOException -> 0x00ba }
        goto L_0x00c4;
    L_0x00ba:
        r0 = move-exception;
        r3 = com.tencent.bugly.proguard.x.a(r0);
        if (r3 != 0) goto L_0x00c4;
    L_0x00c1:
        r0.printStackTrace();
    L_0x00c4:
        if (r2 == 0) goto L_0x00d4;
    L_0x00c6:
        r2.close();	 Catch:{ IOException -> 0x00ca }
        goto L_0x00d4;
    L_0x00ca:
        r0 = move-exception;
        r2 = com.tencent.bugly.proguard.x.a(r0);
        if (r2 != 0) goto L_0x00d4;
    L_0x00d1:
        r0.printStackTrace();
    L_0x00d4:
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.common.info.b.g():long");
    }

    public static String g(Context context) {
        String a = z.a(context, "ro.miui.ui.version.name");
        StringBuilder stringBuilder;
        if (z.a(a) || a.equals("fail")) {
            a = z.a(context, "ro.build.version.emui");
            if (z.a(a) || a.equals("fail")) {
                a = z.a(context, "ro.lenovo.series");
                StringBuilder stringBuilder2;
                if (z.a(a) || a.equals("fail")) {
                    a = z.a(context, "ro.build.nubia.rom.name");
                    StringBuilder stringBuilder3;
                    if (z.a(a) || a.equals("fail")) {
                        a = z.a(context, "ro.meizu.product.model");
                        if (z.a(a) || a.equals("fail")) {
                            a = z.a(context, "ro.build.version.opporom");
                            if (z.a(a) || a.equals("fail")) {
                                a = z.a(context, "ro.vivo.os.build.display.id");
                                if (z.a(a) || a.equals("fail")) {
                                    a = z.a(context, "ro.aa.romver");
                                    if (z.a(a) || a.equals("fail")) {
                                        a = z.a(context, "ro.lewa.version");
                                        if (z.a(a) || a.equals("fail")) {
                                            a = z.a(context, "ro.gn.gnromvernumber");
                                            if (z.a(a) || a.equals("fail")) {
                                                a = z.a(context, "ro.build.tyd.kbstyle_version");
                                                if (z.a(a) || a.equals("fail")) {
                                                    stringBuilder2 = new StringBuilder();
                                                    stringBuilder2.append(z.a(context, "ro.build.fingerprint"));
                                                    stringBuilder2.append(HttpUtils.PATHS_SEPARATOR);
                                                    stringBuilder2.append(z.a(context, "ro.build.rom.id"));
                                                    return stringBuilder2.toString();
                                                }
                                                stringBuilder = new StringBuilder("dido/");
                                                stringBuilder.append(a);
                                                return stringBuilder.toString();
                                            }
                                            stringBuilder3 = new StringBuilder("amigo/");
                                            stringBuilder3.append(a);
                                            stringBuilder3.append(HttpUtils.PATHS_SEPARATOR);
                                            stringBuilder3.append(z.a(context, "ro.build.display.id"));
                                            return stringBuilder3.toString();
                                        }
                                        stringBuilder3 = new StringBuilder("tcl/");
                                        stringBuilder3.append(a);
                                        stringBuilder3.append(HttpUtils.PATHS_SEPARATOR);
                                        stringBuilder3.append(z.a(context, "ro.build.display.id"));
                                        return stringBuilder3.toString();
                                    }
                                    stringBuilder3 = new StringBuilder("htc/");
                                    stringBuilder3.append(a);
                                    stringBuilder3.append(HttpUtils.PATHS_SEPARATOR);
                                    stringBuilder3.append(z.a(context, "ro.build.description"));
                                    return stringBuilder3.toString();
                                }
                                stringBuilder = new StringBuilder("vivo/FUNTOUCH/");
                                stringBuilder.append(a);
                                return stringBuilder.toString();
                            }
                            stringBuilder = new StringBuilder("Oppo/COLOROS/");
                            stringBuilder.append(a);
                            return stringBuilder.toString();
                        }
                        stringBuilder2 = new StringBuilder("Meizu/FLYME/");
                        stringBuilder2.append(z.a(context, "ro.build.display.id"));
                        return stringBuilder2.toString();
                    }
                    stringBuilder3 = new StringBuilder("Zte/NUBIA/");
                    stringBuilder3.append(a);
                    stringBuilder3.append("_");
                    stringBuilder3.append(z.a(context, "ro.build.nubia.rom.code"));
                    return stringBuilder3.toString();
                }
                String a2 = z.a(context, "ro.build.version.incremental");
                stringBuilder2 = new StringBuilder("Lenovo/VIBE/");
                stringBuilder2.append(a2);
                return stringBuilder2.toString();
            }
            stringBuilder = new StringBuilder("HuaWei/EMOTION/");
            stringBuilder.append(a);
            return stringBuilder.toString();
        }
        stringBuilder = new StringBuilder("XiaoMi/MIUI/");
        stringBuilder.append(a);
        return stringBuilder.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:82:0x0118 A:{Catch:{ all -> 0x013e }} */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x011d A:{SYNTHETIC, Splitter:B:84:0x011d} */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x012d A:{SYNTHETIC, Splitter:B:91:0x012d} */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0118 A:{Catch:{ all -> 0x013e }} */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x011d A:{SYNTHETIC, Splitter:B:84:0x011d} */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x012d A:{SYNTHETIC, Splitter:B:91:0x012d} */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0141 A:{SYNTHETIC, Splitter:B:101:0x0141} */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0151 A:{SYNTHETIC, Splitter:B:108:0x0151} */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0141 A:{SYNTHETIC, Splitter:B:101:0x0141} */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0151 A:{SYNTHETIC, Splitter:B:108:0x0151} */
    public static long h() {
        /*
        r0 = "/proc/meminfo";
        r1 = 0;
        r2 = new java.io.FileReader;	 Catch:{ Throwable -> 0x010e, all -> 0x0109 }
        r2.<init>(r0);	 Catch:{ Throwable -> 0x010e, all -> 0x0109 }
        r0 = new java.io.BufferedReader;	 Catch:{ Throwable -> 0x0104, all -> 0x00ff }
        r3 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;
        r0.<init>(r2, r3);	 Catch:{ Throwable -> 0x0104, all -> 0x00ff }
        r0.readLine();	 Catch:{ Throwable -> 0x00fd }
        r1 = r0.readLine();	 Catch:{ Throwable -> 0x00fd }
        r3 = -1;
        if (r1 != 0) goto L_0x0037;
    L_0x001a:
        r0.close();	 Catch:{ IOException -> 0x001e }
        goto L_0x0028;
    L_0x001e:
        r0 = move-exception;
        r1 = com.tencent.bugly.proguard.x.a(r0);
        if (r1 != 0) goto L_0x0028;
    L_0x0025:
        r0.printStackTrace();
    L_0x0028:
        r2.close();	 Catch:{ IOException -> 0x002c }
        goto L_0x0036;
    L_0x002c:
        r0 = move-exception;
        r1 = com.tencent.bugly.proguard.x.a(r0);
        if (r1 != 0) goto L_0x0036;
    L_0x0033:
        r0.printStackTrace();
    L_0x0036:
        return r3;
    L_0x0037:
        r5 = ":\\s+";
        r6 = 2;
        r1 = r1.split(r5, r6);	 Catch:{ Throwable -> 0x00fd }
        r5 = 1;
        r1 = r1[r5];	 Catch:{ Throwable -> 0x00fd }
        r1 = r1.toLowerCase();	 Catch:{ Throwable -> 0x00fd }
        r7 = "kb";
        r8 = "";
        r1 = r1.replace(r7, r8);	 Catch:{ Throwable -> 0x00fd }
        r1 = r1.trim();	 Catch:{ Throwable -> 0x00fd }
        r7 = 0;
        r9 = java.lang.Long.parseLong(r1);	 Catch:{ Throwable -> 0x00fd }
        r1 = 10;
        r9 = r9 << r1;
        r11 = r7 + r9;
        r7 = r0.readLine();	 Catch:{ Throwable -> 0x00fd }
        if (r7 != 0) goto L_0x007f;
    L_0x0062:
        r0.close();	 Catch:{ IOException -> 0x0066 }
        goto L_0x0070;
    L_0x0066:
        r0 = move-exception;
        r1 = com.tencent.bugly.proguard.x.a(r0);
        if (r1 != 0) goto L_0x0070;
    L_0x006d:
        r0.printStackTrace();
    L_0x0070:
        r2.close();	 Catch:{ IOException -> 0x0074 }
        goto L_0x007e;
    L_0x0074:
        r0 = move-exception;
        r1 = com.tencent.bugly.proguard.x.a(r0);
        if (r1 != 0) goto L_0x007e;
    L_0x007b:
        r0.printStackTrace();
    L_0x007e:
        return r3;
    L_0x007f:
        r8 = ":\\s+";
        r7 = r7.split(r8, r6);	 Catch:{ Throwable -> 0x00fd }
        r7 = r7[r5];	 Catch:{ Throwable -> 0x00fd }
        r7 = r7.toLowerCase();	 Catch:{ Throwable -> 0x00fd }
        r8 = "kb";
        r9 = "";
        r7 = r7.replace(r8, r9);	 Catch:{ Throwable -> 0x00fd }
        r7 = r7.trim();	 Catch:{ Throwable -> 0x00fd }
        r7 = java.lang.Long.parseLong(r7);	 Catch:{ Throwable -> 0x00fd }
        r7 = r7 << r1;
        r9 = r11 + r7;
        r7 = r0.readLine();	 Catch:{ Throwable -> 0x00fd }
        if (r7 != 0) goto L_0x00c1;
    L_0x00a4:
        r0.close();	 Catch:{ IOException -> 0x00a8 }
        goto L_0x00b2;
    L_0x00a8:
        r0 = move-exception;
        r1 = com.tencent.bugly.proguard.x.a(r0);
        if (r1 != 0) goto L_0x00b2;
    L_0x00af:
        r0.printStackTrace();
    L_0x00b2:
        r2.close();	 Catch:{ IOException -> 0x00b6 }
        goto L_0x00c0;
    L_0x00b6:
        r0 = move-exception;
        r1 = com.tencent.bugly.proguard.x.a(r0);
        if (r1 != 0) goto L_0x00c0;
    L_0x00bd:
        r0.printStackTrace();
    L_0x00c0:
        return r3;
    L_0x00c1:
        r3 = ":\\s+";
        r3 = r7.split(r3, r6);	 Catch:{ Throwable -> 0x00fd }
        r3 = r3[r5];	 Catch:{ Throwable -> 0x00fd }
        r3 = r3.toLowerCase();	 Catch:{ Throwable -> 0x00fd }
        r4 = "kb";
        r5 = "";
        r3 = r3.replace(r4, r5);	 Catch:{ Throwable -> 0x00fd }
        r3 = r3.trim();	 Catch:{ Throwable -> 0x00fd }
        r3 = java.lang.Long.parseLong(r3);	 Catch:{ Throwable -> 0x00fd }
        r3 = r3 << r1;
        r5 = r9 + r3;
        r0.close();	 Catch:{ IOException -> 0x00e4 }
        goto L_0x00ee;
    L_0x00e4:
        r0 = move-exception;
        r1 = com.tencent.bugly.proguard.x.a(r0);
        if (r1 != 0) goto L_0x00ee;
    L_0x00eb:
        r0.printStackTrace();
    L_0x00ee:
        r2.close();	 Catch:{ IOException -> 0x00f2 }
        goto L_0x00fc;
    L_0x00f2:
        r0 = move-exception;
        r1 = com.tencent.bugly.proguard.x.a(r0);
        if (r1 != 0) goto L_0x00fc;
    L_0x00f9:
        r0.printStackTrace();
    L_0x00fc:
        return r5;
    L_0x00fd:
        r1 = move-exception;
        goto L_0x0112;
    L_0x00ff:
        r0 = move-exception;
        r13 = r1;
        r1 = r0;
        r0 = r13;
        goto L_0x013f;
    L_0x0104:
        r0 = move-exception;
        r13 = r1;
        r1 = r0;
        r0 = r13;
        goto L_0x0112;
    L_0x0109:
        r0 = move-exception;
        r2 = r1;
        r1 = r0;
        r0 = r2;
        goto L_0x013f;
    L_0x010e:
        r0 = move-exception;
        r2 = r1;
        r1 = r0;
        r0 = r2;
    L_0x0112:
        r3 = com.tencent.bugly.proguard.x.a(r1);	 Catch:{ all -> 0x013e }
        if (r3 != 0) goto L_0x011b;
    L_0x0118:
        r1.printStackTrace();	 Catch:{ all -> 0x013e }
    L_0x011b:
        if (r0 == 0) goto L_0x012b;
    L_0x011d:
        r0.close();	 Catch:{ IOException -> 0x0121 }
        goto L_0x012b;
    L_0x0121:
        r0 = move-exception;
        r1 = com.tencent.bugly.proguard.x.a(r0);
        if (r1 != 0) goto L_0x012b;
    L_0x0128:
        r0.printStackTrace();
    L_0x012b:
        if (r2 == 0) goto L_0x013b;
    L_0x012d:
        r2.close();	 Catch:{ IOException -> 0x0131 }
        goto L_0x013b;
    L_0x0131:
        r0 = move-exception;
        r1 = com.tencent.bugly.proguard.x.a(r0);
        if (r1 != 0) goto L_0x013b;
    L_0x0138:
        r0.printStackTrace();
    L_0x013b:
        r0 = -2;
        return r0;
    L_0x013e:
        r1 = move-exception;
    L_0x013f:
        if (r0 == 0) goto L_0x014f;
    L_0x0141:
        r0.close();	 Catch:{ IOException -> 0x0145 }
        goto L_0x014f;
    L_0x0145:
        r0 = move-exception;
        r3 = com.tencent.bugly.proguard.x.a(r0);
        if (r3 != 0) goto L_0x014f;
    L_0x014c:
        r0.printStackTrace();
    L_0x014f:
        if (r2 == 0) goto L_0x015f;
    L_0x0151:
        r2.close();	 Catch:{ IOException -> 0x0155 }
        goto L_0x015f;
    L_0x0155:
        r0 = move-exception;
        r2 = com.tencent.bugly.proguard.x.a(r0);
        if (r2 != 0) goto L_0x015f;
    L_0x015c:
        r0.printStackTrace();
    L_0x015f:
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.common.info.b.h():long");
    }

    public static String h(Context context) {
        return z.a(context, "ro.board.platform");
    }

    public static long i() {
        if (!p()) {
            return 0;
        }
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return -2;
        }
    }

    public static boolean i(Context context) {
        boolean exists;
        try {
            exists = new File("/system/app/Superuser.apk").exists();
        } catch (Throwable th) {
            if (!x.b(th)) {
                th.printStackTrace();
            }
            exists = false;
        }
        Boolean bool = null;
        ArrayList a = z.a(context, new String[]{"/system/bin/sh", "-c", "type su"});
        if (a != null && a.size() > 0) {
            Iterator it = a.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                x.c(str, new Object[0]);
                if (str.contains("not found")) {
                    bool = Boolean.valueOf(false);
                }
            }
            if (bool == null) {
                bool = Boolean.valueOf(true);
            }
        }
        Boolean valueOf = Boolean.valueOf(bool == null ? false : bool.booleanValue());
        int i = (Build.TAGS == null || !Build.TAGS.contains("test-keys")) ? 0 : 1;
        return i != 0 || exists || valueOf.booleanValue();
    }

    public static long j() {
        if (!p()) {
            return 0;
        }
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return -2;
        }
    }

    public static String j(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        String a = z.a(context, "ro.genymotion.version");
        if (a != null) {
            stringBuilder.append("ro.genymotion.version");
            stringBuilder.append("|");
            stringBuilder.append(a);
            stringBuilder.append("\n");
        }
        a = z.a(context, "androVM.vbox_dpi");
        if (a != null) {
            stringBuilder.append("androVM.vbox_dpi");
            stringBuilder.append("|");
            stringBuilder.append(a);
            stringBuilder.append("\n");
        }
        String a2 = z.a(context, "qemu.sf.fake_camera");
        if (a2 != null) {
            stringBuilder.append("qemu.sf.fake_camera");
            stringBuilder.append("|");
            stringBuilder.append(a2);
        }
        return stringBuilder.toString();
    }

    public static String k() {
        String str = "fail";
        try {
            return Locale.getDefault().getCountry();
        } catch (Throwable th) {
            if (x.a(th)) {
                return str;
            }
            th.printStackTrace();
            return str;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x009d A:{SYNTHETIC, Splitter:B:36:0x009d} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ad A:{SYNTHETIC, Splitter:B:44:0x00ad} */
    public static java.lang.String k(android.content.Context r5) {
        /*
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = a;
        if (r1 != 0) goto L_0x0011;
    L_0x0009:
        r1 = "ro.secure";
        r1 = com.tencent.bugly.proguard.z.a(r5, r1);
        a = r1;
    L_0x0011:
        r1 = a;
        if (r1 == 0) goto L_0x0029;
    L_0x0015:
        r1 = "ro.secure";
        r0.append(r1);
        r1 = "|";
        r0.append(r1);
        r1 = a;
        r0.append(r1);
        r1 = "\n";
        r0.append(r1);
    L_0x0029:
        r1 = b;
        if (r1 != 0) goto L_0x0035;
    L_0x002d:
        r1 = "ro.debuggable";
        r5 = com.tencent.bugly.proguard.z.a(r5, r1);
        b = r5;
    L_0x0035:
        r5 = b;
        if (r5 == 0) goto L_0x004d;
    L_0x0039:
        r5 = "ro.debuggable";
        r0.append(r5);
        r5 = "|";
        r0.append(r5);
        r5 = b;
        r0.append(r5);
        r5 = "\n";
        r0.append(r5);
    L_0x004d:
        r5 = 0;
        r1 = new java.io.BufferedReader;	 Catch:{ Throwable -> 0x0094, all -> 0x0090 }
        r2 = new java.io.FileReader;	 Catch:{ Throwable -> 0x0094, all -> 0x0090 }
        r3 = "/proc/self/status";
        r2.<init>(r3);	 Catch:{ Throwable -> 0x0094, all -> 0x0090 }
        r1.<init>(r2);	 Catch:{ Throwable -> 0x0094, all -> 0x0090 }
    L_0x005a:
        r5 = r1.readLine();	 Catch:{ Throwable -> 0x008e }
        if (r5 == 0) goto L_0x0068;
    L_0x0060:
        r2 = "TracerPid:";
        r2 = r5.startsWith(r2);	 Catch:{ Throwable -> 0x008e }
        if (r2 == 0) goto L_0x005a;
    L_0x0068:
        if (r5 == 0) goto L_0x0081;
    L_0x006a:
        r2 = 10;
        r5 = r5.substring(r2);	 Catch:{ Throwable -> 0x008e }
        r5 = r5.trim();	 Catch:{ Throwable -> 0x008e }
        r2 = "tracer_pid";
        r0.append(r2);	 Catch:{ Throwable -> 0x008e }
        r2 = "|";
        r0.append(r2);	 Catch:{ Throwable -> 0x008e }
        r0.append(r5);	 Catch:{ Throwable -> 0x008e }
    L_0x0081:
        r5 = r0.toString();	 Catch:{ Throwable -> 0x008e }
        r1.close();	 Catch:{ IOException -> 0x0089 }
        goto L_0x008d;
    L_0x0089:
        r0 = move-exception;
        com.tencent.bugly.proguard.x.a(r0);
    L_0x008d:
        return r5;
    L_0x008e:
        r5 = move-exception;
        goto L_0x0098;
    L_0x0090:
        r0 = move-exception;
        r1 = r5;
        r5 = r0;
        goto L_0x00ab;
    L_0x0094:
        r1 = move-exception;
        r4 = r1;
        r1 = r5;
        r5 = r4;
    L_0x0098:
        com.tencent.bugly.proguard.x.a(r5);	 Catch:{ all -> 0x00aa }
        if (r1 == 0) goto L_0x00a5;
    L_0x009d:
        r1.close();	 Catch:{ IOException -> 0x00a1 }
        goto L_0x00a5;
    L_0x00a1:
        r5 = move-exception;
        com.tencent.bugly.proguard.x.a(r5);
    L_0x00a5:
        r5 = r0.toString();
        return r5;
    L_0x00aa:
        r5 = move-exception;
    L_0x00ab:
        if (r1 == 0) goto L_0x00b5;
    L_0x00ad:
        r1.close();	 Catch:{ IOException -> 0x00b1 }
        goto L_0x00b5;
    L_0x00b1:
        r0 = move-exception;
        com.tencent.bugly.proguard.x.a(r0);
    L_0x00b5:
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.common.info.b.k(android.content.Context):java.lang.String");
    }

    public static String l() {
        String str = "fail";
        try {
            return Build.BRAND;
        } catch (Throwable th) {
            if (x.a(th)) {
                return str;
            }
            th.printStackTrace();
            return str;
        }
    }

    public static String l(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        String a = z.a(context, "gsm.sim.state");
        if (a != null) {
            stringBuilder.append("gsm.sim.state");
            stringBuilder.append("|");
            stringBuilder.append(a);
        }
        stringBuilder.append("\n");
        String a2 = z.a(context, "gsm.sim.state2");
        if (a2 != null) {
            stringBuilder.append("gsm.sim.state2");
            stringBuilder.append("|");
            stringBuilder.append(a2);
        }
        return stringBuilder.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a8 A:{SYNTHETIC, Splitter:B:54:0x00a8} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x009c A:{SYNTHETIC, Splitter:B:45:0x009c} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a8 A:{SYNTHETIC, Splitter:B:54:0x00a8} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x009c A:{SYNTHETIC, Splitter:B:45:0x009c} */
    public static java.lang.String m() {
        /*
        r0 = 0;
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00a5, all -> 0x0097 }
        r1.<init>();	 Catch:{ Throwable -> 0x00a5, all -> 0x0097 }
        r2 = new java.io.File;	 Catch:{ Throwable -> 0x00a5, all -> 0x0097 }
        r3 = "/sys/block/mmcblk0/device/type";
        r2.<init>(r3);	 Catch:{ Throwable -> 0x00a5, all -> 0x0097 }
        r2 = r2.exists();	 Catch:{ Throwable -> 0x00a5, all -> 0x0097 }
        if (r2 == 0) goto L_0x002c;
    L_0x0013:
        r2 = new java.io.BufferedReader;	 Catch:{ Throwable -> 0x00a5, all -> 0x0097 }
        r3 = new java.io.FileReader;	 Catch:{ Throwable -> 0x00a5, all -> 0x0097 }
        r4 = "/sys/block/mmcblk0/device/type";
        r3.<init>(r4);	 Catch:{ Throwable -> 0x00a5, all -> 0x0097 }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x00a5, all -> 0x0097 }
        r3 = r2.readLine();	 Catch:{ Throwable -> 0x00a6, all -> 0x0095 }
        if (r3 == 0) goto L_0x0028;
    L_0x0025:
        r1.append(r3);	 Catch:{ Throwable -> 0x00a6, all -> 0x0095 }
    L_0x0028:
        r2.close();	 Catch:{ Throwable -> 0x00a6, all -> 0x0095 }
        goto L_0x002d;
    L_0x002c:
        r2 = r0;
    L_0x002d:
        r3 = ",";
        r1.append(r3);	 Catch:{ Throwable -> 0x00a6, all -> 0x0095 }
        r3 = new java.io.File;	 Catch:{ Throwable -> 0x00a6, all -> 0x0095 }
        r4 = "/sys/block/mmcblk0/device/name";
        r3.<init>(r4);	 Catch:{ Throwable -> 0x00a6, all -> 0x0095 }
        r3 = r3.exists();	 Catch:{ Throwable -> 0x00a6, all -> 0x0095 }
        if (r3 == 0) goto L_0x005e;
    L_0x003f:
        r3 = new java.io.BufferedReader;	 Catch:{ Throwable -> 0x00a6, all -> 0x0095 }
        r4 = new java.io.FileReader;	 Catch:{ Throwable -> 0x00a6, all -> 0x0095 }
        r5 = "/sys/block/mmcblk0/device/name";
        r4.<init>(r5);	 Catch:{ Throwable -> 0x00a6, all -> 0x0095 }
        r3.<init>(r4);	 Catch:{ Throwable -> 0x00a6, all -> 0x0095 }
        r2 = r3.readLine();	 Catch:{ Throwable -> 0x005c, all -> 0x0059 }
        if (r2 == 0) goto L_0x0054;
    L_0x0051:
        r1.append(r2);	 Catch:{ Throwable -> 0x005c, all -> 0x0059 }
    L_0x0054:
        r3.close();	 Catch:{ Throwable -> 0x005c, all -> 0x0059 }
        r2 = r3;
        goto L_0x005e;
    L_0x0059:
        r0 = move-exception;
        r2 = r3;
        goto L_0x009a;
    L_0x005c:
        r2 = r3;
        goto L_0x00a6;
    L_0x005e:
        r3 = ",";
        r1.append(r3);	 Catch:{ Throwable -> 0x00a6, all -> 0x0095 }
        r3 = new java.io.File;	 Catch:{ Throwable -> 0x00a6, all -> 0x0095 }
        r4 = "/sys/block/mmcblk0/device/cid";
        r3.<init>(r4);	 Catch:{ Throwable -> 0x00a6, all -> 0x0095 }
        r3 = r3.exists();	 Catch:{ Throwable -> 0x00a6, all -> 0x0095 }
        if (r3 == 0) goto L_0x0086;
    L_0x0070:
        r3 = new java.io.BufferedReader;	 Catch:{ Throwable -> 0x00a6, all -> 0x0095 }
        r4 = new java.io.FileReader;	 Catch:{ Throwable -> 0x00a6, all -> 0x0095 }
        r5 = "/sys/block/mmcblk0/device/cid";
        r4.<init>(r5);	 Catch:{ Throwable -> 0x00a6, all -> 0x0095 }
        r3.<init>(r4);	 Catch:{ Throwable -> 0x00a6, all -> 0x0095 }
        r2 = r3.readLine();	 Catch:{ Throwable -> 0x005c, all -> 0x0059 }
        if (r2 == 0) goto L_0x0085;
    L_0x0082:
        r1.append(r2);	 Catch:{ Throwable -> 0x005c, all -> 0x0059 }
    L_0x0085:
        r2 = r3;
    L_0x0086:
        r1 = r1.toString();	 Catch:{ Throwable -> 0x00a6, all -> 0x0095 }
        if (r2 == 0) goto L_0x0094;
    L_0x008c:
        r2.close();	 Catch:{ IOException -> 0x0090 }
        goto L_0x0094;
    L_0x0090:
        r0 = move-exception;
        com.tencent.bugly.proguard.x.a(r0);
    L_0x0094:
        return r1;
    L_0x0095:
        r0 = move-exception;
        goto L_0x009a;
    L_0x0097:
        r1 = move-exception;
        r2 = r0;
        r0 = r1;
    L_0x009a:
        if (r2 == 0) goto L_0x00a4;
    L_0x009c:
        r2.close();	 Catch:{ IOException -> 0x00a0 }
        goto L_0x00a4;
    L_0x00a0:
        r1 = move-exception;
        com.tencent.bugly.proguard.x.a(r1);
    L_0x00a4:
        throw r0;
    L_0x00a5:
        r2 = r0;
    L_0x00a6:
        if (r2 == 0) goto L_0x00b0;
    L_0x00a8:
        r2.close();	 Catch:{ IOException -> 0x00ac }
        goto L_0x00b0;
    L_0x00ac:
        r1 = move-exception;
        com.tencent.bugly.proguard.x.a(r1);
    L_0x00b0:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.common.info.b.m():java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00bc A:{SYNTHETIC, Splitter:B:47:0x00bc} */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b1 A:{SYNTHETIC, Splitter:B:40:0x00b1} */
    public static java.lang.String n() {
        /*
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = 0;
        r2 = new java.io.File;	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
        r3 = "/sys/class/power_supply/ac/online";
        r2.<init>(r3);	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
        r2 = r2.exists();	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
        if (r2 == 0) goto L_0x003e;
    L_0x0013:
        r2 = new java.io.BufferedReader;	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
        r3 = new java.io.FileReader;	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
        r4 = "/sys/class/power_supply/ac/online";
        r3.<init>(r4);	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
        r1 = r2.readLine();	 Catch:{ Throwable -> 0x003b, all -> 0x0037 }
        if (r1 == 0) goto L_0x0032;
    L_0x0025:
        r3 = "ac_online";
        r0.append(r3);	 Catch:{ Throwable -> 0x003b, all -> 0x0037 }
        r3 = "|";
        r0.append(r3);	 Catch:{ Throwable -> 0x003b, all -> 0x0037 }
        r0.append(r1);	 Catch:{ Throwable -> 0x003b, all -> 0x0037 }
    L_0x0032:
        r2.close();	 Catch:{ Throwable -> 0x003b, all -> 0x0037 }
        r1 = r2;
        goto L_0x003e;
    L_0x0037:
        r0 = move-exception;
        r1 = r2;
        goto L_0x00af;
    L_0x003b:
        r1 = r2;
        goto L_0x00ba;
    L_0x003e:
        r2 = "\n";
        r0.append(r2);	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
        r2 = new java.io.File;	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
        r3 = "/sys/class/power_supply/usb/online";
        r2.<init>(r3);	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
        r2 = r2.exists();	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
        if (r2 == 0) goto L_0x0073;
    L_0x0050:
        r2 = new java.io.BufferedReader;	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
        r3 = new java.io.FileReader;	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
        r4 = "/sys/class/power_supply/usb/online";
        r3.<init>(r4);	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
        r1 = r2.readLine();	 Catch:{ Throwable -> 0x003b, all -> 0x0037 }
        if (r1 == 0) goto L_0x006f;
    L_0x0062:
        r3 = "usb_online";
        r0.append(r3);	 Catch:{ Throwable -> 0x003b, all -> 0x0037 }
        r3 = "|";
        r0.append(r3);	 Catch:{ Throwable -> 0x003b, all -> 0x0037 }
        r0.append(r1);	 Catch:{ Throwable -> 0x003b, all -> 0x0037 }
    L_0x006f:
        r2.close();	 Catch:{ Throwable -> 0x003b, all -> 0x0037 }
        r1 = r2;
    L_0x0073:
        r2 = "\n";
        r0.append(r2);	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
        r2 = new java.io.File;	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
        r3 = "/sys/class/power_supply/battery/capacity";
        r2.<init>(r3);	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
        r2 = r2.exists();	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
        if (r2 == 0) goto L_0x00a8;
    L_0x0085:
        r2 = new java.io.BufferedReader;	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
        r3 = new java.io.FileReader;	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
        r4 = "/sys/class/power_supply/battery/capacity";
        r3.<init>(r4);	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
        r1 = r2.readLine();	 Catch:{ Throwable -> 0x003b, all -> 0x0037 }
        if (r1 == 0) goto L_0x00a4;
    L_0x0097:
        r3 = "battery_capacity";
        r0.append(r3);	 Catch:{ Throwable -> 0x003b, all -> 0x0037 }
        r3 = "|";
        r0.append(r3);	 Catch:{ Throwable -> 0x003b, all -> 0x0037 }
        r0.append(r1);	 Catch:{ Throwable -> 0x003b, all -> 0x0037 }
    L_0x00a4:
        r2.close();	 Catch:{ Throwable -> 0x003b, all -> 0x0037 }
        r1 = r2;
    L_0x00a8:
        if (r1 == 0) goto L_0x00c4;
    L_0x00aa:
        r1.close();	 Catch:{ IOException -> 0x00c0 }
        goto L_0x00c4;
    L_0x00ae:
        r0 = move-exception;
    L_0x00af:
        if (r1 == 0) goto L_0x00b9;
    L_0x00b1:
        r1.close();	 Catch:{ IOException -> 0x00b5 }
        goto L_0x00b9;
    L_0x00b5:
        r1 = move-exception;
        com.tencent.bugly.proguard.x.a(r1);
    L_0x00b9:
        throw r0;
    L_0x00ba:
        if (r1 == 0) goto L_0x00c4;
    L_0x00bc:
        r1.close();	 Catch:{ IOException -> 0x00c0 }
        goto L_0x00c4;
    L_0x00c0:
        r1 = move-exception;
        com.tencent.bugly.proguard.x.a(r1);
    L_0x00c4:
        r0 = r0.toString();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.common.info.b.n():java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x004a A:{SYNTHETIC, Splitter:B:26:0x004a} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0042 A:{SYNTHETIC, Splitter:B:20:0x0042} */
    public static long o() {
        /*
        r0 = 0;
        r1 = 0;
        r2 = new java.io.BufferedReader;	 Catch:{ Throwable -> 0x0039, all -> 0x0036 }
        r3 = new java.io.FileReader;	 Catch:{ Throwable -> 0x0039, all -> 0x0036 }
        r4 = "/proc/uptime";
        r3.<init>(r4);	 Catch:{ Throwable -> 0x0039, all -> 0x0036 }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x0039, all -> 0x0036 }
        r1 = r2.readLine();	 Catch:{ Throwable -> 0x0034 }
        if (r1 == 0) goto L_0x002b;
    L_0x0014:
        r3 = " ";
        r1 = r1.split(r3);	 Catch:{ Throwable -> 0x0034 }
        r3 = 0;
        r1 = r1[r3];	 Catch:{ Throwable -> 0x0034 }
        r3 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x0034 }
        r5 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r3 = r3 / r5;
        r3 = (float) r3;	 Catch:{ Throwable -> 0x0034 }
        r1 = java.lang.Float.parseFloat(r1);	 Catch:{ Throwable -> 0x0034 }
        r3 = r3 - r1;
        r0 = r3;
    L_0x002b:
        r2.close();	 Catch:{ IOException -> 0x002f }
        goto L_0x0045;
    L_0x002f:
        r1 = move-exception;
        com.tencent.bugly.proguard.x.a(r1);
        goto L_0x0045;
    L_0x0034:
        r1 = move-exception;
        goto L_0x003d;
    L_0x0036:
        r0 = move-exception;
        r2 = r1;
        goto L_0x0048;
    L_0x0039:
        r2 = move-exception;
        r7 = r2;
        r2 = r1;
        r1 = r7;
    L_0x003d:
        com.tencent.bugly.proguard.x.a(r1);	 Catch:{ all -> 0x0047 }
        if (r2 == 0) goto L_0x0045;
    L_0x0042:
        r2.close();	 Catch:{ IOException -> 0x002f }
    L_0x0045:
        r0 = (long) r0;
        return r0;
    L_0x0047:
        r0 = move-exception;
    L_0x0048:
        if (r2 == 0) goto L_0x0052;
    L_0x004a:
        r2.close();	 Catch:{ IOException -> 0x004e }
        goto L_0x0052;
    L_0x004e:
        r1 = move-exception;
        com.tencent.bugly.proguard.x.a(r1);
    L_0x0052:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.common.info.b.o():long");
    }

    private static boolean p() {
        try {
            if (Environment.getExternalStorageState().equals("mounted")) {
                return true;
            }
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x007b A:{Catch:{ all -> 0x009f }} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0080 A:{SYNTHETIC, Splitter:B:46:0x0080} */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0090 A:{SYNTHETIC, Splitter:B:53:0x0090} */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00a2 A:{SYNTHETIC, Splitter:B:62:0x00a2} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00b2 A:{SYNTHETIC, Splitter:B:69:0x00b2} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x007b A:{Catch:{ all -> 0x009f }} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0080 A:{SYNTHETIC, Splitter:B:46:0x0080} */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0090 A:{SYNTHETIC, Splitter:B:53:0x0090} */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00a2 A:{SYNTHETIC, Splitter:B:62:0x00a2} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00b2 A:{SYNTHETIC, Splitter:B:69:0x00b2} */
    private static java.lang.String q() {
        /*
        r0 = "/system/build.prop";
        r1 = 0;
        r2 = new java.io.FileReader;	 Catch:{ Throwable -> 0x0072, all -> 0x006d }
        r2.<init>(r0);	 Catch:{ Throwable -> 0x0072, all -> 0x006d }
        r0 = new java.io.BufferedReader;	 Catch:{ Throwable -> 0x006a, all -> 0x0065 }
        r3 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;
        r0.<init>(r2, r3);	 Catch:{ Throwable -> 0x006a, all -> 0x0065 }
    L_0x000f:
        r3 = r0.readLine();	 Catch:{ Throwable -> 0x0063 }
        r4 = 0;
        if (r3 == 0) goto L_0x003b;
    L_0x0016:
        r5 = "=";
        r6 = 2;
        r3 = r3.split(r5, r6);	 Catch:{ Throwable -> 0x0063 }
        r5 = r3.length;	 Catch:{ Throwable -> 0x0063 }
        if (r5 != r6) goto L_0x000f;
    L_0x0020:
        r5 = r3[r4];	 Catch:{ Throwable -> 0x0063 }
        r6 = "ro.product.cpu.abilist";
        r5 = r5.equals(r6);	 Catch:{ Throwable -> 0x0063 }
        r6 = 1;
        if (r5 == 0) goto L_0x002e;
    L_0x002b:
        r3 = r3[r6];	 Catch:{ Throwable -> 0x0063 }
        goto L_0x003c;
    L_0x002e:
        r5 = r3[r4];	 Catch:{ Throwable -> 0x0063 }
        r7 = "ro.product.cpu.abi";
        r5 = r5.equals(r7);	 Catch:{ Throwable -> 0x0063 }
        if (r5 == 0) goto L_0x000f;
    L_0x0038:
        r3 = r3[r6];	 Catch:{ Throwable -> 0x0063 }
        goto L_0x003c;
    L_0x003b:
        r3 = r1;
    L_0x003c:
        if (r3 == 0) goto L_0x0046;
    L_0x003e:
        r5 = ",";
        r3 = r3.split(r5);	 Catch:{ Throwable -> 0x0063 }
        r3 = r3[r4];	 Catch:{ Throwable -> 0x0063 }
    L_0x0046:
        r0.close();	 Catch:{ IOException -> 0x004a }
        goto L_0x0054;
    L_0x004a:
        r0 = move-exception;
        r1 = com.tencent.bugly.proguard.x.a(r0);
        if (r1 != 0) goto L_0x0054;
    L_0x0051:
        r0.printStackTrace();
    L_0x0054:
        r2.close();	 Catch:{ IOException -> 0x0058 }
        goto L_0x0062;
    L_0x0058:
        r0 = move-exception;
        r1 = com.tencent.bugly.proguard.x.a(r0);
        if (r1 != 0) goto L_0x0062;
    L_0x005f:
        r0.printStackTrace();
    L_0x0062:
        return r3;
    L_0x0063:
        r3 = move-exception;
        goto L_0x0075;
    L_0x0065:
        r0 = move-exception;
        r8 = r1;
        r1 = r0;
        r0 = r8;
        goto L_0x00a0;
    L_0x006a:
        r3 = move-exception;
        r0 = r1;
        goto L_0x0075;
    L_0x006d:
        r0 = move-exception;
        r2 = r1;
        r1 = r0;
        r0 = r2;
        goto L_0x00a0;
    L_0x0072:
        r3 = move-exception;
        r0 = r1;
        r2 = r0;
    L_0x0075:
        r4 = com.tencent.bugly.proguard.x.a(r3);	 Catch:{ all -> 0x009f }
        if (r4 != 0) goto L_0x007e;
    L_0x007b:
        r3.printStackTrace();	 Catch:{ all -> 0x009f }
    L_0x007e:
        if (r0 == 0) goto L_0x008e;
    L_0x0080:
        r0.close();	 Catch:{ IOException -> 0x0084 }
        goto L_0x008e;
    L_0x0084:
        r0 = move-exception;
        r3 = com.tencent.bugly.proguard.x.a(r0);
        if (r3 != 0) goto L_0x008e;
    L_0x008b:
        r0.printStackTrace();
    L_0x008e:
        if (r2 == 0) goto L_0x009e;
    L_0x0090:
        r2.close();	 Catch:{ IOException -> 0x0094 }
        goto L_0x009e;
    L_0x0094:
        r0 = move-exception;
        r2 = com.tencent.bugly.proguard.x.a(r0);
        if (r2 != 0) goto L_0x009e;
    L_0x009b:
        r0.printStackTrace();
    L_0x009e:
        return r1;
    L_0x009f:
        r1 = move-exception;
    L_0x00a0:
        if (r0 == 0) goto L_0x00b0;
    L_0x00a2:
        r0.close();	 Catch:{ IOException -> 0x00a6 }
        goto L_0x00b0;
    L_0x00a6:
        r0 = move-exception;
        r3 = com.tencent.bugly.proguard.x.a(r0);
        if (r3 != 0) goto L_0x00b0;
    L_0x00ad:
        r0.printStackTrace();
    L_0x00b0:
        if (r2 == 0) goto L_0x00c0;
    L_0x00b2:
        r2.close();	 Catch:{ IOException -> 0x00b6 }
        goto L_0x00c0;
    L_0x00b6:
        r0 = move-exception;
        r2 = com.tencent.bugly.proguard.x.a(r0);
        if (r2 != 0) goto L_0x00c0;
    L_0x00bd:
        r0.printStackTrace();
    L_0x00c0:
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.common.info.b.q():java.lang.String");
    }
}
