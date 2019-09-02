package com.baidu.lbsapi.auth;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import android.util.Base64;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Locale;

class b {

    static class a {
        public static String a(byte[] bArr) {
            char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            StringBuilder stringBuilder = new StringBuilder(bArr.length * 2);
            for (int i = 0; i < bArr.length; i++) {
                stringBuilder.append(cArr[(bArr[i] & GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN) >> 4]);
                stringBuilder.append(cArr[bArr[i] & 15]);
            }
            return stringBuilder.toString();
        }
    }

    static String a() {
        return Locale.getDefault().getLanguage();
    }

    protected static String a(Context context) {
        String packageName = context.getPackageName();
        String a = a(context, packageName);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a);
        stringBuilder.append(";");
        stringBuilder.append(packageName);
        return stringBuilder.toString();
    }

    private static String a(Context context, String str) {
        String a;
        String str2 = "";
        int i = 0;
        try {
            a = a((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(context.getPackageManager().getPackageInfo(str, 64).signatures[0].toByteArray())));
        } catch (NameNotFoundException | CertificateException unused) {
            a = str2;
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (i < a.length()) {
            stringBuffer.append(a.charAt(i));
            if (i > 0 && i % 2 == 1 && i < a.length() - 1) {
                stringBuffer.append(":");
            }
            i++;
        }
        return stringBuffer.toString();
    }

    static String a(X509Certificate x509Certificate) {
        try {
            return a.a(a(x509Certificate.getEncoded()));
        } catch (CertificateEncodingException unused) {
            return null;
        }
    }

    static byte[] a(byte[] bArr) {
        try {
            return MessageDigest.getInstance("SHA1").digest(bArr);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    protected static String[] b(Context context) {
        String packageName = context.getPackageName();
        String[] b = b(context, packageName);
        if (b == null || b.length <= 0) {
            return null;
        }
        String[] strArr = new String[b.length];
        for (int i = 0; i < strArr.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(b[i]);
            stringBuilder.append(";");
            stringBuilder.append(packageName);
            strArr[i] = stringBuilder.toString();
            if (a.a) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("mcode");
                stringBuilder.append(strArr[i]);
                a.a(stringBuilder.toString());
            }
        }
        return strArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0047  */
    private static java.lang.String[] b(android.content.Context r6, java.lang.String r7) {
        /*
        r0 = 0;
        r1 = 0;
        r6 = r6.getPackageManager();	 Catch:{ NameNotFoundException | CertificateException -> 0x003a, NameNotFoundException | CertificateException -> 0x003a }
        r2 = 64;
        r6 = r6.getPackageInfo(r7, r2);	 Catch:{ NameNotFoundException | CertificateException -> 0x003a, NameNotFoundException | CertificateException -> 0x003a }
        r6 = r6.signatures;	 Catch:{ NameNotFoundException | CertificateException -> 0x003a, NameNotFoundException | CertificateException -> 0x003a }
        if (r6 == 0) goto L_0x003a;
    L_0x0010:
        r7 = r6.length;	 Catch:{ NameNotFoundException | CertificateException -> 0x003a, NameNotFoundException | CertificateException -> 0x003a }
        if (r7 <= 0) goto L_0x003a;
    L_0x0013:
        r7 = r6.length;	 Catch:{ NameNotFoundException | CertificateException -> 0x003a, NameNotFoundException | CertificateException -> 0x003a }
        r7 = new java.lang.String[r7];	 Catch:{ NameNotFoundException | CertificateException -> 0x003a, NameNotFoundException | CertificateException -> 0x003a }
        r2 = r1;
    L_0x0017:
        r3 = r6.length;	 Catch:{ NameNotFoundException | CertificateException -> 0x003b, NameNotFoundException | CertificateException -> 0x003b }
        if (r2 >= r3) goto L_0x003b;
    L_0x001a:
        r3 = "X.509";
        r3 = java.security.cert.CertificateFactory.getInstance(r3);	 Catch:{ NameNotFoundException | CertificateException -> 0x003b, NameNotFoundException | CertificateException -> 0x003b }
        r4 = new java.io.ByteArrayInputStream;	 Catch:{ NameNotFoundException | CertificateException -> 0x003b, NameNotFoundException | CertificateException -> 0x003b }
        r5 = r6[r2];	 Catch:{ NameNotFoundException | CertificateException -> 0x003b, NameNotFoundException | CertificateException -> 0x003b }
        r5 = r5.toByteArray();	 Catch:{ NameNotFoundException | CertificateException -> 0x003b, NameNotFoundException | CertificateException -> 0x003b }
        r4.<init>(r5);	 Catch:{ NameNotFoundException | CertificateException -> 0x003b, NameNotFoundException | CertificateException -> 0x003b }
        r3 = r3.generateCertificate(r4);	 Catch:{ NameNotFoundException | CertificateException -> 0x003b, NameNotFoundException | CertificateException -> 0x003b }
        r3 = (java.security.cert.X509Certificate) r3;	 Catch:{ NameNotFoundException | CertificateException -> 0x003b, NameNotFoundException | CertificateException -> 0x003b }
        r3 = a(r3);	 Catch:{ NameNotFoundException | CertificateException -> 0x003b, NameNotFoundException | CertificateException -> 0x003b }
        r7[r2] = r3;	 Catch:{ NameNotFoundException | CertificateException -> 0x003b, NameNotFoundException | CertificateException -> 0x003b }
        r2 = r2 + 1;
        goto L_0x0017;
    L_0x003a:
        r7 = r0;
    L_0x003b:
        if (r7 == 0) goto L_0x007f;
    L_0x003d:
        r6 = r7.length;
        if (r6 <= 0) goto L_0x007f;
    L_0x0040:
        r6 = r7.length;
        r0 = new java.lang.String[r6];
        r6 = r1;
    L_0x0044:
        r2 = r7.length;
        if (r6 >= r2) goto L_0x007f;
    L_0x0047:
        r2 = new java.lang.StringBuffer;
        r2.<init>();
        r3 = r1;
    L_0x004d:
        r4 = r7[r6];
        r4 = r4.length();
        if (r3 >= r4) goto L_0x0076;
    L_0x0055:
        r4 = r7[r6];
        r4 = r4.charAt(r3);
        r2.append(r4);
        if (r3 <= 0) goto L_0x0073;
    L_0x0060:
        r4 = r3 % 2;
        r5 = 1;
        if (r4 != r5) goto L_0x0073;
    L_0x0065:
        r4 = r7[r6];
        r4 = r4.length();
        r4 = r4 - r5;
        if (r3 >= r4) goto L_0x0073;
    L_0x006e:
        r4 = ":";
        r2.append(r4);
    L_0x0073:
        r3 = r3 + 1;
        goto L_0x004d;
    L_0x0076:
        r2 = r2.toString();
        r0[r6] = r2;
        r6 = r6 + 1;
        goto L_0x0044;
    L_0x007f:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.lbsapi.auth.b.b(android.content.Context, java.lang.String):java.lang.String[]");
    }

    static String c(Context context) {
        String string = context.getSharedPreferences("mac", 0).getString("macaddr", null);
        if (string == null) {
            string = d(context);
            if (string != null) {
                string = Base64.encodeToString(string.getBytes(), 0);
                if (!TextUtils.isEmpty(string)) {
                    context.getSharedPreferences("mac", 0).edit().putString("macaddr", string).commit();
                }
            } else {
                string = "";
            }
        }
        if (a.a) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("getMacID mac_adress: ");
            stringBuilder.append(string);
            a.a(stringBuilder.toString());
        }
        return string;
    }

    private static boolean c(Context context, String str) {
        boolean z = context.checkCallingOrSelfPermission(str) != -1;
        if (a.a) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("hasPermission ");
            stringBuilder.append(z);
            stringBuilder.append(" | ");
            stringBuilder.append(str);
            a.a(stringBuilder.toString());
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0058  */
    static java.lang.String d(android.content.Context r5) {
        /*
        r0 = 0;
        r1 = "android.permission.ACCESS_WIFI_STATE";
        r1 = c(r5, r1);	 Catch:{ Exception -> 0x0053 }
        if (r1 == 0) goto L_0x0049;
    L_0x0009:
        r1 = "wifi";
        r5 = r5.getSystemService(r1);	 Catch:{ Exception -> 0x0053 }
        r5 = (android.net.wifi.WifiManager) r5;	 Catch:{ Exception -> 0x0053 }
        r5 = r5.getConnectionInfo();	 Catch:{ Exception -> 0x0053 }
        r1 = r5.getMacAddress();	 Catch:{ Exception -> 0x0053 }
        r0 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Exception -> 0x0046 }
        r2 = 0;
        if (r0 != 0) goto L_0x0027;
    L_0x0020:
        r0 = r1.getBytes();	 Catch:{ Exception -> 0x0046 }
        android.util.Base64.encode(r0, r2);	 Catch:{ Exception -> 0x0046 }
    L_0x0027:
        r0 = com.baidu.lbsapi.auth.a.a;	 Catch:{ Exception -> 0x0046 }
        if (r0 == 0) goto L_0x0044;
    L_0x002b:
        r0 = "ssid=%s mac=%s";
        r3 = 2;
        r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0046 }
        r4 = r5.getSSID();	 Catch:{ Exception -> 0x0046 }
        r3[r2] = r4;	 Catch:{ Exception -> 0x0046 }
        r2 = 1;
        r5 = r5.getMacAddress();	 Catch:{ Exception -> 0x0046 }
        r3[r2] = r5;	 Catch:{ Exception -> 0x0046 }
        r5 = java.lang.String.format(r0, r3);	 Catch:{ Exception -> 0x0046 }
        com.baidu.lbsapi.auth.a.a(r5);	 Catch:{ Exception -> 0x0046 }
    L_0x0044:
        r0 = r1;
        return r0;
    L_0x0046:
        r5 = move-exception;
        r0 = r1;
        goto L_0x0054;
    L_0x0049:
        r5 = com.baidu.lbsapi.auth.a.a;	 Catch:{ Exception -> 0x0053 }
        if (r5 == 0) goto L_0x005f;
    L_0x004d:
        r5 = "You need the android.Manifest.permission.ACCESS_WIFI_STATE permission. Open AndroidManifest.xml and just before the final </manifest> tag add:android.permission.ACCESS_WIFI_STATE";
        com.baidu.lbsapi.auth.a.a(r5);	 Catch:{ Exception -> 0x0053 }
        return r0;
    L_0x0053:
        r5 = move-exception;
    L_0x0054:
        r1 = com.baidu.lbsapi.auth.a.a;
        if (r1 == 0) goto L_0x005f;
    L_0x0058:
        r5 = r5.toString();
        com.baidu.lbsapi.auth.a.a(r5);
    L_0x005f:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.lbsapi.auth.b.d(android.content.Context):java.lang.String");
    }
}
