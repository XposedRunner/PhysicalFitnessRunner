package com.qiyukf.basesdk.b.a.b.e;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.qiyukf.basesdk.a.a;
import com.qiyukf.basesdk.b.a.b.c.b;
import com.qiyukf.basesdk.b.a.b.c.f;
import java.io.File;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import org.json.JSONException;

public class c {
    private static final String a = a(c.class);

    public static a a(File file, String str) {
        if (file == null) {
            return null;
        }
        try {
            return new a(file, str);
        } catch (IOException e) {
            if (file != null) {
                file.delete();
            }
            throw e;
        }
    }

    public static String a() {
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration inetAddresses = ((NetworkInterface) networkInterfaces.nextElement()).getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                    if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address)) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
        } catch (SocketException unused) {
            a.c(a, "get ip address socket exception");
        }
        return "";
    }

    public static String a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            String typeName = activeNetworkInfo.getTypeName();
            if (typeName.equalsIgnoreCase("WIFI")) {
                return "wifi";
            }
            if (typeName.equalsIgnoreCase("MOBILE")) {
                Object obj = 1;
                switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                        break;
                    default:
                        obj = null;
                        break;
                }
                return obj != null ? "3g/4g" : "2g";
            }
        }
        return "";
    }

    public static String a(com.qiyukf.basesdk.b.a.b.c.c cVar, String str) {
        String str2 = "";
        if (!(cVar == null || cVar.b() == null || !cVar.b().has(str))) {
            try {
                return cVar.b().getString(str);
            } catch (JSONException e) {
                a.b(a, "get result string parse json failed", e);
            }
        }
        return str2;
    }

    public static String a(Class cls) {
        StringBuilder stringBuilder = new StringBuilder("NOS_");
        stringBuilder.append(cls.getSimpleName());
        return stringBuilder.toString();
    }

    public static void a(Context context, File file, Object obj, f fVar, b bVar) {
        String d = fVar.d();
        String e = fVar.e();
        String f = fVar.f();
        if (context == null || file == null || obj == null || fVar == null || bVar == null || d == null || e == null || f == null) {
            throw new com.qiyukf.basesdk.b.a.b.b.b("parameters could not be null");
        }
    }
}
