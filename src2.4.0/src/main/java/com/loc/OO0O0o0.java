package com.loc;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.TrafficStats;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: DeviceInfo */
public final class OO0O0o0 {
    static String O000000o = "";
    static String O00000Oo = "";
    static String O00000o = "";
    public static boolean O00000o0 = false;
    static boolean O00000oO = false;
    static int O00000oo = -1;
    static String O0000O0o = "";
    static String O0000OOo = "";
    private static boolean O0000Oo = false;
    private static String O0000Oo0 = null;
    private static String O0000OoO = "";
    private static String O0000Ooo = "";
    private static boolean O0000o = false;
    private static String O0000o0 = "";
    private static String O0000o00 = "";
    private static String O0000o0O = "";
    private static String O0000o0o = "";
    private static int O0000oO = 0;
    private static long O0000oO0 = 0;
    private static String O0000oOO = null;
    private static String O0000oOo = "";

    public static String O000000o() {
        return O0000Oo0;
    }

    public static String O000000o(Context context) {
        try {
            if (!TextUtils.isEmpty(O00000o)) {
                return O00000o;
            }
            OO0Oo0 O000000o = O0000OOo.O000000o();
            if (O000OOo.O00000Oo(context, O000000o)) {
                Class O000000o2 = O000OOo.O000000o(context, O000000o, OO0o000.O00000o0("WY29tLmFtYXAuYXBpLmFpdW5ldC5OZXRSZXVlc3RQYXJhbQ"));
                if (O000000o2 != null) {
                    O00000o = (String) O000000o2.getMethod("getAdiuExtras", new Class[0]).invoke(O000000o2, new Object[0]);
                }
                return O00000o;
            }
            return "";
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x0072 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing block: B:29:?, code skipped:
            r7 = r1.toString();
     */
    /* JADX WARNING: Missing block: B:30:0x007a, code skipped:
            if (r7.length() == 0) goto L_0x007c;
     */
    /* JADX WARNING: Missing block: B:31:0x007c, code skipped:
            O00000oo = 0;
     */
    /* JADX WARNING: Missing block: B:32:0x0080, code skipped:
            return "";
     */
    /* JADX WARNING: Missing block: B:33:0x0081, code skipped:
            r7 = r7.substring(0, r7.length() - 1);
            O0000O0o = r7;
     */
    /* JADX WARNING: Missing block: B:34:0x008c, code skipped:
            return r7;
     */
    public static java.lang.String O000000o(android.content.Context r7, java.lang.String r8) {
        /*
        r0 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x008d }
        r1 = 21;
        if (r0 >= r1) goto L_0x0009;
    L_0x0006:
        r7 = "";
        return r7;
    L_0x0009:
        r0 = O0000O0o;	 Catch:{ Throwable -> 0x008d }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Throwable -> 0x008d }
        if (r0 != 0) goto L_0x0014;
    L_0x0011:
        r7 = O0000O0o;	 Catch:{ Throwable -> 0x008d }
        return r7;
    L_0x0014:
        r7 = O000O0o(r7);	 Catch:{ Throwable -> 0x008d }
        r0 = O00000oo;	 Catch:{ Throwable -> 0x008d }
        r1 = -1;
        r2 = 0;
        if (r0 != r1) goto L_0x003b;
    L_0x001e:
        r0 = android.telephony.TelephonyManager.class;
        r1 = "UZ2V0UGhvbmVDb3VudA=";
        r3 = new java.lang.Class[r2];	 Catch:{ Throwable -> 0x008d }
        r0 = com.loc.OO0o000.O000000o(r0, r1, r3);	 Catch:{ Throwable -> 0x008d }
        if (r0 == 0) goto L_0x0039;
    L_0x002a:
        r1 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x0039 }
        r0 = r0.invoke(r7, r1);	 Catch:{ Throwable -> 0x0039 }
        r0 = (java.lang.Integer) r0;	 Catch:{ Throwable -> 0x0039 }
        r0 = r0.intValue();	 Catch:{ Throwable -> 0x0039 }
        O00000oo = r0;	 Catch:{ Throwable -> 0x0039 }
        goto L_0x003b;
    L_0x0039:
        O00000oo = r2;	 Catch:{ Throwable -> 0x008d }
    L_0x003b:
        r0 = android.telephony.TelephonyManager.class;
        r1 = "MZ2V0SW1laQ=";
        r3 = 1;
        r4 = new java.lang.Class[r3];	 Catch:{ Throwable -> 0x008d }
        r5 = java.lang.Integer.TYPE;	 Catch:{ Throwable -> 0x008d }
        r4[r2] = r5;	 Catch:{ Throwable -> 0x008d }
        r0 = com.loc.OO0o000.O000000o(r0, r1, r4);	 Catch:{ Throwable -> 0x008d }
        if (r0 != 0) goto L_0x0051;
    L_0x004c:
        O00000oo = r2;	 Catch:{ Throwable -> 0x008d }
        r7 = "";
        return r7;
    L_0x0051:
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x008d }
        r1.<init>();	 Catch:{ Throwable -> 0x008d }
        r4 = r2;
    L_0x0057:
        r5 = O00000oo;	 Catch:{ Throwable -> 0x0072 }
        if (r4 >= r5) goto L_0x0072;
    L_0x005b:
        r5 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x0072 }
        r6 = java.lang.Integer.valueOf(r4);	 Catch:{ Throwable -> 0x0072 }
        r5[r2] = r6;	 Catch:{ Throwable -> 0x0072 }
        r5 = r0.invoke(r7, r5);	 Catch:{ Throwable -> 0x0072 }
        r5 = (java.lang.String) r5;	 Catch:{ Throwable -> 0x0072 }
        r1.append(r5);	 Catch:{ Throwable -> 0x0072 }
        r1.append(r8);	 Catch:{ Throwable -> 0x0072 }
        r4 = r4 + 1;
        goto L_0x0057;
    L_0x0072:
        r7 = r1.toString();	 Catch:{ Throwable -> 0x008d }
        r8 = r7.length();	 Catch:{ Throwable -> 0x008d }
        if (r8 != 0) goto L_0x0081;
    L_0x007c:
        O00000oo = r2;	 Catch:{ Throwable -> 0x008d }
        r7 = "";
        return r7;
    L_0x0081:
        r8 = r7.length();	 Catch:{ Throwable -> 0x008d }
        r8 = r8 - r3;
        r7 = r7.substring(r2, r8);	 Catch:{ Throwable -> 0x008d }
        O0000O0o = r7;	 Catch:{ Throwable -> 0x008d }
        return r7;
    L_0x008d:
        r7 = "";
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.OO0O0o0.O000000o(android.content.Context, java.lang.String):java.lang.String");
    }

    private static List<ScanResult> O000000o(List<ScanResult> list) {
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            for (int i2 = 1; i2 < size - i; i2++) {
                int i3 = i2 - 1;
                if (((ScanResult) list.get(i3)).level > ((ScanResult) list.get(i2)).level) {
                    ScanResult scanResult = (ScanResult) list.get(i3);
                    list.set(i3, list.get(i2));
                    list.set(i2, scanResult);
                }
            }
        }
        return list;
    }

    public static void O000000o(String str) {
        O0000Oo0 = str;
    }

    public static String O00000Oo(final Context context) {
        try {
            if (!TextUtils.isEmpty(O00000Oo)) {
                return O00000Oo;
            }
            OO0Oo0 O000000o = O0000OOo.O000000o();
            if (O000000o == null) {
                return null;
            }
            if (O000OOo.O00000Oo(context, O000000o)) {
                final Class O000000o2 = O000OOo.O000000o(context, O000000o, OO0o000.O00000o0("WY29tLmFtYXAuYXBpLmFpdW5ldC5OZXRSZXVlc3RQYXJhbQ"));
                if (O000000o2 == null) {
                    return O00000Oo;
                }
                String str = (String) O000000o2.getMethod("getADIU", new Class[]{Context.class}).invoke(O000000o2, new Object[]{context});
                if (!TextUtils.isEmpty(str)) {
                    O00000Oo = str;
                    return str;
                } else if (!O0000Oo) {
                    O0000Oo = true;
                    O0000o.O00000o().submit(new Runnable() {
                        public final void run() {
                            try {
                                Map map = (Map) O000000o2.getMethod("getGetParams", new Class[0]).invoke(O000000o2, new Object[0]);
                                if (map != null) {
                                    String str = (String) O000000o2.getMethod("getPostParam", new Class[]{String.class, String.class, String.class, String.class}).invoke(O000000o2, new Object[]{OO0O0o0.O0000OOo(context), OO0O0o0.O0000oo0(context), OO0O0o0.O0000o00(context), OO0O0o0.O0000ooO(context)});
                                    if (!TextUtils.isEmpty(str)) {
                                        O00O0o.O000000o();
                                        byte[] O000000o = O00O0o.O000000o(new O00O0o0(str.getBytes(), map));
                                        O000000o2.getMethod("parseResult", new Class[]{Context.class, String.class}).invoke(O000000o2, new Object[]{context, new String(O000000o)});
                                    }
                                }
                            } catch (Throwable unused) {
                            }
                        }
                    });
                }
            }
            return "";
        } catch (Throwable unused) {
        }
    }

    public static void O00000Oo() {
        try {
            if (VERSION.SDK_INT > 14) {
                TrafficStats.class.getDeclaredMethod("setThreadStatsTag", new Class[]{Integer.TYPE}).invoke(null, new Object[]{Integer.valueOf(40964)});
            }
        } catch (Throwable unused) {
        }
    }

    private static boolean O00000Oo(Context context, String str) {
        return context != null && context.checkCallingOrSelfPermission(str) == 0;
    }

    public static String O00000o() {
        if (!TextUtils.isEmpty(O0000oOO)) {
            return O0000oOO;
        }
        String property = System.getProperty("os.arch");
        O0000oOO = property;
        return property;
    }

    public static String O00000o(Context context) {
        String str = "";
        try {
            String str2 = "";
            String O0000ooO = O0000ooO(context);
            return (O0000ooO == null || O0000ooO.length() < 5) ? str2 : O0000ooO.substring(3, 5);
        } catch (Throwable th) {
            th.printStackTrace();
            return str;
        }
    }

    public static long O00000o0() {
        if (O0000oO0 != 0) {
            return O0000oO0;
        }
        try {
            long blockCountLong;
            long blockCountLong2;
            StatFs statFs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
            StatFs statFs2 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
            if (VERSION.SDK_INT >= 18) {
                blockCountLong = (statFs.getBlockCountLong() * statFs.getBlockSizeLong()) / 1048576;
                blockCountLong2 = (statFs2.getBlockCountLong() * statFs2.getBlockSizeLong()) / 1048576;
            } else {
                blockCountLong = (((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 1048576;
                blockCountLong2 = (((long) statFs2.getBlockCount()) * ((long) statFs2.getBlockSize())) / 1048576;
            }
            O0000oO0 = blockCountLong + blockCountLong2;
        } catch (Throwable unused) {
        }
        return O0000oO0;
    }

    public static String O00000o0(Context context) {
        try {
            return O000O0OO(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static int O00000oO(Context context) {
        try {
            return O000O0o0(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    private static String O00000oO() {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] bArr = null;
                    if (VERSION.SDK_INT >= 9) {
                        bArr = networkInterface.getHardwareAddress();
                    }
                    if (bArr == null) {
                        return "";
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    for (byte b : bArr) {
                        String toUpperCase = Integer.toHexString(b & 255).toUpperCase();
                        if (toUpperCase.length() == 1) {
                            stringBuilder.append("0");
                        }
                        stringBuilder.append(toUpperCase);
                        stringBuilder.append(":");
                    }
                    if (stringBuilder.length() > 0) {
                        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                    }
                    return stringBuilder.toString();
                }
            }
        } catch (Exception unused) {
        }
        return "";
    }

    public static int O00000oo(Context context) {
        try {
            return O000O0Oo(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public static String O0000O0o(Context context) {
        try {
            return O000O00o(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0044  */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x003a */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:7|(1:9)|10|(2:14|15)|16|17|18|(2:21|22)(2:23|24)) */
    public static java.lang.String O0000OOo(android.content.Context r2) {
        /*
        r0 = O000000o;	 Catch:{ Throwable -> 0x003a }
        if (r0 == 0) goto L_0x0011;
    L_0x0004:
        r0 = "";
        r1 = O000000o;	 Catch:{ Throwable -> 0x003a }
        r0 = r0.equals(r1);	 Catch:{ Throwable -> 0x003a }
        if (r0 != 0) goto L_0x0011;
    L_0x000e:
        r0 = O000000o;	 Catch:{ Throwable -> 0x003a }
        return r0;
    L_0x0011:
        r0 = "WYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFVFRJTkdT";
        r0 = com.loc.OO0o000.O00000o0(r0);	 Catch:{ Throwable -> 0x003a }
        r0 = O00000Oo(r2, r0);	 Catch:{ Throwable -> 0x003a }
        if (r0 == 0) goto L_0x0029;
    L_0x001d:
        r0 = r2.getContentResolver();	 Catch:{ Throwable -> 0x003a }
        r1 = "mqBRboGZkQPcAkyk";
        r0 = android.provider.Settings.System.getString(r0, r1);	 Catch:{ Throwable -> 0x003a }
        O000000o = r0;	 Catch:{ Throwable -> 0x003a }
    L_0x0029:
        r0 = O000000o;	 Catch:{ Throwable -> 0x003a }
        if (r0 == 0) goto L_0x003a;
    L_0x002d:
        r0 = "";
        r1 = O000000o;	 Catch:{ Throwable -> 0x003a }
        r0 = r0.equals(r1);	 Catch:{ Throwable -> 0x003a }
        if (r0 != 0) goto L_0x003a;
    L_0x0037:
        r0 = O000000o;	 Catch:{ Throwable -> 0x003a }
        return r0;
    L_0x003a:
        r2 = O00oOooo(r2);	 Catch:{ Throwable -> 0x0040 }
        O000000o = r2;	 Catch:{ Throwable -> 0x0040 }
    L_0x0040:
        r2 = O000000o;
        if (r2 != 0) goto L_0x0047;
    L_0x0044:
        r2 = "";
        return r2;
    L_0x0047:
        r2 = O000000o;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.OO0O0o0.O0000OOo(android.content.Context):java.lang.String");
    }

    public static String O0000Oo(Context context) {
        if (!TextUtils.isEmpty(O0000OoO)) {
            return O0000OoO;
        }
        try {
            String string = Secure.getString(context.getContentResolver(), OO0o000.O00000o0(new String(O0000OOo.O000000o(13))));
            O0000OoO = string;
            return string == null ? "" : O0000OoO;
        } catch (Throwable unused) {
            return O0000OoO;
        }
    }

    public static String O0000Oo0(Context context) {
        if (!TextUtils.isEmpty(O0000Ooo)) {
            return O0000Ooo;
        }
        if (!O00000Oo(context, OO0o000.O00000o0("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            return "";
        }
        try {
            if (VERSION.SDK_INT >= 26) {
                return (String) OO0o000.O000000o(Build.class, "MZ2V0U2VyaWFs", new Class[0]).invoke(Build.class, new Object[0]);
            }
            if (VERSION.SDK_INT >= 9) {
                O0000Ooo = Build.SERIAL;
            }
            return O0000Ooo == null ? "" : O0000Ooo;
        } catch (Throwable unused) {
        }
    }

    static String O0000OoO(Context context) {
        String str = "";
        if (context != null) {
            try {
                if (!O00000Oo(context, OO0o000.O00000o0("WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF"))) {
                    return str;
                }
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                if (wifiManager == null) {
                    return str;
                }
                if (wifiManager.isWifiEnabled()) {
                    str = wifiManager.getConnectionInfo().getBSSID();
                }
            } catch (Throwable unused) {
            }
        }
        return str;
    }

    static String O0000Ooo(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        if (context != null) {
            try {
                if (O00000Oo(context, OO0o000.O00000o0("WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF"))) {
                    WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                    if (wifiManager == null) {
                        return "";
                    }
                    if (wifiManager.isWifiEnabled()) {
                        List scanResults = wifiManager.getScanResults();
                        if (scanResults != null) {
                            if (scanResults.size() != 0) {
                                scanResults = O000000o(scanResults);
                                Object obj = 1;
                                int i = 0;
                                while (i < scanResults.size() && i < 7) {
                                    ScanResult scanResult = (ScanResult) scanResults.get(i);
                                    if (obj != null) {
                                        obj = null;
                                    } else {
                                        stringBuilder.append(";");
                                    }
                                    stringBuilder.append(scanResult.BSSID);
                                    i++;
                                }
                            }
                        }
                        return stringBuilder.toString();
                    }
                    return stringBuilder.toString();
                }
            } catch (Throwable unused) {
            }
        }
        return stringBuilder.toString();
    }

    public static int O0000o(Context context) {
        try {
            return O000O0o0(context);
        } catch (Throwable unused) {
            return -1;
        }
    }

    static String[] O0000o0(Context context) {
        try {
            if (O00000Oo(context, OO0o000.O00000o0("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
                if (O00000Oo(context, OO0o000.O00000o0("EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04="))) {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager == null) {
                        return new String[]{"", ""};
                    }
                    CellLocation cellLocation = telephonyManager.getCellLocation();
                    int cid;
                    int lac;
                    if (cellLocation instanceof GsmCellLocation) {
                        GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                        cid = gsmCellLocation.getCid();
                        lac = gsmCellLocation.getLac();
                        String[] strArr = new String[2];
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(lac);
                        stringBuilder.append("||");
                        stringBuilder.append(cid);
                        strArr[0] = stringBuilder.toString();
                        strArr[1] = "gsm";
                        return strArr;
                    }
                    if (cellLocation instanceof CdmaCellLocation) {
                        CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                        cid = cdmaCellLocation.getSystemId();
                        int networkId = cdmaCellLocation.getNetworkId();
                        lac = cdmaCellLocation.getBaseStationId();
                        String[] strArr2 = new String[2];
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(cid);
                        stringBuilder2.append("||");
                        stringBuilder2.append(networkId);
                        stringBuilder2.append("||");
                        stringBuilder2.append(lac);
                        strArr2[0] = stringBuilder2.toString();
                        strArr2[1] = "cdma";
                        return strArr2;
                    }
                    return new String[]{"", ""};
                }
            }
            return new String[]{"", ""};
        } catch (Throwable unused) {
        }
    }

    public static String O0000o00(Context context) {
        try {
            if (O0000o00 != null && !"".equals(O0000o00)) {
                return O0000o00;
            }
            if (!O00000Oo(context, OO0o000.O00000o0("WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF"))) {
                return O0000o00;
            }
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager == null) {
                return "";
            }
            O0000o00 = wifiManager.getConnectionInfo().getMacAddress();
            if (OO0o000.O00000o0("YMDI6MDA6MDA6MDA6MDA6MDA").equals(O0000o00) || OO0o000.O00000o0("YMDA6MDA6MDA6MDA6MDA6MDA").equals(O0000o00)) {
                O0000o00 = O00000oO();
            }
            return O0000o00;
        } catch (Throwable unused) {
        }
    }

    static String O0000o0O(Context context) {
        String str = "";
        try {
            if (!O00000Oo(context, OO0o000.O00000o0("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
                return str;
            }
            TelephonyManager O000O0o = O000O0o(context);
            if (O000O0o == null) {
                return "";
            }
            String networkOperator = O000O0o.getNetworkOperator();
            return (TextUtils.isEmpty(networkOperator) || networkOperator.length() < 3) ? str : networkOperator.substring(0, 3);
        } catch (Throwable unused) {
            return str;
        }
    }

    static String O0000o0o(Context context) {
        String str = "";
        try {
            if (!O00000Oo(context, OO0o000.O00000o0("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
                return str;
            }
            TelephonyManager O000O0o = O000O0o(context);
            if (O000O0o == null) {
                return "";
            }
            String networkOperator = O000O0o.getNetworkOperator();
            return (TextUtils.isEmpty(networkOperator) || networkOperator.length() < 3) ? str : networkOperator.substring(3);
        } catch (Throwable unused) {
            return str;
        }
    }

    public static NetworkInfo O0000oO(Context context) {
        if (!O00000Oo(context, OO0o000.O00000o0("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF"))) {
            return null;
        }
        ConnectivityManager O00oOoOo = O00oOoOo(context);
        return O00oOoOo == null ? null : O00oOoOo.getActiveNetworkInfo();
    }

    public static int O0000oO0(Context context) {
        try {
            return O000O0Oo(context);
        } catch (Throwable unused) {
            return -1;
        }
    }

    static String O0000oOO(Context context) {
        try {
            NetworkInfo O0000oO = O0000oO(context);
            return O0000oO == null ? null : O0000oO.getExtraInfo();
        } catch (Throwable unused) {
            return null;
        }
    }

    static String O0000oOo(Context context) {
        try {
            if (O0000o0 != null && !"".equals(O0000o0)) {
                return O0000o0;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager == null) {
                return "";
            }
            StringBuilder stringBuilder;
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            if (i2 > i) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(i);
                stringBuilder.append("*");
                stringBuilder.append(i2);
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(i2);
                stringBuilder.append("*");
                stringBuilder.append(i);
            }
            O0000o0 = stringBuilder.toString();
            return O0000o0;
        } catch (Throwable unused) {
        }
    }

    public static String O0000oo(Context context) {
        try {
            if (O0000o0o != null && !"".equals(O0000o0o)) {
                return O0000o0o;
            }
            if (!O00000Oo(context, OO0o000.O00000o0("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
                return O0000o0o;
            }
            TelephonyManager O000O0o = O000O0o(context);
            if (O000O0o == null) {
                return "";
            }
            if (VERSION.SDK_INT >= 26) {
                Method O000000o = OO0o000.O000000o(O000O0o.getClass(), "QZ2V0TWVpZA==", new Class[0]);
                if (O000000o != null) {
                    O0000o0o = (String) O000000o.invoke(O000O0o, new Object[0]);
                }
                if (O0000o0o == null) {
                    O0000o0o = "";
                }
            }
            return O0000o0o;
        } catch (Throwable unused) {
        }
    }

    public static String O0000oo0(Context context) {
        try {
            if (O0000o0O != null && !"".equals(O0000o0O)) {
                return O0000o0O;
            }
            if (!O00000Oo(context, OO0o000.O00000o0("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
                return O0000o0O;
            }
            TelephonyManager O000O0o = O000O0o(context);
            if (O000O0o == null) {
                return "";
            }
            Method O000000o = OO0o000.O000000o(O000O0o.getClass(), "QZ2V0RGV2aWNlSWQ", new Class[0]);
            if (VERSION.SDK_INT >= 26) {
                O000000o = OO0o000.O000000o(O000O0o.getClass(), "QZ2V0SW1laQ==", new Class[0]);
            }
            if (O000000o != null) {
                O0000o0O = (String) O000000o.invoke(O000O0o, new Object[0]);
            }
            if (O0000o0O == null) {
                O0000o0O = "";
            }
            return O0000o0O;
        } catch (Throwable unused) {
        }
    }

    public static String O0000ooO(Context context) {
        try {
            return O000O00o(context);
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0065 A:{SYNTHETIC, Splitter:B:32:0x0065} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005f A:{SYNTHETIC, Splitter:B:26:0x005f} */
    public static int O0000ooo(android.content.Context r4) {
        /*
        r0 = O0000oO;
        if (r0 == 0) goto L_0x0007;
    L_0x0004:
        r4 = O0000oO;
        return r4;
    L_0x0007:
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 16;
        r2 = 0;
        if (r0 < r1) goto L_0x0028;
    L_0x000e:
        r0 = "activity";
        r4 = r4.getSystemService(r0);
        r4 = (android.app.ActivityManager) r4;
        if (r4 != 0) goto L_0x0019;
    L_0x0018:
        return r2;
    L_0x0019:
        r0 = new android.app.ActivityManager$MemoryInfo;
        r0.<init>();
        r4.getMemoryInfo(r0);
        r0 = r0.totalMem;
        r2 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r0 = r0 / r2;
        r2 = (int) r0;
        goto L_0x0068;
    L_0x0028:
        r4 = 0;
        r0 = new java.io.File;	 Catch:{ Throwable -> 0x0063, all -> 0x005c }
        r1 = "/proc/meminfo";
        r0.<init>(r1);	 Catch:{ Throwable -> 0x0063, all -> 0x005c }
        r1 = new java.io.BufferedReader;	 Catch:{ Throwable -> 0x0063, all -> 0x005c }
        r3 = new java.io.FileReader;	 Catch:{ Throwable -> 0x0063, all -> 0x005c }
        r3.<init>(r0);	 Catch:{ Throwable -> 0x0063, all -> 0x005c }
        r1.<init>(r3);	 Catch:{ Throwable -> 0x0063, all -> 0x005c }
        r4 = r1.readLine();	 Catch:{ Throwable -> 0x005a, all -> 0x0056 }
        r0 = "\\s+";
        r4 = r4.split(r0);	 Catch:{ Throwable -> 0x005a, all -> 0x0056 }
        r0 = 1;
        r4 = r4[r0];	 Catch:{ Throwable -> 0x005a, all -> 0x0056 }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Throwable -> 0x005a, all -> 0x0056 }
        r4 = r4.intValue();	 Catch:{ Throwable -> 0x005a, all -> 0x0056 }
        if (r1 == 0) goto L_0x0054;
    L_0x0051:
        r1.close();	 Catch:{ IOException -> 0x0054 }
    L_0x0054:
        r2 = r4;
        goto L_0x0068;
    L_0x0056:
        r4 = move-exception;
        r0 = r4;
        r4 = r1;
        goto L_0x005d;
    L_0x005a:
        r4 = r1;
        goto L_0x0063;
    L_0x005c:
        r0 = move-exception;
    L_0x005d:
        if (r4 == 0) goto L_0x0062;
    L_0x005f:
        r4.close();	 Catch:{ IOException -> 0x0062 }
    L_0x0062:
        throw r0;
    L_0x0063:
        if (r4 == 0) goto L_0x0068;
    L_0x0065:
        r4.close();	 Catch:{ IOException -> 0x0068 }
    L_0x0068:
        r2 = r2 / 1024;
        O0000oO = r2;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.OO0O0o0.O0000ooo(android.content.Context):int");
    }

    private static String O000O00o(Context context) throws InvocationTargetException, IllegalAccessException {
        if (O0000oOo != null && !"".equals(O0000oOo)) {
            return O0000oOo;
        }
        if (!O00000Oo(context, OO0o000.O00000o0("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            return O0000oOo;
        }
        TelephonyManager O000O0o = O000O0o(context);
        if (O000O0o == null) {
            return "";
        }
        Method O000000o = OO0o000.O000000o(O000O0o.getClass(), "UZ2V0U3Vic2NyaWJlcklk", new Class[0]);
        if (O000000o != null) {
            O0000oOo = (String) O000000o.invoke(O000O0o, new Object[0]);
        }
        if (O0000oOo == null) {
            O0000oOo = "";
        }
        return O0000oOo;
    }

    private static String O000O0OO(Context context) {
        if (!O00000Oo(context, OO0o000.O00000o0("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            return null;
        }
        TelephonyManager O000O0o = O000O0o(context);
        if (O000O0o == null) {
            return "";
        }
        String simOperatorName = O000O0o.getSimOperatorName();
        if (TextUtils.isEmpty(simOperatorName)) {
            simOperatorName = O000O0o.getNetworkOperatorName();
        }
        return simOperatorName;
    }

    private static int O000O0Oo(Context context) {
        if (context == null || !O00000Oo(context, OO0o000.O00000o0("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF"))) {
            return -1;
        }
        ConnectivityManager O00oOoOo = O00oOoOo(context);
        if (O00oOoOo == null) {
            return -1;
        }
        NetworkInfo activeNetworkInfo = O00oOoOo.getActiveNetworkInfo();
        return activeNetworkInfo == null ? -1 : activeNetworkInfo.getType();
    }

    private static TelephonyManager O000O0o(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }

    private static int O000O0o0(Context context) {
        if (!O00000Oo(context, OO0o000.O00000o0("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            return -1;
        }
        TelephonyManager O000O0o = O000O0o(context);
        return O000O0o == null ? -1 : O000O0o.getNetworkType();
    }

    private static ConnectivityManager O00oOoOo(Context context) {
        return (ConnectivityManager) context.getSystemService("connectivity");
    }

    static String O00oOooO(Context context) {
        try {
            return O000O0OO(context);
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x009a A:{SYNTHETIC, Splitter:B:46:0x009a} */
    /* JADX WARNING: Missing block: B:41:0x0091, code skipped:
            if (r0 != null) goto L_0x0093;
     */
    /* JADX WARNING: Missing block: B:43:?, code skipped:
            r0.close();
     */
    /* JADX WARNING: Missing block: B:50:0x009e, code skipped:
            if (r0 != null) goto L_0x0093;
     */
    private static java.lang.String O00oOooo(android.content.Context r8) {
        /*
        r0 = 0;
        r1 = "android.permission.READ_EXTERNAL_STORAGE";
        r8 = com.loc.OO0o000.O000000o(r8, r1);	 Catch:{ Throwable -> 0x009e, all -> 0x0097 }
        if (r8 == 0) goto L_0x0091;
    L_0x0009:
        r8 = "mounted";
        r1 = android.os.Environment.getExternalStorageState();	 Catch:{ Throwable -> 0x009e, all -> 0x0097 }
        r8 = r8.equals(r1);	 Catch:{ Throwable -> 0x009e, all -> 0x0097 }
        if (r8 == 0) goto L_0x0091;
    L_0x0015:
        r8 = android.os.Environment.getExternalStorageDirectory();	 Catch:{ Throwable -> 0x009e, all -> 0x0097 }
        r8 = r8.getAbsolutePath();	 Catch:{ Throwable -> 0x009e, all -> 0x0097 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x009e, all -> 0x0097 }
        r1.<init>();	 Catch:{ Throwable -> 0x009e, all -> 0x0097 }
        r1.append(r8);	 Catch:{ Throwable -> 0x009e, all -> 0x0097 }
        r8 = "/.UTSystemConfig/Global/Alvin2.xml";
        r1.append(r8);	 Catch:{ Throwable -> 0x009e, all -> 0x0097 }
        r8 = r1.toString();	 Catch:{ Throwable -> 0x009e, all -> 0x0097 }
        r1 = new java.io.File;	 Catch:{ Throwable -> 0x009e, all -> 0x0097 }
        r1.<init>(r8);	 Catch:{ Throwable -> 0x009e, all -> 0x0097 }
        r8 = android.util.Xml.newPullParser();	 Catch:{ Throwable -> 0x009e, all -> 0x0097 }
        r2 = r8.getEventType();	 Catch:{ Throwable -> 0x009e, all -> 0x0097 }
        r3 = new java.io.FileInputStream;	 Catch:{ Throwable -> 0x009e, all -> 0x0097 }
        r3.<init>(r1);	 Catch:{ Throwable -> 0x009e, all -> 0x0097 }
        r0 = "utf-8";
        r8.setInput(r3, r0);	 Catch:{ Throwable -> 0x008f, all -> 0x008c }
        r0 = 0;
        r1 = r0;
    L_0x0047:
        r4 = 1;
        if (r4 == r2) goto L_0x008a;
    L_0x004a:
        if (r2 == 0) goto L_0x0085;
    L_0x004c:
        switch(r2) {
            case 2: goto L_0x005e;
            case 3: goto L_0x005c;
            case 4: goto L_0x0050;
            default: goto L_0x004f;
        };	 Catch:{ Throwable -> 0x008f, all -> 0x008c }
    L_0x004f:
        goto L_0x0085;
    L_0x0050:
        if (r1 == 0) goto L_0x0085;
    L_0x0052:
        r8 = r8.getText();	 Catch:{ Throwable -> 0x008f, all -> 0x008c }
        if (r3 == 0) goto L_0x005b;
    L_0x0058:
        r3.close();	 Catch:{ Throwable -> 0x005b }
    L_0x005b:
        return r8;
    L_0x005c:
        r1 = r0;
        goto L_0x0085;
    L_0x005e:
        r2 = r8.getAttributeCount();	 Catch:{ Throwable -> 0x008f, all -> 0x008c }
        if (r2 <= 0) goto L_0x0085;
    L_0x0064:
        r2 = r8.getAttributeCount();	 Catch:{ Throwable -> 0x008f, all -> 0x008c }
        r5 = r1;
        r1 = r0;
    L_0x006a:
        if (r1 >= r2) goto L_0x0084;
    L_0x006c:
        r6 = r8.getAttributeValue(r1);	 Catch:{ Throwable -> 0x008f, all -> 0x008c }
        r7 = "UTDID2";
        r7 = r7.equals(r6);	 Catch:{ Throwable -> 0x008f, all -> 0x008c }
        if (r7 != 0) goto L_0x0080;
    L_0x0078:
        r7 = "UTDID";
        r6 = r7.equals(r6);	 Catch:{ Throwable -> 0x008f, all -> 0x008c }
        if (r6 == 0) goto L_0x0081;
    L_0x0080:
        r5 = r4;
    L_0x0081:
        r1 = r1 + 1;
        goto L_0x006a;
    L_0x0084:
        r1 = r5;
    L_0x0085:
        r2 = r8.next();	 Catch:{ Throwable -> 0x008f, all -> 0x008c }
        goto L_0x0047;
    L_0x008a:
        r0 = r3;
        goto L_0x0091;
    L_0x008c:
        r8 = move-exception;
        r0 = r3;
        goto L_0x0098;
    L_0x008f:
        r0 = r3;
        goto L_0x009e;
    L_0x0091:
        if (r0 == 0) goto L_0x00a1;
    L_0x0093:
        r0.close();	 Catch:{ Throwable -> 0x00a1 }
        goto L_0x00a1;
    L_0x0097:
        r8 = move-exception;
    L_0x0098:
        if (r0 == 0) goto L_0x009d;
    L_0x009a:
        r0.close();	 Catch:{ Throwable -> 0x009d }
    L_0x009d:
        throw r8;
    L_0x009e:
        if (r0 == 0) goto L_0x00a1;
    L_0x00a0:
        goto L_0x0093;
    L_0x00a1:
        r8 = "";
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.OO0O0o0.O00oOooo(android.content.Context):java.lang.String");
    }
}
