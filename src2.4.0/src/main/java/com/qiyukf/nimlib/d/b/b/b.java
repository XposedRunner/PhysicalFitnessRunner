package com.qiyukf.nimlib.d.b.b;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.NetworkInfo.DetailedState;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import com.qiyukf.nimlib.d.a.b.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class b {
    public static a a(Context context) {
        WifiManager c = c(context);
        if (c == null) {
            return null;
        }
        r3 = new String[2];
        int i = 0;
        r3[0] = "android.permission.ACCESS_WIFI_STATE";
        r3[1] = "android.permission.ACCESS_NETWORK_STATE";
        if (context != null) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                String str = context.getApplicationInfo().packageName;
                for (int i2 = 0; i2 < 2; i2++) {
                    if (packageManager.checkPermission(r3[i2], str) != 0) {
                        break;
                    }
                }
                i = 1;
            }
        }
        if (i == 0) {
            a.c("unable to get connected wifi info, as wifi/network permission is not granted");
            return null;
        }
        try {
            if (c.isWifiEnabled()) {
                WifiInfo connectionInfo = c.getConnectionInfo();
                if (connectionInfo != null) {
                    DetailedState detailedStateOf = WifiInfo.getDetailedStateOf(connectionInfo.getSupplicantState());
                    if (detailedStateOf == DetailedState.CONNECTED || detailedStateOf == DetailedState.OBTAINING_IPADDR) {
                        a aVar = new a(connectionInfo.getBSSID(), connectionInfo.getSSID());
                        if (VERSION.SDK_INT >= 21) {
                            aVar.d = connectionInfo.getFrequency();
                        }
                        aVar.e = connectionInfo.getLinkSpeed();
                        aVar.c = connectionInfo.getRssi();
                        int ipAddress = connectionInfo.getIpAddress();
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(ipAddress & 255);
                        stringBuilder.append(".");
                        stringBuilder.append((ipAddress >> 8) & 255);
                        stringBuilder.append(".");
                        stringBuilder.append((ipAddress >> 16) & 255);
                        stringBuilder.append(".");
                        stringBuilder.append(ipAddress >>> 24);
                        aVar.f = stringBuilder.toString();
                        return aVar;
                    }
                }
                return null;
            }
            a.c("wifi is disable");
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            StringBuilder stringBuilder2 = new StringBuilder("get connected wifi info failed, e=");
            stringBuilder2.append(th.getMessage());
            a.c(stringBuilder2.toString());
        }
    }

    public static List<a> b(Context context) {
        WifiManager c = c(context);
        if (c == null) {
            return null;
        }
        String str;
        if (!com.qiyukf.nimlib.d.a.d.b.a(context, "android.permission.ACCESS_WIFI_STATE")) {
            str = "unable to scan wifi list, as wifi permission is not granted";
        } else if (com.qiyukf.nimlib.d.a.d.b.a(context, "android.permission.ACCESS_COARSE_LOCATION") || com.qiyukf.nimlib.d.a.d.b.a(context, "android.permission.ACCESS_FINE_LOCATION")) {
            try {
                if (c.isWifiEnabled()) {
                    List<ScanResult> scanResults = c.getScanResults();
                    if (scanResults == null || scanResults.isEmpty()) {
                        return null;
                    }
                    Collections.sort(scanResults, new Comparator<ScanResult>() {
                        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                            return ((ScanResult) obj2).level - ((ScanResult) obj).level;
                        }
                    });
                    ArrayList arrayList = new ArrayList(scanResults.size());
                    for (ScanResult scanResult : scanResults) {
                        a aVar = new a(scanResult.BSSID, scanResult.SSID);
                        aVar.d = scanResult.frequency;
                        aVar.c = scanResult.level;
                        arrayList.add(aVar);
                        if (arrayList.size() >= 10) {
                            break;
                        }
                    }
                    return arrayList;
                }
                a.c("wifi is disable");
                return null;
            } catch (Throwable th) {
                th.printStackTrace();
                StringBuilder stringBuilder = new StringBuilder("scan wifi list failed, e=");
                stringBuilder.append(th.getMessage());
                a.c(stringBuilder.toString());
                return null;
            }
        } else {
            str = "unable to scan wifi list, as location permission is not granted";
        }
        a.c(str);
        return null;
    }

    private static WifiManager c(Context context) {
        try {
            return (WifiManager) context.getApplicationContext().getSystemService("wifi");
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("get WifiManager failed, e=");
            stringBuilder.append(th.getMessage());
            a.c(stringBuilder.toString());
            return null;
        }
    }
}
