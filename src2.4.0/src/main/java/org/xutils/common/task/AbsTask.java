package org.xutils.common.task;

import java.util.concurrent.Executor;
import org.xutils.common.Callback.Cancelable;
import org.xutils.common.Callback.CancelledException;

public abstract class AbsTask<ResultType> implements Cancelable {
    private final Cancelable cancelHandler;
    private volatile boolean isCancelled;
    private ResultType result;
    private volatile State state;
    private TaskProxy taskProxy;

    public enum State {
        IDLE(0),
        WAITING(1),
        STARTED(2),
        SUCCESS(3),
        CANCELLED(4),
        ERROR(5);
        
        private final int value;

        private State(int i) {
            this.value = i;
        }

        public int value() {
            return this.value;
        }
    }

    public AbsTask() {
        this(null);
    }

    public AbsTask(Cancelable cancelable) {
        this.taskProxy = null;
        this.isCancelled = false;
        this.state = State.IDLE;
        this.cancelHandler = cancelable;
    }

    public final synchronized void cancel() {
        if (!this.isCancelled) {
            this.isCancelled = true;
            cancelWorks();
            if (!(this.cancelHandler == null || this.cancelHandler.isCancelled())) {
                this.cancelHandler.cancel();
            }
            if (this.state == State.WAITING || (this.state == State.STARTED && isCancelFast())) {
                if (this.taskProxy != null) {
                    this.taskProxy.onCancelled(new CancelledException("cancelled by user"));
                    this.taskProxy.onFinished();
                } else if (this instanceof TaskProxy) {
                    onCancelled(new CancelledException("cancelled by user"));
                    onFinished();
                }
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void cancelWorks() {
    }

    public abstract ResultType doBackground() throws Throwable;

    public Executor getExecutor() {
        return null;
    }

    public Priority getPriority() {
        return null;
    }

    public final ResultType getResult() {
        return this.result;
    }

    public final State getState() {
        return this.state;
    }

    /* Access modifiers changed, original: protected */
    public boolean isCancelFast() {
        return false;
    }

    public final boolean isCancelled() {
        return this.isCancelled || this.state == State.CANCELLED || (this.cancelHandler != null && this.cancelHandler.isCancelled());
    }

    public final boolean isFinished() {
        return this.state.value() > State.STARTED.value();
    }

    /* Access modifiers changed, original: protected */
    public void onCancelled(CancelledException cancelledException) {
    }

    public abstract void onError(Throwable th, boolean z);

    /* Access modifiers changed, original: protected */
    public void onFinished() {
    }

    /* Access modifiers changed, original: protected */
    public void onStarted() {
    }

    public abstract void onSuccess(ResultType resultType);

    /* Access modifiers changed, original: protected|varargs */
    public void onUpdate(int i, Object... objArr) {
    }

    /* Access modifiers changed, original: protected */
    public void onWaiting() {
    }

    /* Access modifiers changed, original: final */
    public final void setResult(ResultType resultType) {
        this.result = resultType;
    }

    /* Access modifiers changed, original: 0000 */
    public void setState(State state) {
        this.state = state;
    }

    /* Access modifiers changed, original: final */
    public final void setTaskProxy(TaskProxy taskProxy) {
        this.taskProxy = taskProxy;
    }

    /* Access modifiers changed, original: protected|final|varargs */
    public final void update(int i, Object... objArr) {
        if (this.taskProxy != null) {
            this.taskProxy.onUpdate(i, objArr);
        }
    }
}
