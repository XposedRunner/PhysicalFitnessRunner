package com.qiyukf.nimlib.d.a.c;

import android.os.Build.VERSION;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class b implements Executor {
    public static final Executor a = new Executor() {
        public final void execute(Runnable runnable) {
            runnable.run();
        }
    };
    private final String b;
    private final a c;
    private ExecutorService d;

    public static class a {
        public int a = 1;
        public int b = 2;
        public int c = 10000;
        public boolean d = true;
    }

    static class b implements ThreadFactory {
        private final ThreadGroup a;
        private final AtomicInteger b = new AtomicInteger(1);
        private final String c;

        b(String str) {
            SecurityManager securityManager = System.getSecurityManager();
            this.a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("#");
            this.c = stringBuilder.toString();
        }

        public final Thread newThread(Runnable runnable) {
            ThreadGroup threadGroup = this.a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.c);
            stringBuilder.append(this.b.getAndIncrement());
            Thread thread = new Thread(threadGroup, runnable, stringBuilder.toString(), 0);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    public b(String str, a aVar) {
        this(str, aVar, (byte) 0);
    }

    private b(String str, a aVar, byte b) {
        this.b = str;
        this.c = aVar;
        synchronized (this) {
            if (this.d == null || this.d.isShutdown()) {
                a aVar2 = this.c;
                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(aVar2.a, aVar2.b, (long) aVar2.c, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(20), new b(this.b), new DiscardPolicy());
                if (VERSION.SDK_INT > 8) {
                    threadPoolExecutor.allowCoreThreadTimeOut(aVar2.d);
                }
                this.d = threadPoolExecutor;
                return;
            }
        }
    }

    /* JADX WARNING: Missing block: B:11:0x0016, code skipped:
            return;
     */
    public final void execute(java.lang.Runnable r2) {
        /*
        r1 = this;
        monitor-enter(r1);
        r0 = r1.d;	 Catch:{ all -> 0x0017 }
        if (r0 == 0) goto L_0x0015;
    L_0x0005:
        r0 = r1.d;	 Catch:{ all -> 0x0017 }
        r0 = r0.isShutdown();	 Catch:{ all -> 0x0017 }
        if (r0 == 0) goto L_0x000e;
    L_0x000d:
        goto L_0x0015;
    L_0x000e:
        r0 = r1.d;	 Catch:{ all -> 0x0017 }
        r0.execute(r2);	 Catch:{ all -> 0x0017 }
        monitor-exit(r1);	 Catch:{ all -> 0x0017 }
        return;
    L_0x0015:
        monitor-exit(r1);	 Catch:{ all -> 0x0017 }
        return;
    L_0x0017:
        r2 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0017 }
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.d.a.c.b.execute(java.lang.Runnable):void");
    }
}
