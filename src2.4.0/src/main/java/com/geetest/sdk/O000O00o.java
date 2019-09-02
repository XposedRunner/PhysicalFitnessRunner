package com.geetest.sdk;

import org.json.JSONObject;

/* compiled from: Api2Handler */
public class O000O00o extends O000O0OO {
    private static final String O00000oO = "O000O00o";

    public final int O000000o() {
        return 25;
    }

    public final void O000000o(O0O0o00 o0O0o00) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("geetest_challenge", o0O0o00.O0000O0o().O0000OoO());
            jSONObject.put("geetest_seccode", o0O0o00.O0000O0o().O0000o00());
            jSONObject.put("geetest_validate", o0O0o00.O0000O0o().O0000Ooo());
            o0O0o00.O00000oO().getListener().onDialogResult(jSONObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
            StringBuilder stringBuilder = new StringBuilder("拼接错误，错误码为：202-->");
            stringBuilder.append(e.toString());
            O0OOO00.O000000o(stringBuilder.toString());
            O00O000o o00O000o = new O00O000o();
            StringBuilder stringBuilder2 = new StringBuilder("onDialogResult error-->");
            stringBuilder2.append(e.toString());
            o00O000o.O00000Oo(stringBuilder2.toString());
            o00O000o.O000000o("202");
            o00O000o.O000000o(System.currentTimeMillis() - o0O0o00.O0000OOo());
            o00O000o.O00000o0(o0O0o00.O0000O0o().O00000o());
            o0O0o00.O000000o(o00O000o);
            O000O0OO.O00000o0(o0O0o00);
        }
    }
}
