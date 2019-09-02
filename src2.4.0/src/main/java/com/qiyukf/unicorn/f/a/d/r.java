package com.qiyukf.unicorn.f.a.d;

import com.qiyukf.unicorn.f.a.b.b;
import com.qiyukf.unicorn.f.a.e;

@b(a = 57)
public class r extends e {
    @com.qiyukf.unicorn.f.a.b.a(a = "config")
    private a a;

    public static class a implements com.qiyukf.unicorn.f.a.a {
        @com.qiyukf.unicorn.f.a.b.a(a = "switch")
        private int a;
        @com.qiyukf.unicorn.f.a.b.a(a = "sendingRate")
        private String b;
    }

    public final boolean a() {
        return this.a != null && this.a.a > 0;
    }

    public final float b() {
        if (this.a != null) {
            try {
                return Float.parseFloat(this.a.b);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0.0f;
    }
}
