package cn.jiguang.f;

public final class a {
    public static Object a(Class<?> cls, String str, Object[] objArr, Class[] clsArr) {
        a(cls);
        a(clsArr, objArr);
        return cls.getMethod(str, clsArr).invoke(cls, objArr);
    }

    public static <T> T a(Class<T> cls, Object[] objArr, Class<?>[] clsArr) {
        a(cls);
        a(clsArr, objArr);
        return cls.getConstructor(clsArr).newInstance(objArr);
    }

    private static void a(Object obj) {
        if (obj == null) {
            throw new Exception("owner can not be null");
        }
    }

    private static void a(Class<?>[] clsArr, Object[] objArr) {
        int i = 0;
        int length = objArr != null ? objArr.length : 0;
        if (clsArr != null) {
            i = clsArr.length;
        }
        if (length != i) {
            throw new Exception("argClasses' size is not equal to args' size");
        }
    }
}
