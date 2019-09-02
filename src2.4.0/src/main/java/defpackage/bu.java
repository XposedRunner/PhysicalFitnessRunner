package defpackage;

/* compiled from: ImageFormat */
/* renamed from: bu */
public class bu {
    public static final int O000000o = 0;
    public static final int O00000Oo = 1;
    public static final int O00000o = 3;
    public static final int O00000o0 = 2;
    public static final int O00000oO = 4;
    public static final int O00000oo = 5;
    public static final int O0000O0o = 6;
    public static final int O0000OOo = 7;
    public static final int O0000Oo = 9;
    public static final int O0000Oo0 = 8;
    public static final int O0000OoO = 10;
    public static final int O0000Ooo = 11;
    public static final String[] O0000o00 = new String[]{"jpeg", "gif", "png", "bmp", "pcx", "iff", "ras", "pbm", "pgm", "ppm", "psd", "swf"};

    /* JADX WARNING: Unknown top exception splitter block from list: {B:131:0x012c=Splitter:B:131:0x012c, B:101:0x00ed=Splitter:B:101:0x00ed} */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:131:0x012c=Splitter:B:131:0x012c, B:101:0x00ed=Splitter:B:101:0x00ed} */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x015a A:{SYNTHETIC, Splitter:B:154:0x015a} */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x014d A:{SYNTHETIC, Splitter:B:148:0x014d} */
    public static java.lang.String O000000o(byte[] r10) {
        /*
        r0 = 0;
        r1 = new java.io.ByteArrayInputStream;	 Catch:{ Exception -> 0x0143 }
        r1.<init>(r10);	 Catch:{ Exception -> 0x0143 }
        r10 = r1.read();	 Catch:{ Exception -> 0x013d, all -> 0x013b }
        r0 = r1.read();	 Catch:{ Exception -> 0x013d, all -> 0x013b }
        r2 = 71;
        r3 = 1;
        if (r10 != r2) goto L_0x0028;
    L_0x0013:
        r2 = 73;
        if (r0 != r2) goto L_0x0028;
    L_0x0017:
        r10 = O0000o00;	 Catch:{ Exception -> 0x013d, all -> 0x013b }
        r10 = r10[r3];	 Catch:{ Exception -> 0x013d, all -> 0x013b }
        if (r1 == 0) goto L_0x0027;
    L_0x001d:
        r1.close();	 Catch:{ IOException -> 0x0021 }
        goto L_0x0027;
    L_0x0021:
        r0 = move-exception;
        r1 = com.umeng.socialize.utils.O0000o00.O0000OOo.O00000o0;
        com.umeng.socialize.utils.O0000O0o.O000000o(r1, r0);
    L_0x0027:
        return r10;
    L_0x0028:
        r2 = 137; // 0x89 float:1.92E-43 double:6.77E-322;
        r4 = 80;
        if (r10 != r2) goto L_0x0042;
    L_0x002e:
        if (r0 != r4) goto L_0x0042;
    L_0x0030:
        r10 = O0000o00;	 Catch:{ Exception -> 0x013d, all -> 0x013b }
        r0 = 2;
        r10 = r10[r0];	 Catch:{ Exception -> 0x013d, all -> 0x013b }
        if (r1 == 0) goto L_0x0041;
    L_0x0037:
        r1.close();	 Catch:{ IOException -> 0x003b }
        goto L_0x0041;
    L_0x003b:
        r0 = move-exception;
        r1 = com.umeng.socialize.utils.O0000o00.O0000OOo.O00000o0;
        com.umeng.socialize.utils.O0000O0o.O000000o(r1, r0);
    L_0x0041:
        return r10;
    L_0x0042:
        r2 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        if (r10 != r2) goto L_0x005c;
    L_0x0046:
        r2 = 216; // 0xd8 float:3.03E-43 double:1.067E-321;
        if (r0 != r2) goto L_0x005c;
    L_0x004a:
        r10 = O0000o00;	 Catch:{ Exception -> 0x013d, all -> 0x013b }
        r0 = 0;
        r10 = r10[r0];	 Catch:{ Exception -> 0x013d, all -> 0x013b }
        if (r1 == 0) goto L_0x005b;
    L_0x0051:
        r1.close();	 Catch:{ IOException -> 0x0055 }
        goto L_0x005b;
    L_0x0055:
        r0 = move-exception;
        r1 = com.umeng.socialize.utils.O0000o00.O0000OOo.O00000o0;
        com.umeng.socialize.utils.O0000O0o.O000000o(r1, r0);
    L_0x005b:
        return r10;
    L_0x005c:
        r2 = 66;
        r5 = 3;
        if (r10 != r2) goto L_0x0076;
    L_0x0061:
        r6 = 77;
        if (r0 != r6) goto L_0x0076;
    L_0x0065:
        r10 = O0000o00;	 Catch:{ Exception -> 0x013d, all -> 0x013b }
        r10 = r10[r5];	 Catch:{ Exception -> 0x013d, all -> 0x013b }
        if (r1 == 0) goto L_0x0075;
    L_0x006b:
        r1.close();	 Catch:{ IOException -> 0x006f }
        goto L_0x0075;
    L_0x006f:
        r0 = move-exception;
        r1 = com.umeng.socialize.utils.O0000o00.O0000OOo.O00000o0;
        com.umeng.socialize.utils.O0000O0o.O000000o(r1, r0);
    L_0x0075:
        return r10;
    L_0x0076:
        r6 = 10;
        r7 = 6;
        if (r10 != r6) goto L_0x008f;
    L_0x007b:
        if (r0 >= r7) goto L_0x008f;
    L_0x007d:
        r10 = O0000o00;	 Catch:{ Exception -> 0x013d, all -> 0x013b }
        r0 = 4;
        r10 = r10[r0];	 Catch:{ Exception -> 0x013d, all -> 0x013b }
        if (r1 == 0) goto L_0x008e;
    L_0x0084:
        r1.close();	 Catch:{ IOException -> 0x0088 }
        goto L_0x008e;
    L_0x0088:
        r0 = move-exception;
        r1 = com.umeng.socialize.utils.O0000o00.O0000OOo.O00000o0;
        com.umeng.socialize.utils.O0000O0o.O000000o(r1, r0);
    L_0x008e:
        return r10;
    L_0x008f:
        r8 = 70;
        if (r10 != r8) goto L_0x00a9;
    L_0x0093:
        r9 = 79;
        if (r0 != r9) goto L_0x00a9;
    L_0x0097:
        r10 = O0000o00;	 Catch:{ Exception -> 0x013d, all -> 0x013b }
        r0 = 5;
        r10 = r10[r0];	 Catch:{ Exception -> 0x013d, all -> 0x013b }
        if (r1 == 0) goto L_0x00a8;
    L_0x009e:
        r1.close();	 Catch:{ IOException -> 0x00a2 }
        goto L_0x00a8;
    L_0x00a2:
        r0 = move-exception;
        r1 = com.umeng.socialize.utils.O0000o00.O0000OOo.O00000o0;
        com.umeng.socialize.utils.O0000O0o.O000000o(r1, r0);
    L_0x00a8:
        return r10;
    L_0x00a9:
        r9 = 89;
        if (r10 != r9) goto L_0x00c2;
    L_0x00ad:
        r9 = 166; // 0xa6 float:2.33E-43 double:8.2E-322;
        if (r0 != r9) goto L_0x00c2;
    L_0x00b1:
        r10 = O0000o00;	 Catch:{ Exception -> 0x013d, all -> 0x013b }
        r10 = r10[r7];	 Catch:{ Exception -> 0x013d, all -> 0x013b }
        if (r1 == 0) goto L_0x00c1;
    L_0x00b7:
        r1.close();	 Catch:{ IOException -> 0x00bb }
        goto L_0x00c1;
    L_0x00bb:
        r0 = move-exception;
        r1 = com.umeng.socialize.utils.O0000o00.O0000OOo.O00000o0;
        com.umeng.socialize.utils.O0000O0o.O000000o(r1, r0);
    L_0x00c1:
        return r10;
    L_0x00c2:
        if (r10 != r4) goto L_0x00fc;
    L_0x00c4:
        r4 = 49;
        if (r0 < r4) goto L_0x00fc;
    L_0x00c8:
        r4 = 54;
        if (r0 > r4) goto L_0x00fc;
    L_0x00cc:
        r0 = r0 + -48;
        if (r0 < r3) goto L_0x00ed;
    L_0x00d0:
        if (r0 <= r7) goto L_0x00d3;
    L_0x00d2:
        goto L_0x00ed;
    L_0x00d3:
        r10 = new int[r5];	 Catch:{ Exception -> 0x013d, all -> 0x013b }
        r10 = {7, 8, 9};	 Catch:{ Exception -> 0x013d, all -> 0x013b }
        r0 = r0 - r3;
        r0 = r0 % r5;
        r10 = r10[r0];	 Catch:{ Exception -> 0x013d, all -> 0x013b }
        r0 = O0000o00;	 Catch:{ Exception -> 0x013d, all -> 0x013b }
        r10 = r0[r10];	 Catch:{ Exception -> 0x013d, all -> 0x013b }
        if (r1 == 0) goto L_0x00ec;
    L_0x00e2:
        r1.close();	 Catch:{ IOException -> 0x00e6 }
        goto L_0x00ec;
    L_0x00e6:
        r0 = move-exception;
        r1 = com.umeng.socialize.utils.O0000o00.O0000OOo.O00000o0;
        com.umeng.socialize.utils.O0000O0o.O000000o(r1, r0);
    L_0x00ec:
        return r10;
    L_0x00ed:
        r10 = "";
        if (r1 == 0) goto L_0x00fb;
    L_0x00f1:
        r1.close();	 Catch:{ IOException -> 0x00f5 }
        goto L_0x00fb;
    L_0x00f5:
        r0 = move-exception;
        r1 = com.umeng.socialize.utils.O0000o00.O0000OOo.O00000o0;
        com.umeng.socialize.utils.O0000O0o.O000000o(r1, r0);
    L_0x00fb:
        return r10;
    L_0x00fc:
        r3 = 56;
        if (r10 != r3) goto L_0x0113;
    L_0x0100:
        if (r0 != r2) goto L_0x0113;
    L_0x0102:
        r10 = O0000o00;	 Catch:{ Exception -> 0x013d, all -> 0x013b }
        r10 = r10[r6];	 Catch:{ Exception -> 0x013d, all -> 0x013b }
        if (r1 == 0) goto L_0x0112;
    L_0x0108:
        r1.close();	 Catch:{ IOException -> 0x010c }
        goto L_0x0112;
    L_0x010c:
        r0 = move-exception;
        r1 = com.umeng.socialize.utils.O0000o00.O0000OOo.O00000o0;
        com.umeng.socialize.utils.O0000O0o.O000000o(r1, r0);
    L_0x0112:
        return r10;
    L_0x0113:
        if (r10 != r8) goto L_0x012c;
    L_0x0115:
        r10 = 87;
        if (r0 != r10) goto L_0x012c;
    L_0x0119:
        r10 = O0000o00;	 Catch:{ Exception -> 0x013d, all -> 0x013b }
        r0 = 11;
        r10 = r10[r0];	 Catch:{ Exception -> 0x013d, all -> 0x013b }
        if (r1 == 0) goto L_0x012b;
    L_0x0121:
        r1.close();	 Catch:{ IOException -> 0x0125 }
        goto L_0x012b;
    L_0x0125:
        r0 = move-exception;
        r1 = com.umeng.socialize.utils.O0000o00.O0000OOo.O00000o0;
        com.umeng.socialize.utils.O0000O0o.O000000o(r1, r0);
    L_0x012b:
        return r10;
    L_0x012c:
        r10 = "";
        if (r1 == 0) goto L_0x013a;
    L_0x0130:
        r1.close();	 Catch:{ IOException -> 0x0134 }
        goto L_0x013a;
    L_0x0134:
        r0 = move-exception;
        r1 = com.umeng.socialize.utils.O0000o00.O0000OOo.O00000o0;
        com.umeng.socialize.utils.O0000O0o.O000000o(r1, r0);
    L_0x013a:
        return r10;
    L_0x013b:
        r10 = move-exception;
        goto L_0x0158;
    L_0x013d:
        r10 = move-exception;
        r0 = r1;
        goto L_0x0144;
    L_0x0140:
        r10 = move-exception;
        r1 = r0;
        goto L_0x0158;
    L_0x0143:
        r10 = move-exception;
    L_0x0144:
        r1 = com.umeng.socialize.utils.O0000o00.O0000OOo.O0000Oo0;	 Catch:{ all -> 0x0140 }
        com.umeng.socialize.utils.O0000O0o.O000000o(r1, r10);	 Catch:{ all -> 0x0140 }
        r10 = "";
        if (r0 == 0) goto L_0x0157;
    L_0x014d:
        r0.close();	 Catch:{ IOException -> 0x0151 }
        goto L_0x0157;
    L_0x0151:
        r0 = move-exception;
        r1 = com.umeng.socialize.utils.O0000o00.O0000OOo.O00000o0;
        com.umeng.socialize.utils.O0000O0o.O000000o(r1, r0);
    L_0x0157:
        return r10;
    L_0x0158:
        if (r1 == 0) goto L_0x0164;
    L_0x015a:
        r1.close();	 Catch:{ IOException -> 0x015e }
        goto L_0x0164;
    L_0x015e:
        r0 = move-exception;
        r1 = com.umeng.socialize.utils.O0000o00.O0000OOo.O00000o0;
        com.umeng.socialize.utils.O0000O0o.O000000o(r1, r0);
    L_0x0164:
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bu.O000000o(byte[]):java.lang.String");
    }
}
