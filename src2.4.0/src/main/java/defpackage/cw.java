package defpackage;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.stateless.UMSLEnvelopeBuild;
import com.umeng.socialize.net.dplus.cache.DplusCacheListener;
import com.umeng.socialize.net.dplus.cache.O0000O0o;
import com.umeng.socialize.utils.O00000o;
import com.umeng.socialize.utils.O0000o00.O0000Oo;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: UMWorkDispatch */
/* renamed from: cw */
public class cw {
    public static String O000000o = "umpx_share";

    /* compiled from: UMWorkDispatch */
    /* renamed from: cw$1 */
    static class 1 implements DplusCacheListener {
        1() {
        }

        public void O000000o(JSONObject jSONObject) {
        }
    }

    public static void O000000o(final Context context, final int i, Object obj) {
        UMSLEnvelopeBuild.mContext = context;
        if (i == ce.O00oOoOo) {
            O0000O0o.O000000o().O000000o(context, (JSONObject) obj, i, new 1());
        } else {
            O0000O0o.O000000o().O000000o(context, (JSONObject) obj, i, new DplusCacheListener() {
                public void O000000o(JSONObject jSONObject) {
                    UMSLEnvelopeBuild uMSLEnvelopeBuild = new UMSLEnvelopeBuild();
                    JSONObject O000000o = cw.O00000Oo(context, uMSLEnvelopeBuild.buildSLBaseHeader(context));
                    JSONObject O000000o2 = O0000O0o.O000000o().O000000o(context, i);
                    jSONObject = (O000000o2 == null || TextUtils.isEmpty(O000000o2.toString())) ? null : uMSLEnvelopeBuild.buildSLEnvelope(context, O000000o, O000000o2, cw.O000000o);
                    if (jSONObject == null) {
                        com.umeng.socialize.utils.O0000O0o.O000000o(O0000Oo.O0000o0);
                    } else if (!jSONObject.has(ah.O000oOOo)) {
                        O0000O0o.O000000o().O00000Oo(context);
                    } else if (jSONObject.optInt(ah.O000oOOo) != 101) {
                        O0000O0o.O000000o().O00000Oo(context);
                    }
                }
            });
        }
    }

    private static JSONObject O00000Oo(Context context, JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("header");
            if (optJSONObject != null) {
                optJSONObject.put("s_sdk_v", "6.9.4");
                optJSONObject.put(cu.O00000Oo, ce.O0000Oo0);
                optJSONObject.put("imei", O00000o.O000000o(context));
            }
            jSONObject.put("header", optJSONObject);
        } catch (JSONException e) {
            com.umeng.socialize.utils.O0000O0o.O000000o(e);
        }
        return jSONObject;
    }
}
