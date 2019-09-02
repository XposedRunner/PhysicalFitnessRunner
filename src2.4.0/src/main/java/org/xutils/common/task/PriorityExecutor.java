package org.xutils.common.task;

import java.util.Comparator;
import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class PriorityExecutor implements Executor {
    private static final int CORE_POOL_SIZE = 5;
    private static final Comparator<Runnable> FIFO_CMP = new Comparator<Runnable>() {
        public int compare(Runnable runnable, Runnable runnable2) {
            if (!(runnable instanceof PriorityRunnable) || !(runnable2 instanceof PriorityRunnable)) {
                return 0;
            }
            PriorityRunnable priorityRunnable = (PriorityRunnable) runnable;
            PriorityRunnable priorityRunnable2 = (PriorityRunnable) runnable2;
            int ordinal = priorityRunnable.priority.ordinal() - priorityRunnable2.priority.ordinal();
            if (ordinal == 0) {
                ordinal = (int) (priorityRunnable.SEQ - priorityRunnable2.SEQ);
            }
            return ordinal;
        }
    };
    private static final Comparator<Runnable> FILO_CMP = new Comparator<Runnable>() {
        public int compare(Runnable runnable, Runnable runnable2) {
            if (!(runnable instanceof PriorityRunnable) || !(runnable2 instanceof PriorityRunnable)) {
                return 0;
            }
            PriorityRunnable priorityRunnable = (PriorityRunnable) runnable;
            PriorityRunnable priorityRunnable2 = (PriorityRunnable) runnable2;
            int ordinal = priorityRunnable.priority.ordinal() - priorityRunnable2.priority.ordinal();
            if (ordinal == 0) {
                ordinal = (int) (priorityRunnable2.SEQ - priorityRunnable.SEQ);
            }
            return ordinal;
        }
    };
    private static final int KEEP_ALIVE = 1;
    private static final int MAXIMUM_POOL_SIZE = 256;
    private static final AtomicLong SEQ_SEED = new AtomicLong(0);
    private static final ThreadFactory sThreadFactory = new ThreadFactory() {
        private final AtomicInteger mCount = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("xTID#");
            stringBuilder.append(this.mCount.getAndIncrement());
            return new Thread(runnable, stringBuilder.toString());
        }
    };
    private final ThreadPoolExecutor mThreadPoolExecutor;

    public PriorityExecutor(int i, boolean z) {
        this.mThreadPoolExecutor = new ThreadPoolExecutor(i, 256, 1, TimeUnit.SECONDS, new PriorityBlockingQueue(256, z ? FIFO_CMP : FILO_CMP), sThreadFactory);
    }

    public PriorityExecutor(boolean z) {
        this(5, z);
    }

    public void execute(Runnable runnable) {
        if (runnable instanceof PriorityRunnable) {
            ((PriorityRunnable) runnable).SEQ = SEQ_SEED.getAndIncrement();
        }
        this.mThreadPoolExecutor.execute(runnable);
    }

    public int getPoolSize() {
        return this.mThreadPoolExecutor.getCorePoolSize();
    }

    public ThreadPoolExecutor getThreadPoolExecutor() {
        return this.mThreadPoolExecutor;
    }

    public boolean isBusy() {
        return this.mThreadPoolExecutor.getActiveCount() >= this.mThreadPoolExecutor.getCorePoolSize();
    }

    public void setPoolSize(int i) {
        if (i > 0) {
            this.mThreadPoolExecutor.setCorePoolSize(i);
        }
    }
}
