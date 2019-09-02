package com.geetest.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mapapi.SDKInitializer;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: AjaxCoder */
public class O00OoO0o extends O00OOo0<JSONObject> {
    private static final String O00000o0 = "O00OoO0o";
    private O00O00Oo O00000o;
    private Map<String, String> O00000oO;

    private O00OoO0o(String str, Context context) {
        super(str, context);
    }

    public static O00OoO0o O000000o(Context context, O00O00Oo o00O00Oo) {
        StringBuilder stringBuilder = new StringBuilder("https://");
        stringBuilder.append(o00O00Oo.O000000o());
        stringBuilder.append("/ajax.php?gt=");
        stringBuilder.append(o00O00Oo.O00000o0());
        stringBuilder.append("&challenge=");
        stringBuilder.append(o00O00Oo.O00000o());
        stringBuilder.append("&client_type=android&lang=");
        stringBuilder.append(o00O00Oo.O00000Oo());
        O00OoO0o o00OoO0o = new O00OoO0o(stringBuilder.toString(), context);
        o00OoO0o.O00000Oo();
        o00OoO0o.O00000o = o00O00Oo;
        o00OoO0o.O000000o("Ajax");
        o00OoO0o.O00000o();
        return o00OoO0o;
    }

    /* Access modifiers changed, original: protected|final */
    public final JSONObject O000000o() {
        JSONObject jSONObject = new JSONObject();
        try {
            String O000000o = O000o0.O000000o(this.O000000o);
            String replace = !TextUtils.isEmpty(this.O00000o.O0000oO0()) ? this.O00000o.O0000oO0().replace("[", "").replace("]", "") : null;
            String replace2 = !TextUtils.isEmpty(this.O00000o.O0000o()) ? this.O00000o.O0000o().replace("]", "").replace("[", "").replace("{", "").replace("}", "") : null;
            JSONObject jSONObject2 = new JSONObject();
            if (O000000o != null) {
                jSONObject2.put("mi", O000000o.replaceAll(" ", ""));
            }
            if (replace != null) {
                jSONObject2.put("m", replace.replaceAll(" ", ""));
            }
            if (replace2 != null) {
                jSONObject2.put("light", replace2.replaceAll(" ", ""));
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.O00000o.O00000o0());
            stringBuilder.append(this.O00000o.O00000o());
            stringBuilder.append(System.currentTimeMillis());
            jSONObject2.put("rp", ooooooo.O000000o(stringBuilder.toString()));
            JSONObject jSONObject3 = new JSONObject();
            this.O00000oO = this.O00000o.O0000oO();
            if (this.O00000oO != null && this.O00000oO.size() > 0) {
                jSONObject3.put("ci", new JSONObject(this.O00000oO));
            }
            if (jSONObject3.length() > 0) {
                jSONObject2.put("ep", jSONObject3.toString());
            }
            jSONObject2.put("sign", O00o0.O000000o(O000000o, "e6OXZ8q2cdJQctncOhd4qyT8iR32jZwU"));
            jSONObject.put("gt", this.O00000o.O00000o0());
            jSONObject.put("challenge", this.O00000o.O00000o());
            jSONObject.put("client_type", "android");
            new StringBuilder("ajax add info: ").append(jSONObject2.toString());
            O0OOO00.O000000o();
            jSONObject.put("w", O00o0000.O000000o(jSONObject2.toString(), 2));
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean O000000o(O00Oo0<String, JSONObject> o00Oo0, JSONObject jSONObject) {
        Object optString = jSONObject.optString("user_error");
        JSONObject optJSONObject;
        if (TextUtils.isEmpty(optString)) {
            optJSONObject = jSONObject.optJSONObject("data");
            StringBuilder stringBuilder;
            if (optJSONObject == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(jSONObject.toString());
                stringBuilder.append(":  ");
                stringBuilder.append(O00000o0("data"));
                o00Oo0.O000000o = stringBuilder.toString();
                return false;
            }
            String optString2 = optJSONObject.optString("result");
            if (TextUtils.isEmpty(optString2)) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(jSONObject.toString());
                stringBuilder.append(":  ");
                stringBuilder.append(O00000o0("result"));
                o00Oo0.O000000o = stringBuilder.toString();
                return false;
            }
            this.O00000o.O00000oo(optString2);
            if (this.O00000o.O0000o0().O00000Oo().has(optString2)) {
                this.O00000o.O00000oO(this.O00000o.O0000o0().O00000Oo().optString(optString2));
            } else {
                this.O00000o.O00000oO(null);
            }
            if (optJSONObject.has("validate")) {
                this.O00000o.O0000Oo(optJSONObject.optString("validate"));
            }
            o00Oo0.O000000o = "OK";
            o00Oo0.O00000Oo = jSONObject;
            return true;
        }
        try {
            optString = URLDecoder.decode(optString, "utf-8");
        } catch (UnsupportedEncodingException e) {
            try {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(jSONObject.toString());
                stringBuilder2.append(": ");
                stringBuilder2.append(e2.toString());
                o00Oo0.O000000o = stringBuilder2.toString();
                return false;
            }
        }
        Object optString3 = jSONObject.optString(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE);
        if (optString3 != null) {
            optString3 = optString3.replaceAll("[a-zA-Z]", "");
        }
        o00Oo0.O000000o = optString;
        optJSONObject = new JSONObject();
        optJSONObject.put(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, optString3);
        o00Oo0.O00000Oo = optJSONObject;
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean O00000oo() {
        return super.O00000oo();
    }

    /* Access modifiers changed, original: protected|final */
    public final Map<String, String> O0000Oo0() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/x-www-form-urlencoded");
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("Content-Encoding", "gzip");
        hashMap.put("Host", "api.geetest.com");
        hashMap.put("Content-Length", String.valueOf(this.O00000Oo == null ? 0 : this.O00000Oo.length));
        return hashMap;
    }
}
