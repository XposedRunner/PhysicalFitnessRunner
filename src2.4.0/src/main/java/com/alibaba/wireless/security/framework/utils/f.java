package com.alibaba.wireless.security.framework.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build.VERSION;
import android.os.Process;
import java.lang.reflect.Method;

public class f {
    private static String[] a = new String[]{"armeabi", "armeabi-v7a", "x86", "arm64-v8a", "x86_64"};
    private static boolean b = true;
    private static boolean c = false;
    private static boolean d = true;
    private static boolean e = false;
    private static boolean f = true;
    private static boolean g = false;
    private static boolean h = true;
    private static boolean i;

    public static String a(ClassLoader classLoader, String str) {
        String str2;
        if (classLoader == null || str == null || "".equals(str)) {
            str2 = null;
        } else {
            str2 = a(classLoader, str, true);
            if (str2 == null) {
                return a(classLoader, str, false);
            }
        }
        return str2;
    }

    private static String a(ClassLoader classLoader, String str, boolean z) {
        String str2 = null;
        if (classLoader != null) {
            Method method;
            if (z) {
                try {
                    method = classLoader.getClass().getMethod("findLibrary", new Class[]{String.class});
                } catch (Exception unused) {
                }
            } else {
                method = classLoader.getClass().getDeclaredMethod("findLibrary", new Class[]{String.class});
            }
            if (method == null) {
                return null;
            }
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            Object invoke = method.invoke(classLoader, new Object[]{str});
            if (invoke == null) {
                return null;
            }
            if (invoke instanceof String) {
                str2 = (String) invoke;
            }
        }
        return str2;
    }

    public static boolean a() {
        return VERSION.SDK_INT > 27 || "P".equalsIgnoreCase(VERSION.RELEASE);
    }

    /* JADX WARNING: Missing block: B:10:0x0021, code skipped:
            if ((r3.applicationInfo.flags & 128) == 0) goto L_0x0025;
     */
    public static boolean a(android.content.Context r3) {
        /*
        r0 = b;
        if (r0 == 0) goto L_0x0029;
    L_0x0004:
        r0 = r3.getPackageManager();
        r1 = 0;
        r3 = r3.getPackageName();	 Catch:{ Throwable -> 0x0024 }
        r3 = r0.getPackageInfo(r3, r1);	 Catch:{ Throwable -> 0x0024 }
        r0 = 1;
        if (r3 == 0) goto L_0x0024;
    L_0x0014:
        r2 = r3.applicationInfo;	 Catch:{ Throwable -> 0x0024 }
        r2 = r2.flags;	 Catch:{ Throwable -> 0x0024 }
        r2 = r2 & r0;
        if (r2 == 0) goto L_0x0024;
    L_0x001b:
        r3 = r3.applicationInfo;	 Catch:{ Throwable -> 0x0024 }
        r3 = r3.flags;	 Catch:{ Throwable -> 0x0024 }
        r3 = r3 & 128;
        if (r3 != 0) goto L_0x0024;
    L_0x0023:
        goto L_0x0025;
    L_0x0024:
        r0 = r1;
    L_0x0025:
        c = r0;
        b = r1;
    L_0x0029:
        r3 = c;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.utils.f.a(android.content.Context):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0060 A:{SYNTHETIC, Splitter:B:32:0x0060} */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0066 A:{SYNTHETIC, Splitter:B:37:0x0066} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0060 A:{SYNTHETIC, Splitter:B:32:0x0060} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004e A:{Splitter:B:3:0x0007, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:16:0x0046, code skipped:
            r10 = e;
     */
    /* JADX WARNING: Missing block: B:21:0x004e, code skipped:
            r10 = th;
     */
    /* JADX WARNING: Missing block: B:33:?, code skipped:
            r1.close();
     */
    /* JADX WARNING: Missing block: B:38:?, code skipped:
            r2.close();
     */
    public static boolean a(java.lang.String r10, java.lang.String r11, java.io.File r12) {
        /*
        r0 = 0;
        r1 = 0;
        r2 = new java.util.zip.ZipFile;	 Catch:{ IOException -> 0x0057 }
        r2.<init>(r10);	 Catch:{ IOException -> 0x0057 }
        r10 = a;	 Catch:{ IOException -> 0x0050, all -> 0x004e }
        r1 = r10.length;	 Catch:{ IOException -> 0x0050, all -> 0x004e }
        r3 = r0;
    L_0x000b:
        if (r0 >= r1) goto L_0x0048;
    L_0x000d:
        r4 = r10[r0];	 Catch:{ IOException -> 0x0046, all -> 0x004e }
        r5 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0046, all -> 0x004e }
        r5.<init>();	 Catch:{ IOException -> 0x0046, all -> 0x004e }
        r6 = "lib";
        r5.append(r6);	 Catch:{ IOException -> 0x0046, all -> 0x004e }
        r6 = java.io.File.separator;	 Catch:{ IOException -> 0x0046, all -> 0x004e }
        r5.append(r6);	 Catch:{ IOException -> 0x0046, all -> 0x004e }
        r5.append(r4);	 Catch:{ IOException -> 0x0046, all -> 0x004e }
        r4 = java.io.File.separator;	 Catch:{ IOException -> 0x0046, all -> 0x004e }
        r5.append(r4);	 Catch:{ IOException -> 0x0046, all -> 0x004e }
        r5.append(r11);	 Catch:{ IOException -> 0x0046, all -> 0x004e }
        r4 = r5.toString();	 Catch:{ IOException -> 0x0046, all -> 0x004e }
        r4 = r2.getEntry(r4);	 Catch:{ IOException -> 0x0046, all -> 0x004e }
        if (r4 == 0) goto L_0x0043;
    L_0x0033:
        r5 = r4.getSize();	 Catch:{ IOException -> 0x0046, all -> 0x004e }
        r7 = 0;
        r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));
        if (r9 != 0) goto L_0x003e;
    L_0x003d:
        goto L_0x0043;
    L_0x003e:
        r4 = a(r2, r4, r12);	 Catch:{ IOException -> 0x0046, all -> 0x004e }
        r3 = r4;
    L_0x0043:
        r0 = r0 + 1;
        goto L_0x000b;
    L_0x0046:
        r10 = move-exception;
        goto L_0x0052;
    L_0x0048:
        if (r2 == 0) goto L_0x0063;
    L_0x004a:
        r2.close();	 Catch:{ IOException -> 0x0063 }
        return r3;
    L_0x004e:
        r10 = move-exception;
        goto L_0x0064;
    L_0x0050:
        r10 = move-exception;
        r3 = r0;
    L_0x0052:
        r1 = r2;
        goto L_0x0059;
    L_0x0054:
        r10 = move-exception;
        r2 = r1;
        goto L_0x0064;
    L_0x0057:
        r10 = move-exception;
        r3 = r0;
    L_0x0059:
        r11 = "";
        com.alibaba.wireless.security.framework.utils.a.a(r11, r10);	 Catch:{ all -> 0x0054 }
        if (r1 == 0) goto L_0x0063;
    L_0x0060:
        r1.close();	 Catch:{ IOException -> 0x0063 }
    L_0x0063:
        return r3;
    L_0x0064:
        if (r2 == 0) goto L_0x0069;
    L_0x0066:
        r2.close();	 Catch:{ IOException -> 0x0069 }
    L_0x0069:
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.utils.f.a(java.lang.String, java.lang.String, java.io.File):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:65:0x00aa A:{SYNTHETIC, Splitter:B:65:0x00aa} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00af A:{SYNTHETIC, Splitter:B:69:0x00af} */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x009a A:{SYNTHETIC, Splitter:B:52:0x009a} */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x009f A:{SYNTHETIC, Splitter:B:56:0x009f} */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00aa A:{SYNTHETIC, Splitter:B:65:0x00aa} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00af A:{SYNTHETIC, Splitter:B:69:0x00af} */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x009a A:{SYNTHETIC, Splitter:B:52:0x009a} */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x009f A:{SYNTHETIC, Splitter:B:56:0x009f} */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00aa A:{SYNTHETIC, Splitter:B:65:0x00aa} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00af A:{SYNTHETIC, Splitter:B:69:0x00af} */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x009a A:{SYNTHETIC, Splitter:B:52:0x009a} */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x009f A:{SYNTHETIC, Splitter:B:56:0x009f} */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00aa A:{SYNTHETIC, Splitter:B:65:0x00aa} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00af A:{SYNTHETIC, Splitter:B:69:0x00af} */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x009a A:{SYNTHETIC, Splitter:B:52:0x009a} */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x009f A:{SYNTHETIC, Splitter:B:56:0x009f} */
    public static boolean a(java.util.zip.ZipFile r8, java.util.zip.ZipEntry r9, java.io.File r10) {
        /*
        r0 = 0;
        if (r8 == 0) goto L_0x00d4;
    L_0x0003:
        if (r9 == 0) goto L_0x00d4;
    L_0x0005:
        if (r10 != 0) goto L_0x0008;
    L_0x0007:
        return r0;
    L_0x0008:
        r1 = 1;
        r2 = 0;
        r3 = new java.io.File;	 Catch:{ Exception -> 0x00a6, all -> 0x0095 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00a6, all -> 0x0095 }
        r4.<init>();	 Catch:{ Exception -> 0x00a6, all -> 0x0095 }
        r5 = r10.getAbsolutePath();	 Catch:{ Exception -> 0x00a6, all -> 0x0095 }
        r4.append(r5);	 Catch:{ Exception -> 0x00a6, all -> 0x0095 }
        r5 = ".tmp.";
        r4.append(r5);	 Catch:{ Exception -> 0x00a6, all -> 0x0095 }
        r5 = android.os.Process.myPid();	 Catch:{ Exception -> 0x00a6, all -> 0x0095 }
        r4.append(r5);	 Catch:{ Exception -> 0x00a6, all -> 0x0095 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x00a6, all -> 0x0095 }
        r3.<init>(r4);	 Catch:{ Exception -> 0x00a6, all -> 0x0095 }
        r4 = r3.exists();	 Catch:{ Exception -> 0x0093, all -> 0x0090 }
        if (r4 == 0) goto L_0x0034;
    L_0x0031:
        r3.delete();	 Catch:{ Exception -> 0x0093, all -> 0x0090 }
    L_0x0034:
        r8 = r8.getInputStream(r9);	 Catch:{ Exception -> 0x0093, all -> 0x0090 }
        r4 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x008d, all -> 0x0088 }
        r4.<init>(r3);	 Catch:{ Exception -> 0x008d, all -> 0x0088 }
        r5 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r5 = new byte[r5];	 Catch:{ Exception -> 0x008e, all -> 0x0086 }
    L_0x0041:
        r6 = r8.read(r5);	 Catch:{ Exception -> 0x008e, all -> 0x0086 }
        r7 = -1;
        if (r6 == r7) goto L_0x004c;
    L_0x0048:
        r4.write(r5, r0, r6);	 Catch:{ Exception -> 0x008e, all -> 0x0086 }
        goto L_0x0041;
    L_0x004c:
        r8.close();	 Catch:{ Exception -> 0x008e, all -> 0x0086 }
        r4.flush();	 Catch:{ Exception -> 0x00a8, all -> 0x0084 }
        r4.close();	 Catch:{ Exception -> 0x00a8, all -> 0x0084 }
        r8 = r10.exists();	 Catch:{ Exception -> 0x0093, all -> 0x0090 }
        if (r8 == 0) goto L_0x0069;
    L_0x005b:
        r4 = r10.length();	 Catch:{ Exception -> 0x0093, all -> 0x0090 }
        r6 = r9.getSize();	 Catch:{ Exception -> 0x0093, all -> 0x0090 }
        r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r8 != 0) goto L_0x0069;
    L_0x0067:
        r0 = r1;
        goto L_0x00b2;
    L_0x0069:
        r8 = r3.exists();	 Catch:{ Exception -> 0x0093, all -> 0x0090 }
        if (r8 == 0) goto L_0x00b2;
    L_0x006f:
        r4 = r3.length();	 Catch:{ Exception -> 0x0093, all -> 0x0090 }
        r6 = r9.getSize();	 Catch:{ Exception -> 0x0093, all -> 0x0090 }
        r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r8 != 0) goto L_0x00b2;
    L_0x007b:
        r10.delete();	 Catch:{ Exception -> 0x0093, all -> 0x0090 }
        r8 = r3.renameTo(r10);	 Catch:{ Exception -> 0x0093, all -> 0x0090 }
        r0 = r8;
        goto L_0x00b2;
    L_0x0084:
        r8 = move-exception;
        goto L_0x0098;
    L_0x0086:
        r9 = move-exception;
        goto L_0x008a;
    L_0x0088:
        r9 = move-exception;
        r4 = r2;
    L_0x008a:
        r2 = r8;
        r8 = r9;
        goto L_0x0098;
    L_0x008d:
        r4 = r2;
    L_0x008e:
        r2 = r8;
        goto L_0x00a8;
    L_0x0090:
        r8 = move-exception;
        r4 = r2;
        goto L_0x0098;
    L_0x0093:
        r4 = r2;
        goto L_0x00a8;
    L_0x0095:
        r8 = move-exception;
        r3 = r2;
        r4 = r3;
    L_0x0098:
        if (r2 == 0) goto L_0x009d;
    L_0x009a:
        r2.close();	 Catch:{ Exception -> 0x009d }
    L_0x009d:
        if (r4 == 0) goto L_0x00a2;
    L_0x009f:
        r4.close();	 Catch:{ Exception -> 0x00a2 }
    L_0x00a2:
        r3.delete();
        throw r8;
    L_0x00a6:
        r3 = r2;
        r4 = r3;
    L_0x00a8:
        if (r2 == 0) goto L_0x00ad;
    L_0x00aa:
        r2.close();	 Catch:{ Exception -> 0x00ad }
    L_0x00ad:
        if (r4 == 0) goto L_0x00b2;
    L_0x00af:
        r4.close();	 Catch:{ Exception -> 0x00b2 }
    L_0x00b2:
        r3.delete();
        if (r0 != 0) goto L_0x00d4;
    L_0x00b7:
        r8 = r10.exists();
        if (r8 == 0) goto L_0x00d4;
    L_0x00bd:
        r2 = r10.length();
        r4 = 0;
        r8 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r8 <= 0) goto L_0x00d4;
    L_0x00c7:
        r2 = r10.length();
        r8 = r9.getSize();
        r10 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));
        if (r10 != 0) goto L_0x00d4;
    L_0x00d3:
        r0 = r1;
    L_0x00d4:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.utils.f.a(java.util.zip.ZipFile, java.util.zip.ZipEntry, java.io.File):boolean");
    }

    public static boolean b(Context context) {
        if (f) {
            boolean z;
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                if (!(packageInfo == null || (packageInfo.applicationInfo.flags & 128) == 0)) {
                    z = true;
                    g = z;
                    f = false;
                }
            } catch (Throwable unused) {
            }
            z = false;
            g = z;
            f = false;
        }
        return g;
    }

    public static boolean c(Context context) {
        if (h) {
            try {
                i = d(context).equals(context.getPackageName());
                h = false;
            } catch (Exception unused) {
            }
        }
        return i;
    }

    public static String d(Context context) {
        String str = "";
        try {
            int myPid = Process.myPid();
            if (context == null) {
                return str;
            }
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName != null ? runningAppProcessInfo.processName : "";
                }
            }
            return str;
        } catch (Throwable unused) {
            return str;
        }
    }
}
