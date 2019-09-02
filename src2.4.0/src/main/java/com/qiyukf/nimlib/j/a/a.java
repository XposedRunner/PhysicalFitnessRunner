package com.qiyukf.nimlib.j.a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.DhcpInfo;
import android.net.NetworkInfo.DetailedState;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class a {

    public static class b {
        public String e;
        public String f;
        public int g;
        public int h;
        public int i;
        public String j;

        public b(String str, String str2) {
            this.e = str;
            this.f = str2;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("NIMWifiInfo{bssid='");
            stringBuilder.append(this.e);
            stringBuilder.append('\'');
            stringBuilder.append(",ssid='");
            stringBuilder.append(this.f);
            stringBuilder.append('\'');
            stringBuilder.append(",frequency=");
            stringBuilder.append(this.g);
            stringBuilder.append(",speed=");
            stringBuilder.append(this.h);
            stringBuilder.append(",rssi=");
            stringBuilder.append(this.i);
            stringBuilder.append(",ip='");
            stringBuilder.append(this.j);
            stringBuilder.append('\'');
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    public static class a extends b {
        public String a;
        public String b;
        public String c;
        public String d;

        public a(String str, String str2) {
            super(str, str2);
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("NIMConnectedWifiInfo{bssid='");
            stringBuilder.append(this.e);
            stringBuilder.append('\'');
            stringBuilder.append(",ssid='");
            stringBuilder.append(this.f);
            stringBuilder.append('\'');
            stringBuilder.append(",frequency=");
            stringBuilder.append(this.g);
            stringBuilder.append(",speed=");
            stringBuilder.append(this.h);
            stringBuilder.append(",rssi=");
            stringBuilder.append(this.i);
            stringBuilder.append(",ip='");
            stringBuilder.append(this.j);
            stringBuilder.append('\'');
            stringBuilder.append(",dns1='");
            stringBuilder.append(this.a);
            stringBuilder.append('\'');
            stringBuilder.append(",dns2='");
            stringBuilder.append(this.b);
            stringBuilder.append('\'');
            stringBuilder.append(",gateway='");
            stringBuilder.append(this.c);
            stringBuilder.append('\'');
            stringBuilder.append(",netmask='");
            stringBuilder.append(this.d);
            stringBuilder.append('\'');
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    public static a a(Context context) {
        WifiManager c = c(context);
        if (c == null) {
            return null;
        }
        com.qiyukf.basesdk.a.a.b("stat", "begin to get connected wifi info...");
        if (d(context)) {
            try {
                if (c.isWifiEnabled()) {
                    WifiInfo connectionInfo = c.getConnectionInfo();
                    if (connectionInfo != null) {
                        DetailedState detailedStateOf = WifiInfo.getDetailedStateOf(connectionInfo.getSupplicantState());
                        if (detailedStateOf == DetailedState.CONNECTED || detailedStateOf == DetailedState.OBTAINING_IPADDR) {
                            if ("00:00:00:00:00:00".equals(connectionInfo.getBSSID())) {
                                return null;
                            }
                            a aVar = new a(connectionInfo.getBSSID(), connectionInfo.getSSID());
                            if (VERSION.SDK_INT >= 21) {
                                aVar.g = connectionInfo.getFrequency();
                            }
                            aVar.h = connectionInfo.getLinkSpeed();
                            aVar.i = connectionInfo.getRssi();
                            int ipAddress = connectionInfo.getIpAddress();
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(ipAddress & 255);
                            stringBuilder.append(".");
                            stringBuilder.append((ipAddress >> 8) & 255);
                            stringBuilder.append(".");
                            stringBuilder.append((ipAddress >> 16) & 255);
                            stringBuilder.append(".");
                            stringBuilder.append(ipAddress >>> 24);
                            aVar.j = stringBuilder.toString();
                            DhcpInfo dhcpInfo = c.getDhcpInfo();
                            aVar.a = a(dhcpInfo.dns1);
                            aVar.b = a(dhcpInfo.dns2);
                            aVar.c = a(dhcpInfo.gateway);
                            aVar.d = a(dhcpInfo.netmask);
                            StringBuilder stringBuilder2 = new StringBuilder("find connected wifi: ");
                            stringBuilder2.append(aVar.toString());
                            com.qiyukf.basesdk.a.a.b("stat", stringBuilder2.toString());
                            return aVar;
                        }
                    }
                    return null;
                }
                com.qiyukf.basesdk.a.a.b("stat", "wifi is disable");
                return null;
            } catch (Throwable th) {
                th.printStackTrace();
                StringBuilder stringBuilder3 = new StringBuilder("get connected wifi info failed, e=");
                stringBuilder3.append(th.getMessage());
                com.qiyukf.basesdk.a.a.b("stat", stringBuilder3.toString());
            }
        } else {
            com.qiyukf.basesdk.a.a.b("stat", "unable to get connected wifi info, as permission is not granted");
            return null;
        }
    }

    private static String a(int i) {
        String str = "";
        byte[] bArr = new byte[4];
        int i2 = 0;
        while (true) {
            if (i2 >= 4) {
                break;
            }
            bArr[i2] = (byte) (i >>> ((3 - i2) << 3));
            i2++;
        }
        for (int i3 = 3; i3 >= 0; i3--) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(bArr[i3] & 255);
            String stringBuilder2 = stringBuilder.toString();
            if (i3 > 0) {
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(stringBuilder2);
                stringBuilder3.append(".");
                stringBuilder2 = stringBuilder3.toString();
            }
            str = stringBuilder2;
        }
        return str;
    }

    public static List<b> b(Context context) {
        WifiManager c = c(context);
        if (c == null) {
            return null;
        }
        com.qiyukf.basesdk.a.a.b("stat", "begin to scan wifi list...");
        if (d(context)) {
            try {
                if (c.isWifiEnabled()) {
                    List<ScanResult> scanResults = c.getScanResults();
                    if (scanResults != null) {
                        if (!scanResults.isEmpty()) {
                            Collections.sort(scanResults, new Comparator<ScanResult>() {
                                public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                                    return ((ScanResult) obj2).level - ((ScanResult) obj).level;
                                }
                            });
                            ArrayList arrayList = new ArrayList(scanResults.size());
                            for (ScanResult scanResult : scanResults) {
                                if (!"00:00:00:00:00:00".equals(scanResult.BSSID)) {
                                    b bVar = new b(scanResult.BSSID, scanResult.SSID);
                                    bVar.g = scanResult.frequency;
                                    bVar.i = scanResult.level;
                                    arrayList.add(bVar);
                                    StringBuilder stringBuilder = new StringBuilder("find wifi: ");
                                    stringBuilder.append(bVar.toString());
                                    com.qiyukf.basesdk.a.a.b("stat", stringBuilder.toString());
                                }
                            }
                            return arrayList;
                        }
                    }
                    com.qiyukf.basesdk.a.a.b("stat", "find empty wifi node");
                    return null;
                }
                com.qiyukf.basesdk.a.a.b("stat", "wifi is disable");
                return null;
            } catch (Throwable th) {
                th.printStackTrace();
                StringBuilder stringBuilder2 = new StringBuilder("scan wifi list failed, e=");
                stringBuilder2.append(th.getMessage());
                com.qiyukf.basesdk.a.a.b("stat", stringBuilder2.toString());
                return null;
            }
        }
        com.qiyukf.basesdk.a.a.b("stat", "unable to scan wifi list, as permission is not granted");
        return null;
    }

    private static WifiManager c(Context context) {
        try {
            return (WifiManager) context.getApplicationContext().getSystemService("wifi");
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("get system service WifiManager failed, e=");
            stringBuilder.append(th.getMessage());
            com.qiyukf.basesdk.a.a.b("stat", stringBuilder.toString());
            return null;
        }
    }

    private static boolean d(Context context) {
        if (context == null) {
            return false;
        }
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        String packageName = context.getApplicationContext().getPackageName();
        boolean z = packageManager.checkPermission("android.permission.ACCESS_WIFI_STATE", packageName) == 0;
        boolean z2 = packageManager.checkPermission("android.permission.ACCESS_NETWORK_STATE", packageName) == 0;
        StringBuilder stringBuilder = new StringBuilder("check permission ACCESS_WIFI_STATE ");
        stringBuilder.append(z);
        stringBuilder.append(", check ACCESS_NETWORK_STATE ");
        stringBuilder.append(z2);
        com.qiyukf.basesdk.a.a.b("stat", stringBuilder.toString());
        return z && z2;
    }
}
