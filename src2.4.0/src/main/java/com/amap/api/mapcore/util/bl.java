package com.amap.api.mapcore.util;

import android.content.Context;

/* compiled from: LocNetManager */
public final class bl {
    private static bl O00000Oo;
    ooooOO00 O000000o = null;
    private int O00000o = 0;
    private Context O00000o0 = null;
    private int O00000oO = bp.O00000oo;
    private boolean O00000oo = false;
    private int O0000O0o = 0;

    private bl(Context context) {
        try {
            o0OO00OO.O000000o().O000000o(context);
        } catch (Throwable unused) {
        }
        this.O00000o0 = context;
        this.O000000o = ooooOO00.O000000o();
    }

    public static bl O000000o(Context context) {
        if (O00000Oo == null) {
            O00000Oo = new bl(context);
        }
        return O00000Oo;
    }

    /* JADX WARNING: Missing block: B:7:0x00c4, code skipped:
            r11.put(r0, r1);
     */
    /* JADX WARNING: Missing block: B:9:0x00cd, code skipped:
            r11.remove("custom");
     */
    /* JADX WARNING: Missing block: B:10:0x00d2, code skipped:
            r2.O000000o(r11);
            r2.setConnectionTimeout(r9.O00000oO);
            r2.setSoTimeout(r9.O00000oO);
     */
    /* JADX WARNING: Missing block: B:11:0x00e1, code skipped:
            if (r9.O00000oo != false) goto L_0x00e9;
     */
    /* JADX WARNING: Missing block: B:13:0x00e7, code skipped:
            if (com.amap.api.mapcore.util.bt.O00000oO(r10) == false) goto L_0x0103;
     */
    /* JADX WARNING: Missing block: B:15:0x00ef, code skipped:
            if (r12.startsWith("http:") == false) goto L_0x0103;
     */
    /* JADX WARNING: Missing block: B:16:0x00f1, code skipped:
            r2.O00000Oo(r2.getURL().replace("https:", "https:"));
     */
    /* JADX WARNING: Missing block: B:17:0x0100, code skipped:
            return r2;
     */
    public final com.amap.api.mapcore.util.bm O000000o(android.content.Context r10, byte[] r11, java.lang.String r12) {
        /*
        r9 = this;
        r0 = new java.util.HashMap;	 Catch:{ Throwable -> 0x0101 }
        r1 = 16;
        r0.<init>(r1);	 Catch:{ Throwable -> 0x0101 }
        r2 = new com.amap.api.mapcore.util.bm;	 Catch:{ Throwable -> 0x0101 }
        r3 = com.amap.api.mapcore.util.bp.O00000Oo();	 Catch:{ Throwable -> 0x0101 }
        r2.<init>(r10, r3);	 Catch:{ Throwable -> 0x0101 }
        r3 = "Content-Type";
        r4 = "application/octet-stream";
        r0.put(r3, r4);	 Catch:{ Throwable -> 0x0103 }
        r3 = "Accept-Encoding";
        r4 = "gzip";
        r0.put(r3, r4);	 Catch:{ Throwable -> 0x0103 }
        r3 = "gzipped";
        r4 = "1";
        r0.put(r3, r4);	 Catch:{ Throwable -> 0x0103 }
        r3 = "Connection";
        r4 = "Keep-Alive";
        r0.put(r3, r4);	 Catch:{ Throwable -> 0x0103 }
        r3 = "User-Agent";
        r4 = "AMAP_Location_SDK_Android 4.5.1";
        r0.put(r3, r4);	 Catch:{ Throwable -> 0x0103 }
        r3 = "KEY";
        r4 = com.amap.api.mapcore.util.o0O0O0Oo.O00000oo(r10);	 Catch:{ Throwable -> 0x0103 }
        r0.put(r3, r4);	 Catch:{ Throwable -> 0x0103 }
        r3 = "enginever";
        r4 = "4.9";
        r0.put(r3, r4);	 Catch:{ Throwable -> 0x0103 }
        r3 = com.amap.api.mapcore.util.o0O0OOOo.O000000o();	 Catch:{ Throwable -> 0x0103 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0103 }
        r5 = "key=";
        r4.<init>(r5);	 Catch:{ Throwable -> 0x0103 }
        r5 = com.amap.api.mapcore.util.o0O0O0Oo.O00000oo(r10);	 Catch:{ Throwable -> 0x0103 }
        r4.append(r5);	 Catch:{ Throwable -> 0x0103 }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x0103 }
        r4 = com.amap.api.mapcore.util.o0O0OOOo.O000000o(r10, r3, r4);	 Catch:{ Throwable -> 0x0103 }
        r5 = "ts";
        r0.put(r5, r3);	 Catch:{ Throwable -> 0x0103 }
        r3 = "scode";
        r0.put(r3, r4);	 Catch:{ Throwable -> 0x0103 }
        r3 = "encr";
        r4 = "1";
        r0.put(r3, r4);	 Catch:{ Throwable -> 0x0103 }
        r2.O00000Oo(r0);	 Catch:{ Throwable -> 0x0103 }
        r0 = "loc";
        r2.O0000Oo0();	 Catch:{ Throwable -> 0x0103 }
        r3 = java.util.Locale.US;	 Catch:{ Throwable -> 0x0103 }
        r4 = "platform=Android&sdkversion=%s&product=%s&loc_channel=%s";
        r5 = 3;
        r6 = new java.lang.Object[r5];	 Catch:{ Throwable -> 0x0103 }
        r7 = 0;
        r8 = "4.5.1";
        r6[r7] = r8;	 Catch:{ Throwable -> 0x0103 }
        r7 = 1;
        r6[r7] = r0;	 Catch:{ Throwable -> 0x0103 }
        r0 = 2;
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Throwable -> 0x0103 }
        r6[r0] = r5;	 Catch:{ Throwable -> 0x0103 }
        r0 = java.lang.String.format(r3, r4, r6);	 Catch:{ Throwable -> 0x0103 }
        r2.O000000o(r0);	 Catch:{ Throwable -> 0x0103 }
        r2.O000000o();	 Catch:{ Throwable -> 0x0103 }
        r2.O00000Oo(r12);	 Catch:{ Throwable -> 0x0103 }
        r11 = com.amap.api.mapcore.util.bt.O000000o(r11);	 Catch:{ Throwable -> 0x0103 }
        r2.O00000Oo(r11);	 Catch:{ Throwable -> 0x0103 }
        r11 = com.amap.api.mapcore.util.o0OO0OO0.O000000o(r10);	 Catch:{ Throwable -> 0x0103 }
        r2.setProxy(r11);	 Catch:{ Throwable -> 0x0103 }
        r11 = new java.util.HashMap;	 Catch:{ Throwable -> 0x0103 }
        r11.<init>(r1);	 Catch:{ Throwable -> 0x0103 }
        r0 = "output";
        r1 = "bin";
        r11.put(r0, r1);	 Catch:{ Throwable -> 0x0103 }
        r0 = "policy";
        r1 = "3103";
        r11.put(r0, r1);	 Catch:{ Throwable -> 0x0103 }
        r0 = r9.O0000O0o;	 Catch:{ Throwable -> 0x0103 }
        switch(r0) {
            case 0: goto L_0x00cd;
            case 1: goto L_0x00c8;
            case 2: goto L_0x00c0;
            default: goto L_0x00bf;
        };	 Catch:{ Throwable -> 0x0103 }
    L_0x00bf:
        goto L_0x00cd;
    L_0x00c0:
        r0 = "custom";
        r1 = "language:en";
    L_0x00c4:
        r11.put(r0, r1);	 Catch:{ Throwable -> 0x0103 }
        goto L_0x00d2;
    L_0x00c8:
        r0 = "custom";
        r1 = "language:cn";
        goto L_0x00c4;
    L_0x00cd:
        r0 = "custom";
        r11.remove(r0);	 Catch:{ Throwable -> 0x0103 }
    L_0x00d2:
        r2.O000000o(r11);	 Catch:{ Throwable -> 0x0103 }
        r11 = r9.O00000oO;	 Catch:{ Throwable -> 0x0103 }
        r2.setConnectionTimeout(r11);	 Catch:{ Throwable -> 0x0103 }
        r11 = r9.O00000oO;	 Catch:{ Throwable -> 0x0103 }
        r2.setSoTimeout(r11);	 Catch:{ Throwable -> 0x0103 }
        r11 = r9.O00000oo;	 Catch:{ Throwable -> 0x0103 }
        if (r11 != 0) goto L_0x00e9;
    L_0x00e3:
        r10 = com.amap.api.mapcore.util.bt.O00000oO(r10);	 Catch:{ Throwable -> 0x0103 }
        if (r10 == 0) goto L_0x0103;
    L_0x00e9:
        r10 = "http:";
        r10 = r12.startsWith(r10);	 Catch:{ Throwable -> 0x0103 }
        if (r10 == 0) goto L_0x0103;
    L_0x00f1:
        r10 = r2.getURL();	 Catch:{ Throwable -> 0x0103 }
        r11 = "https:";
        r12 = "https:";
        r10 = r10.replace(r11, r12);	 Catch:{ Throwable -> 0x0103 }
        r2.O00000Oo(r10);	 Catch:{ Throwable -> 0x0103 }
        return r2;
    L_0x0101:
        r10 = 0;
        r2 = r10;
    L_0x0103:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.bl.O000000o(android.content.Context, byte[], java.lang.String):com.amap.api.mapcore.util.bm");
    }

    public final oOO0Oo00 O000000o(bm bmVar) throws Throwable {
        long O00000Oo = bt.O00000Oo();
        boolean z = this.O00000oo || bt.O00000oO(this.O00000o0);
        oOO0Oo00 O000000o = this.O000000o.O000000o(bmVar, z);
        this.O00000o = Long.valueOf(bt.O00000Oo() - O00000Oo).intValue();
        return O000000o;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0009 */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    public final void O000000o(long r2, boolean r4) {
        /*
        r1 = this;
        r1.O00000oo = r4;	 Catch:{ Throwable -> 0x0017 }
        r0 = com.amap.api.mapcore.util.o0OO00OO.O000000o();	 Catch:{ Throwable -> 0x0009 }
        r0.O000000o(r4);	 Catch:{ Throwable -> 0x0009 }
    L_0x0009:
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ Throwable -> 0x0017 }
        r2 = r2.intValue();	 Catch:{ Throwable -> 0x0017 }
        r1.O00000oO = r2;	 Catch:{ Throwable -> 0x0017 }
        r2 = 0;
        r1.O0000O0o = r2;	 Catch:{ Throwable -> 0x0017 }
        return;
    L_0x0017:
        r2 = move-exception;
        r3 = "LocNetManager";
        r4 = "setOption";
        com.amap.api.mapcore.util.bp.O000000o(r2, r3, r4);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.bl.O000000o(long, boolean):void");
    }
}
