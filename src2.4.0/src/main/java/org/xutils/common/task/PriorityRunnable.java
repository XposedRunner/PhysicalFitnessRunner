package org.xutils.common.task;

class PriorityRunnable implements Runnable {
    long SEQ;
    public final Priority priority;
    private final Runnable runnable;

    public PriorityRunnable(Priority priority, Runnable runnable) {
        if (priority == null) {
            priority = Priority.DEFAULT;
        }
        this.priority = priority;
        this.runnable = runnable;
    }

    public final void run() {
        this.runnable.run();
    }
}
