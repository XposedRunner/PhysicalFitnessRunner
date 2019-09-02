package com.loc;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.loc.O000o000.O000000o;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.List;

/* compiled from: Utils */
public final class O00O00o0 {
    static PublicKey O000000o() {
        Throwable th;
        Throwable th2;
        Closeable byteArrayInputStream;
        try {
            CertificateFactory instance = CertificateFactory.getInstance("X.509");
            byteArrayInputStream = new ByteArrayInputStream(oOo00.O00000Oo("MIIDRzCCAi+gAwIBAgIEeuDbsDANBgkqhkiG9w0BAQsFADBTMQswCQYDVQQGEwJjbjELMAkGA1UECBMCYmoxCzAJBgNVBAcTAmJqMQ0wCwYDVQQKEwRvcGVuMQ4wDAYDVQQLEwVnYW9kZTELMAkGA1UEAxMCUWkwIBcNMTYwODAxMDE0ODMwWhgPMjA3MTA1MDUwMTQ4MzBaMFMxCzAJBgNVBAYTAmNuMQswCQYDVQQIEwJiajELMAkGA1UEBxMCYmoxDTALBgNVBAoTBG9wZW4xDjAMBgNVBAsTBWdhb2RlMQswCQYDVQQDEwJRaTCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAKpL13mZm4q6AFP5csQE7130Lwq8m+HICy3rBARd9vbw5Cb1wFF96KdhC5P/aASlrPb+6MSyP1nE97p3ygKJWsgxExyvVuOvh1KUqOFuK15oY7JKTk6L4eLCbkBJZV2DLffpW0HGiRpmFG8LJR0sjNOoubSd5R/6XoBwyRglsyVHprjrK2qDRvT3Edgtfvxp4HnUzMsDD3CJRtgsaDw6ECyF7fhYKEz9I6OEEVsPlpbgzRmhSeFDL77/k1mhPve1ZyKGlPcxvSSdLSAlV0hzr5NKlujHll7BbouwDnr6l/0O44AzZ0V/ieft1iBkSLirnlm56uI/8jdh8ANrD1fW4ZUCAwEAAaMhMB8wHQYDVR0OBBYEFBzudtI5UKRvHGDV+VQRzItIj3PqMA0GCSqGSIb3DQEBCwUAA4IBAQBS2EGndgvIBnf7Ce4IhDbm7F5h4L+6TYGmT9acnQbEFY8oUoFblMDgg+cETT44jU/elwbJJVmKhj/WRQl+AdSALBAgDvxq1AcjlGg+c8H3pa2BWlrxNJP9MFLIEI5bA8m5og/Epjut50uemZ9ggoNmJeW0N/a6D8euhYJKOYngUQqDu6cwLj1Ec0ptwrNRbvRXXgzjfJMPE/ii4K/b8JZ+QN2d/bl7QEvKWBSzVueZifV659qAbMh6C9TCVstWWfV53Z3Vyt+duDNU5ed7aWao42Ppw4VHslrJW0V6BXDUhhzgXx28UWY78W7LmYGCtC8PfDId2+k4tPoTNPM6HHP5"));
            try {
                PublicKey publicKey = ((X509Certificate) instance.generateCertificate(byteArrayInputStream)).getPublicKey();
                try {
                    O000000o(byteArrayInputStream);
                    return publicKey;
                } catch (Throwable th3) {
                    th3.printStackTrace();
                    return publicKey;
                }
            } catch (Throwable th4) {
                th2 = th4;
                try {
                    O0000Oo.O000000o(th2, "DyLoader", "init");
                    try {
                        O000000o(byteArrayInputStream);
                        return null;
                    } catch (Throwable th22) {
                        th22.printStackTrace();
                        return null;
                    }
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

    static void O000000o(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    static void O000000o(List<O00O000o> list) {
        int i = 0;
        while (i < list.size() - 1) {
            int i2 = i + 1;
            for (int i3 = i2; i3 < list.size(); i3++) {
                O00O000o o00O000o = (O00O000o) list.get(i);
                O00O000o o00O000o2 = (O00O000o) list.get(i3);
                if (O00000Oo(o00O000o2.O00000oO(), o00O000o.O00000oO()) > 0) {
                    list.set(i, o00O000o2);
                    list.set(i3, o00O000o);
                }
            }
            i = i2;
        }
    }

    private static boolean O000000o(final Context context, O000O0o o000O0o, O00O000o o00O000o, O000OOo0 o000OOo0, final OO0Oo0 oO0Oo0) {
        String str = o000OOo0.O00000Oo;
        String str2 = o000OOo0.O00000o0;
        final String str3 = o000OOo0.O00000o;
        if ("errorstatus".equals(o00O000o.O00000oo())) {
            try {
                if (new File(O000o000.O00000Oo(context, oO0Oo0.O000000o(), oO0Oo0.O00000Oo())).exists() || TextUtils.isEmpty(O000o000.O000000o(context, o000O0o, oO0Oo0))) {
                    return true;
                }
                O00O00Oo.O00000Oo().O000000o().submit(new Runnable() {
                    public final void run() {
                        try {
                            O000o000.O000000o(context, oO0Oo0);
                        } catch (Throwable unused) {
                        }
                    }
                });
                return true;
            } catch (Throwable unused) {
            }
        } else {
            final String O000000o = O000o000.O000000o(context, o000OOo0.O000000o);
            if (!new File(O000000o).exists()) {
                return false;
            }
            List O00000Oo = o000O0o.O00000Oo(O00O000o.O000000o(O000o000.O000000o(context, str, str2), str, str2, str3), O00O000o.class);
            if (O00000Oo != null && O00000Oo.size() > 0) {
                return true;
            }
            O000o000.O000000o(context, str, oO0Oo0.O00000Oo());
            try {
                final Context context2 = context;
                final O000O0o o000O0o2 = o000O0o;
                final OO0Oo0 oO0Oo02 = oO0Oo0;
                O00O00Oo.O00000Oo().O000000o().submit(new Runnable() {
                    public final void run() {
                        try {
                            O000o000.O000000o(context2, o000O0o2, oO0Oo02, O000000o, str3);
                            O000o000.O000000o(context2, oO0Oo02);
                        } catch (Throwable th) {
                            O0000Oo.O000000o(th, "dDownLoad", "processDownloadedFile()");
                        }
                    }
                });
            } catch (Throwable unused2) {
            }
            return true;
        }
    }

    static boolean O000000o(Context context, O000OOo0 o000OOo0, OO0Oo0 oO0Oo0) {
        O000O0o o000O0o = new O000O0o(context, O000o.O00000Oo());
        if (O000000o(o000O0o, o000OOo0)) {
            return true;
        }
        O00O000o O000000o = O000000o.O000000o(o000O0o, o000OOo0.O000000o);
        return O000000o != null ? O000000o(context, o000O0o, O000000o, o000OOo0, oO0Oo0) : false;
    }

    static boolean O000000o(Context context, boolean z) {
        if (z) {
            return true;
        }
        return OO0O0o0.O0000oO0(context) == 1;
    }

    private static boolean O000000o(O000O0o o000O0o, O000OOo0 o000OOo0) {
        try {
            List O000000o = O000000o.O000000o(o000O0o, o000OOo0.O00000Oo, "used");
            if (O000000o != null && O000000o.size() > 0 && O00000Oo(((O00O000o) O000000o.get(0)).O00000oO(), o000OOo0.O00000o) > 0) {
                return true;
            }
        } catch (Throwable th) {
            O0000Oo.O000000o(th, "dDownLoad", "isUsed");
        }
        return false;
    }

    static boolean O000000o(O000O0o o000O0o, String str, String str2, OO0Oo0 oO0Oo0) {
        O00O000o O000000o = O000000o.O000000o(o000O0o, str);
        return O000000o != null && oO0Oo0.O00000Oo().equals(O000000o.O00000o()) && O000000o(str2, O000000o.O00000Oo());
    }

    static boolean O000000o(O000OOo0 o000OOo0) {
        return VERSION.SDK_INT >= o000OOo0.O00000oo && VERSION.SDK_INT <= o000OOo0.O00000oO;
    }

    static boolean O000000o(OO0Oo0 oO0Oo0, O000OOo0 o000OOo0) {
        return oO0Oo0 != null && oO0Oo0.O000000o().equals(o000OOo0.O00000Oo) && oO0Oo0.O00000Oo().equals(o000OOo0.O00000o0);
    }

    static boolean O000000o(String str, String str2) {
        str = OO0OOOO.O000000o(str);
        return str != null && str.equalsIgnoreCase(str2);
    }

    private static int O00000Oo(String str, String str2) {
        try {
            String[] split = str.split("\\.");
            String[] split2 = str2.split("\\.");
            int min = Math.min(split.length, split2.length);
            int i = 0;
            int i2 = 0;
            while (i < min) {
                i2 = split[i].length() - split2[i].length();
                if (i2 != 0) {
                    break;
                }
                i2 = split[i].compareTo(split2[i]);
                if (i2 != 0) {
                    break;
                }
                i++;
            }
            return i2 != 0 ? i2 : split.length - split2.length;
        } catch (Exception e) {
            O0000Oo.O000000o(e, "Utils", "compareVersion");
            return -1;
        }
    }
}
