package defpackage;

import com.umeng.socialize.utils.O0000O0o;
import com.umeng.socialize.utils.O0000o00.O0000Oo;
import org.json.JSONObject;

/* compiled from: LinkCardResponse */
/* renamed from: cj */
public class cj extends ct {
    public String O000000o;

    public cj(Integer num, JSONObject jSONObject) {
        super(num, jSONObject);
    }

    public cj(JSONObject jSONObject) {
        super(jSONObject);
    }

    public void O000000o() {
        JSONObject jSONObject = this.O0000Ooo;
        if (jSONObject == null) {
            O0000O0o.O000000o(O0000Oo.O0000O0o);
        } else {
            this.O000000o = jSONObject.optString("linkcard_url");
        }
    }
}
