package com.tencent.stat;

import com.tencent.stat.a.e;

class k implements Runnable {
    private e a;
    private StatReportStrategy b = null;
    private c c = new l(this);

    public k(e eVar) {
        this.a = eVar;
        this.b = StatConfig.getStatSendStrategy();
    }

    private void a() {
        if (n.b().a() > 0) {
            n.b().a(this.a, null);
            n.b().a(-1);
            return;
        }
        a(true);
    }

    private void a(boolean z) {
        d.b().a(this.a, this.c);
    }

    /* JADX WARNING: Missing block: B:48:0x013b, code skipped:
            r0.a(r1, r2);
     */
    /* JADX WARNING: Missing block: B:49:0x013e, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:53:0x014c, code skipped:
            a();
     */
    /* JADX WARNING: Missing block: B:54:0x014f, code skipped:
            return;
     */
    public void run() {
        /*
        r10 = this;
        r0 = com.tencent.stat.StatConfig.isEnableStatService();	 Catch:{ Throwable -> 0x0170 }
        if (r0 != 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r0 = r10.a;	 Catch:{ Throwable -> 0x0170 }
        r0 = r0.a();	 Catch:{ Throwable -> 0x0170 }
        r1 = com.tencent.stat.a.f.ERROR;	 Catch:{ Throwable -> 0x0170 }
        if (r0 == r1) goto L_0x003e;
    L_0x0011:
        r0 = r10.a;	 Catch:{ Throwable -> 0x0170 }
        r0 = r0.d();	 Catch:{ Throwable -> 0x0170 }
        r0 = r0.length();	 Catch:{ Throwable -> 0x0170 }
        r1 = com.tencent.stat.StatConfig.getMaxReportEventLength();	 Catch:{ Throwable -> 0x0170 }
        if (r0 <= r1) goto L_0x003e;
    L_0x0021:
        r0 = com.tencent.stat.StatService.i;	 Catch:{ Throwable -> 0x0170 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0170 }
        r1.<init>();	 Catch:{ Throwable -> 0x0170 }
        r2 = "Event length exceed StatConfig.getMaxReportEventLength(): ";
        r1.append(r2);	 Catch:{ Throwable -> 0x0170 }
        r2 = com.tencent.stat.StatConfig.getMaxReportEventLength();	 Catch:{ Throwable -> 0x0170 }
        r1.append(r2);	 Catch:{ Throwable -> 0x0170 }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x0170 }
        r0.e(r1);	 Catch:{ Throwable -> 0x0170 }
        return;
    L_0x003e:
        r0 = com.tencent.stat.StatConfig.getMaxSessionStatReportCount();	 Catch:{ Throwable -> 0x0170 }
        if (r0 <= 0) goto L_0x005b;
    L_0x0044:
        r0 = com.tencent.stat.StatConfig.getCurSessionStatReportCount();	 Catch:{ Throwable -> 0x0170 }
        r1 = com.tencent.stat.StatConfig.getMaxSessionStatReportCount();	 Catch:{ Throwable -> 0x0170 }
        if (r0 < r1) goto L_0x0058;
    L_0x004e:
        r0 = com.tencent.stat.StatService.i;	 Catch:{ Throwable -> 0x0170 }
        r1 = "Times for reporting events has reached the limit of StatConfig.getMaxSessionStatReportCount() in current session.";
        r0.e(r1);	 Catch:{ Throwable -> 0x0170 }
        return;
    L_0x0058:
        com.tencent.stat.StatConfig.c();	 Catch:{ Throwable -> 0x0170 }
    L_0x005b:
        r0 = com.tencent.stat.StatService.i;	 Catch:{ Throwable -> 0x0170 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0170 }
        r1.<init>();	 Catch:{ Throwable -> 0x0170 }
        r2 = "Lauch stat task in thread:";
        r1.append(r2);	 Catch:{ Throwable -> 0x0170 }
        r2 = java.lang.Thread.currentThread();	 Catch:{ Throwable -> 0x0170 }
        r2 = r2.getName();	 Catch:{ Throwable -> 0x0170 }
        r1.append(r2);	 Catch:{ Throwable -> 0x0170 }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x0170 }
        r0.i(r1);	 Catch:{ Throwable -> 0x0170 }
        r0 = r10.a;	 Catch:{ Throwable -> 0x0170 }
        r0 = r0.c();	 Catch:{ Throwable -> 0x0170 }
        r1 = com.tencent.stat.common.k.h(r0);	 Catch:{ Throwable -> 0x0170 }
        r2 = 0;
        if (r1 != 0) goto L_0x0092;
    L_0x0088:
        r0 = com.tencent.stat.n.a(r0);	 Catch:{ Throwable -> 0x0170 }
        r1 = r10.a;	 Catch:{ Throwable -> 0x0170 }
        r0.a(r1, r2);	 Catch:{ Throwable -> 0x0170 }
        return;
    L_0x0092:
        r1 = com.tencent.stat.StatConfig.isEnableSmartReporting();	 Catch:{ Throwable -> 0x0170 }
        if (r1 == 0) goto L_0x00a8;
    L_0x0098:
        r1 = r10.b;	 Catch:{ Throwable -> 0x0170 }
        r3 = com.tencent.stat.StatReportStrategy.ONLY_WIFI_NO_CACHE;	 Catch:{ Throwable -> 0x0170 }
        if (r1 == r3) goto L_0x00a8;
    L_0x009e:
        r1 = com.tencent.stat.common.k.g(r0);	 Catch:{ Throwable -> 0x0170 }
        if (r1 == 0) goto L_0x00a8;
    L_0x00a4:
        r1 = com.tencent.stat.StatReportStrategy.INSTANT;	 Catch:{ Throwable -> 0x0170 }
        r10.b = r1;	 Catch:{ Throwable -> 0x0170 }
    L_0x00a8:
        r1 = com.tencent.stat.h.a;	 Catch:{ Throwable -> 0x0170 }
        r3 = r10.b;	 Catch:{ Throwable -> 0x0170 }
        r3 = r3.ordinal();	 Catch:{ Throwable -> 0x0170 }
        r1 = r1[r3];	 Catch:{ Throwable -> 0x0170 }
        switch(r1) {
            case 1: goto L_0x014c;
            case 2: goto L_0x0146;
            case 3: goto L_0x013f;
            case 4: goto L_0x013f;
            case 5: goto L_0x0123;
            case 6: goto L_0x00c6;
            case 7: goto L_0x00bb;
            default: goto L_0x00b5;
        };	 Catch:{ Throwable -> 0x0170 }
    L_0x00b5:
        r0 = com.tencent.stat.StatService.i;	 Catch:{ Throwable -> 0x0170 }
        goto L_0x0157;
    L_0x00bb:
        r0 = com.tencent.stat.common.k.e(r0);	 Catch:{ Throwable -> 0x0170 }
        if (r0 == 0) goto L_0x0178;
    L_0x00c1:
        r0 = 0;
        r10.a(r0);	 Catch:{ Throwable -> 0x0170 }
        return;
    L_0x00c6:
        r1 = com.tencent.stat.n.a(r0);	 Catch:{ Exception -> 0x011a }
        r3 = r10.a;	 Catch:{ Exception -> 0x011a }
        r1.a(r3, r2);	 Catch:{ Exception -> 0x011a }
        r1 = "last_period_ts";
        r2 = 0;
        r2 = com.tencent.stat.common.p.a(r0, r1, r2);	 Catch:{ Exception -> 0x011a }
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ Exception -> 0x011a }
        r3 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x011a }
        r3 = java.lang.Long.valueOf(r3);	 Catch:{ Exception -> 0x011a }
        r4 = r3.longValue();	 Catch:{ Exception -> 0x011a }
        r6 = r2.longValue();	 Catch:{ Exception -> 0x011a }
        r8 = r4 - r6;
        r2 = java.lang.Long.valueOf(r8);	 Catch:{ Exception -> 0x011a }
        r4 = r2.longValue();	 Catch:{ Exception -> 0x011a }
        r6 = 60000; // 0xea60 float:8.4078E-41 double:2.9644E-319;
        r4 = r4 / r6;
        r2 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x011a }
        r4 = r2.longValue();	 Catch:{ Exception -> 0x011a }
        r2 = com.tencent.stat.StatConfig.getSendPeriodMinutes();	 Catch:{ Exception -> 0x011a }
        r6 = (long) r2;	 Catch:{ Exception -> 0x011a }
        r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r2 <= 0) goto L_0x0178;
    L_0x010a:
        r2 = com.tencent.stat.n.a(r0);	 Catch:{ Exception -> 0x011a }
        r4 = -1;
        r2.a(r4);	 Catch:{ Exception -> 0x011a }
        r2 = r3.longValue();	 Catch:{ Exception -> 0x011a }
        com.tencent.stat.common.p.b(r0, r1, r2);	 Catch:{ Exception -> 0x011a }
        return;
    L_0x011a:
        r0 = move-exception;
        r1 = com.tencent.stat.StatService.i;	 Catch:{ Throwable -> 0x0170 }
        r1.e(r0);	 Catch:{ Throwable -> 0x0170 }
        return;
    L_0x0123:
        r1 = r10.a;	 Catch:{ Throwable -> 0x0170 }
        r1 = r1.c();	 Catch:{ Throwable -> 0x0170 }
        r1 = com.tencent.stat.n.a(r1);	 Catch:{ Throwable -> 0x0170 }
        if (r1 != 0) goto L_0x0130;
    L_0x012f:
        return;
    L_0x0130:
        r0 = com.tencent.stat.n.a(r0);	 Catch:{ Throwable -> 0x0170 }
        r1 = r10.a;	 Catch:{ Throwable -> 0x0170 }
        r2 = new com.tencent.stat.m;	 Catch:{ Throwable -> 0x0170 }
        r2.<init>(r10);	 Catch:{ Throwable -> 0x0170 }
    L_0x013b:
        r0.a(r1, r2);	 Catch:{ Throwable -> 0x0170 }
        return;
    L_0x013f:
        r0 = com.tencent.stat.n.a(r0);	 Catch:{ Throwable -> 0x0170 }
        r1 = r10.a;	 Catch:{ Throwable -> 0x0170 }
        goto L_0x013b;
    L_0x0146:
        r1 = com.tencent.stat.common.k.e(r0);	 Catch:{ Throwable -> 0x0170 }
        if (r1 == 0) goto L_0x0150;
    L_0x014c:
        r10.a();	 Catch:{ Throwable -> 0x0170 }
        return;
    L_0x0150:
        r0 = com.tencent.stat.n.a(r0);	 Catch:{ Throwable -> 0x0170 }
        r1 = r10.a;	 Catch:{ Throwable -> 0x0170 }
        goto L_0x013b;
    L_0x0157:
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0170 }
        r1.<init>();	 Catch:{ Throwable -> 0x0170 }
        r2 = "Invalid stat strategy:";
        r1.append(r2);	 Catch:{ Throwable -> 0x0170 }
        r2 = com.tencent.stat.StatConfig.getStatSendStrategy();	 Catch:{ Throwable -> 0x0170 }
        r1.append(r2);	 Catch:{ Throwable -> 0x0170 }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x0170 }
        r0.error(r1);	 Catch:{ Throwable -> 0x0170 }
        return;
    L_0x0170:
        r0 = move-exception;
        r1 = com.tencent.stat.StatService.i;
        r1.e(r0);
    L_0x0178:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.k.run():void");
    }
}
