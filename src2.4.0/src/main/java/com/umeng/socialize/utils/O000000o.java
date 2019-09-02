package com.umeng.socialize.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import defpackage.db;
import java.util.List;

/* compiled from: CommonUtil */
public class O000000o {
    public static String O000000o(Context context) {
        return "";
    }

    public static boolean O000000o(Context context, String str) {
        try {
            context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), str), 0);
            return true;
        } catch (NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean O000000o(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, context.getPackageName()) > 0;
    }

    public static boolean O000000o(String str) {
        try {
            return Class.forName(str) != null;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static String O00000Oo(Context context) {
        return "";
    }

    public static boolean O00000Oo(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }

    public static boolean O00000o(Context context, String str) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            return (applicationInfo == null || applicationInfo.metaData.get(str) == null) ? false : true;
        } catch (NameNotFoundException unused) {
        }
        return false;
    }

    public static String O00000o0(Context context) {
        return "";
    }

    public static boolean O00000o0(Context context, String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addCategory("android.intent.category.BROWSABLE");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(db.O000Oo0O);
        stringBuilder.append(str);
        stringBuilder.append(":");
        intent.setData(Uri.parse(stringBuilder.toString()));
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 64);
        if (queryIntentActivities.size() <= 0) {
            return false;
        }
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            if (resolveInfo.activityInfo != null && resolveInfo.activityInfo.packageName.equals(context.getPackageName())) {
                return true;
            }
        }
        return false;
    }
}
