package com.zjwh.android_wh_physicalfitness.utils;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* compiled from: AsyncExecutor */
public class O0000O0o {
    public static Handler O000000o = new Handler(Looper.getMainLooper());
    private static final String O00000Oo = "O0000O0o";
    private static ExecutorService O00000o0;

    /* compiled from: AsyncExecutor */
    public static abstract class O000000o<T> {
        public abstract T O000000o();

        /* Access modifiers changed, original: protected */
        public void O000000o(T t) {
        }

        /* Access modifiers changed, original: protected */
        public void O00000Oo() {
        }

        /* Access modifiers changed, original: protected */
        public void O00000o0() {
        }
    }

    public O0000O0o() {
        this(null);
    }

    public O0000O0o(ExecutorService executorService) {
        if (O00000o0 != null) {
            O000000o();
        }
        if (executorService == null) {
            O00000o0 = Executors.newCachedThreadPool();
        } else {
            O00000o0 = executorService;
        }
    }

    private <T> T O000000o(final O000000o<T> o000000o, final T t) {
        O000000o.post(new Runnable() {
            public void run() {
                o000000o.O000000o(t);
            }
        });
        return t;
    }

    public static synchronized void O000000o() {
        synchronized (O0000O0o.class) {
            if (!(O00000o0 == null || O00000o0.isShutdown())) {
                O00000o0.shutdownNow();
            }
            O00000o0 = null;
        }
    }

    private void O00000Oo(final O000000o o000000o) {
        O000000o.post(new Runnable() {
            public void run() {
                o000000o.O00000Oo();
            }
        });
    }

    public <T> FutureTask<T> O000000o(final O000000o<T> o000000o) {
        AnonymousClass2 anonymousClass2 = new FutureTask<T>(new Callable<T>() {
            public T call() throws Exception {
                return O0000O0o.this.O000000o(o000000o, o000000o.O000000o());
            }
        }) {
            /* Access modifiers changed, original: protected */
            public void done() {
                try {
                    get();
                } catch (InterruptedException e) {
                    Log.e(O0000O0o.O00000Oo, e.getMessage());
                    o000000o.O00000o0();
                    O0000O0o.this.O00000Oo(o000000o);
                    e.printStackTrace();
                } catch (ExecutionException e2) {
                    Log.e(O0000O0o.O00000Oo, e2.getMessage());
                    e2.printStackTrace();
                    throw new RuntimeException("An error occured while executing doInBackground()", e2.getCause());
                } catch (CancellationException e3) {
                    o000000o.O00000o0();
                    O0000O0o.this.O00000Oo(o000000o);
                    Log.e(O0000O0o.O00000Oo, e3.getMessage());
                    e3.printStackTrace();
                }
            }
        };
        O00000o0.execute(anonymousClass2);
        return anonymousClass2;
    }

    public <T> FutureTask<T> O000000o(Callable<T> callable) {
        FutureTask futureTask = new FutureTask(callable);
        O00000o0.execute(futureTask);
        return futureTask;
    }
}
