package com.ximalaya.ting.android.opensdk.auth.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import defpackage.db;

/* compiled from: DeviceUtil */
public final class a {
    private static String a;

    public static String a(Context context) {
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        if (TextUtils.isEmpty(a)) {
            try {
                a = Secure.getString(context.getContentResolver(), db.O000000o);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return a;
    }

    public static String a(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 0));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @SuppressLint({"NewApi"})
    private static String b(Context context) throws Exception {
        String str = VERSION.SDK_INT > 9 ? Build.SERIAL : null;
        if (str == null || str.equalsIgnoreCase("unknown")) {
            str = Secure.getString(context.getContentResolver(), db.O000000o);
            if (str == null || str.equalsIgnoreCase(db.O000000o) || str.equalsIgnoreCase("9774d56d682e549c")) {
                throw new Exception("FATAL!!!! - This device doesn't have a UNIQUE Serial Number");
            }
        }
        return str;
    }

    public static boolean b(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            packageInfo = null;
        }
        return packageInfo != null;
    }
}
