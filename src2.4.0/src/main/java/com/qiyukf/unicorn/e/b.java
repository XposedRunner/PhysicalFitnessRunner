package com.qiyukf.unicorn.e;

import java.io.Serializable;

public final class b implements Serializable {
    public int a;
    public long b;
    public String c;
    public long d;

    public final long a() {
        return this.a == 1 ? this.b : 0;
    }

    public final long b() {
        return this.a == 2 ? this.b : 0;
    }
}
