package com.qiyukf.basesdk.c.d;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Process;
import android.text.TextUtils;
import com.qiyukf.basesdk.a.a;
import java.util.List;

public final class e {
    public static String a(Context context) {
        return c(context);
    }

    public static void a(Context context, Intent intent) {
        try {
            context.startService(intent);
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("start service: ");
            stringBuilder.append(intent.getComponent());
            stringBuilder.append("error: ");
            stringBuilder.append(th);
            a.a("service", stringBuilder.toString());
            th.printStackTrace();
        }
    }

    public static <Params, Progress, Result> void a(AsyncTask<Params, Progress, Result> asyncTask, Params... paramsArr) {
        if (VERSION.SDK_INT <= 10) {
            asyncTask.execute(paramsArr);
        } else {
            asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, paramsArr);
        }
    }

    public static boolean b(Context context) {
        return TextUtils.equals(context.getApplicationInfo().processName, c(context));
    }

    private static String c(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        CharSequence charSequence = null;
        while (true) {
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses != null) {
                for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.pid == Process.myPid()) {
                        charSequence = runningAppProcessInfo.processName;
                        break;
                    }
                }
            }
            if (!TextUtils.isEmpty(charSequence)) {
                return charSequence;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
