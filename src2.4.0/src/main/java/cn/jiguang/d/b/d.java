package cn.jiguang.d.b;

import android.app.Service;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import cn.jiguang.api.JResponse;
import cn.jiguang.d.a;
import cn.jiguang.d.d.b;
import cn.jiguang.d.d.f;
import cn.jiguang.e.c;
import cn.jpush.android.service.PushService;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

public final class d {
    private static boolean d;
    private static final Object j = new Object();
    private static volatile d l;
    private g a;
    private f b;
    private HandlerThread c;
    private int e = 0;
    private int f = 0;
    private long g;
    private Context h;
    private boolean i = false;
    private WeakReference<Service> k;
    private int m;
    private int n;
    private final AtomicBoolean o = new AtomicBoolean(false);

    private d() {
    }

    public static d a() {
        if (l == null) {
            synchronized (j) {
                if (l == null) {
                    l = new d();
                }
            }
        }
        return l;
    }

    public static void a(byte[] bArr, String str, int i) {
        h.a().a(bArr, str, i);
    }

    private static void b(boolean z) {
        d = z;
        cn.jiguang.d.a.d.c(a.d, z);
    }

    static /* synthetic */ void c(d dVar, long j) {
        StringBuilder stringBuilder = new StringBuilder("Action - onHeartbeatSucceed - connection:");
        stringBuilder.append(j);
        c.a("JiguangTcpManager", stringBuilder.toString());
        if (j == g.a.get()) {
            b.a();
            b.a(dVar.h, j, 19);
        }
    }

    static /* synthetic */ void d(d dVar) {
        if (f.a().f()) {
            f fVar;
            long j;
            dVar.o.set(false);
            dVar.f++;
            StringBuilder stringBuilder = new StringBuilder("Action - onHeartbeatTimeout - timeoutTimes:");
            stringBuilder.append(dVar.f);
            c.a("JiguangTcpManager", stringBuilder.toString());
            if (i()) {
                c.a("JiguangTcpManager", "Is connecting now. Give up to retry.");
                fVar = dVar.b;
                j = 10000;
            } else if (!d || dVar.h()) {
                if (dVar.a != null) {
                    dVar.a.a();
                }
                dVar.k();
            } else {
                c.a("JiguangTcpManager", "Already logged in. Give up to retry.");
                fVar = dVar.b;
                j = 5000;
            }
            fVar.sendEmptyMessageDelayed(1005, j);
        }
    }

    public static boolean d() {
        return d;
    }

    public static long g() {
        return g.a.get();
    }

    private boolean h() {
        return this.f > 1;
    }

    private static boolean i() {
        return (g.a.get() == 0 || d) ? false : true;
    }

    private void j() {
        this.b.removeMessages(1022);
        this.g = System.currentTimeMillis();
        this.f = 0;
        this.o.set(false);
    }

    private void k() {
        StringBuilder stringBuilder = new StringBuilder("Action - retryConnect - disconnectedTimes:");
        stringBuilder.append(this.e);
        c.a("JiguangTcpManager", stringBuilder.toString());
        if (!cn.jiguang.g.a.d(this.h.getApplicationContext()) || cn.jiguang.d.a.a.j()) {
            c.a("JiguangTcpManager", "network is not connect or hb is one day(user stop service) ");
            return;
        }
        int f = cn.jiguang.g.a.f(this.h.getApplicationContext());
        int pow = (int) ((Math.pow(2.0d, (double) this.e) * 3.0d) * 1000.0d);
        int g = (cn.jiguang.d.a.a.g() * 1000) / 2;
        if (pow > g) {
            pow = g;
        }
        if ((this.e < 5 || f == 1) && !this.b.hasMessages(1011)) {
            StringBuilder stringBuilder2 = new StringBuilder("onDisconnected and retry restart conn - delay:");
            stringBuilder2.append(pow);
            c.a("JiguangTcpManager", stringBuilder2.toString());
            this.b.sendEmptyMessageDelayed(1011, (long) pow);
        }
    }

    public final void a(int i) {
        this.m = i;
    }

    public final void a(Service service) {
        if (service != null) {
            this.k = new WeakReference(service);
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0046 */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:22|23) */
    /* JADX WARNING: Missing block: B:23:?, code skipped:
            r2.b = new cn.jiguang.d.b.f(r2, android.os.Looper.getMainLooper());
     */
    public final synchronized void a(android.content.Context r3) {
        /*
        r2 = this;
        monitor-enter(r2);
        r0 = r2.i;	 Catch:{ all -> 0x0073 }
        if (r0 == 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r2);
        return;
    L_0x0007:
        if (r3 != 0) goto L_0x000b;
    L_0x0009:
        monitor-exit(r2);
        return;
    L_0x000b:
        r3 = r3.getApplicationContext();	 Catch:{ all -> 0x0073 }
        r2.h = r3;	 Catch:{ all -> 0x0073 }
        r3 = r2.c;	 Catch:{ Exception -> 0x0046 }
        if (r3 == 0) goto L_0x001d;
    L_0x0015:
        r3 = r2.c;	 Catch:{ Exception -> 0x0046 }
        r3 = r3.isAlive();	 Catch:{ Exception -> 0x0046 }
        if (r3 != 0) goto L_0x002b;
    L_0x001d:
        r3 = new cn.jiguang.d.b.e;	 Catch:{ Exception -> 0x0046 }
        r0 = "JCore";
        r3.<init>(r2, r0);	 Catch:{ Exception -> 0x0046 }
        r2.c = r3;	 Catch:{ Exception -> 0x0046 }
        r3 = r2.c;	 Catch:{ Exception -> 0x0046 }
        r3.start();	 Catch:{ Exception -> 0x0046 }
    L_0x002b:
        r3 = new cn.jiguang.d.b.f;	 Catch:{ Exception -> 0x0046 }
        r0 = r2.c;	 Catch:{ Exception -> 0x0046 }
        r0 = r0.getLooper();	 Catch:{ Exception -> 0x0046 }
        if (r0 != 0) goto L_0x003a;
    L_0x0035:
        r0 = android.os.Looper.getMainLooper();	 Catch:{ Exception -> 0x0046 }
        goto L_0x0040;
    L_0x003a:
        r0 = r2.c;	 Catch:{ Exception -> 0x0046 }
        r0 = r0.getLooper();	 Catch:{ Exception -> 0x0046 }
    L_0x0040:
        r3.<init>(r2, r0);	 Catch:{ Exception -> 0x0046 }
        r2.b = r3;	 Catch:{ Exception -> 0x0046 }
        goto L_0x0051;
    L_0x0046:
        r3 = new cn.jiguang.d.b.f;	 Catch:{ all -> 0x0073 }
        r0 = android.os.Looper.getMainLooper();	 Catch:{ all -> 0x0073 }
        r3.<init>(r2, r0);	 Catch:{ all -> 0x0073 }
        r2.b = r3;	 Catch:{ all -> 0x0073 }
    L_0x0051:
        r3 = cn.jiguang.d.d.l.a();	 Catch:{ all -> 0x0073 }
        r0 = r2.h;	 Catch:{ all -> 0x0073 }
        r3.a(r0);	 Catch:{ all -> 0x0073 }
        r3 = cn.jiguang.d.b.h.a();	 Catch:{ all -> 0x0073 }
        r0 = r2.h;	 Catch:{ all -> 0x0073 }
        r1 = r2.b;	 Catch:{ all -> 0x0073 }
        r3.a(r0, r1);	 Catch:{ all -> 0x0073 }
        r3 = cn.jiguang.d.i.f.a();	 Catch:{ all -> 0x0073 }
        r0 = r2.h;	 Catch:{ all -> 0x0073 }
        r3.a(r0);	 Catch:{ all -> 0x0073 }
        r3 = 1;
        r2.i = r3;	 Catch:{ all -> 0x0073 }
        monitor-exit(r2);
        return;
    L_0x0073:
        r3 = move-exception;
        monitor-exit(r2);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.d.b.d.a(android.content.Context):void");
    }

    public final void a(Bundle bundle) {
        if (!cn.jiguang.d.a.d.i(this.h)) {
            this.b.removeMessages(1006);
            this.b.removeMessages(1007);
            if (!bundle.getBoolean("connection-state", false)) {
                this.b.sendEmptyMessageDelayed(1007, 3000);
            } else if (g.a.get() == 0) {
                e();
            } else {
                this.b.sendEmptyMessageDelayed(1006, 3000);
            }
        }
    }

    public final void a(JResponse jResponse, long j) {
        int a = ((cn.jiguang.d.e.a.a) jResponse).a();
        if (a == 2) {
            cn.jiguang.d.d.d.a(Message.obtain(this.b, 7303), j);
            return;
        }
        if (a == 10) {
            jResponse.getHead().a(Long.valueOf(-1));
        }
    }

    public final void a(String str, Bundle bundle) {
        b.a();
        b.a(this.h, str, g.a.get(), bundle, this.b);
        if (cn.jiguang.d.a.d.i(this.h)) {
            a.a(this.h, true);
            cn.jiguang.d.a.d.b(this.h, false);
            if (g.a.get() == 0) {
                f();
            }
            return;
        }
        c.a("JiguangTcpManager", "jiguang service already started");
    }

    public final void a(String str, Object obj) {
        j();
        h.a().a(str, obj);
    }

    public final void a(boolean z) {
        cn.jiguang.d.a.d.d(this.h, z);
        if (this.k != null && this.k.get() != null && (this.k.get() instanceof PushService)) {
            ((PushService) this.k.get()).setDozePowerReceiver();
        }
    }

    public final void a(boolean z, long j) {
        if (cn.jiguang.d.a.d.i(this.h)) {
            c.a("JiguangTcpManager", "tcp has close by active");
        } else if (g.a.get() == 0) {
            e();
        } else {
            int i = 1004;
            if (j <= 0) {
                this.b.removeMessages(1005);
                if (z) {
                    this.b.removeMessages(1004);
                }
                f fVar = this.b;
                if (!z) {
                    i = 1005;
                }
                fVar.sendEmptyMessage(i);
                return;
            }
            if (z) {
                this.b.removeMessages(1005);
            }
            f fVar2 = this.b;
            if (!z) {
                i = 1005;
            }
            fVar2.sendEmptyMessageDelayed(i, j);
        }
    }

    public final Handler b() {
        return this.b;
    }

    public final void b(int i) {
        this.n = i;
    }

    public final void b(String str, Bundle bundle) {
        b.a();
        b.a(this.h, str, g.a.get(), bundle, this.b);
        if (cn.jiguang.d.a.d.i(this.h)) {
            c.a("JiguangTcpManager", "jiguang service already stoped");
            return;
        }
        f.a();
        if (f.e()) {
            a.a(this.h, false);
            cn.jiguang.d.a.d.b(this.h, true);
            if (!(this.k == null || this.k.get() == null)) {
                ((Service) this.k.get()).stopSelf();
            }
            c();
        }
    }

    public final void c() {
        if (d) {
            cn.jiguang.d.d.d.a(this.h, false);
        }
        b(false);
        this.e = 0;
        this.f = 0;
        if (this.a != null) {
            this.a.c();
        }
    }

    public final void e() {
        if (i()) {
            c.a("JiguangTcpManager", "Is connecting now. Give up to restart.");
        } else if (!d || h()) {
            this.b.removeMessages(1011);
            this.b.removeMessages(1005);
            f();
        } else {
            c.a("JiguangTcpManager", "Already logged in. Give up to restart.");
        }
    }

    public final synchronized void f() {
        StringBuilder stringBuilder = new StringBuilder("Action - restartNetworkingClient, pid:");
        stringBuilder.append(Process.myPid());
        c.a("JiguangTcpManager", stringBuilder.toString());
        if (!cn.jiguang.g.a.d(this.h.getApplicationContext())) {
            c.b("JiguangTcpManager", "No network connection. Give up to start connection thread.");
        } else if (cn.jiguang.d.a.d.i(this.h)) {
            c.a("JiguangTcpManager", "tcp has close by active");
        } else if (this.m == 102) {
            c.c("JiguangTcpManager", "login failed:102,give up start connection thread.reset from next app start");
        } else {
            if (this.a != null) {
                stringBuilder = new StringBuilder("isRunning:");
                stringBuilder.append(this.a.e());
                c.a("JiguangTcpManager", stringBuilder.toString());
                if (this.a.e()) {
                    return;
                }
            }
            if (this.a != null) {
                this.a.c();
                this.a = null;
            }
            this.a = new g(this.h.getApplicationContext(), this.b);
            this.a.b();
        }
    }
}
