package cn.jiguang.d.d;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import cn.jiguang.api.JCoreInterface;
import cn.jiguang.d.a.d;
import cn.jiguang.d.h.a.b;
import cn.jiguang.d.h.f;
import cn.jiguang.d.h.h;
import cn.jiguang.g.a;
import cn.jiguang.g.i;
import cn.jiguang.net.HttpUtils;
import cn.jpush.android.service.PushReceiver;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.statistic.LogBuilder;
import com.umeng.commonsdk.framework.c;
import defpackage.O0000Oo0;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.interfaces.RSAPublicKey;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.crypto.Cipher;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class x {
    public static JSONObject a = null;
    private static String b = "";
    private static String c = "/v3/report";

    public static int a(Context context, Set<String> set, JSONObject jSONObject, File file) {
        if (jSONObject != null) {
            try {
                if (jSONObject.length() == 0) {
                    return -1;
                }
                if (!a.d(context)) {
                    return -2;
                }
                String c;
                boolean equalsIgnoreCase = "CN".equalsIgnoreCase(cn.jiguang.d.a.f.a());
                LinkedHashSet<String> linkedHashSet = new LinkedHashSet();
                if (equalsIgnoreCase) {
                    Set<String> b = c.a().b(context).b((Set) set);
                    if (b != null) {
                        for (String str : b) {
                            if (!TextUtils.isEmpty(str)) {
                                linkedHashSet.add(str);
                            }
                        }
                    }
                }
                String str2 = "https://";
                String str3 = cn.jiguang.d.a.f.g();
                if (!TextUtils.isEmpty(str3)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(str2);
                    stringBuilder.append(str3);
                    linkedHashSet.add(stringBuilder.toString());
                }
                if (equalsIgnoreCase) {
                    c = d.c();
                    if (!TextUtils.isEmpty(c)) {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(str2);
                        stringBuilder2.append(c);
                        linkedHashSet.add(stringBuilder2.toString());
                    }
                }
                if (linkedHashSet.isEmpty()) {
                    return -1;
                }
                new StringBuilder(" type=").append(set);
                for (String c2 : linkedHashSet) {
                    if (!TextUtils.isEmpty(c2)) {
                        if (!c2.endsWith(c)) {
                            StringBuilder stringBuilder3 = new StringBuilder();
                            stringBuilder3.append(c2);
                            stringBuilder3.append(c);
                            c2 = stringBuilder3.toString();
                        }
                        int a = h.a(c2, jSONObject.toString(), context, true, 3, 1).a();
                        if (a == -3) {
                            p.a(context);
                            return -2;
                        } else if (a == 0) {
                            f.a(file);
                            return 0;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return -1;
    }

    public static String a(String str) {
        try {
            RSAPublicKey a = b.a("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCi0v4VEUhOdfIEfFCrPC72pcDsQF/luTmr4q34NY0EZYGKzfQuTrUAm916P52HCgF+342gjZ/Nvijts5543qYNyoLvgtu4NRcHJmuGI/w7qifhfsivYeoEj9wYphXOyB9HUjzwn1BtAih+1RyUrcErCi249yabUOIKQygPZ9OXXQIDAQAB");
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(1, a);
            return new String(Base64.encode(instance.doFinal(str.getBytes()), 2), HttpUtils.ENCODING_UTF_8);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String a(String str, String str2) {
        if (i.a(str)) {
            return null;
        }
        long c = d.c(null);
        if (c == 0) {
            return null;
        }
        String b = a.b(d.e(null));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c);
        stringBuilder.append(b);
        stringBuilder.append(str);
        str = a.c(stringBuilder.toString());
        if (i.a(str)) {
            return null;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(c);
        stringBuilder2.append(":");
        stringBuilder2.append(str);
        stringBuilder2.append(":");
        stringBuilder2.append(str2);
        try {
            return Base64.encodeToString(stringBuilder2.toString().getBytes(), 10);
        } catch (Exception unused) {
            return null;
        }
    }

    private static ArrayList<JSONArray> a(JSONArray jSONArray, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null || jSONArray.length() == 0) {
            return arrayList;
        }
        if (jSONArray.length() == 1) {
            arrayList.add(jSONArray);
            return arrayList;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i3 = 0;
        int i4 = 0;
        for (int length = jSONArray.length() - 1; length >= 0; length--) {
            JSONObject optJSONObject = jSONArray.optJSONObject(length);
            if (!(optJSONObject == null || optJSONObject.length() == 0)) {
                try {
                    int a = h.a(optJSONObject);
                    int i5 = i3 + a;
                    if (i5 > 204800) {
                        break;
                    }
                    int i6 = i4 + a;
                    if (i6 > 40960) {
                        if (jSONArray2.length() > 0) {
                            arrayList.add(jSONArray2);
                        }
                        JSONArray jSONArray3 = new JSONArray();
                        try {
                            jSONArray3.put(optJSONObject);
                            jSONArray2 = jSONArray3;
                        } catch (Exception unused) {
                            jSONArray2 = jSONArray3;
                        }
                    } else {
                        jSONArray2.put(optJSONObject);
                        a = i6;
                    }
                    i4 = a;
                    i3 = i5;
                } catch (Exception unused2) {
                    continue;
                }
            }
        }
        if (jSONArray2.length() > 0) {
            arrayList.add(jSONArray2);
        }
        return arrayList;
    }

    public static Set<String> a(JSONArray jSONArray) {
        HashSet hashSet = new HashSet();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                Object c = c(jSONArray.optJSONObject(i));
                if (c == null) {
                    c = "";
                }
                hashSet.add(c);
            }
        }
        return hashSet;
    }

    public static Set<String> a(JSONObject jSONObject) {
        return jSONObject == null ? new HashSet() : a(jSONObject.optJSONArray(c.a));
    }

    public static JSONObject a(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String b = f.b(f.a(context, str));
            return i.a(b) ? null : new JSONObject(b.trim());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static JSONObject a(Context context, JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("itime", JCoreInterface.getReportTime());
            jSONObject.put("type", str);
            jSONObject.put("account_id", d.m(context));
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    private static JSONObject a(JSONArray jSONArray, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(c.a, jSONArray);
        } catch (JSONException unused) {
        }
        h.a(jSONObject2, jSONObject);
        return jSONObject2;
    }

    public static void a(Context context) {
        p.b(context);
    }

    public static void a(Context context, int i) {
        if (a != null) {
            JSONObject jSONObject = a;
            if (i >= 204800) {
                f(context);
                return;
            }
            int length;
            int i2 = 0;
            try {
                length = jSONObject.toString().getBytes("utf-8").length;
            } catch (UnsupportedEncodingException unused) {
                length = 0;
            }
            i = (i + length) - 204800;
            if (i > 0) {
                JSONArray optJSONArray = jSONObject.optJSONArray(c.a);
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    try {
                        JSONArray jSONArray = new JSONArray();
                        int i3 = 0;
                        while (i2 < optJSONArray.length()) {
                            JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                            if (jSONObject2 != null) {
                                if (i3 >= i) {
                                    jSONArray.put(jSONObject2);
                                }
                                i3 += jSONObject2.toString().getBytes("utf-8").length;
                            }
                            i2++;
                        }
                        if (jSONArray.length() > 0) {
                            jSONObject.put(c.a, jSONArray);
                        } else {
                            jSONObject = null;
                        }
                        synchronized ("jpush_stat_cache_history.json") {
                            a = jSONObject;
                            a(context, "jpush_stat_cache_history.json", jSONObject);
                        }
                    } catch (UnsupportedEncodingException | JSONException unused2) {
                    }
                }
            }
        }
    }

    public static void a(Context context, JSONArray jSONArray) {
        try {
            p.b(context);
            if (jSONArray != null) {
                if (jSONArray.length() != 0) {
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i);
                        if (optJSONObject != null && optJSONObject.length() > 0) {
                            jSONArray2.put(optJSONObject);
                        }
                    }
                    jSONArray = jSONArray2;
                }
            }
            if (jSONArray != null && jSONArray.length() != 0) {
                JCoreInterface.execute("BUILD_REPORT", new y(jSONArray, context), 4);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, JSONObject jSONObject) {
        try {
            p.b(context);
            if (jSONObject != null && jSONObject.length() != 0) {
                JCoreInterface.execute("BUILD_REPORT", new z(jSONObject, context), 4);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Missing block: B:10:0x0033, code skipped:
            if (r4 != null) goto L_0x0011;
     */
    public static void a(android.content.Context r2, org.json.JSONObject r3, cn.jiguang.api.a r4) {
        /*
        if (r3 == 0) goto L_0x0036;
    L_0x0002:
        r0 = r3.length();	 Catch:{ Throwable -> 0x0036 }
        if (r0 <= 0) goto L_0x0036;
    L_0x0008:
        r0 = d(r2);	 Catch:{ Throwable -> 0x0036 }
        if (r0 != 0) goto L_0x0015;
    L_0x000e:
        if (r4 == 0) goto L_0x0036;
    L_0x0010:
        r3 = -1;
    L_0x0011:
        r4.a(r3);	 Catch:{ Throwable -> 0x0036 }
        goto L_0x0036;
    L_0x0015:
        r1 = new org.json.JSONArray;	 Catch:{ Throwable -> 0x0036 }
        r1.<init>();	 Catch:{ Throwable -> 0x0036 }
        r1 = r1.put(r3);	 Catch:{ Throwable -> 0x0036 }
        r0 = a(r1, r0);	 Catch:{ Throwable -> 0x0036 }
        r3 = c(r3);	 Catch:{ Throwable -> 0x0036 }
        r1 = new java.util.HashSet;	 Catch:{ Throwable -> 0x0036 }
        r1.<init>();	 Catch:{ Throwable -> 0x0036 }
        r1.add(r3);	 Catch:{ Throwable -> 0x0036 }
        r3 = 0;
        r3 = a(r2, r1, r0, r3);	 Catch:{ Throwable -> 0x0036 }
        if (r4 == 0) goto L_0x0036;
    L_0x0035:
        goto L_0x0011;
    L_0x0036:
        cn.jiguang.d.d.p.b(r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.d.d.x.a(android.content.Context, org.json.JSONObject, cn.jiguang.api.a):void");
    }

    public static boolean a(Context context, String str, JSONObject jSONObject) {
        try {
            if (i.a(str) || context == null) {
                return false;
            }
            return f.a(f.a(context, str), jSONObject != null ? jSONObject.toString() : "");
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void b(Context context) {
        try {
            i.a().b(context, "report_history", new Bundle());
        } catch (Throwable unused) {
        }
    }

    private static String c(JSONObject jSONObject) {
        return jSONObject != null ? jSONObject.optString("type") : null;
    }

    public static void c(Context context) {
        try {
            Intent intent = new Intent(context, PushReceiver.class);
            intent.setAction("cn.jpush.android.intent.ACTION_REPORT_HISTORY");
            String packageName = context.getPackageName();
            intent.addCategory(packageName);
            intent.setPackage(packageName);
            context.sendBroadcast(intent);
        } catch (Throwable unused) {
        }
    }

    public static JSONObject d(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("platform", "a");
            long c = d.c(context);
            Object obj = null;
            if (c != 0) {
                jSONObject.put(Oauth2AccessToken.KEY_UID, c);
                String b = cn.jiguang.d.a.b(context);
                if (!i.a(b)) {
                    jSONObject.put("app_key", b);
                    b.a().a(jSONObject);
                    jSONObject.put("core_sdk_ver", O0000Oo0.O00000oo);
                    b = cn.jiguang.d.a.a.g("");
                    if (i.a(b)) {
                        cn.jiguang.e.c.c("ReportUtils", "miss channel when wrap container info,but continue report...");
                    } else {
                        jSONObject.put(LogBuilder.KEY_CHANNEL, b);
                    }
                    Pair f = cn.jiguang.d.a.f(context);
                    if (i.a((String) f.first)) {
                        cn.jiguang.e.c.c("ReportUtils", "miss app version when wrap container info,but continue report...");
                    } else {
                        jSONObject.put("app_version", f.first);
                    }
                    obj = 1;
                }
            }
            if (obj != null) {
                return jSONObject;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static void e(Context context) {
        a(context, "jpush_stat_cache.json", null);
        f(context);
    }

    private static void f(Context context) {
        synchronized ("jpush_stat_cache_history.json") {
            a = null;
            if (!a(context, "jpush_stat_cache_history.json", null)) {
                f.a(f.a(context, "jpush_stat_cache_history.json"));
            }
        }
    }
}
