package com.tencent.bugly.proguard;

import android.content.Context;
import java.io.File;
import java.text.SimpleDateFormat;

/* compiled from: BUGLY */
public final class y {
    public static boolean a = true;
    private static SimpleDateFormat b = null;
    private static int c = 5120;
    private static StringBuilder d;
    private static StringBuilder e;
    private static boolean f;
    private static a g;
    private static String h;
    private static String i;
    private static Context j;
    private static String k;
    private static boolean l;
    private static int m;
    private static final Object n = new Object();

    /* compiled from: BUGLY */
    public static class a {
        private boolean a;
        private File b;
        private String c;
        private long d;
        private long e = 30720;

        public a(String str) {
            if (str != null && !str.equals("")) {
                this.c = str;
                this.a = a();
            }
        }

        private boolean a() {
            try {
                this.b = new File(this.c);
                if (!this.b.exists() || this.b.delete()) {
                    if (!this.b.createNewFile()) {
                        this.a = false;
                        return false;
                    }
                    return true;
                }
                this.a = false;
                return false;
            } catch (Throwable unused) {
                this.a = false;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:20:0x0035 A:{SYNTHETIC, Splitter:B:20:0x0035} */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0031 */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x003b A:{SYNTHETIC, Splitter:B:25:0x003b} */
        /* JADX WARNING: Failed to process nested try/catch */
        public final boolean a(java.lang.String r12) {
            /*
            r11 = this;
            r0 = r11.a;
            r1 = 0;
            if (r0 != 0) goto L_0x0006;
        L_0x0005:
            return r1;
        L_0x0006:
            r0 = 0;
            r2 = new java.io.FileOutputStream;	 Catch:{ Throwable -> 0x0031 }
            r3 = r11.b;	 Catch:{ Throwable -> 0x0031 }
            r4 = 1;
            r2.<init>(r3, r4);	 Catch:{ Throwable -> 0x0031 }
            r0 = "UTF-8";
            r12 = r12.getBytes(r0);	 Catch:{ Throwable -> 0x002c, all -> 0x002a }
            r2.write(r12);	 Catch:{ Throwable -> 0x002c, all -> 0x002a }
            r2.flush();	 Catch:{ Throwable -> 0x002c, all -> 0x002a }
            r2.close();	 Catch:{ Throwable -> 0x002c, all -> 0x002a }
            r5 = r11.d;	 Catch:{ Throwable -> 0x002c, all -> 0x002a }
            r12 = r12.length;	 Catch:{ Throwable -> 0x002c, all -> 0x002a }
            r7 = (long) r12;	 Catch:{ Throwable -> 0x002c, all -> 0x002a }
            r9 = r5 + r7;
            r11.d = r9;	 Catch:{ Throwable -> 0x002c, all -> 0x002a }
            r2.close();	 Catch:{ IOException -> 0x0029 }
        L_0x0029:
            return r4;
        L_0x002a:
            r12 = move-exception;
            goto L_0x0039;
        L_0x002c:
            r0 = r2;
            goto L_0x0031;
        L_0x002e:
            r12 = move-exception;
            r2 = r0;
            goto L_0x0039;
        L_0x0031:
            r11.a = r1;	 Catch:{ all -> 0x002e }
            if (r0 == 0) goto L_0x0038;
        L_0x0035:
            r0.close();	 Catch:{ IOException -> 0x0038 }
        L_0x0038:
            return r1;
        L_0x0039:
            if (r2 == 0) goto L_0x003e;
        L_0x003b:
            r2.close();	 Catch:{ IOException -> 0x003e }
        L_0x003e:
            throw r12;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.y$a.a(java.lang.String):boolean");
        }
    }

    static {
        try {
            b = new SimpleDateFormat("MM-dd HH:mm:ss");
        } catch (Throwable unused) {
        }
    }

    public static void a(int i) {
        synchronized (n) {
            c = i;
            if (i < 0) {
                c = 0;
            } else if (i > 10240) {
                c = 10240;
            }
        }
    }

    /* JADX WARNING: Missing block: B:17:0x006b, code skipped:
            return;
     */
    public static synchronized void a(android.content.Context r3) {
        /*
        r0 = com.tencent.bugly.proguard.y.class;
        monitor-enter(r0);
        r1 = l;	 Catch:{ all -> 0x006c }
        if (r1 != 0) goto L_0x006a;
    L_0x0007:
        if (r3 == 0) goto L_0x006a;
    L_0x0009:
        r1 = a;	 Catch:{ all -> 0x006c }
        if (r1 != 0) goto L_0x000e;
    L_0x000d:
        goto L_0x006a;
    L_0x000e:
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0065 }
        r2 = 0;
        r1.<init>(r2);	 Catch:{ Throwable -> 0x0065 }
        e = r1;	 Catch:{ Throwable -> 0x0065 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0065 }
        r1.<init>(r2);	 Catch:{ Throwable -> 0x0065 }
        d = r1;	 Catch:{ Throwable -> 0x0065 }
        j = r3;	 Catch:{ Throwable -> 0x0065 }
        r3 = com.tencent.bugly.crashreport.common.info.a.a(r3);	 Catch:{ Throwable -> 0x0065 }
        r1 = r3.d;	 Catch:{ Throwable -> 0x0065 }
        h = r1;	 Catch:{ Throwable -> 0x0065 }
        r3.getClass();	 Catch:{ Throwable -> 0x0065 }
        r3 = "";
        i = r3;	 Catch:{ Throwable -> 0x0065 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0065 }
        r3.<init>();	 Catch:{ Throwable -> 0x0065 }
        r1 = j;	 Catch:{ Throwable -> 0x0065 }
        r1 = r1.getFilesDir();	 Catch:{ Throwable -> 0x0065 }
        r1 = r1.getPath();	 Catch:{ Throwable -> 0x0065 }
        r3.append(r1);	 Catch:{ Throwable -> 0x0065 }
        r1 = "/buglylog_";
        r3.append(r1);	 Catch:{ Throwable -> 0x0065 }
        r1 = h;	 Catch:{ Throwable -> 0x0065 }
        r3.append(r1);	 Catch:{ Throwable -> 0x0065 }
        r1 = "_";
        r3.append(r1);	 Catch:{ Throwable -> 0x0065 }
        r1 = i;	 Catch:{ Throwable -> 0x0065 }
        r3.append(r1);	 Catch:{ Throwable -> 0x0065 }
        r1 = ".txt";
        r3.append(r1);	 Catch:{ Throwable -> 0x0065 }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x0065 }
        k = r3;	 Catch:{ Throwable -> 0x0065 }
        r3 = android.os.Process.myPid();	 Catch:{ Throwable -> 0x0065 }
        m = r3;	 Catch:{ Throwable -> 0x0065 }
    L_0x0065:
        r3 = 1;
        l = r3;	 Catch:{ all -> 0x006c }
        monitor-exit(r0);
        return;
    L_0x006a:
        monitor-exit(r0);
        return;
    L_0x006c:
        r3 = move-exception;
        monitor-exit(r0);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.y.a(android.content.Context):void");
    }

    /* JADX WARNING: Missing block: B:39:0x00b1, code skipped:
            return;
     */
    public static synchronized void a(java.lang.String r6, java.lang.String r7, java.lang.String r8) {
        /*
        r0 = com.tencent.bugly.proguard.y.class;
        monitor-enter(r0);
        r1 = l;	 Catch:{ all -> 0x00b2 }
        if (r1 == 0) goto L_0x00b0;
    L_0x0007:
        r1 = a;	 Catch:{ all -> 0x00b2 }
        if (r1 != 0) goto L_0x000d;
    L_0x000b:
        goto L_0x00b0;
    L_0x000d:
        b(r6, r7, r8);	 Catch:{ all -> 0x00b2 }
        r1 = android.os.Process.myTid();	 Catch:{ all -> 0x00b2 }
        r1 = (long) r1;	 Catch:{ all -> 0x00b2 }
        r3 = d;	 Catch:{ all -> 0x00b2 }
        r4 = 0;
        r3.setLength(r4);	 Catch:{ all -> 0x00b2 }
        r3 = r8.length();	 Catch:{ all -> 0x00b2 }
        r4 = 1;
        r5 = 30720; // 0x7800 float:4.3048E-41 double:1.51777E-319;
        if (r3 <= r5) goto L_0x0032;
    L_0x0024:
        r3 = r8.length();	 Catch:{ all -> 0x00b2 }
        r3 = r3 - r5;
        r5 = r8.length();	 Catch:{ all -> 0x00b2 }
        r5 = r5 - r4;
        r8 = r8.substring(r3, r5);	 Catch:{ all -> 0x00b2 }
    L_0x0032:
        r3 = new java.util.Date;	 Catch:{ all -> 0x00b2 }
        r3.<init>();	 Catch:{ all -> 0x00b2 }
        r5 = b;	 Catch:{ all -> 0x00b2 }
        if (r5 == 0) goto L_0x0042;
    L_0x003b:
        r5 = b;	 Catch:{ all -> 0x00b2 }
        r3 = r5.format(r3);	 Catch:{ all -> 0x00b2 }
        goto L_0x0046;
    L_0x0042:
        r3 = r3.toString();	 Catch:{ all -> 0x00b2 }
    L_0x0046:
        r5 = d;	 Catch:{ all -> 0x00b2 }
        r5.append(r3);	 Catch:{ all -> 0x00b2 }
        r3 = " ";
        r5.append(r3);	 Catch:{ all -> 0x00b2 }
        r3 = m;	 Catch:{ all -> 0x00b2 }
        r5.append(r3);	 Catch:{ all -> 0x00b2 }
        r3 = " ";
        r5.append(r3);	 Catch:{ all -> 0x00b2 }
        r5.append(r1);	 Catch:{ all -> 0x00b2 }
        r1 = " ";
        r5.append(r1);	 Catch:{ all -> 0x00b2 }
        r5.append(r6);	 Catch:{ all -> 0x00b2 }
        r6 = " ";
        r5.append(r6);	 Catch:{ all -> 0x00b2 }
        r5.append(r7);	 Catch:{ all -> 0x00b2 }
        r6 = ": ";
        r5.append(r6);	 Catch:{ all -> 0x00b2 }
        r5.append(r8);	 Catch:{ all -> 0x00b2 }
        r6 = "\u0001\r\n";
        r5.append(r6);	 Catch:{ all -> 0x00b2 }
        r6 = d;	 Catch:{ all -> 0x00b2 }
        r6 = r6.toString();	 Catch:{ all -> 0x00b2 }
        r7 = n;	 Catch:{ all -> 0x00b2 }
        monitor-enter(r7);	 Catch:{ all -> 0x00b2 }
        r8 = e;	 Catch:{ all -> 0x00ad }
        r8.append(r6);	 Catch:{ all -> 0x00ad }
        r8 = e;	 Catch:{ all -> 0x00ad }
        r8 = r8.length();	 Catch:{ all -> 0x00ad }
        r1 = c;	 Catch:{ all -> 0x00ad }
        if (r8 > r1) goto L_0x0095;
    L_0x0092:
        monitor-exit(r7);	 Catch:{ all -> 0x00ad }
        monitor-exit(r0);
        return;
    L_0x0095:
        r8 = f;	 Catch:{ all -> 0x00ad }
        if (r8 == 0) goto L_0x009c;
    L_0x0099:
        monitor-exit(r7);	 Catch:{ all -> 0x00ad }
        monitor-exit(r0);
        return;
    L_0x009c:
        f = r4;	 Catch:{ all -> 0x00ad }
        r8 = com.tencent.bugly.proguard.w.a();	 Catch:{ all -> 0x00ad }
        r1 = new com.tencent.bugly.proguard.y$1;	 Catch:{ all -> 0x00ad }
        r1.<init>(r6);	 Catch:{ all -> 0x00ad }
        r8.a(r1);	 Catch:{ all -> 0x00ad }
        monitor-exit(r7);	 Catch:{ all -> 0x00ad }
        monitor-exit(r0);
        return;
    L_0x00ad:
        r6 = move-exception;
        monitor-exit(r7);	 Catch:{ all -> 0x00b2 }
        throw r6;	 Catch:{ all -> 0x00b2 }
    L_0x00b0:
        monitor-exit(r0);
        return;
    L_0x00b2:
        r6 = move-exception;
        monitor-exit(r0);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.y.a(java.lang.String, java.lang.String, java.lang.String):void");
    }

    public static void a(String str, String str2, Throwable th) {
        if (th != null) {
            String message = th.getMessage();
            if (message == null) {
                message = "";
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(message);
            stringBuilder.append(10);
            stringBuilder.append(z.b(th));
            a(str, str2, stringBuilder.toString());
        }
    }

    public static byte[] a() {
        if (!a) {
            return null;
        }
        synchronized (n) {
            try {
                File a = (g == null || !g.a) ? null : g.b;
                if (e.length() == 0 && a == null) {
                    return null;
                }
                byte[] a2 = z.a(a, e.toString(), "BuglyLog.txt");
                return a2;
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    private static boolean b(String str, String str2, String str3) {
        try {
            com.tencent.bugly.crashreport.common.info.a b = com.tencent.bugly.crashreport.common.info.a.b();
            if (!(b == null || b.D == null)) {
                return b.D.appendLogToNative(str, str2, str3);
            }
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
        }
        return false;
    }
}
