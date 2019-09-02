package com.baidu.mapsdkplatform.comapi.synchronization.d;

import android.util.Log;

public final class a {
    private static boolean a = true;

    private static String a() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[2];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(stackTraceElement.getFileName());
        stringBuilder.append(": Line ");
        stringBuilder.append(stackTraceElement.getLineNumber());
        return stringBuilder.toString();
    }

    public static void a(String str, String str2) {
        if (a) {
            Log.d(str, str2);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (a) {
            Log.e(str, str2, th);
        }
    }

    public static void a(boolean z) {
        a = z;
    }

    private static String b() {
        return new Throwable().getStackTrace()[2].getMethodName();
    }

    public static void b(String str, String str2) {
        if (a) {
            Log.e(str, str2);
        }
    }

    public static void c(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("-");
        stringBuilder.append(b());
        stringBuilder.append("-");
        stringBuilder.append(a());
        Log.d(stringBuilder.toString(), str2);
    }
}
