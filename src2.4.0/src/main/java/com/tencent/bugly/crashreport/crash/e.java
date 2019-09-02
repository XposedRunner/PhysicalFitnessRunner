package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import com.tencent.bugly.crashreport.common.info.b;
import com.tencent.bugly.crashreport.common.strategy.a;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import com.tencent.bugly.proguard.z;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.HashMap;

/* compiled from: BUGLY */
public final class e implements UncaughtExceptionHandler {
    private static String h;
    private static final Object i = new Object();
    private Context a;
    private b b;
    private a c;
    private com.tencent.bugly.crashreport.common.info.a d;
    private UncaughtExceptionHandler e;
    private UncaughtExceptionHandler f;
    private boolean g = false;
    private int j;

    public e(Context context, b bVar, a aVar, com.tencent.bugly.crashreport.common.info.a aVar2) {
        this.a = context;
        this.b = bVar;
        this.c = aVar;
        this.d = aVar2;
    }

    private static String a(Throwable th, int i) {
        if (th == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        try {
            if (th.getStackTrace() != null) {
                StackTraceElement[] stackTrace = th.getStackTrace();
                int length = stackTrace.length;
                int i2 = 0;
                while (i2 < length) {
                    StackTraceElement stackTraceElement = stackTrace[i2];
                    if (i <= 0 || stringBuilder.length() < i) {
                        stringBuilder.append(stackTraceElement.toString());
                        stringBuilder.append("\n");
                        i2++;
                    } else {
                        StringBuilder stringBuilder2 = new StringBuilder("\n[Stack over limit size :");
                        stringBuilder2.append(i);
                        stringBuilder2.append(" , has been cutted !]");
                        stringBuilder.append(stringBuilder2.toString());
                        return stringBuilder.toString();
                    }
                }
            }
        } catch (Throwable th2) {
            x.e("gen stack error %s", th2.toString());
        }
        return stringBuilder.toString();
    }

    private static boolean a(UncaughtExceptionHandler uncaughtExceptionHandler) {
        if (uncaughtExceptionHandler == null) {
            return true;
        }
        String name = uncaughtExceptionHandler.getClass().getName();
        String str = "uncaughtException";
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            String className = stackTraceElement.getClassName();
            String methodName = stackTraceElement.getMethodName();
            if (name.equals(className) && str.equals(methodName)) {
                return false;
            }
        }
        return true;
    }

    private static boolean a(Thread thread) {
        synchronized (i) {
            if (h == null || !thread.getName().equals(h)) {
                h = thread.getName();
                return false;
            }
            return true;
        }
    }

    private CrashDetailBean b(Thread thread, Throwable th, boolean z, String str, byte[] bArr) {
        int i = 0;
        if (th == null) {
            x.d("We can do nothing with a null throwable.", new Object[0]);
            return null;
        }
        Object a;
        StringBuilder stringBuilder;
        boolean l = c.a().l();
        String str2 = (l && z) ? " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]" : "";
        if (l && z) {
            x.e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.B = b.h();
        crashDetailBean.C = b.f();
        crashDetailBean.D = b.j();
        crashDetailBean.E = this.d.p();
        crashDetailBean.F = this.d.o();
        crashDetailBean.G = this.d.q();
        crashDetailBean.w = z.a(this.a, c.e, null);
        crashDetailBean.x = y.a();
        String str3 = "user log size:%d";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(crashDetailBean.x == null ? 0 : crashDetailBean.x.length);
        x.a(str3, objArr);
        crashDetailBean.b = z ? 0 : 2;
        crashDetailBean.e = this.d.h();
        crashDetailBean.f = this.d.j;
        crashDetailBean.g = this.d.w();
        crashDetailBean.m = this.d.g();
        String name = th.getClass().getName();
        String b = b(th, 1000);
        if (b == null) {
            b = "";
        }
        String str4 = "stack frame :%d, has cause %b";
        Object[] objArr2 = new Object[2];
        objArr2[0] = Integer.valueOf(th.getStackTrace().length);
        objArr2[1] = Boolean.valueOf(th.getCause() != null);
        x.e(str4, objArr2);
        str3 = "";
        if (th.getStackTrace().length > 0) {
            str3 = th.getStackTrace()[0].toString();
        }
        Throwable th2 = th;
        while (th2 != null && th2.getCause() != null) {
            th2 = th2.getCause();
        }
        if (th2 == null || th2 == th) {
            crashDetailBean.n = name;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(b);
            stringBuilder2.append(str2);
            crashDetailBean.o = stringBuilder2.toString();
            if (crashDetailBean.o == null) {
                crashDetailBean.o = "";
            }
            crashDetailBean.p = str3;
            a = a(th, c.f);
            crashDetailBean.q = a;
        } else {
            crashDetailBean.n = th2.getClass().getName();
            crashDetailBean.o = b(th2, 1000);
            if (crashDetailBean.o == null) {
                crashDetailBean.o = "";
            }
            if (th2.getStackTrace().length > 0) {
                crashDetailBean.p = th2.getStackTrace()[0].toString();
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(name);
            stringBuilder.append(":");
            stringBuilder.append(b);
            stringBuilder.append("\n");
            stringBuilder.append(str3);
            stringBuilder.append("\n......");
            stringBuilder.append("\nCaused by:\n");
            stringBuilder.append(crashDetailBean.n);
            stringBuilder.append(":");
            stringBuilder.append(crashDetailBean.o);
            stringBuilder.append("\n");
            a = a(th2, c.f);
            stringBuilder.append(a);
            crashDetailBean.q = stringBuilder.toString();
        }
        crashDetailBean.r = System.currentTimeMillis();
        crashDetailBean.u = z.b(crashDetailBean.q.getBytes());
        try {
            crashDetailBean.y = z.a(c.f, false);
            crashDetailBean.z = this.d.d;
            stringBuilder = new StringBuilder();
            stringBuilder.append(thread.getName());
            stringBuilder.append("(");
            stringBuilder.append(thread.getId());
            stringBuilder.append(")");
            crashDetailBean.A = stringBuilder.toString();
            crashDetailBean.y.put(crashDetailBean.A, a);
            crashDetailBean.H = this.d.y();
            crashDetailBean.h = this.d.v();
            crashDetailBean.i = this.d.K();
            crashDetailBean.L = this.d.a;
            crashDetailBean.M = this.d.a();
            crashDetailBean.O = this.d.H();
            crashDetailBean.P = this.d.I();
            crashDetailBean.Q = this.d.B();
            crashDetailBean.R = this.d.G();
        } catch (Throwable th3) {
            x.e("handle crash error %s", th3.toString());
        }
        if (z) {
            this.b.c(crashDetailBean);
        } else {
            int i2 = (str == null || str.length() <= 0) ? 0 : 1;
            if (bArr != null && bArr.length > 0) {
                i = 1;
            }
            if (i2 != 0) {
                crashDetailBean.N = new HashMap(1);
                crashDetailBean.N.put("UserData", str);
            }
            if (i != 0) {
                crashDetailBean.S = bArr;
            }
        }
        return crashDetailBean;
    }

    private static String b(Throwable th, int i) {
        if (th.getMessage() == null) {
            return "";
        }
        if (th.getMessage().length() <= 1000) {
            return th.getMessage();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(th.getMessage().substring(0, 1000));
        stringBuilder.append("\n[Message over limit size:1000");
        stringBuilder.append(", has been cutted!]");
        return stringBuilder.toString();
    }

    public final synchronized void a() {
        if (this.j >= 10) {
            x.a("java crash handler over %d, no need set.", Integer.valueOf(10));
            return;
        }
        this.g = true;
        UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null) {
            if (!getClass().getName().equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                if ("com.android.internal.os.RuntimeInit$UncaughtHandler".equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                    x.a("backup system java handler: %s", defaultUncaughtExceptionHandler.toString());
                    this.f = defaultUncaughtExceptionHandler;
                    this.e = defaultUncaughtExceptionHandler;
                } else {
                    x.a("backup java handler: %s", defaultUncaughtExceptionHandler.toString());
                    this.e = defaultUncaughtExceptionHandler;
                }
            } else {
                return;
            }
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.j++;
        x.a("registered java monitor: %s", toString());
    }

    /* JADX WARNING: Missing block: B:16:0x002b, code skipped:
            return;
     */
    public final synchronized void a(com.tencent.bugly.crashreport.common.strategy.StrategyBean r5) {
        /*
        r4 = this;
        monitor-enter(r4);
        if (r5 == 0) goto L_0x002a;
    L_0x0003:
        r0 = r5.g;	 Catch:{ all -> 0x0027 }
        r1 = r4.g;	 Catch:{ all -> 0x0027 }
        if (r0 == r1) goto L_0x002a;
    L_0x0009:
        r0 = "java changed to %b";
        r1 = 1;
        r1 = new java.lang.Object[r1];	 Catch:{ all -> 0x0027 }
        r2 = 0;
        r3 = r5.g;	 Catch:{ all -> 0x0027 }
        r3 = java.lang.Boolean.valueOf(r3);	 Catch:{ all -> 0x0027 }
        r1[r2] = r3;	 Catch:{ all -> 0x0027 }
        com.tencent.bugly.proguard.x.a(r0, r1);	 Catch:{ all -> 0x0027 }
        r5 = r5.g;	 Catch:{ all -> 0x0027 }
        if (r5 == 0) goto L_0x0023;
    L_0x001e:
        r4.a();	 Catch:{ all -> 0x0027 }
        monitor-exit(r4);
        return;
    L_0x0023:
        r4.b();	 Catch:{ all -> 0x0027 }
        goto L_0x002a;
    L_0x0027:
        r5 = move-exception;
        monitor-exit(r4);
        throw r5;
    L_0x002a:
        monitor-exit(r4);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.e.a(com.tencent.bugly.crashreport.common.strategy.StrategyBean):void");
    }

    /* JADX WARNING: Missing block: B:82:0x01d4, code skipped:
            if (r8.f != null) goto L_0x0084;
     */
    /* JADX WARNING: Missing block: B:83:0x01d8, code skipped:
            com.tencent.bugly.proguard.x.e("crashreport last handle start!", new java.lang.Object[0]);
            com.tencent.bugly.proguard.x.e("current process die", new java.lang.Object[0]);
            android.os.Process.killProcess(android.os.Process.myPid());
            java.lang.System.exit(1);
            com.tencent.bugly.proguard.x.e("crashreport last handle end!", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing block: B:84:0x01f7, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:97:0x0216, code skipped:
            if (r8.f != null) goto L_0x0084;
     */
    public final void a(java.lang.Thread r9, java.lang.Throwable r10, boolean r11, java.lang.String r12, byte[] r13) {
        /*
        r8 = this;
        r0 = 1;
        r1 = 0;
        if (r11 == 0) goto L_0x004c;
    L_0x0004:
        r2 = "Java Crash Happen cause by %s(%d)";
        r3 = 2;
        r3 = new java.lang.Object[r3];
        r4 = r9.getName();
        r3[r1] = r4;
        r4 = r9.getId();
        r4 = java.lang.Long.valueOf(r4);
        r3[r0] = r4;
        com.tencent.bugly.proguard.x.e(r2, r3);
        r2 = a(r9);
        if (r2 == 0) goto L_0x0053;
    L_0x0022:
        r2 = "this class has handled this exception";
        r3 = new java.lang.Object[r1];
        com.tencent.bugly.proguard.x.a(r2, r3);
        r2 = r8.f;
        if (r2 == 0) goto L_0x003a;
    L_0x002d:
        r2 = "call system handler";
        r3 = new java.lang.Object[r1];
        com.tencent.bugly.proguard.x.a(r2, r3);
        r2 = r8.f;
        r2.uncaughtException(r9, r10);
        goto L_0x0053;
    L_0x003a:
        r2 = "current process die";
        r3 = new java.lang.Object[r1];
        com.tencent.bugly.proguard.x.e(r2, r3);
        r2 = android.os.Process.myPid();
        android.os.Process.killProcess(r2);
        java.lang.System.exit(r0);
        goto L_0x0053;
    L_0x004c:
        r2 = "Java Catch Happen";
        r3 = new java.lang.Object[r1];
        com.tencent.bugly.proguard.x.e(r2, r3);
    L_0x0053:
        r2 = r8.g;	 Catch:{ Throwable -> 0x01fa }
        if (r2 != 0) goto L_0x00b8;
    L_0x0057:
        r12 = "Java crash handler is disable. Just return.";
        r13 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x01fa }
        com.tencent.bugly.proguard.x.c(r12, r13);	 Catch:{ Throwable -> 0x01fa }
        if (r11 == 0) goto L_0x00b7;
    L_0x0060:
        r11 = r8.e;
        if (r11 == 0) goto L_0x0080;
    L_0x0064:
        r11 = r8.e;
        r11 = a(r11);
        if (r11 == 0) goto L_0x0080;
    L_0x006c:
        r11 = "sys default last handle start!";
        r12 = new java.lang.Object[r1];
        com.tencent.bugly.proguard.x.e(r11, r12);
        r11 = r8.e;
        r11.uncaughtException(r9, r10);
        r9 = "sys default last handle end!";
        r10 = new java.lang.Object[r1];
        com.tencent.bugly.proguard.x.e(r9, r10);
        return;
    L_0x0080:
        r11 = r8.f;
        if (r11 == 0) goto L_0x0098;
    L_0x0084:
        r11 = "system handle start!";
        r12 = new java.lang.Object[r1];
        com.tencent.bugly.proguard.x.e(r11, r12);
        r11 = r8.f;
        r11.uncaughtException(r9, r10);
        r9 = "system handle end!";
        r10 = new java.lang.Object[r1];
        com.tencent.bugly.proguard.x.e(r9, r10);
        return;
    L_0x0098:
        r9 = "crashreport last handle start!";
        r10 = new java.lang.Object[r1];
        com.tencent.bugly.proguard.x.e(r9, r10);
        r9 = "current process die";
        r10 = new java.lang.Object[r1];
        com.tencent.bugly.proguard.x.e(r9, r10);
        r9 = android.os.Process.myPid();
        android.os.Process.killProcess(r9);
        java.lang.System.exit(r0);
        r9 = "crashreport last handle end!";
        r10 = new java.lang.Object[r1];
        com.tencent.bugly.proguard.x.e(r9, r10);
    L_0x00b7:
        return;
    L_0x00b8:
        r2 = r8.c;	 Catch:{ Throwable -> 0x01fa }
        r2 = r2.b();	 Catch:{ Throwable -> 0x01fa }
        if (r2 != 0) goto L_0x00db;
    L_0x00c0:
        r2 = "waiting for remote sync";
        r3 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x01fa }
        com.tencent.bugly.proguard.x.e(r2, r3);	 Catch:{ Throwable -> 0x01fa }
        r2 = r1;
    L_0x00c8:
        r3 = r8.c;	 Catch:{ Throwable -> 0x01fa }
        r3 = r3.b();	 Catch:{ Throwable -> 0x01fa }
        if (r3 != 0) goto L_0x00db;
    L_0x00d0:
        r3 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        com.tencent.bugly.proguard.z.b(r3);	 Catch:{ Throwable -> 0x01fa }
        r2 = r2 + 500;
        r3 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;
        if (r2 < r3) goto L_0x00c8;
    L_0x00db:
        r2 = r8.c;	 Catch:{ Throwable -> 0x01fa }
        r2 = r2.b();	 Catch:{ Throwable -> 0x01fa }
        if (r2 != 0) goto L_0x00ea;
    L_0x00e3:
        r2 = "no remote but still store!";
        r3 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x01fa }
        com.tencent.bugly.proguard.x.d(r2, r3);	 Catch:{ Throwable -> 0x01fa }
    L_0x00ea:
        r2 = r8.c;	 Catch:{ Throwable -> 0x01fa }
        r2 = r2.c();	 Catch:{ Throwable -> 0x01fa }
        r2 = r2.g;	 Catch:{ Throwable -> 0x01fa }
        if (r2 != 0) goto L_0x0152;
    L_0x00f4:
        r2 = r8.c;	 Catch:{ Throwable -> 0x01fa }
        r2 = r2.b();	 Catch:{ Throwable -> 0x01fa }
        if (r2 == 0) goto L_0x0152;
    L_0x00fc:
        r12 = "crash report was closed by remote , will not upload to Bugly , print local for helpful!";
        r13 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x01fa }
        com.tencent.bugly.proguard.x.e(r12, r13);	 Catch:{ Throwable -> 0x01fa }
        if (r11 == 0) goto L_0x0108;
    L_0x0105:
        r12 = "JAVA_CRASH";
        goto L_0x010a;
    L_0x0108:
        r12 = "JAVA_CATCH";
    L_0x010a:
        r2 = r12;
        r3 = com.tencent.bugly.proguard.z.a();	 Catch:{ Throwable -> 0x01fa }
        r12 = r8.d;	 Catch:{ Throwable -> 0x01fa }
        r4 = r12.d;	 Catch:{ Throwable -> 0x01fa }
        r6 = com.tencent.bugly.proguard.z.a(r10);	 Catch:{ Throwable -> 0x01fa }
        r7 = 0;
        r5 = r9;
        com.tencent.bugly.crashreport.crash.b.a(r2, r3, r4, r5, r6, r7);	 Catch:{ Throwable -> 0x01fa }
        if (r11 == 0) goto L_0x0151;
    L_0x011e:
        r11 = r8.e;
        if (r11 == 0) goto L_0x012c;
    L_0x0122:
        r11 = r8.e;
        r11 = a(r11);
        if (r11 == 0) goto L_0x012c;
    L_0x012a:
        goto L_0x006c;
    L_0x012c:
        r11 = r8.f;
        if (r11 == 0) goto L_0x0132;
    L_0x0130:
        goto L_0x0084;
    L_0x0132:
        r9 = "crashreport last handle start!";
        r10 = new java.lang.Object[r1];
        com.tencent.bugly.proguard.x.e(r9, r10);
        r9 = "current process die";
        r10 = new java.lang.Object[r1];
        com.tencent.bugly.proguard.x.e(r9, r10);
        r9 = android.os.Process.myPid();
        android.os.Process.killProcess(r9);
        java.lang.System.exit(r0);
        r9 = "crashreport last handle end!";
        r10 = new java.lang.Object[r1];
        com.tencent.bugly.proguard.x.e(r9, r10);
    L_0x0151:
        return;
    L_0x0152:
        r12 = r8.b(r9, r10, r11, r12, r13);	 Catch:{ Throwable -> 0x01fa }
        if (r12 != 0) goto L_0x0195;
    L_0x0158:
        r12 = "pkg crash datas fail!";
        r13 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x01fa }
        com.tencent.bugly.proguard.x.e(r12, r13);	 Catch:{ Throwable -> 0x01fa }
        if (r11 == 0) goto L_0x0194;
    L_0x0161:
        r11 = r8.e;
        if (r11 == 0) goto L_0x016f;
    L_0x0165:
        r11 = r8.e;
        r11 = a(r11);
        if (r11 == 0) goto L_0x016f;
    L_0x016d:
        goto L_0x006c;
    L_0x016f:
        r11 = r8.f;
        if (r11 == 0) goto L_0x0175;
    L_0x0173:
        goto L_0x0084;
    L_0x0175:
        r9 = "crashreport last handle start!";
        r10 = new java.lang.Object[r1];
        com.tencent.bugly.proguard.x.e(r9, r10);
        r9 = "current process die";
        r10 = new java.lang.Object[r1];
        com.tencent.bugly.proguard.x.e(r9, r10);
        r9 = android.os.Process.myPid();
        android.os.Process.killProcess(r9);
        java.lang.System.exit(r0);
        r9 = "crashreport last handle end!";
        r10 = new java.lang.Object[r1];
        com.tencent.bugly.proguard.x.e(r9, r10);
    L_0x0194:
        return;
    L_0x0195:
        if (r11 == 0) goto L_0x019a;
    L_0x0197:
        r13 = "JAVA_CRASH";
        goto L_0x019c;
    L_0x019a:
        r13 = "JAVA_CATCH";
    L_0x019c:
        r2 = r13;
        r3 = com.tencent.bugly.proguard.z.a();	 Catch:{ Throwable -> 0x01fa }
        r13 = r8.d;	 Catch:{ Throwable -> 0x01fa }
        r4 = r13.d;	 Catch:{ Throwable -> 0x01fa }
        r6 = com.tencent.bugly.proguard.z.a(r10);	 Catch:{ Throwable -> 0x01fa }
        r5 = r9;
        r7 = r12;
        com.tencent.bugly.crashreport.crash.b.a(r2, r3, r4, r5, r6, r7);	 Catch:{ Throwable -> 0x01fa }
        r13 = r8.b;	 Catch:{ Throwable -> 0x01fa }
        r13 = r13.a(r12);	 Catch:{ Throwable -> 0x01fa }
        if (r13 != 0) goto L_0x01bd;
    L_0x01b6:
        r13 = r8.b;	 Catch:{ Throwable -> 0x01fa }
        r2 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;
        r13.a(r12, r2, r11);	 Catch:{ Throwable -> 0x01fa }
    L_0x01bd:
        r13 = r8.b;	 Catch:{ Throwable -> 0x01fa }
        r13.b(r12);	 Catch:{ Throwable -> 0x01fa }
        if (r11 == 0) goto L_0x021a;
    L_0x01c4:
        r11 = r8.e;
        if (r11 == 0) goto L_0x01d2;
    L_0x01c8:
        r11 = r8.e;
        r11 = a(r11);
        if (r11 == 0) goto L_0x01d2;
    L_0x01d0:
        goto L_0x006c;
    L_0x01d2:
        r11 = r8.f;
        if (r11 == 0) goto L_0x01d8;
    L_0x01d6:
        goto L_0x0084;
    L_0x01d8:
        r9 = "crashreport last handle start!";
        r10 = new java.lang.Object[r1];
        com.tencent.bugly.proguard.x.e(r9, r10);
        r9 = "current process die";
        r10 = new java.lang.Object[r1];
        com.tencent.bugly.proguard.x.e(r9, r10);
        r9 = android.os.Process.myPid();
        android.os.Process.killProcess(r9);
        java.lang.System.exit(r0);
        r9 = "crashreport last handle end!";
        r10 = new java.lang.Object[r1];
        com.tencent.bugly.proguard.x.e(r9, r10);
        return;
    L_0x01f8:
        r12 = move-exception;
        goto L_0x021b;
    L_0x01fa:
        r12 = move-exception;
        r13 = com.tencent.bugly.proguard.x.a(r12);	 Catch:{ all -> 0x01f8 }
        if (r13 != 0) goto L_0x0204;
    L_0x0201:
        r12.printStackTrace();	 Catch:{ all -> 0x01f8 }
    L_0x0204:
        if (r11 == 0) goto L_0x021a;
    L_0x0206:
        r11 = r8.e;
        if (r11 == 0) goto L_0x0214;
    L_0x020a:
        r11 = r8.e;
        r11 = a(r11);
        if (r11 == 0) goto L_0x0214;
    L_0x0212:
        goto L_0x006c;
    L_0x0214:
        r11 = r8.f;
        if (r11 == 0) goto L_0x01d8;
    L_0x0218:
        goto L_0x0084;
    L_0x021a:
        return;
    L_0x021b:
        if (r11 == 0) goto L_0x0274;
    L_0x021d:
        r11 = r8.e;
        if (r11 == 0) goto L_0x023d;
    L_0x0221:
        r11 = r8.e;
        r11 = a(r11);
        if (r11 == 0) goto L_0x023d;
    L_0x0229:
        r11 = "sys default last handle start!";
        r13 = new java.lang.Object[r1];
        com.tencent.bugly.proguard.x.e(r11, r13);
        r11 = r8.e;
        r11.uncaughtException(r9, r10);
        r9 = "sys default last handle end!";
        r10 = new java.lang.Object[r1];
        com.tencent.bugly.proguard.x.e(r9, r10);
        goto L_0x0274;
    L_0x023d:
        r11 = r8.f;
        if (r11 == 0) goto L_0x0255;
    L_0x0241:
        r11 = "system handle start!";
        r13 = new java.lang.Object[r1];
        com.tencent.bugly.proguard.x.e(r11, r13);
        r11 = r8.f;
        r11.uncaughtException(r9, r10);
        r9 = "system handle end!";
        r10 = new java.lang.Object[r1];
        com.tencent.bugly.proguard.x.e(r9, r10);
        goto L_0x0274;
    L_0x0255:
        r9 = "crashreport last handle start!";
        r10 = new java.lang.Object[r1];
        com.tencent.bugly.proguard.x.e(r9, r10);
        r9 = "current process die";
        r10 = new java.lang.Object[r1];
        com.tencent.bugly.proguard.x.e(r9, r10);
        r9 = android.os.Process.myPid();
        android.os.Process.killProcess(r9);
        java.lang.System.exit(r0);
        r9 = "crashreport last handle end!";
        r10 = new java.lang.Object[r1];
        com.tencent.bugly.proguard.x.e(r9, r10);
    L_0x0274:
        throw r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.e.a(java.lang.Thread, java.lang.Throwable, boolean, java.lang.String, byte[]):void");
    }

    public final synchronized void b() {
        this.g = false;
        x.a("close java monitor!", new Object[0]);
        if (Thread.getDefaultUncaughtExceptionHandler().getClass().getName().contains("bugly")) {
            x.a("Java monitor to unregister: %s", toString());
            Thread.setDefaultUncaughtExceptionHandler(this.e);
            this.j--;
        }
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        synchronized (i) {
            a(thread, th, true, null, null);
        }
    }
}
