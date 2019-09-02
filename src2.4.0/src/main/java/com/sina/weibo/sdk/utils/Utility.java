package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.os.EnvironmentCompat;
import android.text.TextUtils;
import cn.jiguang.net.HttpUtils;
import com.sina.weibo.BuildConfig;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Locale;
import java.util.UUID;

public class Utility {
    private static final String DEFAULT_CHARSET = "UTF-8";

    public static Bundle decodeUrl(String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            for (String split : str.split(HttpUtils.PARAMETERS_SEPARATOR)) {
                String[] split2 = split.split(HttpUtils.EQUAL_SIGN);
                try {
                    bundle.putString(URLDecoder.decode(split2[0], "UTF-8"), URLDecoder.decode(split2[1], "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        return bundle;
    }

    public static String generateGUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String generateUAAid(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        String packageName = context.getPackageName();
        String str = "weibosdk";
        if (!TextUtils.isEmpty(packageName) && packageName.contains(BuildConfig.APPLICATION_ID)) {
            str = "weibo";
        }
        stringBuilder.append(Build.MANUFACTURER);
        stringBuilder.append("-");
        stringBuilder.append(Build.MODEL);
        stringBuilder.append("__");
        stringBuilder.append(str);
        stringBuilder.append("__");
        try {
            stringBuilder.append(WbSdkVersion.WEIBO_SDK_VERSION_CODE.replaceAll("\\s+", "_"));
        } catch (Exception unused) {
            stringBuilder.append(EnvironmentCompat.MEDIA_UNKNOWN);
        }
        stringBuilder.append("__");
        stringBuilder.append("android");
        stringBuilder.append("__android");
        stringBuilder.append(VERSION.RELEASE);
        return stringBuilder.toString();
    }

    public static String getAid(Context context, String str) {
        if (context == null) {
            return "";
        }
        AidTask instance = AidTask.getInstance(context);
        String loadAidFromCache = instance.loadAidFromCache();
        if (!TextUtils.isEmpty(loadAidFromCache)) {
            return loadAidFromCache;
        }
        instance.aidTaskInit(str);
        return "";
    }

    public static String getSign(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            for (Signature toByteArray : packageInfo.signatures) {
                byte[] toByteArray2 = toByteArray.toByteArray();
                if (toByteArray2 != null) {
                    return MD5.hexdigest(toByteArray2);
                }
            }
            return null;
        } catch (NameNotFoundException unused) {
            return null;
        } catch (Exception unused2) {
            return null;
        }
    }

    public static String getWeiBoVersion(Context context) throws NameNotFoundException {
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
        return packageInfo == null ? null : packageInfo.versionName;
    }

    public static boolean isChineseLocale(Context context) {
        try {
            Locale locale = context.getResources().getConfiguration().locale;
            return Locale.CHINA.equals(locale) || Locale.CHINESE.equals(locale) || Locale.SIMPLIFIED_CHINESE.equals(locale) || Locale.TAIWAN.equals(locale);
        } catch (Exception unused) {
            return true;
        }
    }

    public static Bundle parseUrl(String str) {
        try {
            URL url = new URL(str);
            Bundle decodeUrl = decodeUrl(url.getQuery());
            decodeUrl.putAll(decodeUrl(url.getRef()));
            return decodeUrl;
        } catch (MalformedURLException unused) {
            return new Bundle();
        }
    }

    public static String safeString(String str) {
        return TextUtils.isEmpty(str) ? "" : str;
    }
}
