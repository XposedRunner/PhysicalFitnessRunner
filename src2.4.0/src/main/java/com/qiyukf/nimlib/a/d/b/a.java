package com.qiyukf.nimlib.a.d.b;

import com.qiyukf.nimlib.a.d.b;
import com.qiyukf.nimlib.h.c.c.d;
import com.qiyukf.nimlib.h.c.c.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@b(a = (byte) 4, b = {"6", "101"})
public class a extends com.qiyukf.nimlib.a.d.a {
    private List<com.qiyukf.nimlib.h.c.b.b> b;

    public final f a(f fVar) {
        int f = fVar.f();
        this.b = new ArrayList(f);
        for (int i = 0; i < f; i++) {
            this.b.add(d.a(fVar));
        }
        Collections.sort(this.b, new Comparator<com.qiyukf.nimlib.h.c.b.b>() {
            public final /* synthetic */ int compare(Object obj, Object obj2) {
                com.qiyukf.nimlib.h.c.b.b bVar = (com.qiyukf.nimlib.h.c.b.b) obj2;
                long c = ((com.qiyukf.nimlib.h.c.b.b) obj).c(0);
                long c2 = bVar.c(0);
                return c == c2 ? 0 : c - c2 > 0 ? 1 : -1;
            }
        });
        return null;
    }

    public final List<com.qiyukf.nimlib.h.c.b.b> f() {
        return this.b;
    }
}
