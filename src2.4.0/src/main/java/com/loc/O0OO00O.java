package com.loc;

import java.util.HashMap;

/* compiled from: CellAgeEstimator */
public final class O0OO00O {
    private HashMap<Long, O0OO0O> O000000o = new HashMap();
    private long O00000Oo = 0;

    private static long O000000o(int i, int i2) {
        return ((((long) i) & 65535) << 32) | (((long) i2) & 65535);
    }

    public final long O000000o(O0OO0O o0oo0o) {
        if (o0oo0o == null || !o0oo0o.O0000o0o) {
            return 0;
        }
        int i;
        int i2;
        long j;
        HashMap hashMap = this.O000000o;
        switch (o0oo0o.O0000OoO) {
            case 1:
            case 3:
            case 4:
                i = o0oo0o.O00000o0;
                i2 = o0oo0o.O00000o;
                break;
            case 2:
                i = o0oo0o.O0000OOo;
                i2 = o0oo0o.O0000Oo0;
                break;
            default:
                j = 0;
                break;
        }
        j = O000000o(i, i2);
        O0OO0O o0oo0o2 = (O0OO0O) hashMap.get(Long.valueOf(j));
        if (o0oo0o2 != null && o0oo0o2.O0000Oo == o0oo0o.O0000Oo) {
            o0oo0o.O0000o00 = o0oo0o2.O0000o00;
            hashMap.put(Long.valueOf(j), o0oo0o);
            return (OO000OO.O00000o0() - o0oo0o2.O0000o00) / 1000;
        }
        o0oo0o.O0000o00 = OO000OO.O00000o0();
        hashMap.put(Long.valueOf(j), o0oo0o);
        return 0;
    }

    public final void O000000o() {
        this.O000000o.clear();
        this.O00000Oo = 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x005b A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004e  */
    public final void O000000o(java.util.ArrayList<? extends com.loc.O0OO0O> r13) {
        /*
        r12 = this;
        if (r13 == 0) goto L_0x0090;
    L_0x0002:
        r0 = com.loc.OO000OO.O00000o0();
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
        if (r4 >= r3) goto L_0x005e;
    L_0x0025:
        r5 = r13.get(r4);
        r5 = (com.loc.O0OO0O) r5;
        r9 = r5.O0000o0o;
        if (r9 == 0) goto L_0x005b;
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
        r9 = (com.loc.O0OO0O) r9;
        if (r9 == 0) goto L_0x005b;
    L_0x004e:
        r10 = r9.O0000Oo;
        r11 = r5.O0000Oo;
        if (r10 != r11) goto L_0x0059;
    L_0x0054:
        r9 = r9.O0000o00;
        r5.O0000o00 = r9;
        goto L_0x005b;
    L_0x0059:
        r5.O0000o00 = r0;
    L_0x005b:
        r4 = r4 + 1;
        goto L_0x0023;
    L_0x005e:
        r2.clear();
        r3 = r13.size();
    L_0x0065:
        if (r6 >= r3) goto L_0x008e;
    L_0x0067:
        r4 = r13.get(r6);
        r4 = (com.loc.O0OO0O) r4;
        r5 = r4.O0000o0o;
        if (r5 == 0) goto L_0x008b;
    L_0x0071:
        r5 = r4.O0000OoO;
        switch(r5) {
            case 1: goto L_0x007c;
            case 2: goto L_0x0077;
            case 3: goto L_0x007c;
            case 4: goto L_0x007c;
            default: goto L_0x0076;
        };
    L_0x0076:
        goto L_0x0084;
    L_0x0077:
        r5 = r4.O0000OOo;
        r7 = r4.O0000Oo0;
        goto L_0x0080;
    L_0x007c:
        r5 = r4.O00000o0;
        r7 = r4.O00000o;
    L_0x0080:
        r7 = O000000o(r5, r7);
    L_0x0084:
        r5 = java.lang.Long.valueOf(r7);
        r2.put(r5, r4);
    L_0x008b:
        r6 = r6 + 1;
        goto L_0x0065;
    L_0x008e:
        r12.O00000Oo = r0;
    L_0x0090:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O0OO00O.O000000o(java.util.ArrayList):void");
    }
}
