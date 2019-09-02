package com.amap.api.mapcore.util;

import java.util.HashMap;

/* compiled from: CellAgeEstimator */
public final class be {
    private HashMap<Long, bg> O000000o = new HashMap();
    private long O00000Oo = 0;

    private static long O000000o(int i, int i2) {
        return ((((long) i) & 65535) << 32) | (((long) i2) & 65535);
    }

    public final long O000000o(bg bgVar) {
        if (bgVar == null || !bgVar.O0000o0O) {
            return 0;
        }
        int O000000o;
        int O00000Oo;
        long j;
        HashMap hashMap = this.O000000o;
        switch (bgVar.O0000OoO) {
            case 1:
            case 3:
            case 4:
                O000000o = bgVar.O000000o();
                O00000Oo = bgVar.O00000Oo();
                break;
            case 2:
                O000000o = bgVar.O00000o0();
                O00000Oo = bgVar.O00000o();
                break;
            default:
                j = 0;
                break;
        }
        j = O000000o(O000000o, O00000Oo);
        bg bgVar2 = (bg) hashMap.get(Long.valueOf(j));
        if (bgVar2 != null && bgVar2.O00000oO() == bgVar.O00000oO()) {
            bgVar.O0000o00 = bgVar2.O0000o00;
            hashMap.put(Long.valueOf(j), bgVar);
            return (bt.O00000Oo() - bgVar2.O0000o00) / 1000;
        }
        bgVar.O0000o00 = bt.O00000Oo();
        hashMap.put(Long.valueOf(j), bgVar);
        return 0;
    }

    public final void O000000o() {
        this.O000000o.clear();
        this.O00000Oo = 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x005f A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004e  */
    public final void O000000o(java.util.ArrayList<? extends com.amap.api.mapcore.util.bg> r13) {
        /*
        r12 = this;
        if (r13 == 0) goto L_0x009c;
    L_0x0002:
        r0 = com.amap.api.mapcore.util.bt.O00000Oo();
        r2 = r12.O00000Oo;
        r4 = 0;
        r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r6 <= 0) goto L_0x001a;
    L_0x000e:
        r2 = r12.O00000Oo;
        r6 = r0 - r2;
        r2 = 60000; // 0xea60 float:8.4078E-41 double:2.9644E-319;
        r8 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1));
        if (r8 >= 0) goto L_0x001a;
    L_0x0019:
        return;
    L_0x001a:
        r2 = r12.O000000o;
        r3 = r13.size();
        r6 = 0;
        r7 = r4;
        r4 = r6;
    L_0x0023:
        if (r4 >= r3) goto L_0x0062;
    L_0x0025:
        r5 = r13.get(r4);
        r5 = (com.amap.api.mapcore.util.bg) r5;
        r9 = r5.O0000o0O;
        if (r9 == 0) goto L_0x005f;
    L_0x002f:
        r9 = r5.O0000OoO;
        switch(r9) {
            case 1: goto L_0x003a;
            case 2: goto L_0x0035;
            case 3: goto L_0x003a;
            case 4: goto L_0x003a;
            default: goto L_0x0034;
        };
    L_0x0034:
        goto L_0x0042;
    L_0x0035:
        r7 = r5.O0000OOo;
        r8 = r5.O0000Oo0;
        goto L_0x003e;
    L_0x003a:
        r7 = r5.O00000o0;
        r8 = r5.O00000o;
    L_0x003e:
        r7 = O000000o(r7, r8);
    L_0x0042:
        r9 = java.lang.Long.valueOf(r7);
        r9 = r2.get(r9);
        r9 = (com.amap.api.mapcore.util.bg) r9;
        if (r9 == 0) goto L_0x005f;
    L_0x004e:
        r10 = r9.O00000oO();
        r11 = r5.O00000oO();
        if (r10 != r11) goto L_0x005d;
    L_0x0058:
        r9 = r9.O0000o00;
        r5.O0000o00 = r9;
        goto L_0x005f;
    L_0x005d:
        r5.O0000o00 = r0;
    L_0x005f:
        r4 = r4 + 1;
        goto L_0x0023;
    L_0x0062:
        r2.clear();
        r3 = r13.size();
    L_0x0069:
        if (r6 >= r3) goto L_0x009a;
    L_0x006b:
        r4 = r13.get(r6);
        r4 = (com.amap.api.mapcore.util.bg) r4;
        r5 = r4.O0000o0O;
        if (r5 == 0) goto L_0x0097;
    L_0x0075:
        r5 = r4.O0000OoO;
        switch(r5) {
            case 1: goto L_0x0084;
            case 2: goto L_0x007b;
            case 3: goto L_0x0084;
            case 4: goto L_0x0084;
            default: goto L_0x007a;
        };
    L_0x007a:
        goto L_0x0090;
    L_0x007b:
        r5 = r4.O00000o0();
        r7 = r4.O00000o();
        goto L_0x008c;
    L_0x0084:
        r5 = r4.O000000o();
        r7 = r4.O00000Oo();
    L_0x008c:
        r7 = O000000o(r5, r7);
    L_0x0090:
        r5 = java.lang.Long.valueOf(r7);
        r2.put(r5, r4);
    L_0x0097:
        r6 = r6 + 1;
        goto L_0x0069;
    L_0x009a:
        r12.O00000Oo = r0;
    L_0x009c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.be.O000000o(java.util.ArrayList):void");
    }
}
