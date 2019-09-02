package com.amap.api.mapcore.util;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

/* compiled from: DiskLruCache */
public final class oOo0o0oO implements Closeable {
    static final Pattern O000000o = Pattern.compile("[a-z0-9_-]{1,120}");
    static ThreadPoolExecutor O00000Oo = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), O0000o);
    private static final ThreadFactory O0000o = new ThreadFactory() {
        private final AtomicInteger O000000o = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("disklrucache#");
            stringBuilder.append(this.O000000o.getAndIncrement());
            return new Thread(runnable, stringBuilder.toString());
        }
    };
    private static final OutputStream O0000oO = new OutputStream() {
        public void write(int i) throws IOException {
        }
    };
    private final File O00000o;
    private final File O00000o0;
    private final File O00000oO;
    private final File O00000oo;
    private final int O0000O0o;
    private long O0000OOo;
    private long O0000Oo = 0;
    private final int O0000Oo0;
    private Writer O0000OoO;
    private int O0000Ooo = 1000;
    private int O0000o0;
    private final LinkedHashMap<String, O00000o0> O0000o00 = new LinkedHashMap(0, 0.75f, true);
    private ooOOO0Oo O0000o0O;
    private long O0000o0o = 0;
    private final Callable<Void> O0000oO0 = new Callable<Void>() {
        /* JADX WARNING: Missing block: B:11:0x0027, code skipped:
            return null;
     */
        /* renamed from: O000000o */
        public java.lang.Void call() throws java.lang.Exception {
            /*
            r4 = this;
            r0 = com.amap.api.mapcore.util.oOo0o0oO.this;
            monitor-enter(r0);
            r1 = com.amap.api.mapcore.util.oOo0o0oO.this;	 Catch:{ all -> 0x0028 }
            r1 = r1.O0000OoO;	 Catch:{ all -> 0x0028 }
            r2 = 0;
            if (r1 != 0) goto L_0x000e;
        L_0x000c:
            monitor-exit(r0);	 Catch:{ all -> 0x0028 }
            return r2;
        L_0x000e:
            r1 = com.amap.api.mapcore.util.oOo0o0oO.this;	 Catch:{ all -> 0x0028 }
            r1.O0000o00();	 Catch:{ all -> 0x0028 }
            r1 = com.amap.api.mapcore.util.oOo0o0oO.this;	 Catch:{ all -> 0x0028 }
            r1 = r1.O0000OoO();	 Catch:{ all -> 0x0028 }
            if (r1 == 0) goto L_0x0026;
        L_0x001b:
            r1 = com.amap.api.mapcore.util.oOo0o0oO.this;	 Catch:{ all -> 0x0028 }
            r1.O0000Oo();	 Catch:{ all -> 0x0028 }
            r1 = com.amap.api.mapcore.util.oOo0o0oO.this;	 Catch:{ all -> 0x0028 }
            r3 = 0;
            r1.O0000o0 = r3;	 Catch:{ all -> 0x0028 }
        L_0x0026:
            monitor-exit(r0);	 Catch:{ all -> 0x0028 }
            return r2;
        L_0x0028:
            r1 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x0028 }
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.oOo0o0oO$AnonymousClass2.call():java.lang.Void");
        }
    };

    /* compiled from: DiskLruCache */
    public final class O000000o {
        private final O00000o0 O00000Oo;
        private boolean O00000o;
        private final boolean[] O00000o0;
        private boolean O00000oO;

        /* compiled from: DiskLruCache */
        private class O000000o extends FilterOutputStream {
            private O000000o(OutputStream outputStream) {
                super(outputStream);
            }

            /* synthetic */ O000000o(O000000o o000000o, OutputStream outputStream, AnonymousClass1 anonymousClass1) {
                this(outputStream);
            }

            public void close() {
                try {
                    this.out.close();
                } catch (IOException unused) {
                    O000000o.this.O00000o = true;
                }
            }

            public void flush() {
                try {
                    this.out.flush();
                } catch (IOException unused) {
                    O000000o.this.O00000o = true;
                }
            }

            public void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException unused) {
                    O000000o.this.O00000o = true;
                }
            }

            public void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException unused) {
                    O000000o.this.O00000o = true;
                }
            }
        }

        private O000000o(O00000o0 o00000o0) {
            this.O00000Oo = o00000o0;
            this.O00000o0 = o00000o0.O00000o ? null : new boolean[oOo0o0oO.this.O0000Oo0];
        }

        /* synthetic */ O000000o(oOo0o0oO ooo0o0oo, O00000o0 o00000o0, AnonymousClass1 anonymousClass1) {
            this(o00000o0);
        }

        /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0035 */
        /* JADX WARNING: Can't wrap try/catch for region: R(12:10|(1:12)|13|14|15|16|17|18|19|20|21|22) */
        public java.io.OutputStream O000000o(int r4) throws java.io.IOException {
            /*
            r3 = this;
            if (r4 < 0) goto L_0x0054;
        L_0x0002:
            r0 = com.amap.api.mapcore.util.oOo0o0oO.this;
            r0 = r0.O0000Oo0;
            if (r4 < r0) goto L_0x000b;
        L_0x000a:
            goto L_0x0054;
        L_0x000b:
            r0 = com.amap.api.mapcore.util.oOo0o0oO.this;
            monitor-enter(r0);
            r1 = r3.O00000Oo;	 Catch:{ all -> 0x0051 }
            r1 = r1.O00000oO;	 Catch:{ all -> 0x0051 }
            if (r1 == r3) goto L_0x001c;
        L_0x0016:
            r4 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x0051 }
            r4.<init>();	 Catch:{ all -> 0x0051 }
            throw r4;	 Catch:{ all -> 0x0051 }
        L_0x001c:
            r1 = r3.O00000Oo;	 Catch:{ all -> 0x0051 }
            r1 = r1.O00000o;	 Catch:{ all -> 0x0051 }
            if (r1 != 0) goto L_0x0029;
        L_0x0024:
            r1 = r3.O00000o0;	 Catch:{ all -> 0x0051 }
            r2 = 1;
            r1[r4] = r2;	 Catch:{ all -> 0x0051 }
        L_0x0029:
            r1 = r3.O00000Oo;	 Catch:{ all -> 0x0051 }
            r4 = r1.O00000Oo(r4);	 Catch:{ all -> 0x0051 }
            r1 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x0035 }
            r1.<init>(r4);	 Catch:{ FileNotFoundException -> 0x0035 }
            goto L_0x0043;
        L_0x0035:
            r1 = com.amap.api.mapcore.util.oOo0o0oO.this;	 Catch:{ all -> 0x0051 }
            r1 = r1.O00000o0;	 Catch:{ all -> 0x0051 }
            r1.mkdirs();	 Catch:{ all -> 0x0051 }
            r1 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x004b }
            r1.<init>(r4);	 Catch:{ FileNotFoundException -> 0x004b }
        L_0x0043:
            r4 = new com.amap.api.mapcore.util.oOo0o0oO$O000000o$O000000o;	 Catch:{ all -> 0x0051 }
            r2 = 0;
            r4.<init>(r3, r1, r2);	 Catch:{ all -> 0x0051 }
            monitor-exit(r0);	 Catch:{ all -> 0x0051 }
            return r4;
        L_0x004b:
            r4 = com.amap.api.mapcore.util.oOo0o0oO.O0000oO;	 Catch:{ all -> 0x0051 }
            monitor-exit(r0);	 Catch:{ all -> 0x0051 }
            return r4;
        L_0x0051:
            r4 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x0051 }
            throw r4;
        L_0x0054:
            r0 = new java.lang.IllegalArgumentException;
            r1 = new java.lang.StringBuilder;
            r1.<init>();
            r2 = "Expected index ";
            r1.append(r2);
            r1.append(r4);
            r4 = " to be greater than 0 and less than the maximum value count of ";
            r1.append(r4);
            r4 = com.amap.api.mapcore.util.oOo0o0oO.this;
            r4 = r4.O0000Oo0;
            r1.append(r4);
            r4 = r1.toString();
            r0.<init>(r4);
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.oOo0o0oO$O000000o.O000000o(int):java.io.OutputStream");
        }

        public void O000000o() throws IOException {
            if (this.O00000o) {
                oOo0o0oO.this.O000000o(this, false);
                oOo0o0oO.this.O00000o0(this.O00000Oo.O00000Oo);
            } else {
                oOo0o0oO.this.O000000o(this, true);
            }
            this.O00000oO = true;
        }

        public void O00000Oo() throws IOException {
            oOo0o0oO.this.O000000o(this, false);
        }
    }

    /* compiled from: DiskLruCache */
    public final class O00000Oo implements Closeable {
        private final String O00000Oo;
        private final InputStream[] O00000o;
        private final long O00000o0;
        private final long[] O00000oO;

        private O00000Oo(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.O00000Oo = str;
            this.O00000o0 = j;
            this.O00000o = inputStreamArr;
            this.O00000oO = jArr;
        }

        /* synthetic */ O00000Oo(oOo0o0oO ooo0o0oo, String str, long j, InputStream[] inputStreamArr, long[] jArr, AnonymousClass1 anonymousClass1) {
            this(str, j, inputStreamArr, jArr);
        }

        public InputStream O000000o(int i) {
            return this.O00000o[i];
        }

        public void close() {
            for (Closeable O000000o : this.O00000o) {
                oOo00o00.O000000o(O000000o);
            }
        }
    }

    /* compiled from: DiskLruCache */
    private final class O00000o0 {
        private final String O00000Oo;
        private boolean O00000o;
        private final long[] O00000o0;
        private O000000o O00000oO;
        private long O00000oo;

        private O00000o0(String str) {
            this.O00000Oo = str;
            this.O00000o0 = new long[oOo0o0oO.this.O0000Oo0];
        }

        /* synthetic */ O00000o0(oOo0o0oO ooo0o0oo, String str, AnonymousClass1 anonymousClass1) {
            this(str);
        }

        private void O000000o(String[] strArr) throws IOException {
            if (strArr.length != oOo0o0oO.this.O0000Oo0) {
                throw O00000Oo(strArr);
            }
            int i = 0;
            while (i < strArr.length) {
                try {
                    this.O00000o0[i] = Long.parseLong(strArr[i]);
                    i++;
                } catch (NumberFormatException unused) {
                    throw O00000Oo(strArr);
                }
            }
        }

        private IOException O00000Oo(String[] strArr) throws IOException {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("unexpected journal line: ");
            stringBuilder.append(Arrays.toString(strArr));
            throw new IOException(stringBuilder.toString());
        }

        public File O000000o(int i) {
            File O00000oo = oOo0o0oO.this.O00000o0;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.O00000Oo);
            stringBuilder.append(".");
            stringBuilder.append(i);
            return new File(O00000oo, stringBuilder.toString());
        }

        public String O000000o() throws IOException {
            StringBuilder stringBuilder = new StringBuilder();
            for (long j : this.O00000o0) {
                stringBuilder.append(' ');
                stringBuilder.append(j);
            }
            return stringBuilder.toString();
        }

        public File O00000Oo(int i) {
            File O00000oo = oOo0o0oO.this.O00000o0;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.O00000Oo);
            stringBuilder.append(".");
            stringBuilder.append(i);
            stringBuilder.append(".tmp");
            return new File(O00000oo, stringBuilder.toString());
        }
    }

    private oOo0o0oO(File file, int i, int i2, long j) {
        this.O00000o0 = file;
        this.O0000O0o = i;
        this.O00000o = new File(file, "journal");
        this.O00000oO = new File(file, "journal.tmp");
        this.O00000oo = new File(file, "journal.bkp");
        this.O0000Oo0 = i2;
        this.O0000OOo = j;
    }

    /* JADX WARNING: Missing block: B:9:0x0021, code skipped:
            return null;
     */
    private synchronized com.amap.api.mapcore.util.oOo0o0oO.O000000o O000000o(java.lang.String r6, long r7) throws java.io.IOException {
        /*
        r5 = this;
        monitor-enter(r5);
        r5.O0000Ooo();	 Catch:{ all -> 0x0061 }
        r5.O00000oO(r6);	 Catch:{ all -> 0x0061 }
        r0 = r5.O0000o00;	 Catch:{ all -> 0x0061 }
        r0 = r0.get(r6);	 Catch:{ all -> 0x0061 }
        r0 = (com.amap.api.mapcore.util.oOo0o0oO.O00000o0) r0;	 Catch:{ all -> 0x0061 }
        r1 = -1;
        r3 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1));
        r1 = 0;
        if (r3 == 0) goto L_0x0022;
    L_0x0016:
        if (r0 == 0) goto L_0x0020;
    L_0x0018:
        r2 = r0.O00000oo;	 Catch:{ all -> 0x0061 }
        r4 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1));
        if (r4 == 0) goto L_0x0022;
    L_0x0020:
        monitor-exit(r5);
        return r1;
    L_0x0022:
        if (r0 != 0) goto L_0x002f;
    L_0x0024:
        r0 = new com.amap.api.mapcore.util.oOo0o0oO$O00000o0;	 Catch:{ all -> 0x0061 }
        r0.<init>(r5, r6, r1);	 Catch:{ all -> 0x0061 }
        r7 = r5.O0000o00;	 Catch:{ all -> 0x0061 }
        r7.put(r6, r0);	 Catch:{ all -> 0x0061 }
        goto L_0x0037;
    L_0x002f:
        r7 = r0.O00000oO;	 Catch:{ all -> 0x0061 }
        if (r7 == 0) goto L_0x0037;
    L_0x0035:
        monitor-exit(r5);
        return r1;
    L_0x0037:
        r7 = new com.amap.api.mapcore.util.oOo0o0oO$O000000o;	 Catch:{ all -> 0x0061 }
        r7.<init>(r5, r0, r1);	 Catch:{ all -> 0x0061 }
        r0.O00000oO = r7;	 Catch:{ all -> 0x0061 }
        r8 = r5.O0000OoO;	 Catch:{ all -> 0x0061 }
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0061 }
        r0.<init>();	 Catch:{ all -> 0x0061 }
        r1 = "DIRTY ";
        r0.append(r1);	 Catch:{ all -> 0x0061 }
        r0.append(r6);	 Catch:{ all -> 0x0061 }
        r6 = 10;
        r0.append(r6);	 Catch:{ all -> 0x0061 }
        r6 = r0.toString();	 Catch:{ all -> 0x0061 }
        r8.write(r6);	 Catch:{ all -> 0x0061 }
        r6 = r5.O0000OoO;	 Catch:{ all -> 0x0061 }
        r6.flush();	 Catch:{ all -> 0x0061 }
        monitor-exit(r5);
        return r7;
    L_0x0061:
        r6 = move-exception;
        monitor-exit(r5);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.oOo0o0oO.O000000o(java.lang.String, long):com.amap.api.mapcore.util.oOo0o0oO$O000000o");
    }

    public static oOo0o0oO O000000o(File file, int i, int i2, long j) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        } else {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    O000000o(file2, file3, false);
                }
            }
            oOo0o0oO ooo0o0oo = new oOo0o0oO(file, i, i2, j);
            if (ooo0o0oo.O00000o.exists()) {
                try {
                    ooo0o0oo.O0000OOo();
                    ooo0o0oo.O0000Oo0();
                    ooo0o0oo.O0000OoO = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ooo0o0oo.O00000o, true), oOo00o00.O000000o));
                    return ooo0o0oo;
                } catch (Throwable unused) {
                    ooo0o0oo.O00000oo();
                }
            }
            file.mkdirs();
            oOo0o0oO ooo0o0oo2 = new oOo0o0oO(file, i, i2, j);
            ooo0o0oo2.O0000Oo();
            return ooo0o0oo2;
        }
    }

    public static void O000000o() {
        if (O00000Oo != null && !O00000Oo.isShutdown()) {
            O00000Oo.shutdown();
        }
    }

    /* JADX WARNING: Missing block: B:45:0x0114, code skipped:
            return;
     */
    private synchronized void O000000o(com.amap.api.mapcore.util.oOo0o0oO.O000000o r12, boolean r13) throws java.io.IOException {
        /*
        r11 = this;
        monitor-enter(r11);
        r0 = r12.O00000Oo;	 Catch:{ all -> 0x0115 }
        r1 = r0.O00000oO;	 Catch:{ all -> 0x0115 }
        if (r1 == r12) goto L_0x0011;
    L_0x000b:
        r12 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x0115 }
        r12.<init>();	 Catch:{ all -> 0x0115 }
        throw r12;	 Catch:{ all -> 0x0115 }
    L_0x0011:
        r1 = 0;
        if (r13 == 0) goto L_0x0053;
    L_0x0014:
        r2 = r0.O00000o;	 Catch:{ all -> 0x0115 }
        if (r2 != 0) goto L_0x0053;
    L_0x001a:
        r2 = r1;
    L_0x001b:
        r3 = r11.O0000Oo0;	 Catch:{ all -> 0x0115 }
        if (r2 >= r3) goto L_0x0053;
    L_0x001f:
        r3 = r12.O00000o0;	 Catch:{ all -> 0x0115 }
        r3 = r3[r2];	 Catch:{ all -> 0x0115 }
        if (r3 != 0) goto L_0x0041;
    L_0x0027:
        r12.O00000Oo();	 Catch:{ all -> 0x0115 }
        r12 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x0115 }
        r13 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0115 }
        r13.<init>();	 Catch:{ all -> 0x0115 }
        r0 = "Newly created entry didn't create value for index ";
        r13.append(r0);	 Catch:{ all -> 0x0115 }
        r13.append(r2);	 Catch:{ all -> 0x0115 }
        r13 = r13.toString();	 Catch:{ all -> 0x0115 }
        r12.<init>(r13);	 Catch:{ all -> 0x0115 }
        throw r12;	 Catch:{ all -> 0x0115 }
    L_0x0041:
        r3 = r0.O00000Oo(r2);	 Catch:{ all -> 0x0115 }
        r3 = r3.exists();	 Catch:{ all -> 0x0115 }
        if (r3 != 0) goto L_0x0050;
    L_0x004b:
        r12.O00000Oo();	 Catch:{ all -> 0x0115 }
        monitor-exit(r11);
        return;
    L_0x0050:
        r2 = r2 + 1;
        goto L_0x001b;
    L_0x0053:
        r12 = r11.O0000Oo0;	 Catch:{ all -> 0x0115 }
        if (r1 >= r12) goto L_0x0089;
    L_0x0057:
        r12 = r0.O00000Oo(r1);	 Catch:{ all -> 0x0115 }
        if (r13 == 0) goto L_0x0083;
    L_0x005d:
        r2 = r12.exists();	 Catch:{ all -> 0x0115 }
        if (r2 == 0) goto L_0x0086;
    L_0x0063:
        r2 = r0.O000000o(r1);	 Catch:{ all -> 0x0115 }
        r12.renameTo(r2);	 Catch:{ all -> 0x0115 }
        r12 = r0.O00000o0;	 Catch:{ all -> 0x0115 }
        r3 = r12[r1];	 Catch:{ all -> 0x0115 }
        r5 = r2.length();	 Catch:{ all -> 0x0115 }
        r12 = r0.O00000o0;	 Catch:{ all -> 0x0115 }
        r12[r1] = r5;	 Catch:{ all -> 0x0115 }
        r7 = r11.O0000Oo;	 Catch:{ all -> 0x0115 }
        r9 = r7 - r3;
        r2 = r9 + r5;
        r11.O0000Oo = r2;	 Catch:{ all -> 0x0115 }
        goto L_0x0086;
    L_0x0083:
        O000000o(r12);	 Catch:{ all -> 0x0115 }
    L_0x0086:
        r1 = r1 + 1;
        goto L_0x0053;
    L_0x0089:
        r12 = r11.O0000o0;	 Catch:{ all -> 0x0115 }
        r1 = 1;
        r12 = r12 + r1;
        r11.O0000o0 = r12;	 Catch:{ all -> 0x0115 }
        r12 = 0;
        r0.O00000oO = r12;	 Catch:{ all -> 0x0115 }
        r12 = r0.O00000o;	 Catch:{ all -> 0x0115 }
        r12 = r12 | r13;
        r2 = 10;
        if (r12 == 0) goto L_0x00d1;
    L_0x009c:
        r0.O00000o = r1;	 Catch:{ all -> 0x0115 }
        r12 = r11.O0000OoO;	 Catch:{ all -> 0x0115 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0115 }
        r1.<init>();	 Catch:{ all -> 0x0115 }
        r3 = "CLEAN ";
        r1.append(r3);	 Catch:{ all -> 0x0115 }
        r3 = r0.O00000Oo;	 Catch:{ all -> 0x0115 }
        r1.append(r3);	 Catch:{ all -> 0x0115 }
        r3 = r0.O000000o();	 Catch:{ all -> 0x0115 }
        r1.append(r3);	 Catch:{ all -> 0x0115 }
        r1.append(r2);	 Catch:{ all -> 0x0115 }
        r1 = r1.toString();	 Catch:{ all -> 0x0115 }
        r12.write(r1);	 Catch:{ all -> 0x0115 }
        if (r13 == 0) goto L_0x00f7;
    L_0x00c5:
        r12 = r11.O0000o0o;	 Catch:{ all -> 0x0115 }
        r1 = 1;
        r3 = r12 + r1;
        r11.O0000o0o = r3;	 Catch:{ all -> 0x0115 }
        r0.O00000oo = r12;	 Catch:{ all -> 0x0115 }
        goto L_0x00f7;
    L_0x00d1:
        r12 = r11.O0000o00;	 Catch:{ all -> 0x0115 }
        r13 = r0.O00000Oo;	 Catch:{ all -> 0x0115 }
        r12.remove(r13);	 Catch:{ all -> 0x0115 }
        r12 = r11.O0000OoO;	 Catch:{ all -> 0x0115 }
        r13 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0115 }
        r13.<init>();	 Catch:{ all -> 0x0115 }
        r1 = "REMOVE ";
        r13.append(r1);	 Catch:{ all -> 0x0115 }
        r0 = r0.O00000Oo;	 Catch:{ all -> 0x0115 }
        r13.append(r0);	 Catch:{ all -> 0x0115 }
        r13.append(r2);	 Catch:{ all -> 0x0115 }
        r13 = r13.toString();	 Catch:{ all -> 0x0115 }
        r12.write(r13);	 Catch:{ all -> 0x0115 }
    L_0x00f7:
        r12 = r11.O0000OoO;	 Catch:{ all -> 0x0115 }
        r12.flush();	 Catch:{ all -> 0x0115 }
        r12 = r11.O0000Oo;	 Catch:{ all -> 0x0115 }
        r0 = r11.O0000OOo;	 Catch:{ all -> 0x0115 }
        r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1));
        if (r2 > 0) goto L_0x010a;
    L_0x0104:
        r12 = r11.O0000OoO();	 Catch:{ all -> 0x0115 }
        if (r12 == 0) goto L_0x0113;
    L_0x010a:
        r12 = O00000Oo();	 Catch:{ all -> 0x0115 }
        r13 = r11.O0000oO0;	 Catch:{ all -> 0x0115 }
        r12.submit(r13);	 Catch:{ all -> 0x0115 }
    L_0x0113:
        monitor-exit(r11);
        return;
    L_0x0115:
        r12 = move-exception;
        monitor-exit(r11);
        throw r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.oOo0o0oO.O000000o(com.amap.api.mapcore.util.oOo0o0oO$O000000o, boolean):void");
    }

    private static void O000000o(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void O000000o(File file, File file2, boolean z) throws IOException {
        if (z) {
            O000000o(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public static ThreadPoolExecutor O00000Oo() {
        try {
            if (O00000Oo == null || O00000Oo.isShutdown()) {
                O00000Oo = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(256), O0000o);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return O00000Oo;
    }

    private void O00000o(String str) throws IOException {
        int indexOf = str.indexOf(32);
        StringBuilder stringBuilder;
        if (indexOf == -1) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("unexpected journal line: ");
            stringBuilder.append(str);
            throw new IOException(stringBuilder.toString());
        }
        Object substring;
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(32, i);
        if (indexOf2 == -1) {
            substring = str.substring(i);
            if (indexOf == "REMOVE".length() && str.startsWith("REMOVE")) {
                this.O0000o00.remove(substring);
                return;
            }
        }
        substring = str.substring(i, indexOf2);
        O00000o0 o00000o0 = (O00000o0) this.O0000o00.get(substring);
        if (o00000o0 == null) {
            o00000o0 = new O00000o0(this, substring, null);
            this.O0000o00.put(substring, o00000o0);
        }
        if (indexOf2 != -1 && indexOf == "CLEAN".length() && str.startsWith("CLEAN")) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            o00000o0.O00000o = true;
            o00000o0.O00000oO = null;
            o00000o0.O000000o(split);
        } else if (indexOf2 == -1 && indexOf == "DIRTY".length() && str.startsWith("DIRTY")) {
            o00000o0.O00000oO = new O000000o(this, o00000o0, null);
        } else if (!(indexOf2 == -1 && indexOf == "READ".length() && str.startsWith("READ"))) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("unexpected journal line: ");
            stringBuilder.append(str);
            throw new IOException(stringBuilder.toString());
        }
    }

    private void O00000oO(String str) {
        if (!O000000o.matcher(str).matches()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("keys must match regex [a-z0-9_-]{1,120}: \"");
            stringBuilder.append(str);
            stringBuilder.append("\"");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:19:0x006b=Splitter:B:19:0x006b, B:16:0x005e=Splitter:B:16:0x005e} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x005e */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:16|17|24) */
    /* JADX WARNING: Missing block: B:17:?, code skipped:
            r8.O0000o0 = r1 - r8.O0000o00.size();
     */
    private void O0000OOo() throws java.io.IOException {
        /*
        r8 = this;
        r0 = new com.amap.api.mapcore.util.oO0o0000;
        r1 = new java.io.FileInputStream;
        r2 = r8.O00000o;
        r1.<init>(r2);
        r2 = com.amap.api.mapcore.util.oOo00o00.O000000o;
        r0.<init>(r1, r2);
        r1 = r0.O000000o();	 Catch:{ all -> 0x009f }
        r2 = r0.O000000o();	 Catch:{ all -> 0x009f }
        r3 = r0.O000000o();	 Catch:{ all -> 0x009f }
        r4 = r0.O000000o();	 Catch:{ all -> 0x009f }
        r5 = r0.O000000o();	 Catch:{ all -> 0x009f }
        r6 = "libcore.io.DiskLruCache";
        r6 = r6.equals(r1);	 Catch:{ all -> 0x009f }
        if (r6 == 0) goto L_0x006b;
    L_0x002a:
        r6 = "1";
        r6 = r6.equals(r2);	 Catch:{ all -> 0x009f }
        if (r6 == 0) goto L_0x006b;
    L_0x0032:
        r6 = r8.O0000O0o;	 Catch:{ all -> 0x009f }
        r6 = java.lang.Integer.toString(r6);	 Catch:{ all -> 0x009f }
        r3 = r6.equals(r3);	 Catch:{ all -> 0x009f }
        if (r3 == 0) goto L_0x006b;
    L_0x003e:
        r3 = r8.O0000Oo0;	 Catch:{ all -> 0x009f }
        r3 = java.lang.Integer.toString(r3);	 Catch:{ all -> 0x009f }
        r3 = r3.equals(r4);	 Catch:{ all -> 0x009f }
        if (r3 == 0) goto L_0x006b;
    L_0x004a:
        r3 = "";
        r3 = r3.equals(r5);	 Catch:{ all -> 0x009f }
        if (r3 != 0) goto L_0x0053;
    L_0x0052:
        goto L_0x006b;
    L_0x0053:
        r1 = 0;
    L_0x0054:
        r2 = r0.O000000o();	 Catch:{ EOFException -> 0x005e }
        r8.O00000o(r2);	 Catch:{ EOFException -> 0x005e }
        r1 = r1 + 1;
        goto L_0x0054;
    L_0x005e:
        r2 = r8.O0000o00;	 Catch:{ all -> 0x009f }
        r2 = r2.size();	 Catch:{ all -> 0x009f }
        r1 = r1 - r2;
        r8.O0000o0 = r1;	 Catch:{ all -> 0x009f }
        com.amap.api.mapcore.util.oOo00o00.O000000o(r0);
        return;
    L_0x006b:
        r3 = new java.io.IOException;	 Catch:{ all -> 0x009f }
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x009f }
        r6.<init>();	 Catch:{ all -> 0x009f }
        r7 = "unexpected journal header: [";
        r6.append(r7);	 Catch:{ all -> 0x009f }
        r6.append(r1);	 Catch:{ all -> 0x009f }
        r1 = ", ";
        r6.append(r1);	 Catch:{ all -> 0x009f }
        r6.append(r2);	 Catch:{ all -> 0x009f }
        r1 = ", ";
        r6.append(r1);	 Catch:{ all -> 0x009f }
        r6.append(r4);	 Catch:{ all -> 0x009f }
        r1 = ", ";
        r6.append(r1);	 Catch:{ all -> 0x009f }
        r6.append(r5);	 Catch:{ all -> 0x009f }
        r1 = "]";
        r6.append(r1);	 Catch:{ all -> 0x009f }
        r1 = r6.toString();	 Catch:{ all -> 0x009f }
        r3.<init>(r1);	 Catch:{ all -> 0x009f }
        throw r3;	 Catch:{ all -> 0x009f }
    L_0x009f:
        r1 = move-exception;
        com.amap.api.mapcore.util.oOo00o00.O000000o(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.oOo0o0oO.O0000OOo():void");
    }

    private synchronized void O0000Oo() throws IOException {
        if (this.O0000OoO != null) {
            this.O0000OoO.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.O00000oO), oOo00o00.O000000o));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.O0000O0o));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.O0000Oo0));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (O00000o0 o00000o0 : this.O0000o00.values()) {
                StringBuilder stringBuilder;
                if (o00000o0.O00000oO != null) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("DIRTY ");
                    stringBuilder.append(o00000o0.O00000Oo);
                    stringBuilder.append(10);
                    bufferedWriter.write(stringBuilder.toString());
                } else {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("CLEAN ");
                    stringBuilder.append(o00000o0.O00000Oo);
                    stringBuilder.append(o00000o0.O000000o());
                    stringBuilder.append(10);
                    bufferedWriter.write(stringBuilder.toString());
                }
            }
            if (this.O00000o.exists()) {
                O000000o(this.O00000o, this.O00000oo, true);
            }
            O000000o(this.O00000oO, this.O00000o, false);
            this.O00000oo.delete();
            this.O0000OoO = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.O00000o, true), oOo00o00.O000000o));
        } finally {
            bufferedWriter.close();
        }
    }

    private void O0000Oo0() throws IOException {
        O000000o(this.O00000oO);
        Iterator it = this.O0000o00.values().iterator();
        while (it.hasNext()) {
            O00000o0 o00000o0 = (O00000o0) it.next();
            int i = 0;
            if (o00000o0.O00000oO == null) {
                while (i < this.O0000Oo0) {
                    this.O0000Oo += o00000o0.O00000o0[i];
                    i++;
                }
            } else {
                o00000o0.O00000oO = null;
                while (i < this.O0000Oo0) {
                    O000000o(o00000o0.O000000o(i));
                    O000000o(o00000o0.O00000Oo(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    private boolean O0000OoO() {
        return this.O0000o0 >= 2000 && this.O0000o0 >= this.O0000o00.size();
    }

    private void O0000Ooo() {
        if (this.O0000OoO == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private void O0000o00() throws IOException {
        while (true) {
            if (this.O0000Oo > this.O0000OOo || this.O0000o00.size() > this.O0000Ooo) {
                String str = (String) ((Entry) this.O0000o00.entrySet().iterator().next()).getKey();
                O00000o0(str);
                if (this.O0000o0O != null) {
                    this.O0000o0O.O000000o(str);
                }
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0077 */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:32|33|28|27) */
    /* JADX WARNING: Missing block: B:21:?, code skipped:
            r11.O0000o0++;
            r1 = r11.O0000OoO;
            r2 = new java.lang.StringBuilder();
            r2.append("READ ");
            r2.append(r12);
            r2.append(10);
            r1.append(r2.toString());
     */
    /* JADX WARNING: Missing block: B:22:0x0059, code skipped:
            if (O0000OoO() == false) goto L_0x0064;
     */
    /* JADX WARNING: Missing block: B:23:0x005b, code skipped:
            O00000Oo().submit(r11.O0000oO0);
     */
    /* JADX WARNING: Missing block: B:26:0x0076, code skipped:
            return new com.amap.api.mapcore.util.oOo0o0oO.O00000Oo(r11, r12, com.amap.api.mapcore.util.oOo0o0oO.O00000o0.O00000oO(r0), r8, com.amap.api.mapcore.util.oOo0o0oO.O00000o0.O00000Oo(r0), null);
     */
    /* JADX WARNING: Missing block: B:35:0x0088, code skipped:
            return null;
     */
    public synchronized com.amap.api.mapcore.util.oOo0o0oO.O00000Oo O000000o(java.lang.String r12) throws java.io.IOException {
        /*
        r11 = this;
        monitor-enter(r11);
        r11.O0000Ooo();	 Catch:{ all -> 0x0089 }
        r11.O00000oO(r12);	 Catch:{ all -> 0x0089 }
        r0 = r11.O0000o00;	 Catch:{ all -> 0x0089 }
        r0 = r0.get(r12);	 Catch:{ all -> 0x0089 }
        r0 = (com.amap.api.mapcore.util.oOo0o0oO.O00000o0) r0;	 Catch:{ all -> 0x0089 }
        r1 = 0;
        if (r0 != 0) goto L_0x0014;
    L_0x0012:
        monitor-exit(r11);
        return r1;
    L_0x0014:
        r2 = r0.O00000o;	 Catch:{ all -> 0x0089 }
        if (r2 != 0) goto L_0x001c;
    L_0x001a:
        monitor-exit(r11);
        return r1;
    L_0x001c:
        r2 = r11.O0000Oo0;	 Catch:{ all -> 0x0089 }
        r8 = new java.io.InputStream[r2];	 Catch:{ all -> 0x0089 }
        r2 = 0;
        r3 = r2;
    L_0x0022:
        r4 = r11.O0000Oo0;	 Catch:{ FileNotFoundException -> 0x0077 }
        if (r3 >= r4) goto L_0x0034;
    L_0x0026:
        r4 = new java.io.FileInputStream;	 Catch:{ FileNotFoundException -> 0x0077 }
        r5 = r0.O000000o(r3);	 Catch:{ FileNotFoundException -> 0x0077 }
        r4.<init>(r5);	 Catch:{ FileNotFoundException -> 0x0077 }
        r8[r3] = r4;	 Catch:{ FileNotFoundException -> 0x0077 }
        r3 = r3 + 1;
        goto L_0x0022;
    L_0x0034:
        r1 = r11.O0000o0;	 Catch:{ all -> 0x0089 }
        r1 = r1 + 1;
        r11.O0000o0 = r1;	 Catch:{ all -> 0x0089 }
        r1 = r11.O0000OoO;	 Catch:{ all -> 0x0089 }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0089 }
        r2.<init>();	 Catch:{ all -> 0x0089 }
        r3 = "READ ";
        r2.append(r3);	 Catch:{ all -> 0x0089 }
        r2.append(r12);	 Catch:{ all -> 0x0089 }
        r3 = 10;
        r2.append(r3);	 Catch:{ all -> 0x0089 }
        r2 = r2.toString();	 Catch:{ all -> 0x0089 }
        r1.append(r2);	 Catch:{ all -> 0x0089 }
        r1 = r11.O0000OoO();	 Catch:{ all -> 0x0089 }
        if (r1 == 0) goto L_0x0064;
    L_0x005b:
        r1 = O00000Oo();	 Catch:{ all -> 0x0089 }
        r2 = r11.O0000oO0;	 Catch:{ all -> 0x0089 }
        r1.submit(r2);	 Catch:{ all -> 0x0089 }
    L_0x0064:
        r1 = new com.amap.api.mapcore.util.oOo0o0oO$O00000Oo;	 Catch:{ all -> 0x0089 }
        r6 = r0.O00000oo;	 Catch:{ all -> 0x0089 }
        r9 = r0.O00000o0;	 Catch:{ all -> 0x0089 }
        r10 = 0;
        r3 = r1;
        r4 = r11;
        r5 = r12;
        r3.<init>(r4, r5, r6, r8, r9, r10);	 Catch:{ all -> 0x0089 }
        monitor-exit(r11);
        return r1;
    L_0x0077:
        r12 = r11.O0000Oo0;	 Catch:{ all -> 0x0089 }
        if (r2 >= r12) goto L_0x0087;
    L_0x007b:
        r12 = r8[r2];	 Catch:{ all -> 0x0089 }
        if (r12 == 0) goto L_0x0087;
    L_0x007f:
        r12 = r8[r2];	 Catch:{ all -> 0x0089 }
        com.amap.api.mapcore.util.oOo00o00.O000000o(r12);	 Catch:{ all -> 0x0089 }
        r2 = r2 + 1;
        goto L_0x0077;
    L_0x0087:
        monitor-exit(r11);
        return r1;
    L_0x0089:
        r12 = move-exception;
        monitor-exit(r11);
        throw r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.oOo0o0oO.O000000o(java.lang.String):com.amap.api.mapcore.util.oOo0o0oO$O00000Oo");
    }

    public void O000000o(int i) {
        if (i < 10) {
            i = 10;
        } else if (i > 10000) {
            i = 10000;
        }
        this.O0000Ooo = i;
    }

    public O000000o O00000Oo(String str) throws IOException {
        return O000000o(str, -1);
    }

    public synchronized boolean O00000o() {
        return this.O0000OoO == null;
    }

    public File O00000o0() {
        return this.O00000o0;
    }

    /* JADX WARNING: Missing block: B:20:0x0092, code skipped:
            return true;
     */
    /* JADX WARNING: Missing block: B:22:0x0094, code skipped:
            return false;
     */
    public synchronized boolean O00000o0(java.lang.String r10) throws java.io.IOException {
        /*
        r9 = this;
        monitor-enter(r9);
        r9.O0000Ooo();	 Catch:{ all -> 0x0095 }
        r9.O00000oO(r10);	 Catch:{ all -> 0x0095 }
        r0 = r9.O0000o00;	 Catch:{ all -> 0x0095 }
        r0 = r0.get(r10);	 Catch:{ all -> 0x0095 }
        r0 = (com.amap.api.mapcore.util.oOo0o0oO.O00000o0) r0;	 Catch:{ all -> 0x0095 }
        r1 = 0;
        if (r0 == 0) goto L_0x0093;
    L_0x0012:
        r2 = r0.O00000oO;	 Catch:{ all -> 0x0095 }
        if (r2 == 0) goto L_0x001a;
    L_0x0018:
        goto L_0x0093;
    L_0x001a:
        r2 = r9.O0000Oo0;	 Catch:{ all -> 0x0095 }
        if (r1 >= r2) goto L_0x005c;
    L_0x001e:
        r2 = r0.O000000o(r1);	 Catch:{ all -> 0x0095 }
        r3 = r2.exists();	 Catch:{ all -> 0x0095 }
        if (r3 == 0) goto L_0x0045;
    L_0x0028:
        r3 = r2.delete();	 Catch:{ all -> 0x0095 }
        if (r3 != 0) goto L_0x0045;
    L_0x002e:
        r10 = new java.io.IOException;	 Catch:{ all -> 0x0095 }
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0095 }
        r0.<init>();	 Catch:{ all -> 0x0095 }
        r1 = "failed to delete ";
        r0.append(r1);	 Catch:{ all -> 0x0095 }
        r0.append(r2);	 Catch:{ all -> 0x0095 }
        r0 = r0.toString();	 Catch:{ all -> 0x0095 }
        r10.<init>(r0);	 Catch:{ all -> 0x0095 }
        throw r10;	 Catch:{ all -> 0x0095 }
    L_0x0045:
        r2 = r9.O0000Oo;	 Catch:{ all -> 0x0095 }
        r4 = r0.O00000o0;	 Catch:{ all -> 0x0095 }
        r5 = r4[r1];	 Catch:{ all -> 0x0095 }
        r7 = r2 - r5;
        r9.O0000Oo = r7;	 Catch:{ all -> 0x0095 }
        r2 = r0.O00000o0;	 Catch:{ all -> 0x0095 }
        r3 = 0;
        r2[r1] = r3;	 Catch:{ all -> 0x0095 }
        r1 = r1 + 1;
        goto L_0x001a;
    L_0x005c:
        r0 = r9.O0000o0;	 Catch:{ all -> 0x0095 }
        r1 = 1;
        r0 = r0 + r1;
        r9.O0000o0 = r0;	 Catch:{ all -> 0x0095 }
        r0 = r9.O0000OoO;	 Catch:{ all -> 0x0095 }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0095 }
        r2.<init>();	 Catch:{ all -> 0x0095 }
        r3 = "REMOVE ";
        r2.append(r3);	 Catch:{ all -> 0x0095 }
        r2.append(r10);	 Catch:{ all -> 0x0095 }
        r3 = 10;
        r2.append(r3);	 Catch:{ all -> 0x0095 }
        r2 = r2.toString();	 Catch:{ all -> 0x0095 }
        r0.append(r2);	 Catch:{ all -> 0x0095 }
        r0 = r9.O0000o00;	 Catch:{ all -> 0x0095 }
        r0.remove(r10);	 Catch:{ all -> 0x0095 }
        r10 = r9.O0000OoO();	 Catch:{ all -> 0x0095 }
        if (r10 == 0) goto L_0x0091;
    L_0x0088:
        r10 = O00000Oo();	 Catch:{ all -> 0x0095 }
        r0 = r9.O0000oO0;	 Catch:{ all -> 0x0095 }
        r10.submit(r0);	 Catch:{ all -> 0x0095 }
    L_0x0091:
        monitor-exit(r9);
        return r1;
    L_0x0093:
        monitor-exit(r9);
        return r1;
    L_0x0095:
        r10 = move-exception;
        monitor-exit(r9);
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.oOo0o0oO.O00000o0(java.lang.String):boolean");
    }

    public synchronized void O00000oO() throws IOException {
        O0000Ooo();
        O0000o00();
        this.O0000OoO.flush();
    }

    public void O00000oo() throws IOException {
        close();
        oOo00o00.O000000o(this.O00000o0);
    }

    public synchronized void close() throws IOException {
        if (this.O0000OoO != null) {
            Iterator it = new ArrayList(this.O0000o00.values()).iterator();
            while (it.hasNext()) {
                O00000o0 o00000o0 = (O00000o0) it.next();
                if (o00000o0.O00000oO != null) {
                    o00000o0.O00000oO.O00000Oo();
                }
            }
            O0000o00();
            this.O0000OoO.close();
            this.O0000OoO = null;
        }
    }
}
