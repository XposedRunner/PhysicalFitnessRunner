package com.geetest.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Proxy;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.support.v4.content.ContextCompat;
import android.support.v4.os.EnvironmentCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.format.Formatter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: GT3GainIp */
public final class O0Oo0o0 {
    private static String O000000o = "$unknown";

    public static String O000000o() {
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration inetAddresses = ((NetworkInterface) networkInterfaces.nextElement()).getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        String toLowerCase = inetAddress.getHostAddress().toLowerCase();
                        if (toLowerCase.indexOf(37) >= 0) {
                            toLowerCase = toLowerCase.substring(0, toLowerCase.indexOf(37));
                        }
                        return toLowerCase;
                    }
                }
            }
        } catch (Exception | SocketException unused) {
        }
        return null;
    }

    public static String O000000o(Context context) {
        String str = EnvironmentCompat.MEDIA_UNKNOWN;
        try {
            return Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String O00000Oo() {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = (NetworkInterface) networkInterfaces.nextElement();
                StringBuffer stringBuffer2 = new StringBuffer();
                Enumeration inetAddresses = networkInterface.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                    StringBuffer stringBuffer3 = new StringBuffer();
                    if (inetAddress.getAddress().length == 4) {
                        for (int i = 0; i < 4; i++) {
                            StringBuilder stringBuilder;
                            if (inetAddress.getAddress()[i] < (byte) 0) {
                                stringBuilder = new StringBuilder();
                                stringBuilder.append(inetAddress.getAddress()[i] + 256);
                                stringBuilder.append(".");
                                stringBuffer3.append(stringBuilder.toString());
                            } else {
                                stringBuilder = new StringBuilder();
                                stringBuilder.append(inetAddress.getAddress()[i]);
                                stringBuilder.append(".");
                                stringBuffer3.append(stringBuilder.toString());
                            }
                        }
                        StringBuilder stringBuilder2 = new StringBuilder(" \"");
                        stringBuilder2.append(networkInterface.getName());
                        stringBuilder2.append("\":");
                        stringBuilder2.append(stringBuffer3.toString().substring(0, stringBuffer3.toString().length() - 1));
                        stringBuffer2.append(stringBuilder2.toString());
                    }
                }
                stringBuffer.append(stringBuffer2.toString());
            }
            return stringBuffer.toString();
        } catch (SocketException unused) {
            return "";
        }
    }

    public static String O00000Oo(Context context) {
        WifiInfo O0000Oo0 = O0000Oo0(context);
        return O0000Oo0 != null ? ooooooo.O000000o(O0000Oo0.getSSID().replace("\"", "")) : null;
    }

    private static String O00000o() {
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = (NetworkInterface) networkInterfaces.nextElement();
                if ("wlan0".equals(networkInterface.getName())) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (!(hardwareAddress == null || hardwareAddress.length == 0)) {
                        StringBuilder stringBuilder = new StringBuilder();
                        int length = hardwareAddress.length;
                        for (int i = 0; i < length; i++) {
                            stringBuilder.append(String.format("%02X:", new Object[]{Byte.valueOf(hardwareAddress[i])}));
                        }
                        if (stringBuilder.length() > 0) {
                            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                        }
                        return stringBuilder.toString();
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return "$unknown";
    }

    public static JSONObject O00000o(Context context) {
        JSONObject jSONObject = new JSONObject();
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("level", -1);
            int intExtra2 = registerReceiver.getIntExtra("scale", -1);
            double d = -1.0d;
            if (!(intExtra == -1 || intExtra2 == -1)) {
                d = ((double) intExtra) / ((double) intExtra2);
            }
            intExtra = registerReceiver.getIntExtra("status", -1);
            intExtra2 = registerReceiver.getIntExtra("plugged", -1);
            int intExtra3 = registerReceiver.getIntExtra("health", -1);
            try {
                jSONObject.put("br", String.valueOf(d));
                jSONObject.put("bs", String.valueOf(intExtra));
                jSONObject.put("plugState", String.valueOf(intExtra2));
                jSONObject.put("health", String.valueOf(intExtra3));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    public static float O00000o0(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return 0.0f;
        }
        return (100.0f * ((float) registerReceiver.getIntExtra("level", 0))) / ((float) registerReceiver.getIntExtra("scale", 100));
    }

    public static String O00000o0() {
        ArrayList arrayList = new ArrayList();
        if (!"$unknown".equals(O000000o)) {
            return O000000o;
        }
        int i = 0;
        InetAddress[] inetAddressArr = new InetAddress[0];
        try {
            inetAddressArr = InetAddress.getAllByName("www.geetest.com");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        int length = inetAddressArr.length;
        while (i < length) {
            arrayList.add(inetAddressArr[i].getHostAddress());
            i++;
        }
        O000000o = arrayList.toString();
        return arrayList.toString();
    }

    public static int O00000oO(Context context) {
        String str;
        try {
            if (ContextCompat.checkSelfPermission(context, "android.permission.READ_PHONE_STATE") != 0) {
                str = "$unknown";
            } else {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                str = telephonyManager != null ? telephonyManager.getSubscriberId() : "$unknown";
            }
        } catch (Exception e) {
            e.printStackTrace();
            str = "$unknown";
        }
        if (str != null) {
            if (str.startsWith("46000") || str.startsWith("46002") || str.startsWith("46004") || str.startsWith("46007")) {
                return 1;
            }
            if (str.startsWith("46001") || str.startsWith("46006") || str.startsWith("46009")) {
                return 2;
            }
            if (str.startsWith("46003") || str.startsWith("46005") || str.startsWith("46011")) {
                return 3;
            }
        }
        return 0;
    }

    public static String O00000oo(Context context) {
        String str = "$unknown";
        WifiInfo O0000Oo0 = O0000Oo0(context);
        return O0000Oo0 != null ? VERSION.SDK_INT >= 23 ? O00000o() : O0000Oo0.getMacAddress() : str;
    }

    public static String O0000O0o(Context context) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            long longValue = Long.valueOf(bufferedReader.readLine().split("\\s+")[1]).longValue() << 10;
            bufferedReader.close();
            return Formatter.formatFileSize(context, longValue);
        } catch (IOException unused) {
            return "$unknown";
        }
    }

    public static boolean O0000OOo(Context context) {
        CharSequence property;
        int parseInt;
        if (VERSION.SDK_INT >= 14) {
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
        return (TextUtils.isEmpty(property) || parseInt == -1) ? false : true;
    }

    private static WifiInfo O0000Oo0(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        return wifiManager != null ? wifiManager.getConnectionInfo() : null;
    }
}
