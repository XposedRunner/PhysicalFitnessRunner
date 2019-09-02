package com.loc;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: LoaderFactory */
public final class O00O00Oo {
    private static final O00O00Oo O000000o = new O00O00Oo();
    private static final ThreadFactory O00000o = new ThreadFactory() {
        private final AtomicInteger O000000o = new AtomicInteger(1);

        public final Thread newThread(Runnable runnable) {
            StringBuilder stringBuilder = new StringBuilder("amapD#");
            stringBuilder.append(this.O000000o.getAndIncrement());
            return new Thread(runnable, stringBuilder.toString());
        }
    };
    private final Map<String, O000Oo0> O00000Oo = new HashMap();
    private final Map<String, O000000o> O00000o0 = new HashMap();
    private ExecutorService O00000oO = null;

    /* compiled from: LoaderFactory */
    class O000000o {
        volatile boolean O000000o = false;
        volatile boolean O00000Oo = false;

        O000000o() {
        }
    }

    private O00O00Oo() {
    }

    public static O00O00Oo O00000Oo() {
        return O000000o;
    }

    private static boolean O00000Oo(OO0Oo0 oO0Oo0) {
        return (oO0Oo0 == null || TextUtils.isEmpty(oO0Oo0.O00000Oo()) || TextUtils.isEmpty(oO0Oo0.O000000o())) ? false : true;
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x002c */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:5|6|(5:8|9|10|11|12)|14|15) */
    public final com.loc.O000Oo0 O000000o(android.content.Context r6, com.loc.OO0Oo0 r7) throws java.lang.Exception {
        /*
        r5 = this;
        r0 = O00000Oo(r7);
        if (r0 == 0) goto L_0x0031;
    L_0x0006:
        if (r6 != 0) goto L_0x0009;
    L_0x0008:
        goto L_0x0031;
    L_0x0009:
        r0 = r7.O000000o();
        r1 = r5.O00000Oo;
        monitor-enter(r1);
        r2 = r5.O00000Oo;	 Catch:{ all -> 0x002e }
        r2 = r2.get(r0);	 Catch:{ all -> 0x002e }
        r2 = (com.loc.O000Oo0) r2;	 Catch:{ all -> 0x002e }
        if (r2 != 0) goto L_0x002c;
    L_0x001a:
        r3 = new com.loc.oooOoO;	 Catch:{ Throwable -> 0x002c }
        r4 = r6.getApplicationContext();	 Catch:{ Throwable -> 0x002c }
        r3.<init>(r4, r7);	 Catch:{ Throwable -> 0x002c }
        r2 = r5.O00000Oo;	 Catch:{ Throwable -> 0x002b }
        r2.put(r0, r3);	 Catch:{ Throwable -> 0x002b }
        com.loc.O000o0.O000000o(r6, r7);	 Catch:{ Throwable -> 0x002b }
    L_0x002b:
        r2 = r3;
    L_0x002c:
        monitor-exit(r1);	 Catch:{ all -> 0x002e }
        return r2;
    L_0x002e:
        r6 = move-exception;
        monitor-exit(r1);
        throw r6;
    L_0x0031:
        r6 = 0;
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O00O00Oo.O000000o(android.content.Context, com.loc.OO0Oo0):com.loc.O000Oo0");
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0025 */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:8|(5:10|11|12|13|14)|16|17|18) */
    public final com.loc.O00O00Oo.O000000o O000000o(com.loc.OO0Oo0 r4) {
        /*
        r3 = this;
        r0 = r3.O00000o0;
        monitor-enter(r0);
        r1 = O00000Oo(r4);	 Catch:{ all -> 0x0027 }
        if (r1 != 0) goto L_0x000c;
    L_0x0009:
        r4 = 0;
        monitor-exit(r0);	 Catch:{ all -> 0x0027 }
        return r4;
    L_0x000c:
        r4 = r4.O000000o();	 Catch:{ all -> 0x0027 }
        r1 = r3.O00000o0;	 Catch:{ all -> 0x0027 }
        r1 = r1.get(r4);	 Catch:{ all -> 0x0027 }
        r1 = (com.loc.O00O00Oo.O000000o) r1;	 Catch:{ all -> 0x0027 }
        if (r1 != 0) goto L_0x0025;
    L_0x001a:
        r2 = new com.loc.O00O00Oo$O000000o;	 Catch:{ Throwable -> 0x0025 }
        r2.<init>();	 Catch:{ Throwable -> 0x0025 }
        r1 = r3.O00000o0;	 Catch:{ Throwable -> 0x0024 }
        r1.put(r4, r2);	 Catch:{ Throwable -> 0x0024 }
    L_0x0024:
        r1 = r2;
    L_0x0025:
        monitor-exit(r0);	 Catch:{ all -> 0x0027 }
        return r1;
    L_0x0027:
        r4 = move-exception;
        monitor-exit(r0);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O00O00Oo.O000000o(com.loc.OO0Oo0):com.loc.O00O00Oo$O000000o");
    }

    /* Access modifiers changed, original: final */
    public final ExecutorService O000000o() {
        try {
            if (this.O00000oO == null || this.O00000oO.isShutdown()) {
                this.O00000oO = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(128), O00000o);
            }
        } catch (Throwable unused) {
        }
        return this.O00000oO;
    }
}
