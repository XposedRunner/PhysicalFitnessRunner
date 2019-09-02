package com.qiyukf.nimlib;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import cn.jiguang.net.HttpUtils;
import com.qiyukf.basesdk.a;
import com.qiyukf.basesdk.c.d.e;
import com.qiyukf.basesdk.sdk.ServerAddresses;
import com.qiyukf.nimlib.a.c;
import com.qiyukf.nimlib.a.d;
import com.qiyukf.nimlib.e.g;
import com.qiyukf.nimlib.sdk.SDKOptions;
import com.qiyukf.nimlib.sdk.auth.LoginInfo;
import com.qiyukf.nimlib.service.NimService;
import com.qiyukf.unicorn.api.StatusBarNotificationConfig;
import com.tencent.stat.DeviceInfo;
import java.io.File;

public final class b {
    private static b i;
    private static com.qiyukf.basesdk.b j = new com.qiyukf.basesdk.b() {
        public final String a() {
            return b.g();
        }

        public final int b() {
            return b.d().thumbnailSize;
        }

        public final ServerAddresses c() {
            return b.i();
        }

        public final String d() {
            CharSequence charSequence = a.d() == null ? null : a.d().nosUpload;
            return TextUtils.isEmpty(charSequence) ? "https://wanproxy.127.net/lbs" : charSequence;
        }

        public final String e() {
            CharSequence charSequence = a.d() == null ? null : a.d().nosUpload;
            return TextUtils.isEmpty(charSequence) ? "nosup-hz1.127.net" : charSequence;
        }

        public final void f() {
            com.qiyukf.nimlib.a.c.a aVar = new com.qiyukf.nimlib.a.c.a.a();
            aVar.f();
            c.a().a(aVar);
        }
    };
    private Context a;
    private LoginInfo b;
    private Integer c;
    private SDKOptions d;
    private ServerAddresses e;
    private g f;
    private String g;
    private String h;

    private b() {
    }

    public static Context a() {
        return i == null ? null : i.a;
    }

    public static <T> T a(Class<T> cls) {
        if (i != null && i.f != null) {
            return i.f.a(cls);
        }
        throw new IllegalStateException("SDK not initialized or invoked in wrong process!");
    }

    private static String a(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                b bVar;
                String trim;
                if (TextUtils.isEmpty(d().appKey)) {
                    bVar = i;
                    trim = applicationInfo.metaData.getString("com.qiyukf.nim.appKey").trim();
                } else {
                    bVar = i;
                    trim = d().appKey.trim();
                }
                bVar.h = trim;
                i.g = applicationInfo.packageName;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void a(Context context, LoginInfo loginInfo, SDKOptions sDKOptions, boolean z) {
        if (d.f() || d.g()) {
            String str;
            StringBuilder stringBuilder;
            b bVar = new b();
            i = bVar;
            bVar.a = context.getApplicationContext();
            i.d = sDKOptions;
            i.b = loginInfo;
            a(context);
            a.a(context, j);
            com.qiyukf.nimlib.k.c.c.a(context);
            c.a(z);
            String str2 = i.h;
            try {
                str = context.getApplicationInfo().dataDir;
                a.a = str;
                if (TextUtils.isEmpty(str)) {
                    stringBuilder = new StringBuilder("/data/data/");
                    stringBuilder.append(context.getPackageName());
                    a.a = stringBuilder.toString();
                }
                if (context.getCacheDir() == null) {
                    stringBuilder = new StringBuilder("/data/data/");
                    stringBuilder.append(context.getPackageName());
                    stringBuilder.append("/cache");
                    a.b = stringBuilder.toString();
                    File file = new File(a.b);
                    if (!file.exists()) {
                        file.mkdir();
                    }
                } else {
                    a.b = context.getCacheDir().getAbsolutePath();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(a.a);
            stringBuilder.append(HttpUtils.PATHS_SEPARATOR);
            stringBuilder.append(str2);
            a.a = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(a.b);
            stringBuilder.append(HttpUtils.PATHS_SEPARATOR);
            stringBuilder.append(str2);
            a.b = stringBuilder.toString();
            stringBuilder = new StringBuilder("DATA ");
            stringBuilder.append(a.a);
            com.qiyukf.basesdk.a.a.d("AppDir", stringBuilder.toString());
            stringBuilder = new StringBuilder("CACHE ");
            stringBuilder.append(a.b);
            com.qiyukf.basesdk.a.a.d("AppDir", stringBuilder.toString());
            str2 = e.a(context);
            str = d.f() ? DeviceInfo.TAG_IMEI : "core";
            StringBuilder stringBuilder2 = new StringBuilder("SDK init, processName=");
            stringBuilder2.append(str2);
            com.qiyukf.basesdk.a.a.a(str, stringBuilder2.toString());
            if (d.f()) {
                stringBuilder = new StringBuilder("**** SDK Start ");
                stringBuilder.append(context.getPackageName());
                stringBuilder.append(" **** Version: 4.5.2/46/e3826cce ****");
                com.qiyukf.basesdk.a.a.a("NIM", stringBuilder.toString());
                i.f = new g();
                com.qiyukf.nimlib.e.a.a();
                c.a().b();
                NimService.a(context, 1);
            }
            if (d.g()) {
                com.qiyukf.unicorn.g.c.a(context).a();
                if (!d.f()) {
                    i.d = null;
                }
            }
            com.qiyukf.unicorn.analytics.a.a(context);
        }
    }

    public static void a(LoginInfo loginInfo) {
        j().b = loginInfo;
    }

    public static void a(StatusBarNotificationConfig statusBarNotificationConfig) {
        if (statusBarNotificationConfig != null) {
            d().statusBarNotificationConfig = statusBarNotificationConfig;
        }
    }

    public static String b() {
        return (i == null || i.b == null) ? null : i.b.getAccount();
    }

    public static Integer c() {
        return j().c;
    }

    public static SDKOptions d() {
        return j().d == null ? SDKOptions.DEFAULT : i.d;
    }

    public static LoginInfo e() {
        return i == null ? null : i.b;
    }

    public static String f() {
        return j().g;
    }

    public static String g() {
        return j().h;
    }

    public static String h() {
        return d.b();
    }

    public static ServerAddresses i() {
        return j().e;
    }

    private static b j() {
        if (i != null) {
            return i;
        }
        throw new IllegalStateException("SDK not initialized, call NimClient.init() first!");
    }
}
