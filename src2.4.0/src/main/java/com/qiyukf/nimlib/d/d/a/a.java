package com.qiyukf.nimlib.d.d.a;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class a implements com.qiyukf.nimlib.d.b.a {
    private static final DateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
    private static final Date b = new Date();
    private final int c;
    private final String d;
    private final double e;
    private final double f;
    private final double g;
    private final float h;
    private final long i;

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.c);
            jSONObject.put("coor_type", this.d);
            jSONObject.put("latitude", this.e);
            jSONObject.put("longitude", this.f);
            jSONObject.put("altitude", this.g);
            jSONObject.put("precision", (double) this.h);
            jSONObject.put("time", this.i);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    public final String toString() {
        b.setTime(this.i);
        StringBuilder stringBuilder = new StringBuilder("loc{");
        stringBuilder.append(this.e);
        stringBuilder.append(",");
        stringBuilder.append(this.f);
        stringBuilder.append(",");
        stringBuilder.append(this.e);
        stringBuilder.append(",");
        stringBuilder.append(a.format(b));
        stringBuilder.append(",");
        stringBuilder.append(this.c);
        stringBuilder.append(",");
        stringBuilder.append(this.d);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
