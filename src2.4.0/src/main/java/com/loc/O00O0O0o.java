package com.loc;

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
public final class O00O0O0o implements Closeable {
    static final Pattern O000000o = Pattern.compile("[a-z0-9_-]{1,120}");
    static ThreadPoolExecutor O00000Oo = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), O0000o);
    private static final ThreadFactory O0000o = new ThreadFactory() {
        private final AtomicInteger O000000o = new AtomicInteger(1);

        public final Thread newThread(Runnable runnable) {
            StringBuilder stringBuilder = new StringBuilder("disklrucache#");
            stringBuilder.append(this.O000000o.getAndIncrement());
            return new Thread(runnable, stringBuilder.toString());
        }
    };
    private static final OutputStream O0000oO = new OutputStream() {
        public final void write(int i) throws IOException {
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
    private O00O0OOo O0000o0O;
    private long O0000o0o = 0;
    private final Callable<Void> O0000oO0 = new Callable<Void>() {
        /* JADX WARNING: Missing block: B:11:0x0026, code skipped:
            return null;
     */
        private java.lang.Void O000000o() throws java.lang.Exception {
            /*
            r3 = this;
            r0 = com.loc.O00O0O0o.this;
            monitor-enter(r0);
            r1 = com.loc.O00O0O0o.this;	 Catch:{ all -> 0x0027 }
            r1 = r1.O0000OoO;	 Catch:{ all -> 0x0027 }
            r2 = 0;
            if (r1 != 0) goto L_0x000e;
        L_0x000c:
            monitor-exit(r0);	 Catch:{ all -> 0x0027 }
            return r2;
        L_0x000e:
            r1 = com.loc.O00O0O0o.this;	 Catch:{ all -> 0x0027 }
            r1.O0000Ooo();	 Catch:{ all -> 0x0027 }
            r1 = com.loc.O00O0O0o.this;	 Catch:{ all -> 0x0027 }
            r1 = r1.O0000Oo();	 Catch:{ all -> 0x0027 }
            if (r1 == 0) goto L_0x0025;
        L_0x001b:
            r1 = com.loc.O00O0O0o.this;	 Catch:{ all -> 0x0027 }
            r1.O0000Oo0();	 Catch:{ all -> 0x0027 }
            r1 = com.loc.O00O0O0o.this;	 Catch:{ all -> 0x0027 }
            r1.O0000o0 = 0;	 Catch:{ all -> 0x0027 }
        L_0x0025:
            monitor-exit(r0);	 Catch:{ all -> 0x0027 }
            return r2;
        L_0x0027:
            r1 = move-exception;
            monitor-exit(r0);
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.loc.O00O0O0o$AnonymousClass2.O000000o():java.lang.Void");
        }

        public final /* synthetic */ Object call() throws Exception {
            return O000000o();
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

            /* synthetic */ O000000o(O000000o o000000o, OutputStream outputStream, byte b) {
                this(outputStream);
            }

            public final void close() {
                try {
                    this.out.close();
                } catch (IOException unused) {
                    O000000o.this.O00000o = true;
                }
            }

            public final void flush() {
                try {
                    this.out.flush();
                } catch (IOException unused) {
                    O000000o.this.O00000o = true;
                }
            }

            public final void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException unused) {
                    O000000o.this.O00000o = true;
                }
            }

            public final void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException unused) {
                    O000000o.this.O00000o = true;
                }
            }
        }

        private O000000o(O00000o0 o00000o0) {
            this.O00000Oo = o00000o0;
            this.O00000o0 = o00000o0.O00000o ? null : new boolean[O00O0O0o.this.O0000Oo0];
        }

        /* synthetic */ O000000o(O00O0O0o o00O0O0o, O00000o0 o00000o0, byte b) {
            this(o00000o0);
        }

        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004d */
        /* JADX WARNING: Can't wrap try/catch for region: R(12:11|(1:13)|14|15|16|17|18|19|20|21|22|23) */
        public final java.io.OutputStream O000000o() throws java.io.IOException {
            /*
            r4 = this;
            r0 = com.loc.O00O0O0o.this;
            r0 = r0.O0000Oo0;
            if (r0 > 0) goto L_0x0022;
        L_0x0008:
            r0 = new java.lang.IllegalArgumentException;
            r1 = new java.lang.StringBuilder;
            r2 = "Expected index 0 to be greater than 0 and less than the maximum value count of ";
            r1.<init>(r2);
            r2 = com.loc.O00O0O0o.this;
            r2 = r2.O0000Oo0;
            r1.append(r2);
            r1 = r1.toString();
            r0.<init>(r1);
            throw r0;
        L_0x0022:
            r0 = com.loc.O00O0O0o.this;
            monitor-enter(r0);
            r1 = r4.O00000Oo;	 Catch:{ all -> 0x0068 }
            r1 = r1.O00000oO;	 Catch:{ all -> 0x0068 }
            if (r1 == r4) goto L_0x0033;
        L_0x002d:
            r1 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x0068 }
            r1.<init>();	 Catch:{ all -> 0x0068 }
            throw r1;	 Catch:{ all -> 0x0068 }
        L_0x0033:
            r1 = r4.O00000Oo;	 Catch:{ all -> 0x0068 }
            r1 = r1.O00000o;	 Catch:{ all -> 0x0068 }
            r2 = 0;
            if (r1 != 0) goto L_0x0041;
        L_0x003c:
            r1 = r4.O00000o0;	 Catch:{ all -> 0x0068 }
            r3 = 1;
            r1[r2] = r3;	 Catch:{ all -> 0x0068 }
        L_0x0041:
            r1 = r4.O00000Oo;	 Catch:{ all -> 0x0068 }
            r1 = r1.O00000Oo(r2);	 Catch:{ all -> 0x0068 }
            r3 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x004d }
            r3.<init>(r1);	 Catch:{ FileNotFoundException -> 0x004d }
            goto L_0x005b;
        L_0x004d:
            r3 = com.loc.O00O0O0o.this;	 Catch:{ all -> 0x0068 }
            r3 = r3.O00000o0;	 Catch:{ all -> 0x0068 }
            r3.mkdirs();	 Catch:{ all -> 0x0068 }
            r3 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x0062 }
            r3.<init>(r1);	 Catch:{ FileNotFoundException -> 0x0062 }
        L_0x005b:
            r1 = new com.loc.O00O0O0o$O000000o$O000000o;	 Catch:{ all -> 0x0068 }
            r1.<init>(r4, r3, r2);	 Catch:{ all -> 0x0068 }
            monitor-exit(r0);	 Catch:{ all -> 0x0068 }
            return r1;
        L_0x0062:
            r1 = com.loc.O00O0O0o.O0000oO;	 Catch:{ all -> 0x0068 }
            monitor-exit(r0);	 Catch:{ all -> 0x0068 }
            return r1;
        L_0x0068:
            r1 = move-exception;
            monitor-exit(r0);
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.loc.O00O0O0o$O000000o.O000000o():java.io.OutputStream");
        }

        public final void O00000Oo() throws IOException {
            if (this.O00000o) {
                O00O0O0o.this.O000000o(this, false);
                O00O0O0o.this.O00000o0(this.O00000Oo.O00000Oo);
            } else {
                O00O0O0o.this.O000000o(this, true);
            }
            this.O00000oO = true;
        }

        public final void O00000o0() throws IOException {
            O00O0O0o.this.O000000o(this, false);
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

        /* synthetic */ O00000Oo(O00O0O0o o00O0O0o, String str, long j, InputStream[] inputStreamArr, long[] jArr, byte b) {
            this(str, j, inputStreamArr, jArr);
        }

        public final InputStream O000000o() {
            return this.O00000o[0];
        }

        public final void close() {
            for (Closeable O000000o : this.O00000o) {
                O00O0o00.O000000o(O000000o);
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
            this.O00000o0 = new long[O00O0O0o.this.O0000Oo0];
        }

        /* synthetic */ O00000o0(O00O0O0o o00O0O0o, String str, byte b) {
            this(str);
        }

        private static IOException O000000o(String[] strArr) throws IOException {
            StringBuilder stringBuilder = new StringBuilder("unexpected journal line: ");
            stringBuilder.append(Arrays.toString(strArr));
            throw new IOException(stringBuilder.toString());
        }

        public final File O000000o(int i) {
            File O0000O0o = O00O0O0o.this.O00000o0;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.O00000Oo);
            stringBuilder.append(".");
            stringBuilder.append(i);
            return new File(O0000O0o, stringBuilder.toString());
        }

        public final String O000000o() throws IOException {
            StringBuilder stringBuilder = new StringBuilder();
            for (long j : this.O00000o0) {
                stringBuilder.append(' ');
                stringBuilder.append(j);
            }
            return stringBuilder.toString();
        }

        public final File O00000Oo(int i) {
            File O0000O0o = O00O0O0o.this.O00000o0;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.O00000Oo);
            stringBuilder.append(".");
            stringBuilder.append(i);
            stringBuilder.append(".tmp");
            return new File(O0000O0o, stringBuilder.toString());
        }
    }

    private O00O0O0o(File file, long j) {
        this.O00000o0 = file;
        this.O0000O0o = 1;
        this.O00000o = new File(file, "journal");
        this.O00000oO = new File(file, "journal.tmp");
        this.O00000oo = new File(file, "journal.bkp");
        this.O0000Oo0 = 1;
        this.O0000OOo = j;
    }

    public static O00O0O0o O000000o(File file, long j) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                O000000o(file2, file3, false);
            }
        }
        O00O0O0o o00O0O0o = new O00O0O0o(file, j);
        if (o00O0O0o.O00000o.exists()) {
            try {
                o00O0O0o.O0000O0o();
                o00O0O0o.O0000OOo();
                o00O0O0o.O0000OoO = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(o00O0O0o.O00000o, true), O00O0o00.O000000o));
                return o00O0O0o;
            } catch (Throwable unused) {
                o00O0O0o.O00000o();
            }
        }
        file.mkdirs();
        o00O0O0o = new O00O0O0o(file, j);
        o00O0O0o.O0000Oo0();
        return o00O0O0o;
    }

    public static void O000000o() {
        if (O00000Oo != null && !O00000Oo.isShutdown()) {
            O00000Oo.shutdown();
        }
    }

    /* JADX WARNING: Missing block: B:45:0x010b, code skipped:
            return;
     */
    private synchronized void O000000o(com.loc.O00O0O0o.O000000o r12, boolean r13) throws java.io.IOException {
        /*
        r11 = this;
        monitor-enter(r11);
        r0 = r12.O00000Oo;	 Catch:{ all -> 0x010c }
        r1 = r0.O00000oO;	 Catch:{ all -> 0x010c }
        if (r1 == r12) goto L_0x0011;
    L_0x000b:
        r12 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x010c }
        r12.<init>();	 Catch:{ all -> 0x010c }
        throw r12;	 Catch:{ all -> 0x010c }
    L_0x0011:
        r1 = 0;
        if (r13 == 0) goto L_0x0050;
    L_0x0014:
        r2 = r0.O00000o;	 Catch:{ all -> 0x010c }
        if (r2 != 0) goto L_0x0050;
    L_0x001a:
        r2 = r1;
    L_0x001b:
        r3 = r11.O0000Oo0;	 Catch:{ all -> 0x010c }
        if (r2 >= r3) goto L_0x0050;
    L_0x001f:
        r3 = r12.O00000o0;	 Catch:{ all -> 0x010c }
        r3 = r3[r2];	 Catch:{ all -> 0x010c }
        if (r3 != 0) goto L_0x003e;
    L_0x0027:
        r12.O00000o0();	 Catch:{ all -> 0x010c }
        r12 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x010c }
        r13 = new java.lang.StringBuilder;	 Catch:{ all -> 0x010c }
        r0 = "Newly created entry didn't create value for index ";
        r13.<init>(r0);	 Catch:{ all -> 0x010c }
        r13.append(r2);	 Catch:{ all -> 0x010c }
        r13 = r13.toString();	 Catch:{ all -> 0x010c }
        r12.<init>(r13);	 Catch:{ all -> 0x010c }
        throw r12;	 Catch:{ all -> 0x010c }
    L_0x003e:
        r3 = r0.O00000Oo(r2);	 Catch:{ all -> 0x010c }
        r3 = r3.exists();	 Catch:{ all -> 0x010c }
        if (r3 != 0) goto L_0x004d;
    L_0x0048:
        r12.O00000o0();	 Catch:{ all -> 0x010c }
        monitor-exit(r11);
        return;
    L_0x004d:
        r2 = r2 + 1;
        goto L_0x001b;
    L_0x0050:
        r12 = r11.O0000Oo0;	 Catch:{ all -> 0x010c }
        if (r1 >= r12) goto L_0x0086;
    L_0x0054:
        r12 = r0.O00000Oo(r1);	 Catch:{ all -> 0x010c }
        if (r13 == 0) goto L_0x0080;
    L_0x005a:
        r2 = r12.exists();	 Catch:{ all -> 0x010c }
        if (r2 == 0) goto L_0x0083;
    L_0x0060:
        r2 = r0.O000000o(r1);	 Catch:{ all -> 0x010c }
        r12.renameTo(r2);	 Catch:{ all -> 0x010c }
        r12 = r0.O00000o0;	 Catch:{ all -> 0x010c }
        r3 = r12[r1];	 Catch:{ all -> 0x010c }
        r5 = r2.length();	 Catch:{ all -> 0x010c }
        r12 = r0.O00000o0;	 Catch:{ all -> 0x010c }
        r12[r1] = r5;	 Catch:{ all -> 0x010c }
        r7 = r11.O0000Oo;	 Catch:{ all -> 0x010c }
        r9 = r7 - r3;
        r2 = r9 + r5;
        r11.O0000Oo = r2;	 Catch:{ all -> 0x010c }
        goto L_0x0083;
    L_0x0080:
        O000000o(r12);	 Catch:{ all -> 0x010c }
    L_0x0083:
        r1 = r1 + 1;
        goto L_0x0050;
    L_0x0086:
        r12 = r11.O0000o0;	 Catch:{ all -> 0x010c }
        r12 = r12 + 1;
        r11.O0000o0 = r12;	 Catch:{ all -> 0x010c }
        r12 = 0;
        r0.O00000oO = r12;	 Catch:{ all -> 0x010c }
        r12 = r0.O00000o;	 Catch:{ all -> 0x010c }
        r12 = r12 | r13;
        r1 = 10;
        if (r12 == 0) goto L_0x00cb;
    L_0x0099:
        r0.O00000o = true;	 Catch:{ all -> 0x010c }
        r12 = r11.O0000OoO;	 Catch:{ all -> 0x010c }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x010c }
        r3 = "CLEAN ";
        r2.<init>(r3);	 Catch:{ all -> 0x010c }
        r3 = r0.O00000Oo;	 Catch:{ all -> 0x010c }
        r2.append(r3);	 Catch:{ all -> 0x010c }
        r3 = r0.O000000o();	 Catch:{ all -> 0x010c }
        r2.append(r3);	 Catch:{ all -> 0x010c }
        r2.append(r1);	 Catch:{ all -> 0x010c }
        r1 = r2.toString();	 Catch:{ all -> 0x010c }
        r12.write(r1);	 Catch:{ all -> 0x010c }
        if (r13 == 0) goto L_0x00ee;
    L_0x00bf:
        r12 = r11.O0000o0o;	 Catch:{ all -> 0x010c }
        r1 = 1;
        r3 = r12 + r1;
        r11.O0000o0o = r3;	 Catch:{ all -> 0x010c }
        r0.O00000oo = r12;	 Catch:{ all -> 0x010c }
        goto L_0x00ee;
    L_0x00cb:
        r12 = r11.O0000o00;	 Catch:{ all -> 0x010c }
        r13 = r0.O00000Oo;	 Catch:{ all -> 0x010c }
        r12.remove(r13);	 Catch:{ all -> 0x010c }
        r12 = r11.O0000OoO;	 Catch:{ all -> 0x010c }
        r13 = new java.lang.StringBuilder;	 Catch:{ all -> 0x010c }
        r2 = "REMOVE ";
        r13.<init>(r2);	 Catch:{ all -> 0x010c }
        r0 = r0.O00000Oo;	 Catch:{ all -> 0x010c }
        r13.append(r0);	 Catch:{ all -> 0x010c }
        r13.append(r1);	 Catch:{ all -> 0x010c }
        r13 = r13.toString();	 Catch:{ all -> 0x010c }
        r12.write(r13);	 Catch:{ all -> 0x010c }
    L_0x00ee:
        r12 = r11.O0000OoO;	 Catch:{ all -> 0x010c }
        r12.flush();	 Catch:{ all -> 0x010c }
        r12 = r11.O0000Oo;	 Catch:{ all -> 0x010c }
        r0 = r11.O0000OOo;	 Catch:{ all -> 0x010c }
        r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1));
        if (r2 > 0) goto L_0x0101;
    L_0x00fb:
        r12 = r11.O0000Oo();	 Catch:{ all -> 0x010c }
        if (r12 == 0) goto L_0x010a;
    L_0x0101:
        r12 = O00000oo();	 Catch:{ all -> 0x010c }
        r13 = r11.O0000oO0;	 Catch:{ all -> 0x010c }
        r12.submit(r13);	 Catch:{ all -> 0x010c }
    L_0x010a:
        monitor-exit(r11);
        return;
    L_0x010c:
        r12 = move-exception;
        monitor-exit(r11);
        throw r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O00O0O0o.O000000o(com.loc.O00O0O0o$O000000o, boolean):void");
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

    private synchronized O000000o O00000o(String str) throws IOException {
        O0000OoO();
        O00000oO(str);
        O00000o0 o00000o0 = (O00000o0) this.O0000o00.get(str);
        if (o00000o0 == null) {
            o00000o0 = new O00000o0(this, str, (byte) 0);
            this.O0000o00.put(str, o00000o0);
        } else if (o00000o0.O00000oO != null) {
            return null;
        }
        O000000o o000000o = new O000000o(this, o00000o0, (byte) 0);
        o00000o0.O00000oO = o000000o;
        Writer writer = this.O0000OoO;
        StringBuilder stringBuilder = new StringBuilder("DIRTY ");
        stringBuilder.append(str);
        stringBuilder.append(10);
        writer.write(stringBuilder.toString());
        this.O0000OoO.flush();
        return o000000o;
    }

    private static void O00000oO(String str) {
        if (!O000000o.matcher(str).matches()) {
            StringBuilder stringBuilder = new StringBuilder("keys must match regex [a-z0-9_-]{1,120}: \"");
            stringBuilder.append(str);
            stringBuilder.append("\"");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    private static ThreadPoolExecutor O00000oo() {
        try {
            if (O00000Oo == null || O00000Oo.isShutdown()) {
                O00000Oo = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(256), O0000o);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return O00000Oo;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:13:0x0056=Splitter:B:13:0x0056, B:52:0x0118=Splitter:B:52:0x0118} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x010b */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:49|50|65|51) */
    /* JADX WARNING: Missing block: B:50:?, code skipped:
            r10.O0000o0 = r2 - r10.O0000o00.size();
     */
    /* JADX WARNING: Missing block: B:51:0x0117, code skipped:
            return;
     */
    private void O0000O0o() throws java.io.IOException {
        /*
        r10 = this;
        r0 = new com.loc.O00O0Oo0;
        r1 = new java.io.FileInputStream;
        r2 = r10.O00000o;
        r1.<init>(r2);
        r2 = com.loc.O00O0o00.O000000o;
        r0.<init>(r1, r2);
        r1 = r0.O000000o();	 Catch:{ all -> 0x0149 }
        r2 = r0.O000000o();	 Catch:{ all -> 0x0149 }
        r3 = r0.O000000o();	 Catch:{ all -> 0x0149 }
        r4 = r0.O000000o();	 Catch:{ all -> 0x0149 }
        r5 = r0.O000000o();	 Catch:{ all -> 0x0149 }
        r6 = "libcore.io.DiskLruCache";
        r6 = r6.equals(r1);	 Catch:{ all -> 0x0149 }
        if (r6 == 0) goto L_0x0118;
    L_0x002a:
        r6 = "1";
        r6 = r6.equals(r2);	 Catch:{ all -> 0x0149 }
        if (r6 == 0) goto L_0x0118;
    L_0x0032:
        r6 = r10.O0000O0o;	 Catch:{ all -> 0x0149 }
        r6 = java.lang.Integer.toString(r6);	 Catch:{ all -> 0x0149 }
        r3 = r6.equals(r3);	 Catch:{ all -> 0x0149 }
        if (r3 == 0) goto L_0x0118;
    L_0x003e:
        r3 = r10.O0000Oo0;	 Catch:{ all -> 0x0149 }
        r3 = java.lang.Integer.toString(r3);	 Catch:{ all -> 0x0149 }
        r3 = r3.equals(r4);	 Catch:{ all -> 0x0149 }
        if (r3 == 0) goto L_0x0118;
    L_0x004a:
        r3 = "";
        r3 = r3.equals(r5);	 Catch:{ all -> 0x0149 }
        if (r3 != 0) goto L_0x0054;
    L_0x0052:
        goto L_0x0118;
    L_0x0054:
        r1 = 0;
        r2 = r1;
    L_0x0056:
        r3 = r0.O000000o();	 Catch:{ EOFException -> 0x010b }
        r4 = 32;
        r5 = r3.indexOf(r4);	 Catch:{ EOFException -> 0x010b }
        r6 = -1;
        if (r5 != r6) goto L_0x0077;
    L_0x0063:
        r1 = new java.io.IOException;	 Catch:{ EOFException -> 0x010b }
        r4 = new java.lang.StringBuilder;	 Catch:{ EOFException -> 0x010b }
        r5 = "unexpected journal line: ";
        r4.<init>(r5);	 Catch:{ EOFException -> 0x010b }
        r4.append(r3);	 Catch:{ EOFException -> 0x010b }
        r3 = r4.toString();	 Catch:{ EOFException -> 0x010b }
        r1.<init>(r3);	 Catch:{ EOFException -> 0x010b }
        throw r1;	 Catch:{ EOFException -> 0x010b }
    L_0x0077:
        r7 = r5 + 1;
        r4 = r3.indexOf(r4, r7);	 Catch:{ EOFException -> 0x010b }
        if (r4 != r6) goto L_0x0094;
    L_0x007f:
        r7 = r3.substring(r7);	 Catch:{ EOFException -> 0x010b }
        r8 = 6;
        if (r5 != r8) goto L_0x0098;
    L_0x0086:
        r8 = "REMOVE";
        r8 = r3.startsWith(r8);	 Catch:{ EOFException -> 0x010b }
        if (r8 == 0) goto L_0x0098;
    L_0x008e:
        r3 = r10.O0000o00;	 Catch:{ EOFException -> 0x010b }
        r3.remove(r7);	 Catch:{ EOFException -> 0x010b }
        goto L_0x00f3;
    L_0x0094:
        r7 = r3.substring(r7, r4);	 Catch:{ EOFException -> 0x010b }
    L_0x0098:
        r8 = r10.O0000o00;	 Catch:{ EOFException -> 0x010b }
        r8 = r8.get(r7);	 Catch:{ EOFException -> 0x010b }
        r8 = (com.loc.O00O0O0o.O00000o0) r8;	 Catch:{ EOFException -> 0x010b }
        if (r8 != 0) goto L_0x00ac;
    L_0x00a2:
        r8 = new com.loc.O00O0O0o$O00000o0;	 Catch:{ EOFException -> 0x010b }
        r8.<init>(r10, r7, r1);	 Catch:{ EOFException -> 0x010b }
        r9 = r10.O0000o00;	 Catch:{ EOFException -> 0x010b }
        r9.put(r7, r8);	 Catch:{ EOFException -> 0x010b }
    L_0x00ac:
        r7 = 5;
        if (r4 == r6) goto L_0x00d0;
    L_0x00af:
        if (r5 != r7) goto L_0x00d0;
    L_0x00b1:
        r9 = "CLEAN";
        r9 = r3.startsWith(r9);	 Catch:{ EOFException -> 0x010b }
        if (r9 == 0) goto L_0x00d0;
    L_0x00b9:
        r4 = r4 + 1;
        r3 = r3.substring(r4);	 Catch:{ EOFException -> 0x010b }
        r4 = " ";
        r3 = r3.split(r4);	 Catch:{ EOFException -> 0x010b }
        r8.O00000o = true;	 Catch:{ EOFException -> 0x010b }
        r4 = 0;
        r8.O00000oO = r4;	 Catch:{ EOFException -> 0x010b }
        com.loc.O00O0O0o.O00000o0.O000000o(r8, r3);	 Catch:{ EOFException -> 0x010b }
        goto L_0x00f3;
    L_0x00d0:
        if (r4 != r6) goto L_0x00e5;
    L_0x00d2:
        if (r5 != r7) goto L_0x00e5;
    L_0x00d4:
        r7 = "DIRTY";
        r7 = r3.startsWith(r7);	 Catch:{ EOFException -> 0x010b }
        if (r7 == 0) goto L_0x00e5;
    L_0x00dc:
        r3 = new com.loc.O00O0O0o$O000000o;	 Catch:{ EOFException -> 0x010b }
        r3.<init>(r10, r8, r1);	 Catch:{ EOFException -> 0x010b }
        r8.O00000oO = r3;	 Catch:{ EOFException -> 0x010b }
        goto L_0x00f3;
    L_0x00e5:
        if (r4 != r6) goto L_0x00f7;
    L_0x00e7:
        r4 = 4;
        if (r5 != r4) goto L_0x00f7;
    L_0x00ea:
        r4 = "READ";
        r4 = r3.startsWith(r4);	 Catch:{ EOFException -> 0x010b }
        if (r4 != 0) goto L_0x00f3;
    L_0x00f2:
        goto L_0x00f7;
    L_0x00f3:
        r2 = r2 + 1;
        goto L_0x0056;
    L_0x00f7:
        r1 = new java.io.IOException;	 Catch:{ EOFException -> 0x010b }
        r4 = new java.lang.StringBuilder;	 Catch:{ EOFException -> 0x010b }
        r5 = "unexpected journal line: ";
        r4.<init>(r5);	 Catch:{ EOFException -> 0x010b }
        r4.append(r3);	 Catch:{ EOFException -> 0x010b }
        r3 = r4.toString();	 Catch:{ EOFException -> 0x010b }
        r1.<init>(r3);	 Catch:{ EOFException -> 0x010b }
        throw r1;	 Catch:{ EOFException -> 0x010b }
    L_0x010b:
        r1 = r10.O0000o00;	 Catch:{ all -> 0x0149 }
        r1 = r1.size();	 Catch:{ all -> 0x0149 }
        r2 = r2 - r1;
        r10.O0000o0 = r2;	 Catch:{ all -> 0x0149 }
        com.loc.O00O0o00.O000000o(r0);
        return;
    L_0x0118:
        r3 = new java.io.IOException;	 Catch:{ all -> 0x0149 }
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0149 }
        r7 = "unexpected journal header: [";
        r6.<init>(r7);	 Catch:{ all -> 0x0149 }
        r6.append(r1);	 Catch:{ all -> 0x0149 }
        r1 = ", ";
        r6.append(r1);	 Catch:{ all -> 0x0149 }
        r6.append(r2);	 Catch:{ all -> 0x0149 }
        r1 = ", ";
        r6.append(r1);	 Catch:{ all -> 0x0149 }
        r6.append(r4);	 Catch:{ all -> 0x0149 }
        r1 = ", ";
        r6.append(r1);	 Catch:{ all -> 0x0149 }
        r6.append(r5);	 Catch:{ all -> 0x0149 }
        r1 = "]";
        r6.append(r1);	 Catch:{ all -> 0x0149 }
        r1 = r6.toString();	 Catch:{ all -> 0x0149 }
        r3.<init>(r1);	 Catch:{ all -> 0x0149 }
        throw r3;	 Catch:{ all -> 0x0149 }
    L_0x0149:
        r1 = move-exception;
        com.loc.O00O0o00.O000000o(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O00O0O0o.O0000O0o():void");
    }

    private void O0000OOo() throws IOException {
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

    private boolean O0000Oo() {
        return this.O0000o0 >= 2000 && this.O0000o0 >= this.O0000o00.size();
    }

    private synchronized void O0000Oo0() throws IOException {
        if (this.O0000OoO != null) {
            this.O0000OoO.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.O00000oO), O00O0o00.O000000o));
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
                String stringBuilder;
                StringBuilder stringBuilder2;
                if (o00000o0.O00000oO != null) {
                    stringBuilder2 = new StringBuilder("DIRTY ");
                    stringBuilder2.append(o00000o0.O00000Oo);
                    stringBuilder2.append(10);
                    stringBuilder = stringBuilder2.toString();
                } else {
                    stringBuilder2 = new StringBuilder("CLEAN ");
                    stringBuilder2.append(o00000o0.O00000Oo);
                    stringBuilder2.append(o00000o0.O000000o());
                    stringBuilder2.append(10);
                    stringBuilder = stringBuilder2.toString();
                }
                bufferedWriter.write(stringBuilder);
            }
            if (this.O00000o.exists()) {
                O000000o(this.O00000o, this.O00000oo, true);
            }
            O000000o(this.O00000oO, this.O00000o, false);
            this.O00000oo.delete();
            this.O0000OoO = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.O00000o, true), O00O0o00.O000000o));
        } finally {
            bufferedWriter.close();
        }
    }

    private void O0000OoO() {
        if (this.O0000OoO == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private void O0000Ooo() throws IOException {
        while (true) {
            if (this.O0000Oo > this.O0000OOo || this.O0000o00.size() > this.O0000Ooo) {
                O00000o0((String) ((Entry) this.O0000o00.entrySet().iterator().next()).getKey());
                if (this.O0000o0O != null) {
                    O00O0OOo o00O0OOo = this.O0000o0O;
                }
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0074 */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:32|33|28|27) */
    /* JADX WARNING: Missing block: B:21:?, code skipped:
            r11.O0000o0++;
            r1 = r11.O0000OoO;
            r2 = new java.lang.StringBuilder("READ ");
            r2.append(r12);
            r2.append(10);
            r1.append(r2.toString());
     */
    /* JADX WARNING: Missing block: B:22:0x0056, code skipped:
            if (O0000Oo() == false) goto L_0x0061;
     */
    /* JADX WARNING: Missing block: B:23:0x0058, code skipped:
            O00000oo().submit(r11.O0000oO0);
     */
    /* JADX WARNING: Missing block: B:26:0x0073, code skipped:
            return new com.loc.O00O0O0o.O00000Oo(r11, r12, com.loc.O00O0O0o.O00000o0.O00000oo(r0), r8, com.loc.O00O0O0o.O00000o0.O00000o0(r0), (byte) 0);
     */
    /* JADX WARNING: Missing block: B:35:0x0085, code skipped:
            return null;
     */
    public final synchronized com.loc.O00O0O0o.O00000Oo O000000o(java.lang.String r12) throws java.io.IOException {
        /*
        r11 = this;
        monitor-enter(r11);
        r11.O0000OoO();	 Catch:{ all -> 0x0086 }
        O00000oO(r12);	 Catch:{ all -> 0x0086 }
        r0 = r11.O0000o00;	 Catch:{ all -> 0x0086 }
        r0 = r0.get(r12);	 Catch:{ all -> 0x0086 }
        r0 = (com.loc.O00O0O0o.O00000o0) r0;	 Catch:{ all -> 0x0086 }
        r1 = 0;
        if (r0 != 0) goto L_0x0014;
    L_0x0012:
        monitor-exit(r11);
        return r1;
    L_0x0014:
        r2 = r0.O00000o;	 Catch:{ all -> 0x0086 }
        if (r2 != 0) goto L_0x001c;
    L_0x001a:
        monitor-exit(r11);
        return r1;
    L_0x001c:
        r2 = r11.O0000Oo0;	 Catch:{ all -> 0x0086 }
        r8 = new java.io.InputStream[r2];	 Catch:{ all -> 0x0086 }
        r2 = 0;
        r3 = r2;
    L_0x0022:
        r4 = r11.O0000Oo0;	 Catch:{ FileNotFoundException -> 0x0074 }
        if (r3 >= r4) goto L_0x0034;
    L_0x0026:
        r4 = new java.io.FileInputStream;	 Catch:{ FileNotFoundException -> 0x0074 }
        r5 = r0.O000000o(r3);	 Catch:{ FileNotFoundException -> 0x0074 }
        r4.<init>(r5);	 Catch:{ FileNotFoundException -> 0x0074 }
        r8[r3] = r4;	 Catch:{ FileNotFoundException -> 0x0074 }
        r3 = r3 + 1;
        goto L_0x0022;
    L_0x0034:
        r1 = r11.O0000o0;	 Catch:{ all -> 0x0086 }
        r1 = r1 + 1;
        r11.O0000o0 = r1;	 Catch:{ all -> 0x0086 }
        r1 = r11.O0000OoO;	 Catch:{ all -> 0x0086 }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0086 }
        r3 = "READ ";
        r2.<init>(r3);	 Catch:{ all -> 0x0086 }
        r2.append(r12);	 Catch:{ all -> 0x0086 }
        r3 = 10;
        r2.append(r3);	 Catch:{ all -> 0x0086 }
        r2 = r2.toString();	 Catch:{ all -> 0x0086 }
        r1.append(r2);	 Catch:{ all -> 0x0086 }
        r1 = r11.O0000Oo();	 Catch:{ all -> 0x0086 }
        if (r1 == 0) goto L_0x0061;
    L_0x0058:
        r1 = O00000oo();	 Catch:{ all -> 0x0086 }
        r2 = r11.O0000oO0;	 Catch:{ all -> 0x0086 }
        r1.submit(r2);	 Catch:{ all -> 0x0086 }
    L_0x0061:
        r1 = new com.loc.O00O0O0o$O00000Oo;	 Catch:{ all -> 0x0086 }
        r6 = r0.O00000oo;	 Catch:{ all -> 0x0086 }
        r9 = r0.O00000o0;	 Catch:{ all -> 0x0086 }
        r10 = 0;
        r3 = r1;
        r4 = r11;
        r5 = r12;
        r3.<init>(r4, r5, r6, r8, r9, r10);	 Catch:{ all -> 0x0086 }
        monitor-exit(r11);
        return r1;
    L_0x0074:
        r12 = r11.O0000Oo0;	 Catch:{ all -> 0x0086 }
        if (r2 >= r12) goto L_0x0084;
    L_0x0078:
        r12 = r8[r2];	 Catch:{ all -> 0x0086 }
        if (r12 == 0) goto L_0x0084;
    L_0x007c:
        r12 = r8[r2];	 Catch:{ all -> 0x0086 }
        com.loc.O00O0o00.O000000o(r12);	 Catch:{ all -> 0x0086 }
        r2 = r2 + 1;
        goto L_0x0074;
    L_0x0084:
        monitor-exit(r11);
        return r1;
    L_0x0086:
        r12 = move-exception;
        monitor-exit(r11);
        throw r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O00O0O0o.O000000o(java.lang.String):com.loc.O00O0O0o$O00000Oo");
    }

    public final void O000000o(int i) {
        if (i < 10) {
            i = 10;
        } else if (i > 10000) {
            i = 10000;
        }
        this.O0000Ooo = i;
    }

    public final O000000o O00000Oo(String str) throws IOException {
        return O00000o(str);
    }

    public final File O00000Oo() {
        return this.O00000o0;
    }

    public final void O00000o() throws IOException {
        close();
        O00O0o00.O000000o(this.O00000o0);
    }

    public final synchronized void O00000o0() throws IOException {
        O0000OoO();
        O0000Ooo();
        this.O0000OoO.flush();
    }

    /* JADX WARNING: Missing block: B:20:0x008b, code skipped:
            return true;
     */
    /* JADX WARNING: Missing block: B:22:0x008d, code skipped:
            return false;
     */
    public final synchronized boolean O00000o0(java.lang.String r10) throws java.io.IOException {
        /*
        r9 = this;
        monitor-enter(r9);
        r9.O0000OoO();	 Catch:{ all -> 0x008e }
        O00000oO(r10);	 Catch:{ all -> 0x008e }
        r0 = r9.O0000o00;	 Catch:{ all -> 0x008e }
        r0 = r0.get(r10);	 Catch:{ all -> 0x008e }
        r0 = (com.loc.O00O0O0o.O00000o0) r0;	 Catch:{ all -> 0x008e }
        r1 = 0;
        if (r0 == 0) goto L_0x008c;
    L_0x0012:
        r2 = r0.O00000oO;	 Catch:{ all -> 0x008e }
        if (r2 == 0) goto L_0x0019;
    L_0x0018:
        goto L_0x008c;
    L_0x0019:
        r2 = r9.O0000Oo0;	 Catch:{ all -> 0x008e }
        if (r1 >= r2) goto L_0x0058;
    L_0x001d:
        r2 = r0.O000000o(r1);	 Catch:{ all -> 0x008e }
        r3 = r2.exists();	 Catch:{ all -> 0x008e }
        if (r3 == 0) goto L_0x0041;
    L_0x0027:
        r3 = r2.delete();	 Catch:{ all -> 0x008e }
        if (r3 != 0) goto L_0x0041;
    L_0x002d:
        r10 = new java.io.IOException;	 Catch:{ all -> 0x008e }
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x008e }
        r1 = "failed to delete ";
        r0.<init>(r1);	 Catch:{ all -> 0x008e }
        r0.append(r2);	 Catch:{ all -> 0x008e }
        r0 = r0.toString();	 Catch:{ all -> 0x008e }
        r10.<init>(r0);	 Catch:{ all -> 0x008e }
        throw r10;	 Catch:{ all -> 0x008e }
    L_0x0041:
        r2 = r9.O0000Oo;	 Catch:{ all -> 0x008e }
        r4 = r0.O00000o0;	 Catch:{ all -> 0x008e }
        r5 = r4[r1];	 Catch:{ all -> 0x008e }
        r7 = r2 - r5;
        r9.O0000Oo = r7;	 Catch:{ all -> 0x008e }
        r2 = r0.O00000o0;	 Catch:{ all -> 0x008e }
        r3 = 0;
        r2[r1] = r3;	 Catch:{ all -> 0x008e }
        r1 = r1 + 1;
        goto L_0x0019;
    L_0x0058:
        r0 = r9.O0000o0;	 Catch:{ all -> 0x008e }
        r1 = 1;
        r0 = r0 + r1;
        r9.O0000o0 = r0;	 Catch:{ all -> 0x008e }
        r0 = r9.O0000OoO;	 Catch:{ all -> 0x008e }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x008e }
        r3 = "REMOVE ";
        r2.<init>(r3);	 Catch:{ all -> 0x008e }
        r2.append(r10);	 Catch:{ all -> 0x008e }
        r3 = 10;
        r2.append(r3);	 Catch:{ all -> 0x008e }
        r2 = r2.toString();	 Catch:{ all -> 0x008e }
        r0.append(r2);	 Catch:{ all -> 0x008e }
        r0 = r9.O0000o00;	 Catch:{ all -> 0x008e }
        r0.remove(r10);	 Catch:{ all -> 0x008e }
        r10 = r9.O0000Oo();	 Catch:{ all -> 0x008e }
        if (r10 == 0) goto L_0x008a;
    L_0x0081:
        r10 = O00000oo();	 Catch:{ all -> 0x008e }
        r0 = r9.O0000oO0;	 Catch:{ all -> 0x008e }
        r10.submit(r0);	 Catch:{ all -> 0x008e }
    L_0x008a:
        monitor-exit(r9);
        return r1;
    L_0x008c:
        monitor-exit(r9);
        return r1;
    L_0x008e:
        r10 = move-exception;
        monitor-exit(r9);
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O00O0O0o.O00000o0(java.lang.String):boolean");
    }

    public final synchronized void close() throws IOException {
        if (this.O0000OoO != null) {
            Iterator it = new ArrayList(this.O0000o00.values()).iterator();
            while (it.hasNext()) {
                O00000o0 o00000o0 = (O00000o0) it.next();
                if (o00000o0.O00000oO != null) {
                    o00000o0.O00000oO.O00000o0();
                }
            }
            O0000Ooo();
            this.O0000OoO.close();
            this.O0000OoO = null;
        }
    }
}
