package com.geetest.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.support.v4.content.ContextCompat;
import android.support.v4.os.EnvironmentCompat;
import android.telephony.TelephonyManager;

/* compiled from: DeviceUtils */
public final class O0OoOo {
    public static String O000000o(Context context) {
        if (context == null) {
            return EnvironmentCompat.MEDIA_UNKNOWN;
        }
        try {
            if (ContextCompat.checkSelfPermission(context, "android.permission.READ_PHONE_STATE") != 0) {
                return EnvironmentCompat.MEDIA_UNKNOWN;
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return telephonyManager != null ? telephonyManager.getDeviceId() == null ? EnvironmentCompat.MEDIA_UNKNOWN : telephonyManager.getDeviceId() : EnvironmentCompat.MEDIA_UNKNOWN;
        } catch (Exception e) {
            e.printStackTrace();
            return EnvironmentCompat.MEDIA_UNKNOWN;
        }
    }

    public static int O00000Oo(Context context) {
        if (context == null) {
            return 0;
        }
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (NameNotFoundException unused) {
            packageInfo = null;
        }
        return (packageInfo == null || packageInfo.versionCode == 0) ? 0 : packageInfo.versionCode;
    }

    public static String O00000o0(Context context) {
        if (context == null) {
            return EnvironmentCompat.MEDIA_UNKNOWN;
        }
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (NameNotFoundException unused) {
            packageInfo = null;
        }
        return packageInfo != null ? packageInfo.packageName == null ? EnvironmentCompat.MEDIA_UNKNOWN : packageInfo.packageName : EnvironmentCompat.MEDIA_UNKNOWN;
    }
}
