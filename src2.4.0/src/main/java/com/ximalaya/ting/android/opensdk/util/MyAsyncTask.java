package com.ximalaya.ting.android.opensdk.util;

import android.os.AsyncTask;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class MyAsyncTask<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {
    private static final int CORE_POOL_SIZE = Math.max(2, Math.min(CPU_COUNT - 1, 4));
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final int KEEP_ALIVE_SECONDS = 30;
    private static final int MAXIMUM_POOL_SIZE = ((CPU_COUNT * 2) + 1);
    public static final ThreadPoolExecutor MY_THREAD_POOL_EXECUTOR;
    public static String TAG = "MyAsyncTask";
    private static final BlockingQueue<Runnable> mPoolWorkQueue = new LinkedBlockingQueue();
    private static final ThreadFactory mThreadFactory = new ThreadFactory() {
        private final AtomicInteger mCount = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("MyAsyncTask #");
            stringBuilder.append(this.mCount.getAndIncrement());
            return new Thread(runnable, stringBuilder.toString());
        }
    };

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, 30, TimeUnit.SECONDS, mPoolWorkQueue, mThreadFactory);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        MY_THREAD_POOL_EXECUTOR = threadPoolExecutor;
    }

    public static String dumpAllThreadStack() {
        Map allStackTraces = Thread.getAllStackTraces();
        if (allStackTraces == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Thread thread : allStackTraces.keySet()) {
            if (thread != null) {
                long id = thread.getId();
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("thread id: ");
                stringBuilder2.append(id);
                stringBuilder2.append(", name: ");
                stringBuilder2.append(thread.getName());
                stringBuilder2.append(", state:");
                stringBuilder2.append(thread.getState());
                stringBuilder2.append(", priority:");
                stringBuilder2.append(thread.getPriority());
                stringBuilder.append(stringBuilder2.toString());
                stringBuilder.append("\n");
                StackTraceElement[] stackTrace = thread.getStackTrace();
                if (stackTrace != null) {
                    for (Object obj : stackTrace) {
                        stringBuilder.append("\t");
                        stringBuilder.append(obj);
                        stringBuilder.append("\n");
                    }
                }
            }
        }
        return stringBuilder.toString();
    }

    public static void execute(Runnable runnable) {
        handleThreadException();
        MY_THREAD_POOL_EXECUTOR.execute(runnable);
    }

    public static void execute(Runnable runnable, boolean z) {
        handleThreadException();
        if (MY_THREAD_POOL_EXECUTOR.getQueue().size() < 10 || !z) {
            execute(runnable);
        }
    }

    private static void handleThreadException() {
    }

    public final MyAsyncTask<Params, Progress, Result> myexec(Params... paramsArr) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MyAsyncTask --- myexec ");
        stringBuilder.append(this);
        Logger.i("MyAsyncTask", stringBuilder.toString());
        handleThreadException();
        executeOnExecutor(MY_THREAD_POOL_EXECUTOR, paramsArr);
        return this;
    }
}
