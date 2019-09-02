package com.qiyukf.basesdk.b.b.a;

import android.os.SystemClock;
import android.util.SparseArray;
import com.qiyukf.basesdk.b.b.c.c;
import com.qiyukf.basesdk.b.b.c.d;
import com.qiyukf.basesdk.b.b.c.f;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;

public final class g {
    private a a;
    private j b;
    private l c;
    private f d;
    private c e;
    private i f;

    private class a implements Runnable {
        private d b;
        private Object c;
        private c d;

        public a(d dVar, Object obj, c cVar) {
            this.b = dVar;
            this.c = obj;
            this.d = cVar;
        }

        public final void run() {
            try {
                d dVar = this.b;
                Object obj = this.c;
                c cVar = this.d;
                if (g.this.a.b().b()) {
                    com.qiyukf.basesdk.b.b.c.g e = dVar.e();
                    if (e != null) {
                        e.a(obj, cVar);
                    }
                } else {
                    cVar.a(com.qiyukf.basesdk.b.b.e.a.a(g.this.a));
                }
                this.b = null;
                this.c = null;
                this.d = null;
            } catch (Throwable th) {
                this.b = null;
                this.c = null;
                this.d = null;
            }
        }
    }

    public g(a aVar, f fVar) {
        this.a = aVar;
        this.d = fVar;
        this.b = new j(this);
        this.c = new l(this);
        this.b.c = this.c;
        this.c.b = this.b;
    }

    static /* synthetic */ void a(g gVar, SparseArray sparseArray, e eVar) {
        gVar.a.a(sparseArray);
        eVar.a(gVar);
    }

    static /* synthetic */ void a(g gVar, SocketAddress socketAddress, c cVar, long j) {
        d c = gVar.c.c();
        if (c != null) {
            try {
                if (((com.qiyukf.basesdk.b.b.c.g) c.g()).a(socketAddress)) {
                    gVar.g();
                    cVar.b();
                    return;
                }
                gVar.e = cVar;
                if (gVar.f != null) {
                    gVar.f.b();
                }
                gVar.f = new i(SystemClock.elapsedRealtime() + j) {
                    public final void run() {
                        if (!c()) {
                            g.this.b((Throwable) new ConnectException("connect timeout"));
                        }
                    }
                };
                gVar.d.a(gVar.f);
            } catch (Exception e) {
                cVar.a(e);
            }
        }
    }

    private void b(Throwable th) {
        c cVar = this.e;
        this.e = null;
        if (cVar != null) {
            if (th != null) {
                cVar.a(th);
                return;
            }
            cVar.b();
        }
    }

    private void g() {
        try {
            SelectionKey f = this.a.f();
            if (f.isValid()) {
                int interestOps = f.interestOps();
                if ((interestOps & 1) == 0) {
                    f.interestOps(interestOps | 1);
                }
            }
        } catch (Exception e) {
            this.d.execute(new Runnable() {
                public final void run() {
                    g.this.b.a(e);
                }
            });
            this.a.e();
        }
    }

    public final a a() {
        return this.a;
    }

    public final c a(Object obj) {
        c cVar = new c(this.a);
        com.qiyukf.basesdk.b.b.e.a.a(this.d, new a(this.c, obj, cVar));
        return cVar;
    }

    public final c a(String str, int i, SparseArray<Object> sparseArray, e eVar, long j) {
        c cVar = new c(this.a);
        final c cVar2 = cVar;
        final SparseArray<Object> sparseArray2 = sparseArray;
        final e eVar2 = eVar;
        final String str2 = str;
        final int i2 = i;
        final long j2 = j;
        this.d.execute(new Runnable() {
            public final void run() {
                if (g.this.e != null) {
                    cVar2.a(new b("Already in connection progress"));
                }
                try {
                    g.a(g.this, sparseArray2, eVar2);
                } catch (Throwable th) {
                    g.this.a.e();
                    cVar2.a(th);
                }
                g.a(g.this, new InetSocketAddress(str2, i2), cVar2, j2);
            }
        });
        return cVar;
    }

    public final void a(c cVar) {
        d hVar = new h(this, cVar);
        cVar.a(hVar);
        hVar.c = this.c;
        hVar.b = this.c.b;
        this.c.b.c = hVar;
        this.c.b = hVar;
    }

    public final void a(Throwable th) {
        this.b.a(th);
    }

    /* Access modifiers changed, original: final */
    public final void a(ByteBuffer byteBuffer) {
        d b = this.b.b();
        if (b != null) {
            ((d) b.g()).a(byteBuffer);
        }
    }

    public final void b() {
        try {
            this.a.b().f();
            b(null);
            if (this.a.b().b()) {
                g();
            }
            if (this.f != null) {
                this.f.b();
                this.f = null;
            }
            this.e = null;
        } catch (Throwable th) {
            if (this.f != null) {
                this.f.b();
                this.f = null;
            }
            this.e = null;
            throw th;
        }
    }

    public final void c() {
        if (this.d.h()) {
            this.c.e().a(new c(this.a));
        } else {
            com.qiyukf.basesdk.b.b.e.a.a(this.d, new Runnable() {
                public final void run() {
                    g.this.c.e().a(new c(g.this.a));
                }
            });
        }
    }

    public final f d() {
        return this.d;
    }

    /* Access modifiers changed, original: final */
    public final void e() {
        d b = this.b.b();
        if (b != null) {
            ((d) b.g()).i();
        }
    }

    /* Access modifiers changed, original: final */
    public final void f() {
        d b = this.b.b();
        if (b != null) {
            ((d) b.g()).h();
        }
        if (this.f != null) {
            this.f.b();
            this.f = null;
        }
    }
}
