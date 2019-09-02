package com.qiyukf.unicorn.f.a.d;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.wireless.security.SecExceptionCode;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.e.h;
import com.qiyukf.unicorn.f.a.b.b;
import com.qiyukf.unicorn.f.a.e;
import org.json.JSONObject;

@b(a = 2)
public class a extends e {
    @com.qiyukf.unicorn.f.a.b.a(a = "code")
    private int a;
    @com.qiyukf.unicorn.f.a.b.a(a = "exchange")
    private String b;
    @com.qiyukf.unicorn.f.a.b.a(a = "staffid")
    private String c;
    @com.qiyukf.unicorn.f.a.b.a(a = "staffname")
    private String d;
    @com.qiyukf.unicorn.f.a.b.a(a = "groupname")
    private String e;
    @com.qiyukf.unicorn.f.a.b.a(a = "iconurl")
    private String f;
    @com.qiyukf.unicorn.f.a.b.a(a = "message")
    private String g;
    @com.qiyukf.unicorn.f.a.b.a(a = "sessionid")
    private long h;
    @com.qiyukf.unicorn.f.a.b.a(a = "before")
    private int i;
    @com.qiyukf.unicorn.f.a.b.a(a = "showNum")
    private int j;
    @com.qiyukf.unicorn.f.a.b.a(a = "inqueueNotify")
    private String k;
    @com.qiyukf.unicorn.f.a.b.a(a = "stafftype")
    private int l;
    @com.qiyukf.unicorn.f.a.b.a(a = "operator_enable")
    private int m;
    @com.qiyukf.unicorn.f.a.b.a(a = "realStaffid")
    private long n;
    @com.qiyukf.unicorn.f.a.b.a(a = "groupid")
    private long o;
    @com.qiyukf.unicorn.f.a.b.a(a = "evaluation")
    private String p;
    @com.qiyukf.unicorn.f.a.b.a(a = "shop")
    private String q;
    @com.qiyukf.unicorn.f.a.b.a(a = "robotInQueue")
    private int r;
    @com.qiyukf.unicorn.f.a.b.a(a = "robotSessionId")
    private long s;
    private com.qiyukf.unicorn.f.a.c.b t;
    private h u;
    private com.qiyukf.unicorn.e.a v;

    public final int a() {
        return this.a;
    }

    public final CharSequence a(Context context) {
        String string;
        if (TextUtils.isEmpty(this.e)) {
            string = context.getString(R.string.ysf_staff_assigned, new Object[]{this.d});
        } else {
            string = context.getString(R.string.ysf_staff_assigned_with_group, new Object[]{this.e, this.d});
        }
        if (this.l != 0 || TextUtils.isEmpty(this.g)) {
            return string;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.g);
        stringBuilder.append(" ");
        stringBuilder.append(string);
        return stringBuilder.toString();
    }

    public final void a(String str) {
        this.b = str;
    }

    /* Access modifiers changed, original: protected */
    public void afterParse(JSONObject jSONObject) {
        if (!TextUtils.isEmpty(this.p)) {
            this.t = new com.qiyukf.unicorn.f.a.c.b();
            this.t.a(com.qiyukf.basesdk.c.b.a(this.p));
        }
        if (!TextUtils.isEmpty(this.q)) {
            this.u = new h();
            this.u.a(this.q);
            this.v = new com.qiyukf.unicorn.e.a();
            this.v.a(this.q);
        }
    }

    public final String b() {
        return this.c;
    }

    public final String c() {
        return this.d;
    }

    public boolean countToUnread() {
        return true;
    }

    public final String d() {
        return this.g;
    }

    public final long e() {
        return this.h;
    }

    public final void f() {
        this.a = 408;
    }

    public final int g() {
        return this.i;
    }

    public String getContent(Context context) {
        StringBuilder stringBuilder = new StringBuilder("[");
        stringBuilder.append(a(context));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public final boolean h() {
        return this.j == 1;
    }

    public final int i() {
        return this.l;
    }

    public final int j() {
        return this.m;
    }

    public final String k() {
        return this.f;
    }

    public final long l() {
        return this.n;
    }

    public final long m() {
        return this.o;
    }

    public final com.qiyukf.unicorn.f.a.c.b n() {
        return this.t;
    }

    public final h o() {
        return this.u;
    }

    public final com.qiyukf.unicorn.e.a p() {
        return this.v;
    }

    public final String q() {
        return this.k;
    }

    public final boolean r() {
        return this.a == SecExceptionCode.SEC_ERROR_STA_STORE_NO_DATA_FILE && this.r == 1;
    }

    public final long s() {
        return this.s;
    }
}
