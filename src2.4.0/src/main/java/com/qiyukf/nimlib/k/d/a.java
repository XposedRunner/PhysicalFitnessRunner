package com.qiyukf.nimlib.k.d;

import android.text.TextUtils;
import java.lang.reflect.Method;

public final class a {
    public static Object a(Object obj, String str) {
        if (obj == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Method method = obj.getClass().getMethod(str, null);
            method.setAccessible(true);
            return method.invoke(obj, null);
        } catch (NoSuchMethodException unused) {
            StringBuilder stringBuilder = new StringBuilder("method ");
            stringBuilder.append(str);
            stringBuilder.append(" not found in ");
            stringBuilder.append(obj.getClass().getName());
            com.qiyukf.basesdk.a.a.a("reflect", stringBuilder.toString());
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
