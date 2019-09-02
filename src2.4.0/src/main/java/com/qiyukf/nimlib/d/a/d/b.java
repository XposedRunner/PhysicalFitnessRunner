package com.qiyukf.nimlib.d.a.d;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;

public final class b {
    public static boolean a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null && packageManager.checkPermission(str, context.getApplicationInfo().packageName) == 0) {
            return true;
        }
        return false;
    }
}
