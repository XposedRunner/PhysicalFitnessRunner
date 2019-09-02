package com.qiyukf.basesdk.b.a.b.d;

import cn.jiguang.net.HttpUtils;
import com.qiyukf.basesdk.a.a;
import com.qiyukf.basesdk.b.a.b.e.c;

public class b {
    private static final String a = c.a(b.class);

    public static String a(String str) {
        String str2 = a;
        StringBuilder stringBuilder = new StringBuilder("query lbs url: ");
        stringBuilder.append(str);
        a.d(str2, stringBuilder.toString());
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str);
        stringBuilder2.append("?version=1.0");
        return stringBuilder2.toString();
    }

    public static String a(String str, String str2, String str3, String str4) {
        if (str4 != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str2);
            stringBuilder.append(HttpUtils.PATHS_SEPARATOR);
            stringBuilder.append(str3);
            stringBuilder.append("?uploadContext&version=1.0&context=");
            stringBuilder.append(str4);
            str2 = stringBuilder.toString();
        } else {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str2);
            stringBuilder2.append(HttpUtils.PATHS_SEPARATOR);
            stringBuilder2.append(str3);
            stringBuilder2.append("?uploadContext&version=1.0");
            str2 = stringBuilder2.toString();
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(str);
        stringBuilder3.append(HttpUtils.PATHS_SEPARATOR);
        stringBuilder3.append(str2);
        return stringBuilder3.toString();
    }

    public static String a(String str, String str2, String str3, String str4, long j, boolean z) {
        StringBuilder stringBuilder;
        if (str4 != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str2);
            stringBuilder2.append(HttpUtils.PATHS_SEPARATOR);
            stringBuilder2.append(str3);
            stringBuilder2.append("?version=1.0&context=");
            stringBuilder2.append(str4);
            stringBuilder2.append("&offset=");
            stringBuilder2.append(j);
            stringBuilder2.append("&complete=");
            stringBuilder2.append(z);
            str2 = stringBuilder2.toString();
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str2);
            stringBuilder.append(HttpUtils.PATHS_SEPARATOR);
            stringBuilder.append(str3);
            stringBuilder.append("?version=1.0&offset=");
            stringBuilder.append(j);
            stringBuilder.append("&complete=");
            stringBuilder.append(z);
            str2 = stringBuilder.toString();
        }
        str3 = a;
        stringBuilder = new StringBuilder("post data url server: ");
        stringBuilder.append(str);
        stringBuilder.append(", query string: ");
        stringBuilder.append(str2);
        a.d(str3, stringBuilder.toString());
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(str);
        stringBuilder3.append(HttpUtils.PATHS_SEPARATOR);
        stringBuilder3.append(str2);
        return stringBuilder3.toString();
    }
}
