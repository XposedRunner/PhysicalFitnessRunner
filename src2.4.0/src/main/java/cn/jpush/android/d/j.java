package cn.jpush.android.d;

import java.lang.reflect.Method;

public final class j {
    public static Object a(Object obj, String str, Class[] clsArr, Object[] objArr) {
        if (objArr.length != clsArr.length) {
            throw new IllegalArgumentException("argClasses' size is not equal to args' size");
        }
        Exception e;
        Method method = obj.getClass().getMethod(str, clsArr);
        boolean isAccessible = method.isAccessible();
        if (!isAccessible) {
            method.setAccessible(true);
        }
        Object obj2 = null;
        try {
            obj2 = method.invoke(obj, objArr);
            e = null;
        } catch (Exception e2) {
            e = e2;
        }
        if (!isAccessible) {
            method.setAccessible(false);
        }
        if (e == null) {
            return obj2;
        }
        throw e;
    }
}
