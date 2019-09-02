package com.qiyukf.basesdk.b.b.a;

import android.util.SparseArray;
import com.qiyukf.basesdk.b.b.c.f;
import com.qiyukf.basesdk.b.b.d.a;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.SelectionKey;

public final class k implements a {
    private volatile SelectionKey a;
    private g b;
    private a c = new a(this);
    private c d = new c(this);

    public k(f fVar) {
        this.b = new g(this, fVar);
    }

    public final c a(Object obj) {
        return this.b.a(obj);
    }

    public final g a() {
        return this.b;
    }

    public final void a(SparseArray<Object> sparseArray) {
        this.c.a((SparseArray) sparseArray);
        Object obj = null;
        while (true) {
            try {
                this.a = this.c.a(this.b.d().a(), (a) this);
                return;
            } catch (CancelledKeyException e) {
                if (obj == null) {
                    this.b.d().d();
                    obj = 1;
                } else {
                    throw e;
                }
            }
        }
    }

    public final void a(SelectionKey selectionKey) {
        this.a = selectionKey;
    }

    public final a b() {
        return this.c;
    }

    public final f c() {
        return this.b.d();
    }

    public final boolean d() {
        return this.c.a();
    }

    public final void e() {
        this.b.c();
    }

    public final SelectionKey f() {
        return this.a;
    }

    public final void g() {
        if (this.c.e()) {
            this.b.d().execute(new Runnable() {
                public final void run() {
                    k.this.e();
                }
            });
        } else if (!this.d.c()) {
            boolean b = this.c.b();
            try {
                this.c.c();
                this.d.b();
            } catch (Throwable th) {
                this.d.a(th);
            } finally {
                if (b && !this.c.b()) {
                    com.qiyukf.basesdk.b.b.e.a.a(this.b.d(), new Runnable() {
                        public final void run() {
                            k.this.b.f();
                        }
                    });
                }
                this.a.cancel();
            }
        }
    }

    public final void h() {
        int i = 0;
        int i2 = 0;
        do {
            try {
                ByteBuffer allocate = ByteBuffer.allocate(1024);
                int a = this.c.a(allocate);
                if (a > 0) {
                    this.b.a(allocate);
                    if (a < 1024) {
                        break;
                    }
                    i2++;
                } else if (a < 0) {
                    i = 1;
                }
            } catch (Throwable th) {
                this.b.e();
                this.b.a(th);
                if (this.c.a() && (null != null || (th instanceof IOException))) {
                    this.b.c();
                }
                return;
            }
        } while (i2 < 16);
        this.b.e();
        if (i != 0 && this.c.a()) {
            this.b.c();
        }
    }
}
