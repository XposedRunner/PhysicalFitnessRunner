package com.qiyukf.nimlib.d.b.a;

import com.qiyukf.nimlib.d.b.a;
import org.json.JSONException;
import org.json.JSONObject;

public final class c implements a {
    private int a;
    private int b;
    private int c;

    c(int i, int i2, int i3) {
        this.a = i;
        this.b = i2;
        this.c = i3;
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cell_id", this.b);
            jSONObject.put("lac", this.a);
            jSONObject.put("strength", this.c);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("CellInfo{lac=");
        stringBuilder.append(this.a);
        stringBuilder.append(", cid=");
        stringBuilder.append(this.b);
        stringBuilder.append(", strength=");
        stringBuilder.append(this.c);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
