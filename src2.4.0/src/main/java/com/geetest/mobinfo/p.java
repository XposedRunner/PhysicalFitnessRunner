package com.geetest.mobinfo;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Proxy;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.alibaba.wireless.security.SecExceptionCode;
import com.bangcle.andJni.JniLib1557756502;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: GtDataUtils */
public class p {
    static final /* synthetic */ boolean a = true;
    private static final String[] b = new String[]{"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"};
    private static final String[] c = new String[]{"com.noshufou.android.su", "com.noshufou.android.su.elite", "eu.chainfire.supersu", "com.koushikdutta.superuser", "com.thirdparty.superuser", "com.yellowes.su"};
    private static final String[] d = new String[]{"com.koushikdutta.rommanager", "com.dimonvideo.luckypatcher", "com.chelpus.lackypatch", "com.ramdroid.appquarantine"};
    private static final String[] e = new String[]{"com.devadvance.rootcloak", "de.robv.android.xposed.installer", "com.saurik.substrate", "com.devadvance.rootcloakplus", "com.zachspong.temprootremovejb", "com.amphoras.hidemyroot", "com.formyhm.hideroot"};
    private static final String[] f = new String[]{"/system", "/system/bin", "/system/sbin", "/system/xbin", "/vendor/bin", "/sbin", "/etc"};
    private static final Map<String, String> g = new HashMap();

    public static String a() {
        return (String) JniLib1557756502.cL(Integer.valueOf(146));
    }

    public static String a(Context context) {
        return (String) JniLib1557756502.cL(context, Integer.valueOf(147));
    }

    public static String b() {
        return (String) JniLib1557756502.cL(Integer.valueOf(148));
    }

    public static String b(Context context) {
        CharSequence property;
        int parseInt;
        if ((VERSION.SDK_INT >= 14 ? 1 : null) != null) {
            property = System.getProperty("http.proxyHost");
            String property2 = System.getProperty("http.proxyPort");
            if (property2 == null) {
                property2 = "-1";
            }
            parseInt = Integer.parseInt(property2);
        } else {
            String host = Proxy.getHost(context);
            parseInt = Proxy.getPort(context);
            property = host;
        }
        return (TextUtils.isEmpty(property) || parseInt == -1) ? "0" : "1";
    }

    public static int c(Context context) {
        return JniLib1557756502.cI(context, Integer.valueOf(149));
    }

    public static String c() {
        return (VERSION.INCREMENTAL == null || !Build.DISPLAY.contains(VERSION.INCREMENTAL)) ? VERSION.INCREMENTAL : Build.DISPLAY;
    }

    public static String d() {
        Process exec;
        try {
            exec = Runtime.getRuntime().exec("cat /proc/version");
        } catch (IOException unused) {
            exec = null;
        }
        if (exec != null) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()), 8192);
            String str = "";
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(str);
                    stringBuilder.append(readLine);
                    str = stringBuilder.toString();
                } catch (IOException unused2) {
                }
            }
            if (!"".equals(str)) {
                String str2 = "version ";
                str2 = str.substring(str.indexOf(str2) + str2.length());
                return str2.substring(0, str2.indexOf(" "));
            }
        }
        return "$unknown";
    }

    public static String d(Context context) {
        return (String) JniLib1557756502.cL(context, Integer.valueOf(SecExceptionCode.SEC_ERROR_INIT_NO_ANNOTATION));
    }

    private static List<String> e(Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(c));
        arrayList.addAll(Arrays.asList(d));
        arrayList.addAll(Arrays.asList(e));
        PackageManager packageManager = context.getPackageManager();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            try {
                packageManager.getPackageInfo(str, 0);
                arrayList2.add(str);
            } catch (NameNotFoundException unused) {
            }
        }
        return arrayList2;
    }

    public static JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = (NetworkInterface) networkInterfaces.nextElement();
                Enumeration inetAddresses = networkInterface.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                    StringBuilder stringBuilder = new StringBuilder();
                    if (inetAddress.getAddress().length == 4) {
                        for (int i = 0; i < 4; i++) {
                            if (inetAddress.getAddress()[i] < (byte) 0) {
                                stringBuilder.append(inetAddress.getAddress()[i] + 256);
                                stringBuilder.append(".");
                            } else {
                                stringBuilder.append(inetAddress.getAddress()[i]);
                                stringBuilder.append(".");
                            }
                        }
                        jSONObject.put(networkInterface.getName(), stringBuilder.toString().substring(0, stringBuilder.toString().length() - 1));
                    }
                }
                jSONObject.put("ipv6", f());
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static String f() {
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration inetAddresses = ((NetworkInterface) networkInterfaces.nextElement()).getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        String toLowerCase = inetAddress.getHostAddress().toLowerCase();
                        if (toLowerCase.indexOf(37) > -1) {
                            toLowerCase = toLowerCase.substring(0, toLowerCase.indexOf(37));
                        }
                        return toLowerCase;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return "$unknown";
    }

    private static List<String> g() {
        ArrayList arrayList = new ArrayList();
        for (String str : b) {
            if (new File(str).exists()) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    private static List<String> h() {
        g.put("[ro.debuggable]", "[1]");
        g.put("[ro.secure]", "[0]");
        String[] j = j();
        ArrayList arrayList = new ArrayList();
        if (a || j != null) {
            for (String str : j) {
                for (String str2 : g.keySet()) {
                    if (str.contains(str2) && str.contains((CharSequence) g.get(str2))) {
                        arrayList.add(str);
                    }
                }
            }
            return arrayList;
        }
        throw new AssertionError();
    }

    private static List<String> i() {
        String[] k = k();
        ArrayList arrayList = new ArrayList();
        if (a || k != null) {
            for (String split : k) {
                String split2;
                String[] split3 = split2.split(" ");
                if (split3.length >= 4) {
                    String str = split3[1];
                    split2 = split3[3];
                    for (String str2 : f) {
                        if (str.equalsIgnoreCase(str2)) {
                            for (String equalsIgnoreCase : split2.split(",")) {
                                if ("rw".equalsIgnoreCase(equalsIgnoreCase)) {
                                    arrayList.add(str2);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            return arrayList;
        }
        throw new AssertionError();
    }

    private static String[] j() {
        return (String[]) JniLib1557756502.cL(Integer.valueOf(151));
    }

    private static String[] k() {
        return (String[]) JniLib1557756502.cL(Integer.valueOf(152));
    }
}
