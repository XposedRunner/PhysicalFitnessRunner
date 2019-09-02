package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.amap.api.mapcore.util.oO00OOOo.O000000o;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.List;

/* compiled from: Utils */
public class oOo00ooO {
    public static int O000000o(String str, String str2) {
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
            if (i2 == 0) {
                i2 = split.length - split2.length;
            }
            return i2;
        } catch (Exception e) {
            oO0OoOO0.O000000o(e, "Utils", "compareVersion");
            return -1;
        }
    }

    static PublicKey O000000o() {
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
                    O000000o(th2, "DyLoader", "init");
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

    private static void O000000o(final Context context, oO0O0o0o oo0o0o0o, final o0OO0o00 o0oo0o00) {
        try {
            if (!new File(oO00OOOo.O00000Oo(context, o0oo0o00.O000000o(), o0oo0o00.O00000Oo())).exists() && !TextUtils.isEmpty(oO00OOOo.O000000o(context, oo0o0o0o, o0oo0o00))) {
                oO0OO000.O00000Oo().O000000o().submit(new Runnable() {
                    public void run() {
                        try {
                            oO00OOOo.O000000o(context, o0oo0o00);
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
        } catch (Throwable unused) {
        }
    }

    public static void O000000o(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void O000000o(Throwable th, String str, String str2) {
        oO0OoOO0.O000000o(th, str, str2);
    }

    static void O000000o(List<oOOoOOO0> list) {
        int i = 0;
        while (i < list.size() - 1) {
            int i2 = i + 1;
            for (int i3 = i2; i3 < list.size(); i3++) {
                oOOoOOO0 ooooooo0 = (oOOoOOO0) list.get(i);
                oOOoOOO0 ooooooo02 = (oOOoOOO0) list.get(i3);
                if (O000000o(ooooooo02.O00000oO(), ooooooo0.O00000oO()) > 0) {
                    list.set(i, ooooooo02);
                    list.set(i3, ooooooo0);
                }
            }
            i = i2;
        }
    }

    static boolean O000000o(Context context) {
        return o0O0o000.O0000oO0(context) == 1;
    }

    static boolean O000000o(Context context, o0OO0o00 o0oo0o00, oO00OO0O oo00oo0o) {
        return oo00oo0o.O00000oO() ? true : true;
    }

    static boolean O000000o(Context context, oO00OO0O oo00oo0o, o0OO0o00 o0oo0o00) {
        oO0O0o0o oo0o0o0o = new oO0O0o0o(context, oO00Oo00.O000000o());
        if (O000000o(oo0o0o0o, oo00oo0o)) {
            return true;
        }
        oOOoOOO0 O000000o = O000000o.O000000o(oo0o0o0o, oo00oo0o.O00000Oo);
        return O000000o != null ? O000000o(context, oo0o0o0o, O000000o, oo00oo0o, o0oo0o00) : false;
    }

    private static boolean O000000o(Context context, oO0O0o0o oo0o0o0o, oOOoOOO0 ooooooo0, oO00OO0O oo00oo0o, o0OO0o00 o0oo0o00) {
        String str = oo00oo0o.O00000o0;
        String str2 = oo00oo0o.O00000o;
        final String str3 = oo00oo0o.O00000oO;
        if ("errorstatus".equals(ooooooo0.O00000oo())) {
            O000000o(context, oo0o0o0o, o0oo0o00);
            return true;
        }
        final String O000000o = oO00OOOo.O000000o(context, oo00oo0o.O00000Oo);
        if (!new File(O000000o).exists()) {
            return false;
        }
        List O00000Oo = oo0o0o0o.O00000Oo(oOOoOOO0.O000000o(oO00OOOo.O000000o(context, str, str2), str, str2, str3), oOOoOOO0.class);
        if (O00000Oo != null && O00000Oo.size() > 0) {
            return true;
        }
        oO00OOOo.O000000o(context, str, o0oo0o00.O00000Oo());
        try {
            final Context context2 = context;
            final oO0O0o0o oo0o0o0o2 = oo0o0o0o;
            final o0OO0o00 o0oo0o002 = o0oo0o00;
            oO0OO000.O00000Oo().O000000o().submit(new Runnable() {
                public void run() {
                    try {
                        oO00OOOo.O000000o(context2, oo0o0o0o2, o0oo0o002, O000000o, str3);
                        oO00OOOo.O000000o(context2, o0oo0o002);
                    } catch (Throwable th) {
                        oOo00ooO.O000000o(th, "dDownLoad", "processDownloadedFile()");
                    }
                }
            });
        } catch (Throwable unused) {
        }
        return true;
    }

    static boolean O000000o(Context context, oO0O0o0o oo0o0o0o, String str, o0OO0o00 o0oo0o00) {
        return O000000o(oo0o0o0o, str, oO00OOOo.O000000o(context, str), o0oo0o00);
    }

    static boolean O000000o(Context context, boolean z) {
        return z || O000000o(context);
    }

    static boolean O000000o(o0OO0o00 o0oo0o00, oO00OO0O oo00oo0o) {
        boolean z = false;
        if (o0oo0o00 == null) {
            return false;
        }
        if (o0oo0o00.O000000o().equals(oo00oo0o.O00000o0) && o0oo0o00.O00000Oo().equals(oo00oo0o.O00000o)) {
            z = true;
        }
        return z;
    }

    static boolean O000000o(oO00OO0O oo00oo0o) {
        return VERSION.SDK_INT >= oo00oo0o.O0000OOo && VERSION.SDK_INT <= oo00oo0o.O0000O0o;
    }

    private static boolean O000000o(oO0O0o0o oo0o0o0o, oO00OO0O oo00oo0o) {
        try {
            List O000000o = O000000o.O000000o(oo0o0o0o, oo00oo0o.O00000o0, "used");
            if (O000000o != null && O000000o.size() > 0 && O000000o(((oOOoOOO0) O000000o.get(0)).O00000oO(), oo00oo0o.O00000oO) > 0) {
                return true;
            }
        } catch (Throwable th) {
            O000000o(th, "dDownLoad", "isUsed");
        }
        return false;
    }

    static boolean O000000o(oO0O0o0o oo0o0o0o, String str, String str2, o0OO0o00 o0oo0o00) {
        oOOoOOO0 O000000o = O000000o.O000000o(oo0o0o0o, str);
        return O000000o != null && o0oo0o00.O00000Oo().equals(O000000o.O00000o()) && O00000Oo(str2, O000000o.O00000Oo());
    }

    static boolean O00000Oo(String str, String str2) {
        str = o0OO00o0.O000000o(str);
        return str != null && str.equalsIgnoreCase(str2);
    }
}
