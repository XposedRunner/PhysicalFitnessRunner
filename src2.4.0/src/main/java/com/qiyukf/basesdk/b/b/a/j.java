package com.qiyukf.basesdk.b.b.a;

import com.qiyukf.basesdk.b.b.c.c;
import com.qiyukf.basesdk.b.b.c.g;
import com.qiyukf.basesdk.b.b.d.a;
import java.net.SocketAddress;
import java.nio.ByteBuffer;

final class j extends d implements g {
    j(g gVar) {
        super(gVar, false, true);
    }

    private a h() {
        return this.a.a().b();
    }

    public final void a(c cVar) {
        this.a.a().g();
    }

    public final void a(d dVar) {
    }

    public final void a(Object obj, c cVar) {
        if (obj instanceof ByteBuffer) {
            h().a((ByteBuffer) obj, cVar);
        } else {
            cVar.a(new UnsupportedOperationException("Only ByteBuffer is supported"));
        }
    }

    public final void a(Throwable th) {
        if (this.c != null && this.c.g() != null) {
            this.c.g().a(th);
        }
    }

    public final boolean a(SocketAddress socketAddress) {
        return h().a(socketAddress);
    }

    public final c g() {
        return this;
    }
}
