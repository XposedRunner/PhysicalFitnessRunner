package cn.jiguang.d.d;

import android.content.Context;
import cn.jiguang.e.c;

public final class ac {
    public static String a(Context context) {
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            if (str.length() > 30) {
                c.d("ServiceHelper", "The versionName is not valid, Please check your AndroidManifest.xml");
                str = str.substring(0, 30);
            }
            return str;
        } catch (Throwable unused) {
            return "Unknown";
        }
    }
}
