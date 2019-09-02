package com.baidu.location.g;

import java.io.File;
import java.io.RandomAccessFile;

public class c {
    static c c;
    String a = "firll.dat";
    int b = 3164;
    int d = 0;
    int e = 20;
    int f = 40;
    int g = 60;
    int h = 80;
    int i = 100;

    /* JADX WARNING: Removed duplicated region for block: B:23:0x004b A:{SYNTHETIC, Splitter:B:23:0x004b} */
    /* JADX WARNING: Missing block: B:15:0x003f, code skipped:
            if (r4 != null) goto L_0x0041;
     */
    /* JADX WARNING: Missing block: B:17:?, code skipped:
            r4.close();
     */
    /* JADX WARNING: Missing block: B:18:0x0044, code skipped:
            return -1;
     */
    /* JADX WARNING: Missing block: B:29:0x0050, code skipped:
            if (r4 != null) goto L_0x0041;
     */
    /* JADX WARNING: Missing block: B:31:0x0053, code skipped:
            return -1;
     */
    private long a(int r8) {
        /*
        r7 = this;
        r0 = com.baidu.location.g.j.i();
        r1 = -1;
        if (r0 != 0) goto L_0x0009;
    L_0x0008:
        return r1;
    L_0x0009:
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r3.append(r0);
        r0 = java.io.File.separator;
        r3.append(r0);
        r0 = r7.a;
        r3.append(r0);
        r0 = r3.toString();
        r3 = 0;
        r4 = new java.io.RandomAccessFile;	 Catch:{ Exception -> 0x004f, all -> 0x0047 }
        r5 = "rw";
        r4.<init>(r0, r5);	 Catch:{ Exception -> 0x004f, all -> 0x0047 }
        r5 = (long) r8;
        r4.seek(r5);	 Catch:{ Exception -> 0x0050, all -> 0x0045 }
        r8 = r4.readInt();	 Catch:{ Exception -> 0x0050, all -> 0x0045 }
        r5 = r4.readLong();	 Catch:{ Exception -> 0x0050, all -> 0x0045 }
        r0 = r4.readInt();	 Catch:{ Exception -> 0x0050, all -> 0x0045 }
        if (r8 != r0) goto L_0x003f;
    L_0x0039:
        if (r4 == 0) goto L_0x003e;
    L_0x003b:
        r4.close();	 Catch:{ IOException -> 0x003e }
    L_0x003e:
        return r5;
    L_0x003f:
        if (r4 == 0) goto L_0x0053;
    L_0x0041:
        r4.close();	 Catch:{ IOException -> 0x0053 }
        return r1;
    L_0x0045:
        r8 = move-exception;
        goto L_0x0049;
    L_0x0047:
        r8 = move-exception;
        r4 = r3;
    L_0x0049:
        if (r4 == 0) goto L_0x004e;
    L_0x004b:
        r4.close();	 Catch:{ IOException -> 0x004e }
    L_0x004e:
        throw r8;
    L_0x004f:
        r4 = r3;
    L_0x0050:
        if (r4 == 0) goto L_0x0053;
    L_0x0052:
        goto L_0x0041;
    L_0x0053:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.g.c.a(int):long");
    }

    public static c a() {
        if (c == null) {
            c = new c();
        }
        return c;
    }

    private void a(int i, long j) {
        String i2 = j.i();
        if (i2 != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i2);
            stringBuilder.append(File.separator);
            stringBuilder.append(this.a);
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(stringBuilder.toString(), "rw");
                randomAccessFile.seek((long) i);
                randomAccessFile.writeInt(this.b);
                randomAccessFile.writeLong(j);
                randomAccessFile.writeInt(this.b);
                randomAccessFile.close();
            } catch (Exception unused) {
            }
        }
    }

    public void a(long j) {
        a(this.d, j);
    }

    public long b() {
        return a(this.d);
    }

    public void b(long j) {
        a(this.e, j);
    }

    public long c() {
        return a(this.e);
    }

    public void c(long j) {
        a(this.g, j);
    }

    public long d() {
        return a(this.g);
    }
}
