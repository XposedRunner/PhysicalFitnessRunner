package com.qiyukf.nimlib.e;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public final class g {
    private final Map<Class<?>, Object> a = new HashMap();

    public final <T> T a(Class<T> cls) {
        if (cls.isInterface()) {
            T t;
            synchronized (this.a) {
                t = this.a.get(cls);
                if (t == null) {
                    t = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new e());
                    if (t != null) {
                        this.a.put(cls, t);
                    }
                }
            }
            return t;
        }
        StringBuilder stringBuilder = new StringBuilder("Only accept interface: ");
        stringBuilder.append(cls);
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}
