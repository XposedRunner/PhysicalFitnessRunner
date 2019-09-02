package com.umeng.commonsdk.statistics.common;

import android.text.TextUtils;
import android.util.Log;
import java.util.Formatter;
import java.util.Locale;

public class ULog {
    public static boolean DEBUG = false;
    private static final int LEVEL_DEBUG = 2;
    private static final int LEVEL_ERROR = 5;
    private static final int LEVEL_INFO = 3;
    private static final int LEVEL_VERBOSE = 1;
    private static final int LEVEL_WARN = 4;
    private static int LOG_MAXLENGTH = 2000;
    private static String TAG = "ULog";

    private ULog() {
    }

    public static void d(String str) {
        d(TAG, str, null);
    }

    public static void d(String str, String str2, Throwable th) {
        if (DEBUG) {
            print(2, str, str2, th);
        }
    }

    public static void d(String str, Throwable th) {
        d(TAG, str, th);
    }

    public static void d(String str, Object... objArr) {
        try {
            String str2 = "";
            if (str.contains("%")) {
                d(TAG, new Formatter().format(str, objArr).toString(), null);
                return;
            }
            if (objArr != null) {
                str2 = (String) objArr[0];
            }
            d(str, str2, null);
        } catch (Throwable th) {
            e(th);
        }
    }

    public static void d(Throwable th) {
        d(TAG, null, th);
    }

    public static void d(Locale locale, String str, Object... objArr) {
        try {
            d(TAG, new Formatter(locale).format(str, objArr).toString(), null);
        } catch (Throwable th) {
            e(th);
        }
    }

    public static void e(String str) {
        e(TAG, str, null);
    }

    public static void e(String str, String str2, Throwable th) {
        if (DEBUG) {
            print(5, str, str2, th);
        }
    }

    public static void e(String str, Throwable th) {
        e(TAG, str, th);
    }

    public static void e(String str, Object... objArr) {
        try {
            String str2 = "";
            if (str.contains("%")) {
                e(TAG, new Formatter().format(str, objArr).toString(), null);
                return;
            }
            if (objArr != null) {
                str2 = (String) objArr[0];
            }
            e(str, str2, null);
        } catch (Throwable th) {
            e(th);
        }
    }

    public static void e(Throwable th) {
        e(TAG, null, th);
    }

    public static void e(Locale locale, String str, Object... objArr) {
        try {
            e(TAG, new Formatter(locale).format(str, objArr).toString(), null);
        } catch (Throwable th) {
            e(th);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x003c A:{SYNTHETIC, Splitter:B:31:0x003c} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0030 A:{SYNTHETIC, Splitter:B:21:0x0030} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x003c A:{SYNTHETIC, Splitter:B:31:0x003c} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0030 A:{SYNTHETIC, Splitter:B:21:0x0030} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0035  */
    public static java.lang.String getStackTrace(java.lang.Throwable r4) {
        /*
        r0 = "";
        r1 = 0;
        r2 = new java.io.StringWriter;	 Catch:{ Throwable -> 0x0039, all -> 0x002c }
        r2.<init>();	 Catch:{ Throwable -> 0x0039, all -> 0x002c }
        r3 = new java.io.PrintWriter;	 Catch:{ Throwable -> 0x003a, all -> 0x002a }
        r3.<init>(r2);	 Catch:{ Throwable -> 0x003a, all -> 0x002a }
        r4.printStackTrace(r3);	 Catch:{ Throwable -> 0x0028, all -> 0x0025 }
        r3.flush();	 Catch:{ Throwable -> 0x0028, all -> 0x0025 }
        r2.flush();	 Catch:{ Throwable -> 0x0028, all -> 0x0025 }
        r4 = r2.toString();	 Catch:{ Throwable -> 0x0028, all -> 0x0025 }
        if (r2 == 0) goto L_0x001f;
    L_0x001c:
        r2.close();	 Catch:{ Throwable -> 0x001f }
    L_0x001f:
        if (r3 == 0) goto L_0x0045;
    L_0x0021:
        r3.close();
        goto L_0x0045;
    L_0x0025:
        r4 = move-exception;
        r1 = r3;
        goto L_0x002e;
    L_0x0028:
        r1 = r3;
        goto L_0x003a;
    L_0x002a:
        r4 = move-exception;
        goto L_0x002e;
    L_0x002c:
        r4 = move-exception;
        r2 = r1;
    L_0x002e:
        if (r2 == 0) goto L_0x0033;
    L_0x0030:
        r2.close();	 Catch:{ Throwable -> 0x0033 }
    L_0x0033:
        if (r1 == 0) goto L_0x0038;
    L_0x0035:
        r1.close();
    L_0x0038:
        throw r4;
    L_0x0039:
        r2 = r1;
    L_0x003a:
        if (r2 == 0) goto L_0x003f;
    L_0x003c:
        r2.close();	 Catch:{ Throwable -> 0x003f }
    L_0x003f:
        if (r1 == 0) goto L_0x0044;
    L_0x0041:
        r1.close();
    L_0x0044:
        r4 = r0;
    L_0x0045:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.common.ULog.getStackTrace(java.lang.Throwable):java.lang.String");
    }

    public static void i(String str) {
        i(TAG, str, null);
    }

    public static void i(String str, String str2, Throwable th) {
        if (DEBUG) {
            print(3, str, str2, th);
        }
    }

    public static void i(String str, Throwable th) {
        i(TAG, str, th);
    }

    public static void i(String str, Object... objArr) {
        try {
            String str2 = "";
            if (str.contains("%")) {
                i(TAG, new Formatter().format(str, objArr).toString(), null);
                return;
            }
            if (objArr != null) {
                str2 = (String) objArr[0];
            }
            i(str, str2, null);
        } catch (Throwable th) {
            e(th);
        }
    }

    public static void i(Throwable th) {
        i(TAG, null, th);
    }

    public static void i(Locale locale, String str, Object... objArr) {
        try {
            i(TAG, new Formatter(locale).format(str, objArr).toString(), null);
        } catch (Throwable th) {
            e(th);
        }
    }

    private static void print(int i, String str, String str2, Throwable th) {
        if (!TextUtils.isEmpty(str2)) {
            int length = str2.length();
            int i2 = LOG_MAXLENGTH;
            int i3 = 0;
            int i4 = 0;
            while (i3 < 100) {
                if (length <= i2) {
                    switch (i) {
                        case 1:
                            Log.v(str, str2.substring(i4, length));
                            break;
                        case 2:
                            Log.d(str, str2.substring(i4, length));
                            break;
                        case 3:
                            Log.i(str, str2.substring(i4, length));
                            break;
                        case 4:
                            Log.w(str, str2.substring(i4, length));
                            break;
                        case 5:
                            Log.e(str, str2.substring(i4, length));
                            break;
                    }
                }
                switch (i) {
                    case 1:
                        Log.v(str, str2.substring(i4, i2));
                        break;
                    case 2:
                        Log.d(str, str2.substring(i4, i2));
                        break;
                    case 3:
                        Log.i(str, str2.substring(i4, i2));
                        break;
                    case 4:
                        Log.w(str, str2.substring(i4, i2));
                        break;
                    case 5:
                        Log.e(str, str2.substring(i4, i2));
                        break;
                    default:
                        break;
                }
                i3++;
                i4 = i2;
                i2 = LOG_MAXLENGTH + i2;
            }
        }
        if (th != null) {
            str2 = getStackTrace(th);
            if (!TextUtils.isEmpty(str2)) {
                switch (i) {
                    case 1:
                        Log.v(str, str2);
                        return;
                    case 2:
                        Log.d(str, str2);
                        return;
                    case 3:
                        Log.i(str, str2);
                        return;
                    case 4:
                        Log.w(str, str2);
                        return;
                    case 5:
                        Log.e(str, str2);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public static void v(String str) {
        v(TAG, str, null);
    }

    public static void v(String str, String str2, Throwable th) {
        if (DEBUG) {
            print(1, str, str2, th);
        }
    }

    public static void v(String str, Throwable th) {
        v(TAG, str, th);
    }

    public static void v(String str, Object... objArr) {
        try {
            String str2 = "";
            if (str.contains("%")) {
                v(TAG, new Formatter().format(str, objArr).toString(), null);
                return;
            }
            if (objArr != null) {
                str2 = (String) objArr[0];
            }
            v(str, str2, null);
        } catch (Throwable th) {
            e(th);
        }
    }

    public static void v(Throwable th) {
        v(TAG, null, th);
    }

    public static void v(Locale locale, String str, Object... objArr) {
        try {
            v(TAG, new Formatter(locale).format(str, objArr).toString(), null);
        } catch (Throwable th) {
            e(th);
        }
    }

    public static void w(String str) {
        w(TAG, str, null);
    }

    public static void w(String str, String str2, Throwable th) {
        if (DEBUG) {
            print(4, str, str2, th);
        }
    }

    public static void w(String str, Throwable th) {
        w(TAG, str, th);
    }

    public static void w(String str, Object... objArr) {
        try {
            String str2 = "";
            if (str.contains("%")) {
                w(TAG, new Formatter().format(str, objArr).toString(), null);
                return;
            }
            if (objArr != null) {
                str2 = (String) objArr[0];
            }
            w(str, str2, null);
        } catch (Throwable th) {
            e(th);
        }
    }

    public static void w(Throwable th) {
        w(TAG, null, th);
    }

    public static void w(Locale locale, String str, Object... objArr) {
        try {
            w(TAG, new Formatter(locale).format(str, objArr).toString(), null);
        } catch (Throwable th) {
            e(th);
        }
    }
}
