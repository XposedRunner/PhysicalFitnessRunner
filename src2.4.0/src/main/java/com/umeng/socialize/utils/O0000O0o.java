package com.umeng.socialize.utils;

import android.os.Bundle;
import android.util.Log;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: SLog */
public class O0000O0o {
    private static final String O000000o = "Social";
    private static final String O00000Oo = "priviteSocial";
    private static final int O00000o = 0;
    private static boolean O00000o0 = true;
    private static final int O00000oO = 2;

    public static void O000000o(Bundle bundle) {
        if (UMConfigure.umDebugLog != null) {
            UMLog uMLog = UMConfigure.umDebugLog;
            UMLog.bundle(O000000o, 2, bundle);
        }
    }

    public static void O000000o(String str) {
        if (UMConfigure.umDebugLog != null) {
            String[] split = str.split("\n");
            UMLog uMLog = UMConfigure.umDebugLog;
            UMLog.mutlInfo(O000000o, 0, split);
        }
    }

    public static void O000000o(String str, String str2) {
        UMLog uMLog = UMConfigure.umDebugLog;
        UMLog.aq(O000000o, 0, str, str2);
    }

    public static void O000000o(String str, Throwable th) {
        if (UMConfigure.umDebugLog != null && th != null) {
            StackTraceElement[] stackTrace = th.getStackTrace();
            int i = 2;
            String[] strArr = new String[(stackTrace.length + 2)];
            strArr[0] = str;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("错误类型:");
            stringBuilder.append(th.getMessage());
            strArr[1] = stringBuilder.toString();
            for (StackTraceElement stackTraceElement : stackTrace) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("        at\t ");
                stringBuilder2.append(stackTraceElement.toString());
                strArr[i] = stringBuilder2.toString();
                i++;
            }
            UMLog uMLog = UMConfigure.umDebugLog;
            UMLog.mutlInfo(O000000o, 0, strArr);
        }
    }

    public static void O000000o(Throwable th) {
        if (UMConfigure.umDebugLog != null) {
            StackTraceElement[] stackTrace = th.getStackTrace();
            String[] strArr = new String[(stackTrace.length + 2)];
            strArr[0] = "错误信息如下:";
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("错误类型:");
            stringBuilder.append(th.getMessage());
            strArr[1] = stringBuilder.toString();
            int i = 2;
            for (StackTraceElement stackTraceElement : stackTrace) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("        at\t ");
                stringBuilder2.append(stackTraceElement.toString());
                strArr[i] = stringBuilder2.toString();
                i++;
            }
            UMLog uMLog = UMConfigure.umDebugLog;
            UMLog.mutlInfo(O000000o, 0, strArr);
        }
    }

    public static void O000000o(JSONArray jSONArray) {
        if (UMConfigure.umDebugLog != null) {
            UMLog uMLog = UMConfigure.umDebugLog;
            UMLog.jsonArry(O000000o, jSONArray);
        }
    }

    public static void O000000o(JSONObject jSONObject) {
        if (UMConfigure.umDebugLog != null) {
            UMLog uMLog = UMConfigure.umDebugLog;
            UMLog.jsonObject(O000000o, jSONObject);
        }
    }

    public static void O000000o(String... strArr) {
        UMLog uMLog = UMConfigure.umDebugLog;
        UMLog.mutlInfo(O000000o, 0, strArr);
    }

    public static boolean O000000o() {
        return UMConfigure.umDebugLog != null ? UMConfigure.isDebugLog() : false;
    }

    public static void O00000Oo() {
        if (UMConfigure.isDebugLog()) {
            Log.e(O00000Oo, "欢迎使用友盟社会化分享业务，您已添加debug包，可以使用UM Debug模式");
        } else {
            Log.e(O00000Oo, "欢迎使用友盟社会化分享业务，您没有添加debug库，如需看log，请根据文档提示添加：https://developer.umeng.com/docs/66632/detail/66890#h2-u67E5u770Bu65E5u5FD74");
        }
    }

    public static void O00000Oo(String str) {
        if (UMConfigure.umDebugLog != null) {
            String[] split = str.split("\n");
            UMLog uMLog = UMConfigure.umDebugLog;
            UMLog.mutlInfo(O000000o, 2, split);
        }
    }

    public static void O00000Oo(String str, String str2) {
        if (UMConfigure.umDebugLog != null) {
            String[] split = str2.split("\n");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Social_");
            stringBuilder.append(str);
            str = stringBuilder.toString();
            UMLog uMLog = UMConfigure.umDebugLog;
            UMLog.mutlInfo(str, 0, split);
        }
    }

    public static void O00000Oo(String... strArr) {
        if (UMConfigure.umDebugLog != null) {
            UMLog uMLog = UMConfigure.umDebugLog;
            UMLog.mutlInfo(O000000o, 2, strArr);
        }
    }

    public static void O00000o(String str) {
        Log.e(O00000Oo, str);
    }

    public static void O00000o0(String str) {
        if (UMConfigure.umDebugLog != null && O00000o0) {
            UMLog uMLog = UMConfigure.umDebugLog;
            String str2 = O00000Oo;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[private log]  ");
            stringBuilder.append(str);
            UMLog.mutlInfo(str2, 2, stringBuilder.toString());
        }
    }

    public static void O00000o0(String str, String str2) {
        if (UMConfigure.umDebugLog != null) {
            String[] split = str2.split("\n");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Social_");
            stringBuilder.append(str);
            str = stringBuilder.toString();
            UMLog uMLog = UMConfigure.umDebugLog;
            UMLog.mutlInfo(str, 2, split);
        }
    }

    public static void O00000oO(String str) {
        UMRTLog.e(O00000Oo, str);
    }
}
