package com.loc;

import android.content.Context;

/* compiled from: LocNetManager */
public final class O0Oo00 {
    private static O0Oo00 O00000Oo;
    O00O0o O000000o = null;
    private int O00000o = 0;
    private Context O00000o0 = null;
    private int O00000oO = O0o0000.O00000oo;
    private boolean O00000oo = false;
    private int O0000O0o = 0;

    private O0Oo00(Context context) {
        try {
            OO0OO0o.O000000o().O000000o(context);
        } catch (Throwable unused) {
        }
        this.O00000o0 = context;
        this.O000000o = O00O0o.O000000o();
    }

    public static O0Oo00 O000000o(Context context) {
        if (O00000Oo == null) {
            O00000Oo = new O0Oo00(context);
        }
        return O00000Oo;
    }

    public final int O000000o() {
        return this.O00000o;
    }

    public final O00Oo00 O000000o(O0Oo0 o0Oo0) throws Throwable {
        long O00000o0 = OO000OO.O00000o0();
        boolean z = this.O00000oo || OO000OO.O0000Oo(this.O00000o0);
        O00O0o o00O0o = this.O000000o;
        O00Oo00 O000000o = O00O0o.O000000o(o0Oo0, z);
        this.O00000o = Long.valueOf(OO000OO.O00000o0() - O00000o0).intValue();
        return O000000o;
    }

    /* JADX WARNING: Missing block: B:10:0x00c2, code skipped:
            r12.put(r14, r0);
     */
    /* JADX WARNING: Missing block: B:12:0x00cb, code skipped:
            r12.remove("custom");
     */
    /* JADX WARNING: Missing block: B:13:0x00d0, code skipped:
            r2.O0000Ooo = r12;
            r2.O000000o(r10.O00000oO);
            r2.O00000Oo(r10.O00000oO);
     */
    /* JADX WARNING: Missing block: B:14:0x00de, code skipped:
            if (r10.O00000oo != false) goto L_0x00e6;
     */
    /* JADX WARNING: Missing block: B:16:0x00e4, code skipped:
            if (com.loc.OO000OO.O0000Oo(r11) == false) goto L_0x00ff;
     */
    /* JADX WARNING: Missing block: B:18:0x00ec, code skipped:
            if (r13.startsWith("http:") == false) goto L_0x00ff;
     */
    /* JADX WARNING: Missing block: B:19:0x00ee, code skipped:
            r2.O0000O0o = r2.O00000o0().replace("https:", "https:");
     */
    /* JADX WARNING: Missing block: B:20:0x00fc, code skipped:
            return r2;
     */
    public final com.loc.O0Oo0 O000000o(android.content.Context r11, byte[] r12, java.lang.String r13, boolean r14) {
        /*
        r10 = this;
        r0 = new java.util.HashMap;	 Catch:{ Throwable -> 0x00fd }
        r1 = 16;
        r0.<init>(r1);	 Catch:{ Throwable -> 0x00fd }
        r2 = new com.loc.O0Oo0;	 Catch:{ Throwable -> 0x00fd }
        r3 = com.loc.O0o0000.O00000Oo();	 Catch:{ Throwable -> 0x00fd }
        r2.<init>(r11, r3);	 Catch:{ Throwable -> 0x00fd }
        r3 = "Content-Type";
        r4 = "application/octet-stream";
        r0.put(r3, r4);	 Catch:{ Throwable -> 0x00ff }
        r3 = "Accept-Encoding";
        r4 = "gzip";
        r0.put(r3, r4);	 Catch:{ Throwable -> 0x00ff }
        r3 = "gzipped";
        r4 = "1";
        r0.put(r3, r4);	 Catch:{ Throwable -> 0x00ff }
        r3 = "Connection";
        r4 = "Keep-Alive";
        r0.put(r3, r4);	 Catch:{ Throwable -> 0x00ff }
        r3 = "User-Agent";
        r4 = "AMAP_Location_SDK_Android 4.6.0";
        r0.put(r3, r4);	 Catch:{ Throwable -> 0x00ff }
        r3 = "KEY";
        r4 = com.loc.OO00o00.O00000oo(r11);	 Catch:{ Throwable -> 0x00ff }
        r0.put(r3, r4);	 Catch:{ Throwable -> 0x00ff }
        r3 = "enginever";
        r4 = "5.1";
        r0.put(r3, r4);	 Catch:{ Throwable -> 0x00ff }
        r3 = com.loc.OO0O0O.O000000o();	 Catch:{ Throwable -> 0x00ff }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00ff }
        r5 = "key=";
        r4.<init>(r5);	 Catch:{ Throwable -> 0x00ff }
        r5 = com.loc.OO00o00.O00000oo(r11);	 Catch:{ Throwable -> 0x00ff }
        r4.append(r5);	 Catch:{ Throwable -> 0x00ff }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x00ff }
        r4 = com.loc.OO0O0O.O000000o(r11, r3, r4);	 Catch:{ Throwable -> 0x00ff }
        r5 = "ts";
        r0.put(r5, r3);	 Catch:{ Throwable -> 0x00ff }
        r3 = "scode";
        r0.put(r3, r4);	 Catch:{ Throwable -> 0x00ff }
        r3 = "encr";
        r4 = "1";
        r0.put(r3, r4);	 Catch:{ Throwable -> 0x00ff }
        r2.O00000oo = r0;	 Catch:{ Throwable -> 0x00ff }
        r0 = "loc";
        if (r14 != 0) goto L_0x0076;
    L_0x0074:
        r0 = "locf";
    L_0x0076:
        r3 = 1;
        r2.O0000o00 = r3;	 Catch:{ Throwable -> 0x00ff }
        r4 = java.util.Locale.US;	 Catch:{ Throwable -> 0x00ff }
        r5 = "platform=Android&sdkversion=%s&product=%s&loc_channel=%s";
        r6 = 3;
        r7 = new java.lang.Object[r6];	 Catch:{ Throwable -> 0x00ff }
        r8 = 0;
        r9 = "4.6.0";
        r7[r8] = r9;	 Catch:{ Throwable -> 0x00ff }
        r7[r3] = r0;	 Catch:{ Throwable -> 0x00ff }
        r0 = 2;
        r3 = java.lang.Integer.valueOf(r6);	 Catch:{ Throwable -> 0x00ff }
        r7[r0] = r3;	 Catch:{ Throwable -> 0x00ff }
        r0 = java.lang.String.format(r4, r5, r7);	 Catch:{ Throwable -> 0x00ff }
        r2.O0000OoO = r0;	 Catch:{ Throwable -> 0x00ff }
        r2.O0000Oo = r14;	 Catch:{ Throwable -> 0x00ff }
        r2.O0000O0o = r13;	 Catch:{ Throwable -> 0x00ff }
        r12 = com.loc.OO000OO.O000000o(r12);	 Catch:{ Throwable -> 0x00ff }
        r2.O0000OOo = r12;	 Catch:{ Throwable -> 0x00ff }
        r12 = com.loc.OO0OOo0.O000000o(r11);	 Catch:{ Throwable -> 0x00ff }
        r2.O000000o(r12);	 Catch:{ Throwable -> 0x00ff }
        r12 = new java.util.HashMap;	 Catch:{ Throwable -> 0x00ff }
        r12.<init>(r1);	 Catch:{ Throwable -> 0x00ff }
        r14 = "output";
        r0 = "bin";
        r12.put(r14, r0);	 Catch:{ Throwable -> 0x00ff }
        r14 = "policy";
        r0 = "3103";
        r12.put(r14, r0);	 Catch:{ Throwable -> 0x00ff }
        r14 = r10.O0000O0o;	 Catch:{ Throwable -> 0x00ff }
        switch(r14) {
            case 0: goto L_0x00cb;
            case 1: goto L_0x00c6;
            case 2: goto L_0x00be;
            default: goto L_0x00bd;
        };	 Catch:{ Throwable -> 0x00ff }
    L_0x00bd:
        goto L_0x00cb;
    L_0x00be:
        r14 = "custom";
        r0 = "language:en";
    L_0x00c2:
        r12.put(r14, r0);	 Catch:{ Throwable -> 0x00ff }
        goto L_0x00d0;
    L_0x00c6:
        r14 = "custom";
        r0 = "language:cn";
        goto L_0x00c2;
    L_0x00cb:
        r14 = "custom";
        r12.remove(r14);	 Catch:{ Throwable -> 0x00ff }
    L_0x00d0:
        r2.O0000Ooo = r12;	 Catch:{ Throwable -> 0x00ff }
        r12 = r10.O00000oO;	 Catch:{ Throwable -> 0x00ff }
        r2.O000000o(r12);	 Catch:{ Throwable -> 0x00ff }
        r12 = r10.O00000oO;	 Catch:{ Throwable -> 0x00ff }
        r2.O00000Oo(r12);	 Catch:{ Throwable -> 0x00ff }
        r12 = r10.O00000oo;	 Catch:{ Throwable -> 0x00ff }
        if (r12 != 0) goto L_0x00e6;
    L_0x00e0:
        r11 = com.loc.OO000OO.O0000Oo(r11);	 Catch:{ Throwable -> 0x00ff }
        if (r11 == 0) goto L_0x00ff;
    L_0x00e6:
        r11 = "http:";
        r11 = r13.startsWith(r11);	 Catch:{ Throwable -> 0x00ff }
        if (r11 == 0) goto L_0x00ff;
    L_0x00ee:
        r11 = r2.O00000o0();	 Catch:{ Throwable -> 0x00ff }
        r12 = "https:";
        r13 = "https:";
        r11 = r11.replace(r12, r13);	 Catch:{ Throwable -> 0x00ff }
        r2.O0000O0o = r11;	 Catch:{ Throwable -> 0x00ff }
        return r2;
    L_0x00fd:
        r11 = 0;
        r2 = r11;
    L_0x00ff:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O0Oo00.O000000o(android.content.Context, byte[], java.lang.String, boolean):com.loc.O0Oo0");
    }

    /* JADX WARNING: Missing block: B:5:0x0047, code skipped:
            r3.put(r1, r4);
     */
    /* JADX WARNING: Missing block: B:7:0x0050, code skipped:
            r3.remove("language");
     */
    /* JADX WARNING: Missing block: B:8:0x0055, code skipped:
            r1 = com.loc.OO0O0O.O000000o();
            r4 = com.loc.OO0O0O.O000000o(r7, r1, com.loc.OO0o000.O00000Oo(r3));
            r3.put(com.tencent.stat.DeviceInfo.TAG_TIMESTAMPS, r1);
            r3.put("scode", r4);
            r1 = new java.lang.StringBuilder("output=json&radius=1000&extensions=all&location=");
            r1.append(r10);
            r1.append(",");
            r1.append(r8);
            r2.O00000Oo(r1.toString().getBytes(cn.jiguang.net.HttpUtils.ENCODING_UTF_8));
            r2.O0000o00 = false;
            r2.O0000Oo = true;
            r2.O0000OoO = java.lang.String.format(java.util.Locale.US, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s", new java.lang.Object[]{"4.6.0", "loc", java.lang.Integer.valueOf(3)});
            r2.O0000Ooo = r3;
            r2.O00000oo = r0;
            r2.O000000o(com.loc.OO0OOo0.O000000o(r7));
            r2.O000000o(com.loc.O0o0000.O00000oo);
            r2.O00000Oo(com.loc.O0o0000.O00000oo);
     */
    /* JADX WARNING: Missing block: B:10:?, code skipped:
            r8 = "http://restapi.amap.com/v3/geocode/regeo";
     */
    /* JADX WARNING: Missing block: B:11:0x00c7, code skipped:
            if (com.loc.OO000OO.O0000Oo(r7) == false) goto L_0x00da;
     */
    /* JADX WARNING: Missing block: B:12:0x00c9, code skipped:
            r2.O0000O0o = r8.replace("http:", "https:");
            r7 = r6.O000000o;
            r7 = com.loc.O00O0o.O000000o(r2);
     */
    /* JADX WARNING: Missing block: B:13:0x00da, code skipped:
            r2.O0000O0o = r8;
            r7 = r6.O000000o;
            r7 = com.loc.O00O0o.O00000Oo(r2);
     */
    /* JADX WARNING: Missing block: B:15:0x00e9, code skipped:
            return new java.lang.String(r7, "utf-8");
     */
    public final java.lang.String O000000o(android.content.Context r7, double r8, double r10) {
        /*
        r6 = this;
        r0 = new java.util.HashMap;	 Catch:{ Throwable -> 0x00f2 }
        r1 = 16;
        r0.<init>(r1);	 Catch:{ Throwable -> 0x00f2 }
        r2 = new com.loc.O0Oo0;	 Catch:{ Throwable -> 0x00f2 }
        r3 = com.loc.O0o0000.O00000Oo();	 Catch:{ Throwable -> 0x00f2 }
        r2.<init>(r7, r3);	 Catch:{ Throwable -> 0x00f2 }
        r0.clear();	 Catch:{ Throwable -> 0x00f2 }
        r3 = "Content-Type";
        r4 = "application/x-www-form-urlencoded";
        r0.put(r3, r4);	 Catch:{ Throwable -> 0x00f2 }
        r3 = "Connection";
        r4 = "Keep-Alive";
        r0.put(r3, r4);	 Catch:{ Throwable -> 0x00f2 }
        r3 = "User-Agent";
        r4 = "AMAP_Location_SDK_Android 4.6.0";
        r0.put(r3, r4);	 Catch:{ Throwable -> 0x00f2 }
        r3 = new java.util.HashMap;	 Catch:{ Throwable -> 0x00f2 }
        r3.<init>(r1);	 Catch:{ Throwable -> 0x00f2 }
        r1 = "custom";
        r4 = "26260A1F00020002";
        r3.put(r1, r4);	 Catch:{ Throwable -> 0x00f2 }
        r1 = "key";
        r4 = com.loc.OO00o00.O00000oo(r7);	 Catch:{ Throwable -> 0x00f2 }
        r3.put(r1, r4);	 Catch:{ Throwable -> 0x00f2 }
        r1 = r6.O0000O0o;	 Catch:{ Throwable -> 0x00f2 }
        switch(r1) {
            case 0: goto L_0x0050;
            case 1: goto L_0x004b;
            case 2: goto L_0x0043;
            default: goto L_0x0042;
        };	 Catch:{ Throwable -> 0x00f2 }
    L_0x0042:
        goto L_0x0050;
    L_0x0043:
        r1 = "language";
        r4 = "en";
    L_0x0047:
        r3.put(r1, r4);	 Catch:{ Throwable -> 0x00f2 }
        goto L_0x0055;
    L_0x004b:
        r1 = "language";
        r4 = "zh-CN";
        goto L_0x0047;
    L_0x0050:
        r1 = "language";
        r3.remove(r1);	 Catch:{ Throwable -> 0x00f2 }
    L_0x0055:
        r1 = com.loc.OO0O0O.O000000o();	 Catch:{ Throwable -> 0x00f2 }
        r4 = com.loc.OO0o000.O00000Oo(r3);	 Catch:{ Throwable -> 0x00f2 }
        r4 = com.loc.OO0O0O.O000000o(r7, r1, r4);	 Catch:{ Throwable -> 0x00f2 }
        r5 = "ts";
        r3.put(r5, r1);	 Catch:{ Throwable -> 0x00f2 }
        r1 = "scode";
        r3.put(r1, r4);	 Catch:{ Throwable -> 0x00f2 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00f2 }
        r4 = "output=json&radius=1000&extensions=all&location=";
        r1.<init>(r4);	 Catch:{ Throwable -> 0x00f2 }
        r1.append(r10);	 Catch:{ Throwable -> 0x00f2 }
        r10 = ",";
        r1.append(r10);	 Catch:{ Throwable -> 0x00f2 }
        r1.append(r8);	 Catch:{ Throwable -> 0x00f2 }
        r8 = r1.toString();	 Catch:{ Throwable -> 0x00f2 }
        r9 = "UTF-8";
        r8 = r8.getBytes(r9);	 Catch:{ Throwable -> 0x00f2 }
        r2.O00000Oo(r8);	 Catch:{ Throwable -> 0x00f2 }
        r8 = 0;
        r2.O0000o00 = r8;	 Catch:{ Throwable -> 0x00f2 }
        r9 = 1;
        r2.O0000Oo = r9;	 Catch:{ Throwable -> 0x00f2 }
        r10 = java.util.Locale.US;	 Catch:{ Throwable -> 0x00f2 }
        r11 = "platform=Android&sdkversion=%s&product=%s&loc_channel=%s";
        r1 = 3;
        r4 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x00f2 }
        r5 = "4.6.0";
        r4[r8] = r5;	 Catch:{ Throwable -> 0x00f2 }
        r8 = "loc";
        r4[r9] = r8;	 Catch:{ Throwable -> 0x00f2 }
        r8 = 2;
        r9 = java.lang.Integer.valueOf(r1);	 Catch:{ Throwable -> 0x00f2 }
        r4[r8] = r9;	 Catch:{ Throwable -> 0x00f2 }
        r8 = java.lang.String.format(r10, r11, r4);	 Catch:{ Throwable -> 0x00f2 }
        r2.O0000OoO = r8;	 Catch:{ Throwable -> 0x00f2 }
        r2.O0000Ooo = r3;	 Catch:{ Throwable -> 0x00f2 }
        r2.O00000oo = r0;	 Catch:{ Throwable -> 0x00f2 }
        r8 = com.loc.OO0OOo0.O000000o(r7);	 Catch:{ Throwable -> 0x00f2 }
        r2.O000000o(r8);	 Catch:{ Throwable -> 0x00f2 }
        r8 = com.loc.O0o0000.O00000oo;	 Catch:{ Throwable -> 0x00f2 }
        r2.O000000o(r8);	 Catch:{ Throwable -> 0x00f2 }
        r8 = com.loc.O0o0000.O00000oo;	 Catch:{ Throwable -> 0x00f2 }
        r2.O00000Oo(r8);	 Catch:{ Throwable -> 0x00f2 }
        r8 = "http://restapi.amap.com/v3/geocode/regeo";
        r7 = com.loc.OO000OO.O0000Oo(r7);	 Catch:{ Throwable -> 0x00ea }
        if (r7 == 0) goto L_0x00da;
    L_0x00c9:
        r7 = "http:";
        r9 = "https:";
        r7 = r8.replace(r7, r9);	 Catch:{ Throwable -> 0x00ea }
        r2.O0000O0o = r7;	 Catch:{ Throwable -> 0x00ea }
        r7 = r6.O000000o;	 Catch:{ Throwable -> 0x00ea }
        r7 = com.loc.O00O0o.O000000o(r2);	 Catch:{ Throwable -> 0x00ea }
        goto L_0x00e2;
    L_0x00da:
        r2.O0000O0o = r8;	 Catch:{ Throwable -> 0x00ea }
        r7 = r6.O000000o;	 Catch:{ Throwable -> 0x00ea }
        r7 = com.loc.O00O0o.O00000Oo(r2);	 Catch:{ Throwable -> 0x00ea }
    L_0x00e2:
        r8 = new java.lang.String;	 Catch:{ Throwable -> 0x00ea }
        r9 = "utf-8";
        r8.<init>(r7, r9);	 Catch:{ Throwable -> 0x00ea }
        return r8;
    L_0x00ea:
        r7 = move-exception;
        r8 = "LocNetManager";
        r9 = "post";
        com.loc.O0o0000.O000000o(r7, r8, r9);	 Catch:{ Throwable -> 0x00f2 }
    L_0x00f2:
        r8 = 0;
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O0Oo00.O000000o(android.content.Context, double, double):java.lang.String");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0009 */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    public final void O000000o(long r2, boolean r4, int r5) {
        /*
        r1 = this;
        r1.O00000oo = r4;	 Catch:{ Throwable -> 0x0016 }
        r0 = com.loc.OO0OO0o.O000000o();	 Catch:{ Throwable -> 0x0009 }
        r0.O000000o(r4);	 Catch:{ Throwable -> 0x0009 }
    L_0x0009:
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ Throwable -> 0x0016 }
        r2 = r2.intValue();	 Catch:{ Throwable -> 0x0016 }
        r1.O00000oO = r2;	 Catch:{ Throwable -> 0x0016 }
        r1.O0000O0o = r5;	 Catch:{ Throwable -> 0x0016 }
        return;
    L_0x0016:
        r2 = move-exception;
        r3 = "LocNetManager";
        r4 = "setOption";
        com.loc.O0o0000.O000000o(r2, r3, r4);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O0Oo00.O000000o(long, boolean, int):void");
    }
}
