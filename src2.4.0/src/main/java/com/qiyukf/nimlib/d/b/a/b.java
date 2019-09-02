package com.qiyukf.nimlib.d.b.a;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.qiyukf.nimlib.d.a.b.a;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public final class b {
    private static synchronized long a() {
        long a;
        synchronized (b.class) {
            long j = 0;
            try {
                String a2 = a(new File("/proc/meminfo"), "MemTotal");
                if (!TextUtils.isEmpty(a2)) {
                    a2 = a2.toUpperCase(Locale.US);
                    if (a2.endsWith("KB")) {
                        a = a(a2, "KB", 1024);
                    } else if (a2.endsWith("MB")) {
                        a = a(a2, "MB", 1048576);
                    } else if (a2.endsWith("GB")) {
                        a = a(a2, "GB", 1073741824);
                    } else {
                        j = -1;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
                StringBuilder stringBuilder = new StringBuilder("getTotalMemory error=");
                stringBuilder.append(th.getMessage());
                a.c(stringBuilder.toString());
            }
            a = j;
        }
        return a;
    }

    private static long a(String str, String str2, int i) {
        return Long.parseLong(str.split(str2)[0].trim()) * ((long) i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0033  */
    private static com.qiyukf.nimlib.d.b.a.a a(android.content.Context r3, android.content.pm.PackageInfo r4, android.content.pm.PackageManager r5) {
        /*
        r0 = 0;
        if (r3 == 0) goto L_0x003b;
    L_0x0003:
        if (r4 == 0) goto L_0x003b;
    L_0x0005:
        r1 = r4.packageName;
        r2 = r4.versionName;
        if (r5 == 0) goto L_0x0015;
    L_0x000b:
        r0 = r4.applicationInfo;
        r5 = r5.getApplicationLabel(r0);
        r0 = r5.toString();
    L_0x0015:
        r5 = android.text.TextUtils.isEmpty(r0);
        if (r5 == 0) goto L_0x002c;
    L_0x001b:
        r5 = r4.applicationInfo;	 Catch:{ Throwable -> 0x0028 }
        r5 = r5.labelRes;	 Catch:{ Throwable -> 0x0028 }
        r3 = r3.getResources();	 Catch:{ Throwable -> 0x0028 }
        r3 = r3.getString(r5);	 Catch:{ Throwable -> 0x0028 }
        goto L_0x002d;
    L_0x0028:
        r3 = move-exception;
        r3.printStackTrace();
    L_0x002c:
        r3 = r0;
    L_0x002d:
        r5 = android.text.TextUtils.isEmpty(r3);
        if (r5 == 0) goto L_0x0035;
    L_0x0033:
        r3 = r4.packageName;
    L_0x0035:
        r4 = new com.qiyukf.nimlib.d.b.a.a;
        r4.<init>(r1, r3, r2);
        return r4;
    L_0x003b:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.d.b.a.b.a(android.content.Context, android.content.pm.PackageInfo, android.content.pm.PackageManager):com.qiyukf.nimlib.d.b.a.a");
    }

    static d a(Context context) {
        String str = Build.BRAND;
        String str2 = Build.MODEL;
        String c = c(context);
        b(context);
        long[] jArr = new long[2];
        if ("mounted".equals(Environment.getExternalStorageState())) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            long blockSizeLong;
            long availableBlocksLong;
            if (VERSION.SDK_INT >= 18) {
                blockSizeLong = statFs.getBlockSizeLong();
                long blockCountLong = statFs.getBlockCountLong();
                availableBlocksLong = statFs.getAvailableBlocksLong();
                jArr[0] = blockCountLong * blockSizeLong;
                jArr[1] = blockSizeLong * availableBlocksLong;
            } else {
                blockSizeLong = (long) statFs.getBlockSize();
                availableBlocksLong = (long) statFs.getAvailableBlocks();
                jArr[0] = ((long) statFs.getBlockCount()) * blockSizeLong;
                jArr[1] = blockSizeLong * availableBlocksLong;
            }
        } else {
            jArr[0] = 0;
            jArr[1] = 0;
        }
        long j = jArr[0];
        long a = a();
        int i = VERSION.SDK_INT;
        String a2 = g.a();
        Locale locale = context.getResources().getConfiguration().locale;
        String language = locale.getLanguage();
        String country = locale.getCountry();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(language);
        stringBuilder.append("_");
        stringBuilder.append(country);
        return new d(str, str2, c, j, a, "android", i, a2, stringBuilder.toString(), TimeZone.getDefault().getDisplayName(false, 0));
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x004b A:{SYNTHETIC, Splitter:B:29:0x004b} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0052 A:{SYNTHETIC, Splitter:B:34:0x0052} */
    private static java.lang.String a(java.io.File r4, java.lang.String r5) {
        /*
        r0 = r4.exists();
        r1 = 0;
        if (r0 == 0) goto L_0x005b;
    L_0x0007:
        r0 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x0044, all -> 0x0041 }
        r2 = new java.io.FileReader;	 Catch:{ Exception -> 0x0044, all -> 0x0041 }
        r2.<init>(r4);	 Catch:{ Exception -> 0x0044, all -> 0x0041 }
        r4 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r0.<init>(r2, r4);	 Catch:{ Exception -> 0x0044, all -> 0x0041 }
    L_0x0013:
        r4 = r0.readLine();	 Catch:{ Exception -> 0x003f }
        if (r4 == 0) goto L_0x0036;
    L_0x0019:
        r2 = "\\s*:\\s*";
        r2 = java.util.regex.Pattern.compile(r2);	 Catch:{ Exception -> 0x003f }
        r3 = 2;
        r4 = r2.split(r4, r3);	 Catch:{ Exception -> 0x003f }
        if (r4 == 0) goto L_0x0013;
    L_0x0026:
        r2 = r4.length;	 Catch:{ Exception -> 0x003f }
        r3 = 1;
        if (r2 <= r3) goto L_0x0013;
    L_0x002a:
        r2 = 0;
        r2 = r4[r2];	 Catch:{ Exception -> 0x003f }
        r2 = r2.equals(r5);	 Catch:{ Exception -> 0x003f }
        if (r2 == 0) goto L_0x0013;
    L_0x0033:
        r4 = r4[r3];	 Catch:{ Exception -> 0x003f }
        r1 = r4;
    L_0x0036:
        r0.close();	 Catch:{ IOException -> 0x003a }
        return r1;
    L_0x003a:
        r4 = move-exception;
        r4.printStackTrace();
        return r1;
    L_0x003f:
        r4 = move-exception;
        goto L_0x0046;
    L_0x0041:
        r4 = move-exception;
        r0 = r1;
        goto L_0x0050;
    L_0x0044:
        r4 = move-exception;
        r0 = r1;
    L_0x0046:
        r4.printStackTrace();	 Catch:{ all -> 0x004f }
        if (r0 == 0) goto L_0x005b;
    L_0x004b:
        r0.close();	 Catch:{ IOException -> 0x003a }
        return r1;
    L_0x004f:
        r4 = move-exception;
    L_0x0050:
        if (r0 == 0) goto L_0x005a;
    L_0x0052:
        r0.close();	 Catch:{ IOException -> 0x0056 }
        goto L_0x005a;
    L_0x0056:
        r5 = move-exception;
        r5.printStackTrace();
    L_0x005a:
        throw r4;
    L_0x005b:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.d.b.a.b.a(java.io.File, java.lang.String):java.lang.String");
    }

    public static String b(Context context) {
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        if (wifiManager == null) {
            return null;
        }
        String str;
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        if (packageManager == null) {
            str = "getActiveMacAddress pm null, fuck!";
        } else if (packageManager.checkPermission("android.permission.ACCESS_WIFI_STATE", context.getApplicationContext().getPackageName()) != 0) {
            str = "getActiveMacAddress without permission!";
        } else {
            try {
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                if (connectionInfo != null) {
                    return connectionInfo.getMacAddress();
                }
            } catch (Throwable th) {
                th.printStackTrace();
                StringBuilder stringBuilder = new StringBuilder("getActiveMacAddress error, e=");
                stringBuilder.append(th.getMessage());
                a.c(stringBuilder.toString());
            }
            return null;
        }
        a.c(str);
        return null;
    }

    public static String c(Context context) {
        if (context == null) {
            return null;
        }
        String str;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            str = "getIMEI tm null, fuck!";
        } else if (com.qiyukf.nimlib.d.a.d.b.a(context, "android.permission.READ_PHONE_STATE")) {
            try {
                return telephonyManager.getDeviceId();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            str = "getIMEI without permission!";
        }
        a.c(str);
        return null;
    }

    static a d(Context context) {
        String str;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            str = "getAppInfo pm null, fuck!";
        } else {
            PackageInfo packageInfo;
            try {
                packageInfo = packageManager.getPackageInfo(context.getPackageName(), 16384);
            } catch (Throwable th) {
                th.printStackTrace();
                packageInfo = null;
            }
            if (packageInfo != null) {
                return a(context, packageInfo, packageManager);
            }
            str = "getAppInfo pi null!";
        }
        a.c(str);
        return null;
    }

    static f e(Context context) {
        try {
            if (context.getApplicationContext().getPackageManager() == null) {
                a.c("getOperatorInfo pm null, fuck!");
                return null;
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                a.c("getOperatorInfo TelephonyManager null, fuck!");
                return null;
            } else if (telephonyManager.getSimState() != 5) {
                a.c("getOperatorInfo SIM CARD not ready!");
                return null;
            } else {
                String str;
                switch (telephonyManager.getNetworkType()) {
                    case 1:
                        str = "GPRS";
                        break;
                    case 2:
                        str = "EDGE";
                        break;
                    case 3:
                        str = "UMTS";
                        break;
                    case 4:
                        str = "CDMA";
                        break;
                    case 5:
                        str = "EVDO_0";
                        break;
                    case 6:
                        str = "EVDO_A";
                        break;
                    case 7:
                        str = "1xRTT";
                        break;
                    case 8:
                        str = "HSDPA";
                        break;
                    case 9:
                        str = "HSUPA";
                        break;
                    case 10:
                        str = "HSPA";
                        break;
                    case 11:
                        str = "IDEN";
                        break;
                    case 12:
                        str = "EVDO_B";
                        break;
                    case 13:
                        str = "LTE";
                        break;
                    case 14:
                        str = "EHRPD";
                        break;
                    case 15:
                        str = "HSPAP";
                        break;
                    case 16:
                        str = "GSM";
                        break;
                    case 17:
                        str = "TD_SCDMA";
                        break;
                    case 18:
                        str = "IWLAN";
                        break;
                    default:
                        str = "UNKNOWN";
                        break;
                }
                String str2 = str;
                String networkOperatorName = telephonyManager.getNetworkOperatorName();
                String networkCountryIso = telephonyManager.getNetworkCountryIso();
                String networkOperator = telephonyManager.getNetworkOperator();
                if (networkOperator != null) {
                    return new f(Integer.parseInt(networkOperator.substring(0, 3)), Integer.parseInt(networkOperator.substring(3)), str2, networkOperatorName, networkCountryIso);
                }
                a.c("getOperatorInfo get network operator null!");
                return null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b0 A:{Catch:{ Throwable -> 0x0126 }} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b0 A:{Catch:{ Throwable -> 0x0126 }} */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x011d A:{SKIP, Catch:{ Throwable -> 0x0126 }} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b0 A:{Catch:{ Throwable -> 0x0126 }} */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x011d A:{SKIP, Catch:{ Throwable -> 0x0126 }} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b0 A:{Catch:{ Throwable -> 0x0126 }} */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x011d A:{SKIP, Catch:{ Throwable -> 0x0126 }} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b0 A:{Catch:{ Throwable -> 0x0126 }} */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x011d A:{SKIP, Catch:{ Throwable -> 0x0126 }} */
    static com.qiyukf.nimlib.d.b.a.c f(android.content.Context r9) {
        /*
        r0 = 0;
        r1 = r9.getApplicationContext();	 Catch:{ Throwable -> 0x0126 }
        r1 = r1.getPackageManager();	 Catch:{ Throwable -> 0x0126 }
        if (r1 != 0) goto L_0x0011;
    L_0x000b:
        r9 = "getCellInfo pm null, fuck!";
        com.qiyukf.nimlib.d.a.b.a.c(r9);	 Catch:{ Throwable -> 0x0126 }
        return r0;
    L_0x0011:
        r2 = "phone";
        r2 = r9.getSystemService(r2);	 Catch:{ Throwable -> 0x0126 }
        r2 = (android.telephony.TelephonyManager) r2;	 Catch:{ Throwable -> 0x0126 }
        if (r2 != 0) goto L_0x0021;
    L_0x001b:
        r9 = "getCellInfo TelephonyManager null, fuck!";
        com.qiyukf.nimlib.d.a.b.a.c(r9);	 Catch:{ Throwable -> 0x0126 }
        return r0;
    L_0x0021:
        r3 = r2.getSimState();	 Catch:{ Throwable -> 0x0126 }
        r4 = 5;
        if (r3 == r4) goto L_0x002e;
    L_0x0028:
        r9 = "getCellInfo SIM CARD not ready!";
        com.qiyukf.nimlib.d.a.b.a.c(r9);	 Catch:{ Throwable -> 0x0126 }
        return r0;
    L_0x002e:
        r3 = r2.getNetworkOperator();	 Catch:{ Throwable -> 0x0126 }
        if (r3 != 0) goto L_0x003a;
    L_0x0034:
        r9 = "getCellInfo get network operator null!";
        com.qiyukf.nimlib.d.a.b.a.c(r9);	 Catch:{ Throwable -> 0x0126 }
        return r0;
    L_0x003a:
        r9 = r9.getApplicationContext();	 Catch:{ Throwable -> 0x0126 }
        r9 = r9.getPackageName();	 Catch:{ Throwable -> 0x0126 }
        r3 = "android.permission.ACCESS_COARSE_LOCATION";
        r3 = r1.checkPermission(r3, r9);	 Catch:{ Throwable -> 0x0126 }
        r4 = 0;
        r5 = 1;
        if (r3 != 0) goto L_0x004e;
    L_0x004c:
        r3 = r5;
        goto L_0x004f;
    L_0x004e:
        r3 = r4;
    L_0x004f:
        r6 = "android.permission.ACCESS_FINE_LOCATION";
        r9 = r1.checkPermission(r6, r9);	 Catch:{ Throwable -> 0x0126 }
        if (r9 != 0) goto L_0x0058;
    L_0x0057:
        r4 = r5;
    L_0x0058:
        r9 = -1;
        if (r3 != 0) goto L_0x0064;
    L_0x005b:
        if (r4 == 0) goto L_0x005e;
    L_0x005d:
        goto L_0x0064;
    L_0x005e:
        r1 = "getCellInfo without permission!";
    L_0x0060:
        com.qiyukf.nimlib.d.a.b.a.c(r1);	 Catch:{ Throwable -> 0x0126 }
        goto L_0x0096;
    L_0x0064:
        r1 = r2.getPhoneType();	 Catch:{ Throwable -> 0x0126 }
        r4 = 2;
        if (r1 != r4) goto L_0x007c;
    L_0x006b:
        r1 = r2.getCellLocation();	 Catch:{ Throwable -> 0x0126 }
        r1 = (android.telephony.cdma.CdmaCellLocation) r1;	 Catch:{ Throwable -> 0x0126 }
        if (r1 == 0) goto L_0x0096;
    L_0x0073:
        r4 = r1.getBaseStationId();	 Catch:{ Throwable -> 0x0126 }
        r1 = r1.getNetworkId();	 Catch:{ Throwable -> 0x0126 }
        goto L_0x0098;
    L_0x007c:
        r1 = r2.getPhoneType();	 Catch:{ Throwable -> 0x0126 }
        if (r1 != r5) goto L_0x0093;
    L_0x0082:
        r1 = r2.getCellLocation();	 Catch:{ Throwable -> 0x0126 }
        r1 = (android.telephony.gsm.GsmCellLocation) r1;	 Catch:{ Throwable -> 0x0126 }
        if (r1 == 0) goto L_0x0096;
    L_0x008a:
        r4 = r1.getCid();	 Catch:{ Throwable -> 0x0126 }
        r1 = r1.getLac();	 Catch:{ Throwable -> 0x0126 }
        goto L_0x0098;
    L_0x0093:
        r1 = "getCellInfo phone type NONE!";
        goto L_0x0060;
    L_0x0096:
        r1 = r9;
        r4 = r1;
    L_0x0098:
        if (r3 == 0) goto L_0x011a;
    L_0x009a:
        r3 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x0126 }
        r5 = 17;
        if (r3 < r5) goto L_0x011a;
    L_0x00a0:
        r2 = r2.getAllCellInfo();	 Catch:{ Throwable -> 0x0126 }
        r2 = r2.iterator();	 Catch:{ Throwable -> 0x0126 }
        r3 = r9;
        r5 = r3;
    L_0x00aa:
        r6 = r2.hasNext();	 Catch:{ Throwable -> 0x0126 }
        if (r6 == 0) goto L_0x011a;
    L_0x00b0:
        r6 = r2.next();	 Catch:{ Throwable -> 0x0126 }
        r6 = (android.telephony.CellInfo) r6;	 Catch:{ Throwable -> 0x0126 }
        r7 = r6 instanceof android.telephony.CellInfoCdma;	 Catch:{ Throwable -> 0x0126 }
        if (r7 == 0) goto L_0x00cd;
    L_0x00ba:
        r6 = (android.telephony.CellInfoCdma) r6;	 Catch:{ Throwable -> 0x0126 }
        r3 = r6.getCellIdentity();	 Catch:{ Throwable -> 0x0126 }
        r3 = r3.getBasestationId();	 Catch:{ Throwable -> 0x0126 }
        r5 = r6.getCellSignalStrength();	 Catch:{ Throwable -> 0x0126 }
        r5 = r5.getCdmaDbm();	 Catch:{ Throwable -> 0x0126 }
        goto L_0x0117;
    L_0x00cd:
        r7 = r6 instanceof android.telephony.CellInfoWcdma;	 Catch:{ Throwable -> 0x0126 }
        if (r7 == 0) goto L_0x00ea;
    L_0x00d1:
        r6 = (android.telephony.CellInfoWcdma) r6;	 Catch:{ Throwable -> 0x0126 }
        r7 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x0126 }
        r8 = 18;
        if (r7 < r8) goto L_0x0117;
    L_0x00d9:
        r3 = r6.getCellIdentity();	 Catch:{ Throwable -> 0x0126 }
        r3 = r3.getCid();	 Catch:{ Throwable -> 0x0126 }
        r5 = r6.getCellSignalStrength();	 Catch:{ Throwable -> 0x0126 }
        r5 = r5.getDbm();	 Catch:{ Throwable -> 0x0126 }
        goto L_0x0117;
    L_0x00ea:
        r7 = r6 instanceof android.telephony.CellInfoGsm;	 Catch:{ Throwable -> 0x0126 }
        if (r7 == 0) goto L_0x0101;
    L_0x00ee:
        r6 = (android.telephony.CellInfoGsm) r6;	 Catch:{ Throwable -> 0x0126 }
        r3 = r6.getCellIdentity();	 Catch:{ Throwable -> 0x0126 }
        r3 = r3.getCid();	 Catch:{ Throwable -> 0x0126 }
        r5 = r6.getCellSignalStrength();	 Catch:{ Throwable -> 0x0126 }
        r5 = r5.getDbm();	 Catch:{ Throwable -> 0x0126 }
        goto L_0x0117;
    L_0x0101:
        r7 = r6 instanceof android.telephony.CellInfoLte;	 Catch:{ Throwable -> 0x0126 }
        if (r7 == 0) goto L_0x0117;
    L_0x0105:
        r6 = (android.telephony.CellInfoLte) r6;	 Catch:{ Throwable -> 0x0126 }
        r3 = r6.getCellIdentity();	 Catch:{ Throwable -> 0x0126 }
        r3 = r3.getCi();	 Catch:{ Throwable -> 0x0126 }
        r5 = r6.getCellSignalStrength();	 Catch:{ Throwable -> 0x0126 }
        r5 = r5.getDbm();	 Catch:{ Throwable -> 0x0126 }
    L_0x0117:
        if (r4 != r3) goto L_0x00aa;
    L_0x0119:
        goto L_0x011b;
    L_0x011a:
        r5 = r9;
    L_0x011b:
        if (r4 == r9) goto L_0x0125;
    L_0x011d:
        if (r1 == r9) goto L_0x0125;
    L_0x011f:
        r9 = new com.qiyukf.nimlib.d.b.a.c;	 Catch:{ Throwable -> 0x0126 }
        r9.<init>(r4, r1, r5);	 Catch:{ Throwable -> 0x0126 }
        return r9;
    L_0x0125:
        return r0;
    L_0x0126:
        r9 = move-exception;
        r9.printStackTrace();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.d.b.a.b.f(android.content.Context):com.qiyukf.nimlib.d.b.a.c");
    }

    static List<a> g(Context context) {
        if (((ActivityManager) context.getSystemService("activity")) == null) {
            return null;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return null;
        }
        try {
            List<PackageInfo> installedPackages = packageManager.getInstalledPackages(0);
            if (installedPackages == null || installedPackages.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList(installedPackages.size());
            for (PackageInfo packageInfo : installedPackages) {
                if (!(TextUtils.isEmpty(packageInfo.packageName) || packageInfo.packageName.startsWith("com.android") || packageInfo.packageName.startsWith("com.oppo"))) {
                    String str = packageInfo.packageName;
                    StringBuilder stringBuilder = new StringBuilder("com.");
                    stringBuilder.append(Build.BRAND.toLowerCase());
                    if (!str.startsWith(stringBuilder.toString())) {
                        arrayList.add(a(context, packageInfo, packageManager));
                    }
                }
            }
            return arrayList;
        } catch (Throwable th) {
            StringBuilder stringBuilder2 = new StringBuilder("get installed app info list error, e=");
            stringBuilder2.append(th.getMessage());
            a.c(stringBuilder2.toString());
            th.printStackTrace();
            return null;
        }
    }

    public static String h(Context context) {
        try {
            return Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable th) {
            th.printStackTrace();
            StringBuilder stringBuilder = new StringBuilder("get android id error, e=");
            stringBuilder.append(th.getMessage());
            a.c(stringBuilder.toString());
            return null;
        }
    }
}
