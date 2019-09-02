package com.qiyukf.nimlib.a.d;

import com.qiyukf.basesdk.sdk.ResponseCode;
import com.qiyukf.nimlib.h.c.c.f;

public abstract class a {
    protected com.qiyukf.nimlib.h.c.a a;

    public static final class a {
        public com.qiyukf.nimlib.h.c.a a;
        public f b;

        public static a a(com.qiyukf.nimlib.h.c.a aVar, short s) {
            if (aVar == null) {
                return null;
            }
            a aVar2 = new a();
            aVar2.a = aVar.a();
            aVar2.a.b(s);
            return aVar2;
        }
    }

    public final com.qiyukf.nimlib.h.c.a a() {
        return this.a;
    }

    public abstract f a(f fVar);

    public final void a(com.qiyukf.nimlib.h.c.a aVar) {
        this.a = aVar;
    }

    public final boolean b() {
        return this.a != null && this.a.j() == ResponseCode.RES_SUCCESS;
    }

    public final short c() {
        return this.a != null ? this.a.i() : (short) 0;
    }

    public final byte d() {
        return this.a != null ? this.a.h() : (byte) 0;
    }

    public final short e() {
        return this.a != null ? this.a.j() : ResponseCode.RES_EUNKNOWN;
    }
}
