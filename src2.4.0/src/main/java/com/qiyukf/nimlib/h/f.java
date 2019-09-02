package com.qiyukf.nimlib.h;

import android.content.Context;
import com.qiyukf.basesdk.c.e;
import com.qiyukf.nimlib.h.b.b;
import com.qiyukf.nimlib.h.b.b.a;
import com.qiyukf.nimlib.sdk.auth.LoginInfo;
import com.qiyukf.unicorn.g.d;
import java.util.concurrent.atomic.AtomicInteger;

public final class f {
    private static f g = new f();
    private AtomicInteger a = new AtomicInteger(1);
    private Context b;
    private b c = new b();
    private b d = new b(new a() {
        public final void a(int i) {
            f.this.e.execute(new Runnable(i) {
                public final void run() {
                    try {
                        f.this.c.a(r3);
                    } catch (Throwable unused) {
                        com.qiyukf.basesdk.a.a.a("core", "handle connection change error");
                    }
                }
            });
        }

        public final void a(com.qiyukf.nimlib.a.d.a.a aVar) {
            f.this.f.a(aVar);
        }
    });
    private e e = new e("Response", e.c, false);
    private com.qiyukf.nimlib.a.b.b f = new com.qiyukf.nimlib.a.b.b(true, this.e, null);

    private f() {
    }

    public static f a() {
        return g;
    }

    private void a(final boolean z) {
        this.c.a(z);
        com.qiyukf.basesdk.c.a.b().postDelayed(new Runnable() {
            public final void run() {
                f.a(f.this, z);
            }
        }, 100);
    }

    private boolean e() {
        return this.a.get() == 3;
    }

    public final void a(int i) {
        this.c.b(i);
    }

    public final void a(int i, int i2) {
        this.c.a(i, i2);
        d.a().b();
        com.qiyukf.basesdk.c.a.b().post(new Runnable() {
            public final void run() {
                f.a(f.this, true);
            }
        });
    }

    public final void a(Context context) {
        if (this.a.compareAndSet(1, 2)) {
            com.qiyukf.basesdk.a.a.a("core", "startup");
            this.b = context;
            this.e.a();
            this.c.a(context, this.d);
            this.a.compareAndSet(2, 3);
        }
    }

    public final void a(com.qiyukf.nimlib.a.c.a aVar) {
        if (e()) {
            aVar.a().a(com.qiyukf.nimlib.a.b.a(true));
            this.d.a(aVar);
        }
    }

    public final void a(com.qiyukf.nimlib.a.d.a.a aVar) {
        this.f.a(aVar);
    }

    public final void a(com.qiyukf.nimlib.f.a.a aVar) {
        if (e()) {
            this.d.a(aVar);
        }
    }

    public final void a(LoginInfo loginInfo) {
        if (e()) {
            this.c.a(loginInfo);
        }
    }

    public final void b() {
        a(true);
        d.a().b();
    }

    public final void c() {
        a(false);
    }

    public final void d() {
        if (this.a.get() == 3) {
            this.d.b();
        }
    }
}
