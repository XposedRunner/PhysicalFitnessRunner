package com.loc;

import android.content.Context;
import android.text.TextUtils;
import com.qiyukf.nimlib.sdk.msg.MsgService;
import com.tencent.stat.DeviceInfo;
import java.util.HashMap;
import java.util.Map;

/* compiled from: GeoFenceNetManager */
public final class O000o00 {
    O00O0o O000000o = null;

    public O000o00(Context context) {
        try {
            OO0OO0o.O000000o().O000000o(context);
        } catch (Throwable unused) {
        }
        this.O000000o = O00O0o.O000000o();
    }

    private String O000000o(Context context, String str, Map<String, String> map) {
        try {
            byte[] O000000o;
            Map hashMap = new HashMap(16);
            O0Oo000 o0Oo000 = new O0Oo000();
            hashMap.clear();
            hashMap.put("Content-Type", "application/x-www-form-urlencoded");
            hashMap.put("Connection", "Keep-Alive");
            hashMap.put("User-Agent", "AMAP_Location_SDK_Android 4.6.0");
            String O000000o2 = OO0O0O.O000000o();
            String O000000o3 = OO0O0O.O000000o(context, O000000o2, OO0o000.O00000Oo((Map) map));
            map.put(DeviceInfo.TAG_TIMESTAMPS, O000000o2);
            map.put("scode", O000000o3);
            o0Oo000.O00000Oo(map);
            o0Oo000.O000000o(hashMap);
            o0Oo000.O000000o(str);
            o0Oo000.O000000o(OO0OOo0.O000000o(context));
            o0Oo000.O000000o(O0o0000.O00000oo);
            o0Oo000.O00000Oo(O0o0000.O00000oo);
            O00O0o o00O0o;
            if (OO000OO.O0000Oo(context)) {
                o0Oo000.O000000o(str.replace("http:", "https:"));
                o00O0o = this.O000000o;
                O000000o = O00O0o.O000000o(o0Oo000);
            } else {
                o00O0o = this.O000000o;
                O000000o = O00O0o.O00000Oo(o0Oo000);
            }
            return new String(O000000o, "utf-8");
        } catch (Throwable unused) {
        }
        return null;
    }

    private static Map<String, String> O00000Oo(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        HashMap hashMap = new HashMap(16);
        hashMap.put("key", OO00o00.O00000oo(context));
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("keywords", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("types", str2);
        }
        if (!(TextUtils.isEmpty(str5) || TextUtils.isEmpty(str6))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str6);
            stringBuilder.append(",");
            stringBuilder.append(str5);
            hashMap.put("location", stringBuilder.toString());
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("city", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("offset", str4);
        }
        if (!TextUtils.isEmpty(str7)) {
            hashMap.put("radius", str7);
        }
        return hashMap;
    }

    public final String O000000o(Context context, String str, String str2) {
        Map O00000Oo = O00000Oo(context, str2, null, null, null, null, null, null);
        O00000Oo.put("extensions", MsgService.MSG_CHATTING_ACCOUNT_ALL);
        return O000000o(context, str, O00000Oo);
    }

    public final String O000000o(Context context, String str, String str2, String str3, String str4, String str5) {
        Map O00000Oo = O00000Oo(context, str2, str3, str4, str5, null, null, null);
        O00000Oo.put("children", "1");
        O00000Oo.put("page", "1");
        O00000Oo.put("extensions", "base");
        return O000000o(context, str, O00000Oo);
    }

    public final String O000000o(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Map O00000Oo = O00000Oo(context, str2, str3, null, str4, str5, str6, str7);
        O00000Oo.put("children", "1");
        O00000Oo.put("page", "1");
        O00000Oo.put("extensions", "base");
        return O000000o(context, str, O00000Oo);
    }
}
