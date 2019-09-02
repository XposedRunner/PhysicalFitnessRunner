package com.tencent.bugly.crashreport.crash;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;

/* compiled from: BUGLY */
public class BuglyBroadcastRecevier extends BroadcastReceiver {
    private static BuglyBroadcastRecevier d;
    private IntentFilter a = new IntentFilter();
    private Context b;
    private String c;
    private boolean e = true;

    /* JADX WARNING: Missing block: B:36:0x00bd, code skipped:
            return true;
     */
    /* JADX WARNING: Missing block: B:45:0x00cb, code skipped:
            return false;
     */
    private synchronized boolean a(android.content.Context r10, android.content.Intent r11) {
        /*
        r9 = this;
        monitor-enter(r9);
        r0 = 0;
        if (r10 == 0) goto L_0x00ca;
    L_0x0004:
        if (r11 == 0) goto L_0x00ca;
    L_0x0006:
        r11 = r11.getAction();	 Catch:{ all -> 0x00c7 }
        r1 = "android.net.conn.CONNECTIVITY_CHANGE";
        r11 = r11.equals(r1);	 Catch:{ all -> 0x00c7 }
        if (r11 != 0) goto L_0x0014;
    L_0x0012:
        goto L_0x00ca;
    L_0x0014:
        r11 = r9.e;	 Catch:{ all -> 0x00c7 }
        r1 = 1;
        if (r11 == 0) goto L_0x001d;
    L_0x0019:
        r9.e = r0;	 Catch:{ all -> 0x00c7 }
        monitor-exit(r9);
        return r1;
    L_0x001d:
        r11 = r9.b;	 Catch:{ all -> 0x00c7 }
        r11 = com.tencent.bugly.crashreport.common.info.b.f(r11);	 Catch:{ all -> 0x00c7 }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c7 }
        r3 = "is Connect BC ";
        r2.<init>(r3);	 Catch:{ all -> 0x00c7 }
        r2.append(r11);	 Catch:{ all -> 0x00c7 }
        r2 = r2.toString();	 Catch:{ all -> 0x00c7 }
        r3 = new java.lang.Object[r0];	 Catch:{ all -> 0x00c7 }
        com.tencent.bugly.proguard.x.c(r2, r3);	 Catch:{ all -> 0x00c7 }
        r2 = "network %s changed to %s";
        r3 = 2;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x00c7 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c7 }
        r4.<init>();	 Catch:{ all -> 0x00c7 }
        r5 = r9.c;	 Catch:{ all -> 0x00c7 }
        r4.append(r5);	 Catch:{ all -> 0x00c7 }
        r4 = r4.toString();	 Catch:{ all -> 0x00c7 }
        r3[r0] = r4;	 Catch:{ all -> 0x00c7 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c7 }
        r4.<init>();	 Catch:{ all -> 0x00c7 }
        r4.append(r11);	 Catch:{ all -> 0x00c7 }
        r4 = r4.toString();	 Catch:{ all -> 0x00c7 }
        r3[r1] = r4;	 Catch:{ all -> 0x00c7 }
        com.tencent.bugly.proguard.x.a(r2, r3);	 Catch:{ all -> 0x00c7 }
        if (r11 != 0) goto L_0x0063;
    L_0x005e:
        r10 = 0;
        r9.c = r10;	 Catch:{ all -> 0x00c7 }
        monitor-exit(r9);
        return r1;
    L_0x0063:
        r2 = r9.c;	 Catch:{ all -> 0x00c7 }
        r9.c = r11;	 Catch:{ all -> 0x00c7 }
        r3 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x00c7 }
        r5 = com.tencent.bugly.crashreport.common.strategy.a.a();	 Catch:{ all -> 0x00c7 }
        r6 = com.tencent.bugly.proguard.u.a();	 Catch:{ all -> 0x00c7 }
        r10 = com.tencent.bugly.crashreport.common.info.a.a(r10);	 Catch:{ all -> 0x00c7 }
        if (r5 == 0) goto L_0x00be;
    L_0x0079:
        if (r6 == 0) goto L_0x00be;
    L_0x007b:
        if (r10 != 0) goto L_0x007e;
    L_0x007d:
        goto L_0x00be;
    L_0x007e:
        r10 = r11.equals(r2);	 Catch:{ all -> 0x00c7 }
        if (r10 != 0) goto L_0x00bc;
    L_0x0084:
        r10 = com.tencent.bugly.crashreport.crash.c.a;	 Catch:{ all -> 0x00c7 }
        r10 = r6.a(r10);	 Catch:{ all -> 0x00c7 }
        r7 = r3 - r10;
        r10 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r2 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1));
        if (r2 <= 0) goto L_0x00a4;
    L_0x0092:
        r2 = "try to upload crash on network changed.";
        r5 = new java.lang.Object[r0];	 Catch:{ all -> 0x00c7 }
        com.tencent.bugly.proguard.x.a(r2, r5);	 Catch:{ all -> 0x00c7 }
        r2 = com.tencent.bugly.crashreport.crash.c.a();	 Catch:{ all -> 0x00c7 }
        if (r2 == 0) goto L_0x00a4;
    L_0x009f:
        r7 = 0;
        r2.a(r7);	 Catch:{ all -> 0x00c7 }
    L_0x00a4:
        r2 = 1001; // 0x3e9 float:1.403E-42 double:4.946E-321;
        r5 = r6.a(r2);	 Catch:{ all -> 0x00c7 }
        r7 = r3 - r5;
        r2 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1));
        if (r2 <= 0) goto L_0x00bc;
    L_0x00b0:
        r10 = "try to upload userinfo on network changed.";
        r11 = new java.lang.Object[r0];	 Catch:{ all -> 0x00c7 }
        com.tencent.bugly.proguard.x.a(r10, r11);	 Catch:{ all -> 0x00c7 }
        r10 = com.tencent.bugly.crashreport.biz.b.a;	 Catch:{ all -> 0x00c7 }
        r10.b();	 Catch:{ all -> 0x00c7 }
    L_0x00bc:
        monitor-exit(r9);
        return r1;
    L_0x00be:
        r10 = "not inited BC not work";
        r11 = new java.lang.Object[r0];	 Catch:{ all -> 0x00c7 }
        com.tencent.bugly.proguard.x.d(r10, r11);	 Catch:{ all -> 0x00c7 }
        monitor-exit(r9);
        return r1;
    L_0x00c7:
        r10 = move-exception;
        monitor-exit(r9);
        throw r10;
    L_0x00ca:
        monitor-exit(r9);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.BuglyBroadcastRecevier.a(android.content.Context, android.content.Intent):boolean");
    }

    public static synchronized BuglyBroadcastRecevier getInstance() {
        BuglyBroadcastRecevier buglyBroadcastRecevier;
        synchronized (BuglyBroadcastRecevier.class) {
            if (d == null) {
                d = new BuglyBroadcastRecevier();
            }
            buglyBroadcastRecevier = d;
        }
        return buglyBroadcastRecevier;
    }

    public synchronized void addFilter(String str) {
        if (!this.a.hasAction(str)) {
            this.a.addAction(str);
        }
        x.c("add action %s", str);
    }

    public final void onReceive(Context context, Intent intent) {
        try {
            a(context, intent);
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
        }
    }

    public synchronized void register(Context context) {
        this.b = context;
        z.a(new Runnable() {
            public final void run() {
                try {
                    x.a(BuglyBroadcastRecevier.d.getClass(), "Register broadcast receiver of Bugly.", new Object[0]);
                    synchronized (this) {
                        BuglyBroadcastRecevier.this.b.registerReceiver(BuglyBroadcastRecevier.d, BuglyBroadcastRecevier.this.a);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    public synchronized void unregister(Context context) {
        try {
            x.a(getClass(), "Unregister broadcast receiver of Bugly.", new Object[0]);
            context.unregisterReceiver(this);
            this.b = context;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
        }
    }
}
