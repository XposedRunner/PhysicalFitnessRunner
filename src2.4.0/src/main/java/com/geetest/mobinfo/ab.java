package com.geetest.mobinfo;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Process;
import com.alibaba.wireless.security.SecExceptionCode;
import com.bangcle.andJni.JniLib1557756502;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.List;
import org.json.JSONObject;

/* compiled from: XposedUtils */
public class ab {
    public static JSONObject a(Context context, String str, String str2, String str3) {
        return (JSONObject) JniLib1557756502.cL(context, str, str2, str3, Integer.valueOf(108));
    }

    private static void a(Context context, y yVar) {
        List<ApplicationInfo> installedApplications = context.getApplicationContext().getPackageManager().getInstalledApplications(128);
        if (installedApplications != null) {
            for (ApplicationInfo applicationInfo : installedApplications) {
                if ("de.robv.android.xposed.installer".equals(applicationInfo.packageName)) {
                    yVar.a(true);
                }
                if ("com.saurik.substrate".equals(applicationInfo.packageName)) {
                    yVar.d(true);
                }
            }
        }
    }

    private static void a(y yVar) {
        try {
            throw new Exception("Deteck hook");
        } catch (Exception e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            int i = 0;
            int length = stackTrace.length;
            int i2 = 0;
            while (i < length) {
                StackTraceElement stackTraceElement = stackTrace[i];
                if ("com.android.internal.os.ZygoteInit".equals(stackTraceElement.getClassName())) {
                    i2++;
                    if (i2 == 2) {
                        yVar.e(true);
                    }
                }
                if ("com.saurik.substrate.MS$2".equals(stackTraceElement.getClassName()) && "invoke".equals(stackTraceElement.getMethodName())) {
                    yVar.e(true);
                }
                if ("de.robv.android.xposed.XposedBridge".equals(stackTraceElement.getClassName()) && "main".equals(stackTraceElement.getMethodName())) {
                    yVar.b(true);
                }
                if ("de.robv.android.xposed.XposedBridge".equals(stackTraceElement.getClassName()) && "handleHookedMethod".equals(stackTraceElement.getMethodName())) {
                    yVar.b(true);
                }
                i++;
            }
        }
    }

    private static boolean a(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        List runningServices = activityManager != null ? activityManager.getRunningServices(SecExceptionCode.SEC_ERROR_STA_ENC) : null;
        int i = 0;
        if (runningServices == null) {
            return false;
        }
        boolean z = false;
        while (i < runningServices.size()) {
            if (((RunningServiceInfo) runningServices.get(i)).process.contains("fridaserver")) {
                z = true;
            }
            i++;
        }
        return z;
    }

    private static void b(y yVar) {
        HashSet<String> hashSet = new HashSet();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/proc/");
        stringBuilder.append(Process.myPid());
        stringBuilder.append("/maps");
        try {
            String readLine;
            BufferedReader bufferedReader = new BufferedReader(new FileReader(stringBuilder.toString()));
            while (true) {
                readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                if (readLine.toLowerCase().contains("frida")) {
                    yVar.g(true);
                }
                if (readLine.endsWith(".so") || readLine.endsWith(".jar")) {
                    hashSet.add(readLine.substring(readLine.lastIndexOf(" ") + 1));
                }
            }
            for (String readLine2 : hashSet) {
                if (readLine2.contains("com.saurik.substrate")) {
                    yVar.f(true);
                }
                if (readLine2.contains("XposedBridge.jar")) {
                    yVar.c(true);
                }
            }
            bufferedReader.close();
        } catch (Exception unused) {
        }
    }
}
