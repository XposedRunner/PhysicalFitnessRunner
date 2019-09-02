package com.amap.api.mapcore.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: AbstractAsyncTask */
public abstract class OO0Oo00<Params, Progress, Result> {
    public static final Executor O000000o = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, O00000oO, O00000o, new DiscardOldestPolicy());
    public static final Executor O00000Oo;
    private static final ThreadFactory O00000o = new ThreadFactory() {
        private final AtomicInteger O000000o = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("AbstractAsyncTask #");
            stringBuilder.append(this.O000000o.getAndIncrement());
            return new Thread(runnable, stringBuilder.toString());
        }
    };
    public static final Executor O00000o0 = new ThreadPoolExecutor(2, 2, 1, TimeUnit.SECONDS, new LinkedBlockingQueue(), new OOO0o00("AMapDUAL_THREAD_EXECUTOR"), new AbortPolicy());
    private static final BlockingQueue<Runnable> O00000oO = new LinkedBlockingQueue(10);
    private static final O00000o0 O00000oo = new O00000o0(Looper.getMainLooper());
    private static volatile Executor O0000O0o = O00000Oo;
    private final O000000o<Params, Result> O0000OOo = new O000000o<Params, Result>() {
        public Result call() throws Exception {
            OO0Oo00.this.O0000Ooo.set(true);
            return OO0Oo00.this.O00000o(OO0Oo00.this.O000000o(this.O00000Oo));
        }
    };
    private volatile O0000O0o O0000Oo = O0000O0o.PENDING;
    private final FutureTask<Result> O0000Oo0 = new FutureTask<Result>(this.O0000OOo) {
        /* Access modifiers changed, original: protected */
        public void done() {
            try {
                OO0Oo00.this.O00000o0(OO0Oo00.this.O0000Oo0.get());
            } catch (InterruptedException e) {
                Log.w("AbstractAsyncTask", e);
            } catch (ExecutionException e2) {
                throw new RuntimeException("An error occured while executing doInBackground()", e2.getCause());
            } catch (CancellationException unused) {
                OO0Oo00.this.O00000o0(null);
            }
        }
    };
    private final AtomicBoolean O0000OoO = new AtomicBoolean();
    private final AtomicBoolean O0000Ooo = new AtomicBoolean();

    /* compiled from: AbstractAsyncTask */
    private static abstract class O000000o<Params, Result> implements Callable<Result> {
        Params[] O00000Oo;

        private O000000o() {
        }

        /* synthetic */ O000000o(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* compiled from: AbstractAsyncTask */
    private static class O00000Oo<Data> {
        final OO0Oo00 O000000o;
        final Data[] O00000Oo;

        O00000Oo(OO0Oo00 oO0Oo00, Data... dataArr) {
            this.O000000o = oO0Oo00;
            this.O00000Oo = dataArr;
        }
    }

    /* compiled from: AbstractAsyncTask */
    private static class O00000o0 extends Handler {
        public O00000o0(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (message.obj != null && (message.obj instanceof O00000Oo)) {
                O00000Oo o00000Oo = (O00000Oo) message.obj;
                switch (message.what) {
                    case 1:
                        o00000Oo.O000000o.O00000oO(o00000Oo.O00000Oo[0]);
                        return;
                    case 2:
                        o00000Oo.O000000o.O00000Oo(o00000Oo.O00000Oo);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* compiled from: AbstractAsyncTask */
    private static class O00000o implements Executor {
        final ArrayDeque<Runnable> O000000o;
        Runnable O00000Oo;

        private O00000o() {
            this.O000000o = new ArrayDeque();
        }

        /* synthetic */ O00000o(AnonymousClass1 anonymousClass1) {
            this();
        }

        /* Access modifiers changed, original: protected|declared_synchronized */
        public synchronized void O000000o() {
            Runnable runnable = (Runnable) this.O000000o.poll();
            this.O00000Oo = runnable;
            if (runnable != null) {
                OO0Oo00.O000000o.execute(this.O00000Oo);
            }
        }

        public synchronized void execute(final Runnable runnable) {
            this.O000000o.offer(new Runnable() {
                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        O00000o.this.O000000o();
                    }
                }
            });
            if (this.O00000Oo == null) {
                O000000o();
            }
        }
    }

    /* compiled from: AbstractAsyncTask */
    public enum O0000O0o {
        PENDING,
        RUNNING,
        FINISHED
    }

    static {
        Executor o00000o;
        if (OOo000.O00000o0()) {
            o00000o = new O00000o();
        } else {
            Executor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 1, TimeUnit.SECONDS, new LinkedBlockingQueue(), new OOO0o00("AMapSERIAL_EXECUTOR"), new AbortPolicy());
        }
        O00000Oo = o00000o;
    }

    private Result O00000o(Result result) {
        O00000oo.obtainMessage(1, new O00000Oo(this, result)).sendToTarget();
        return result;
    }

    private void O00000o0(Result result) {
        if (!this.O0000Ooo.get()) {
            O00000o(result);
        }
    }

    private void O00000oO(Result result) {
        if (O00000o()) {
            O00000Oo((Object) result);
        } else {
            O000000o((Object) result);
        }
        this.O0000Oo = O0000O0o.FINISHED;
    }

    public final O0000O0o O000000o() {
        return this.O0000Oo;
    }

    public final OO0Oo00<Params, Progress, Result> O000000o(Executor executor, Params... paramsArr) {
        if (this.O0000Oo != O0000O0o.PENDING) {
            switch (this.O0000Oo) {
                case RUNNING:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case FINISHED:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.O0000Oo = O0000O0o.RUNNING;
        O00000Oo();
        this.O0000OOo.O00000Oo = paramsArr;
        executor.execute(this.O0000Oo0);
        return this;
    }

    public abstract Result O000000o(Params... paramsArr);

    /* Access modifiers changed, original: protected */
    public void O000000o(Result result) {
    }

    public final boolean O000000o(boolean z) {
        this.O0000OoO.set(true);
        return this.O0000Oo0.cancel(z);
    }

    /* Access modifiers changed, original: protected */
    public void O00000Oo() {
    }

    /* Access modifiers changed, original: protected */
    public void O00000Oo(Result result) {
        O00000o0();
    }

    /* Access modifiers changed, original: protected|varargs */
    public void O00000Oo(Progress... progressArr) {
    }

    public final boolean O00000o() {
        return this.O0000OoO.get();
    }

    public final OO0Oo00<Params, Progress, Result> O00000o0(Params... paramsArr) {
        return O000000o(O0000O0o, (Object[]) paramsArr);
    }

    /* Access modifiers changed, original: protected */
    public void O00000o0() {
    }
}
