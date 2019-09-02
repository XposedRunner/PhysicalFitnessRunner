package com.qiyukf.nimlib.h.a.c;

import com.qiyukf.nimlib.a.d.a;
import com.qiyukf.nimlib.a.d.b;
import com.qiyukf.nimlib.h.c.c.f;

@b(a = (byte) 4, b = {"1", "2"})
public class d extends a {
    private long b;
    private com.qiyukf.nimlib.h.c.a c;

    public final f a(f fVar) {
        com.qiyukf.nimlib.h.c.a aVar;
        short s;
        this.b = fVar.g();
        this.c = new com.qiyukf.nimlib.h.c.a();
        this.c.a(fVar);
        if (this.a.h() == (byte) 2) {
            aVar = this.c;
            s = (short) 0;
        } else {
            aVar = this.c;
            s = (short) 1;
        }
        aVar.a(s);
        StringBuilder stringBuilder = new StringBuilder("packet in notify: ");
        stringBuilder.append(this.c);
        com.qiyukf.basesdk.a.a.a("core", stringBuilder.toString());
        com.qiyukf.nimlib.h.c.c.b bVar = new com.qiyukf.nimlib.h.c.c.b();
        bVar.a(this.c);
        bVar.a(fVar.b());
        return new f(bVar.b());
    }

    public final long f() {
        return this.b;
    }

    public final com.qiyukf.nimlib.h.c.a g() {
        return this.c;
    }
}
