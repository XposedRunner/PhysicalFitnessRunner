package com.baidu.mapapi.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class OpenClientUtil {
    public static int getBaiduMapVersion(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            String str = context.getPackageManager().getPackageInfo("com.baidu.BaiduMap", 0).versionName;
            return (str == null || str.length() <= 0) ? 0 : Integer.valueOf(str.trim().replace(".", "").trim()).intValue();
        } catch (Exception unused) {
        }
        return 0;
    }

    public static void getLatestBaiduMapApp(Context context) {
        if (context != null) {
            String b = b.b(context);
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("http://map.baidu.com/zt/client/index/?fr=sdk_[");
            stringBuilder.append(b);
            stringBuilder.append("]");
            intent.setData(Uri.parse(stringBuilder.toString()));
            context.startActivity(intent);
        }
    }
}
