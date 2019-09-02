package com.tencent.bugly;

import android.content.Context;
import android.util.Log;
import com.tencent.bugly.crashreport.common.info.a;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.x;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BUGLY */
public final class b {
    public static boolean a = true;
    public static List<a> b = new ArrayList();
    public static boolean c;
    private static p d;
    private static boolean e;

    public static synchronized void a(Context context) {
        synchronized (b.class) {
            a(context, null);
        }
    }

    public static synchronized void a(Context context, BuglyStrategy buglyStrategy) {
        synchronized (b.class) {
            if (e) {
                x.d("[init] initial Multi-times, ignore this.", new Object[0]);
            } else if (context == null) {
                Log.w(x.a, "[init] context of init() is null, check it.");
            } else {
                a a = a.a(context);
                if (a(a)) {
                    a = false;
                    return;
                }
                String f = a.f();
                if (f == null) {
                    Log.e(x.a, "[init] meta data of BUGLY_APPID in AndroidManifest.xml should be set.");
                    return;
                }
                a(context, f, a.u, buglyStrategy);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:63:0x0183 A:{Catch:{ Exception -> 0x0170, all -> 0x0237 }} */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01b6 A:{Catch:{ Exception -> 0x0170, all -> 0x0237 }} */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0183 A:{Catch:{ Exception -> 0x0170, all -> 0x0237 }} */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01b6 A:{Catch:{ Exception -> 0x0170, all -> 0x0237 }} */
    public static synchronized void a(android.content.Context r22, java.lang.String r23, boolean r24, com.tencent.bugly.BuglyStrategy r25) {
        /*
        r1 = r23;
        r2 = r24;
        r3 = r25;
        r4 = com.tencent.bugly.b.class;
        monitor-enter(r4);
        r5 = e;	 Catch:{ all -> 0x0237 }
        r6 = 0;
        if (r5 == 0) goto L_0x0017;
    L_0x000e:
        r1 = "[init] initial Multi-times, ignore this.";
        r2 = new java.lang.Object[r6];	 Catch:{ all -> 0x0237 }
        com.tencent.bugly.proguard.x.d(r1, r2);	 Catch:{ all -> 0x0237 }
        monitor-exit(r4);
        return;
    L_0x0017:
        if (r22 != 0) goto L_0x0022;
    L_0x0019:
        r1 = com.tencent.bugly.proguard.x.a;	 Catch:{ all -> 0x0237 }
        r2 = "[init] context is null, check it.";
        android.util.Log.w(r1, r2);	 Catch:{ all -> 0x0237 }
        monitor-exit(r4);
        return;
    L_0x0022:
        if (r1 != 0) goto L_0x002d;
    L_0x0024:
        r1 = com.tencent.bugly.proguard.x.a;	 Catch:{ all -> 0x0237 }
        r2 = "init arg 'crashReportAppID' should not be null!";
        android.util.Log.e(r1, r2);	 Catch:{ all -> 0x0237 }
        monitor-exit(r4);
        return;
    L_0x002d:
        r7 = 1;
        e = r7;	 Catch:{ all -> 0x0237 }
        if (r2 == 0) goto L_0x006e;
    L_0x0032:
        c = r7;	 Catch:{ all -> 0x0237 }
        com.tencent.bugly.proguard.x.b = r7;	 Catch:{ all -> 0x0237 }
        r8 = "Bugly debug模式开启，请在发布时把isDebug关闭。 -- Running in debug model for 'isDebug' is enabled. Please disable it when you release.";
        r9 = new java.lang.Object[r6];	 Catch:{ all -> 0x0237 }
        com.tencent.bugly.proguard.x.d(r8, r9);	 Catch:{ all -> 0x0237 }
        r8 = "--------------------------------------------------------------------------------------------";
        r9 = new java.lang.Object[r6];	 Catch:{ all -> 0x0237 }
        com.tencent.bugly.proguard.x.e(r8, r9);	 Catch:{ all -> 0x0237 }
        r8 = "Bugly debug模式将有以下行为特性 -- The following list shows the behaviour of debug model: ";
        r9 = new java.lang.Object[r6];	 Catch:{ all -> 0x0237 }
        com.tencent.bugly.proguard.x.d(r8, r9);	 Catch:{ all -> 0x0237 }
        r8 = "[1] 输出详细的Bugly SDK的Log -- More detailed log of Bugly SDK will be output to logcat;";
        r9 = new java.lang.Object[r6];	 Catch:{ all -> 0x0237 }
        com.tencent.bugly.proguard.x.d(r8, r9);	 Catch:{ all -> 0x0237 }
        r8 = "[2] 每一条Crash都会被立即上报 -- Every crash caught by Bugly will be uploaded immediately.";
        r9 = new java.lang.Object[r6];	 Catch:{ all -> 0x0237 }
        com.tencent.bugly.proguard.x.d(r8, r9);	 Catch:{ all -> 0x0237 }
        r8 = "[3] 自定义日志将会在Logcat中输出 -- Custom log will be output to logcat.";
        r9 = new java.lang.Object[r6];	 Catch:{ all -> 0x0237 }
        com.tencent.bugly.proguard.x.d(r8, r9);	 Catch:{ all -> 0x0237 }
        r8 = "--------------------------------------------------------------------------------------------";
        r9 = new java.lang.Object[r6];	 Catch:{ all -> 0x0237 }
        com.tencent.bugly.proguard.x.e(r8, r9);	 Catch:{ all -> 0x0237 }
        r8 = "[init] Open debug mode of Bugly.";
        r9 = new java.lang.Object[r6];	 Catch:{ all -> 0x0237 }
        com.tencent.bugly.proguard.x.b(r8, r9);	 Catch:{ all -> 0x0237 }
    L_0x006e:
        r8 = "[init] Bugly version: v%s";
        r9 = new java.lang.Object[r7];	 Catch:{ all -> 0x0237 }
        r10 = "2.6.6";
        r9[r6] = r10;	 Catch:{ all -> 0x0237 }
        com.tencent.bugly.proguard.x.a(r8, r9);	 Catch:{ all -> 0x0237 }
        r8 = " crash report start initializing...";
        r9 = new java.lang.Object[r6];	 Catch:{ all -> 0x0237 }
        com.tencent.bugly.proguard.x.a(r8, r9);	 Catch:{ all -> 0x0237 }
        r8 = "[init] Bugly start initializing...";
        r9 = new java.lang.Object[r6];	 Catch:{ all -> 0x0237 }
        com.tencent.bugly.proguard.x.b(r8, r9);	 Catch:{ all -> 0x0237 }
        r8 = "[init] Bugly complete version: v%s";
        r9 = new java.lang.Object[r7];	 Catch:{ all -> 0x0237 }
        r10 = "2.6.6";
        r9[r6] = r10;	 Catch:{ all -> 0x0237 }
        com.tencent.bugly.proguard.x.a(r8, r9);	 Catch:{ all -> 0x0237 }
        r5 = com.tencent.bugly.proguard.z.a(r22);	 Catch:{ all -> 0x0237 }
        r8 = com.tencent.bugly.crashreport.common.info.a.a(r5);	 Catch:{ all -> 0x0237 }
        r8.t();	 Catch:{ all -> 0x0237 }
        com.tencent.bugly.proguard.y.a(r5);	 Catch:{ all -> 0x0237 }
        r9 = b;	 Catch:{ all -> 0x0237 }
        r9 = com.tencent.bugly.proguard.p.a(r5, r9);	 Catch:{ all -> 0x0237 }
        d = r9;	 Catch:{ all -> 0x0237 }
        com.tencent.bugly.proguard.u.a(r5);	 Catch:{ all -> 0x0237 }
        r9 = b;	 Catch:{ all -> 0x0237 }
        r9 = com.tencent.bugly.crashreport.common.strategy.a.a(r5, r9);	 Catch:{ all -> 0x0237 }
        r10 = com.tencent.bugly.proguard.n.a(r5);	 Catch:{ all -> 0x0237 }
        r11 = a(r8);	 Catch:{ all -> 0x0237 }
        if (r11 == 0) goto L_0x00bf;
    L_0x00bb:
        a = r6;	 Catch:{ all -> 0x0237 }
        monitor-exit(r4);
        return;
    L_0x00bf:
        r8.a(r1);	 Catch:{ all -> 0x0237 }
        r11 = "[param] Set APP ID:%s";
        r12 = new java.lang.Object[r7];	 Catch:{ all -> 0x0237 }
        r12[r6] = r1;	 Catch:{ all -> 0x0237 }
        com.tencent.bugly.proguard.x.a(r11, r12);	 Catch:{ all -> 0x0237 }
        if (r3 == 0) goto L_0x01ec;
    L_0x00cd:
        r1 = r25.getAppVersion();	 Catch:{ all -> 0x0237 }
        r11 = android.text.TextUtils.isEmpty(r1);	 Catch:{ all -> 0x0237 }
        r13 = 3;
        r14 = 100;
        if (r11 != 0) goto L_0x0107;
    L_0x00da:
        r11 = r1.length();	 Catch:{ all -> 0x0237 }
        if (r11 <= r14) goto L_0x00f7;
    L_0x00e0:
        r11 = r1.substring(r6, r14);	 Catch:{ all -> 0x0237 }
        r15 = "appVersion %s length is over limit %d substring to %s";
        r12 = new java.lang.Object[r13];	 Catch:{ all -> 0x0237 }
        r12[r6] = r1;	 Catch:{ all -> 0x0237 }
        r1 = java.lang.Integer.valueOf(r14);	 Catch:{ all -> 0x0237 }
        r12[r7] = r1;	 Catch:{ all -> 0x0237 }
        r1 = 2;
        r12[r1] = r11;	 Catch:{ all -> 0x0237 }
        com.tencent.bugly.proguard.x.d(r15, r12);	 Catch:{ all -> 0x0237 }
        goto L_0x00f8;
    L_0x00f7:
        r11 = r1;
    L_0x00f8:
        r8.j = r11;	 Catch:{ all -> 0x0237 }
        r1 = "[param] Set App version: %s";
        r11 = new java.lang.Object[r7];	 Catch:{ all -> 0x0237 }
        r12 = r25.getAppVersion();	 Catch:{ all -> 0x0237 }
        r11[r6] = r12;	 Catch:{ all -> 0x0237 }
        com.tencent.bugly.proguard.x.a(r1, r11);	 Catch:{ all -> 0x0237 }
    L_0x0107:
        r1 = r25.isReplaceOldChannel();	 Catch:{ Exception -> 0x0170 }
        if (r1 == 0) goto L_0x0149;
    L_0x010d:
        r1 = r25.getAppChannel();	 Catch:{ Exception -> 0x0170 }
        r11 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Exception -> 0x0170 }
        if (r11 != 0) goto L_0x0164;
    L_0x0117:
        r11 = r1.length();	 Catch:{ Exception -> 0x0170 }
        if (r11 <= r14) goto L_0x0134;
    L_0x011d:
        r11 = r1.substring(r6, r14);	 Catch:{ Exception -> 0x0170 }
        r12 = "appChannel %s length is over limit %d substring to %s";
        r15 = new java.lang.Object[r13];	 Catch:{ Exception -> 0x0170 }
        r15[r6] = r1;	 Catch:{ Exception -> 0x0170 }
        r1 = java.lang.Integer.valueOf(r14);	 Catch:{ Exception -> 0x0170 }
        r15[r7] = r1;	 Catch:{ Exception -> 0x0170 }
        r1 = 2;
        r15[r1] = r11;	 Catch:{ Exception -> 0x0170 }
        com.tencent.bugly.proguard.x.d(r12, r15);	 Catch:{ Exception -> 0x0170 }
        goto L_0x0135;
    L_0x0134:
        r11 = r1;
    L_0x0135:
        r16 = d;	 Catch:{ Exception -> 0x0170 }
        r17 = 556; // 0x22c float:7.79E-43 double:2.747E-321;
        r18 = "app_channel";
        r19 = r11.getBytes();	 Catch:{ Exception -> 0x0170 }
        r20 = 0;
        r21 = 0;
        r16.a(r17, r18, r19, r20, r21);	 Catch:{ Exception -> 0x0170 }
    L_0x0146:
        r8.l = r11;	 Catch:{ Exception -> 0x0170 }
        goto L_0x0164;
    L_0x0149:
        r1 = d;	 Catch:{ Exception -> 0x0170 }
        r11 = 556; // 0x22c float:7.79E-43 double:2.747E-321;
        r12 = 0;
        r1 = r1.a(r11, r12, r7);	 Catch:{ Exception -> 0x0170 }
        if (r1 == 0) goto L_0x0164;
    L_0x0154:
        r11 = "app_channel";
        r1 = r1.get(r11);	 Catch:{ Exception -> 0x0170 }
        r1 = (byte[]) r1;	 Catch:{ Exception -> 0x0170 }
        if (r1 == 0) goto L_0x0164;
    L_0x015e:
        r11 = new java.lang.String;	 Catch:{ Exception -> 0x0170 }
        r11.<init>(r1);	 Catch:{ Exception -> 0x0170 }
        goto L_0x0146;
    L_0x0164:
        r1 = "[param] Set App channel: %s";
        r11 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x0170 }
        r12 = r8.l;	 Catch:{ Exception -> 0x0170 }
        r11[r6] = r12;	 Catch:{ Exception -> 0x0170 }
        com.tencent.bugly.proguard.x.a(r1, r11);	 Catch:{ Exception -> 0x0170 }
        goto L_0x0179;
    L_0x0170:
        r0 = move-exception;
        r1 = r0;
        r11 = c;	 Catch:{ all -> 0x0237 }
        if (r11 == 0) goto L_0x0179;
    L_0x0176:
        r1.printStackTrace();	 Catch:{ all -> 0x0237 }
    L_0x0179:
        r1 = r25.getAppPackageName();	 Catch:{ all -> 0x0237 }
        r11 = android.text.TextUtils.isEmpty(r1);	 Catch:{ all -> 0x0237 }
        if (r11 != 0) goto L_0x01b0;
    L_0x0183:
        r11 = r1.length();	 Catch:{ all -> 0x0237 }
        if (r11 <= r14) goto L_0x01a0;
    L_0x0189:
        r11 = r1.substring(r6, r14);	 Catch:{ all -> 0x0237 }
        r12 = "appPackageName %s length is over limit %d substring to %s";
        r15 = new java.lang.Object[r13];	 Catch:{ all -> 0x0237 }
        r15[r6] = r1;	 Catch:{ all -> 0x0237 }
        r1 = java.lang.Integer.valueOf(r14);	 Catch:{ all -> 0x0237 }
        r15[r7] = r1;	 Catch:{ all -> 0x0237 }
        r1 = 2;
        r15[r1] = r11;	 Catch:{ all -> 0x0237 }
        com.tencent.bugly.proguard.x.d(r12, r15);	 Catch:{ all -> 0x0237 }
        goto L_0x01a1;
    L_0x01a0:
        r11 = r1;
    L_0x01a1:
        r8.c = r11;	 Catch:{ all -> 0x0237 }
        r1 = "[param] Set App package: %s";
        r11 = new java.lang.Object[r7];	 Catch:{ all -> 0x0237 }
        r12 = r25.getAppPackageName();	 Catch:{ all -> 0x0237 }
        r11[r6] = r12;	 Catch:{ all -> 0x0237 }
        com.tencent.bugly.proguard.x.a(r1, r11);	 Catch:{ all -> 0x0237 }
    L_0x01b0:
        r1 = r25.getDeviceID();	 Catch:{ all -> 0x0237 }
        if (r1 == 0) goto L_0x01e0;
    L_0x01b6:
        r11 = r1.length();	 Catch:{ all -> 0x0237 }
        if (r11 <= r14) goto L_0x01d3;
    L_0x01bc:
        r11 = r1.substring(r6, r14);	 Catch:{ all -> 0x0237 }
        r12 = "deviceId %s length is over limit %d substring to %s";
        r13 = new java.lang.Object[r13];	 Catch:{ all -> 0x0237 }
        r13[r6] = r1;	 Catch:{ all -> 0x0237 }
        r1 = java.lang.Integer.valueOf(r14);	 Catch:{ all -> 0x0237 }
        r13[r7] = r1;	 Catch:{ all -> 0x0237 }
        r1 = 2;
        r13[r1] = r11;	 Catch:{ all -> 0x0237 }
        com.tencent.bugly.proguard.x.d(r12, r13);	 Catch:{ all -> 0x0237 }
        goto L_0x01d4;
    L_0x01d3:
        r11 = r1;
    L_0x01d4:
        r8.c(r11);	 Catch:{ all -> 0x0237 }
        r1 = "s[param] Set device ID: %s";
        r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x0237 }
        r7[r6] = r11;	 Catch:{ all -> 0x0237 }
        com.tencent.bugly.proguard.x.a(r1, r7);	 Catch:{ all -> 0x0237 }
    L_0x01e0:
        r1 = r25.isUploadProcess();	 Catch:{ all -> 0x0237 }
        r8.e = r1;	 Catch:{ all -> 0x0237 }
        r1 = r25.isBuglyLogUpload();	 Catch:{ all -> 0x0237 }
        com.tencent.bugly.proguard.y.a = r1;	 Catch:{ all -> 0x0237 }
    L_0x01ec:
        com.tencent.bugly.crashreport.biz.b.a(r5, r3);	 Catch:{ all -> 0x0237 }
        r1 = r6;
    L_0x01f0:
        r7 = b;	 Catch:{ all -> 0x0237 }
        r7 = r7.size();	 Catch:{ all -> 0x0237 }
        if (r1 >= r7) goto L_0x0222;
    L_0x01f8:
        r7 = b;	 Catch:{ Throwable -> 0x0214 }
        r7 = r7.get(r1);	 Catch:{ Throwable -> 0x0214 }
        r7 = (com.tencent.bugly.a) r7;	 Catch:{ Throwable -> 0x0214 }
        r7 = r7.id;	 Catch:{ Throwable -> 0x0214 }
        r7 = r10.a(r7);	 Catch:{ Throwable -> 0x0214 }
        if (r7 == 0) goto L_0x021f;
    L_0x0208:
        r7 = b;	 Catch:{ Throwable -> 0x0214 }
        r7 = r7.get(r1);	 Catch:{ Throwable -> 0x0214 }
        r7 = (com.tencent.bugly.a) r7;	 Catch:{ Throwable -> 0x0214 }
        r7.init(r5, r2, r3);	 Catch:{ Throwable -> 0x0214 }
        goto L_0x021f;
    L_0x0214:
        r0 = move-exception;
        r7 = r0;
        r8 = com.tencent.bugly.proguard.x.a(r7);	 Catch:{ all -> 0x0237 }
        if (r8 != 0) goto L_0x021f;
    L_0x021c:
        r7.printStackTrace();	 Catch:{ all -> 0x0237 }
    L_0x021f:
        r1 = r1 + 1;
        goto L_0x01f0;
    L_0x0222:
        if (r3 == 0) goto L_0x0229;
    L_0x0224:
        r1 = r25.getAppReportDelay();	 Catch:{ all -> 0x0237 }
        goto L_0x022b;
    L_0x0229:
        r1 = 0;
    L_0x022b:
        r9.a(r1);	 Catch:{ all -> 0x0237 }
        r1 = "[init] Bugly initialization finished.";
        r2 = new java.lang.Object[r6];	 Catch:{ all -> 0x0237 }
        com.tencent.bugly.proguard.x.b(r1, r2);	 Catch:{ all -> 0x0237 }
        monitor-exit(r4);
        return;
    L_0x0237:
        r0 = move-exception;
        r1 = r0;
        monitor-exit(r4);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.b.a(android.content.Context, java.lang.String, boolean, com.tencent.bugly.BuglyStrategy):void");
    }

    public static synchronized void a(a aVar) {
        synchronized (b.class) {
            if (!b.contains(aVar)) {
                b.add(aVar);
            }
        }
    }

    private static boolean a(a aVar) {
        List list = aVar.o;
        aVar.getClass();
        return list != null && list.contains("bugly");
    }
}
