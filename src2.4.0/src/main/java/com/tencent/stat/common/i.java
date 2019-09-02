package com.tencent.stat.common;

class i extends h {
    private static final int[] c = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    private static final int[] d = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    private int e;
    private int f;
    private final int[] g;

    public i(int i, byte[] bArr) {
        this.a = bArr;
        this.g = (i & 8) == 0 ? c : d;
        this.e = 0;
        this.f = 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00de  */
    /* JADX WARNING: Missing block: B:20:0x0074, code skipped:
            r0 = r13;
     */
    public boolean a(byte[] r12, int r13, int r14, boolean r15) {
        /*
        r11 = this;
        r0 = r11.e;
        r1 = 0;
        r2 = 6;
        if (r0 != r2) goto L_0x0007;
    L_0x0006:
        return r1;
    L_0x0007:
        r14 = r14 + r13;
        r0 = r11.e;
        r3 = r11.f;
        r4 = r11.a;
        r5 = r11.g;
        r6 = r3;
        r3 = r1;
    L_0x0012:
        r7 = 4;
        if (r13 >= r14) goto L_0x00db;
    L_0x0015:
        if (r0 != 0) goto L_0x005c;
    L_0x0017:
        r8 = r13 + 4;
        if (r8 > r14) goto L_0x0058;
    L_0x001b:
        r6 = r12[r13];
        r6 = r6 & 255;
        r6 = r5[r6];
        r6 = r6 << 18;
        r9 = r13 + 1;
        r9 = r12[r9];
        r9 = r9 & 255;
        r9 = r5[r9];
        r9 = r9 << 12;
        r6 = r6 | r9;
        r9 = r13 + 2;
        r9 = r12[r9];
        r9 = r9 & 255;
        r9 = r5[r9];
        r9 = r9 << r2;
        r6 = r6 | r9;
        r9 = r13 + 3;
        r9 = r12[r9];
        r9 = r9 & 255;
        r9 = r5[r9];
        r6 = r6 | r9;
        if (r6 < 0) goto L_0x0058;
    L_0x0043:
        r13 = r3 + 2;
        r9 = (byte) r6;
        r4[r13] = r9;
        r13 = r3 + 1;
        r9 = r6 >> 8;
        r9 = (byte) r9;
        r4[r13] = r9;
        r13 = r6 >> 16;
        r13 = (byte) r13;
        r4[r3] = r13;
        r3 = r3 + 3;
        r13 = r8;
        goto L_0x0017;
    L_0x0058:
        if (r13 < r14) goto L_0x005c;
    L_0x005a:
        goto L_0x00db;
    L_0x005c:
        r8 = r13 + 1;
        r13 = r12[r13];
        r13 = r13 & 255;
        r13 = r5[r13];
        r9 = -2;
        r10 = -1;
        switch(r0) {
            case 0: goto L_0x00cd;
            case 1: goto L_0x00c2;
            case 2: goto L_0x00ae;
            case 3: goto L_0x007c;
            case 4: goto L_0x0070;
            case 5: goto L_0x006b;
            default: goto L_0x0069;
        };
    L_0x0069:
        goto L_0x00d8;
    L_0x006b:
        if (r13 == r10) goto L_0x00d8;
    L_0x006d:
        r11.e = r2;
        return r1;
    L_0x0070:
        if (r13 != r9) goto L_0x0077;
    L_0x0072:
        r13 = r0 + 1;
    L_0x0074:
        r0 = r13;
        goto L_0x00d8;
    L_0x0077:
        if (r13 == r10) goto L_0x00d8;
    L_0x0079:
        r11.e = r2;
        return r1;
    L_0x007c:
        if (r13 < 0) goto L_0x0097;
    L_0x007e:
        r0 = r6 << 6;
        r13 = r13 | r0;
        r0 = r3 + 2;
        r6 = (byte) r13;
        r4[r0] = r6;
        r0 = r3 + 1;
        r6 = r13 >> 8;
        r6 = (byte) r6;
        r4[r0] = r6;
        r0 = r13 >> 16;
        r0 = (byte) r0;
        r4[r3] = r0;
        r3 = r3 + 3;
        r6 = r13;
        r0 = r1;
        goto L_0x00d8;
    L_0x0097:
        if (r13 != r9) goto L_0x00a9;
    L_0x0099:
        r13 = r3 + 1;
        r0 = r6 >> 2;
        r0 = (byte) r0;
        r4[r13] = r0;
        r13 = r6 >> 10;
        r13 = (byte) r13;
        r4[r3] = r13;
        r3 = r3 + 2;
        r13 = 5;
        goto L_0x0074;
    L_0x00a9:
        if (r13 == r10) goto L_0x00d8;
    L_0x00ab:
        r11.e = r2;
        return r1;
    L_0x00ae:
        if (r13 < 0) goto L_0x00b1;
    L_0x00b0:
        goto L_0x00c4;
    L_0x00b1:
        if (r13 != r9) goto L_0x00bd;
    L_0x00b3:
        r13 = r3 + 1;
        r0 = r6 >> 4;
        r0 = (byte) r0;
        r4[r3] = r0;
        r3 = r13;
        r0 = r7;
        goto L_0x00d8;
    L_0x00bd:
        if (r13 == r10) goto L_0x00d8;
    L_0x00bf:
        r11.e = r2;
        return r1;
    L_0x00c2:
        if (r13 < 0) goto L_0x00c8;
    L_0x00c4:
        r6 = r6 << 6;
        r13 = r13 | r6;
        goto L_0x00cf;
    L_0x00c8:
        if (r13 == r10) goto L_0x00d8;
    L_0x00ca:
        r11.e = r2;
        return r1;
    L_0x00cd:
        if (r13 < 0) goto L_0x00d3;
    L_0x00cf:
        r0 = r0 + 1;
        r6 = r13;
        goto L_0x00d8;
    L_0x00d3:
        if (r13 == r10) goto L_0x00d8;
    L_0x00d5:
        r11.e = r2;
        return r1;
    L_0x00d8:
        r13 = r8;
        goto L_0x0012;
    L_0x00db:
        r12 = 1;
        if (r15 != 0) goto L_0x00e5;
    L_0x00de:
        r11.e = r0;
        r11.f = r6;
    L_0x00e2:
        r11.b = r3;
        return r12;
    L_0x00e5:
        switch(r0) {
            case 0: goto L_0x0107;
            case 1: goto L_0x0104;
            case 2: goto L_0x00fb;
            case 3: goto L_0x00ec;
            case 4: goto L_0x00e9;
            default: goto L_0x00e8;
        };
    L_0x00e8:
        goto L_0x0107;
    L_0x00e9:
        r11.e = r2;
        return r1;
    L_0x00ec:
        r13 = r3 + 1;
        r14 = r6 >> 10;
        r14 = (byte) r14;
        r4[r3] = r14;
        r3 = r13 + 1;
        r14 = r6 >> 2;
        r14 = (byte) r14;
        r4[r13] = r14;
        goto L_0x0107;
    L_0x00fb:
        r13 = r3 + 1;
        r14 = r6 >> 4;
        r14 = (byte) r14;
        r4[r3] = r14;
        r3 = r13;
        goto L_0x0107;
    L_0x0104:
        r11.e = r2;
        return r1;
    L_0x0107:
        r11.e = r0;
        goto L_0x00e2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.common.i.a(byte[], int, int, boolean):boolean");
    }
}
