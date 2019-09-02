package com.qiyukf.nimlib.d.a.d;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.util.List;

public final class c {
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0059 A:{SYNTHETIC, Splitter:B:28:0x0059} */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004d A:{SYNTHETIC, Splitter:B:19:0x004d} */
    private static java.lang.String a() {
        /*
        r0 = 0;
        r1 = android.os.Process.myPid();	 Catch:{ Exception -> 0x0056, all -> 0x004a }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0056, all -> 0x004a }
        r3 = "/proc/";
        r2.<init>(r3);	 Catch:{ Exception -> 0x0056, all -> 0x004a }
        r2.append(r1);	 Catch:{ Exception -> 0x0056, all -> 0x004a }
        r1 = "/cmdline";
        r2.append(r1);	 Catch:{ Exception -> 0x0056, all -> 0x004a }
        r1 = r2.toString();	 Catch:{ Exception -> 0x0056, all -> 0x004a }
        r2 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x0056, all -> 0x004a }
        r3 = new java.io.InputStreamReader;	 Catch:{ Exception -> 0x0056, all -> 0x004a }
        r4 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x0056, all -> 0x004a }
        r4.<init>(r1);	 Catch:{ Exception -> 0x0056, all -> 0x004a }
        r1 = "iso-8859-1";
        r3.<init>(r4, r1);	 Catch:{ Exception -> 0x0056, all -> 0x004a }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0056, all -> 0x004a }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0057, all -> 0x0046 }
        r1.<init>();	 Catch:{ Exception -> 0x0057, all -> 0x0046 }
    L_0x002e:
        r3 = r2.read();	 Catch:{ Exception -> 0x0057, all -> 0x0046 }
        if (r3 <= 0) goto L_0x0039;
    L_0x0034:
        r3 = (char) r3;	 Catch:{ Exception -> 0x0057, all -> 0x0046 }
        r1.append(r3);	 Catch:{ Exception -> 0x0057, all -> 0x0046 }
        goto L_0x002e;
    L_0x0039:
        r1 = r1.toString();	 Catch:{ Exception -> 0x0057, all -> 0x0046 }
        r2.close();	 Catch:{ IOException -> 0x0041 }
        return r1;
    L_0x0041:
        r0 = move-exception;
        r0.printStackTrace();
        return r1;
    L_0x0046:
        r0 = move-exception;
        r1 = r0;
        r0 = r2;
        goto L_0x004b;
    L_0x004a:
        r1 = move-exception;
    L_0x004b:
        if (r0 == 0) goto L_0x0055;
    L_0x004d:
        r0.close();	 Catch:{ IOException -> 0x0051 }
        goto L_0x0055;
    L_0x0051:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x0055:
        throw r1;
    L_0x0056:
        r2 = r0;
    L_0x0057:
        if (r2 == 0) goto L_0x0061;
    L_0x0059:
        r2.close();	 Catch:{ IOException -> 0x005d }
        return r0;
    L_0x005d:
        r1 = move-exception;
        r1.printStackTrace();
    L_0x0061:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.d.a.d.c.a():java.lang.String");
    }

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        String packageName = context.getApplicationContext().getPackageName();
        Object a = a();
        if (a == null) {
            a = b(context);
        }
        return packageName.equals(a);
    }

    private static String b(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return null;
        }
        CharSequence charSequence = null;
        for (int i = 0; i < 2; i++) {
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
        return null;
    }
}
