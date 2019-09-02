package com.qiyukf.nimlib.d.b.b;

import android.text.TextUtils;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a implements com.qiyukf.nimlib.d.b.a {
    String a;
    String b;
    int c;
    int d;
    int e;
    String f;

    a(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public static JSONArray a(List<a> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (a aVar : list) {
            if (aVar.b()) {
                jSONArray.put(aVar.a());
            }
        }
        return jSONArray.length() > 0 ? jSONArray : null;
    }

    private boolean b() {
        return (TextUtils.isEmpty(this.a) || this.a.equals("00:00:00:00:00:00")) ? false : true;
    }

    public final JSONObject a() {
        if (!b()) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("bssid", this.a);
            jSONObject.put("ssid", this.b);
            jSONObject.put("strength_type", 2);
            jSONObject.put("strength", this.c);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("NIMWifiInfo{bssid='");
        stringBuilder.append(this.a);
        stringBuilder.append('\'');
        stringBuilder.append(",ssid='");
        stringBuilder.append(this.b);
        stringBuilder.append('\'');
        stringBuilder.append(",rssi=");
        stringBuilder.append(this.c);
        stringBuilder.append(",frequency=");
        stringBuilder.append(this.d);
        stringBuilder.append(",speed=");
        stringBuilder.append(this.e);
        stringBuilder.append(",ip='");
        stringBuilder.append(this.f);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
