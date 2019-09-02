package com.qiyukf.nimlib.h.a.c;

import com.qiyukf.nimlib.a.d.a;
import com.qiyukf.nimlib.a.d.b;
import com.qiyukf.nimlib.h.c.c.d;
import com.qiyukf.nimlib.h.c.c.f;
import java.util.ArrayList;

@b(a = (byte) 2, b = {"7"})
public class c extends a {
    private byte b;
    private ArrayList<com.qiyukf.nimlib.a.a> c;

    public final f a(f fVar) {
        this.b = fVar.c();
        int f = fVar.f();
        this.c = new ArrayList(f);
        for (int i = 0; i < f; i++) {
            this.c.add(com.qiyukf.nimlib.a.a.a(d.a(fVar)));
        }
        return null;
    }

    public final byte f() {
        return this.b;
    }

    public final ArrayList<com.qiyukf.nimlib.a.a> g() {
        return this.c;
    }
}
