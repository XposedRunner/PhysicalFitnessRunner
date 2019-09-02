package com.qiyukf.nimlib.a.c.c;

import com.qiyukf.nimlib.h.c.c.b;
import com.qiyukf.nimlib.h.c.c.d;
import java.util.ArrayList;
import java.util.List;

public final class a extends com.qiyukf.nimlib.a.c.a {
    List<String> a = new ArrayList(1);

    public a(String str) {
        this.a.add(str);
    }

    public final b b() {
        b bVar = new b();
        d.a(bVar, this.a);
        return bVar;
    }

    public final byte c() {
        return (byte) 2;
    }

    public final byte d() {
        return (byte) 8;
    }
}
