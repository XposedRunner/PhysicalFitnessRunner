package com.tencent.bugly.crashreport.crash.anr;

import android.content.Context;
import android.os.FileObserver;
import com.tencent.bugly.crashreport.common.info.a;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import com.tencent.bugly.proguard.z;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: BUGLY */
public final class b {
    private AtomicInteger a = new AtomicInteger(0);
    private long b = -1;
    private final Context c;
    private final a d;
    private final w e;
    private final com.tencent.bugly.crashreport.common.strategy.a f;
    private final String g;
    private final com.tencent.bugly.crashreport.crash.b h;
    private FileObserver i;
    private boolean j = true;

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.crashreport.crash.anr.b$1 */
    class AnonymousClass1 extends FileObserver {
        AnonymousClass1(String str, int i) {
            super(str, 8);
        }

        public final void onEvent(int i, String str) {
            if (str != null) {
                StringBuilder stringBuilder = new StringBuilder("/data/anr/");
                stringBuilder.append(str);
                String stringBuilder2 = stringBuilder.toString();
                if (stringBuilder2.contains("trace")) {
                    b.this.a(stringBuilder2);
                    return;
                }
                x.d("not anr file %s", stringBuilder2);
            }
        }
    }

    public b(Context context, com.tencent.bugly.crashreport.common.strategy.a aVar, a aVar2, w wVar, com.tencent.bugly.crashreport.crash.b bVar) {
        this.c = z.a(context);
        this.g = context.getDir("bugly", 0).getAbsolutePath();
        this.d = aVar2;
        this.e = wVar;
        this.f = aVar;
        this.h = bVar;
    }

    private CrashDetailBean a(a aVar) {
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        try {
            crashDetailBean.B = com.tencent.bugly.crashreport.common.info.b.h();
            crashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.f();
            crashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.j();
            crashDetailBean.E = this.d.p();
            crashDetailBean.F = this.d.o();
            crashDetailBean.G = this.d.q();
            crashDetailBean.w = z.a(this.c, c.e, null);
            crashDetailBean.b = 3;
            crashDetailBean.e = this.d.h();
            crashDetailBean.f = this.d.j;
            crashDetailBean.g = this.d.w();
            crashDetailBean.m = this.d.g();
            crashDetailBean.n = "ANR_EXCEPTION";
            crashDetailBean.o = aVar.f;
            crashDetailBean.q = aVar.g;
            crashDetailBean.N = new HashMap();
            crashDetailBean.N.put("BUGLY_CR_01", aVar.e);
            int i = -1;
            if (crashDetailBean.q != null) {
                i = crashDetailBean.q.indexOf("\n");
            }
            crashDetailBean.p = i > 0 ? crashDetailBean.q.substring(0, i) : "GET_FAIL";
            crashDetailBean.r = aVar.c;
            if (crashDetailBean.q != null) {
                crashDetailBean.u = z.b(crashDetailBean.q.getBytes());
            }
            crashDetailBean.y = aVar.b;
            crashDetailBean.z = this.d.d;
            crashDetailBean.A = "main(1)";
            crashDetailBean.H = this.d.y();
            crashDetailBean.h = this.d.v();
            crashDetailBean.i = this.d.K();
            crashDetailBean.v = aVar.d;
            crashDetailBean.K = this.d.n;
            crashDetailBean.L = this.d.a;
            crashDetailBean.M = this.d.a();
            crashDetailBean.O = this.d.H();
            crashDetailBean.P = this.d.I();
            crashDetailBean.Q = this.d.B();
            crashDetailBean.R = this.d.G();
            this.h.c(crashDetailBean);
            crashDetailBean.x = y.a();
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
        }
        return crashDetailBean;
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x012f A:{Catch:{ all -> 0x0125 }} */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x015d A:{SYNTHETIC, Splitter:B:57:0x015d} */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x016e A:{SYNTHETIC, Splitter:B:65:0x016e} */
    private static boolean a(java.lang.String r9, java.lang.String r10, java.lang.String r11) {
        /*
        r0 = 1;
        r9 = com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.readTargetDumpInfo(r11, r9, r0);
        r1 = 0;
        if (r9 == 0) goto L_0x01bd;
    L_0x0008:
        r2 = r9.d;
        if (r2 == 0) goto L_0x01bd;
    L_0x000c:
        r2 = r9.d;
        r2 = r2.size();
        if (r2 > 0) goto L_0x0016;
    L_0x0014:
        goto L_0x01bd;
    L_0x0016:
        r11 = new java.io.File;
        r11.<init>(r10);
        r2 = 2;
        r3 = r11.exists();	 Catch:{ Exception -> 0x0187 }
        if (r3 != 0) goto L_0x0036;
    L_0x0022:
        r3 = r11.getParentFile();	 Catch:{ Exception -> 0x0187 }
        r3 = r3.exists();	 Catch:{ Exception -> 0x0187 }
        if (r3 != 0) goto L_0x0033;
    L_0x002c:
        r3 = r11.getParentFile();	 Catch:{ Exception -> 0x0187 }
        r3.mkdirs();	 Catch:{ Exception -> 0x0187 }
    L_0x0033:
        r11.createNewFile();	 Catch:{ Exception -> 0x0187 }
    L_0x0036:
        r3 = r11.exists();
        if (r3 == 0) goto L_0x017d;
    L_0x003c:
        r3 = r11.canWrite();
        if (r3 != 0) goto L_0x0044;
    L_0x0042:
        goto L_0x017d;
    L_0x0044:
        r10 = 0;
        r3 = new java.io.BufferedWriter;	 Catch:{ IOException -> 0x0128 }
        r4 = new java.io.FileWriter;	 Catch:{ IOException -> 0x0128 }
        r4.<init>(r11, r1);	 Catch:{ IOException -> 0x0128 }
        r3.<init>(r4);	 Catch:{ IOException -> 0x0128 }
        r10 = r9.d;	 Catch:{ IOException -> 0x0122, all -> 0x0120 }
        r11 = "main";
        r10 = r10.get(r11);	 Catch:{ IOException -> 0x0122, all -> 0x0120 }
        r10 = (java.lang.String[]) r10;	 Catch:{ IOException -> 0x0122, all -> 0x0120 }
        r11 = 3;
        if (r10 == 0) goto L_0x008e;
    L_0x005c:
        r4 = r10.length;	 Catch:{ IOException -> 0x0122, all -> 0x0120 }
        if (r4 < r11) goto L_0x008e;
    L_0x005f:
        r4 = r10[r1];	 Catch:{ IOException -> 0x0122, all -> 0x0120 }
        r5 = r10[r0];	 Catch:{ IOException -> 0x0122, all -> 0x0120 }
        r10 = r10[r2];	 Catch:{ IOException -> 0x0122, all -> 0x0120 }
        r6 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0122, all -> 0x0120 }
        r7 = "\"main\" tid=";
        r6.<init>(r7);	 Catch:{ IOException -> 0x0122, all -> 0x0120 }
        r6.append(r10);	 Catch:{ IOException -> 0x0122, all -> 0x0120 }
        r10 = " :\n";
        r6.append(r10);	 Catch:{ IOException -> 0x0122, all -> 0x0120 }
        r6.append(r4);	 Catch:{ IOException -> 0x0122, all -> 0x0120 }
        r10 = "\n";
        r6.append(r10);	 Catch:{ IOException -> 0x0122, all -> 0x0120 }
        r6.append(r5);	 Catch:{ IOException -> 0x0122, all -> 0x0120 }
        r10 = "\n\n";
        r6.append(r10);	 Catch:{ IOException -> 0x0122, all -> 0x0120 }
        r10 = r6.toString();	 Catch:{ IOException -> 0x0122, all -> 0x0120 }
        r3.write(r10);	 Catch:{ IOException -> 0x0122, all -> 0x0120 }
        r3.flush();	 Catch:{ IOException -> 0x0122, all -> 0x0120 }
    L_0x008e:
        r9 = r9.d;	 Catch:{ IOException -> 0x0122, all -> 0x0120 }
        r9 = r9.entrySet();	 Catch:{ IOException -> 0x0122, all -> 0x0120 }
        r9 = r9.iterator();	 Catch:{ IOException -> 0x0122, all -> 0x0120 }
    L_0x0098:
        r10 = r9.hasNext();	 Catch:{ IOException -> 0x0122, all -> 0x0120 }
        if (r10 == 0) goto L_0x0111;
    L_0x009e:
        r10 = r9.next();	 Catch:{ IOException -> 0x0122, all -> 0x0120 }
        r10 = (java.util.Map.Entry) r10;	 Catch:{ IOException -> 0x0122, all -> 0x0120 }
        r4 = r10.getKey();	 Catch:{ IOException -> 0x0122, all -> 0x0120 }
        r4 = (java.lang.String) r4;	 Catch:{ IOException -> 0x0122, all -> 0x0120 }
        r5 = "main";
        r4 = r4.equals(r5);	 Catch:{ IOException -> 0x0122, all -> 0x0120 }
        if (r4 != 0) goto L_0x0098;
    L_0x00b2:
        r4 = r10.getValue();	 Catch:{ IOException -> 0x0122, all -> 0x0120 }
        if (r4 == 0) goto L_0x0098;
    L_0x00b8:
        r4 = r10.getValue();	 Catch:{ IOException -> 0x0122, all -> 0x0120 }
        r4 = (java.lang.String[]) r4;	 Catch:{ IOException -> 0x0122, all -> 0x0120 }
        r4 = r4.length;	 Catch:{ IOException -> 0x0122, all -> 0x0120 }
        if (r4 < r11) goto L_0x0098;
    L_0x00c1:
        r4 = r10.getValue();	 Catch:{ IOException -> 0x0122, all -> 0x0120 }
        r4 = (java.lang.String[]) r4;	 Catch:{ IOException -> 0x0122, all -> 0x0120 }
        r4 = r4[r1];	 Catch:{ IOException -> 0x0122, all -> 0x0120 }
        r5 = r10.getValue();	 Catch:{ IOException -> 0x0122, all -> 0x0120 }
        r5 = (java.lang.String[]) r5;	 Catch:{ IOException -> 0x0122, all -> 0x0120 }
        r5 = r5[r0];	 Catch:{ IOException -> 0x0122, all -> 0x0120 }
        r6 = r10.getValue();	 Catch:{ IOException -> 0x0122, all -> 0x0120 }
        r6 = (java.lang.String[]) r6;	 Catch:{ IOException -> 0x0122, all -> 0x0120 }
        r6 = r6[r2];	 Catch:{ IOException -> 0x0122, all -> 0x0120 }
        r7 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0122, all -> 0x0120 }
        r8 = "\"";
        r7.<init>(r8);	 Catch:{ IOException -> 0x0122, all -> 0x0120 }
        r10 = r10.getKey();	 Catch:{ IOException -> 0x0122, all -> 0x0120 }
        r10 = (java.lang.String) r10;	 Catch:{ IOException -> 0x0122, all -> 0x0120 }
        r7.append(r10);	 Catch:{ IOException -> 0x0122, all -> 0x0120 }
        r10 = "\" tid=";
        r7.append(r10);	 Catch:{ IOException -> 0x0122, all -> 0x0120 }
        r7.append(r6);	 Catch:{ IOException -> 0x0122, all -> 0x0120 }
        r10 = " :\n";
        r7.append(r10);	 Catch:{ IOException -> 0x0122, all -> 0x0120 }
        r7.append(r4);	 Catch:{ IOException -> 0x0122, all -> 0x0120 }
        r10 = "\n";
        r7.append(r10);	 Catch:{ IOException -> 0x0122, all -> 0x0120 }
        r7.append(r5);	 Catch:{ IOException -> 0x0122, all -> 0x0120 }
        r10 = "\n\n";
        r7.append(r10);	 Catch:{ IOException -> 0x0122, all -> 0x0120 }
        r10 = r7.toString();	 Catch:{ IOException -> 0x0122, all -> 0x0120 }
        r3.write(r10);	 Catch:{ IOException -> 0x0122, all -> 0x0120 }
        r3.flush();	 Catch:{ IOException -> 0x0122, all -> 0x0120 }
        goto L_0x0098;
    L_0x0111:
        r3.close();	 Catch:{ IOException -> 0x0115 }
        goto L_0x011f;
    L_0x0115:
        r9 = move-exception;
        r10 = com.tencent.bugly.proguard.x.a(r9);
        if (r10 != 0) goto L_0x011f;
    L_0x011c:
        r9.printStackTrace();
    L_0x011f:
        return r0;
    L_0x0120:
        r9 = move-exception;
        goto L_0x016c;
    L_0x0122:
        r9 = move-exception;
        r10 = r3;
        goto L_0x0129;
    L_0x0125:
        r9 = move-exception;
        r3 = r10;
        goto L_0x016c;
    L_0x0128:
        r9 = move-exception;
    L_0x0129:
        r11 = com.tencent.bugly.proguard.x.a(r9);	 Catch:{ all -> 0x0125 }
        if (r11 != 0) goto L_0x0132;
    L_0x012f:
        r9.printStackTrace();	 Catch:{ all -> 0x0125 }
    L_0x0132:
        r11 = "dump trace fail %s";
        r0 = new java.lang.Object[r0];	 Catch:{ all -> 0x0125 }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0125 }
        r2.<init>();	 Catch:{ all -> 0x0125 }
        r3 = r9.getClass();	 Catch:{ all -> 0x0125 }
        r3 = r3.getName();	 Catch:{ all -> 0x0125 }
        r2.append(r3);	 Catch:{ all -> 0x0125 }
        r3 = ":";
        r2.append(r3);	 Catch:{ all -> 0x0125 }
        r9 = r9.getMessage();	 Catch:{ all -> 0x0125 }
        r2.append(r9);	 Catch:{ all -> 0x0125 }
        r9 = r2.toString();	 Catch:{ all -> 0x0125 }
        r0[r1] = r9;	 Catch:{ all -> 0x0125 }
        com.tencent.bugly.proguard.x.e(r11, r0);	 Catch:{ all -> 0x0125 }
        if (r10 == 0) goto L_0x016b;
    L_0x015d:
        r10.close();	 Catch:{ IOException -> 0x0161 }
        goto L_0x016b;
    L_0x0161:
        r9 = move-exception;
        r10 = com.tencent.bugly.proguard.x.a(r9);
        if (r10 != 0) goto L_0x016b;
    L_0x0168:
        r9.printStackTrace();
    L_0x016b:
        return r1;
    L_0x016c:
        if (r3 == 0) goto L_0x017c;
    L_0x016e:
        r3.close();	 Catch:{ IOException -> 0x0172 }
        goto L_0x017c;
    L_0x0172:
        r10 = move-exception;
        r11 = com.tencent.bugly.proguard.x.a(r10);
        if (r11 != 0) goto L_0x017c;
    L_0x0179:
        r10.printStackTrace();
    L_0x017c:
        throw r9;
    L_0x017d:
        r9 = "backup file create fail %s";
        r11 = new java.lang.Object[r0];
        r11[r1] = r10;
        com.tencent.bugly.proguard.x.e(r9, r11);
        return r1;
    L_0x0187:
        r9 = move-exception;
        r11 = com.tencent.bugly.proguard.x.a(r9);
        if (r11 != 0) goto L_0x0191;
    L_0x018e:
        r9.printStackTrace();
    L_0x0191:
        r11 = "backup file create error! %s  %s";
        r2 = new java.lang.Object[r2];
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = r9.getClass();
        r4 = r4.getName();
        r3.append(r4);
        r4 = ":";
        r3.append(r4);
        r9 = r9.getMessage();
        r3.append(r9);
        r9 = r3.toString();
        r2[r1] = r9;
        r2[r0] = r10;
        com.tencent.bugly.proguard.x.e(r11, r2);
        return r1;
    L_0x01bd:
        r9 = "not found trace dump for %s";
        r10 = new java.lang.Object[r0];
        r10[r1] = r11;
        com.tencent.bugly.proguard.x.e(r9, r10);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.anr.b.a(java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    private synchronized void b(boolean z) {
        if (z) {
            c();
        } else {
            d();
        }
    }

    private synchronized void c() {
        if (e()) {
            x.d("start when started!", new Object[0]);
            return;
        }
        this.i = new AnonymousClass1("/data/anr/", 8);
        try {
            this.i.startWatching();
            x.a("start anr monitor!", new Object[0]);
            this.e.a(new Runnable() {
                public final void run() {
                    b.this.b();
                }
            });
        } catch (Throwable th) {
            this.i = null;
            x.d("start anr monitor failed!", new Object[0]);
            if (!x.a(th)) {
                th.printStackTrace();
            }
        }
    }

    private synchronized void c(boolean z) {
        if (this.j != z) {
            x.a("user change anr %b", Boolean.valueOf(z));
            this.j = z;
        }
    }

    private synchronized void d() {
        if (e()) {
            try {
                this.i.stopWatching();
                this.i = null;
                x.d("close anr monitor!", new Object[0]);
                return;
            } catch (Throwable th) {
                x.d("stop anr monitor failed!", new Object[0]);
                if (!x.a(th)) {
                    th.printStackTrace();
                }
                return;
            }
        }
        x.d("close when closed!", new Object[0]);
    }

    private synchronized boolean e() {
        return this.i != null;
    }

    private synchronized boolean f() {
        return this.j;
    }

    /* JADX WARNING: Missing block: B:18:0x0042, code skipped:
            return;
     */
    public final synchronized void a(com.tencent.bugly.crashreport.common.strategy.StrategyBean r6) {
        /*
        r5 = this;
        monitor-enter(r5);
        if (r6 != 0) goto L_0x0005;
    L_0x0003:
        monitor-exit(r5);
        return;
    L_0x0005:
        r0 = r6.j;	 Catch:{ all -> 0x0043 }
        r1 = r5.e();	 Catch:{ all -> 0x0043 }
        r2 = 0;
        r3 = 1;
        if (r0 == r1) goto L_0x001e;
    L_0x000f:
        r0 = "server anr changed to %b";
        r1 = new java.lang.Object[r3];	 Catch:{ all -> 0x0043 }
        r4 = r6.j;	 Catch:{ all -> 0x0043 }
        r4 = java.lang.Boolean.valueOf(r4);	 Catch:{ all -> 0x0043 }
        r1[r2] = r4;	 Catch:{ all -> 0x0043 }
        com.tencent.bugly.proguard.x.d(r0, r1);	 Catch:{ all -> 0x0043 }
    L_0x001e:
        r6 = r6.j;	 Catch:{ all -> 0x0043 }
        if (r6 == 0) goto L_0x002a;
    L_0x0022:
        r6 = r5.f();	 Catch:{ all -> 0x0043 }
        if (r6 == 0) goto L_0x002a;
    L_0x0028:
        r6 = r3;
        goto L_0x002b;
    L_0x002a:
        r6 = r2;
    L_0x002b:
        r0 = r5.e();	 Catch:{ all -> 0x0043 }
        if (r6 == r0) goto L_0x0041;
    L_0x0031:
        r0 = "anr changed to %b";
        r1 = new java.lang.Object[r3];	 Catch:{ all -> 0x0043 }
        r3 = java.lang.Boolean.valueOf(r6);	 Catch:{ all -> 0x0043 }
        r1[r2] = r3;	 Catch:{ all -> 0x0043 }
        com.tencent.bugly.proguard.x.a(r0, r1);	 Catch:{ all -> 0x0043 }
        r5.b(r6);	 Catch:{ all -> 0x0043 }
    L_0x0041:
        monitor-exit(r5);
        return;
    L_0x0043:
        r6 = move-exception;
        monitor-exit(r5);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.anr.b.a(com.tencent.bugly.crashreport.common.strategy.StrategyBean):void");
    }

    /*  JADX ERROR: ConcurrentModificationException in pass: EliminatePhiNodes
        java.util.ConcurrentModificationException
        	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1042)
        	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:996)
        	at jadx.core.dex.visitors.ssa.EliminatePhiNodes.replaceMerge(EliminatePhiNodes.java:114)
        	at jadx.core.dex.visitors.ssa.EliminatePhiNodes.replaceMergeInstructions(EliminatePhiNodes.java:68)
        	at jadx.core.dex.visitors.ssa.EliminatePhiNodes.visit(EliminatePhiNodes.java:31)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:32)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
        */
    public final void a(java.lang.String r20) {
        /*
        r19 = this;
        r1 = r19;
        r2 = r20;
        monitor-enter(r19);
        r3 = r1.a;	 Catch:{ all -> 0x02a8 }
        r3 = r3.get();	 Catch:{ all -> 0x02a8 }
        r4 = 0;	 Catch:{ all -> 0x02a8 }
        if (r3 == 0) goto L_0x0017;	 Catch:{ all -> 0x02a8 }
    L_0x000e:
        r2 = "trace started return ";	 Catch:{ all -> 0x02a8 }
        r3 = new java.lang.Object[r4];	 Catch:{ all -> 0x02a8 }
        com.tencent.bugly.proguard.x.c(r2, r3);	 Catch:{ all -> 0x02a8 }
        monitor-exit(r19);	 Catch:{ all -> 0x02a8 }
        return;	 Catch:{ all -> 0x02a8 }
    L_0x0017:
        r3 = r1.a;	 Catch:{ all -> 0x02a8 }
        r5 = 1;	 Catch:{ all -> 0x02a8 }
        r3.set(r5);	 Catch:{ all -> 0x02a8 }
        monitor-exit(r19);	 Catch:{ all -> 0x02a8 }
        r3 = "read trace first dump for create time!";	 Catch:{ Throwable -> 0x0284 }
        r6 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x0284 }
        com.tencent.bugly.proguard.x.c(r3, r6);	 Catch:{ Throwable -> 0x0284 }
        r3 = com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.readFirstDumpInfo(r2, r4);	 Catch:{ Throwable -> 0x0284 }
        r6 = -1;	 Catch:{ Throwable -> 0x0284 }
        if (r3 == 0) goto L_0x0030;	 Catch:{ Throwable -> 0x0284 }
    L_0x002d:
        r8 = r3.c;	 Catch:{ Throwable -> 0x0284 }
        goto L_0x0031;	 Catch:{ Throwable -> 0x0284 }
    L_0x0030:
        r8 = r6;	 Catch:{ Throwable -> 0x0284 }
    L_0x0031:
        r3 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1));	 Catch:{ Throwable -> 0x0284 }
        if (r3 != 0) goto L_0x0040;	 Catch:{ Throwable -> 0x0284 }
    L_0x0035:
        r3 = "trace dump fail could not get time!";	 Catch:{ Throwable -> 0x0284 }
        r6 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x0284 }
        com.tencent.bugly.proguard.x.d(r3, r6);	 Catch:{ Throwable -> 0x0284 }
        r8 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x0284 }
    L_0x0040:
        r6 = r1.b;	 Catch:{ Throwable -> 0x0284 }
        r10 = r8 - r6;	 Catch:{ Throwable -> 0x0284 }
        r6 = java.lang.Math.abs(r10);	 Catch:{ Throwable -> 0x0284 }
        r10 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;	 Catch:{ Throwable -> 0x0284 }
        r3 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1));	 Catch:{ Throwable -> 0x0284 }
        if (r3 >= 0) goto L_0x0063;	 Catch:{ Throwable -> 0x0284 }
    L_0x004e:
        r2 = "should not process ANR too Fre in %d";	 Catch:{ Throwable -> 0x0284 }
        r3 = new java.lang.Object[r5];	 Catch:{ Throwable -> 0x0284 }
        r6 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;	 Catch:{ Throwable -> 0x0284 }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Throwable -> 0x0284 }
        r3[r4] = r6;	 Catch:{ Throwable -> 0x0284 }
        com.tencent.bugly.proguard.x.d(r2, r3);	 Catch:{ Throwable -> 0x0284 }
    L_0x005d:
        r2 = r1.a;
        r2.set(r4);
        return;
    L_0x0063:
        r1.b = r8;	 Catch:{ Throwable -> 0x0284 }
        r3 = r1.a;	 Catch:{ Throwable -> 0x0284 }
        r3.set(r5);	 Catch:{ Throwable -> 0x0284 }
        r3 = com.tencent.bugly.crashreport.crash.c.f;	 Catch:{ Throwable -> 0x0273 }
        r3 = com.tencent.bugly.proguard.z.a(r3, r4);	 Catch:{ Throwable -> 0x0273 }
        if (r3 == 0) goto L_0x026a;
    L_0x0072:
        r6 = r3.size();	 Catch:{ Throwable -> 0x0284 }
        if (r6 > 0) goto L_0x007a;	 Catch:{ Throwable -> 0x0284 }
    L_0x0078:
        goto L_0x026a;	 Catch:{ Throwable -> 0x0284 }
    L_0x007a:
        r6 = r1.c;	 Catch:{ Throwable -> 0x0284 }
        r7 = "to find!";	 Catch:{ Throwable -> 0x0284 }
        r10 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x0284 }
        com.tencent.bugly.proguard.x.c(r7, r10);	 Catch:{ Throwable -> 0x0284 }
        r7 = "activity";	 Catch:{ Throwable -> 0x0284 }
        r6 = r6.getSystemService(r7);	 Catch:{ Throwable -> 0x0284 }
        r6 = (android.app.ActivityManager) r6;	 Catch:{ Throwable -> 0x0284 }
        r7 = r4;	 Catch:{ Throwable -> 0x0284 }
    L_0x008c:
        r12 = "waiting!";	 Catch:{ Throwable -> 0x0284 }
        r13 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x0284 }
        com.tencent.bugly.proguard.x.c(r12, r13);	 Catch:{ Throwable -> 0x0284 }
        r12 = r6.getProcessesInErrorState();	 Catch:{ Throwable -> 0x0284 }
        r13 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;	 Catch:{ Throwable -> 0x0284 }
        r15 = 2;	 Catch:{ Throwable -> 0x0284 }
        if (r12 == 0) goto L_0x00bc;	 Catch:{ Throwable -> 0x0284 }
    L_0x009c:
        r12 = r12.iterator();	 Catch:{ Throwable -> 0x0284 }
    L_0x00a0:
        r16 = r12.hasNext();	 Catch:{ Throwable -> 0x0284 }
        if (r16 == 0) goto L_0x00bc;	 Catch:{ Throwable -> 0x0284 }
    L_0x00a6:
        r16 = r12.next();	 Catch:{ Throwable -> 0x0284 }
        r5 = r16;	 Catch:{ Throwable -> 0x0284 }
        r5 = (android.app.ActivityManager.ProcessErrorStateInfo) r5;	 Catch:{ Throwable -> 0x0284 }
        r10 = r5.condition;	 Catch:{ Throwable -> 0x0284 }
        if (r10 != r15) goto L_0x00ba;	 Catch:{ Throwable -> 0x0284 }
    L_0x00b2:
        r6 = "found!";	 Catch:{ Throwable -> 0x0284 }
        r7 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x0284 }
        com.tencent.bugly.proguard.x.c(r6, r7);	 Catch:{ Throwable -> 0x0284 }
        goto L_0x00d0;	 Catch:{ Throwable -> 0x0284 }
    L_0x00ba:
        r5 = 1;	 Catch:{ Throwable -> 0x0284 }
        goto L_0x00a0;	 Catch:{ Throwable -> 0x0284 }
    L_0x00bc:
        com.tencent.bugly.proguard.z.b(r13);	 Catch:{ Throwable -> 0x0284 }
        r5 = r7 + 1;	 Catch:{ Throwable -> 0x0284 }
        r10 = (long) r7;	 Catch:{ Throwable -> 0x0284 }
        r17 = 20;	 Catch:{ Throwable -> 0x0284 }
        r7 = (r10 > r17 ? 1 : (r10 == r17 ? 0 : -1));	 Catch:{ Throwable -> 0x0284 }
        if (r7 < 0) goto L_0x0266;	 Catch:{ Throwable -> 0x0284 }
    L_0x00c8:
        r5 = "end!";	 Catch:{ Throwable -> 0x0284 }
        r6 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x0284 }
        com.tencent.bugly.proguard.x.c(r5, r6);	 Catch:{ Throwable -> 0x0284 }
        r5 = 0;	 Catch:{ Throwable -> 0x0284 }
    L_0x00d0:
        if (r5 != 0) goto L_0x00da;	 Catch:{ Throwable -> 0x0284 }
    L_0x00d2:
        r2 = "proc state is unvisiable!";	 Catch:{ Throwable -> 0x0284 }
        r3 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x0284 }
        com.tencent.bugly.proguard.x.c(r2, r3);	 Catch:{ Throwable -> 0x0284 }
        goto L_0x005d;	 Catch:{ Throwable -> 0x0284 }
    L_0x00da:
        r6 = r5.pid;	 Catch:{ Throwable -> 0x0284 }
        r7 = android.os.Process.myPid();	 Catch:{ Throwable -> 0x0284 }
        if (r6 == r7) goto L_0x00f0;	 Catch:{ Throwable -> 0x0284 }
    L_0x00e2:
        r2 = "not mind proc!";	 Catch:{ Throwable -> 0x0284 }
        r3 = 1;	 Catch:{ Throwable -> 0x0284 }
        r6 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x0284 }
        r3 = r5.processName;	 Catch:{ Throwable -> 0x0284 }
        r6[r4] = r3;	 Catch:{ Throwable -> 0x0284 }
        com.tencent.bugly.proguard.x.c(r2, r6);	 Catch:{ Throwable -> 0x0284 }
        goto L_0x005d;	 Catch:{ Throwable -> 0x0284 }
    L_0x00f0:
        r6 = "found visiable anr , start to process!";	 Catch:{ Throwable -> 0x0284 }
        r7 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x0284 }
        com.tencent.bugly.proguard.x.a(r6, r7);	 Catch:{ Throwable -> 0x0284 }
        r6 = r1.c;	 Catch:{ Throwable -> 0x0284 }
        r7 = r1.f;	 Catch:{ Throwable -> 0x0284 }
        r7.c();	 Catch:{ Throwable -> 0x0284 }
        r7 = r1.f;	 Catch:{ Throwable -> 0x0284 }
        r7 = r7.b();	 Catch:{ Throwable -> 0x0284 }
        if (r7 != 0) goto L_0x011f;	 Catch:{ Throwable -> 0x0284 }
    L_0x0106:
        r7 = "waiting for remote sync";	 Catch:{ Throwable -> 0x0284 }
        r10 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x0284 }
        com.tencent.bugly.proguard.x.e(r7, r10);	 Catch:{ Throwable -> 0x0284 }
        r7 = r4;	 Catch:{ Throwable -> 0x0284 }
    L_0x010e:
        r10 = r1.f;	 Catch:{ Throwable -> 0x0284 }
        r10 = r10.b();	 Catch:{ Throwable -> 0x0284 }
        if (r10 != 0) goto L_0x011f;	 Catch:{ Throwable -> 0x0284 }
    L_0x0116:
        com.tencent.bugly.proguard.z.b(r13);	 Catch:{ Throwable -> 0x0284 }
        r7 = r7 + 500;	 Catch:{ Throwable -> 0x0284 }
        r10 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;	 Catch:{ Throwable -> 0x0284 }
        if (r7 < r10) goto L_0x010e;	 Catch:{ Throwable -> 0x0284 }
    L_0x011f:
        r7 = new java.io.File;	 Catch:{ Throwable -> 0x0284 }
        r6 = r6.getFilesDir();	 Catch:{ Throwable -> 0x0284 }
        r10 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0284 }
        r11 = "bugly/bugly_trace_";	 Catch:{ Throwable -> 0x0284 }
        r10.<init>(r11);	 Catch:{ Throwable -> 0x0284 }
        r10.append(r8);	 Catch:{ Throwable -> 0x0284 }
        r11 = ".txt";	 Catch:{ Throwable -> 0x0284 }
        r10.append(r11);	 Catch:{ Throwable -> 0x0284 }
        r10 = r10.toString();	 Catch:{ Throwable -> 0x0284 }
        r7.<init>(r6, r10);	 Catch:{ Throwable -> 0x0284 }
        r6 = new com.tencent.bugly.crashreport.crash.anr.a;	 Catch:{ Throwable -> 0x0284 }
        r6.<init>();	 Catch:{ Throwable -> 0x0284 }
        r6.c = r8;	 Catch:{ Throwable -> 0x0284 }
        r7 = r7.getAbsolutePath();	 Catch:{ Throwable -> 0x0284 }
        r6.d = r7;	 Catch:{ Throwable -> 0x0284 }
        r7 = r5.processName;	 Catch:{ Throwable -> 0x0284 }
        r6.a = r7;	 Catch:{ Throwable -> 0x0284 }
        r7 = r5.shortMsg;	 Catch:{ Throwable -> 0x0284 }
        r6.f = r7;	 Catch:{ Throwable -> 0x0284 }
        r5 = r5.longMsg;	 Catch:{ Throwable -> 0x0284 }
        r6.e = r5;	 Catch:{ Throwable -> 0x0284 }
        r6.b = r3;	 Catch:{ Throwable -> 0x0284 }
        if (r3 == 0) goto L_0x017d;	 Catch:{ Throwable -> 0x0284 }
    L_0x0158:
        r5 = r3.keySet();	 Catch:{ Throwable -> 0x0284 }
        r5 = r5.iterator();	 Catch:{ Throwable -> 0x0284 }
    L_0x0160:
        r7 = r5.hasNext();	 Catch:{ Throwable -> 0x0284 }
        if (r7 == 0) goto L_0x017d;	 Catch:{ Throwable -> 0x0284 }
    L_0x0166:
        r7 = r5.next();	 Catch:{ Throwable -> 0x0284 }
        r7 = (java.lang.String) r7;	 Catch:{ Throwable -> 0x0284 }
        r8 = "main(";	 Catch:{ Throwable -> 0x0284 }
        r8 = r7.startsWith(r8);	 Catch:{ Throwable -> 0x0284 }
        if (r8 == 0) goto L_0x0160;	 Catch:{ Throwable -> 0x0284 }
    L_0x0174:
        r7 = r3.get(r7);	 Catch:{ Throwable -> 0x0284 }
        r7 = (java.lang.String) r7;	 Catch:{ Throwable -> 0x0284 }
        r6.g = r7;	 Catch:{ Throwable -> 0x0284 }
        goto L_0x0160;	 Catch:{ Throwable -> 0x0284 }
    L_0x017d:
        r3 = "anr tm:%d\ntr:%s\nproc:%s\nsMsg:%s\n lMsg:%s\n threads:%d";	 Catch:{ Throwable -> 0x0284 }
        r5 = 6;	 Catch:{ Throwable -> 0x0284 }
        r5 = new java.lang.Object[r5];	 Catch:{ Throwable -> 0x0284 }
        r7 = r6.c;	 Catch:{ Throwable -> 0x0284 }
        r7 = java.lang.Long.valueOf(r7);	 Catch:{ Throwable -> 0x0284 }
        r5[r4] = r7;	 Catch:{ Throwable -> 0x0284 }
        r7 = r6.d;	 Catch:{ Throwable -> 0x0284 }
        r8 = 1;	 Catch:{ Throwable -> 0x0284 }
        r5[r8] = r7;	 Catch:{ Throwable -> 0x0284 }
        r7 = r6.a;	 Catch:{ Throwable -> 0x0284 }
        r5[r15] = r7;	 Catch:{ Throwable -> 0x0284 }
        r7 = r6.f;	 Catch:{ Throwable -> 0x0284 }
        r8 = 3;	 Catch:{ Throwable -> 0x0284 }
        r5[r8] = r7;	 Catch:{ Throwable -> 0x0284 }
        r7 = 4;	 Catch:{ Throwable -> 0x0284 }
        r9 = r6.e;	 Catch:{ Throwable -> 0x0284 }
        r5[r7] = r9;	 Catch:{ Throwable -> 0x0284 }
        r7 = 5;	 Catch:{ Throwable -> 0x0284 }
        r9 = r6.b;	 Catch:{ Throwable -> 0x0284 }
        if (r9 != 0) goto L_0x01a4;	 Catch:{ Throwable -> 0x0284 }
    L_0x01a2:
        r9 = r4;	 Catch:{ Throwable -> 0x0284 }
        goto L_0x01aa;	 Catch:{ Throwable -> 0x0284 }
    L_0x01a4:
        r9 = r6.b;	 Catch:{ Throwable -> 0x0284 }
        r9 = r9.size();	 Catch:{ Throwable -> 0x0284 }
    L_0x01aa:
        r9 = java.lang.Integer.valueOf(r9);	 Catch:{ Throwable -> 0x0284 }
        r5[r7] = r9;	 Catch:{ Throwable -> 0x0284 }
        com.tencent.bugly.proguard.x.c(r3, r5);	 Catch:{ Throwable -> 0x0284 }
        r3 = r1.f;	 Catch:{ Throwable -> 0x0284 }
        r3 = r3.b();	 Catch:{ Throwable -> 0x0284 }
        if (r3 != 0) goto L_0x01d3;	 Catch:{ Throwable -> 0x0284 }
    L_0x01bb:
        r2 = "crash report sync remote fail, will not upload to Bugly , print local for helpful!";	 Catch:{ Throwable -> 0x0284 }
        r3 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x0284 }
        com.tencent.bugly.proguard.x.e(r2, r3);	 Catch:{ Throwable -> 0x0284 }
        r7 = "ANR";	 Catch:{ Throwable -> 0x0284 }
        r8 = com.tencent.bugly.proguard.z.a();	 Catch:{ Throwable -> 0x0284 }
        r9 = r6.a;	 Catch:{ Throwable -> 0x0284 }
        r10 = 0;	 Catch:{ Throwable -> 0x0284 }
        r11 = r6.e;	 Catch:{ Throwable -> 0x0284 }
        r12 = 0;	 Catch:{ Throwable -> 0x0284 }
        com.tencent.bugly.crashreport.crash.b.a(r7, r8, r9, r10, r11, r12);	 Catch:{ Throwable -> 0x0284 }
        goto L_0x0260;	 Catch:{ Throwable -> 0x0284 }
    L_0x01d3:
        r3 = r1.f;	 Catch:{ Throwable -> 0x0284 }
        r3 = r3.c();	 Catch:{ Throwable -> 0x0284 }
        r3 = r3.j;	 Catch:{ Throwable -> 0x0284 }
        if (r3 != 0) goto L_0x01e6;	 Catch:{ Throwable -> 0x0284 }
    L_0x01dd:
        r2 = "ANR Report is closed!";	 Catch:{ Throwable -> 0x0284 }
        r3 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x0284 }
        com.tencent.bugly.proguard.x.d(r2, r3);	 Catch:{ Throwable -> 0x0284 }
        goto L_0x0260;	 Catch:{ Throwable -> 0x0284 }
    L_0x01e6:
        r3 = "found visiable anr , start to upload!";	 Catch:{ Throwable -> 0x0284 }
        r5 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x0284 }
        com.tencent.bugly.proguard.x.a(r3, r5);	 Catch:{ Throwable -> 0x0284 }
        r3 = r1.a(r6);	 Catch:{ Throwable -> 0x0284 }
        if (r3 != 0) goto L_0x01fb;	 Catch:{ Throwable -> 0x0284 }
    L_0x01f3:
        r2 = "pack anr fail!";	 Catch:{ Throwable -> 0x0284 }
        r3 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x0284 }
        com.tencent.bugly.proguard.x.e(r2, r3);	 Catch:{ Throwable -> 0x0284 }
        goto L_0x0260;	 Catch:{ Throwable -> 0x0284 }
    L_0x01fb:
        r5 = com.tencent.bugly.crashreport.crash.c.a();	 Catch:{ Throwable -> 0x0284 }
        r5.a(r3);	 Catch:{ Throwable -> 0x0284 }
        r9 = r3.a;	 Catch:{ Throwable -> 0x0284 }
        r11 = 0;	 Catch:{ Throwable -> 0x0284 }
        r5 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1));	 Catch:{ Throwable -> 0x0284 }
        if (r5 < 0) goto L_0x0212;	 Catch:{ Throwable -> 0x0284 }
    L_0x020a:
        r5 = "backup anr record success!";	 Catch:{ Throwable -> 0x0284 }
        r7 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x0284 }
        com.tencent.bugly.proguard.x.a(r5, r7);	 Catch:{ Throwable -> 0x0284 }
        goto L_0x0219;	 Catch:{ Throwable -> 0x0284 }
    L_0x0212:
        r5 = "backup anr record fail!";	 Catch:{ Throwable -> 0x0284 }
        r7 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x0284 }
        com.tencent.bugly.proguard.x.d(r5, r7);	 Catch:{ Throwable -> 0x0284 }
    L_0x0219:
        if (r2 == 0) goto L_0x023c;	 Catch:{ Throwable -> 0x0284 }
    L_0x021b:
        r5 = new java.io.File;	 Catch:{ Throwable -> 0x0284 }
        r5.<init>(r2);	 Catch:{ Throwable -> 0x0284 }
        r5 = r5.exists();	 Catch:{ Throwable -> 0x0284 }
        if (r5 == 0) goto L_0x023c;	 Catch:{ Throwable -> 0x0284 }
    L_0x0226:
        r5 = r1.a;	 Catch:{ Throwable -> 0x0284 }
        r5.set(r8);	 Catch:{ Throwable -> 0x0284 }
        r5 = r6.d;	 Catch:{ Throwable -> 0x0284 }
        r7 = r6.a;	 Catch:{ Throwable -> 0x0284 }
        r2 = a(r2, r5, r7);	 Catch:{ Throwable -> 0x0284 }
        if (r2 == 0) goto L_0x023c;	 Catch:{ Throwable -> 0x0284 }
    L_0x0235:
        r2 = "backup trace success";	 Catch:{ Throwable -> 0x0284 }
        r5 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x0284 }
        com.tencent.bugly.proguard.x.a(r2, r5);	 Catch:{ Throwable -> 0x0284 }
    L_0x023c:
        r9 = "ANR";	 Catch:{ Throwable -> 0x0284 }
        r10 = com.tencent.bugly.proguard.z.a();	 Catch:{ Throwable -> 0x0284 }
        r11 = r6.a;	 Catch:{ Throwable -> 0x0284 }
        r12 = 0;	 Catch:{ Throwable -> 0x0284 }
        r13 = r6.e;	 Catch:{ Throwable -> 0x0284 }
        r14 = r3;	 Catch:{ Throwable -> 0x0284 }
        com.tencent.bugly.crashreport.crash.b.a(r9, r10, r11, r12, r13, r14);	 Catch:{ Throwable -> 0x0284 }
        r2 = r1.h;	 Catch:{ Throwable -> 0x0284 }
        r2 = r2.a(r3);	 Catch:{ Throwable -> 0x0284 }
        if (r2 != 0) goto L_0x025b;	 Catch:{ Throwable -> 0x0284 }
    L_0x0253:
        r2 = r1.h;	 Catch:{ Throwable -> 0x0284 }
        r5 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;	 Catch:{ Throwable -> 0x0284 }
        r7 = 1;	 Catch:{ Throwable -> 0x0284 }
        r2.a(r3, r5, r7);	 Catch:{ Throwable -> 0x0284 }
    L_0x025b:
        r2 = r1.h;	 Catch:{ Throwable -> 0x0284 }
        r2.b(r3);	 Catch:{ Throwable -> 0x0284 }
    L_0x0260:
        r2 = r1.a;
        r2.set(r4);
        return;
    L_0x0266:
        r7 = r5;
        r5 = 1;
        goto L_0x008c;
    L_0x026a:
        r2 = "can't get all thread skip this anr";	 Catch:{ Throwable -> 0x0284 }
        r3 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x0284 }
        com.tencent.bugly.proguard.x.d(r2, r3);	 Catch:{ Throwable -> 0x0284 }
        goto L_0x005d;	 Catch:{ Throwable -> 0x0284 }
    L_0x0273:
        r0 = move-exception;	 Catch:{ Throwable -> 0x0284 }
        r2 = r0;	 Catch:{ Throwable -> 0x0284 }
        com.tencent.bugly.proguard.x.a(r2);	 Catch:{ Throwable -> 0x0284 }
        r2 = "get all thread stack fail!";	 Catch:{ Throwable -> 0x0284 }
        r3 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x0284 }
        com.tencent.bugly.proguard.x.e(r2, r3);	 Catch:{ Throwable -> 0x0284 }
        goto L_0x005d;
    L_0x0281:
        r0 = move-exception;
        r2 = r0;
        goto L_0x02a2;
    L_0x0284:
        r0 = move-exception;
        r2 = r0;
        r3 = com.tencent.bugly.proguard.x.a(r2);	 Catch:{ all -> 0x0281 }
        if (r3 != 0) goto L_0x028f;	 Catch:{ all -> 0x0281 }
    L_0x028c:
        r2.printStackTrace();	 Catch:{ all -> 0x0281 }
    L_0x028f:
        r3 = "handle anr error %s";	 Catch:{ all -> 0x0281 }
        r5 = 1;	 Catch:{ all -> 0x0281 }
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0281 }
        r2 = r2.getClass();	 Catch:{ all -> 0x0281 }
        r2 = r2.toString();	 Catch:{ all -> 0x0281 }
        r5[r4] = r2;	 Catch:{ all -> 0x0281 }
        com.tencent.bugly.proguard.x.e(r3, r5);	 Catch:{ all -> 0x0281 }
        goto L_0x0260;
    L_0x02a2:
        r3 = r1.a;
        r3.set(r4);
        throw r2;
    L_0x02a8:
        r0 = move-exception;
        r2 = r0;
        monitor-exit(r19);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.anr.b.a(java.lang.String):void");
    }

    public final void a(boolean z) {
        c(z);
        z = f();
        com.tencent.bugly.crashreport.common.strategy.a a = com.tencent.bugly.crashreport.common.strategy.a.a();
        if (a != null) {
            z = z && a.c().g;
        }
        if (z != e()) {
            x.a("anr changed to %b", Boolean.valueOf(z));
            b(z);
        }
    }

    public final boolean a() {
        return this.a.get() != 0;
    }

    /* Access modifiers changed, original: protected|final */
    public final void b() {
        long b = z.b() - c.g;
        File file = new File(this.g);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                String str = "bugly_trace_";
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
                            x.e("tomb format error delete %s", name);
                        }
                        if (file2.delete()) {
                            i2++;
                        }
                    }
                    i++;
                }
                x.c("clean tombs %d", Integer.valueOf(i2));
            }
        }
    }
}
