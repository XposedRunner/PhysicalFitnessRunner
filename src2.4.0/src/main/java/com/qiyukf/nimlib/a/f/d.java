package com.qiyukf.nimlib.a.f;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.qiyukf.nimlib.a.b.f;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class d implements f {
    private final SparseArray<a> a = new SparseArray();
    private final int b = 0;
    private final int c = 1;
    private AtomicInteger d = new AtomicInteger(0);
    private Handler e = new Handler(Looper.getMainLooper());

    private class a implements Runnable {
        c a;

        a(c cVar) {
            this.a = cVar;
        }

        public final int a() {
            return this.a.b().a().i();
        }

        public final void run() {
            d.this.a(this, false);
        }
    }

    private a a(int i) {
        a aVar;
        synchronized (this.a) {
            aVar = (a) this.a.get(i);
        }
        return aVar;
    }

    private void a(a aVar, boolean z) {
        if (a("onTimeout")) {
            int a = aVar.a();
            a a2 = a(a);
            if (a2 != null) {
                if (a2.a.c()) {
                    a2 = b(a);
                }
                if (a2 != null) {
                    if (z) {
                        a2.a.f();
                        return;
                    }
                    a2.a.e();
                }
            }
        }
    }

    private boolean a(String str) {
        boolean z = true;
        if (this.d.get() != 1) {
            z = false;
        }
        if (!z) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(" while not running");
            com.qiyukf.basesdk.a.a.a("TaskMgr", stringBuilder.toString());
        }
        return z;
    }

    private a b(int i) {
        a aVar;
        synchronized (this.a) {
            aVar = (a) this.a.get(i);
            if (aVar != null) {
                this.a.remove(i);
            }
        }
        if (aVar != null) {
            this.e.removeCallbacks(aVar);
        }
        return aVar;
    }

    /* JADX WARNING: Missing block: B:15:0x0041, code skipped:
            return null;
     */
    private com.qiyukf.nimlib.a.f.d.a d(com.qiyukf.nimlib.a.d.a r5) {
        /*
        r4 = this;
        r0 = r4.a;
        monitor-enter(r0);
        r1 = r4.a;	 Catch:{ all -> 0x0042 }
        r2 = r5.a();	 Catch:{ all -> 0x0042 }
        r2 = r2.i();	 Catch:{ all -> 0x0042 }
        r1 = r1.get(r2);	 Catch:{ all -> 0x0042 }
        r1 = (com.qiyukf.nimlib.a.f.d.a) r1;	 Catch:{ all -> 0x0042 }
        if (r1 == 0) goto L_0x003f;
    L_0x0015:
        r2 = r1.a;	 Catch:{ all -> 0x0042 }
        if (r2 == 0) goto L_0x003f;
    L_0x0019:
        r2 = r1.a;	 Catch:{ all -> 0x0042 }
        r2 = r2.b();	 Catch:{ all -> 0x0042 }
        r2 = r2.c();	 Catch:{ all -> 0x0042 }
        r3 = r5.a();	 Catch:{ all -> 0x0042 }
        r3 = r3.g();	 Catch:{ all -> 0x0042 }
        if (r2 != r3) goto L_0x003f;
    L_0x002d:
        r2 = r1.a;	 Catch:{ all -> 0x0042 }
        r2 = r2.b();	 Catch:{ all -> 0x0042 }
        r2 = r2.d();	 Catch:{ all -> 0x0042 }
        r5 = r5.d();	 Catch:{ all -> 0x0042 }
        if (r2 != r5) goto L_0x003f;
    L_0x003d:
        monitor-exit(r0);	 Catch:{ all -> 0x0042 }
        return r1;
    L_0x003f:
        monitor-exit(r0);	 Catch:{ all -> 0x0042 }
        r5 = 0;
        return r5;
    L_0x0042:
        r5 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0042 }
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.a.f.d.d(com.qiyukf.nimlib.a.d.a):com.qiyukf.nimlib.a.f.d$a");
    }

    private List<a> d() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.a) {
            for (int i = 0; i < this.a.size(); i++) {
                arrayList.add(this.a.valueAt(i));
            }
        }
        return arrayList;
    }

    public final void a() {
        if (!this.d.compareAndSet(0, 1)) {
        }
    }

    public final void a(com.qiyukf.nimlib.a.d.a aVar) {
        if (a("pre process")) {
            synchronized (this.a) {
                a d = d(aVar);
                if (d != null) {
                    this.e.removeCallbacks(d);
                }
            }
        }
    }

    public final boolean a(c cVar) {
        if (!a("pend task")) {
            return false;
        }
        if (!(cVar.b() != null)) {
            return false;
        }
        a aVar = new a(cVar);
        synchronized (this.a) {
            this.a.put(aVar.a(), aVar);
            this.e.postDelayed(aVar, (long) (aVar.a.d() * 1000));
        }
        return true;
    }

    public final void b() {
        if (this.d.compareAndSet(1, 0)) {
            this.a.clear();
        }
    }

    public final void b(com.qiyukf.nimlib.a.d.a aVar) {
        if (a("on processed")) {
            a d = d(aVar);
            if (!(d == null || d.a == null)) {
                d.a.a(aVar);
            }
            b(aVar.c());
        }
    }

    public final com.qiyukf.nimlib.a.c.a c(com.qiyukf.nimlib.a.d.a aVar) {
        if (!a("retrieve request")) {
            return null;
        }
        a d = d(aVar);
        return d == null ? null : d.a.b();
    }

    public final void c() {
        if (a("onLogin")) {
            for (a a : d()) {
                a(a, true);
            }
        }
    }
}
