package com.tencent.open.a;

import com.tencent.open.a.d.a;

/* compiled from: ProGuard */
public abstract class i {
    private volatile int a;
    private volatile boolean b;
    private h c;

    public i() {
        this(c.a, true, h.a);
    }

    public i(int i, boolean z, h hVar) {
        this.a = c.a;
        this.b = true;
        this.c = h.a;
        a(i);
        a(z);
        a(hVar);
    }

    public void a(int i) {
        this.a = i;
    }

    public abstract void a(int i, Thread thread, long j, String str, String str2, Throwable th);

    public void a(h hVar) {
        this.c = hVar;
    }

    public void a(boolean z) {
        this.b = z;
    }

    public void b(int i, Thread thread, long j, String str, String str2, Throwable th) {
        if (d() && a.a(this.a, i)) {
            a(i, thread, j, str, str2, th);
        }
    }

    public boolean d() {
        return this.b;
    }

    public h e() {
        return this.c;
    }
}
