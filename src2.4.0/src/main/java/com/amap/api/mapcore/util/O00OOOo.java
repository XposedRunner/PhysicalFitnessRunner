package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.mapcore.util.o0O0O0o0.O000000o;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: OfflineUpdateCityHandlerAbstract */
public class O00OOOo extends ooooooo<String, List<OfflineMapProvince>> {
    private Context O00000o;

    public O00OOOo(Context context, String str) {
        super(context, str);
    }

    /* Access modifiers changed, original: protected */
    public String O000000o() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("015");
        return stringBuilder.toString();
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: O000000o */
    public List<OfflineMapProvince> O00000Oo(JSONObject jSONObject) throws AMapException {
        try {
            if (this.O00000o != null) {
                O00o.O00000o0(jSONObject.toString(), this.O00000o);
            }
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "OfflineUpdateCityHandlerAbstract", "loadData jsonInit");
            th.printStackTrace();
        }
        try {
            return this.O00000o != null ? O00o.O000000o(jSONObject, this.O00000o) : null;
        } catch (JSONException e) {
            ooOOOOoo.O00000o0(e, "OfflineUpdateCityHandlerAbstract", "loadData parseJson");
            e.printStackTrace();
            return null;
        }
    }

    /* Access modifiers changed, original: protected */
    public JSONObject O000000o(O000000o o000000o) {
        if (o000000o == null || o000000o.O0000oo == null) {
            return null;
        }
        JSONObject optJSONObject = o000000o.O0000oo.optJSONObject("015");
        if (!optJSONObject.has("result")) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("result", new JSONObject().put("offlinemap_with_province_vfour", optJSONObject));
                return jSONObject;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return optJSONObject;
    }

    public void O000000o(Context context) {
        this.O00000o = context;
    }

    /* Access modifiers changed, original: protected */
    public Map<String, String> O00000Oo() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("mapver", this.O000000o);
        return hashtable;
    }
}
