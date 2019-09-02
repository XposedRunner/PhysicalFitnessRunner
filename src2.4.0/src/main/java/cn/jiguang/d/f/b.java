package cn.jiguang.d.f;

import android.content.Context;

final class b implements Runnable {
    final /* synthetic */ a a;
    private Context b;

    public b(a aVar, Context context) {
        this.a = aVar;
        this.b = context;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x006b A:{SYNTHETIC, Splitter:B:14:0x006b} */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01c4 A:{Splitter:B:1:0x0003, ExcHandler: all (r0_0 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01c4 A:{Splitter:B:1:0x0003, ExcHandler: all (r0_0 'th' java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:64:0x01c2, code skipped:
            r4 = false;
     */
    /* JADX WARNING: Missing block: B:66:0x01c4, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:67:0x01c5, code skipped:
            r2 = r0;
            r1.a.h = false;
            cn.jiguang.d.f.a.b(r1.a, r1.b);
     */
    /* JADX WARNING: Missing block: B:69:0x01d4, code skipped:
            r4 = false;
     */
    public final void run() {
        /*
        r23 = this;
        r1 = r23;
        r2 = 0;
        r3 = new java.util.ArrayList;	 Catch:{ Throwable -> 0x01d4, all -> 0x01c4 }
        r3.<init>();	 Catch:{ Throwable -> 0x01d4, all -> 0x01c4 }
        r3 = r1.a;	 Catch:{ Throwable -> 0x01d4, all -> 0x01c4 }
        r4 = r1.b;	 Catch:{ Throwable -> 0x01d4, all -> 0x01c4 }
        r4 = cn.jiguang.d.a.d.r(r4);	 Catch:{ Throwable -> 0x01d4, all -> 0x01c4 }
        r3.d = r4;	 Catch:{ Throwable -> 0x01d4, all -> 0x01c4 }
        r3 = r1.b;	 Catch:{ Throwable -> 0x01d4, all -> 0x01c4 }
        r3 = cn.jiguang.d.a.d.t(r3);	 Catch:{ Throwable -> 0x01d4, all -> 0x01c4 }
        r5 = r1.a;	 Catch:{ Throwable -> 0x01d4, all -> 0x01c4 }
        r5 = r5.d;	 Catch:{ Throwable -> 0x01d4, all -> 0x01c4 }
        r5 = android.text.TextUtils.isEmpty(r5);	 Catch:{ Throwable -> 0x01d4, all -> 0x01c4 }
        r6 = 0;
        if (r5 != 0) goto L_0x002e;
    L_0x0027:
        r5 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1));
        if (r5 >= 0) goto L_0x002c;
    L_0x002b:
        goto L_0x002e;
    L_0x002c:
        r5 = r2;
        goto L_0x0050;
    L_0x002e:
        r3 = r1.a;	 Catch:{ Throwable -> 0x01d4, all -> 0x01c4 }
        r4 = java.util.UUID.randomUUID();	 Catch:{ Throwable -> 0x01d4, all -> 0x01c4 }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x01d4, all -> 0x01c4 }
        r3.d = r4;	 Catch:{ Throwable -> 0x01d4, all -> 0x01c4 }
        r3 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x01d4, all -> 0x01c4 }
        r5 = r1.b;	 Catch:{ Throwable -> 0x01d4, all -> 0x01c4 }
        cn.jiguang.d.a.d.f(r5, r3);	 Catch:{ Throwable -> 0x01d4, all -> 0x01c4 }
        r5 = r1.b;	 Catch:{ Throwable -> 0x01d4, all -> 0x01c4 }
        r8 = r1.a;	 Catch:{ Throwable -> 0x01d4, all -> 0x01c4 }
        r8 = r8.d;	 Catch:{ Throwable -> 0x01d4, all -> 0x01c4 }
        cn.jiguang.d.a.d.f(r5, r8);	 Catch:{ Throwable -> 0x01d4, all -> 0x01c4 }
        r5 = 1;
    L_0x0050:
        r8 = r1.a;	 Catch:{ Throwable -> 0x01d4, all -> 0x01c4 }
        r9 = r1.b;	 Catch:{ Throwable -> 0x01d4, all -> 0x01c4 }
        r8 = r8.b(r9);	 Catch:{ Throwable -> 0x01d4, all -> 0x01c4 }
        r9 = r8.isEmpty();	 Catch:{ Throwable -> 0x01d4, all -> 0x01c4 }
        if (r9 == 0) goto L_0x006b;
    L_0x005e:
        r3 = r1.a;
        r3.h = false;
    L_0x0063:
        r2 = r1.a;
        r3 = r1.b;
        cn.jiguang.d.f.a.b(r2, r3);
        return;
    L_0x006b:
        r9 = cn.jiguang.d.a.a.v();	 Catch:{ Throwable -> 0x01d4, all -> 0x01c4 }
        r10 = new java.util.ArrayList;	 Catch:{ Throwable -> 0x01d4, all -> 0x01c4 }
        r10.<init>();	 Catch:{ Throwable -> 0x01d4, all -> 0x01c4 }
        r11 = r2;
    L_0x0075:
        r12 = r8.size();	 Catch:{ Throwable -> 0x01d4, all -> 0x01c4 }
        if (r11 >= r12) goto L_0x00a5;
    L_0x007b:
        r12 = r8.get(r11);	 Catch:{ Throwable -> 0x01d4, all -> 0x01c4 }
        r12 = (cn.jiguang.d.f.c) r12;	 Catch:{ Throwable -> 0x01d4, all -> 0x01c4 }
        r13 = r12.b;	 Catch:{ Throwable -> 0x01d4, all -> 0x01c4 }
        if (r9 != r13) goto L_0x00a2;
    L_0x0087:
        r13 = r12.d;	 Catch:{ Throwable -> 0x01d4, all -> 0x01c4 }
        r15 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1));
        if (r15 <= 0) goto L_0x00a2;
    L_0x008f:
        r13 = r1.b;	 Catch:{ Throwable -> 0x01d4, all -> 0x01c4 }
        r13 = r13.getPackageName();	 Catch:{ Throwable -> 0x01d4, all -> 0x01c4 }
        r14 = r12.e;	 Catch:{ Throwable -> 0x01d4, all -> 0x01c4 }
        r13 = r13.equals(r14);	 Catch:{ Throwable -> 0x01d4, all -> 0x01c4 }
        if (r13 != 0) goto L_0x00a2;
    L_0x009f:
        r10.add(r12);	 Catch:{ Throwable -> 0x01d4, all -> 0x01c4 }
    L_0x00a2:
        r11 = r11 + 1;
        goto L_0x0075;
    L_0x00a5:
        r8 = r10.size();	 Catch:{ Throwable -> 0x01d4, all -> 0x01c4 }
        if (r8 != 0) goto L_0x00ac;
    L_0x00ab:
        goto L_0x005e;
    L_0x00ac:
        r8 = "";
        r9 = "";
        r11 = r1.a;	 Catch:{ Throwable -> 0x01d4, all -> 0x01c4 }
        r12 = r10.size();	 Catch:{ Throwable -> 0x01d4, all -> 0x01c4 }
        r12 = new long[r12];	 Catch:{ Throwable -> 0x01d4, all -> 0x01c4 }
        r11.c = r12;	 Catch:{ Throwable -> 0x01d4, all -> 0x01c4 }
        r15 = r9;
        r13 = -1;
        r9 = r8;
        r8 = r2;
    L_0x00c0:
        r2 = r10.size();	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        if (r8 >= r2) goto L_0x0149;
    L_0x00c6:
        r2 = r1.a;	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        r2 = r2.c;	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        r16 = r10.get(r8);	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        r11 = r16;
        r11 = (cn.jiguang.d.f.c) r11;	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        r11 = r11.d;	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        r2[r8] = r11;	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        r2.<init>();	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        r2.append(r15);	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        r11 = r10.get(r8);	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        r11 = (cn.jiguang.d.f.c) r11;	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        r11 = r11.d;	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        r2.append(r11);	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        r11 = ",";
        r2.append(r11);	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        r15 = r2.toString();	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        r2 = r10.get(r8);	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        r2 = (cn.jiguang.d.f.c) r2;	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        r2 = r2.c;	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        r2 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        if (r2 != 0) goto L_0x0143;
    L_0x0108:
        r2 = r10.get(r8);	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        r2 = (cn.jiguang.d.f.c) r2;	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        r11 = r2.h;	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        r2 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1));
        if (r2 <= 0) goto L_0x0143;
    L_0x0116:
        r2 = r10.get(r8);	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        r2 = (cn.jiguang.d.f.c) r2;	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        r11 = r2.h;	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        r2 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1));
        if (r2 < 0) goto L_0x012b;
    L_0x0124:
        r11 = -1;
        r2 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1));
        if (r2 != 0) goto L_0x0145;
    L_0x012a:
        goto L_0x012d;
    L_0x012b:
        r11 = -1;
    L_0x012d:
        r2 = r10.get(r8);	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        r2 = (cn.jiguang.d.f.c) r2;	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        r2 = r2.c;	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        r9 = r10.get(r8);	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        r9 = (cn.jiguang.d.f.c) r9;	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        r13 = r9.h;	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        r9 = r2;
        goto L_0x0145;
    L_0x0143:
        r11 = -1;
    L_0x0145:
        r8 = r8 + 1;
        goto L_0x00c0;
    L_0x0149:
        r2 = android.text.TextUtils.isEmpty(r9);	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        if (r2 != 0) goto L_0x0190;
    L_0x014f:
        if (r5 == 0) goto L_0x0167;
    L_0x0151:
        r2 = r1.a;	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        r2.d = r9;	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        r2 = r1.b;	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        r3 = r1.a;	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        r3 = r3.d;	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        cn.jiguang.d.a.d.f(r2, r3);	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        r2 = r1.b;	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        cn.jiguang.d.a.d.f(r2, r13);	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        goto L_0x0190;
    L_0x0167:
        r2 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1));
        if (r2 == 0) goto L_0x0176;
    L_0x016b:
        r2 = r1.b;	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        cn.jiguang.d.a.d.f(r2, r9);	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        r2 = r1.b;	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        cn.jiguang.d.a.d.f(r2, r13);	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        goto L_0x018b;
    L_0x0176:
        r2 = r1.a;	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        r2 = r2.d;	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        r2 = r2.equals(r9);	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        if (r2 != 0) goto L_0x018b;
    L_0x0182:
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        r4 = r1.b;	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        cn.jiguang.d.a.d.f(r4, r2);	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
    L_0x018b:
        r2 = r1.a;	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        r2.d = r9;	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
    L_0x0190:
        r16 = cn.jiguang.api.JCoreInterface.getNextRid();	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        r18 = cn.jiguang.api.JCoreInterface.getSid();	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        r2 = r1.b;	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        r19 = cn.jiguang.d.a.d.c(r2);	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        r2 = r1.a;	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        r21 = r2.d;	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        r2 = r1.a;	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        r22 = r2.c;	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        r2 = cn.jiguang.d.e.a.a.b.a(r16, r18, r19, r21, r22);	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        cn.jiguang.d.b.d.a();	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        r3 = cn.jiguang.api.SdkType.JCORE;	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        r3 = r3.name();	 Catch:{ Throwable -> 0x01c2, all -> 0x01c4 }
        r4 = 0;
        cn.jiguang.d.b.d.a(r2, r3, r4);	 Catch:{ Throwable -> 0x01bb, all -> 0x01c4 }
    L_0x01bb:
        r2 = r1.a;
        r2.h = false;
        goto L_0x0063;
    L_0x01c2:
        r4 = 0;
        goto L_0x01bb;
    L_0x01c4:
        r0 = move-exception;
        r2 = r0;
        r3 = r1.a;
        r4 = 0;
        r3.h = false;
        r3 = r1.a;
        r4 = r1.b;
        cn.jiguang.d.f.a.b(r3, r4);
        throw r2;
    L_0x01d4:
        r4 = r2;
        goto L_0x01bb;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.d.f.b.run():void");
    }
}
