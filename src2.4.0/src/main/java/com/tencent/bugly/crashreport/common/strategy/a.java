package com.tencent.bugly.crashreport.common.strategy;

import android.content.Context;
import android.os.Parcelable;
import com.tencent.bugly.crashreport.biz.b;
import com.tencent.bugly.proguard.ap;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.r;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
public final class a {
    public static int a = 1000;
    private static a b;
    private static String h;
    private final List<com.tencent.bugly.a> c;
    private final w d;
    private final StrategyBean e;
    private StrategyBean f = null;
    private Context g;

    private a(Context context, List<com.tencent.bugly.a> list) {
        this.g = context;
        this.e = new StrategyBean();
        this.c = list;
        this.d = w.a();
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            aVar = b;
        }
        return aVar;
    }

    public static synchronized a a(Context context, List<com.tencent.bugly.a> list) {
        a aVar;
        synchronized (a.class) {
            if (b == null) {
                b = new a(context, list);
            }
            aVar = b;
        }
        return aVar;
    }

    public static StrategyBean d() {
        List a = p.a().a(2);
        if (a != null && a.size() > 0) {
            r rVar = (r) a.get(0);
            if (rVar.g != null) {
                return (StrategyBean) z.a(rVar.g, StrategyBean.CREATOR);
            }
        }
        return null;
    }

    public final void a(long j) {
        this.d.a(new Thread() {
            public final void run() {
                try {
                    Map a = p.a().a(a.a, null, true);
                    if (a != null) {
                        byte[] bArr = (byte[]) a.get("key_imei");
                        byte[] bArr2 = (byte[]) a.get("key_ip");
                        if (bArr != null) {
                            com.tencent.bugly.crashreport.common.info.a.a(a.this.g).e(new String(bArr));
                        }
                        if (bArr2 != null) {
                            com.tencent.bugly.crashreport.common.info.a.a(a.this.g).d(new String(bArr2));
                        }
                    }
                    a aVar = a.this;
                    a aVar2 = a.this;
                    aVar.f = a.d();
                    if (!(a.this.f == null || z.a(null) || !z.c(null))) {
                        a.this.f.r = null;
                        a.this.f.s = null;
                    }
                } catch (Throwable th) {
                    if (!x.a(th)) {
                        th.printStackTrace();
                    }
                }
                a.this.a(a.this.f, false);
            }
        }, j);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(StrategyBean strategyBean, boolean z) {
        x.c("[Strategy] Notify %s", b.class.getName());
        b.a(strategyBean, z);
        for (com.tencent.bugly.a aVar : this.c) {
            try {
                x.c("[Strategy] Notify %s", aVar.getClass().getName());
                aVar.onServerStrategyChanged(strategyBean);
            } catch (Throwable th) {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    public final void a(ap apVar) {
        if (apVar != null) {
            if (this.f == null || apVar.h != this.f.p) {
                StrategyBean strategyBean = new StrategyBean();
                strategyBean.g = apVar.a;
                strategyBean.i = apVar.c;
                strategyBean.h = apVar.b;
                if (z.a(null) || !z.c(null)) {
                    if (z.c(apVar.d)) {
                        x.c("[Strategy] Upload url changes to %s", apVar.d);
                        strategyBean.r = apVar.d;
                    }
                    if (z.c(apVar.e)) {
                        x.c("[Strategy] Exception upload url changes to %s", apVar.e);
                        strategyBean.s = apVar.e;
                    }
                }
                if (!(apVar.f == null || z.a(apVar.f.a))) {
                    strategyBean.u = apVar.f.a;
                }
                if (apVar.h != 0) {
                    strategyBean.p = apVar.h;
                }
                if (apVar.g != null && apVar.g.size() > 0) {
                    strategyBean.v = apVar.g;
                    String str = (String) apVar.g.get("B11");
                    if (str == null || !str.equals("1")) {
                        strategyBean.j = false;
                    } else {
                        strategyBean.j = true;
                    }
                    str = (String) apVar.g.get("B3");
                    if (str != null) {
                        strategyBean.y = Long.valueOf(str).longValue();
                    }
                    strategyBean.q = (long) apVar.i;
                    strategyBean.x = (long) apVar.i;
                    str = (String) apVar.g.get("B27");
                    if (str != null && str.length() > 0) {
                        try {
                            int parseInt = Integer.parseInt(str);
                            if (parseInt > 0) {
                                strategyBean.w = parseInt;
                            }
                        } catch (Exception e) {
                            if (!x.a(e)) {
                                e.printStackTrace();
                            }
                        }
                    }
                    String str2 = (String) apVar.g.get("B25");
                    if (str2 == null || !str2.equals("1")) {
                        strategyBean.l = false;
                    } else {
                        strategyBean.l = true;
                    }
                }
                x.a("[Strategy] enableCrashReport:%b, enableQuery:%b, enableUserInfo:%b, enableAnr:%b, enableBlock:%b, enableSession:%b, enableSessionTimer:%b, sessionOverTime:%d, enableCocos:%b, strategyLastUpdateTime:%d", Boolean.valueOf(strategyBean.g), Boolean.valueOf(strategyBean.i), Boolean.valueOf(strategyBean.h), Boolean.valueOf(strategyBean.j), Boolean.valueOf(strategyBean.k), Boolean.valueOf(strategyBean.n), Boolean.valueOf(strategyBean.o), Long.valueOf(strategyBean.q), Boolean.valueOf(strategyBean.l), Long.valueOf(strategyBean.p));
                this.f = strategyBean;
                p.a().b(2);
                r rVar = new r();
                rVar.b = 2;
                rVar.a = strategyBean.e;
                rVar.e = strategyBean.f;
                rVar.g = z.a((Parcelable) strategyBean);
                p.a().a(rVar);
                a(strategyBean, true);
            }
        }
    }

    public final synchronized boolean b() {
        return this.f != null;
    }

    public final StrategyBean c() {
        return this.f != null ? this.f : this.e;
    }
}
