package com.qiyukf.unicorn.f;

import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import cn.jiguang.net.HttpUtils;
import com.qiyukf.nimlib.b.d;
import com.qiyukf.nimlib.sdk.auth.LoginInfo;
import com.qiyukf.unicorn.f.b.a;
import com.qiyukf.unicorn.f.b.b;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.statistic.LogBuilder;
import com.sina.weibo.sdk.web.WebPicUploadResult;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONObject;

public final class c {
    public static int a(String str) {
        int i;
        int a = d.a();
        String str2 = a == 1 ? "http://da.ysf.space" : a == 2 ? "http://da.qiyukf.netease.com" : "https://da.qiyukf.com";
        String d = com.qiyukf.unicorn.d.d();
        String packageName = com.qiyukf.unicorn.d.c().getPackageName();
        try {
            a.a(str2, String.format(Locale.getDefault(), "%s?ak=%s&bid=%s&r=%s", new Object[]{"/mobileda/da.gif", d, packageName, str}), null);
            i = 200;
        } catch (b e) {
            i = e.a();
        }
        StringBuilder stringBuilder = new StringBuilder("upload records, code = ");
        stringBuilder.append(i);
        com.qiyukf.basesdk.a.a.d("YSFClient", stringBuilder.toString());
        return i;
    }

    public static int a(String str, String str2, String str3, String str4, int i, long j) {
        Object str42;
        String a = a.a();
        String str5 = "/swallow/log";
        HashMap hashMap = new HashMap();
        String str6 = "android";
        hashMap.put("terminal", str6);
        StringBuilder stringBuilder = new StringBuilder("sdk_");
        stringBuilder.append(str);
        str = stringBuilder.toString();
        hashMap.put("version", str);
        stringBuilder = new StringBuilder();
        stringBuilder.append(Build.BRAND);
        stringBuilder.append(HttpUtils.PATHS_SEPARATOR);
        stringBuilder.append(Build.MODEL);
        stringBuilder.append(HttpUtils.PATHS_SEPARATOR);
        stringBuilder.append(VERSION.RELEASE);
        hashMap.put("platform", stringBuilder.toString());
        hashMap.put("type", str2);
        Object substring = (TextUtils.isEmpty(str3) || !str3.contains("\n")) ? str3 : str3.substring(0, str3.indexOf("\n"));
        hashMap.put("identity", substring);
        String g = com.qiyukf.nimlib.b.g();
        hashMap.put(LogBuilder.KEY_APPKEY, g);
        String str7 = "clientid";
        Object b = com.qiyukf.nimlib.b.b();
        if (TextUtils.isEmpty(b) && com.qiyukf.nimlib.b.a() != null) {
            String string = Secure.getString(com.qiyukf.nimlib.b.a().getContentResolver(), "android_id");
            StringBuilder stringBuilder2 = new StringBuilder("ANDROID_ID_");
            stringBuilder2.append(string);
            b = stringBuilder2.toString();
        }
        if (TextUtils.isEmpty(b)) {
            b = "ANONYMOUS";
        }
        hashMap.put(str7, b);
        hashMap.put("level", "ERROR");
        str7 = "message";
        if (TextUtils.isEmpty(str42)) {
            str42 = "EMPTY_MESSAGE";
        }
        hashMap.put(str7, str42);
        hashMap.put("attachment", str3);
        JSONObject jSONObject = new JSONObject();
        com.qiyukf.basesdk.c.b.a(jSONObject, "count", i);
        com.qiyukf.basesdk.c.b.a(jSONObject, "time", j);
        hashMap.put("extra", jSONObject.toString());
        long currentTimeMillis = System.currentTimeMillis();
        hashMap.put("timestamp", String.valueOf(currentTimeMillis));
        StringBuilder stringBuilder3 = new StringBuilder("ysf");
        stringBuilder3.append(str6);
        stringBuilder3.append(str);
        stringBuilder3.append(str2);
        stringBuilder3.append(g);
        stringBuilder3.append(currentTimeMillis);
        stringBuilder3.append("qykf");
        hashMap.put("sign", com.qiyukf.basesdk.c.c.c.a(stringBuilder3.toString()));
        try {
            return com.qiyukf.basesdk.c.b.b(com.qiyukf.basesdk.c.b.a(a.a(a, str5, new HashMap(), hashMap)), WebPicUploadResult.RESP_UPLOAD_PIC_PARAM_CODE);
        } catch (b e) {
            return e.a();
        }
    }

    public static b a(String str, String str2) {
        String str3 = "/webapi/user/create.action";
        HashMap hashMap = new HashMap(2);
        hashMap.put(LogBuilder.KEY_APPKEY, str);
        hashMap.put("deviceid", str2);
        try {
            JSONObject a = com.qiyukf.basesdk.c.b.a(a.b(str3, hashMap));
            b bVar = new b();
            int b = com.qiyukf.basesdk.c.b.b(a, WebPicUploadResult.RESP_UPLOAD_PIC_PARAM_CODE);
            if (b == 200) {
                a = com.qiyukf.basesdk.c.b.f(a, "info");
                com.qiyukf.basesdk.a.a.b("test", a.toString());
                bVar.a(new LoginInfo(a.getString("accid"), a.getString("token")));
                boolean z = true;
                if (com.qiyukf.basesdk.c.b.b(a, UMModuleRegister.PUSH) != 1) {
                    z = false;
                }
                bVar.a(z);
                com.qiyukf.unicorn.b.b.d(com.qiyukf.basesdk.c.b.e(a, "bid"));
                return bVar;
            }
            StringBuilder stringBuilder = new StringBuilder("fetch login data error, code: ");
            stringBuilder.append(b);
            com.qiyukf.basesdk.a.a.a("HTTP", stringBuilder.toString());
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static JSONObject a() {
        String str = "/swallow/config";
        HashMap hashMap = new HashMap();
        hashMap.put("t", "aos");
        hashMap.put("p", "sdk");
        try {
            return com.qiyukf.basesdk.c.b.a(a.a(a.a(), str, hashMap));
        } catch (b e) {
            e.printStackTrace();
            return null;
        }
    }

    public static JSONObject a(String str, String str2, long j, String str3, long j2, long j3) {
        String str4 = "/webapi/user/queryCount.action";
        HashMap hashMap = new HashMap(3);
        hashMap.put("time", String.valueOf(j));
        if (j2 <= 0 || j3 <= 0) {
            hashMap.put(WBConstants.SSO_APP_KEY, str);
            hashMap.put("nimId", str2);
            hashMap.put("pkg", str3);
        } else {
            hashMap.put("user", String.valueOf(j2));
            hashMap.put("app", String.valueOf(j3));
        }
        try {
            return com.qiyukf.basesdk.c.b.f(com.qiyukf.basesdk.c.b.a(a.b(str4, hashMap)), "result");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static JSONObject b() {
        String str = "/webapi/user/da/config";
        HashMap hashMap = new HashMap();
        hashMap.put("ak", com.qiyukf.unicorn.d.d());
        try {
            return com.qiyukf.basesdk.c.b.a(a.a(str, hashMap));
        } catch (b e) {
            e.printStackTrace();
            return null;
        }
    }
}
