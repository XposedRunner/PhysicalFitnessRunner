package com.qiyukf.nimlib.a.c;

import com.qiyukf.nimlib.h.c.c.b;
import java.nio.ByteBuffer;

public abstract class a {
    private com.qiyukf.nimlib.h.c.a a;
    private Object b;

    public static class a {
        public com.qiyukf.nimlib.h.c.a a;
        public ByteBuffer b;

        public a(com.qiyukf.nimlib.h.c.a aVar, ByteBuffer byteBuffer) {
            this.a = aVar;
            this.b = byteBuffer;
        }
    }

    public final com.qiyukf.nimlib.h.c.a a() {
        if (this.a == null) {
            this.a = new com.qiyukf.nimlib.h.c.a(c(), d());
        }
        return this.a;
    }

    public final void a(Object obj) {
        this.b = obj;
    }

    public abstract b b();

    public abstract byte c();

    public abstract byte d();

    public final Object e() {
        return this.b;
    }
}
