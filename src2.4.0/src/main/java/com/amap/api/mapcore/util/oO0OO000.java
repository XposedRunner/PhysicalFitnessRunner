package com.amap.api.mapcore.util;

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
public class oO0OO000 {
    private static final oO0OO000 O000000o = new oO0OO000();
    private static final ThreadFactory O00000o = new O00000Oo();
    private final Map<String, oOo000Oo> O00000Oo = new HashMap();
    private final Map<String, O000000o> O00000o0 = new HashMap();
    private ExecutorService O00000oO = null;

    /* compiled from: LoaderFactory */
    class O000000o {
        volatile boolean O000000o = false;
        volatile boolean O00000Oo = false;

        O000000o() {
        }
    }

    /* compiled from: LoaderFactory */
    static class O00000Oo implements ThreadFactory {
        private final AtomicInteger O000000o = new AtomicInteger(1);

        O00000Oo() {
        }

        public Thread newThread(Runnable runnable) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("amapD#");
            stringBuilder.append(this.O000000o.getAndIncrement());
            return new Thread(runnable, stringBuilder.toString());
        }
    }

    private oO0OO000() {
    }

    public static oO0OO000 O00000Oo() {
        return O000000o;
    }

    private boolean O00000Oo(o0OO0o00 o0oo0o00) {
        return (o0oo0o00 == null || TextUtils.isEmpty(o0oo0o00.O00000Oo()) || TextUtils.isEmpty(o0oo0o00.O000000o())) ? false : true;
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0025 */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:8|(5:10|11|12|13|14)|16|17|18) */
    public com.amap.api.mapcore.util.oO0OO000.O000000o O000000o(com.amap.api.mapcore.util.o0OO0o00 r4) {
        /*
        r3 = this;
        r0 = r3.O00000o0;
        monitor-enter(r0);
        r1 = r3.O00000Oo(r4);	 Catch:{ all -> 0x0027 }
        if (r1 != 0) goto L_0x000c;
    L_0x0009:
        r4 = 0;
        monitor-exit(r0);	 Catch:{ all -> 0x0027 }
        return r4;
    L_0x000c:
        r4 = r4.O000000o();	 Catch:{ all -> 0x0027 }
        r1 = r3.O00000o0;	 Catch:{ all -> 0x0027 }
        r1 = r1.get(r4);	 Catch:{ all -> 0x0027 }
        r1 = (com.amap.api.mapcore.util.oO0OO000.O000000o) r1;	 Catch:{ all -> 0x0027 }
        if (r1 != 0) goto L_0x0025;
    L_0x001a:
        r2 = new com.amap.api.mapcore.util.oO0OO000$O000000o;	 Catch:{ Throwable -> 0x0025 }
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
        monitor-exit(r0);	 Catch:{ all -> 0x0027 }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.oO0OO000.O000000o(com.amap.api.mapcore.util.o0OO0o00):com.amap.api.mapcore.util.oO0OO000$O000000o");
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x002d */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:5|6|(5:8|9|10|11|12)|14|15) */
    public com.amap.api.mapcore.util.oOo000Oo O000000o(android.content.Context r7, com.amap.api.mapcore.util.o0OO0o00 r8) throws java.lang.Exception {
        /*
        r6 = this;
        r0 = r6.O00000Oo(r8);
        if (r0 == 0) goto L_0x0032;
    L_0x0006:
        if (r7 != 0) goto L_0x0009;
    L_0x0008:
        goto L_0x0032;
    L_0x0009:
        r0 = r8.O000000o();
        r1 = r6.O00000Oo;
        monitor-enter(r1);
        r2 = r6.O00000Oo;	 Catch:{ all -> 0x002f }
        r2 = r2.get(r0);	 Catch:{ all -> 0x002f }
        r2 = (com.amap.api.mapcore.util.oOo000Oo) r2;	 Catch:{ all -> 0x002f }
        if (r2 != 0) goto L_0x002d;
    L_0x001a:
        r3 = new com.amap.api.mapcore.util.oOo000o0;	 Catch:{ Throwable -> 0x002d }
        r4 = r7.getApplicationContext();	 Catch:{ Throwable -> 0x002d }
        r5 = 1;
        r3.<init>(r4, r8, r5);	 Catch:{ Throwable -> 0x002d }
        r2 = r6.O00000Oo;	 Catch:{ Throwable -> 0x002c }
        r2.put(r0, r3);	 Catch:{ Throwable -> 0x002c }
        com.amap.api.mapcore.util.oO00OOo0.O000000o(r7, r8);	 Catch:{ Throwable -> 0x002c }
    L_0x002c:
        r2 = r3;
    L_0x002d:
        monitor-exit(r1);	 Catch:{ all -> 0x002f }
        return r2;
    L_0x002f:
        r7 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x002f }
        throw r7;
    L_0x0032:
        r7 = 0;
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.oO0OO000.O000000o(android.content.Context, com.amap.api.mapcore.util.o0OO0o00):com.amap.api.mapcore.util.oOo000Oo");
    }

    public ExecutorService O000000o() {
        try {
            if (this.O00000oO == null || this.O00000oO.isShutdown()) {
                this.O00000oO = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(128), O00000o);
            }
        } catch (Throwable unused) {
        }
        return this.O00000oO;
    }
}
