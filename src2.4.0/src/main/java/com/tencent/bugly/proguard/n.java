package com.tencent.bugly.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.common.info.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
public final class n {
    public static final long a = System.currentTimeMillis();
    private static n b;
    private Context c;
    private String d = a.b().d;
    private Map<Integer, Map<String, m>> e = new HashMap();
    private SharedPreferences f;

    private n(Context context) {
        this.c = context;
        this.f = context.getSharedPreferences("crashrecord", 0);
    }

    public static synchronized n a() {
        n nVar;
        synchronized (n.class) {
            nVar = b;
        }
        return nVar;
    }

    public static synchronized n a(Context context) {
        n nVar;
        synchronized (n.class) {
            if (b == null) {
                b = new n(context);
            }
            nVar = b;
        }
        return nVar;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x0056 */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004c A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0048 A:{SYNTHETIC, Splitter:B:23:0x0048} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0050 A:{SYNTHETIC, Splitter:B:28:0x0050} */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    private synchronized <T extends java.util.List<?>> void a(int r5, T r6) {
        /*
        r4 = this;
        monitor-enter(r4);
        if (r6 != 0) goto L_0x0005;
    L_0x0003:
        monitor-exit(r4);
        return;
    L_0x0005:
        r0 = 0;
        r1 = new java.io.File;	 Catch:{ Exception -> 0x0056 }
        r2 = r4.c;	 Catch:{ Exception -> 0x0056 }
        r3 = "crashrecord";
        r2 = r2.getDir(r3, r0);	 Catch:{ Exception -> 0x0056 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0056 }
        r3.<init>();	 Catch:{ Exception -> 0x0056 }
        r3.append(r5);	 Catch:{ Exception -> 0x0056 }
        r5 = r3.toString();	 Catch:{ Exception -> 0x0056 }
        r1.<init>(r2, r5);	 Catch:{ Exception -> 0x0056 }
        r5 = 0;
        r2 = new java.io.ObjectOutputStream;	 Catch:{ IOException -> 0x003b }
        r3 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x003b }
        r3.<init>(r1);	 Catch:{ IOException -> 0x003b }
        r2.<init>(r3);	 Catch:{ IOException -> 0x003b }
        r2.writeObject(r6);	 Catch:{ IOException -> 0x0035, all -> 0x0031 }
        r2.close();	 Catch:{ Exception -> 0x0056 }
        goto L_0x005d;
    L_0x0031:
        r5 = move-exception;
        r6 = r5;
        r5 = r2;
        goto L_0x004e;
    L_0x0035:
        r5 = move-exception;
        r6 = r5;
        r5 = r2;
        goto L_0x003c;
    L_0x0039:
        r6 = move-exception;
        goto L_0x004e;
    L_0x003b:
        r6 = move-exception;
    L_0x003c:
        r6.printStackTrace();	 Catch:{ all -> 0x0039 }
        r6 = "open record file error";
        r1 = new java.lang.Object[r0];	 Catch:{ all -> 0x0039 }
        com.tencent.bugly.proguard.x.a(r6, r1);	 Catch:{ all -> 0x0039 }
        if (r5 == 0) goto L_0x004c;
    L_0x0048:
        r5.close();	 Catch:{ Exception -> 0x0056 }
        goto L_0x005d;
    L_0x004c:
        monitor-exit(r4);
        return;
    L_0x004e:
        if (r5 == 0) goto L_0x0053;
    L_0x0050:
        r5.close();	 Catch:{ Exception -> 0x0056 }
    L_0x0053:
        throw r6;	 Catch:{ Exception -> 0x0056 }
    L_0x0054:
        r5 = move-exception;
        goto L_0x005f;
    L_0x0056:
        r5 = "writeCrashRecord error";
        r6 = new java.lang.Object[r0];	 Catch:{ all -> 0x0054 }
        com.tencent.bugly.proguard.x.e(r5, r6);	 Catch:{ all -> 0x0054 }
    L_0x005d:
        monitor-exit(r4);
        return;
    L_0x005f:
        monitor-exit(r4);
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.n.a(int, java.util.List):void");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0084 */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing block: B:31:0x0079, code skipped:
            return true;
     */
    /* JADX WARNING: Missing block: B:38:?, code skipped:
            com.tencent.bugly.proguard.x.e("isFrequentCrash failed", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing block: B:40:0x008c, code skipped:
            return false;
     */
    private synchronized boolean b(int r15) {
        /*
        r14 = this;
        monitor-enter(r14);
        r0 = 0;
        r1 = r14.c(r15);	 Catch:{ Exception -> 0x0084 }
        if (r1 != 0) goto L_0x000a;
    L_0x0008:
        monitor-exit(r14);
        return r0;
    L_0x000a:
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0084 }
        r4 = new java.util.ArrayList;	 Catch:{ Exception -> 0x0084 }
        r4.<init>();	 Catch:{ Exception -> 0x0084 }
        r5 = new java.util.ArrayList;	 Catch:{ Exception -> 0x0084 }
        r5.<init>();	 Catch:{ Exception -> 0x0084 }
        r6 = r1.iterator();	 Catch:{ Exception -> 0x0084 }
    L_0x001c:
        r7 = r6.hasNext();	 Catch:{ Exception -> 0x0084 }
        r8 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;
        if (r7 == 0) goto L_0x004c;
    L_0x0025:
        r7 = r6.next();	 Catch:{ Exception -> 0x0084 }
        r7 = (com.tencent.bugly.proguard.m) r7;	 Catch:{ Exception -> 0x0084 }
        r10 = r7.b;	 Catch:{ Exception -> 0x0084 }
        if (r10 == 0) goto L_0x0040;
    L_0x002f:
        r10 = r7.b;	 Catch:{ Exception -> 0x0084 }
        r11 = r14.d;	 Catch:{ Exception -> 0x0084 }
        r10 = r10.equalsIgnoreCase(r11);	 Catch:{ Exception -> 0x0084 }
        if (r10 == 0) goto L_0x0040;
    L_0x0039:
        r10 = r7.d;	 Catch:{ Exception -> 0x0084 }
        if (r10 <= 0) goto L_0x0040;
    L_0x003d:
        r4.add(r7);	 Catch:{ Exception -> 0x0084 }
    L_0x0040:
        r10 = r7.c;	 Catch:{ Exception -> 0x0084 }
        r12 = r10 + r8;
        r8 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1));
        if (r8 >= 0) goto L_0x001c;
    L_0x0048:
        r5.add(r7);	 Catch:{ Exception -> 0x0084 }
        goto L_0x001c;
    L_0x004c:
        java.util.Collections.sort(r4);	 Catch:{ Exception -> 0x0084 }
        r6 = r4.size();	 Catch:{ Exception -> 0x0084 }
        r7 = 2;
        if (r6 < r7) goto L_0x007a;
    L_0x0056:
        r5 = r4.size();	 Catch:{ Exception -> 0x0084 }
        r6 = 1;
        if (r5 <= 0) goto L_0x0078;
    L_0x005d:
        r5 = r4.size();	 Catch:{ Exception -> 0x0084 }
        r5 = r5 - r6;
        r4 = r4.get(r5);	 Catch:{ Exception -> 0x0084 }
        r4 = (com.tencent.bugly.proguard.m) r4;	 Catch:{ Exception -> 0x0084 }
        r4 = r4.c;	 Catch:{ Exception -> 0x0084 }
        r10 = r4 + r8;
        r4 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1));
        if (r4 >= 0) goto L_0x0078;
    L_0x0070:
        r1.clear();	 Catch:{ Exception -> 0x0084 }
        r14.a(r15, r1);	 Catch:{ Exception -> 0x0084 }
        monitor-exit(r14);
        return r0;
    L_0x0078:
        monitor-exit(r14);
        return r6;
    L_0x007a:
        r1.removeAll(r5);	 Catch:{ Exception -> 0x0084 }
        r14.a(r15, r1);	 Catch:{ Exception -> 0x0084 }
        monitor-exit(r14);
        return r0;
    L_0x0082:
        r15 = move-exception;
        goto L_0x008d;
    L_0x0084:
        r15 = "isFrequentCrash failed";
        r1 = new java.lang.Object[r0];	 Catch:{ all -> 0x0082 }
        com.tencent.bugly.proguard.x.e(r15, r1);	 Catch:{ all -> 0x0082 }
        monitor-exit(r14);
        return r0;
    L_0x008d:
        monitor-exit(r14);
        throw r15;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.n.b(int):boolean");
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:26:0x004b=Splitter:B:26:0x004b, B:19:0x003d=Splitter:B:19:0x003d} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x005e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x004b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x003d */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0058 A:{SYNTHETIC, Splitter:B:31:0x0058} */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:19:0x003d, B:26:0x004b] */
    /* JADX WARNING: Missing block: B:20:?, code skipped:
            com.tencent.bugly.proguard.x.a("get object error", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing block: B:21:0x0044, code skipped:
            if (r6 == null) goto L_0x0065;
     */
    /* JADX WARNING: Missing block: B:23:?, code skipped:
            r6.close();
     */
    /* JADX WARNING: Missing block: B:27:?, code skipped:
            com.tencent.bugly.proguard.x.a("open record file error", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing block: B:28:0x0052, code skipped:
            if (r6 == null) goto L_0x0065;
     */
    /* JADX WARNING: Missing block: B:29:0x0055, code skipped:
            r2 = th;
     */
    /* JADX WARNING: Missing block: B:32:?, code skipped:
            r6.close();
     */
    /* JADX WARNING: Missing block: B:36:?, code skipped:
            com.tencent.bugly.proguard.x.e("readCrashRecord error", new java.lang.Object[0]);
     */
    private synchronized <T extends java.util.List<?>> T c(int r6) {
        /*
        r5 = this;
        monitor-enter(r5);
        r0 = 0;
        r1 = 0;
        r2 = new java.io.File;	 Catch:{ Exception -> 0x005e }
        r3 = r5.c;	 Catch:{ Exception -> 0x005e }
        r4 = "crashrecord";
        r3 = r3.getDir(r4, r1);	 Catch:{ Exception -> 0x005e }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x005e }
        r4.<init>();	 Catch:{ Exception -> 0x005e }
        r4.append(r6);	 Catch:{ Exception -> 0x005e }
        r6 = r4.toString();	 Catch:{ Exception -> 0x005e }
        r2.<init>(r3, r6);	 Catch:{ Exception -> 0x005e }
        r6 = r2.exists();	 Catch:{ Exception -> 0x005e }
        if (r6 != 0) goto L_0x0024;
    L_0x0022:
        monitor-exit(r5);
        return r0;
    L_0x0024:
        r6 = new java.io.ObjectInputStream;	 Catch:{ IOException -> 0x004a, ClassNotFoundException -> 0x003c, all -> 0x0039 }
        r3 = new java.io.FileInputStream;	 Catch:{ IOException -> 0x004a, ClassNotFoundException -> 0x003c, all -> 0x0039 }
        r3.<init>(r2);	 Catch:{ IOException -> 0x004a, ClassNotFoundException -> 0x003c, all -> 0x0039 }
        r6.<init>(r3);	 Catch:{ IOException -> 0x004a, ClassNotFoundException -> 0x003c, all -> 0x0039 }
        r2 = r6.readObject();	 Catch:{ IOException -> 0x004b, ClassNotFoundException -> 0x003d }
        r2 = (java.util.List) r2;	 Catch:{ IOException -> 0x004b, ClassNotFoundException -> 0x003d }
        r6.close();	 Catch:{ Exception -> 0x005e }
        monitor-exit(r5);
        return r2;
    L_0x0039:
        r2 = move-exception;
        r6 = r0;
        goto L_0x0056;
    L_0x003c:
        r6 = r0;
    L_0x003d:
        r2 = "get object error";
        r3 = new java.lang.Object[r1];	 Catch:{ all -> 0x0055 }
        com.tencent.bugly.proguard.x.a(r2, r3);	 Catch:{ all -> 0x0055 }
        if (r6 == 0) goto L_0x0065;
    L_0x0046:
        r6.close();	 Catch:{ Exception -> 0x005e }
        goto L_0x0065;
    L_0x004a:
        r6 = r0;
    L_0x004b:
        r2 = "open record file error";
        r3 = new java.lang.Object[r1];	 Catch:{ all -> 0x0055 }
        com.tencent.bugly.proguard.x.a(r2, r3);	 Catch:{ all -> 0x0055 }
        if (r6 == 0) goto L_0x0065;
    L_0x0054:
        goto L_0x0046;
    L_0x0055:
        r2 = move-exception;
    L_0x0056:
        if (r6 == 0) goto L_0x005b;
    L_0x0058:
        r6.close();	 Catch:{ Exception -> 0x005e }
    L_0x005b:
        throw r2;	 Catch:{ Exception -> 0x005e }
    L_0x005c:
        r6 = move-exception;
        goto L_0x0067;
    L_0x005e:
        r6 = "readCrashRecord error";
        r1 = new java.lang.Object[r1];	 Catch:{ all -> 0x005c }
        com.tencent.bugly.proguard.x.e(r6, r1);	 Catch:{ all -> 0x005c }
    L_0x0065:
        monitor-exit(r5);
        return r0;
    L_0x0067:
        monitor-exit(r5);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.n.c(int):java.util.List");
    }

    public final synchronized void a(int i, final int i2) {
        w.a().a(new Runnable(1004) {
            public final void run() {
                try {
                    if (!TextUtils.isEmpty(n.this.d)) {
                        m mVar;
                        List a = n.this.c(1004);
                        if (a == null) {
                            a = new ArrayList();
                        }
                        if (n.this.e.get(Integer.valueOf(1004)) == null) {
                            n.this.e.put(Integer.valueOf(1004), new HashMap());
                        }
                        if (((Map) n.this.e.get(Integer.valueOf(1004))).get(n.this.d) == null) {
                            mVar = new m();
                            mVar.a = (long) 1004;
                            mVar.g = n.a;
                            mVar.b = n.this.d;
                            mVar.f = a.b().j;
                            a.b().getClass();
                            mVar.e = "2.6.6";
                            mVar.c = System.currentTimeMillis();
                            mVar.d = i2;
                            ((Map) n.this.e.get(Integer.valueOf(1004))).put(n.this.d, mVar);
                        } else {
                            mVar = (m) ((Map) n.this.e.get(Integer.valueOf(1004))).get(n.this.d);
                            mVar.d = i2;
                        }
                        ArrayList arrayList = new ArrayList();
                        int i = 0;
                        for (m mVar2 : a) {
                            if (mVar2.g == mVar.g && mVar2.b != null && mVar2.b.equalsIgnoreCase(mVar.b)) {
                                i = 1;
                                mVar2.d = mVar.d;
                            }
                            if ((mVar2.e != null && !mVar2.e.equalsIgnoreCase(mVar.e)) || ((mVar2.f != null && !mVar2.f.equalsIgnoreCase(mVar.f)) || mVar2.d <= 0)) {
                                arrayList.add(mVar2);
                            }
                        }
                        a.removeAll(arrayList);
                        if (i == 0) {
                            a.add(mVar);
                        }
                        n.this.a(1004, (List) a);
                    }
                } catch (Exception unused) {
                    x.e("saveCrashRecord failed", new Object[0]);
                }
            }
        });
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0030 */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    public final synchronized boolean a(final int r5) {
        /*
        r4 = this;
        monitor-enter(r4);
        r0 = 1;
        r1 = r4.f;	 Catch:{ Exception -> 0x0030 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0030 }
        r2.<init>();	 Catch:{ Exception -> 0x0030 }
        r2.append(r5);	 Catch:{ Exception -> 0x0030 }
        r3 = "_";
        r2.append(r3);	 Catch:{ Exception -> 0x0030 }
        r3 = r4.d;	 Catch:{ Exception -> 0x0030 }
        r2.append(r3);	 Catch:{ Exception -> 0x0030 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0030 }
        r1 = r1.getBoolean(r2, r0);	 Catch:{ Exception -> 0x0030 }
        r0 = com.tencent.bugly.proguard.w.a();	 Catch:{ Exception -> 0x002c }
        r2 = new com.tencent.bugly.proguard.n$2;	 Catch:{ Exception -> 0x002c }
        r2.<init>(r5);	 Catch:{ Exception -> 0x002c }
        r0.a(r2);	 Catch:{ Exception -> 0x002c }
        monitor-exit(r4);
        return r1;
    L_0x002c:
        r0 = r1;
        goto L_0x0030;
    L_0x002e:
        r5 = move-exception;
        goto L_0x003a;
    L_0x0030:
        r5 = "canInit error";
        r1 = 0;
        r1 = new java.lang.Object[r1];	 Catch:{ all -> 0x002e }
        com.tencent.bugly.proguard.x.e(r5, r1);	 Catch:{ all -> 0x002e }
        monitor-exit(r4);
        return r0;
    L_0x003a:
        monitor-exit(r4);
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.n.a(int):boolean");
    }
}
