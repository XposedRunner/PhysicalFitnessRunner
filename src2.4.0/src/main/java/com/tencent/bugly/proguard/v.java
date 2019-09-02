package com.tencent.bugly.proguard;

import android.content.Context;
import cn.jiguang.net.HttpUtils;
import com.tencent.bugly.crashreport.common.info.a;
import java.util.Map;
import java.util.UUID;

/* compiled from: BUGLY */
public final class v implements Runnable {
    private int a;
    private int b;
    private final Context c;
    private final int d;
    private final byte[] e;
    private final a f;
    private final com.tencent.bugly.crashreport.common.strategy.a g;
    private final s h;
    private final u i;
    private final int j;
    private final t k;
    private final t l;
    private String m;
    private final String n;
    private final Map<String, String> o;
    private int p;
    private long q;
    private long r;
    private boolean s;
    private boolean t;

    public v(Context context, int i, int i2, byte[] bArr, String str, String str2, t tVar, boolean z, int i3, int i4, boolean z2, Map<String, String> map) {
        int i5 = i3;
        int i6 = i4;
        this.a = 2;
        this.b = 30000;
        this.m = null;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = true;
        this.t = false;
        Context context2 = context;
        this.c = context2;
        this.f = a.a(context2);
        this.e = bArr;
        this.g = com.tencent.bugly.crashreport.common.strategy.a.a();
        this.h = s.a(context2);
        this.i = u.a();
        this.j = i;
        this.m = str;
        this.n = str2;
        this.k = tVar;
        u uVar = this.i;
        this.l = null;
        this.s = z;
        this.d = i2;
        if (i5 > 0) {
            this.a = i5;
        }
        if (i6 > 0) {
            this.b = i6;
        }
        this.t = z2;
        this.o = map;
    }

    public v(Context context, int i, int i2, byte[] bArr, String str, String str2, t tVar, boolean z, boolean z2) {
        this(context, i, i2, bArr, str, str2, tVar, z, 2, 30000, z2, null);
    }

    private static String a(String str) {
        if (z.a(str)) {
            return str;
        }
        try {
            return String.format("%s?aid=%s", new Object[]{str, UUID.randomUUID().toString()});
        } catch (Throwable th) {
            x.a(th);
            return str;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0022  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0022  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A:{SYNTHETIC, RETURN} */
    private void a(com.tencent.bugly.proguard.an r5, boolean r6, int r7, java.lang.String r8, int r9) {
        /*
        r4 = this;
        r5 = r4.d;
        r0 = 630; // 0x276 float:8.83E-43 double:3.113E-321;
        if (r5 == r0) goto L_0x001c;
    L_0x0006:
        r0 = 640; // 0x280 float:8.97E-43 double:3.16E-321;
        if (r5 == r0) goto L_0x0019;
    L_0x000a:
        r0 = 830; // 0x33e float:1.163E-42 double:4.1E-321;
        if (r5 == r0) goto L_0x001c;
    L_0x000e:
        r0 = 840; // 0x348 float:1.177E-42 double:4.15E-321;
        if (r5 == r0) goto L_0x0019;
    L_0x0012:
        r5 = r4.d;
        r5 = java.lang.String.valueOf(r5);
        goto L_0x001e;
    L_0x0019:
        r5 = "userinfo";
        goto L_0x001e;
    L_0x001c:
        r5 = "crash";
    L_0x001e:
        r0 = 0;
        r1 = 1;
        if (r6 == 0) goto L_0x002c;
    L_0x0022:
        r7 = "[Upload] Success: %s";
        r8 = new java.lang.Object[r1];
        r8[r0] = r5;
        com.tencent.bugly.proguard.x.a(r7, r8);
        goto L_0x0049;
    L_0x002c:
        r2 = "[Upload] Failed to upload(%d) %s: %s";
        r3 = 3;
        r3 = new java.lang.Object[r3];
        r7 = java.lang.Integer.valueOf(r7);
        r3[r0] = r7;
        r3[r1] = r5;
        r5 = 2;
        r3[r5] = r8;
        com.tencent.bugly.proguard.x.e(r2, r3);
        r5 = r4.s;
        if (r5 == 0) goto L_0x0049;
    L_0x0043:
        r5 = r4.i;
        r7 = 0;
        r5.a(r9, r7);
    L_0x0049:
        r7 = r4.q;
        r0 = r4.r;
        r2 = r7 + r0;
        r7 = 0;
        r5 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1));
        if (r5 <= 0) goto L_0x006c;
    L_0x0055:
        r5 = r4.i;
        r7 = r4.t;
        r7 = r5.a(r7);
        r0 = r4.q;
        r2 = r7 + r0;
        r7 = r4.r;
        r0 = r2 + r7;
        r5 = r4.i;
        r7 = r4.t;
        r5.a(r0, r7);
    L_0x006c:
        r5 = r4.k;
        if (r5 == 0) goto L_0x007b;
    L_0x0070:
        r5 = r4.k;
        r7 = r4.d;
        r7 = r4.q;
        r7 = r4.r;
        r5.a(r6);
    L_0x007b:
        r5 = r4.l;
        if (r5 == 0) goto L_0x008a;
    L_0x007f:
        r5 = r4.l;
        r7 = r4.d;
        r7 = r4.q;
        r7 = r4.r;
        r5.a(r6);
    L_0x008a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.v.a(com.tencent.bugly.proguard.an, boolean, int, java.lang.String, int):void");
    }

    private static boolean a(an anVar, a aVar, com.tencent.bugly.crashreport.common.strategy.a aVar2) {
        if (anVar == null) {
            x.d("resp == null!", new Object[0]);
            return false;
        } else if (anVar.a != (byte) 0) {
            x.e("resp result error %d", Byte.valueOf(anVar.a));
            return false;
        } else {
            try {
                if (!(z.a(anVar.d) || a.b().i().equals(anVar.d))) {
                    p.a().a(com.tencent.bugly.crashreport.common.strategy.a.a, "key_ip", anVar.d.getBytes(HttpUtils.ENCODING_UTF_8), null, true);
                    aVar.d(anVar.d);
                }
                if (!(z.a(anVar.f) || a.b().j().equals(anVar.f))) {
                    p.a().a(com.tencent.bugly.crashreport.common.strategy.a.a, "key_imei", anVar.f.getBytes(HttpUtils.ENCODING_UTF_8), null, true);
                    aVar.e(anVar.f);
                }
            } catch (Throwable th) {
                x.a(th);
            }
            aVar.i = anVar.e;
            if (anVar.b == 510) {
                if (anVar.c == null) {
                    x.e("[Upload] Strategy data is null. Response cmd: %d", Integer.valueOf(anVar.b));
                    return false;
                }
                ap apVar = (ap) a.a(anVar.c, ap.class);
                if (apVar == null) {
                    x.e("[Upload] Failed to decode strategy from server. Response cmd: %d", Integer.valueOf(anVar.b));
                    return false;
                }
                aVar2.a(apVar);
            }
            return true;
        }
    }

    public final void a(long j) {
        this.p++;
        this.q += j;
    }

    public final void b(long j) {
        this.r += j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:92:0x02a9 A:{SYNTHETIC, Splitter:B:92:0x02a9} */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0240 A:{Catch:{ Throwable -> 0x035b, Throwable -> 0x0469 }} */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0240 A:{Catch:{ Throwable -> 0x035b, Throwable -> 0x0469 }} */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x02a9 A:{SYNTHETIC, Splitter:B:92:0x02a9} */
    /* JADX WARNING: Missing block: B:96:0x02d6, code skipped:
            if (r14 == 0) goto L_0x0385;
     */
    /* JADX WARNING: Missing block: B:97:0x02d8, code skipped:
            if (r14 != 2) goto L_0x0344;
     */
    /* JADX WARNING: Missing block: B:100:0x02e4, code skipped:
            if ((r7.q + r7.r) <= 0) goto L_0x02fd;
     */
    /* JADX WARNING: Missing block: B:101:0x02e6, code skipped:
            r7.i.a((r7.i.a(r7.t) + r7.q) + r7.r, r7.t);
     */
    /* JADX WARNING: Missing block: B:102:0x02fd, code skipped:
            r7.i.a(r14, null);
            com.tencent.bugly.proguard.x.a("[Upload] Session ID is invalid, will try again immediately (pid=%d | tid=%d).", java.lang.Integer.valueOf(android.os.Process.myPid()), java.lang.Integer.valueOf(android.os.Process.myTid()));
            r7.i.a(r7.j, r7.d, r7.e, r7.m, r7.n, r7.k, r7.a, r7.b, true, r7.o);
     */
    /* JADX WARNING: Missing block: B:103:0x0343, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:104:0x0344, code skipped:
            r1 = new java.lang.StringBuilder("status of server is ");
            r1.append(r14);
            a(null, false, 1, r1.toString(), r14);
     */
    /* JADX WARNING: Missing block: B:105:0x035a, code skipped:
            return;
     */
    public final void run() {
        /*
        r23 = this;
        r7 = r23;
        r1 = 0;
        r7.p = r1;	 Catch:{ Throwable -> 0x0469 }
        r2 = 0;
        r7.q = r2;	 Catch:{ Throwable -> 0x0469 }
        r7.r = r2;	 Catch:{ Throwable -> 0x0469 }
        r4 = r7.e;	 Catch:{ Throwable -> 0x0469 }
        r5 = r7.c;	 Catch:{ Throwable -> 0x0469 }
        r5 = com.tencent.bugly.crashreport.common.info.b.f(r5);	 Catch:{ Throwable -> 0x0469 }
        if (r5 != 0) goto L_0x0020;
    L_0x0015:
        r2 = 0;
        r3 = 0;
        r4 = 0;
        r5 = "network is not available";
        r6 = 0;
        r1 = r7;
        r1.a(r2, r3, r4, r5, r6);	 Catch:{ Throwable -> 0x0469 }
        return;
    L_0x0020:
        if (r4 == 0) goto L_0x045e;
    L_0x0022:
        r5 = r4.length;	 Catch:{ Throwable -> 0x0469 }
        if (r5 != 0) goto L_0x0027;
    L_0x0025:
        goto L_0x045e;
    L_0x0027:
        r5 = r7.i;	 Catch:{ Throwable -> 0x0469 }
        r6 = r7.t;	 Catch:{ Throwable -> 0x0469 }
        r5 = r5.a(r6);	 Catch:{ Throwable -> 0x0469 }
        r8 = r4.length;	 Catch:{ Throwable -> 0x0469 }
        r8 = (long) r8;	 Catch:{ Throwable -> 0x0469 }
        r10 = r5 + r8;
        r8 = 2097152; // 0x200000 float:2.938736E-39 double:1.0361308E-317;
        r12 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1));
        r10 = 2;
        r11 = 1;
        if (r12 < 0) goto L_0x006d;
    L_0x003c:
        r2 = "[Upload] Upload too much data, try next time: %d/%d";
        r3 = new java.lang.Object[r10];	 Catch:{ Throwable -> 0x0469 }
        r4 = java.lang.Long.valueOf(r5);	 Catch:{ Throwable -> 0x0469 }
        r3[r1] = r4;	 Catch:{ Throwable -> 0x0469 }
        r1 = java.lang.Long.valueOf(r8);	 Catch:{ Throwable -> 0x0469 }
        r3[r11] = r1;	 Catch:{ Throwable -> 0x0469 }
        com.tencent.bugly.proguard.x.e(r2, r3);	 Catch:{ Throwable -> 0x0469 }
        r2 = 0;
        r3 = 0;
        r4 = 0;
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0469 }
        r5 = "over net consume: ";
        r1.<init>(r5);	 Catch:{ Throwable -> 0x0469 }
        r5 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;
        r1.append(r5);	 Catch:{ Throwable -> 0x0469 }
        r5 = "K";
        r1.append(r5);	 Catch:{ Throwable -> 0x0469 }
        r5 = r1.toString();	 Catch:{ Throwable -> 0x0469 }
        r6 = 0;
        r1 = r7;
        r1.a(r2, r3, r4, r5, r6);	 Catch:{ Throwable -> 0x0469 }
        return;
    L_0x006d:
        r5 = "[Upload] Run upload task with cmd: %d";
        r6 = new java.lang.Object[r11];	 Catch:{ Throwable -> 0x0469 }
        r8 = r7.d;	 Catch:{ Throwable -> 0x0469 }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ Throwable -> 0x0469 }
        r6[r1] = r8;	 Catch:{ Throwable -> 0x0469 }
        com.tencent.bugly.proguard.x.c(r5, r6);	 Catch:{ Throwable -> 0x0469 }
        r5 = r7.c;	 Catch:{ Throwable -> 0x0469 }
        if (r5 == 0) goto L_0x0453;
    L_0x0080:
        r5 = r7.f;	 Catch:{ Throwable -> 0x0469 }
        if (r5 == 0) goto L_0x0453;
    L_0x0084:
        r5 = r7.g;	 Catch:{ Throwable -> 0x0469 }
        if (r5 == 0) goto L_0x0453;
    L_0x0088:
        r5 = r7.h;	 Catch:{ Throwable -> 0x0469 }
        if (r5 != 0) goto L_0x008e;
    L_0x008c:
        goto L_0x0453;
    L_0x008e:
        r5 = r7.g;	 Catch:{ Throwable -> 0x0469 }
        r5 = r5.c();	 Catch:{ Throwable -> 0x0469 }
        if (r5 != 0) goto L_0x00a1;
    L_0x0096:
        r2 = 0;
        r3 = 0;
        r4 = 0;
        r5 = "illegal local strategy";
        r6 = 0;
        r1 = r7;
        r1.a(r2, r3, r4, r5, r6);	 Catch:{ Throwable -> 0x0469 }
        return;
    L_0x00a1:
        r6 = new java.util.HashMap;	 Catch:{ Throwable -> 0x0469 }
        r6.<init>();	 Catch:{ Throwable -> 0x0469 }
        r8 = "prodId";
        r9 = r7.f;	 Catch:{ Throwable -> 0x0469 }
        r9 = r9.f();	 Catch:{ Throwable -> 0x0469 }
        r6.put(r8, r9);	 Catch:{ Throwable -> 0x0469 }
        r8 = "bundleId";
        r9 = r7.f;	 Catch:{ Throwable -> 0x0469 }
        r9 = r9.c;	 Catch:{ Throwable -> 0x0469 }
        r6.put(r8, r9);	 Catch:{ Throwable -> 0x0469 }
        r8 = "appVer";
        r9 = r7.f;	 Catch:{ Throwable -> 0x0469 }
        r9 = r9.j;	 Catch:{ Throwable -> 0x0469 }
        r6.put(r8, r9);	 Catch:{ Throwable -> 0x0469 }
        r8 = r7.o;	 Catch:{ Throwable -> 0x0469 }
        if (r8 == 0) goto L_0x00cc;
    L_0x00c7:
        r8 = r7.o;	 Catch:{ Throwable -> 0x0469 }
        r6.putAll(r8);	 Catch:{ Throwable -> 0x0469 }
    L_0x00cc:
        r8 = r7.s;	 Catch:{ Throwable -> 0x0469 }
        if (r8 == 0) goto L_0x0132;
    L_0x00d0:
        r8 = "cmd";
        r9 = r7.d;	 Catch:{ Throwable -> 0x0469 }
        r9 = java.lang.Integer.toString(r9);	 Catch:{ Throwable -> 0x0469 }
        r6.put(r8, r9);	 Catch:{ Throwable -> 0x0469 }
        r8 = "platformId";
        r9 = java.lang.Byte.toString(r11);	 Catch:{ Throwable -> 0x0469 }
        r6.put(r8, r9);	 Catch:{ Throwable -> 0x0469 }
        r8 = "sdkVer";
        r9 = r7.f;	 Catch:{ Throwable -> 0x0469 }
        r9.getClass();	 Catch:{ Throwable -> 0x0469 }
        r9 = "2.6.6";
        r6.put(r8, r9);	 Catch:{ Throwable -> 0x0469 }
        r8 = "strategylastUpdateTime";
        r12 = r5.p;	 Catch:{ Throwable -> 0x0469 }
        r5 = java.lang.Long.toString(r12);	 Catch:{ Throwable -> 0x0469 }
        r6.put(r8, r5);	 Catch:{ Throwable -> 0x0469 }
        r5 = r7.i;	 Catch:{ Throwable -> 0x0469 }
        r5 = r5.a(r6);	 Catch:{ Throwable -> 0x0469 }
        if (r5 != 0) goto L_0x010e;
    L_0x0103:
        r2 = 0;
        r3 = 0;
        r4 = 0;
        r5 = "failed to add security info to HTTP headers";
        r6 = 0;
        r1 = r7;
        r1.a(r2, r3, r4, r5, r6);	 Catch:{ Throwable -> 0x0469 }
        return;
    L_0x010e:
        r4 = com.tencent.bugly.proguard.z.a(r4, r10);	 Catch:{ Throwable -> 0x0469 }
        if (r4 != 0) goto L_0x011f;
    L_0x0114:
        r2 = 0;
        r3 = 0;
        r4 = 0;
        r5 = "failed to zip request body";
        r6 = 0;
        r1 = r7;
        r1.a(r2, r3, r4, r5, r6);	 Catch:{ Throwable -> 0x0469 }
        return;
    L_0x011f:
        r5 = r7.i;	 Catch:{ Throwable -> 0x0469 }
        r4 = r5.a(r4);	 Catch:{ Throwable -> 0x0469 }
        if (r4 != 0) goto L_0x0132;
    L_0x0127:
        r2 = 0;
        r3 = 0;
        r4 = 0;
        r5 = "failed to encrypt request body";
        r6 = 0;
        r1 = r7;
        r1.a(r2, r3, r4, r5, r6);	 Catch:{ Throwable -> 0x0469 }
        return;
    L_0x0132:
        r5 = r7.i;	 Catch:{ Throwable -> 0x0469 }
        r8 = r7.j;	 Catch:{ Throwable -> 0x0469 }
        r12 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x0469 }
        r5.a(r8, r12);	 Catch:{ Throwable -> 0x0469 }
        r5 = r7.k;	 Catch:{ Throwable -> 0x0469 }
        if (r5 == 0) goto L_0x0145;
    L_0x0141:
        r5 = r7.k;	 Catch:{ Throwable -> 0x0469 }
        r5 = r7.d;	 Catch:{ Throwable -> 0x0469 }
    L_0x0145:
        r5 = r7.l;	 Catch:{ Throwable -> 0x0469 }
        if (r5 == 0) goto L_0x014d;
    L_0x0149:
        r5 = r7.l;	 Catch:{ Throwable -> 0x0469 }
        r5 = r7.d;	 Catch:{ Throwable -> 0x0469 }
    L_0x014d:
        r5 = r7.m;	 Catch:{ Throwable -> 0x0469 }
        r8 = -1;
        r9 = r5;
        r12 = r8;
        r5 = r1;
        r8 = r5;
    L_0x0154:
        r13 = r5 + 1;
        r14 = r7.a;	 Catch:{ Throwable -> 0x0469 }
        if (r5 >= r14) goto L_0x0448;
    L_0x015a:
        if (r13 <= r11) goto L_0x0180;
    L_0x015c:
        r5 = "[Upload] Failed to upload last time, wait and try(%d) again.";
        r8 = new java.lang.Object[r11];	 Catch:{ Throwable -> 0x0469 }
        r14 = java.lang.Integer.valueOf(r13);	 Catch:{ Throwable -> 0x0469 }
        r8[r1] = r14;	 Catch:{ Throwable -> 0x0469 }
        com.tencent.bugly.proguard.x.d(r5, r8);	 Catch:{ Throwable -> 0x0469 }
        r5 = r7.b;	 Catch:{ Throwable -> 0x0469 }
        r14 = (long) r5;	 Catch:{ Throwable -> 0x0469 }
        com.tencent.bugly.proguard.z.b(r14);	 Catch:{ Throwable -> 0x0469 }
        r5 = r7.a;	 Catch:{ Throwable -> 0x0469 }
        if (r13 != r5) goto L_0x0180;
    L_0x0173:
        r5 = "[Upload] Use the back-up url at the last time: %s";
        r8 = new java.lang.Object[r11];	 Catch:{ Throwable -> 0x0469 }
        r9 = r7.n;	 Catch:{ Throwable -> 0x0469 }
        r8[r1] = r9;	 Catch:{ Throwable -> 0x0469 }
        com.tencent.bugly.proguard.x.d(r5, r8);	 Catch:{ Throwable -> 0x0469 }
        r9 = r7.n;	 Catch:{ Throwable -> 0x0469 }
    L_0x0180:
        r5 = "[Upload] Send %d bytes";
        r8 = new java.lang.Object[r11];	 Catch:{ Throwable -> 0x0469 }
        r14 = r4.length;	 Catch:{ Throwable -> 0x0469 }
        r14 = java.lang.Integer.valueOf(r14);	 Catch:{ Throwable -> 0x0469 }
        r8[r1] = r14;	 Catch:{ Throwable -> 0x0469 }
        com.tencent.bugly.proguard.x.c(r5, r8);	 Catch:{ Throwable -> 0x0469 }
        r5 = r7.s;	 Catch:{ Throwable -> 0x0469 }
        if (r5 == 0) goto L_0x0197;
    L_0x0192:
        r5 = a(r9);	 Catch:{ Throwable -> 0x0469 }
        r9 = r5;
    L_0x0197:
        r5 = "[Upload] Upload to %s with cmd %d (pid=%d | tid=%d).";
        r8 = 4;
        r8 = new java.lang.Object[r8];	 Catch:{ Throwable -> 0x0469 }
        r8[r1] = r9;	 Catch:{ Throwable -> 0x0469 }
        r14 = r7.d;	 Catch:{ Throwable -> 0x0469 }
        r14 = java.lang.Integer.valueOf(r14);	 Catch:{ Throwable -> 0x0469 }
        r8[r11] = r14;	 Catch:{ Throwable -> 0x0469 }
        r14 = android.os.Process.myPid();	 Catch:{ Throwable -> 0x0469 }
        r14 = java.lang.Integer.valueOf(r14);	 Catch:{ Throwable -> 0x0469 }
        r8[r10] = r14;	 Catch:{ Throwable -> 0x0469 }
        r14 = android.os.Process.myTid();	 Catch:{ Throwable -> 0x0469 }
        r14 = java.lang.Integer.valueOf(r14);	 Catch:{ Throwable -> 0x0469 }
        r15 = 3;
        r8[r15] = r14;	 Catch:{ Throwable -> 0x0469 }
        com.tencent.bugly.proguard.x.c(r5, r8);	 Catch:{ Throwable -> 0x0469 }
        r5 = r7.h;	 Catch:{ Throwable -> 0x0469 }
        r5 = r5.a(r9, r4, r7, r6);	 Catch:{ Throwable -> 0x0469 }
        if (r5 != 0) goto L_0x01db;
    L_0x01c6:
        r5 = "Failed to upload for no response!";
        r8 = "[Upload] Failed to upload(%d): %s";
        r14 = new java.lang.Object[r10];	 Catch:{ Throwable -> 0x0469 }
        r15 = java.lang.Integer.valueOf(r11);	 Catch:{ Throwable -> 0x0469 }
        r14[r1] = r15;	 Catch:{ Throwable -> 0x0469 }
        r14[r11] = r5;	 Catch:{ Throwable -> 0x0469 }
        com.tencent.bugly.proguard.x.e(r8, r14);	 Catch:{ Throwable -> 0x0469 }
    L_0x01d7:
        r8 = r11;
        r5 = r13;
        goto L_0x0154;
    L_0x01db:
        r8 = r7.h;	 Catch:{ Throwable -> 0x0469 }
        r8 = r8.a;	 Catch:{ Throwable -> 0x0469 }
        r14 = r7.s;	 Catch:{ Throwable -> 0x0469 }
        if (r14 == 0) goto L_0x0384;
    L_0x01e3:
        if (r8 == 0) goto L_0x0236;
    L_0x01e5:
        r14 = r8.size();	 Catch:{ Throwable -> 0x0469 }
        if (r14 != 0) goto L_0x01ec;
    L_0x01eb:
        goto L_0x0236;
    L_0x01ec:
        r14 = "status";
        r14 = r8.containsKey(r14);	 Catch:{ Throwable -> 0x0469 }
        if (r14 != 0) goto L_0x0200;
    L_0x01f4:
        r14 = "[Upload] Headers does not contain %s";
        r2 = new java.lang.Object[r11];	 Catch:{ Throwable -> 0x0469 }
        r3 = "status";
        r2[r1] = r3;	 Catch:{ Throwable -> 0x0469 }
        com.tencent.bugly.proguard.x.d(r14, r2);	 Catch:{ Throwable -> 0x0469 }
        goto L_0x023d;
    L_0x0200:
        r2 = "Bugly-Version";
        r2 = r8.containsKey(r2);	 Catch:{ Throwable -> 0x0469 }
        if (r2 != 0) goto L_0x0211;
    L_0x0208:
        r2 = "[Upload] Headers does not contain %s";
        r3 = new java.lang.Object[r11];	 Catch:{ Throwable -> 0x0469 }
        r14 = "Bugly-Version";
        r3[r1] = r14;	 Catch:{ Throwable -> 0x0469 }
        goto L_0x023a;
    L_0x0211:
        r2 = "Bugly-Version";
        r2 = r8.get(r2);	 Catch:{ Throwable -> 0x0469 }
        r2 = (java.lang.String) r2;	 Catch:{ Throwable -> 0x0469 }
        r3 = "bugly";
        r3 = r2.contains(r3);	 Catch:{ Throwable -> 0x0469 }
        if (r3 != 0) goto L_0x022b;
    L_0x0221:
        r3 = "[Upload] Bugly version is not valid: %s";
        r14 = new java.lang.Object[r11];	 Catch:{ Throwable -> 0x0469 }
        r14[r1] = r2;	 Catch:{ Throwable -> 0x0469 }
        com.tencent.bugly.proguard.x.d(r3, r14);	 Catch:{ Throwable -> 0x0469 }
        goto L_0x023d;
    L_0x022b:
        r3 = "[Upload] Bugly version from headers is: %s";
        r14 = new java.lang.Object[r11];	 Catch:{ Throwable -> 0x0469 }
        r14[r1] = r2;	 Catch:{ Throwable -> 0x0469 }
        com.tencent.bugly.proguard.x.c(r3, r14);	 Catch:{ Throwable -> 0x0469 }
        r2 = r11;
        goto L_0x023e;
    L_0x0236:
        r2 = "[Upload] Headers is empty.";
        r3 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x0469 }
    L_0x023a:
        com.tencent.bugly.proguard.x.d(r2, r3);	 Catch:{ Throwable -> 0x0469 }
    L_0x023d:
        r2 = r1;
    L_0x023e:
        if (r2 != 0) goto L_0x02a9;
    L_0x0240:
        r2 = "[Upload] Headers from server is not valid, just try again (pid=%d | tid=%d).";
        r3 = new java.lang.Object[r10];	 Catch:{ Throwable -> 0x0469 }
        r5 = android.os.Process.myPid();	 Catch:{ Throwable -> 0x0469 }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Throwable -> 0x0469 }
        r3[r1] = r5;	 Catch:{ Throwable -> 0x0469 }
        r5 = android.os.Process.myTid();	 Catch:{ Throwable -> 0x0469 }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Throwable -> 0x0469 }
        r3[r11] = r5;	 Catch:{ Throwable -> 0x0469 }
        com.tencent.bugly.proguard.x.c(r2, r3);	 Catch:{ Throwable -> 0x0469 }
        r2 = "[Upload] Failed to upload for no status header.";
        r3 = "[Upload] Failed to upload(%d): %s";
        r5 = new java.lang.Object[r10];	 Catch:{ Throwable -> 0x0469 }
        r14 = java.lang.Integer.valueOf(r11);	 Catch:{ Throwable -> 0x0469 }
        r5[r1] = r14;	 Catch:{ Throwable -> 0x0469 }
        r5[r11] = r2;	 Catch:{ Throwable -> 0x0469 }
        com.tencent.bugly.proguard.x.e(r3, r5);	 Catch:{ Throwable -> 0x0469 }
        if (r8 == 0) goto L_0x029c;
    L_0x026e:
        r2 = r8.entrySet();	 Catch:{ Throwable -> 0x0469 }
        r2 = r2.iterator();	 Catch:{ Throwable -> 0x0469 }
    L_0x0276:
        r3 = r2.hasNext();	 Catch:{ Throwable -> 0x0469 }
        if (r3 == 0) goto L_0x029c;
    L_0x027c:
        r3 = r2.next();	 Catch:{ Throwable -> 0x0469 }
        r3 = (java.util.Map.Entry) r3;	 Catch:{ Throwable -> 0x0469 }
        r5 = "[key]: %s, [value]: %s";
        r8 = new java.lang.Object[r10];	 Catch:{ Throwable -> 0x0469 }
        r14 = r3.getKey();	 Catch:{ Throwable -> 0x0469 }
        r8[r1] = r14;	 Catch:{ Throwable -> 0x0469 }
        r3 = r3.getValue();	 Catch:{ Throwable -> 0x0469 }
        r8[r11] = r3;	 Catch:{ Throwable -> 0x0469 }
        r3 = java.lang.String.format(r5, r8);	 Catch:{ Throwable -> 0x0469 }
        r5 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x0469 }
        com.tencent.bugly.proguard.x.c(r3, r5);	 Catch:{ Throwable -> 0x0469 }
        goto L_0x0276;
    L_0x029c:
        r2 = "[Upload] Failed to upload for no status header.";
        r3 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x0469 }
        com.tencent.bugly.proguard.x.c(r2, r3);	 Catch:{ Throwable -> 0x0469 }
        r8 = r11;
        r5 = r13;
        r2 = 0;
        goto L_0x0154;
    L_0x02a9:
        r2 = "status";
        r2 = r8.get(r2);	 Catch:{ Throwable -> 0x035f }
        r2 = (java.lang.String) r2;	 Catch:{ Throwable -> 0x035f }
        r14 = java.lang.Integer.parseInt(r2);	 Catch:{ Throwable -> 0x035f }
        r2 = "[Upload] Status from server is %d (pid=%d | tid=%d).";
        r3 = new java.lang.Object[r15];	 Catch:{ Throwable -> 0x035b }
        r12 = java.lang.Integer.valueOf(r14);	 Catch:{ Throwable -> 0x035b }
        r3[r1] = r12;	 Catch:{ Throwable -> 0x035b }
        r12 = android.os.Process.myPid();	 Catch:{ Throwable -> 0x035b }
        r12 = java.lang.Integer.valueOf(r12);	 Catch:{ Throwable -> 0x035b }
        r3[r11] = r12;	 Catch:{ Throwable -> 0x035b }
        r12 = android.os.Process.myTid();	 Catch:{ Throwable -> 0x035b }
        r12 = java.lang.Integer.valueOf(r12);	 Catch:{ Throwable -> 0x035b }
        r3[r10] = r12;	 Catch:{ Throwable -> 0x035b }
        com.tencent.bugly.proguard.x.c(r2, r3);	 Catch:{ Throwable -> 0x035b }
        if (r14 == 0) goto L_0x0385;
    L_0x02d8:
        if (r14 != r10) goto L_0x0344;
    L_0x02da:
        r2 = r7.q;	 Catch:{ Throwable -> 0x0469 }
        r4 = r7.r;	 Catch:{ Throwable -> 0x0469 }
        r8 = r2 + r4;
        r2 = 0;
        r4 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1));
        if (r4 <= 0) goto L_0x02fd;
    L_0x02e6:
        r2 = r7.i;	 Catch:{ Throwable -> 0x0469 }
        r3 = r7.t;	 Catch:{ Throwable -> 0x0469 }
        r2 = r2.a(r3);	 Catch:{ Throwable -> 0x0469 }
        r4 = r7.q;	 Catch:{ Throwable -> 0x0469 }
        r8 = r2 + r4;
        r2 = r7.r;	 Catch:{ Throwable -> 0x0469 }
        r4 = r8 + r2;
        r2 = r7.i;	 Catch:{ Throwable -> 0x0469 }
        r3 = r7.t;	 Catch:{ Throwable -> 0x0469 }
        r2.a(r4, r3);	 Catch:{ Throwable -> 0x0469 }
    L_0x02fd:
        r2 = r7.i;	 Catch:{ Throwable -> 0x0469 }
        r3 = 0;
        r2.a(r14, r3);	 Catch:{ Throwable -> 0x0469 }
        r2 = "[Upload] Session ID is invalid, will try again immediately (pid=%d | tid=%d).";
        r3 = new java.lang.Object[r10];	 Catch:{ Throwable -> 0x0469 }
        r4 = android.os.Process.myPid();	 Catch:{ Throwable -> 0x0469 }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Throwable -> 0x0469 }
        r3[r1] = r4;	 Catch:{ Throwable -> 0x0469 }
        r1 = android.os.Process.myTid();	 Catch:{ Throwable -> 0x0469 }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ Throwable -> 0x0469 }
        r3[r11] = r1;	 Catch:{ Throwable -> 0x0469 }
        com.tencent.bugly.proguard.x.a(r2, r3);	 Catch:{ Throwable -> 0x0469 }
        r12 = r7.i;	 Catch:{ Throwable -> 0x0469 }
        r13 = r7.j;	 Catch:{ Throwable -> 0x0469 }
        r14 = r7.d;	 Catch:{ Throwable -> 0x0469 }
        r15 = r7.e;	 Catch:{ Throwable -> 0x0469 }
        r1 = r7.m;	 Catch:{ Throwable -> 0x0469 }
        r2 = r7.n;	 Catch:{ Throwable -> 0x0469 }
        r3 = r7.k;	 Catch:{ Throwable -> 0x0469 }
        r4 = r7.a;	 Catch:{ Throwable -> 0x0469 }
        r5 = r7.b;	 Catch:{ Throwable -> 0x0469 }
        r21 = 1;
        r6 = r7.o;	 Catch:{ Throwable -> 0x0469 }
        r16 = r1;
        r17 = r2;
        r18 = r3;
        r19 = r4;
        r20 = r5;
        r22 = r6;
        r12.a(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);	 Catch:{ Throwable -> 0x0469 }
        return;
    L_0x0344:
        r2 = 0;
        r3 = 0;
        r4 = 1;
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0469 }
        r5 = "status of server is ";
        r1.<init>(r5);	 Catch:{ Throwable -> 0x0469 }
        r1.append(r14);	 Catch:{ Throwable -> 0x0469 }
        r5 = r1.toString();	 Catch:{ Throwable -> 0x0469 }
        r1 = r7;
        r6 = r14;
        r1.a(r2, r3, r4, r5, r6);	 Catch:{ Throwable -> 0x0469 }
        return;
    L_0x035b:
        r2 = 0;
        r12 = r14;
        goto L_0x0361;
    L_0x035f:
        r2 = 0;
    L_0x0361:
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0469 }
        r8 = "[Upload] Failed to upload for format of status header is invalid: ";
        r5.<init>(r8);	 Catch:{ Throwable -> 0x0469 }
        r8 = java.lang.Integer.toString(r12);	 Catch:{ Throwable -> 0x0469 }
        r5.append(r8);	 Catch:{ Throwable -> 0x0469 }
        r5 = r5.toString();	 Catch:{ Throwable -> 0x0469 }
        r8 = "[Upload] Failed to upload(%d): %s";
        r14 = new java.lang.Object[r10];	 Catch:{ Throwable -> 0x0469 }
        r15 = java.lang.Integer.valueOf(r11);	 Catch:{ Throwable -> 0x0469 }
        r14[r1] = r15;	 Catch:{ Throwable -> 0x0469 }
        r14[r11] = r5;	 Catch:{ Throwable -> 0x0469 }
        com.tencent.bugly.proguard.x.e(r8, r14);	 Catch:{ Throwable -> 0x0469 }
        goto L_0x01d7;
    L_0x0384:
        r14 = r12;
    L_0x0385:
        r2 = "[Upload] Received %d bytes";
        r3 = new java.lang.Object[r11];	 Catch:{ Throwable -> 0x0469 }
        r4 = r5.length;	 Catch:{ Throwable -> 0x0469 }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Throwable -> 0x0469 }
        r3[r1] = r4;	 Catch:{ Throwable -> 0x0469 }
        com.tencent.bugly.proguard.x.c(r2, r3);	 Catch:{ Throwable -> 0x0469 }
        r2 = r7.s;	 Catch:{ Throwable -> 0x0469 }
        if (r2 == 0) goto L_0x03f1;
    L_0x0397:
        r2 = r5.length;	 Catch:{ Throwable -> 0x0469 }
        if (r2 != 0) goto L_0x03cd;
    L_0x039a:
        r2 = r8.entrySet();	 Catch:{ Throwable -> 0x0469 }
        r2 = r2.iterator();	 Catch:{ Throwable -> 0x0469 }
    L_0x03a2:
        r3 = r2.hasNext();	 Catch:{ Throwable -> 0x0469 }
        if (r3 == 0) goto L_0x03c2;
    L_0x03a8:
        r3 = r2.next();	 Catch:{ Throwable -> 0x0469 }
        r3 = (java.util.Map.Entry) r3;	 Catch:{ Throwable -> 0x0469 }
        r4 = "[Upload] HTTP headers from server: key = %s, value = %s";
        r5 = new java.lang.Object[r10];	 Catch:{ Throwable -> 0x0469 }
        r6 = r3.getKey();	 Catch:{ Throwable -> 0x0469 }
        r5[r1] = r6;	 Catch:{ Throwable -> 0x0469 }
        r3 = r3.getValue();	 Catch:{ Throwable -> 0x0469 }
        r5[r11] = r3;	 Catch:{ Throwable -> 0x0469 }
        com.tencent.bugly.proguard.x.c(r4, r5);	 Catch:{ Throwable -> 0x0469 }
        goto L_0x03a2;
    L_0x03c2:
        r2 = 0;
        r3 = 0;
        r4 = 1;
        r5 = "response data from server is empty";
        r6 = 0;
        r1 = r7;
        r1.a(r2, r3, r4, r5, r6);	 Catch:{ Throwable -> 0x0469 }
        return;
    L_0x03cd:
        r2 = r7.i;	 Catch:{ Throwable -> 0x0469 }
        r2 = r2.b(r5);	 Catch:{ Throwable -> 0x0469 }
        if (r2 != 0) goto L_0x03e0;
    L_0x03d5:
        r2 = 0;
        r3 = 0;
        r4 = 1;
        r5 = "failed to decrypt response from server";
        r6 = 0;
        r1 = r7;
        r1.a(r2, r3, r4, r5, r6);	 Catch:{ Throwable -> 0x0469 }
        return;
    L_0x03e0:
        r5 = com.tencent.bugly.proguard.z.b(r2, r10);	 Catch:{ Throwable -> 0x0469 }
        if (r5 != 0) goto L_0x03f1;
    L_0x03e6:
        r2 = 0;
        r3 = 0;
        r4 = 1;
        r5 = "failed unzip(Gzip) response from server";
        r6 = 0;
        r1 = r7;
        r1.a(r2, r3, r4, r5, r6);	 Catch:{ Throwable -> 0x0469 }
        return;
    L_0x03f1:
        r2 = r7.s;	 Catch:{ Throwable -> 0x0469 }
        r2 = com.tencent.bugly.proguard.a.a(r5, r2);	 Catch:{ Throwable -> 0x0469 }
        if (r2 != 0) goto L_0x0404;
    L_0x03f9:
        r2 = 0;
        r3 = 0;
        r4 = 1;
        r5 = "failed to decode response package";
        r6 = 0;
        r1 = r7;
        r1.a(r2, r3, r4, r5, r6);	 Catch:{ Throwable -> 0x0469 }
        return;
    L_0x0404:
        r3 = r7.s;	 Catch:{ Throwable -> 0x0469 }
        if (r3 == 0) goto L_0x040d;
    L_0x0408:
        r3 = r7.i;	 Catch:{ Throwable -> 0x0469 }
        r3.a(r14, r2);	 Catch:{ Throwable -> 0x0469 }
    L_0x040d:
        r3 = "[Upload] Response cmd is: %d, length of sBuffer is: %d";
        r4 = new java.lang.Object[r10];	 Catch:{ Throwable -> 0x0469 }
        r5 = r2.b;	 Catch:{ Throwable -> 0x0469 }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Throwable -> 0x0469 }
        r4[r1] = r5;	 Catch:{ Throwable -> 0x0469 }
        r5 = r2.c;	 Catch:{ Throwable -> 0x0469 }
        if (r5 != 0) goto L_0x041e;
    L_0x041d:
        goto L_0x0421;
    L_0x041e:
        r1 = r2.c;	 Catch:{ Throwable -> 0x0469 }
        r1 = r1.length;	 Catch:{ Throwable -> 0x0469 }
    L_0x0421:
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ Throwable -> 0x0469 }
        r4[r11] = r1;	 Catch:{ Throwable -> 0x0469 }
        com.tencent.bugly.proguard.x.c(r3, r4);	 Catch:{ Throwable -> 0x0469 }
        r1 = r7.f;	 Catch:{ Throwable -> 0x0469 }
        r3 = r7.g;	 Catch:{ Throwable -> 0x0469 }
        r1 = a(r2, r1, r3);	 Catch:{ Throwable -> 0x0469 }
        if (r1 != 0) goto L_0x043e;
    L_0x0434:
        r3 = 0;
        r4 = 2;
        r5 = "failed to process response package";
        r6 = 0;
        r1 = r7;
        r1.a(r2, r3, r4, r5, r6);	 Catch:{ Throwable -> 0x0469 }
        return;
    L_0x043e:
        r3 = 1;
        r4 = 2;
        r5 = "successfully uploaded";
        r6 = 0;
        r1 = r7;
        r1.a(r2, r3, r4, r5, r6);	 Catch:{ Throwable -> 0x0469 }
        return;
    L_0x0448:
        r2 = 0;
        r3 = 0;
        r5 = "failed after many attempts";
        r6 = 0;
        r1 = r7;
        r4 = r8;
        r1.a(r2, r3, r4, r5, r6);	 Catch:{ Throwable -> 0x0469 }
        return;
    L_0x0453:
        r2 = 0;
        r3 = 0;
        r4 = 0;
        r5 = "illegal access error";
        r6 = 0;
        r1 = r7;
        r1.a(r2, r3, r4, r5, r6);	 Catch:{ Throwable -> 0x0469 }
        return;
    L_0x045e:
        r2 = 0;
        r3 = 0;
        r4 = 0;
        r5 = "request package is empty!";
        r6 = 0;
        r1 = r7;
        r1.a(r2, r3, r4, r5, r6);	 Catch:{ Throwable -> 0x0469 }
        return;
    L_0x0469:
        r0 = move-exception;
        r1 = r0;
        r2 = com.tencent.bugly.proguard.x.a(r1);
        if (r2 != 0) goto L_0x0474;
    L_0x0471:
        r1.printStackTrace();
    L_0x0474:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.v.run():void");
    }
}
