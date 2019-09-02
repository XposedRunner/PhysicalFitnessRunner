package defpackage;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.socialize.utils.O0000O0o;
import com.umeng.socialize.utils.O0000o00.O0000Oo;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: URequest */
/* renamed from: dd */
public abstract class dd {
    protected static String O0000Ooo = "POST";
    protected static String O0000o0 = "multipart/form-data";
    protected static String O0000o00 = "GET";
    protected static String O0000o0O = "application/x-www-form-urlencoded";
    protected O00000Oo O00000oO;
    public Map<String, String> O00000oo;
    public Map<String, String> O0000O0o = new HashMap();
    public Class<? extends ct> O0000OOo;
    public O00000o O0000Oo;
    public Context O0000Oo0;
    public O00000o0 O0000OoO = O00000o0.MULTIPART;
    protected String O0000o0o;

    /* compiled from: URequest */
    /* renamed from: dd$O000000o */
    public static class O000000o {
        String O000000o;
        byte[] O00000Oo;

        public O000000o(String str, byte[] bArr) {
            this.O000000o = str;
            this.O00000Oo = bArr;
        }
    }

    /* compiled from: URequest */
    /* renamed from: dd$O00000Oo */
    protected enum O00000Oo {
        DEFAULT("application/x-www-form-urlencoded;charset=utf-8"),
        JSON("application/json;charset=utf-8");
        
        private String O00000o0;

        private O00000Oo(String str) {
            this.O00000o0 = str;
        }

        public String toString() {
            return this.O00000o0;
        }
    }

    /* compiled from: URequest */
    /* renamed from: dd$O00000o */
    public enum O00000o {
        GET {
            public String toString() {
                return dd.O0000o00;
            }
        },
        POST {
            public String toString() {
                return dd.O0000Ooo;
            }
        }
    }

    /* compiled from: URequest */
    /* renamed from: dd$O00000o0 */
    public enum O00000o0 {
        MULTIPART {
            public String toString() {
                return dd.O0000o0;
            }
        },
        APPLICATION {
            public String toString() {
                return dd.O0000o0O;
            }
        }
    }

    public dd(String str) {
        this.O0000o0o = str;
    }

    public static String O000000o(Map<String, Object> map) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : map.keySet()) {
            if (map.get(str) != null) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(str);
                stringBuilder2.append("=");
                stringBuilder2.append(URLEncoder.encode(map.get(str).toString()));
                stringBuilder2.append("&");
                stringBuilder.append(stringBuilder2.toString());
            }
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1).toString();
    }

    public String O000000o(String str, Map<String, Object> map) {
        return O00000Oo(str, map);
    }

    public void O000000o() {
    }

    public void O000000o(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            this.O0000O0o.put(str, str2);
        }
    }

    public String O00000Oo(String str, Map<String, Object> map) {
        if (TextUtils.isEmpty(str) || map == null || map.size() == 0) {
            return str;
        }
        StringBuilder stringBuilder;
        if (!str.endsWith("?")) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("?");
            str = stringBuilder.toString();
        }
        String O000000o = dd.O000000o(map);
        O0000O0o.O00000o0(O0000Oo.O000000o(str, O000000o));
        try {
            O000000o = O0000O0o(O000000o);
        } catch (Exception e) {
            O0000O0o.O000000o(O0000Oo.O000000o, e);
        }
        stringBuilder = new StringBuilder(str);
        stringBuilder.append(O000000o);
        return stringBuilder.toString();
    }

    public abstract Map<String, Object> O00000o();

    public abstract String O00000o0();

    public Map<String, Object> O00000oO() {
        return null;
    }

    public Map<String, O000000o> O00000oo() {
        return null;
    }

    public void O00000oo(String str) {
        this.O0000o0o = str;
    }

    /* Access modifiers changed, original: protected */
    public String O0000O0o() {
        return this.O0000Oo.toString();
    }

    public String O0000O0o(String str) {
        return str;
    }

    public String O0000OOo() {
        return this.O0000o0o;
    }

    public String O0000OOo(String str) {
        return str;
    }

    public abstract JSONObject e_();
}
