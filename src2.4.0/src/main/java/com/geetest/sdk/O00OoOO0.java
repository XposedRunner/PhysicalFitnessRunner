package com.geetest.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mapapi.SDKInitializer;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: GetCoder */
public final class O00OoOO0 extends O00OOo0<JSONObject> {
    private O00O00Oo O00000o0;

    private O00OoOO0(String str, Context context) {
        super(str, context);
    }

    public static O00OoOO0 O000000o(Context context, O00O00Oo o00O00Oo) {
        String O000000o = O00o0000.O000000o(o00O00Oo.O00000Oo() == null ? "" : o00O00Oo.O00000Oo(), 1);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("https://%s/get.php?gt=", new Object[]{o00O00Oo.O000000o()}));
        stringBuilder.append(o00O00Oo.O00000o0());
        stringBuilder.append("&challenge=");
        stringBuilder.append(o00O00Oo.O00000o());
        stringBuilder.append("&client_type=android&lang=");
        stringBuilder.append(o00O00Oo.O00000Oo());
        stringBuilder.append("&client_type=android");
        stringBuilder.append(O000000o);
        O00OoOO0 o00OoOO0 = new O00OoOO0(stringBuilder.toString(), context);
        o00OoOO0.O00000Oo();
        o00OoOO0.O000000o("GetCoder");
        o00OoOO0.O00000o0 = o00O00Oo;
        return o00OoOO0;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean O000000o(O00Oo0<String, JSONObject> o00Oo0, JSONObject jSONObject) {
        O00Oo0<String, JSONObject> o00Oo02 = o00Oo0;
        JSONObject jSONObject2 = jSONObject;
        Object optString = jSONObject2.optString("user_error");
        int i = 0;
        JSONObject optJSONObject;
        if (TextUtils.isEmpty(optString)) {
            optJSONObject = jSONObject2.optJSONObject("data");
            StringBuilder stringBuilder;
            if (optJSONObject == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(jSONObject.toString());
                stringBuilder.append(":  ");
                stringBuilder.append(O00000o0("data"));
                o00Oo02.O000000o = stringBuilder.toString();
                return false;
            }
            String optString2 = optJSONObject.optString("s");
            String optString3 = optJSONObject.optString("theme_version");
            String optString4 = optJSONObject.optString("feedback");
            if (TextUtils.isEmpty(optString4)) {
                optString4 = "";
            }
            String optString5 = optJSONObject.optString("api_server");
            if (TextUtils.isEmpty(optString5)) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(jSONObject.toString());
                stringBuilder.append(":  ");
                stringBuilder.append(O00000o0("api_server"));
                o00Oo02.O000000o = stringBuilder.toString();
                return false;
            }
            String optString6 = optJSONObject.optString("theme");
            if (optJSONObject.has("logo")) {
                boolean optBoolean = optJSONObject.optBoolean("logo");
                O00O0Oo0.O000000o(optBoolean);
                JSONArray optJSONArray = optJSONObject.optJSONArray("static_servers");
                List arrayList = new ArrayList();
                if (optJSONArray != null) {
                    for (int i2 = 0; optJSONArray.length() > i2; i2++) {
                        String optString7 = optJSONArray.optString(i2);
                        if (!TextUtils.isEmpty(optString7)) {
                            arrayList.add(optString7);
                        }
                    }
                }
                if (arrayList.size() == 0) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(jSONObject.toString());
                    stringBuilder.append(":  ");
                    stringBuilder.append(O00000o0("static_servers"));
                    o00Oo02.O000000o = stringBuilder.toString();
                    return false;
                }
                List arrayList2 = new ArrayList();
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("c");
                if (optJSONArray2 != null) {
                    while (i < optJSONArray2.length()) {
                        arrayList2.add(Integer.valueOf(optJSONArray2.optInt(i)));
                        i++;
                    }
                }
                O00O0o00 o00O0o00 = new O00O0o00();
                o00O0o00.O00000o0(optString5);
                o00O0o00.O00000Oo(arrayList2);
                o00O0o00.O00000Oo(optString4);
                o00O0o00.O000000o(optBoolean);
                o00O0o00.O000000o(arrayList);
                o00O0o00.O00000o(optString6);
                o00O0o00.O000000o(optString3);
                o00O0o00.O00000oO(optString2);
                this.O00000o0.O000000o(o00O0o00);
                o00Oo02.O000000o = "OK";
                o00Oo02.O00000Oo = jSONObject2;
                return true;
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(jSONObject.toString());
            stringBuilder.append(":  ");
            stringBuilder.append(O00000o0("logo"));
            o00Oo02.O000000o = stringBuilder.toString();
            return false;
        }
        try {
            optString = URLDecoder.decode(optString, "utf-8");
        } catch (UnsupportedEncodingException e) {
            try {
                e.printStackTrace();
            } catch (Exception e2) {
                Exception exception = e2;
                exception.printStackTrace();
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(jSONObject.toString());
                stringBuilder2.append(": ");
                stringBuilder2.append(exception.toString());
                o00Oo02.O000000o = stringBuilder2.toString();
                return false;
            }
        }
        Object optString8 = jSONObject2.optString(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE);
        if (optString8 != null) {
            optString8 = optString8.replaceAll("[a-zA-Z]", "");
        }
        o00Oo02.O000000o = optString;
        optJSONObject = new JSONObject();
        optJSONObject.put(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, optString8);
        o00Oo02.O00000Oo = optJSONObject;
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean O00000oo() {
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final Map<String, String> O0000Oo0() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/x-www-form-urlencoded");
        hashMap.put("Host", "api.geetest.com");
        hashMap.put("Content-Length", String.valueOf(this.O00000Oo == null ? 0 : this.O00000Oo.length));
        return hashMap;
    }
}
