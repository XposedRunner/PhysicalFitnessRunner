package com.qiyukf.nimlib.d.c;

public class b {
    private Long a;
    private Long b;
    private Long c;
    private Long d;
    private Long e;
    private Long f;
    private Long g;
    private Long h;
    private boolean i;

    public final Long a() {
        return this.a;
    }

    public final Long b() {
        return this.b;
    }

    public final Long c() {
        return this.c;
    }

    public final Long d() {
        return this.d;
    }

    public final Long e() {
        return this.e;
    }

    public final Long f() {
        return this.f;
    }

    public final Long g() {
        return this.g;
    }

    public final Long h() {
        return this.h;
    }

    public final boolean i() {
        return this.i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("DCStrategy{dev=");
        stringBuilder.append(this.a);
        stringBuilder.append(", corp=");
        stringBuilder.append(this.b);
        stringBuilder.append(", applist=");
        stringBuilder.append(this.c);
        stringBuilder.append(", source=");
        stringBuilder.append(this.d);
        stringBuilder.append(", wifiinfo=");
        stringBuilder.append(this.e);
        stringBuilder.append(", wifilist=");
        stringBuilder.append(this.f);
        stringBuilder.append(", gpsinfo=");
        stringBuilder.append(this.g);
        stringBuilder.append(", baseinfo=");
        stringBuilder.append(this.h);
        stringBuilder.append(", enable=");
        stringBuilder.append(this.i);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
