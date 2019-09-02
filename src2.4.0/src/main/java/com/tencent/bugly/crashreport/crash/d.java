package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import com.tencent.bugly.crashreport.common.strategy.a;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import java.util.Map;

/* compiled from: BUGLY */
public final class d {
    private static d a;
    private a b;
    private com.tencent.bugly.crashreport.common.info.a c;
    private b d;
    private Context e;

    private d(Context context) {
        c a = c.a();
        if (a != null) {
            this.b = a.a();
            this.c = com.tencent.bugly.crashreport.common.info.a.a(context);
            this.d = a.o;
            this.e = context;
            w.a().a(new Runnable() {
                public final void run() {
                    d.a(d.this);
                }
            });
        }
    }

    public static d a(Context context) {
        if (a == null) {
            a = new d(context);
        }
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:70:0x0259 A:{Catch:{ Throwable -> 0x0252, all -> 0x0250 }} */
    static /* synthetic */ void a(com.tencent.bugly.crashreport.crash.d r9, java.lang.Thread r10, int r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, java.util.Map r15) {
        /*
        r0 = 1;
        r1 = 0;
        switch(r11) {
            case 4: goto L_0x0019;
            case 5: goto L_0x0016;
            case 6: goto L_0x0016;
            case 7: goto L_0x0005;
            case 8: goto L_0x0013;
            default: goto L_0x0005;
        };
    L_0x0005:
        r9 = "[ExtraCrashManager] Unknown extra crash type: %d";
        r10 = new java.lang.Object[r0];
        r11 = java.lang.Integer.valueOf(r11);
        r10[r1] = r11;
        com.tencent.bugly.proguard.x.d(r9, r10);
        return;
    L_0x0013:
        r2 = "H5";
        goto L_0x001b;
    L_0x0016:
        r2 = "Cocos";
        goto L_0x001b;
    L_0x0019:
        r2 = "Unity";
    L_0x001b:
        r3 = r2;
        r2 = "[ExtraCrashManager] %s Crash Happen";
        r4 = new java.lang.Object[r0];
        r4[r1] = r3;
        com.tencent.bugly.proguard.x.e(r2, r4);
        r2 = r9.b;	 Catch:{ Throwable -> 0x0252 }
        r2 = r2.b();	 Catch:{ Throwable -> 0x0252 }
        if (r2 != 0) goto L_0x0048;
    L_0x002d:
        r2 = "waiting for remote sync";
        r4 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x0252 }
        com.tencent.bugly.proguard.x.e(r2, r4);	 Catch:{ Throwable -> 0x0252 }
        r2 = r1;
    L_0x0035:
        r4 = r9.b;	 Catch:{ Throwable -> 0x0252 }
        r4 = r4.b();	 Catch:{ Throwable -> 0x0252 }
        if (r4 != 0) goto L_0x0048;
    L_0x003d:
        r4 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        com.tencent.bugly.proguard.z.b(r4);	 Catch:{ Throwable -> 0x0252 }
        r2 = r2 + 500;
        r4 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;
        if (r2 < r4) goto L_0x0035;
    L_0x0048:
        r2 = r9.b;	 Catch:{ Throwable -> 0x0252 }
        r2 = r2.b();	 Catch:{ Throwable -> 0x0252 }
        if (r2 != 0) goto L_0x0057;
    L_0x0050:
        r2 = "[ExtraCrashManager] There is no remote strategy, but still store it.";
        r4 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x0252 }
        com.tencent.bugly.proguard.x.d(r2, r4);	 Catch:{ Throwable -> 0x0252 }
    L_0x0057:
        r2 = r9.b;	 Catch:{ Throwable -> 0x0252 }
        r2 = r2.c();	 Catch:{ Throwable -> 0x0252 }
        r4 = r2.g;	 Catch:{ Throwable -> 0x0252 }
        if (r4 != 0) goto L_0x00a1;
    L_0x0061:
        r4 = r9.b;	 Catch:{ Throwable -> 0x0252 }
        r4 = r4.b();	 Catch:{ Throwable -> 0x0252 }
        if (r4 == 0) goto L_0x00a1;
    L_0x0069:
        r11 = "[ExtraCrashManager] Crash report was closed by remote , will not upload to Bugly , print local for helpful!";
        r15 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x0252 }
        com.tencent.bugly.proguard.x.e(r11, r15);	 Catch:{ Throwable -> 0x0252 }
        r4 = com.tencent.bugly.proguard.z.a();	 Catch:{ Throwable -> 0x0252 }
        r9 = r9.c;	 Catch:{ Throwable -> 0x0252 }
        r5 = r9.d;	 Catch:{ Throwable -> 0x0252 }
        r9 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0252 }
        r9.<init>();	 Catch:{ Throwable -> 0x0252 }
        r9.append(r12);	 Catch:{ Throwable -> 0x0252 }
        r11 = "\n";
        r9.append(r11);	 Catch:{ Throwable -> 0x0252 }
        r9.append(r13);	 Catch:{ Throwable -> 0x0252 }
        r11 = "\n";
        r9.append(r11);	 Catch:{ Throwable -> 0x0252 }
        r9.append(r14);	 Catch:{ Throwable -> 0x0252 }
        r7 = r9.toString();	 Catch:{ Throwable -> 0x0252 }
        r8 = 0;
        r6 = r10;
        com.tencent.bugly.crashreport.crash.b.a(r3, r4, r5, r6, r7, r8);	 Catch:{ Throwable -> 0x0252 }
        r9 = "[ExtraCrashManager] Successfully handled.";
        r10 = new java.lang.Object[r1];
        com.tencent.bugly.proguard.x.e(r9, r10);
        return;
    L_0x00a1:
        switch(r11) {
            case 4: goto L_0x00cf;
            case 5: goto L_0x00ba;
            case 6: goto L_0x00ba;
            case 7: goto L_0x00a4;
            case 8: goto L_0x00a5;
            default: goto L_0x00a4;
        };
    L_0x00a4:
        goto L_0x00cf;
    L_0x00a5:
        r2 = r2.m;	 Catch:{ Throwable -> 0x0252 }
        if (r2 != 0) goto L_0x00cf;
    L_0x00a9:
        r9 = "[ExtraCrashManager] %s report is disabled.";
        r10 = new java.lang.Object[r0];	 Catch:{ Throwable -> 0x0252 }
        r10[r1] = r3;	 Catch:{ Throwable -> 0x0252 }
        com.tencent.bugly.proguard.x.e(r9, r10);	 Catch:{ Throwable -> 0x0252 }
        r9 = "[ExtraCrashManager] Successfully handled.";
        r10 = new java.lang.Object[r1];
        com.tencent.bugly.proguard.x.e(r9, r10);
        return;
    L_0x00ba:
        r2 = r2.l;	 Catch:{ Throwable -> 0x0252 }
        if (r2 != 0) goto L_0x00cf;
    L_0x00be:
        r9 = "[ExtraCrashManager] %s report is disabled.";
        r10 = new java.lang.Object[r0];	 Catch:{ Throwable -> 0x0252 }
        r10[r1] = r3;	 Catch:{ Throwable -> 0x0252 }
        com.tencent.bugly.proguard.x.e(r9, r10);	 Catch:{ Throwable -> 0x0252 }
        r9 = "[ExtraCrashManager] Successfully handled.";
        r10 = new java.lang.Object[r1];
        com.tencent.bugly.proguard.x.e(r9, r10);
        return;
    L_0x00cf:
        r0 = 8;
        if (r11 != r0) goto L_0x00d4;
    L_0x00d3:
        r11 = 5;
    L_0x00d4:
        r0 = new com.tencent.bugly.crashreport.crash.CrashDetailBean;	 Catch:{ Throwable -> 0x0252 }
        r0.<init>();	 Catch:{ Throwable -> 0x0252 }
        r4 = com.tencent.bugly.crashreport.common.info.b.h();	 Catch:{ Throwable -> 0x0252 }
        r0.B = r4;	 Catch:{ Throwable -> 0x0252 }
        r4 = com.tencent.bugly.crashreport.common.info.b.f();	 Catch:{ Throwable -> 0x0252 }
        r0.C = r4;	 Catch:{ Throwable -> 0x0252 }
        r4 = com.tencent.bugly.crashreport.common.info.b.j();	 Catch:{ Throwable -> 0x0252 }
        r0.D = r4;	 Catch:{ Throwable -> 0x0252 }
        r2 = r9.c;	 Catch:{ Throwable -> 0x0252 }
        r4 = r2.p();	 Catch:{ Throwable -> 0x0252 }
        r0.E = r4;	 Catch:{ Throwable -> 0x0252 }
        r2 = r9.c;	 Catch:{ Throwable -> 0x0252 }
        r4 = r2.o();	 Catch:{ Throwable -> 0x0252 }
        r0.F = r4;	 Catch:{ Throwable -> 0x0252 }
        r2 = r9.c;	 Catch:{ Throwable -> 0x0252 }
        r4 = r2.q();	 Catch:{ Throwable -> 0x0252 }
        r0.G = r4;	 Catch:{ Throwable -> 0x0252 }
        r2 = r9.e;	 Catch:{ Throwable -> 0x0252 }
        r4 = com.tencent.bugly.crashreport.crash.c.e;	 Catch:{ Throwable -> 0x0252 }
        r5 = 0;
        r2 = com.tencent.bugly.proguard.z.a(r2, r4, r5);	 Catch:{ Throwable -> 0x0252 }
        r0.w = r2;	 Catch:{ Throwable -> 0x0252 }
        r0.b = r11;	 Catch:{ Throwable -> 0x0252 }
        r11 = r9.c;	 Catch:{ Throwable -> 0x0252 }
        r11 = r11.h();	 Catch:{ Throwable -> 0x0252 }
        r0.e = r11;	 Catch:{ Throwable -> 0x0252 }
        r11 = r9.c;	 Catch:{ Throwable -> 0x0252 }
        r11 = r11.j;	 Catch:{ Throwable -> 0x0252 }
        r0.f = r11;	 Catch:{ Throwable -> 0x0252 }
        r11 = r9.c;	 Catch:{ Throwable -> 0x0252 }
        r11 = r11.w();	 Catch:{ Throwable -> 0x0252 }
        r0.g = r11;	 Catch:{ Throwable -> 0x0252 }
        r11 = r9.c;	 Catch:{ Throwable -> 0x0252 }
        r11 = r11.g();	 Catch:{ Throwable -> 0x0252 }
        r0.m = r11;	 Catch:{ Throwable -> 0x0252 }
        r11 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0252 }
        r11.<init>();	 Catch:{ Throwable -> 0x0252 }
        r11.append(r12);	 Catch:{ Throwable -> 0x0252 }
        r11 = r11.toString();	 Catch:{ Throwable -> 0x0252 }
        r0.n = r11;	 Catch:{ Throwable -> 0x0252 }
        r11 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0252 }
        r11.<init>();	 Catch:{ Throwable -> 0x0252 }
        r11.append(r13);	 Catch:{ Throwable -> 0x0252 }
        r11 = r11.toString();	 Catch:{ Throwable -> 0x0252 }
        r0.o = r11;	 Catch:{ Throwable -> 0x0252 }
        r11 = "";
        if (r14 == 0) goto L_0x015b;
    L_0x014e:
        r2 = "\n";
        r2 = r14.split(r2);	 Catch:{ Throwable -> 0x0252 }
        r4 = r2.length;	 Catch:{ Throwable -> 0x0252 }
        if (r4 <= 0) goto L_0x0159;
    L_0x0157:
        r11 = r2[r1];	 Catch:{ Throwable -> 0x0252 }
    L_0x0159:
        r2 = r14;
        goto L_0x015d;
    L_0x015b:
        r2 = "";
    L_0x015d:
        r0.p = r11;	 Catch:{ Throwable -> 0x0252 }
        r0.q = r2;	 Catch:{ Throwable -> 0x0252 }
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x0252 }
        r0.r = r4;	 Catch:{ Throwable -> 0x0252 }
        r11 = r0.q;	 Catch:{ Throwable -> 0x0252 }
        r11 = r11.getBytes();	 Catch:{ Throwable -> 0x0252 }
        r11 = com.tencent.bugly.proguard.z.b(r11);	 Catch:{ Throwable -> 0x0252 }
        r0.u = r11;	 Catch:{ Throwable -> 0x0252 }
        r11 = com.tencent.bugly.crashreport.crash.c.f;	 Catch:{ Throwable -> 0x0252 }
        r11 = com.tencent.bugly.proguard.z.a(r11, r1);	 Catch:{ Throwable -> 0x0252 }
        r0.y = r11;	 Catch:{ Throwable -> 0x0252 }
        r11 = r9.c;	 Catch:{ Throwable -> 0x0252 }
        r11 = r11.d;	 Catch:{ Throwable -> 0x0252 }
        r0.z = r11;	 Catch:{ Throwable -> 0x0252 }
        r11 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0252 }
        r11.<init>();	 Catch:{ Throwable -> 0x0252 }
        r2 = r10.getName();	 Catch:{ Throwable -> 0x0252 }
        r11.append(r2);	 Catch:{ Throwable -> 0x0252 }
        r2 = "(";
        r11.append(r2);	 Catch:{ Throwable -> 0x0252 }
        r4 = r10.getId();	 Catch:{ Throwable -> 0x0252 }
        r11.append(r4);	 Catch:{ Throwable -> 0x0252 }
        r2 = ")";
        r11.append(r2);	 Catch:{ Throwable -> 0x0252 }
        r11 = r11.toString();	 Catch:{ Throwable -> 0x0252 }
        r0.A = r11;	 Catch:{ Throwable -> 0x0252 }
        r11 = r9.c;	 Catch:{ Throwable -> 0x0252 }
        r11 = r11.y();	 Catch:{ Throwable -> 0x0252 }
        r0.H = r11;	 Catch:{ Throwable -> 0x0252 }
        r11 = r9.c;	 Catch:{ Throwable -> 0x0252 }
        r11 = r11.v();	 Catch:{ Throwable -> 0x0252 }
        r0.h = r11;	 Catch:{ Throwable -> 0x0252 }
        r11 = r9.c;	 Catch:{ Throwable -> 0x0252 }
        r4 = r11.a;	 Catch:{ Throwable -> 0x0252 }
        r0.L = r4;	 Catch:{ Throwable -> 0x0252 }
        r11 = r9.c;	 Catch:{ Throwable -> 0x0252 }
        r11 = r11.a();	 Catch:{ Throwable -> 0x0252 }
        r0.M = r11;	 Catch:{ Throwable -> 0x0252 }
        r11 = r9.c;	 Catch:{ Throwable -> 0x0252 }
        r11 = r11.H();	 Catch:{ Throwable -> 0x0252 }
        r0.O = r11;	 Catch:{ Throwable -> 0x0252 }
        r11 = r9.c;	 Catch:{ Throwable -> 0x0252 }
        r11 = r11.I();	 Catch:{ Throwable -> 0x0252 }
        r0.P = r11;	 Catch:{ Throwable -> 0x0252 }
        r11 = r9.c;	 Catch:{ Throwable -> 0x0252 }
        r11 = r11.B();	 Catch:{ Throwable -> 0x0252 }
        r0.Q = r11;	 Catch:{ Throwable -> 0x0252 }
        r11 = r9.c;	 Catch:{ Throwable -> 0x0252 }
        r11 = r11.G();	 Catch:{ Throwable -> 0x0252 }
        r0.R = r11;	 Catch:{ Throwable -> 0x0252 }
        r11 = r9.d;	 Catch:{ Throwable -> 0x0252 }
        r11.c(r0);	 Catch:{ Throwable -> 0x0252 }
        r11 = com.tencent.bugly.proguard.y.a();	 Catch:{ Throwable -> 0x0252 }
        r0.x = r11;	 Catch:{ Throwable -> 0x0252 }
        r11 = r0.N;	 Catch:{ Throwable -> 0x0252 }
        if (r11 != 0) goto L_0x01f8;
    L_0x01f1:
        r11 = new java.util.LinkedHashMap;	 Catch:{ Throwable -> 0x0252 }
        r11.<init>();	 Catch:{ Throwable -> 0x0252 }
        r0.N = r11;	 Catch:{ Throwable -> 0x0252 }
    L_0x01f8:
        if (r15 == 0) goto L_0x01ff;
    L_0x01fa:
        r11 = r0.N;	 Catch:{ Throwable -> 0x0252 }
        r11.putAll(r15);	 Catch:{ Throwable -> 0x0252 }
    L_0x01ff:
        if (r0 != 0) goto L_0x0210;
    L_0x0201:
        r9 = "[ExtraCrashManager] Failed to package crash data.";
        r10 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x0252 }
        com.tencent.bugly.proguard.x.e(r9, r10);	 Catch:{ Throwable -> 0x0252 }
        r9 = "[ExtraCrashManager] Successfully handled.";
        r10 = new java.lang.Object[r1];
        com.tencent.bugly.proguard.x.e(r9, r10);
        return;
    L_0x0210:
        r4 = com.tencent.bugly.proguard.z.a();	 Catch:{ Throwable -> 0x0252 }
        r11 = r9.c;	 Catch:{ Throwable -> 0x0252 }
        r5 = r11.d;	 Catch:{ Throwable -> 0x0252 }
        r11 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0252 }
        r11.<init>();	 Catch:{ Throwable -> 0x0252 }
        r11.append(r12);	 Catch:{ Throwable -> 0x0252 }
        r12 = "\n";
        r11.append(r12);	 Catch:{ Throwable -> 0x0252 }
        r11.append(r13);	 Catch:{ Throwable -> 0x0252 }
        r12 = "\n";
        r11.append(r12);	 Catch:{ Throwable -> 0x0252 }
        r11.append(r14);	 Catch:{ Throwable -> 0x0252 }
        r7 = r11.toString();	 Catch:{ Throwable -> 0x0252 }
        r6 = r10;
        r8 = r0;
        com.tencent.bugly.crashreport.crash.b.a(r3, r4, r5, r6, r7, r8);	 Catch:{ Throwable -> 0x0252 }
        r10 = r9.d;	 Catch:{ Throwable -> 0x0252 }
        r10 = r10.a(r0);	 Catch:{ Throwable -> 0x0252 }
        if (r10 != 0) goto L_0x0248;
    L_0x0241:
        r9 = r9.d;	 Catch:{ Throwable -> 0x0252 }
        r10 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;
        r9.a(r0, r10, r1);	 Catch:{ Throwable -> 0x0252 }
    L_0x0248:
        r9 = "[ExtraCrashManager] Successfully handled.";
        r10 = new java.lang.Object[r1];
        com.tencent.bugly.proguard.x.e(r9, r10);
        return;
    L_0x0250:
        r9 = move-exception;
        goto L_0x0264;
    L_0x0252:
        r9 = move-exception;
        r10 = com.tencent.bugly.proguard.x.a(r9);	 Catch:{ all -> 0x0250 }
        if (r10 != 0) goto L_0x025c;
    L_0x0259:
        r9.printStackTrace();	 Catch:{ all -> 0x0250 }
    L_0x025c:
        r9 = "[ExtraCrashManager] Successfully handled.";
        r10 = new java.lang.Object[r1];
        com.tencent.bugly.proguard.x.e(r9, r10);
        return;
    L_0x0264:
        r10 = "[ExtraCrashManager] Successfully handled.";
        r11 = new java.lang.Object[r1];
        com.tencent.bugly.proguard.x.e(r10, r11);
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.d.a(com.tencent.bugly.crashreport.crash.d, java.lang.Thread, int, java.lang.String, java.lang.String, java.lang.String, java.util.Map):void");
    }

    public static void a(Thread thread, int i, String str, String str2, String str3, Map<String, String> map) {
        final Thread thread2 = thread;
        final int i2 = i;
        final String str4 = str;
        final String str5 = str2;
        final String str6 = str3;
        final Map<String, String> map2 = map;
        w.a().a(new Runnable() {
            public final void run() {
                try {
                    if (d.a == null) {
                        x.e("[ExtraCrashManager] Extra crash manager has not been initialized.", new Object[0]);
                    } else {
                        d.a(d.a, thread2, i2, str4, str5, str6, map2);
                    }
                } catch (Throwable th) {
                    if (!x.b(th)) {
                        th.printStackTrace();
                    }
                    x.e("[ExtraCrashManager] Crash error %s %s %s", str4, str5, str6);
                }
            }
        });
    }
}
