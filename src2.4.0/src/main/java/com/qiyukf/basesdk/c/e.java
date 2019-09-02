package com.qiyukf.basesdk.c;

import android.os.Build.VERSION;
import java.util.Comparator;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class e implements Executor {
    public static final Executor a = new Executor() {
        public final void execute(Runnable runnable) {
            runnable.run();
        }
    };
    public static a b = new a(3, 5, true);
    public static a c = new a(1, 1, false);
    Comparator<Runnable> d = new Comparator<Runnable>() {
        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return b.a((b) ((Runnable) obj), (b) ((Runnable) obj2));
        }
    };
    private final String e;
    private final a f;
    private ExecutorService g;

    public static class a {
        public int a;
        public int b;
        public int c = 30000;
        public boolean d;

        public a(int i, int i2, boolean z) {
            this.a = i;
            this.b = i2;
            this.d = z;
        }
    }

    private static class b implements Runnable {
        private static int a;
        private Runnable b;
        private int c;
        private int d;

        public b(Runnable runnable, int i) {
            int i2 = a;
            a = i2 + 1;
            this.d = i2;
            this.b = runnable;
            this.c = i;
        }

        public static final int a(b bVar, b bVar2) {
            return bVar.c != bVar2.c ? bVar2.c - bVar.c : bVar.d - bVar2.d;
        }

        public final void run() {
            if (this.b != null) {
                this.b.run();
            }
        }
    }

    static class c implements ThreadFactory {
        private final ThreadGroup a;
        private final AtomicInteger b = new AtomicInteger(1);
        private final String c;

        c(String str) {
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

    public e(String str, a aVar, boolean z) {
        this.e = str;
        this.f = aVar;
        if (z) {
            a();
        }
    }

    /* JADX WARNING: Missing block: B:11:0x0016, code skipped:
            return;
     */
    private void a(java.lang.Runnable r2) {
        /*
        r1 = this;
        monitor-enter(r1);
        r0 = r1.g;	 Catch:{ all -> 0x0017 }
        if (r0 == 0) goto L_0x0015;
    L_0x0005:
        r0 = r1.g;	 Catch:{ all -> 0x0017 }
        r0 = r0.isShutdown();	 Catch:{ all -> 0x0017 }
        if (r0 == 0) goto L_0x000e;
    L_0x000d:
        goto L_0x0015;
    L_0x000e:
        r0 = r1.g;	 Catch:{ all -> 0x0017 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.basesdk.c.e.a(java.lang.Runnable):void");
    }

    public final void a() {
        synchronized (this) {
            if (this.g == null || this.g.isShutdown()) {
                a aVar = this.f;
                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(aVar.a, aVar.b, (long) aVar.c, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(11, this.d), new c(this.e), new DiscardPolicy());
                boolean z = aVar.d;
                if (VERSION.SDK_INT >= 9) {
                    threadPoolExecutor.allowCoreThreadTimeOut(z);
                }
                this.g = threadPoolExecutor;
                return;
            }
        }
    }

    public final void a(Runnable runnable, int i) {
        a(new b(runnable, i));
    }

    public final void b() {
        ExecutorService executorService;
        synchronized (this) {
            if (this.g != null) {
                executorService = this.g;
                this.g = null;
            } else {
                executorService = null;
            }
        }
        if (executorService != null && !executorService.isShutdown()) {
            executorService.shutdown();
        }
    }

    public final void execute(Runnable runnable) {
        a(new b(runnable, 0));
    }
}
