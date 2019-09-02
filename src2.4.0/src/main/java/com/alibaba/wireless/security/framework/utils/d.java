package com.alibaba.wireless.security.framework.utils;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class d {
    private final Object a;
    private final boolean b = false;

    private static class a {
        private a() {
        }
    }

    private d(Object obj) {
        this.a = obj;
    }

    public static d a(Object obj) {
        return new d(obj);
    }

    private static d a(Method method, Object obj, Object... objArr) throws e {
        try {
            a((AccessibleObject) method);
            if (method.getReturnType() != Void.TYPE) {
                return a(method.invoke(obj, objArr));
            }
            method.invoke(obj, objArr);
            return a(obj);
        } catch (Exception e) {
            throw new e(e);
        }
    }

    public static Class<?> a(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        if (cls.isPrimitive()) {
            if (Boolean.TYPE == cls) {
                return Boolean.class;
            }
            if (Integer.TYPE == cls) {
                return Integer.class;
            }
            if (Long.TYPE == cls) {
                return Long.class;
            }
            if (Short.TYPE == cls) {
                return Short.class;
            }
            if (Byte.TYPE == cls) {
                return Byte.class;
            }
            if (Double.TYPE == cls) {
                return Double.class;
            }
            if (Float.TYPE == cls) {
                return Float.class;
            }
            if (Character.TYPE == cls) {
                return Character.class;
            }
            if (Void.TYPE == cls) {
                cls = Void.class;
            }
        }
        return cls;
    }

    public static <T extends AccessibleObject> T a(T t) {
        if (t == null) {
            return null;
        }
        if (t instanceof Member) {
            Member member = (Member) t;
            if (Modifier.isPublic(member.getModifiers()) && Modifier.isPublic(member.getDeclaringClass().getModifiers())) {
                return t;
            }
        }
        if (!t.isAccessible()) {
            t.setAccessible(true);
        }
        return t;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0009 */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:4|5|12|6) */
    /* JADX WARNING: Missing block: B:6:0x000d, code skipped:
            return r0.getDeclaredMethod(r3, r4);
     */
    /* JADX WARNING: Missing block: B:7:0x000e, code skipped:
            r0 = r0.getSuperclass();
     */
    /* JADX WARNING: Missing block: B:9:0x0012, code skipped:
            if (r0 != null) goto L_0x0009;
     */
    /* JADX WARNING: Missing block: B:11:0x0019, code skipped:
            throw new java.lang.NoSuchMethodException();
     */
    private java.lang.reflect.Method a(java.lang.String r3, java.lang.Class<?>[] r4) throws java.lang.NoSuchMethodException {
        /*
        r2 = this;
        r0 = r2.b();
        r1 = r0.getMethod(r3, r4);	 Catch:{ NoSuchMethodException -> 0x0009 }
        return r1;
    L_0x0009:
        r1 = r0.getDeclaredMethod(r3, r4);	 Catch:{ NoSuchMethodException -> 0x000e }
        return r1;
    L_0x000e:
        r0 = r0.getSuperclass();
        if (r0 != 0) goto L_0x0009;
    L_0x0014:
        r3 = new java.lang.NoSuchMethodException;
        r3.<init>();
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.utils.d.a(java.lang.String, java.lang.Class[]):java.lang.reflect.Method");
    }

    private boolean a(Method method, String str, Class<?>[] clsArr) {
        return method.getName().equals(str) && a(method.getParameterTypes(), (Class[]) clsArr);
    }

    private boolean a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        int i = 0;
        while (i < clsArr2.length) {
            if (clsArr2[i] != a.class && !a(clsArr[i]).isAssignableFrom(a(clsArr2[i]))) {
                return false;
            }
            i++;
        }
        return true;
    }

    private static Class<?>[] a(Object... objArr) {
        int i = 0;
        if (objArr == null) {
            return new Class[0];
        }
        Class[] clsArr = new Class[objArr.length];
        while (i < objArr.length) {
            Object obj = objArr[i];
            clsArr[i] = obj == null ? a.class : obj.getClass();
            i++;
        }
        return clsArr;
    }

    private Method b(String str, Class<?>[] clsArr) throws NoSuchMethodException {
        Class b = b();
        for (Method method : b.getMethods()) {
            if (a(method, str, (Class[]) clsArr)) {
                return method;
            }
        }
        do {
            for (Method method2 : b.getDeclaredMethods()) {
                if (a(method2, str, (Class[]) clsArr)) {
                    return method2;
                }
            }
            b = b.getSuperclass();
        } while (b != null);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("No similar method ");
        stringBuilder.append(str);
        stringBuilder.append(" with params ");
        stringBuilder.append(Arrays.toString(clsArr));
        stringBuilder.append(" could be found on type ");
        stringBuilder.append(b());
        stringBuilder.append(".");
        throw new NoSuchMethodException(stringBuilder.toString());
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x000f */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:4|5|6) */
    /* JADX WARNING: Missing block: B:6:0x0019, code skipped:
            return a(b(r4, r0), r3.a, r5);
     */
    /* JADX WARNING: Missing block: B:7:0x001a, code skipped:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:9:0x0020, code skipped:
            throw new com.alibaba.wireless.security.framework.utils.e(r4);
     */
    public com.alibaba.wireless.security.framework.utils.d a(java.lang.String r4, java.lang.Object... r5) throws com.alibaba.wireless.security.framework.utils.e {
        /*
        r3 = this;
        r0 = a(r5);
        r1 = r3.a(r4, r0);	 Catch:{ NoSuchMethodException -> 0x000f }
        r2 = r3.a;	 Catch:{ NoSuchMethodException -> 0x000f }
        r1 = a(r1, r2, r5);	 Catch:{ NoSuchMethodException -> 0x000f }
        return r1;
    L_0x000f:
        r4 = r3.b(r4, r0);	 Catch:{ NoSuchMethodException -> 0x001a }
        r0 = r3.a;	 Catch:{ NoSuchMethodException -> 0x001a }
        r4 = a(r4, r0, r5);	 Catch:{ NoSuchMethodException -> 0x001a }
        return r4;
    L_0x001a:
        r4 = move-exception;
        r5 = new com.alibaba.wireless.security.framework.utils.e;
        r5.<init>(r4);
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.utils.d.a(java.lang.String, java.lang.Object[]):com.alibaba.wireless.security.framework.utils.d");
    }

    public <T> T a() {
        return this.a;
    }

    public Class<?> b() {
        return this.b ? (Class) this.a : this.a.getClass();
    }

    public boolean equals(Object obj) {
        return obj instanceof d ? this.a.equals(((d) obj).a()) : false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return this.a.toString();
    }
}
