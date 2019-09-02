package defpackage;

import defpackage.dd.O00000o;
import defpackage.dd.O00000o0;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: DeleteRequest */
/* renamed from: ch */
public class ch extends dd {
    public ch(String str, String str2) {
        super("https://api.weibo.com/oauth2/revokeoauth2");
        this.O0000Oo = O00000o.POST;
        this.O0000OOo = ci.class;
        this.O0000OoO = O00000o0.APPLICATION;
        O000000o("access_token", str2);
    }

    public Map<String, Object> O00000o() {
        return null;
    }

    public String O00000o0() {
        return null;
    }

    public Map<String, Object> O00000oO() {
        HashMap hashMap = new HashMap();
        hashMap.putAll(this.O0000O0o);
        return hashMap;
    }

    public JSONObject e_() {
        return null;
    }
}
