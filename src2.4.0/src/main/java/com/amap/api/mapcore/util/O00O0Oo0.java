package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.mapcore.util.o0O0O0o0.O000000o;
import com.amap.api.maps.AMapException;
import java.util.Hashtable;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: OfflineInitHandlerAbstract */
public class O00O0Oo0 extends ooooooo<String, O00O0OOo> {
    public O00O0Oo0(Context context, String str) {
        super(context, str);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: O000000o */
    public O00O0OOo O00000Oo(JSONObject jSONObject) throws AMapException {
        O00O0OOo o00O0OOo = new O00O0OOo();
        try {
            String optString = jSONObject.optString("update", "");
            if (optString.equals("0")) {
                o00O0OOo.O000000o(false);
            } else if (optString.equals("1")) {
                o00O0OOo.O000000o(true);
            }
            o00O0OOo.O000000o(jSONObject.optString("version", ""));
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "OfflineInitHandlerAbstract", "loadData parseJson");
        }
        return o00O0OOo;
    }

    /* Access modifiers changed, original: protected */
    public String O000000o() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("016");
        return stringBuilder.toString();
    }

    /* Access modifiers changed, original: protected */
    public JSONObject O000000o(O000000o o000000o) {
        return (o000000o == null || o000000o.O0000oo == null) ? null : o000000o.O0000oo.optJSONObject("016");
    }

    /* Access modifiers changed, original: protected */
    public Map<String, String> O00000Oo() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("mapver", this.O000000o);
        return hashtable;
    }
}
