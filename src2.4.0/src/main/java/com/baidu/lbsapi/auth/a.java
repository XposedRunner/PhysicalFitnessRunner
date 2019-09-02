package com.baidu.lbsapi.auth;

import android.util.Log;

class a {
    public static boolean a = false;
    private static String b = "BaiduApiAuth";

    public static String a() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[2];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(stackTraceElement.getFileName());
        stringBuilder.append("[");
        stringBuilder.append(stackTraceElement.getLineNumber());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static void a(String str) {
        if (a && Thread.currentThread().getStackTrace().length != 0) {
            String str2 = b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a());
            stringBuilder.append(";");
            stringBuilder.append(str);
            Log.d(str2, stringBuilder.toString());
        }
    }

    public static void b(String str) {
        if (Thread.currentThread().getStackTrace().length != 0) {
            Log.i(b, str);
        }
    }

    public static void c(String str) {
        if (a && Thread.currentThread().getStackTrace().length != 0) {
            String str2 = b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a());
            stringBuilder.append(";");
            stringBuilder.append(str);
            Log.e(str2, stringBuilder.toString());
        }
    }
}
