package com.qiyukf.unicorn.f.a.a.a;

import android.text.TextUtils;
import com.qiyukf.basesdk.c.b;
import com.qiyukf.unicorn.f.a.b.c;
import com.tencent.open.SocialConstants;
import java.util.List;
import org.json.JSONObject;

@c(a = "static_union")
public class i extends com.qiyukf.unicorn.a.a.a.a.a.a {
    @com.qiyukf.unicorn.f.a.b.a(a = "unions")
    private List<a> a;

    public static class a implements com.qiyukf.unicorn.f.a.a {
        @com.qiyukf.unicorn.f.a.b.a(a = "type")
        private String a;
        @com.qiyukf.unicorn.f.a.b.a(a = "detail")
        private transient JSONObject b;

        public final boolean a() {
            return TextUtils.equals(this.a, "image");
        }

        public final boolean b() {
            return TextUtils.equals(this.a, "link") && TextUtils.equals(b.e(this.b, "type"), SocialConstants.PARAM_URL);
        }

        public final boolean c() {
            return TextUtils.equals(this.a, "link") && TextUtils.equals(b.e(this.b, "type"), "block");
        }

        public final boolean d() {
            return TextUtils.equals(this.a, "richText");
        }

        public final String e() {
            return b.e(this.b, "label");
        }

        public final String f() {
            return b.e(this.b, SocialConstants.PARAM_URL);
        }

        public final String g() {
            return b.e(this.b, "target");
        }

        public final String h() {
            return b.e(this.b, "params");
        }
    }

    public final List<a> c() {
        return this.a;
    }
}
