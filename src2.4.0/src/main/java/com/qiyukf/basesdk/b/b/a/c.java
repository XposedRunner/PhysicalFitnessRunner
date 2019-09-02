package com.qiyukf.basesdk.b.b.a;

import com.qiyukf.basesdk.b.b.c.f;
import java.util.ArrayList;
import java.util.List;

public final class c {
    private static final a a = new a("SUCCESS");
    private static final a b = new a("CANCELED");
    private List<f> c;
    private f d;
    private a e;
    private Object f;
    private Throwable g;

    private static final class a {
        String a;

        a(String str) {
            this.a = str;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("ChannelFutureResult ");
            stringBuilder.append(this.a);
            return stringBuilder.toString();
        }
    }

    public c(a aVar) {
        this.e = aVar;
        this.d = aVar.a().d();
    }

    private void f() {
        if (this.d.h()) {
            g();
        } else {
            com.qiyukf.basesdk.b.b.e.a.a(this.d, new Runnable() {
                public final void run() {
                    c.this.g();
                }
            });
        }
    }

    private void g() {
        if (this.c != null) {
            for (f a : this.c) {
                a.a(this);
            }
        }
    }

    public final a a() {
        return this.e;
    }

    public final void a(final f fVar) {
        if (this.c == null) {
            this.c = new ArrayList();
        }
        if (!this.c.contains(fVar)) {
            this.c.add(fVar);
            if (c()) {
                if (this.d.h()) {
                    fVar.a(this);
                    return;
                }
                com.qiyukf.basesdk.b.b.e.a.a(this.d, new Runnable() {
                    public final void run() {
                        fVar.a(c.this);
                    }
                });
            }
        }
    }

    public final void a(Throwable th) {
        this.g = th;
        f();
    }

    public final void b() {
        this.f = a;
        this.g = null;
        f();
    }

    public final void b(f fVar) {
        if (this.c != null) {
            this.c.remove(fVar);
        }
    }

    public final boolean c() {
        return (this.f == null && this.g == null) ? false : true;
    }

    public final boolean d() {
        return this.g == null && this.f != b;
    }

    public final boolean e() {
        if (c()) {
            return false;
        }
        synchronized (this) {
            if (c()) {
                return false;
            }
            this.f = b;
            f();
            return true;
        }
    }
}
