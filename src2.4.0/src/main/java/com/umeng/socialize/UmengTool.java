package com.umeng.socialize;

import android.annotation.TargetApi;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.socialize.utils.O00000Oo;
import com.umeng.socialize.utils.O0000O0o;
import com.umeng.socialize.utils.O0000o00;
import com.umeng.socialize.utils.O0000o00.O00000o0;
import com.umeng.socialize.utils.O0000o00.O000O0OO;
import com.umeng.socialize.utils.O0000o00.O00oOooO;
import defpackage.by;

public class UmengTool {
    public static void checkAlipay(Context context) {
        String packageName = context.getPackageName();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(packageName);
        stringBuilder.append(".apshare.ShareEntryActivity");
        stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(packageName);
        stringBuilder.append(".apshare.ShareEntryActivity");
        if (UMUtils.checkPath(stringBuilder.toString())) {
            O0000O0o.O000000o(O00000o0.O0000OoO);
        } else {
            O0000O0o.O000000o(O00000o0.O0000Oo);
        }
    }

    @TargetApi(9)
    public static String checkFBByself(Context context) {
        return !UMUtils.checkAndroidManifest(context, "com.umeng.facebook.FacebookActivity") ? O0000o00.O0000O0o.O00000oO : !UMUtils.checkMetaData(context, "com.facebook.sdk.ApplicationId") ? O0000o00.O0000O0o.O0000O0o : !UMUtils.checkResource(context, "facebook_app_id", "string") ? O0000o00.O0000O0o.O0000OOo : O00000o0.O000000o(UMUtils.getAppHashKey(context), O00000Oo.O00000Oo());
    }

    public static void checkFacebook(Context context) {
        showDialog(context, checkFBByself(context));
    }

    public static String checkKakao(Context context) {
        String packageName = context.getPackageName();
        context.getPackageManager();
        if (TextUtils.isEmpty(packageName)) {
            return "包名为空";
        }
        try {
            context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("kakao 配置正确，请检查kakao后台签名:");
            stringBuilder.append(UMUtils.getAppHashKey(context));
            return stringBuilder.toString();
        } catch (NameNotFoundException unused) {
            return "签名获取失败";
        }
    }

    public static String checkLinkin(Context context) {
        String packageName = context.getPackageName();
        context.getPackageManager();
        if (TextUtils.isEmpty(packageName)) {
            return "包名为空";
        }
        try {
            context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("领英 配置正确，请检查领英后台签名:");
            stringBuilder.append(UMUtils.getAppHashKey(context));
            return stringBuilder.toString();
        } catch (NameNotFoundException unused) {
            return "签名获取失败";
        }
    }

    public static void checkQQ(Context context) {
        showDialog(context, checkQQByself(context));
    }

    public static String checkQQByself(Context context) {
        String str = "com.tencent.tauth.AuthActivity";
        String str2 = "com.tencent.connect.common.AssistActivity";
        return !UMUtils.checkAndroidManifest(context, str) ? O0000o00.O0000o00.O000000o(str) : !UMUtils.checkAndroidManifest(context, str2) ? O0000o00.O0000o00.O000000o(str2) : !UMUtils.checkPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE") ? O0000o00.O0000o00.O0000o0O : !UMUtils.checkIntentFilterData(context, ((PlatformConfig$APPIDPlatform) PlatformConfig.getPlatform(by.QQ)).appId) ? O0000o00.O0000o00.O0000o00 : "qq配置正确";
    }

    public static void checkSina(Context context) {
        showDialog(context, checkSinaBySelf(context));
    }

    public static String checkSinaBySelf(Context context) {
        return !UMUtils.checkAndroidManifest(context, "com.umeng.socialize.media.WBShareCallBackActivity") ? O00oOooO.O0000OOo : !UMUtils.checkAndroidManifest(context, "com.sina.weibo.sdk.web.WeiboSdkWebActivity") ? O00oOooO.O0000Oo0 : !UMUtils.checkAndroidManifest(context, "com.sina.weibo.sdk.share.WbShareTransActivity") ? O00oOooO.O0000Oo : O00000o0.O000000o(UMUtils.getAppMD5Signature(context).toLowerCase(), context.getPackageName());
    }

    public static void checkVK(Context context) {
        showDialog(context, checkVKByself(context));
    }

    public static String checkVKByself(Context context) {
        context.getPackageName();
        String appSHA1Key = UMUtils.getAppSHA1Key(context);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("你使用的签名：");
        stringBuilder.append(appSHA1Key.replace(":", ""));
        return stringBuilder.toString();
    }

    public static void checkWx(Context context) {
        showDialog(context, checkWxBySelf(context));
    }

    public static String checkWxBySelf(Context context) {
        String packageName = context.getPackageName();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(packageName);
        stringBuilder.append(".wxapi.WXEntryActivity");
        String stringBuilder2 = stringBuilder.toString();
        if (!UMUtils.checkPath(stringBuilder2)) {
            return O000O0OO.O0000OoO;
        }
        return UMUtils.checkAndroidManifest(context, stringBuilder2) ? O00000o0.O000000o(UMUtils.getAppMD5Signature(context).toLowerCase(), packageName) : O000O0OO.O0000Ooo;
    }

    public static void getSignature(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("包名：");
        stringBuilder.append(O00000Oo.O00000Oo());
        stringBuilder.append("\n");
        stringBuilder.append("签名:");
        stringBuilder.append(UMUtils.getAppMD5Signature(context));
        stringBuilder.append("\n");
        stringBuilder.append("facebook keyhash:");
        stringBuilder.append(UMUtils.getAppHashKey(context));
        showDialog(context, stringBuilder.toString());
    }

    public static String getStrRedicrectUrl() {
        return ((PlatformConfig$APPIDPlatform) PlatformConfig.configs.get(by.SINA)).redirectUrl;
    }

    public static void showDialog(Context context, String str) {
        new Builder(context).setTitle("友盟Debug模式自检").setMessage(str).setPositiveButton("关闭", null).show();
    }
}
