package com.umeng.commonsdk.framework;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.Process;
import android.text.TextUtils;
import cn.jiguang.net.HttpUtils;
import com.sina.weibo.sdk.statistic.LogBuilder;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.List;

public class UMFrUtils {
    private static final String KEY_LAST_INSTANT_SUCC_BUILD_TIME = "last_instant_build_time";
    private static final String KEY_LAST_SUCC_BUILD_TIME = "last_successful_build_time";
    private static String mDefaultEnvelopeDir = "envelope";
    private static String mDefaultEnvelopeDirPath;
    private static Object mEnvelopeBuildTimeLock = new Object();
    private static Object mEnvelopeFileLock = new Object();

    private static boolean checkPermission(Context context, String str) {
        if (context == null) {
            return false;
        }
        Context applicationContext = context.getApplicationContext();
        if (VERSION.SDK_INT >= 23) {
            try {
                if (((Integer) Class.forName("android.content.Context").getMethod("checkSelfPermission", new Class[]{String.class}).invoke(context, new Object[]{str})).intValue() != 0) {
                    return false;
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(applicationContext, th);
                return false;
            }
        }
        try {
            if (applicationContext.getPackageManager().checkPermission(str, applicationContext.getPackageName()) != 0) {
                return false;
            }
        } catch (Throwable th2) {
            UMCrashManager.reportCrash(applicationContext, th2);
            return false;
        }
        return true;
    }

    public static int envelopeFileNumber(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            File file = new File(getEnvelopeDirPath(context));
            synchronized (mEnvelopeFileLock) {
                if (file.isDirectory()) {
                    String[] list = file.list();
                    if (list != null) {
                        int length = list.length;
                        return length;
                    }
                }
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
        return 0;
    }

    private static String getCreateTimeFromFileName(String str) {
        Context appContext = UMModuleRegister.getAppContext();
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int indexOf = str.indexOf(95) + 1;
        try {
            return str.substring(indexOf, str.indexOf(95, indexOf));
        } catch (IndexOutOfBoundsException e) {
            UMCrashManager.reportCrash(appContext, e);
            return "";
        }
    }

    public static String getCurrentProcessName(Context context) {
        String str = "";
        try {
            int myPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null) {
                return str;
            }
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null || runningAppProcesses.size() <= 0) {
                return str;
            }
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
            return str;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context.getApplicationContext(), th);
            return str;
        }
    }

    private static long getDistanceDays(long j, long j2) {
        return (j < j2 ? j2 - j : j - j2) / LogBuilder.MAX_INTERVAL;
    }

    public static String getEnvelopeDirPath(Context context) {
        String str;
        synchronized (mEnvelopeFileLock) {
            try {
                if (mDefaultEnvelopeDirPath == null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(context.getFilesDir().getAbsolutePath());
                    stringBuilder.append("/.");
                    stringBuilder.append(mDefaultEnvelopeDir);
                    mDefaultEnvelopeDirPath = stringBuilder.toString();
                }
                File file = new File(mDefaultEnvelopeDirPath);
                if (!(file.exists() || file.mkdir())) {
                    ULog.d("--->>> Create Envelope Directory failed!!!");
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(context, th);
            }
            str = mDefaultEnvelopeDirPath;
        }
        return str;
    }

    /* JADX WARNING: Missing block: B:15:0x0028, code skipped:
            return null;
     */
    public static java.io.File getEnvelopeFile(final android.content.Context r4) {
        /*
        r0 = 0;
        if (r4 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = new java.io.File;
        r2 = getEnvelopeDirPath(r4);
        r1.<init>(r2);
        r2 = mEnvelopeFileLock;
        monitor-enter(r2);
        r1 = r1.listFiles();	 Catch:{ all -> 0x0029 }
        if (r1 == 0) goto L_0x0027;
    L_0x0016:
        r3 = r1.length;	 Catch:{ all -> 0x0029 }
        if (r3 != 0) goto L_0x001a;
    L_0x0019:
        goto L_0x0027;
    L_0x001a:
        r0 = new com.umeng.commonsdk.framework.UMFrUtils$2;	 Catch:{ all -> 0x0029 }
        r0.<init>(r4);	 Catch:{ all -> 0x0029 }
        java.util.Arrays.sort(r1, r0);	 Catch:{ all -> 0x0029 }
        r4 = 0;
        r4 = r1[r4];	 Catch:{ all -> 0x0029 }
        monitor-exit(r2);	 Catch:{ all -> 0x0029 }
        return r4;
    L_0x0027:
        monitor-exit(r2);	 Catch:{ all -> 0x0029 }
        return r0;
    L_0x0029:
        r4 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0029 }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.framework.UMFrUtils.getEnvelopeFile(android.content.Context):java.io.File");
    }

    public static long getLastInstantBuildTime(Context context) {
        long j;
        synchronized (mEnvelopeBuildTimeLock) {
            j = PreferenceWrapper.getDefault(context).getLong(KEY_LAST_INSTANT_SUCC_BUILD_TIME, 0);
        }
        return j;
    }

    public static long getLastSuccessfulBuildTime(Context context) {
        long j;
        synchronized (mEnvelopeBuildTimeLock) {
            j = PreferenceWrapper.getDefault(context).getLong(KEY_LAST_SUCC_BUILD_TIME, 0);
        }
        return j;
    }

    public static String getLegacyEnvelopeDir(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null) {
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                ULog.d("--->>> getEnvelopeDir: can't get process name, use default envelope directory.");
                return mDefaultEnvelopeDir;
            } else if (runningAppProcesses.size() == 0) {
                return mDefaultEnvelopeDir;
            } else {
                try {
                    for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (runningAppProcessInfo.pid == Process.myPid()) {
                            String replace = runningAppProcessInfo.processName.replace(':', '_');
                            ULog.d("--->>> getEnvelopeDir: use current process name as envelope directory.");
                            return replace;
                        }
                    }
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(context, th);
                }
            }
        }
        return mDefaultEnvelopeDir;
    }

    public static String getSubProcessName(Context context) {
        String str = "";
        try {
            String currentProcessName = getCurrentProcessName(context);
            int indexOf = currentProcessName.indexOf(":");
            if (indexOf >= 0) {
                str = currentProcessName.substring(indexOf + 1);
            }
            return indexOf < 0 ? currentProcessName.substring(context.getPackageName().length() + 1, currentProcessName.length()) : str;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context.getApplicationContext(), th);
            return str;
        }
    }

    /* JADX WARNING: Missing block: B:22:0x0036, code skipped:
            return false;
     */
    public static boolean hasEnvelopeFile(android.content.Context r6, com.umeng.commonsdk.framework.UMLogDataProtocol.UMBusinessType r7) {
        /*
        r0 = "a";
        r1 = com.umeng.commonsdk.framework.UMLogDataProtocol.UMBusinessType.U_INTERNAL;
        if (r7 != r1) goto L_0x0008;
    L_0x0006:
        r0 = "i";
    L_0x0008:
        r7 = new java.io.File;
        r1 = getEnvelopeDirPath(r6);
        r7.<init>(r1);
        r1 = mEnvelopeFileLock;
        monitor-enter(r1);
        r2 = 0;
        r7 = r7.listFiles();	 Catch:{ Throwable -> 0x0039 }
        if (r7 == 0) goto L_0x0035;
    L_0x001b:
        r3 = r7.length;	 Catch:{ Throwable -> 0x0039 }
        if (r3 != 0) goto L_0x001f;
    L_0x001e:
        goto L_0x0035;
    L_0x001f:
        r3 = r7.length;	 Catch:{ Throwable -> 0x0039 }
        r4 = r2;
    L_0x0021:
        if (r4 >= r3) goto L_0x003d;
    L_0x0023:
        r5 = r7[r4];	 Catch:{ Throwable -> 0x0039 }
        r5 = r5.getName();	 Catch:{ Throwable -> 0x0039 }
        r5 = r5.startsWith(r0);	 Catch:{ Throwable -> 0x0039 }
        if (r5 == 0) goto L_0x0032;
    L_0x002f:
        monitor-exit(r1);	 Catch:{ all -> 0x0037 }
        r6 = 1;
        return r6;
    L_0x0032:
        r4 = r4 + 1;
        goto L_0x0021;
    L_0x0035:
        monitor-exit(r1);	 Catch:{ all -> 0x0037 }
        return r2;
    L_0x0037:
        r6 = move-exception;
        goto L_0x003f;
    L_0x0039:
        r7 = move-exception;
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r6, r7);	 Catch:{ all -> 0x0037 }
    L_0x003d:
        monitor-exit(r1);	 Catch:{ all -> 0x0037 }
        return r2;
    L_0x003f:
        monitor-exit(r1);	 Catch:{ all -> 0x0037 }
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.framework.UMFrUtils.hasEnvelopeFile(android.content.Context, com.umeng.commonsdk.framework.UMLogDataProtocol$UMBusinessType):boolean");
    }

    public static boolean isOnline(Context context) {
        try {
            if (checkPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null) {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo != null) {
                        return activeNetworkInfo.isConnectedOrConnecting();
                    }
                }
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context.getApplicationContext(), th);
        }
        return false;
    }

    public static boolean removeEnvelopeFile(File file) {
        Context appContext = UMModuleRegister.getAppContext();
        synchronized (mEnvelopeFileLock) {
            if (file != null) {
                try {
                    if (file.exists()) {
                        boolean delete = file.delete();
                        return delete;
                    }
                } catch (Throwable th) {
                }
            }
            return true;
        }
    }

    /* JADX WARNING: Missing block: B:24:0x0051, code skipped:
            return;
     */
    public static void removeRedundantEnvelopeFiles(final android.content.Context r5, int r6) {
        /*
        r0 = new java.io.File;
        r1 = getEnvelopeDirPath(r5);
        r0.<init>(r1);
        r1 = mEnvelopeFileLock;
        monitor-enter(r1);
        r0 = r0.listFiles();	 Catch:{ all -> 0x0052 }
        if (r0 == 0) goto L_0x0050;
    L_0x0012:
        r2 = r0.length;	 Catch:{ all -> 0x0052 }
        if (r2 > r6) goto L_0x0016;
    L_0x0015:
        goto L_0x0050;
    L_0x0016:
        r2 = new com.umeng.commonsdk.framework.UMFrUtils$1;	 Catch:{ all -> 0x0052 }
        r2.<init>(r5);	 Catch:{ all -> 0x0052 }
        java.util.Arrays.sort(r0, r2);	 Catch:{ all -> 0x0052 }
        r2 = r0.length;	 Catch:{ all -> 0x0052 }
        if (r2 <= r6) goto L_0x004e;
    L_0x0021:
        r2 = 0;
    L_0x0022:
        r3 = r0.length;	 Catch:{ Throwable -> 0x004a }
        r3 = r3 - r6;
        if (r2 >= r3) goto L_0x004e;
    L_0x0026:
        r3 = r0[r2];	 Catch:{ Throwable -> 0x004a }
        r3 = r3.delete();	 Catch:{ Throwable -> 0x004a }
        if (r3 != 0) goto L_0x0047;
    L_0x002e:
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x004a }
        r3.<init>();	 Catch:{ Throwable -> 0x004a }
        r4 = "--->>> remove [";
        r3.append(r4);	 Catch:{ Throwable -> 0x004a }
        r3.append(r2);	 Catch:{ Throwable -> 0x004a }
        r4 = "] file fail.";
        r3.append(r4);	 Catch:{ Throwable -> 0x004a }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x004a }
        com.umeng.commonsdk.statistics.common.ULog.d(r3);	 Catch:{ Throwable -> 0x004a }
    L_0x0047:
        r2 = r2 + 1;
        goto L_0x0022;
    L_0x004a:
        r6 = move-exception;
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r5, r6);	 Catch:{ all -> 0x0052 }
    L_0x004e:
        monitor-exit(r1);	 Catch:{ all -> 0x0052 }
        return;
    L_0x0050:
        monitor-exit(r1);	 Catch:{ all -> 0x0052 }
        return;
    L_0x0052:
        r5 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0052 }
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.framework.UMFrUtils.removeRedundantEnvelopeFiles(android.content.Context, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x005c A:{SYNTHETIC, Splitter:B:28:0x005c} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0068 A:{SYNTHETIC, Splitter:B:36:0x0068} */
    public static int saveEnvelopeFile(android.content.Context r5, java.lang.String r6, byte[] r7) {
        /*
        r0 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        if (r7 != 0) goto L_0x0005;
    L_0x0004:
        return r0;
    L_0x0005:
        r1 = new java.io.File;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = getEnvelopeDirPath(r5);
        r2.append(r3);
        r3 = "/";
        r2.append(r3);
        r2.append(r6);
        r2 = r2.toString();
        r1.<init>(r2);
        r2 = mEnvelopeFileLock;
        monitor-enter(r2);
        r3 = 0;
        r4 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x0056 }
        r4.<init>(r1);	 Catch:{ IOException -> 0x0056 }
        r4.write(r7);	 Catch:{ IOException -> 0x0051, all -> 0x004e }
        r4.close();	 Catch:{ IOException -> 0x0051, all -> 0x004e }
        r7 = com.umeng.commonsdk.statistics.internal.a.a(r5);	 Catch:{ all -> 0x006c }
        r7 = r7.a(r6);	 Catch:{ all -> 0x006c }
        r0 = com.umeng.commonsdk.statistics.internal.a.a(r5);	 Catch:{ all -> 0x006c }
        r6 = r0.b(r6);	 Catch:{ all -> 0x006c }
        if (r7 == 0) goto L_0x0046;
    L_0x0043:
        updateLastSuccessfulBuildTime(r5);	 Catch:{ all -> 0x006c }
    L_0x0046:
        if (r6 == 0) goto L_0x004b;
    L_0x0048:
        updateLastInstantBuildTime(r5);	 Catch:{ all -> 0x006c }
    L_0x004b:
        r5 = 0;
        monitor-exit(r2);	 Catch:{ all -> 0x006c }
        return r5;
    L_0x004e:
        r6 = move-exception;
        r3 = r4;
        goto L_0x0066;
    L_0x0051:
        r6 = move-exception;
        r3 = r4;
        goto L_0x0057;
    L_0x0054:
        r6 = move-exception;
        goto L_0x0066;
    L_0x0056:
        r6 = move-exception;
    L_0x0057:
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r5, r6);	 Catch:{ all -> 0x0054 }
        if (r3 == 0) goto L_0x0064;
    L_0x005c:
        r3.close();	 Catch:{ Throwable -> 0x0060 }
        goto L_0x0064;
    L_0x0060:
        r6 = move-exception;
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r5, r6);	 Catch:{ all -> 0x006c }
    L_0x0064:
        monitor-exit(r2);	 Catch:{ all -> 0x006c }
        return r0;
    L_0x0066:
        if (r3 == 0) goto L_0x0072;
    L_0x0068:
        r3.close();	 Catch:{ Throwable -> 0x006e }
        goto L_0x0072;
    L_0x006c:
        r5 = move-exception;
        goto L_0x0073;
    L_0x006e:
        r7 = move-exception;
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r5, r7);	 Catch:{ all -> 0x006c }
    L_0x0072:
        throw r6;	 Catch:{ all -> 0x006c }
    L_0x0073:
        monitor-exit(r2);	 Catch:{ all -> 0x006c }
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.framework.UMFrUtils.saveEnvelopeFile(android.content.Context, java.lang.String, byte[]):int");
    }

    public static void syncLegacyEnvelopeIfNeeded(Context context) {
        if (context != null) {
            try {
                String legacyEnvelopeDir = getLegacyEnvelopeDir(context);
                if (!TextUtils.isEmpty(legacyEnvelopeDir) && !legacyEnvelopeDir.equals(mDefaultEnvelopeDir)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(context.getFilesDir().getAbsolutePath());
                    stringBuilder.append("/.");
                    stringBuilder.append(legacyEnvelopeDir);
                    File file = new File(stringBuilder.toString());
                    if (file.exists()) {
                        File[] listFiles = file.listFiles();
                        if (listFiles == null || listFiles.length == 0) {
                            try {
                                if (file.isDirectory()) {
                                    file.delete();
                                }
                            } catch (Throwable th) {
                                UMCrashManager.reportCrash(context, th);
                            }
                            return;
                        }
                        String envelopeDirPath = getEnvelopeDirPath(context);
                        for (int i = 0; i < listFiles.length; i++) {
                            File file2 = listFiles[i];
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append(envelopeDirPath);
                            stringBuilder2.append(HttpUtils.PATHS_SEPARATOR);
                            stringBuilder2.append(listFiles[i].getName());
                            file2.renameTo(new File(stringBuilder2.toString()));
                        }
                        if (file.isDirectory()) {
                            file.delete();
                        }
                    }
                }
            } catch (Throwable th2) {
                UMCrashManager.reportCrash(context, th2);
            }
        }
    }

    public static byte[] toByteArray(String str) throws IOException {
        byte[] bArr;
        Throwable e;
        Context appContext = UMModuleRegister.getAppContext();
        synchronized (mEnvelopeFileLock) {
            FileChannel channel;
            try {
                channel = new RandomAccessFile(str, "r").getChannel();
                try {
                    MappedByteBuffer load = channel.map(MapMode.READ_ONLY, 0, channel.size()).load();
                    System.out.println(load.isLoaded());
                    bArr = new byte[((int) channel.size())];
                    if (load.remaining() > 0) {
                        load.get(bArr, 0, load.remaining());
                    }
                    try {
                        channel.close();
                    } catch (Throwable th) {
                        UMCrashManager.reportCrash(appContext, th);
                    }
                } catch (IOException e2) {
                    e = e2;
                    try {
                        UMCrashManager.reportCrash(appContext, e);
                        throw e;
                    } catch (Throwable th2) {
                        e = th2;
                        try {
                            channel.close();
                        } catch (Throwable th3) {
                            UMCrashManager.reportCrash(appContext, th3);
                        }
                        throw e;
                    }
                }
            } catch (IOException th32) {
                e = th32;
                channel = null;
                UMCrashManager.reportCrash(appContext, e);
                throw e;
            } catch (Throwable th322) {
                e = th322;
                channel = null;
                channel.close();
                throw e;
            }
        }
        return bArr;
    }

    private static void updateLastInstantBuildTime(Context context) {
        synchronized (mEnvelopeBuildTimeLock) {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            sharedPreferences.edit().putLong(KEY_LAST_INSTANT_SUCC_BUILD_TIME, System.currentTimeMillis()).commit();
        }
    }

    private static void updateLastSuccessfulBuildTime(Context context) {
        synchronized (mEnvelopeBuildTimeLock) {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            sharedPreferences.edit().putLong(KEY_LAST_SUCC_BUILD_TIME, System.currentTimeMillis()).commit();
        }
    }
}
