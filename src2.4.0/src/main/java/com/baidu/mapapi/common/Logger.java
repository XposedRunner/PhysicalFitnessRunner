package com.baidu.mapapi.common;

import android.util.Log;

public class Logger {
    public static boolean debugEnable() {
        return false;
    }

    public static void logD(String str, String str2) {
    }

    public static void logE(String str, String str2) {
        Log.e(str, str2);
    }

    public static void logI(String str, String str2) {
    }

    public static void logV(String str, String str2) {
    }

    public static void logW(String str, String str2) {
    }
}
