package com.geetest.mobinfo;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.bangcle.andJni.JniLib1557756502;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* compiled from: GtMobCardUtils */
public class q {
    private static Pattern a = Pattern.compile("[0-9]*");

    private static String a(TelephonyManager telephonyManager, String str, int i) {
        try {
            Object invoke = Class.forName(telephonyManager.getClass().getName()).getMethod(str, new Class[]{Integer.TYPE}).invoke(telephonyManager, new Object[]{Integer.valueOf(i)});
            return invoke != null ? invoke.toString() : null;
        } catch (Exception unused) {
            throw new Exception(str);
        }
    }

    private static String a(TelephonyManager telephonyManager, boolean z) {
        return (String) JniLib1557756502.cL(telephonyManager, Boolean.valueOf(z), Integer.valueOf(153));
    }

    private static String a(String str, String str2, boolean z) {
        return (String) JniLib1557756502.cL(str, str2, Boolean.valueOf(z), Integer.valueOf(154));
    }

    public static JSONObject a(Context context) {
        return (JSONObject) JniLib1557756502.cL(context, Integer.valueOf(155));
    }

    private static boolean a(String str) {
        return JniLib1557756502.cZ(str, Integer.valueOf(156));
    }
}
