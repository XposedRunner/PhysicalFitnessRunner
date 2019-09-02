package com.qiyukf.unicorn.f.b;

import android.text.TextUtils;
import cn.jiguang.net.HttpUtils;
import com.qiyukf.basesdk.b.a.c.b;
import com.qiyukf.nimlib.b.d;
import com.tencent.connect.common.Constants;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Map.Entry;

public final class a {
    public static String a() {
        int a = d.a();
        return a == 1 ? "http://qytest.netease.com" : a == 2 ? "http://qiyukf.netease.com" : "https://qy-swallow.qiyukf.com";
    }

    public static String a(String str, String str2, Map<String, String> map) {
        try {
            return b.b(c(str, str2, map), Constants.HTTP_GET, "Common");
        } catch (IOException e) {
            throw new b("get request error", e);
        }
    }

    public static String a(String str, String str2, Map<String, String> map, Map<String, String> map2) {
        str = c(str, str2, map);
        try {
            HttpURLConnection a = b.a(str, Constants.HTTP_POST, "Common");
            b.a(a, "charset", HttpUtils.ENCODING_UTF_8);
            b.a(a, "Content-Type", "application/x-www-form-urlencoded");
            StringBuilder stringBuilder = new StringBuilder();
            for (Entry entry : map2.entrySet()) {
                if (!(TextUtils.isEmpty((CharSequence) entry.getKey()) || TextUtils.isEmpty((CharSequence) entry.getValue()))) {
                    if (stringBuilder.length() > 0) {
                        stringBuilder.append(HttpUtils.PARAMETERS_SEPARATOR);
                    }
                    stringBuilder.append((String) entry.getKey());
                    stringBuilder.append(HttpUtils.EQUAL_SIGN);
                    stringBuilder.append(URLEncoder.encode((String) entry.getValue()));
                }
            }
            b.a(a, stringBuilder.toString().getBytes(HttpUtils.ENCODING_UTF_8));
            int responseCode = a.getResponseCode();
            if (responseCode == 200) {
                return b.a(a.getInputStream());
            }
            stringBuilder = new StringBuilder("query url: ");
            stringBuilder.append(str);
            stringBuilder.append("failed: ");
            stringBuilder.append(responseCode);
            com.qiyukf.basesdk.a.a.a("HttpUtil", stringBuilder.toString());
            return null;
        } catch (IOException e) {
            throw new b("post form data error", e);
        }
    }

    public static String a(String str, Map<String, String> map) {
        return a(b(), str, map);
    }

    private static String b() {
        int a = d.a();
        return a == 1 ? "http://qytest.netease.com" : a == 2 ? "http://qiyukf.netease.com" : a == 3 ? "http://qydev.netease.com" : "https://nim.qiyukf.com";
    }

    private static String b(String str, String str2, Map<String, String> map) {
        try {
            return b.b(c(str, str2, map), Constants.HTTP_POST, "Common");
        } catch (IOException e) {
            throw new b("post request error", e);
        }
    }

    public static String b(String str, Map<String, String> map) {
        return b(b(), str, map);
    }

    private static String c(String str, String str2, Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(str2);
        str = stringBuilder.toString();
        if (map != null) {
            int i = 0;
            for (Entry entry : map.entrySet()) {
                if (!(TextUtils.isEmpty((CharSequence) entry.getKey()) || TextUtils.isEmpty((CharSequence) entry.getValue()))) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(str);
                    stringBuilder2.append(i == 0 ? HttpUtils.URL_AND_PARA_SEPARATOR : HttpUtils.PARAMETERS_SEPARATOR);
                    str = stringBuilder2.toString();
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(str);
                    stringBuilder2.append((String) entry.getKey());
                    stringBuilder2.append(HttpUtils.EQUAL_SIGN);
                    stringBuilder2.append(URLEncoder.encode((String) entry.getValue()));
                    str = stringBuilder2.toString();
                    i++;
                }
            }
        }
        StringBuilder stringBuilder3 = new StringBuilder("http request: ");
        stringBuilder3.append(str);
        com.qiyukf.basesdk.a.a.b("test", stringBuilder3.toString());
        return str;
    }
}
