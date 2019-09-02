package com.qiyukf.unicorn.f.a.a;

import com.qiyukf.unicorn.f.a.a.a.d;
import com.qiyukf.unicorn.f.a.a.a.k;
import com.qiyukf.unicorn.f.a.b.a;
import com.qiyukf.unicorn.f.a.e;
import org.json.JSONObject;

@com.qiyukf.unicorn.f.a.b.b(a = 205)
public class b extends e {
    @a(a = "template")
    private String a;
    private com.qiyukf.unicorn.a.a.a.a.a.a b;

    public final com.qiyukf.unicorn.a.a.a.a.a.a a() {
        return this.b;
    }

    /* Access modifiers changed, original: protected */
    public void afterParse(JSONObject jSONObject) {
        super.afterParse(jSONObject);
        jSONObject = com.qiyukf.basesdk.c.b.a(this.a);
        String e = com.qiyukf.basesdk.c.b.e(jSONObject, "id");
        if (e != null) {
            com.qiyukf.unicorn.a.a.a.a.a.a kVar;
            Object obj = -1;
            int hashCode = e.hashCode();
            if (hashCode != -1349088399) {
                if (hashCode != 3433178) {
                    if (hashCode != 503245625) {
                        if (hashCode == 756171503 && e.equals("order_list")) {
                            obj = null;
                        }
                    } else if (e.equals("card_layout")) {
                        obj = 1;
                    }
                } else if (e.equals("pair")) {
                    obj = 2;
                }
            } else if (e.equals("custom")) {
                obj = 3;
            }
            switch (obj) {
                case null:
                    kVar = new k();
                    break;
                case 1:
                    kVar = new com.qiyukf.unicorn.f.a.a.a.e();
                    break;
                case 2:
                    kVar = new d();
                    break;
                case 3:
                    this.b = new com.qiyukf.unicorn.a.a.a.a.a.b();
                    return;
                default:
                    return;
            }
            this.b = kVar;
            this.b.fromJson(jSONObject);
        }
    }
}
