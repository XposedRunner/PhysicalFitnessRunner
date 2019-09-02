package com.geetest.mobinfo;

import android.content.Context;
import com.bangcle.andJni.JniLib1557756502;
import java.lang.reflect.Field;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: XposedHookUtils */
public class aa {
    private static String a(Context context) {
        return (String) JniLib1557756502.cL(context, Integer.valueOf(106));
    }

    public static JSONObject a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        return (JSONObject) JniLib1557756502.cL(context, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, Integer.valueOf(107));
    }

    private static boolean a(Object obj, String str, z zVar, String str2) {
        try {
            Field declaredField = obj.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            Map map = (Map) declaredField.get(obj);
            if (!map.isEmpty()) {
                for (Object next : map.keySet()) {
                    if (next.toString().contains(str2)) {
                        zVar.a(true);
                    }
                    if (next.toString().toLowerCase().contains("getDeviceId".toLowerCase())) {
                        zVar.b(true);
                    }
                    if (next.toString().toLowerCase().contains("SERIAL".toLowerCase())) {
                        zVar.c(true);
                    }
                    if (next.toString().toLowerCase().contains("getSSID".toLowerCase())) {
                        zVar.d(true);
                    }
                    if (next.toString().toLowerCase().contains("getMacAddress".toLowerCase())) {
                        zVar.e(true);
                    }
                    if (next.toString().toLowerCase().contains("BluetoothAdapter#getAddress".toLowerCase())) {
                        zVar.f(true);
                    }
                    if (next.toString().toLowerCase().contains("Secure#getString".toLowerCase())) {
                        zVar.g(true);
                    }
                    if (next.toString().toLowerCase().contains("getSubscriberId".toLowerCase())) {
                        zVar.h(true);
                    }
                    if (next.toString().toLowerCase().contains("getLatitude".toLowerCase())) {
                        zVar.i(true);
                    }
                    if (next.toString().toLowerCase().contains("getLongitude".toLowerCase())) {
                        zVar.j(true);
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
