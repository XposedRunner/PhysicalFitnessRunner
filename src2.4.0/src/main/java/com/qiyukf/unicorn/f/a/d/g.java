package com.qiyukf.unicorn.f.a.d;

import com.qiyukf.unicorn.f.a.b.a;
import com.qiyukf.unicorn.f.a.b.b;
import com.qiyukf.unicorn.f.a.e;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

@b(a = 502, b = false)
public class g extends e {
    @a(a = "result")
    private String a;
    private Map<String, Integer> b;

    public final Map<String, Integer> a() {
        return this.b;
    }

    /* Access modifiers changed, original: protected */
    public void afterParse(JSONObject jSONObject) {
        super.afterParse(jSONObject);
        JSONArray b = com.qiyukf.basesdk.c.b.b(this.a);
        if (b != null && b.length() > 0) {
            this.b = new HashMap(b.length());
            for (int i = 0; i < b.length(); i++) {
                JSONObject b2 = com.qiyukf.basesdk.c.b.b(b, i);
                this.b.put(com.qiyukf.basesdk.c.b.e(com.qiyukf.basesdk.c.b.f(b2, "shop"), "id"), Integer.valueOf(com.qiyukf.basesdk.c.b.b(com.qiyukf.basesdk.c.b.f(b2, "sessionStatus"), "status")));
            }
        }
    }
}
