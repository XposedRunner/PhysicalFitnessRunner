package defpackage;

import android.text.TextUtils;
import com.umeng.socialize.utils.O0000O0o;
import com.umeng.socialize.utils.O0000o00.O0000Oo;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SocializeReseponse */
/* renamed from: ct */
public class ct extends de {
    protected static final String O0000OoO = "SocializeReseponse";
    private int O000000o;
    protected JSONObject O0000Ooo;
    public int O0000o0;
    public String O0000o00;

    public ct(Integer num, JSONObject jSONObject) {
        this(jSONObject);
        this.O000000o = num == null ? -1 : num.intValue();
    }

    public ct(JSONObject jSONObject) {
        super(jSONObject);
        this.O0000o0 = bz.O00000Oo;
        this.O0000Ooo = O000000o(jSONObject);
        O000000o();
    }

    private void O000000o(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                JSONObject jSONObject2 = jSONObject.getJSONObject((String) keys.next());
                if (TextUtils.isEmpty(jSONObject2.getString(db.O000OO00))) {
                    jSONObject2.getJSONObject("data").getString(db.O000Oo0);
                }
            }
        } catch (Exception e) {
            O0000O0o.O000000o(e);
        }
    }

    public JSONObject O000000o(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            this.O0000o0 = jSONObject.optInt("st", ce.O0000o0O);
            if (this.O0000o0 == 0) {
                return null;
            }
            this.O0000o00 = jSONObject.optString(db.O000OO00, "");
            String optString = jSONObject.optString("data", null);
            if (TextUtils.isEmpty(optString)) {
                return null;
            }
            if (this.O0000o0 != 200) {
                O000000o(optString);
            }
            return new JSONObject(optString);
        } catch (JSONException e) {
            O0000O0o.O000000o(O0000Oo.O000000o, e);
            return null;
        }
    }

    public void O000000o() {
    }

    public boolean O00000Oo() {
        return this.O000000o == 200;
    }

    public JSONObject O00000o() {
        return this.O0000Ooo;
    }

    public boolean O00000o0() {
        return this.O0000o0 == 200;
    }
}
