package cn.jiguang.e;

import cn.jiguang.api.BaseLogger;

public final class c {
    private static BaseLogger a = new b();

    public static void a(String str, String str2) {
        a.dd(str, str2);
    }

    public static void a(String str, String str2, Throwable th) {
        a.ww(str, str2, th);
    }

    public static void b(String str, String str2) {
        a.ii(str, str2);
    }

    public static void b(String str, String str2, Throwable th) {
        a.ee(str, str2, th);
    }

    public static void c(String str, String str2) {
        a.ww(str, str2);
    }

    public static void c(String str, String str2, Throwable th) {
        b(str, str2, th);
    }

    public static void d(String str, String str2) {
        a.ee(str, str2);
    }
}
