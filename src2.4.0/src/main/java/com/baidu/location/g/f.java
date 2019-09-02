package com.baidu.location.g;

class f extends Thread {
    final /* synthetic */ e a;

    f(e eVar) {
        this.a = eVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:68:0x00ee A:{LOOP_END, LOOP:0: B:1:0x0018->B:68:0x00ee} */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x010f A:{SYNTHETIC, EDGE_INSN: B:90:0x010f->B:84:0x010f ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00fc A:{SYNTHETIC, Splitter:B:74:0x00fc} */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0106 A:{SYNTHETIC, Splitter:B:79:0x0106} */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00d8 A:{SYNTHETIC, Splitter:B:57:0x00d8} */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00e2 A:{SYNTHETIC, Splitter:B:62:0x00e2} */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x010f A:{SYNTHETIC, EDGE_INSN: B:90:0x010f->B:84:0x010f ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00ee A:{LOOP_END, LOOP:0: B:1:0x0018->B:68:0x00ee} */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00fc A:{SYNTHETIC, Splitter:B:74:0x00fc} */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0106 A:{SYNTHETIC, Splitter:B:79:0x0106} */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00d8 A:{SYNTHETIC, Splitter:B:57:0x00d8} */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00e2 A:{SYNTHETIC, Splitter:B:62:0x00e2} */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00ee A:{LOOP_END, LOOP:0: B:1:0x0018->B:68:0x00ee} */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x010f A:{SYNTHETIC, EDGE_INSN: B:90:0x010f->B:84:0x010f ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00fc A:{SYNTHETIC, Splitter:B:74:0x00fc} */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0106 A:{SYNTHETIC, Splitter:B:79:0x0106} */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00d8 A:{SYNTHETIC, Splitter:B:57:0x00d8} */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00e2 A:{SYNTHETIC, Splitter:B:62:0x00e2} */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x010f A:{SYNTHETIC, EDGE_INSN: B:90:0x010f->B:84:0x010f ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00ee A:{LOOP_END, LOOP:0: B:1:0x0018->B:68:0x00ee} */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00fc A:{SYNTHETIC, Splitter:B:74:0x00fc} */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0106 A:{SYNTHETIC, Splitter:B:79:0x0106} */
    public void run() {
        /*
        r12 = this;
        r0 = r12.a;
        r1 = com.baidu.location.g.j.d();
        r0.h = r1;
        r0 = r12.a;
        r0.b();
        r0 = r12.a;
        r0.a();
        r0 = r12.a;
        r0 = r0.i;
        r1 = 0;
        r2 = r1;
    L_0x0018:
        r3 = 1;
        r4 = 0;
        if (r0 <= 0) goto L_0x010f;
    L_0x001c:
        r5 = new java.net.URL;	 Catch:{ Exception -> 0x00c8, all -> 0x00c4 }
        r6 = r12.a;	 Catch:{ Exception -> 0x00c8, all -> 0x00c4 }
        r6 = r6.h;	 Catch:{ Exception -> 0x00c8, all -> 0x00c4 }
        r5.<init>(r6);	 Catch:{ Exception -> 0x00c8, all -> 0x00c4 }
        r5 = r5.openConnection();	 Catch:{ Exception -> 0x00c8, all -> 0x00c4 }
        r5 = (java.net.HttpURLConnection) r5;	 Catch:{ Exception -> 0x00c8, all -> 0x00c4 }
        r2 = "GET";
        r5.setRequestMethod(r2);	 Catch:{ Exception -> 0x00c0, all -> 0x00bd }
        r5.setDoInput(r3);	 Catch:{ Exception -> 0x00c0, all -> 0x00bd }
        r5.setDoOutput(r3);	 Catch:{ Exception -> 0x00c0, all -> 0x00bd }
        r5.setUseCaches(r4);	 Catch:{ Exception -> 0x00c0, all -> 0x00bd }
        r2 = com.baidu.location.g.a.b;	 Catch:{ Exception -> 0x00c0, all -> 0x00bd }
        r5.setConnectTimeout(r2);	 Catch:{ Exception -> 0x00c0, all -> 0x00bd }
        r2 = com.baidu.location.g.a.b;	 Catch:{ Exception -> 0x00c0, all -> 0x00bd }
        r5.setReadTimeout(r2);	 Catch:{ Exception -> 0x00c0, all -> 0x00bd }
        r2 = "Content-Type";
        r6 = "application/x-www-form-urlencoded; charset=utf-8";
        r5.setRequestProperty(r2, r6);	 Catch:{ Exception -> 0x00c0, all -> 0x00bd }
        r2 = "Accept-Charset";
        r6 = "UTF-8";
        r5.setRequestProperty(r2, r6);	 Catch:{ Exception -> 0x00c0, all -> 0x00bd }
        r2 = r5.getResponseCode();	 Catch:{ Exception -> 0x00c0, all -> 0x00bd }
        r6 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r2 != r6) goto L_0x009c;
    L_0x0059:
        r2 = r5.getInputStream();	 Catch:{ Exception -> 0x00c0, all -> 0x00bd }
        r6 = new java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x0097, all -> 0x0092 }
        r6.<init>();	 Catch:{ Exception -> 0x0097, all -> 0x0092 }
        r7 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r7 = new byte[r7];	 Catch:{ Exception -> 0x0098, all -> 0x0090 }
    L_0x0066:
        r8 = r2.read(r7);	 Catch:{ Exception -> 0x0098, all -> 0x0090 }
        r9 = -1;
        if (r8 == r9) goto L_0x0071;
    L_0x006d:
        r6.write(r7, r4, r8);	 Catch:{ Exception -> 0x0098, all -> 0x0090 }
        goto L_0x0066;
    L_0x0071:
        r2.close();	 Catch:{ Exception -> 0x0098, all -> 0x0090 }
        r6.close();	 Catch:{ Exception -> 0x0098, all -> 0x0090 }
        r7 = r12.a;	 Catch:{ Exception -> 0x0098, all -> 0x0090 }
        r8 = new java.lang.String;	 Catch:{ Exception -> 0x0098, all -> 0x0090 }
        r9 = r6.toByteArray();	 Catch:{ Exception -> 0x0098, all -> 0x0090 }
        r10 = "utf-8";
        r8.<init>(r9, r10);	 Catch:{ Exception -> 0x0098, all -> 0x0090 }
        r7.j = r8;	 Catch:{ Exception -> 0x0098, all -> 0x0090 }
        r7 = r12.a;	 Catch:{ Exception -> 0x0098, all -> 0x0090 }
        r7.a(r3);	 Catch:{ Exception -> 0x0098, all -> 0x0090 }
        r5.disconnect();	 Catch:{ Exception -> 0x0098, all -> 0x0090 }
        r7 = r3;
        goto L_0x00a2;
    L_0x0090:
        r0 = move-exception;
        goto L_0x0094;
    L_0x0092:
        r0 = move-exception;
        r6 = r1;
    L_0x0094:
        r1 = r2;
        goto L_0x00f5;
    L_0x0097:
        r6 = r1;
    L_0x0098:
        r11 = r5;
        r5 = r2;
        r2 = r11;
        goto L_0x00ca;
    L_0x009c:
        r5.disconnect();	 Catch:{ Exception -> 0x00c0, all -> 0x00bd }
        r2 = r1;
        r6 = r2;
        r7 = r4;
    L_0x00a2:
        if (r5 == 0) goto L_0x00a7;
    L_0x00a4:
        r5.disconnect();
    L_0x00a7:
        if (r2 == 0) goto L_0x00b1;
    L_0x00a9:
        r2.close();	 Catch:{ Exception -> 0x00ad }
        goto L_0x00b1;
    L_0x00ad:
        r2 = move-exception;
        r2.printStackTrace();
    L_0x00b1:
        if (r6 == 0) goto L_0x00bb;
    L_0x00b3:
        r6.close();	 Catch:{ Exception -> 0x00b7 }
        goto L_0x00bb;
    L_0x00b7:
        r2 = move-exception;
        r2.printStackTrace();
    L_0x00bb:
        r2 = r5;
        goto L_0x00eb;
    L_0x00bd:
        r0 = move-exception;
        r6 = r1;
        goto L_0x00f5;
    L_0x00c0:
        r6 = r1;
        r2 = r5;
        r5 = r6;
        goto L_0x00ca;
    L_0x00c4:
        r0 = move-exception;
        r6 = r1;
    L_0x00c6:
        r5 = r2;
        goto L_0x00f5;
    L_0x00c8:
        r5 = r1;
        r6 = r5;
    L_0x00ca:
        r7 = com.baidu.location.g.a.a;	 Catch:{ all -> 0x00f2 }
        r8 = "NetworkCommunicationException!";
        android.util.Log.d(r7, r8);	 Catch:{ all -> 0x00f2 }
        if (r2 == 0) goto L_0x00d6;
    L_0x00d3:
        r2.disconnect();
    L_0x00d6:
        if (r5 == 0) goto L_0x00e0;
    L_0x00d8:
        r5.close();	 Catch:{ Exception -> 0x00dc }
        goto L_0x00e0;
    L_0x00dc:
        r5 = move-exception;
        r5.printStackTrace();
    L_0x00e0:
        if (r6 == 0) goto L_0x00ea;
    L_0x00e2:
        r6.close();	 Catch:{ Exception -> 0x00e6 }
        goto L_0x00ea;
    L_0x00e6:
        r5 = move-exception;
        r5.printStackTrace();
    L_0x00ea:
        r7 = r4;
    L_0x00eb:
        if (r7 == 0) goto L_0x00ee;
    L_0x00ed:
        goto L_0x010f;
    L_0x00ee:
        r0 = r0 + -1;
        goto L_0x0018;
    L_0x00f2:
        r0 = move-exception;
        r1 = r5;
        goto L_0x00c6;
    L_0x00f5:
        if (r5 == 0) goto L_0x00fa;
    L_0x00f7:
        r5.disconnect();
    L_0x00fa:
        if (r1 == 0) goto L_0x0104;
    L_0x00fc:
        r1.close();	 Catch:{ Exception -> 0x0100 }
        goto L_0x0104;
    L_0x0100:
        r1 = move-exception;
        r1.printStackTrace();
    L_0x0104:
        if (r6 == 0) goto L_0x010e;
    L_0x0106:
        r6.close();	 Catch:{ Exception -> 0x010a }
        goto L_0x010e;
    L_0x010a:
        r1 = move-exception;
        r1.printStackTrace();
    L_0x010e:
        throw r0;
    L_0x010f:
        if (r0 > 0) goto L_0x0120;
    L_0x0111:
        r0 = com.baidu.location.g.e.p;
        r0 = r0 + r3;
        com.baidu.location.g.e.p = r0;
        r0 = r12.a;
        r0.j = r1;
        r0 = r12.a;
        r0.a(r4);
        return;
    L_0x0120:
        com.baidu.location.g.e.p = r4;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.g.f.run():void");
    }
}
