package com.ximalaya.ting.android.opensdk.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodUtil {
    public static Object invokeMethod(Object obj, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Class[] nullToEmpty = BaseUtil.nullToEmpty(clsArr);
        objArr = BaseUtil.nullToEmpty(objArr);
        Method method = obj.getClass().getMethod(str, nullToEmpty);
        if (method != null) {
            return method.invoke(obj, objArr);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("No such accessible method: ");
        stringBuilder.append(str);
        stringBuilder.append("() on object: ");
        stringBuilder.append(obj.getClass().getName());
        throw new NoSuchMethodException(stringBuilder.toString());
    }

    public static Object invokeStaticMethod(Class cls, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if (cls == null) {
            return null;
        }
        Class[] nullToEmpty = BaseUtil.nullToEmpty(clsArr);
        objArr = BaseUtil.nullToEmpty(objArr);
        Method method = cls.getMethod(str, nullToEmpty);
        if (method != null) {
            return method.invoke(null, objArr);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("No such accessible method: ");
        stringBuilder.append(str);
        stringBuilder.append("() on object: ");
        stringBuilder.append(cls.getName());
        throw new NoSuchMethodException(stringBuilder.toString());
    }
}
