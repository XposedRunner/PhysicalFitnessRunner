package com.qiyukf.nimlib.g;

public enum c {
    MESSAGE("UNICORN_MESSAGE", 1),
    ADD_BUDDY("UNICORN_ADD_BUDDY", 2);
    
    public static final c[] c = null;
    public static final c[] d = null;
    private String e;
    private int f;

    static {
        c = new c[]{MESSAGE, ADD_BUDDY};
        d = new c[]{MESSAGE, ADD_BUDDY};
    }

    private c(String str, int i) {
        this.e = str;
        this.f = i;
    }

    public final String a() {
        return this.e;
    }

    public final int b() {
        return this.f;
    }
}
