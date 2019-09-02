package com.baidu.location.indoor;

import com.baidu.location.indoor.n.a;

class j implements a {
    final /* synthetic */ g a;

    j(g gVar) {
        this.a = gVar;
    }

    /*  JADX ERROR: NullPointerException in pass: EliminatePhiNodes
        java.lang.NullPointerException
        */
    public synchronized void a(double r17, double r19, double r21, long r23) {
        /*
        r16 = this;
        r1 = r16;
        monitor-enter(r16);
        r2 = r1.a;	 Catch:{ all -> 0x0166 }
        r2 = r2.o;	 Catch:{ all -> 0x0166 }
        if (r2 != 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r16);
        return;
    L_0x000d:
        r2 = r1.a;	 Catch:{ all -> 0x0166 }
        r3 = 4600877379321698714; // 0x3fd999999999999a float:-1.5881868E-23 double:0.4;	 Catch:{ all -> 0x0166 }
        r2.J = r3;	 Catch:{ all -> 0x0166 }
        r2 = r1.a;	 Catch:{ all -> 0x0166 }
        r3 = r2.ae;	 Catch:{ all -> 0x0166 }
        r4 = r17;	 Catch:{ all -> 0x0166 }
        r6 = r19;	 Catch:{ all -> 0x0166 }
        r8 = r21;	 Catch:{ all -> 0x0166 }
        r10 = r23;	 Catch:{ all -> 0x0166 }
        r3.a(r4, r6, r8, r10);	 Catch:{ all -> 0x0166 }
        r2 = r1.a;	 Catch:{ all -> 0x0166 }
        r3 = r2.w;	 Catch:{ all -> 0x0166 }
        r4 = r17;	 Catch:{ all -> 0x0166 }
        r6 = r19;	 Catch:{ all -> 0x0166 }
        r8 = r21;	 Catch:{ all -> 0x0166 }
        r2 = com.baidu.location.indoor.mapversion.b.a.a(r3, r4, r6, r8);	 Catch:{ all -> 0x0166 }
        if (r2 != 0) goto L_0x003c;	 Catch:{ all -> 0x0166 }
    L_0x003a:
        goto L_0x0164;	 Catch:{ all -> 0x0166 }
    L_0x003c:
        r3 = 0;	 Catch:{ all -> 0x0166 }
        r4 = r2[r3];	 Catch:{ all -> 0x0166 }
        r6 = -4616189618054758400; // 0xbff0000000000000 float:0.0 double:-1.0;	 Catch:{ all -> 0x0166 }
        r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));	 Catch:{ all -> 0x0166 }
        if (r8 != 0) goto L_0x0047;	 Catch:{ all -> 0x0166 }
    L_0x0045:
        goto L_0x0164;	 Catch:{ all -> 0x0166 }
    L_0x0047:
        r3 = r2[r3];	 Catch:{ all -> 0x0166 }
        r5 = 0;	 Catch:{ all -> 0x0166 }
        r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));	 Catch:{ all -> 0x0166 }
        if (r7 != 0) goto L_0x0164;	 Catch:{ all -> 0x0166 }
    L_0x004f:
        r3 = r1.a;	 Catch:{ all -> 0x0166 }
        r4 = 2;	 Catch:{ all -> 0x0166 }
        r5 = r2[r4];	 Catch:{ all -> 0x0166 }
        r3.I = r5;	 Catch:{ all -> 0x0166 }
        r3 = r1.a;	 Catch:{ all -> 0x0166 }
        r5 = 1;	 Catch:{ all -> 0x0166 }
        r6 = r2[r5];	 Catch:{ all -> 0x0166 }
        r3.H = r6;	 Catch:{ all -> 0x0166 }
        r3 = r1.a;	 Catch:{ all -> 0x0166 }
        r3 = r3.M;	 Catch:{ all -> 0x0166 }
        r3 = r3.size();	 Catch:{ all -> 0x0166 }
        r6 = 50;	 Catch:{ all -> 0x0166 }
        if (r3 <= r6) goto L_0x0076;	 Catch:{ all -> 0x0166 }
    L_0x006d:
        r3 = r1.a;	 Catch:{ all -> 0x0166 }
        r3 = r3.M;	 Catch:{ all -> 0x0166 }
        r3.clear();	 Catch:{ all -> 0x0166 }
    L_0x0076:
        r3 = r1.a;	 Catch:{ all -> 0x0166 }
        r3 = r3.M;	 Catch:{ all -> 0x0166 }
        r15 = new com.baidu.location.indoor.g$h;	 Catch:{ all -> 0x0166 }
        r7 = r1.a;	 Catch:{ all -> 0x0166 }
        r6 = r1.a;	 Catch:{ all -> 0x0166 }
        r6 = r6.k;	 Catch:{ all -> 0x0166 }
        r8 = r6.d();	 Catch:{ all -> 0x0166 }
        r6 = r15;	 Catch:{ all -> 0x0166 }
        r9 = r17;	 Catch:{ all -> 0x0166 }
        r11 = r21;	 Catch:{ all -> 0x0166 }
        r13 = r19;	 Catch:{ all -> 0x0166 }
        r6.<init>(r8, r9, r11, r13);	 Catch:{ all -> 0x0166 }
        r3.add(r15);	 Catch:{ all -> 0x0166 }
        r3 = r1.a;	 Catch:{ all -> 0x0166 }
        r3.u = r3.u + 1;	 Catch:{ all -> 0x0166 }
        r3 = new com.baidu.location.BDLocation;	 Catch:{ Exception -> 0x0164 }
        r3.<init>();	 Catch:{ Exception -> 0x0164 }
        r6 = 161; // 0xa1 float:2.26E-43 double:7.95E-322;	 Catch:{ Exception -> 0x0164 }
        r3.setLocType(r6);	 Catch:{ Exception -> 0x0164 }
        r6 = r2[r4];	 Catch:{ Exception -> 0x0164 }
        r3.setLatitude(r6);	 Catch:{ Exception -> 0x0164 }
        r6 = r2[r5];	 Catch:{ Exception -> 0x0164 }
        r3.setLongitude(r6);	 Catch:{ Exception -> 0x0164 }
        r6 = r21;	 Catch:{ Exception -> 0x0164 }
        r4 = (float) r6;	 Catch:{ Exception -> 0x0164 }
        r3.setDirection(r4);	 Catch:{ Exception -> 0x0164 }
        r4 = new java.util.Date;	 Catch:{ Exception -> 0x0164 }
        r4.<init>();	 Catch:{ Exception -> 0x0164 }
        r6 = r1.a;	 Catch:{ Exception -> 0x0164 }
        r6 = r6.b;	 Catch:{ Exception -> 0x0164 }
        r4 = r6.format(r4);	 Catch:{ Exception -> 0x0164 }
        r3.setTime(r4);	 Catch:{ Exception -> 0x0164 }
        r4 = r1.a;	 Catch:{ Exception -> 0x0164 }
        r4 = r4.w;	 Catch:{ Exception -> 0x0164 }
        r3.setFloor(r4);	 Catch:{ Exception -> 0x0164 }
        r4 = r1.a;	 Catch:{ Exception -> 0x0164 }
        r4 = r4.x;	 Catch:{ Exception -> 0x0164 }
        r3.setBuildingID(r4);	 Catch:{ Exception -> 0x0164 }
        r4 = r1.a;	 Catch:{ Exception -> 0x0164 }
        r4 = r4.z;	 Catch:{ Exception -> 0x0164 }
        r3.setBuildingName(r4);	 Catch:{ Exception -> 0x0164 }
        r4 = r1.a;	 Catch:{ Exception -> 0x0164 }
        r4 = r4.C;	 Catch:{ Exception -> 0x0164 }
        r3.setParkAvailable(r4);	 Catch:{ Exception -> 0x0164 }
        r3.setIndoorLocMode(r5);	 Catch:{ Exception -> 0x0164 }
        r4 = r1.a;	 Catch:{ Exception -> 0x0164 }
        r4 = r4.T;	 Catch:{ Exception -> 0x0164 }
        if (r4 == 0) goto L_0x00fb;	 Catch:{ Exception -> 0x0164 }
    L_0x00f5:
        r4 = 1090519040; // 0x41000000 float:8.0 double:5.38787994E-315;	 Catch:{ Exception -> 0x0164 }
        r3.setRadius(r4);	 Catch:{ Exception -> 0x0164 }
        goto L_0x0100;	 Catch:{ Exception -> 0x0164 }
    L_0x00fb:
        r4 = 1097859072; // 0x41700000 float:15.0 double:5.424144515E-315;	 Catch:{ Exception -> 0x0164 }
        r3.setRadius(r4);	 Catch:{ Exception -> 0x0164 }
    L_0x0100:
        r4 = "res";	 Catch:{ Exception -> 0x0164 }
        r3.setFusionLocInfo(r4, r2);	 Catch:{ Exception -> 0x0164 }
        r4 = 5;	 Catch:{ Exception -> 0x0164 }
        r5 = r2[r4];	 Catch:{ Exception -> 0x0164 }
        r5 = (float) r5;	 Catch:{ Exception -> 0x0164 }
        r3.setRadius(r5);	 Catch:{ Exception -> 0x0164 }
        r5 = 6;	 Catch:{ Exception -> 0x0164 }
        r5 = r2[r5];	 Catch:{ Exception -> 0x0164 }
        r5 = (float) r5;	 Catch:{ Exception -> 0x0164 }
        r3.setDirection(r5);	 Catch:{ Exception -> 0x0164 }
        r5 = 8;	 Catch:{ Exception -> 0x0164 }
        r5 = r2[r5];	 Catch:{ Exception -> 0x0164 }
        r5 = (float) r5;	 Catch:{ Exception -> 0x0164 }
        r3.setSpeed(r5);	 Catch:{ Exception -> 0x0164 }
        r5 = "dr";	 Catch:{ Exception -> 0x0164 }
        r3.setNetworkLocationType(r5);	 Catch:{ Exception -> 0x0164 }
        r5 = new com.baidu.location.BDLocation;	 Catch:{ Exception -> 0x0164 }
        r5.<init>(r3);	 Catch:{ Exception -> 0x0164 }
        r6 = "dr2";	 Catch:{ Exception -> 0x0164 }
        r5.setNetworkLocationType(r6);	 Catch:{ Exception -> 0x0164 }
        r6 = r1.a;	 Catch:{ Exception -> 0x0164 }
        r6 = r6.U;	 Catch:{ Exception -> 0x0164 }
        if (r6 == 0) goto L_0x0148;	 Catch:{ Exception -> 0x0164 }
    L_0x0132:
        r6 = r1.a;	 Catch:{ Exception -> 0x0164 }
        r6 = r6.U;	 Catch:{ Exception -> 0x0164 }
        r6 = r6.c();	 Catch:{ Exception -> 0x0164 }
        if (r6 == 0) goto L_0x0148;	 Catch:{ Exception -> 0x0164 }
    L_0x013e:
        r6 = r1.a;	 Catch:{ Exception -> 0x0164 }
        r6 = r6.U;	 Catch:{ Exception -> 0x0164 }
        r6.a(r5);	 Catch:{ Exception -> 0x0164 }
        goto L_0x014f;	 Catch:{ Exception -> 0x0164 }
    L_0x0148:
        r6 = r1.a;	 Catch:{ Exception -> 0x0164 }
        r7 = 21;	 Catch:{ Exception -> 0x0164 }
        r6.a(r5, r7);	 Catch:{ Exception -> 0x0164 }
    L_0x014f:
        r5 = r1.a;	 Catch:{ Exception -> 0x0164 }
        r5 = r5.ae;	 Catch:{ Exception -> 0x0164 }
        r6 = r2[r4];	 Catch:{ Exception -> 0x0164 }
        r2 = "dr";	 Catch:{ Exception -> 0x0164 }
        r2 = r5.a(r3, r6, r2);	 Catch:{ Exception -> 0x0164 }
        if (r2 != 0) goto L_0x0164;	 Catch:{ Exception -> 0x0164 }
    L_0x015f:
        r2 = r1.a;	 Catch:{ Exception -> 0x0164 }
        r2.d();	 Catch:{ Exception -> 0x0164 }
    L_0x0164:
        monitor-exit(r16);
        return;
    L_0x0166:
        r0 = move-exception;
        r2 = r0;
        monitor-exit(r16);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.indoor.j.a(double, double, double, long):void");
    }
}
