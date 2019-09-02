package com.qiyukf.nimlib.h.a.c;

import com.qiyukf.nimlib.a.d.a;
import com.qiyukf.nimlib.h.c.c.d;
import com.qiyukf.nimlib.h.c.c.f;
import java.util.ArrayList;

@com.qiyukf.nimlib.a.d.b(a = (byte) 2, b = {"2"})
public class b extends a {
    private com.qiyukf.nimlib.h.c.b.b b;
    private ArrayList<com.qiyukf.nimlib.a.a> c;

    public final f a(f fVar) {
        this.b = d.a(fVar);
        if (fVar.a() > 0) {
            int f = fVar.f();
            if (f > 0) {
                this.c = new ArrayList(f);
                for (int i = 0; i < f; i++) {
                    this.c.add(com.qiyukf.nimlib.a.a.a(d.a(fVar)));
                }
            }
        }
        return null;
    }

    public final com.qiyukf.nimlib.h.c.b.b f() {
        return this.b;
    }

    public final ArrayList<com.qiyukf.nimlib.a.a> g() {
        return this.c;
    }
}
