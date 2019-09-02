package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import com.sina.weibo.sdk.ApiUtils;
import com.sina.weibo.sdk.auth.WbAppInfo;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.constant.WBConstants.Base;

public class SecurityHelper {
    public static boolean checkResponseAppLegal(Context context, WbAppInfo wbAppInfo, Intent intent) {
        if ((wbAppInfo != null && wbAppInfo.getSupportVersion() <= ApiUtils.BUILD_INT_VER_2_3) || wbAppInfo == null) {
            return true;
        }
        String stringExtra = intent != null ? intent.getStringExtra(Base.APP_PKG) : null;
        return (stringExtra == null || intent.getStringExtra(WBConstants.TRAN) == null || !ApiUtils.validateWeiboSign(context, stringExtra)) ? false : true;
    }

    public static boolean containSign(Signature[] signatureArr, String str) {
        if (signatureArr == null || str == null) {
            return false;
        }
        for (Signature toByteArray : signatureArr) {
            if (str.equals(MD5.hexdigest(toByteArray.toByteArray()))) {
                return true;
            }
        }
        return false;
    }

    public static boolean validateAppSignatureForIntent(Context context, Intent intent) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
        if (resolveActivity == null) {
            return false;
        }
        try {
            return containSign(packageManager.getPackageInfo(resolveActivity.activityInfo.packageName, 64).signatures, WBConstants.WEIBO_SIGN);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
