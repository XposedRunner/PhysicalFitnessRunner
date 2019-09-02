package defpackage;

import defpackage.dd.O00000o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: UserinfoRequest */
/* renamed from: cm */
public class cm extends dd {
    private static final String O000000o = "https://api.weibo.com/2/users/show.json";

    public cm(String str, String str2, String str3) {
        super(O000000o);
        this.O0000Oo = O00000o.GET;
        this.O0000OOo = cn.class;
        O000000o("uid", str);
        O000000o("appkey", str3);
        O000000o("access_token", str2);
    }

    public Map<String, Object> O00000o() {
        HashMap hashMap = new HashMap();
        hashMap.putAll(this.O0000O0o);
        return hashMap;
    }

    public String O00000o0() {
        return O000000o(O0000OOo(), O00000o());
    }

    public JSONObject e_() {
        return null;
    }
}
