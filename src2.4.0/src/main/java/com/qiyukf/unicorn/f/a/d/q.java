package com.qiyukf.unicorn.f.a.d;

import android.text.TextUtils;
import com.qiyukf.unicorn.f.a.b.a;
import com.qiyukf.unicorn.f.a.b.b;
import com.qiyukf.unicorn.f.a.e;
import org.json.JSONArray;
import org.json.JSONObject;

@b(a = 42)
public class q extends e {
    @a(a = "sessionId")
    private long a;
    @a(a = "msgIdClient")
    private String b;
    @a(a = "trashWords")
    private transient JSONArray c;
    @a(a = "auditResult")
    private int d;
    private String e;

    public final boolean a() {
        return this.a > 0 && !TextUtils.isEmpty(this.e);
    }

    /* Access modifiers changed, original: protected */
    public void afterParse(JSONObject jSONObject) {
        try {
            this.e = this.b.substring(this.b.indexOf(35) + 1);
        } catch (Exception unused) {
        }
    }

    public final String b() {
        return this.e;
    }

    public final JSONArray c() {
        return this.c;
    }

    public final int d() {
        return this.d;
    }
}
