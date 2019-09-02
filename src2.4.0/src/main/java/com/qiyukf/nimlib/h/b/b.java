package com.qiyukf.nimlib.h.b;

import com.qiyukf.basesdk.b.b.a.c;
import com.qiyukf.basesdk.b.b.a.e;
import com.qiyukf.basesdk.b.b.a.f;
import com.qiyukf.basesdk.b.b.a.g;
import java.net.SocketException;
import java.util.concurrent.atomic.AtomicInteger;

public final class b {
    private a a;
    private AtomicInteger b = new AtomicInteger(0);
    private com.qiyukf.basesdk.b.b.a.a c;
    private c d;
    private d e;
    private com.qiyukf.basesdk.b.b.a f;
    private com.qiyukf.nimlib.h.a g = new com.qiyukf.nimlib.h.a() {
        /* Access modifiers changed, original: protected|final */
        public final void a() {
            b.this.a(new com.qiyukf.nimlib.h.a.b.b());
        }

        /* Access modifiers changed, original: protected|final */
        public final void b() {
            com.qiyukf.basesdk.a.a.a("core", "keep alive on timeout");
            b.this.e();
        }
    };
    private f h = new f() {
        public final void a(c cVar) {
            b.a(b.this, cVar);
        }
    };

    public interface a {
        void a(int i);

        void a(com.qiyukf.nimlib.a.d.a.a aVar);
    }

    public b(a aVar) {
        this.a = aVar;
        f();
    }

    private void a(Object obj) {
        com.qiyukf.basesdk.b.b.a.a aVar = this.c;
        if (aVar != null) {
            aVar.a(obj);
            return;
        }
        com.qiyukf.basesdk.a.a.a("core", "writeRequest while channel is null");
    }

    private boolean c() {
        return this.b.get() == 2 || this.b.get() == 3;
    }

    private int d() {
        com.qiyukf.basesdk.b.b.a.a aVar = this.c;
        c cVar = this.d;
        synchronized (this) {
            this.c = null;
            this.d = null;
        }
        if (cVar != null) {
            cVar.b(this.h);
            cVar.e();
        }
        if (aVar != null) {
            aVar.e();
        }
        int andSet = this.b.getAndSet(0);
        if (!(andSet == 3 || andSet == 0)) {
            com.qiyukf.basesdk.a.a.a("core", "on channel unreachable");
            com.qiyukf.nimlib.h.b.b.a.a().c();
        }
        this.g.e();
        StringBuilder stringBuilder = new StringBuilder("do disconnect from ");
        stringBuilder.append(andSet);
        com.qiyukf.basesdk.a.a.d("core", stringBuilder.toString());
        return andSet;
    }

    private void e() {
        int d = d();
        if (this.a != null && d != 0) {
            this.a.a(0);
        }
    }

    private void f() {
        if (this.f != null) {
            this.f.b();
        }
        this.f = new com.qiyukf.basesdk.b.b.a();
        this.f.a(1, Boolean.valueOf(true)).a().a(4098, Integer.valueOf(65536)).a(new e() {
            public final void a(g gVar) {
                gVar.a(new com.qiyukf.nimlib.h.b.a.a(b.this.e));
                gVar.a(new com.qiyukf.nimlib.h.b.a.b(b.this.e));
                gVar.a(new com.qiyukf.basesdk.b.b.c.e() {
                    public final void a(Object obj) {
                        if (b.this.c == this.a.f() && (obj instanceof com.qiyukf.nimlib.a.d.a.a)) {
                            b.a(b.this, (com.qiyukf.nimlib.a.d.a.a) obj);
                            b.this.g.a(false);
                        }
                    }

                    public final void a(Object obj, c cVar) {
                        super.a(obj, cVar);
                        b.this.g.a(true);
                    }

                    public final void a(Throwable th) {
                        StringBuilder stringBuilder;
                        if (this.a.f() == b.this.c || b.this.c == null) {
                            stringBuilder = new StringBuilder("network exception caught: ");
                            stringBuilder.append(th);
                            com.qiyukf.basesdk.a.a.e("core", stringBuilder.toString());
                            th.printStackTrace();
                            if (th instanceof SocketException) {
                                com.qiyukf.basesdk.a.a.a("core", "on channel throw socket exception, on disconnected");
                                b.this.e();
                                return;
                            }
                            if ((th instanceof com.qiyukf.basesdk.b.b.b.b) && (th.getCause() instanceof com.qiyukf.nimlib.h.c.c.g)) {
                                com.qiyukf.basesdk.a.a.a("core", "on channel throw unpack exception, on disconnected and setup netty");
                                b.this.e();
                                b.this.f();
                            }
                            return;
                        }
                        stringBuilder = new StringBuilder("channel exception, but not current one, cause: ");
                        stringBuilder.append(th);
                        com.qiyukf.basesdk.a.a.d("net", stringBuilder.toString());
                    }

                    public final void h() {
                        if (b.this.c != null && b.this.c == this.a.f()) {
                            com.qiyukf.basesdk.a.a.a("core", "on channel inactive, on disconnected");
                            b.this.e();
                        }
                    }
                });
            }
        });
    }

    public final void a() {
        if (this.b.get() != 0) {
            d();
        }
    }

    public final boolean a(com.qiyukf.nimlib.a.c.a aVar) {
        if (c()) {
            a((Object) aVar);
            return true;
        }
        com.qiyukf.basesdk.a.a.a("core", "sendPacket while not connected");
        return false;
    }

    public final boolean a(com.qiyukf.nimlib.f.a.a aVar) {
        if (!c()) {
            return false;
        }
        a((Object) aVar);
        return true;
    }

    public final boolean a(com.qiyukf.nimlib.h.b.b.b bVar) {
        if (!this.b.compareAndSet(0, 1)) {
            return false;
        }
        if (this.e == null) {
            this.e = new d(com.qiyukf.nimlib.b.a(), new com.qiyukf.nimlib.h.b.d.b() {
                public final void a() {
                    b.this.e();
                }

                public final void a(com.qiyukf.nimlib.a.c.a.a aVar, boolean z) {
                    b.this.b.compareAndSet(2, 3);
                    if (z) {
                        com.qiyukf.nimlib.a.d.a.a a = com.qiyukf.nimlib.a.d.a.a.a(aVar.a, (short) 201);
                        if (!(a == null || b.this.a == null)) {
                            b.this.a.a(a);
                        }
                        return;
                    }
                    b.this.g.d();
                }
            });
        }
        this.e.a();
        try {
            c a = this.f.a(bVar.a, bVar.b);
            synchronized (this) {
                this.d = a;
            }
            a.a(this.h);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            StringBuilder stringBuilder = new StringBuilder("connect server failed: ");
            stringBuilder.append(e);
            com.qiyukf.basesdk.a.a.a("core", stringBuilder.toString());
            e();
            if (e instanceof com.qiyukf.basesdk.b.b.a.b) {
                stringBuilder = new StringBuilder("connect server failed, e=ChannelException ");
                stringBuilder.append(e.getMessage());
                com.qiyukf.basesdk.a.a.a("core", stringBuilder.toString());
            }
            return true;
        }
    }

    public final void b() {
        if (c()) {
            this.g.c();
        }
    }
}
