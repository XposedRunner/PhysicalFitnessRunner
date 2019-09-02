package cn.jiguang.c;

import android.content.Context;
import android.text.TextUtils;
import java.lang.reflect.Method;

public final class c {
    private static String a = "";

    public static String a(Context context) {
        String str = "";
        return !TextUtils.isEmpty(str) ? str : b(context);
    }

    private static String b(Context context) {
        String str = null;
        int i = -1;
        if (context != null) {
            try {
                Object systemService = context.getApplicationContext().getSystemService("country_detector");
                if (systemService != null) {
                    Method declaredMethod = systemService.getClass().getDeclaredMethod("detectCountry", new Class[0]);
                    if (declaredMethod != null) {
                        systemService = declaredMethod.invoke(systemService, new Object[0]);
                        if (systemService != null) {
                            String str2 = (String) systemService.getClass().getDeclaredMethod("getCountryIso", new Class[0]).invoke(systemService, new Object[0]);
                            try {
                                i = ((Integer) systemService.getClass().getDeclaredMethod("getSource", new Class[0]).invoke(systemService, new Object[0])).intValue();
                            } catch (Throwable unused) {
                            }
                            str = str2;
                        }
                    }
                }
            } catch (Throwable unused2) {
            }
        }
        return (i == 0 || i == 1) ? str : "";
    }
}
