package com.qiyukf.unicorn.f.a.a.a;

import com.qiyukf.unicorn.f.a.b.c;
import java.util.List;
import org.json.JSONObject;

@c(a = "order_list")
public class k extends com.qiyukf.unicorn.a.a.a.a.a.a {
    @com.qiyukf.unicorn.f.a.b.a(a = "label")
    private String a;
    @com.qiyukf.unicorn.f.a.b.a(a = "list")
    private List<b> b;
    @com.qiyukf.unicorn.f.a.b.a(a = "action")
    private a c;

    public static class a implements com.qiyukf.unicorn.f.a.a {
        @com.qiyukf.unicorn.f.a.b.a(a = "label")
        private String a;
        @com.qiyukf.unicorn.f.a.b.a(a = "target")
        private String b;
        @com.qiyukf.unicorn.f.a.b.a(a = "params")
        private String c;

        public final String a() {
            return this.a;
        }

        public final String b() {
            return this.b;
        }

        public final String c() {
            return this.c;
        }
    }

    public static class b implements com.qiyukf.unicorn.f.a.a {
        @com.qiyukf.unicorn.f.a.b.a(a = "s_name")
        private String a;
        @com.qiyukf.unicorn.f.a.b.a(a = "s_status")
        private String b;
        @com.qiyukf.unicorn.f.a.b.a(a = "goods")
        private List<a> c;

        public static class a implements com.qiyukf.unicorn.f.a.a {
            @com.qiyukf.unicorn.f.a.b.a(a = "target")
            private String a;
            @com.qiyukf.unicorn.f.a.b.a(a = "params")
            private String b;
            @com.qiyukf.unicorn.f.a.b.a(a = "p_status")
            private String c;
            @com.qiyukf.unicorn.f.a.b.a(a = "p_img")
            private String d;
            @com.qiyukf.unicorn.f.a.b.a(a = "p_name")
            private String e;
            @com.qiyukf.unicorn.f.a.b.a(a = "p_price")
            private String f;
            @com.qiyukf.unicorn.f.a.b.a(a = "p_count")
            private String g;
            @com.qiyukf.unicorn.f.a.b.a(a = "p_stock")
            private String h;
            private transient JSONObject i;

            public final JSONObject a() {
                if (this.i == null) {
                    this.i = new JSONObject();
                    com.qiyukf.basesdk.c.b.a(this.i, "target", this.a);
                    com.qiyukf.basesdk.c.b.a(this.i, "params", this.b);
                    com.qiyukf.basesdk.c.b.a(this.i, "p_status", this.c);
                    com.qiyukf.basesdk.c.b.a(this.i, "p_img", this.d);
                    com.qiyukf.basesdk.c.b.a(this.i, "p_name", this.e);
                    com.qiyukf.basesdk.c.b.a(this.i, "p_price", this.f);
                    com.qiyukf.basesdk.c.b.a(this.i, "p_count", this.g);
                    com.qiyukf.basesdk.c.b.a(this.i, "p_stock", this.h);
                }
                return this.i;
            }

            public final String b() {
                return this.a;
            }

            public final String c() {
                return this.b;
            }

            public final String d() {
                return this.c;
            }

            public final String e() {
                return this.d;
            }

            public final String f() {
                return this.e;
            }

            public final String g() {
                return this.f;
            }

            public final String h() {
                return this.g;
            }

            public final String i() {
                return this.h;
            }
        }

        public final String a() {
            return this.a;
        }

        public final String b() {
            return this.b;
        }

        public final List<a> c() {
            return this.c;
        }
    }

    public final String c() {
        return this.a;
    }

    public final List<b> d() {
        return this.b;
    }

    public final a e() {
        return this.c;
    }
}
