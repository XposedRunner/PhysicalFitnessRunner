package com.tencent.bugly.crashreport.crash.jni;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.bugly.Bugly;
import com.tencent.bugly.crashreport.a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.b;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.io.File;

/* compiled from: BUGLY */
public class NativeCrashHandler implements a {
    private static NativeCrashHandler a;
    private static boolean l;
    private static boolean m;
    private final Context b;
    private final com.tencent.bugly.crashreport.common.info.a c;
    private final w d;
    private NativeExceptionHandler e;
    private String f;
    private final boolean g;
    private boolean h = false;
    private boolean i = false;
    private boolean j = false;
    private boolean k = false;
    private b n;

    @SuppressLint({"SdCardPath"})
    private NativeCrashHandler(Context context, com.tencent.bugly.crashreport.common.info.a aVar, b bVar, w wVar, boolean z, String str) {
        this.b = z.a(context);
        try {
            if (z.a(str)) {
                str = context.getDir("bugly", 0).getAbsolutePath();
            }
        } catch (Throwable unused) {
            str = com.tencent.bugly.crashreport.common.info.a.a(context).c;
            StringBuilder stringBuilder = new StringBuilder("/data/data/");
            stringBuilder.append(str);
            stringBuilder.append("/app_bugly");
            str = stringBuilder.toString();
        }
        this.n = bVar;
        this.f = str;
        this.c = aVar;
        this.d = wVar;
        this.g = z;
        this.e = new a(context, aVar, bVar, com.tencent.bugly.crashreport.common.strategy.a.a());
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x007f A:{Catch:{ Throwable -> 0x008d }} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008b A:{Catch:{ Throwable -> 0x008d }} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0099 A:{Catch:{ Throwable -> 0x00bb }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0091 A:{Catch:{ Throwable -> 0x00bb }} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ac A:{Catch:{ Throwable -> 0x00bb }} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a4 A:{Catch:{ Throwable -> 0x00bb }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0091 A:{Catch:{ Throwable -> 0x00bb }} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0099 A:{Catch:{ Throwable -> 0x00bb }} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a4 A:{Catch:{ Throwable -> 0x00bb }} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ac A:{Catch:{ Throwable -> 0x00bb }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x008d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:62:0x018d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:40:0x00bb */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:7|8|9|(3:11|12|(16:14|(1:16)(15:18|(1:20)|21|22|(1:24)|25|(1:27)|28|29|(1:31)(1:32)|33|(1:35)(1:36)|37|38|39)|17|21|22|(0)|25|(0)|28|29|(0)(0)|33|(0)(0)|37|38|39))(2:42|(6:44|45|(1:47)(1:48)|49|(1:51)|(7:53|(1:55)|56|(1:58)|59|60|61)))|62|63|64|65) */
    /* JADX WARNING: Can't wrap try/catch for region: R(16:14|(1:16)(15:18|(1:20)|21|22|(1:24)|25|(1:27)|28|29|(1:31)(1:32)|33|(1:35)(1:36)|37|38|39)|17|21|22|(0)|25|(0)|28|29|(0)(0)|33|(0)(0)|37|38|39) */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:40|41) */
    /* JADX WARNING: Missing block: B:41:?, code skipped:
            com.tencent.bugly.proguard.x.c("[Native] Failed to load Bugly SO file.", new java.lang.Object[0]);
     */
    private synchronized void a(boolean r11) {
        /*
        r10 = this;
        monitor-enter(r10);
        r0 = r10.j;	 Catch:{ all -> 0x0193 }
        r1 = 0;
        if (r0 == 0) goto L_0x000f;
    L_0x0006:
        r11 = "[Native] Native crash report has already registered.";
        r0 = new java.lang.Object[r1];	 Catch:{ all -> 0x0193 }
        com.tencent.bugly.proguard.x.d(r11, r0);	 Catch:{ all -> 0x0193 }
        monitor-exit(r10);
        return;
    L_0x000f:
        r0 = r10.i;	 Catch:{ all -> 0x0193 }
        r2 = 2;
        r3 = 1;
        if (r0 == 0) goto L_0x00c4;
    L_0x0015:
        r0 = r10.f;	 Catch:{ Throwable -> 0x00bb }
        r11 = r10.regist(r0, r11, r3);	 Catch:{ Throwable -> 0x00bb }
        if (r11 == 0) goto L_0x018d;
    L_0x001d:
        r0 = "[Native] Native Crash Report enable.";
        r4 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x00bb }
        com.tencent.bugly.proguard.x.a(r0, r4);	 Catch:{ Throwable -> 0x00bb }
        r0 = "[Native] Check extra jni for Bugly NDK v%s";
        r4 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x00bb }
        r4[r1] = r11;	 Catch:{ Throwable -> 0x00bb }
        com.tencent.bugly.proguard.x.c(r0, r4);	 Catch:{ Throwable -> 0x00bb }
        r0 = "2.1.1";
        r4 = ".";
        r5 = "";
        r0 = r0.replace(r4, r5);	 Catch:{ Throwable -> 0x00bb }
        r4 = "2.3.0";
        r5 = ".";
        r6 = "";
        r4 = r4.replace(r5, r6);	 Catch:{ Throwable -> 0x00bb }
        r5 = ".";
        r6 = "";
        r5 = r11.replace(r5, r6);	 Catch:{ Throwable -> 0x00bb }
        r6 = r5.length();	 Catch:{ Throwable -> 0x00bb }
        if (r6 != r2) goto L_0x0061;
    L_0x004f:
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00bb }
        r2.<init>();	 Catch:{ Throwable -> 0x00bb }
        r2.append(r5);	 Catch:{ Throwable -> 0x00bb }
        r5 = "0";
        r2.append(r5);	 Catch:{ Throwable -> 0x00bb }
    L_0x005c:
        r5 = r2.toString();	 Catch:{ Throwable -> 0x00bb }
        goto L_0x0075;
    L_0x0061:
        r2 = r5.length();	 Catch:{ Throwable -> 0x00bb }
        if (r2 != r3) goto L_0x0075;
    L_0x0067:
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00bb }
        r2.<init>();	 Catch:{ Throwable -> 0x00bb }
        r2.append(r5);	 Catch:{ Throwable -> 0x00bb }
        r5 = "00";
        r2.append(r5);	 Catch:{ Throwable -> 0x00bb }
        goto L_0x005c;
    L_0x0075:
        r2 = java.lang.Integer.parseInt(r5);	 Catch:{ Throwable -> 0x008d }
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ Throwable -> 0x008d }
        if (r2 < r0) goto L_0x0081;
    L_0x007f:
        l = r3;	 Catch:{ Throwable -> 0x008d }
    L_0x0081:
        r0 = java.lang.Integer.parseInt(r5);	 Catch:{ Throwable -> 0x008d }
        r2 = java.lang.Integer.parseInt(r4);	 Catch:{ Throwable -> 0x008d }
        if (r0 < r2) goto L_0x008d;
    L_0x008b:
        m = r3;	 Catch:{ Throwable -> 0x008d }
    L_0x008d:
        r0 = m;	 Catch:{ Throwable -> 0x00bb }
        if (r0 == 0) goto L_0x0099;
    L_0x0091:
        r0 = "[Native] Info setting jni can be accessed.";
        r2 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x00bb }
        com.tencent.bugly.proguard.x.a(r0, r2);	 Catch:{ Throwable -> 0x00bb }
        goto L_0x00a0;
    L_0x0099:
        r0 = "[Native] Info setting jni can not be accessed.";
        r2 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x00bb }
        com.tencent.bugly.proguard.x.d(r0, r2);	 Catch:{ Throwable -> 0x00bb }
    L_0x00a0:
        r0 = l;	 Catch:{ Throwable -> 0x00bb }
        if (r0 == 0) goto L_0x00ac;
    L_0x00a4:
        r0 = "[Native] Extra jni can be accessed.";
        r2 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x00bb }
        com.tencent.bugly.proguard.x.a(r0, r2);	 Catch:{ Throwable -> 0x00bb }
        goto L_0x00b3;
    L_0x00ac:
        r0 = "[Native] Extra jni can not be accessed.";
        r2 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x00bb }
        com.tencent.bugly.proguard.x.d(r0, r2);	 Catch:{ Throwable -> 0x00bb }
    L_0x00b3:
        r0 = r10.c;	 Catch:{ Throwable -> 0x00bb }
        r0.n = r11;	 Catch:{ Throwable -> 0x00bb }
        r10.j = r3;	 Catch:{ Throwable -> 0x00bb }
        monitor-exit(r10);
        return;
    L_0x00bb:
        r11 = "[Native] Failed to load Bugly SO file.";
        r0 = new java.lang.Object[r1];	 Catch:{ all -> 0x0193 }
        com.tencent.bugly.proguard.x.c(r11, r0);	 Catch:{ all -> 0x0193 }
        goto L_0x018d;
    L_0x00c4:
        r0 = r10.h;	 Catch:{ all -> 0x0193 }
        if (r0 == 0) goto L_0x018d;
    L_0x00c8:
        r0 = "com.tencent.feedback.eup.jni.NativeExceptionUpload";
        r4 = "registNativeExceptionHandler2";
        r5 = 4;
        r6 = new java.lang.Class[r5];	 Catch:{ Throwable -> 0x018d }
        r7 = java.lang.String.class;
        r6[r1] = r7;	 Catch:{ Throwable -> 0x018d }
        r7 = java.lang.String.class;
        r6[r3] = r7;	 Catch:{ Throwable -> 0x018d }
        r7 = java.lang.Integer.TYPE;	 Catch:{ Throwable -> 0x018d }
        r6[r2] = r7;	 Catch:{ Throwable -> 0x018d }
        r7 = java.lang.Integer.TYPE;	 Catch:{ Throwable -> 0x018d }
        r8 = 3;
        r6[r8] = r7;	 Catch:{ Throwable -> 0x018d }
        r5 = new java.lang.Object[r5];	 Catch:{ Throwable -> 0x018d }
        r7 = r10.f;	 Catch:{ Throwable -> 0x018d }
        r5[r1] = r7;	 Catch:{ Throwable -> 0x018d }
        r7 = com.tencent.bugly.crashreport.common.info.b.a(r1);	 Catch:{ Throwable -> 0x018d }
        r5[r3] = r7;	 Catch:{ Throwable -> 0x018d }
        r7 = 5;
        if (r11 == 0) goto L_0x00f1;
    L_0x00ef:
        r9 = r3;
        goto L_0x00f2;
    L_0x00f1:
        r9 = r7;
    L_0x00f2:
        r9 = java.lang.Integer.valueOf(r9);	 Catch:{ Throwable -> 0x018d }
        r5[r2] = r9;	 Catch:{ Throwable -> 0x018d }
        r9 = java.lang.Integer.valueOf(r3);	 Catch:{ Throwable -> 0x018d }
        r5[r8] = r9;	 Catch:{ Throwable -> 0x018d }
        r9 = 0;
        r0 = com.tencent.bugly.proguard.z.a(r0, r4, r9, r6, r5);	 Catch:{ Throwable -> 0x018d }
        r0 = (java.lang.String) r0;	 Catch:{ Throwable -> 0x018d }
        if (r0 != 0) goto L_0x0138;
    L_0x0107:
        r0 = "com.tencent.feedback.eup.jni.NativeExceptionUpload";
        r4 = "registNativeExceptionHandler";
        r5 = new java.lang.Class[r8];	 Catch:{ Throwable -> 0x018d }
        r6 = java.lang.String.class;
        r5[r1] = r6;	 Catch:{ Throwable -> 0x018d }
        r6 = java.lang.String.class;
        r5[r3] = r6;	 Catch:{ Throwable -> 0x018d }
        r6 = java.lang.Integer.TYPE;	 Catch:{ Throwable -> 0x018d }
        r5[r2] = r6;	 Catch:{ Throwable -> 0x018d }
        r6 = new java.lang.Object[r8];	 Catch:{ Throwable -> 0x018d }
        r8 = r10.f;	 Catch:{ Throwable -> 0x018d }
        r6[r1] = r8;	 Catch:{ Throwable -> 0x018d }
        r8 = com.tencent.bugly.crashreport.common.info.b.a(r1);	 Catch:{ Throwable -> 0x018d }
        r6[r3] = r8;	 Catch:{ Throwable -> 0x018d }
        com.tencent.bugly.crashreport.common.info.a.b();	 Catch:{ Throwable -> 0x018d }
        r8 = com.tencent.bugly.crashreport.common.info.a.L();	 Catch:{ Throwable -> 0x018d }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ Throwable -> 0x018d }
        r6[r2] = r8;	 Catch:{ Throwable -> 0x018d }
        r0 = com.tencent.bugly.proguard.z.a(r0, r4, r9, r5, r6);	 Catch:{ Throwable -> 0x018d }
        r0 = (java.lang.String) r0;	 Catch:{ Throwable -> 0x018d }
    L_0x0138:
        if (r0 == 0) goto L_0x018d;
    L_0x013a:
        r10.j = r3;	 Catch:{ Throwable -> 0x018d }
        r2 = com.tencent.bugly.crashreport.common.info.a.b();	 Catch:{ Throwable -> 0x018d }
        r2.n = r0;	 Catch:{ Throwable -> 0x018d }
        r2 = "com.tencent.feedback.eup.jni.NativeExceptionUpload";
        r4 = "checkExtraJni";
        r5 = new java.lang.Class[r3];	 Catch:{ Throwable -> 0x018d }
        r6 = java.lang.String.class;
        r5[r1] = r6;	 Catch:{ Throwable -> 0x018d }
        r6 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x018d }
        r6[r1] = r0;	 Catch:{ Throwable -> 0x018d }
        r0 = com.tencent.bugly.proguard.z.a(r2, r4, r9, r5, r6);	 Catch:{ Throwable -> 0x018d }
        r0 = (java.lang.Boolean) r0;	 Catch:{ Throwable -> 0x018d }
        if (r0 == 0) goto L_0x015e;
    L_0x0158:
        r0 = r0.booleanValue();	 Catch:{ Throwable -> 0x018d }
        l = r0;	 Catch:{ Throwable -> 0x018d }
    L_0x015e:
        r0 = "com.tencent.feedback.eup.jni.NativeExceptionUpload";
        r2 = "enableHandler";
        r4 = new java.lang.Class[r3];	 Catch:{ Throwable -> 0x018d }
        r5 = java.lang.Boolean.TYPE;	 Catch:{ Throwable -> 0x018d }
        r4[r1] = r5;	 Catch:{ Throwable -> 0x018d }
        r5 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x018d }
        r6 = java.lang.Boolean.valueOf(r3);	 Catch:{ Throwable -> 0x018d }
        r5[r1] = r6;	 Catch:{ Throwable -> 0x018d }
        com.tencent.bugly.proguard.z.a(r0, r2, r9, r4, r5);	 Catch:{ Throwable -> 0x018d }
        if (r11 == 0) goto L_0x0176;
    L_0x0175:
        r7 = r3;
    L_0x0176:
        r11 = "com.tencent.feedback.eup.jni.NativeExceptionUpload";
        r0 = "setLogMode";
        r2 = new java.lang.Class[r3];	 Catch:{ Throwable -> 0x018d }
        r4 = java.lang.Integer.TYPE;	 Catch:{ Throwable -> 0x018d }
        r2[r1] = r4;	 Catch:{ Throwable -> 0x018d }
        r3 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x018d }
        r4 = java.lang.Integer.valueOf(r7);	 Catch:{ Throwable -> 0x018d }
        r3[r1] = r4;	 Catch:{ Throwable -> 0x018d }
        com.tencent.bugly.proguard.z.a(r11, r0, r9, r2, r3);	 Catch:{ Throwable -> 0x018d }
        monitor-exit(r10);
        return;
    L_0x018d:
        r10.i = r1;	 Catch:{ all -> 0x0193 }
        r10.h = r1;	 Catch:{ all -> 0x0193 }
        monitor-exit(r10);
        return;
    L_0x0193:
        r11 = move-exception;
        monitor-exit(r10);
        throw r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.a(boolean):void");
    }

    private boolean a(int i, String str) {
        if (!this.i || !m) {
            return false;
        }
        try {
            setNativeInfo(i, str);
            return true;
        } catch (UnsatisfiedLinkError unused) {
            m = false;
            return false;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }

    private static boolean a(String str, boolean z) {
        Throwable th;
        boolean z2;
        try {
            x.a("[Native] Trying to load so: %s", str);
            if (z) {
                System.load(str);
            } else {
                System.loadLibrary(str);
            }
            try {
                x.a("[Native] Successfully loaded SO: %s", str);
                return true;
            } catch (Throwable th2) {
                th = th2;
                z2 = true;
            }
        } catch (Throwable th3) {
            th = th3;
            z2 = false;
            x.d(th.getMessage(), new Object[0]);
            x.d("[Native] Failed to load so: %s", str);
            return z2;
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0020 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0049 */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:13|14) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:19|20|21|22) */
    /* JADX WARNING: Missing block: B:14:?, code skipped:
            com.tencent.bugly.proguard.x.c("[Native] Failed to close native crash report.", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing block: B:20:?, code skipped:
            com.tencent.bugly.proguard.x.c("[Native] Failed to close native crash report.", new java.lang.Object[0]);
            r7.i = false;
            r7.h = false;
     */
    /* JADX WARNING: Missing block: B:22:0x0055, code skipped:
            return;
     */
    private synchronized void b() {
        /*
        r7 = this;
        monitor-enter(r7);
        r0 = r7.j;	 Catch:{ all -> 0x0056 }
        r1 = 0;
        if (r0 != 0) goto L_0x000f;
    L_0x0006:
        r0 = "[Native] Native crash report has already unregistered.";
        r1 = new java.lang.Object[r1];	 Catch:{ all -> 0x0056 }
        com.tencent.bugly.proguard.x.d(r0, r1);	 Catch:{ all -> 0x0056 }
        monitor-exit(r7);
        return;
    L_0x000f:
        r0 = r7.unregist();	 Catch:{ Throwable -> 0x0020 }
        if (r0 == 0) goto L_0x0027;
    L_0x0015:
        r0 = "[Native] Successfully closed native crash report.";
        r2 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x0020 }
        com.tencent.bugly.proguard.x.a(r0, r2);	 Catch:{ Throwable -> 0x0020 }
        r7.j = r1;	 Catch:{ Throwable -> 0x0020 }
        monitor-exit(r7);
        return;
    L_0x0020:
        r0 = "[Native] Failed to close native crash report.";
        r2 = new java.lang.Object[r1];	 Catch:{ all -> 0x0056 }
        com.tencent.bugly.proguard.x.c(r0, r2);	 Catch:{ all -> 0x0056 }
    L_0x0027:
        r0 = "com.tencent.feedback.eup.jni.NativeExceptionUpload";
        r2 = "enableHandler";
        r3 = 0;
        r4 = 1;
        r5 = new java.lang.Class[r4];	 Catch:{ Throwable -> 0x0049 }
        r6 = java.lang.Boolean.TYPE;	 Catch:{ Throwable -> 0x0049 }
        r5[r1] = r6;	 Catch:{ Throwable -> 0x0049 }
        r4 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x0049 }
        r6 = java.lang.Boolean.valueOf(r1);	 Catch:{ Throwable -> 0x0049 }
        r4[r1] = r6;	 Catch:{ Throwable -> 0x0049 }
        com.tencent.bugly.proguard.z.a(r0, r2, r3, r5, r4);	 Catch:{ Throwable -> 0x0049 }
        r7.j = r1;	 Catch:{ Throwable -> 0x0049 }
        r0 = "[Native] Successfully closed native crash report.";
        r2 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x0049 }
        com.tencent.bugly.proguard.x.a(r0, r2);	 Catch:{ Throwable -> 0x0049 }
        monitor-exit(r7);
        return;
    L_0x0049:
        r0 = "[Native] Failed to close native crash report.";
        r2 = new java.lang.Object[r1];	 Catch:{ all -> 0x0056 }
        com.tencent.bugly.proguard.x.c(r0, r2);	 Catch:{ all -> 0x0056 }
        r7.i = r1;	 Catch:{ all -> 0x0056 }
        r7.h = r1;	 Catch:{ all -> 0x0056 }
        monitor-exit(r7);
        return;
    L_0x0056:
        r0 = move-exception;
        monitor-exit(r7);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.b():void");
    }

    private synchronized void b(boolean z) {
        if (z) {
            startNativeMonitor();
        } else {
            b();
        }
    }

    private synchronized void c(boolean z) {
        if (this.k != z) {
            x.a("user change native %b", Boolean.valueOf(z));
            this.k = z;
        }
    }

    public static synchronized NativeCrashHandler getInstance() {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            nativeCrashHandler = a;
        }
        return nativeCrashHandler;
    }

    public static synchronized NativeCrashHandler getInstance(Context context, com.tencent.bugly.crashreport.common.info.a aVar, b bVar, com.tencent.bugly.crashreport.common.strategy.a aVar2, w wVar, boolean z, String str) {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            if (a == null) {
                a = new NativeCrashHandler(context, aVar, bVar, wVar, z, str);
            }
            nativeCrashHandler = a;
        }
        return nativeCrashHandler;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a() {
        long b = z.b() - c.g;
        File file = new File(this.f);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                String str = "tomb_";
                String str2 = ".txt";
                int length = str.length();
                int length2 = listFiles.length;
                int i = 0;
                int i2 = i;
                while (i < length2) {
                    File file2 = listFiles[i];
                    String name = file2.getName();
                    if (name.startsWith(str)) {
                        try {
                            int indexOf = name.indexOf(str2);
                            if (indexOf > 0 && Long.parseLong(name.substring(length, indexOf)) >= b) {
                            }
                        } catch (Throwable unused) {
                            x.e("[Native] Tomb file format error, delete %s", name);
                        }
                        if (file2.delete()) {
                            i2++;
                        }
                    }
                    i++;
                }
                x.c("[Native] Clean tombs %d", Integer.valueOf(i2));
            }
        }
    }

    public boolean appendLogToNative(String str, String str2, String str3) {
        if ((!this.h && !this.i) || !l || str == null || str2 == null || str3 == null) {
            return false;
        }
        try {
            if (this.i) {
                return appendNativeLog(str, str2, str3);
            }
            Boolean bool = (Boolean) z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "appendNativeLog", null, new Class[]{String.class, String.class, String.class}, new Object[]{str, str2, str3});
            return bool != null ? bool.booleanValue() : false;
        } catch (UnsatisfiedLinkError unused) {
            l = false;
            return false;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }

    public native boolean appendNativeLog(String str, String str2, String str3);

    public native boolean appendWholeNativeLog(String str);

    public boolean filterSigabrtSysLog() {
        return a(998, "true");
    }

    public synchronized String getDumpFilePath() {
        return this.f;
    }

    public NativeExceptionHandler getNativeExceptionHandler() {
        return this.e;
    }

    public native String getNativeKeyValueList();

    public native String getNativeLog();

    public synchronized boolean isUserOpened() {
        return this.k;
    }

    public synchronized void onStrategyChanged(StrategyBean strategyBean) {
        if (strategyBean != null) {
            try {
                if (strategyBean.g != this.j) {
                    x.d("server native changed to %b", Boolean.valueOf(strategyBean.g));
                }
            } finally {
            }
        }
        boolean z = com.tencent.bugly.crashreport.common.strategy.a.a().c().g && this.k;
        if (z != this.j) {
            x.a("native changed to %b", Boolean.valueOf(z));
            b(z);
        }
    }

    public boolean putKeyValueToNative(String str, String str2) {
        if ((!this.h && !this.i) || !l || str == null || str2 == null) {
            return false;
        }
        try {
            if (this.i) {
                return putNativeKeyValue(str, str2);
            }
            Boolean bool = (Boolean) z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "putNativeKeyValue", null, new Class[]{String.class, String.class}, new Object[]{str, str2});
            return bool != null ? bool.booleanValue() : false;
        } catch (UnsatisfiedLinkError unused) {
            l = false;
            return false;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }

    public native boolean putNativeKeyValue(String str, String str2);

    public native String regist(String str, boolean z, int i);

    public native String removeNativeKeyValue(String str);

    public synchronized void setDumpFilePath(String str) {
        this.f = str;
    }

    public boolean setNativeAppChannel(String str) {
        return a(12, str);
    }

    public boolean setNativeAppPackage(String str) {
        return a(13, str);
    }

    public boolean setNativeAppVersion(String str) {
        return a(10, str);
    }

    public native void setNativeInfo(int i, String str);

    public boolean setNativeIsAppForeground(boolean z) {
        return a(14, z ? "true" : Bugly.SDK_IS_DEV);
    }

    public boolean setNativeLaunchTime(long j) {
        try {
            return a(15, String.valueOf(j));
        } catch (NumberFormatException e) {
            if (!x.a(e)) {
                e.printStackTrace();
            }
            return false;
        }
    }

    public boolean setNativeUserId(String str) {
        return a(11, str);
    }

    public synchronized void setUserOpened(boolean z) {
        c(z);
        z = isUserOpened();
        com.tencent.bugly.crashreport.common.strategy.a a = com.tencent.bugly.crashreport.common.strategy.a.a();
        if (a != null) {
            z = z && a.c().g;
        }
        if (z != this.j) {
            x.a("native changed to %b", Boolean.valueOf(z));
            b(z);
        }
    }

    public synchronized void startNativeMonitor() {
        if (!this.i) {
            if (!this.h) {
                String str = "Bugly";
                boolean a = z.a(this.c.m) ^ 1;
                String str2 = this.c.m;
                if (a) {
                    str = str2;
                } else {
                    this.c.getClass();
                }
                this.i = a(str, a);
                if (this.i || this.h) {
                    a(this.g);
                    this.d.a(new Runnable() {
                        public final void run() {
                            if (z.a(NativeCrashHandler.this.b, "native_record_lock", 10000)) {
                                try {
                                    NativeCrashHandler.this.setNativeAppVersion(NativeCrashHandler.this.c.j);
                                    NativeCrashHandler.this.setNativeAppChannel(NativeCrashHandler.this.c.l);
                                    NativeCrashHandler.this.setNativeAppPackage(NativeCrashHandler.this.c.c);
                                    NativeCrashHandler.this.setNativeUserId(NativeCrashHandler.this.c.g());
                                    NativeCrashHandler.this.setNativeIsAppForeground(NativeCrashHandler.this.c.a());
                                    NativeCrashHandler.this.setNativeLaunchTime(NativeCrashHandler.this.c.a);
                                } catch (Throwable th) {
                                    if (!x.a(th)) {
                                        th.printStackTrace();
                                    }
                                }
                                CrashDetailBean a = b.a(NativeCrashHandler.this.b, NativeCrashHandler.this.f, NativeCrashHandler.this.e);
                                if (a != null) {
                                    x.a("[Native] Get crash from native record.", new Object[0]);
                                    if (!NativeCrashHandler.this.n.a(a)) {
                                        NativeCrashHandler.this.n.a(a, 3000, false);
                                    }
                                    b.a(false, NativeCrashHandler.this.f);
                                }
                                NativeCrashHandler.this.a();
                                z.b(NativeCrashHandler.this.b, "native_record_lock");
                                return;
                            }
                            x.a("[Native] Failed to lock file for handling native crash record.", new Object[0]);
                        }
                    });
                    return;
                }
                return;
            }
        }
        a(this.g);
    }

    public native void testCrash();

    public void testNativeCrash() {
        if (this.i) {
            testCrash();
        } else {
            x.d("[Native] Bugly SO file has not been load.", new Object[0]);
        }
    }

    public native String unregist();
}
