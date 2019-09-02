package com.qiyukf.nimlib.a.c.b;

import com.qiyukf.nimlib.h.c.c.b;
import java.util.List;

public final class a extends com.qiyukf.nimlib.a.c.a {
    private byte a;
    private byte b;
    private List<Long> c;

    public final void a(byte b) {
        this.a = b;
    }

    public final void a(List<Long> list) {
        this.c = list;
    }

    public final b b() {
        b bVar = new b();
        bVar.a(this.a);
        bVar.a(this.b);
        bVar.b(this.c.size());
        for (Long longValue : this.c) {
            bVar.a(longValue.longValue());
        }
        return bVar;
    }

    public final void b(byte b) {
        this.b = b;
    }

    public final byte c() {
        return (byte) 4;
    }

    public final byte d() {
        return (byte) 5;
    }
}
