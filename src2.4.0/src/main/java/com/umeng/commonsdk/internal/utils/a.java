package com.umeng.commonsdk.internal.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import com.ximalaya.ting.android.opensdk.constants.PreferenceConstantsInOpenSdk;
import com.yalantis.ucrop.view.CropImageView;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ApplicationLayerUtil */
public class a {

    /* compiled from: ApplicationLayerUtil */
    public static class a {
        public String a;
        public String b;
    }

    /* compiled from: ApplicationLayerUtil */
    public static class b {
        public String a = null;
        public int b = -1;
        public String c = null;
    }

    /* compiled from: ApplicationLayerUtil */
    public static class c {
        public int a;
        public String b;
        public String c;
        public int d;
        public int e;
        public int f;
        public int g;
        public String h;
        public int i;
        public int j;
        public int k;
        public long l;
    }

    public static float a(Context context) {
        float f = CropImageView.DEFAULT_ASPECT_RATIO;
        if (context == null) {
            return CropImageView.DEFAULT_ASPECT_RATIO;
        }
        Configuration configuration = new Configuration();
        try {
            configuration.updateFrom(context.getResources().getConfiguration());
            if (configuration != null) {
                f = configuration.fontScale;
            }
        } catch (Exception e) {
            if (e != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("getFontSize:");
                stringBuilder.append(e.getMessage());
                ULog.e(stringBuilder.toString());
            }
        }
        return f;
    }

    public static long a(Context context, String str) {
        long j = 0;
        if (context == null) {
            return 0;
        }
        try {
            j = context.getPackageManager().getPackageInfo(str, 0).firstInstallTime;
        } catch (NameNotFoundException e) {
            UMCrashManager.reportCrash(context, e);
            if (e != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("getAppFirstInstallTime");
                stringBuilder.append(e.getMessage());
                ULog.e(stringBuilder.toString());
            }
        }
        return j;
    }

    private static String a(BluetoothAdapter bluetoothAdapter) {
        if (bluetoothAdapter == null) {
            return null;
        }
        Class cls = bluetoothAdapter.getClass();
        try {
            Class cls2 = Class.forName("android.bluetooth.IBluetooth");
            Field declaredField = cls.getDeclaredField("mService");
            declaredField.setAccessible(true);
            Method method = cls2.getMethod("getAddress", new Class[0]);
            method.setAccessible(true);
            return (String) method.invoke(declaredField.get(bluetoothAdapter), new Object[0]);
        } catch (Exception unused) {
            return bluetoothAdapter.getAddress();
        }
    }

    public static boolean a() {
        return h.a();
    }

    public static long b(Context context, String str) {
        long j = 0;
        if (context == null) {
            return 0;
        }
        try {
            j = context.getPackageManager().getPackageInfo(str, 0).lastUpdateTime;
        } catch (NameNotFoundException e) {
            UMCrashManager.reportCrash(context, e);
            if (e != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("getAppLastUpdateTime:");
                stringBuilder.append(e.getMessage());
                ULog.e(stringBuilder.toString());
            }
        }
        return j;
    }

    public static String b() {
        return new SimpleDateFormat().format(new Date());
    }

    public static List<ScanResult> b(Context context) {
        List<ScanResult> list = null;
        if (context == null) {
            return null;
        }
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        if (wifiManager == null) {
            return null;
        }
        if (DeviceConfig.checkPermission(context, "android.permission.ACCESS_WIFI_STATE") && (DeviceConfig.checkPermission(context, "android.permission.ACCESS_COARSE_LOCATION") || DeviceConfig.checkPermission(context, "android.permission.ACCESS_FINE_LOCATION"))) {
            list = wifiManager.getScanResults();
            if (list == null || list.size() == 0) {
                return list;
            }
        }
        return list;
    }

    public static long c() {
        return (!j() || VERSION.SDK_INT < 9) ? 0 : Environment.getExternalStorageDirectory().getFreeSpace();
    }

    public static WifiInfo c(Context context) {
        WifiInfo wifiInfo = null;
        if (context == null) {
            return null;
        }
        if (DeviceConfig.checkPermission(context, "android.permission.ACCESS_WIFI_STATE")) {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager != null) {
                wifiInfo = wifiManager.getConnectionInfo();
            }
        }
        return wifiInfo;
    }

    public static String c(Context context, String str) {
        try {
            return context.getPackageManager().getInstallerPackageName(str);
        } catch (Exception e) {
            UMCrashManager.reportCrash(context, e);
            if (e != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("getAppInstaller:");
                stringBuilder.append(e.getMessage());
                ULog.e(stringBuilder.toString());
            }
            return null;
        }
    }

    public static int d(Context context, String str) {
        if (context == null) {
            return 0;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getPackageInfo(str, 0).applicationInfo;
            return applicationInfo != null ? applicationInfo.uid : 0;
        } catch (NameNotFoundException e) {
            UMCrashManager.reportCrash(context, e);
            if (e != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("getAppUid:");
                stringBuilder.append(e.getMessage());
                ULog.e(stringBuilder.toString());
            }
            return 0;
        }
    }

    public static long d() {
        return (!j() || VERSION.SDK_INT < 9) ? 0 : Environment.getExternalStorageDirectory().getTotalSpace();
    }

    public static void d(Context context) {
        if (context != null) {
            WifiInfo c = c(context);
            if (c != null) {
                c cVar = new c();
                cVar.a = c.describeContents();
                cVar.b = c.getBSSID();
                cVar.c = c.getSSID();
                if (VERSION.SDK_INT >= 21) {
                    cVar.d = c.getFrequency();
                } else {
                    cVar.d = -1;
                }
                int i = 0;
                if (c.getHiddenSSID()) {
                    cVar.e = 1;
                } else {
                    cVar.e = 0;
                }
                cVar.f = c.getIpAddress();
                cVar.g = c.getLinkSpeed();
                cVar.h = DeviceConfig.getMac(context);
                cVar.i = c.getNetworkId();
                cVar.j = c.getRssi();
                cVar.k = g(context);
                cVar.l = System.currentTimeMillis();
                if (c != null) {
                    try {
                        JSONArray b = f.b(context);
                        if (b != null && b.length() > 0) {
                            for (int i2 = 0; i2 < b.length(); i2++) {
                                String optString = b.optJSONObject(i2).optString("ssid", null);
                                if (optString != null && optString.equals(cVar.c)) {
                                    i = 1;
                                    break;
                                }
                            }
                        }
                        if (i == 0) {
                            f.a(context, cVar);
                        }
                    } catch (Exception e) {
                        if (e != null) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("wifiChange:");
                            stringBuilder.append(e.getMessage());
                            ULog.e(stringBuilder.toString());
                        }
                    }
                }
            }
        }
    }

    public static String e() {
        return g.a("df");
    }

    private static String e(Context context, String str) {
        String str2 = null;
        if (context == null) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
            if (applicationInfo != null) {
                str2 = (String) applicationInfo.loadLabel(context.getPackageManager());
            }
        } catch (Exception e) {
            if (e != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("getLabel:");
                stringBuilder.append(e.getMessage());
                ULog.e(stringBuilder.toString());
            }
        }
        return str2;
    }

    public static JSONArray e(Context context) {
        return context == null ? null : f.b(context);
    }

    public static long f() {
        return System.currentTimeMillis() - SystemClock.elapsedRealtime();
    }

    public static void f(Context context) {
        if (context != null) {
            f.c(context);
        }
    }

    public static int g(Context context) {
        int i = -1;
        if (context == null) {
            return -1;
        }
        if (DeviceConfig.checkPermission(context, "android.permission.ACCESS_WIFI_STATE")) {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager != null) {
                i = wifiManager.getWifiState();
            }
        }
        return i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003b  */
    public static java.lang.String g() {
        /*
        r0 = 0;
        r1 = android.os.Build.class;
        r2 = "getString";
        r3 = 1;
        r4 = new java.lang.Class[r3];	 Catch:{ Exception -> 0x0038 }
        r5 = java.lang.String.class;
        r6 = 0;
        r4[r6] = r5;	 Catch:{ Exception -> 0x0038 }
        r1 = r1.getDeclaredMethod(r2, r4);	 Catch:{ Exception -> 0x0038 }
        r1.setAccessible(r3);	 Catch:{ Exception -> 0x0038 }
        r2 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0038 }
        r3 = "net.hostname";
        r2[r6] = r3;	 Catch:{ Exception -> 0x0038 }
        r1 = r1.invoke(r0, r2);	 Catch:{ Exception -> 0x0038 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0038 }
        if (r1 == 0) goto L_0x0036;
    L_0x0024:
        r0 = "";
        r0 = r1.equalsIgnoreCase(r0);	 Catch:{ Exception -> 0x0031 }
        if (r0 != 0) goto L_0x0036;
    L_0x002c:
        r0 = com.umeng.commonsdk.statistics.common.HelperUtils.getUmengMD5(r1);	 Catch:{ Exception -> 0x0031 }
        goto L_0x0053;
    L_0x0031:
        r0 = move-exception;
        r7 = r1;
        r1 = r0;
        r0 = r7;
        goto L_0x0039;
    L_0x0036:
        r0 = r1;
        goto L_0x0053;
    L_0x0038:
        r1 = move-exception;
    L_0x0039:
        if (r1 == 0) goto L_0x0053;
    L_0x003b:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "getHostName:";
        r2.append(r3);
        r1 = r1.getMessage();
        r2.append(r1);
        r1 = r2.toString();
        com.umeng.commonsdk.statistics.common.ULog.e(r1);
    L_0x0053:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.utils.a.g():java.lang.String");
    }

    public static int h(Context context) {
        if (context == null) {
            return 0;
        }
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier(PreferenceConstantsInOpenSdk.OPENSDK_KEY_STATUS_BAR_HEIGHT, "dimen", "android"));
    }

    public static long h() {
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return ((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount());
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int i(Context context) {
        if (context == null) {
            return 0;
        }
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"));
    }

    public static long i() {
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
        } catch (Exception unused) {
            return 0;
        }
    }

    public static DisplayMetrics j(Context context) {
        return context == null ? null : context.getResources().getDisplayMetrics();
    }

    private static boolean j() {
        String externalStorageState = Environment.getExternalStorageState();
        return "mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState);
    }

    public static String k(Context context) {
        String str = null;
        if (context == null) {
            return null;
        }
        if (DeviceConfig.checkPermission(context, "android.permission.READ_PHONE_STATE")) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                str = telephonyManager.getSubscriberId();
            }
        }
        return str;
    }

    public static String l(Context context) {
        String str = null;
        if (context == null) {
            return null;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return null;
        }
        if (DeviceConfig.checkPermission(context, "android.permission.READ_PHONE_STATE") && telephonyManager != null) {
            if (VERSION.SDK_INT < 26) {
                str = telephonyManager.getDeviceId();
            } else {
                try {
                    String t = t(context);
                    try {
                        if (TextUtils.isEmpty(t)) {
                            str = telephonyManager.getDeviceId();
                        }
                    } catch (Throwable unused) {
                    }
                    str = t;
                } catch (Throwable unused2) {
                }
            }
        }
        return str;
    }

    public static List<InputMethodInfo> m(Context context) {
        if (context == null) {
            return null;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        return inputMethodManager == null ? null : inputMethodManager.getInputMethodList();
    }

    public static void n(Context context) {
        if (context != null) {
            try {
                if (DeviceConfig.checkPermission(context, "android.permission.BLUETOOTH")) {
                    BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                    b bVar = new b();
                    if (defaultAdapter.isEnabled()) {
                        bVar.b = defaultAdapter.getState();
                        if (VERSION.SDK_INT < 23) {
                            bVar.a = defaultAdapter.getAddress();
                        } else {
                            bVar.a = a(defaultAdapter);
                        }
                        bVar.c = defaultAdapter.getName();
                        UMWorkDispatch.sendEvent(context, 32773, com.umeng.commonsdk.internal.b.a(context).a(), bVar);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public static JSONObject o(Context context) {
        return context == null ? null : f.a(context);
    }

    public static List<a> p(Context context) {
        if (context == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Environment.getExternalStorageDirectory());
            stringBuilder.append("/Android/data/");
            File file = new File(stringBuilder.toString());
            if (file != null && file.isDirectory()) {
                String[] list = file.list();
                if (list != null && list.length > 0) {
                    for (String str : list) {
                        if (!(str == null || str.startsWith("."))) {
                            a aVar = new a();
                            aVar.a = str;
                            aVar.b = e(context, str);
                            arrayList.add(aVar);
                        }
                    }
                }
            }
        } catch (Exception e) {
            if (e != null) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("getAppList:");
                stringBuilder2.append(e.getMessage());
                ULog.e(stringBuilder2.toString());
            }
        }
        return arrayList;
    }

    public static MemoryInfo q(Context context) {
        if (context == null) {
            return null;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return null;
        }
        MemoryInfo memoryInfo = new MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo;
    }

    public static String r(Context context) {
        return context == null ? null : null;
    }

    public static String s(Context context) {
        return null;
    }

    private static String t(Context context) {
        String str = null;
        if (context == null) {
            return null;
        }
        try {
            Object invoke = Class.forName("android.telephony.TelephonyManager").getMethod("getMeid", new Class[0]).invoke(null, new Object[0]);
            if (invoke != null && (invoke instanceof String)) {
                str = (String) invoke;
            }
        } catch (Exception e) {
            if (e != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("meid:");
                stringBuilder.append(e.getMessage());
                ULog.e(stringBuilder.toString());
            }
        }
        return str;
    }
}
