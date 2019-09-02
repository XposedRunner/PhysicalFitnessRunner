package cn.jiguang.g.c;

import android.text.TextUtils;
import org.json.JSONObject;

public final class a {
    public String a;
    public String b;
    public String c;

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("imei", TextUtils.isEmpty(this.a) ? "" : this.a);
            jSONObject.put("iccid", TextUtils.isEmpty(this.c) ? "" : this.c);
            jSONObject.put("imsi", TextUtils.isEmpty(this.b) ? "" : this.b);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("SimInfo{imei='");
        stringBuilder.append(this.a);
        stringBuilder.append('\'');
        stringBuilder.append(", imsi='");
        stringBuilder.append(this.b);
        stringBuilder.append('\'');
        stringBuilder.append(", iccid='");
        stringBuilder.append(this.c);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
