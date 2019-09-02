package cn.jiguang.api;

import cn.jiguang.e.a;

public abstract class BaseLogger {
    private a a;

    public BaseLogger() {
        this.a = null;
        this.a = new a(getCommonTag());
    }

    public static void flushCached2File() {
    }

    public void _d(String str, String str2, Object... objArr) {
    }

    public void d(String str, String str2) {
    }

    public void d(String str, String str2, Throwable th) {
    }

    public void dd(String str, String str2) {
        this.a.a(str, str2, null);
    }

    public void dd(String str, String str2, Throwable th) {
        this.a.a(str, str2, th);
    }

    public void e(String str, String str2) {
    }

    public void e(String str, String str2, Throwable th) {
    }

    public void ee(String str, String str2) {
        this.a.d(str, str2, null);
    }

    public void ee(String str, String str2, Throwable th) {
        this.a.d(str, str2, th);
    }

    public abstract String getCommonTag();

    public void i(String str, String str2) {
    }

    public void i(String str, String str2, Throwable th) {
    }

    public void ii(String str, String str2) {
        this.a.b(str, str2, null);
    }

    public void ii(String str, String str2, Throwable th) {
        this.a.b(str, str2, th);
    }

    public void v(String str, String str2) {
    }

    public void v(String str, String str2, Throwable th) {
    }

    public void vv(String str, String str2) {
    }

    public void vv(String str, String str2, Throwable th) {
    }

    public void w(String str, String str2) {
    }

    public void w(String str, String str2, Throwable th) {
    }

    public void ww(String str, String str2) {
        this.a.c(str, str2, null);
    }

    public void ww(String str, String str2, Throwable th) {
        this.a.c(str, str2, th);
    }
}
