package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import android.util.Base64;
import com.tencent.bugly.b;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: BUGLY */
public final class u {
    private static u b;
    public boolean a = true;
    private final p c;
    private final Context d;
    private Map<Integer, Long> e = new HashMap();
    private long f;
    private long g;
    private LinkedBlockingQueue<Runnable> h = new LinkedBlockingQueue();
    private LinkedBlockingQueue<Runnable> i = new LinkedBlockingQueue();
    private final Object j = new Object();
    private String k = null;
    private byte[] l = null;
    private long m = 0;
    private byte[] n = null;
    private long o = 0;
    private String p = null;
    private long q = 0;
    private final Object r = new Object();
    private boolean s = false;
    private final Object t = new Object();
    private int u = 0;

    /* compiled from: BUGLY */
    class a implements Runnable {
        private final Context a;
        private final Runnable b;
        private final long c;

        public a(Context context) {
            this.a = context;
            this.b = null;
            this.c = 0;
        }

        public a(Context context, Runnable runnable, long j) {
            this.a = context;
            this.b = runnable;
            this.c = j;
        }

        public final void run() {
            if (z.a(this.a, "security_info", (long) StatisticConfig.MIN_UPLOAD_INTERVAL)) {
                if (!u.this.e()) {
                    x.d("[UploadManager] Failed to load security info from database", new Object[0]);
                    u.this.b(false);
                }
                if (u.this.p != null) {
                    if (u.this.b()) {
                        x.c("[UploadManager] Sucessfully got session ID, try to execute upload tasks now (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                        if (this.b != null) {
                            u.this.a(this.b, this.c);
                        }
                        u.this.c(0);
                        z.b(this.a, "security_info");
                        synchronized (u.this.t) {
                            u.this.s = false;
                        }
                        return;
                    }
                    x.a("[UploadManager] Session ID is expired, drop it.", new Object[0]);
                    u.this.b(true);
                }
                byte[] a = z.a(128);
                if (a == null || (a.length << 3) != 128) {
                    x.d("[UploadManager] Failed to create AES key (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                    u.this.b(false);
                    z.b(this.a, "security_info");
                    synchronized (u.this.t) {
                        u.this.s = false;
                    }
                    return;
                }
                u.this.n = a;
                x.c("[UploadManager] Execute one upload task for requesting session ID (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                if (this.b != null) {
                    u.this.a(this.b, this.c);
                    return;
                } else {
                    u.this.c(1);
                    return;
                }
            }
            x.c("[UploadManager] Sleep %d try to lock security file again (pid=%d | tid=%d)", Integer.valueOf(5000), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            z.b(5000);
            if (z.a((Runnable) this, "BUGLY_ASYNC_UPLOAD") == null) {
                x.d("[UploadManager] Failed to start a thread to execute task of initializing security context, try to post it into thread pool.", new Object[0]);
                w a2 = w.a();
                if (a2 != null) {
                    a2.a(this);
                } else {
                    x.e("[UploadManager] Asynchronous thread pool is unavailable now, try next time.", new Object[0]);
                }
            }
        }
    }

    private u(Context context) {
        this.d = context;
        this.c = p.a();
        try {
            Class.forName("android.util.Base64");
        } catch (ClassNotFoundException unused) {
            x.a("[UploadManager] Error: Can not find Base64 class, will not use stronger security way to upload", new Object[0]);
            this.a = false;
        }
        if (this.a) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDP9x32s5pPtZBXzJBz2GWM/sbTvVO2+RvW0PH01IdaBxc/");
            stringBuilder.append("fB6fbHZocC9T3nl1+J5eAFjIRVuV8vHDky7Qo82Mnh0PVvcZIEQvMMVKU8dsMQopxgsOs2gkSHJwgWdinKNS8CmWobo6pFwPUW11lMv714jAUZRq2GBOqiO2vQI6iwIDAQAB");
            this.k = stringBuilder.toString();
        }
    }

    public static synchronized u a() {
        u uVar;
        synchronized (u.class) {
            uVar = b;
        }
        return uVar;
    }

    public static synchronized u a(Context context) {
        u uVar;
        synchronized (u.class) {
            if (b == null) {
                b = new u(context);
            }
            uVar = b;
        }
        return uVar;
    }

    private void a(Runnable runnable, long j) {
        if (runnable == null) {
            x.d("[UploadManager] Upload task should not be null", new Object[0]);
            return;
        }
        x.c("[UploadManager] Execute synchronized upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        Thread a = z.a(runnable, "BUGLY_SYNC_UPLOAD");
        if (a == null) {
            x.e("[UploadManager] Failed to start a thread to execute synchronized upload task, add it to queue.", new Object[0]);
            a(runnable, true);
            return;
        }
        try {
            a.join(j);
        } catch (Throwable th) {
            x.e("[UploadManager] Failed to join upload synchronized task with message: %s. Add it to queue.", th.getMessage());
            a(runnable, true);
            c(0);
        }
    }

    /* JADX WARNING: Missing block: B:25:0x008f, code skipped:
            com.tencent.bugly.proguard.x.c("[UploadManager] Initialize security context now (pid=%d | tid=%d)", java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
     */
    /* JADX WARNING: Missing block: B:26:0x00aa, code skipped:
            if (r15 == false) goto L_0x00bc;
     */
    /* JADX WARNING: Missing block: B:27:0x00ac, code skipped:
            r3 = r7.d;
     */
    /* JADX WARNING: Missing block: B:29:0x00bc, code skipped:
            a(r4, r14);
            r1 = new com.tencent.bugly.proguard.u.a(r7, r7.d);
            com.tencent.bugly.proguard.x.a("[UploadManager] Create and start a new thread to execute a task of initializing security context: %s", "BUGLY_ASYNC_UPLOAD");
     */
    /* JADX WARNING: Missing block: B:30:0x00d7, code skipped:
            if (com.tencent.bugly.proguard.z.a(r1, "BUGLY_ASYNC_UPLOAD") != null) goto L_0x00fc;
     */
    /* JADX WARNING: Missing block: B:31:0x00d9, code skipped:
            com.tencent.bugly.proguard.x.d("[UploadManager] Failed to start a thread to execute task of initializing security context, try to post it into thread pool.", new java.lang.Object[0]);
            r3 = com.tencent.bugly.proguard.w.a();
     */
    /* JADX WARNING: Missing block: B:32:0x00e4, code skipped:
            if (r3 == null) goto L_0x00ea;
     */
    /* JADX WARNING: Missing block: B:33:0x00e6, code skipped:
            r3.a(r1);
     */
    /* JADX WARNING: Missing block: B:34:0x00e9, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:35:0x00ea, code skipped:
            com.tencent.bugly.proguard.x.e("[UploadManager] Asynchronous thread pool is unavailable now, try next time.", new java.lang.Object[0]);
            r1 = r7.t;
     */
    /* JADX WARNING: Missing block: B:36:0x00f3, code skipped:
            monitor-enter(r1);
     */
    /* JADX WARNING: Missing block: B:38:?, code skipped:
            r7.s = false;
     */
    /* JADX WARNING: Missing block: B:39:0x00f6, code skipped:
            monitor-exit(r1);
     */
    /* JADX WARNING: Missing block: B:40:0x00f7, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:41:0x00f8, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:42:0x00f9, code skipped:
            r2 = r0;
     */
    /* JADX WARNING: Missing block: B:43:0x00fc, code skipped:
            return;
     */
    private void a(java.lang.Runnable r13, boolean r14, boolean r15, long r16) {
        /*
        r12 = this;
        r7 = r12;
        r4 = r13;
        r2 = 0;
        if (r4 != 0) goto L_0x000c;
    L_0x0005:
        r3 = "[UploadManager] Upload task should not be null";
        r5 = new java.lang.Object[r2];
        com.tencent.bugly.proguard.x.d(r3, r5);
    L_0x000c:
        r3 = "[UploadManager] Add upload task (pid=%d | tid=%d)";
        r5 = 2;
        r6 = new java.lang.Object[r5];
        r8 = android.os.Process.myPid();
        r8 = java.lang.Integer.valueOf(r8);
        r6[r2] = r8;
        r8 = android.os.Process.myTid();
        r8 = java.lang.Integer.valueOf(r8);
        r9 = 1;
        r6[r9] = r8;
        com.tencent.bugly.proguard.x.c(r3, r6);
        r3 = r7.p;
        if (r3 == 0) goto L_0x007e;
    L_0x002d:
        r3 = r7.b();
        if (r3 == 0) goto L_0x005d;
    L_0x0033:
        r3 = "[UploadManager] Sucessfully got session ID, try to execute upload task now (pid=%d | tid=%d)";
        r5 = new java.lang.Object[r5];
        r6 = android.os.Process.myPid();
        r6 = java.lang.Integer.valueOf(r6);
        r5[r2] = r6;
        r6 = android.os.Process.myTid();
        r6 = java.lang.Integer.valueOf(r6);
        r5[r9] = r6;
        com.tencent.bugly.proguard.x.c(r3, r5);
        if (r15 == 0) goto L_0x0056;
    L_0x0050:
        r10 = r16;
        r7.a(r4, r10);
        return;
    L_0x0056:
        r7.a(r4, r14);
        r7.c(r2);
        return;
    L_0x005d:
        r10 = r16;
        r3 = "[UploadManager] Session ID is expired, drop it (pid=%d | tid=%d)";
        r6 = new java.lang.Object[r5];
        r8 = android.os.Process.myPid();
        r8 = java.lang.Integer.valueOf(r8);
        r6[r2] = r8;
        r8 = android.os.Process.myTid();
        r8 = java.lang.Integer.valueOf(r8);
        r6[r9] = r8;
        com.tencent.bugly.proguard.x.a(r3, r6);
        r7.b(r2);
        goto L_0x0080;
    L_0x007e:
        r10 = r16;
    L_0x0080:
        r3 = r7.t;
        monitor-enter(r3);
        r6 = r7.s;	 Catch:{ all -> 0x00fd }
        if (r6 == 0) goto L_0x008c;
    L_0x0087:
        r7.a(r4, r14);	 Catch:{ all -> 0x00fd }
        monitor-exit(r3);	 Catch:{ all -> 0x00fd }
        return;
    L_0x008c:
        r7.s = r9;	 Catch:{ all -> 0x00fd }
        monitor-exit(r3);	 Catch:{ all -> 0x00fd }
        r3 = "[UploadManager] Initialize security context now (pid=%d | tid=%d)";
        r5 = new java.lang.Object[r5];
        r6 = android.os.Process.myPid();
        r6 = java.lang.Integer.valueOf(r6);
        r5[r2] = r6;
        r6 = android.os.Process.myTid();
        r6 = java.lang.Integer.valueOf(r6);
        r5[r9] = r6;
        com.tencent.bugly.proguard.x.c(r3, r5);
        if (r15 == 0) goto L_0x00bc;
    L_0x00ac:
        r8 = new com.tencent.bugly.proguard.u$a;
        r3 = r7.d;
        r1 = r8;
        r2 = r7;
        r5 = r10;
        r1.<init>(r3, r4, r5);
        r1 = 0;
        r7.a(r8, r1);
        return;
    L_0x00bc:
        r7.a(r4, r14);
        r1 = new com.tencent.bugly.proguard.u$a;
        r3 = r7.d;
        r1.<init>(r3);
        r3 = "[UploadManager] Create and start a new thread to execute a task of initializing security context: %s";
        r4 = new java.lang.Object[r9];
        r5 = "BUGLY_ASYNC_UPLOAD";
        r4[r2] = r5;
        com.tencent.bugly.proguard.x.a(r3, r4);
        r3 = "BUGLY_ASYNC_UPLOAD";
        r3 = com.tencent.bugly.proguard.z.a(r1, r3);
        if (r3 != 0) goto L_0x00fc;
    L_0x00d9:
        r3 = "[UploadManager] Failed to start a thread to execute task of initializing security context, try to post it into thread pool.";
        r4 = new java.lang.Object[r2];
        com.tencent.bugly.proguard.x.d(r3, r4);
        r3 = com.tencent.bugly.proguard.w.a();
        if (r3 == 0) goto L_0x00ea;
    L_0x00e6:
        r3.a(r1);
        return;
    L_0x00ea:
        r1 = "[UploadManager] Asynchronous thread pool is unavailable now, try next time.";
        r3 = new java.lang.Object[r2];
        com.tencent.bugly.proguard.x.e(r1, r3);
        r1 = r7.t;
        monitor-enter(r1);
        r7.s = r2;	 Catch:{ all -> 0x00f8 }
        monitor-exit(r1);	 Catch:{ all -> 0x00f8 }
        return;
    L_0x00f8:
        r0 = move-exception;
        r2 = r0;
        monitor-exit(r1);
        throw r2;
    L_0x00fc:
        return;
    L_0x00fd:
        r0 = move-exception;
        r1 = r0;
        monitor-exit(r3);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.u.a(java.lang.Runnable, boolean, boolean, long):void");
    }

    private boolean a(Runnable runnable, boolean z) {
        if (runnable == null) {
            x.a("[UploadManager] Upload task should not be null", new Object[0]);
            return false;
        }
        try {
            x.c("[UploadManager] Add upload task to queue (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            synchronized (this.j) {
                if (z) {
                    this.h.put(runnable);
                } else {
                    this.i.put(runnable);
                }
            }
            return true;
        } catch (Throwable th) {
            x.e("[UploadManager] Failed to add upload task to queue: %s", th.getMessage());
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x006c A:{Catch:{ Throwable -> 0x007f }} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0093 A:{Catch:{ Throwable -> 0x007f }} */
    /* JADX WARNING: Missing block: B:46:0x00b9, code skipped:
            if (r5 <= 0) goto L_0x00dc;
     */
    /* JADX WARNING: Missing block: B:47:0x00bb, code skipped:
            com.tencent.bugly.proguard.x.c("[UploadManager] Execute urgent upload tasks of queue which has %d tasks (pid=%d | tid=%d)", java.lang.Integer.valueOf(r5), java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
     */
    /* JADX WARNING: Missing block: B:48:0x00dc, code skipped:
            r7 = 0;
     */
    /* JADX WARNING: Missing block: B:49:0x00dd, code skipped:
            if (r7 >= r5) goto L_0x012b;
     */
    /* JADX WARNING: Missing block: B:50:0x00df, code skipped:
            r8 = (java.lang.Runnable) r2.poll();
     */
    /* JADX WARNING: Missing block: B:51:0x00e5, code skipped:
            if (r8 == null) goto L_0x012b;
     */
    /* JADX WARNING: Missing block: B:52:0x00e7, code skipped:
            r10 = r13.j;
     */
    /* JADX WARNING: Missing block: B:53:0x00e9, code skipped:
            monitor-enter(r10);
     */
    /* JADX WARNING: Missing block: B:56:0x00ec, code skipped:
            if (r13.u < 2) goto L_0x00f5;
     */
    /* JADX WARNING: Missing block: B:57:0x00ee, code skipped:
            if (r1 == null) goto L_0x00f5;
     */
    /* JADX WARNING: Missing block: B:58:0x00f0, code skipped:
            r1.a(r8);
     */
    /* JADX WARNING: Missing block: B:59:0x00f3, code skipped:
            monitor-exit(r10);
     */
    /* JADX WARNING: Missing block: B:60:0x00f5, code skipped:
            monitor-exit(r10);
     */
    /* JADX WARNING: Missing block: B:61:0x00f6, code skipped:
            com.tencent.bugly.proguard.x.a("[UploadManager] Create and start a new thread to execute a upload task: %s", "BUGLY_ASYNC_UPLOAD");
     */
    /* JADX WARNING: Missing block: B:62:0x010c, code skipped:
            if (com.tencent.bugly.proguard.z.a(new com.tencent.bugly.proguard.u.AnonymousClass1(r13), "BUGLY_ASYNC_UPLOAD") == null) goto L_0x011b;
     */
    /* JADX WARNING: Missing block: B:63:0x010e, code skipped:
            r8 = r13.j;
     */
    /* JADX WARNING: Missing block: B:64:0x0110, code skipped:
            monitor-enter(r8);
     */
    /* JADX WARNING: Missing block: B:66:?, code skipped:
            r13.u++;
     */
    /* JADX WARNING: Missing block: B:67:0x0116, code skipped:
            monitor-exit(r8);
     */
    /* JADX WARNING: Missing block: B:71:0x011b, code skipped:
            com.tencent.bugly.proguard.x.d("[UploadManager] Failed to start a thread to execute asynchronous upload task, will try again next time.", new java.lang.Object[0]);
            a(r8, true);
     */
    /* JADX WARNING: Missing block: B:72:0x0125, code skipped:
            r7 = r7 + 1;
     */
    /* JADX WARNING: Missing block: B:76:0x012b, code skipped:
            if (r14 <= 0) goto L_0x014e;
     */
    /* JADX WARNING: Missing block: B:77:0x012d, code skipped:
            com.tencent.bugly.proguard.x.c("[UploadManager] Execute upload tasks of queue which has %d tasks (pid=%d | tid=%d)", java.lang.Integer.valueOf(r14), java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
     */
    /* JADX WARNING: Missing block: B:78:0x014e, code skipped:
            if (r1 == null) goto L_0x0158;
     */
    /* JADX WARNING: Missing block: B:79:0x0150, code skipped:
            r1.a(new com.tencent.bugly.proguard.u.AnonymousClass2(r13));
     */
    /* JADX WARNING: Missing block: B:80:0x0158, code skipped:
            return;
     */
    private void c(int r14) {
        /*
        r13 = this;
        r0 = 0;
        if (r14 >= 0) goto L_0x000b;
    L_0x0003:
        r14 = "[UploadManager] Number of task to execute should >= 0";
        r0 = new java.lang.Object[r0];
        com.tencent.bugly.proguard.x.a(r14, r0);
        return;
    L_0x000b:
        r1 = com.tencent.bugly.proguard.w.a();
        r2 = new java.util.concurrent.LinkedBlockingQueue;
        r2.<init>();
        r3 = new java.util.concurrent.LinkedBlockingQueue;
        r3.<init>();
        r4 = r13.j;
        monitor-enter(r4);
        r5 = "[UploadManager] Try to poll all upload task need and put them into temp queue (pid=%d | tid=%d)";
        r6 = 2;
        r7 = new java.lang.Object[r6];	 Catch:{ all -> 0x0159 }
        r8 = android.os.Process.myPid();	 Catch:{ all -> 0x0159 }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ all -> 0x0159 }
        r7[r0] = r8;	 Catch:{ all -> 0x0159 }
        r8 = android.os.Process.myTid();	 Catch:{ all -> 0x0159 }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ all -> 0x0159 }
        r9 = 1;
        r7[r9] = r8;	 Catch:{ all -> 0x0159 }
        com.tencent.bugly.proguard.x.c(r5, r7);	 Catch:{ all -> 0x0159 }
        r5 = r13.h;	 Catch:{ all -> 0x0159 }
        r5 = r5.size();	 Catch:{ all -> 0x0159 }
        r7 = r13.i;	 Catch:{ all -> 0x0159 }
        r7 = r7.size();	 Catch:{ all -> 0x0159 }
        if (r5 != 0) goto L_0x0052;
    L_0x0047:
        if (r7 != 0) goto L_0x0052;
    L_0x0049:
        r14 = "[UploadManager] There is no upload task in queue.";
        r0 = new java.lang.Object[r0];	 Catch:{ all -> 0x0159 }
        com.tencent.bugly.proguard.x.c(r14, r0);	 Catch:{ all -> 0x0159 }
        monitor-exit(r4);	 Catch:{ all -> 0x0159 }
        return;
    L_0x0052:
        if (r14 == 0) goto L_0x005f;
    L_0x0054:
        if (r14 >= r5) goto L_0x0059;
    L_0x0056:
        r5 = r14;
        r14 = r0;
        goto L_0x0060;
    L_0x0059:
        r8 = r5 + r7;
        if (r14 >= r8) goto L_0x005f;
    L_0x005d:
        r14 = r14 - r5;
        goto L_0x0060;
    L_0x005f:
        r14 = r7;
    L_0x0060:
        if (r1 == 0) goto L_0x0068;
    L_0x0062:
        r7 = r1.c();	 Catch:{ all -> 0x0159 }
        if (r7 != 0) goto L_0x0069;
    L_0x0068:
        r14 = r0;
    L_0x0069:
        r7 = r0;
    L_0x006a:
        if (r7 >= r5) goto L_0x0090;
    L_0x006c:
        r8 = r13.h;	 Catch:{ all -> 0x0159 }
        r8 = r8.peek();	 Catch:{ all -> 0x0159 }
        r8 = (java.lang.Runnable) r8;	 Catch:{ all -> 0x0159 }
        if (r8 == 0) goto L_0x0090;
    L_0x0076:
        r2.put(r8);	 Catch:{ Throwable -> 0x007f }
        r8 = r13.h;	 Catch:{ Throwable -> 0x007f }
        r8.poll();	 Catch:{ Throwable -> 0x007f }
        goto L_0x008d;
    L_0x007f:
        r8 = move-exception;
        r10 = "[UploadManager] Failed to add upload task to temp urgent queue: %s";
        r11 = new java.lang.Object[r9];	 Catch:{ all -> 0x0159 }
        r8 = r8.getMessage();	 Catch:{ all -> 0x0159 }
        r11[r0] = r8;	 Catch:{ all -> 0x0159 }
        com.tencent.bugly.proguard.x.e(r10, r11);	 Catch:{ all -> 0x0159 }
    L_0x008d:
        r7 = r7 + 1;
        goto L_0x006a;
    L_0x0090:
        r7 = r0;
    L_0x0091:
        if (r7 >= r14) goto L_0x00b7;
    L_0x0093:
        r8 = r13.i;	 Catch:{ all -> 0x0159 }
        r8 = r8.peek();	 Catch:{ all -> 0x0159 }
        r8 = (java.lang.Runnable) r8;	 Catch:{ all -> 0x0159 }
        if (r8 == 0) goto L_0x00b7;
    L_0x009d:
        r3.put(r8);	 Catch:{ Throwable -> 0x00a6 }
        r8 = r13.i;	 Catch:{ Throwable -> 0x00a6 }
        r8.poll();	 Catch:{ Throwable -> 0x00a6 }
        goto L_0x00b4;
    L_0x00a6:
        r8 = move-exception;
        r10 = "[UploadManager] Failed to add upload task to temp urgent queue: %s";
        r11 = new java.lang.Object[r9];	 Catch:{ all -> 0x0159 }
        r8 = r8.getMessage();	 Catch:{ all -> 0x0159 }
        r11[r0] = r8;	 Catch:{ all -> 0x0159 }
        com.tencent.bugly.proguard.x.e(r10, r11);	 Catch:{ all -> 0x0159 }
    L_0x00b4:
        r7 = r7 + 1;
        goto L_0x0091;
    L_0x00b7:
        monitor-exit(r4);	 Catch:{ all -> 0x0159 }
        r4 = 3;
        if (r5 <= 0) goto L_0x00dc;
    L_0x00bb:
        r7 = "[UploadManager] Execute urgent upload tasks of queue which has %d tasks (pid=%d | tid=%d)";
        r8 = new java.lang.Object[r4];
        r10 = java.lang.Integer.valueOf(r5);
        r8[r0] = r10;
        r10 = android.os.Process.myPid();
        r10 = java.lang.Integer.valueOf(r10);
        r8[r9] = r10;
        r10 = android.os.Process.myTid();
        r10 = java.lang.Integer.valueOf(r10);
        r8[r6] = r10;
        com.tencent.bugly.proguard.x.c(r7, r8);
    L_0x00dc:
        r7 = r0;
    L_0x00dd:
        if (r7 >= r5) goto L_0x012b;
    L_0x00df:
        r8 = r2.poll();
        r8 = (java.lang.Runnable) r8;
        if (r8 == 0) goto L_0x012b;
    L_0x00e7:
        r10 = r13.j;
        monitor-enter(r10);
        r11 = r13.u;	 Catch:{ all -> 0x0128 }
        if (r11 < r6) goto L_0x00f5;
    L_0x00ee:
        if (r1 == 0) goto L_0x00f5;
    L_0x00f0:
        r1.a(r8);	 Catch:{ all -> 0x0128 }
        monitor-exit(r10);	 Catch:{ all -> 0x0128 }
        goto L_0x0125;
    L_0x00f5:
        monitor-exit(r10);
        r10 = "[UploadManager] Create and start a new thread to execute a upload task: %s";
        r11 = new java.lang.Object[r9];
        r12 = "BUGLY_ASYNC_UPLOAD";
        r11[r0] = r12;
        com.tencent.bugly.proguard.x.a(r10, r11);
        r10 = new com.tencent.bugly.proguard.u$1;
        r10.<init>(r8);
        r11 = "BUGLY_ASYNC_UPLOAD";
        r10 = com.tencent.bugly.proguard.z.a(r10, r11);
        if (r10 == 0) goto L_0x011b;
    L_0x010e:
        r8 = r13.j;
        monitor-enter(r8);
        r10 = r13.u;	 Catch:{ all -> 0x0118 }
        r10 = r10 + r9;
        r13.u = r10;	 Catch:{ all -> 0x0118 }
        monitor-exit(r8);	 Catch:{ all -> 0x0118 }
        goto L_0x0125;
    L_0x0118:
        r14 = move-exception;
        monitor-exit(r8);
        throw r14;
    L_0x011b:
        r10 = "[UploadManager] Failed to start a thread to execute asynchronous upload task, will try again next time.";
        r11 = new java.lang.Object[r0];
        com.tencent.bugly.proguard.x.d(r10, r11);
        r13.a(r8, r9);
    L_0x0125:
        r7 = r7 + 1;
        goto L_0x00dd;
    L_0x0128:
        r14 = move-exception;
        monitor-exit(r10);
        throw r14;
    L_0x012b:
        if (r14 <= 0) goto L_0x014e;
    L_0x012d:
        r2 = "[UploadManager] Execute upload tasks of queue which has %d tasks (pid=%d | tid=%d)";
        r4 = new java.lang.Object[r4];
        r5 = java.lang.Integer.valueOf(r14);
        r4[r0] = r5;
        r0 = android.os.Process.myPid();
        r0 = java.lang.Integer.valueOf(r0);
        r4[r9] = r0;
        r0 = android.os.Process.myTid();
        r0 = java.lang.Integer.valueOf(r0);
        r4[r6] = r0;
        com.tencent.bugly.proguard.x.c(r2, r4);
    L_0x014e:
        if (r1 == 0) goto L_0x0158;
    L_0x0150:
        r0 = new com.tencent.bugly.proguard.u$2;
        r0.<init>(r13, r14, r3);
        r1.a(r0);
    L_0x0158:
        return;
    L_0x0159:
        r14 = move-exception;
        monitor-exit(r4);
        throw r14;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.u.c(int):void");
    }

    private static boolean c() {
        x.c("[UploadManager] Drop security info of database (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            p a = p.a();
            if (a != null) {
                return a.a(555, "security_info", null, true);
            }
            x.d("[UploadManager] Failed to get Database", new Object[0]);
            return false;
        } catch (Throwable th) {
            x.a(th);
            return false;
        }
    }

    private boolean d() {
        x.c("[UploadManager] Record security info to database (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            p a = p.a();
            if (a == null) {
                x.d("[UploadManager] Failed to get database", new Object[0]);
                return false;
            }
            StringBuilder stringBuilder = new StringBuilder();
            if (this.n != null) {
                stringBuilder.append(Base64.encodeToString(this.n, 0));
                stringBuilder.append("#");
                if (this.o != 0) {
                    stringBuilder.append(Long.toString(this.o));
                } else {
                    stringBuilder.append("null");
                }
                stringBuilder.append("#");
                if (this.p != null) {
                    stringBuilder.append(this.p);
                } else {
                    stringBuilder.append("null");
                }
                stringBuilder.append("#");
                if (this.q != 0) {
                    stringBuilder.append(Long.toString(this.q));
                } else {
                    stringBuilder.append("null");
                }
                a.a(555, "security_info", stringBuilder.toString().getBytes(), null, true);
                return true;
            }
            x.c("[UploadManager] AES key is null, will not record", new Object[0]);
            return false;
        } catch (Throwable th) {
            x.a(th);
            c();
            return false;
        }
    }

    private boolean e() {
        x.c("[UploadManager] Load security info from database (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        int i;
        try {
            p a = p.a();
            if (a == null) {
                x.d("[UploadManager] Failed to get database", new Object[0]);
                return false;
            }
            Map a2 = a.a(555, null, true);
            if (a2 != null && a2.containsKey("security_info")) {
                String[] split = new String((byte[]) a2.get("security_info")).split("#");
                if (split.length == 4) {
                    if (!(split[0].isEmpty() || split[0].equals("null"))) {
                        this.n = Base64.decode(split[0], 0);
                    }
                    i = 0;
                    if (!(i != 0 || split[1].isEmpty() || split[1].equals("null"))) {
                        try {
                            this.o = Long.parseLong(split[1]);
                        } catch (Throwable th) {
                            x.a(th);
                            i = 1;
                        }
                    }
                    if (!(i != 0 || split[2].isEmpty() || split[2].equals("null"))) {
                        this.p = split[2];
                    }
                    if (!(i != 0 || split[3].isEmpty() || split[3].equals("null"))) {
                        try {
                            this.q = Long.parseLong(split[3]);
                        } catch (Throwable th2) {
                            x.a(th2);
                        }
                    }
                } else {
                    x.a("SecurityInfo = %s, Strings.length = %d", r2, Integer.valueOf(split.length));
                    i = 1;
                }
                if (i != 0) {
                    c();
                }
            }
            return true;
        } catch (Throwable th22) {
            x.a(th22);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0039 A:{Catch:{ Throwable -> 0x0058, all -> 0x005d }} */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0039 A:{Catch:{ Throwable -> 0x0058, all -> 0x005d }} */
    public final synchronized long a(int r8) {
        /*
        r7 = this;
        monitor-enter(r7);
        r0 = 0;
        r2 = 0;
        r3 = 1;
        if (r8 < 0) goto L_0x005f;
    L_0x0007:
        r4 = r7.e;	 Catch:{ all -> 0x005d }
        r5 = java.lang.Integer.valueOf(r8);	 Catch:{ all -> 0x005d }
        r4 = r4.get(r5);	 Catch:{ all -> 0x005d }
        r4 = (java.lang.Long) r4;	 Catch:{ all -> 0x005d }
        if (r4 == 0) goto L_0x001b;
    L_0x0015:
        r0 = r4.longValue();	 Catch:{ all -> 0x005d }
        monitor-exit(r7);
        return r0;
    L_0x001b:
        r4 = r7.c;	 Catch:{ all -> 0x005d }
        r4 = r4.a(r8);	 Catch:{ all -> 0x005d }
        if (r4 == 0) goto L_0x006c;
    L_0x0023:
        r5 = r4.size();	 Catch:{ all -> 0x005d }
        if (r5 <= 0) goto L_0x006c;
    L_0x0029:
        r5 = r4.size();	 Catch:{ all -> 0x005d }
        if (r5 <= r3) goto L_0x004e;
    L_0x002f:
        r2 = r4.iterator();	 Catch:{ all -> 0x005d }
    L_0x0033:
        r3 = r2.hasNext();	 Catch:{ all -> 0x005d }
        if (r3 == 0) goto L_0x0048;
    L_0x0039:
        r3 = r2.next();	 Catch:{ all -> 0x005d }
        r3 = (com.tencent.bugly.proguard.r) r3;	 Catch:{ all -> 0x005d }
        r4 = r3.e;	 Catch:{ all -> 0x005d }
        r6 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r6 <= 0) goto L_0x0033;
    L_0x0045:
        r0 = r3.e;	 Catch:{ all -> 0x005d }
        goto L_0x0033;
    L_0x0048:
        r2 = r7.c;	 Catch:{ all -> 0x005d }
        r2.b(r8);	 Catch:{ all -> 0x005d }
        goto L_0x006c;
    L_0x004e:
        r8 = r4.get(r2);	 Catch:{ Throwable -> 0x0058 }
        r8 = (com.tencent.bugly.proguard.r) r8;	 Catch:{ Throwable -> 0x0058 }
        r2 = r8.e;	 Catch:{ Throwable -> 0x0058 }
        r0 = r2;
        goto L_0x006c;
    L_0x0058:
        r8 = move-exception;
        com.tencent.bugly.proguard.x.a(r8);	 Catch:{ all -> 0x005d }
        goto L_0x006c;
    L_0x005d:
        r8 = move-exception;
        goto L_0x006e;
    L_0x005f:
        r4 = "[UploadManager] Unknown upload ID: %d";
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x005d }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ all -> 0x005d }
        r3[r2] = r8;	 Catch:{ all -> 0x005d }
        com.tencent.bugly.proguard.x.e(r4, r3);	 Catch:{ all -> 0x005d }
    L_0x006c:
        monitor-exit(r7);
        return r0;
    L_0x006e:
        monitor-exit(r7);
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.u.a(int):long");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0047  */
    public final long a(boolean r12) {
        /*
        r11 = this;
        r0 = com.tencent.bugly.proguard.z.b();
        r2 = 3;
        if (r12 == 0) goto L_0x0009;
    L_0x0007:
        r3 = 5;
        goto L_0x000a;
    L_0x0009:
        r3 = r2;
    L_0x000a:
        r4 = r11.c;
        r4 = r4.a(r3);
        r5 = 0;
        if (r4 == 0) goto L_0x004d;
    L_0x0013:
        r6 = r4.size();
        if (r6 <= 0) goto L_0x004d;
    L_0x0019:
        r6 = 0;
        r12 = r4.get(r5);	 Catch:{ Throwable -> 0x003c }
        r12 = (com.tencent.bugly.proguard.r) r12;	 Catch:{ Throwable -> 0x003c }
        r8 = r12.e;	 Catch:{ Throwable -> 0x003c }
        r10 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1));
        if (r10 < 0) goto L_0x003a;
    L_0x0027:
        r0 = r12.g;	 Catch:{ Throwable -> 0x003c }
        r0 = com.tencent.bugly.proguard.z.c(r0);	 Catch:{ Throwable -> 0x003c }
        if (r3 != r2) goto L_0x0034;
    L_0x002f:
        r11.f = r0;	 Catch:{ Throwable -> 0x0032 }
        goto L_0x0036;
    L_0x0032:
        r12 = move-exception;
        goto L_0x003e;
    L_0x0034:
        r11.g = r0;	 Catch:{ Throwable -> 0x0032 }
    L_0x0036:
        r4.remove(r12);	 Catch:{ Throwable -> 0x0032 }
        goto L_0x0041;
    L_0x003a:
        r0 = r6;
        goto L_0x0041;
    L_0x003c:
        r12 = move-exception;
        r0 = r6;
    L_0x003e:
        com.tencent.bugly.proguard.x.a(r12);
    L_0x0041:
        r12 = r4.size();
        if (r12 <= 0) goto L_0x0054;
    L_0x0047:
        r12 = r11.c;
        r12.a(r4);
        goto L_0x0054;
    L_0x004d:
        if (r12 == 0) goto L_0x0052;
    L_0x004f:
        r0 = r11.g;
        goto L_0x0054;
    L_0x0052:
        r0 = r11.f;
    L_0x0054:
        r12 = "[UploadManager] Local network consume: %d KB";
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r3 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r3 = r0 / r3;
        r3 = java.lang.Long.valueOf(r3);
        r2[r5] = r3;
        com.tencent.bugly.proguard.x.c(r12, r2);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.u.a(boolean):long");
    }

    public final void a(int i, int i2, byte[] bArr, String str, String str2, t tVar, int i3, int i4, boolean z, Map<String, String> map) {
        try {
            a(new v(this.d, i, i2, bArr, str, str2, tVar, this.a, i3, i4, false, map), z, false, 0);
        } catch (Throwable th) {
            Throwable th2 = th;
            if (!x.a(th2)) {
                th2.printStackTrace();
            }
        }
    }

    public final synchronized void a(int i, long j) {
        if (i >= 0) {
            this.e.put(Integer.valueOf(i), Long.valueOf(j));
            r rVar = new r();
            rVar.b = i;
            rVar.e = j;
            rVar.c = "";
            rVar.d = "";
            rVar.g = new byte[0];
            this.c.b(i);
            this.c.a(rVar);
            x.c("[UploadManager] Uploading(ID:%d) time: %s", Integer.valueOf(i), z.a(j));
            return;
        }
        x.e("[UploadManager] Unknown uploading ID: %d", Integer.valueOf(i));
    }

    public final void a(int i, am amVar, String str, String str2, t tVar, long j, boolean z) {
        try {
            a(new v(this.d, i, amVar.g, a.a((Object) amVar), str, str2, tVar, this.a, z), true, true, j);
        } catch (Throwable th) {
            Throwable th2 = th;
            if (!x.a(th2)) {
                th2.printStackTrace();
            }
        }
    }

    public final void a(int i, am amVar, String str, String str2, t tVar, boolean z) {
        Object obj = amVar;
        a(i, obj.g, a.a(obj), str, str2, tVar, 0, 0, z, null);
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x00da */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0129 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0129 A:{SYNTHETIC} */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:30|31) */
    /* JADX WARNING: Missing block: B:14:0x0034, code skipped:
            if (r11 == null) goto L_0x0108;
     */
    /* JADX WARNING: Missing block: B:15:0x0036, code skipped:
            com.tencent.bugly.proguard.x.c("[UploadManager] Record security context (pid=%d | tid=%d)", java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
     */
    /* JADX WARNING: Missing block: B:17:?, code skipped:
            r10 = r11.g;
     */
    /* JADX WARNING: Missing block: B:18:0x0053, code skipped:
            if (r10 == null) goto L_0x0102;
     */
    /* JADX WARNING: Missing block: B:20:0x005b, code skipped:
            if (r10.containsKey("S1") == false) goto L_0x0102;
     */
    /* JADX WARNING: Missing block: B:22:0x0063, code skipped:
            if (r10.containsKey("S2") == false) goto L_0x0102;
     */
    /* JADX WARNING: Missing block: B:23:0x0065, code skipped:
            r9.m = r11.e - java.lang.System.currentTimeMillis();
            com.tencent.bugly.proguard.x.c("[UploadManager] Time lag of server is: %d", java.lang.Long.valueOf(r9.m));
            r9.p = (java.lang.String) r10.get("S1");
            com.tencent.bugly.proguard.x.c("[UploadManager] Session ID from server is: %s", r9.p);
     */
    /* JADX WARNING: Missing block: B:24:0x0099, code skipped:
            if (r9.p.length() <= 0) goto L_0x00f6;
     */
    /* JADX WARNING: Missing block: B:27:?, code skipped:
            r9.q = java.lang.Long.parseLong((java.lang.String) r10.get("S2"));
            com.tencent.bugly.proguard.x.c("[UploadManager] Session expired time from server is: %d(%s)", java.lang.Long.valueOf(r9.q), new java.util.Date(r9.q).toString());
     */
    /* JADX WARNING: Missing block: B:28:0x00ce, code skipped:
            if (r9.q >= 1000) goto L_0x00e3;
     */
    /* JADX WARNING: Missing block: B:29:0x00d0, code skipped:
            com.tencent.bugly.proguard.x.d("[UploadManager] Session expired time from server is less than 1 second, will set to default value", new java.lang.Object[0]);
            r9.q = 259200000;
     */
    /* JADX WARNING: Missing block: B:31:?, code skipped:
            com.tencent.bugly.proguard.x.d("[UploadManager] Session expired time is invalid, will set to default value", new java.lang.Object[0]);
            r9.q = 259200000;
     */
    /* JADX WARNING: Missing block: B:37:0x00f6, code skipped:
            com.tencent.bugly.proguard.x.c("[UploadManager] Session ID from server is invalid, try next time", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing block: B:38:0x00fe, code skipped:
            r10 = move-exception;
     */
    /* JADX WARNING: Missing block: B:39:0x00ff, code skipped:
            com.tencent.bugly.proguard.x.a(r10);
     */
    /* JADX WARNING: Missing block: B:42:0x0108, code skipped:
            com.tencent.bugly.proguard.x.c("[UploadManager] Fail to init security context and clear local info (pid=%d | tid=%d)", java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
            b(false);
     */
    public final void a(int r10, com.tencent.bugly.proguard.an r11) {
        /*
        r9 = this;
        r0 = r9.a;
        if (r0 != 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = 2;
        r1 = 1;
        r2 = 0;
        if (r10 != r0) goto L_0x002a;
    L_0x000a:
        r10 = "[UploadManager] Session ID is invalid, will clear security context (pid=%d | tid=%d)";
        r11 = new java.lang.Object[r0];
        r0 = android.os.Process.myPid();
        r0 = java.lang.Integer.valueOf(r0);
        r11[r2] = r0;
        r0 = android.os.Process.myTid();
        r0 = java.lang.Integer.valueOf(r0);
        r11[r1] = r0;
        com.tencent.bugly.proguard.x.c(r10, r11);
        r9.b(r1);
        goto L_0x0126;
    L_0x002a:
        r10 = r9.t;
        monitor-enter(r10);
        r3 = r9.s;	 Catch:{ all -> 0x013b }
        if (r3 != 0) goto L_0x0033;
    L_0x0031:
        monitor-exit(r10);	 Catch:{ all -> 0x013b }
        return;
    L_0x0033:
        monitor-exit(r10);
        if (r11 == 0) goto L_0x0108;
    L_0x0036:
        r10 = "[UploadManager] Record security context (pid=%d | tid=%d)";
        r3 = new java.lang.Object[r0];
        r4 = android.os.Process.myPid();
        r4 = java.lang.Integer.valueOf(r4);
        r3[r2] = r4;
        r4 = android.os.Process.myTid();
        r4 = java.lang.Integer.valueOf(r4);
        r3[r1] = r4;
        com.tencent.bugly.proguard.x.c(r10, r3);
        r10 = r11.g;	 Catch:{ Throwable -> 0x00fe }
        if (r10 == 0) goto L_0x0102;
    L_0x0055:
        r3 = "S1";
        r3 = r10.containsKey(r3);	 Catch:{ Throwable -> 0x00fe }
        if (r3 == 0) goto L_0x0102;
    L_0x005d:
        r3 = "S2";
        r3 = r10.containsKey(r3);	 Catch:{ Throwable -> 0x00fe }
        if (r3 == 0) goto L_0x0102;
    L_0x0065:
        r3 = r11.e;	 Catch:{ Throwable -> 0x00fe }
        r5 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x00fe }
        r7 = r3 - r5;
        r9.m = r7;	 Catch:{ Throwable -> 0x00fe }
        r11 = "[UploadManager] Time lag of server is: %d";
        r3 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x00fe }
        r4 = r9.m;	 Catch:{ Throwable -> 0x00fe }
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ Throwable -> 0x00fe }
        r3[r2] = r4;	 Catch:{ Throwable -> 0x00fe }
        com.tencent.bugly.proguard.x.c(r11, r3);	 Catch:{ Throwable -> 0x00fe }
        r11 = "S1";
        r11 = r10.get(r11);	 Catch:{ Throwable -> 0x00fe }
        r11 = (java.lang.String) r11;	 Catch:{ Throwable -> 0x00fe }
        r9.p = r11;	 Catch:{ Throwable -> 0x00fe }
        r11 = "[UploadManager] Session ID from server is: %s";
        r3 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x00fe }
        r4 = r9.p;	 Catch:{ Throwable -> 0x00fe }
        r3[r2] = r4;	 Catch:{ Throwable -> 0x00fe }
        com.tencent.bugly.proguard.x.c(r11, r3);	 Catch:{ Throwable -> 0x00fe }
        r11 = r9.p;	 Catch:{ Throwable -> 0x00fe }
        r11 = r11.length();	 Catch:{ Throwable -> 0x00fe }
        if (r11 <= 0) goto L_0x00f6;
    L_0x009b:
        r3 = 259200000; // 0xf731400 float:1.1984677E-29 double:1.280618154E-315;
        r11 = "S2";
        r10 = r10.get(r11);	 Catch:{ NumberFormatException -> 0x00da }
        r10 = (java.lang.String) r10;	 Catch:{ NumberFormatException -> 0x00da }
        r10 = java.lang.Long.parseLong(r10);	 Catch:{ NumberFormatException -> 0x00da }
        r9.q = r10;	 Catch:{ NumberFormatException -> 0x00da }
        r10 = "[UploadManager] Session expired time from server is: %d(%s)";
        r11 = new java.lang.Object[r0];	 Catch:{ NumberFormatException -> 0x00da }
        r5 = r9.q;	 Catch:{ NumberFormatException -> 0x00da }
        r0 = java.lang.Long.valueOf(r5);	 Catch:{ NumberFormatException -> 0x00da }
        r11[r2] = r0;	 Catch:{ NumberFormatException -> 0x00da }
        r0 = new java.util.Date;	 Catch:{ NumberFormatException -> 0x00da }
        r5 = r9.q;	 Catch:{ NumberFormatException -> 0x00da }
        r0.<init>(r5);	 Catch:{ NumberFormatException -> 0x00da }
        r0 = r0.toString();	 Catch:{ NumberFormatException -> 0x00da }
        r11[r1] = r0;	 Catch:{ NumberFormatException -> 0x00da }
        com.tencent.bugly.proguard.x.c(r10, r11);	 Catch:{ NumberFormatException -> 0x00da }
        r10 = r9.q;	 Catch:{ NumberFormatException -> 0x00da }
        r5 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r0 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1));
        if (r0 >= 0) goto L_0x00e3;
    L_0x00d0:
        r10 = "[UploadManager] Session expired time from server is less than 1 second, will set to default value";
        r11 = new java.lang.Object[r2];	 Catch:{ NumberFormatException -> 0x00da }
        com.tencent.bugly.proguard.x.d(r10, r11);	 Catch:{ NumberFormatException -> 0x00da }
        r9.q = r3;	 Catch:{ NumberFormatException -> 0x00da }
        goto L_0x00e3;
    L_0x00da:
        r10 = "[UploadManager] Session expired time is invalid, will set to default value";
        r11 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x00fe }
        com.tencent.bugly.proguard.x.d(r10, r11);	 Catch:{ Throwable -> 0x00fe }
        r9.q = r3;	 Catch:{ Throwable -> 0x00fe }
    L_0x00e3:
        r10 = r9.d();	 Catch:{ Throwable -> 0x00fe }
        if (r10 == 0) goto L_0x00eb;
    L_0x00e9:
        r1 = r2;
        goto L_0x00f2;
    L_0x00eb:
        r10 = "[UploadManager] Failed to record database";
        r11 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x00fe }
        com.tencent.bugly.proguard.x.c(r10, r11);	 Catch:{ Throwable -> 0x00fe }
    L_0x00f2:
        r9.c(r2);	 Catch:{ Throwable -> 0x00fe }
        goto L_0x0102;
    L_0x00f6:
        r10 = "[UploadManager] Session ID from server is invalid, try next time";
        r11 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x00fe }
        com.tencent.bugly.proguard.x.c(r10, r11);	 Catch:{ Throwable -> 0x00fe }
        goto L_0x0102;
    L_0x00fe:
        r10 = move-exception;
        com.tencent.bugly.proguard.x.a(r10);
    L_0x0102:
        if (r1 == 0) goto L_0x0126;
    L_0x0104:
        r9.b(r2);
        goto L_0x0126;
    L_0x0108:
        r10 = "[UploadManager] Fail to init security context and clear local info (pid=%d | tid=%d)";
        r11 = new java.lang.Object[r0];
        r0 = android.os.Process.myPid();
        r0 = java.lang.Integer.valueOf(r0);
        r11[r2] = r0;
        r0 = android.os.Process.myTid();
        r0 = java.lang.Integer.valueOf(r0);
        r11[r1] = r0;
        com.tencent.bugly.proguard.x.c(r10, r11);
        r9.b(r2);
    L_0x0126:
        r10 = r9.t;
        monitor-enter(r10);
        r11 = r9.s;	 Catch:{ all -> 0x0138 }
        if (r11 == 0) goto L_0x0136;
    L_0x012d:
        r9.s = r2;	 Catch:{ all -> 0x0138 }
        r11 = r9.d;	 Catch:{ all -> 0x0138 }
        r0 = "security_info";
        com.tencent.bugly.proguard.z.b(r11, r0);	 Catch:{ all -> 0x0138 }
    L_0x0136:
        monitor-exit(r10);	 Catch:{ all -> 0x0138 }
        return;
    L_0x0138:
        r11 = move-exception;
        monitor-exit(r10);
        throw r11;
    L_0x013b:
        r11 = move-exception;
        monitor-exit(r10);
        throw r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.u.a(int, com.tencent.bugly.proguard.an):void");
    }

    /* Access modifiers changed, original: protected|final|declared_synchronized */
    public final synchronized void a(long j, boolean z) {
        int i = z ? 5 : 3;
        r rVar = new r();
        rVar.b = i;
        rVar.e = z.b();
        rVar.c = "";
        rVar.d = "";
        rVar.g = z.c(j);
        this.c.b(i);
        this.c.a(rVar);
        if (z) {
            this.g = j;
        } else {
            this.f = j;
        }
        x.c("[UploadManager] Network total consume: %d KB", Long.valueOf(j / 1024));
    }

    public final boolean a(Map<String, String> map) {
        if (map == null) {
            return false;
        }
        x.c("[UploadManager] Integrate security to HTTP headers (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        if (this.p != null) {
            map.put("secureSessionId", this.p);
            return true;
        } else if (this.n == null || (this.n.length << 3) != 128) {
            x.d("[UploadManager] AES key is invalid", new Object[0]);
            return false;
        } else {
            if (this.l == null) {
                this.l = Base64.decode(this.k, 0);
                if (this.l == null) {
                    x.d("[UploadManager] Failed to decode RSA public key", new Object[0]);
                    return false;
                }
            }
            byte[] b = z.b(1, this.n, this.l);
            if (b == null) {
                x.d("[UploadManager] Failed to encrypt AES key", new Object[0]);
                return false;
            }
            String encodeToString = Base64.encodeToString(b, 0);
            if (encodeToString == null) {
                x.d("[UploadManager] Failed to encode AES key", new Object[0]);
                return false;
            }
            map.put("raKey", encodeToString);
            return true;
        }
    }

    public final byte[] a(byte[] bArr) {
        if (this.n != null && (this.n.length << 3) == 128) {
            return z.a(1, bArr, this.n);
        }
        x.d("[UploadManager] AES key is invalid (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        return null;
    }

    /* Access modifiers changed, original: protected|final */
    public final void b(boolean z) {
        synchronized (this.r) {
            x.c("[UploadManager] Clear security context (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            this.n = null;
            this.p = null;
            this.q = 0;
        }
        if (z) {
            c();
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean b() {
        if (this.p == null || this.q == 0) {
            return false;
        }
        if (this.q >= System.currentTimeMillis() + this.m) {
            return true;
        }
        x.c("[UploadManager] Session ID expired time from server is: %d(%s), but now is: %d(%s)", Long.valueOf(this.q), new Date(this.q).toString(), Long.valueOf(System.currentTimeMillis() + this.m), new Date(System.currentTimeMillis() + this.m).toString());
        return false;
    }

    public final boolean b(int i) {
        if (b.c) {
            x.c("Uploading frequency will not be checked if SDK is in debug mode.", new Object[0]);
            return true;
        }
        x.c("[UploadManager] Time interval is %d seconds since last uploading(ID: %d).", Long.valueOf((System.currentTimeMillis() - a(i)) / 1000), Integer.valueOf(i));
        if (System.currentTimeMillis() - a(i) >= StatisticConfig.MIN_UPLOAD_INTERVAL) {
            return true;
        }
        x.a("[UploadManager] Data only be uploaded once in %d seconds.", Long.valueOf(30));
        return false;
    }

    public final byte[] b(byte[] bArr) {
        if (this.n != null && (this.n.length << 3) == 128) {
            return z.a(2, bArr, this.n);
        }
        x.d("[UploadManager] AES key is invalid (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        return null;
    }
}
