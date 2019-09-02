package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;

public class a {

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

    public static String a(Context context) {
        String packageName = context.getPackageName();
        String a = a(context, packageName);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a);
        stringBuilder.append(";");
        stringBuilder.append(packageName);
        return stringBuilder.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0040  */
    private static java.lang.String a(android.content.Context r3, java.lang.String r4) {
        /*
        r0 = "";
        r1 = 0;
        r3 = r3.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0030, CertificateException -> 0x002b }
        r2 = 64;
        r3 = r3.getPackageInfo(r4, r2);	 Catch:{ NameNotFoundException -> 0x0030, CertificateException -> 0x002b }
        r3 = r3.signatures;	 Catch:{ NameNotFoundException -> 0x0030, CertificateException -> 0x002b }
        r4 = "X.509";
        r4 = java.security.cert.CertificateFactory.getInstance(r4);	 Catch:{ NameNotFoundException -> 0x0030, CertificateException -> 0x002b }
        r2 = new java.io.ByteArrayInputStream;	 Catch:{ NameNotFoundException -> 0x0030, CertificateException -> 0x002b }
        r3 = r3[r1];	 Catch:{ NameNotFoundException -> 0x0030, CertificateException -> 0x002b }
        r3 = r3.toByteArray();	 Catch:{ NameNotFoundException -> 0x0030, CertificateException -> 0x002b }
        r2.<init>(r3);	 Catch:{ NameNotFoundException -> 0x0030, CertificateException -> 0x002b }
        r3 = r4.generateCertificate(r2);	 Catch:{ NameNotFoundException -> 0x0030, CertificateException -> 0x002b }
        r3 = (java.security.cert.X509Certificate) r3;	 Catch:{ NameNotFoundException -> 0x0030, CertificateException -> 0x002b }
        r3 = a(r3);	 Catch:{ NameNotFoundException -> 0x0030, CertificateException -> 0x002b }
        goto L_0x0035;
    L_0x002b:
        r3 = move-exception;
        r3.printStackTrace();
        goto L_0x0034;
    L_0x0030:
        r3 = move-exception;
        r3.printStackTrace();
    L_0x0034:
        r3 = r0;
    L_0x0035:
        r4 = new java.lang.StringBuffer;
        r4.<init>();
    L_0x003a:
        r0 = r3.length();
        if (r1 >= r0) goto L_0x005d;
    L_0x0040:
        r0 = r3.charAt(r1);
        r4.append(r0);
        if (r1 <= 0) goto L_0x005a;
    L_0x0049:
        r0 = r1 % 2;
        r2 = 1;
        if (r0 != r2) goto L_0x005a;
    L_0x004e:
        r0 = r3.length();
        r0 = r0 - r2;
        if (r1 >= r0) goto L_0x005a;
    L_0x0055:
        r0 = ":";
        r4.append(r0);
    L_0x005a:
        r1 = r1 + 1;
        goto L_0x003a;
    L_0x005d:
        r3 = r4.toString();
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.util.a.a(android.content.Context, java.lang.String):java.lang.String");
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
}
