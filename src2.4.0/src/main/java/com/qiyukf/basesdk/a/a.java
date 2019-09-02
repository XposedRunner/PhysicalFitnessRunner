package com.qiyukf.basesdk.a;

import android.text.TextUtils;
import android.util.Log;
import cn.jiguang.net.HttpUtils;

public final class a {
    private static c a = null;
    private static int b = 3;

    public static c a() {
        return a;
    }

    private static void a(int i, String str, String str2, Throwable th) {
        if (i >= b) {
            long currentTimeMillis = System.currentTimeMillis();
            long id = Thread.currentThread().getId();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(id);
            stringBuilder.append(HttpUtils.PATHS_SEPARATOR);
            stringBuilder.append(str2);
            stringBuilder.append(10);
            stringBuilder.append(Log.getStackTraceString(th));
            Log.println(i, str, stringBuilder.toString());
            try {
                if (a != null) {
                    a.a(str, currentTimeMillis, str2, th);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void a(String str, String str2) {
        a(4, str, str2, null);
    }

    public static void a(String str, String str2, int i, boolean z) {
        b = i;
        if (!TextUtils.isEmpty(str)) {
            if (a == null) {
                a = new c(str, str2, z);
                return;
            }
            a.a(str);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        a(4, str, str2, th);
    }

    public static void b(String str, String str2) {
        a(2, str, str2, null);
    }

    public static void b(String str, String str2, Throwable th) {
        a(6, str, str2, th);
    }

    public static void c(String str, String str2) {
        b(str, str2, null);
    }

    public static void c(String str, String str2, Throwable th) {
        a(3, str, str2, th);
    }

    public static void d(String str, String str2) {
        a(3, str, str2, null);
    }

    public static void d(String str, String str2, Throwable th) {
        a(5, str, str2, th);
    }

    public static void e(String str, String str2) {
        a(5, str, str2, null);
    }
}
