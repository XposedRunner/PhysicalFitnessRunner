package com.loc;

import com.amap.api.location.AMapLocation;
import com.autonavi.aps.amapapi.model.AMapLocationServer;

/* compiled from: LocFilter */
public final class O0O0o0 {
    AMapLocationServer O000000o = null;
    long O00000Oo = 0;
    int O00000o = 0;
    long O00000o0 = 0;
    long O00000oO = 0;
    AMapLocation O00000oo = null;
    long O0000O0o = 0;
    private boolean O0000OOo = true;

    private AMapLocationServer O00000Oo(AMapLocationServer aMapLocationServer) {
        if (OO000OO.O000000o(aMapLocationServer)) {
            int i;
            if (!this.O0000OOo || !OoO0o.O00000Oo(aMapLocationServer.getTime())) {
                i = this.O00000o;
            } else if (aMapLocationServer.getLocationType() == 5 || aMapLocationServer.getLocationType() == 6) {
                i = 4;
            }
            aMapLocationServer.setLocationType(i);
        }
        return aMapLocationServer;
    }

    public final AMapLocation O000000o(AMapLocation aMapLocation) {
        if (!OO000OO.O000000o(aMapLocation)) {
            return aMapLocation;
        }
        long O00000o0 = OO000OO.O00000o0() - this.O0000O0o;
        this.O0000O0o = OO000OO.O00000o0();
        if (O00000o0 > 5000) {
            return aMapLocation;
        }
        if (this.O00000oo == null) {
            this.O00000oo = aMapLocation;
            return aMapLocation;
        } else if (1 != this.O00000oo.getLocationType() && !"gps".equalsIgnoreCase(this.O00000oo.getProvider())) {
            this.O00000oo = aMapLocation;
            return aMapLocation;
        } else if (this.O00000oo.getAltitude() == aMapLocation.getAltitude() && this.O00000oo.getLongitude() == aMapLocation.getLongitude()) {
            this.O00000oo = aMapLocation;
            return aMapLocation;
        } else {
            long abs = Math.abs(aMapLocation.getTime() - this.O00000oo.getTime());
            if (StatisticConfig.MIN_UPLOAD_INTERVAL < abs) {
                this.O00000oo = aMapLocation;
                return aMapLocation;
            }
            if (OO000OO.O000000o(aMapLocation, this.O00000oo) > ((((this.O00000oo.getSpeed() + aMapLocation.getSpeed()) * ((float) abs)) / 2000.0f) + (2.0f * (this.O00000oo.getAccuracy() + aMapLocation.getAccuracy()))) + 3000.0f) {
                return this.O00000oo;
            }
            this.O00000oo = aMapLocation;
            return aMapLocation;
        }
    }

    /* JADX WARNING: Missing block: B:61:0x011a, code skipped:
            if (r13 < com.sina.weibo.sdk.statistic.StatisticConfig.MIN_UPLOAD_INTERVAL) goto L_0x00ff;
     */
    /* JADX WARNING: Missing block: B:66:0x012f, code skipped:
            if ((r9 - r0.O00000o0) > com.sina.weibo.sdk.statistic.StatisticConfig.MIN_UPLOAD_INTERVAL) goto L_0x00d5;
     */
    public final com.autonavi.aps.amapapi.model.AMapLocationServer O000000o(com.autonavi.aps.amapapi.model.AMapLocationServer r21) {
        /*
        r20 = this;
        r0 = r20;
        r1 = r21;
        r2 = com.loc.OO000OO.O00000o0();
        r4 = r0.O00000oO;
        r6 = r2 - r4;
        r2 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r4 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1));
        if (r4 <= 0) goto L_0x001d;
    L_0x0012:
        r0.O000000o = r1;
        r1 = com.loc.OO000OO.O00000o0();
        r0.O00000oO = r1;
    L_0x001a:
        r1 = r0.O000000o;
        return r1;
    L_0x001d:
        r4 = com.loc.OO000OO.O00000o0();
        r0.O00000oO = r4;
        r4 = r0.O000000o;
        r4 = com.loc.OO000OO.O000000o(r4);
        if (r4 == 0) goto L_0x0057;
    L_0x002b:
        r4 = com.loc.OO000OO.O000000o(r21);
        if (r4 != 0) goto L_0x0032;
    L_0x0031:
        goto L_0x0057;
    L_0x0032:
        r4 = r21.getTime();
        r6 = r0.O000000o;
        r6 = r6.getTime();
        r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        r4 = 1133903872; // 0x43960000 float:300.0 double:5.60222949E-315;
        if (r8 != 0) goto L_0x004b;
    L_0x0042:
        r5 = r21.getAccuracy();
        r5 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1));
        if (r5 >= 0) goto L_0x004b;
    L_0x004a:
        return r1;
    L_0x004b:
        r5 = r21.getProvider();
        r6 = "gps";
        r5 = r5.equals(r6);
        if (r5 == 0) goto L_0x0060;
    L_0x0057:
        r2 = com.loc.OO000OO.O00000o0();
        r0.O00000Oo = r2;
    L_0x005d:
        r0.O000000o = r1;
        goto L_0x001a;
    L_0x0060:
        r5 = r21.c();
        r6 = r0.O000000o;
        r6 = r6.c();
        if (r5 == r6) goto L_0x006d;
    L_0x006c:
        goto L_0x0057;
    L_0x006d:
        r5 = r21.getBuildingId();
        r6 = r0.O000000o;
        r6 = r6.getBuildingId();
        r5 = r5.equals(r6);
        if (r5 != 0) goto L_0x0088;
    L_0x007d:
        r5 = r21.getBuildingId();
        r5 = android.text.TextUtils.isEmpty(r5);
        if (r5 != 0) goto L_0x0088;
    L_0x0087:
        goto L_0x0057;
    L_0x0088:
        r5 = r21.getLocationType();
        r0.O00000o = r5;
        r5 = r0.O000000o;
        r5 = com.loc.OO000OO.O000000o(r1, r5);
        r6 = r0.O000000o;
        r6 = r6.getAccuracy();
        r7 = r21.getAccuracy();
        r8 = r7 - r6;
        r9 = com.loc.OO000OO.O00000o0();
        r11 = r0.O00000Oo;
        r13 = r9 - r11;
        r11 = 1120403456; // 0x42c80000 float:100.0 double:5.53552857E-315;
        r12 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1));
        r15 = 0;
        r16 = 1;
        r17 = 1133871104; // 0x43958000 float:299.0 double:5.602067593E-315;
        if (r12 > 0) goto L_0x00bb;
    L_0x00b4:
        r12 = (r7 > r17 ? 1 : (r7 == r17 ? 0 : -1));
        if (r12 <= 0) goto L_0x00bb;
    L_0x00b8:
        r12 = r16;
        goto L_0x00bc;
    L_0x00bb:
        r12 = r15;
    L_0x00bc:
        r18 = (r6 > r17 ? 1 : (r6 == r17 ? 0 : -1));
        if (r18 <= 0) goto L_0x00c6;
    L_0x00c0:
        r18 = (r7 > r17 ? 1 : (r7 == r17 ? 0 : -1));
        if (r18 <= 0) goto L_0x00c6;
    L_0x00c4:
        r15 = r16;
    L_0x00c6:
        r2 = 0;
        if (r12 != 0) goto L_0x011e;
    L_0x00ca:
        if (r15 == 0) goto L_0x00cd;
    L_0x00cc:
        goto L_0x011e;
    L_0x00cd:
        r11 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1));
        if (r11 >= 0) goto L_0x00dd;
    L_0x00d1:
        r11 = (r6 > r17 ? 1 : (r6 == r17 ? 0 : -1));
        if (r11 <= 0) goto L_0x00dd;
    L_0x00d5:
        r0.O00000Oo = r9;
        r0.O000000o = r1;
        r0.O00000o0 = r2;
        goto L_0x001a;
    L_0x00dd:
        r11 = (r7 > r17 ? 1 : (r7 == r17 ? 0 : -1));
        if (r11 > 0) goto L_0x00e3;
    L_0x00e1:
        r0.O00000o0 = r2;
    L_0x00e3:
        r2 = 1092616192; // 0x41200000 float:10.0 double:5.398241246E-315;
        r2 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1));
        if (r2 >= 0) goto L_0x0112;
    L_0x00e9:
        r2 = (double) r5;
        r11 = 4591870180066957722; // 0x3fb999999999999a float:-1.5881868E-23 double:0.1;
        r5 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1));
        if (r5 <= 0) goto L_0x0112;
    L_0x00f3:
        r2 = 1084227584; // 0x40a00000 float:5.0 double:5.356796015E-315;
        r2 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1));
        if (r2 <= 0) goto L_0x0112;
    L_0x00f9:
        r2 = -1013579776; // 0xffffffffc3960000 float:-300.0 double:NaN;
        r2 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1));
        if (r2 < 0) goto L_0x0107;
    L_0x00ff:
        r1 = r0.O000000o;
        r1 = r0.O00000Oo(r1);
        goto L_0x005d;
    L_0x0107:
        r6 = r6 / r7;
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1));
        if (r2 < 0) goto L_0x00ff;
    L_0x010e:
        r0.O00000Oo = r9;
        goto L_0x005d;
    L_0x0112:
        r2 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1));
        if (r2 < 0) goto L_0x0057;
    L_0x0116:
        r2 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r4 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1));
        if (r4 < 0) goto L_0x00ff;
    L_0x011c:
        goto L_0x0057;
    L_0x011e:
        r4 = r0.O00000o0;
        r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));
        if (r6 != 0) goto L_0x0127;
    L_0x0124:
        r0.O00000o0 = r9;
        goto L_0x00ff;
    L_0x0127:
        r4 = r0.O00000o0;
        r6 = r9 - r4;
        r4 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r8 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1));
        if (r8 <= 0) goto L_0x00ff;
    L_0x0131:
        goto L_0x00d5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O0O0o0.O000000o(com.autonavi.aps.amapapi.model.AMapLocationServer):com.autonavi.aps.amapapi.model.AMapLocationServer");
    }

    public final void O000000o() {
        this.O000000o = null;
        this.O00000Oo = 0;
        this.O00000o0 = 0;
        this.O00000oo = null;
        this.O0000O0o = 0;
    }

    public final void O000000o(boolean z) {
        this.O0000OOo = z;
    }
}
