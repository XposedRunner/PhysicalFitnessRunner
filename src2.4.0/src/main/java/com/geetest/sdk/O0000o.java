package com.geetest.sdk;

import com.baidu.mapapi.SDKInitializer;
import com.geetest.sdk.O000000o.O000000o;
import org.json.JSONObject;

/* compiled from: AjaxHandler */
public class O0000o extends O000O0OO {
    private static final String O00000oO = "O0000o";

    static /* synthetic */ void O000000o(O0000o o0000o, int i, String str, JSONObject jSONObject) {
        if (o0000o.O00000Oo.O0000Oo() == 2) {
            O000000o O0000Oo0 = o0000o.O00000Oo.O0000Oo0();
            if (O0000Oo0 != null) {
                O0000Oo0.O00000Oo();
            }
        }
        if (OooOO.O000000o(i)) {
            O00O00o0.O0000OOo("0");
            o0000o.O000000o("208", "ajax接口返回错误，错误码为：208-->".concat(String.valueOf(str)), str);
        } else if ("OK".equals(str)) {
            O00O00Oo O0000O0o = o0000o.O00000Oo.O0000O0o();
            String O0000Oo02 = O0000O0o.O0000Oo0();
            O00O00o0.O00000Oo(O0000Oo02);
            StringBuilder stringBuilder;
            StringBuilder stringBuilder2;
            if ("success".equals(O0000Oo02)) {
                O00O00o0.O0000OOo("1");
                o0000o.O00000o(o0000o.O00000Oo);
                o0000o.O00000Oo.O000000o = O0O0o00.O000000o.ONEPASS$5c47eb37;
                O0000O0o.O0000O0o(O0000O0o.O00000o());
                O0000O0o.O0000OOo(O0000O0o.O0000o0o());
                stringBuilder = new StringBuilder();
                stringBuilder.append(O0000O0o.O0000o0o());
                stringBuilder.append("|jordan");
                O0000O0o.O0000Oo0(stringBuilder.toString());
                o0000o.O00000Oo.O00000Oo();
                o0000o.O000000o.O00000Oo(o0000o.O00000Oo);
            } else if ("forbidden".equals(O0000Oo02)) {
                O00O00o0.O0000OOo("0");
                o0000o.O000000o("200", "ajax接口被forbidden，错误码为：200-->".concat(String.valueOf(str)), jSONObject.toString());
            } else if (O0000O0o.O0000o0().O00000Oo().has(O0000Oo02)) {
                int intValue = ((Integer) O0000O0o.O0000o0().O000000o().get(O0000Oo02)).intValue();
                if (intValue == 0) {
                    O00O00o0.O0000OOo("0");
                    stringBuilder2 = new StringBuilder("ajax接口返回错误，dialogHeight为0，错误码为：208-->");
                    stringBuilder2.append(O0000O0o.O0000o0().toString());
                    o0000o.O000000o("208", stringBuilder2.toString(), str);
                    return;
                }
                O00O00o0.O0000OOo("1");
                O0000O0o.O00000o0(intValue);
                o0000o.O000000o.O00000Oo(o0000o.O00000Oo);
            } else {
                O00O00o0.O0000OOo("0");
                stringBuilder = new StringBuilder("ajax接口返回错误，错误码为：208-->");
                stringBuilder.append(jSONObject.toString());
                str = stringBuilder.toString();
                stringBuilder2 = new StringBuilder("data type error-->");
                stringBuilder2.append(jSONObject.toString());
                o0000o.O000000o("208", str, stringBuilder2.toString());
            }
        } else {
            O00O00o0.O0000OOo("0");
            o0000o.O000000o(jSONObject.optString(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE), "ajax接口返回错误，错误码为：208-->".concat(String.valueOf(str)), str);
        }
    }

    private void O000000o(String str, String str2, String str3) {
        O0OOO00.O000000o(str2);
        O00O000o o00O000o = new O00O000o();
        o00O000o.O00000Oo(str3);
        o00O000o.O000000o(str);
        o00O000o.O000000o(System.currentTimeMillis() - this.O00000Oo.O0000OOo());
        o00O000o.O00000o0(this.O00000Oo.O0000O0o().O00000o());
        this.O00000Oo.O000000o(o00O000o);
        O00000o(this.O00000Oo);
        O000O0OO.O00000o0(this.O00000Oo);
    }

    public final int O000000o() {
        return 15;
    }

    public final void O000000o(O0O0o00 o0O0o00) {
        O00OOo.O000000o().O000000o(O00OoO0o.O000000o(o0O0o00.O00000o(), o0O0o00.O0000O0o()), O00Oo0OO.O000000o(new O00oOooO(this)));
    }
}
