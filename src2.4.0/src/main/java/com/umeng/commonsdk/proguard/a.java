package com.umeng.commonsdk.proguard;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.statistics.common.ULog;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* compiled from: AliUMIDManager */
public class a {
    private static Object a = new Object();
    private static String b;

    public static void a(Context context) {
        try {
            Class[] clsArr = new Class[]{Context.class};
            try {
                Class cls = Class.forName("com.wireless.security.securityenv.sdk.SecurityEnvSDK");
                if (cls != null) {
                    Constructor constructor = cls.getConstructor(clsArr);
                    if (constructor != null) {
                        Object newInstance = constructor.newInstance(new Object[]{context});
                        if (newInstance != null) {
                            Method declaredMethod = cls.getDeclaredMethod("initSync", new Class[0]);
                            if (declaredMethod != null) {
                                declaredMethod.setAccessible(true);
                                declaredMethod.invoke(newInstance, new Object[0]);
                            }
                            declaredMethod = cls.getDeclaredMethod("getToken", new Class[0]);
                            if (declaredMethod != null) {
                                declaredMethod.setAccessible(true);
                                String str = (String) declaredMethod.invoke(newInstance, new Object[0]);
                                if (!TextUtils.isEmpty(str)) {
                                    synchronized (a) {
                                        b = str;
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception unused) {
            }
        } catch (Exception e) {
            Object[] objArr = new Object[1];
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("e is ");
            stringBuilder.append(e);
            objArr[0] = stringBuilder.toString();
            ULog.e("internal", objArr);
        }
    }

    public static String b(Context context) {
        String str;
        synchronized (a) {
            str = b;
        }
        return str;
    }
}
