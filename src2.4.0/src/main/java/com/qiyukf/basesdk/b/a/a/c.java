package com.qiyukf.basesdk.b.a.a;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.Date;

public final class c {
    private boolean a;

    public static class a {
        private String a;
        private String b;
        private a c;
        private long d;
        private int e;

        public static class a {
            private String a;
            private String b;
            private a c = null;
            private long d = -1;
            private int e = b.a;

            public a(String str, String str2) {
                this.a = str;
                this.b = str2;
            }

            public final a a(long j) {
                this.d = j;
                return this;
            }

            public final a a(a aVar) {
                this.c = aVar;
                return this;
            }

            public final a a() {
                return new a(this.a, this.b, this.c, this.d, this.e, (byte) 0);
            }
        }

        public enum b {
            ;
            
            public static final int a = 1;
            public static final int b = 2;
            public static final int c = 3;
            public static final int d = 4;

            static {
                e = new int[]{a, b, c, d};
            }
        }

        private a(String str, String str2, a aVar, long j, int i) {
            this.c = null;
            this.d = -1;
            this.e = b.a;
            this.a = str;
            this.b = str2;
            this.c = aVar;
            this.d = j;
            this.e = i;
        }

        /* synthetic */ a(String str, String str2, a aVar, long j, int i, byte b) {
            this(str, str2, aVar, j, i);
        }
    }

    private c() {
    }

    public static final c a() {
        return new c();
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0063 A:{Catch:{ Exception -> 0x0381, all -> 0x038b }} */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0061 A:{Catch:{ Exception -> 0x0381, all -> 0x038b }} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x010a A:{Catch:{ Exception -> 0x0105, all -> 0x038b }} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x025a  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x025d A:{SYNTHETIC, Splitter:B:70:0x025d} */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x026f A:{SYNTHETIC, Splitter:B:78:0x026f} */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0301 A:{SYNTHETIC, EDGE_INSN: B:177:0x0301->B:120:0x0301 ?: BREAK  , EDGE_INSN: B:177:0x0301->B:120:0x0301 ?: BREAK  , EDGE_INSN: B:177:0x0301->B:120:0x0301 ?: BREAK  , EDGE_INSN: B:177:0x0301->B:120:0x0301 ?: BREAK  , EDGE_INSN: B:177:0x0301->B:120:0x0301 ?: BREAK  , EDGE_INSN: B:177:0x0301->B:120:0x0301 ?: BREAK  , EDGE_INSN: B:177:0x0301->B:120:0x0301 ?: BREAK  , EDGE_INSN: B:177:0x0301->B:120:0x0301 ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0284 A:{SYNTHETIC, Splitter:B:87:0x0284} */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x03ea A:{SYNTHETIC, Splitter:B:162:0x03ea} */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x038b A:{Splitter:B:12:0x005b, ExcHandler: all (r0_28 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x043e A:{SYNTHETIC, Splitter:B:172:0x043e} */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x043e A:{SYNTHETIC, Splitter:B:172:0x043e} */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x03ea A:{SYNTHETIC, Splitter:B:162:0x03ea} */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x043e A:{SYNTHETIC, Splitter:B:172:0x043e} */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x03ea A:{SYNTHETIC, Splitter:B:162:0x03ea} */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x038b A:{Splitter:B:12:0x005b, ExcHandler: all (r0_28 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x03ea A:{SYNTHETIC, Splitter:B:162:0x03ea} */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x01fa A:{Splitter:B:47:0x016d, ExcHandler: all (r0_1 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x03ea A:{SYNTHETIC, Splitter:B:162:0x03ea} */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x043e A:{SYNTHETIC, Splitter:B:172:0x043e} */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x03ea A:{SYNTHETIC, Splitter:B:162:0x03ea} */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x043e A:{SYNTHETIC, Splitter:B:172:0x043e} */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x03ea A:{SYNTHETIC, Splitter:B:162:0x03ea} */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x043e A:{SYNTHETIC, Splitter:B:172:0x043e} */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x03ea A:{SYNTHETIC, Splitter:B:162:0x03ea} */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x043e A:{SYNTHETIC, Splitter:B:172:0x043e} */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x03ea A:{SYNTHETIC, Splitter:B:162:0x03ea} */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x043e A:{SYNTHETIC, Splitter:B:172:0x043e} */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x03ea A:{SYNTHETIC, Splitter:B:162:0x03ea} */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x043e A:{SYNTHETIC, Splitter:B:172:0x043e} */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x043e A:{SYNTHETIC, Splitter:B:172:0x043e} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:47:0x016d, B:72:0x0260] */
    /* JADX WARNING: Missing block: B:31:0x0105, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:32:0x0106, code skipped:
            r13 = r21;
     */
    /* JADX WARNING: Missing block: B:58:0x01fa, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:59:0x01fb, code skipped:
            r13 = r21;
            r1 = r0;
            r12 = null;
     */
    /* JADX WARNING: Missing block: B:120:0x0301, code skipped:
            r13 = r21;
            r19 = r6;
     */
    /* JADX WARNING: Missing block: B:122:?, code skipped:
            r12.close();
     */
    /* JADX WARNING: Missing block: B:123:0x0308, code skipped:
            if (r4 == null) goto L_0x0327;
     */
    /* JADX WARNING: Missing block: B:126:0x0313, code skipped:
            if (new java.io.File(r3).exists() == false) goto L_0x0319;
     */
    /* JADX WARNING: Missing block: B:127:0x0315, code skipped:
            r4.b(r1);
     */
    /* JADX WARNING: Missing block: B:128:0x0319, code skipped:
            r4.a(r1, "file not exist");
     */
    /* JADX WARNING: Missing block: B:129:0x031f, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:130:0x0320, code skipped:
            r1 = r0;
            r12 = null;
     */
    /* JADX WARNING: Missing block: B:131:0x0323, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:132:0x0324, code skipped:
            r1 = r0;
            r12 = null;
     */
    /* JADX WARNING: Missing block: B:133:0x0327, code skipped:
            r1 = c();
            r3 = new java.lang.StringBuilder("HTTPDownload STAT END ");
            r3.append(r1);
            com.qiyukf.basesdk.a.a.d("RES", r3.toString());
            r3 = r1 - r7;
            r1 = new java.lang.StringBuilder("HTTPDownload STAT COST ");
            r1.append(r3);
            com.qiyukf.basesdk.a.a.d("RES", r1.toString());
            com.qiyukf.basesdk.b.a.c.b.a(r19);
     */
    /* JADX WARNING: Missing block: B:134:0x0359, code skipped:
            return true;
     */
    /* JADX WARNING: Missing block: B:135:0x035a, code skipped:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:136:0x035b, code skipped:
            r1 = r19;
     */
    /* JADX WARNING: Missing block: B:137:0x035e, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:138:0x035f, code skipped:
            r1 = r19;
     */
    /* JADX WARNING: Missing block: B:154:0x038b, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:155:0x038c, code skipped:
            r13 = r21;
            r1 = r0;
            r12 = null;
     */
    /* JADX WARNING: Missing block: B:163:?, code skipped:
            r12.close();
     */
    /* JADX WARNING: Missing block: B:164:0x03ee, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:165:0x03ef, code skipped:
            r0.printStackTrace();
            r1 = new java.lang.StringBuilder("HTTPDownload FAILED CLOSE EX ");
            r1.append(r0.toString());
            com.qiyukf.basesdk.a.a.a("RES", r1.toString());
     */
    /* JADX WARNING: Missing block: B:173:?, code skipped:
            r12.close();
     */
    /* JADX WARNING: Missing block: B:174:0x0442, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:175:0x0443, code skipped:
            r0.printStackTrace();
            r2 = new java.lang.StringBuilder("HTTPDownload FAILED CLOSE EX ");
            r2.append(r0.toString());
            com.qiyukf.basesdk.a.a.a("RES", r2.toString());
     */
    private boolean a(java.lang.String r22, java.lang.String r23, java.lang.String r24, com.qiyukf.basesdk.b.a.a.a r25, long r26) {
        /*
        r21 = this;
        r1 = r22;
        r2 = r23;
        r3 = r24;
        r4 = r25;
        r5 = r26;
        r7 = new java.lang.StringBuilder;
        r8 = "HTTPDownload GET URL ";
        r7.<init>(r8);
        r7.append(r2);
        r7 = r7.toString();
        r8 = "RES";
        com.qiyukf.basesdk.a.a.d(r8, r7);
        r7 = c();
        r9 = new java.lang.StringBuilder;
        r10 = "HTTPDownload STAT START ";
        r9.<init>(r10);
        r9.append(r7);
        r9 = r9.toString();
        r10 = "RES";
        com.qiyukf.basesdk.a.a.d(r10, r9);
        if (r4 == 0) goto L_0x0039;
    L_0x0036:
        r4.a(r1);
    L_0x0039:
        r9 = 0;
        r11 = "http://";
        r11 = r2.startsWith(r11);	 Catch:{ Exception -> 0x0392, all -> 0x038b }
        if (r11 != 0) goto L_0x005a;
    L_0x0042:
        r11 = "https://";
        r11 = r2.startsWith(r11);	 Catch:{ Exception -> 0x0392, all -> 0x038b }
        if (r11 == 0) goto L_0x004b;
    L_0x004a:
        goto L_0x005a;
    L_0x004b:
        r11 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0392, all -> 0x038b }
        r12 = "http://";
        r11.<init>(r12);	 Catch:{ Exception -> 0x0392, all -> 0x038b }
        r11.append(r2);	 Catch:{ Exception -> 0x0392, all -> 0x038b }
        r11 = r11.toString();	 Catch:{ Exception -> 0x0392, all -> 0x038b }
        goto L_0x005b;
    L_0x005a:
        r11 = r2;
    L_0x005b:
        r2 = android.text.TextUtils.isEmpty(r11);	 Catch:{ Exception -> 0x0381, all -> 0x038b }
        if (r2 == 0) goto L_0x0063;
    L_0x0061:
        r2 = r11;
        goto L_0x006b;
    L_0x0063:
        r2 = "(http://|https://)nos.netease.com/nim/";
        r12 = "https://nim.nosdn.127.net/";
        r2 = r11.replaceAll(r2, r12);	 Catch:{ Exception -> 0x0381, all -> 0x038b }
    L_0x006b:
        r12 = "RES-DOWN";
        r2 = com.qiyukf.basesdk.b.a.c.b.c(r2, r12);	 Catch:{ Exception -> 0x0381, all -> 0x038b }
        r12 = new java.io.File;	 Catch:{ Exception -> 0x0381, all -> 0x038b }
        r12.<init>(r3);	 Catch:{ Exception -> 0x0381, all -> 0x038b }
        r13 = r12.exists();	 Catch:{ Exception -> 0x0381, all -> 0x038b }
        r14 = 1;
        r15 = 0;
        if (r13 == 0) goto L_0x010a;
    L_0x007f:
        r18 = r11;
        r10 = r12.length();	 Catch:{ Exception -> 0x0105, all -> 0x038b }
        r13 = (r5 > r15 ? 1 : (r5 == r15 ? 0 : -1));
        if (r13 <= 0) goto L_0x00dc;
    L_0x0089:
        r13 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1));
        if (r13 < 0) goto L_0x00dc;
    L_0x008d:
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0105, all -> 0x038b }
        r2 = "HTTPDownload FAILED MISMATCH OFFSET ";
        r1.<init>(r2);	 Catch:{ Exception -> 0x0105, all -> 0x038b }
        r1.append(r10);	 Catch:{ Exception -> 0x0105, all -> 0x038b }
        r2 = " SIZE ";
        r1.append(r2);	 Catch:{ Exception -> 0x0105, all -> 0x038b }
        r1.append(r5);	 Catch:{ Exception -> 0x0105, all -> 0x038b }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0105, all -> 0x038b }
        r2 = "RES";
        com.qiyukf.basesdk.a.a.a(r2, r1);	 Catch:{ Exception -> 0x0105, all -> 0x038b }
        r12.delete();	 Catch:{ Exception -> 0x0105, all -> 0x038b }
        r1 = c();
        r3 = new java.lang.StringBuilder;
        r4 = "HTTPDownload STAT END ";
        r3.<init>(r4);
        r3.append(r1);
        r3 = r3.toString();
        r4 = "RES";
        com.qiyukf.basesdk.a.a.d(r4, r3);
        r3 = r1 - r7;
        r1 = new java.lang.StringBuilder;
        r2 = "HTTPDownload STAT COST ";
        r1.<init>(r2);
        r1.append(r3);
        r1 = r1.toString();
        r2 = "RES";
        com.qiyukf.basesdk.a.a.d(r2, r1);
        com.qiyukf.basesdk.b.a.c.b.a(r9);
        r1 = 0;
        return r1;
    L_0x00dc:
        r5 = "Range";
        r6 = "bytes=%d-";
        r12 = new java.lang.Object[r14];	 Catch:{ Exception -> 0x0105, all -> 0x038b }
        r13 = java.lang.Long.valueOf(r10);	 Catch:{ Exception -> 0x0105, all -> 0x038b }
        r17 = 0;
        r12[r17] = r13;	 Catch:{ Exception -> 0x0105, all -> 0x038b }
        r6 = java.lang.String.format(r6, r12);	 Catch:{ Exception -> 0x0105, all -> 0x038b }
        r2.setRequestProperty(r5, r6);	 Catch:{ Exception -> 0x0105, all -> 0x038b }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0105, all -> 0x038b }
        r6 = "HTTPDownload RANGE OFFSET ";
        r5.<init>(r6);	 Catch:{ Exception -> 0x0105, all -> 0x038b }
        r5.append(r10);	 Catch:{ Exception -> 0x0105, all -> 0x038b }
        r5 = r5.toString();	 Catch:{ Exception -> 0x0105, all -> 0x038b }
        r6 = "RES";
        com.qiyukf.basesdk.a.a.a(r6, r5);	 Catch:{ Exception -> 0x0105, all -> 0x038b }
        goto L_0x0157;
    L_0x0105:
        r0 = move-exception;
        r13 = r21;
        goto L_0x0386;
    L_0x010a:
        r18 = r11;
        r5 = com.qiyukf.basesdk.b.a.c.a.a(r24);	 Catch:{ Exception -> 0x0105, all -> 0x038b }
        if (r5 != 0) goto L_0x0156;
    L_0x0112:
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0105, all -> 0x038b }
        r2 = "HTTPDownload FAILED CREATE PATH ";
        r1.<init>(r2);	 Catch:{ Exception -> 0x0105, all -> 0x038b }
        r1.append(r3);	 Catch:{ Exception -> 0x0105, all -> 0x038b }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0105, all -> 0x038b }
        r2 = "RES";
        com.qiyukf.basesdk.a.a.a(r2, r1);	 Catch:{ Exception -> 0x0105, all -> 0x038b }
        r1 = c();
        r3 = new java.lang.StringBuilder;
        r4 = "HTTPDownload STAT END ";
        r3.<init>(r4);
        r3.append(r1);
        r3 = r3.toString();
        r4 = "RES";
        com.qiyukf.basesdk.a.a.d(r4, r3);
        r3 = r1 - r7;
        r1 = new java.lang.StringBuilder;
        r2 = "HTTPDownload STAT COST ";
        r1.<init>(r2);
        r1.append(r3);
        r1 = r1.toString();
        r2 = "RES";
        com.qiyukf.basesdk.a.a.d(r2, r1);
        com.qiyukf.basesdk.b.a.c.b.a(r9);
        r1 = 0;
        return r1;
    L_0x0156:
        r10 = r15;
    L_0x0157:
        r5 = r2.getResponseCode();	 Catch:{ Exception -> 0x0105, all -> 0x038b }
        r6 = r2.getInputStream();	 Catch:{ Exception -> 0x0105, all -> 0x038b }
        r12 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r5 == r12) goto L_0x0258;
    L_0x0163:
        r13 = 206; // 0xce float:2.89E-43 double:1.02E-321;
        if (r5 != r13) goto L_0x0169;
    L_0x0167:
        goto L_0x0258;
    L_0x0169:
        r1 = 416; // 0x1a0 float:5.83E-43 double:2.055E-321;
        if (r5 != r1) goto L_0x020c;
    L_0x016d:
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0202, all -> 0x01fa }
        r4 = "HTTPDownload FAILED REASON REQUESTED_RANGE_NOT_SATISFIABLE:";
        r1.<init>(r4);	 Catch:{ Exception -> 0x0202, all -> 0x01fa }
        r2 = r2.getErrorStream();	 Catch:{ Exception -> 0x0202, all -> 0x01fa }
        r2 = com.qiyukf.basesdk.b.a.c.b.a(r2);	 Catch:{ Exception -> 0x0202, all -> 0x01fa }
        r1.append(r2);	 Catch:{ Exception -> 0x0202, all -> 0x01fa }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0202, all -> 0x01fa }
        r2 = "RES";
        com.qiyukf.basesdk.a.a.a(r2, r1);	 Catch:{ Exception -> 0x0202, all -> 0x01fa }
        r1 = android.text.TextUtils.isEmpty(r24);	 Catch:{ Exception -> 0x0202, all -> 0x01fa }
        if (r1 != 0) goto L_0x01c9;
    L_0x018e:
        r1 = new java.io.File;	 Catch:{ Exception -> 0x0202, all -> 0x01fa }
        r1.<init>(r3);	 Catch:{ Exception -> 0x0202, all -> 0x01fa }
        r2 = r1.exists();	 Catch:{ Exception -> 0x0202, all -> 0x01fa }
        if (r2 == 0) goto L_0x01c9;
    L_0x0199:
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0202, all -> 0x01fa }
        r2.<init>();	 Catch:{ Exception -> 0x0202, all -> 0x01fa }
        r3 = r1.getParent();	 Catch:{ Exception -> 0x0202, all -> 0x01fa }
        r2.append(r3);	 Catch:{ Exception -> 0x0202, all -> 0x01fa }
        r3 = "/";
        r2.append(r3);	 Catch:{ Exception -> 0x0202, all -> 0x01fa }
        r3 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0202, all -> 0x01fa }
        r2.append(r3);	 Catch:{ Exception -> 0x0202, all -> 0x01fa }
        r3 = "_tmp";
        r2.append(r3);	 Catch:{ Exception -> 0x0202, all -> 0x01fa }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0202, all -> 0x01fa }
        r3 = new java.io.File;	 Catch:{ Exception -> 0x0202, all -> 0x01fa }
        r3.<init>(r2);	 Catch:{ Exception -> 0x0202, all -> 0x01fa }
        r2 = r1.renameTo(r3);	 Catch:{ Exception -> 0x0202, all -> 0x01fa }
        if (r2 == 0) goto L_0x01c6;
    L_0x01c5:
        r1 = r3;
    L_0x01c6:
        r1.delete();	 Catch:{ Exception -> 0x0202, all -> 0x01fa }
    L_0x01c9:
        r1 = c();
        r3 = new java.lang.StringBuilder;
        r4 = "HTTPDownload STAT END ";
        r3.<init>(r4);
        r3.append(r1);
        r3 = r3.toString();
        r4 = "RES";
        com.qiyukf.basesdk.a.a.d(r4, r3);
        r3 = r1 - r7;
        r1 = new java.lang.StringBuilder;
        r2 = "HTTPDownload STAT COST ";
        r1.<init>(r2);
        r1.append(r3);
        r1 = r1.toString();
        r2 = "RES";
        com.qiyukf.basesdk.a.a.d(r2, r1);
        com.qiyukf.basesdk.b.a.c.b.a(r6);
        r1 = 0;
        return r1;
    L_0x01fa:
        r0 = move-exception;
        r13 = r21;
        r1 = r0;
        r12 = r9;
    L_0x01ff:
        r9 = r6;
        goto L_0x040d;
    L_0x0202:
        r0 = move-exception;
        r13 = r21;
        r1 = r0;
        r12 = r9;
        r2 = r18;
        r9 = r6;
        goto L_0x0397;
    L_0x020c:
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0202, all -> 0x01fa }
        r3 = "HTTPDownload FAILED REASON: ";
        r1.<init>(r3);	 Catch:{ Exception -> 0x0202, all -> 0x01fa }
        r2 = r2.getErrorStream();	 Catch:{ Exception -> 0x0202, all -> 0x01fa }
        r2 = com.qiyukf.basesdk.b.a.c.b.a(r2);	 Catch:{ Exception -> 0x0202, all -> 0x01fa }
        r1.append(r2);	 Catch:{ Exception -> 0x0202, all -> 0x01fa }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0202, all -> 0x01fa }
        r2 = "RES";
        com.qiyukf.basesdk.a.a.a(r2, r1);	 Catch:{ Exception -> 0x0202, all -> 0x01fa }
        r1 = c();
        r3 = new java.lang.StringBuilder;
        r4 = "HTTPDownload STAT END ";
        r3.<init>(r4);
        r3.append(r1);
        r3 = r3.toString();
        r4 = "RES";
        com.qiyukf.basesdk.a.a.d(r4, r3);
        r3 = r1 - r7;
        r1 = new java.lang.StringBuilder;
        r2 = "HTTPDownload STAT COST ";
        r1.<init>(r2);
        r1.append(r3);
        r1 = r1.toString();
        r2 = "RES";
        com.qiyukf.basesdk.a.a.d(r2, r1);
        com.qiyukf.basesdk.b.a.c.b.a(r6);
        r1 = 0;
        return r1;
    L_0x0258:
        if (r5 != r12) goto L_0x025b;
    L_0x025a:
        r10 = r15;
    L_0x025b:
        if (r4 == 0) goto L_0x0260;
    L_0x025d:
        r4.a(r1, r10);	 Catch:{ Exception -> 0x0202, all -> 0x01fa }
    L_0x0260:
        r5 = "Content-Length";
        r2 = r2.getHeaderField(r5);	 Catch:{ Exception -> 0x026c, all -> 0x01fa }
        r12 = java.lang.Long.parseLong(r2);	 Catch:{ Exception -> 0x026c, all -> 0x01fa }
        r15 = r10 + r12;
    L_0x026c:
        r12 = r15;
        if (r4 == 0) goto L_0x0272;
    L_0x026f:
        r4.b(r1, r12);	 Catch:{ Exception -> 0x0202, all -> 0x01fa }
    L_0x0272:
        r2 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r5 = new byte[r2];	 Catch:{ Exception -> 0x0377, all -> 0x036f }
        r12 = new java.io.RandomAccessFile;	 Catch:{ Exception -> 0x0377, all -> 0x036f }
        r13 = "rws";
        r12.<init>(r3, r13);	 Catch:{ Exception -> 0x0377, all -> 0x036f }
        r13 = 0;
    L_0x027e:
        r15 = r6.read(r5, r13, r2);	 Catch:{ Exception -> 0x0367, all -> 0x0362 }
        if (r15 <= 0) goto L_0x0301;
    L_0x0284:
        r12.seek(r10);	 Catch:{ Exception -> 0x02f5, all -> 0x02eb }
        r12.write(r5, r13, r15);	 Catch:{ Exception -> 0x02f5, all -> 0x02eb }
        r13 = r21;
        r2 = r13.a;	 Catch:{ Exception -> 0x02e9, all -> 0x02e7 }
        if (r2 == 0) goto L_0x02cc;
    L_0x0290:
        r12.close();	 Catch:{ Exception -> 0x02c7, all -> 0x02c3 }
        r1 = c();
        r3 = new java.lang.StringBuilder;
        r4 = "HTTPDownload STAT END ";
        r3.<init>(r4);
        r3.append(r1);
        r3 = r3.toString();
        r4 = "RES";
        com.qiyukf.basesdk.a.a.d(r4, r3);
        r3 = r1 - r7;
        r1 = new java.lang.StringBuilder;
        r2 = "HTTPDownload STAT COST ";
        r1.<init>(r2);
        r1.append(r3);
        r1 = r1.toString();
        r2 = "RES";
        com.qiyukf.basesdk.a.a.d(r2, r1);
        com.qiyukf.basesdk.b.a.c.b.a(r6);
        return r14;
    L_0x02c3:
        r0 = move-exception;
        r1 = r0;
        goto L_0x01ff;
    L_0x02c7:
        r0 = move-exception;
        r1 = r0;
        r9 = r6;
        goto L_0x0388;
    L_0x02cc:
        r14 = (long) r15;
        r20 = r5;
        r19 = r6;
        r5 = r10 + r14;
        if (r4 == 0) goto L_0x02dd;
    L_0x02d5:
        r4.a(r1, r5);	 Catch:{ Exception -> 0x02db, all -> 0x02d9 }
        goto L_0x02dd;
    L_0x02d9:
        r0 = move-exception;
        goto L_0x02f0;
    L_0x02db:
        r0 = move-exception;
        goto L_0x02fa;
    L_0x02dd:
        r10 = r5;
        r6 = r19;
        r5 = r20;
        r2 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r13 = 0;
        r14 = 1;
        goto L_0x027e;
    L_0x02e7:
        r0 = move-exception;
        goto L_0x02ee;
    L_0x02e9:
        r0 = move-exception;
        goto L_0x02f8;
    L_0x02eb:
        r0 = move-exception;
        r13 = r21;
    L_0x02ee:
        r19 = r6;
    L_0x02f0:
        r1 = r0;
    L_0x02f1:
        r9 = r19;
        goto L_0x040d;
    L_0x02f5:
        r0 = move-exception;
        r13 = r21;
    L_0x02f8:
        r19 = r6;
    L_0x02fa:
        r1 = r0;
    L_0x02fb:
        r2 = r18;
        r9 = r19;
        goto L_0x0397;
    L_0x0301:
        r13 = r21;
        r19 = r6;
        r12.close();	 Catch:{ Exception -> 0x035e, all -> 0x035a }
        if (r4 == 0) goto L_0x0327;
    L_0x030a:
        r2 = new java.io.File;	 Catch:{ Exception -> 0x0323, all -> 0x031f }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0323, all -> 0x031f }
        r2 = r2.exists();	 Catch:{ Exception -> 0x0323, all -> 0x031f }
        if (r2 == 0) goto L_0x0319;
    L_0x0315:
        r4.b(r1);	 Catch:{ Exception -> 0x0323, all -> 0x031f }
        goto L_0x0327;
    L_0x0319:
        r2 = "file not exist";
        r4.a(r1, r2);	 Catch:{ Exception -> 0x0323, all -> 0x031f }
        goto L_0x0327;
    L_0x031f:
        r0 = move-exception;
        r1 = r0;
        r12 = r9;
        goto L_0x02f1;
    L_0x0323:
        r0 = move-exception;
        r1 = r0;
        r12 = r9;
        goto L_0x02fb;
    L_0x0327:
        r1 = c();
        r3 = new java.lang.StringBuilder;
        r4 = "HTTPDownload STAT END ";
        r3.<init>(r4);
        r3.append(r1);
        r3 = r3.toString();
        r4 = "RES";
        com.qiyukf.basesdk.a.a.d(r4, r3);
        r3 = r1 - r7;
        r1 = new java.lang.StringBuilder;
        r2 = "HTTPDownload STAT COST ";
        r1.<init>(r2);
        r1.append(r3);
        r1 = r1.toString();
        r2 = "RES";
        com.qiyukf.basesdk.a.a.d(r2, r1);
        r1 = r19;
        com.qiyukf.basesdk.b.a.c.b.a(r1);
        r1 = 1;
        return r1;
    L_0x035a:
        r0 = move-exception;
        r1 = r19;
        goto L_0x0374;
    L_0x035e:
        r0 = move-exception;
        r1 = r19;
        goto L_0x036b;
    L_0x0362:
        r0 = move-exception;
        r13 = r21;
        r1 = r6;
        goto L_0x0374;
    L_0x0367:
        r0 = move-exception;
        r13 = r21;
        r1 = r6;
    L_0x036b:
        r9 = r1;
        r2 = r18;
        goto L_0x037f;
    L_0x036f:
        r0 = move-exception;
        r13 = r21;
        r1 = r6;
        r12 = r9;
    L_0x0374:
        r9 = r1;
        goto L_0x040c;
    L_0x0377:
        r0 = move-exception;
        r13 = r21;
        r1 = r6;
        r12 = r9;
        r2 = r18;
        r9 = r1;
    L_0x037f:
        r1 = r0;
        goto L_0x0397;
    L_0x0381:
        r0 = move-exception;
        r13 = r21;
        r18 = r11;
    L_0x0386:
        r1 = r0;
        r12 = r9;
    L_0x0388:
        r2 = r18;
        goto L_0x0397;
    L_0x038b:
        r0 = move-exception;
        r13 = r21;
        r1 = r0;
        r12 = r9;
        goto L_0x040d;
    L_0x0392:
        r0 = move-exception;
        r13 = r21;
        r1 = r0;
        r12 = r9;
    L_0x0397:
        r1.printStackTrace();	 Catch:{ all -> 0x040b }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x040b }
        r4 = "HTTPDownload FAILED URL ";
        r3.<init>(r4);	 Catch:{ all -> 0x040b }
        r3.append(r2);	 Catch:{ all -> 0x040b }
        r2 = " EX ";
        r3.append(r2);	 Catch:{ all -> 0x040b }
        r1 = r1.getMessage();	 Catch:{ all -> 0x040b }
        r3.append(r1);	 Catch:{ all -> 0x040b }
        r1 = r3.toString();	 Catch:{ all -> 0x040b }
        r2 = "RES";
        com.qiyukf.basesdk.a.a.a(r2, r1);	 Catch:{ all -> 0x040b }
        r1 = c();
        r3 = new java.lang.StringBuilder;
        r4 = "HTTPDownload STAT END ";
        r3.<init>(r4);
        r3.append(r1);
        r3 = r3.toString();
        r4 = "RES";
        com.qiyukf.basesdk.a.a.d(r4, r3);
        r3 = r1 - r7;
        r1 = new java.lang.StringBuilder;
        r2 = "HTTPDownload STAT COST ";
        r1.<init>(r2);
        r1.append(r3);
        r1 = r1.toString();
        r2 = "RES";
        com.qiyukf.basesdk.a.a.d(r2, r1);
        com.qiyukf.basesdk.b.a.c.b.a(r9);
        if (r12 == 0) goto L_0x0409;
    L_0x03ea:
        r12.close();	 Catch:{ IOException -> 0x03ee }
        goto L_0x0409;
    L_0x03ee:
        r0 = move-exception;
        r0.printStackTrace();
        r1 = new java.lang.StringBuilder;
        r2 = "HTTPDownload FAILED CLOSE EX ";
        r1.<init>(r2);
        r2 = r0.toString();
        r1.append(r2);
        r1 = r1.toString();
        r2 = "RES";
        com.qiyukf.basesdk.a.a.a(r2, r1);
    L_0x0409:
        r1 = 0;
        return r1;
    L_0x040b:
        r0 = move-exception;
    L_0x040c:
        r1 = r0;
    L_0x040d:
        r2 = c();
        r4 = new java.lang.StringBuilder;
        r5 = "HTTPDownload STAT END ";
        r4.<init>(r5);
        r4.append(r2);
        r4 = r4.toString();
        r5 = "RES";
        com.qiyukf.basesdk.a.a.d(r5, r4);
        r4 = r2 - r7;
        r2 = new java.lang.StringBuilder;
        r3 = "HTTPDownload STAT COST ";
        r2.<init>(r3);
        r2.append(r4);
        r2 = r2.toString();
        r3 = "RES";
        com.qiyukf.basesdk.a.a.d(r3, r2);
        com.qiyukf.basesdk.b.a.c.b.a(r9);
        if (r12 == 0) goto L_0x045d;
    L_0x043e:
        r12.close();	 Catch:{ IOException -> 0x0442 }
        goto L_0x045d;
    L_0x0442:
        r0 = move-exception;
        r0.printStackTrace();
        r2 = new java.lang.StringBuilder;
        r3 = "HTTPDownload FAILED CLOSE EX ";
        r2.<init>(r3);
        r3 = r0.toString();
        r2.append(r3);
        r2 = r2.toString();
        r3 = "RES";
        com.qiyukf.basesdk.a.a.a(r3, r2);
    L_0x045d:
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.basesdk.b.a.a.c.a(java.lang.String, java.lang.String, java.lang.String, com.qiyukf.basesdk.b.a.a.a, long):boolean");
    }

    private static final long c() {
        return new Date().getTime();
    }

    public final boolean a(a aVar) {
        String a = aVar.a;
        String b = aVar.b;
        a c = aVar.c;
        long d = aVar.d;
        if (TextUtils.isEmpty(a) || TextUtils.isEmpty(b)) {
            if (c != null) {
                c.a(a, "url or file path is empty");
            }
            return false;
        }
        boolean z;
        for (int i = 0; i < 3; i++) {
            if (a(a, a, b, c, d)) {
                z = true;
                break;
            }
            SystemClock.sleep(5000);
            StringBuilder stringBuilder = new StringBuilder("HTTPDownload USUAL RETRY ");
            stringBuilder.append(i);
            com.qiyukf.basesdk.a.a.a("RES", stringBuilder.toString());
        }
        z = false;
        if (z) {
            return true;
        }
        if (c != null) {
            c.a(a, "");
        }
        return false;
    }

    public final void b() {
        this.a = true;
    }
}
