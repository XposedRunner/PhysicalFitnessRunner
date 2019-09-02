package defpackage;

import com.umeng.socialize.utils.O0000O0o;
import com.umeng.socialize.utils.O0000o00.O0000Oo;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ActionBarResponse */
/* renamed from: cg */
public class cg extends ct {
    public int O000000o;
    public int O00000Oo;
    public String O00000o;
    public int O00000o0;
    public String O00000oO;
    public int O00000oo;
    public int O0000O0o;
    public String O0000OOo;
    public int O0000Oo;
    public String O0000Oo0;

    public cg(Integer num, JSONObject jSONObject) {
        super(jSONObject);
    }

    public void O000000o() {
        JSONObject jSONObject = this.O0000Ooo;
        if (jSONObject == null) {
            O0000O0o.O00000Oo(O0000Oo.O0000O0o);
            return;
        }
        try {
            if (jSONObject.has(db.O000O0Oo)) {
                this.O00000Oo = jSONObject.getInt(db.O000O0Oo);
            }
            if (jSONObject.has(db.O0000o0o)) {
                this.O00000oO = jSONObject.getString(db.O0000o0o);
            }
            if (jSONObject.has(db.O00oOoOo)) {
                this.O00000oo = jSONObject.getInt(db.O00oOoOo);
            }
            if (jSONObject.has(db.O000O0o0)) {
                this.O0000O0o = jSONObject.optInt(db.O000O0o0, 0);
            }
            if (jSONObject.has(db.O000O0o)) {
                this.O00000o0 = jSONObject.getInt(db.O000O0o);
            }
            if (jSONObject.has(db.O000O0oO)) {
                this.O000000o = jSONObject.getInt(db.O000O0oO);
            }
            if (jSONObject.has(db.O0000o)) {
                this.O00000o = jSONObject.getString(db.O0000o);
            }
            if (jSONObject.has("uid")) {
                this.O0000OOo = jSONObject.getString("uid");
            }
            if (jSONObject.has("sn")) {
                this.O0000Oo = jSONObject.getInt("sn");
            }
        } catch (JSONException e) {
            O0000O0o.O000000o(O0000Oo.O000000o, e);
        }
    }
}
