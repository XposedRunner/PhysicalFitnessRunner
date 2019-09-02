package com.tencent.open.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import com.tencent.connect.common.Constants;
import com.tencent.open.a.f;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;

/* compiled from: ProGuard */
public class h {
    public static int a(String str) {
        return "shareToQQ".equals(str) ? Constants.REQUEST_QQ_SHARE : "shareToQzone".equals(str) ? Constants.REQUEST_QZONE_SHARE : "addToQQFavorites".equals(str) ? Constants.REQUEST_QQ_FAVORITES : "sendToMyComputer".equals(str) ? Constants.REQUEST_SEND_TO_MY_COMPUTER : "shareToTroopBar".equals(str) ? Constants.REQUEST_SHARE_TO_TROOP_BAR : "action_login".equals(str) ? Constants.REQUEST_LOGIN : "action_request".equals(str) ? Constants.REQUEST_API : -1;
    }

    public static int a(String str, String str2) {
        if (str == null && str2 == null) {
            return 0;
        }
        if (str != null && str2 == null) {
            return 1;
        }
        if (str == null && str2 != null) {
            return -1;
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int i = 0;
        while (i < split.length && i < split2.length) {
            try {
                int parseInt = Integer.parseInt(split[i]);
                int parseInt2 = Integer.parseInt(split2[i]);
                if (parseInt < parseInt2) {
                    return -1;
                }
                if (parseInt > parseInt2) {
                    return 1;
                }
                i++;
            } catch (NumberFormatException unused) {
                return str.compareTo(str2);
            }
        }
        return split.length > i ? 1 : split2.length > i ? -1 : 0;
    }

    private static long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr, 0, bArr.length);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
                j += (long) read;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("-->copy, copyed size is: ");
                stringBuilder.append(j);
                f.c("openSDK_LOG.SystemUtils", stringBuilder.toString());
                return j;
            }
        }
    }

    public static String a(int i) {
        return i == Constants.REQUEST_QQ_SHARE ? "shareToQQ" : i == Constants.REQUEST_QZONE_SHARE ? "shareToQzone" : i == Constants.REQUEST_QQ_FAVORITES ? "addToQQFavorites" : i == Constants.REQUEST_SEND_TO_MY_COMPUTER ? "sendToMyComputer" : i == Constants.REQUEST_SHARE_TO_TROOP_BAR ? "shareToTroopBar" : i == Constants.REQUEST_LOGIN ? "action_login" : i == Constants.REQUEST_API ? "action_request" : null;
    }

    public static String a(Context context) {
        return context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
    }

    public static String a(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (NameNotFoundException unused) {
            return null;
        }
    }

    public static boolean a(Context context, Intent intent) {
        boolean z = false;
        if (context == null || intent == null) {
            return false;
        }
        if (context.getPackageManager().queryIntentActivities(intent, 0).size() != 0) {
            z = true;
        }
        return z;
    }

    public static boolean a(Context context, String str, String str2) {
        f.a("openSDK_LOG.SystemUtils", "OpenUi, validateAppSignatureForPackage");
        try {
            for (Signature toCharsString : context.getPackageManager().getPackageInfo(str, 64).signatures) {
                if (j.f(toCharsString.toCharsString()).equals(str2)) {
                    return true;
                }
            }
            return false;
        } catch (NameNotFoundException unused) {
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x00c5 A:{SYNTHETIC, Splitter:B:58:0x00c5} */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00ca A:{SYNTHETIC, Splitter:B:62:0x00ca} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00b8 A:{SYNTHETIC, Splitter:B:47:0x00b8} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00bd A:{SYNTHETIC, Splitter:B:51:0x00bd} */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00c5 A:{SYNTHETIC, Splitter:B:58:0x00c5} */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00ca A:{SYNTHETIC, Splitter:B:62:0x00ca} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00b8 A:{SYNTHETIC, Splitter:B:47:0x00b8} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00bd A:{SYNTHETIC, Splitter:B:51:0x00bd} */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00c5 A:{SYNTHETIC, Splitter:B:58:0x00c5} */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00ca A:{SYNTHETIC, Splitter:B:62:0x00ca} */
    @android.annotation.SuppressLint({"SdCardPath"})
    public static boolean a(java.lang.String r8, java.lang.String r9, int r10) {
        /*
        r0 = "openSDK_LOG.SystemUtils";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "-->extractSecureLib, libName: ";
        r1.append(r2);
        r1.append(r8);
        r1 = r1.toString();
        com.tencent.open.a.f.c(r0, r1);
        r0 = com.tencent.open.utils.e.a();
        r1 = 0;
        if (r0 != 0) goto L_0x0025;
    L_0x001d:
        r8 = "openSDK_LOG.SystemUtils";
        r9 = "-->extractSecureLib, global context is null. ";
        com.tencent.open.a.f.c(r8, r9);
        return r1;
    L_0x0025:
        r2 = "secure_lib";
        r2 = r0.getSharedPreferences(r2, r1);
        r3 = new java.io.File;
        r4 = r0.getFilesDir();
        r3.<init>(r4, r9);
        r4 = r3.exists();
        r5 = 1;
        if (r4 != 0) goto L_0x0050;
    L_0x003b:
        r4 = r3.getParentFile();
        if (r4 == 0) goto L_0x0077;
    L_0x0041:
        r4 = r4.mkdirs();
        if (r4 == 0) goto L_0x0077;
    L_0x0047:
        r3.createNewFile();	 Catch:{ IOException -> 0x004b }
        goto L_0x0077;
    L_0x004b:
        r3 = move-exception;
        r3.printStackTrace();
        goto L_0x0077;
    L_0x0050:
        r3 = "version";
        r3 = r2.getInt(r3, r1);
        r4 = "openSDK_LOG.SystemUtils";
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "-->extractSecureLib, libVersion: ";
        r6.append(r7);
        r6.append(r10);
        r7 = " | oldVersion: ";
        r6.append(r7);
        r6.append(r3);
        r6 = r6.toString();
        com.tencent.open.a.f.c(r4, r6);
        if (r10 != r3) goto L_0x0077;
    L_0x0076:
        return r5;
    L_0x0077:
        r3 = 0;
        r4 = r0.getAssets();	 Catch:{ Exception -> 0x00ad, all -> 0x00a9 }
        r8 = r4.open(r8);	 Catch:{ Exception -> 0x00ad, all -> 0x00a9 }
        r9 = r0.openFileOutput(r9, r1);	 Catch:{ Exception -> 0x00a5, all -> 0x00a2 }
        a(r8, r9);	 Catch:{ Exception -> 0x00a0, all -> 0x009e }
        r0 = r2.edit();	 Catch:{ Exception -> 0x00a0, all -> 0x009e }
        r2 = "version";
        r0.putInt(r2, r10);	 Catch:{ Exception -> 0x00a0, all -> 0x009e }
        r0.commit();	 Catch:{ Exception -> 0x00a0, all -> 0x009e }
        if (r8 == 0) goto L_0x0098;
    L_0x0095:
        r8.close();	 Catch:{ IOException -> 0x0098 }
    L_0x0098:
        if (r9 == 0) goto L_0x009d;
    L_0x009a:
        r9.close();	 Catch:{ IOException -> 0x009d }
    L_0x009d:
        return r5;
    L_0x009e:
        r10 = move-exception;
        goto L_0x00c3;
    L_0x00a0:
        r10 = move-exception;
        goto L_0x00a7;
    L_0x00a2:
        r10 = move-exception;
        r9 = r3;
        goto L_0x00c3;
    L_0x00a5:
        r10 = move-exception;
        r9 = r3;
    L_0x00a7:
        r3 = r8;
        goto L_0x00af;
    L_0x00a9:
        r10 = move-exception;
        r8 = r3;
        r9 = r8;
        goto L_0x00c3;
    L_0x00ad:
        r10 = move-exception;
        r9 = r3;
    L_0x00af:
        r8 = "openSDK_LOG.SystemUtils";
        r0 = "-->extractSecureLib, when copy lib execption.";
        com.tencent.open.a.f.b(r8, r0, r10);	 Catch:{ all -> 0x00c1 }
        if (r3 == 0) goto L_0x00bb;
    L_0x00b8:
        r3.close();	 Catch:{ IOException -> 0x00bb }
    L_0x00bb:
        if (r9 == 0) goto L_0x00c0;
    L_0x00bd:
        r9.close();	 Catch:{ IOException -> 0x00c0 }
    L_0x00c0:
        return r1;
    L_0x00c1:
        r10 = move-exception;
        r8 = r3;
    L_0x00c3:
        if (r8 == 0) goto L_0x00c8;
    L_0x00c5:
        r8.close();	 Catch:{ IOException -> 0x00c8 }
    L_0x00c8:
        if (r9 == 0) goto L_0x00cd;
    L_0x00ca:
        r9.close();	 Catch:{ IOException -> 0x00cd }
    L_0x00cd:
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.utils.h.a(java.lang.String, java.lang.String, int):boolean");
    }

    public static String b(Context context, String str) {
        String a;
        Exception e;
        f.a("openSDK_LOG.SystemUtils", "OpenUi, getSignValidString");
        String str2 = "";
        try {
            String packageName = context.getPackageName();
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(packageName, 64).signatures;
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(signatureArr[0].toByteArray());
            a = j.a(instance.digest());
            instance.reset();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("-->sign: ");
            stringBuilder.append(a);
            f.a("openSDK_LOG.SystemUtils", stringBuilder.toString());
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(packageName);
            stringBuilder2.append("_");
            stringBuilder2.append(a);
            stringBuilder2.append("_");
            stringBuilder2.append(str);
            stringBuilder2.append("");
            instance.update(j.i(stringBuilder2.toString()));
            a = j.a(instance.digest());
            try {
                instance.reset();
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append("-->signEncryped: ");
                stringBuilder3.append(a);
                f.a("openSDK_LOG.SystemUtils", stringBuilder3.toString());
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            a = str2;
            e.printStackTrace();
            f.b("openSDK_LOG.SystemUtils", "OpenUi, getSignValidString error", e);
            return a;
        }
        return a;
    }

    public static int c(Context context, String str) {
        return a(a(context, "com.tencent.mobileqq"), str);
    }

    public static int d(Context context, String str) {
        return a(a(context, Constants.PACKAGE_TIM), str);
    }
}
