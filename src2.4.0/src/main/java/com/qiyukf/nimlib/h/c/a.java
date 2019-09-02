package com.qiyukf.nimlib.h.c;

import com.qiyukf.basesdk.sdk.ResponseCode;
import com.qiyukf.nimlib.h.c.c.b;
import com.qiyukf.nimlib.h.c.c.f;

public final class a implements com.qiyukf.nimlib.h.c.b.a {
    private byte a;
    private byte b;
    private short c;
    private byte d;
    private int e = 0;
    private short f = ResponseCode.RES_SUCCESS;

    public a(byte b, byte b2) {
        this.a = b;
        this.b = b2;
    }

    public final a a() {
        a aVar = new a();
        aVar.a = this.a;
        aVar.b = this.b;
        aVar.c = this.c;
        aVar.d = this.d;
        aVar.e = this.e;
        aVar.f = this.f;
        return aVar;
    }

    public final void a(int i) {
        this.e = i;
    }

    public final void a(b bVar) {
        bVar.b(this.e);
        bVar.a(this.a);
        bVar.a(this.b);
        bVar.a(this.c);
        bVar.a(this.d);
        if (d()) {
            bVar.a(this.f);
        }
    }

    public final void a(f fVar) {
        this.e = fVar.f();
        this.a = fVar.c();
        this.b = fVar.c();
        this.c = fVar.h();
        this.d = fVar.c();
        if (d()) {
            this.f = fVar.h();
        }
    }

    public final void a(short s) {
        this.c = s;
    }

    public final void b() {
        this.f = ResponseCode.RES_SUCCESS;
        this.d = (byte) 0;
        this.e = 0;
    }

    public final void b(short s) {
        this.d = (byte) (this.d | 2);
        this.f = s;
    }

    public final boolean c() {
        return (this.d & 1) != 0;
    }

    public final boolean d() {
        return (this.d & 2) != 0;
    }

    public final void e() {
        this.d = (byte) (this.d | 1);
    }

    public final void f() {
        this.d = (byte) (this.d & -2);
    }

    public final byte g() {
        return this.a;
    }

    public final byte h() {
        return this.b;
    }

    public final short i() {
        return this.c;
    }

    public final short j() {
        return this.f;
    }

    public final byte k() {
        return this.d;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("PacketHeader [SID ");
        stringBuilder.append(this.a);
        stringBuilder.append(" , CID ");
        stringBuilder.append(this.b);
        stringBuilder.append(" , SER ");
        stringBuilder.append(this.c);
        stringBuilder.append(" , RES ");
        stringBuilder.append(this.f);
        stringBuilder.append(" , TAG ");
        stringBuilder.append(this.d);
        stringBuilder.append(" , LEN ");
        stringBuilder.append(this.e);
        String stringBuilder2 = stringBuilder.toString();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append("]");
        return stringBuilder3.toString();
    }
}
