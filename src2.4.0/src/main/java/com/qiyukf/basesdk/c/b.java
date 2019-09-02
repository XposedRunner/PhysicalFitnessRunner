package com.qiyukf.basesdk.c;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b {
    public static String a(JSONArray jSONArray, int i) {
        return jSONArray == null ? null : jSONArray.optString(i);
    }

    public static JSONObject a(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return new JSONObject(str);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static void a(JSONArray jSONArray, Object obj) {
        try {
            jSONArray.put(obj);
        } catch (Exception unused) {
        }
    }

    public static void a(JSONObject jSONObject, String str, int i) {
        try {
            jSONObject.put(str, i);
        } catch (Exception unused) {
        }
    }

    public static void a(JSONObject jSONObject, String str, long j) {
        try {
            jSONObject.put(str, j);
        } catch (Exception unused) {
        }
    }

    public static void a(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (Exception unused) {
        }
    }

    public static void a(JSONObject jSONObject, String str, String str2) {
        try {
            jSONObject.put(str, str2);
        } catch (Exception unused) {
        }
    }

    public static boolean a(JSONObject jSONObject, String str) {
        return jSONObject != null && jSONObject.optBoolean(str);
    }

    public static int b(JSONObject jSONObject, String str) {
        return jSONObject == null ? 0 : jSONObject.optInt(str);
    }

    public static JSONArray b(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return new JSONArray(str);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static JSONObject b(JSONArray jSONArray, int i) {
        return jSONArray == null ? null : jSONArray.optJSONObject(i);
    }

    public static long c(JSONObject jSONObject, String str) {
        return jSONObject == null ? 0 : jSONObject.optLong(str);
    }

    public static double d(JSONObject jSONObject, String str) {
        return jSONObject == null ? 0.0d : jSONObject.optDouble(str);
    }

    public static String e(JSONObject jSONObject, String str) {
        return jSONObject == null ? null : jSONObject.optString(str, null);
    }

    public static JSONObject f(JSONObject jSONObject, String str) {
        return jSONObject == null ? null : jSONObject.optJSONObject(str);
    }

    public static JSONArray g(JSONObject jSONObject, String str) {
        return jSONObject == null ? null : jSONObject.optJSONArray(str);
    }
}
