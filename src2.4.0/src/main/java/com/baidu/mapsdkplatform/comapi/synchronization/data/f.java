package com.baidu.mapsdkplatform.comapi.synchronization.data;

public final class f {
    private String a;
    private String b;
    private String c;
    private b d;
    private int e;
    private int f;
    private a g;
    private String h;
    private String i;
    private int j;

    public enum a {
        GPS,
        COMMON,
        BD09LL,
        BD09MC
    }

    public enum b {
        DRIVING,
        RIDING
    }

    public f() {
        this.d = b.DRIVING;
        this.f = 15;
        this.g = a.BD09LL;
        this.d = b.DRIVING;
        this.g = a.BD09LL;
        this.f = 15;
    }

    public String a() {
        return this.a;
    }

    public void a(int i) {
        this.e = i;
    }

    public void a(String str) {
        this.a = str;
    }

    public String b() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }

    public String c() {
        return this.c;
    }

    public void c(String str) {
        this.c = str;
    }

    public String d() {
        return this.h;
    }

    public void d(String str) {
        this.h = str;
    }

    public String e() {
        return this.i;
    }

    public void e(String str) {
        this.i = str;
    }

    public a f() {
        return this.g;
    }

    public b g() {
        return this.d;
    }

    public int h() {
        return this.e;
    }

    public int i() {
        return this.f;
    }

    public int j() {
        return this.j;
    }
}
