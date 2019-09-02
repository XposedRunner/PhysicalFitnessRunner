package cn.jpush.android.d;

import cn.jiguang.api.BaseLogger;

public final class f {
    private static BaseLogger a = new e();

    public static void a(String str, String str2) {
        a.dd(str, str2);
    }

    public static void a(String str, String str2, Throwable th) {
        a.dd(str, str2, th);
    }

    public static void b(String str, String str2) {
        a.ii(str, str2);
    }

    public static void b(String str, String str2, Throwable th) {
        a.ii(str, str2, th);
    }

    public static void c(String str, String str2) {
        a.ww(str, str2);
    }

    public static void c(String str, String str2, Throwable th) {
        a.ww(str, str2, th);
    }

    public static void d(String str, String str2) {
        a.ee(str, str2);
    }

    public static void d(String str, String str2, Throwable th) {
        a.ee(str, str2, th);
    }
}
