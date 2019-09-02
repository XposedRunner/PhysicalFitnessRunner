package com.qiyukf.basesdk.b.a.b.c;

import android.util.Base64;

public final class a {
    private Object a;
    private String b;
    private int c;
    private String d;
    private Exception e;
    private String f;
    private String g;

    public a(Object obj, String str, int i, String str2, String str3, String str4, Exception exception) {
        this.a = obj;
        this.b = str;
        this.c = i;
        this.f = str2;
        this.g = new String(Base64.decode(str3, 0));
        this.d = str4;
        this.e = exception;
    }

    public final int a() {
        return this.c;
    }

    public final Exception b() {
        return this.e;
    }
}
