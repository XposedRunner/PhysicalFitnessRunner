package com.qiyukf.unicorn.f.a.a.b;

import com.qiyukf.unicorn.a.a.a.a.b.a;
import com.qiyukf.unicorn.f.a.b.c;
import org.json.JSONObject;

@c(a = "qiyu_template_mixReply")
public class b extends a {
    @com.qiyukf.unicorn.f.a.b.a(a = "label")
    private String a;
    @com.qiyukf.unicorn.f.a.b.a(a = "type")
    private String b;
    private transient JSONObject c;

    public final void a(String str) {
        this.a = str;
    }

    public final void b(String str) {
        this.b = str;
    }

    public final String c() {
        return this.a;
    }

    public final JSONObject d() {
        JSONObject jSONObject = this.c == null ? new JSONObject() : this.c;
        com.qiyukf.basesdk.c.b.a(jSONObject, "id", b());
        com.qiyukf.basesdk.c.b.a(jSONObject, "label", this.a);
        return jSONObject;
    }
}
