package com.amap.api.mapcore.util;

/* compiled from: MapLocFilter */
public final class aw {
    private static aw O00000Oo;
    long O000000o = 0;
    private long O00000o = 0;
    private ls O00000o0 = null;
    private long O00000oO = 0;

    private aw() {
    }

    public static synchronized aw O000000o() {
        aw awVar;
        synchronized (aw.class) {
            if (O00000Oo == null) {
                O00000Oo = new aw();
            }
            awVar = O00000Oo;
        }
        return awVar;
    }

    public static ls O00000Oo(ls lsVar) {
        return lsVar;
    }

    /* JADX WARNING: Missing block: B:36:0x00ea, code skipped:
            if ((r9 - r0.O00000oO) > com.sina.weibo.sdk.statistic.StatisticConfig.MIN_UPLOAD_INTERVAL) goto L_0x00ec;
     */
    public final com.amap.api.mapcore.util.ls O000000o(com.amap.api.mapcore.util.ls r18) {
        /*
        r17 = this;
        r0 = r17;
        r1 = r18;
        r2 = com.amap.api.mapcore.util.bt.O00000Oo();
        r4 = r0.O000000o;
        r6 = r2 - r4;
        r2 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r4 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1));
        if (r4 <= 0) goto L_0x001d;
    L_0x0012:
        r0.O00000o0 = r1;
        r1 = com.amap.api.mapcore.util.bt.O00000Oo();
        r0.O000000o = r1;
    L_0x001a:
        r1 = r0.O00000o0;
        return r1;
    L_0x001d:
        r4 = com.amap.api.mapcore.util.bt.O00000Oo();
        r0.O000000o = r4;
        r4 = r0.O00000o0;
        r4 = com.amap.api.mapcore.util.bd.O000000o(r4);
        if (r4 == 0) goto L_0x0057;
    L_0x002b:
        r4 = com.amap.api.mapcore.util.bd.O000000o(r18);
        if (r4 != 0) goto L_0x0032;
    L_0x0031:
        goto L_0x0057;
    L_0x0032:
        r4 = r18.getTime();
        r6 = r0.O00000o0;
        r6 = r6.getTime();
        r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        r4 = 1133903872; // 0x43960000 float:300.0 double:5.60222949E-315;
        if (r8 != 0) goto L_0x004b;
    L_0x0042:
        r5 = r18.getAccuracy();
        r5 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1));
        if (r5 >= 0) goto L_0x004b;
    L_0x004a:
        return r1;
    L_0x004b:
        r5 = r18.getProvider();
        r6 = "gps";
        r5 = r5.equalsIgnoreCase(r6);
        if (r5 == 0) goto L_0x0060;
    L_0x0057:
        r2 = com.amap.api.mapcore.util.bt.O00000Oo();
        r0.O00000o = r2;
    L_0x005d:
        r0.O00000o0 = r1;
        goto L_0x001a;
    L_0x0060:
        r5 = r18.O00000o0();
        r6 = r0.O00000o0;
        r6 = r6.O00000o0();
        if (r5 == r6) goto L_0x006d;
    L_0x006c:
        goto L_0x0057;
    L_0x006d:
        r5 = r18.getBuildingId();
        r6 = r0.O00000o0;
        r6 = r6.getBuildingId();
        r5 = r5.equals(r6);
        if (r5 != 0) goto L_0x0088;
    L_0x007d:
        r5 = r18.getBuildingId();
        r5 = android.text.TextUtils.isEmpty(r5);
        if (r5 != 0) goto L_0x0088;
    L_0x0087:
        goto L_0x0057;
    L_0x0088:
        r5 = 4;
        r5 = new double[r5];
        r6 = 0;
        r7 = r18.getLatitude();
        r5[r6] = r7;
        r6 = 1;
        r7 = r18.getLongitude();
        r5[r6] = r7;
        r6 = 2;
        r7 = r0.O00000o0;
        r7 = r7.getLatitude();
        r5[r6] = r7;
        r6 = 3;
        r7 = r0.O00000o0;
        r7 = r7.getLongitude();
        r5[r6] = r7;
        r5 = com.amap.api.mapcore.util.bt.O000000o(r5);
        r6 = r0.O00000o0;
        r6 = r6.getAccuracy();
        r7 = r18.getAccuracy();
        r8 = r7 - r6;
        r9 = com.amap.api.mapcore.util.bt.O00000Oo();
        r11 = r0.O00000o;
        r13 = r9 - r11;
        r11 = 1120534528; // 0x42ca0000 float:101.0 double:5.536176153E-315;
        r12 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1));
        r15 = r5;
        r4 = 0;
        r16 = 1133871104; // 0x43958000 float:299.0 double:5.602067593E-315;
        if (r12 >= 0) goto L_0x00d3;
    L_0x00cf:
        r12 = (r7 > r16 ? 1 : (r7 == r16 ? 0 : -1));
        if (r12 > 0) goto L_0x00db;
    L_0x00d3:
        r12 = (r6 > r16 ? 1 : (r6 == r16 ? 0 : -1));
        if (r12 <= 0) goto L_0x00f7;
    L_0x00d7:
        r12 = (r7 > r16 ? 1 : (r7 == r16 ? 0 : -1));
        if (r12 <= 0) goto L_0x00f7;
    L_0x00db:
        r6 = r0.O00000oO;
        r8 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1));
        if (r8 != 0) goto L_0x00e4;
    L_0x00e1:
        r0.O00000oO = r9;
        goto L_0x00f4;
    L_0x00e4:
        r6 = r0.O00000oO;
        r11 = r9 - r6;
        r6 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1));
        if (r6 <= 0) goto L_0x00f4;
    L_0x00ec:
        r0.O00000o = r9;
        r0.O00000o0 = r1;
        r0.O00000oO = r4;
        goto L_0x001a;
    L_0x00f4:
        r1 = r0.O00000o0;
        return r1;
    L_0x00f7:
        r11 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1));
        if (r11 >= 0) goto L_0x0100;
    L_0x00fb:
        r11 = (r6 > r16 ? 1 : (r6 == r16 ? 0 : -1));
        if (r11 <= 0) goto L_0x0100;
    L_0x00ff:
        goto L_0x00ec;
    L_0x0100:
        r11 = (r7 > r16 ? 1 : (r7 == r16 ? 0 : -1));
        if (r11 > 0) goto L_0x0106;
    L_0x0104:
        r0.O00000oO = r4;
    L_0x0106:
        r4 = 1092616192; // 0x41200000 float:10.0 double:5.398241246E-315;
        r4 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1));
        if (r4 >= 0) goto L_0x0134;
    L_0x010c:
        r4 = r15;
        r4 = (double) r4;
        r11 = 4591870180066957722; // 0x3fb999999999999a float:-1.5881868E-23 double:0.1;
        r15 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1));
        if (r15 <= 0) goto L_0x0134;
    L_0x0117:
        r4 = 1084227584; // 0x40a00000 float:5.0 double:5.356796015E-315;
        r4 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1));
        if (r4 <= 0) goto L_0x0134;
    L_0x011d:
        r2 = -1013579776; // 0xffffffffc3960000 float:-300.0 double:NaN;
        r2 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1));
        if (r2 < 0) goto L_0x0126;
    L_0x0123:
        r1 = r0.O00000o0;
        return r1;
    L_0x0126:
        r6 = r6 / r7;
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1));
        if (r2 < 0) goto L_0x0131;
    L_0x012d:
        r0.O00000o = r9;
        goto L_0x005d;
    L_0x0131:
        r1 = r0.O00000o0;
        return r1;
    L_0x0134:
        r4 = 1133903872; // 0x43960000 float:300.0 double:5.60222949E-315;
        r4 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1));
        if (r4 < 0) goto L_0x0057;
    L_0x013a:
        r4 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1));
        if (r4 < 0) goto L_0x0140;
    L_0x013e:
        goto L_0x0057;
    L_0x0140:
        r1 = r0.O00000o0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.aw.O000000o(com.amap.api.mapcore.util.ls):com.amap.api.mapcore.util.ls");
    }
}
