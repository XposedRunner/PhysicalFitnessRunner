package org.xutils.common.task;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.Executor;
import org.xutils.common.Callback.CancelledException;
import org.xutils.common.task.AbsTask.State;
import org.xutils.common.util.LogUtil;
import org.xutils.x;

class TaskProxy<ResultType> extends AbsTask<ResultType> {
    private static final int MSG_WHAT_BASE = 1000000000;
    private static final int MSG_WHAT_ON_CANCEL = 1000000006;
    private static final int MSG_WHAT_ON_ERROR = 1000000004;
    private static final int MSG_WHAT_ON_FINISHED = 1000000007;
    private static final int MSG_WHAT_ON_START = 1000000002;
    private static final int MSG_WHAT_ON_SUCCESS = 1000000003;
    private static final int MSG_WHAT_ON_UPDATE = 1000000005;
    private static final int MSG_WHAT_ON_WAITING = 1000000001;
    static final PriorityExecutor sDefaultExecutor = new PriorityExecutor(true);
    static final InternalHandler sHandler = new InternalHandler();
    private volatile boolean callOnCanceled = false;
    private volatile boolean callOnFinished = false;
    private final Executor executor;
    private final AbsTask<ResultType> task;

    private static class ArgsObj {
        final Object[] args;
        final TaskProxy taskProxy;

        public ArgsObj(TaskProxy taskProxy, Object... objArr) {
            this.taskProxy = taskProxy;
            this.args = objArr;
        }
    }

    static final class InternalHandler extends Handler {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        static {
            Class cls = TaskProxy.class;
        }

        private InternalHandler() {
            super(Looper.getMainLooper());
        }

        /* synthetic */ InternalHandler(AnonymousClass1 anonymousClass1) {
            this();
        }

        public void handleMessage(Message message) {
            if (message.obj == null) {
                throw new IllegalArgumentException("msg must not be null");
            }
            Object[] objArr;
            TaskProxy taskProxy = null;
            if (message.obj instanceof TaskProxy) {
                taskProxy = (TaskProxy) message.obj;
                objArr = null;
            } else if (message.obj instanceof ArgsObj) {
                ArgsObj argsObj = (ArgsObj) message.obj;
                taskProxy = argsObj.taskProxy;
                objArr = argsObj.args;
            } else {
                objArr = null;
            }
            if (taskProxy == null) {
                throw new RuntimeException("msg.obj not instanceof TaskProxy");
            }
            Throwable th;
            try {
                switch (message.what) {
                    case TaskProxy.MSG_WHAT_ON_WAITING /*1000000001*/:
                        taskProxy.task.onWaiting();
                        break;
                    case TaskProxy.MSG_WHAT_ON_START /*1000000002*/:
                        taskProxy.task.onStarted();
                        break;
                    case TaskProxy.MSG_WHAT_ON_SUCCESS /*1000000003*/:
                        taskProxy.task.onSuccess(taskProxy.getResult());
                        break;
                    case TaskProxy.MSG_WHAT_ON_ERROR /*1000000004*/:
                        th = (Throwable) objArr[0];
                        LogUtil.d(th.getMessage(), th);
                        taskProxy.task.onError(th, false);
                        break;
                    case TaskProxy.MSG_WHAT_ON_UPDATE /*1000000005*/:
                        taskProxy.task.onUpdate(message.arg1, objArr);
                        break;
                    case TaskProxy.MSG_WHAT_ON_CANCEL /*1000000006*/:
                        if (!taskProxy.callOnCanceled) {
                            taskProxy.callOnCanceled = true;
                            taskProxy.task.onCancelled((CancelledException) objArr[0]);
                            break;
                        }
                        return;
                    case TaskProxy.MSG_WHAT_ON_FINISHED /*1000000007*/:
                        if (!taskProxy.callOnFinished) {
                            taskProxy.callOnFinished = true;
                            taskProxy.task.onFinished();
                            break;
                        }
                        return;
                    default:
                        break;
                }
            } catch (Throwable th2) {
                taskProxy.setState(State.ERROR);
                if (message.what != TaskProxy.MSG_WHAT_ON_ERROR) {
                    taskProxy.task.onError(th2, true);
                } else if (x.isDebug()) {
                    RuntimeException runtimeException = new RuntimeException(th2);
                }
            }
        }
    }

    TaskProxy(AbsTask<ResultType> absTask) {
        super(absTask);
        this.task = absTask;
        this.task.setTaskProxy(this);
        setTaskProxy(null);
        Executor executor = absTask.getExecutor();
        if (executor == null) {
            executor = sDefaultExecutor;
        }
        this.executor = executor;
    }

    /* Access modifiers changed, original: protected|final */
    public final ResultType doBackground() throws Throwable {
        onWaiting();
        this.executor.execute(new PriorityRunnable(this.task.getPriority(), new Runnable() {
            public void run() {
                try {
                    if (!TaskProxy.this.callOnCanceled) {
                        if (!TaskProxy.this.isCancelled()) {
                            TaskProxy.this.onStarted();
                            if (TaskProxy.this.isCancelled()) {
                                throw new CancelledException("");
                            }
                            TaskProxy.this.task.setResult(TaskProxy.this.task.doBackground());
                            TaskProxy.this.setResult(TaskProxy.this.task.getResult());
                            if (TaskProxy.this.isCancelled()) {
                                throw new CancelledException("");
                            }
                            TaskProxy.this.onSuccess(TaskProxy.this.task.getResult());
                            TaskProxy.this.onFinished();
                            return;
                        }
                    }
                    throw new CancelledException("");
                } catch (CancelledException e) {
                    TaskProxy.this.onCancelled(e);
                } catch (Throwable th) {
                    TaskProxy.this.onFinished();
                }
            }
        }));
        return null;
    }

    public final Executor getExecutor() {
        return this.executor;
    }

    public final Priority getPriority() {
        return this.task.getPriority();
    }

    /* Access modifiers changed, original: protected */
    public void onCancelled(CancelledException cancelledException) {
        setState(State.CANCELLED);
        sHandler.obtainMessage(MSG_WHAT_ON_CANCEL, new ArgsObj(this, cancelledException)).sendToTarget();
    }

    /* Access modifiers changed, original: protected */
    public void onError(Throwable th, boolean z) {
        setState(State.ERROR);
        sHandler.obtainMessage(MSG_WHAT_ON_ERROR, new ArgsObj(this, th)).sendToTarget();
    }

    /* Access modifiers changed, original: protected */
    public void onFinished() {
        sHandler.obtainMessage(MSG_WHAT_ON_FINISHED, this).sendToTarget();
    }

    /* Access modifiers changed, original: protected */
    public void onStarted() {
        setState(State.STARTED);
        sHandler.obtainMessage(MSG_WHAT_ON_START, this).sendToTarget();
    }

    /* Access modifiers changed, original: protected */
    public void onSuccess(ResultType resultType) {
        setState(State.SUCCESS);
        sHandler.obtainMessage(MSG_WHAT_ON_SUCCESS, this).sendToTarget();
    }

    /* Access modifiers changed, original: protected|varargs */
    public void onUpdate(int i, Object... objArr) {
        sHandler.obtainMessage(MSG_WHAT_ON_UPDATE, i, i, new ArgsObj(this, objArr)).sendToTarget();
    }

    /* Access modifiers changed, original: protected */
    public void onWaiting() {
        setState(State.WAITING);
        sHandler.obtainMessage(MSG_WHAT_ON_WAITING, this).sendToTarget();
    }

    /* Access modifiers changed, original: final */
    public final void setState(State state) {
        super.setState(state);
        this.task.setState(state);
    }
}
