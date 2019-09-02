package com.qiyukf.unicorn.f.a.c;

import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.d;
import com.qiyukf.unicorn.f.a.a;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b implements a {
    @com.qiyukf.unicorn.f.a.b.a(a = "type")
    private int a;
    @com.qiyukf.unicorn.f.a.b.a(a = "messageInvite")
    private String b;
    @com.qiyukf.unicorn.f.a.b.a(a = "messageThanks")
    private String c;
    @com.qiyukf.unicorn.f.a.b.a(a = "list")
    private List<c> d;
    private transient JSONObject e;

    public static b a() {
        Object jSONObject = new JSONObject();
        com.qiyukf.basesdk.c.b.a((JSONObject) jSONObject, "name", d.c().getString(R.string.ysf_evaluation_satisfied));
        com.qiyukf.basesdk.c.b.a((JSONObject) jSONObject, "value", 100);
        Object jSONObject2 = new JSONObject();
        com.qiyukf.basesdk.c.b.a((JSONObject) jSONObject2, "name", d.c().getString(R.string.ysf_evaluation_dissatisfied));
        com.qiyukf.basesdk.c.b.a((JSONObject) jSONObject2, "value", 1);
        Object jSONArray = new JSONArray();
        com.qiyukf.basesdk.c.b.a((JSONArray) jSONArray, jSONObject);
        com.qiyukf.basesdk.c.b.a((JSONArray) jSONArray, jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        com.qiyukf.basesdk.c.b.a(jSONObject3, "list", jSONArray);
        com.qiyukf.basesdk.c.b.a(jSONObject3, "type", 2);
        b bVar = new b();
        bVar.a(jSONObject3);
        return bVar;
    }

    public final void a(JSONObject jSONObject) {
        this.e = jSONObject;
        com.qiyukf.unicorn.f.a.b.a((Object) this, jSONObject);
    }

    public final JSONObject b() {
        return this.e;
    }

    public final int c() {
        return this.a;
    }

    public final String d() {
        return this.b;
    }

    public final String e() {
        return this.c;
    }

    public final List<c> f() {
        return this.d;
    }
}
