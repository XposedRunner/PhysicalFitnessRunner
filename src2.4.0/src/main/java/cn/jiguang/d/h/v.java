package cn.jiguang.d.h;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class v extends ThreadPoolExecutor {
    private final int a;

    private v(int i, int i2, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, int i3) {
        super(i, i2, 10, TimeUnit.SECONDS, blockingQueue, threadFactory);
        this.a = i3;
    }

    public static v a(String str, int i) {
        return new v(0, 30, new SynchronousQueue(), new u(str, 0), 0);
    }

    public static v a(String str, int i, int i2) {
        return new v(1, 1, i2 < 0 ? new LinkedBlockingDeque() : new LinkedBlockingDeque(i2), new u(str, i), i);
    }

    public static v a(String str, int i, int i2, int i3) {
        return new v(15, 15, new PriorityBlockingQueue(), new u(str, 0), 0);
    }

    /* Access modifiers changed, original: protected|final */
    public final void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        try {
            if (this.a > 0) {
                thread.setPriority(this.a);
                return;
            }
            if (runnable instanceof w) {
                thread.setPriority(((w) runnable).a);
            }
        } catch (Throwable unused) {
        }
    }
}
