package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import cn.jiguang.net.HttpUtils;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.baidu.android.bbalbs.common.util.CommonParam;
import com.baidu.mapapi.VersionInfo;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.baidu.mapsdkplatform.comjni.util.a;
import com.ecloud.pulltozoomview.O000000o;
import com.sina.weibo.sdk.statistic.LogBuilder;
import com.tencent.open.SocialOperation;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class h {
    private static a A = new a();
    private static boolean B = true;
    private static int C = 0;
    private static int D = 0;
    private static Map<String, String> E = new HashMap();
    static String a = "02";
    static String b = null;
    static String c = null;
    static String d = null;
    static String e = null;
    static int f = 0;
    static int g = 0;
    static int h = 0;
    static int i = 0;
    static int j = 0;
    static int k = 0;
    static String l = null;
    static String m = "baidu";
    static String n = "baidu";
    static String o = "";
    static String p = "";
    static String q = "";
    static String r = null;
    static String s = null;
    static String t = "-1";
    static String u = "-1";
    public static Context v = null;
    public static final int w = Integer.parseInt(VERSION.SDK);
    public static float x = 1.0f;
    public static String y = null;
    private static final String z = "h";

    public static void a() {
        d();
    }

    public static void a(String str) {
        l = str;
        f();
    }

    public static void a(String str, String str2) {
        t = str2;
        u = str;
        f();
    }

    public static byte[] a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray();
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putString("cpu", o);
        bundle.putString("resid", a);
        bundle.putString(LogBuilder.KEY_CHANNEL, m);
        bundle.putString("glr", p);
        bundle.putString("glv", q);
        bundle.putString("mb", g());
        bundle.putString("sv", i());
        bundle.putString("os", k());
        bundle.putInt("dpi_x", l());
        bundle.putInt("dpi_y", l());
        bundle.putString("net", l);
        bundle.putString("cuid", p());
        bundle.putByteArray(SocialOperation.GAME_SIGNATURE, a(v));
        bundle.putString("pcn", v.getPackageName());
        bundle.putInt("screen_x", h());
        bundle.putInt("screen_y", j());
        if (A != null) {
            A.a(bundle);
            Log.d("phoneInfo", "mAppSysOSAPI not null");
        }
        Log.d("phoneInfo", bundle.toString());
        return bundle;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0116 */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:11|12|13) */
    /* JADX WARNING: Missing block: B:12:?, code skipped:
            android.util.Log.w("baidumapsdk", "LocationManager error");
     */
    /* JADX WARNING: Missing block: B:13:0x011d, code skipped:
            E.put("resid", com.baidu.mapsdkplatform.comjni.util.AppMD5.encodeUrlParamsValue(a));
            E.put(com.sina.weibo.sdk.statistic.LogBuilder.KEY_CHANNEL, com.baidu.mapsdkplatform.comjni.util.AppMD5.encodeUrlParamsValue(m()));
            E.put("mb", com.baidu.mapsdkplatform.comjni.util.AppMD5.encodeUrlParamsValue(g()));
            E.put("sv", com.baidu.mapsdkplatform.comjni.util.AppMD5.encodeUrlParamsValue(i()));
            E.put("os", com.baidu.mapsdkplatform.comjni.util.AppMD5.encodeUrlParamsValue(k()));
            E.put("dpi", com.baidu.mapsdkplatform.comjni.util.AppMD5.encodeUrlParamsValue(java.lang.String.format("%d,%d", new java.lang.Object[]{java.lang.Integer.valueOf(l()), java.lang.Integer.valueOf(l())})));
            E.put("cuid", com.baidu.mapsdkplatform.comjni.util.AppMD5.encodeUrlParamsValue(p()));
            E.put("pcn", com.baidu.mapsdkplatform.comjni.util.AppMD5.encodeUrlParamsValue(v.getPackageName()));
            r8 = E;
            r3 = "screen";
            r4 = "%d,%d";
            r2 = new java.lang.Object[]{java.lang.Integer.valueOf(h()), java.lang.Integer.valueOf(j())};
     */
    /* JADX WARNING: Missing block: B:17:0x01de, code skipped:
            E.put("resid", com.baidu.mapsdkplatform.comjni.util.AppMD5.encodeUrlParamsValue(a));
            E.put(com.sina.weibo.sdk.statistic.LogBuilder.KEY_CHANNEL, com.baidu.mapsdkplatform.comjni.util.AppMD5.encodeUrlParamsValue(m()));
            E.put("mb", com.baidu.mapsdkplatform.comjni.util.AppMD5.encodeUrlParamsValue(g()));
            E.put("sv", com.baidu.mapsdkplatform.comjni.util.AppMD5.encodeUrlParamsValue(i()));
            E.put("os", com.baidu.mapsdkplatform.comjni.util.AppMD5.encodeUrlParamsValue(k()));
            E.put("dpi", com.baidu.mapsdkplatform.comjni.util.AppMD5.encodeUrlParamsValue(java.lang.String.format("%d,%d", new java.lang.Object[]{java.lang.Integer.valueOf(l()), java.lang.Integer.valueOf(l())})));
            E.put("cuid", com.baidu.mapsdkplatform.comjni.util.AppMD5.encodeUrlParamsValue(p()));
            E.put("pcn", com.baidu.mapsdkplatform.comjni.util.AppMD5.encodeUrlParamsValue(v.getPackageName()));
            E.put("screen", com.baidu.mapsdkplatform.comjni.util.AppMD5.encodeUrlParamsValue(java.lang.String.format("%d,%d", new java.lang.Object[]{java.lang.Integer.valueOf(h()), java.lang.Integer.valueOf(j())})));
     */
    public static void b(android.content.Context r8) {
        /*
        v = r8;
        r0 = r8.getFilesDir();
        if (r0 == 0) goto L_0x0012;
    L_0x0008:
        r0 = r8.getFilesDir();
        r0 = r0.getAbsolutePath();
        r = r0;
    L_0x0012:
        r0 = r8.getCacheDir();
        if (r0 == 0) goto L_0x0022;
    L_0x0018:
        r0 = r8.getCacheDir();
        r0 = r0.getAbsolutePath();
        s = r0;
    L_0x0022:
        r0 = android.os.Build.MODEL;
        c = r0;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "Android";
        r0.append(r1);
        r1 = android.os.Build.VERSION.SDK;
        r0.append(r1);
        r0 = r0.toString();
        d = r0;
        r0 = r8.getPackageName();
        b = r0;
        c(r8);
        d(r8);
        e(r8);
        r0 = 1;
        r1 = 0;
        r2 = 2;
        r3 = "location";
        r8 = r8.getSystemService(r3);	 Catch:{ Exception -> 0x0116 }
        r8 = (android.location.LocationManager) r8;	 Catch:{ Exception -> 0x0116 }
        r3 = "gps";
        r3 = r8.isProviderEnabled(r3);	 Catch:{ Exception -> 0x0116 }
        C = r3;	 Catch:{ Exception -> 0x0116 }
        r3 = "network";
        r8 = r8.isProviderEnabled(r3);	 Catch:{ Exception -> 0x0116 }
        D = r8;	 Catch:{ Exception -> 0x0116 }
        r8 = E;
        r3 = "resid";
        r4 = a;
        r4 = com.baidu.mapsdkplatform.comjni.util.AppMD5.encodeUrlParamsValue(r4);
        r8.put(r3, r4);
        r8 = E;
        r3 = "channel";
        r4 = m();
        r4 = com.baidu.mapsdkplatform.comjni.util.AppMD5.encodeUrlParamsValue(r4);
        r8.put(r3, r4);
        r8 = E;
        r3 = "mb";
        r4 = g();
        r4 = com.baidu.mapsdkplatform.comjni.util.AppMD5.encodeUrlParamsValue(r4);
        r8.put(r3, r4);
        r8 = E;
        r3 = "sv";
        r4 = i();
        r4 = com.baidu.mapsdkplatform.comjni.util.AppMD5.encodeUrlParamsValue(r4);
        r8.put(r3, r4);
        r8 = E;
        r3 = "os";
        r4 = k();
        r4 = com.baidu.mapsdkplatform.comjni.util.AppMD5.encodeUrlParamsValue(r4);
        r8.put(r3, r4);
        r8 = E;
        r3 = "dpi";
        r4 = "%d,%d";
        r5 = new java.lang.Object[r2];
        r6 = l();
        r6 = java.lang.Integer.valueOf(r6);
        r5[r1] = r6;
        r6 = l();
        r6 = java.lang.Integer.valueOf(r6);
        r5[r0] = r6;
        r4 = java.lang.String.format(r4, r5);
        r4 = com.baidu.mapsdkplatform.comjni.util.AppMD5.encodeUrlParamsValue(r4);
        r8.put(r3, r4);
        r8 = E;
        r3 = "cuid";
        r4 = p();
        r4 = com.baidu.mapsdkplatform.comjni.util.AppMD5.encodeUrlParamsValue(r4);
        r8.put(r3, r4);
        r8 = E;
        r3 = "pcn";
        r4 = v;
        r4 = r4.getPackageName();
        r4 = com.baidu.mapsdkplatform.comjni.util.AppMD5.encodeUrlParamsValue(r4);
        r8.put(r3, r4);
        r8 = E;
        r3 = "screen";
        r4 = "%d,%d";
        r2 = new java.lang.Object[r2];
        r5 = h();
        r5 = java.lang.Integer.valueOf(r5);
        r2[r1] = r5;
        r1 = j();
        r1 = java.lang.Integer.valueOf(r1);
        r2[r0] = r1;
        goto L_0x01c9;
    L_0x0113:
        r8 = move-exception;
        goto L_0x01de;
    L_0x0116:
        r8 = "baidumapsdk";
        r3 = "LocationManager error";
        android.util.Log.w(r8, r3);	 Catch:{ all -> 0x0113 }
        r8 = E;
        r3 = "resid";
        r4 = a;
        r4 = com.baidu.mapsdkplatform.comjni.util.AppMD5.encodeUrlParamsValue(r4);
        r8.put(r3, r4);
        r8 = E;
        r3 = "channel";
        r4 = m();
        r4 = com.baidu.mapsdkplatform.comjni.util.AppMD5.encodeUrlParamsValue(r4);
        r8.put(r3, r4);
        r8 = E;
        r3 = "mb";
        r4 = g();
        r4 = com.baidu.mapsdkplatform.comjni.util.AppMD5.encodeUrlParamsValue(r4);
        r8.put(r3, r4);
        r8 = E;
        r3 = "sv";
        r4 = i();
        r4 = com.baidu.mapsdkplatform.comjni.util.AppMD5.encodeUrlParamsValue(r4);
        r8.put(r3, r4);
        r8 = E;
        r3 = "os";
        r4 = k();
        r4 = com.baidu.mapsdkplatform.comjni.util.AppMD5.encodeUrlParamsValue(r4);
        r8.put(r3, r4);
        r8 = E;
        r3 = "dpi";
        r4 = "%d,%d";
        r5 = new java.lang.Object[r2];
        r6 = l();
        r6 = java.lang.Integer.valueOf(r6);
        r5[r1] = r6;
        r6 = l();
        r6 = java.lang.Integer.valueOf(r6);
        r5[r0] = r6;
        r4 = java.lang.String.format(r4, r5);
        r4 = com.baidu.mapsdkplatform.comjni.util.AppMD5.encodeUrlParamsValue(r4);
        r8.put(r3, r4);
        r8 = E;
        r3 = "cuid";
        r4 = p();
        r4 = com.baidu.mapsdkplatform.comjni.util.AppMD5.encodeUrlParamsValue(r4);
        r8.put(r3, r4);
        r8 = E;
        r3 = "pcn";
        r4 = v;
        r4 = r4.getPackageName();
        r4 = com.baidu.mapsdkplatform.comjni.util.AppMD5.encodeUrlParamsValue(r4);
        r8.put(r3, r4);
        r8 = E;
        r3 = "screen";
        r4 = "%d,%d";
        r2 = new java.lang.Object[r2];
        r5 = h();
        r5 = java.lang.Integer.valueOf(r5);
        r2[r1] = r5;
        r1 = j();
        r1 = java.lang.Integer.valueOf(r1);
        r2[r0] = r1;
    L_0x01c9:
        r0 = java.lang.String.format(r4, r2);
        r0 = com.baidu.mapsdkplatform.comjni.util.AppMD5.encodeUrlParamsValue(r0);
        r8.put(r3, r0);
        r8 = A;
        if (r8 == 0) goto L_0x01dd;
    L_0x01d8:
        r8 = A;
        r8.a();
    L_0x01dd:
        return;
    L_0x01de:
        r3 = E;
        r4 = "resid";
        r5 = a;
        r5 = com.baidu.mapsdkplatform.comjni.util.AppMD5.encodeUrlParamsValue(r5);
        r3.put(r4, r5);
        r3 = E;
        r4 = "channel";
        r5 = m();
        r5 = com.baidu.mapsdkplatform.comjni.util.AppMD5.encodeUrlParamsValue(r5);
        r3.put(r4, r5);
        r3 = E;
        r4 = "mb";
        r5 = g();
        r5 = com.baidu.mapsdkplatform.comjni.util.AppMD5.encodeUrlParamsValue(r5);
        r3.put(r4, r5);
        r3 = E;
        r4 = "sv";
        r5 = i();
        r5 = com.baidu.mapsdkplatform.comjni.util.AppMD5.encodeUrlParamsValue(r5);
        r3.put(r4, r5);
        r3 = E;
        r4 = "os";
        r5 = k();
        r5 = com.baidu.mapsdkplatform.comjni.util.AppMD5.encodeUrlParamsValue(r5);
        r3.put(r4, r5);
        r3 = E;
        r4 = "dpi";
        r5 = "%d,%d";
        r6 = new java.lang.Object[r2];
        r7 = l();
        r7 = java.lang.Integer.valueOf(r7);
        r6[r1] = r7;
        r7 = l();
        r7 = java.lang.Integer.valueOf(r7);
        r6[r0] = r7;
        r5 = java.lang.String.format(r5, r6);
        r5 = com.baidu.mapsdkplatform.comjni.util.AppMD5.encodeUrlParamsValue(r5);
        r3.put(r4, r5);
        r3 = E;
        r4 = "cuid";
        r5 = p();
        r5 = com.baidu.mapsdkplatform.comjni.util.AppMD5.encodeUrlParamsValue(r5);
        r3.put(r4, r5);
        r3 = E;
        r4 = "pcn";
        r5 = v;
        r5 = r5.getPackageName();
        r5 = com.baidu.mapsdkplatform.comjni.util.AppMD5.encodeUrlParamsValue(r5);
        r3.put(r4, r5);
        r3 = E;
        r4 = "screen";
        r5 = "%d,%d";
        r2 = new java.lang.Object[r2];
        r6 = h();
        r6 = java.lang.Integer.valueOf(r6);
        r2[r1] = r6;
        r1 = j();
        r1 = java.lang.Integer.valueOf(r1);
        r2[r0] = r1;
        r0 = java.lang.String.format(r5, r2);
        r0 = com.baidu.mapsdkplatform.comjni.util.AppMD5.encodeUrlParamsValue(r0);
        r3.put(r4, r0);
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.util.h.b(android.content.Context):void");
    }

    public static String c() {
        if (E == null) {
            return null;
        }
        Date date = new Date();
        long time = date.getTime() + ((long) (date.getSeconds() * 1000));
        double d = ((double) (time / 1000)) + (((double) (time % 1000)) / 1000.0d);
        E.put("ctm", AppMD5.encodeUrlParamsValue(String.format("%f", new Object[]{Double.valueOf(d)})));
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry : E.entrySet()) {
            stringBuilder.append(HttpUtils.PARAMETERS_SEPARATOR);
            stringBuilder.append((String) entry.getKey());
            stringBuilder.append(HttpUtils.EQUAL_SIGN);
            stringBuilder.append((String) entry.getValue());
        }
        return stringBuilder.toString();
    }

    private static void c(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            e = VersionInfo.getApiVersion();
            if (!(e == null || e.equals(""))) {
                e = e.replace('_', '.');
            }
            f = packageInfo.versionCode;
        } catch (NameNotFoundException unused) {
            e = O000000o.O00000oo;
            f = 1;
        }
    }

    public static void d() {
        if (A != null) {
            A.b();
        }
    }

    private static void d(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display defaultDisplay = windowManager != null ? windowManager.getDefaultDisplay() : null;
        if (defaultDisplay != null) {
            g = defaultDisplay.getWidth();
            h = defaultDisplay.getHeight();
            defaultDisplay.getMetrics(displayMetrics);
        }
        x = displayMetrics.density;
        i = (int) displayMetrics.xdpi;
        j = (int) displayMetrics.ydpi;
        if (w > 3) {
            k = displayMetrics.densityDpi;
        } else {
            k = GlMapUtil.DEVICE_DISPLAY_DPI_NORMAL;
        }
        if (k == 0) {
            k = GlMapUtil.DEVICE_DISPLAY_DPI_NORMAL;
        }
    }

    public static String e() {
        return l;
    }

    private static void e(Context context) {
        l = "0";
    }

    public static void f() {
        E.put("net", AppMD5.encodeUrlParamsValue(e()));
        E.put("appid", AppMD5.encodeUrlParamsValue(t));
        E.put("bduid", "");
        if (A != null) {
            Bundle bundle = new Bundle();
            bundle.putString("cpu", o);
            bundle.putString("resid", a);
            bundle.putString(LogBuilder.KEY_CHANNEL, m);
            bundle.putString("glr", p);
            bundle.putString("glv", q);
            bundle.putString("mb", g());
            bundle.putString("sv", i());
            bundle.putString("os", k());
            bundle.putInt("dpi_x", l());
            bundle.putInt("dpi_y", l());
            bundle.putString("net", l);
            bundle.putString("cuid", p());
            bundle.putString("pcn", v.getPackageName());
            bundle.putInt("screen_x", h());
            bundle.putInt("screen_y", j());
            bundle.putString("appid", t);
            bundle.putString("duid", u);
            if (!TextUtils.isEmpty(y)) {
                bundle.putString("token", y);
            }
            A.a(bundle);
            SysUpdateObservable.getInstance().updatePhoneInfo();
        }
    }

    public static String g() {
        return c;
    }

    public static int h() {
        return g;
    }

    public static String i() {
        return e;
    }

    public static int j() {
        return h;
    }

    public static String k() {
        return d;
    }

    public static int l() {
        return k;
    }

    public static String m() {
        return m;
    }

    public static String n() {
        return b;
    }

    public static String o() {
        return r;
    }

    public static String p() {
        String a;
        try {
            a = CommonParam.a(v);
        } catch (Exception unused) {
            a = "";
        }
        return a == null ? "" : a;
    }
}
