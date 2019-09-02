package com.qiyukf.nimlib.a.f;

import com.qiyukf.basesdk.sdk.ResponseCode;
import com.qiyukf.nimlib.a.d.a;

public abstract class c {
    private final a a;
    private boolean b = false;

    public c(a aVar) {
        this.a = aVar == null ? null : new a(aVar);
    }

    public abstract void a(a aVar);

    public final void a(short s) {
        com.qiyukf.nimlib.a.c.a().a(a.a.a(b().a(), s));
    }

    /* Access modifiers changed, original: protected */
    public boolean a() {
        b().a().b();
        com.qiyukf.nimlib.a.c.a().a(this);
        return true;
    }

    public abstract com.qiyukf.nimlib.a.c.a b();

    public final boolean c() {
        return this.a != null && this.a.a() > 0;
    }

    public final int d() {
        return this.a != null ? this.a.b() : 0;
    }

    public final boolean e() {
        if (this.a == null) {
            return false;
        }
        int c = this.a.c();
        if (c != -1 && !this.b) {
            return c < -1 ? false : a();
        } else {
            a((short) ResponseCode.RES_ETIMEOUT);
            return false;
        }
    }

    public final boolean f() {
        boolean z = false;
        if (this.a == null || this.a.c() < -1) {
            return false;
        }
        if (this.a.a() == -1) {
            z = true;
        }
        this.b = z;
        return a();
    }
}
