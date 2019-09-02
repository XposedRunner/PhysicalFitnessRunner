package com.tencent.bugly.crashreport.biz;

import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.common.strategy.a;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;

/* compiled from: BUGLY */
public class b {
    public static a a = null;
    private static boolean b = false;
    private static int c = 10;
    private static long d = 300000;
    private static long e = 30000;
    private static long f = 0;
    private static int g = 0;
    private static long h = 0;
    private static long i = 0;
    private static long j = 0;
    private static ActivityLifecycleCallbacks k = null;
    private static Class<?> l = null;
    private static boolean m = true;

    public static void a() {
        if (a != null) {
            a.a(2, false, 0);
        }
    }

    public static void a(long j) {
        if (j < 0) {
            j = a.a().c().q;
        }
        f = j;
    }

    public static void a(Context context) {
        if (b && context != null) {
            Application application = null;
            if (VERSION.SDK_INT >= 14) {
                if (context.getApplicationContext() instanceof Application) {
                    application = (Application) context.getApplicationContext();
                }
                if (application != null) {
                    try {
                        if (k != null) {
                            application.unregisterActivityLifecycleCallbacks(k);
                        }
                    } catch (Exception e) {
                        if (!x.a(e)) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            b = false;
        }
    }

    public static void a(final Context context, final BuglyStrategy buglyStrategy) {
        if (!b) {
            long appReportDelay;
            m = com.tencent.bugly.crashreport.common.info.a.a(context).e;
            a = new a(context, m);
            b = true;
            if (buglyStrategy != null) {
                l = buglyStrategy.getUserInfoActivity();
                appReportDelay = buglyStrategy.getAppReportDelay();
            } else {
                appReportDelay = 0;
            }
            if (appReportDelay <= 0) {
                c(context, buglyStrategy);
            } else {
                w.a().a(new Runnable() {
                    public final void run() {
                        b.c(context, buglyStrategy);
                    }
                }, appReportDelay);
            }
        }
    }

    public static void a(StrategyBean strategyBean, boolean z) {
        if (!(a == null || z)) {
            a aVar = a;
            w a = w.a();
            if (a != null) {
                a.a(/* anonymous class already generated */);
            }
        }
        if (strategyBean != null) {
            if (strategyBean.q > 0) {
                e = strategyBean.q;
            }
            if (strategyBean.w > 0) {
                c = strategyBean.w;
            }
            if (strategyBean.x > 0) {
                d = strategyBean.x;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0068 A:{RETURN} */
    private static void c(android.content.Context r14, com.tencent.bugly.BuglyStrategy r15) {
        /*
        r0 = 0;
        r1 = 1;
        if (r15 == 0) goto L_0x000d;
    L_0x0004:
        r2 = r15.recordUserInfoOnceADay();
        r15 = r15.isEnableUserInfo();
        goto L_0x000f;
    L_0x000d:
        r2 = r0;
        r15 = r1;
    L_0x000f:
        r3 = 0;
        if (r2 == 0) goto L_0x006a;
    L_0x0013:
        r15 = com.tencent.bugly.crashreport.common.info.a.a(r14);
        r2 = r15.d;
        r5 = a;
        r2 = r5.a(r2);
        if (r2 == 0) goto L_0x0065;
    L_0x0021:
        r5 = r0;
    L_0x0022:
        r6 = r2.size();
        if (r5 >= r6) goto L_0x0065;
    L_0x0028:
        r6 = r2.get(r5);
        r6 = (com.tencent.bugly.crashreport.biz.UserInfoBean) r6;
        r7 = r6.n;
        r8 = r15.j;
        r7 = r7.equals(r8);
        if (r7 == 0) goto L_0x0062;
    L_0x0038:
        r7 = r6.b;
        if (r7 != r1) goto L_0x0062;
    L_0x003c:
        r7 = com.tencent.bugly.proguard.z.b();
        r9 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1));
        if (r9 <= 0) goto L_0x0065;
    L_0x0044:
        r9 = r6.e;
        r11 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1));
        if (r11 < 0) goto L_0x0062;
    L_0x004a:
        r5 = r6.f;
        r15 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1));
        if (r15 > 0) goto L_0x0060;
    L_0x0050:
        r15 = a;
        r2 = com.tencent.bugly.proguard.w.a();
        if (r2 == 0) goto L_0x0060;
    L_0x0058:
        r5 = new com.tencent.bugly.crashreport.biz.a$2;
        r5.<init>();
        r2.a(r5);
    L_0x0060:
        r15 = r0;
        goto L_0x0066;
    L_0x0062:
        r5 = r5 + 1;
        goto L_0x0022;
    L_0x0065:
        r15 = r1;
    L_0x0066:
        if (r15 != 0) goto L_0x0069;
    L_0x0068:
        return;
    L_0x0069:
        r15 = r0;
    L_0x006a:
        r2 = com.tencent.bugly.crashreport.common.info.a.b();
        r5 = 0;
        if (r2 == 0) goto L_0x00b0;
    L_0x0071:
        r6 = java.lang.Thread.currentThread();
        r6 = r6.getStackTrace();
        r7 = r6.length;
        r8 = r0;
        r10 = r8;
        r9 = r5;
    L_0x007d:
        if (r8 >= r7) goto L_0x00a1;
    L_0x007f:
        r11 = r6[r8];
        r12 = r11.getMethodName();
        r13 = "onCreate";
        r12 = r12.equals(r13);
        if (r12 == 0) goto L_0x0091;
    L_0x008d:
        r9 = r11.getClassName();
    L_0x0091:
        r11 = r11.getClassName();
        r12 = "android.app.Activity";
        r11 = r11.equals(r12);
        if (r11 == 0) goto L_0x009e;
    L_0x009d:
        r10 = r1;
    L_0x009e:
        r8 = r8 + 1;
        goto L_0x007d;
    L_0x00a1:
        if (r9 == 0) goto L_0x00ac;
    L_0x00a3:
        if (r10 == 0) goto L_0x00a9;
    L_0x00a5:
        r2.a(r1);
        goto L_0x00ae;
    L_0x00a9:
        r9 = "background";
        goto L_0x00ae;
    L_0x00ac:
        r9 = "unknown";
    L_0x00ae:
        r2.p = r9;
    L_0x00b0:
        if (r15 == 0) goto L_0x00e4;
    L_0x00b2:
        r15 = android.os.Build.VERSION.SDK_INT;
        r2 = 14;
        if (r15 < r2) goto L_0x00e4;
    L_0x00b8:
        r15 = r14.getApplicationContext();
        r15 = r15 instanceof android.app.Application;
        if (r15 == 0) goto L_0x00c7;
    L_0x00c0:
        r14 = r14.getApplicationContext();
        r5 = r14;
        r5 = (android.app.Application) r5;
    L_0x00c7:
        if (r5 == 0) goto L_0x00e4;
    L_0x00c9:
        r14 = k;	 Catch:{ Exception -> 0x00da }
        if (r14 != 0) goto L_0x00d4;
    L_0x00cd:
        r14 = new com.tencent.bugly.crashreport.biz.b$2;	 Catch:{ Exception -> 0x00da }
        r14.<init>();	 Catch:{ Exception -> 0x00da }
        k = r14;	 Catch:{ Exception -> 0x00da }
    L_0x00d4:
        r14 = k;	 Catch:{ Exception -> 0x00da }
        r5.registerActivityLifecycleCallbacks(r14);	 Catch:{ Exception -> 0x00da }
        goto L_0x00e4;
    L_0x00da:
        r14 = move-exception;
        r15 = com.tencent.bugly.proguard.x.a(r14);
        if (r15 != 0) goto L_0x00e4;
    L_0x00e1:
        r14.printStackTrace();
    L_0x00e4:
        r14 = m;
        if (r14 == 0) goto L_0x0110;
    L_0x00e8:
        r14 = java.lang.System.currentTimeMillis();
        i = r14;
        r14 = a;
        r14.a(r1, r0, r3);
        r14 = "[session] launch app, new start";
        r15 = new java.lang.Object[r0];
        com.tencent.bugly.proguard.x.a(r14, r15);
        r14 = a;
        r14.a();
        r14 = a;
        r0 = 21600000; // 0x1499700 float:3.7026207E-38 double:1.0671818E-316;
        r15 = com.tencent.bugly.proguard.w.a();
        r2 = new com.tencent.bugly.crashreport.biz.a$c;
        r2.<init>(r0);
        r15.a(r2, r0);
    L_0x0110:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.biz.b.c(android.content.Context, com.tencent.bugly.BuglyStrategy):void");
    }

    static /* synthetic */ int g() {
        int i = g;
        g = i + 1;
        return i;
    }
}
