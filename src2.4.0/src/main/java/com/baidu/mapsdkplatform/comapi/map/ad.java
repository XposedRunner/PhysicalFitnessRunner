package com.baidu.mapsdkplatform.comapi.map;

import android.os.Handler;

class ad extends Handler {
    final /* synthetic */ ac a;

    ad(ac acVar) {
        this.a = acVar;
    }

    /* JADX WARNING: Missing block: B:46:0x00fe, code skipped:
            if (r12.a.h != null) goto L_0x0100;
     */
    /* JADX WARNING: Missing block: B:51:0x0114, code skipped:
            if (r12.a.h != null) goto L_0x0100;
     */
    public void handleMessage(android.os.Message r13) {
        /*
        r12 = this;
        super.handleMessage(r13);
        r0 = r12.a;
        r0 = r0.i;
        if (r0 == 0) goto L_0x02fc;
    L_0x000b:
        r0 = r12.a;
        r0 = r0.i;
        r0 = r0.i;
        if (r0 != 0) goto L_0x0016;
    L_0x0015:
        return;
    L_0x0016:
        r0 = r13.obj;
        r0 = (java.lang.Long) r0;
        r0 = r0.longValue();
        r2 = r12.a;
        r2 = r2.i;
        r2 = r2.j;
        r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r4 == 0) goto L_0x002b;
    L_0x002a:
        return;
    L_0x002b:
        r0 = r13.what;
        r1 = 4000; // 0xfa0 float:5.605E-42 double:1.9763E-320;
        r2 = 0;
        r3 = 1;
        if (r0 != r1) goto L_0x00c3;
    L_0x0033:
        r0 = r12.a;
        r0 = r0.i;
        r0 = r0.h;
        if (r0 != 0) goto L_0x003e;
    L_0x003d:
        return;
    L_0x003e:
        r0 = r12.a;
        r0 = r0.i;
        r0 = r0.h;
        r0 = r0.iterator();
    L_0x004a:
        r1 = r0.hasNext();
        if (r1 == 0) goto L_0x02fc;
    L_0x0050:
        r1 = r0.next();
        r1 = (com.baidu.mapsdkplatform.comapi.map.l) r1;
        r4 = 0;
        r5 = r13.arg2;
        if (r5 != r3) goto L_0x00bd;
    L_0x005b:
        r4 = com.baidu.mapsdkplatform.comapi.map.ac.a;
        r5 = com.baidu.mapsdkplatform.comapi.map.ac.b;
        r4 = r4 * r5;
        r4 = new int[r4];
        r5 = com.baidu.mapsdkplatform.comapi.map.ac.a;
        r6 = com.baidu.mapsdkplatform.comapi.map.ac.b;
        r5 = r5 * r6;
        r5 = new int[r5];
        r6 = r12.a;
        r6 = r6.i;
        r6 = r6.i;
        if (r6 != 0) goto L_0x0074;
    L_0x0073:
        return;
    L_0x0074:
        r6 = r12.a;
        r6 = r6.i;
        r6 = r6.i;
        r7 = com.baidu.mapsdkplatform.comapi.map.ac.a;
        r8 = com.baidu.mapsdkplatform.comapi.map.ac.b;
        r4 = r6.a(r4, r7, r8);
        r6 = r2;
    L_0x0085:
        r7 = com.baidu.mapsdkplatform.comapi.map.ac.b;
        if (r6 >= r7) goto L_0x00b3;
    L_0x0089:
        r7 = r2;
    L_0x008a:
        r8 = com.baidu.mapsdkplatform.comapi.map.ac.a;
        if (r7 >= r8) goto L_0x00b0;
    L_0x008e:
        r8 = com.baidu.mapsdkplatform.comapi.map.ac.a;
        r8 = r8 * r6;
        r8 = r8 + r7;
        r8 = r4[r8];
        r9 = r8 >> 16;
        r9 = r9 & 255;
        r10 = r8 << 16;
        r11 = 16711680; // 0xff0000 float:2.3418052E-38 double:8.256667E-317;
        r10 = r10 & r11;
        r11 = -16711936; // 0xffffffffff00ff00 float:-1.7146522E38 double:NaN;
        r8 = r8 & r11;
        r8 = r8 | r10;
        r8 = r8 | r9;
        r9 = com.baidu.mapsdkplatform.comapi.map.ac.b;
        r9 = r9 - r6;
        r9 = r9 - r3;
        r10 = com.baidu.mapsdkplatform.comapi.map.ac.a;
        r9 = r9 * r10;
        r9 = r9 + r7;
        r5[r9] = r8;
        r7 = r7 + 1;
        goto L_0x008a;
    L_0x00b0:
        r6 = r6 + 1;
        goto L_0x0085;
    L_0x00b3:
        r4 = com.baidu.mapsdkplatform.comapi.map.ac.a;
        r6 = com.baidu.mapsdkplatform.comapi.map.ac.b;
        r7 = android.graphics.Bitmap.Config.ARGB_8888;
        r4 = android.graphics.Bitmap.createBitmap(r5, r4, r6, r7);
    L_0x00bd:
        if (r1 == 0) goto L_0x004a;
    L_0x00bf:
        r1.a(r4);
        goto L_0x004a;
    L_0x00c3:
        r0 = r13.what;
        r1 = 39;
        r4 = 1099956224; // 0x41900000 float:18.0 double:5.43450582E-315;
        if (r0 != r1) goto L_0x0207;
    L_0x00cb:
        r0 = r12.a;
        r0 = r0.i;
        if (r0 != 0) goto L_0x00d4;
    L_0x00d3:
        return;
    L_0x00d4:
        r0 = r13.arg1;
        r1 = 100;
        if (r0 != r1) goto L_0x00e4;
    L_0x00da:
        r13 = r12.a;
        r13 = r13.i;
        r13.B();
        goto L_0x0145;
    L_0x00e4:
        r0 = r13.arg1;
        r1 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r0 != r1) goto L_0x00f4;
    L_0x00ea:
        r13 = r12.a;
        r13 = r13.i;
        r13.L();
        goto L_0x0145;
    L_0x00f4:
        r0 = r13.arg1;
        if (r0 != r3) goto L_0x010a;
    L_0x00f8:
        r13 = r12.a;
        r13 = r13.h;
        if (r13 == 0) goto L_0x0145;
    L_0x0100:
        r13 = r12.a;
        r13 = r13.h;
        r13.a();
        goto L_0x0145;
    L_0x010a:
        r0 = r13.arg1;
        if (r0 != 0) goto L_0x0117;
    L_0x010e:
        r13 = r12.a;
        r13 = r13.h;
        if (r13 == 0) goto L_0x0145;
    L_0x0116:
        goto L_0x0100;
    L_0x0117:
        r13 = r13.arg1;
        r0 = 2;
        if (r13 != r0) goto L_0x0145;
    L_0x011c:
        r13 = r12.a;
        r13 = r13.i;
        r13 = r13.h;
        if (r13 != 0) goto L_0x0127;
    L_0x0126:
        return;
    L_0x0127:
        r13 = r12.a;
        r13 = r13.i;
        r13 = r13.h;
        r13 = r13.iterator();
    L_0x0133:
        r0 = r13.hasNext();
        if (r0 == 0) goto L_0x0145;
    L_0x0139:
        r0 = r13.next();
        r0 = (com.baidu.mapsdkplatform.comapi.map.l) r0;
        if (r0 == 0) goto L_0x0133;
    L_0x0141:
        r0.c();
        goto L_0x0133;
    L_0x0145:
        r13 = r12.a;
        r13 = r13.i;
        r13 = r13.k;
        if (r13 != 0) goto L_0x0194;
    L_0x014f:
        r13 = com.baidu.mapsdkplatform.comapi.map.ac.b;
        if (r13 <= 0) goto L_0x0194;
    L_0x0153:
        r13 = com.baidu.mapsdkplatform.comapi.map.ac.a;
        if (r13 <= 0) goto L_0x0194;
    L_0x0157:
        r13 = r12.a;
        r13 = r13.i;
        r13 = r13.b(r2, r2);
        if (r13 == 0) goto L_0x0194;
    L_0x0163:
        r13 = r12.a;
        r13 = r13.i;
        r13.k = r3;
        r13 = r12.a;
        r13 = r13.i;
        r13 = r13.h;
        if (r13 != 0) goto L_0x0176;
    L_0x0175:
        return;
    L_0x0176:
        r13 = r12.a;
        r13 = r13.i;
        r13 = r13.h;
        r13 = r13.iterator();
    L_0x0182:
        r0 = r13.hasNext();
        if (r0 == 0) goto L_0x0194;
    L_0x0188:
        r0 = r13.next();
        r0 = (com.baidu.mapsdkplatform.comapi.map.l) r0;
        if (r0 == 0) goto L_0x0182;
    L_0x0190:
        r0.b();
        goto L_0x0182;
    L_0x0194:
        r13 = r12.a;
        r13 = r13.i;
        r13 = r13.h;
        if (r13 != 0) goto L_0x019f;
    L_0x019e:
        return;
    L_0x019f:
        r13 = r12.a;
        r13 = r13.i;
        r13 = r13.h;
        r13 = r13.iterator();
    L_0x01ab:
        r0 = r13.hasNext();
        if (r0 == 0) goto L_0x01bd;
    L_0x01b1:
        r0 = r13.next();
        r0 = (com.baidu.mapsdkplatform.comapi.map.l) r0;
        if (r0 == 0) goto L_0x01ab;
    L_0x01b9:
        r0.a();
        goto L_0x01ab;
    L_0x01bd:
        r13 = r12.a;
        r13 = r13.i;
        r13 = r13.q();
        if (r13 == 0) goto L_0x02fc;
    L_0x01c9:
        r13 = r12.a;
        r13 = r13.i;
        r13 = r13.h;
        if (r13 != 0) goto L_0x01d4;
    L_0x01d3:
        return;
    L_0x01d4:
        r13 = r12.a;
        r13 = r13.i;
        r13 = r13.h;
        r13 = r13.iterator();
    L_0x01e0:
        r0 = r13.hasNext();
        if (r0 == 0) goto L_0x02fc;
    L_0x01e6:
        r0 = r13.next();
        r0 = (com.baidu.mapsdkplatform.comapi.map.l) r0;
        if (r0 != 0) goto L_0x01ef;
    L_0x01ee:
        goto L_0x01e0;
    L_0x01ef:
        r1 = r12.a;
        r1 = r1.i;
        r1 = r1.E();
        r1 = r1.a;
        r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1));
        if (r1 < 0) goto L_0x0203;
    L_0x01ff:
        r0.a(r3);
        goto L_0x01e0;
    L_0x0203:
        r0.a(r2);
        goto L_0x01e0;
    L_0x0207:
        r0 = r13.what;
        r1 = 41;
        if (r0 != r1) goto L_0x0281;
    L_0x020d:
        r13 = r12.a;
        r13 = r13.i;
        if (r13 != 0) goto L_0x0216;
    L_0x0215:
        return;
    L_0x0216:
        r13 = r12.a;
        r13 = r13.i;
        r13 = r13.n;
        if (r13 != 0) goto L_0x022a;
    L_0x0220:
        r13 = r12.a;
        r13 = r13.i;
        r13 = r13.o;
        if (r13 == 0) goto L_0x02fc;
    L_0x022a:
        r13 = r12.a;
        r13 = r13.i;
        r13 = r13.h;
        if (r13 != 0) goto L_0x0235;
    L_0x0234:
        return;
    L_0x0235:
        r13 = r12.a;
        r13 = r13.i;
        r13 = r13.h;
        r13 = r13.iterator();
    L_0x0241:
        r0 = r13.hasNext();
        if (r0 == 0) goto L_0x02fc;
    L_0x0247:
        r0 = r13.next();
        r0 = (com.baidu.mapsdkplatform.comapi.map.l) r0;
        if (r0 != 0) goto L_0x0250;
    L_0x024f:
        goto L_0x0241;
    L_0x0250:
        r1 = r12.a;
        r1 = r1.i;
        r1 = r1.E();
        r0.b(r1);
        r1 = r12.a;
        r1 = r1.i;
        r1 = r1.q();
        if (r1 == 0) goto L_0x0241;
    L_0x0269:
        r1 = r12.a;
        r1 = r1.i;
        r1 = r1.E();
        r1 = r1.a;
        r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1));
        if (r1 < 0) goto L_0x027d;
    L_0x0279:
        r0.a(r3);
        goto L_0x0241;
    L_0x027d:
        r0.a(r2);
        goto L_0x0241;
    L_0x0281:
        r0 = r13.what;
        r1 = 999; // 0x3e7 float:1.4E-42 double:4.936E-321;
        if (r0 != r1) goto L_0x02b0;
    L_0x0287:
        r13 = r12.a;
        r13 = r13.i;
        r13 = r13.h;
        if (r13 != 0) goto L_0x0292;
    L_0x0291:
        return;
    L_0x0292:
        r13 = r12.a;
        r13 = r13.i;
        r13 = r13.h;
        r13 = r13.iterator();
    L_0x029e:
        r0 = r13.hasNext();
        if (r0 == 0) goto L_0x02fc;
    L_0x02a4:
        r0 = r13.next();
        r0 = (com.baidu.mapsdkplatform.comapi.map.l) r0;
        if (r0 == 0) goto L_0x029e;
    L_0x02ac:
        r0.e();
        goto L_0x029e;
    L_0x02b0:
        r0 = r13.what;
        r1 = 50;
        if (r0 != r1) goto L_0x02fc;
    L_0x02b6:
        r0 = r12.a;
        r0 = r0.i;
        r0 = r0.h;
        if (r0 != 0) goto L_0x02c1;
    L_0x02c0:
        return;
    L_0x02c1:
        r0 = r12.a;
        r0 = r0.i;
        r0 = r0.h;
        r0 = r0.iterator();
    L_0x02cd:
        r1 = r0.hasNext();
        if (r1 == 0) goto L_0x02fc;
    L_0x02d3:
        r1 = r0.next();
        r1 = (com.baidu.mapsdkplatform.comapi.map.l) r1;
        if (r1 != 0) goto L_0x02dc;
    L_0x02db:
        goto L_0x02cd;
    L_0x02dc:
        r5 = r13.arg1;
        if (r5 != 0) goto L_0x02e4;
    L_0x02e0:
        r1.a(r2);
        goto L_0x02cd;
    L_0x02e4:
        r5 = r13.arg1;
        if (r5 != r3) goto L_0x02cd;
    L_0x02e8:
        r5 = r12.a;
        r5 = r5.i;
        r5 = r5.E();
        r5 = r5.a;
        r5 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1));
        if (r5 < 0) goto L_0x02e0;
    L_0x02f8:
        r1.a(r3);
        goto L_0x02cd;
    L_0x02fc:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.map.ad.handleMessage(android.os.Message):void");
    }
}
