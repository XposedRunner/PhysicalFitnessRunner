package com.qiyukf.unicorn.d;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.qiyukf.basesdk.c.d.c;
import com.qiyukf.basesdk.c.d.e;
import com.qiyukf.nimlib.b.f;
import com.qiyukf.nimlib.sdk.auth.LoginInfo;
import com.qiyukf.nimlib.service.NimService;
import com.qiyukf.unicorn.d;
import com.tencent.connect.common.Constants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a {
    private static Throwable a;
    private static AtomicBoolean b = new AtomicBoolean(false);

    private enum a {
        UNKNOWN,
        IN_WRONG_PROCESS,
        INIT_EXCEPTION,
        INIT_BUT_NET_BROKEN,
        INVALID_APP_KEY,
        ASSETS_ABSENT,
        SERVICE_NOT_DECLARED,
        NET_NOT_CONNECTED,
        CAN_NOT_CREATE_USER,
        STATUS_NOT_LOGIN,
        SESSION_STATUS,
        NOTIFICATION_NULL,
        NOTIFICATION_OFF,
        NOTIFICATION_NIM,
        IMAGE_LOADER_NULL
    }

    private static class b {
        a a;
        String b;

        b(a aVar, String str) {
            this.a = aVar;
            this.b = str;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x008b A:{SYNTHETIC, Splitter:B:48:0x008b} */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0093 A:{Catch:{ IOException -> 0x008f }} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0077 A:{SYNTHETIC, Splitter:B:36:0x0077} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x007f A:{Catch:{ IOException -> 0x007b }} */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x008b A:{SYNTHETIC, Splitter:B:48:0x008b} */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0093 A:{Catch:{ IOException -> 0x008f }} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0077 A:{SYNTHETIC, Splitter:B:36:0x0077} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x007f A:{Catch:{ IOException -> 0x007b }} */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x008b A:{SYNTHETIC, Splitter:B:48:0x008b} */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0093 A:{Catch:{ IOException -> 0x008f }} */
    private static java.lang.String a(java.lang.String r10) {
        /*
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = android.os.Environment.getExternalStorageDirectory();
        r1 = r1.getPath();
        r0.append(r1);
        r1 = "/qiyu_diagnose_result.log";
        r0.append(r1);
        r0 = r0.toString();
        r1 = 0;
        r2 = new java.io.FileWriter;	 Catch:{ IOException -> 0x0070, all -> 0x006c }
        r2.<init>(r0);	 Catch:{ IOException -> 0x0070, all -> 0x006c }
        r2.write(r10);	 Catch:{ IOException -> 0x0068, all -> 0x0065 }
        r10 = com.qiyukf.basesdk.a.a.a();	 Catch:{ IOException -> 0x0068, all -> 0x0065 }
        if (r10 == 0) goto L_0x005c;
    L_0x0028:
        r10 = r10.b();	 Catch:{ IOException -> 0x0068, all -> 0x0065 }
        r3 = new java.io.FileReader;	 Catch:{ IOException -> 0x0068, all -> 0x0065 }
        r3.<init>(r10);	 Catch:{ IOException -> 0x0068, all -> 0x0065 }
        r1 = new java.io.File;	 Catch:{ IOException -> 0x005a, all -> 0x0058 }
        r1.<init>(r10);	 Catch:{ IOException -> 0x005a, all -> 0x0058 }
        r4 = r1.length();	 Catch:{ IOException -> 0x005a, all -> 0x0058 }
        r6 = 102400; // 0x19000 float:1.43493E-40 double:5.05923E-319;
        r10 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r10 <= 0) goto L_0x0046;
    L_0x0041:
        r8 = r4 - r6;
        r3.skip(r8);	 Catch:{ IOException -> 0x005a, all -> 0x0058 }
    L_0x0046:
        r10 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r10 = new char[r10];	 Catch:{ IOException -> 0x005a, all -> 0x0058 }
    L_0x004a:
        r1 = r3.read(r10);	 Catch:{ IOException -> 0x005a, all -> 0x0058 }
        r4 = -1;
        if (r1 == r4) goto L_0x0056;
    L_0x0051:
        r4 = 0;
        r2.write(r10, r4, r1);	 Catch:{ IOException -> 0x005a, all -> 0x0058 }
        goto L_0x004a;
    L_0x0056:
        r1 = r3;
        goto L_0x005c;
    L_0x0058:
        r10 = move-exception;
        goto L_0x0089;
    L_0x005a:
        r10 = move-exception;
        goto L_0x006a;
    L_0x005c:
        r2.close();	 Catch:{ IOException -> 0x007b }
        if (r1 == 0) goto L_0x0086;
    L_0x0061:
        r1.close();	 Catch:{ IOException -> 0x007b }
        return r0;
    L_0x0065:
        r10 = move-exception;
        r3 = r1;
        goto L_0x0089;
    L_0x0068:
        r10 = move-exception;
        r3 = r1;
    L_0x006a:
        r1 = r2;
        goto L_0x0072;
    L_0x006c:
        r10 = move-exception;
        r2 = r1;
        r3 = r2;
        goto L_0x0089;
    L_0x0070:
        r10 = move-exception;
        r3 = r1;
    L_0x0072:
        r10.printStackTrace();	 Catch:{ all -> 0x0087 }
        if (r1 == 0) goto L_0x007d;
    L_0x0077:
        r1.close();	 Catch:{ IOException -> 0x007b }
        goto L_0x007d;
    L_0x007b:
        r10 = move-exception;
        goto L_0x0083;
    L_0x007d:
        if (r3 == 0) goto L_0x0086;
    L_0x007f:
        r3.close();	 Catch:{ IOException -> 0x007b }
        return r0;
    L_0x0083:
        r10.printStackTrace();
    L_0x0086:
        return r0;
    L_0x0087:
        r10 = move-exception;
        r2 = r1;
    L_0x0089:
        if (r2 == 0) goto L_0x0091;
    L_0x008b:
        r2.close();	 Catch:{ IOException -> 0x008f }
        goto L_0x0091;
    L_0x008f:
        r0 = move-exception;
        goto L_0x0097;
    L_0x0091:
        if (r3 == 0) goto L_0x009a;
    L_0x0093:
        r3.close();	 Catch:{ IOException -> 0x008f }
        goto L_0x009a;
    L_0x0097:
        r0.printStackTrace();
    L_0x009a:
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.unicorn.d.a.a(java.lang.String):java.lang.String");
    }

    private static String a(List<b> list) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("problems found: ");
        stringBuilder.append(System.getProperty("line.separator"));
        for (b bVar : list) {
            StringBuilder stringBuilder2 = new StringBuilder("**");
            stringBuilder2.append(bVar.a);
            stringBuilder2.append("** ");
            stringBuilder2.append(bVar.b);
            stringBuilder.append(stringBuilder2.toString());
            stringBuilder.append(System.getProperty("line.separator"));
        }
        stringBuilder.append("============================");
        stringBuilder.append(System.getProperty("line.separator"));
        stringBuilder.append(b.a());
        stringBuilder.append(System.getProperty("line.separator"));
        String stringBuilder3 = stringBuilder.toString();
        Log.e("Diagnose", stringBuilder3);
        return a(stringBuilder3);
    }

    public static void a(final Context context) {
        if (!b.getAndSet(true)) {
            com.qiyukf.basesdk.c.a.a().c().post(new Runnable() {
                public final void run() {
                    String b = a.c(context);
                    StringBuilder stringBuilder = new StringBuilder("log path: ");
                    stringBuilder.append(b);
                    Log.e("Diagnose", stringBuilder.toString());
                    Context context = context;
                    stringBuilder = new StringBuilder("dump log to: ");
                    stringBuilder.append(b);
                    Toast.makeText(context, stringBuilder.toString(), 1).show();
                    a.b.set(false);
                }
            });
        }
    }

    public static void a(Throwable th) {
        a = th;
    }

    private static String c(Context context) {
        if (context == null) {
            throw new NullPointerException("diagnose context is null");
        }
        context = context.getApplicationContext();
        List arrayList = new ArrayList();
        Object obj = null;
        try {
            d.a();
        } catch (Throwable unused) {
            obj = !e.b(context) ? new b(a.IN_WRONG_PROCESS, e.a(context)) : a != null ? new b(a.INIT_EXCEPTION, Log.getStackTraceString(a)) : new b(a.UNKNOWN, "unknown problem in initialization");
        }
        if (obj == null) {
            obj = d(context);
        }
        if (obj == null) {
            obj = e(context);
        }
        if (obj != null) {
            arrayList.add(obj);
            return a(arrayList);
        }
        a aVar;
        if (!com.qiyukf.nimlib.d.e().logined()) {
            aVar = a.STATUS_NOT_LOGIN;
            StringBuilder stringBuilder = new StringBuilder("status is ");
            stringBuilder.append(com.qiyukf.nimlib.d.e());
            arrayList.add(new b(aVar, stringBuilder.toString()));
        }
        aVar = a.SESSION_STATUS;
        com.qiyukf.unicorn.h.d g = d.g();
        StringBuilder stringBuilder2 = new StringBuilder("queue: ");
        stringBuilder2.append(g.a("-1"));
        stringBuilder2.append(", type: ");
        stringBuilder2.append(g.e("-1"));
        stringBuilder2.append(", isSelecting: ");
        stringBuilder2.append(com.qiyukf.unicorn.h.d.i("-1"));
        arrayList.add(new b(aVar, stringBuilder2.toString()));
        if (d.e().statusBarNotificationConfig == null) {
            arrayList.add(new b(a.NOTIFICATION_NULL, "notify config is not set"));
        }
        if (!com.qiyukf.unicorn.b.b.k()) {
            arrayList.add(new b(a.NOTIFICATION_OFF, "notify toggle is off now"));
        }
        try {
            Class.forName("com.netease.nim.sdk.NimClient");
            arrayList.add(new b(a.NOTIFICATION_NIM, "maybe confusing with nim"));
        } catch (Exception unused2) {
        }
        if (d.f() == null) {
            arrayList.add(new b(a.IMAGE_LOADER_NULL, "ImageLoader is null"));
        }
        return a(arrayList);
    }

    private static b d(Context context) {
        if (new LoginInfo(com.qiyukf.unicorn.b.b.a(), com.qiyukf.unicorn.b.b.b()).valid()) {
            return null;
        }
        if (!c.b(context)) {
            return new b(a.INIT_BUT_NET_BROKEN, "init when network is not available");
        }
        String d = d.d();
        if (TextUtils.isEmpty(d) || !d.toLowerCase().equals(d)) {
            return new b(a.INVALID_APP_KEY, d);
        }
        Log.e("Diagnose", "checking network connection...");
        try {
            com.qiyukf.basesdk.b.a.c.b.b(f.a(), Constants.HTTP_GET, "Diagnose");
            a aVar;
            StringBuilder stringBuilder;
            try {
                com.qiyukf.unicorn.f.b a = com.qiyukf.unicorn.f.c.a(d, com.qiyukf.unicorn.b.b.d());
                if (a != null && a.a() != null && a.a().valid()) {
                    return new b(a.UNKNOWN, "unknown error when create nim user");
                }
                aVar = a.CAN_NOT_CREATE_USER;
                stringBuilder = new StringBuilder("appkey: ");
                stringBuilder.append(d);
                stringBuilder.append(", response: ");
                stringBuilder.append(a);
                return new b(aVar, stringBuilder.toString());
            } catch (Exception e) {
                aVar = a.CAN_NOT_CREATE_USER;
                stringBuilder = new StringBuilder("appkey: ");
                stringBuilder.append(d);
                stringBuilder.append(", ");
                stringBuilder.append(Log.getStackTraceString(e));
                return new b(aVar, stringBuilder.toString());
            }
        } catch (Exception e2) {
            return new b(a.NET_NOT_CONNECTED, Log.getStackTraceString(e2));
        }
    }

    private static b e(Context context) {
        try {
            context.getAssets().open("keystore_unicorn");
            try {
                context.getPackageManager().getServiceInfo(new ComponentName(context.getPackageName(), NimService.class.getName()), 0);
                return null;
            } catch (NameNotFoundException unused) {
                return new b(a.SERVICE_NOT_DECLARED, "NimService not found in AndroidManifest");
            }
        } catch (IOException unused2) {
            return new b(a.ASSETS_ABSENT, "assets folder is absent");
        }
    }
}
