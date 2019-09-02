package com.qiyukf.nimlib.e;

import cn.jiguang.net.HttpUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public final class e implements InvocationHandler {

    private static class a {
        private static final Map<Class, Object> a;

        static {
            HashMap hashMap = new HashMap(7);
            a = hashMap;
            hashMap.put(Integer.TYPE, Integer.valueOf(0));
            a.put(Long.TYPE, Long.valueOf(0));
            a.put(Boolean.TYPE, Boolean.valueOf(false));
            a.put(Byte.TYPE, Byte.valueOf((byte) 0));
            a.put(Float.TYPE, Float.valueOf(0.0f));
            a.put(Double.TYPE, Double.valueOf(0.0d));
            a.put(Character.TYPE, Character.valueOf(0));
        }

        static /* synthetic */ Object a(Class cls, Object obj) {
            return (obj == null && a.containsKey(cls)) ? a.get(cls) : obj;
        }
    }

    public final Object invoke(Object obj, Method method, Object[] objArr) {
        boolean z = false;
        boolean z2 = (method.getReturnType().equals(Void.TYPE) || method.getReturnType().equals(Void.class)) ? false : true;
        if (z2 && !method.getReturnType().isAssignableFrom(k.class)) {
            z = true;
        }
        i iVar = new i();
        i a = iVar.a(objArr);
        String simpleName = method.getDeclaringClass().getSimpleName();
        b bVar = a.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(simpleName);
        stringBuilder.append(HttpUtils.PATHS_SEPARATOR);
        stringBuilder.append(method.getName());
        bVar.a = stringBuilder.toString();
        a.b(z2).a(z);
        obj = a.a(iVar);
        return z ? a.a(method.getReturnType(), obj) : obj;
    }
}
