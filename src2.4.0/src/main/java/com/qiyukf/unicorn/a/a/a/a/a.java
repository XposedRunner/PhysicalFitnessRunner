package com.qiyukf.unicorn.a.a.a.a;

import com.qiyukf.unicorn.f.a.b.b;
import com.qiyukf.unicorn.f.a.e;
import org.json.JSONObject;

@b(a = 203)
public class a extends e {
    @com.qiyukf.unicorn.f.a.b.a(a = "type")
    private String a;
    @com.qiyukf.unicorn.f.a.b.a(a = "template")
    private String b;

    public final String a() {
        return this.a;
    }

    public final void a(String str, Object obj) {
        JSONObject a = com.qiyukf.basesdk.c.b.a(this.b);
        if (a != null) {
            com.qiyukf.basesdk.c.b.a(a, str, obj);
            this.b = a.toString();
        }
    }

    public final String b() {
        return this.b;
    }
}
