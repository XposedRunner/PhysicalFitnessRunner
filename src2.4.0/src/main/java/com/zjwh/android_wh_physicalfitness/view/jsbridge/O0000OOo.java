package com.zjwh.android_wh_physicalfitness.view.jsbridge;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Message */
public class O0000OOo {
    private static final String O00000oo = "callbackId";
    private static final String O0000O0o = "responseId";
    private static final String O0000OOo = "responseData";
    private static final String O0000Oo = "handlerName";
    private static final String O0000Oo0 = "data";
    private String O000000o;
    private String O00000Oo;
    private String O00000o;
    private String O00000o0;
    private String O00000oO;

    public static O0000OOo O00000oo(String str) {
        O0000OOo o0000OOo = new O0000OOo();
        try {
            JSONObject jSONObject = new JSONObject(str);
            String str2 = null;
            o0000OOo.O00000oO(jSONObject.has(O0000Oo) ? jSONObject.getString(O0000Oo) : null);
            o0000OOo.O00000o0(jSONObject.has(O00000oo) ? jSONObject.getString(O00000oo) : null);
            o0000OOo.O00000Oo(jSONObject.has(O0000OOo) ? jSONObject.getString(O0000OOo) : null);
            o0000OOo.O000000o(jSONObject.has(O0000O0o) ? jSONObject.getString(O0000O0o) : null);
            if (jSONObject.has("data")) {
                str2 = jSONObject.getString("data");
            }
            o0000OOo.O00000o(str2);
            return o0000OOo;
        } catch (JSONException e) {
            e.printStackTrace();
            return o0000OOo;
        }
    }

    public static List<O0000OOo> O0000O0o(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                O0000OOo o0000OOo = new O0000OOo();
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String str2 = null;
                o0000OOo.O00000oO(jSONObject.has(O0000Oo) ? jSONObject.getString(O0000Oo) : null);
                o0000OOo.O00000o0(jSONObject.has(O00000oo) ? jSONObject.getString(O00000oo) : null);
                o0000OOo.O00000Oo(jSONObject.has(O0000OOo) ? jSONObject.getString(O0000OOo) : null);
                o0000OOo.O000000o(jSONObject.has(O0000O0o) ? jSONObject.getString(O0000O0o) : null);
                if (jSONObject.has("data")) {
                    str2 = jSONObject.getString("data");
                }
                o0000OOo.O00000o(str2);
                arrayList.add(o0000OOo);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public String O000000o() {
        return this.O00000Oo;
    }

    public void O000000o(String str) {
        this.O00000Oo = str;
    }

    public String O00000Oo() {
        return this.O00000o0;
    }

    public void O00000Oo(String str) {
        this.O00000o0 = str;
    }

    public String O00000o() {
        return this.O00000o;
    }

    public void O00000o(String str) {
        this.O00000o = str;
    }

    public String O00000o0() {
        return this.O000000o;
    }

    public void O00000o0(String str) {
        this.O000000o = str;
    }

    public String O00000oO() {
        return this.O00000oO;
    }

    public void O00000oO(String str) {
        this.O00000oO = str;
    }

    public String O00000oo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(O00000oo, O00000o0());
            jSONObject.put("data", O00000o());
            jSONObject.put(O0000Oo, O00000oO());
            jSONObject.put(O0000OOo, O00000Oo());
            jSONObject.put(O0000O0o, O000000o());
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
