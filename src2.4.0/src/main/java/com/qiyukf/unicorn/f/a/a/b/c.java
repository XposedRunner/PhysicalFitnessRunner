package com.qiyukf.unicorn.f.a.a.b;

import android.content.Context;
import com.qiyukf.basesdk.c.b;
import com.qiyukf.unicorn.a.a.a.a.b.a;
import org.json.JSONObject;

@com.qiyukf.unicorn.f.a.b.c(a = "qiyu_template_text")
public class c extends a implements com.qiyukf.unicorn.f.a.c {
    @com.qiyukf.unicorn.f.a.b.a(a = "label")
    private String a;

    public final String a(Context context) {
        return this.a;
    }

    public final void a(String str) {
        this.a = str;
    }

    public final JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        b.a(jSONObject, "label", this.a);
        b.a(jSONObject, "id", b());
        return jSONObject;
    }

    public final String d() {
        return this.a;
    }
}
