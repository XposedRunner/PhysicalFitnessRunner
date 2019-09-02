package com.baidu.mapapi.common;

import android.content.Context;
import com.baidu.mapsdkplatform.comapi.util.g;
import java.io.File;

public class EnvironmentUtilities {
    static String a;
    static String b;
    static String c;
    static int d;
    static int e;
    static int f;
    private static g g;

    public static String getAppCachePath() {
        return b;
    }

    public static String getAppSDCardPath() {
        String str = a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("/BaiduMapSDKNew");
        str = stringBuilder.toString();
        if (str.length() != 0) {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return str;
    }

    public static String getAppSecondCachePath() {
        return c;
    }

    public static int getDomTmpStgMax() {
        return e;
    }

    public static int getItsTmpStgMax() {
        return f;
    }

    public static int getMapTmpStgMax() {
        return d;
    }

    public static String getSDCardPath() {
        return a;
    }

    public static void initAppDirectory(Context context) {
        String c;
        if (g == null) {
            g = g.a();
            g.a(context);
        }
        if (a == null || a.length() <= 0) {
            a = g.b().a();
            c = g.b().c();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append(File.separator);
            stringBuilder.append("BaiduMapSDKNew");
            stringBuilder.append(File.separator);
            stringBuilder.append("cache");
            c = stringBuilder.toString();
        }
        b = c;
        c = g.b().d();
        d = 20971520;
        e = 52428800;
        f = 5242880;
    }

    public static void setSDCardPath(String str) {
        a = str;
    }
}
