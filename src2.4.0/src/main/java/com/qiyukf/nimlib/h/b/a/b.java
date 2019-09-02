package com.qiyukf.nimlib.h.b.a;

import com.qiyukf.basesdk.b.b.b.c;
import com.qiyukf.basesdk.b.b.b.d;
import com.qiyukf.nimlib.a.c.a.a;
import java.nio.ByteBuffer;

public final class b extends d<Object> {
    com.qiyukf.nimlib.h.b.d b;

    public b(com.qiyukf.nimlib.h.b.d dVar) {
        super(Object.class);
        this.b = dVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final ByteBuffer a(Object obj) {
        com.qiyukf.nimlib.h.b.d dVar;
        a aVar;
        if (obj instanceof com.qiyukf.nimlib.a.c.a) {
            com.qiyukf.nimlib.a.c.a aVar2 = (com.qiyukf.nimlib.a.c.a) obj;
            dVar = this.b;
            aVar = new a(aVar2.a(), aVar2.b().b());
        } else if (obj instanceof com.qiyukf.nimlib.f.a.a) {
            com.qiyukf.nimlib.f.a.a aVar3 = (com.qiyukf.nimlib.f.a.a) obj;
            dVar = this.b;
            aVar = new a(aVar3.b(), aVar3.c());
        } else {
            StringBuilder stringBuilder = new StringBuilder("unsupport request type: ");
            stringBuilder.append(obj.getClass().getName());
            throw new c(stringBuilder.toString());
        }
        return dVar.a(aVar).b();
    }
}
