package com.qiyukf.unicorn.f.a.a.b;

import com.qiyukf.basesdk.c.b;
import com.qiyukf.unicorn.f.a.b.c;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@c(a = "qiyu_template_botForm")
public class a extends com.qiyukf.unicorn.a.a.a.a.b.a {
    @com.qiyukf.unicorn.f.a.b.a(a = "forms")
    private List<com.qiyukf.unicorn.f.a.a.a.f.a> a;

    public final void a(List<com.qiyukf.unicorn.f.a.a.a.f.a> list) {
        this.a = list;
    }

    public final JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        b.a(jSONObject, "id", b());
        Object jSONArray = new JSONArray();
        for (com.qiyukf.unicorn.f.a.a.a.f.a aVar : this.a) {
            Object jSONObject2 = new JSONObject();
            b.a((JSONObject) jSONObject2, "label", aVar.c());
            b.a((JSONObject) jSONObject2, "type", aVar.b());
            b.a((JSONObject) jSONObject2, "value", aVar.f());
            b.a((JSONArray) jSONArray, jSONObject2);
        }
        b.a(jSONObject, "forms", jSONArray);
        return jSONObject;
    }

    public final List<com.qiyukf.unicorn.f.a.a.a.f.a> d() {
        return this.a;
    }
}
