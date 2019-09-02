package com.sina.weibo.sdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.WbAppInfo;
import com.sina.weibo.sdk.utils.AidTask;
import java.util.List;

public class WbSdk {
    private static AuthInfo authInfo;
    private static boolean init;

    public static void checkInit() {
        if (!init) {
            throw new RuntimeException("weibo sdk was not initall! please use: WbSdk.install() in your app Application or your main Activity. when you want to use weibo sdk function, make sure call WbSdk.install() before this function");
        }
    }

    public static AuthInfo getAuthInfo() {
        checkInit();
        return authInfo;
    }

    public static void install(Context context, AuthInfo authInfo) {
        if (!init) {
            if (authInfo == null || TextUtils.isEmpty(authInfo.getAppKey()) || TextUtils.isEmpty(authInfo.getRedirectUrl())) {
                throw new RuntimeException("please set right app info (appKey,redirect");
            }
            authInfo = authInfo;
            AidTask.getInstance(context).aidTaskInit(authInfo.getAppKey());
            init = true;
        }
    }

    public static boolean isWbInstall(Context context) {
        Intent intent = new Intent(WeiboAppManager.WEIBO_IDENTITY_ACTION);
        intent.addCategory("android.intent.category.DEFAULT");
        List queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        return (queryIntentServices == null || queryIntentServices.isEmpty()) ? false : true;
    }

    public static boolean supportMultiImage(Context context) {
        if (!isWbInstall(context)) {
            return false;
        }
        WbAppInfo wbAppInfo = WeiboAppManager.getInstance(context).getWbAppInfo();
        return wbAppInfo != null && wbAppInfo.getSupportVersion() >= ApiUtils.STORY_INT_VER;
    }
}
