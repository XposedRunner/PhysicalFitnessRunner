package com.qiyukf.basesdk.b.b.c;

import android.os.SystemClock;
import com.qiyukf.basesdk.a.a;
import com.qiyukf.basesdk.b.b.a.i;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class h implements Executor {
    private static final String a = "h";
    private final AtomicInteger b = new AtomicInteger(1);
    private final Queue<Runnable> c;
    private final Queue<i> d;
    private final Thread e = new Thread(new Runnable() {
        /* JADX WARNING: Removed duplicated region for block: B:14:0x004c  */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x0197 A:{RETURN} */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x018a  */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x01d9 A:{REMOVE} */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x02c8 A:{REMOVE} */
        /* JADX WARNING: Removed duplicated region for block: B:67:0x02a6  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x00b0 A:{REMOVE} */
        public final void run() {
            /*
            r6 = this;
            r0 = 3;
            r1 = 41;
            r2 = 5;
            r3 = com.qiyukf.basesdk.b.b.c.h.this;	 Catch:{ Throwable -> 0x013d }
            r3.b();	 Catch:{ Throwable -> 0x013d }
        L_0x0009:
            r3 = com.qiyukf.basesdk.b.b.c.h.this;
            r3 = r3.b;
            r3 = r3.get();
            if (r3 >= r0) goto L_0x0021;
        L_0x0015:
            r4 = com.qiyukf.basesdk.b.b.c.h.this;
            r4 = r4.b;
            r3 = r4.compareAndSet(r3, r0);
            if (r3 == 0) goto L_0x0009;
        L_0x0021:
            r0 = com.qiyukf.basesdk.b.b.c.h.this;	 Catch:{ all -> 0x00b1 }
            r0 = r0.k();	 Catch:{ all -> 0x00b1 }
            if (r0 == 0) goto L_0x0021;
        L_0x0029:
            r0 = com.qiyukf.basesdk.b.b.c.h.this;	 Catch:{ all -> 0x006f }
            r0.c();	 Catch:{ all -> 0x006f }
            r0 = com.qiyukf.basesdk.b.b.c.h.this;
            r0 = r0.b;
            r0.set(r2);
            r0 = com.qiyukf.basesdk.b.b.c.h.this;
            r0 = r0.f;
            r0.release();
            r0 = com.qiyukf.basesdk.b.b.c.h.this;
            r0 = r0.c;
            r0 = r0.isEmpty();
            if (r0 != 0) goto L_0x006e;
        L_0x004c:
            r0 = com.qiyukf.basesdk.b.b.c.h.a;
            r2 = new java.lang.StringBuilder;
            r3 = "An event executor terminated with non-empty task queue (";
            r2.<init>(r3);
        L_0x0057:
            r3 = com.qiyukf.basesdk.b.b.c.h.this;
            r3 = r3.c;
            r3 = r3.size();
            r2.append(r3);
            r2.append(r1);
            r1 = r2.toString();
            com.qiyukf.basesdk.a.a.e(r0, r1);
        L_0x006e:
            return;
        L_0x006f:
            r0 = move-exception;
            r3 = com.qiyukf.basesdk.b.b.c.h.this;
            r3 = r3.b;
            r3.set(r2);
            r2 = com.qiyukf.basesdk.b.b.c.h.this;
            r2 = r2.f;
            r2.release();
            r2 = com.qiyukf.basesdk.b.b.c.h.this;
            r2 = r2.c;
            r2 = r2.isEmpty();
            if (r2 != 0) goto L_0x00b0;
        L_0x008e:
            r2 = com.qiyukf.basesdk.b.b.c.h.a;
            r3 = new java.lang.StringBuilder;
            r4 = "An event executor terminated with non-empty task queue (";
            r3.<init>(r4);
            r4 = com.qiyukf.basesdk.b.b.c.h.this;
            r4 = r4.c;
            r4 = r4.size();
            r3.append(r4);
            r3.append(r1);
            r1 = r3.toString();
            com.qiyukf.basesdk.a.a.e(r2, r1);
        L_0x00b0:
            throw r0;
        L_0x00b1:
            r0 = move-exception;
            r3 = com.qiyukf.basesdk.b.b.c.h.this;	 Catch:{ all -> 0x00f8 }
            r3.c();	 Catch:{ all -> 0x00f8 }
            r3 = com.qiyukf.basesdk.b.b.c.h.this;
            r3 = r3.b;
            r3.set(r2);
            r2 = com.qiyukf.basesdk.b.b.c.h.this;
            r2 = r2.f;
            r2.release();
            r2 = com.qiyukf.basesdk.b.b.c.h.this;
            r2 = r2.c;
            r2 = r2.isEmpty();
            if (r2 != 0) goto L_0x00f7;
        L_0x00d5:
            r2 = com.qiyukf.basesdk.b.b.c.h.a;
            r3 = new java.lang.StringBuilder;
            r4 = "An event executor terminated with non-empty task queue (";
            r3.<init>(r4);
            r4 = com.qiyukf.basesdk.b.b.c.h.this;
            r4 = r4.c;
            r4 = r4.size();
            r3.append(r4);
            r3.append(r1);
            r1 = r3.toString();
            com.qiyukf.basesdk.a.a.e(r2, r1);
        L_0x00f7:
            throw r0;
        L_0x00f8:
            r0 = move-exception;
            r3 = com.qiyukf.basesdk.b.b.c.h.this;
            r3 = r3.b;
            r3.set(r2);
            r2 = com.qiyukf.basesdk.b.b.c.h.this;
            r2 = r2.f;
            r2.release();
            r2 = com.qiyukf.basesdk.b.b.c.h.this;
            r2 = r2.c;
            r2 = r2.isEmpty();
            if (r2 != 0) goto L_0x0139;
        L_0x0117:
            r2 = com.qiyukf.basesdk.b.b.c.h.a;
            r3 = new java.lang.StringBuilder;
            r4 = "An event executor terminated with non-empty task queue (";
            r3.<init>(r4);
            r4 = com.qiyukf.basesdk.b.b.c.h.this;
            r4 = r4.c;
            r4 = r4.size();
            r3.append(r4);
            r3.append(r1);
            r1 = r3.toString();
            com.qiyukf.basesdk.a.a.e(r2, r1);
        L_0x0139:
            throw r0;
        L_0x013a:
            r3 = move-exception;
            goto L_0x0263;
        L_0x013d:
            r3 = move-exception;
            r4 = com.qiyukf.basesdk.b.b.c.h.a;	 Catch:{ all -> 0x013a }
            r5 = "Unexpected exception from an event executor: ";
            com.qiyukf.basesdk.a.a.b(r4, r5, r3);	 Catch:{ all -> 0x013a }
        L_0x0147:
            r3 = com.qiyukf.basesdk.b.b.c.h.this;
            r3 = r3.b;
            r3 = r3.get();
            if (r3 >= r0) goto L_0x015f;
        L_0x0153:
            r4 = com.qiyukf.basesdk.b.b.c.h.this;
            r4 = r4.b;
            r3 = r4.compareAndSet(r3, r0);
            if (r3 == 0) goto L_0x0147;
        L_0x015f:
            r0 = com.qiyukf.basesdk.b.b.c.h.this;	 Catch:{ all -> 0x01da }
            r0 = r0.k();	 Catch:{ all -> 0x01da }
            if (r0 == 0) goto L_0x015f;
        L_0x0167:
            r0 = com.qiyukf.basesdk.b.b.c.h.this;	 Catch:{ all -> 0x0198 }
            r0.c();	 Catch:{ all -> 0x0198 }
            r0 = com.qiyukf.basesdk.b.b.c.h.this;
            r0 = r0.b;
            r0.set(r2);
            r0 = com.qiyukf.basesdk.b.b.c.h.this;
            r0 = r0.f;
            r0.release();
            r0 = com.qiyukf.basesdk.b.b.c.h.this;
            r0 = r0.c;
            r0 = r0.isEmpty();
            if (r0 != 0) goto L_0x0197;
        L_0x018a:
            r0 = com.qiyukf.basesdk.b.b.c.h.a;
            r2 = new java.lang.StringBuilder;
            r3 = "An event executor terminated with non-empty task queue (";
            r2.<init>(r3);
            goto L_0x0057;
        L_0x0197:
            return;
        L_0x0198:
            r0 = move-exception;
            r3 = com.qiyukf.basesdk.b.b.c.h.this;
            r3 = r3.b;
            r3.set(r2);
            r2 = com.qiyukf.basesdk.b.b.c.h.this;
            r2 = r2.f;
            r2.release();
            r2 = com.qiyukf.basesdk.b.b.c.h.this;
            r2 = r2.c;
            r2 = r2.isEmpty();
            if (r2 != 0) goto L_0x01d9;
        L_0x01b7:
            r2 = com.qiyukf.basesdk.b.b.c.h.a;
            r3 = new java.lang.StringBuilder;
            r4 = "An event executor terminated with non-empty task queue (";
            r3.<init>(r4);
            r4 = com.qiyukf.basesdk.b.b.c.h.this;
            r4 = r4.c;
            r4 = r4.size();
            r3.append(r4);
            r3.append(r1);
            r1 = r3.toString();
            com.qiyukf.basesdk.a.a.e(r2, r1);
        L_0x01d9:
            throw r0;
        L_0x01da:
            r0 = move-exception;
            r3 = com.qiyukf.basesdk.b.b.c.h.this;	 Catch:{ all -> 0x0221 }
            r3.c();	 Catch:{ all -> 0x0221 }
            r3 = com.qiyukf.basesdk.b.b.c.h.this;
            r3 = r3.b;
            r3.set(r2);
            r2 = com.qiyukf.basesdk.b.b.c.h.this;
            r2 = r2.f;
            r2.release();
            r2 = com.qiyukf.basesdk.b.b.c.h.this;
            r2 = r2.c;
            r2 = r2.isEmpty();
            if (r2 != 0) goto L_0x0220;
        L_0x01fe:
            r2 = com.qiyukf.basesdk.b.b.c.h.a;
            r3 = new java.lang.StringBuilder;
            r4 = "An event executor terminated with non-empty task queue (";
            r3.<init>(r4);
            r4 = com.qiyukf.basesdk.b.b.c.h.this;
            r4 = r4.c;
            r4 = r4.size();
            r3.append(r4);
            r3.append(r1);
            r1 = r3.toString();
            com.qiyukf.basesdk.a.a.e(r2, r1);
        L_0x0220:
            throw r0;
        L_0x0221:
            r0 = move-exception;
            r3 = com.qiyukf.basesdk.b.b.c.h.this;
            r3 = r3.b;
            r3.set(r2);
            r2 = com.qiyukf.basesdk.b.b.c.h.this;
            r2 = r2.f;
            r2.release();
            r2 = com.qiyukf.basesdk.b.b.c.h.this;
            r2 = r2.c;
            r2 = r2.isEmpty();
            if (r2 != 0) goto L_0x0262;
        L_0x0240:
            r2 = com.qiyukf.basesdk.b.b.c.h.a;
            r3 = new java.lang.StringBuilder;
            r4 = "An event executor terminated with non-empty task queue (";
            r3.<init>(r4);
            r4 = com.qiyukf.basesdk.b.b.c.h.this;
            r4 = r4.c;
            r4 = r4.size();
            r3.append(r4);
            r3.append(r1);
            r1 = r3.toString();
            com.qiyukf.basesdk.a.a.e(r2, r1);
        L_0x0262:
            throw r0;
        L_0x0263:
            r4 = com.qiyukf.basesdk.b.b.c.h.this;
            r4 = r4.b;
            r4 = r4.get();
            if (r4 >= r0) goto L_0x027b;
        L_0x026f:
            r5 = com.qiyukf.basesdk.b.b.c.h.this;
            r5 = r5.b;
            r4 = r5.compareAndSet(r4, r0);
            if (r4 == 0) goto L_0x0263;
        L_0x027b:
            r0 = com.qiyukf.basesdk.b.b.c.h.this;	 Catch:{ all -> 0x030b }
            r0 = r0.k();	 Catch:{ all -> 0x030b }
            if (r0 == 0) goto L_0x027b;
        L_0x0283:
            r0 = com.qiyukf.basesdk.b.b.c.h.this;	 Catch:{ all -> 0x02c9 }
            r0.c();	 Catch:{ all -> 0x02c9 }
            r0 = com.qiyukf.basesdk.b.b.c.h.this;
            r0 = r0.b;
            r0.set(r2);
            r0 = com.qiyukf.basesdk.b.b.c.h.this;
            r0 = r0.f;
            r0.release();
            r0 = com.qiyukf.basesdk.b.b.c.h.this;
            r0 = r0.c;
            r0 = r0.isEmpty();
            if (r0 != 0) goto L_0x02c8;
        L_0x02a6:
            r0 = com.qiyukf.basesdk.b.b.c.h.a;
            r2 = new java.lang.StringBuilder;
            r4 = "An event executor terminated with non-empty task queue (";
            r2.<init>(r4);
            r4 = com.qiyukf.basesdk.b.b.c.h.this;
            r4 = r4.c;
            r4 = r4.size();
            r2.append(r4);
            r2.append(r1);
            r1 = r2.toString();
            com.qiyukf.basesdk.a.a.e(r0, r1);
        L_0x02c8:
            throw r3;
        L_0x02c9:
            r0 = move-exception;
            r3 = com.qiyukf.basesdk.b.b.c.h.this;
            r3 = r3.b;
            r3.set(r2);
            r2 = com.qiyukf.basesdk.b.b.c.h.this;
            r2 = r2.f;
            r2.release();
            r2 = com.qiyukf.basesdk.b.b.c.h.this;
            r2 = r2.c;
            r2 = r2.isEmpty();
            if (r2 != 0) goto L_0x030a;
        L_0x02e8:
            r2 = com.qiyukf.basesdk.b.b.c.h.a;
            r3 = new java.lang.StringBuilder;
            r4 = "An event executor terminated with non-empty task queue (";
            r3.<init>(r4);
            r4 = com.qiyukf.basesdk.b.b.c.h.this;
            r4 = r4.c;
            r4 = r4.size();
            r3.append(r4);
            r3.append(r1);
            r1 = r3.toString();
            com.qiyukf.basesdk.a.a.e(r2, r1);
        L_0x030a:
            throw r0;
        L_0x030b:
            r0 = move-exception;
            r3 = com.qiyukf.basesdk.b.b.c.h.this;	 Catch:{ all -> 0x0352 }
            r3.c();	 Catch:{ all -> 0x0352 }
            r3 = com.qiyukf.basesdk.b.b.c.h.this;
            r3 = r3.b;
            r3.set(r2);
            r2 = com.qiyukf.basesdk.b.b.c.h.this;
            r2 = r2.f;
            r2.release();
            r2 = com.qiyukf.basesdk.b.b.c.h.this;
            r2 = r2.c;
            r2 = r2.isEmpty();
            if (r2 != 0) goto L_0x0351;
        L_0x032f:
            r2 = com.qiyukf.basesdk.b.b.c.h.a;
            r3 = new java.lang.StringBuilder;
            r4 = "An event executor terminated with non-empty task queue (";
            r3.<init>(r4);
            r4 = com.qiyukf.basesdk.b.b.c.h.this;
            r4 = r4.c;
            r4 = r4.size();
            r3.append(r4);
            r3.append(r1);
            r1 = r3.toString();
            com.qiyukf.basesdk.a.a.e(r2, r1);
        L_0x0351:
            throw r0;
        L_0x0352:
            r0 = move-exception;
            r3 = com.qiyukf.basesdk.b.b.c.h.this;
            r3 = r3.b;
            r3.set(r2);
            r2 = com.qiyukf.basesdk.b.b.c.h.this;
            r2 = r2.f;
            r2.release();
            r2 = com.qiyukf.basesdk.b.b.c.h.this;
            r2 = r2.c;
            r2 = r2.isEmpty();
            if (r2 != 0) goto L_0x0393;
        L_0x0371:
            r2 = com.qiyukf.basesdk.b.b.c.h.a;
            r3 = new java.lang.StringBuilder;
            r4 = "An event executor terminated with non-empty task queue (";
            r3.<init>(r4);
            r4 = com.qiyukf.basesdk.b.b.c.h.this;
            r4 = r4.c;
            r4 = r4.size();
            r3.append(r4);
            r3.append(r1);
            r1 = r3.toString();
            com.qiyukf.basesdk.a.a.e(r2, r1);
        L_0x0393:
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.basesdk.b.b.c.h$AnonymousClass1.run():void");
        }
    });
    private final Semaphore f = new Semaphore(0);

    protected h() {
        this.e.setName("Socket-Thread");
        this.e.setPriority(10);
        this.c = new LinkedBlockingQueue();
        this.d = new PriorityBlockingQueue();
    }

    private Runnable a() {
        return (Runnable) this.c.poll();
    }

    private void a(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("task");
        }
        if (d()) {
            m();
        }
        this.c.add(runnable);
    }

    private boolean d() {
        return this.b.get() >= 4;
    }

    private static void m() {
        throw new RejectedExecutionException("event executor terminated");
    }

    public final void a(i iVar) {
        this.d.add(iVar);
        a(h());
    }

    public abstract void a(boolean z);

    public abstract void b();

    public abstract void c();

    /* Access modifiers changed, original: protected|final */
    public final boolean e() {
        return !this.c.isEmpty();
    }

    public void execute(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("task");
        }
        boolean h = h();
        if (h) {
            a(runnable);
        } else {
            if (this.b.get() == 1 && this.b.compareAndSet(1, 2)) {
                this.e.start();
            }
            a(runnable);
            if (d()) {
                if (runnable == null) {
                    throw new NullPointerException("task");
                } else if (this.c.remove(runnable)) {
                    m();
                }
            }
        }
        a(h);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean f() {
        while (true) {
            i iVar = (i) this.d.peek();
            if (iVar == null) {
                break;
            }
            if (iVar.a() > SystemClock.elapsedRealtime()) {
                break;
            }
            this.d.remove();
            if (!iVar.c()) {
                this.c.add(iVar);
            }
        }
        Runnable a = a();
        if (a == null) {
            return false;
        }
        do {
            try {
                a.run();
            } catch (Throwable th) {
                a.d(a, "A task raised an exception.", th);
            }
            a = a();
        } while (a != null);
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final long g() {
        i iVar;
        loop0:
        while (true) {
            iVar = null;
            while (iVar == null && this.d.size() > 0) {
                iVar = (i) this.d.peek();
                if (iVar.c()) {
                    this.d.remove();
                }
            }
        }
        return iVar != null ? iVar.a() - SystemClock.elapsedRealtime() : 15000;
    }

    public final boolean h() {
        return Thread.currentThread() == this.e;
    }

    public final void i() {
        if (!d()) {
            boolean h = h();
            while (!j()) {
                Object obj;
                int i = this.b.get();
                int i2 = 4;
                if (!h) {
                    switch (i) {
                        case 1:
                        case 2:
                        case 3:
                            break;
                        default:
                            obj = null;
                            i2 = i;
                            break;
                    }
                }
                obj = 1;
                if (this.b.compareAndSet(i, i2)) {
                    if (i == 1) {
                        this.e.start();
                    }
                    if (obj != null) {
                        a(h);
                    }
                    return;
                }
            }
        }
    }

    public final boolean j() {
        return this.b.get() >= 3;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean k() {
        if (!j()) {
            return false;
        }
        if (!h()) {
            throw new IllegalStateException("must be invoked from an event loop");
        } else if (!f()) {
            if (d()) {
            }
            return true;
        } else if (d()) {
            return true;
        } else {
            a(true);
            return false;
        }
    }
}
