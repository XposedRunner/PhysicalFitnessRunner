package com.umeng.commonsdk.internal.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.JSONObject;

/* compiled from: UMProbe */
public class l {
    public static final String a = "UM_PROBE_DATA";
    public static final String b = "_dsk_s";
    public static final String c = "_thm_z";
    public static final String d = "_gdf_r";
    private static Object e = new Object();

    public static int a(String str, String str2) throws IOException {
        int i;
        Process exec = Runtime.getRuntime().exec(str);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
        String readLine;
        do {
            readLine = bufferedReader.readLine();
            if (readLine == null) {
                i = -1;
                break;
            }
        } while (!readLine.contains(str2));
        i = 1;
        try {
            return exec.waitFor() != 0 ? -1 : i;
        } catch (InterruptedException unused) {
            return -1;
        }
    }

    public static String a() {
        int a;
        String str = "unknown";
        try {
            a = a("ls /sys/class/thermal", "thermal_zone");
        } catch (Throwable unused) {
            a = -1;
        }
        return a > 0 ? "thermal_zone" : a < 0 ? "noper" : str;
    }

    public static String a(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(a, 0);
            if (sharedPreferences == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            synchronized (e) {
                jSONObject.put(b, sharedPreferences.getString(b, ""));
                jSONObject.put(c, sharedPreferences.getString(c, ""));
                jSONObject.put(d, sharedPreferences.getString(d, ""));
            }
            return jSONObject.toString();
        } catch (Exception e) {
            UMCrashManager.reportCrash(context, e);
            return null;
        }
    }

    public static String b() {
        int a;
        String str = "unknown";
        try {
            a = a("ls /", "goldfish");
        } catch (Throwable unused) {
            a = -1;
        }
        return a > 0 ? "goldfish" : a < 0 ? "noper" : str;
    }

    public static void b(final Context context) {
        if (!c(context)) {
            final String[] strArr = new String[]{"unknown", "unknown", "unknown"};
            new Thread() {
                public void run() {
                    super.run();
                    try {
                        strArr[0] = l.c();
                        strArr[1] = l.a();
                        strArr[2] = l.b();
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("diskType = ");
                        stringBuilder.append(strArr[0]);
                        stringBuilder.append("; ThremalZone = ");
                        stringBuilder.append(strArr[1]);
                        stringBuilder.append("; GoldFishRc = ");
                        stringBuilder.append(strArr[2]);
                        ULog.i(stringBuilder.toString());
                        l.b(context, strArr);
                    } catch (Throwable th) {
                        UMCrashManager.reportCrash(context, th);
                    }
                }
            }.start();
        }
    }

    private static void b(Context context, String[] strArr) {
        if (context != null) {
            SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(a, 0);
            if (sharedPreferences != null) {
                synchronized (e) {
                    sharedPreferences.edit().putString(b, strArr[0]).putString(c, strArr[1]).putString(d, strArr[2]).commit();
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x003d A:{SYNTHETIC, Splitter:B:22:0x003d} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x003d A:{SYNTHETIC, Splitter:B:22:0x003d} */
    public static java.lang.String c() {
        /*
        r0 = "unknown";
        r1 = 0;
        r2 = new java.io.BufferedReader;	 Catch:{ Throwable -> 0x0038 }
        r3 = new java.io.FileReader;	 Catch:{ Throwable -> 0x0038 }
        r4 = "/proc/diskstats";
        r3.<init>(r4);	 Catch:{ Throwable -> 0x0038 }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x0038 }
        r1 = "mmcblk";
        r3 = "sda";
        r4 = "mtd";
        if (r2 == 0) goto L_0x003b;
    L_0x0017:
        r5 = r2.readLine();	 Catch:{ Throwable -> 0x0039 }
        if (r5 == 0) goto L_0x003b;
    L_0x001d:
        r6 = r5.contains(r1);	 Catch:{ Throwable -> 0x0039 }
        if (r6 == 0) goto L_0x0026;
    L_0x0023:
        r0 = "mmcblk";
        goto L_0x003b;
    L_0x0026:
        r6 = r5.contains(r3);	 Catch:{ Throwable -> 0x0039 }
        if (r6 == 0) goto L_0x002f;
    L_0x002c:
        r0 = "sda";
        goto L_0x003b;
    L_0x002f:
        r5 = r5.contains(r4);	 Catch:{ Throwable -> 0x0039 }
        if (r5 == 0) goto L_0x0017;
    L_0x0035:
        r0 = "mtd";
        goto L_0x003b;
    L_0x0038:
        r2 = r1;
    L_0x0039:
        r0 = "noper";
    L_0x003b:
        if (r2 == 0) goto L_0x0040;
    L_0x003d:
        r2.close();	 Catch:{ Throwable -> 0x0040 }
    L_0x0040:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.utils.l.c():java.lang.String");
    }

    public static boolean c(Context context) {
        if (context == null) {
            return false;
        }
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(a, 0);
        return (sharedPreferences == null || TextUtils.isEmpty(sharedPreferences.getString(b, ""))) ? false : true;
    }
}
