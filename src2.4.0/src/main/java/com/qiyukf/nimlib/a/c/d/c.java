package com.qiyukf.nimlib.a.c.d;

import com.qiyukf.nimlib.a.c.a;
import com.qiyukf.nimlib.h.c.c.b;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;

public final class c extends a {
    private SessionTypeEnum a;
    private String b;
    private long c;
    private long d;
    private long e;
    private int f;
    private boolean g;
    private boolean h;

    public c(String str, SessionTypeEnum sessionTypeEnum, long j, long j2, long j3, int i, boolean z, boolean z2) {
        this.b = str;
        this.a = sessionTypeEnum;
        this.c = j;
        this.d = j2;
        this.e = j3;
        this.f = i;
        this.g = z;
        this.h = z2;
    }

    public final b b() {
        b bVar = new b();
        if (this.a == SessionTypeEnum.Team) {
            bVar.b(this.b);
        } else {
            bVar.a(this.b);
        }
        bVar.a(this.c);
        bVar.a(this.d);
        bVar.a(this.e);
        bVar.a(this.f);
        bVar.a(this.g);
        return bVar;
    }

    public final byte c() {
        return this.a == SessionTypeEnum.Team ? (byte) 8 : (byte) 7;
    }

    public final byte d() {
        return this.a == SessionTypeEnum.Team ? (byte) 23 : (byte) 6;
    }
}
