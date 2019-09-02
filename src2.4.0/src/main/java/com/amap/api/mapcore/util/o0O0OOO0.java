package com.amap.api.mapcore.util;

import android.content.Context;
import android.util.Log;
import cn.jiguang.net.HttpUtils;
import com.tencent.stat.DeviceInfo;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
/* compiled from: AuthManager */
public class o0O0OOO0 {
    public static int O000000o = -1;
    public static String O00000Oo = "";
    private static String O00000o = "http://apiinit.amap.com/v3/log/init";
    private static o0OO0o00 O00000o0;
    private static String O00000oO;

    private static String O000000o() {
        return O00000o;
    }

    private static Map<String, String> O000000o(Context context) {
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("resType", "json");
            hashMap.put("encode", HttpUtils.ENCODING_UTF_8);
            String O000000o = o0O0OOOo.O000000o();
            hashMap.put(DeviceInfo.TAG_TIMESTAMPS, O000000o);
            hashMap.put("key", o0O0O0Oo.O00000oo(context));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("resType=json&encode=UTF-8&key=");
            stringBuilder.append(o0O0O0Oo.O00000oo(context));
            hashMap.put("scode", o0O0OOOo.O000000o(context, O000000o, o0OOOO00.O00000o(stringBuilder.toString())));
        } catch (Throwable th) {
            oO0OoOO0.O000000o(th, "Auth", "gParams");
        }
        return hashMap;
    }

    @Deprecated
    public static synchronized boolean O000000o(Context context, o0OO0o00 o0oo0o00) {
        boolean O000000o;
        synchronized (o0O0OOO0.class) {
            O000000o = O000000o(context, o0oo0o00, false);
        }
        return O000000o;
    }

    private static boolean O000000o(Context context, o0OO0o00 o0oo0o00, boolean z) {
        O00000o0 = o0oo0o00;
        try {
            String O000000o = O000000o();
            Map hashMap = new HashMap();
            hashMap.put("Content-Type", "application/x-www-form-urlencoded");
            hashMap.put("Accept-Encoding", "gzip");
            hashMap.put("Connection", "Keep-Alive");
            hashMap.put("User-Agent", O00000o0.O00000o());
            hashMap.put("X-INFO", o0O0OOOo.O00000Oo(context));
            hashMap.put("logversion", "2.1");
            hashMap.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", new Object[]{O00000o0.O00000Oo(), O00000o0.O000000o()}));
            ooooOO00 O000000o2 = ooooOO00.O000000o();
            o0OOOO0o o0oooo0o = new o0OOOO0o();
            o0oooo0o.setProxy(o0OO0OO0.O000000o(context));
            o0oooo0o.O000000o(hashMap);
            o0oooo0o.O00000Oo(O000000o(context));
            o0oooo0o.O000000o(O000000o);
            return O000000o(O000000o2.O00000Oo(o0oooo0o));
        } catch (Throwable th) {
            oO0OoOO0.O000000o(th, "Auth", "getAuth");
            return true;
        }
    }

    private static boolean O000000o(byte[] bArr) {
        if (bArr == null) {
            return true;
        }
        try {
            JSONObject jSONObject = new JSONObject(o0OOOO00.O000000o(bArr));
            if (jSONObject.has("status")) {
                int i = jSONObject.getInt("status");
                if (i == 1) {
                    O000000o = 1;
                } else if (i == 0) {
                    O000000o = 0;
                }
            }
            if (jSONObject.has("info")) {
                O00000Oo = jSONObject.getString("info");
            }
            if (O000000o == 0) {
                Log.i("AuthFailure", O00000Oo);
            }
            return O000000o == 1;
        } catch (JSONException e) {
            oO0OoOO0.O000000o(e, "Auth", "lData");
            return false;
        } catch (Throwable e2) {
            oO0OoOO0.O000000o(e2, "Auth", "lData");
            return false;
        }
    }
}
