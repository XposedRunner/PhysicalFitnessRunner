package com.amap.api.mapcore.util;

import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* compiled from: RSAUtil */
public final class aq {
    private static PublicKey O000000o;

    private static PublicKey O000000o() {
        Throwable th;
        Throwable th2;
        Closeable byteArrayInputStream;
        try {
            CertificateFactory instance = CertificateFactory.getInstance("X.509");
            byteArrayInputStream = new ByteArrayInputStream(o0OO000o.O00000Oo("MIIDRzCCAi+gAwIBAgIEeuDbsDANBgkqhkiG9w0BAQsFADBTMQswCQYDVQQGEwJjbjELMAkGA1UECBMCYmoxCzAJBgNVBAcTAmJqMQ0wCwYDVQQKEwRvcGVuMQ4wDAYDVQQLEwVnYW9kZTELMAkGA1UEAxMCUWkwIBcNMTYwODAxMDE0ODMwWhgPMjA3MTA1MDUwMTQ4MzBaMFMxCzAJBgNVBAYTAmNuMQswCQYDVQQIEwJiajELMAkGA1UEBxMCYmoxDTALBgNVBAoTBG9wZW4xDjAMBgNVBAsTBWdhb2RlMQswCQYDVQQDEwJRaTCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAKpL13mZm4q6AFP5csQE7130Lwq8m+HICy3rBARd9vbw5Cb1wFF96KdhC5P/aASlrPb+6MSyP1nE97p3ygKJWsgxExyvVuOvh1KUqOFuK15oY7JKTk6L4eLCbkBJZV2DLffpW0HGiRpmFG8LJR0sjNOoubSd5R/6XoBwyRglsyVHprjrK2qDRvT3Edgtfvxp4HnUzMsDD3CJRtgsaDw6ECyF7fhYKEz9I6OEEVsPlpbgzRmhSeFDL77/k1mhPve1ZyKGlPcxvSSdLSAlV0hzr5NKlujHll7BbouwDnr6l/0O44AzZ0V/ieft1iBkSLirnlm56uI/8jdh8ANrD1fW4ZUCAwEAAaMhMB8wHQYDVR0OBBYEFBzudtI5UKRvHGDV+VQRzItIj3PqMA0GCSqGSIb3DQEBCwUAA4IBAQBS2EGndgvIBnf7Ce4IhDbm7F5h4L+6TYGmT9acnQbEFY8oUoFblMDgg+cETT44jU/elwbJJVmKhj/WRQl+AdSALBAgDvxq1AcjlGg+c8H3pa2BWlrxNJP9MFLIEI5bA8m5og/Epjut50uemZ9ggoNmJeW0N/a6D8euhYJKOYngUQqDu6cwLj1Ec0ptwrNRbvRXXgzjfJMPE/ii4K/b8JZ+QN2d/bl7QEvKWBSzVueZifV659qAbMh6C9TCVstWWfV53Z3Vyt+duDNU5ed7aWao42Ppw4VHslrJW0V6BXDUhhzgXx28UWY78W7LmYGCtC8PfDId2+k4tPoTNPM6HHP5"));
            try {
                PublicKey publicKey = ((X509Certificate) instance.generateCertificate(byteArrayInputStream)).getPublicKey();
                try {
                    O000000o(byteArrayInputStream);
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
                return publicKey;
            } catch (Throwable th4) {
                th2 = th4;
                try {
                    oO0OoOO0.O000000o(th2, "SoLoader", "init");
                    try {
                        O000000o(byteArrayInputStream);
                    } catch (Throwable th22) {
                        th22.printStackTrace();
                    }
                    return null;
                } catch (Throwable th5) {
                    th3 = th5;
                    try {
                        O000000o(byteArrayInputStream);
                    } catch (Throwable th222) {
                        th222.printStackTrace();
                    }
                    throw th3;
                }
            }
        } catch (Throwable th2222) {
            byteArrayInputStream = null;
            th3 = th2222;
            O000000o(byteArrayInputStream);
            throw th3;
        }
    }

    private static void O000000o(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    private static void O000000o(JarFile jarFile, JarEntry jarEntry) throws IOException {
        Throwable th;
        Closeable closeable = null;
        try {
            Closeable inputStream = jarFile.getInputStream(jarEntry);
            try {
                do {
                } while (inputStream.read(new byte[8192]) > 0);
                O000000o(inputStream);
            } catch (Throwable th2) {
                th = th2;
                closeable = inputStream;
                O000000o(closeable);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            oO0OoOO0.O000000o(th, "DyLoader", "loadJa");
            O000000o(closeable);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x0067 A:{SYNTHETIC, Splitter:B:47:0x0067} */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x006d A:{SYNTHETIC, Splitter:B:52:0x006d} */
    private static boolean O000000o(java.io.File r5) {
        /*
        r0 = 0;
        r1 = 0;
        r2 = O000000o;	 Catch:{ Throwable -> 0x005d }
        if (r2 != 0) goto L_0x000c;
    L_0x0006:
        r2 = O000000o();	 Catch:{ Throwable -> 0x005d }
        O000000o = r2;	 Catch:{ Throwable -> 0x005d }
    L_0x000c:
        r2 = new java.util.jar.JarFile;	 Catch:{ Throwable -> 0x005d }
        r2.<init>(r5);	 Catch:{ Throwable -> 0x005d }
        r5 = r2.entries();	 Catch:{ Throwable -> 0x0057, all -> 0x0055 }
        if (r5 != 0) goto L_0x001b;
    L_0x0017:
        r2.close();	 Catch:{ Throwable -> 0x001a }
    L_0x001a:
        return r0;
    L_0x001b:
        r1 = r5.hasMoreElements();	 Catch:{ Throwable -> 0x0057, all -> 0x0055 }
        if (r1 == 0) goto L_0x0050;
    L_0x0021:
        r1 = r5.nextElement();	 Catch:{ Throwable -> 0x0057, all -> 0x0055 }
        r1 = (java.util.jar.JarEntry) r1;	 Catch:{ Throwable -> 0x0057, all -> 0x0055 }
        r3 = r1.getName();	 Catch:{ Throwable -> 0x0057, all -> 0x0055 }
        if (r3 == 0) goto L_0x001b;
    L_0x002d:
        r3 = r1.getName();	 Catch:{ Throwable -> 0x0057, all -> 0x0055 }
        r4 = "so";
        r3 = r3.endsWith(r4);	 Catch:{ Throwable -> 0x0057, all -> 0x0055 }
        if (r3 == 0) goto L_0x001b;
    L_0x0039:
        O000000o(r2, r1);	 Catch:{ Throwable -> 0x0057, all -> 0x0055 }
        r1 = r1.getCertificates();	 Catch:{ Throwable -> 0x0057, all -> 0x0055 }
        if (r1 != 0) goto L_0x0046;
    L_0x0042:
        r2.close();	 Catch:{ Throwable -> 0x0045 }
    L_0x0045:
        return r0;
    L_0x0046:
        r1 = O000000o(r1);	 Catch:{ Throwable -> 0x0057, all -> 0x0055 }
        if (r1 != 0) goto L_0x001b;
    L_0x004c:
        r2.close();	 Catch:{ Throwable -> 0x004f }
    L_0x004f:
        return r0;
    L_0x0050:
        r2.close();	 Catch:{ Throwable -> 0x0053 }
    L_0x0053:
        r5 = 1;
        return r5;
    L_0x0055:
        r5 = move-exception;
        goto L_0x006b;
    L_0x0057:
        r5 = move-exception;
        r1 = r2;
        goto L_0x005e;
    L_0x005a:
        r5 = move-exception;
        r2 = r1;
        goto L_0x006b;
    L_0x005d:
        r5 = move-exception;
    L_0x005e:
        r2 = "DyLoader";
        r3 = "verify";
        com.amap.api.mapcore.util.oO0OoOO0.O000000o(r5, r2, r3);	 Catch:{ all -> 0x005a }
        if (r1 == 0) goto L_0x006a;
    L_0x0067:
        r1.close();	 Catch:{ Throwable -> 0x006a }
    L_0x006a:
        return r0;
    L_0x006b:
        if (r2 == 0) goto L_0x0070;
    L_0x006d:
        r2.close();	 Catch:{ Throwable -> 0x0070 }
    L_0x0070:
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.aq.O000000o(java.io.File):boolean");
    }

    public static boolean O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return O000000o(new File(str));
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean O000000o(Certificate[] certificateArr) {
        try {
            if (certificateArr.length > 0) {
                int length = certificateArr.length - 1;
                if (length >= 0) {
                    certificateArr[length].verify(O000000o);
                    return true;
                }
            }
        } catch (Throwable th) {
            oO0OoOO0.O000000o(th, "DyLoader", "check");
        }
        return false;
    }
}
