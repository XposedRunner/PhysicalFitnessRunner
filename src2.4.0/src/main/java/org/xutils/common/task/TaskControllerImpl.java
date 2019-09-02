package org.xutils.common.task;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicInteger;
import org.xutils.common.Callback.Cancelable;
import org.xutils.common.Callback.CancelledException;
import org.xutils.common.Callback.GroupCallback;
import org.xutils.common.TaskController;
import org.xutils.common.util.LogUtil;
import org.xutils.x.Ext;

public final class TaskControllerImpl implements TaskController {
    private static volatile TaskController instance;

    private TaskControllerImpl() {
    }

    public static void registerInstance() {
        if (instance == null) {
            synchronized (TaskController.class) {
                if (instance == null) {
                    instance = new TaskControllerImpl();
                }
            }
        }
        Ext.setTaskController(instance);
    }

    public void autoPost(Runnable runnable) {
        if (runnable != null) {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                runnable.run();
            } else {
                TaskProxy.sHandler.post(runnable);
            }
        }
    }

    public void post(Runnable runnable) {
        if (runnable != null) {
            TaskProxy.sHandler.post(runnable);
        }
    }

    public void postDelayed(Runnable runnable, long j) {
        if (runnable != null) {
            TaskProxy.sHandler.postDelayed(runnable, j);
        }
    }

    public void removeCallbacks(Runnable runnable) {
        TaskProxy.sHandler.removeCallbacks(runnable);
    }

    public void run(Runnable runnable) {
        if (TaskProxy.sDefaultExecutor.isBusy()) {
            new Thread(runnable).start();
        } else {
            TaskProxy.sDefaultExecutor.execute(runnable);
        }
    }

    public <T> AbsTask<T> start(AbsTask<T> absTask) {
        TaskProxy taskProxy = absTask instanceof TaskProxy ? (TaskProxy) absTask : new TaskProxy(absTask);
        try {
            taskProxy.doBackground();
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
        }
        return taskProxy;
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x001a A:{Splitter:B:1:0x0001, ExcHandler: Throwable (r0_5 'th' java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:6:0x0013, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:7:0x0014, code skipped:
            r2 = r1;
            r1 = r0;
            r0 = r2;
     */
    /* JADX WARNING: Missing block: B:9:0x001a, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:12:?, code skipped:
            r4.onError(r0, false);
     */
    /* JADX WARNING: Missing block: B:17:0x0028, code skipped:
            r4.onFinished();
     */
    public <T> T startSync(org.xutils.common.task.AbsTask<T> r4) throws java.lang.Throwable {
        /*
        r3 = this;
        r0 = 0;
        r4.onWaiting();	 Catch:{ CancelledException -> 0x0020, Throwable -> 0x001a }
        r4.onStarted();	 Catch:{ CancelledException -> 0x0020, Throwable -> 0x001a }
        r1 = r4.doBackground();	 Catch:{ CancelledException -> 0x0020, Throwable -> 0x001a }
        r4.onSuccess(r1);	 Catch:{ CancelledException -> 0x0013, Throwable -> 0x001a }
        r4.onFinished();
        r0 = r1;
        goto L_0x0027;
    L_0x0013:
        r0 = move-exception;
        r2 = r1;
        r1 = r0;
        r0 = r2;
        goto L_0x0021;
    L_0x0018:
        r0 = move-exception;
        goto L_0x0028;
    L_0x001a:
        r0 = move-exception;
        r1 = 0;
        r4.onError(r0, r1);	 Catch:{ all -> 0x0018 }
        throw r0;	 Catch:{ all -> 0x0018 }
    L_0x0020:
        r1 = move-exception;
    L_0x0021:
        r4.onCancelled(r1);	 Catch:{ all -> 0x0018 }
        r4.onFinished();
    L_0x0027:
        return r0;
    L_0x0028:
        r4.onFinished();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xutils.common.task.TaskControllerImpl.startSync(org.xutils.common.task.AbsTask):java.lang.Object");
    }

    public <T extends AbsTask<?>> Cancelable startTasks(final GroupCallback<T> groupCallback, final T... tArr) {
        if (tArr == null) {
            throw new IllegalArgumentException("task must not be null");
        }
        AnonymousClass1 anonymousClass1 = new Runnable() {
            private final AtomicInteger count = new AtomicInteger(0);
            private final int total = tArr.length;

            public void run() {
                if (this.count.incrementAndGet() == this.total && groupCallback != null) {
                    groupCallback.onAllFinished();
                }
            }
        };
        for (final AbsTask absTask : tArr) {
            final GroupCallback<T> groupCallback2 = groupCallback;
            final AnonymousClass1 anonymousClass12 = anonymousClass1;
            start(new TaskProxy(absTask) {
                /* Access modifiers changed, original: protected */
                public void onCancelled(final CancelledException cancelledException) {
                    super.onCancelled(cancelledException);
                    TaskControllerImpl.this.post(new Runnable() {
                        public void run() {
                            if (groupCallback2 != null) {
                                groupCallback2.onCancelled(absTask, cancelledException);
                            }
                        }
                    });
                }

                /* Access modifiers changed, original: protected */
                public void onError(final Throwable th, final boolean z) {
                    super.onError(th, z);
                    TaskControllerImpl.this.post(new Runnable() {
                        public void run() {
                            if (groupCallback2 != null) {
                                groupCallback2.onError(absTask, th, z);
                            }
                        }
                    });
                }

                /* Access modifiers changed, original: protected */
                public void onFinished() {
                    super.onFinished();
                    TaskControllerImpl.this.post(new Runnable() {
                        public void run() {
                            if (groupCallback2 != null) {
                                groupCallback2.onFinished(absTask);
                            }
                            anonymousClass12.run();
                        }
                    });
                }

                /* Access modifiers changed, original: protected */
                public void onSuccess(Object obj) {
                    super.onSuccess(obj);
                    TaskControllerImpl.this.post(new Runnable() {
                        public void run() {
                            if (groupCallback2 != null) {
                                groupCallback2.onSuccess(absTask);
                            }
                        }
                    });
                }
            });
        }
        return new Cancelable() {
            public void cancel() {
                for (AbsTask cancel : tArr) {
                    cancel.cancel();
                }
            }

            public boolean isCancelled() {
                boolean z = true;
                for (AbsTask isCancelled : tArr) {
                    if (!isCancelled.isCancelled()) {
                        z = false;
                    }
                }
                return z;
            }
        };
    }
}
