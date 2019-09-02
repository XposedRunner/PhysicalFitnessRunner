package defpackage;

import android.content.Context;
import com.umeng.commonsdk.debug.UMRTLog;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: DataSpliter */
/* renamed from: as */
public class as {
    public static long O000000o(JSONArray jSONArray) {
        return (long) jSONArray.toString().getBytes().length;
    }

    public static long O000000o(JSONObject jSONObject) {
        return (long) jSONObject.toString().getBytes().length;
    }

    public static JSONObject O000000o(Context context, long j, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (!jSONObject.has("content")) {
                return jSONObject2;
            }
            JSONObject jSONObject3 = jSONObject.getJSONObject("content");
            if (jSONObject3.has("analytics")) {
                JSONObject jSONObject4 = jSONObject3.getJSONObject("analytics");
                if (jSONObject4.has(ah.O000Oo00)) {
                    jSONObject4.remove(ah.O000Oo00);
                }
                if (jSONObject4.has(ah.O000Oo0)) {
                    jSONObject4.remove(ah.O000Oo0);
                }
                if (jSONObject4.has("error")) {
                    jSONObject4.remove("error");
                }
                jSONObject3.put("analytics", jSONObject4);
            }
            jSONObject2.put("content", jSONObject3);
            if (jSONObject.has("header")) {
                jSONObject2.put("header", jSONObject.getJSONObject("header"));
            }
            if (as.O000000o(jSONObject2) <= j) {
                return jSONObject2;
            }
            am.O000000o(context).O0000Oo0();
            am.O000000o(context).O0000OOo();
            am.O000000o(context).O00000Oo(true, false);
            am.O000000o(context).O000000o();
            UMRTLog.i("MobclickRT", "--->>> u-app packet overload !!! ");
            return null;
        } catch (Throwable unused) {
            return jSONObject2;
        }
    }
}
