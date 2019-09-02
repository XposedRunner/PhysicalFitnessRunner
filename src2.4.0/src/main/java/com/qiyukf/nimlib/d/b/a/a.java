package com.qiyukf.nimlib.d.b.a;

import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a implements com.qiyukf.nimlib.d.b.a {
    private String a;
    private String b;
    private String c;

    a(String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public static JSONArray a(List<a> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (a a : list) {
            jSONArray.put(a.a());
        }
        return jSONArray;
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_id", this.a);
            jSONObject.put("app_name", this.b);
            jSONObject.put("app_version", this.c);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("AppInfo{appId='");
        stringBuilder.append(this.a);
        stringBuilder.append('\'');
        stringBuilder.append(", appName='");
        stringBuilder.append(this.b);
        stringBuilder.append('\'');
        stringBuilder.append(", appVersion='");
        stringBuilder.append(this.c);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
