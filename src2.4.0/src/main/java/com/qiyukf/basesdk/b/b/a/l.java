package com.qiyukf.basesdk.b.b.a;

import com.qiyukf.basesdk.a.a;
import com.qiyukf.basesdk.b.b.c.c;
import com.qiyukf.basesdk.b.b.c.d;

final class l extends d implements d {
    l(g gVar) {
        super(gVar, true, false);
    }

    public final void a(d dVar) {
    }

    public final void a(Object obj) {
        StringBuilder stringBuilder = new StringBuilder("Discarded inbound message ");
        stringBuilder.append(obj);
        stringBuilder.append("  that reached at the tail of the pipeline. Please check your pipeline configuration.");
        a.d("DefaultChannelPipeline", stringBuilder.toString());
    }

    public final void a(Throwable th) {
        a.d("DefaultChannelPipeline", "An exceptionCaught() event was fired, and it reached at the tail of the pipeline. It usually means the last handler in the pipeline did not handle the exception.", th);
    }

    public final c g() {
        return this;
    }

    public final void h() {
    }

    public final void i() {
    }
}
