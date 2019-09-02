package com.qiyukf.unicorn.e;

import com.qiyukf.basesdk.c.b;
import java.io.Serializable;
import org.json.JSONObject;

public final class a implements Serializable {
    private String a;
    private String b;
    private String c;

    public final String a() {
        return this.b;
    }

    public final void a(String str) {
        JSONObject a = b.a(str);
        if (a.has("setting")) {
            a = b.f(a, "setting");
            if (a != null) {
                this.a = b.e(a, "inputSwitch");
                this.b = b.e(a, "staffReadSwitch");
                this.c = b.e(a, "sendingRate");
            }
        }
    }
}
