package com.baidu.location.e;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Handler;
import cn.jiguang.net.HttpUtils;
import com.baidu.location.f;
import java.util.List;

public class i {
    public static long a;
    private static i b;
    private WifiManager c = null;
    private a d = null;
    private h e = null;
    private long f = 0;
    private long g = 0;
    private boolean h = false;
    private Handler i = new Handler();
    private long j = 0;
    private long k = 0;

    private class a extends BroadcastReceiver {
        private long b;
        private boolean c;

        private a() {
            this.b = 0;
            this.c = false;
        }

        public void onReceive(Context context, Intent intent) {
            if (context != null) {
                String action = intent.getAction();
                if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                    i.a = System.currentTimeMillis() / 1000;
                    i.this.i.post(new j(this));
                } else if (action.equals("android.net.wifi.STATE_CHANGE") && ((NetworkInfo) intent.getParcelableExtra("networkInfo")).getState().equals(State.CONNECTED) && System.currentTimeMillis() - this.b >= 5000) {
                    this.b = System.currentTimeMillis();
                    if (!this.c) {
                        this.c = true;
                    }
                }
            }
        }
    }

    private i() {
    }

    public static synchronized i a() {
        i iVar;
        synchronized (i.class) {
            if (b == null) {
                b = new i();
            }
            iVar = b;
        }
        return iVar;
    }

    private String a(long j) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.valueOf((int) (j & 255)));
        stringBuffer.append('.');
        stringBuffer.append(String.valueOf((int) ((j >> 8) & 255)));
        stringBuffer.append('.');
        stringBuffer.append(String.valueOf((int) ((j >> 16) & 255)));
        stringBuffer.append('.');
        stringBuffer.append(String.valueOf((int) ((j >> 24) & 255)));
        return stringBuffer.toString();
    }

    public static boolean a(h hVar, h hVar2) {
        boolean a = a(hVar, hVar2, 0.7f);
        long currentTimeMillis = System.currentTimeMillis() - com.baidu.location.a.a.c;
        return (currentTimeMillis <= 0 || currentTimeMillis >= StatisticConfig.MIN_UPLOAD_INTERVAL || !a || hVar2.g() - hVar.g() <= 30) ? a : false;
    }

    public static boolean a(h hVar, h hVar2, float f) {
        if (hVar == null || hVar2 == null) {
            return false;
        }
        List list = hVar.a;
        List list2 = hVar2.a;
        if (list == list2) {
            return true;
        }
        if (list == null || list2 == null) {
            return false;
        }
        int size = list.size();
        int size2 = list2.size();
        if (size == 0 && size2 == 0) {
            return true;
        }
        if (size == 0 || size2 == 0) {
            return false;
        }
        int i = 0;
        int i2 = i;
        while (i < size) {
            String str = ((ScanResult) list.get(i)).BSSID;
            if (str != null) {
                for (int i3 = 0; i3 < size2; i3++) {
                    if (str.equals(((ScanResult) list2.get(i3)).BSSID)) {
                        i2++;
                        break;
                    }
                }
            }
            i++;
        }
        return ((float) i2) >= ((float) size) * f;
    }

    public static boolean j() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) f.getServiceContext().getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
        } catch (Exception unused) {
            return false;
        }
    }

    private void s() {
        if (this.c != null) {
            try {
                List scanResults = this.c.getScanResults();
                if (scanResults != null) {
                    h hVar = new h(scanResults, System.currentTimeMillis());
                    if (this.e == null || !hVar.a(this.e)) {
                        this.e = hVar;
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public void b() {
        this.j = 0;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0038 */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:12|13|14|15|16|17|18|19) */
    public synchronized void c() {
        /*
        r5 = this;
        monitor-enter(r5);
        r0 = r5.h;	 Catch:{ all -> 0x003c }
        r1 = 1;
        if (r0 != r1) goto L_0x0008;
    L_0x0006:
        monitor-exit(r5);
        return;
    L_0x0008:
        r0 = com.baidu.location.f.isServing;	 Catch:{ all -> 0x003c }
        if (r0 != 0) goto L_0x000e;
    L_0x000c:
        monitor-exit(r5);
        return;
    L_0x000e:
        r0 = com.baidu.location.f.getServiceContext();	 Catch:{ all -> 0x003c }
        r0 = r0.getApplicationContext();	 Catch:{ all -> 0x003c }
        r2 = "wifi";
        r0 = r0.getSystemService(r2);	 Catch:{ all -> 0x003c }
        r0 = (android.net.wifi.WifiManager) r0;	 Catch:{ all -> 0x003c }
        r5.c = r0;	 Catch:{ all -> 0x003c }
        r0 = new com.baidu.location.e.i$a;	 Catch:{ all -> 0x003c }
        r2 = 0;
        r0.<init>();	 Catch:{ all -> 0x003c }
        r5.d = r0;	 Catch:{ all -> 0x003c }
        r0 = com.baidu.location.f.getServiceContext();	 Catch:{ Exception -> 0x0038 }
        r2 = r5.d;	 Catch:{ Exception -> 0x0038 }
        r3 = new android.content.IntentFilter;	 Catch:{ Exception -> 0x0038 }
        r4 = "android.net.wifi.SCAN_RESULTS";
        r3.<init>(r4);	 Catch:{ Exception -> 0x0038 }
        r0.registerReceiver(r2, r3);	 Catch:{ Exception -> 0x0038 }
    L_0x0038:
        r5.h = r1;	 Catch:{ all -> 0x003c }
        monitor-exit(r5);
        return;
    L_0x003c:
        r0 = move-exception;
        monitor-exit(r5);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.e.i.c():void");
    }

    public List<WifiConfiguration> d() {
        try {
            return this.c != null ? this.c.getConfiguredNetworks() : null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public synchronized void e() {
        if (this.h) {
            try {
                f.getServiceContext().unregisterReceiver(this.d);
                a = 0;
            } catch (Exception unused) {
            }
            this.d = null;
            this.c = null;
            this.h = false;
        }
    }

    public boolean f() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.g > 0 && currentTimeMillis - this.g <= 5000) {
            return false;
        }
        this.g = currentTimeMillis;
        b();
        return g();
    }

    public boolean g() {
        if (this.c == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f > 0) {
            if (currentTimeMillis - this.f <= 5000 + this.j || currentTimeMillis - (a * 1000) <= 5000 + this.j) {
                return false;
            }
            if (j() && currentTimeMillis - this.f <= 10000 + this.j) {
                return false;
            }
        }
        return i();
    }

    @SuppressLint({"NewApi"})
    public String h() {
        String str = "";
        if (this.c != null) {
            try {
                if (this.c.isWifiEnabled() || (VERSION.SDK_INT > 17 && this.c.isScanAlwaysAvailable())) {
                    return "&wifio=1";
                }
            } catch (Exception | NoSuchMethodError unused) {
            }
        }
        return str;
    }

    @SuppressLint({"NewApi"})
    public boolean i() {
        long currentTimeMillis = System.currentTimeMillis() - this.k;
        boolean z = false;
        if (currentTimeMillis >= 0 && currentTimeMillis <= 2000) {
            return false;
        }
        this.k = System.currentTimeMillis();
        try {
            if (!this.c.isWifiEnabled()) {
                if (VERSION.SDK_INT <= 17 || !this.c.isScanAlwaysAvailable()) {
                    return false;
                }
            }
            this.c.startScan();
            this.f = System.currentTimeMillis();
            z = true;
        } catch (Exception | NoSuchMethodError unused) {
        }
        return z;
    }

    @SuppressLint({"NewApi"})
    public boolean k() {
        boolean z = false;
        try {
            if (this.c.isWifiEnabled() || (VERSION.SDK_INT > 17 && this.c.isScanAlwaysAvailable())) {
                if (j()) {
                    return false;
                }
                h hVar = new h(this.c.getScanResults(), 0);
                if (hVar != null && hVar.e()) {
                    z = true;
                }
            }
        } catch (Exception | NoSuchMethodError unused) {
        }
        return z;
    }

    public WifiInfo l() {
        if (this.c == null) {
            return null;
        }
        try {
            WifiInfo connectionInfo = this.c.getConnectionInfo();
            if (connectionInfo == null || connectionInfo.getBSSID() == null || connectionInfo.getRssi() <= -100) {
                return null;
            }
            String bssid = connectionInfo.getBSSID();
            if (bssid != null) {
                bssid = bssid.replace(":", "");
                if ("000000000000".equals(bssid) || "".equals(bssid)) {
                    return null;
                }
            }
            return connectionInfo;
        } catch (Error | Exception unused) {
        }
        return null;
    }

    public String m() {
        StringBuffer stringBuffer = new StringBuffer();
        WifiInfo l = a().l();
        if (!(l == null || l.getBSSID() == null)) {
            String replace = l.getBSSID().replace(":", "");
            int rssi = l.getRssi();
            String n = a().n();
            if (rssi < 0) {
                rssi = -rssi;
            }
            if (replace != null && rssi < 100) {
                stringBuffer.append("&wf=");
                stringBuffer.append(replace);
                stringBuffer.append(";");
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("");
                stringBuilder.append(rssi);
                stringBuilder.append(";");
                stringBuffer.append(stringBuilder.toString());
                String ssid = l.getSSID();
                if (ssid != null && (ssid.contains(HttpUtils.PARAMETERS_SEPARATOR) || ssid.contains(";"))) {
                    ssid = ssid.replace(HttpUtils.PARAMETERS_SEPARATOR, "_");
                }
                stringBuffer.append(ssid);
                stringBuffer.append("&wf_n=1");
                if (n != null) {
                    stringBuffer.append("&wf_gw=");
                    stringBuffer.append(n);
                }
                return stringBuffer.toString();
            }
        }
        return null;
    }

    public String n() {
        if (this.c != null) {
            DhcpInfo dhcpInfo = this.c.getDhcpInfo();
            if (dhcpInfo != null) {
                return a((long) dhcpInfo.gateway);
            }
        }
        return null;
    }

    public h o() {
        return (this.e == null || !this.e.j()) ? q() : this.e;
    }

    public h p() {
        return (this.e == null || !this.e.k()) ? q() : this.e;
    }

    public h q() {
        if (this.c != null) {
            try {
                return new h(this.c.getScanResults(), this.f);
            } catch (Exception unused) {
            }
        }
        return new h(null, 0);
    }

    public String r() {
        try {
            WifiInfo connectionInfo = this.c.getConnectionInfo();
            if (connectionInfo != null) {
                return connectionInfo.getMacAddress();
            }
        } catch (Error | Exception unused) {
        }
        return null;
    }
}
