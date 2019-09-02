package com.qiyukf.unicorn.f.a.a.a;

import android.text.TextUtils;
import com.qiyukf.unicorn.f.a.b.c;
import java.util.List;
import org.json.JSONObject;

@c(a = "bot_form")
public class f extends com.qiyukf.unicorn.a.a.a.a.a.a {
    @com.qiyukf.unicorn.f.a.b.a(a = "label")
    private String a;
    @com.qiyukf.unicorn.f.a.b.a(a = "params")
    private String b;
    @com.qiyukf.unicorn.f.a.b.a(a = "forms")
    private List<a> c;
    @com.qiyukf.unicorn.f.a.b.a(a = "hasCommit")
    private boolean d;

    public static class a implements com.qiyukf.unicorn.f.a.a {
        @com.qiyukf.unicorn.f.a.b.a(a = "id")
        private String a;
        @com.qiyukf.unicorn.f.a.b.a(a = "type")
        private String b;
        @com.qiyukf.unicorn.f.a.b.a(a = "label")
        private String c;
        @com.qiyukf.unicorn.f.a.b.a(a = "required")
        private int d;
        @com.qiyukf.unicorn.f.a.b.a(a = "value")
        private Object e;

        public final String a() {
            return this.a;
        }

        public final void a(Object obj) {
            this.e = obj;
        }

        public final String b() {
            return this.b;
        }

        public final String c() {
            return this.c;
        }

        public final boolean d() {
            return this.d == 1;
        }

        public final boolean e() {
            return TextUtils.equals(this.b, "image");
        }

        public final Object f() {
            return this.e;
        }

        public final String g() {
            return (e() || !(this.e instanceof String)) ? null : (String) this.e;
        }

        public final JSONObject h() {
            return (e() && (this.e instanceof JSONObject)) ? (JSONObject) this.e : null;
        }

        public final boolean i() {
            return (d() && TextUtils.isEmpty(g()) && h() == null) ? false : true;
        }
    }

    public final String c() {
        return this.a;
    }

    public final String d() {
        return this.b;
    }

    public final List<a> e() {
        return this.c;
    }

    public final boolean f() {
        return this.d;
    }

    public final void g() {
        this.d = true;
    }
}
