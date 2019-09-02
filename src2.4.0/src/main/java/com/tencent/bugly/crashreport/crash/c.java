package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.common.strategy.a;
import com.tencent.bugly.crashreport.crash.anr.b;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.o;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.r;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: BUGLY */
public final class c {
    public static int a = 0;
    public static boolean b = false;
    public static int c = 2;
    public static boolean d = true;
    public static int e = 20000;
    public static int f = 20000;
    public static long g = 604800000;
    public static String h = null;
    public static boolean i = false;
    public static String j = null;
    public static int k = 5000;
    public static boolean l = true;
    public static String m;
    public static String n;
    private static c q;
    public final b o;
    private final Context p;
    private final e r;
    private final NativeCrashHandler s;
    private a t = a.a();
    private w u;
    private final b v;
    private Boolean w;

    private c(int i, Context context, w wVar, boolean z, BuglyStrategy.a aVar, o oVar, String str) {
        a = i;
        Context a = z.a(context);
        this.p = a;
        w wVar2 = wVar;
        this.u = wVar2;
        this.o = new b(i, a, u.a(), p.a(), this.t, aVar, oVar);
        com.tencent.bugly.crashreport.common.info.a a2 = com.tencent.bugly.crashreport.common.info.a.a(a);
        this.r = new e(a, this.o, this.t, a2);
        w wVar3 = wVar2;
        this.s = NativeCrashHandler.getInstance(a, a2, this.o, this.t, wVar3, z, str);
        a2.D = this.s;
        this.v = new b(a, this.t, a2, wVar3, this.o);
    }

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            cVar = q;
        }
        return cVar;
    }

    public static synchronized void a(int i, Context context, boolean z, BuglyStrategy.a aVar, o oVar, String str) {
        synchronized (c.class) {
            if (q == null) {
                q = new c(1004, context, w.a(), z, aVar, null, null);
            }
        }
    }

    public final void a(long j) {
        w.a().a(new Thread() {
            public final void run() {
                if (z.a(c.this.p, "local_crash_lock", 10000)) {
                    List a = c.this.o.a();
                    if (a != null && a.size() > 0) {
                        List list;
                        int size = a.size();
                        if (((long) size) > 100) {
                            ArrayList arrayList = new ArrayList();
                            Collections.sort(a);
                            for (int i = 0; ((long) i) < 100; i++) {
                                arrayList.add(a.get((size - 1) - i));
                            }
                            list = arrayList;
                        } else {
                            list = a;
                        }
                        c.this.o.a(list, 0, false, false, false);
                    }
                    z.b(c.this.p, "local_crash_lock");
                }
            }
        }, 0);
    }

    public final void a(StrategyBean strategyBean) {
        this.r.a(strategyBean);
        this.s.onStrategyChanged(strategyBean);
        this.v.a(strategyBean);
        w.a().a(/* anonymous class already generated */, 0);
    }

    public final void a(CrashDetailBean crashDetailBean) {
        this.o.d(crashDetailBean);
    }

    public final void a(Thread thread, Throwable th, boolean z, String str, byte[] bArr, boolean z2) {
        final Thread thread2 = thread;
        final Throwable th2 = th;
        final boolean z3 = z2;
        this.u.a(new Runnable(false, null, null) {
            public final void run() {
                try {
                    x.c("post a throwable %b", Boolean.valueOf(false));
                    c.this.r.a(thread2, th2, false, null, null);
                    if (z3) {
                        x.a("clear user datas", new Object[0]);
                        com.tencent.bugly.crashreport.common.info.a.a(c.this.p).C();
                    }
                } catch (Throwable th) {
                    if (!x.b(th)) {
                        th.printStackTrace();
                    }
                    x.e("java catch error: %s", th2.toString());
                }
            }
        });
    }

    public final boolean b() {
        Boolean bool = this.w;
        if (bool != null) {
            return bool.booleanValue();
        }
        String str = com.tencent.bugly.crashreport.common.info.a.b().d;
        List<r> a = p.a().a(1);
        List arrayList = new ArrayList();
        if (a == null || a.size() <= 0) {
            this.w = Boolean.valueOf(false);
            return false;
        }
        for (r rVar : a) {
            if (str.equals(rVar.c)) {
                this.w = Boolean.valueOf(true);
                arrayList.add(rVar);
            }
        }
        if (arrayList.size() > 0) {
            p.a().a(arrayList);
        }
        return true;
    }

    public final synchronized void c() {
        this.r.a();
        this.s.setUserOpened(true);
        this.v.a(true);
    }

    public final synchronized void d() {
        this.r.b();
        this.s.setUserOpened(false);
        this.v.a(false);
    }

    public final void e() {
        this.r.a();
    }

    public final void f() {
        this.s.setUserOpened(false);
    }

    public final void g() {
        this.s.setUserOpened(true);
    }

    public final void h() {
        this.v.a(true);
    }

    public final void i() {
        this.v.a(false);
    }

    public final synchronized void j() {
        this.s.testNativeCrash();
    }

    public final synchronized void k() {
        b bVar = this.v;
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i < 30) {
                try {
                    x.a("try main sleep for make a test anr! try:%d/30 , kill it if you don't want to wait!", Integer.valueOf(i2));
                    z.b(5000);
                    i = i2;
                } catch (Throwable th) {
                    if (!x.a(th)) {
                        th.printStackTrace();
                    }
                    return;
                }
            }
        }
    }

    public final boolean l() {
        return this.v.a();
    }
}
