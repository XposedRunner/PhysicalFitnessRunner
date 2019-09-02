package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.b;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import com.tencent.bugly.proguard.z;
import java.util.Map;

/* compiled from: BUGLY */
public final class a implements NativeExceptionHandler {
    private final Context a;
    private final b b;
    private final com.tencent.bugly.crashreport.common.info.a c;
    private final com.tencent.bugly.crashreport.common.strategy.a d;

    public a(Context context, com.tencent.bugly.crashreport.common.info.a aVar, b bVar, com.tencent.bugly.crashreport.common.strategy.a aVar2) {
        this.a = context;
        this.b = bVar;
        this.c = aVar;
        this.d = aVar2;
    }

    public final void handleNativeException(int i, int i2, long j, long j2, String str, String str2, String str3, String str4, int i3, String str5, int i4, int i5, int i6, String str6, String str7) {
        x.a("Native Crash Happen v1", new Object[0]);
        handleNativeException2(i, i2, j, j2, str, str2, str3, str4, i3, str5, i4, i5, i6, str6, str7, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:89:0x0211 A:{SYNTHETIC, Splitter:B:89:0x0211} */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0202 A:{SYNTHETIC, Splitter:B:84:0x0202} */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0155 A:{SYNTHETIC, Splitter:B:66:0x0155} */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0202 A:{SYNTHETIC, Splitter:B:84:0x0202} */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0211 A:{SYNTHETIC, Splitter:B:89:0x0211} */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0281  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0281  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0281  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0281  */
    /* JADX WARNING: Missing block: B:10:0x0033, code skipped:
            if (r3 >= com.baidu.mapapi.synchronization.SynchronizationConstants.LBS_STATUS_CODE_START_DEGRADED_DISPLAY) goto L_0x003b;
     */
    public final void handleNativeException2(int r27, int r28, long r29, long r31, java.lang.String r33, java.lang.String r34, java.lang.String r35, java.lang.String r36, int r37, java.lang.String r38, int r39, int r40, int r41, java.lang.String r42, java.lang.String r43, java.lang.String[] r44) {
        /*
        r26 = this;
        r15 = r26;
        r14 = r34;
        r13 = r37;
        r1 = r39;
        r2 = r44;
        r3 = "Native Crash Happen v2";
        r12 = 0;
        r4 = new java.lang.Object[r12];
        com.tencent.bugly.proguard.x.a(r3, r4);
        r3 = r15.d;	 Catch:{ Throwable -> 0x0278 }
        r3 = r3.b();	 Catch:{ Throwable -> 0x0278 }
        if (r3 != 0) goto L_0x003b;
    L_0x001a:
        r3 = "waiting for remote sync";
        r4 = new java.lang.Object[r12];	 Catch:{ Throwable -> 0x0036 }
        com.tencent.bugly.proguard.x.e(r3, r4);	 Catch:{ Throwable -> 0x0036 }
        r3 = r12;
    L_0x0022:
        r4 = r15.d;	 Catch:{ Throwable -> 0x0036 }
        r4 = r4.b();	 Catch:{ Throwable -> 0x0036 }
        if (r4 != 0) goto L_0x003b;
    L_0x002a:
        r4 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        com.tencent.bugly.proguard.z.b(r4);	 Catch:{ Throwable -> 0x0036 }
        r3 = r3 + 500;
        r4 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;
        if (r3 < r4) goto L_0x0022;
    L_0x0035:
        goto L_0x003b;
    L_0x0036:
        r0 = move-exception;
        r1 = r0;
        r2 = r15;
        goto L_0x027b;
    L_0x003b:
        r11 = com.tencent.bugly.crashreport.crash.jni.b.a(r35);	 Catch:{ Throwable -> 0x0278 }
        r3 = "UNKNOWN";
        if (r13 <= 0) goto L_0x0067;
    L_0x0043:
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0036 }
        r1.<init>();	 Catch:{ Throwable -> 0x0036 }
        r4 = r33;
        r1.append(r4);	 Catch:{ Throwable -> 0x0036 }
        r4 = "(";
        r1.append(r4);	 Catch:{ Throwable -> 0x0036 }
        r5 = r38;
        r1.append(r5);	 Catch:{ Throwable -> 0x0036 }
        r4 = ")";
        r1.append(r4);	 Catch:{ Throwable -> 0x0036 }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x0036 }
        r4 = "KERNEL";
        r10 = r1;
        r16 = r3;
        r9 = r4;
        goto L_0x009d;
    L_0x0067:
        r4 = r33;
        r5 = r38;
        if (r1 <= 0) goto L_0x0073;
    L_0x006d:
        r3 = r15.a;	 Catch:{ Throwable -> 0x0036 }
        r3 = com.tencent.bugly.crashreport.common.info.AppInfo.a(r39);	 Catch:{ Throwable -> 0x0036 }
    L_0x0073:
        r6 = java.lang.String.valueOf(r39);	 Catch:{ Throwable -> 0x0278 }
        r6 = r3.equals(r6);	 Catch:{ Throwable -> 0x0278 }
        if (r6 != 0) goto L_0x0099;
    L_0x007d:
        r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0036 }
        r6.<init>();	 Catch:{ Throwable -> 0x0036 }
        r6.append(r3);	 Catch:{ Throwable -> 0x0036 }
        r3 = "(";
        r6.append(r3);	 Catch:{ Throwable -> 0x0036 }
        r6.append(r1);	 Catch:{ Throwable -> 0x0036 }
        r1 = ")";
        r6.append(r1);	 Catch:{ Throwable -> 0x0036 }
        r1 = r6.toString();	 Catch:{ Throwable -> 0x0036 }
        r16 = r1;
        goto L_0x009b;
    L_0x0099:
        r16 = r3;
    L_0x009b:
        r10 = r4;
        r9 = r5;
    L_0x009d:
        r1 = r15.d;	 Catch:{ Throwable -> 0x0278 }
        r1 = r1.b();	 Catch:{ Throwable -> 0x0278 }
        if (r1 != 0) goto L_0x00ac;
    L_0x00a5:
        r1 = "no remote but still store!";
        r3 = new java.lang.Object[r12];	 Catch:{ Throwable -> 0x0036 }
        com.tencent.bugly.proguard.x.d(r1, r3);	 Catch:{ Throwable -> 0x0036 }
    L_0x00ac:
        r1 = r15.d;	 Catch:{ Throwable -> 0x0278 }
        r1 = r1.c();	 Catch:{ Throwable -> 0x0278 }
        r1 = r1.g;	 Catch:{ Throwable -> 0x0278 }
        if (r1 != 0) goto L_0x00f7;
    L_0x00b6:
        r1 = r15.d;	 Catch:{ Throwable -> 0x0036 }
        r1 = r1.b();	 Catch:{ Throwable -> 0x0036 }
        if (r1 == 0) goto L_0x00f7;
    L_0x00be:
        r1 = "crash report was closed by remote , will not upload to Bugly , print local for helpful!";
        r2 = new java.lang.Object[r12];	 Catch:{ Throwable -> 0x0036 }
        com.tencent.bugly.proguard.x.e(r1, r2);	 Catch:{ Throwable -> 0x0036 }
        r3 = "NATIVE_CRASH";
        r4 = com.tencent.bugly.proguard.z.a();	 Catch:{ Throwable -> 0x0036 }
        r1 = r15.c;	 Catch:{ Throwable -> 0x0036 }
        r5 = r1.d;	 Catch:{ Throwable -> 0x0036 }
        r6 = java.lang.Thread.currentThread();	 Catch:{ Throwable -> 0x0036 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0036 }
        r1.<init>();	 Catch:{ Throwable -> 0x0036 }
        r1.append(r10);	 Catch:{ Throwable -> 0x0036 }
        r2 = "\n";
        r1.append(r2);	 Catch:{ Throwable -> 0x0036 }
        r1.append(r14);	 Catch:{ Throwable -> 0x0036 }
        r2 = "\n";
        r1.append(r2);	 Catch:{ Throwable -> 0x0036 }
        r1.append(r11);	 Catch:{ Throwable -> 0x0036 }
        r7 = r1.toString();	 Catch:{ Throwable -> 0x0036 }
        r8 = 0;
        com.tencent.bugly.crashreport.crash.b.a(r3, r4, r5, r6, r7, r8);	 Catch:{ Throwable -> 0x0036 }
        com.tencent.bugly.proguard.z.b(r36);	 Catch:{ Throwable -> 0x0036 }
        return;
    L_0x00f7:
        r1 = new java.util.HashMap;	 Catch:{ Throwable -> 0x0278 }
        r1.<init>();	 Catch:{ Throwable -> 0x0278 }
        if (r2 == 0) goto L_0x0124;
    L_0x00fe:
        r3 = r2.length;	 Catch:{ Throwable -> 0x0036 }
        r4 = r12;
    L_0x0100:
        if (r4 >= r3) goto L_0x012b;
    L_0x0102:
        r5 = r2[r4];	 Catch:{ Throwable -> 0x0036 }
        r6 = "=";
        r6 = r5.split(r6);	 Catch:{ Throwable -> 0x0036 }
        r7 = r6.length;	 Catch:{ Throwable -> 0x0036 }
        r8 = 2;
        if (r7 != r8) goto L_0x0117;
    L_0x010e:
        r5 = r6[r12];	 Catch:{ Throwable -> 0x0036 }
        r7 = 1;
        r6 = r6[r7];	 Catch:{ Throwable -> 0x0036 }
        r1.put(r5, r6);	 Catch:{ Throwable -> 0x0036 }
        goto L_0x0121;
    L_0x0117:
        r6 = "bad extraMsg %s";
        r7 = 1;
        r8 = new java.lang.Object[r7];	 Catch:{ Throwable -> 0x0036 }
        r8[r12] = r5;	 Catch:{ Throwable -> 0x0036 }
        com.tencent.bugly.proguard.x.d(r6, r8);	 Catch:{ Throwable -> 0x0036 }
    L_0x0121:
        r4 = r4 + 1;
        goto L_0x0100;
    L_0x0124:
        r2 = "not found extraMsg";
        r3 = new java.lang.Object[r12];	 Catch:{ Throwable -> 0x0278 }
        com.tencent.bugly.proguard.x.c(r2, r3);	 Catch:{ Throwable -> 0x0278 }
    L_0x012b:
        r2 = "ExceptionProcessName";
        r2 = r1.get(r2);	 Catch:{ Throwable -> 0x0278 }
        r2 = (java.lang.String) r2;	 Catch:{ Throwable -> 0x0278 }
        if (r2 == 0) goto L_0x0147;
    L_0x0135:
        r3 = r2.length();	 Catch:{ Throwable -> 0x0036 }
        if (r3 != 0) goto L_0x013c;
    L_0x013b:
        goto L_0x0147;
    L_0x013c:
        r3 = "crash process name change to %s";
        r4 = 1;
        r5 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x0036 }
        r5[r12] = r2;	 Catch:{ Throwable -> 0x0036 }
        com.tencent.bugly.proguard.x.c(r3, r5);	 Catch:{ Throwable -> 0x0036 }
        goto L_0x014b;
    L_0x0147:
        r2 = r15.c;	 Catch:{ Throwable -> 0x0278 }
        r2 = r2.d;	 Catch:{ Throwable -> 0x0278 }
    L_0x014b:
        r3 = "ExceptionThreadName";
        r3 = r1.get(r3);	 Catch:{ Throwable -> 0x0278 }
        r3 = (java.lang.String) r3;	 Catch:{ Throwable -> 0x0278 }
        if (r3 == 0) goto L_0x01a6;
    L_0x0155:
        r4 = r3.length();	 Catch:{ Throwable -> 0x0036 }
        if (r4 != 0) goto L_0x015c;
    L_0x015b:
        goto L_0x01a6;
    L_0x015c:
        r4 = "crash thread name change to %s";
        r8 = 1;
        r5 = new java.lang.Object[r8];	 Catch:{ Throwable -> 0x0036 }
        r5[r12] = r3;	 Catch:{ Throwable -> 0x0036 }
        com.tencent.bugly.proguard.x.c(r4, r5);	 Catch:{ Throwable -> 0x0036 }
        r4 = java.lang.Thread.getAllStackTraces();	 Catch:{ Throwable -> 0x0036 }
        r4 = r4.keySet();	 Catch:{ Throwable -> 0x0036 }
        r4 = r4.iterator();	 Catch:{ Throwable -> 0x0036 }
    L_0x0172:
        r5 = r4.hasNext();	 Catch:{ Throwable -> 0x0036 }
        if (r5 == 0) goto L_0x01cc;
    L_0x0178:
        r5 = r4.next();	 Catch:{ Throwable -> 0x0036 }
        r5 = (java.lang.Thread) r5;	 Catch:{ Throwable -> 0x0036 }
        r6 = r5.getName();	 Catch:{ Throwable -> 0x0036 }
        r6 = r6.equals(r3);	 Catch:{ Throwable -> 0x0036 }
        if (r6 == 0) goto L_0x0172;
    L_0x0188:
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0036 }
        r4.<init>();	 Catch:{ Throwable -> 0x0036 }
        r4.append(r3);	 Catch:{ Throwable -> 0x0036 }
        r3 = "(";
        r4.append(r3);	 Catch:{ Throwable -> 0x0036 }
        r5 = r5.getId();	 Catch:{ Throwable -> 0x0036 }
        r4.append(r5);	 Catch:{ Throwable -> 0x0036 }
        r3 = ")";
        r4.append(r3);	 Catch:{ Throwable -> 0x0036 }
        r3 = r4.toString();	 Catch:{ Throwable -> 0x0036 }
        goto L_0x01cc;
    L_0x01a6:
        r8 = 1;
        r3 = java.lang.Thread.currentThread();	 Catch:{ Throwable -> 0x0278 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0278 }
        r4.<init>();	 Catch:{ Throwable -> 0x0278 }
        r5 = r3.getName();	 Catch:{ Throwable -> 0x0278 }
        r4.append(r5);	 Catch:{ Throwable -> 0x0278 }
        r5 = "(";
        r4.append(r5);	 Catch:{ Throwable -> 0x0278 }
        r5 = r3.getId();	 Catch:{ Throwable -> 0x0278 }
        r4.append(r5);	 Catch:{ Throwable -> 0x0278 }
        r3 = ")";
        r4.append(r3);	 Catch:{ Throwable -> 0x0278 }
        r3 = r4.toString();	 Catch:{ Throwable -> 0x0278 }
    L_0x01cc:
        r4 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r6 = r29 * r4;
        r4 = r31 / r4;
        r17 = r6 + r4;
        r4 = "SysLogPath";
        r1 = r1.get(r4);	 Catch:{ Throwable -> 0x0278 }
        r19 = r1;
        r19 = (java.lang.String) r19;	 Catch:{ Throwable -> 0x0278 }
        r20 = 0;
        r21 = 0;
        r22 = 1;
        r1 = r15;
        r4 = r17;
        r6 = r10;
        r7 = r14;
        r8 = r11;
        r23 = r10;
        r10 = r16;
        r24 = r11;
        r11 = r36;
        r12 = r19;
        r13 = r43;
        r14 = r20;
        r15 = r21;
        r16 = r22;
        r1 = r1.packageCrashDatas(r2, r3, r4, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16);	 Catch:{ Throwable -> 0x0274 }
        if (r1 != 0) goto L_0x0211;
    L_0x0202:
        r1 = "pkg crash datas fail!";
        r2 = 0;
        r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x020b }
        com.tencent.bugly.proguard.x.e(r1, r2);	 Catch:{ Throwable -> 0x020b }
        return;
    L_0x020b:
        r0 = move-exception;
        r1 = r0;
        r2 = r26;
        goto L_0x027b;
    L_0x0211:
        r15 = "NATIVE_CRASH";
        r16 = com.tencent.bugly.proguard.z.a();	 Catch:{ Throwable -> 0x0274 }
        r2 = r26;
        r3 = r2.c;	 Catch:{ Throwable -> 0x0272 }
        r3 = r3.d;	 Catch:{ Throwable -> 0x0272 }
        r18 = java.lang.Thread.currentThread();	 Catch:{ Throwable -> 0x0272 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0272 }
        r4.<init>();	 Catch:{ Throwable -> 0x0272 }
        r5 = r23;
        r4.append(r5);	 Catch:{ Throwable -> 0x0272 }
        r5 = "\n";
        r4.append(r5);	 Catch:{ Throwable -> 0x0272 }
        r5 = r34;
        r4.append(r5);	 Catch:{ Throwable -> 0x0272 }
        r5 = "\n";
        r4.append(r5);	 Catch:{ Throwable -> 0x0272 }
        r5 = r24;
        r4.append(r5);	 Catch:{ Throwable -> 0x0272 }
        r19 = r4.toString();	 Catch:{ Throwable -> 0x0272 }
        r17 = r3;
        r20 = r1;
        com.tencent.bugly.crashreport.crash.b.a(r15, r16, r17, r18, r19, r20);	 Catch:{ Throwable -> 0x0272 }
        r3 = r2.b;	 Catch:{ Throwable -> 0x0272 }
        r4 = r37;
        r3 = r3.a(r1, r4);	 Catch:{ Throwable -> 0x0272 }
        if (r3 != 0) goto L_0x025d;
    L_0x0254:
        r3 = r2.b;	 Catch:{ Throwable -> 0x0272 }
        r4 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;
        r6 = 1;
        r3.a(r1, r4, r6);	 Catch:{ Throwable -> 0x0272 }
        goto L_0x025e;
    L_0x025d:
        r6 = 1;
    L_0x025e:
        r3 = r2.b;	 Catch:{ Throwable -> 0x0272 }
        r3.b(r1);	 Catch:{ Throwable -> 0x0272 }
        r1 = 0;
        r3 = com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.getInstance();	 Catch:{ Throwable -> 0x0272 }
        if (r3 == 0) goto L_0x026e;
    L_0x026a:
        r1 = r3.getDumpFilePath();	 Catch:{ Throwable -> 0x0272 }
    L_0x026e:
        com.tencent.bugly.crashreport.crash.jni.b.a(r6, r1);	 Catch:{ Throwable -> 0x0272 }
        return;
    L_0x0272:
        r0 = move-exception;
        goto L_0x027a;
    L_0x0274:
        r0 = move-exception;
        r2 = r26;
        goto L_0x027a;
    L_0x0278:
        r0 = move-exception;
        r2 = r15;
    L_0x027a:
        r1 = r0;
    L_0x027b:
        r3 = com.tencent.bugly.proguard.x.a(r1);
        if (r3 != 0) goto L_0x0284;
    L_0x0281:
        r1.printStackTrace();
    L_0x0284:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.jni.a.handleNativeException2(int, int, long, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, int, int, int, java.lang.String, java.lang.String, java.lang.String[]):void");
    }

    public final CrashDetailBean packageCrashDatas(String str, String str2, long j, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, byte[] bArr, Map<String, String> map, boolean z) {
        String str11 = str;
        String str12 = str8;
        byte[] bArr2 = bArr;
        boolean l = c.a().l();
        if (l) {
            x.e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.b = 1;
        crashDetailBean.e = this.c.h();
        crashDetailBean.f = this.c.j;
        crashDetailBean.g = this.c.w();
        crashDetailBean.m = this.c.g();
        crashDetailBean.n = str3;
        crashDetailBean.o = l ? " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]" : "";
        crashDetailBean.p = str4;
        crashDetailBean.q = str5 == null ? "" : str5;
        crashDetailBean.r = j;
        crashDetailBean.u = z.b(crashDetailBean.q.getBytes());
        crashDetailBean.z = str11;
        crashDetailBean.A = str2;
        crashDetailBean.H = this.c.y();
        crashDetailBean.h = this.c.v();
        crashDetailBean.i = this.c.K();
        crashDetailBean.v = str12;
        NativeCrashHandler instance = NativeCrashHandler.getInstance();
        String dumpFilePath = instance != null ? instance.getDumpFilePath() : null;
        str12 = b.a(dumpFilePath, str12);
        if (!z.a(str12)) {
            crashDetailBean.T = str12;
        }
        crashDetailBean.U = b.b(dumpFilePath);
        crashDetailBean.w = b.a(str9, c.e, null);
        crashDetailBean.I = str7;
        crashDetailBean.J = str6;
        crashDetailBean.K = str10;
        crashDetailBean.E = this.c.p();
        crashDetailBean.F = this.c.o();
        crashDetailBean.G = this.c.q();
        if (z) {
            crashDetailBean.B = com.tencent.bugly.crashreport.common.info.b.h();
            crashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.f();
            crashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.j();
            if (crashDetailBean.w == null) {
                crashDetailBean.w = z.a(this.a, c.e, null);
            }
            crashDetailBean.x = y.a();
            crashDetailBean.L = this.c.a;
            crashDetailBean.M = this.c.a();
            crashDetailBean.O = this.c.H();
            crashDetailBean.P = this.c.I();
            crashDetailBean.Q = this.c.B();
            crashDetailBean.R = this.c.G();
            crashDetailBean.y = z.a(c.f, false);
            str12 = "java:\n";
            int indexOf = crashDetailBean.q.indexOf(str12);
            if (indexOf > 0) {
                indexOf += str12.length();
                if (indexOf < crashDetailBean.q.length()) {
                    str12 = crashDetailBean.q.substring(indexOf, crashDetailBean.q.length() - 1);
                    if (str12.length() > 0 && crashDetailBean.y.containsKey(crashDetailBean.A)) {
                        dumpFilePath = (String) crashDetailBean.y.get(crashDetailBean.A);
                        int indexOf2 = dumpFilePath.indexOf(str12);
                        if (indexOf2 > 0) {
                            str12 = dumpFilePath.substring(indexOf2);
                            crashDetailBean.y.put(crashDetailBean.A, str12);
                            crashDetailBean.q = crashDetailBean.q.substring(0, indexOf);
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(crashDetailBean.q);
                            stringBuilder.append(str12);
                            crashDetailBean.q = stringBuilder.toString();
                        }
                    }
                }
            }
            if (str11 == null) {
                crashDetailBean.z = this.c.d;
            }
            this.b.c(crashDetailBean);
        } else {
            crashDetailBean.B = -1;
            crashDetailBean.C = -1;
            crashDetailBean.D = -1;
            if (crashDetailBean.w == null) {
                crashDetailBean.w = "this crash is occurred at last process! Log is miss, when get an terrible ABRT Native Exception etc.";
            }
            crashDetailBean.L = -1;
            crashDetailBean.O = -1;
            crashDetailBean.P = -1;
            crashDetailBean.Q = map;
            crashDetailBean.R = this.c.G();
            crashDetailBean.y = null;
            if (str11 == null) {
                crashDetailBean.z = "unknown(record)";
            }
            if (bArr2 != null) {
                crashDetailBean.x = bArr2;
            }
        }
        return crashDetailBean;
    }
}
