package cn.jiguang.d.b;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Process;
import android.text.TextUtils;
import cn.jiguang.api.JCoreInterface;
import cn.jiguang.api.MultiSpHelper;
import cn.jiguang.e.c;
import cn.jpush.android.service.AlarmReceiver;
import cn.jpush.android.service.PushReceiver;
import java.io.File;

public final class a {
    public static int a = -1;
    private static String b;

    public static void a(Context context) {
        try {
            JCoreInterface.asyncExecute(new c(context), new int[0]);
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, boolean z) {
        try {
            PackageManager packageManager = context.getPackageManager();
            ComponentName componentName = new ComponentName(context.getApplicationContext(), PushReceiver.class);
            ComponentName componentName2 = new ComponentName(context.getApplicationContext(), AlarmReceiver.class);
            if (z) {
                c.a("JCoreServiceUtils", "set Push/Alarm Receiver enabled");
                packageManager.setComponentEnabledSetting(componentName, 1, 1);
                packageManager.setComponentEnabledSetting(componentName2, 1, 1);
                cn.jiguang.g.a.k(context.getApplicationContext());
                return;
            }
            c.a("JCoreServiceUtils", "set Push/Alarm Receiver disabled");
            packageManager.setComponentEnabledSetting(componentName, 2, 1);
            packageManager.setComponentEnabledSetting(componentName2, 2, 1);
            cn.jiguang.g.a.l(context.getApplicationContext());
            cn.jiguang.g.a.s(context);
        } catch (Throwable unused) {
        }
    }

    public static boolean a() {
        return a == 0;
    }

    public static void b() {
        if (cn.jiguang.g.a.q(cn.jiguang.d.a.d)) {
            if (b(cn.jiguang.d.a.d)) {
                try {
                    JCoreInterface.asyncExecute(new b(), new int[0]);
                    return;
                } catch (Throwable th) {
                    StringBuilder stringBuilder = new StringBuilder("create checkCommonService thread error:");
                    stringBuilder.append(th);
                    c.c("JCoreServiceUtils", stringBuilder.toString());
                    a = 1;
                }
            }
            return;
        }
        a = 0;
    }

    public static boolean b(Context context) {
        String c = c(context);
        String packageName = context.getPackageName();
        return (c == null || packageName == null || !packageName.equals(c)) ? false : true;
    }

    public static String c(Context context) {
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        try {
            context = cn.jiguang.d.a.a(context);
            ActivityManager activityManager = null;
            if (context != null) {
                activityManager = (ActivityManager) context.getSystemService("activity");
            }
            if (activityManager != null) {
                int myPid = Process.myPid();
                for (RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == myPid) {
                        b = runningAppProcessInfo.processName;
                        break;
                    }
                }
            }
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("#unexcepted - getCurProcessName failed:");
            stringBuilder.append(th.getMessage());
            c.c("JCoreServiceUtils", stringBuilder.toString());
        }
        return b;
    }

    public static boolean c() {
        return a == 1 || a == -1;
    }

    static /* synthetic */ void d(Context context) {
        File file = new File(context.getFilesDir(), ".servicesaveFile");
        if (MultiSpHelper.getBoolean(context, "needcleanFile", true)) {
            if (file.exists()) {
                file.delete();
            }
            MultiSpHelper.commitBoolean(context, "needcleanFile", false);
        }
        int i = 20;
        while (i > 0) {
            try {
                if (file.exists()) {
                    a = 1;
                    break;
                } else {
                    i--;
                    Thread.sleep(1000);
                }
            } catch (InterruptedException unused) {
                a = 1;
            } catch (Throwable unused2) {
                a = 1;
            }
        }
        if (a == -1) {
            a = 0;
            JCoreInterface.register(cn.jiguang.d.a.d);
        }
    }
}
