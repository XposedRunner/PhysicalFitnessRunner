package com.qiyukf.basesdk.b.a.b.c;

import android.text.TextUtils;
import com.qiyukf.basesdk.c.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d {
    private String a;
    private String b;
    private String c;
    private int d;

    private static d a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        d dVar = new d();
        dVar.c = b.e(jSONObject, "bucket");
        dVar.b = b.e(jSONObject, "token");
        dVar.a = b.e(jSONObject, "obj");
        dVar.d = b.b(jSONObject, "expire");
        return dVar;
    }

    public static String a(d dVar) {
        return b(dVar).toString();
    }

    public static String a(List<d> list) {
        JSONArray jSONArray = new JSONArray();
        for (d b : list) {
            JSONObject b2 = b(b);
            if (b2 != null) {
                jSONArray.put(b2);
            }
        }
        return jSONArray.toString();
    }

    private static JSONObject b(d dVar) {
        if (dVar == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        b.a(jSONObject, "bucket", dVar.c);
        b.a(jSONObject, "token", dVar.b);
        b.a(jSONObject, "obj", dVar.a);
        b.a(jSONObject, "expire", dVar.d);
        return jSONObject;
    }

    public static List<d> d(String str) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray b = b.b(str);
                for (int i = 0; i < b.length(); i++) {
                    d a = a(b.getJSONObject(i));
                    if (a != null) {
                        arrayList.add(a);
                    }
                }
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    public static d e(String str) {
        return a(b.a(str));
    }

    public final String a() {
        return this.b;
    }

    public final void a(int i) {
        this.d = i;
    }

    public final void a(String str) {
        this.b = str;
    }

    public final String b() {
        return this.c;
    }

    public final void b(String str) {
        this.c = str;
    }

    public final String c() {
        return this.a;
    }

    public final void c(String str) {
        this.a = str;
    }
}
