package com.amap.api.mapcore.util;

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
public class ooOOOOoo extends oO0OoOO0 implements UncaughtExceptionHandler {
    private static ExecutorService O00000oO;
    private static Set<Integer> O00000oo = Collections.synchronizedSet(new HashSet());
    private static WeakReference<Context> O0000O0o;
    private static final ThreadFactory O0000OOo = new ThreadFactory() {
        private final AtomicInteger O000000o = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("pama#");
            stringBuilder.append(this.O000000o.getAndIncrement());
            return new Thread(runnable, stringBuilder.toString());
        }
    };
    private Context O00000o;
    private List<O000000o> O0000Oo0;

    /* compiled from: SDKLogHandler */
    public interface O000000o {
        void O000000o(Thread thread, Throwable th);
    }

    private ooOOOOoo(Context context, o0OO0o00 o0oo0o00) {
        this.O00000o = context;
        O00000oo();
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:3:0x0005, B:12:0x0022] */
    /* JADX WARNING: Missing block: B:24:0x005b, code skipped:
            r3 = move-exception;
     */
    /* JADX WARNING: Missing block: B:26:?, code skipped:
            r3.printStackTrace();
     */
    public static synchronized com.amap.api.mapcore.util.ooOOOOoo O000000o(android.content.Context r3, com.amap.api.mapcore.util.o0OO0o00 r4) throws com.amap.api.mapcore.util.o0O0oo0o {
        /*
        r0 = com.amap.api.mapcore.util.ooOOOOoo.class;
        monitor-enter(r0);
        if (r4 != 0) goto L_0x000f;
    L_0x0005:
        r3 = new com.amap.api.mapcore.util.o0O0oo0o;	 Catch:{ all -> 0x000d }
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
        r1 = new com.amap.api.mapcore.util.oO000Oo0;	 Catch:{ Throwable -> 0x005b }
        r1.<init>();	 Catch:{ Throwable -> 0x005b }
        r1.O000000o(r3);	 Catch:{ Throwable -> 0x005b }
        r1 = O00000oo;	 Catch:{ Throwable -> 0x005b }
        r2 = r4.hashCode();	 Catch:{ Throwable -> 0x005b }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ Throwable -> 0x005b }
        r1 = r1.add(r2);	 Catch:{ Throwable -> 0x005b }
        if (r1 != 0) goto L_0x0040;
    L_0x003a:
        r3 = com.amap.api.mapcore.util.oO0OoOO0.O000000o;	 Catch:{ Throwable -> 0x005b }
        r3 = (com.amap.api.mapcore.util.ooOOOOoo) r3;	 Catch:{ Throwable -> 0x005b }
        monitor-exit(r0);
        return r3;
    L_0x0040:
        r1 = com.amap.api.mapcore.util.oO0OoOO0.O000000o;	 Catch:{ Throwable -> 0x005b }
        if (r1 != 0) goto L_0x004c;
    L_0x0044:
        r1 = new com.amap.api.mapcore.util.ooOOOOoo;	 Catch:{ Throwable -> 0x005b }
        r1.<init>(r3, r4);	 Catch:{ Throwable -> 0x005b }
        com.amap.api.mapcore.util.oO0OoOO0.O000000o = r1;	 Catch:{ Throwable -> 0x005b }
        goto L_0x0051;
    L_0x004c:
        r1 = com.amap.api.mapcore.util.oO0OoOO0.O000000o;	 Catch:{ Throwable -> 0x005b }
        r2 = 0;
        r1.O00000o0 = r2;	 Catch:{ Throwable -> 0x005b }
    L_0x0051:
        r1 = com.amap.api.mapcore.util.oO0OoOO0.O000000o;	 Catch:{ Throwable -> 0x005b }
        r2 = com.amap.api.mapcore.util.oO0OoOO0.O000000o;	 Catch:{ Throwable -> 0x005b }
        r2 = r2.O00000o0;	 Catch:{ Throwable -> 0x005b }
        r1.O000000o(r3, r4, r2);	 Catch:{ Throwable -> 0x005b }
        goto L_0x005f;
    L_0x005b:
        r3 = move-exception;
        r3.printStackTrace();	 Catch:{ all -> 0x000d }
    L_0x005f:
        r3 = com.amap.api.mapcore.util.oO0OoOO0.O000000o;	 Catch:{ all -> 0x000d }
        r3 = (com.amap.api.mapcore.util.ooOOOOoo) r3;	 Catch:{ all -> 0x000d }
        monitor-exit(r0);
        return r3;
    L_0x0065:
        r3 = new com.amap.api.mapcore.util.o0O0oo0o;	 Catch:{ all -> 0x000d }
        r4 = "sdk name is invalid";
        r3.<init>(r4);	 Catch:{ all -> 0x000d }
        throw r3;	 Catch:{ all -> 0x000d }
    L_0x006d:
        monitor-exit(r0);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.ooOOOOoo.O000000o(android.content.Context, com.amap.api.mapcore.util.o0OO0o00):com.amap.api.mapcore.util.ooOOOOoo");
    }

    public static void O000000o(Context context) {
        if (context != null) {
            try {
                O0000O0o = new WeakReference(context.getApplicationContext());
            } catch (Throwable unused) {
            }
        }
    }

    public static void O000000o(o0OO0o00 o0oo0o00, String str, o0O0oo0o o0o0oo0o) {
        if (o0o0oo0o != null) {
            O000000o(o0oo0o00, str, o0o0oo0o.O00000o0(), o0o0oo0o.O00000o(), o0o0oo0o.O00000Oo());
        }
    }

    public static void O000000o(o0OO0o00 o0oo0o00, String str, String str2, String str3, String str4) {
        try {
            if (oO0OoOO0.O000000o != null) {
                StringBuilder stringBuilder = new StringBuilder("path:");
                stringBuilder.append(str);
                stringBuilder.append(",type:");
                stringBuilder.append(str2);
                stringBuilder.append(",gsid:");
                stringBuilder.append(str3);
                stringBuilder.append(",code:");
                stringBuilder.append(str4);
                oO0OoOO0.O000000o.O000000o(o0oo0o00, stringBuilder.toString(), "networkError");
            }
        } catch (Throwable unused) {
        }
    }

    private void O000000o(Thread thread, Throwable th) {
        int i = 0;
        while (i < this.O0000Oo0.size() && i < 10) {
            try {
                O000000o o000000o = (O000000o) this.O0000Oo0.get(i);
                if (o000000o != null) {
                    o000000o.O000000o(thread, th);
                }
                i++;
            } catch (Throwable unused) {
                return;
            }
        }
    }

    public static synchronized void O00000Oo() {
        synchronized (ooOOOOoo.class) {
            try {
                if (O00000oO != null) {
                    O00000oO.shutdown();
                }
                oOo0o0oO.O000000o();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                if (!(oO0OoOO0.O000000o == null || Thread.getDefaultUncaughtExceptionHandler() != oO0OoOO0.O000000o || oO0OoOO0.O000000o.O00000Oo == null)) {
                    Thread.setDefaultUncaughtExceptionHandler(oO0OoOO0.O000000o.O00000Oo);
                }
                oO0OoOO0.O000000o = null;
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return;
    }

    public static void O00000Oo(o0OO0o00 o0oo0o00, String str, String str2) {
        try {
            if (oO0OoOO0.O000000o != null) {
                oO0OoOO0.O000000o.O000000o(o0oo0o00, str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    public static void O00000Oo(o0OO0o00 o0oo0o00, String str, String str2, String str3) {
        try {
            if (oO0OoOO0.O000000o != null) {
                oO0OoOO0.O000000o.O000000o(o0oo0o00, str, str2, str3);
            }
        } catch (Throwable unused) {
        }
    }

    public static synchronized ExecutorService O00000o() {
        ExecutorService executorService;
        synchronized (ooOOOOoo.class) {
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
            if (oO0OoOO0.O000000o != null) {
                oO0OoOO0.O000000o.O000000o();
            }
            return;
        }
        oO0Oo0oo.O00000Oo((Context) O0000O0o.get());
    }

    public static void O00000o0(Throwable th, String str, String str2) {
        try {
            if (oO0OoOO0.O000000o != null) {
                oO0OoOO0.O000000o.O000000o(th, 1, str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    public static synchronized ooOOOOoo O00000oO() {
        ooOOOOoo oooooooo;
        synchronized (ooOOOOoo.class) {
            oooooooo = (ooOOOOoo) oO0OoOO0.O000000o;
        }
        return oooooooo;
    }

    private void O00000oo() {
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

    /* Access modifiers changed, original: protected */
    public void O000000o() {
        oO0Oo0oo.O00000Oo(this.O00000o);
    }

    /* Access modifiers changed, original: protected */
    public void O000000o(final Context context, final o0OO0o00 o0oo0o00, final boolean z) {
        try {
            ExecutorService O00000o = O00000o();
            if (O00000o != null) {
                if (!O00000o.isShutdown()) {
                    O00000o.submit(new Runnable() {
                        public void run() {
                            try {
                                synchronized (Looper.getMainLooper()) {
                                    new oO00O0o0(context, true).O000000o(o0oo0o00);
                                }
                                if (z) {
                                    oO0OOo0o.O000000o(ooOOOOoo.this.O00000o);
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }
            }
        } catch (RejectedExecutionException unused) {
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* Access modifiers changed, original: protected */
    public void O000000o(o0OO0o00 o0oo0o00, String str, String str2) {
        oO0OOo0o.O00000Oo(o0oo0o00, this.O00000o, str2, str);
    }

    public void O000000o(o0OO0o00 o0oo0o00, String str, String str2, String str3) {
        oO0OOo0o.O000000o(this.O00000o, o0oo0o00, str, 0, str2, str3);
    }

    /* Access modifiers changed, original: protected */
    public void O000000o(Throwable th, int i, String str, String str2) {
        oO0OOo0o.O000000o(this.O00000o, th, i, str, str2);
    }

    public void O00000Oo(Throwable th, String str, String str2) {
        if (th != null) {
            try {
                O000000o(th, 1, str, str2);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        O000000o(thread, th);
        if (th != null) {
            O000000o(th, 0, null, null);
            if (this.O00000Oo != null) {
                try {
                    Thread.setDefaultUncaughtExceptionHandler(this.O00000Oo);
                } catch (Throwable unused) {
                }
                this.O00000Oo.uncaughtException(thread, th);
            }
        }
    }
}
