package com.alibaba.wireless.security.framework;

import java.io.File;
import org.json.JSONObject;

public class b {
    private static String b = "version";
    private static String c = "lib_dep_version";
    private static String d = "lib_dep_arch";
    private static String e = "target_plugin";
    private JSONObject a;
    private boolean f = true;
    private int g = 0;
    private boolean h = true;
    private String i = "";
    private boolean j = true;
    private String k = "";

    private b(JSONObject jSONObject) {
        this.a = jSONObject;
    }

    public static b a(File file) {
        b bVar = null;
        if (file != null) {
            if (!file.exists()) {
                return null;
            }
            try {
                String a = com.alibaba.wireless.security.framework.utils.b.a(file);
                if (a != null && a.length() > 0) {
                    JSONObject jSONObject = new JSONObject(a);
                    if ("1.0".equals(jSONObject.getString(b))) {
                        bVar = new b(jSONObject);
                    }
                }
            } catch (Exception unused) {
            }
        }
        return bVar;
    }

    public String a(String str) {
        try {
            return a().getString(str);
        } catch (Exception unused) {
            return "";
        }
    }

    public JSONObject a() {
        return this.a;
    }

    public int b() {
        if (this.f) {
            int parseInt;
            try {
                parseInt = Integer.parseInt(a().getString(c));
            } catch (Exception unused) {
                parseInt = 0;
            }
            this.g = parseInt;
            this.f = false;
        }
        return this.g;
    }

    public String c() {
        if (this.h) {
            String string;
            try {
                string = a().getString(d);
            } catch (Exception unused) {
                string = "";
            }
            this.i = string;
            this.h = false;
        }
        return this.i;
    }

    public String d() {
        if (this.j) {
            String string;
            try {
                string = a().getString(e);
            } catch (Exception unused) {
                string = "";
            }
            this.k = string;
            this.j = false;
        }
        return this.k;
    }
}
