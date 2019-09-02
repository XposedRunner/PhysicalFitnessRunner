package com.qiyukf.nimlib.d.b.a;

import android.os.Build;
import android.support.v4.os.EnvironmentCompat;
import android.text.TextUtils;
import android.util.Log;

public final class g {
    private static String a;
    private static String b;

    static String a() {
        String str;
        Throwable th;
        StringBuilder stringBuilder;
        String str2 = EnvironmentCompat.MEDIA_UNKNOWN;
        try {
            if (a == null) {
                a("");
            }
            str = a;
            try {
                str2 = b();
                if (!(TextUtils.isEmpty(str2) || EnvironmentCompat.MEDIA_UNKNOWN.equals(str2))) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(str);
                    stringBuilder2.append("_");
                    stringBuilder2.append(b());
                    return stringBuilder2.toString();
                }
            } catch (Throwable th2) {
                th = th2;
                stringBuilder = new StringBuilder("RomUtils getNameVersion error=");
                stringBuilder.append(th.getMessage());
                Log.e("stat", stringBuilder.toString());
                th.printStackTrace();
                return str;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            str = str2;
            th = th4;
            stringBuilder = new StringBuilder("RomUtils getNameVersion error=");
            stringBuilder.append(th.getMessage());
            Log.e("stat", stringBuilder.toString());
            th.printStackTrace();
            return str;
        }
        return str;
    }

    private static boolean a(String str) {
        if (a == null) {
            String b = b("ro.miui.ui.version.name");
            b = b;
            if (TextUtils.isEmpty(b)) {
                b = b("ro.build.version.emui");
                b = b;
                if (TextUtils.isEmpty(b)) {
                    b = b("ro.build.version.opporom");
                    b = b;
                    if (TextUtils.isEmpty(b)) {
                        b = b("ro.vivo.os.version");
                        b = b;
                        if (TextUtils.isEmpty(b)) {
                            b = b("ro.smartisan.version");
                            b = b;
                            if (TextUtils.isEmpty(b)) {
                                b = Build.DISPLAY;
                                b = b;
                                if (b.toUpperCase().contains("FLYME")) {
                                    b = "FLYME";
                                } else {
                                    b = EnvironmentCompat.MEDIA_UNKNOWN;
                                    b = Build.MANUFACTURER.toUpperCase();
                                }
                            } else {
                                b = "SMARTISAN";
                            }
                        } else {
                            b = "VIVO";
                        }
                    } else {
                        b = "OPPO";
                    }
                } else {
                    b = "EMUI";
                }
            } else {
                b = "MIUI";
            }
            a = b;
        }
        return a.equals(str);
    }

    private static String b() {
        if (b == null) {
            a("");
        }
        return b;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x003a */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005c A:{SYNTHETIC, Splitter:B:26:0x005c} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:15:?, code skipped:
            r3 = new java.lang.StringBuilder("Unable to read rom prop ");
            r3.append(r5);
            android.util.Log.e("stat", r3.toString());
     */
    /* JADX WARNING: Missing block: B:16:0x004d, code skipped:
            if (r2 != null) goto L_0x004f;
     */
    /* JADX WARNING: Missing block: B:18:?, code skipped:
            r2.close();
     */
    /* JADX WARNING: Missing block: B:19:0x0052, code skipped:
            return null;
     */
    /* JADX WARNING: Missing block: B:20:0x0053, code skipped:
            r5 = move-exception;
     */
    /* JADX WARNING: Missing block: B:21:0x0054, code skipped:
            r5.printStackTrace();
     */
    /* JADX WARNING: Missing block: B:22:0x0057, code skipped:
            return null;
     */
    /* JADX WARNING: Missing block: B:23:0x0058, code skipped:
            r5 = th;
     */
    /* JADX WARNING: Missing block: B:24:0x0059, code skipped:
            r0 = r2;
     */
    private static java.lang.String b(java.lang.String r5) {
        /*
        r0 = 0;
        r1 = java.lang.Runtime.getRuntime();	 Catch:{ IOException -> 0x0039, all -> 0x0037 }
        r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0039, all -> 0x0037 }
        r3 = "getprop ";
        r2.<init>(r3);	 Catch:{ IOException -> 0x0039, all -> 0x0037 }
        r2.append(r5);	 Catch:{ IOException -> 0x0039, all -> 0x0037 }
        r2 = r2.toString();	 Catch:{ IOException -> 0x0039, all -> 0x0037 }
        r1 = r1.exec(r2);	 Catch:{ IOException -> 0x0039, all -> 0x0037 }
        r2 = new java.io.BufferedReader;	 Catch:{ IOException -> 0x0039, all -> 0x0037 }
        r3 = new java.io.InputStreamReader;	 Catch:{ IOException -> 0x0039, all -> 0x0037 }
        r1 = r1.getInputStream();	 Catch:{ IOException -> 0x0039, all -> 0x0037 }
        r3.<init>(r1);	 Catch:{ IOException -> 0x0039, all -> 0x0037 }
        r1 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r2.<init>(r3, r1);	 Catch:{ IOException -> 0x0039, all -> 0x0037 }
        r1 = r2.readLine();	 Catch:{ IOException -> 0x003a }
        r2.close();	 Catch:{ IOException -> 0x003a }
        r2.close();	 Catch:{ IOException -> 0x0032 }
        return r1;
    L_0x0032:
        r5 = move-exception;
        r5.printStackTrace();
        return r1;
    L_0x0037:
        r5 = move-exception;
        goto L_0x005a;
    L_0x0039:
        r2 = r0;
    L_0x003a:
        r1 = "stat";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0058 }
        r4 = "Unable to read rom prop ";
        r3.<init>(r4);	 Catch:{ all -> 0x0058 }
        r3.append(r5);	 Catch:{ all -> 0x0058 }
        r5 = r3.toString();	 Catch:{ all -> 0x0058 }
        android.util.Log.e(r1, r5);	 Catch:{ all -> 0x0058 }
        if (r2 == 0) goto L_0x0057;
    L_0x004f:
        r2.close();	 Catch:{ IOException -> 0x0053 }
        return r0;
    L_0x0053:
        r5 = move-exception;
        r5.printStackTrace();
    L_0x0057:
        return r0;
    L_0x0058:
        r5 = move-exception;
        r0 = r2;
    L_0x005a:
        if (r0 == 0) goto L_0x0064;
    L_0x005c:
        r0.close();	 Catch:{ IOException -> 0x0060 }
        goto L_0x0064;
    L_0x0060:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x0064:
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.d.b.a.g.b(java.lang.String):java.lang.String");
    }
}
