package com.qiyukf.basesdk.b.a.a;

import com.qiyukf.basesdk.c.c.c;

public final class d {
    private String a;
    private String b;
    private String c;
    private long d;
    private boolean e;
    private e f;

    public d(String str, String str2, e eVar) {
        this(str, str2, eVar, (byte) 0);
    }

    private d(String str, String str2, e eVar, byte b) {
        this.e = false;
        this.a = str;
        this.b = str2;
        this.f = eVar;
        this.d = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append("@url#");
        stringBuilder.append(c.a(str));
        this.c = stringBuilder.toString();
    }

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }

    public final long d() {
        return this.d;
    }

    public final void e() {
        this.e = true;
        if (this.f != null) {
            this.f.c();
        }
    }

    public final boolean f() {
        return this.e;
    }

    public final e g() {
        return this.f;
    }
}
