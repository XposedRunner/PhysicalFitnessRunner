package com.amap.api.mapcore.util;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SoFileItem */
public final class y {
    String O000000o;
    private String O00000Oo;
    private String O00000o;
    private String O00000o0;

    private y(String str, String str2, String str3, String str4) {
        this.O00000Oo = str;
        this.O00000o0 = str2;
        this.O000000o = str3;
        this.O00000o = str4;
    }

    private static String O000000o(y yVar) {
        if (yVar == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mk", yVar.O00000o0);
            jSONObject.put("ek", yVar.O000000o);
            jSONObject.put("nk", yVar.O00000o);
            jSONObject.put("sk", yVar.O00000Oo);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public static String O000000o(List<y> list) {
        if (list == null) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            try {
                jSONArray.put(i, O000000o((y) list.get(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONArray.toString();
    }

    public static List<y> O00000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(O00000oO(jSONArray.getString(i)));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static y O00000o0(String str) {
        if (TextUtils.isEmpty(str)) {
            return new y();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new y("", "", jSONObject.optString("md5", ""), jSONObject.optString("so_file_name", ""));
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("SoFile#fromJson json ex ");
            stringBuilder.append(th);
            t.O000000o(stringBuilder.toString());
            return new y();
        }
    }

    private static y O00000oO(String str) {
        if (TextUtils.isEmpty(str)) {
            return new y();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new y(jSONObject.optString("sk", ""), jSONObject.optString("mk", ""), jSONObject.optString("ek", ""), jSONObject.optString("nk", ""));
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("SoFile#fromJson json ex ");
            stringBuilder.append(th);
            t.O000000o(stringBuilder.toString());
            return new y();
        }
    }

    public final String O000000o() {
        return this.O00000o;
    }

    public final void O000000o(String str) {
        this.O00000o0 = str;
    }

    public final void O00000Oo(String str) {
        this.O00000Oo = str;
    }
}
