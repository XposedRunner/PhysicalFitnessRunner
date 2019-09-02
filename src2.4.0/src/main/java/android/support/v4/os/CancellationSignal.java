package android.support.v4.os;

import android.os.Build.VERSION;

public final class CancellationSignal {
    private boolean mCancelInProgress;
    private Object mCancellationSignalObj;
    private boolean mIsCanceled;
    private OnCancelListener mOnCancelListener;

    public interface OnCancelListener {
        void onCancel();
    }

    private void waitForCancelFinishedLocked() {
        while (this.mCancelInProgress) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    /* JADX WARNING: Missing block: B:9:0x0012, code skipped:
            if (r0 == null) goto L_0x001a;
     */
    /* JADX WARNING: Missing block: B:11:?, code skipped:
            r0.onCancel();
     */
    /* JADX WARNING: Missing block: B:14:0x001a, code skipped:
            if (r1 == null) goto L_0x002b;
     */
    /* JADX WARNING: Missing block: B:15:0x001c, code skipped:
            android.support.v4.os.CancellationSignalCompatJellybean.cancel(r1);
     */
    /* JADX WARNING: Missing block: B:16:0x0020, code skipped:
            monitor-enter(r3);
     */
    /* JADX WARNING: Missing block: B:18:?, code skipped:
            r3.mCancelInProgress = false;
            notifyAll();
     */
    /* JADX WARNING: Missing block: B:25:0x002b, code skipped:
            monitor-enter(r3);
     */
    /* JADX WARNING: Missing block: B:27:?, code skipped:
            r3.mCancelInProgress = false;
            notifyAll();
     */
    /* JADX WARNING: Missing block: B:28:0x0031, code skipped:
            monitor-exit(r3);
     */
    /* JADX WARNING: Missing block: B:29:0x0032, code skipped:
            return;
     */
    public void cancel() {
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = r3.mIsCanceled;	 Catch:{ all -> 0x0036 }
        if (r0 == 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r3);	 Catch:{ all -> 0x0036 }
        return;
    L_0x0007:
        r0 = 1;
        r3.mIsCanceled = r0;	 Catch:{ all -> 0x0036 }
        r3.mCancelInProgress = r0;	 Catch:{ all -> 0x0036 }
        r0 = r3.mOnCancelListener;	 Catch:{ all -> 0x0036 }
        r1 = r3.mCancellationSignalObj;	 Catch:{ all -> 0x0036 }
        monitor-exit(r3);	 Catch:{ all -> 0x0036 }
        r2 = 0;
        if (r0 == 0) goto L_0x001a;
    L_0x0014:
        r0.onCancel();	 Catch:{ all -> 0x0018 }
        goto L_0x001a;
    L_0x0018:
        r0 = move-exception;
        goto L_0x0020;
    L_0x001a:
        if (r1 == 0) goto L_0x002b;
    L_0x001c:
        android.support.v4.os.CancellationSignalCompatJellybean.cancel(r1);	 Catch:{ all -> 0x0018 }
        goto L_0x002b;
    L_0x0020:
        monitor-enter(r3);
        r3.mCancelInProgress = r2;	 Catch:{ all -> 0x0028 }
        r3.notifyAll();	 Catch:{ all -> 0x0028 }
        monitor-exit(r3);	 Catch:{ all -> 0x0028 }
        throw r0;
    L_0x0028:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0028 }
        throw r0;
    L_0x002b:
        monitor-enter(r3);
        r3.mCancelInProgress = r2;	 Catch:{ all -> 0x0033 }
        r3.notifyAll();	 Catch:{ all -> 0x0033 }
        monitor-exit(r3);	 Catch:{ all -> 0x0033 }
        return;
    L_0x0033:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0033 }
        throw r0;
    L_0x0036:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0036 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.os.CancellationSignal.cancel():void");
    }

    public Object getCancellationSignalObject() {
        if (VERSION.SDK_INT < 16) {
            return null;
        }
        Object obj;
        synchronized (this) {
            if (this.mCancellationSignalObj == null) {
                this.mCancellationSignalObj = CancellationSignalCompatJellybean.create();
                if (this.mIsCanceled) {
                    CancellationSignalCompatJellybean.cancel(this.mCancellationSignalObj);
                }
            }
            obj = this.mCancellationSignalObj;
        }
        return obj;
    }

    public boolean isCanceled() {
        boolean z;
        synchronized (this) {
            z = this.mIsCanceled;
        }
        return z;
    }

    public void setOnCancelListener(OnCancelListener onCancelListener) {
        synchronized (this) {
            waitForCancelFinishedLocked();
            if (this.mOnCancelListener == onCancelListener) {
                return;
            }
            this.mOnCancelListener = onCancelListener;
            if (this.mIsCanceled) {
                if (onCancelListener != null) {
                    onCancelListener.onCancel();
                    return;
                }
            }
        }
    }

    public void throwIfCanceled() {
        if (isCanceled()) {
            throw new OperationCanceledException();
        }
    }
}
