package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v4.os.EnvironmentCompat;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import java.util.List;

public class NetworkHelper {
    public static void clearCookies(Context context) {
        CookieSyncManager.createInstance(context);
        CookieManager.getInstance().removeAllCookie();
        CookieSyncManager.getInstance().sync();
    }

    public static String generateUA(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Android");
        stringBuilder.append("__");
        stringBuilder.append("weibo");
        stringBuilder.append("__");
        stringBuilder.append("sdk");
        stringBuilder.append("__");
        try {
            stringBuilder.append(context.getPackageManager().getPackageInfo(context.getPackageName(), 16).versionName.replaceAll("\\s+", "_"));
        } catch (Exception unused) {
            stringBuilder.append(EnvironmentCompat.MEDIA_UNKNOWN);
        }
        return stringBuilder.toString();
    }

    public static NetworkInfo getActiveNetworkInfo(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
    }

    public static NetworkInfo getNetworkInfo(Context context, int i) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(i);
    }

    public static int getNetworkType(Context context) {
        int i = -1;
        if (context == null) {
            return -1;
        }
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        if (activeNetworkInfo != null) {
            i = activeNetworkInfo.getType();
        }
        return i;
    }

    public static DetailedState getWifiConnectivityState(Context context) {
        NetworkInfo networkInfo = getNetworkInfo(context, 1);
        return networkInfo == null ? DetailedState.FAILED : networkInfo.getDetailedState();
    }

    public static int getWifiState(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        return wifiManager == null ? 4 : wifiManager.getWifiState();
    }

    public static boolean hasInternetPermission(Context context) {
        boolean z = true;
        if (context == null) {
            return true;
        }
        if (context.checkCallingOrSelfPermission("android.permission.INTERNET") != 0) {
            z = false;
        }
        return z;
    }

    public static boolean isMobileNetwork(Context context) {
        boolean z = false;
        if (context == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        if (activeNetworkInfo == null) {
            return false;
        }
        if (activeNetworkInfo != null && activeNetworkInfo.getType() == 0 && activeNetworkInfo.isConnected()) {
            z = true;
        }
        return z;
    }

    public static boolean isNetworkAvailable(Context context) {
        boolean z = false;
        if (context == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            z = true;
        }
        return z;
    }

    public static boolean isWifiValid(Context context) {
        boolean z = false;
        if (context == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        if (activeNetworkInfo != null && 1 == activeNetworkInfo.getType() && activeNetworkInfo.isConnected()) {
            z = true;
        }
        return z;
    }

    public static boolean wifiConnection(Context context, String str, String str2) {
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\"");
        stringBuilder.append(str);
        stringBuilder.append("\"");
        String stringBuilder2 = stringBuilder.toString();
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        if (connectionInfo != null && (str.equals(connectionInfo.getSSID()) || stringBuilder2.equals(connectionInfo.getSSID()))) {
            return true;
        }
        List scanResults = wifiManager.getScanResults();
        if (!(scanResults == null || scanResults.size() == 0)) {
            for (int size = scanResults.size() - 1; size >= 0; size--) {
                String str3 = ((ScanResult) scanResults.get(size)).SSID;
                if (str.equals(str3) || stringBuilder2.equals(str3)) {
                    WifiConfiguration wifiConfiguration = new WifiConfiguration();
                    wifiConfiguration.SSID = stringBuilder2;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("\"");
                    stringBuilder.append(str2);
                    stringBuilder.append("\"");
                    wifiConfiguration.preSharedKey = stringBuilder.toString();
                    wifiConfiguration.status = 2;
                    return wifiManager.enableNetwork(wifiManager.addNetwork(wifiConfiguration), false);
                }
            }
        }
        return false;
    }
}
