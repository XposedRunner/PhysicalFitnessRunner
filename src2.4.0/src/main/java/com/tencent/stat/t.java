package com.tencent.stat;

class t implements Runnable {
    final /* synthetic */ n a;

    t(n nVar) {
        this.a = nVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A:{SYNTHETIC, RETURN} */
    public void run() {
        /*
        r11 = this;
        r0 = 0;
        r1 = r11.a;	 Catch:{ Throwable -> 0x0051, all -> 0x004c }
        r1 = r1.d;	 Catch:{ Throwable -> 0x0051, all -> 0x004c }
        r2 = r1.getReadableDatabase();	 Catch:{ Throwable -> 0x0051, all -> 0x004c }
        r3 = "config";
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r1 = r2.query(r3, r4, r5, r6, r7, r8, r9);	 Catch:{ Throwable -> 0x0051, all -> 0x004c }
    L_0x0017:
        r0 = r1.moveToNext();	 Catch:{ Throwable -> 0x004a }
        if (r0 == 0) goto L_0x0047;
    L_0x001d:
        r0 = 0;
        r0 = r1.getInt(r0);	 Catch:{ Throwable -> 0x004a }
        r2 = 1;
        r2 = r1.getString(r2);	 Catch:{ Throwable -> 0x004a }
        r3 = 2;
        r3 = r1.getString(r3);	 Catch:{ Throwable -> 0x004a }
        r4 = 3;
        r4 = r1.getInt(r4);	 Catch:{ Throwable -> 0x004a }
        r5 = new com.tencent.stat.b;	 Catch:{ Throwable -> 0x004a }
        r5.<init>(r0);	 Catch:{ Throwable -> 0x004a }
        r5.a = r0;	 Catch:{ Throwable -> 0x004a }
        r0 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x004a }
        r0.<init>(r2);	 Catch:{ Throwable -> 0x004a }
        r5.b = r0;	 Catch:{ Throwable -> 0x004a }
        r5.c = r3;	 Catch:{ Throwable -> 0x004a }
        r5.d = r4;	 Catch:{ Throwable -> 0x004a }
        com.tencent.stat.StatConfig.a(r5);	 Catch:{ Throwable -> 0x004a }
        goto L_0x0017;
    L_0x0047:
        if (r1 == 0) goto L_0x0061;
    L_0x0049:
        goto L_0x005e;
    L_0x004a:
        r0 = move-exception;
        goto L_0x0055;
    L_0x004c:
        r1 = move-exception;
        r10 = r1;
        r1 = r0;
        r0 = r10;
        goto L_0x0063;
    L_0x0051:
        r1 = move-exception;
        r10 = r1;
        r1 = r0;
        r0 = r10;
    L_0x0055:
        r2 = com.tencent.stat.n.e;	 Catch:{ all -> 0x0062 }
        r2.e(r0);	 Catch:{ all -> 0x0062 }
        if (r1 == 0) goto L_0x0061;
    L_0x005e:
        r1.close();
    L_0x0061:
        return;
    L_0x0062:
        r0 = move-exception;
    L_0x0063:
        if (r1 == 0) goto L_0x0068;
    L_0x0065:
        r1.close();
    L_0x0068:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.t.run():void");
    }
}
