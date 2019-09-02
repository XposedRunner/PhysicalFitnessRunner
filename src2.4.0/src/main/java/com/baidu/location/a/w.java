package com.baidu.location.a;

import android.location.Location;
import com.baidu.location.e.h;
import com.baidu.location.g.e;
import com.baidu.location.g.i;
import com.baidu.location.g.j;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public class w {
    private static w A = null;
    private static long C = 0;
    private static ArrayList<String> b = new ArrayList();
    private static ArrayList<String> c = new ArrayList();
    private static ArrayList<String> d = new ArrayList();
    private static String e = null;
    private static String f = null;
    private static String g = null;
    private static String h = null;
    private static String i = null;
    private static File j = null;
    private static int k = 8;
    private static int l = 8;
    private static int m = 16;
    private static int n = 1024;
    private static double o = 0.0d;
    private static double p = 0.1d;
    private static double q = 30.0d;
    private static double r = 100.0d;
    private static int s = 0;
    private static int t = 64;
    private static int u = 128;
    private static Location v;
    private static Location w;
    private static Location x;
    private static h y;
    private int B;
    long a;
    private a z;

    private class a extends e {
        boolean a;
        int b;
        int c;
        private ArrayList<String> e;
        private boolean f;

        public a() {
            this.a = false;
            this.b = 0;
            this.c = 0;
            this.e = new ArrayList();
            this.f = true;
            this.k = new HashMap();
        }

        public void a() {
            this.h = j.d();
            if (this.b != 1) {
                this.h = j.f();
            }
            this.i = 2;
            if (this.e != null) {
                for (int i = 0; i < this.e.size(); i++) {
                    Map map;
                    StringBuilder stringBuilder;
                    String str;
                    if (this.b == 1) {
                        map = this.k;
                        stringBuilder = new StringBuilder();
                        str = "cldc[";
                    } else {
                        map = this.k;
                        stringBuilder = new StringBuilder();
                        str = "cltr[";
                    }
                    stringBuilder.append(str);
                    stringBuilder.append(i);
                    stringBuilder.append("]");
                    map.put(stringBuilder.toString(), this.e.get(i));
                }
                this.k.put("trtm", String.format(Locale.CHINA, "%d", new Object[]{Long.valueOf(System.currentTimeMillis())}));
                if (this.b != 1) {
                    this.k.put("qt", "cltrg");
                }
            }
        }

        public void a(boolean z) {
            if (z && this.j != null) {
                if (this.e != null) {
                    this.e.clear();
                }
                try {
                    JSONObject jSONObject = new JSONObject(this.j);
                    if (jSONObject.has("ison") && jSONObject.getInt("ison") == 0) {
                        this.f = false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (this.k != null) {
                this.k.clear();
            }
            this.a = false;
        }

        /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x00a0 */
        /* JADX WARNING: Can't wrap try/catch for region: R(5:67|68|(1:70)|71|72) */
        /* JADX WARNING: Missing block: B:69:0x00a2, code skipped:
            if (r7.e != null) goto L_0x00a4;
     */
        /* JADX WARNING: Missing block: B:70:0x00a4, code skipped:
            r7.e.clear();
     */
        /* JADX WARNING: Missing block: B:72:0x00aa, code skipped:
            return;
     */
        public synchronized void b() {
            /*
            r7 = this;
            monitor-enter(r7);
            r0 = r7.a;	 Catch:{ all -> 0x00ab }
            if (r0 == 0) goto L_0x0007;
        L_0x0005:
            monitor-exit(r7);
            return;
        L_0x0007:
            r0 = p;	 Catch:{ all -> 0x00ab }
            r1 = 4;
            r2 = 1;
            if (r0 <= r1) goto L_0x001a;
        L_0x000d:
            r0 = r7.c;	 Catch:{ all -> 0x00ab }
            r1 = p;	 Catch:{ all -> 0x00ab }
            if (r0 >= r1) goto L_0x001a;
        L_0x0013:
            r0 = r7.c;	 Catch:{ all -> 0x00ab }
            r0 = r0 + r2;
            r7.c = r0;	 Catch:{ all -> 0x00ab }
            monitor-exit(r7);
            return;
        L_0x001a:
            r0 = 0;
            r7.c = r0;	 Catch:{ all -> 0x00ab }
            r7.a = r2;	 Catch:{ all -> 0x00ab }
            r7.b = r0;	 Catch:{ all -> 0x00ab }
            r1 = r7.e;	 Catch:{ Exception -> 0x00a0 }
            if (r1 == 0) goto L_0x002d;
        L_0x0025:
            r1 = r7.e;	 Catch:{ Exception -> 0x00a0 }
            r1 = r1.size();	 Catch:{ Exception -> 0x00a0 }
            if (r1 >= r2) goto L_0x0075;
        L_0x002d:
            r1 = r7.e;	 Catch:{ Exception -> 0x00a0 }
            if (r1 != 0) goto L_0x0038;
        L_0x0031:
            r1 = new java.util.ArrayList;	 Catch:{ Exception -> 0x00a0 }
            r1.<init>();	 Catch:{ Exception -> 0x00a0 }
            r7.e = r1;	 Catch:{ Exception -> 0x00a0 }
        L_0x0038:
            r7.b = r0;	 Catch:{ Exception -> 0x00a0 }
            r1 = r0;
        L_0x003b:
            r3 = r7.b;	 Catch:{ Exception -> 0x00a0 }
            r4 = 2;
            r5 = 0;
            if (r3 >= r4) goto L_0x0046;
        L_0x0041:
            r3 = com.baidu.location.a.w.b();	 Catch:{ Exception -> 0x00a0 }
            goto L_0x0047;
        L_0x0046:
            r3 = r5;
        L_0x0047:
            if (r3 != 0) goto L_0x005a;
        L_0x0049:
            r6 = r7.b;	 Catch:{ Exception -> 0x00a0 }
            if (r6 == r2) goto L_0x005a;
        L_0x004d:
            r6 = r7.f;	 Catch:{ Exception -> 0x00a0 }
            if (r6 == 0) goto L_0x005a;
        L_0x0051:
            r7.b = r4;	 Catch:{ Exception -> 0x00a0 }
            r3 = com.baidu.location.a.g.a();	 Catch:{ Exception -> 0x0058 }
            goto L_0x005c;
        L_0x0058:
            r3 = r5;
            goto L_0x005c;
        L_0x005a:
            r7.b = r2;	 Catch:{ Exception -> 0x00a0 }
        L_0x005c:
            if (r3 != 0) goto L_0x005f;
        L_0x005e:
            goto L_0x0075;
        L_0x005f:
            r4 = "err!";
            r4 = r3.contains(r4);	 Catch:{ Exception -> 0x00a0 }
            if (r4 != 0) goto L_0x003b;
        L_0x0067:
            r4 = r7.e;	 Catch:{ Exception -> 0x00a0 }
            r4.add(r3);	 Catch:{ Exception -> 0x00a0 }
            r3 = r3.length();	 Catch:{ Exception -> 0x00a0 }
            r1 = r1 + r3;
            r3 = com.baidu.location.g.a.i;	 Catch:{ Exception -> 0x00a0 }
            if (r1 < r3) goto L_0x003b;
        L_0x0075:
            r1 = r7.e;	 Catch:{ Exception -> 0x00a0 }
            if (r1 == 0) goto L_0x0093;
        L_0x0079:
            r1 = r7.e;	 Catch:{ Exception -> 0x00a0 }
            r1 = r1.size();	 Catch:{ Exception -> 0x00a0 }
            if (r1 >= r2) goto L_0x0082;
        L_0x0081:
            goto L_0x0093;
        L_0x0082:
            r0 = r7.b;	 Catch:{ all -> 0x00ab }
            if (r0 == r2) goto L_0x008e;
        L_0x0086:
            r0 = com.baidu.location.g.j.f();	 Catch:{ all -> 0x00ab }
        L_0x008a:
            r7.c(r0);	 Catch:{ all -> 0x00ab }
            goto L_0x0091;
        L_0x008e:
            r0 = com.baidu.location.g.j.f;	 Catch:{ all -> 0x00ab }
            goto L_0x008a;
        L_0x0091:
            monitor-exit(r7);
            return;
        L_0x0093:
            r1 = r7.e;	 Catch:{ Exception -> 0x00a0 }
            if (r1 == 0) goto L_0x009c;
        L_0x0097:
            r1 = r7.e;	 Catch:{ Exception -> 0x00a0 }
            r1.clear();	 Catch:{ Exception -> 0x00a0 }
        L_0x009c:
            r7.a = r0;	 Catch:{ Exception -> 0x00a0 }
            monitor-exit(r7);
            return;
        L_0x00a0:
            r0 = r7.e;	 Catch:{ all -> 0x00ab }
            if (r0 == 0) goto L_0x00a9;
        L_0x00a4:
            r0 = r7.e;	 Catch:{ all -> 0x00ab }
            r0.clear();	 Catch:{ all -> 0x00ab }
        L_0x00a9:
            monitor-exit(r7);
            return;
        L_0x00ab:
            r0 = move-exception;
            monitor-exit(r7);
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.a.w$a.b():void");
        }
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i.a);
        stringBuilder.append("/yo.dat");
        e = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(i.a);
        stringBuilder.append("/yoh.dat");
        f = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(i.a);
        stringBuilder.append("/yom.dat");
        g = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(i.a);
        stringBuilder.append("/yol.dat");
        h = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(i.a);
        stringBuilder.append("/yor.dat");
        i = stringBuilder.toString();
    }

    private w() {
        this.z = null;
        this.B = 0;
        this.a = 0;
        this.z = new a();
        this.B = 0;
    }

    private static synchronized int a(List<String> list, int i) {
        Exception exception;
        Exception e;
        Throwable th;
        Throwable th2;
        List<String> list2 = list;
        int i2 = i;
        Class cls = w.class;
        synchronized (cls) {
            if (list2 == null || i2 > 256 || i2 < 0) {
                return -1;
            }
            Class cls2;
            try {
                if (j == null) {
                    try {
                        j = new File(e);
                        if (!j.exists()) {
                            j = null;
                            return -2;
                        }
                    } catch (Exception e2) {
                        exception = e2;
                        cls2 = cls;
                        try {
                            exception.printStackTrace();
                            return -5;
                        } catch (Throwable th3) {
                            th = th3;
                            th2 = th;
                            throw th2;
                        }
                    } catch (Throwable th4) {
                        th2 = th4;
                        cls2 = cls;
                        throw th2;
                    }
                }
                RandomAccessFile randomAccessFile = new RandomAccessFile(j, "rw");
                if (randomAccessFile.length() < 1) {
                    randomAccessFile.close();
                    return -3;
                }
                long j = (long) i2;
                randomAccessFile.seek(j);
                i2 = randomAccessFile.readInt();
                int readInt = randomAccessFile.readInt();
                int readInt2 = randomAccessFile.readInt();
                int readInt3 = randomAccessFile.readInt();
                long readLong = randomAccessFile.readLong();
                long j2 = readLong;
                if (a(i2, readInt, readInt2, readInt3, readLong)) {
                    int i3 = 1;
                    if (readInt >= 1) {
                        int i4;
                        long j3;
                        byte[] bArr = new byte[n];
                        int i5 = k;
                        while (i5 > 0 && readInt > 0) {
                            i4 = i2;
                            cls2 = cls;
                            byte[] bArr2 = bArr;
                            j3 = j2;
                            try {
                                byte[] bArr3;
                                randomAccessFile.seek(j3 + ((long) ((((i2 + readInt) - i3) % readInt2) * readInt3)));
                                i2 = randomAccessFile.readInt();
                                if (i2 <= 0 || i2 >= readInt3) {
                                    bArr3 = bArr2;
                                } else {
                                    bArr3 = bArr2;
                                    randomAccessFile.read(bArr3, 0, i2);
                                    i2--;
                                    if (bArr3[i2] == (byte) 0) {
                                        list2.add(new String(bArr3, 0, i2));
                                    }
                                }
                                i5--;
                                readInt--;
                                j2 = j3;
                                bArr = bArr3;
                                cls = cls2;
                                i2 = i4;
                                i3 = 1;
                            } catch (Exception e3) {
                                e2 = e3;
                                exception = e2;
                                exception.printStackTrace();
                                return -5;
                            }
                        }
                        i4 = i2;
                        cls2 = cls;
                        j3 = j2;
                        randomAccessFile.seek(j);
                        randomAccessFile.writeInt(i4);
                        randomAccessFile.writeInt(readInt);
                        randomAccessFile.writeInt(readInt2);
                        randomAccessFile.writeInt(readInt3);
                        randomAccessFile.writeLong(j3);
                        randomAccessFile.close();
                        int i6 = k - i5;
                        return i6;
                    }
                }
                cls2 = cls;
                randomAccessFile.close();
                return -4;
            } catch (Exception e4) {
                e2 = e4;
                cls2 = cls;
                exception = e2;
                exception.printStackTrace();
                return -5;
            } catch (Throwable th5) {
                th4 = th5;
                cls2 = cls;
                th2 = th4;
                throw th2;
            }
        }
    }

    public static synchronized w a() {
        w wVar;
        synchronized (w.class) {
            if (A == null) {
                A = new w();
            }
            wVar = A;
        }
        return wVar;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x003f */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:20|21|(6:23|24|25|26|27|28)|30|31) */
    private static java.lang.String a(int r4) {
        /*
        r0 = 1;
        r1 = 0;
        if (r4 != r0) goto L_0x0009;
    L_0x0004:
        r4 = f;
        r2 = b;
        goto L_0x001f;
    L_0x0009:
        r2 = 2;
        if (r4 != r2) goto L_0x0011;
    L_0x000c:
        r4 = g;
        r2 = c;
        goto L_0x001f;
    L_0x0011:
        r2 = 3;
        if (r4 != r2) goto L_0x0019;
    L_0x0014:
        r4 = h;
    L_0x0016:
        r2 = d;
        goto L_0x001f;
    L_0x0019:
        r2 = 4;
        if (r4 != r2) goto L_0x0044;
    L_0x001c:
        r4 = i;
        goto L_0x0016;
    L_0x001f:
        if (r2 != 0) goto L_0x0022;
    L_0x0021:
        return r1;
    L_0x0022:
        r3 = r2.size();
        if (r3 >= r0) goto L_0x002b;
    L_0x0028:
        a(r4, r2);
    L_0x002b:
        r4 = com.baidu.location.a.w.class;
        monitor-enter(r4);
        r3 = r2.size();	 Catch:{ all -> 0x0041 }
        if (r3 <= 0) goto L_0x003f;
    L_0x0034:
        r3 = r3 - r0;
        r0 = r2.get(r3);	 Catch:{ Exception -> 0x003f }
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x003f }
        r2.remove(r3);	 Catch:{ Exception -> 0x003e }
    L_0x003e:
        r1 = r0;
    L_0x003f:
        monitor-exit(r4);	 Catch:{ all -> 0x0041 }
        return r1;
    L_0x0041:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0041 }
        throw r0;
    L_0x0044:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.a.w.a(int):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00cc A:{SYNTHETIC, EDGE_INSN: B:44:0x00cc->B:37:0x00cc ?: BREAK  , EDGE_INSN: B:44:0x00cc->B:37:0x00cc ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0060 A:{Catch:{ Exception -> 0x00e5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00cc A:{SYNTHETIC, EDGE_INSN: B:44:0x00cc->B:37:0x00cc ?: BREAK  , EDGE_INSN: B:44:0x00cc->B:37:0x00cc ?: BREAK  , EDGE_INSN: B:44:0x00cc->B:37:0x00cc ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0060 A:{Catch:{ Exception -> 0x00e5 }} */
    /* JADX WARNING: Missing block: B:9:0x0011, code skipped:
            if (r15 != false) goto L_0x0009;
     */
    /* JADX WARNING: Missing block: B:14:0x001c, code skipped:
            if (r15 != false) goto L_0x0014;
     */
    /* JADX WARNING: Missing block: B:18:0x0026, code skipped:
            if (r15 != false) goto L_0x001f;
     */
    private static void a(int r14, boolean r15) {
        /*
        r0 = 4;
        r1 = 1;
        if (r14 != r1) goto L_0x000c;
    L_0x0004:
        r2 = f;
        if (r15 == 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r3 = b;
        goto L_0x0029;
    L_0x000c:
        r2 = 2;
        if (r14 != r2) goto L_0x0017;
    L_0x000f:
        r2 = g;
        if (r15 == 0) goto L_0x0014;
    L_0x0013:
        goto L_0x0009;
    L_0x0014:
        r3 = c;
        goto L_0x0029;
    L_0x0017:
        r2 = 3;
        if (r14 != r2) goto L_0x0022;
    L_0x001a:
        r2 = h;
        if (r15 == 0) goto L_0x001f;
    L_0x001e:
        goto L_0x0014;
    L_0x001f:
        r3 = d;
        goto L_0x0029;
    L_0x0022:
        if (r14 != r0) goto L_0x00e5;
    L_0x0024:
        r2 = i;
        if (r15 == 0) goto L_0x00e5;
    L_0x0028:
        goto L_0x001f;
    L_0x0029:
        r4 = new java.io.File;
        r4.<init>(r2);
        r5 = r4.exists();
        if (r5 != 0) goto L_0x0037;
    L_0x0034:
        d(r2);
    L_0x0037:
        r2 = new java.io.RandomAccessFile;	 Catch:{ Exception -> 0x00e5 }
        r5 = "rw";
        r2.<init>(r4, r5);	 Catch:{ Exception -> 0x00e5 }
        r4 = 4;
        r2.seek(r4);	 Catch:{ Exception -> 0x00e5 }
        r4 = r2.readInt();	 Catch:{ Exception -> 0x00e5 }
        r5 = r2.readInt();	 Catch:{ Exception -> 0x00e5 }
        r6 = r2.readInt();	 Catch:{ Exception -> 0x00e5 }
        r7 = r2.readInt();	 Catch:{ Exception -> 0x00e5 }
        r8 = r2.readInt();	 Catch:{ Exception -> 0x00e5 }
        r9 = r3.size();	 Catch:{ Exception -> 0x00e5 }
    L_0x005b:
        r10 = l;	 Catch:{ Exception -> 0x00e5 }
        r11 = 0;
        if (r9 <= r10) goto L_0x00cc;
    L_0x0060:
        if (r15 == 0) goto L_0x0064;
    L_0x0062:
        r8 = r8 + 1;
    L_0x0064:
        r10 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        if (r6 >= r4) goto L_0x0096;
    L_0x0068:
        r12 = r5 * r6;
        r10 = r10 + r12;
        r12 = (long) r10;	 Catch:{ Exception -> 0x00e5 }
        r2.seek(r12);	 Catch:{ Exception -> 0x00e5 }
        r10 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00e5 }
        r10.<init>();	 Catch:{ Exception -> 0x00e5 }
        r12 = r3.get(r11);	 Catch:{ Exception -> 0x00e5 }
        r12 = (java.lang.String) r12;	 Catch:{ Exception -> 0x00e5 }
        r10.append(r12);	 Catch:{ Exception -> 0x00e5 }
        r10.append(r11);	 Catch:{ Exception -> 0x00e5 }
        r10 = r10.toString();	 Catch:{ Exception -> 0x00e5 }
        r10 = r10.getBytes();	 Catch:{ Exception -> 0x00e5 }
        r12 = r10.length;	 Catch:{ Exception -> 0x00e5 }
        r2.writeInt(r12);	 Catch:{ Exception -> 0x00e5 }
        r12 = r10.length;	 Catch:{ Exception -> 0x00e5 }
        r2.write(r10, r11, r12);	 Catch:{ Exception -> 0x00e5 }
        r3.remove(r11);	 Catch:{ Exception -> 0x00e5 }
        r6 = r6 + 1;
        goto L_0x00c8;
    L_0x0096:
        if (r15 == 0) goto L_0x00cb;
    L_0x0098:
        r12 = r7 * r5;
        r10 = r10 + r12;
        r12 = (long) r10;	 Catch:{ Exception -> 0x00e5 }
        r2.seek(r12);	 Catch:{ Exception -> 0x00e5 }
        r10 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00e5 }
        r10.<init>();	 Catch:{ Exception -> 0x00e5 }
        r12 = r3.get(r11);	 Catch:{ Exception -> 0x00e5 }
        r12 = (java.lang.String) r12;	 Catch:{ Exception -> 0x00e5 }
        r10.append(r12);	 Catch:{ Exception -> 0x00e5 }
        r10.append(r11);	 Catch:{ Exception -> 0x00e5 }
        r10 = r10.toString();	 Catch:{ Exception -> 0x00e5 }
        r10 = r10.getBytes();	 Catch:{ Exception -> 0x00e5 }
        r12 = r10.length;	 Catch:{ Exception -> 0x00e5 }
        r2.writeInt(r12);	 Catch:{ Exception -> 0x00e5 }
        r12 = r10.length;	 Catch:{ Exception -> 0x00e5 }
        r2.write(r10, r11, r12);	 Catch:{ Exception -> 0x00e5 }
        r3.remove(r11);	 Catch:{ Exception -> 0x00e5 }
        r7 = r7 + 1;
        if (r7 <= r6) goto L_0x00c8;
    L_0x00c7:
        r7 = r11;
    L_0x00c8:
        r9 = r9 + -1;
        goto L_0x005b;
    L_0x00cb:
        r11 = r1;
    L_0x00cc:
        r3 = 12;
        r2.seek(r3);	 Catch:{ Exception -> 0x00e5 }
        r2.writeInt(r6);	 Catch:{ Exception -> 0x00e5 }
        r2.writeInt(r7);	 Catch:{ Exception -> 0x00e5 }
        r2.writeInt(r8);	 Catch:{ Exception -> 0x00e5 }
        r2.close();	 Catch:{ Exception -> 0x00e5 }
        if (r11 == 0) goto L_0x00e5;
    L_0x00df:
        if (r14 >= r0) goto L_0x00e5;
    L_0x00e1:
        r14 = r14 + r1;
        a(r14, r1);	 Catch:{ Exception -> 0x00e5 }
    L_0x00e5:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.a.w.a(int, boolean):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:93:0x01c8  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x01d3  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0166  */
    public static void a(com.baidu.location.e.a r12, com.baidu.location.e.h r13, android.location.Location r14, java.lang.String r15) {
        /*
        r0 = com.baidu.location.b.e.a();
        r0 = r0.a;
        if (r0 != 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r0 = com.baidu.location.g.j.v;
        r1 = 3;
        r2 = 0;
        if (r0 != r1) goto L_0x001c;
    L_0x000f:
        r0 = a(r14, r13);
        if (r0 != 0) goto L_0x001c;
    L_0x0015:
        r0 = a(r14, r2);
        if (r0 != 0) goto L_0x001c;
    L_0x001b:
        return;
    L_0x001c:
        if (r12 == 0) goto L_0x01e0;
    L_0x001e:
        r0 = r12.c();
        if (r0 == 0) goto L_0x0025;
    L_0x0024:
        return;
    L_0x0025:
        r0 = com.baidu.location.f.getServiceContext();
        r0 = com.baidu.location.g.j.a(r0);
        if (r0 == 0) goto L_0x003f;
    L_0x002f:
        r3 = com.baidu.location.d.g.a();
        r6 = 0;
        r7 = com.baidu.location.d.g.b.IS_MIX_MODE;
    L_0x0036:
        r8 = com.baidu.location.d.g.a.NO_NEED_TO_LOG;
        r4 = r12;
        r5 = r13;
        r0 = r3.a(r4, r5, r6, r7, r8);
        goto L_0x0047;
    L_0x003f:
        r3 = com.baidu.location.d.g.a();
        r6 = 0;
        r7 = com.baidu.location.d.g.b.IS_NOT_MIX_MODE;
        goto L_0x0036;
    L_0x0047:
        r3 = 2;
        r4 = 0;
        r5 = 1;
        if (r0 == 0) goto L_0x00c4;
    L_0x004c:
        r6 = r0.getLocType();
        r7 = 67;
        if (r6 != r7) goto L_0x0056;
    L_0x0054:
        goto L_0x00c4;
    L_0x0056:
        if (r0 == 0) goto L_0x0063;
    L_0x0058:
        r6 = r0.getNetworkLocationType();
        if (r6 == 0) goto L_0x0063;
    L_0x005e:
        r6 = r0.getNetworkLocationType();
        goto L_0x0064;
    L_0x0063:
        r6 = r4;
    L_0x0064:
        if (r6 == 0) goto L_0x0070;
    L_0x0066:
        r7 = "cl";
        r7 = r6.equals(r7);
        if (r7 == 0) goto L_0x0070;
    L_0x006e:
        r6 = r5;
        goto L_0x007d;
    L_0x0070:
        if (r6 == 0) goto L_0x007c;
    L_0x0072:
        r7 = "wf";
        r6 = r6.equals(r7);
        if (r6 == 0) goto L_0x007c;
    L_0x007a:
        r6 = r3;
        goto L_0x007d;
    L_0x007c:
        r6 = r2;
    L_0x007d:
        if (r0 == 0) goto L_0x00e1;
    L_0x007f:
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r7.append(r15);
        r15 = java.util.Locale.CHINA;
        r8 = "&ofl=%s|%d|%f|%f|%d";
        r9 = 5;
        r9 = new java.lang.Object[r9];
        r10 = "1";
        r9[r2] = r10;
        r2 = java.lang.Integer.valueOf(r6);
        r9[r5] = r2;
        r10 = r0.getLongitude();
        r2 = java.lang.Double.valueOf(r10);
        r9[r3] = r2;
        r10 = r0.getLatitude();
        r2 = java.lang.Double.valueOf(r10);
        r9[r1] = r2;
        r2 = 4;
        r0 = r0.getRadius();
        r0 = (int) r0;
        r0 = java.lang.Integer.valueOf(r0);
        r9[r2] = r0;
        r15 = java.lang.String.format(r15, r8, r9);
        r7.append(r15);
        r15 = r7.toString();
        goto L_0x00e1;
    L_0x00c4:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r0.append(r15);
        r15 = java.util.Locale.CHINA;
        r6 = "&ofl=%s|0";
        r7 = new java.lang.Object[r5];
        r8 = "1";
        r7[r2] = r8;
        r15 = java.lang.String.format(r15, r6, r7);
        r0.append(r15);
        r15 = r0.toString();
    L_0x00e1:
        if (r12 == 0) goto L_0x0106;
    L_0x00e3:
        r0 = r12.a();
        if (r0 == 0) goto L_0x0106;
    L_0x00e9:
        r0 = a(r14, r13);
        if (r0 != 0) goto L_0x00f0;
    L_0x00ef:
        r13 = r4;
    L_0x00f0:
        r12 = com.baidu.location.g.j.a(r12, r13, r14, r15, r5);
        if (r12 == 0) goto L_0x0105;
    L_0x00f6:
        r12 = com.baidu.location.Jni.encode(r12);
        a(r12);
        w = r14;
        v = r14;
        if (r13 == 0) goto L_0x0105;
    L_0x0103:
        y = r13;
    L_0x0105:
        return;
    L_0x0106:
        if (r13 == 0) goto L_0x0176;
    L_0x0108:
        r0 = r13.l();
        if (r0 == 0) goto L_0x0176;
    L_0x010e:
        r0 = a(r14, r13);
        if (r0 == 0) goto L_0x0176;
    L_0x0114:
        r0 = a(r14);
        if (r0 != 0) goto L_0x0136;
    L_0x011a:
        r0 = com.baidu.location.e.b.a();
        r0 = r0.d();
        if (r0 != 0) goto L_0x0136;
    L_0x0124:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "&cfr=1";
    L_0x012b:
        r0.append(r1);
        r0.append(r15);
        r15 = r0.toString();
        goto L_0x0160;
    L_0x0136:
        r0 = a(r14);
        if (r0 != 0) goto L_0x014e;
    L_0x013c:
        r0 = com.baidu.location.e.b.a();
        r0 = r0.d();
        if (r0 == 0) goto L_0x014e;
    L_0x0146:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "&cfr=3";
        goto L_0x012b;
    L_0x014e:
        r0 = com.baidu.location.e.b.a();
        r0 = r0.d();
        if (r0 == 0) goto L_0x0160;
    L_0x0158:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "&cfr=2";
        goto L_0x012b;
    L_0x0160:
        r12 = com.baidu.location.g.j.a(r12, r13, r14, r15, r3);
        if (r12 == 0) goto L_0x0175;
    L_0x0166:
        r12 = com.baidu.location.Jni.encode(r12);
        b(r12);
        x = r14;
        v = r14;
        if (r13 == 0) goto L_0x0175;
    L_0x0173:
        y = r13;
    L_0x0175:
        return;
    L_0x0176:
        r0 = a(r14);
        if (r0 != 0) goto L_0x0198;
    L_0x017c:
        r0 = com.baidu.location.e.b.a();
        r0 = r0.d();
        if (r0 != 0) goto L_0x0198;
    L_0x0186:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r2 = "&cfr=1";
    L_0x018d:
        r0.append(r2);
        r0.append(r15);
        r15 = r0.toString();
        goto L_0x01c2;
    L_0x0198:
        r0 = a(r14);
        if (r0 != 0) goto L_0x01b0;
    L_0x019e:
        r0 = com.baidu.location.e.b.a();
        r0 = r0.d();
        if (r0 == 0) goto L_0x01b0;
    L_0x01a8:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r2 = "&cfr=3";
        goto L_0x018d;
    L_0x01b0:
        r0 = com.baidu.location.e.b.a();
        r0 = r0.d();
        if (r0 == 0) goto L_0x01c2;
    L_0x01ba:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r2 = "&cfr=2";
        goto L_0x018d;
    L_0x01c2:
        r0 = a(r14, r13);
        if (r0 != 0) goto L_0x01c9;
    L_0x01c8:
        r13 = r4;
    L_0x01c9:
        if (r12 != 0) goto L_0x01cd;
    L_0x01cb:
        if (r13 == 0) goto L_0x01e0;
    L_0x01cd:
        r12 = com.baidu.location.g.j.a(r12, r13, r14, r15, r1);
        if (r12 == 0) goto L_0x01e0;
    L_0x01d3:
        r12 = com.baidu.location.Jni.encode(r12);
        c(r12);
        v = r14;
        if (r13 == 0) goto L_0x01e0;
    L_0x01de:
        y = r13;
    L_0x01e0:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.a.w.a(com.baidu.location.e.a, com.baidu.location.e.h, android.location.Location, java.lang.String):void");
    }

    private static void a(String str) {
        e(str);
    }

    /* JADX WARNING: Missing block: B:17:0x001b, code skipped:
            return false;
     */
    private static boolean a(int r0, int r1, int r2, int r3, long r4) {
        /*
        r4 = 0;
        if (r0 < 0) goto L_0x001b;
    L_0x0003:
        if (r0 < r2) goto L_0x0006;
    L_0x0005:
        return r4;
    L_0x0006:
        if (r1 < 0) goto L_0x001b;
    L_0x0008:
        if (r1 <= r2) goto L_0x000b;
    L_0x000a:
        return r4;
    L_0x000b:
        if (r2 < 0) goto L_0x001b;
    L_0x000d:
        r0 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        if (r2 <= r0) goto L_0x0012;
    L_0x0011:
        return r4;
    L_0x0012:
        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        if (r3 < r1) goto L_0x001b;
    L_0x0016:
        if (r3 <= r0) goto L_0x0019;
    L_0x0018:
        return r4;
    L_0x0019:
        r0 = 1;
        return r0;
    L_0x001b:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.a.w.a(int, int, int, int, long):boolean");
    }

    private static boolean a(Location location) {
        boolean z = false;
        if (location == null) {
            return false;
        }
        if (w == null || v == null) {
            w = location;
            return true;
        }
        double distanceTo = (double) location.distanceTo(w);
        if (((double) location.distanceTo(v)) > (((((double) j.S) * distanceTo) * distanceTo) + (((double) j.T) * distanceTo)) + ((double) j.U)) {
            z = true;
        }
        return z;
    }

    private static boolean a(Location location, h hVar) {
        boolean z = false;
        if (!(location == null || hVar == null || hVar.a == null)) {
            if (hVar.a.isEmpty() || hVar.b(y)) {
                return false;
            }
            z = true;
            if (x == null) {
                x = location;
            }
        }
        return z;
    }

    public static boolean a(Location location, boolean z) {
        return com.baidu.location.e.e.a(v, location, z);
    }

    private static boolean a(String str, List<String> list) {
        boolean z;
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(8);
            int readInt = randomAccessFile.readInt();
            int readInt2 = randomAccessFile.readInt();
            int readInt3 = randomAccessFile.readInt();
            byte[] bArr = new byte[n];
            int i = l + 1;
            z = false;
            while (i > 0 && readInt2 > 0) {
                if (readInt2 < readInt3) {
                    readInt3 = 0;
                }
                try {
                    randomAccessFile.seek((long) (128 + ((readInt2 - 1) * readInt)));
                    int readInt4 = randomAccessFile.readInt();
                    if (readInt4 > 0 && readInt4 < readInt) {
                        randomAccessFile.read(bArr, 0, readInt4);
                        readInt4--;
                        if (bArr[readInt4] == (byte) 0) {
                            list.add(0, new String(bArr, 0, readInt4));
                            z = true;
                        }
                    }
                    i--;
                    readInt2--;
                } catch (Exception unused) {
                    return z;
                }
            }
            randomAccessFile.seek(12);
            randomAccessFile.writeInt(readInt2);
            randomAccessFile.writeInt(readInt3);
            randomAccessFile.close();
            return z;
        } catch (Exception unused2) {
            z = false;
            return z;
        }
    }

    public static String b() {
        return f();
    }

    private static void b(String str) {
        e(str);
    }

    private static void c(String str) {
        e(str);
    }

    public static void d() {
        l = 0;
        a(1, false);
        a(2, false);
        a(3, false);
        l = 8;
    }

    private static void d(String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                File file2 = new File(i.a);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                if (!file.createNewFile()) {
                    file = null;
                }
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(0);
                randomAccessFile.writeInt(32);
                randomAccessFile.writeInt(2048);
                randomAccessFile.writeInt(1040);
                randomAccessFile.writeInt(0);
                randomAccessFile.writeInt(0);
                randomAccessFile.writeInt(0);
                randomAccessFile.close();
            }
        } catch (Exception unused) {
        }
    }

    public static String e() {
        RandomAccessFile randomAccessFile;
        int readInt;
        StringBuilder stringBuilder;
        String stringBuilder2;
        File file = new File(g);
        String str = null;
        if (file.exists()) {
            try {
                randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(20);
                readInt = randomAccessFile.readInt();
                if (readInt > 128) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("&p1=");
                    stringBuilder.append(readInt);
                    stringBuilder2 = stringBuilder.toString();
                    try {
                        randomAccessFile.seek(20);
                        randomAccessFile.writeInt(0);
                        randomAccessFile.close();
                        return stringBuilder2;
                    } catch (Exception unused) {
                        str = stringBuilder2;
                    }
                } else {
                    randomAccessFile.close();
                }
            } catch (Exception unused2) {
            }
        }
        file = new File(h);
        if (file.exists()) {
            try {
                randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(20);
                readInt = randomAccessFile.readInt();
                if (readInt > 256) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("&p2=");
                    stringBuilder.append(readInt);
                    stringBuilder2 = stringBuilder.toString();
                    try {
                        randomAccessFile.seek(20);
                        randomAccessFile.writeInt(0);
                        randomAccessFile.close();
                        return stringBuilder2;
                    } catch (Exception unused3) {
                        str = stringBuilder2;
                    }
                } else {
                    randomAccessFile.close();
                }
            } catch (Exception unused4) {
            }
        }
        file = new File(i);
        if (file.exists()) {
            try {
                randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(20);
                readInt = randomAccessFile.readInt();
                if (readInt > 512) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("&p3=");
                    stringBuilder.append(readInt);
                    stringBuilder2 = stringBuilder.toString();
                    try {
                        randomAccessFile.seek(20);
                        randomAccessFile.writeInt(0);
                        randomAccessFile.close();
                        return stringBuilder2;
                    } catch (Exception unused5) {
                        return stringBuilder2;
                    }
                }
                randomAccessFile.close();
            } catch (Exception unused6) {
            }
        }
        return str;
    }

    private static synchronized void e(String str) {
        synchronized (w.class) {
            if (str.contains("err!")) {
                return;
            }
            List list;
            int i = j.q;
            if (i == 1) {
                list = b;
            } else if (i == 2) {
                list = c;
            } else if (i == 3) {
                list = d;
            } else {
                return;
            }
            if (list == null) {
                return;
            }
            if (list.size() <= m) {
                list.add(str);
            }
            if (list.size() >= m) {
                a(i, false);
            }
            while (list.size() > m) {
                list.remove(0);
            }
        }
    }

    private static String f() {
        String str = null;
        for (int i = 1; i < 5; i++) {
            str = a(i);
            if (str != null) {
                return str;
            }
        }
        a(d, t);
        if (d.size() > 0) {
            str = (String) d.get(0);
            d.remove(0);
        }
        if (str != null) {
            return str;
        }
        a(d, s);
        if (d.size() > 0) {
            str = (String) d.get(0);
            d.remove(0);
        }
        if (str != null) {
            return str;
        }
        a(d, u);
        if (d.size() > 0) {
            str = (String) d.get(0);
            d.remove(0);
        }
        return str;
    }

    public void c() {
        if (com.baidu.location.e.i.j()) {
            this.z.b();
        }
    }
}
