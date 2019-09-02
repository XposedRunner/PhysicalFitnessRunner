package com.geetest.sdk;

import com.baidu.mapapi.SDKInitializer;
import com.geetest.sdk.O000000o.O000000o;
import org.json.JSONObject;

/* compiled from: GetHandler */
public class O000O0o extends O000O0OO {
    private static final String O00000oO = "O000O0o";

    static /* synthetic */ void O000000o(O000O0o o000O0o, int i, String str, JSONObject jSONObject) {
        O00O000o o00O000o;
        if (OooOO.O000000o(i)) {
            O00O00o0.O0000O0o("0");
            O0OOO00.O000000o("get接口返回错误，错误码为：207-->".concat(String.valueOf(str)));
            o00O000o = new O00O000o();
            o00O000o.O00000Oo(str);
            o00O000o.O000000o("207");
            o00O000o.O000000o(System.currentTimeMillis() - o000O0o.O00000Oo.O0000OOo());
            o00O000o.O00000o0(o000O0o.O00000Oo.O0000O0o().O00000o());
            o000O0o.O00000Oo.O000000o(o00O000o);
            o000O0o.O00000o(o000O0o.O00000Oo);
            O000O0OO.O00000o0(o000O0o.O00000Oo);
        } else if ("OK".equals(str)) {
            O00O00o0.O0000O0o("1");
            if (o000O0o.O00000Oo.O0000Oo() == 2) {
                O000000o O0000Oo0 = o000O0o.O00000Oo.O0000Oo0();
                if (O0000Oo0 != null) {
                    if (O00O0Oo0.O000000o()) {
                        O0000Oo0.O0000OOo();
                    } else {
                        O0000Oo0.O0000Oo0();
                    }
                }
            }
            o000O0o.O000000o.O00000Oo(o000O0o.O00000Oo);
        } else {
            O00O00o0.O0000O0o("0");
            O0OOO00.O000000o("get接口返回错误，错误码为：207-->".concat(String.valueOf(str)));
            o00O000o = new O00O000o();
            o00O000o.O00000Oo(str);
            o00O000o.O000000o(jSONObject.optString(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE));
            o00O000o.O000000o(System.currentTimeMillis() - o000O0o.O00000Oo.O0000OOo());
            o00O000o.O00000o0(o000O0o.O00000Oo.O0000O0o().O00000o());
            o000O0o.O00000Oo.O000000o(o00O000o);
            o000O0o.O00000o(o000O0o.O00000Oo);
            O000O0OO.O00000o0(o000O0o.O00000Oo);
        }
    }

    public final int O000000o() {
        return 10;
    }

    public final void O000000o(O0O0o00 o0O0o00) {
        O00OOo.O000000o().O000000o(O00OoOO0.O000000o(o0O0o00.O00000o(), o0O0o00.O0000O0o()), O00Oo0OO.O000000o(new O000OO00(this)));
    }
}
