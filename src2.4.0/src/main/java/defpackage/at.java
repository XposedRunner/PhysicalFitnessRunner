package defpackage;

import android.content.Context;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O000000o;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DefconProcesser */
/* renamed from: at */
public class at {
    private static final int O000000o = 0;
    private static final int O00000Oo = 1;
    private static final int O00000o = 3;
    private static final int O00000o0 = 2;
    private final long O00000oO;

    /* compiled from: DefconProcesser */
    /* renamed from: at$O000000o */
    private static class O000000o {
        public static final at O000000o = new at();

        private O000000o() {
        }
    }

    private at() {
        this.O00000oO = O000000o.O00000o;
    }

    public static at O000000o() {
        return O000000o.O000000o;
    }

    private void O000000o(JSONObject jSONObject, boolean z) {
        if (!z && jSONObject.has(ah.O0000o0)) {
            jSONObject.remove(ah.O0000o0);
        }
        if (jSONObject.has(ah.O000OO0o)) {
            jSONObject.remove(ah.O000OO0o);
        }
        if (jSONObject.has("error")) {
            jSONObject.remove("error");
        }
        if (jSONObject.has(ah.O000Oo00)) {
            jSONObject.remove(ah.O000Oo00);
        }
        if (jSONObject.has(ah.O000Oo0)) {
            jSONObject.remove(ah.O000Oo0);
        }
        if (jSONObject.has(ah.O000OO0o)) {
            jSONObject.remove(ah.O000OO0o);
        }
        if (jSONObject.has("userlevel")) {
            jSONObject.remove("userlevel");
        }
    }

    private JSONArray O00000Oo() {
        JSONArray jSONArray = new JSONArray();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", ba.O000000o().O000000o(UMGlobalContext.getAppContext(null)));
            jSONObject.put(ah.O0000o0o, currentTimeMillis);
            jSONObject.put(ah.O0000o, currentTimeMillis + O000000o.O00000o);
            jSONObject.put("duration", O000000o.O00000o);
            jSONArray.put(jSONObject);
        } catch (JSONException unused) {
        }
        return jSONArray;
    }

    private JSONArray O00000o0() {
        JSONArray jSONArray = new JSONArray();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", ba.O000000o().O00000o(UMGlobalContext.getAppContext(null)));
            jSONObject.put(ah.O0000o0o, currentTimeMillis);
            jSONArray.put(jSONObject);
        } catch (JSONException unused) {
        }
        return jSONArray;
    }

    public int O000000o(Context context) {
        return Integer.valueOf(UMEnvelopeBuild.imprintProperty(context, "defcon", String.valueOf(0))).intValue();
    }

    public void O000000o(JSONObject jSONObject, Context context) {
        int O000000o = O000000o(context);
        if (O000000o == 1) {
            O000000o(jSONObject, true);
            am.O000000o(context).O00000Oo(false, true);
        } else if (O000000o == 2) {
            jSONObject.remove(ah.O0000o0);
            try {
                jSONObject.put(ah.O0000o0, O00000Oo());
            } catch (Exception unused) {
            }
            O000000o(jSONObject, true);
            am.O000000o(context).O00000Oo(false, true);
        } else if (O000000o == 3) {
            O000000o(jSONObject, false);
            am.O000000o(context).O00000Oo(false, true);
        }
    }

    public void O00000Oo(JSONObject jSONObject, Context context) {
        int O000000o = O000000o(context);
        if (O000000o == 1) {
            if (jSONObject.has(ah.O000OO0o)) {
                jSONObject.remove(ah.O000OO0o);
            }
            if (jSONObject.has(ah.O0000o0)) {
                try {
                    JSONArray jSONArray = jSONObject.getJSONArray(ah.O0000o0);
                    O000000o = jSONArray.length();
                    for (int i = 0; i < O000000o; i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        if (jSONObject2.has(ah.O000oO00)) {
                            jSONObject2.remove(ah.O000oO00);
                        }
                        if (jSONObject2.has(ah.O000oO0)) {
                            jSONObject2.remove(ah.O000oO0);
                        }
                    }
                } catch (JSONException unused) {
                }
            }
            am.O000000o(context).O000000o(false, true);
        } else if (O000000o == 2) {
            if (jSONObject.has(ah.O000OO0o)) {
                jSONObject.remove(ah.O000OO0o);
            }
            if (jSONObject.has(ah.O0000o0)) {
                jSONObject.remove(ah.O0000o0);
            }
            try {
                jSONObject.put(ah.O0000o0, O00000o0());
            } catch (Exception unused2) {
            }
            am.O000000o(context).O000000o(false, true);
        } else if (O000000o == 3) {
            if (jSONObject.has(ah.O000OO0o)) {
                jSONObject.remove(ah.O000OO0o);
            }
            jSONObject.remove(ah.O0000o0);
            am.O000000o(context).O000000o(false, true);
        }
    }
}
