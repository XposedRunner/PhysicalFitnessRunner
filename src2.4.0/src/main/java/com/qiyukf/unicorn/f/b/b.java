package com.qiyukf.unicorn.f.b;

public final class b extends Exception {
    private int a;

    public b(String str, Throwable th) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(" code is: 408");
        super(stringBuilder.toString(), th);
        this.a = 408;
    }

    public final int a() {
        return this.a;
    }
}
