package com.umeng.commonsdk.proguard;

import java.lang.reflect.InvocationTargetException;

/* compiled from: TEnumHelper */
public class o {
    public static n a(Class<? extends n> cls, int i) {
        try {
            return (n) cls.getMethod("findByValue", new Class[]{Integer.TYPE}).invoke(null, new Object[]{Integer.valueOf(i)});
        } catch (NoSuchMethodException unused) {
            return null;
        } catch (IllegalAccessException unused2) {
            return null;
        } catch (InvocationTargetException unused3) {
            return null;
        }
    }
}
