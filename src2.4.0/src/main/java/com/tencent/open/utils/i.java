package com.tencent.open.utils;

import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ProGuard */
public final class i {
    public static final Executor a = c();
    private static Object b = new Object();
    private static Handler c;
    private static HandlerThread d;

    /* compiled from: ProGuard */
    private static class a implements Executor {
        final Queue<Runnable> a;
        Runnable b;

        private a() {
            this.a = new LinkedList();
        }

        /* Access modifiers changed, original: protected|declared_synchronized */
        public synchronized void a() {
            Runnable runnable = (Runnable) this.a.poll();
            this.b = runnable;
            if (runnable != null) {
                i.a.execute(this.b);
            }
        }

        public synchronized void execute(final Runnable runnable) {
            this.a.offer(new Runnable() {
                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        a.this.a();
                    }
                }
            });
            if (this.b == null) {
                a();
            }
        }
    }

    public static Handler a() {
        if (c == null) {
            synchronized (i.class) {
                d = new HandlerThread("SDK_SUB");
                d.start();
                c = new Handler(d.getLooper());
            }
        }
        return c;
    }

    public static void a(Runnable runnable) {
        a().post(runnable);
    }

    public static Executor b() {
        return new a();
    }

    private static Executor c() {
        Executor executor;
        if (VERSION.SDK_INT >= 11) {
            Executor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new LinkedBlockingQueue());
        } else {
            try {
                Field declaredField = AsyncTask.class.getDeclaredField("sExecutor");
                declaredField.setAccessible(true);
                executor = (Executor) declaredField.get(null);
            } catch (Exception unused) {
                Executor threadPoolExecutor2 = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new LinkedBlockingQueue());
            }
        }
        if (executor instanceof ThreadPoolExecutor) {
            ((ThreadPoolExecutor) executor).setCorePoolSize(3);
        }
        return executor;
    }
}
