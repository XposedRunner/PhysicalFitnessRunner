package com.ximalaya.ting.android.opensdk.auth.utils;

import android.util.Log;

public class Logger {
    public static boolean sIsLogEnable;

    public static void d(String str, String str2) {
        if (sIsLogEnable) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(stackTraceElement.getFileName());
            stringBuilder.append("(");
            stringBuilder.append(stackTraceElement.getLineNumber());
            stringBuilder.append(") ");
            stringBuilder.append(stackTraceElement.getMethodName());
            String stringBuilder2 = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder2);
            stringBuilder.append(": ");
            stringBuilder.append(str2);
            Log.d(str, stringBuilder.toString());
        }
    }

    public static void disableLog() {
        sIsLogEnable = false;
    }

    public static void e(String str, String str2) {
        if (sIsLogEnable) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(stackTraceElement.getFileName());
            stringBuilder.append("(");
            stringBuilder.append(stackTraceElement.getLineNumber());
            stringBuilder.append(") ");
            stringBuilder.append(stackTraceElement.getMethodName());
            String stringBuilder2 = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder2);
            stringBuilder.append(": ");
            stringBuilder.append(str2);
            Log.e(str, stringBuilder.toString());
        }
    }

    public static void enableLog() {
        sIsLogEnable = true;
    }

    public static String getStackTraceMsg() {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(stackTraceElement.getFileName());
        stringBuilder.append("(");
        stringBuilder.append(stackTraceElement.getLineNumber());
        stringBuilder.append(") ");
        stringBuilder.append(stackTraceElement.getMethodName());
        return stringBuilder.toString();
    }

    public static void i(String str, String str2) {
        if (sIsLogEnable) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(stackTraceElement.getFileName());
            stringBuilder.append("(");
            stringBuilder.append(stackTraceElement.getLineNumber());
            stringBuilder.append(") ");
            stringBuilder.append(stackTraceElement.getMethodName());
            String stringBuilder2 = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder2);
            stringBuilder.append(": ");
            stringBuilder.append(str2);
            Log.i(str, stringBuilder.toString());
        }
    }

    public static void v(String str, String str2) {
        if (sIsLogEnable) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(stackTraceElement.getFileName());
            stringBuilder.append("(");
            stringBuilder.append(stackTraceElement.getLineNumber());
            stringBuilder.append(") ");
            stringBuilder.append(stackTraceElement.getMethodName());
            String stringBuilder2 = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder2);
            stringBuilder.append(": ");
            stringBuilder.append(str2);
            Log.v(str, stringBuilder.toString());
        }
    }

    public static void w(String str, String str2) {
        if (sIsLogEnable) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(stackTraceElement.getFileName());
            stringBuilder.append("(");
            stringBuilder.append(stackTraceElement.getLineNumber());
            stringBuilder.append(") ");
            stringBuilder.append(stackTraceElement.getMethodName());
            String stringBuilder2 = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder2);
            stringBuilder.append(": ");
            stringBuilder.append(str2);
            Log.w(str, stringBuilder.toString());
        }
    }
}
