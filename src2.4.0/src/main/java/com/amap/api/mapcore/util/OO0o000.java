package com.amap.api.mapcore.util;

import android.content.Context;
import android.util.Log;
import cn.jiguang.net.HttpUtils;

/* compiled from: AuthLogUtil */
public class OO0o000 {
    static String O000000o;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 80; i++) {
            stringBuilder.append(HttpUtils.EQUAL_SIGN);
        }
        O000000o = stringBuilder.toString();
    }

    public static void O000000o() {
        O00000Oo(O000000o);
        O00000Oo("自6.6.0开始使用新版样式，旧版样式无法在新版接口setCustomMapStyle(CustomMapStyleOptions options)中使用，请到官网(lbs.amap.com)更新新版样式文件");
        O00000Oo(O000000o);
    }

    public static void O000000o(Context context) {
        String str = "鉴权失败，当前key没有自定义纹理和在线拉去样式的使用权限，自定义纹理和在线拉去样式相关内容，将不会呈现！";
        O00000Oo(O000000o);
        if (context != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("key:");
            stringBuilder.append(o0O0O0Oo.O00000oo(context));
            O000000o(stringBuilder.toString());
        }
        O00000Oo(str);
        O00000Oo(O000000o);
    }

    static void O000000o(String str) {
        int i = 0;
        if (str.length() < 78) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("|");
            stringBuilder.append(str);
            while (i < 78 - str.length()) {
                stringBuilder.append(" ");
                i++;
            }
            stringBuilder.append("|");
            O00000Oo(stringBuilder.toString());
            return;
        }
        String substring = str.substring(0, 78);
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("|");
        stringBuilder2.append(substring);
        stringBuilder2.append("|");
        O00000Oo(stringBuilder2.toString());
        O000000o(str.substring(78));
    }

    private static void O00000Oo(String str) {
        Log.i("authErrLog", str);
    }
}
