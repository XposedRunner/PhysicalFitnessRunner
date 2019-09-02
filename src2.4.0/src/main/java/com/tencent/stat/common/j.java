package com.tencent.stat.common;

class j extends h {
    static final /* synthetic */ boolean g = true;
    private static final byte[] h = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 43, (byte) 47};
    private static final byte[] i = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 45, (byte) 95};
    int c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    private final byte[] j;
    private int k;
    private final byte[] l;

    static {
        Class cls = g.class;
    }

    public j(int i, byte[] bArr) {
        this.a = bArr;
        boolean z = true;
        this.d = (i & 1) == 0;
        this.e = (i & 2) == 0;
        if ((i & 4) == 0) {
            z = false;
        }
        this.f = z;
        this.l = (i & 8) == 0 ? h : i;
        this.j = new byte[2];
        this.c = 0;
        this.k = this.e ? 19 : -1;
    }

    /* JADX WARNING: Missing block: B:8:0x004a, code skipped:
            r0.c = 0;
     */
    /* JADX WARNING: Missing block: B:9:0x004d, code skipped:
            r7 = r20;
            r2 = -1;
     */
    /* JADX WARNING: Missing block: B:11:0x0056, code skipped:
            if (r2 == -1) goto L_0x008e;
     */
    /* JADX WARNING: Missing block: B:12:0x0058, code skipped:
            r4[0] = r3[(r2 >> 18) & 63];
            r4[1] = r3[(r2 >> 12) & 63];
            r4[2] = r3[(r2 >> 6) & 63];
            r4[3] = r3[r2 & 63];
            r5 = r5 - 1;
     */
    /* JADX WARNING: Missing block: B:13:0x0079, code skipped:
            if (r5 != 0) goto L_0x008b;
     */
    /* JADX WARNING: Missing block: B:15:0x007d, code skipped:
            if (r0.f == false) goto L_0x0083;
     */
    /* JADX WARNING: Missing block: B:16:0x007f, code skipped:
            r2 = 5;
            r4[4] = (byte) 13;
     */
    /* JADX WARNING: Missing block: B:17:0x0083, code skipped:
            r2 = 4;
     */
    /* JADX WARNING: Missing block: B:18:0x0084, code skipped:
            r5 = r2 + 1;
            r4[r2] = (byte) 10;
            r2 = 19;
     */
    /* JADX WARNING: Missing block: B:19:0x008b, code skipped:
            r2 = r5;
            r5 = 4;
     */
    /* JADX WARNING: Missing block: B:20:0x008e, code skipped:
            r2 = r5;
            r5 = 0;
     */
    /* JADX WARNING: Missing block: B:21:0x0090, code skipped:
            r8 = r7 + 3;
     */
    /* JADX WARNING: Missing block: B:22:0x0092, code skipped:
            if (r8 > r6) goto L_0x00e9;
     */
    /* JADX WARNING: Missing block: B:23:0x0094, code skipped:
            r7 = (r19[r7 + 2] & 255) | (((r19[r7] & 255) << 16) | ((r19[r7 + 1] & 255) << 8));
            r4[r5] = r3[(r7 >> 18) & 63];
            r4[r5 + 1] = r3[(r7 >> 12) & 63];
            r4[r5 + 2] = r3[(r7 >> 6) & 63];
            r4[r5 + 3] = r3[r7 & 63];
            r5 = r5 + 4;
            r2 = r2 - 1;
     */
    /* JADX WARNING: Missing block: B:24:0x00d2, code skipped:
            if (r2 != 0) goto L_0x00e6;
     */
    /* JADX WARNING: Missing block: B:26:0x00d6, code skipped:
            if (r0.f == false) goto L_0x00dd;
     */
    /* JADX WARNING: Missing block: B:27:0x00d8, code skipped:
            r2 = r5 + 1;
            r4[r5] = (byte) 13;
     */
    /* JADX WARNING: Missing block: B:28:0x00dd, code skipped:
            r2 = r5;
     */
    /* JADX WARNING: Missing block: B:29:0x00de, code skipped:
            r5 = r2 + 1;
            r4[r2] = (byte) 10;
            r7 = r8;
            r2 = 19;
     */
    /* JADX WARNING: Missing block: B:30:0x00e6, code skipped:
            r7 = r8;
     */
    /* JADX WARNING: Missing block: B:32:0x00e9, code skipped:
            if (r22 == false) goto L_0x01e7;
     */
    /* JADX WARNING: Missing block: B:34:0x00f1, code skipped:
            if ((r7 - r0.c) != (r6 - 1)) goto L_0x013e;
     */
    /* JADX WARNING: Missing block: B:36:0x00f5, code skipped:
            if (r0.c <= 0) goto L_0x00fd;
     */
    /* JADX WARNING: Missing block: B:37:0x00f7, code skipped:
            r1 = r0.j[0];
            r9 = 1;
     */
    /* JADX WARNING: Missing block: B:38:0x00fd, code skipped:
            r8 = r7 + 1;
            r1 = r19[r7];
            r7 = r8;
     */
    /* JADX WARNING: Missing block: B:39:0x0102, code skipped:
            r1 = (r1 & 255) << 4;
            r0.c -= r9;
            r8 = r5 + 1;
            r4[r5] = r3[(r1 >> 6) & 63];
            r5 = r8 + 1;
            r4[r8] = r3[r1 & 63];
     */
    /* JADX WARNING: Missing block: B:40:0x011e, code skipped:
            if (r0.d == false) goto L_0x012a;
     */
    /* JADX WARNING: Missing block: B:41:0x0120, code skipped:
            r1 = r5 + 1;
            r4[r5] = (byte) 61;
            r5 = r1 + 1;
            r4[r1] = (byte) 61;
     */
    /* JADX WARNING: Missing block: B:43:0x012c, code skipped:
            if (r0.e == false) goto L_0x01cd;
     */
    /* JADX WARNING: Missing block: B:45:0x0130, code skipped:
            if (r0.f == false) goto L_0x0137;
     */
    /* JADX WARNING: Missing block: B:46:0x0132, code skipped:
            r1 = r5 + 1;
            r4[r5] = (byte) 13;
     */
    /* JADX WARNING: Missing block: B:47:0x0137, code skipped:
            r1 = r5;
     */
    /* JADX WARNING: Missing block: B:48:0x0138, code skipped:
            r5 = r1 + 1;
            r4[r1] = (byte) 10;
     */
    /* JADX WARNING: Missing block: B:50:0x0144, code skipped:
            if ((r7 - r0.c) != (r6 - 2)) goto L_0x01b4;
     */
    /* JADX WARNING: Missing block: B:52:0x0148, code skipped:
            if (r0.c <= 1) goto L_0x0155;
     */
    /* JADX WARNING: Missing block: B:53:0x014a, code skipped:
            r9 = 1;
            r8 = r7;
            r7 = r0.j[0];
     */
    /* JADX WARNING: Missing block: B:54:0x0155, code skipped:
            r8 = r7 + 1;
            r7 = r19[r7];
     */
    /* JADX WARNING: Missing block: B:55:0x0159, code skipped:
            r7 = (r7 & 255) << 10;
     */
    /* JADX WARNING: Missing block: B:56:0x015e, code skipped:
            if (r0.c <= 0) goto L_0x0169;
     */
    /* JADX WARNING: Missing block: B:57:0x0160, code skipped:
            r11 = r9 + 1;
            r1 = r0.j[r9];
            r9 = r11;
            r11 = r8;
     */
    /* JADX WARNING: Missing block: B:58:0x0169, code skipped:
            r11 = r8 + 1;
            r1 = r19[r8];
     */
    /* JADX WARNING: Missing block: B:59:0x016d, code skipped:
            r1 = ((r1 & 255) << 2) | r7;
            r0.c -= r9;
            r7 = r5 + 1;
            r4[r5] = r3[(r1 >> 12) & 63];
            r5 = r7 + 1;
            r4[r7] = r3[(r1 >> 6) & 63];
            r7 = r5 + 1;
            r4[r5] = r3[r1 & 63];
     */
    /* JADX WARNING: Missing block: B:60:0x0195, code skipped:
            if (r0.d == false) goto L_0x019e;
     */
    /* JADX WARNING: Missing block: B:61:0x0197, code skipped:
            r1 = r7 + 1;
            r4[r7] = (byte) 61;
     */
    /* JADX WARNING: Missing block: B:62:0x019e, code skipped:
            r1 = r7;
     */
    /* JADX WARNING: Missing block: B:64:0x01a1, code skipped:
            if (r0.e == false) goto L_0x01b1;
     */
    /* JADX WARNING: Missing block: B:66:0x01a5, code skipped:
            if (r0.f == false) goto L_0x01ac;
     */
    /* JADX WARNING: Missing block: B:67:0x01a7, code skipped:
            r3 = r1 + 1;
            r4[r1] = (byte) 13;
            r1 = r3;
     */
    /* JADX WARNING: Missing block: B:68:0x01ac, code skipped:
            r3 = r1 + 1;
            r4[r1] = (byte) 10;
            r1 = r3;
     */
    /* JADX WARNING: Missing block: B:69:0x01b1, code skipped:
            r5 = r1;
            r7 = r11;
     */
    /* JADX WARNING: Missing block: B:71:0x01b6, code skipped:
            if (r0.e == false) goto L_0x01cd;
     */
    /* JADX WARNING: Missing block: B:72:0x01b8, code skipped:
            if (r5 <= 0) goto L_0x01cd;
     */
    /* JADX WARNING: Missing block: B:74:0x01bc, code skipped:
            if (r2 == 19) goto L_0x01cd;
     */
    /* JADX WARNING: Missing block: B:76:0x01c0, code skipped:
            if (r0.f == false) goto L_0x01c7;
     */
    /* JADX WARNING: Missing block: B:77:0x01c2, code skipped:
            r1 = r5 + 1;
            r4[r5] = (byte) 13;
     */
    /* JADX WARNING: Missing block: B:78:0x01c7, code skipped:
            r1 = r5;
     */
    /* JADX WARNING: Missing block: B:79:0x01c8, code skipped:
            r3 = r1 + 1;
            r4[r1] = (byte) 10;
            r5 = r3;
     */
    /* JADX WARNING: Missing block: B:81:0x01cf, code skipped:
            if (g != false) goto L_0x01db;
     */
    /* JADX WARNING: Missing block: B:83:0x01d3, code skipped:
            if (r0.c == 0) goto L_0x01db;
     */
    /* JADX WARNING: Missing block: B:85:0x01da, code skipped:
            throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Missing block: B:87:0x01dd, code skipped:
            if (g != false) goto L_0x0215;
     */
    /* JADX WARNING: Missing block: B:88:0x01df, code skipped:
            if (r7 == r6) goto L_0x0215;
     */
    /* JADX WARNING: Missing block: B:90:0x01e6, code skipped:
            throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Missing block: B:92:0x01e9, code skipped:
            if (r7 != (r6 - 1)) goto L_0x01f8;
     */
    /* JADX WARNING: Missing block: B:93:0x01eb, code skipped:
            r3 = r0.j;
            r4 = r0.c;
            r0.c = r4 + 1;
            r3[r4] = r19[r7];
     */
    /* JADX WARNING: Missing block: B:95:0x01fa, code skipped:
            if (r7 != (r6 - 2)) goto L_0x0215;
     */
    /* JADX WARNING: Missing block: B:96:0x01fc, code skipped:
            r3 = r0.j;
            r4 = r0.c;
            r0.c = r4 + 1;
            r3[r4] = r19[r7];
            r3 = r0.j;
            r4 = r0.c;
            r0.c = r4 + 1;
            r3[r4] = r19[r7 + 1];
     */
    /* JADX WARNING: Missing block: B:97:0x0215, code skipped:
            r0.b = r5;
            r0.k = r2;
     */
    /* JADX WARNING: Missing block: B:98:0x0219, code skipped:
            return true;
     */
    public boolean a(byte[] r19, int r20, int r21, boolean r22) {
        /*
        r18 = this;
        r0 = r18;
        r3 = r0.l;
        r4 = r0.a;
        r5 = r0.k;
        r6 = r21 + r20;
        r7 = r0.c;
        r8 = -1;
        r9 = 0;
        r10 = 1;
        switch(r7) {
            case 0: goto L_0x004d;
            case 1: goto L_0x002e;
            case 2: goto L_0x0013;
            default: goto L_0x0012;
        };
    L_0x0012:
        goto L_0x004d;
    L_0x0013:
        r7 = r20 + 1;
        if (r7 > r6) goto L_0x004d;
    L_0x0017:
        r11 = r0.j;
        r11 = r11[r9];
        r11 = r11 & 255;
        r11 = r11 << 16;
        r12 = r0.j;
        r12 = r12[r10];
        r12 = r12 & 255;
        r12 = r12 << 8;
        r11 = r11 | r12;
        r2 = r19[r20];
        r2 = r2 & 255;
        r2 = r2 | r11;
        goto L_0x004a;
    L_0x002e:
        r7 = r20 + 2;
        if (r7 > r6) goto L_0x004d;
    L_0x0032:
        r7 = r0.j;
        r7 = r7[r9];
        r7 = r7 & 255;
        r7 = r7 << 16;
        r11 = r20 + 1;
        r2 = r19[r20];
        r2 = r2 & 255;
        r2 = r2 << 8;
        r2 = r2 | r7;
        r7 = r11 + 1;
        r11 = r19[r11];
        r11 = r11 & 255;
        r2 = r2 | r11;
    L_0x004a:
        r0.c = r9;
        goto L_0x0050;
    L_0x004d:
        r7 = r20;
        r2 = r8;
    L_0x0050:
        r12 = 4;
        r13 = 13;
        r14 = 10;
        r15 = 2;
        if (r2 == r8) goto L_0x008e;
    L_0x0058:
        r8 = r2 >> 18;
        r8 = r8 & 63;
        r8 = r3[r8];
        r4[r9] = r8;
        r8 = r2 >> 12;
        r8 = r8 & 63;
        r8 = r3[r8];
        r4[r10] = r8;
        r8 = r2 >> 6;
        r8 = r8 & 63;
        r8 = r3[r8];
        r4[r15] = r8;
        r2 = r2 & 63;
        r2 = r3[r2];
        r8 = 3;
        r4[r8] = r2;
        r5 = r5 + -1;
        if (r5 != 0) goto L_0x008b;
    L_0x007b:
        r2 = r0.f;
        if (r2 == 0) goto L_0x0083;
    L_0x007f:
        r2 = 5;
        r4[r12] = r13;
        goto L_0x0084;
    L_0x0083:
        r2 = r12;
    L_0x0084:
        r5 = r2 + 1;
        r4[r2] = r14;
        r2 = 19;
        goto L_0x0090;
    L_0x008b:
        r2 = r5;
        r5 = r12;
        goto L_0x0090;
    L_0x008e:
        r2 = r5;
        r5 = r9;
    L_0x0090:
        r8 = r7 + 3;
        if (r8 > r6) goto L_0x00e9;
    L_0x0094:
        r11 = r19[r7];
        r11 = r11 & 255;
        r11 = r11 << 16;
        r16 = r7 + 1;
        r15 = r19[r16];
        r15 = r15 & 255;
        r15 = r15 << 8;
        r11 = r11 | r15;
        r7 = r7 + 2;
        r7 = r19[r7];
        r7 = r7 & 255;
        r7 = r7 | r11;
        r11 = r7 >> 18;
        r11 = r11 & 63;
        r11 = r3[r11];
        r4[r5] = r11;
        r11 = r5 + 1;
        r15 = r7 >> 12;
        r15 = r15 & 63;
        r15 = r3[r15];
        r4[r11] = r15;
        r11 = r5 + 2;
        r15 = r7 >> 6;
        r15 = r15 & 63;
        r15 = r3[r15];
        r4[r11] = r15;
        r11 = r5 + 3;
        r7 = r7 & 63;
        r7 = r3[r7];
        r4[r11] = r7;
        r5 = r5 + 4;
        r2 = r2 + -1;
        if (r2 != 0) goto L_0x00e6;
    L_0x00d4:
        r2 = r0.f;
        if (r2 == 0) goto L_0x00dd;
    L_0x00d8:
        r2 = r5 + 1;
        r4[r5] = r13;
        goto L_0x00de;
    L_0x00dd:
        r2 = r5;
    L_0x00de:
        r5 = r2 + 1;
        r4[r2] = r14;
        r7 = r8;
        r2 = 19;
        goto L_0x00e7;
    L_0x00e6:
        r7 = r8;
    L_0x00e7:
        r15 = 2;
        goto L_0x0090;
    L_0x00e9:
        if (r22 == 0) goto L_0x01e7;
    L_0x00eb:
        r8 = r0.c;
        r8 = r7 - r8;
        r11 = r6 + -1;
        if (r8 != r11) goto L_0x013e;
    L_0x00f3:
        r8 = r0.c;
        if (r8 <= 0) goto L_0x00fd;
    L_0x00f7:
        r1 = r0.j;
        r1 = r1[r9];
        r9 = r10;
        goto L_0x0102;
    L_0x00fd:
        r8 = r7 + 1;
        r1 = r19[r7];
        r7 = r8;
    L_0x0102:
        r1 = r1 & 255;
        r1 = r1 << r12;
        r8 = r0.c;
        r8 = r8 - r9;
        r0.c = r8;
        r8 = r5 + 1;
        r9 = r1 >> 6;
        r9 = r9 & 63;
        r9 = r3[r9];
        r4[r5] = r9;
        r5 = r8 + 1;
        r1 = r1 & 63;
        r1 = r3[r1];
        r4[r8] = r1;
        r1 = r0.d;
        if (r1 == 0) goto L_0x012a;
    L_0x0120:
        r1 = r5 + 1;
        r3 = 61;
        r4[r5] = r3;
        r5 = r1 + 1;
        r4[r1] = r3;
    L_0x012a:
        r1 = r0.e;
        if (r1 == 0) goto L_0x01cd;
    L_0x012e:
        r1 = r0.f;
        if (r1 == 0) goto L_0x0137;
    L_0x0132:
        r1 = r5 + 1;
        r4[r5] = r13;
        goto L_0x0138;
    L_0x0137:
        r1 = r5;
    L_0x0138:
        r5 = r1 + 1;
        r4[r1] = r14;
        goto L_0x01cd;
    L_0x013e:
        r8 = r0.c;
        r8 = r7 - r8;
        r11 = r6 + -2;
        if (r8 != r11) goto L_0x01b4;
    L_0x0146:
        r8 = r0.c;
        if (r8 <= r10) goto L_0x0155;
    L_0x014a:
        r8 = r0.j;
        r8 = r8[r9];
        r9 = r10;
        r17 = r8;
        r8 = r7;
        r7 = r17;
        goto L_0x0159;
    L_0x0155:
        r8 = r7 + 1;
        r7 = r19[r7];
    L_0x0159:
        r7 = r7 & 255;
        r7 = r7 << r14;
        r11 = r0.c;
        if (r11 <= 0) goto L_0x0169;
    L_0x0160:
        r1 = r0.j;
        r11 = r9 + 1;
        r1 = r1[r9];
        r9 = r11;
        r11 = r8;
        goto L_0x016d;
    L_0x0169:
        r11 = r8 + 1;
        r1 = r19[r8];
    L_0x016d:
        r1 = r1 & 255;
        r8 = 2;
        r1 = r1 << r8;
        r1 = r1 | r7;
        r7 = r0.c;
        r7 = r7 - r9;
        r0.c = r7;
        r7 = r5 + 1;
        r8 = r1 >> 12;
        r8 = r8 & 63;
        r8 = r3[r8];
        r4[r5] = r8;
        r5 = r7 + 1;
        r8 = r1 >> 6;
        r8 = r8 & 63;
        r8 = r3[r8];
        r4[r7] = r8;
        r7 = r5 + 1;
        r1 = r1 & 63;
        r1 = r3[r1];
        r4[r5] = r1;
        r1 = r0.d;
        if (r1 == 0) goto L_0x019e;
    L_0x0197:
        r1 = r7 + 1;
        r3 = 61;
        r4[r7] = r3;
        goto L_0x019f;
    L_0x019e:
        r1 = r7;
    L_0x019f:
        r3 = r0.e;
        if (r3 == 0) goto L_0x01b1;
    L_0x01a3:
        r3 = r0.f;
        if (r3 == 0) goto L_0x01ac;
    L_0x01a7:
        r3 = r1 + 1;
        r4[r1] = r13;
        r1 = r3;
    L_0x01ac:
        r3 = r1 + 1;
        r4[r1] = r14;
        r1 = r3;
    L_0x01b1:
        r5 = r1;
        r7 = r11;
        goto L_0x01cd;
    L_0x01b4:
        r1 = r0.e;
        if (r1 == 0) goto L_0x01cd;
    L_0x01b8:
        if (r5 <= 0) goto L_0x01cd;
    L_0x01ba:
        r1 = 19;
        if (r2 == r1) goto L_0x01cd;
    L_0x01be:
        r1 = r0.f;
        if (r1 == 0) goto L_0x01c7;
    L_0x01c2:
        r1 = r5 + 1;
        r4[r5] = r13;
        goto L_0x01c8;
    L_0x01c7:
        r1 = r5;
    L_0x01c8:
        r3 = r1 + 1;
        r4[r1] = r14;
        r5 = r3;
    L_0x01cd:
        r1 = g;
        if (r1 != 0) goto L_0x01db;
    L_0x01d1:
        r1 = r0.c;
        if (r1 == 0) goto L_0x01db;
    L_0x01d5:
        r1 = new java.lang.AssertionError;
        r1.<init>();
        throw r1;
    L_0x01db:
        r1 = g;
        if (r1 != 0) goto L_0x0215;
    L_0x01df:
        if (r7 == r6) goto L_0x0215;
    L_0x01e1:
        r1 = new java.lang.AssertionError;
        r1.<init>();
        throw r1;
    L_0x01e7:
        r3 = r6 + -1;
        if (r7 != r3) goto L_0x01f8;
    L_0x01eb:
        r3 = r0.j;
        r4 = r0.c;
        r6 = r4 + 1;
        r0.c = r6;
        r1 = r19[r7];
        r3[r4] = r1;
        goto L_0x0215;
    L_0x01f8:
        r3 = 2;
        r6 = r6 - r3;
        if (r7 != r6) goto L_0x0215;
    L_0x01fc:
        r3 = r0.j;
        r4 = r0.c;
        r6 = r4 + 1;
        r0.c = r6;
        r6 = r19[r7];
        r3[r4] = r6;
        r3 = r0.j;
        r4 = r0.c;
        r6 = r4 + 1;
        r0.c = r6;
        r7 = r7 + r10;
        r1 = r19[r7];
        r3[r4] = r1;
    L_0x0215:
        r0.b = r5;
        r0.k = r2;
        return r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.common.j.a(byte[], int, int, boolean):boolean");
    }
}
