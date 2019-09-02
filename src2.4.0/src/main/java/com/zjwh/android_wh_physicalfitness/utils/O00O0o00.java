package com.zjwh.android_wh_physicalfitness.utils;

import android.os.Handler;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* compiled from: SafeAsyncTask */
public abstract class O00O0o00<ResultT> implements Callable<ResultT> {
    protected static final Executor DEFAULT_EXECUTOR = Executors.newFixedThreadPool(25);
    public static final int DEFAULT_POOL_SIZE = 25;
    public static final String TAG = "O00O0o00";
    protected Executor executor;
    protected FutureTask<Void> future;
    protected Handler handler;
    protected StackTraceElement[] launchLocation;

    public O00O0o00() {
        this.executor = DEFAULT_EXECUTOR;
    }

    public O00O0o00(Handler handler) {
        this.handler = handler;
        this.executor = DEFAULT_EXECUTOR;
    }

    public O00O0o00(Handler handler, Executor executor) {
        this.handler = handler;
        this.executor = executor;
    }

    public O00O0o00(Executor executor) {
        this.executor = executor;
    }

    public boolean cancel(boolean z) {
        if (this.future != null) {
            return this.future.cancel(z);
        }
        throw new UnsupportedOperationException("You cannot cancel this task before calling future()");
    }

    public void execute() {
        execute(Thread.currentThread().getStackTrace());
    }

    /* Access modifiers changed, original: protected */
    public void execute(StackTraceElement[] stackTraceElementArr) {
        this.launchLocation = stackTraceElementArr;
        this.executor.execute(future());
    }

    public O00O0o00<ResultT> executor(Executor executor) {
        this.executor = executor;
        return this;
    }

    public Executor executor() {
        return this.executor;
    }

    public FutureTask<Void> future() {
        this.future = new FutureTask(newTask());
        return this.future;
    }

    public Handler handler() {
        return this.handler;
    }

    public O00O0o00<ResultT> handler(Handler handler) {
        this.handler = handler;
        return this;
    }

    /* Access modifiers changed, original: protected */
    public O000000o<ResultT> newTask() {
        return new O000000o(this);
    }

    /* Access modifiers changed, original: protected */
    public void onException(Exception exception) throws RuntimeException {
        onThrowable(exception);
    }

    /* Access modifiers changed, original: protected */
    public void onFinally() throws RuntimeException {
    }

    /* Access modifiers changed, original: protected */
    public void onInterrupted(Exception exception) {
        onException(exception);
    }

    /* Access modifiers changed, original: protected */
    public void onPreExecute() throws Exception {
    }

    /* Access modifiers changed, original: protected */
    public void onSuccess(ResultT resultT) throws Exception {
    }

    /* Access modifiers changed, original: protected */
    public void onThrowable(Throwable th) throws RuntimeException {
        th.printStackTrace();
        kz.O00000oO(TAG, "Throwable caught during background processing");
    }
}
