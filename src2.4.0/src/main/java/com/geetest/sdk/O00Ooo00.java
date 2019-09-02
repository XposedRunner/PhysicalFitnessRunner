package com.geetest.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mapapi.SDKInitializer;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: GettypeCoder */
public final class O00Ooo00 extends O00OOo0<JSONObject> {
    private O00O00Oo O00000o0;

    private O00Ooo00(String str, Context context) {
        super(str, context);
    }

    public static O00Ooo00 O000000o(Context context, O00O00Oo o00O00Oo) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("https://%s/gettype.php?gt=", new Object[]{o00O00Oo.O000000o()}));
        stringBuilder.append(o00O00Oo.O00000o0());
        O00Ooo00 o00Ooo00 = new O00Ooo00(stringBuilder.toString(), context);
        o00Ooo00.O00000Oo();
        o00Ooo00.O000000o("Gettype");
        o00Ooo00.O00000o0 = o00O00Oo;
        return o00Ooo00;
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
            String optString2 = optJSONObject.optString("type");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("aspect_radio");
            if (optJSONObject2 == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(jSONObject.toString());
                stringBuilder.append(":  ");
                stringBuilder.append(O00000o0("aspect_radio"));
                o00Oo02.O000000o = stringBuilder.toString();
                return false;
            }
            String str;
            Map hashMap = new HashMap();
            Iterator keys = optJSONObject2.keys();
            while (keys.hasNext()) {
                str = (String) keys.next();
                hashMap.put(str, Integer.valueOf(optJSONObject2.optInt(str)));
            }
            String optString3 = optJSONObject.optString("fullpage");
            String optString4 = optJSONObject.optString("click");
            str = optJSONObject.optString("voice");
            String optString5 = optJSONObject.optString("slide");
            String optString6 = optJSONObject.optString("geetest");
            JSONArray optJSONArray = optJSONObject.optJSONArray("static_servers");
            List arrayList = new ArrayList();
            if (optJSONArray != null) {
                while (optJSONArray.length() > i) {
                    String optString7 = optJSONArray.optString(i);
                    if (!TextUtils.isEmpty(optString7)) {
                        arrayList.add(optString7);
                    }
                    i++;
                }
            }
            O00O0o0 o00O0o0 = new O00O0o0();
            o00O0o0.O000000o(hashMap);
            o00O0o0.O00000o(optString4);
            o00O0o0.O00000o0(optString6);
            o00O0o0.O00000oo(optString5);
            o00O0o0.O000000o(optString2);
            o00O0o0.O00000Oo(optString3);
            o00O0o0.O00000oO(str);
            o00O0o0.O000000o(arrayList);
            o00O0o0.O000000o(optJSONObject);
            this.O00000o0.O000000o(o00O0o0);
            o00Oo02.O000000o = "OK";
            o00Oo02.O00000Oo = jSONObject2;
            return true;
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
