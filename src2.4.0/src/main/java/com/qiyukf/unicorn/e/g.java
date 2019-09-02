package com.qiyukf.unicorn.e;

import java.io.Serializable;

public final class g implements Serializable {
    public static final g a = new g(true, 1.5f);
    private boolean b;
    private float c;

    public g(boolean z, float f) {
        this.b = z;
        this.c = f;
    }

    public final boolean a() {
        return this.b;
    }

    public final float b() {
        return this.c;
    }
}
