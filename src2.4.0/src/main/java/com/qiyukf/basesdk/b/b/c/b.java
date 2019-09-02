package com.qiyukf.basesdk.b.b.c;

import com.qiyukf.basesdk.b.b.a.c;
import com.qiyukf.basesdk.b.b.a.d;
import java.net.SocketAddress;

public class b implements g {
    protected d a;

    public final void a(c cVar) {
        g e = this.a.e();
        if (e != null) {
            try {
                e.a(cVar);
            } catch (Throwable th) {
                this.a.g().a(th);
            }
        }
    }

    public final void a(d dVar) {
        this.a = dVar;
    }

    public void a(Object obj, c cVar) {
        g e = this.a.e();
        if (e != null) {
            try {
                e.a(obj, cVar);
            } catch (Throwable th) {
                this.a.g().a(th);
            }
        }
    }

    public void a(Throwable th) {
        if (this.a.a() != null && this.a.a().g() != null) {
            this.a.a().g().a(th);
        }
    }

    public final boolean a(SocketAddress socketAddress) {
        g e = this.a.e();
        if (e != null) {
            try {
                return e.a(socketAddress);
            } catch (Throwable th) {
                e.a(th);
            }
        }
        return false;
    }
}
