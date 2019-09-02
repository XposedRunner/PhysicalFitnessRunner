package com.ximalaya.ting.android.opensdk.util;

import android.app.ActivityManager;
import android.app.ActivityManager.AppTask;
import android.app.ActivityManager.RecentTaskInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Process;
import android.text.TextUtils;
import com.ximalaya.ting.android.opensdk.constants.ConstantsOpenSdk;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class BaseUtil {
    private static char AppWhich;
    static final Class<?>[] EMPTY_CLASS_ARRAY = new Class[0];
    static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];
    public static String curProcessName;

    public static String getCurProcessName(Context context) {
        if (context == null) {
            return "";
        }
        if (!TextUtils.isEmpty(curProcessName)) {
            return curProcessName;
        }
        int myPid = Process.myPid();
        List runningAppProcesses;
        try {
            runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        } catch (Exception e) {
            e.printStackTrace();
            runningAppProcesses = null;
        }
        if (runningAppProcesses != null) {
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    curProcessName = runningAppProcessInfo.processName;
                    break;
                }
            }
        }
        if (TextUtils.isEmpty(curProcessName)) {
            curProcessName = getProcessName();
        }
        if (TextUtils.isEmpty(curProcessName)) {
            curProcessName = context.getPackageName();
        }
        return curProcessName;
    }

    private static String getProcessName() {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("/proc/");
            stringBuilder.append(Process.myPid());
            stringBuilder.append("/cmdline");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(stringBuilder.toString())));
            String trim = bufferedReader.readLine().trim();
            bufferedReader.close();
            return trim;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String[] getYDTDayNum() {
        String[] strArr = new String[3];
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy:MM:dd");
        int i = -1;
        for (int i2 = 0; i2 < 3; i2++) {
            Calendar instance = Calendar.getInstance();
            instance.add(5, i);
            strArr[i2] = simpleDateFormat.format(instance.getTime());
            i++;
        }
        return strArr;
    }

    public static boolean isActivityAlive(Context context, String str) {
        if (context == null) {
            return false;
        }
        for (RunningTaskInfo runningTaskInfo : ((ActivityManager) context.getSystemService("activity")).getRunningTasks(100)) {
            if (!runningTaskInfo.topActivity.toString().equals(str)) {
                if (runningTaskInfo.baseActivity.toString().equals(str)) {
                }
            }
            return true;
        }
        return false;
    }

    public static int isInTime(String str) throws IllegalArgumentException {
        StringBuilder stringBuilder;
        if (!TextUtils.isEmpty(str) && str.contains("-") && str.contains(":")) {
            String[] split = str.split("-");
            int i = split[0].split(":").length == 2 ? 1 : 0;
            int i2 = split[0].split(":").length == 3 ? 1 : 0;
            int i3 = split[0].split(":").length == 5 ? 1 : 0;
            SimpleDateFormat simpleDateFormat = null;
            if (i2 != 0) {
                simpleDateFormat = new SimpleDateFormat("dd:HH:mm", Locale.getDefault());
            } else if (i3 != 0) {
                simpleDateFormat = new SimpleDateFormat("yy:MM:dd:HH:mm", Locale.getDefault());
            } else if (i != 0) {
                simpleDateFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
            }
            if (simpleDateFormat == null) {
                return -2;
            }
            try {
                long time = simpleDateFormat.parse(simpleDateFormat.format(new Date(System.currentTimeMillis()))).getTime();
                long time2 = simpleDateFormat.parse(split[0]).getTime();
                StringBuilder stringBuilder2;
                if (split[1].contains("00:00") && i2 != 0) {
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(split[1].split(":")[0]);
                    stringBuilder2.append(":23:59");
                    split[1] = stringBuilder2.toString();
                } else if (split[1].contains("00:00") && i3 != 0) {
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(split[1].split(":")[0]);
                    stringBuilder2.append(":");
                    stringBuilder2.append(split[1].split(":")[1]);
                    stringBuilder2.append(":");
                    stringBuilder2.append(split[1].split(":")[2]);
                    stringBuilder2.append(":23:59");
                    split[1] = stringBuilder2.toString();
                } else if (split[1].contains("00:00") && i != 0) {
                    split[1] = "23:59";
                }
                long time3 = simpleDateFormat.parse(split[1]).getTime();
                return time >= time3 ? -1 : (time < time2 || time >= time3) ? 1 : 0;
            } catch (ParseException e) {
                e.printStackTrace();
                if (!ConstantsOpenSdk.isDebug) {
                    return -2;
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append("Illegal Argument arg:");
                stringBuilder.append(str);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        } else if (!ConstantsOpenSdk.isDebug) {
            return -2;
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Illegal Argument arg:");
            stringBuilder.append(str);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public static boolean isMainApp() {
        if (AppWhich == 0) {
            try {
                Class.forName("com.ximalaya.ting.android.host.manager.request.CommonRequestM");
                AppWhich = 1;
            } catch (ClassNotFoundException unused) {
                AppWhich = 2;
            } catch (Exception unused2) {
                AppWhich = 2;
            }
        }
        return AppWhich == 1 || AppWhich != 2;
    }

    public static boolean isMainProcess(Context context) {
        if (isMainApp()) {
            String curProcessName = getCurProcessName(context);
            return !TextUtils.isEmpty(curProcessName) && curProcessName.equals("com.ximalaya.ting.android");
        } else {
            String curProcessName2 = getCurProcessName(context);
            return !TextUtils.isEmpty(curProcessName2) && curProcessName2.equals(context.getPackageName());
        }
    }

    public static boolean isNight() {
        int intValue = Integer.valueOf(new SimpleDateFormat("HH", Locale.getDefault()).format(Long.valueOf(System.currentTimeMillis())).trim()).intValue();
        return intValue == 22 || intValue == 23 || (intValue >= 0 && intValue < 6);
    }

    public static boolean isPlayerProcess(Context context) {
        String curProcessName = getCurProcessName(context);
        return !TextUtils.isEmpty(curProcessName) && curProcessName.contains("player");
    }

    public static boolean isProcessInRecentTasks(Context context, String str) {
        if (context == null || str == null) {
            return true;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return true;
        }
        RecentTaskInfo recentTaskInfo;
        if (VERSION.SDK_INT >= 21) {
            List<AppTask> appTasks = activityManager.getAppTasks();
            if (appTasks == null || appTasks.isEmpty()) {
                return false;
            }
            for (AppTask appTask : appTasks) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("process RecentTaskInfo processName0:");
                stringBuilder.append(appTask.getTaskInfo().baseIntent.getComponent().getPackageName());
                Logger.log(stringBuilder.toString());
                recentTaskInfo = null;
                if (appTask != null) {
                    recentTaskInfo = appTask.getTaskInfo();
                }
                if (recentTaskInfo != null && recentTaskInfo.baseIntent != null && recentTaskInfo.baseIntent.getComponent() != null && str.equals(recentTaskInfo.baseIntent.getComponent().getPackageName())) {
                    return true;
                }
            }
            return false;
        }
        List recentTasks = activityManager.getRecentTasks(100, 2);
        if (recentTasks == null || recentTasks.isEmpty()) {
            return false;
        }
        for (int i = 0; i < recentTasks.size(); i++) {
            recentTaskInfo = (RecentTaskInfo) recentTasks.get(i);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("process RecentTaskInfo processName1:");
            stringBuilder2.append(recentTaskInfo.baseIntent.getComponent().getPackageName());
            Logger.log(stringBuilder2.toString());
            if (recentTaskInfo.baseIntent != null && recentTaskInfo.baseIntent.getComponent() != null && str.equals(recentTaskInfo.baseIntent.getComponent().getPackageName())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isProcessRunning(Context context, String str) {
        List runningAppProcesses;
        try {
            runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        } catch (Exception e) {
            e.printStackTrace();
            runningAppProcesses = null;
        }
        if (runningAppProcesses == null) {
            return false;
        }
        for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.processName.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isPushProcess(Context context) {
        String curProcessName = getCurProcessName(context);
        return !TextUtils.isEmpty(curProcessName) && curProcessName.contains("pushservice");
    }

    static Class<?>[] nullToEmpty(Class<?>[] clsArr) {
        return (clsArr == null || clsArr.length == 0) ? EMPTY_CLASS_ARRAY : clsArr;
    }

    static Object[] nullToEmpty(Object[] objArr) {
        return (objArr == null || objArr.length == 0) ? EMPTY_OBJECT_ARRAY : objArr;
    }

    public static String printTrack() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null) {
            return "无堆栈...";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (stringBuffer.length() > 0) {
                stringBuffer.append(" <- ");
                stringBuffer.append(System.getProperty("line.separator"));
            }
            stringBuffer.append(MessageFormat.format("{0}.{1}() {2}", new Object[]{stackTraceElement.getClassName(), stackTraceElement.getMethodName(), Integer.valueOf(stackTraceElement.getLineNumber())}));
        }
        return stringBuffer.toString();
    }
}
