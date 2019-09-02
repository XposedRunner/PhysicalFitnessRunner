package com.baidu.mapsdkvi;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Environment;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.StatFs;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.telephony.CellLocation;
import android.telephony.PhoneNumberUtils;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.webkit.MimeTypeMap;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class VDeviceAPI {
    private static WakeLock a;
    private static BroadcastReceiver b;

    public static String getAppVersion() {
        try {
            return b.a().getPackageManager().getPackageInfo(b.a().getApplicationInfo().packageName, 0).versionName;
        } catch (NameNotFoundException unused) {
            return null;
        }
    }

    public static long getAvailableMemory() {
        ActivityManager activityManager = (ActivityManager) b.a().getSystemService("activity");
        MemoryInfo memoryInfo = new MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.availMem / 1024;
    }

    public static String getCachePath() {
        return Environment.getDataDirectory().getAbsolutePath();
    }

    public static String getCellId() {
        TelephonyManager telephonyManager = (TelephonyManager) b.a().getSystemService("phone");
        if (telephonyManager == null) {
            return null;
        }
        CellLocation cellLocation = telephonyManager.getCellLocation();
        if (!(cellLocation instanceof GsmCellLocation)) {
            return " ";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" ");
        stringBuilder.append(((GsmCellLocation) cellLocation).getCid());
        return stringBuilder.toString();
    }

    public static int getCurrentNetworkType() {
        NetworkInfo activeNetworkInfo;
        try {
            activeNetworkInfo = ((ConnectivityManager) b.a().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception unused) {
            activeNetworkInfo = null;
        }
        if (activeNetworkInfo == null) {
            return 0;
        }
        switch (activeNetworkInfo.getType()) {
            case 0:
                return 3;
            case 1:
                return 2;
            default:
                return 1;
        }
    }

    public static long getFreeSpace() {
        StatFs statFs = new StatFs(Environment.getRootDirectory().getPath());
        return (((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks())) / 1024;
    }

    public static String getImei() {
        TelephonyManager telephonyManager = (TelephonyManager) b.a().getSystemService("phone");
        return telephonyManager != null ? telephonyManager.getDeviceId() : null;
    }

    public static String getImsi() {
        TelephonyManager telephonyManager = (TelephonyManager) b.a().getSystemService("phone");
        return telephonyManager != null ? telephonyManager.getSubscriberId() : null;
    }

    public static String getLac() {
        TelephonyManager telephonyManager = (TelephonyManager) b.a().getSystemService("phone");
        if (telephonyManager == null) {
            return null;
        }
        CellLocation cellLocation = telephonyManager.getCellLocation();
        if (!(cellLocation instanceof GsmCellLocation)) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(((GsmCellLocation) cellLocation).getLac());
        return stringBuilder.toString();
    }

    public static String getModuleFileName() {
        return b.a().getFilesDir().getAbsolutePath();
    }

    public static c getNetworkInfo(int i) {
        NetworkInfo networkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) b.a().getSystemService("connectivity");
        switch (i) {
            case 2:
                i = 1;
                break;
            case 3:
                i = 0;
                break;
            default:
                networkInfo = null;
                break;
        }
        networkInfo = connectivityManager.getNetworkInfo(i);
        return networkInfo != null ? new c(networkInfo) : null;
    }

    public static String getOsVersion() {
        return "android";
    }

    public static int getScreenBrightness() {
        int i;
        ContentResolver contentResolver = b.a().getContentResolver();
        try {
            i = System.getInt(contentResolver, "screen_brightness_mode");
        } catch (SettingNotFoundException unused) {
            i = 0;
        }
        if (i == 1) {
            return -1;
        }
        try {
            return System.getInt(contentResolver, "screen_brightness");
        } catch (SettingNotFoundException unused2) {
            return -1;
        }
    }

    public static float getScreenDensity() {
        if (b.a() == null) {
            return 0.0f;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) b.a().getSystemService("window");
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics.density;
    }

    public static int getScreenDensityDpi() {
        if (b.a() == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) b.a().getSystemService("window");
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics.densityDpi;
    }

    public static long getSdcardFreeSpace() {
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return (((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks())) / 1024;
    }

    public static String getSdcardPath() {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        return externalStorageDirectory != null ? externalStorageDirectory.getAbsolutePath() : null;
    }

    public static long getSdcardTotalSpace() {
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return (((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount())) / 1024;
    }

    public static float getSystemMetricsX() {
        if (b.a() == null) {
            return 0.0f;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) b.a().getSystemService("window");
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return (float) displayMetrics.widthPixels;
    }

    public static float getSystemMetricsY() {
        if (b.a() == null) {
            return 0.0f;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) b.a().getSystemService("window");
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return (float) displayMetrics.heightPixels;
    }

    public static long getTotalMemory() {
        long j = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                j = (long) Integer.valueOf(readLine.split("\\s+")[1]).intValue();
            }
            bufferedReader.close();
        } catch (IOException unused) {
        }
        return j;
    }

    public static long getTotalSpace() {
        StatFs statFs = new StatFs(Environment.getRootDirectory().getPath());
        return (((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount())) / 1024;
    }

    public static ScanResult[] getWifiHotpot() {
        List scanResults = ((WifiManager) b.a().getSystemService("wifi")).getScanResults();
        return (ScanResult[]) scanResults.toArray(new ScanResult[scanResults.size()]);
    }

    public static boolean isWifiConnected() {
        NetworkInfo networkInfo = ((ConnectivityManager) b.a().getSystemService("connectivity")).getNetworkInfo(1);
        return networkInfo == null ? false : networkInfo.isConnected();
    }

    public static void makeCall(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("tel:");
        stringBuilder.append(str);
        b.a().startActivity(new Intent("android.intent.action.DIAL", Uri.parse(stringBuilder.toString())));
    }

    public static native void onNetworkStateChanged();

    public static void openUrl(String str) {
        b.a().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    public static int sendMMS(String str, String str2, String str3, String str4) {
        if (!PhoneNumberUtils.isWellFormedSmsAddress(str)) {
            return 1;
        }
        try {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(Uri.fromFile(new File(str4)).toString()));
            Intent intent = new Intent("android.intent.action.SEND");
            intent.putExtra("address", str);
            intent.putExtra("subject", str2);
            intent.putExtra("sms_body", str3);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("file://");
            stringBuilder.append(str4);
            intent.putExtra("android.intent.extra.STREAM", Uri.parse(stringBuilder.toString()));
            intent.setType(mimeTypeFromExtension);
            b.a().startActivity(intent);
            return 0;
        } catch (Exception unused) {
            return 2;
        }
    }

    public static void sendSMS(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("smsto:");
        stringBuilder.append(str);
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse(stringBuilder.toString()));
        intent.putExtra("sms_body", str2);
        b.a().startActivity(intent);
    }

    public static void setNetworkChangedCallback() {
        unsetNetworkChangedCallback();
        b = new a();
        b.a().registerReceiver(b, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public static void setScreenAlwaysOn(boolean z) {
        if (z) {
            if (a == null) {
                a = ((PowerManager) b.a().getSystemService("power")).newWakeLock(10, "VDeviceAPI");
            }
            a.acquire();
            return;
        }
        if (a != null && a.isHeld()) {
            a.release();
            a = null;
        }
    }

    public static void setupSoftware(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(new File(str)), "application/vnd.android.package-archive");
        b.a().startActivity(intent);
    }

    public static void unsetNetworkChangedCallback() {
        if (b != null) {
            b.a().unregisterReceiver(b);
            b = null;
        }
    }
}
