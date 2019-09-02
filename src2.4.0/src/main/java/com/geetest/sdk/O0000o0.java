package com.geetest.sdk;

import android.text.TextUtils;
import com.geetest.sdk.O000000o.O000000o;
import com.tencent.bugly.Bugly;
import org.json.JSONObject;

/* compiled from: API1Handler */
public class O0000o0 extends O000O0OO {
    private static final String O00000oO = "O0000o0";

    private void O000000o(int i, String str, JSONObject jSONObject) {
        this.O00000o.getListener().onApi1Result(jSONObject == null ? null : jSONObject.toString());
        if (OooOO.O000000o(i)) {
            O00O00o0.O00000oO("0");
            O0OOO00.O000000o("api1接口错误，错误码为：205-->".concat(String.valueOf(str)));
            O00O000o o00O000o = new O00O000o();
            o00O000o.O00000Oo(str);
            o00O000o.O000000o("205");
            o00O000o.O000000o(System.currentTimeMillis() - this.O00000Oo.O0000OOo());
            o00O000o.O00000o0(null);
            this.O00000Oo.O000000o(o00O000o);
            O00000o(this.O00000Oo);
            O000O0OO.O00000o0(this.O00000Oo);
            return;
        }
        O00O00o0.O00000oO("1");
        O00O00o0.O00000o0(this.O00000Oo.O0000O0o().O00000o0());
        O00O00o0.O00000o(this.O00000Oo.O0000O0o().O00000o());
        if (this.O00000Oo.O0000O0o().O0000Oo()) {
            O00O00o0.O000000o("true");
            this.O000000o.O00000Oo(this.O00000Oo);
            return;
        }
        if (this.O00000Oo.O0000Oo() == 2) {
            O000000o O0000Oo0 = this.O00000Oo.O0000Oo0();
            if (O0000Oo0 != null) {
                O0000Oo0.O00000oo();
            }
        }
        O00O00o0.O000000o(Bugly.SDK_IS_DEV);
        this.O00000Oo.O000000o = O0O0o00.O000000o.SHUTDOWN$5c47eb37;
        String O000000o = ooooooo.O000000o(this.O00000Oo.O0000O0o().O00000o());
        this.O00000Oo.O0000O0o().O0000O0o(this.O00000Oo.O0000O0o().O00000o());
        this.O00000Oo.O0000O0o().O0000Oo0(O000000o);
        O00O00Oo O0000O0o = this.O00000Oo.O0000O0o();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(O000000o);
        stringBuilder.append("|jordan");
        O0000O0o.O0000OOo(stringBuilder.toString());
        this.O00000Oo.O00000Oo();
        this.O000000o.O00000Oo(this.O00000Oo);
        O00000o(this.O00000Oo);
    }

    public final int O000000o() {
        return 1;
    }

    public final void O000000o(O0O0o00 o0O0o00) {
        o0O0o00.O00000oo().O000000o();
        JSONObject api1Json = this.O00000o.getApi1Json();
        O00O00Oo O0000O0o = o0O0o00.O0000O0o();
        StringBuilder stringBuilder;
        String optString;
        if (api1Json == null) {
            O000000o(-1, "api1 result is null !", null);
        } else if (api1Json == null) {
            O000000o(-1, "api1 result parsed is null !", null);
        } else if (api1Json.has("data")) {
            JSONObject optJSONObject = api1Json.optJSONObject("data");
            if (optJSONObject == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(api1Json.toString());
                stringBuilder.append("-->absent data");
                O000000o(-1, stringBuilder.toString(), api1Json);
                return;
            }
            int optInt = optJSONObject.optInt("success");
            optString = optJSONObject.optString("challenge");
            if (TextUtils.isEmpty(optString)) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(api1Json.toString());
                stringBuilder.append("-->absent challenge");
                O000000o(-1, stringBuilder.toString(), api1Json);
                return;
            }
            String optString2 = optJSONObject.optString("gt");
            if (TextUtils.isEmpty(optString2)) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(api1Json.toString());
                stringBuilder.append("-->absent gt");
                O000000o(-1, stringBuilder.toString(), api1Json);
                return;
            }
            O0000O0o.O00000o(optString);
            O0000O0o.O00000o0(optString2);
            O0000O0o.O00000o(optInt);
            O000000o(0, "OK", api1Json);
        } else {
            int optInt2 = api1Json.optInt("success");
            String optString3 = api1Json.optString("challenge");
            if (TextUtils.isEmpty(optString3)) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(api1Json.toString());
                stringBuilder.append("-->absent challenge");
                O000000o(-1, stringBuilder.toString(), api1Json);
                return;
            }
            optString = api1Json.optString("gt");
            if (TextUtils.isEmpty(optString)) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(api1Json.toString());
                stringBuilder.append("-->absent gt");
                O000000o(-1, stringBuilder.toString(), api1Json);
                return;
            }
            O0000O0o.O00000o(optString3);
            O0000O0o.O00000o0(optString);
            O0000O0o.O00000o(optInt2);
            O000000o(0, "OK", api1Json);
        }
    }
}
