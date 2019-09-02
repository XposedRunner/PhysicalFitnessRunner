package com.qiyukf.nimlib.d.b.a;

import com.qiyukf.nimlib.d.b.a;
import org.json.JSONException;
import org.json.JSONObject;

public final class d implements a {
    private String a;
    private String b;
    private String c;
    private String d;
    private long e;
    private long f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;

    d(String str, String str2, String str3, long j, long j2, String str4, int i, String str5, String str6, String str7) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.e = j;
        this.f = j2;
        this.g = str4;
        this.i = str5;
        this.h = String.valueOf(i);
        this.j = str6;
        this.k = str7;
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("brand", this.a);
            jSONObject.put("model", this.b);
            jSONObject.put("imei", this.c);
            jSONObject.put("disk_size", this.e);
            jSONObject.put("memory_size", this.f);
            jSONObject.put("system_name", this.g);
            jSONObject.put("system_version", this.h);
            jSONObject.put("rom", this.i);
            jSONObject.put("language", this.j);
            jSONObject.put("timezone", this.k);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("DeviceInfo{brand='");
        stringBuilder.append(this.a);
        stringBuilder.append('\'');
        stringBuilder.append(", model='");
        stringBuilder.append(this.b);
        stringBuilder.append('\'');
        stringBuilder.append(", imei='");
        stringBuilder.append(this.c);
        stringBuilder.append('\'');
        stringBuilder.append(", mac='");
        stringBuilder.append(this.d);
        stringBuilder.append('\'');
        stringBuilder.append(", diskSize=");
        stringBuilder.append(this.e);
        stringBuilder.append(", memorySize=");
        stringBuilder.append(this.f);
        stringBuilder.append(", systemName='");
        stringBuilder.append(this.g);
        stringBuilder.append('\'');
        stringBuilder.append(", systemVersion='");
        stringBuilder.append(this.h);
        stringBuilder.append('\'');
        stringBuilder.append(", rom='");
        stringBuilder.append(this.i);
        stringBuilder.append('\'');
        stringBuilder.append(", language='");
        stringBuilder.append(this.j);
        stringBuilder.append('\'');
        stringBuilder.append(", timeZone='");
        stringBuilder.append(this.k);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
