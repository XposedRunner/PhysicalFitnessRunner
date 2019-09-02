package cn.jpush.android.api;

import cn.jpush.android.d.f;

public class ThirdLogger {
    public static void d(String str, String str2) {
    }

    public static void d(String str, String str2, Throwable th) {
    }

    public static void dd(String str, String str2) {
        f.a(str, str2);
    }

    public static void dd(String str, String str2, Throwable th) {
        f.a(str, str2, th);
    }

    public static void e(String str, String str2) {
    }

    public static void e(String str, String str2, Throwable th) {
    }

    public static void ee(String str, String str2) {
        f.d(str, str2);
    }

    public static void ee(String str, String str2, Throwable th) {
        f.d(str, str2, th);
    }

    public static void i(String str, String str2) {
    }

    public static void i(String str, String str2, Throwable th) {
    }

    public static void ii(String str, String str2) {
        f.b(str, str2);
    }

    public static void ii(String str, String str2, Throwable th) {
        f.b(str, str2, th);
    }

    public static void v(String str, String str2) {
    }

    public static void v(String str, String str2, Throwable th) {
    }

    public static void vv(String str, String str2) {
    }

    public static void vv(String str, String str2, Throwable th) {
    }

    public static void w(String str, String str2) {
    }

    public static void w(String str, String str2, Throwable th) {
    }

    public static void ww(String str, String str2) {
        f.c(str, str2);
    }

    public static void ww(String str, String str2, Throwable th) {
        f.c(str, str2, th);
    }
}
