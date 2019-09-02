package com.qiyukf.unicorn.f.a.d;

import android.content.Context;
import android.text.TextUtils;
import com.qiyukf.unicorn.e.h;
import com.qiyukf.unicorn.f.a.b.a;
import com.qiyukf.unicorn.f.a.b.b;
import com.qiyukf.unicorn.f.a.c;
import com.qiyukf.unicorn.f.a.e;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@b(a = 90)
public class o extends e implements c {
    @a(a = "message")
    private String a;
    @a(a = "iconurl")
    private String b;
    @a(a = "entries")
    private String c;
    @a(a = "shop")
    private String d;
    private List<com.qiyukf.unicorn.e.b> e;
    private boolean f;
    private h g;
    @a(a = "isShown")
    private boolean h;

    public final String a() {
        return this.a;
    }

    public final String a(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(this.a)) {
            stringBuilder.append(this.a);
        }
        if (this.e != null) {
            for (com.qiyukf.unicorn.e.b bVar : this.e) {
                stringBuilder.append("\r\n");
                stringBuilder.append(bVar.c);
            }
        }
        return com.qiyukf.nim.uikit.session.emoji.e.b(context, stringBuilder.toString(), null).toString();
    }

    /* Access modifiers changed, original: protected */
    public void afterParse(JSONObject jSONObject) {
        JSONArray b = com.qiyukf.basesdk.c.b.b(this.c);
        if (b != null) {
            this.e = new ArrayList(b.length());
            for (int i = 0; i < b.length(); i++) {
                com.qiyukf.unicorn.e.b bVar = new com.qiyukf.unicorn.e.b();
                JSONObject b2 = com.qiyukf.basesdk.c.b.b(b, i);
                bVar.a = com.qiyukf.basesdk.c.b.b(b2, "type");
                bVar.b = com.qiyukf.basesdk.c.b.c(b2, "id");
                bVar.c = com.qiyukf.basesdk.c.b.e(b2, "label");
                bVar.d = com.qiyukf.basesdk.c.b.c(b2, "entryid");
                this.e.add(bVar);
            }
        }
        if (!TextUtils.isEmpty(this.d)) {
            this.g = new h();
            this.g.a(this.d);
        }
        this.f = jSONObject.has("clickable") ? com.qiyukf.basesdk.c.b.a(jSONObject, "clickable") : true;
    }

    public final String b() {
        return this.b;
    }

    public final List<com.qiyukf.unicorn.e.b> c() {
        return this.e;
    }

    public final boolean d() {
        return this.f;
    }

    public final void e() {
        this.f = false;
    }

    public final h f() {
        return this.g;
    }

    public final boolean g() {
        return this.h;
    }

    public String getContent(Context context) {
        StringBuilder stringBuilder = new StringBuilder("[");
        stringBuilder.append(a(context).replace("\n", " "));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public final void h() {
        this.h = true;
    }

    /* Access modifiers changed, original: protected */
    public JSONObject toJsonObject(boolean z) {
        JSONObject toJsonObject = super.toJsonObject(z);
        if (!z) {
            com.qiyukf.basesdk.c.b.a(toJsonObject, "clickable", Boolean.valueOf(this.f));
            com.qiyukf.basesdk.c.b.a(toJsonObject, "isShown", Boolean.valueOf(this.h));
        }
        return toJsonObject;
    }
}
