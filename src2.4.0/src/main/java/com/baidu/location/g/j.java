package com.baidu.location.g;

import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.text.TextUtils;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.b.d;
import com.baidu.location.e.a;
import com.baidu.location.e.b;
import com.baidu.location.e.e;
import com.baidu.location.e.h;
import com.baidu.location.f;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Locale;

public class j {
    public static float A = 2.2f;
    public static float B = 2.3f;
    public static float C = 3.8f;
    public static int D = 3;
    public static int E = 10;
    public static int F = 2;
    public static int G = 7;
    public static int H = 20;
    public static int I = 70;
    public static int J = 120;
    public static float K = 2.0f;
    public static float L = 10.0f;
    public static float M = 50.0f;
    public static float N = 200.0f;
    public static int O = 16;
    public static float P = 0.9f;
    public static int Q = 10000;
    public static float R = 0.5f;
    public static float S = 0.0f;
    public static float T = 0.1f;
    public static int U = 30;
    public static int V = 100;
    public static int W = 0;
    public static int X = 0;
    public static int Y = 0;
    public static int Z = 420000;
    public static boolean a = false;
    private static String aA = "http://loc.map.baidu.com/rtbu.php";
    private static String aB = "http://loc.map.baidu.com/iofd.php";
    private static String aC = "http://loc.map.baidu.com/wloc";
    public static boolean aa = true;
    public static boolean ab = true;
    public static int ac = 20;
    public static int ad = 300;
    public static int ae = 1000;
    public static int af = Integer.MAX_VALUE;
    public static long ag = 900000;
    public static long ah = 420000;
    public static long ai = 180000;
    public static long aj = 0;
    public static long ak = 15;
    public static long al = 300000;
    public static int am = 1000;
    public static int an = 0;
    public static int ao = 30000;
    public static int ap = 30000;
    public static float aq = 10.0f;
    public static float ar = 6.0f;
    public static float as = 10.0f;
    public static int at = 60;
    public static int au = 70;
    public static int av = 6;
    private static String aw = "http://loc.map.baidu.com/sdk.php";
    private static String ax = "http://loc.map.baidu.com/user_err.php";
    private static String ay = "http://loc.map.baidu.com/oqur.php";
    private static String az = "http://loc.map.baidu.com/tcu.php";
    public static boolean b = false;
    public static boolean c = false;
    public static int d = 0;
    public static String e = "http://loc.map.baidu.com/sdk_ep.php";
    public static String f = "https://loc.map.baidu.com/sdk.php";
    public static String g = "no";
    public static boolean h = false;
    public static boolean i = false;
    public static boolean j = false;
    public static boolean k = false;
    public static boolean l = false;
    public static boolean m = false;
    public static String n = "gcj02";
    public static String o = "";
    public static boolean p = true;
    public static int q = 3;
    public static double r = 0.0d;
    public static double s = 0.0d;
    public static double t = 0.0d;
    public static double u = 0.0d;
    public static int v = 0;
    public static byte[] w = null;
    public static boolean x = false;
    public static int y = 0;
    public static float z = 1.1f;

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0017 A:{RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0016 A:{RETURN} */
    public static int a(android.content.Context r4, java.lang.String r5) {
        /*
        r0 = 0;
        r1 = 1;
        r2 = android.os.Process.myPid();	 Catch:{ Exception -> 0x0013 }
        r3 = android.os.Process.myUid();	 Catch:{ Exception -> 0x0013 }
        r4 = r4.checkPermission(r5, r2, r3);	 Catch:{ Exception -> 0x0013 }
        if (r4 != 0) goto L_0x0011;
    L_0x0010:
        goto L_0x0013;
    L_0x0011:
        r4 = r0;
        goto L_0x0014;
    L_0x0013:
        r4 = r1;
    L_0x0014:
        if (r4 != 0) goto L_0x0017;
    L_0x0016:
        return r0;
    L_0x0017:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.g.j.a(android.content.Context, java.lang.String):int");
    }

    public static int a(String str, String str2, String str3) {
        if (str == null || str.equals("")) {
            return Integer.MIN_VALUE;
        }
        int indexOf = str.indexOf(str2);
        if (indexOf == -1) {
            return Integer.MIN_VALUE;
        }
        indexOf += str2.length();
        int indexOf2 = str.indexOf(str3, indexOf);
        if (indexOf2 == -1) {
            return Integer.MIN_VALUE;
        }
        str = str.substring(indexOf, indexOf2);
        if (str == null || str.equals("")) {
            return Integer.MIN_VALUE;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return Integer.MIN_VALUE;
        }
    }

    public static String a() {
        Calendar instance = Calendar.getInstance();
        int i = instance.get(5);
        int i2 = instance.get(1);
        int i3 = instance.get(2) + 1;
        int i4 = instance.get(11);
        int i5 = instance.get(12);
        int i6 = instance.get(13);
        return String.format(Locale.CHINA, "%d-%02d-%02d %02d:%02d:%02d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)});
    }

    public static String a(a aVar, h hVar, Location location, String str, int i) {
        return a(aVar, hVar, location, str, i, false);
    }

    public static String a(a aVar, h hVar, Location location, String str, int i, boolean z) {
        String b;
        String a;
        StringBuffer stringBuffer = new StringBuffer(1024);
        if (aVar != null) {
            String b2 = b.a().b(aVar);
            if (b2 != null) {
                stringBuffer.append(b2);
            }
        }
        if (hVar != null) {
            b = i == 0 ? z ? hVar.b() : hVar.c() : hVar.d();
            if (b != null) {
                stringBuffer.append(b);
            }
        }
        if (location != null) {
            b = (d == 0 || i == 0) ? e.b(location) : e.c(location);
            if (b != null) {
                stringBuffer.append(b);
            }
        }
        z = false;
        if (i == 0) {
            z = true;
        }
        String a2 = b.a().a(z);
        if (a2 != null) {
            stringBuffer.append(a2);
        }
        if (str != null) {
            stringBuffer.append(str);
        }
        str = d.a().d();
        if (!TextUtils.isEmpty(str)) {
            stringBuffer.append("&bc=");
            stringBuffer.append(str);
        }
        if (aVar != null) {
            a = b.a().a(aVar);
            if (a != null && a.length() + stringBuffer.length() < 750) {
                stringBuffer.append(a);
            }
        }
        a = stringBuffer.toString();
        if (!(location == null || hVar == null)) {
            try {
                float speed = location.getSpeed();
                i = d;
                int h = hVar.h();
                int a3 = hVar.a();
                boolean i2 = hVar.i();
                if (speed < ar && ((i == 1 || i == 0) && (h < at || i2))) {
                    q = 1;
                    return a;
                } else if (speed < as && ((i == 1 || i == 0 || i == 3) && (h < au || a3 > av))) {
                    q = 2;
                    return a;
                }
            } catch (Exception unused) {
                q = 3;
                return a;
            }
        }
        q = 3;
        return a;
    }

    public static String a(File file, String str) {
        if (!file.isFile()) {
            return null;
        }
        byte[] bArr = new byte[1024];
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                int read = fileInputStream.read(bArr, 0, 1024);
                if (read != -1) {
                    instance.update(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    return new BigInteger(1, instance.digest()).toString(16);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(o);
        stringBuilder.append(";");
        stringBuilder.append(str);
        return Jni.en1(stringBuilder.toString());
    }

    public static boolean a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
            if (allNetworkInfo != null) {
                for (NetworkInfo state : allNetworkInfo) {
                    if (state.getState() == State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean a(BDLocation bDLocation) {
        int locType = bDLocation.getLocType();
        return (locType > 100 && locType < 200) || locType == 62;
    }

    public static int b(Context context) {
        try {
            return System.getInt(context.getContentResolver(), "airplane_mode_on", 0);
        } catch (Exception unused) {
            return 2;
        }
    }

    public static String b() {
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration inetAddresses = ((NetworkInterface) networkInterfaces.nextElement()).getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                    if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address)) {
                        byte[] address = inetAddress.getAddress();
                        String str = "";
                        for (byte b : address) {
                            StringBuilder stringBuilder;
                            String toHexString = Integer.toHexString(b & 255);
                            if (toHexString.length() == 1) {
                                stringBuilder = new StringBuilder();
                                stringBuilder.append('0');
                                stringBuilder.append(toHexString);
                                toHexString = stringBuilder.toString();
                            }
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(str);
                            stringBuilder.append(toHexString);
                            str = stringBuilder.toString();
                        }
                        return str;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static boolean b(String str, String str2, String str3) {
        try {
            PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(com.baidu.android.bbalbs.common.a.b.a(str3.getBytes())));
            Signature instance = Signature.getInstance("SHA1WithRSA");
            instance.initVerify(generatePublic);
            instance.update(str.getBytes());
            return instance.verify(com.baidu.android.bbalbs.common.a.b.a(str2.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int c(Context context) {
        int i = -1;
        if (VERSION.SDK_INT >= 19) {
            try {
                return Secure.getInt(context.getContentResolver(), "location_mode", -1);
            } catch (Exception unused) {
            }
        } else {
            i = -2;
            return i;
        }
    }

    public static String c() {
        String str = "";
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration inetAddresses = ((NetworkInterface) networkInterfaces.nextElement()).getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                    if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet6Address) && inetAddress.getHostAddress() != null && !inetAddress.getHostAddress().startsWith("fe80:")) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return str;
    }

    public static String d() {
        return aw;
    }

    public static String d(Context context) {
        int a = a(context, "android.permission.ACCESS_COARSE_LOCATION");
        int a2 = a(context, "android.permission.ACCESS_FINE_LOCATION");
        int a3 = a(context, "android.permission.READ_PHONE_STATE");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("&per=");
        stringBuilder.append(a);
        stringBuilder.append("|");
        stringBuilder.append(a2);
        stringBuilder.append("|");
        stringBuilder.append(a3);
        return stringBuilder.toString();
    }

    public static String e() {
        return az;
    }

    public static String e(Context context) {
        int i = -1;
        if (context != null) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                    i = activeNetworkInfo.getType();
                }
            } catch (Exception unused) {
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("&netc=");
        stringBuilder.append(i);
        return stringBuilder.toString();
    }

    public static String f() {
        return "https://daup.map.baidu.com/cltr/rcvr";
    }

    public static String g() {
        try {
            if (Environment.getExternalStorageState().equals("mounted")) {
                String path = Environment.getExternalStorageDirectory().getPath();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(path);
                stringBuilder.append("/baidu/tempdata");
                File file = new File(stringBuilder.toString());
                if (!file.exists()) {
                    file.mkdirs();
                }
                return path;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static String h() {
        String g = g();
        if (g == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(g);
        stringBuilder.append("/baidu/tempdata");
        return stringBuilder.toString();
    }

    public static String i() {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f.getServiceContext().getFilesDir());
            stringBuilder.append(File.separator);
            stringBuilder.append("lldt");
            File file = new File(stringBuilder.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getAbsolutePath();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String j() {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f.getServiceContext().getFilesDir());
            stringBuilder.append(File.separator);
            stringBuilder.append("/baidu/tempdata");
            File file = new File(stringBuilder.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            return f.getServiceContext().getFilesDir().getPath();
        } catch (Exception unused) {
            return null;
        }
    }
}
