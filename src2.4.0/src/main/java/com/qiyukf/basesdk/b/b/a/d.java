package com.qiyukf.basesdk.b.b.a;

import com.qiyukf.basesdk.b.b.c.c;
import com.qiyukf.basesdk.b.b.c.g;

public abstract class d {
    protected g a;
    volatile d b;
    volatile d c;
    private boolean d;
    private boolean e;

    public d(g gVar, boolean z, boolean z2) {
        this.a = gVar;
        this.d = z;
        this.e = z2;
    }

    public final d a() {
        return this.c;
    }

    public final d b() {
        for (d dVar = this.c; dVar != null; dVar = dVar.c) {
            if (dVar.d) {
                return dVar;
            }
        }
        return null;
    }

    public final d c() {
        for (d dVar = this.b; dVar != null; dVar = dVar.b) {
            if (dVar.e) {
                return dVar;
            }
        }
        return null;
    }

    public final com.qiyukf.basesdk.b.b.c.d d() {
        d b = b();
        return b == null ? null : (com.qiyukf.basesdk.b.b.c.d) b.g();
    }

    public final g e() {
        d c = c();
        return c == null ? null : (g) c.g();
    }

    public final a f() {
        return this.a.a();
    }

    public abstract c g();
}
