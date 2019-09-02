package cn.jpush.android.a;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.api.JCoreInterface;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.data.a;
import cn.jpush.android.data.g;
import org.json.JSONException;
import org.json.JSONObject;

public final class i {
    public static a a(Context context, String str, String str2, String str3, String str4) {
        if (context == null) {
            throw new IllegalArgumentException("NULL context");
        } else if (TextUtils.isEmpty(str)) {
            e.a("NO MSGID", 996, null, context);
            return null;
        } else {
            JSONObject a = a(context, "NO_MSGID", str);
            if (a == null) {
                return null;
            }
            str = a.optString(JThirdPlatFormInterface.KEY_MSG_ID, "");
            if (TextUtils.isEmpty(str)) {
                str = a.optString("ad_id", "");
            }
            if (TextUtils.isEmpty(str)) {
                str = a.optString("_jmsgid_", "");
            }
            if (TextUtils.isEmpty(str)) {
                str = str4;
            }
            boolean z = true;
            if (a.optInt("n_only", 0) != 1) {
                z = false;
            }
            int optInt = z ? a.optInt("n_builder_id", 0) : 0;
            a aVar = new a();
            aVar.c = str;
            aVar.a = a;
            aVar.b = a.optInt("show_type", 3);
            aVar.f = z;
            aVar.g = optInt;
            aVar.h = a.optInt("notificaion_type", 0);
            aVar.j = a.optString("message", "");
            aVar.k = a.optString("content_type", "");
            aVar.m = a.optString("title", "");
            aVar.n = a.optString("extras", "");
            aVar.o = str2;
            aVar.p = str3;
            aVar.d = a.optString("override_msg_id", "");
            return aVar;
        }
    }

    private static JSONObject a(Context context, String str, String str2) {
        try {
            return new JSONObject(str2);
        } catch (JSONException unused) {
            e.a(str, 996, null, context);
            return null;
        }
    }

    public static JSONObject a(Context context, String str, JSONObject jSONObject, String str2) {
        if (jSONObject == null) {
            e.a(str, 996, null, context);
            return null;
        } else if (TextUtils.isEmpty(str2)) {
            return null;
        } else {
            try {
                return jSONObject.isNull(str2) ? null : jSONObject.getJSONObject(str2);
            } catch (JSONException unused) {
                e.a(str, 996, null, context);
                return null;
            }
        }
    }

    public static void a(Context context, a aVar) {
        if (context == null) {
            throw new IllegalArgumentException("NULL context");
        }
        int i = aVar.b;
        JSONObject jSONObject = aVar.a;
        String str = aVar.c;
        if (i == 3 || i == 4) {
            jSONObject = a(context, str, jSONObject, "m_content");
            if (jSONObject != null) {
                int optInt = jSONObject.optInt("ad_t", 0);
                if (optInt == 0) {
                    g gVar = new g();
                    gVar.c = str;
                    gVar.b = i;
                    gVar.q = optInt;
                    gVar.i = aVar.i;
                    gVar.f = aVar.f;
                    gVar.g = aVar.g;
                    gVar.o = aVar.o;
                    gVar.d = aVar.d;
                    gVar.h = aVar.h;
                    if (gVar.a(context, jSONObject)) {
                        gVar.a(context);
                    }
                    return;
                }
                e.a(str, 996, null, context);
                return;
            }
            return;
        }
        e.a(str, 996, null, context);
    }

    public static void a(Context context, String str) {
        if (context == null) {
            throw new IllegalArgumentException("NULL context");
        } else if (!TextUtils.isEmpty(str)) {
            JSONObject a = a(context, "NO MSGID", str);
            if (a != null) {
                String optString = a.optString(JThirdPlatFormInterface.KEY_MSG_ID, "");
                if (TextUtils.isEmpty(optString)) {
                    optString = a.optString("ad_id", "");
                }
                int optInt = a.optInt("show_type", -1);
                if (optInt == 2) {
                    str = a.optString("m_content", "").trim();
                    if (!a(str)) {
                        e.a(optString, 996, null, context);
                        return;
                    } else if (context == null) {
                        throw new IllegalArgumentException("NULL context");
                    } else {
                        JCoreInterface.asyncExecute(new j(str, context, optString), new int[0]);
                        return;
                    }
                }
                a = optInt == 1 ? a(context, optString, a, "m_content") : null;
                if (a != null) {
                    int optInt2 = a.optInt("ad_t", -1);
                    if (optInt2 != 0) {
                        e.a(optString, 996, null, context);
                        return;
                    }
                    g gVar = new g();
                    boolean a2 = gVar.a(context, a);
                    gVar.c = optString;
                    gVar.b = optInt;
                    gVar.q = optInt2;
                    if (a2) {
                        gVar.a(context);
                    }
                }
            }
        }
    }

    public static boolean a(String str) {
        return TextUtils.isEmpty(str) ? false : str.trim().matches("^[http|https]+://.*");
    }
}
