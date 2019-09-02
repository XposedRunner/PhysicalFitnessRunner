package com.qiyukf.nimlib.a.d.a;

import com.qiyukf.nimlib.a.d.b;
import com.qiyukf.nimlib.h.c.c.d;
import com.qiyukf.nimlib.h.c.c.f;
import java.util.ArrayList;
import java.util.List;

@b(a = (byte) 6, b = {"1"})
public class a extends com.qiyukf.nimlib.a.d.a {
    private List<com.qiyukf.nimlib.h.c.b.b> b;

    public final f a(f fVar) {
        this.b = new ArrayList();
        int f = fVar.f();
        for (int i = 0; i < f; i++) {
            this.b.add(d.a(fVar));
        }
        return null;
    }

    public final List<com.qiyukf.nimlib.h.c.b.b> f() {
        return this.b;
    }
}
