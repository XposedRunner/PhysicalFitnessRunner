package com.qiyukf.unicorn.a.a.a.a.b;

import com.qiyukf.unicorn.api.msg.ProductReslectOnclickListener;
import com.qiyukf.unicorn.f.a.b.a;
import com.qiyukf.unicorn.f.a.b.c;
import org.json.JSONObject;

@c(a = "qiyu_template_goods")
public class b extends a {
    @a(a = "p_status")
    private String a;
    @a(a = "p_img")
    private String b;
    @a(a = "p_name")
    private String c;
    @a(a = "p_price")
    private String d;
    @a(a = "p_count")
    private String e;
    @a(a = "p_stock")
    private String f;
    private boolean g;
    private String h;
    private String i;
    private ProductReslectOnclickListener j;
    private transient JSONObject k;

    /* Access modifiers changed, original: protected */
    public void afterParse(JSONObject jSONObject) {
        this.k = jSONObject;
    }

    public final JSONObject c() {
        JSONObject jSONObject = this.k == null ? new JSONObject() : this.k;
        com.qiyukf.basesdk.c.b.a(jSONObject, "id", b());
        return jSONObject;
    }

    public final String d() {
        return this.a;
    }

    public final String e() {
        return this.b;
    }

    public final String f() {
        return this.c;
    }

    public final String g() {
        return this.d;
    }

    public final String h() {
        return this.e;
    }

    public final String i() {
        return this.f;
    }

    public final boolean j() {
        return this.g;
    }

    public final String k() {
        return this.h;
    }

    public final String l() {
        return this.i;
    }

    public final ProductReslectOnclickListener m() {
        return this.j;
    }
}
