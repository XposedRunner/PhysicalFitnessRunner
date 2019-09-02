package cn.jiguang.d.h;

import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    int a = -1;
    int b = -1;
    int c = -1;
    int d = -1;
    int e = -1;

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("level", this.a);
            jSONObject.put("scale", this.b);
            jSONObject.put("status", this.c);
            jSONObject.put("voltage", this.d);
            jSONObject.put("temperature", this.e);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("BatteryInfo{level=");
        stringBuilder.append(this.a);
        stringBuilder.append(", scale=");
        stringBuilder.append(this.b);
        stringBuilder.append(", status=");
        stringBuilder.append(this.c);
        stringBuilder.append(", voltage=");
        stringBuilder.append(this.d);
        stringBuilder.append(", temperature=");
        stringBuilder.append(this.e);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
