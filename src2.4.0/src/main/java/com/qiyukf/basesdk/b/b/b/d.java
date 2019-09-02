package com.qiyukf.basesdk.b.b.b;

import com.qiyukf.basesdk.b.b.a.c;
import com.qiyukf.basesdk.b.b.c.b;
import java.nio.ByteBuffer;

public abstract class d<I> extends b {
    private final Class<? extends I> b;

    protected d(Class<? extends I> cls) {
        this.b = cls;
    }

    public abstract ByteBuffer a(I i);

    public final void a(Object obj, c cVar) {
        try {
            Object obj2 = (this.b == null || !this.b.isInstance(obj)) ? null : 1;
            if (obj2 != null) {
                super.a(a(obj), cVar);
            } else {
                super.a(obj, cVar);
            }
        } catch (c e) {
            throw e;
        } catch (Throwable th) {
            c cVar2 = new c(th);
        }
    }
}
