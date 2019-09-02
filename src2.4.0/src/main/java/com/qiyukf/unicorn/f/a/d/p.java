package com.qiyukf.unicorn.f.a.d;

import android.content.Context;
import android.text.TextUtils;
import com.qiyukf.unicorn.f.a.b.a;
import com.qiyukf.unicorn.f.a.b.b;
import com.qiyukf.unicorn.f.a.e;
import com.umeng.commonsdk.framework.c;
import org.json.JSONArray;

@b(a = 43)
public class p extends e {
    @a(a = "content")
    private String a;
    @a(a = "type")
    private int b;
    @a(a = "trashWords")
    private transient JSONArray c;
    @a(a = "auditResult")
    private int d;

    public final void a() {
        this.b = 1;
    }

    public final void a(int i) {
        this.d = i;
    }

    public final void a(String str) {
        this.a = str;
    }

    public final void a(JSONArray jSONArray) {
        this.c = jSONArray;
    }

    public String getContent(Context context) {
        if (this.b != 1) {
            return this.a;
        }
        String e = com.qiyukf.basesdk.c.b.e(com.qiyukf.basesdk.c.b.a(this.a), c.a);
        if (TextUtils.isEmpty(e)) {
            e = "";
        }
        return com.qiyukf.unicorn.j.c.a(e).replace("\n", " ");
    }
}
