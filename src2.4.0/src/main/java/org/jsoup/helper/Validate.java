package org.jsoup.helper;

public final class Validate {
    private Validate() {
    }

    public static void O000000o(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Object must not be null");
        }
    }

    public static void O000000o(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void O000000o(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("String must not be empty");
        }
    }

    public static void O000000o(String str, String str2) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static void O000000o(boolean z) {
        if (!z) {
            throw new IllegalArgumentException("Must be true");
        }
    }

    public static void O000000o(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void O000000o(Object[] objArr) {
        O000000o(objArr, "Array must not contain any null objects");
    }

    public static void O000000o(Object[] objArr, String str) {
        for (Object obj : objArr) {
            if (obj == null) {
                throw new IllegalArgumentException(str);
            }
        }
    }

    public static void O00000Oo(String str) {
        throw new IllegalArgumentException(str);
    }

    public static void O00000Oo(boolean z) {
        if (z) {
            throw new IllegalArgumentException("Must be false");
        }
    }

    public static void O00000Oo(boolean z, String str) {
        if (z) {
            throw new IllegalArgumentException(str);
        }
    }
}
