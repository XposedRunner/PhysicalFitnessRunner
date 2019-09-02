package com.geetest.sdk;

import android.os.Build;
import android.os.Build.VERSION;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* compiled from: ReportParam */
public final class O0O0OO0 {
    public static JSONObject O000000o(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject O000000o = O0O00o.O000000o(new URL(str).getHost());
            jSONObject.put("time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis())));
            jSONObject.put("exception_url", str);
            jSONObject.put("domain_ip", O000000o.getJSONObject("ping").getString("ip"));
            jSONObject.put("user_ip", new JSONObject(O0O00o0.O000000o()));
            jSONObject.put("captcha_id", str2);
            jSONObject.put("client_type", "android");
            jSONObject.put("challenge", str3);
            jSONObject.put("device_type", Build.MODEL);
            jSONObject.put("device_os_version", VERSION.RELEASE);
            jSONObject.put("sdk_version", str4);
            jSONObject.put("network", O000000o);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
