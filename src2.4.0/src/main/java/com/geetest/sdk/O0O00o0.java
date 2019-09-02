package com.geetest.sdk;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import org.json.JSONObject;

/* compiled from: MobUtils */
public final class O0O00o0 {
    public static String O000000o() {
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
                jSONObject.put("ipv6", O00000Oo());
            }
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    private static String O00000Oo() {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "$unknown";
    }
}
