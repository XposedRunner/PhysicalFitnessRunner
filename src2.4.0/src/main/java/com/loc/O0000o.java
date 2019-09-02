package com.loc;

import android.content.Context;
import android.os.Looper;
import java.lang.Thread.UncaughtExceptionHandler;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: SDKLogHandler */
public final class O0000o extends O0000Oo implements UncaughtExceptionHandler {
    private static ExecutorService O00000oO;
    private static Set<Integer> O00000oo = Collections.synchronizedSet(new HashSet());
    private static WeakReference<Context> O0000O0o;
    private static final ThreadFactory O0000OOo = new ThreadFactory() {
        private final AtomicInteger O000000o = new AtomicInteger(1);

        public final Thread newThread(Runnable runnable) {
            StringBuilder stringBuilder = new StringBuilder("pama#");
            stringBuilder.append(this.O000000o.getAndIncrement());
            return new Thread(runnable, stringBuilder.toString());
        }
    };
    private Context O00000o;
    private List O0000Oo0;

    private O0000o(Context context) {
        this.O00000o = context;
        try {
            this.O00000Oo = Thread.getDefaultUncaughtExceptionHandler();
            if (this.O00000Oo == null) {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.O00000o0 = true;
                return;
            }
            String obj = this.O00000Oo.toString();
            if (obj.startsWith("com.amap.apis.utils.core.dynamiccore") || (obj.indexOf("com.amap.api") == -1 && obj.indexOf("com.loc") == -1)) {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.O00000o0 = true;
                return;
            }
            this.O00000o0 = false;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:3:0x0005, B:12:0x0022] */
    /* JADX WARNING: Missing block: B:24:0x005b, code skipped:
            r3 = move-exception;
     */
    /* JADX WARNING: Missing block: B:26:?, code skipped:
            r3.printStackTrace();
     */
    public static synchronized com.loc.O0000o O000000o(android.content.Context r3, com.loc.OO0Oo0 r4) throws com.loc.OO00Oo0 {
        /*
        r0 = com.loc.O0000o.class;
        monitor-enter(r0);
        if (r4 != 0) goto L_0x000f;
    L_0x0005:
        r3 = new com.loc.OO00Oo0;	 Catch:{ all -> 0x000d }
        r4 = "sdk info is null";
        r3.<init>(r4);	 Catch:{ all -> 0x000d }
        throw r3;	 Catch:{ all -> 0x000d }
    L_0x000d:
        r3 = move-exception;
        goto L_0x006d;
    L_0x000f:
        r1 = r4.O000000o();	 Catch:{ all -> 0x000d }
        if (r1 == 0) goto L_0x0065;
    L_0x0015:
        r1 = "";
        r2 = r4.O000000o();	 Catch:{ all -> 0x000d }
        r1 = r1.equals(r2);	 Catch:{ all -> 0x000d }
        if (r1 == 0) goto L_0x0022;
    L_0x0021:
        goto L_0x0065;
    L_0x0022:
        r1 = new com.loc.O000O00o;	 Catch:{ Throwable -> 0x005b }
        r1.<init>();	 Catch:{ Throwable -> 0x005b }
        r1.O000000o(r3);	 Catch:{ Throwable -> 0x005b }
        r1 = O00000oo;	 Catch:{ Throwable -> 0x005b }
        r2 = r4.hashCode();	 Catch:{ Throwable -> 0x005b }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ Throwable -> 0x005b }
        r1 = r1.add(r2);	 Catch:{ Throwable -> 0x005b }
        if (r1 != 0) goto L_0x0040;
    L_0x003a:
        r3 = com.loc.O0000Oo.O000000o;	 Catch:{ Throwable -> 0x005b }
        r3 = (com.loc.O0000o) r3;	 Catch:{ Throwable -> 0x005b }
        monitor-exit(r0);
        return r3;
    L_0x0040:
        r1 = com.loc.O0000Oo.O000000o;	 Catch:{ Throwable -> 0x005b }
        if (r1 != 0) goto L_0x004c;
    L_0x0044:
        r1 = new com.loc.O0000o;	 Catch:{ Throwable -> 0x005b }
        r1.<init>(r3);	 Catch:{ Throwable -> 0x005b }
        com.loc.O0000Oo.O000000o = r1;	 Catch:{ Throwable -> 0x005b }
        goto L_0x0051;
    L_0x004c:
        r1 = com.loc.O0000Oo.O000000o;	 Catch:{ Throwable -> 0x005b }
        r2 = 0;
        r1.O00000o0 = r2;	 Catch:{ Throwable -> 0x005b }
    L_0x0051:
        r1 = com.loc.O0000Oo.O000000o;	 Catch:{ Throwable -> 0x005b }
        r2 = com.loc.O0000Oo.O000000o;	 Catch:{ Throwable -> 0x005b }
        r2 = r2.O00000o0;	 Catch:{ Throwable -> 0x005b }
        r1.O000000o(r3, r4, r2);	 Catch:{ Throwable -> 0x005b }
        goto L_0x005f;
    L_0x005b:
        r3 = move-exception;
        r3.printStackTrace();	 Catch:{ all -> 0x000d }
    L_0x005f:
        r3 = com.loc.O0000Oo.O000000o;	 Catch:{ all -> 0x000d }
        r3 = (com.loc.O0000o) r3;	 Catch:{ all -> 0x000d }
        monitor-exit(r0);
        return r3;
    L_0x0065:
        r3 = new com.loc.OO00Oo0;	 Catch:{ all -> 0x000d }
        r4 = "sdk name is invalid";
        r3.<init>(r4);	 Catch:{ all -> 0x000d }
        throw r3;	 Catch:{ all -> 0x000d }
    L_0x006d:
        monitor-exit(r0);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O0000o.O000000o(android.content.Context, com.loc.OO0Oo0):com.loc.O0000o");
    }

    public static void O000000o(OO0Oo0 oO0Oo0, String str, OO00Oo0 oO00Oo0) {
        if (oO00Oo0 != null) {
            O000000o(oO0Oo0, str, oO00Oo0.O00000o0(), oO00Oo0.O00000o(), oO00Oo0.O00000Oo());
        }
    }

    public static void O000000o(OO0Oo0 oO0Oo0, String str, String str2, String str3, String str4) {
        try {
            if (O0000Oo.O000000o != null) {
                StringBuilder stringBuilder = new StringBuilder("path:");
                stringBuilder.append(str);
                stringBuilder.append(",type:");
                stringBuilder.append(str2);
                stringBuilder.append(",gsid:");
                stringBuilder.append(str3);
                stringBuilder.append(",code:");
                stringBuilder.append(str4);
                O0000Oo.O000000o.O000000o(oO0Oo0, stringBuilder.toString(), "networkError");
            }
        } catch (Throwable unused) {
        }
    }

    public static synchronized void O00000Oo() {
        synchronized (O0000o.class) {
            try {
                if (O00000oO != null) {
                    O00000oO.shutdown();
                }
                O00O0O0o.O000000o();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                if (!(O0000Oo.O000000o == null || Thread.getDefaultUncaughtExceptionHandler() != O0000Oo.O000000o || O0000Oo.O000000o.O00000Oo == null)) {
                    Thread.setDefaultUncaughtExceptionHandler(O0000Oo.O000000o.O00000Oo);
                }
                O0000Oo.O000000o = null;
            } catch (Throwable th2) {
                th2.printStackTrace();
                return;
            }
        }
        return;
    }

    public static void O00000Oo(OO0Oo0 oO0Oo0, String str, String str2) {
        try {
            if (O0000Oo.O000000o != null) {
                O0000Oo.O000000o.O000000o(oO0Oo0, str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    public static void O00000Oo(Throwable th, String str, String str2) {
        try {
            if (O0000Oo.O000000o != null) {
                O0000Oo.O000000o.O000000o(th, 1, str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    public static synchronized ExecutorService O00000o() {
        ExecutorService executorService;
        synchronized (O0000o.class) {
            try {
                if (O00000oO == null || O00000oO.isShutdown()) {
                    O00000oO = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(256), O0000OOo);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            executorService = O00000oO;
        }
        return executorService;
    }

    public static void O00000o0() {
        if (O0000O0o == null || O0000O0o.get() == null) {
            if (O0000Oo.O000000o != null) {
                O0000Oo.O000000o.O000000o();
            }
            return;
        }
        O0000o00.O00000Oo((Context) O0000O0o.get());
    }

    /* Access modifiers changed, original: protected|final */
    public final void O000000o() {
        O0000o00.O00000Oo(this.O00000o);
    }

    /* Access modifiers changed, original: protected|final */
    public final void O000000o(final Context context, final OO0Oo0 oO0Oo0, final boolean z) {
        try {
            ExecutorService O00000o = O00000o();
            if (O00000o != null && !O00000o.isShutdown()) {
                O00000o.submit(new Runnable() {
                    public final void run() {
                        try {
                            synchronized (Looper.getMainLooper()) {
                                new O000OO(context, true).O000000o(oO0Oo0);
                            }
                            if (z) {
                                O00oOooO.O000000o(O0000o.this.O00000o);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }
        } catch (RejectedExecutionException unused) {
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void O000000o(OO0Oo0 oO0Oo0, String str, String str2) {
        O00oOooO.O00000Oo(oO0Oo0, this.O00000o, str2, str);
    }

    /* Access modifiers changed, original: protected|final */
    public final void O000000o(Throwable th, int i, String str, String str2) {
        O00oOooO.O000000o(this.O00000o, th, i, str, str2);
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        int i = 0;
        while (i < this.O0000Oo0.size() && i < 10) {
            try {
                this.O0000Oo0.get(i);
                i++;
            } catch (Throwable unused) {
            }
        }
        if (th != null) {
            O000000o(th, 0, null, null);
            if (this.O00000Oo != null) {
                try {
                    Thread.setDefaultUncaughtExceptionHandler(this.O00000Oo);
                } catch (Throwable unused2) {
                }
                this.O00000Oo.uncaughtException(thread, th);
            }
        }
    }
}
