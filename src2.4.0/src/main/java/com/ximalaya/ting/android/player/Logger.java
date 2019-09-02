package com.ximalaya.ting.android.player;

import android.os.Environment;
import android.os.Process;
import android.util.Log;
import com.ximalaya.ting.android.opensdk.player.appnotification.XmNotificationCreater;
import java.io.File;
import java.io.PrintStream;

public class Logger {
    public static final String JSON_ERROR = "解析json异常";
    private static final int LOG_LEVEL = 0;
    public static boolean isJavaLog;

    public static void d(String str, String str2) {
        if (isJavaLog) {
            printJava(str, str2);
            return;
        }
        if (str2 != null && isLoggable(str, 3)) {
            Log.d(str, str2);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (str2 != null && isLoggable(str, 3)) {
            Log.d(str, str2, th);
        }
    }

    public static void e(Exception exception) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("解析json异常");
        stringBuilder.append(exception.getMessage());
        stringBuilder.append(getLineInfo());
        e("解析json异常", stringBuilder.toString());
    }

    public static void e(String str, String str2) {
        if (str2 != null && isLoggable(str, 6)) {
            Log.e(str, str2);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (str2 != null && isLoggable(str, 6)) {
            Log.e(str, str2, th);
        }
    }

    public static String getLineInfo() {
        if (!XMediaPlayerConstants.isDebug) {
            return "";
        }
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("@");
        stringBuilder.append(stackTraceElement.getFileName());
        stringBuilder.append(": Line ");
        stringBuilder.append(stackTraceElement.getLineNumber());
        return stringBuilder.toString();
    }

    public static File getLogFilePath() {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return null;
        }
        File file = new File("/sdcard/ting/errorLog/infor.log");
        if (!file.getParentFile().getParentFile().exists()) {
            file.getParentFile().getParentFile().mkdir();
        }
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdir();
        }
        return file;
    }

    public static void i(String str, String str2) {
        if (str2 != null && isLoggable(str, 4)) {
            Log.i(str, str2);
        }
    }

    public static void i(String str, String str2, Throwable th) {
        if (str2 != null && isLoggable(str, 4)) {
            Log.i(str, str2, th);
        }
    }

    public static boolean isLoggable(String str, int i) {
        boolean z = false;
        if (!XMediaPlayerConstants.isDebug) {
            return false;
        }
        if (i >= 0) {
            z = true;
        }
        return z;
    }

    public static void log(Object obj) {
        if (isJavaLog) {
            System.out.println(obj);
            return;
        }
        if (XMediaPlayerConstants.isDebug) {
            String str = XmNotificationCreater.IMG_NOTIFYICON_DRAWABLE_S;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(obj);
            stringBuilder.append("");
            Log.i(str, stringBuilder.toString());
        }
    }

    public static void log(String str, Object obj) {
        if (XMediaPlayerConstants.isDebug && obj != null && !str.equals("dl_mp3")) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("JTid(");
            stringBuilder.append(Long.toString(Thread.currentThread().getId()));
            stringBuilder.append(")STid(");
            stringBuilder.append(Process.myTid());
            stringBuilder.append(")SPid(");
            stringBuilder.append(Process.myPid());
            stringBuilder.append(")");
            stringBuilder.append(obj);
            Log.i(str, stringBuilder.toString());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0028  */
    public static void logToSd(java.lang.String r5) {
        /*
        r0 = com.ximalaya.ting.android.player.XMediaPlayerConstants.isDebug;
        if (r0 == 0) goto L_0x0031;
    L_0x0004:
        r0 = getLogFilePath();
        if (r0 != 0) goto L_0x000b;
    L_0x000a:
        return;
    L_0x000b:
        r1 = 0;
        r2 = new java.io.PrintWriter;	 Catch:{ Throwable -> 0x002c, all -> 0x0025 }
        r3 = new java.io.FileWriter;	 Catch:{ Throwable -> 0x002c, all -> 0x0025 }
        r4 = 1;
        r3.<init>(r0, r4);	 Catch:{ Throwable -> 0x002c, all -> 0x0025 }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x002c, all -> 0x0025 }
        r2.println(r5);	 Catch:{ Throwable -> 0x0023, all -> 0x0020 }
        if (r2 == 0) goto L_0x0031;
    L_0x001c:
        r2.close();
        goto L_0x0031;
    L_0x0020:
        r5 = move-exception;
        r1 = r2;
        goto L_0x0026;
    L_0x0023:
        r1 = r2;
        goto L_0x002c;
    L_0x0025:
        r5 = move-exception;
    L_0x0026:
        if (r1 == 0) goto L_0x002b;
    L_0x0028:
        r1.close();
    L_0x002b:
        throw r5;
    L_0x002c:
        if (r1 == 0) goto L_0x0031;
    L_0x002e:
        r1.close();
    L_0x0031:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ximalaya.ting.android.player.Logger.logToSd(java.lang.String):void");
    }

    public static void printJava(String str, String str2) {
        PrintStream printStream = System.out;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("  ");
        stringBuilder.append(str2);
        printStream.println(stringBuilder.toString());
    }

    public static void throwRuntimeException(Object obj) {
        if (XMediaPlayerConstants.isDebug) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("出现异常：");
            stringBuilder.append(obj);
            throw new RuntimeException(stringBuilder.toString());
        }
    }

    public static void v(String str, String str2) {
        if (str2 != null && isLoggable(str, 2)) {
            Log.v(str, str2);
        }
    }

    public static void v(String str, String str2, Throwable th) {
        if (str2 != null && isLoggable(str, 2)) {
            Log.v(str, str2, th);
        }
    }

    public static void w(String str, String str2) {
        if (str2 != null && isLoggable(str, 5)) {
            Log.w(str, str2);
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (str2 != null && isLoggable(str, 5)) {
            Log.w(str, str2, th);
        }
    }

    public static void w(String str, Throwable th) {
        if (th != null && isLoggable(str, 5)) {
            Log.w(str, th);
        }
    }
}
