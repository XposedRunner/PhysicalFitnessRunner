package cn.jiguang.d;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import cn.jiguang.a.a.c.e;
import cn.jiguang.api.JCoreInterface;
import cn.jiguang.api.SdkType;
import cn.jiguang.c.b;
import cn.jiguang.d.a.d;
import cn.jiguang.d.d.f;
import cn.jiguang.d.d.i;
import cn.jiguang.d.d.p;
import cn.jiguang.d.d.x;
import cn.jiguang.e.c;
import cn.jiguang.service.Protocol;
import cn.jpush.android.service.PushService;
import defpackage.O0000Oo0;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

public final class a {
    public static final String a = SdkType.JCORE.name();
    public static boolean b;
    public static String c;
    public static Context d;
    static boolean e;
    public static final b f = new cn.jiguang.c.a();
    public static String g;
    public static boolean h;
    public static boolean i;
    private static final AtomicInteger j = new AtomicInteger(-1);
    private static final Object k = new Object();
    private static Pair<String, Integer> l;
    private static ServiceConnection m = new b();

    public static Context a(Context context) {
        if (d == null && context != null) {
            d = context.getApplicationContext();
            c = context.getPackageName();
        }
        return d;
    }

    public static String a(Bundle bundle, String str) {
        if (bundle == null) {
            return null;
        }
        Object obj = bundle.get(str);
        return obj == null ? null : obj.toString();
    }

    public static void a(Context context, boolean z) {
        if (!cn.jiguang.g.a.a.d()) {
            Intent intent = new Intent();
            intent.setClass(context, PushService.class);
            try {
                if (context.bindService(intent, m, 1)) {
                    cn.jiguang.g.a.a.e();
                }
            } catch (SecurityException unused) {
                c.c("JCoreGlobal", "Remote Service bind failed caused by SecurityException!");
            }
        }
    }

    public static void a(Context context, boolean z, long j) {
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean("force", z);
            bundle.putLong("rtc_delay", j);
            i.a().b(context, "intent.RTC", bundle);
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("sendHeartBeat error:");
            stringBuilder.append(th.getMessage());
            c.c("JCoreGlobal", stringBuilder.toString());
        }
    }

    private static boolean a() {
        int GetSdkVersion;
        try {
            GetSdkVersion = Protocol.GetSdkVersion();
        } catch (UnsatisfiedLinkError e) {
            c.d("JCoreGlobal", "Get sdk version fail![获取sdk版本失败!]");
            e.printStackTrace();
            GetSdkVersion = 0;
        }
        return GetSdkVersion >= 100;
    }

    public static String b(Context context) {
        if (TextUtils.isEmpty(g)) {
            try {
                context = a(context);
                if (context != null) {
                    ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                    if (!(applicationInfo == null || applicationInfo.metaData == null)) {
                        String a = a(applicationInfo.metaData, "JPUSH_APPKEY");
                        g = a;
                        if (!TextUtils.isEmpty(a)) {
                            g = g.toLowerCase(Locale.getDefault());
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return g;
    }

    public static boolean c(Context context) {
        switch (j.get()) {
            case -1:
                context = a(context);
                if (context != null) {
                    JCoreInterface.execute("SDK_MAIN", new c(context, 0), new int[0]);
                }
                return false;
            case 0:
                return true;
            default:
                return false;
        }
    }

    public static boolean d(Context context) {
        int e = e(a(context));
        if (e == 0) {
            return true;
        }
        StringBuilder stringBuilder = new StringBuilder("JCore init code = ");
        stringBuilder.append(e);
        c.c("JCoreGlobal", stringBuilder.toString());
        return false;
    }

    public static int e(Context context) {
        i = h;
        h = true;
        int i = j.get();
        if (i != -1) {
            return i;
        }
        synchronized (k) {
            int i2 = j.get();
            if (i2 != -1) {
                return i2;
            }
            c.a("JCoreGlobal", "action:init - sdkVersion:1.2.6, buildId:101");
            f.a();
            context = a(context);
            if (context == null) {
                return -1;
            }
            e.a().b();
            cn.jiguang.d.a.a.d(context, O0000Oo0.O00000oo);
            cn.jiguang.a.a.a(context);
            if (!a()) {
                c.d("JCoreGlobal", "JCore .so file do not match JCore .jar file in the project, Failed to init JCore");
                j.set(3);
                return 3;
            } else if (g(context)) {
                int r = cn.jiguang.g.a.r(context);
                if (r != 0) {
                    j.set(r);
                    return r;
                }
                b(context);
                String d = cn.jiguang.d.a.a.d(context);
                if (TextUtils.isEmpty(d)) {
                    d = cn.jiguang.d.a.a.c(context);
                }
                String b = b(context);
                if (cn.jiguang.g.i.a(d) || "null".equals(d) || !d.equalsIgnoreCase(b)) {
                    cn.jiguang.d.a.a.g(context, b);
                    c.a("ServiceHelper", "We found the appKey is changed or register appkey is empty. Will re-register.");
                    d.f(context);
                    cn.jiguang.d.a.a.f(context);
                    d.a(context, new cn.jiguang.g.b.a().a("last_report_device_info", null).a("lbs_report_enable", null).a("last_collection_location", null).a("location_report_delay", null).a("location_collect_frequency", null).a("last_check_userapp_status", null).a("nb_upload", null).a("nb_lasttime", null).a("app_running_collect_enable", null).a("app_running_collect_interval", null).a("app_running_last_collect_time", null).a("app_running_collect_app_type", null).a("app_running_collect_process_type", null).a("battery_last_collect_time", null).a("last_report_location", null).a("lbs_report_now", null).a("report_location_frequency", null).a("report_notify_state", null));
                    cn.jiguang.a.a.c.b.a(context, null);
                    x.e(context);
                    e.a(context);
                    p.a(context, null, "nowrap");
                }
                j.set(0);
                JCoreInterface.execute("SDK_MAIN", new c(context, 1), new int[0]);
                return 0;
            } else {
                j.set(2);
                return 2;
            }
        }
    }

    public static Pair<String, Integer> f(Context context) {
        if (l == null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                Object obj = packageInfo.versionName;
                if (obj.length() > 30) {
                    obj = obj.substring(0, 30);
                }
                l = new Pair(obj, Integer.valueOf(packageInfo.versionCode));
            } catch (Throwable unused) {
                c.a("JCoreGlobal", "NO versionCode or versionName defined in manifest.");
            }
        }
        return l;
    }

    private static boolean g(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null) {
                c.c("JCoreGlobal", "metadata: Can not get metaData from ApplicationInfo");
                return false;
            } else if (applicationInfo.metaData == null) {
                c.c("JCoreGlobal", "NO meta data defined in manifest.");
                return false;
            } else {
                String str;
                StringBuilder stringBuilder;
                Bundle bundle = applicationInfo.metaData;
                String b = cn.jiguang.d.a.a.b(context, null);
                if (b != null) {
                    str = "JCoreGlobal";
                    stringBuilder = new StringBuilder("set option channel - ");
                } else {
                    b = a(bundle, "JPUSH_CHANNEL");
                    str = "JCoreGlobal";
                    stringBuilder = new StringBuilder("manifest:channel - ");
                }
                stringBuilder.append(b);
                c.a(str, stringBuilder.toString());
                cn.jiguang.d.a.a.a(context, cn.jiguang.g.i.c(b));
                String a = a(bundle, "JPUSH_APPKEY");
                if (!TextUtils.isEmpty(a) && !TextUtils.isEmpty(g) && g.equals(a)) {
                    return g.length() == 24;
                } else {
                    g = a;
                    if (cn.jiguang.g.i.a(a)) {
                        c.d("JCoreGlobal", "errorcode:10001,metadata: JCore appKey - not defined in manifest");
                        cn.jiguang.d.d.d.a(d, 10001, false);
                        cn.jiguang.d.a.a.a(context, 10001);
                        return false;
                    } else if (g.length() != 24) {
                        StringBuilder stringBuilder2 = new StringBuilder("errorcode:1008,Invalid appKey : ");
                        stringBuilder2.append(g);
                        stringBuilder2.append(", Please get your Appkey from JIGUANG web console!");
                        c.d("JCoreGlobal", stringBuilder2.toString());
                        cn.jiguang.d.d.d.a(d, 1008, false);
                        cn.jiguang.d.a.a.a(context, 1008);
                        return false;
                    } else {
                        g = g.toLowerCase(Locale.getDefault());
                        StringBuilder stringBuilder3 = new StringBuilder("metadata: appKey - ");
                        stringBuilder3.append(g);
                        c.a("JCoreGlobal", stringBuilder3.toString());
                        return true;
                    }
                }
            }
        } catch (Throwable th) {
            c.a("JCoreGlobal", "Unexpected: failed to get current application info", th);
            return false;
        }
    }
}
