package cn.jiguang.a.a.c;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Pair;
import cn.jiguang.d.a.d;
import cn.jiguang.d.d.x;
import cn.jiguang.d.h.e;
import cn.jiguang.g.a;
import cn.jiguang.g.i;
import com.sina.weibo.sdk.statistic.LogBuilder;
import defpackage.O0000Oo0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b {
    private static final String a = "b";

    public static JSONObject a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            Object a = a.a();
            Object a2 = a.a(context);
            Object format = String.format(Locale.ENGLISH, "%.1f", new Object[]{Double.valueOf(a.p(context))});
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(VERSION.RELEASE);
            Object stringBuilder2 = stringBuilder.toString();
            Object format2 = String.format(Locale.ENGLISH, Build.MODEL, new Object[0]);
            Object locale = context.getResources().getConfiguration().locale.toString();
            Object b = a.b(cn.jiguang.d.a.d, "");
            Object format3 = String.format(Locale.ENGLISH, Build.MANUFACTURER, new Object[0]);
            long rawOffset = (long) (TimeZone.getDefault().getRawOffset() / 3600000);
            StringBuilder stringBuilder3 = rawOffset > 0 ? new StringBuilder("+") : rawOffset < 0 ? new StringBuilder("-") : new StringBuilder();
            stringBuilder3.append(rawOffset);
            Object stringBuilder4 = stringBuilder3.toString();
            String str = "cpu_info";
            if (i.a(a)) {
                a = "";
            }
            jSONObject.put(str, a);
            String str2 = "resolution";
            if (i.a(a2)) {
                a2 = "";
            }
            jSONObject.put(str2, a2);
            str2 = "os_version";
            if (i.a(stringBuilder2)) {
                stringBuilder2 = "";
            }
            jSONObject.put(str2, stringBuilder2);
            str2 = "language";
            if (i.a(locale)) {
                locale = "";
            }
            jSONObject.put(str2, locale);
            str2 = "timezone";
            if (i.a(stringBuilder4)) {
                stringBuilder4 = "";
            }
            jSONObject.put(str2, stringBuilder4);
            str2 = "model";
            if (i.a(format2)) {
                format2 = "";
            }
            jSONObject.put(str2, format2);
            str2 = "screensize";
            if (i.a(format)) {
                format = "";
            }
            jSONObject.put(str2, format);
            str2 = "mac";
            if (i.a(b)) {
                b = "";
            }
            jSONObject.put(str2, b);
            str2 = "manufacturer";
            if (i.a(format3)) {
                format3 = "";
            }
            jSONObject.put(str2, format3);
            ArrayList a3 = cn.jiguang.g.c.b.a(context.getApplicationContext());
            JSONArray jSONArray = new JSONArray();
            if (a3 != null) {
                Iterator it = a3.iterator();
                while (it.hasNext()) {
                    cn.jiguang.g.c.a aVar = (cn.jiguang.g.c.a) it.next();
                    if (aVar != null) {
                        JSONObject a4 = aVar.a();
                        if (a4 != null) {
                            jSONArray.put(a4);
                        }
                    }
                }
            }
            jSONObject.put("sim_slots", jSONArray);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static JSONObject a(Context context, e eVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            ArrayList a = cn.jiguang.g.c.b.a(context.getApplicationContext());
            JSONArray jSONArray = new JSONArray();
            if (a != null) {
                Iterator it = a.iterator();
                while (it.hasNext()) {
                    cn.jiguang.g.c.a aVar = (cn.jiguang.g.c.a) it.next();
                    if (aVar != null) {
                        JSONObject a2 = aVar.a();
                        if (a2 != null) {
                            jSONArray.put(a2);
                        }
                    }
                }
            }
            jSONObject.put("sim_slots", jSONArray);
            jSONObject.put("pkgname", context.getPackageName());
            jSONObject.put(LogBuilder.KEY_APPKEY, cn.jiguang.d.a.b(context));
            jSONObject.put("platform", 0);
            jSONObject.put("apkversion", eVar.a);
            jSONObject.put("systemversion", eVar.b);
            jSONObject.put("modelnumber", eVar.c);
            jSONObject.put("basebandversion", eVar.d);
            jSONObject.put("buildnumber", eVar.e);
            jSONObject.put(LogBuilder.KEY_CHANNEL, eVar.l);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("PushSDKVer", eVar.f);
            jSONObject2.put("StatisticSDKVer", eVar.g);
            jSONObject2.put("ShareSDKVer", eVar.h);
            jSONObject2.put("CoreSDKVer", eVar.i);
            jSONObject2.put("SspSDKVer", eVar.j);
            jSONObject2.put("VerificationSDKVer", eVar.k);
            jSONObject.put("sdkver", jSONObject2);
            jSONObject.put("installation", eVar.m);
            jSONObject.put("resolution", eVar.n);
            jSONObject.put("business", eVar.o);
            jSONObject.put("device_id_status", eVar.p);
            jSONObject.put("device_id", eVar.q);
            jSONObject.put("android_id", eVar.r);
            jSONObject.put("mac_address", eVar.s);
            jSONObject.put("serial_number", eVar.t);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public static void a(Context context, String str) {
        Editor edit = context.getSharedPreferences("jpush_device_info", 0).edit();
        edit.putString("device_session", str);
        edit.commit();
    }

    public static void b(Context context) {
        if (d.d(context)) {
            JSONObject a = a(context);
            if (a != null) {
                String jSONObject = a.toString();
                if (!TextUtils.isEmpty(jSONObject)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(jSONObject);
                    jSONObject = cn.jiguang.d.a.a.g("");
                    String b = cn.jiguang.d.a.b(context);
                    Pair f = cn.jiguang.d.a.f(context);
                    String str = (String) f.first;
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(f.second);
                    String stringBuilder3 = stringBuilder2.toString();
                    String str2 = O0000Oo0.O00000oo;
                    String str3 = "126";
                    String str4 = cn.jiguang.d.a.c;
                    StringBuilder stringBuilder4 = new StringBuilder();
                    stringBuilder4.append(jSONObject);
                    stringBuilder4.append(",");
                    if (TextUtils.isEmpty(b)) {
                        b = "";
                    }
                    stringBuilder4.append(b);
                    stringBuilder4.append(",");
                    if (TextUtils.isEmpty(str)) {
                        str = "";
                    }
                    stringBuilder4.append(str);
                    stringBuilder4.append(",");
                    if (TextUtils.isEmpty(stringBuilder3)) {
                        stringBuilder3 = "";
                    }
                    stringBuilder4.append(stringBuilder3);
                    stringBuilder4.append(",");
                    if (TextUtils.isEmpty(str2)) {
                        str2 = "";
                    }
                    stringBuilder4.append(str2);
                    stringBuilder4.append(",");
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "";
                    }
                    stringBuilder4.append(str3);
                    stringBuilder4.append(",");
                    if (TextUtils.isEmpty(str4)) {
                        str4 = "";
                    }
                    stringBuilder4.append(str4);
                    stringBuilder.append(stringBuilder4.toString());
                    jSONObject = i.b(stringBuilder.toString());
                    if (!(jSONObject == null || TextUtils.equals(jSONObject, context.getSharedPreferences("jpush_device_info", 0).getString("device_session", null)))) {
                        try {
                            x.a(context, a, "device_info");
                            x.a(context, a, new c(context, jSONObject));
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
        }
    }

    public static void b(Context context, e eVar) {
        cn.jiguang.d.a.a.h(context, a(context, eVar).toString());
    }
}
