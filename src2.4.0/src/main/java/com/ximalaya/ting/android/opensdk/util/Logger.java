package com.ximalaya.ting.android.opensdk.util;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.ximalaya.ting.android.opensdk.constants.ConstantsOpenSdk;
import com.ximalaya.ting.android.opensdk.player.appnotification.XmNotificationCreater;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Logger {
    public static String CACHE_DIR = "";
    public static String ERROR_LOG_PATH = null;
    public static final String JSON_ERROR = "解析json异常";
    private static int LOG_LEVEL = 0;
    public static String LOG_UPLOAD_FILE = "upload_log_file";
    public static boolean UPLOADING;
    static Map<String, String> map = new HashMap();
    private static long nowTime = System.currentTimeMillis();

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ba A:{SYNTHETIC, Splitter:B:46:0x00ba} */
    /* JADX WARNING: Removed duplicated region for block: B:77:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00c4 A:{SYNTHETIC, Splitter:B:51:0x00c4} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ba A:{SYNTHETIC, Splitter:B:46:0x00ba} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00c4 A:{SYNTHETIC, Splitter:B:51:0x00c4} */
    /* JADX WARNING: Removed duplicated region for block: B:77:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00d0 A:{SYNTHETIC, Splitter:B:57:0x00d0} */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00da A:{SYNTHETIC, Splitter:B:62:0x00da} */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00d0 A:{SYNTHETIC, Splitter:B:57:0x00d0} */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00da A:{SYNTHETIC, Splitter:B:62:0x00da} */
    static {
        /*
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = android.os.Environment.getExternalStorageDirectory();
        r0.append(r1);
        r1 = "/ting/errorLog/infor.log";
        r0.append(r1);
        r0 = r0.toString();
        ERROR_LOG_PATH = r0;
        r0 = new java.util.HashMap;
        r0.<init>();
        map = r0;
        r0 = java.lang.System.currentTimeMillis();
        nowTime = r0;
        r0 = map;
        r0.clear();
        r0 = 0;
        r1 = android.os.Environment.getExternalStorageState();	 Catch:{ Exception -> 0x002f }
        goto L_0x0034;
    L_0x002f:
        r1 = move-exception;
        r1.printStackTrace();
        r1 = r0;
    L_0x0034:
        r2 = "mounted";
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x00e3;
    L_0x003c:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = android.os.Environment.getExternalStorageDirectory();
        r1.append(r2);
        r2 = "/ting/config.ini";
        r1.append(r2);
        r1 = r1.toString();
        r2 = android.text.TextUtils.isEmpty(r1);
        if (r2 != 0) goto L_0x00e3;
    L_0x0057:
        r2 = new java.io.File;
        r2.<init>(r1);
        r2 = r2.exists();
        if (r2 == 0) goto L_0x00e3;
    L_0x0062:
        r2 = new java.io.FileReader;	 Catch:{ Exception -> 0x00b1, all -> 0x00ac }
        r2.<init>(r1);	 Catch:{ Exception -> 0x00b1, all -> 0x00ac }
        r1 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x00a7, all -> 0x00a2 }
        r1.<init>(r2);	 Catch:{ Exception -> 0x00a7, all -> 0x00a2 }
    L_0x006c:
        r0 = r1.readLine();	 Catch:{ Exception -> 0x00a0 }
        if (r0 == 0) goto L_0x0090;
    L_0x0072:
        r3 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x00a0 }
        if (r3 != 0) goto L_0x006c;
    L_0x0078:
        r3 = "=";
        r0 = r0.split(r3);	 Catch:{ Exception -> 0x00a0 }
        if (r0 == 0) goto L_0x006c;
    L_0x0080:
        r3 = r0.length;	 Catch:{ Exception -> 0x00a0 }
        r4 = 2;
        if (r3 != r4) goto L_0x006c;
    L_0x0084:
        r3 = map;	 Catch:{ Exception -> 0x00a0 }
        r4 = 0;
        r4 = r0[r4];	 Catch:{ Exception -> 0x00a0 }
        r5 = 1;
        r0 = r0[r5];	 Catch:{ Exception -> 0x00a0 }
        r3.put(r4, r0);	 Catch:{ Exception -> 0x00a0 }
        goto L_0x006c;
    L_0x0090:
        if (r1 == 0) goto L_0x009a;
    L_0x0092:
        r1.close();	 Catch:{ IOException -> 0x0096 }
        goto L_0x009a;
    L_0x0096:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x009a:
        if (r2 == 0) goto L_0x00e3;
    L_0x009c:
        r2.close();	 Catch:{ IOException -> 0x00c8 }
        goto L_0x00e3;
    L_0x00a0:
        r0 = move-exception;
        goto L_0x00b5;
    L_0x00a2:
        r1 = move-exception;
        r6 = r1;
        r1 = r0;
        r0 = r6;
        goto L_0x00ce;
    L_0x00a7:
        r1 = move-exception;
        r6 = r1;
        r1 = r0;
        r0 = r6;
        goto L_0x00b5;
    L_0x00ac:
        r1 = move-exception;
        r2 = r0;
        r0 = r1;
        r1 = r2;
        goto L_0x00ce;
    L_0x00b1:
        r1 = move-exception;
        r2 = r0;
        r0 = r1;
        r1 = r2;
    L_0x00b5:
        r0.printStackTrace();	 Catch:{ all -> 0x00cd }
        if (r1 == 0) goto L_0x00c2;
    L_0x00ba:
        r1.close();	 Catch:{ IOException -> 0x00be }
        goto L_0x00c2;
    L_0x00be:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x00c2:
        if (r2 == 0) goto L_0x00e3;
    L_0x00c4:
        r2.close();	 Catch:{ IOException -> 0x00c8 }
        goto L_0x00e3;
    L_0x00c8:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x00e3;
    L_0x00cd:
        r0 = move-exception;
    L_0x00ce:
        if (r1 == 0) goto L_0x00d8;
    L_0x00d0:
        r1.close();	 Catch:{ IOException -> 0x00d4 }
        goto L_0x00d8;
    L_0x00d4:
        r1 = move-exception;
        r1.printStackTrace();
    L_0x00d8:
        if (r2 == 0) goto L_0x00e2;
    L_0x00da:
        r2.close();	 Catch:{ IOException -> 0x00de }
        goto L_0x00e2;
    L_0x00de:
        r1 = move-exception;
        r1.printStackTrace();
    L_0x00e2:
        throw r0;
    L_0x00e3:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ximalaya.ting.android.opensdk.util.Logger.<clinit>():void");
    }

    public static boolean checkIfLog(String str) {
        for (Entry entry : map.entrySet()) {
            if (str.contains((CharSequence) entry.getKey()) && ((String) entry.getValue()).equals("true")) {
                return true;
            }
        }
        return false;
    }

    public static void d(String str, String str2) {
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

    public static String getCacheDir(Context context) {
        CACHE_DIR = context.getCacheDir().getPath();
        return CACHE_DIR;
    }

    public static String getLineInfo() {
        if (!ConstantsOpenSdk.isDebug) {
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
        try {
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Environment.getExternalStorageDirectory());
            stringBuilder.append("/ting/errorLog/infor.log");
            File file = new File(stringBuilder.toString());
            try {
                file.getParentFile().mkdirs();
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return file;
        } catch (ArrayIndexOutOfBoundsException unused) {
            return null;
        }
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

    public static void init(Context context) {
        if (context != null && context.getExternalFilesDir("") != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(context.getExternalFilesDir(""));
            stringBuilder.append("/errorLog/infor.log");
            ERROR_LOG_PATH = stringBuilder.toString();
        }
    }

    public static boolean isLoggable(String str, int i) {
        boolean z = false;
        if (!ConstantsOpenSdk.isDebug) {
            return false;
        }
        if (i >= LOG_LEVEL) {
            z = true;
        }
        return z;
    }

    public static void log(Object obj) {
        if (ConstantsOpenSdk.isDebug) {
            String str = XmNotificationCreater.IMG_NOTIFYICON_DRAWABLE_S;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(obj);
            stringBuilder.append("");
            Log.i(str, stringBuilder.toString());
        }
    }

    public static void log(String str, String str2, boolean z) {
        if (str2 != null && isLoggable(str, 3)) {
            Log.d(str, str2);
        }
    }

    public static void logFuncRunTime(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("time ");
        stringBuilder.append(str);
        stringBuilder.append(":");
        stringBuilder.append(System.currentTimeMillis() - nowTime);
        log(stringBuilder.toString());
        nowTime = System.currentTimeMillis();
    }

    public static void logFuncRunTimeReset(String str) {
        log(str);
        nowTime = System.currentTimeMillis();
    }

    public static void logListToSD(List list, String str) {
        if (list != null && list.size() != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("start-log-list:");
            stringBuilder.append(str);
            stringBuilder.append(":size:");
            stringBuilder.append(list.size());
            logToSd(stringBuilder.toString());
            for (Object next : list) {
                if (next != null) {
                    logToSd(next.toString());
                }
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("end-log-list");
            stringBuilder2.append(str);
            logToSd(stringBuilder2.toString());
        }
    }

    public static void logToFile(String str) {
        if (ConstantsOpenSdk.isLogToFile && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(CACHE_DIR) && !UPLOADING) {
            logToSd(str, new File(CACHE_DIR, LOG_UPLOAD_FILE));
        }
    }

    public static void logToSd(String str) {
        if (ConstantsOpenSdk.isDebug) {
            log(str);
            File logFilePath = getLogFilePath();
            if (logFilePath != null) {
                logToSd(str, logFilePath);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0020  */
    public static void logToSd(java.lang.String r4, java.io.File r5) {
        /*
        if (r5 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r0 = 0;
        r1 = new java.io.PrintWriter;	 Catch:{ Throwable -> 0x0024, all -> 0x001d }
        r2 = new java.io.FileWriter;	 Catch:{ Throwable -> 0x0024, all -> 0x001d }
        r3 = 1;
        r2.<init>(r5, r3);	 Catch:{ Throwable -> 0x0024, all -> 0x001d }
        r1.<init>(r2);	 Catch:{ Throwable -> 0x0024, all -> 0x001d }
        r1.println(r4);	 Catch:{ Throwable -> 0x001b, all -> 0x0018 }
        if (r1 == 0) goto L_0x0029;
    L_0x0014:
        r1.close();
        goto L_0x0029;
    L_0x0018:
        r4 = move-exception;
        r0 = r1;
        goto L_0x001e;
    L_0x001b:
        r0 = r1;
        goto L_0x0024;
    L_0x001d:
        r4 = move-exception;
    L_0x001e:
        if (r0 == 0) goto L_0x0023;
    L_0x0020:
        r0.close();
    L_0x0023:
        throw r4;
    L_0x0024:
        if (r0 == 0) goto L_0x0029;
    L_0x0026:
        r0.close();
    L_0x0029:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ximalaya.ting.android.opensdk.util.Logger.logToSd(java.lang.String, java.io.File):void");
    }

    public static void setDebugLevel(int i) {
        LOG_LEVEL = i;
    }

    public static void throwRuntimeException(Object obj) {
        if (ConstantsOpenSdk.isDebug) {
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
