package com.loc;

import android.content.ContentResolver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.alibaba.wireless.security.SecExceptionCode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;

/* compiled from: WifiManagerWrapper */
public final class O0OOO00 {
    static long O00000o;
    static long O00000o0;
    static long O00000oO;
    static long O00000oo;
    static long O0000O0o;
    public static HashMap<String, Long> O0000o = new HashMap(36);
    static int O0000oO;
    public static long O0000oO0;
    WifiManager O000000o;
    ArrayList<ScanResult> O00000Oo = new ArrayList();
    Context O0000OOo;
    StringBuilder O0000Oo = null;
    boolean O0000Oo0 = false;
    boolean O0000OoO = true;
    boolean O0000Ooo = true;
    String O0000o0 = null;
    boolean O0000o00 = true;
    TreeMap<Integer, ScanResult> O0000o0O = null;
    public boolean O0000o0o = true;
    ConnectivityManager O0000oOO = null;
    volatile boolean O0000oOo = false;
    private long O0000oo = StatisticConfig.MIN_UPLOAD_INTERVAL;
    private volatile WifiInfo O0000oo0 = null;

    public O0OOO00(Context context, WifiManager wifiManager) {
        this.O000000o = wifiManager;
        this.O0000OOo = context;
    }

    public static long O000000o() {
        return ((OO000OO.O00000o0() - O0000oO0) / 1000) + 1;
    }

    private static boolean O000000o(int i) {
        try {
            i = WifiManager.calculateSignalLevel(i, 20);
        } catch (ArithmeticException e) {
            O0o0000.O000000o(e, "Aps", "wifiSigFine");
            i = 20;
        }
        return i > 0;
    }

    public static boolean O000000o(WifiInfo wifiInfo) {
        return (wifiInfo == null || TextUtils.isEmpty(wifiInfo.getSSID()) || !OO000OO.O000000o(wifiInfo.getBSSID())) ? false : true;
    }

    public static String O0000Ooo() {
        return String.valueOf(OO000OO.O00000o0() - O00000oo);
    }

    private WifiInfo O0000o0() {
        try {
            if (this.O000000o != null) {
                return this.O000000o.getConnectionInfo();
            }
        } catch (Throwable th) {
            O0o0000.O000000o(th, "WifiManagerWrapper", "getConnectionInfo");
        }
        return null;
    }

    private List<ScanResult> O0000o00() {
        if (this.O000000o != null) {
            try {
                long O00000o0;
                List<ScanResult> scanResults = this.O000000o.getScanResults();
                if (VERSION.SDK_INT >= 17) {
                    HashMap hashMap = new HashMap(36);
                    for (ScanResult scanResult : scanResults) {
                        hashMap.put(scanResult.BSSID, Long.valueOf(scanResult.timestamp));
                    }
                    if (O0000o.isEmpty() || !O0000o.equals(hashMap)) {
                        O0000o = hashMap;
                        O00000o0 = OO000OO.O00000o0();
                    }
                    this.O0000o0 = null;
                    return scanResults;
                }
                O00000o0 = OO000OO.O00000o0();
                O0000oO0 = O00000o0;
                this.O0000o0 = null;
                return scanResults;
            } catch (SecurityException e) {
                this.O0000o0 = e.getMessage();
            } catch (Throwable th) {
                this.O0000o0 = null;
                O0o0000.O000000o(th, "WifiManagerWrapper", "getScanResults");
                return null;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0078 A:{Catch:{ Throwable -> 0x007f }} */
    /* JADX WARNING: Missing block: B:23:0x0058, code skipped:
            if (r4 < r6) goto L_0x0075;
     */
    private void O0000o0O() {
        /*
        r10 = this;
        r0 = r10.O0000o0o();
        if (r0 == 0) goto L_0x0087;
    L_0x0006:
        r0 = com.loc.OO000OO.O00000o0();	 Catch:{ Throwable -> 0x007f }
        r2 = O00000o0;	 Catch:{ Throwable -> 0x007f }
        r4 = r0 - r2;
        r0 = 4900; // 0x1324 float:6.866E-42 double:2.421E-320;
        r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r2 < 0) goto L_0x0075;
    L_0x0014:
        r0 = r10.O0000oOO;	 Catch:{ Throwable -> 0x007f }
        if (r0 != 0) goto L_0x0024;
    L_0x0018:
        r0 = r10.O0000OOo;	 Catch:{ Throwable -> 0x007f }
        r1 = "connectivity";
        r0 = com.loc.OO000OO.O000000o(r0, r1);	 Catch:{ Throwable -> 0x007f }
        r0 = (android.net.ConnectivityManager) r0;	 Catch:{ Throwable -> 0x007f }
        r10.O0000oOO = r0;	 Catch:{ Throwable -> 0x007f }
    L_0x0024:
        r0 = r10.O0000oOO;	 Catch:{ Throwable -> 0x007f }
        r0 = r10.O000000o(r0);	 Catch:{ Throwable -> 0x007f }
        if (r0 == 0) goto L_0x0032;
    L_0x002c:
        r0 = 9900; // 0x26ac float:1.3873E-41 double:4.8912E-320;
        r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r2 < 0) goto L_0x0075;
    L_0x0032:
        r0 = O0000oO;	 Catch:{ Throwable -> 0x007f }
        r1 = 1;
        if (r0 <= r1) goto L_0x005a;
    L_0x0037:
        r2 = r10.O0000oo;	 Catch:{ Throwable -> 0x007f }
        r6 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r0 == 0) goto L_0x0042;
    L_0x003f:
        r6 = r10.O0000oo;	 Catch:{ Throwable -> 0x007f }
        goto L_0x0050;
    L_0x0042:
        r2 = com.loc.OoO0o.O000OO00();	 Catch:{ Throwable -> 0x007f }
        r8 = -1;
        r0 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));
        if (r0 == 0) goto L_0x0050;
    L_0x004c:
        r6 = com.loc.OoO0o.O000OO00();	 Catch:{ Throwable -> 0x007f }
    L_0x0050:
        r0 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x007f }
        r2 = 28;
        if (r0 < r2) goto L_0x005a;
    L_0x0056:
        r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r0 < 0) goto L_0x0075;
    L_0x005a:
        r0 = r10.O000000o;	 Catch:{ Throwable -> 0x007f }
        if (r0 == 0) goto L_0x0075;
    L_0x005e:
        r2 = com.loc.OO000OO.O00000o0();	 Catch:{ Throwable -> 0x007f }
        O00000o0 = r2;	 Catch:{ Throwable -> 0x007f }
        r0 = O0000oO;	 Catch:{ Throwable -> 0x007f }
        r2 = 2;
        if (r0 >= r2) goto L_0x006e;
    L_0x0069:
        r0 = O0000oO;	 Catch:{ Throwable -> 0x007f }
        r0 = r0 + r1;
        O0000oO = r0;	 Catch:{ Throwable -> 0x007f }
    L_0x006e:
        r0 = r10.O000000o;	 Catch:{ Throwable -> 0x007f }
        r0 = r0.startScan();	 Catch:{ Throwable -> 0x007f }
        goto L_0x0076;
    L_0x0075:
        r0 = 0;
    L_0x0076:
        if (r0 == 0) goto L_0x007e;
    L_0x0078:
        r0 = com.loc.OO000OO.O00000o0();	 Catch:{ Throwable -> 0x007f }
        O00000oO = r0;	 Catch:{ Throwable -> 0x007f }
    L_0x007e:
        return;
    L_0x007f:
        r0 = move-exception;
        r1 = "WifiManager";
        r2 = "wifiScan";
        com.loc.O0o0000.O000000o(r0, r1, r2);
    L_0x0087:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O0OOO00.O0000o0O():void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:21:0x004d in {2, 3, 6, 9, 13, 16, 19, 20} preds:[]
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:242)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:42)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:32)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
        	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
        	at jadx.core.ProcessClass.process(ProcessClass.java:37)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
        */
    private boolean O0000o0o() {
        /*
        r11 = this;
        r0 = r11.O000000o;
        r1 = 0;
        if (r0 != 0) goto L_0x0007;
        r0 = r1;
        goto L_0x000d;
        r0 = r11.O0000OOo;
        r0 = com.loc.OO000OO.O0000O0o(r0);
        r11.O0000o0o = r0;
        r0 = r11.O0000o0o;
        r2 = 1;
        if (r0 != 0) goto L_0x0015;
        return r1;
        r0 = r11.O0000OoO;
        if (r0 != 0) goto L_0x001a;
        return r1;
        r3 = O00000oO;
        r5 = 0;
        r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r0 != 0) goto L_0x0024;
        r1 = r2;
        return r1;
        r3 = com.loc.OO000OO.O00000o0();
        r5 = O00000oO;
        r7 = r3 - r5;
        r3 = 4900; // 0x1324 float:6.866E-42 double:2.421E-320;
        r0 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1));
        if (r0 >= 0) goto L_0x0033;
        return r1;
        r5 = com.loc.OO000OO.O00000o0();
        r7 = O00000oo;
        r9 = r5 - r7;
        r5 = 1500; // 0x5dc float:2.102E-42 double:7.41E-321;
        r0 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1));
        if (r0 >= 0) goto L_0x0042;
        return r1;
        r0 = com.loc.OO000OO.O00000o0();
        r5 = O00000oo;
        r7 = r0 - r5;
        r0 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1));
        goto L_0x0022;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O0OOO00.O0000o0o():boolean");
    }

    public final void O000000o(boolean z) {
        Context context = this.O0000OOo;
        if (OoO0o.O000O0oo() && this.O0000o00 && this.O000000o != null && context != null && z && OO000OO.O00000o() > 17) {
            ContentResolver contentResolver = context.getContentResolver();
            String str = "android.provider.Settings$Global";
            try {
                if (((Integer) O0o.O000000o(str, "getInt", new Object[]{contentResolver, "wifi_scan_always_enabled"}, new Class[]{ContentResolver.class, String.class})).intValue() == 0) {
                    O0o.O000000o(str, "putInt", new Object[]{contentResolver, "wifi_scan_always_enabled", Integer.valueOf(1)}, new Class[]{ContentResolver.class, String.class, Integer.TYPE});
                }
            } catch (Throwable th) {
                O0o0000.O000000o(th, "WifiManagerWrapper", "enableWifiAlwaysScan");
            }
        }
    }

    public final void O000000o(boolean z, boolean z2, boolean z3, long j) {
        this.O0000OoO = z;
        this.O0000Ooo = z2;
        this.O0000o00 = z3;
        if (j < 10000) {
            this.O0000oo = 10000;
        } else {
            this.O0000oo = j;
        }
    }

    public final boolean O000000o(ConnectivityManager connectivityManager) {
        WifiManager wifiManager = this.O000000o;
        if (wifiManager == null) {
            return false;
        }
        try {
            if (OO000OO.O000000o(connectivityManager.getActiveNetworkInfo()) == 1 && O000000o(wifiManager.getConnectionInfo())) {
                return true;
            }
        } catch (Throwable th) {
            O0o0000.O000000o(th, "WifiManagerWrapper", "wifiAccess");
        }
        return false;
    }

    public final String O00000Oo() {
        return this.O0000o0;
    }

    public final void O00000Oo(boolean z) {
        int i;
        if (!z) {
            O0000o0O();
        } else if (O0000o0o()) {
            long O00000o0 = OO000OO.O00000o0();
            if (O00000o0 - O00000o >= 10000) {
                this.O00000Oo.clear();
                O0000O0o = O00000oo;
            }
            O0000o0O();
            if (O00000o0 - O00000o >= 10000) {
                for (i = 20; i > 0 && O00000oo == O0000O0o; i--) {
                    try {
                        Thread.sleep(150);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        int i2 = 0;
        if (this.O0000oOo) {
            this.O0000oOo = false;
            O00000o();
        }
        if (O0000O0o != O00000oo) {
            Collection collection = null;
            try {
                collection = O0000o00();
            } catch (Throwable th) {
                O0o0000.O000000o(th, "WifiManager", "updateScanResult");
            }
            O0000O0o = O00000oo;
            if (collection != null) {
                this.O00000Oo.clear();
                this.O00000Oo.addAll(collection);
            } else {
                this.O00000Oo.clear();
            }
        }
        if (OO000OO.O00000o0() - O00000oo > 20000) {
            this.O00000Oo.clear();
        }
        O00000o = OO000OO.O00000o0();
        if (this.O00000Oo.isEmpty()) {
            O00000oo = OO000OO.O00000o0();
            List O0000o00 = O0000o00();
            if (O0000o00 != null) {
                this.O00000Oo.addAll(O0000o00);
            }
        }
        if (this.O00000Oo != null && !this.O00000Oo.isEmpty()) {
            if (OO000OO.O00000o0() - O00000oo > 3600000) {
                O00000o();
            }
            if (this.O0000o0O == null) {
                this.O0000o0O = new TreeMap(Collections.reverseOrder());
            }
            this.O0000o0O.clear();
            i = this.O00000Oo.size();
            while (i2 < i) {
                ScanResult scanResult = (ScanResult) this.O00000Oo.get(i2);
                if (OO000OO.O000000o(scanResult != null ? scanResult.BSSID : "") && (i <= 20 || O000000o(scanResult.level))) {
                    String str;
                    if (TextUtils.isEmpty(scanResult.SSID)) {
                        str = "unkwn";
                    } else {
                        if (!"<unknown ssid>".equals(scanResult.SSID)) {
                            str = String.valueOf(i2);
                        }
                        this.O0000o0O.put(Integer.valueOf((scanResult.level * 25) + i2), scanResult);
                    }
                    scanResult.SSID = str;
                    this.O0000o0O.put(Integer.valueOf((scanResult.level * 25) + i2), scanResult);
                }
                i2++;
            }
            this.O00000Oo.clear();
            for (ScanResult add : this.O0000o0O.values()) {
                this.O00000Oo.add(add);
            }
            this.O0000o0O.clear();
        }
    }

    public final void O00000o() {
        this.O0000oo0 = null;
        this.O00000Oo.clear();
    }

    public final ArrayList<ScanResult> O00000o0() {
        if (this.O00000Oo == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!this.O00000Oo.isEmpty()) {
            arrayList.addAll(this.O00000Oo);
        }
        return arrayList;
    }

    public final void O00000oO() {
        if (this.O000000o != null && OO000OO.O00000o0() - O00000oo > 4900) {
            O00000oo = OO000OO.O00000o0();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x001e  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0027  */
    public final void O00000oo() {
        /*
        r4 = this;
        r0 = r4.O000000o;
        if (r0 != 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = 4;
        r1 = r4.O000000o;	 Catch:{ Throwable -> 0x0011 }
        if (r1 == 0) goto L_0x0019;
    L_0x000a:
        r1 = r4.O000000o;	 Catch:{ Throwable -> 0x0011 }
        r1 = r1.getWifiState();	 Catch:{ Throwable -> 0x0011 }
        goto L_0x001a;
    L_0x0011:
        r1 = move-exception;
        r2 = "Aps";
        r3 = "onReceive part";
        com.loc.O0o0000.O000000o(r1, r2, r3);
    L_0x0019:
        r1 = r0;
    L_0x001a:
        r2 = r4.O00000Oo;
        if (r2 != 0) goto L_0x0025;
    L_0x001e:
        r2 = new java.util.ArrayList;
        r2.<init>();
        r4.O00000Oo = r2;
    L_0x0025:
        if (r1 == r0) goto L_0x002b;
    L_0x0027:
        switch(r1) {
            case 0: goto L_0x002b;
            case 1: goto L_0x002b;
            default: goto L_0x002a;
        };
    L_0x002a:
        return;
    L_0x002b:
        r0 = 1;
        r4.O0000oOo = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O0OOO00.O00000oo():void");
    }

    public final boolean O0000O0o() {
        return this.O0000o0o;
    }

    public final WifiInfo O0000OOo() {
        this.O0000oo0 = O0000o0();
        return this.O0000oo0;
    }

    public final String O0000Oo() {
        if (this.O0000Oo == null) {
            this.O0000Oo = new StringBuilder(SecExceptionCode.SEC_ERROR_STA_KEY_ENC);
        } else {
            this.O0000Oo.delete(0, this.O0000Oo.length());
        }
        this.O0000Oo0 = false;
        String str = "";
        this.O0000oo0 = O0000OOo();
        if (O000000o(this.O0000oo0)) {
            str = this.O0000oo0.getBSSID();
        }
        int size = this.O00000Oo.size();
        int i = 0;
        int i2 = i;
        int i3 = i2;
        while (i < size) {
            String str2 = ((ScanResult) this.O00000Oo.get(i)).BSSID;
            if (!this.O0000Ooo) {
                if (!"<unknown ssid>".equals(((ScanResult) this.O00000Oo.get(i)).SSID)) {
                    i2 = 1;
                }
            }
            String str3 = "nb";
            if (str.equals(str2)) {
                str3 = "access";
                i3 = 1;
            }
            this.O0000Oo.append(String.format(Locale.US, "#%s,%s", new Object[]{str2, str3}));
            i++;
        }
        if (this.O00000Oo.size() == 0) {
            i2 = 1;
        }
        if (!this.O0000Ooo && r4 == 0) {
            this.O0000Oo0 = true;
        }
        if (i3 == 0 && !TextUtils.isEmpty(str)) {
            StringBuilder stringBuilder = this.O0000Oo;
            stringBuilder.append("#");
            stringBuilder.append(str);
            this.O0000Oo.append(",access");
        }
        return this.O0000Oo.toString();
    }

    public final boolean O0000Oo0() {
        return this.O0000Oo0;
    }

    public final void O0000OoO() {
        O00000o();
        this.O00000Oo.clear();
    }
}
