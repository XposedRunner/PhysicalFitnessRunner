package com.umeng.commonsdk.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.proguard.ab;
import com.umeng.commonsdk.proguard.j;
import com.umeng.commonsdk.proguard.m;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler.a;
import com.umeng.commonsdk.statistics.idtracking.e;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.statistics.internal.StatTracer;
import com.umeng.commonsdk.statistics.internal.d;
import com.umeng.commonsdk.statistics.noise.ABTest;
import com.umeng.commonsdk.statistics.noise.Defcon;
import com.umeng.commonsdk.statistics.proto.Response;
import java.io.File;

/* compiled from: NetWorkManager */
public class c {
    private static final int b = 1;
    private static final int c = 2;
    private static final int d = 3;
    private static final String o = "thtstart";
    private static final String p = "gkvc";
    private static final String q = "ekvc";
    String a = null;
    private final int e = 1;
    private com.umeng.commonsdk.statistics.internal.c f;
    private ImprintHandler g;
    private e h;
    private a i = null;
    private ABTest j = null;
    private Defcon k = null;
    private long l = 0;
    private int m = 0;
    private int n = 0;
    private Context r;
    private ReportStrategy s = null;

    public c(Context context) {
        this.r = context;
        this.i = ImprintHandler.getImprintService(this.r).c();
        this.k = Defcon.getService(this.r);
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(this.r);
        this.l = sharedPreferences.getLong(o, 0);
        this.m = sharedPreferences.getInt(p, 0);
        this.n = sharedPreferences.getInt(q, 0);
        this.a = UMEnvelopeBuild.imprintProperty(this.r, "track_list", null);
        this.g = ImprintHandler.getImprintService(this.r);
        this.g.a(new d() {
            /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
            public void onImprintChanged(com.umeng.commonsdk.statistics.idtracking.ImprintHandler.a r8) {
                /*
                r7 = this;
                r0 = com.umeng.commonsdk.statistics.c.this;
                r0 = r0.k;
                r0.onImprintChanged(r8);
                r8 = com.umeng.commonsdk.statistics.c.this;
                r0 = com.umeng.commonsdk.statistics.c.this;
                r0 = r0.r;
                r1 = "track_list";
                r2 = 0;
                r0 = com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(r0, r1, r2);
                r8.a = r0;
                r8 = com.umeng.commonsdk.statistics.c.this;	 Catch:{  }
                r8 = r8.r;	 Catch:{  }
                r0 = "umtt";
                r8 = com.umeng.commonsdk.framework.a.a(r8, r0, r2);	 Catch:{  }
                r0 = android.text.TextUtils.isEmpty(r8);	 Catch:{  }
                if (r0 != 0) goto L_0x0056;
            L_0x002c:
                r0 = "com.umeng.commonsdk.internal.utils.SDStorageAgent";
                r0 = java.lang.Class.forName(r0);	 Catch:{ Throwable -> 0x0056 }
                if (r0 == 0) goto L_0x0056;
            L_0x0034:
                r1 = "updateUMTT";
                r2 = 2;
                r3 = new java.lang.Class[r2];	 Catch:{ Throwable -> 0x0056 }
                r4 = android.content.Context.class;
                r5 = 0;
                r3[r5] = r4;	 Catch:{ Throwable -> 0x0056 }
                r4 = java.lang.String.class;
                r6 = 1;
                r3[r6] = r4;	 Catch:{ Throwable -> 0x0056 }
                r1 = r0.getMethod(r1, r3);	 Catch:{ Throwable -> 0x0056 }
                r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x0056 }
                r3 = com.umeng.commonsdk.statistics.c.this;	 Catch:{ Throwable -> 0x0056 }
                r3 = r3.r;	 Catch:{ Throwable -> 0x0056 }
                r2[r5] = r3;	 Catch:{ Throwable -> 0x0056 }
                r2[r6] = r8;	 Catch:{ Throwable -> 0x0056 }
                r1.invoke(r0, r2);	 Catch:{ Throwable -> 0x0056 }
            L_0x0056:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.c$AnonymousClass1.onImprintChanged(com.umeng.commonsdk.statistics.idtracking.ImprintHandler$a):void");
            }
        });
        this.h = e.a(this.r);
        this.f = new com.umeng.commonsdk.statistics.internal.c(this.r);
        this.f.a(StatTracer.getInstance(this.r));
    }

    private int a(byte[] bArr, boolean z) {
        j response = new Response();
        try {
            new m(new ab.a()).a(response, bArr);
            if (response.resp_code == 1) {
                this.g.b(response.getImprint());
                this.g.d();
            }
            StringBuilder stringBuilder;
            if (z) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("send log:");
                stringBuilder.append(response.getMsg());
                MLog.i(stringBuilder.toString());
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append("inner req:");
                stringBuilder.append(response.getMsg());
                MLog.i(stringBuilder.toString());
            }
            StringBuilder stringBuilder2;
            if (z) {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append("send log: ");
                stringBuilder2.append(response.getMsg());
                UMRTLog.i("MobclickRT", stringBuilder2.toString());
            } else {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append("inner req: ");
                stringBuilder2.append(response.getMsg());
                UMRTLog.i("MobclickRT", stringBuilder2.toString());
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(this.r, th);
        }
        return response.resp_code == 1 ? 2 : 3;
    }

    public boolean a(File file) {
        if (file == null) {
            return false;
        }
        try {
            byte[] toByteArray = UMFrUtils.toByteArray(file.getPath());
            if (toByteArray == null) {
                return false;
            }
            int i;
            com.umeng.commonsdk.statistics.internal.a.a(this.r).c(file.getName());
            boolean a = com.umeng.commonsdk.statistics.internal.a.a(this.r).a(file.getName());
            boolean b = com.umeng.commonsdk.statistics.internal.a.a(this.r).b(file.getName());
            toByteArray = this.f.a(toByteArray, a);
            if (toByteArray == null) {
                i = 1;
            } else {
                if (!a) {
                    if (!b) {
                        b = false;
                        i = a(toByteArray, b);
                    }
                }
                b = true;
                i = a(toByteArray, b);
            }
            switch (i) {
                case 1:
                    break;
                case 2:
                    this.h.d();
                    StatTracer.getInstance(this.r).saveSate();
                    break;
                case 3:
                    StatTracer.getInstance(this.r).saveSate();
                    break;
                default:
                    break;
            }
            return i == 2;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(this.r, th);
            return false;
        }
    }
}
