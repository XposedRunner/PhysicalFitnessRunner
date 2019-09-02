package org.xutils.common.util;

import android.text.TextUtils;
import android.util.Log;
import org.xutils.x;

public class LogUtil {
    public static String customTagPrefix = "x_log";

    private LogUtil() {
    }

    public static void d(String str) {
        if (x.isDebug()) {
            Log.d(generateTag(), str);
        }
    }

    public static void d(String str, Throwable th) {
        if (x.isDebug()) {
            Log.d(generateTag(), str, th);
        }
    }

    public static void e(String str) {
        if (x.isDebug()) {
            Log.e(generateTag(), str);
        }
    }

    public static void e(String str, Throwable th) {
        if (x.isDebug()) {
            Log.e(generateTag(), str, th);
        }
    }

    private static String generateTag() {
        String className = new Throwable().getStackTrace()[2].getClassName();
        className = className.substring(className.lastIndexOf(".") + 1);
        String format = String.format("%s.%s(L:%d)", new Object[]{className, r0.getMethodName(), Integer.valueOf(r0.getLineNumber())});
        if (TextUtils.isEmpty(customTagPrefix)) {
            return format;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(customTagPrefix);
        stringBuilder.append(":");
        stringBuilder.append(format);
        return stringBuilder.toString();
    }

    public static void i(String str) {
        if (x.isDebug()) {
            Log.i(generateTag(), str);
        }
    }

    public static void i(String str, Throwable th) {
        if (x.isDebug()) {
            Log.i(generateTag(), str, th);
        }
    }

    public static void v(String str) {
        if (x.isDebug()) {
            Log.v(generateTag(), str);
        }
    }

    public static void v(String str, Throwable th) {
        if (x.isDebug()) {
            Log.v(generateTag(), str, th);
        }
    }

    public static void w(String str) {
        if (x.isDebug()) {
            Log.w(generateTag(), str);
        }
    }

    public static void w(String str, Throwable th) {
        if (x.isDebug()) {
            Log.w(generateTag(), str, th);
        }
    }

    public static void w(Throwable th) {
        if (x.isDebug()) {
            Log.w(generateTag(), th);
        }
    }

    public static void wtf(String str) {
        if (x.isDebug()) {
            Log.wtf(generateTag(), str);
        }
    }

    public static void wtf(String str, Throwable th) {
        if (x.isDebug()) {
            Log.wtf(generateTag(), str, th);
        }
    }

    public static void wtf(Throwable th) {
        if (x.isDebug()) {
            Log.wtf(generateTag(), th);
        }
    }
}
