package com.taobao.wireless.security.adapter.common;

public class a {
    public static boolean a(String... strArr) {
        for (Object obj : strArr) {
            if (obj == null || "".equals(obj)) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(String... strArr) {
        return a(strArr) ^ 1;
    }
}
