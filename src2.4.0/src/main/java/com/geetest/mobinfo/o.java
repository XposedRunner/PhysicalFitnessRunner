package com.geetest.mobinfo;

import android.content.Context;
import android.location.Location;
import android.net.wifi.WifiInfo;
import android.os.Build.VERSION;
import com.bangcle.andJni.JniLib1557756502;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: GtData */
public class o {
    public static JSONArray a() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        InetAddress[] inetAddressArr = new InetAddress[0];
        try {
            inetAddressArr = InetAddress.getAllByName("api.geetest.com");
        } catch (Exception unused) {
        }
        int length = inetAddressArr.length;
        while (i < length) {
            arrayList.add(inetAddressArr[i].getHostAddress());
            i++;
        }
        try {
            return new JSONArray(arrayList.toString());
        } catch (JSONException unused2) {
            return null;
        }
    }

    public static JSONObject a(Context context) {
        return (JSONObject) JniLib1557756502.cL(context, Integer.valueOf(141));
    }

    private static void a(JSONObject jSONObject, Location location) {
        JniLib1557756502.cV(jSONObject, location, Integer.valueOf(142));
    }

    private static void a(JSONObject jSONObject, String str) {
        JniLib1557756502.cV(jSONObject, str, Integer.valueOf(143));
    }

    private static String b() {
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = (NetworkInterface) networkInterfaces.nextElement();
                if ("wlan0".equals(networkInterface.getName())) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        continue;
                    } else if (hardwareAddress.length != 0) {
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
        } catch (SocketException unused) {
        }
        return "$unknown";
    }

    public static String b(Context context) {
        return (String) JniLib1557756502.cL(context, Integer.valueOf(144));
    }

    public static String c(Context context) {
        String str = "$unknown";
        try {
            WifiInfo d = d(context);
            if (d == null) {
                return str;
            }
            return VERSION.SDK_INT >= 23 ? b() : d.getMacAddress();
        } catch (Exception unused) {
            return str;
        }
    }

    private static WifiInfo d(Context context) {
        return (WifiInfo) JniLib1557756502.cL(context, Integer.valueOf(145));
    }
}
