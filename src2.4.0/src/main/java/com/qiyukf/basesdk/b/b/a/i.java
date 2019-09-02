package com.qiyukf.basesdk.b.b.a;

public abstract class i implements Comparable<i>, Runnable {
    private long a;
    private boolean b;

    public i(long j) {
        this.a = j;
    }

    public final long a() {
        return this.a;
    }

    public final void b() {
        this.b = true;
    }

    public final boolean c() {
        return this.b;
    }

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        i iVar = (i) obj;
        return this.a == iVar.a ? 0 : this.a > iVar.a ? 1 : -1;
    }
}
