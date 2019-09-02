package com.loc;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import java.security.MessageDigest;
import java.util.Locale;

/* compiled from: AppInfo */
public final class OO00o00 {
    static String O000000o = null;
    static boolean O00000Oo = false;
    private static String O00000o = "";
    private static String O00000o0 = "";
    private static String O00000oO = "";
    private static String O00000oo = "";

    public static String O000000o(Context context) {
        try {
            return O0000OOo(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return O00000oo;
        }
    }

    static void O000000o(final Context context, final String str) {
        if (!TextUtils.isEmpty(str)) {
            O00000oo = str;
            if (context != null) {
                O0000o.O00000o().submit(new Runnable() {
                    /* JADX WARNING: Removed duplicated region for block: B:30:0x0057 A:{SYNTHETIC, Splitter:B:30:0x0057} */
                    /* JADX WARNING: Removed duplicated region for block: B:23:0x004c A:{SYNTHETIC, Splitter:B:23:0x004c} */
                    public final void run() {
                        /*
                        r5 = this;
                        r0 = 0;
                        r1 = r2;	 Catch:{ Throwable -> 0x0042 }
                        r2 = "k.store";
                        r1 = com.loc.O0000o00.O00000o0(r1, r2);	 Catch:{ Throwable -> 0x0042 }
                        r2 = new java.io.File;	 Catch:{ Throwable -> 0x0042 }
                        r2.<init>(r1);	 Catch:{ Throwable -> 0x0042 }
                        r1 = r2.getParentFile();	 Catch:{ Throwable -> 0x0042 }
                        r1 = r1.exists();	 Catch:{ Throwable -> 0x0042 }
                        if (r1 != 0) goto L_0x001f;
                    L_0x0018:
                        r1 = r2.getParentFile();	 Catch:{ Throwable -> 0x0042 }
                        r1.mkdirs();	 Catch:{ Throwable -> 0x0042 }
                    L_0x001f:
                        r1 = new java.io.FileOutputStream;	 Catch:{ Throwable -> 0x0042 }
                        r1.<init>(r2);	 Catch:{ Throwable -> 0x0042 }
                        r0 = r3;	 Catch:{ Throwable -> 0x003b, all -> 0x0036 }
                        r0 = com.loc.OO0o000.O000000o(r0);	 Catch:{ Throwable -> 0x003b, all -> 0x0036 }
                        r1.write(r0);	 Catch:{ Throwable -> 0x003b, all -> 0x0036 }
                        r1.close();	 Catch:{ Throwable -> 0x0031 }
                        return;
                    L_0x0031:
                        r0 = move-exception;
                        r0.printStackTrace();
                        return;
                    L_0x0036:
                        r0 = move-exception;
                        r4 = r1;
                        r1 = r0;
                        r0 = r4;
                        goto L_0x0055;
                    L_0x003b:
                        r0 = move-exception;
                        r4 = r1;
                        r1 = r0;
                        r0 = r4;
                        goto L_0x0043;
                    L_0x0040:
                        r1 = move-exception;
                        goto L_0x0055;
                    L_0x0042:
                        r1 = move-exception;
                    L_0x0043:
                        r2 = "AI";
                        r3 = "stf";
                        com.loc.O0000Oo.O000000o(r1, r2, r3);	 Catch:{ all -> 0x0040 }
                        if (r0 == 0) goto L_0x0054;
                    L_0x004c:
                        r0.close();	 Catch:{ Throwable -> 0x0050 }
                        return;
                    L_0x0050:
                        r0 = move-exception;
                        r0.printStackTrace();
                    L_0x0054:
                        return;
                    L_0x0055:
                        if (r0 == 0) goto L_0x005f;
                    L_0x0057:
                        r0.close();	 Catch:{ Throwable -> 0x005b }
                        goto L_0x005f;
                    L_0x005b:
                        r0 = move-exception;
                        r0.printStackTrace();
                    L_0x005f:
                        throw r1;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.loc.OO00o00$AnonymousClass1.run():void");
                    }
                });
            }
        }
    }

    public static void O000000o(String str) {
        O00000o = str;
    }

    static boolean O000000o() {
        try {
            if (O00000Oo) {
                return true;
            }
            if (O00000Oo(O000000o)) {
                O00000Oo = true;
                return true;
            } else if (!TextUtils.isEmpty(O000000o)) {
                O00000Oo = false;
                O000000o = null;
                return false;
            } else if (O00000Oo(O00000o)) {
                O00000Oo = true;
                return true;
            } else {
                if (!TextUtils.isEmpty(O00000o)) {
                    O00000Oo = false;
                    O00000o = null;
                    return false;
                }
                return true;
            }
        } catch (Throwable unused) {
        }
    }

    public static String O00000Oo(Context context) {
        try {
            if (!"".equals(O00000o0)) {
                return O00000o0;
            }
            PackageManager packageManager = context.getPackageManager();
            O00000o0 = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
            return O00000o0;
        } catch (Throwable th) {
            O0000Oo.O000000o(th, "AI", "gAN");
        }
    }

    private static boolean O00000Oo(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        str.toCharArray();
        for (char c : str.toCharArray()) {
            if (('A' > c || c > 'z') && (('0' > c || c > ':') && c != '.')) {
                try {
                    O0000o.O00000Oo(OO0o000.O000000o(), str, "errorPackage");
                } catch (Throwable unused) {
                }
                return false;
            }
        }
        return true;
    }

    public static String O00000o(Context context) {
        try {
            if (!"".equals(O00000oO)) {
                return O00000oO;
            }
            O00000oO = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            return O00000oO == null ? "" : O00000oO;
        } catch (Throwable th) {
            O0000Oo.O000000o(th, "AI", "gAV");
        }
    }

    public static String O00000o0(Context context) {
        try {
            if (O00000o != null && !"".equals(O00000o)) {
                return O00000o;
            }
            String packageName = context.getPackageName();
            O00000o = packageName;
            if (!O00000Oo(packageName)) {
                O00000o = context.getPackageName();
            }
            return O00000o;
        } catch (Throwable th) {
            O0000Oo.O000000o(th, "AI", "gpck");
        }
    }

    public static String O00000oO(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            int i = 0;
            byte[] digest = MessageDigest.getInstance("SHA1").digest(packageInfo.signatures[0].toByteArray());
            StringBuffer stringBuffer = new StringBuffer();
            while (i < digest.length) {
                String toUpperCase = Integer.toHexString(255 & digest[i]).toUpperCase(Locale.US);
                if (toUpperCase.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(toUpperCase);
                stringBuffer.append(":");
                i++;
            }
            String str = packageInfo.packageName;
            if (O00000Oo(str)) {
                str = packageInfo.packageName;
            }
            if (!TextUtils.isEmpty(O00000o)) {
                str = O00000o0(context);
            }
            stringBuffer.append(str);
            String stringBuffer2 = stringBuffer.toString();
            O000000o = stringBuffer2;
            return stringBuffer2;
        } catch (Throwable th) {
            O0000Oo.O000000o(th, "AI", "gsp");
            return O000000o;
        }
    }

    public static String O00000oo(Context context) {
        try {
            return O0000OOo(context);
        } catch (Throwable th) {
            O0000Oo.O000000o(th, "AI", "gKy");
            return O00000oo;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x006a A:{SYNTHETIC, Splitter:B:41:0x006a} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0052 A:{Catch:{ Throwable -> 0x0056, all -> 0x0067 }} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x005c A:{SYNTHETIC, Splitter:B:33:0x005c} */
    private static java.lang.String O0000O0o(android.content.Context r5) {
        /*
        r0 = "k.store";
        r5 = com.loc.O0000o00.O00000o0(r5, r0);
        r0 = new java.io.File;
        r0.<init>(r5);
        r5 = r0.exists();
        if (r5 != 0) goto L_0x0014;
    L_0x0011:
        r5 = "";
        return r5;
    L_0x0014:
        r5 = 0;
        r1 = new java.io.FileInputStream;	 Catch:{ Throwable -> 0x0041, all -> 0x003d }
        r1.<init>(r0);	 Catch:{ Throwable -> 0x0041, all -> 0x003d }
        r5 = r1.available();	 Catch:{ Throwable -> 0x003b }
        r5 = new byte[r5];	 Catch:{ Throwable -> 0x003b }
        r1.read(r5);	 Catch:{ Throwable -> 0x003b }
        r5 = com.loc.OO0o000.O000000o(r5);	 Catch:{ Throwable -> 0x003b }
        r2 = r5.length();	 Catch:{ Throwable -> 0x003b }
        r3 = 32;
        if (r2 != r3) goto L_0x0030;
    L_0x002f:
        goto L_0x0032;
    L_0x0030:
        r5 = "";
    L_0x0032:
        r1.close();	 Catch:{ Throwable -> 0x0036 }
        return r5;
    L_0x0036:
        r0 = move-exception;
        r0.printStackTrace();
        return r5;
    L_0x003b:
        r5 = move-exception;
        goto L_0x0045;
    L_0x003d:
        r0 = move-exception;
        r1 = r5;
        r5 = r0;
        goto L_0x0068;
    L_0x0041:
        r1 = move-exception;
        r4 = r1;
        r1 = r5;
        r5 = r4;
    L_0x0045:
        r2 = "AI";
        r3 = "gKe";
        com.loc.O0000Oo.O000000o(r5, r2, r3);	 Catch:{ all -> 0x0067 }
        r5 = r0.exists();	 Catch:{ Throwable -> 0x0056 }
        if (r5 == 0) goto L_0x005a;
    L_0x0052:
        r0.delete();	 Catch:{ Throwable -> 0x0056 }
        goto L_0x005a;
    L_0x0056:
        r5 = move-exception;
        r5.printStackTrace();	 Catch:{ all -> 0x0067 }
    L_0x005a:
        if (r1 == 0) goto L_0x0064;
    L_0x005c:
        r1.close();	 Catch:{ Throwable -> 0x0060 }
        goto L_0x0064;
    L_0x0060:
        r5 = move-exception;
        r5.printStackTrace();
    L_0x0064:
        r5 = "";
        return r5;
    L_0x0067:
        r5 = move-exception;
    L_0x0068:
        if (r1 == 0) goto L_0x0072;
    L_0x006a:
        r1.close();	 Catch:{ Throwable -> 0x006e }
        goto L_0x0072;
    L_0x006e:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x0072:
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.OO00o00.O0000O0o(android.content.Context):java.lang.String");
    }

    private static String O0000OOo(Context context) throws NameNotFoundException {
        if (O00000oo == null || O00000oo.equals("")) {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || applicationInfo.metaData == null) {
                return O00000oo;
            }
            String string = applicationInfo.metaData.getString("com.amap.api.v2.apikey");
            O00000oo = string;
            if (string == null) {
                O00000oo = O0000O0o(context);
            }
        }
        return O00000oo;
    }
}
