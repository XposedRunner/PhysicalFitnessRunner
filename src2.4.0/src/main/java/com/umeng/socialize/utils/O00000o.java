package com.umeng.socialize.utils;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.Settings.Secure;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import defpackage.db;

/* compiled from: DeviceConfig */
public class O00000o {
    protected static final String O000000o = "DeviceConfig";
    protected static final String O00000Oo = "Unknown";
    private static final String O00000o = "2G/3G";
    public static Context O00000o0 = null;
    private static final String O00000oO = "Wi-Fi";
    private static Object O00000oo = new Object();

    public static String O000000o() {
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", new Class[]{String.class, String.class}).invoke(cls, new Object[]{"ro.serialno", "unknown"});
        } catch (Exception unused) {
            return null;
        }
    }

    public static String O000000o(Context context) {
        return DeviceConfig.getDeviceId(context);
    }

    public static boolean O000000o(Context context, String str) {
        return DeviceConfig.checkPermission(context, str);
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0013 */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    public static boolean O000000o(java.lang.String r3, android.content.Context r4) {
        /*
        r0 = 0;
        if (r4 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = O00000oo;
        monitor-enter(r1);
        r2 = 1;
        r4 = r4.getPackageManager();	 Catch:{ NameNotFoundException | RuntimeException -> 0x0013, NameNotFoundException | RuntimeException -> 0x0013 }
        r4.getPackageInfo(r3, r2);	 Catch:{ NameNotFoundException | RuntimeException -> 0x0013, NameNotFoundException | RuntimeException -> 0x0013 }
        r0 = r2;
        goto L_0x0013;
    L_0x0011:
        r3 = move-exception;
        goto L_0x0015;
    L_0x0013:
        monitor-exit(r1);	 Catch:{ all -> 0x0011 }
        return r0;
    L_0x0015:
        monitor-exit(r1);	 Catch:{ all -> 0x0011 }
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.utils.O00000o.O000000o(java.lang.String, android.content.Context):boolean");
    }

    public static String O00000Oo(String str, Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean O00000Oo() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static String[] O00000Oo(Context context) {
        return DeviceConfig.getNetworkAccessMode(context);
    }

    public static boolean O00000o(Context context) {
        return context != null && O000000o(context, "android.permission.ACCESS_NETWORK_STATE") && O00000o0(context);
    }

    public static String O00000o0() {
        return VERSION.RELEASE;
    }

    public static boolean O00000o0(Context context) {
        return DeviceConfig.isOnline(context);
    }

    public static String O00000oO(Context context) {
        return context == null ? "" : Secure.getString(context.getContentResolver(), db.O000000o);
    }

    public static String O00000oo(Context context) {
        return DeviceConfig.getMac(context);
    }

    public static String O0000O0o(Context context) {
        return context == null ? "" : context.getPackageName();
    }
}
