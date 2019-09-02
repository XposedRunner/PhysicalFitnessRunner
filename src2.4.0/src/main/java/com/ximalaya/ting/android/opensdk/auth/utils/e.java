package com.ximalaya.ting.android.opensdk.auth.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.ximalaya.ting.android.opensdk.auth.constants.XmlyConstants;

/* compiled from: SecurityUtil */
public final class e {
    private static final int a = 118;

    public static boolean a(Context context, Intent intent) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 65536);
        if (resolveActivity == null) {
            return false;
        }
        try {
            return a(packageManager.getPackageInfo(resolveActivity.activityInfo.packageName, 64).signatures, "22a001357629de32518a24508149689f");
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        try {
            return a(packageManager.getPackageInfo(str, 64).signatures, "22a001357629de32518a24508149689f");
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean a(Signature[] signatureArr, String str) {
        if (signatureArr == null) {
            return false;
        }
        for (Signature toByteArray : signatureArr) {
            if (b.a(toByteArray.toByteArray()).equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static int b(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionCode;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private static boolean b(Context context, Intent intent) {
        String stringExtra = intent != null ? intent.getStringExtra(XmlyConstants.XMLY_TING_APP_PACKAGE_NAME) : null;
        return stringExtra != null && a(context, stringExtra);
    }

    private static boolean c(Context context, String str) {
        return b(context, str) >= 118;
    }
}
