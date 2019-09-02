package com.amap.api.mapcore.util;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: RollbackInfo */
public final class al {
    private List<O000000o> O000000o = new ArrayList();

    /* compiled from: RollbackInfo */
    public static class O000000o {
        private String O000000o;
        private String O00000Oo;

        public O000000o(String str, String str2) {
            this.O000000o = str;
            this.O00000Oo = str2;
        }

        public final String O000000o() {
            return this.O000000o;
        }

        public final String O00000Oo() {
            return this.O00000Oo;
        }
    }

    public static al O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return new al();
        }
        al alVar = new al();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                alVar.O000000o.add(new O000000o(jSONObject.optString("sk", ""), jSONObject.optString("dk", "")));
            }
            return alVar;
        } catch (Throwable unused) {
            return alVar;
        }
    }

    public final List<O000000o> O000000o() {
        return this.O000000o;
    }

    public final void O000000o(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.O000000o.add(new O000000o(str, str2));
        }
    }

    public final String O00000Oo() {
        if (this.O000000o == null || this.O000000o.size() == 0) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < this.O000000o.size(); i++) {
            O000000o o000000o = (O000000o) this.O000000o.get(i);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("sk", o000000o.O000000o());
                jSONObject.put("dk", o000000o.O00000Oo());
                jSONArray.put(jSONObject);
            } catch (JSONException unused) {
            }
        }
        return jSONArray.toString();
    }
}
