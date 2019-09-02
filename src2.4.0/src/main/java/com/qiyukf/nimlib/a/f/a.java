package com.qiyukf.nimlib.a.f;

public final class a {
    public static final a a = new a(0, 30);
    public static final a b = new a(2, 15);
    public static final a c = new a(0, 10);
    public static final a d = null;
    private int e;
    private int f;

    public a(int i, int i2) {
        this.e = i;
        this.f = i2;
    }

    public a(a aVar) {
        this.e = aVar.e;
        this.f = aVar.f;
    }

    public final int a() {
        return this.e;
    }

    public final int b() {
        return this.f;
    }

    public final int c() {
        int i = this.e - 1;
        this.e = i;
        return i;
    }
}
