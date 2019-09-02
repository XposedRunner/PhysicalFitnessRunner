package com.qiyukf.nimlib.d.b.a;

import com.qiyukf.nimlib.d.b.a;
import org.json.JSONException;
import org.json.JSONObject;

public final class f implements a {
    private int a;
    private int b;
    private String c;
    private String d;
    private String e;

    f(int i, int i2, String str, String str2, String str3) {
        this.a = i;
        this.b = i2;
        this.c = str;
        this.d = str2;
        this.e = str3;
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mnc", this.b);
            jSONObject.put("mcc", this.a);
            jSONObject.put("raido_tech", this.c);
            jSONObject.put("carrier_name", this.d);
            jSONObject.put("iso_cc", this.e);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("OperatorInfo{mcc=");
        stringBuilder.append(this.a);
        stringBuilder.append(", mnc=");
        stringBuilder.append(this.b);
        stringBuilder.append(", networkType='");
        stringBuilder.append(this.c);
        stringBuilder.append('\'');
        stringBuilder.append(", networkOperatorName='");
        stringBuilder.append(this.d);
        stringBuilder.append('\'');
        stringBuilder.append(", networkCountryIso='");
        stringBuilder.append(this.e);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
