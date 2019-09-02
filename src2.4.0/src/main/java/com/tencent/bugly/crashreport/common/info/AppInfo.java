package com.tencent.bugly.crashreport.common.info;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.support.v4.os.EnvironmentCompat;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.Principal;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
public class AppInfo {
    private static ActivityManager a;

    static {
        "@buglyAllChannel@".split(",");
        "@buglyAllChannelPriority@".split(",");
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0059 A:{SYNTHETIC, Splitter:B:33:0x0059} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004a A:{Catch:{ all -> 0x0041 }} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0053 A:{SYNTHETIC, Splitter:B:28:0x0053} */
    public static java.lang.String a(int r6) {
        /*
        r0 = 0;
        r1 = new java.io.FileReader;	 Catch:{ Throwable -> 0x0043 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0043 }
        r3 = "/proc/";
        r2.<init>(r3);	 Catch:{ Throwable -> 0x0043 }
        r2.append(r6);	 Catch:{ Throwable -> 0x0043 }
        r3 = "/cmdline";
        r2.append(r3);	 Catch:{ Throwable -> 0x0043 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x0043 }
        r1.<init>(r2);	 Catch:{ Throwable -> 0x0043 }
        r0 = 512; // 0x200 float:7.175E-43 double:2.53E-321;
        r0 = new char[r0];	 Catch:{ Throwable -> 0x003c, all -> 0x0039 }
        r1.read(r0);	 Catch:{ Throwable -> 0x003c, all -> 0x0039 }
        r2 = 0;
        r3 = r2;
    L_0x0022:
        r4 = r0.length;	 Catch:{ Throwable -> 0x003c, all -> 0x0039 }
        if (r3 >= r4) goto L_0x002c;
    L_0x0025:
        r4 = r0[r3];	 Catch:{ Throwable -> 0x003c, all -> 0x0039 }
        if (r4 == 0) goto L_0x002c;
    L_0x0029:
        r3 = r3 + 1;
        goto L_0x0022;
    L_0x002c:
        r4 = new java.lang.String;	 Catch:{ Throwable -> 0x003c, all -> 0x0039 }
        r4.<init>(r0);	 Catch:{ Throwable -> 0x003c, all -> 0x0039 }
        r0 = r4.substring(r2, r3);	 Catch:{ Throwable -> 0x003c, all -> 0x0039 }
        r1.close();	 Catch:{ Throwable -> 0x0038 }
    L_0x0038:
        return r0;
    L_0x0039:
        r6 = move-exception;
        r0 = r1;
        goto L_0x0057;
    L_0x003c:
        r0 = move-exception;
        r5 = r1;
        r1 = r0;
        r0 = r5;
        goto L_0x0044;
    L_0x0041:
        r6 = move-exception;
        goto L_0x0057;
    L_0x0043:
        r1 = move-exception;
    L_0x0044:
        r2 = com.tencent.bugly.proguard.x.a(r1);	 Catch:{ all -> 0x0041 }
        if (r2 != 0) goto L_0x004d;
    L_0x004a:
        r1.printStackTrace();	 Catch:{ all -> 0x0041 }
    L_0x004d:
        r6 = java.lang.String.valueOf(r6);	 Catch:{ all -> 0x0041 }
        if (r0 == 0) goto L_0x0056;
    L_0x0053:
        r0.close();	 Catch:{ Throwable -> 0x0056 }
    L_0x0056:
        return r6;
    L_0x0057:
        if (r0 == 0) goto L_0x005c;
    L_0x0059:
        r0.close();	 Catch:{ Throwable -> 0x005c }
    L_0x005c:
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.common.info.AppInfo.a(int):java.lang.String");
    }

    public static String a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getPackageName();
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return "fail";
        }
    }

    private static String a(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        if (bArr != null && bArr.length > 0) {
            try {
                CertificateFactory instance = CertificateFactory.getInstance("X.509");
                if (instance == null) {
                    return null;
                }
                X509Certificate x509Certificate = (X509Certificate) instance.generateCertificate(new ByteArrayInputStream(bArr));
                if (x509Certificate == null) {
                    return null;
                }
                stringBuilder.append("Issuer|");
                Principal issuerDN = x509Certificate.getIssuerDN();
                if (issuerDN != null) {
                    stringBuilder.append(issuerDN.toString());
                } else {
                    stringBuilder.append(EnvironmentCompat.MEDIA_UNKNOWN);
                }
                stringBuilder.append("\n");
                stringBuilder.append("SerialNumber|");
                BigInteger serialNumber = x509Certificate.getSerialNumber();
                if (issuerDN != null) {
                    stringBuilder.append(serialNumber.toString(16));
                } else {
                    stringBuilder.append(EnvironmentCompat.MEDIA_UNKNOWN);
                }
                stringBuilder.append("\n");
                stringBuilder.append("NotBefore|");
                Date notBefore = x509Certificate.getNotBefore();
                if (issuerDN != null) {
                    stringBuilder.append(notBefore.toString());
                } else {
                    stringBuilder.append(EnvironmentCompat.MEDIA_UNKNOWN);
                }
                stringBuilder.append("\n");
                stringBuilder.append("NotAfter|");
                notBefore = x509Certificate.getNotAfter();
                if (issuerDN != null) {
                    stringBuilder.append(notBefore.toString());
                } else {
                    stringBuilder.append(EnvironmentCompat.MEDIA_UNKNOWN);
                }
                stringBuilder.append("\n");
                stringBuilder.append("SHA1|");
                String a = z.a(MessageDigest.getInstance("SHA1").digest(x509Certificate.getEncoded()));
                if (a == null || a.length() <= 0) {
                    stringBuilder.append(EnvironmentCompat.MEDIA_UNKNOWN);
                } else {
                    stringBuilder.append(a.toString());
                }
                stringBuilder.append("\n");
                stringBuilder.append("MD5|");
                String a2 = z.a(MessageDigest.getInstance("MD5").digest(x509Certificate.getEncoded()));
                if (a2 == null || a2.length() <= 0) {
                    stringBuilder.append(EnvironmentCompat.MEDIA_UNKNOWN);
                } else {
                    stringBuilder.append(a2.toString());
                }
            } catch (CertificateException e) {
                if (!x.a(e)) {
                    e.printStackTrace();
                }
            } catch (Throwable th) {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return stringBuilder.length() == 0 ? EnvironmentCompat.MEDIA_UNKNOWN : stringBuilder.toString();
    }

    public static List<String> a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        try {
            String str = (String) map.get("BUGLY_DISABLE");
            if (str != null) {
                if (str.length() != 0) {
                    String[] split = str.split(",");
                    for (int i = 0; i < split.length; i++) {
                        split[i] = split[i].trim();
                    }
                    return Arrays.asList(split);
                }
            }
            return null;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static boolean a(Context context, String str) {
        if (context == null || str == null || str.trim().length() <= 0) {
            return false;
        }
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            if (strArr != null) {
                for (Object equals : strArr) {
                    if (str.equals(equals)) {
                        return true;
                    }
                }
            }
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public static PackageInfo b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(a(context), 0);
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static String c(Context context) {
        if (context == null) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (!(packageManager == null || applicationInfo == null)) {
                CharSequence applicationLabel = packageManager.getApplicationLabel(applicationInfo);
                if (applicationLabel != null) {
                    return applicationLabel.toString();
                }
            }
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
        }
        return null;
    }

    public static Map<String, String> d(Context context) {
        Map<String, String> map = null;
        if (context == null) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo.metaData != null) {
                HashMap hashMap = new HashMap();
                Object obj = applicationInfo.metaData.get("BUGLY_DISABLE");
                if (obj != null) {
                    hashMap.put("BUGLY_DISABLE", obj.toString());
                }
                obj = applicationInfo.metaData.get("BUGLY_APPID");
                if (obj != null) {
                    hashMap.put("BUGLY_APPID", obj.toString());
                }
                obj = applicationInfo.metaData.get("BUGLY_APP_CHANNEL");
                if (obj != null) {
                    hashMap.put("BUGLY_APP_CHANNEL", obj.toString());
                }
                obj = applicationInfo.metaData.get("BUGLY_APP_VERSION");
                if (obj != null) {
                    hashMap.put("BUGLY_APP_VERSION", obj.toString());
                }
                obj = applicationInfo.metaData.get("BUGLY_ENABLE_DEBUG");
                if (obj != null) {
                    hashMap.put("BUGLY_ENABLE_DEBUG", obj.toString());
                }
                Object obj2 = applicationInfo.metaData.get("com.tencent.rdm.uuid");
                if (obj2 != null) {
                    hashMap.put("com.tencent.rdm.uuid", obj2.toString());
                }
                map = hashMap;
            }
            return map;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static String e(Context context) {
        String a = a(context);
        if (a == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(a, 64);
            if (packageInfo == null) {
                return null;
            }
            Signature[] signatureArr = packageInfo.signatures;
            return (signatureArr == null || signatureArr.length == 0) ? null : a(packageInfo.signatures[0].toByteArray());
        } catch (NameNotFoundException unused) {
            return null;
        }
    }

    public static boolean f(Context context) {
        if (context == null) {
            return false;
        }
        if (a == null) {
            a = (ActivityManager) context.getSystemService("activity");
        }
        try {
            MemoryInfo memoryInfo = new MemoryInfo();
            a.getMemoryInfo(memoryInfo);
            if (!memoryInfo.lowMemory) {
                return false;
            }
            x.c("Memory is low.", new Object[0]);
            return true;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }
}
