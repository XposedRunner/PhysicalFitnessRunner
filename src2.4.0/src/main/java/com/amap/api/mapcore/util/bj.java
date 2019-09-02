package com.amap.api.mapcore.util;

import android.content.ContentResolver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

/* compiled from: WifiManagerWrapper */
public final class bj {
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

    public bj(Context context, WifiManager wifiManager) {
        this.O000000o = wifiManager;
        this.O0000OOo = context;
    }

    private static boolean O000000o(int i) {
        try {
            i = WifiManager.calculateSignalLevel(i, 20);
        } catch (ArithmeticException e) {
            bp.O000000o(e, "Aps", "wifiSigFine");
            i = 20;
        }
        return i > 0;
    }

    public static boolean O000000o(WifiInfo wifiInfo) {
        return (wifiInfo == null || TextUtils.isEmpty(wifiInfo.getSSID()) || !bt.O000000o(wifiInfo.getBSSID())) ? false : true;
    }

    private void O00000o(boolean z) {
        this.O0000OoO = z;
        this.O0000Ooo = true;
        this.O0000o00 = true;
        this.O0000oo = StatisticConfig.MIN_UPLOAD_INTERVAL;
    }

    private List<ScanResult> O0000Oo() {
        if (this.O000000o != null) {
            try {
                long O00000Oo;
                List<ScanResult> scanResults = this.O000000o.getScanResults();
                if (VERSION.SDK_INT >= 17) {
                    HashMap hashMap = new HashMap(36);
                    for (ScanResult scanResult : scanResults) {
                        hashMap.put(scanResult.BSSID, Long.valueOf(scanResult.timestamp));
                    }
                    if (O0000o.isEmpty() || !O0000o.equals(hashMap)) {
                        O0000o = hashMap;
                        O00000Oo = bt.O00000Oo();
                    }
                    this.O0000o0 = null;
                    return scanResults;
                }
                O00000Oo = bt.O00000Oo();
                O0000oO0 = O00000Oo;
                this.O0000o0 = null;
                return scanResults;
            } catch (SecurityException e) {
                this.O0000o0 = e.getMessage();
            } catch (Throwable th) {
                this.O0000o0 = null;
                bp.O000000o(th, "WifiManagerWrapper", "getScanResults");
                return null;
            }
        }
        return null;
    }

    public static String O0000Oo0() {
        return String.valueOf(bt.O00000Oo() - O00000oo);
    }

    private WifiInfo O0000OoO() {
        try {
            if (this.O000000o != null) {
                return this.O000000o.getConnectionInfo();
            }
        } catch (Throwable th) {
            bp.O000000o(th, "WifiManagerWrapper", "getConnectionInfo");
        }
        return null;
    }

    private int O0000Ooo() {
        return this.O000000o != null ? this.O000000o.getWifiState() : 4;
    }

    private void O0000o() {
        if (O0000oOO()) {
            long O00000Oo = bt.O00000Oo();
            if (O00000Oo - O00000o >= 10000) {
                this.O00000Oo.clear();
                O0000O0o = O00000oo;
            }
            O0000oO0();
            if (O00000Oo - O00000o >= 10000) {
                for (int i = 20; i > 0 && O00000oo == O0000O0o; i--) {
                    try {
                        Thread.sleep(150);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    private boolean O0000o0() {
        if (this.O0000oOO == null) {
            this.O0000oOO = (ConnectivityManager) bt.O000000o(this.O0000OOo, "connectivity");
        }
        return O000000o(this.O0000oOO);
    }

    private boolean O0000o00() {
        long O00000Oo = bt.O00000Oo() - O00000o0;
        boolean z = false;
        if (O00000Oo < 4900) {
            return false;
        }
        if (O0000o0() && O00000Oo < 9900) {
            return false;
        }
        if (O0000oO > 1) {
            long j = this.O0000oo;
            long j2 = StatisticConfig.MIN_UPLOAD_INTERVAL;
            if (j != StatisticConfig.MIN_UPLOAD_INTERVAL) {
                j2 = this.O0000oo;
            } else if (bo.O00000Oo() != -1) {
                j2 = bo.O00000Oo();
            }
            if (VERSION.SDK_INT >= 28 && O00000Oo < j2) {
                return false;
            }
        }
        if (this.O000000o != null) {
            O00000o0 = bt.O00000Oo();
            if (O0000oO < 2) {
                O0000oO++;
            }
            z = this.O000000o.startScan();
        }
        return z;
    }

    private boolean O0000o0O() {
        return this.O000000o == null ? false : bt.O00000o0(this.O0000OOo);
    }

    private void O0000o0o() {
        if (this.O00000Oo != null && !this.O00000Oo.isEmpty()) {
            if (bt.O00000Oo() - O00000oo > 3600000) {
                O00000Oo();
            }
            if (this.O0000o0O == null) {
                this.O0000o0O = new TreeMap(Collections.reverseOrder());
            }
            this.O0000o0O.clear();
            int size = this.O00000Oo.size();
            for (int i = 0; i < size; i++) {
                ScanResult scanResult = (ScanResult) this.O00000Oo.get(i);
                if (bt.O000000o(scanResult != null ? scanResult.BSSID : "") && (size <= 20 || O000000o(scanResult.level))) {
                    String str;
                    if (TextUtils.isEmpty(scanResult.SSID)) {
                        str = "unkwn";
                    } else {
                        if (!"<unknown ssid>".equals(scanResult.SSID)) {
                            str = String.valueOf(i);
                        }
                        this.O0000o0O.put(Integer.valueOf((scanResult.level * 25) + i), scanResult);
                    }
                    scanResult.SSID = str;
                    this.O0000o0O.put(Integer.valueOf((scanResult.level * 25) + i), scanResult);
                }
            }
            this.O00000Oo.clear();
            for (ScanResult add : this.O0000o0O.values()) {
                this.O00000Oo.add(add);
            }
            this.O0000o0O.clear();
        }
    }

    private void O0000oO() {
        if (O0000O0o != O00000oo) {
            Collection collection = null;
            try {
                collection = O0000Oo();
            } catch (Throwable th) {
                bp.O000000o(th, "WifiManager", "updateScanResult");
            }
            O0000O0o = O00000oo;
            if (collection != null) {
                this.O00000Oo.clear();
                this.O00000Oo.addAll(collection);
                return;
            }
            this.O00000Oo.clear();
        }
    }

    private void O0000oO0() {
        if (O0000oOO()) {
            try {
                if (O0000o00()) {
                    O00000oO = bt.O00000Oo();
                }
            } catch (Throwable th) {
                bp.O000000o(th, "WifiManager", "wifiScan");
            }
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:17:0x0045 in {2, 5, 9, 12, 15, 16} preds:[]
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
    private boolean O0000oOO() {
        /*
        r11 = this;
        r0 = r11.O0000o0O();
        r11.O0000o0o = r0;
        r0 = r11.O0000o0o;
        r1 = 1;
        r2 = 0;
        if (r0 != 0) goto L_0x000d;
        return r2;
        r0 = r11.O0000OoO;
        if (r0 != 0) goto L_0x0012;
        return r2;
        r3 = O00000oO;
        r5 = 0;
        r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r0 != 0) goto L_0x001c;
        r2 = r1;
        return r2;
        r3 = com.amap.api.mapcore.util.bt.O00000Oo();
        r5 = O00000oO;
        r7 = r3 - r5;
        r3 = 4900; // 0x1324 float:6.866E-42 double:2.421E-320;
        r0 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1));
        if (r0 >= 0) goto L_0x002b;
        return r2;
        r5 = com.amap.api.mapcore.util.bt.O00000Oo();
        r7 = O00000oo;
        r9 = r5 - r7;
        r5 = 1500; // 0x5dc float:2.102E-42 double:7.41E-321;
        r0 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1));
        if (r0 >= 0) goto L_0x003a;
        return r2;
        r5 = com.amap.api.mapcore.util.bt.O00000Oo();
        r7 = O00000oo;
        r9 = r5 - r7;
        r0 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1));
        goto L_0x001a;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.bj.O0000oOO():boolean");
    }

    public final ArrayList<ScanResult> O000000o() {
        if (this.O00000Oo == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!this.O00000Oo.isEmpty()) {
            arrayList.addAll(this.O00000Oo);
        }
        return arrayList;
    }

    public final void O000000o(boolean z) {
        Context context = this.O0000OOo;
        if (bo.O000000o() && this.O0000o00 && this.O000000o != null && context != null && z && bt.O00000o0() > 17) {
            ContentResolver contentResolver = context.getContentResolver();
            String str = "android.provider.Settings$Global";
            try {
                if (((Integer) br.O000000o(str, "getInt", new Object[]{contentResolver, "wifi_scan_always_enabled"}, new Class[]{ContentResolver.class, String.class})).intValue() == 0) {
                    br.O000000o(str, "putInt", new Object[]{contentResolver, "wifi_scan_always_enabled", Integer.valueOf(1)}, new Class[]{ContentResolver.class, String.class, Integer.TYPE});
                }
            } catch (Throwable th) {
                bp.O000000o(th, "WifiManagerWrapper", "enableWifiAlwaysScan");
            }
        }
    }

    public final boolean O000000o(ConnectivityManager connectivityManager) {
        WifiManager wifiManager = this.O000000o;
        if (wifiManager == null) {
            return false;
        }
        try {
            if (bt.O000000o(connectivityManager.getActiveNetworkInfo()) == 1 && O000000o(wifiManager.getConnectionInfo())) {
                return true;
            }
        } catch (Throwable th) {
            bp.O000000o(th, "WifiManagerWrapper", "wifiAccess");
        }
        return false;
    }

    public final void O00000Oo() {
        this.O0000oo0 = null;
        this.O00000Oo.clear();
    }

    public final void O00000Oo(boolean z) {
        if (z) {
            O0000o();
        } else {
            O0000oO0();
        }
        if (this.O0000oOo) {
            this.O0000oOo = false;
            O00000Oo();
        }
        O0000oO();
        if (bt.O00000Oo() - O00000oo > 20000) {
            this.O00000Oo.clear();
        }
        O00000o = bt.O00000Oo();
        if (this.O00000Oo.isEmpty()) {
            O00000oo = bt.O00000Oo();
            List O0000Oo = O0000Oo();
            if (O0000Oo != null) {
                this.O00000Oo.addAll(O0000Oo);
            }
        }
        O0000o0o();
    }

    public final void O00000o() {
        if (this.O000000o != null) {
            int O0000Ooo;
            try {
                O0000Ooo = O0000Ooo();
            } catch (Throwable th) {
                bp.O000000o(th, "Aps", "onReceive part");
                O0000Ooo = 4;
            }
            if (this.O00000Oo == null) {
                this.O00000Oo = new ArrayList();
            }
            if (O0000Ooo != 4) {
                switch (O0000Ooo) {
                    case 0:
                    case 1:
                        break;
                    default:
                        return;
                }
            }
            this.O0000oOo = true;
        }
    }

    public final void O00000o0() {
        if (this.O000000o != null && bt.O00000Oo() - O00000oo > 4900) {
            O00000oo = bt.O00000Oo();
        }
    }

    public final void O00000o0(boolean z) {
        O00000o(z);
    }

    public final boolean O00000oO() {
        return this.O0000o0o;
    }

    public final WifiInfo O00000oo() {
        this.O0000oo0 = O0000OoO();
        return this.O0000oo0;
    }

    public final boolean O0000O0o() {
        return this.O0000Oo0;
    }

    public final void O0000OOo() {
        O00000Oo();
        this.O00000Oo.clear();
    }
}
