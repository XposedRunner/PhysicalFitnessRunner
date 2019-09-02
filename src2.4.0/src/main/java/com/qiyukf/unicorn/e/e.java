package com.qiyukf.unicorn.e;

public final class e {
    private long a;
    private long b;
    private long c;
    private boolean d;
    private boolean e;
    private long f;

    public final void a(long j) {
        this.a = j;
    }

    public final void a(boolean z) {
        this.d = z;
    }

    public final void b(long j) {
        this.b = j;
    }

    public final void b(boolean z) {
        this.e = z;
    }

    public final void c(long j) {
        this.c = j;
    }

    public final void d(long j) {
        this.f = j;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (this.a == eVar.a && this.b == eVar.b && this.c == eVar.c && this.d == eVar.d && this.e == eVar.e && this.f == eVar.f) {
                return true;
            }
        }
        return false;
    }
}
