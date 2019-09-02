package cn.jiguang.d.h;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class h {
    public static int a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                return jSONObject.toString().getBytes("utf-8").length;
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    public static JSONObject a(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!map.isEmpty()) {
                for (Entry entry : map.entrySet()) {
                    jSONObject.put((String) entry.getKey(), entry.getValue());
                }
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public static JSONObject a(JSONObject jSONObject, Set<String> set) {
        JSONObject jSONObject2 = new JSONObject();
        if (set == null || set.isEmpty()) {
            return jSONObject2;
        }
        for (String str : set) {
            try {
                jSONObject2.put(str, jSONObject.opt(str));
            } catch (JSONException unused) {
            }
        }
        return jSONObject2;
    }

    public static void a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject2 != null && jSONObject2.length() != 0 && jSONObject != null) {
            Iterator keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                try {
                    jSONObject.put(str, jSONObject2.get(str));
                } catch (JSONException unused) {
                }
            }
        }
    }

    public static boolean b(JSONObject jSONObject) {
        return jSONObject == null || jSONObject.length() == 0;
    }
}
