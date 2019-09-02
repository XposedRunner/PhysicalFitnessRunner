package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.baidu.mapapi.synchronization.DisplayOptions;
import com.baidu.mapapi.synchronization.RoleOptions;

public class d {
    private static final String a = "d";
    private static int b = 0;
    private static g c = null;
    private static Thread d = null;
    private static volatile boolean e = true;
    private static volatile long g = 5000;
    private static long h = 5000;
    private static volatile boolean i = false;
    private static int j = 1000;
    private c f;
    private boolean k;

    private static class a {
        private static final d a = new d();
    }

    private static class b implements Runnable {
        private String a;

        b(String str) {
            this.a = str;
        }

        public void run() {
            while (!d.e) {
                int i = 0;
                if (d.c != null) {
                    d.c.a(d.b, d.i);
                    d.i = false;
                }
                try {
                    Thread.sleep(d.g);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
                if (d.c != null) {
                    i = d.c.d();
                }
                if (i >= 3) {
                    long j = (long) (1 + (i / 3));
                    long j2 = 60000;
                    if (d.h * j < 60000) {
                        j2 = d.h * j;
                    }
                    d.g = j2;
                } else {
                    d.g = d.h;
                }
            }
        }
    }

    private static class c extends Handler {
        c() {
        }

        private void a(int i) {
            if (d.j != i) {
                d.i = true;
                d.j = i;
                return;
            }
            d.i = false;
        }

        public void handleMessage(Message message) {
            String k = d.a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("The order state is: ");
            stringBuilder.append(message.what);
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(k, stringBuilder.toString());
            a(message.what);
            switch (message.what) {
                case 0:
                case 5:
                    d.p();
                    return;
                case 1:
                case 2:
                case 3:
                case 4:
                    d.q();
                    return;
                default:
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(d.a, "The order state is undefined");
                    return;
            }
        }
    }

    private d() {
        this.k = true;
    }

    /* synthetic */ d(e eVar) {
        this();
    }

    static d a() {
        return a.a;
    }

    private void o() {
        e = true;
        if (d != null) {
            d.interrupt();
            d = null;
        }
    }

    private static synchronized void p() {
        synchronized (d.class) {
            e = true;
        }
    }

    /* JADX WARNING: Missing block: B:16:0x0042, code skipped:
            return;
     */
    private static synchronized void q() {
        /*
        r0 = com.baidu.mapsdkplatform.comapi.synchronization.data.d.class;
        monitor-enter(r0);
        r1 = d;	 Catch:{ all -> 0x0043 }
        if (r1 != 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r0);
        return;
    L_0x0009:
        r1 = 0;
        e = r1;	 Catch:{ all -> 0x0043 }
        r1 = java.lang.Thread.State.NEW;	 Catch:{ all -> 0x0043 }
        r2 = d;	 Catch:{ all -> 0x0043 }
        r2 = r2.getState();	 Catch:{ all -> 0x0043 }
        if (r1 != r2) goto L_0x001b;
    L_0x0016:
        r1 = d;	 Catch:{ all -> 0x0043 }
        r1.start();	 Catch:{ all -> 0x0043 }
    L_0x001b:
        r1 = java.lang.Thread.State.TERMINATED;	 Catch:{ all -> 0x0043 }
        r2 = d;	 Catch:{ all -> 0x0043 }
        r2 = r2.getState();	 Catch:{ all -> 0x0043 }
        if (r1 != r2) goto L_0x0041;
    L_0x0025:
        r1 = 0;
        d = r1;	 Catch:{ all -> 0x0043 }
        r1 = new java.lang.Thread;	 Catch:{ all -> 0x0043 }
        r2 = new com.baidu.mapsdkplatform.comapi.synchronization.data.d$b;	 Catch:{ all -> 0x0043 }
        r3 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x0043 }
        r3 = r3.getName();	 Catch:{ all -> 0x0043 }
        r2.<init>(r3);	 Catch:{ all -> 0x0043 }
        r1.<init>(r2);	 Catch:{ all -> 0x0043 }
        d = r1;	 Catch:{ all -> 0x0043 }
        r1 = d;	 Catch:{ all -> 0x0043 }
        r1.start();	 Catch:{ all -> 0x0043 }
    L_0x0041:
        monitor-exit(r0);
        return;
    L_0x0043:
        r1 = move-exception;
        monitor-exit(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.synchronization.data.d.q():void");
    }

    /* Access modifiers changed, original: declared_synchronized */
    public synchronized void a(int i) {
        String str = a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The order state = ");
        stringBuilder.append(i);
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.c(str, stringBuilder.toString());
        b = i;
        if (this.f == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "SyncDataRequestHandler is null");
            return;
        }
        Message obtainMessage = this.f.obtainMessage();
        obtainMessage.what = i;
        this.f.sendMessage(obtainMessage);
    }

    /* Access modifiers changed, original: 0000 */
    public void a(View view) {
        if (c != null) {
            c.a(view);
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void a(DisplayOptions displayOptions) {
        if (c != null) {
            c.a(displayOptions);
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void a(RoleOptions roleOptions) {
        if (c != null) {
            c.a(roleOptions);
        }
    }

    public void a(RoleOptions roleOptions, DisplayOptions displayOptions) {
        c = g.a();
        if (c != null) {
            c.b();
            c.a(roleOptions);
            c.a(displayOptions);
        }
        d = new Thread(new b(Thread.currentThread().getName()));
        this.f = new c();
    }

    /* Access modifiers changed, original: 0000 */
    public void a(k kVar) {
        if (c != null) {
            c.a(kVar);
        }
    }

    public void b() {
        if (this.k) {
            this.k = false;
        } else {
            q();
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void b(int i) {
        long j = (long) (i * 1000);
        h = j;
        g = j;
    }

    /* Access modifiers changed, original: 0000 */
    public void b(View view) {
        if (c != null) {
            c.b(view);
        }
    }

    public void c() {
        p();
    }

    /* Access modifiers changed, original: 0000 */
    public void c(View view) {
        if (c != null) {
            c.c(view);
        }
    }

    public void d() {
        o();
        this.f.removeCallbacksAndMessages(null);
        b = 0;
        h = 5000;
        i = false;
        j = 1000;
        this.k = true;
        if (c != null) {
            c.h();
        }
    }
}
