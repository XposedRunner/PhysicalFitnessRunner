package com.qiyukf.nimlib.e;

public abstract class h {
    private static final ThreadLocal<i> a = new ThreadLocal();

    public static final void a() {
        a.set(null);
    }

    public static final void a(i iVar) {
        a.set(iVar);
    }

    protected static i b() {
        return (i) a.get();
    }
}
