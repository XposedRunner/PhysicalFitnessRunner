package com.geetest.sdk;

import com.tencent.open.SocialConstants;
import java.io.BufferedReader;
import java.io.FileReader;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ParamUtils */
public final class O0O00o {
    private static JSONArray O000000o() {
        JSONArray jSONArray = new JSONArray();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/system/etc/hosts"));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                jSONArray.put(readLine);
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONArray;
    }

    public static JSONObject O000000o(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SocialConstants.PARAM_URL, str);
            O0O0O0o O000000o = new O0O0O(str).O000000o();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("ip", O000000o.O00000o0());
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(O000000o.O0000Oo());
            jSONObject2.put("ttl", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(O000000o.O00000Oo());
            jSONObject2.put("transmitted", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(O000000o.O00000oO());
            jSONObject2.put("receive", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(O000000o.O00000o());
            jSONObject2.put("lossRate", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(O000000o.O0000Oo0());
            jSONObject2.put("rttMin", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(O000000o.O00000oo());
            jSONObject2.put("rttAvg", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(O000000o.O0000OOo());
            jSONObject2.put("rttMax", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(O000000o.O0000O0o());
            jSONObject2.put("rttMDev", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(O000000o.O000000o());
            jSONObject2.put("allTime", stringBuilder.toString());
            jSONObject.put("ping", jSONObject2);
            jSONObject.put("host", O000000o());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
